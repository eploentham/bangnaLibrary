/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author root
 */
public class BEmployeeDB {
    public Config1 config1 ;
    public BEmployee employee, dbObj ;
    
    public BEmployeeDB(){
        config1 = new Config1();
        initConfig(config1);
    }
    public BEmployeeDB(Config1 cf){
        config1 = cf;
        initConfig(cf);
    }
    public void initConfig(Config1 cf){
        employee = new BEmployee();
        dbObj = new BEmployee();
        dbObj.addressLine1="";
        dbObj.addressLine2="";
        dbObj.age="";
        dbObj.bBankId="";
        dbObj.bBankNamet="";
        dbObj.bEmployeeDefaultTab="b_employee_default_tab";
        dbObj.bEmployeeId="b_employee_id";
        dbObj.bServicePointId="b_service_point_id";
        dbObj.bVisitClinicId="";
        dbObj.bookBankId="";
        dbObj.bookBankNamet="";
        dbObj.branchId="";
        dbObj.charge=0.0;
        dbObj.doctorId="";
        dbObj.employeeActive="employee_active";
        dbObj.employeeDate="";
        dbObj.employeeDepartment="";
        dbObj.employeeFirstname="employee_firstname";
        dbObj.employeeLastname="employee_lastname";
        dbObj.employeeLastLogin="employee_last_login";
        dbObj.employeeLogin="employee_login";
        dbObj.employeeNumber="employee_number";
        dbObj.employeePassword="employee_password";
        dbObj.employeePrefixId="";
        dbObj.employeeSection="";
        dbObj.employeeShortName="employee_shortname";
        dbObj.employeeStatus="employee_status";
        dbObj.fEmployeeAuthenticationId="f_employee_authentication_id";
        dbObj.fEmployeeLevelId="f_employee_level_id";
        dbObj.fEmployeeRuleId="f_employee_rule_id";
        dbObj.employeeWarningDx="employee_warning_dx";
        dbObj.formulaId="";
        dbObj.mobile="";
        dbObj.paymentStatusId="";
        dbObj.paymentStatusNamet="";
        dbObj.pid="";
        dbObj.salary=0.0;
        dbObj.salaryWarranty=0.0;
        dbObj.sex="";
        dbObj.specialistId="";
        dbObj.statusDoctor="";
        dbObj.statusEmployee="";
        dbObj.statusFormula="";
        dbObj.taxId="";
        dbObj.taxRate=0.0;
        dbObj.typeDoctorId="";
        dbObj.typeIncomeId="";
        dbObj.statusNoCloseDayImport = "status_no_close_day_import";
        dbObj.dateNoCloseDayImport = "date_no_close_day_import";
        
        dbObj.pk_field="b_employee_id";
        dbObj.table="b_employee";
    }
    public String getMaxRowBEmployee(Connection conn){
        String sql="", max="";
        try {
//            Connection conn = config1.getConnectionBangna();
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select max("+employee.getFBEmployeeId()+") as cnt From "+employee.getBEmployee();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
//            conn.close();
            if(max!=null && !max.equals("")) {
                max =  String.valueOf(Integer.parseInt(max)+1);
            }
            else {
                max = "15100001";
            }
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public BEmployee getBEmployeeByPK(String employee_id, String flag) {
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            employee = getBEmployeeByPK(st, employee_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
        return employee;
    }
    public BEmployee getBEmployeeByPK(Statement stbangna,String employee_id, String flag) {
        Connection conn;
//        BContact contact = new BContact();
//        BDepartment department = new BDepartment();
        //FoodsPeriod foodsperiod = new FoodsPeriod();
        String sql="";
        try {
            employee = new BEmployee();
//            conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();

            if(flag.equals("doctor")){
                sql="Select employee.*, bank.b_bank_namet, fps.payment_status_namet "+
                "From "+employee.getBEmployee()+" as employee "
                + "left join b_bank bank on employee.b_bank_id = bank.b_bank_id " +
                "left join f_payment_status fps on employee.payment_status_id = fps.payment_status_id " +
                "Where "+employee.getFEmployeeActive()+"='1' and employee."+employee.getFEmployeeNumber()+"='"+employee_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }else if(flag.equals("name")){
                sql="Select employee.*, bank.b_bank_namet, fps.payment_status_namet "+
                "From "+employee.getBEmployee()+" as employee left join b_bank bank on employee.b_bank_id = bank.b_bank_id " +
                "left join f_payment_status fps on employee.payment_status_id = fps.payment_status_id "+
                "Where "+employee.getFEmployeeActive()+"='1' and employee."+employee.getFEmployeeFirstname()+"='"+employee_id+"'";
            }else{
                sql="Select employee.*, bank.b_bank_namet, fps.payment_status_namet "+
                "From "+employee.getBEmployee()+" as employee left join b_bank bank on employee.b_bank_id = bank.b_bank_id " +
                "left join f_payment_status fps on employee.payment_status_id = fps.payment_status_id "+
                "Where "+employee.getFEmployeeActive()+"='1' and employee."+employee.getFBEmployeeId()+"='"+employee_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                employee.setBEmployeeDefaultTab(config1.StringNull(rs.getString(employee.getFBEmployeeDefaultTab())));
                employee.setBEmployeeId(config1.StringNull(rs.getString(employee.getFBEmployeeId())));
                employee.setBServicePointId(config1.StringNull(rs.getString(employee.getFBServicePointId())));
                employee.setEmployeeActive(config1.StringNull(rs.getString(employee.getFEmployeeActive())));
                employee.setEmployeeFirstname(config1.StringNull(rs.getString(employee.getFEmployeeFirstname())));

                employee.setEmployeeLastLogin(config1.StringNull(rs.getString(employee.getFEmployeeLastLogin())));
                employee.setEmployeeLastLogout(config1.StringNull(rs.getString(employee.getFEmployeeLastLogout())));
                employee.setEmployeeLastname(config1.StringNull(rs.getString(employee.getFEmployeeLastname())));
                employee.setEmployeeLogin(config1.StringNull(rs.getString(employee.getFEmployeeLogin())));
                employee.setEmployeeNumber(config1.StringNull(rs.getString(employee.getFEmployeeNumber())));

                employee.setEmployeePassword(config1.StringNull(rs.getString(employee.getFEmployeePassword())));
                employee.setEmployeeStatus(config1.StringNull(rs.getString(employee.getFEmployeeStatus())));
                employee.setEmployeeWarningDx(config1.StringNull(rs.getString(employee.getFEmployeeWarningDx())));
                employee.setFEmployeeAuthenticationId(config1.StringNull(rs.getString(employee.getFFEmployeeAuthenticationId())));
                employee.setFEmployeeLevelId(config1.StringNull(rs.getString(employee.getFFEmployeeLevelId())));

                employee.setFEmployeeRuleId(config1.StringNull(rs.getString(employee.getFFEmployeeRuleId())));
                employee.setSalary(Double.parseDouble(rs.getString(employee.getFSalary())));
                employee.setSalaryWarranty(Double.parseDouble(rs.getString(employee.getFSalaryWarranty())));
                employee.setCharge(Double.parseDouble(rs.getString(employee.getFCharge())));
                employee.setBBankId(config1.StringNull(rs.getString(employee.getFBBankId())));

                employee.setBBankNamet(config1.StringNull(rs.getString(employee.getFBBankNamet())));
                employee.setBookBankId(config1.StringNull(rs.getString(employee.getFBookBankId())));
                employee.setBookBankNamet(config1.StringNull(rs.getString(employee.getFBookBankNamet())));
                employee.setPaymentStatusId(config1.StringNull(rs.getString(employee.getFPaymentStatusId())));
                employee.setPaymentStatusNamet(config1.StringNull(rs.getString(employee.getFPaymentStatusNamet())));

                employee.setBranchId(config1.StringNull(rs.getString(employee.getFBranchId())));
                employee.setAddressLine1(config1.StringNull(rs.getString(employee.getFAddressLine1())));
                employee.setAddressLine2(config1.StringNull(rs.getString(employee.getFAddressLine2())));
                employee.setPid(config1.StringNull(rs.getString(employee.getFPid())));
                employee.setTaxRate(Double.parseDouble(rs.getString(employee.getFTaxRate())));
                
                employee.setFormulaId(config1.StringNull(rs.getString(employee.getFFormulaId())));
                employee.setTaxId(config1.StringNull(rs.getString(employee.getFTaxId())));
                employee.setStatusEmpoyee(config1.StringNull(rs.getString(employee.getFStatusEmployee())));
                employee.setDoctorId(config1.StringNull(rs.getString(employee.getFDoctorId())));
                employee.setTypeIncomeId(config1.StringNull(rs.getString(employee.getFTypeIncomeId())));

                employee.setEmployeeDate(config1.StringNull(rs.getString(employee.getFEmployeeDate())));
                employee.setMobile(config1.StringNull(rs.getString(employee.getFMobile())));
                employee.setStatusDoctor(config1.StringNull(rs.getString(employee.getFStatusDoctor())));
                employee.setBVisitClinicId(config1.StringNull(rs.getString(employee.getFBVisitClinicId())));
                employee.setTypeDoctorId(config1.StringNull(rs.getString(employee.getFTypeDoctorId())));

                employee.setStatusFormula(config1.StringNull(rs.getString(employee.getFStatusFormula())));
                employee.setSpecialistId(config1.StringNull(rs.getString(employee.getFSpecialistId())));
                employee.employeeShortName = rs.getString(dbObj.employeeShortName);
                employee.statusNoCloseDayImport = config1.StringNull(rs.getString(dbObj.getFStatusNoCloseDayImport()));
                employee.dateNoCloseDayImport = config1.StringNull(rs.getString(dbObj.getFDateNoCloseDayImport()));

                }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }
    public Vector getBEmployee(String employee_id, String flag) {
        Connection conn;
        Vector v_employee = new Vector();
        String sql="", empSearch="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            if(flag.equals("doctor")){
                if(!employee_id.equals("")){
                    empSearch = " and ("+employee.getFEmployeeFirstname()+" like '%"+employee_id+"%' or "
                        + employee.getFEmployeeNumber()+" like '%"+employee_id+"%') ";
                }
                sql="Select employee.*, bank.b_bank_namet, fps.payment_status_namet "+
                "From "+employee.getBEmployee()+" as employee left join b_bank bank on employee.b_bank_id = bank.b_bank_id " +
                "left join f_payment_status fps on employee.payment_status_id = fps.payment_status_id "+
                "Where "+employee.getFEmployeeActive()+"='1' "+empSearch+
                "Order By "+employee.getFEmployeeFirstname()+" asc";
            }else if(flag.equals("doctor_autosearch")){
                if(!employee_id.equals("")){
                    empSearch = " and ("+employee.getFEmployeeFirstname()+" like '"+employee_id+"%' or "
                            + employee.getFEmployeeNumber()+" like '"+employee_id+"%') ";
                }
                sql="Select employee.*, bank.b_bank_namet, fps.payment_status_namet "+
                "From "+employee.getBEmployee()+" as employee left join b_bank bank on employee.b_bank_id = bank.b_bank_id " +
                "left join f_payment_status fps on employee.payment_status_id = fps.payment_status_id "+
                "Where "+employee.getFEmployeeActive()+"='1' "+empSearch+
                "Order By "+employee.getFEmployeeNumber()+" asc";
            }else if(flag.equals("status_no_close_day_import")){
                sql="Select employee.*, bank.b_bank_namet, fps.payment_status_namet "+
                    "From "+employee.getBEmployee()+" as employee left join b_bank bank on employee.b_bank_id = bank.b_bank_id " +
                    "left join f_payment_status fps on employee.payment_status_id = fps.payment_status_id "+
                    "Where "+employee.getFEmployeeActive()+"='1' and "+employee.getFStatusNoCloseDayImport()+"='2' "+
                    "Order By "+employee.getFEmployeeFirstname()+" asc";
            }else if(flag.equals("search_staff_attend")){
                sql="Select * "
                +"From "+employee.getBEmployee()+" "
                +"Where "+employee.getFEmployeeFirstname()+" like '"+employee_id+"'% and "+employee.getFEmployeeActive()+" = '1' "
                +"Order By "+employee.getFEmployeeFirstname()+" desc";
            }else{
                sql="Select * "
                +"From "+employee.getBEmployee()+" "
                +"Where "+employee.getFBEmployeeId()+"='"+employee_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                employee = new BEmployee();
                employee.setBEmployeeDefaultTab(config1.StringNull(rs.getString(employee.getFBEmployeeDefaultTab())));
                employee.setBEmployeeId(config1.StringNull(rs.getString(employee.getFBEmployeeId())));
                employee.setBServicePointId(config1.StringNull(rs.getString(employee.getFBServicePointId())));
                employee.setEmployeeActive(config1.StringNull(rs.getString(employee.getFEmployeeActive())));
                employee.setEmployeeFirstname(config1.StringNull(rs.getString(employee.getFEmployeeFirstname())));

                employee.setEmployeeLastLogin(config1.StringNull(rs.getString(employee.getFEmployeeLastLogin())));
                employee.setEmployeeLastLogout(config1.StringNull(rs.getString(employee.getFEmployeeLastLogout())));
                employee.setEmployeeLastname(config1.StringNull(rs.getString(employee.getFEmployeeLastname())));
                employee.setEmployeeLogin(config1.StringNull(rs.getString(employee.getFEmployeeLogin())));
                employee.setEmployeeNumber(config1.StringNull(rs.getString(employee.getFEmployeeNumber())));

                employee.setEmployeePassword(config1.StringNull(rs.getString(employee.getFEmployeePassword())));
                employee.setEmployeeStatus(config1.StringNull(rs.getString(employee.getFEmployeeStatus())));
                employee.setEmployeeWarningDx(config1.StringNull(rs.getString(employee.getFEmployeeWarningDx())));
                employee.setFEmployeeAuthenticationId(config1.StringNull(rs.getString(employee.getFFEmployeeAuthenticationId())));
                employee.setFEmployeeLevelId(config1.StringNull(rs.getString(employee.getFFEmployeeLevelId())));

                employee.setFEmployeeRuleId(config1.StringNull(rs.getString(employee.getFFEmployeeRuleId())));
                employee.setSalary(Double.parseDouble(rs.getString(employee.getFSalary())));
                employee.setSalaryWarranty(Double.parseDouble(rs.getString(employee.getFSalaryWarranty())));
                employee.setCharge(Double.parseDouble(rs.getString(employee.getFCharge())));
                employee.setBBankId(config1.StringNull(rs.getString(employee.getFBBankId())));

                employee.setBBankNamet(config1.StringNull(rs.getString(employee.getFBBankNamet())));
                employee.setBookBankId(config1.StringNull(rs.getString(employee.getFBookBankId())));
                employee.setBookBankNamet(config1.StringNull(rs.getString(employee.getFBookBankNamet())));
                employee.setPaymentStatusId(config1.StringNull(rs.getString(employee.getFPaymentStatusId())));
                employee.setPaymentStatusNamet(config1.StringNull(rs.getString(employee.getFPaymentStatusNamet())));

                employee.setBranchId(config1.StringNull(rs.getString(employee.getFBranchId())));
                employee.setAddressLine1(config1.StringNull(rs.getString(employee.getFAddressLine1())));
                employee.setAddressLine2(config1.StringNull(rs.getString(employee.getFAddressLine2())));
                employee.setPid(config1.StringNull(rs.getString(employee.getFPid())));
                employee.setTaxRate(Double.parseDouble(rs.getString(employee.getFTaxRate())));

                employee.setFormulaId(config1.StringNull(rs.getString(employee.getFFormulaId())));
                employee.setTaxId(config1.StringNull(rs.getString(employee.getFTaxId())));
                employee.setStatusEmpoyee(config1.StringNull(rs.getString(employee.getFStatusEmployee())));
                employee.setDoctorId(config1.StringNull(rs.getString(employee.getFDoctorId())));
                employee.setTypeIncomeId(config1.StringNull(rs.getString(employee.getFTypeIncomeId())));

                employee.setEmployeeDate(config1.StringNull(rs.getString(employee.getFEmployeeDate())));
                employee.setMobile(config1.StringNull(rs.getString(employee.getFMobile())));
                employee.setStatusDoctor(config1.StringNull(rs.getString(employee.getFStatusDoctor())));
                employee.setBVisitClinicId(config1.StringNull(rs.getString(employee.getFBVisitClinicId())));
                employee.setTypeDoctorId(config1.StringNull(rs.getString(employee.getFTypeDoctorId())));

                employee.setStatusFormula(config1.StringNull(rs.getString(employee.getFStatusFormula())));
                employee.setSpecialistId(config1.StringNull(rs.getString(employee.getFSpecialistId())));
                employee.statusNoCloseDayImport = config1.StringNull(rs.getString(dbObj.getFStatusNoCloseDayImport()));
                employee.dateNoCloseDayImport = config1.StringNull(rs.getString(dbObj.getFDateNoCloseDayImport()));

                v_employee.add(employee);
                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_employee;
    }
    public List getBEmployeeL(String employee_id, String flag) {
        Connection conn;
        List<BEmployee> lEmployee = new ArrayList<BEmployee>();
        String sql="", empSearch="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            if(flag.equals("doctor")){
                if(!employee_id.equals("")){
                    empSearch = " and ("+employee.getFEmployeeFirstname()+" like '%"+employee_id+"%' or "
                        + employee.getFEmployeeNumber()+" like '%"+employee_id+"%') ";
                }
                sql="Select employee.*, bank.b_bank_namet, fps.payment_status_namet "+
                "From "+employee.getBEmployee()+" as employee left join b_bank bank on employee.b_bank_id = bank.b_bank_id " +
                "left join f_payment_status fps on employee.payment_status_id = fps.payment_status_id "+
                "Where "+employee.getFEmployeeActive()+"='1' "+empSearch+
                "Order By "+employee.getFEmployeeFirstname()+" asc";
            }else if(flag.equals("doctor_autosearch")){
                if(!employee_id.equals("")){
                    empSearch = " and ("+employee.getFEmployeeFirstname()+" like '"+employee_id+"%' or "
                            + employee.getFEmployeeNumber()+" like '"+employee_id+"%') ";
                }
                sql="Select employee.*, bank.b_bank_namet, fps.payment_status_namet "+
                "From "+employee.getBEmployee()+" as employee left join b_bank bank on employee.b_bank_id = bank.b_bank_id " +
                "left join f_payment_status fps on employee.payment_status_id = fps.payment_status_id "+
                "Where "+employee.getFEmployeeActive()+"='1' "+empSearch+
                "Order By "+employee.getFEmployeeNumber()+" asc";
            }else if(flag.equals("status_no_close_day_import")){
                sql="Select employee.*, bank.b_bank_namet, fps.payment_status_namet "+
                    "From "+employee.getBEmployee()+" as employee left join b_bank bank on employee.b_bank_id = bank.b_bank_id " +
                    "left join f_payment_status fps on employee.payment_status_id = fps.payment_status_id "+
                    "Where "+employee.getFEmployeeActive()+"='1' and "+employee.getFStatusNoCloseDayImport()+"='2' "+
                    "Order By "+employee.getFEmployeeFirstname()+" asc";
            }else if(flag.equals("search_staff_attend")){
                sql="Select employee.*, bank.b_bank_namet, fps.payment_status_namet "
                +"From "+employee.getBEmployee()+" as employee left join b_bank bank on employee.b_bank_id = bank.b_bank_id " 
                +"left join f_payment_status fps on employee.payment_status_id = fps.payment_status_id "
                +"Where "+employee.getFEmployeeFirstname()+" like '"+employee_id+"%' and "+employee.getFEmployeeActive()+" = '1' "
                +"Order By "+employee.getFEmployeeFirstname()+" desc";
            }else{
                sql="Select * "
                +"From "+employee.getBEmployee()+" "
                +"Where "+employee.getFBEmployeeId()+"='"+employee_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                employee = new BEmployee();
                employee.setBEmployeeDefaultTab(config1.StringNull(rs.getString(employee.getFBEmployeeDefaultTab())));
                employee.setBEmployeeId(config1.StringNull(rs.getString(employee.getFBEmployeeId())));
                employee.setBServicePointId(config1.StringNull(rs.getString(employee.getFBServicePointId())));
                employee.setEmployeeActive(config1.StringNull(rs.getString(employee.getFEmployeeActive())));
                employee.setEmployeeFirstname(config1.StringNull(rs.getString(employee.getFEmployeeFirstname())));

                employee.setEmployeeLastLogin(config1.StringNull(rs.getString(employee.getFEmployeeLastLogin())));
                employee.setEmployeeLastLogout(config1.StringNull(rs.getString(employee.getFEmployeeLastLogout())));
                employee.setEmployeeLastname(config1.StringNull(rs.getString(employee.getFEmployeeLastname())));
                employee.setEmployeeLogin(config1.StringNull(rs.getString(employee.getFEmployeeLogin())));
                employee.setEmployeeNumber(config1.StringNull(rs.getString(employee.getFEmployeeNumber())));

                employee.setEmployeePassword(config1.StringNull(rs.getString(employee.getFEmployeePassword())));
                employee.setEmployeeStatus(config1.StringNull(rs.getString(employee.getFEmployeeStatus())));
                employee.setEmployeeWarningDx(config1.StringNull(rs.getString(employee.getFEmployeeWarningDx())));
                employee.setFEmployeeAuthenticationId(config1.StringNull(rs.getString(employee.getFFEmployeeAuthenticationId())));
                employee.setFEmployeeLevelId(config1.StringNull(rs.getString(employee.getFFEmployeeLevelId())));

                employee.setFEmployeeRuleId(config1.StringNull(rs.getString(employee.getFFEmployeeRuleId())));
                employee.setSalary(Double.parseDouble(rs.getString(employee.getFSalary())));
                employee.setSalaryWarranty(Double.parseDouble(rs.getString(employee.getFSalaryWarranty())));
                employee.setCharge(Double.parseDouble(rs.getString(employee.getFCharge())));
                employee.setBBankId(config1.StringNull(rs.getString(employee.getFBBankId())));

                employee.setBBankNamet(config1.StringNull(rs.getString(employee.getFBBankNamet())));
                employee.setBookBankId(config1.StringNull(rs.getString(employee.getFBookBankId())));
                employee.setBookBankNamet(config1.StringNull(rs.getString(employee.getFBookBankNamet())));
                employee.setPaymentStatusId(config1.StringNull(rs.getString(employee.getFPaymentStatusId())));
                employee.setPaymentStatusNamet(config1.StringNull(rs.getString(employee.getFPaymentStatusNamet())));

                employee.setBranchId(config1.StringNull(rs.getString(employee.getFBranchId())));
                employee.setAddressLine1(config1.StringNull(rs.getString(employee.getFAddressLine1())));
                employee.setAddressLine2(config1.StringNull(rs.getString(employee.getFAddressLine2())));
                employee.setPid(config1.StringNull(rs.getString(employee.getFPid())));
                employee.setTaxRate(Double.parseDouble(rs.getString(employee.getFTaxRate())));

                employee.setFormulaId(config1.StringNull(rs.getString(employee.getFFormulaId())));
                employee.setTaxId(config1.StringNull(rs.getString(employee.getFTaxId())));
                employee.setStatusEmpoyee(config1.StringNull(rs.getString(employee.getFStatusEmployee())));
                employee.setDoctorId(config1.StringNull(rs.getString(employee.getFDoctorId())));
                employee.setTypeIncomeId(config1.StringNull(rs.getString(employee.getFTypeIncomeId())));

                employee.setEmployeeDate(config1.StringNull(rs.getString(employee.getFEmployeeDate())));
                employee.setMobile(config1.StringNull(rs.getString(employee.getFMobile())));
                employee.setStatusDoctor(config1.StringNull(rs.getString(employee.getFStatusDoctor())));
                employee.setBVisitClinicId(config1.StringNull(rs.getString(employee.getFBVisitClinicId())));
                employee.setTypeDoctorId(config1.StringNull(rs.getString(employee.getFTypeDoctorId())));

                employee.setStatusFormula(config1.StringNull(rs.getString(employee.getFStatusFormula())));
                employee.setSpecialistId(config1.StringNull(rs.getString(employee.getFSpecialistId())));
                employee.statusNoCloseDayImport = config1.StringNull(rs.getString(dbObj.getFStatusNoCloseDayImport()));
                employee.dateNoCloseDayImport = config1.StringNull(rs.getString(dbObj.getFDateNoCloseDayImport()));

                lEmployee.add(employee);
                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lEmployee;
    }
    public String setSaveBEmployee(BEmployee item, String flagpage) throws Exception {
        int chk=0;
        String sql="", ma_date="", attend_date="", max="";
//        BContact contact = new BContact();
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            employee = getBEmployeeByPK(item.getBEmployeeId(),"");
            item.setEmployeeFirstname(item.getEmployeeFirstname().replace("'", "''"));
            item.setEmployeeLastname(item.getEmployeeLastname().replace("'", "''"));
            item.setAddressLine1(item.getAddressLine1().replace("'", "''"));
            item.setAddressLine2(item.getAddressLine2().replace("'", "''"));
            item.employeeShortName = item.employeeShortName.replace("'", "''");
//            item.setWarranty(item.getWarranty().replace("'", "''"));
            if (employee.getBEmployeeId().equals("")) {
                max = getMaxRowBEmployee(conn);
                sql="Insert Into "+employee.getBEmployee()+"("
                        +employee.getFBEmployeeId()+", "+employee.getFBEmployeeDefaultTab()+", "
                        +employee.getFBServicePointId()+","+ employee.getFEmployeeActive()+","
                        +employee.getFEmployeeFirstname()+","+ employee.getFEmployeeLastLogin()+","
                        +employee.getFEmployeeLastLogout()+","+ employee.getFEmployeeLastname()+","
                        +employee.getFFEmployeeLevelId()+","+ employee.getFEmployeeLogin()+","
                        +employee.getFEmployeeNumber()+","+ employee.getFEmployeePassword()+","+
                        employee.getFFEmployeeRuleId()+","+ employee.getFEmployeeStatus()+", "+
                        employee.getFEmployeeWarningDx()+","+ employee.getFFEmployeeAuthenticationId()+", "+
                        employee.getFSalary()+","+ employee.getFSalaryWarranty()+"," +
                        employee.getFBBankId()+","+employee.getFBookBankId()+"," +
                        employee.getFBookBankNamet()+","+employee.getFPaymentStatusId()+"," +
                        employee.getFCharge()+","+employee.getFBranchId()+"," +
                        employee.getFAddressLine1()+","+employee.getFAddressLine2()+"," +
                        employee.getFPid()+","+employee.getFTaxRate()+","
                        + employee.getFFormulaId()+","+employee.getFTaxId()+","
                        + employee.getFStatusEmployee()+","+employee.getFDoctorId()+","
                        + employee.getFTypeIncomeId()+","+employee.getFEmployeeDate()+","
                        +employee.getFMobile()+","+employee.getFStatusDoctor()+","
                        +employee.getFBVisitClinicId()+","+employee.getFTypeDoctorId()+","
                        + employee.getFStatusFormula()+","+employee.getFSpecialistId()+", "
                        +dbObj.employeeShortName+","+dbObj.statusNoCloseDayImport+", "
                        +dbObj.dateNoCloseDayImport+")"
                        +"Values('"+max+"','"+item.getBEmployeeDefaultTab()+"','"+
                        item.getBServicePointId() + "','"+ item.getEmployeeActive()+"','"+
                        item.getEmployeeFirstname() + "','"+ item.getEmployeeLastLogin()+"','"+
                        item.getEmployeeLastLogout() + "','"+ item.getEmployeeLastname()+"','"+
                        item.getFEmployeeLevelId() + "','"+ item.getEmployeeLogin()+"','"+
                        item.getEmployeeNumber() + "','"+ item.getEmployeePassword()+"','"+
                        item.getFEmployeeRuleId() + "','"+ item.getEmployeeStatus()+"','"
                        +item.getEmployeeWarningDx() + "','"+ item.getFEmployeeAuthenticationId()+"','"
                        +item.getSalary() + "','"+ item.getSalaryWarranty()+"','" +
                        item.getBBankId()+"','"+item.getBookBankId()+"','" +
                        item.getBookBankNamet()+"','"+item.getPaymentStatusId()+"'," +
                        item.getCharge()+",'"+item.getBranchId()+"','" +
                        item.getAddressLine1()+"','"+item.getAddressLine2()+"','" +
                        item.getPid()+"',"+item.getTaxRate()+",'"
                        + item.getFormulaId()+"','"+item.getTaxId()+"','"
                        + item.getStatusEmpoyee()+"','"+item.getDoctorId()+"','"
                        + item.getTypeIncomeId()+"','"+item.getEmployeeDate()+"','"
                        + item.getMobile()+"','"+item.getStatusDoctor()+"','"
                        + item.getBVisitClinicId()+"','"+item.getTypeDoctorId()+"','"
                        + item.getStatusFormula()+"','"+item.getSpecialistId()+"','"
                        + item.employeeShortName+"','"+item.statusNoCloseDayImport+"','"
                        +item.dateNoCloseDayImport+"')";
            } else {
//                attend_date=config1.DateFormatShow2DB(itemdetail.getAttendDate(), "ddMMyyyy");
//                wound_care_date=config1.DateFormatShow2DB(itemdetail.getMaDate(), "ddMMyyyy");
                sql = "Update "+employee.getBEmployee()+" set "+
                employee.getFBEmployeeDefaultTab()+" = '"+item.getBEmployeeDefaultTab()+"', "+
                employee.getFBServicePointId()+" = '"+item.getBServicePointId()+"', "+
                employee.getFEmployeeActive()+" = '"+item.getEmployeeActive()+"', "+
                employee.getFEmployeeFirstname()+" = '"+item.getEmployeeFirstname()+"', "+
                employee.getFEmployeeLastLogin()+" = '"+item.getEmployeeLastLogin()+"', "+
                employee.getFEmployeeLastLogout()+" = '"+item.getEmployeeLastLogout()+"', "+
                employee.getFEmployeeLastname()+" = '"+item.getEmployeeLastname()+"', "+
                employee.getFFEmployeeLevelId()+" = '"+item.getFEmployeeLevelId()+"', "+
                employee.getFEmployeeLogin()+" = '"+item.getEmployeeLogin()+"', "+
                employee.getFEmployeeNumber()+" = '"+item.getEmployeeNumber()+"', "+
                employee.getFEmployeePassword()+" = '"+item.getEmployeePassword()+"', "+
                employee.getFFEmployeeRuleId()+" = '"+item.getFEmployeeRuleId()+"', "+
                employee.getFEmployeeStatus()+" = '"+item.getEmployeeStatus()+"', "+
                employee.getFEmployeeWarningDx()+" = '"+item.getEmployeeWarningDx()+"', "+
                employee.getFFEmployeeAuthenticationId()+" = '"+item.getFEmployeeAuthenticationId()+"', "+
                employee.getFSalary()+" = '"+item.getSalary()+"', "+
                employee.getFSalaryWarranty()+" = '"+item.getSalaryWarranty()+"', "+
                employee.getFBBankId()+" = '"+item.getBBankId()+"', "+
                employee.getFBookBankId()+" = '"+item.getBookBankId()+"', "+
                employee.getFBookBankNamet()+" = '"+item.getBookBankNamet()+"', "+
                employee.getFPaymentStatusId()+" = '"+item.getPaymentStatusId()+"', "+
                employee.getFCharge()+" = "+item.getCharge()+", "+
                employee.getFBranchId()+" = '"+item.getBranchId()+"', "+
                employee.getFAddressLine1()+" = '"+item.getAddressLine1()+"', "+
                employee.getFAddressLine2()+" = '"+item.getAddressLine2()+"', "+
                employee.getFPid()+" = '"+item.getPid()+"', "+
                employee.getFTaxRate()+" = "+item.getTaxRate()+", "+
                        employee.getFFormulaId()+" = '"+item.getFormulaId()+"', "+
                        employee.getFTaxId()+" = '"+item.getTaxId()+"', "+
                        employee.getFStatusEmployee()+" = '"+item.getStatusEmpoyee()+"', "+
                        employee.getFDoctorId()+" = '"+item.getDoctorId()+"', "+
                        employee.getFTypeIncomeId()+" = '"+item.getTypeIncomeId()+"', "+
                        employee.getFEmployeeDate()+" = '"+item.getEmployeeDate()+"', "+
                        employee.getFMobile()+" = '"+item.getMobile()+"', "+
                        employee.getFStatusDoctor()+" = '"+item.getStatusDoctor()+"', "+
                        employee.getFBVisitClinicId()+" = '"+item.getBVisitClinicId()+"', "+
                        employee.getFTypeDoctorId()+" = '"+item.getTypeDoctorId()+"', "+
                        employee.getFStatusFormula()+" = '"+item.getStatusFormula()+"', "+
                        employee.getFSpecialistId()+" = '"+item.getSpecialistId()+"', "+
                        dbObj.employeeShortName+" = '"+item.employeeShortName+"', "+
                        dbObj.statusNoCloseDayImport+" = '"+item.statusNoCloseDayImport+"', "+
                        dbObj.dateNoCloseDayImport+" = '"+item.dateNoCloseDayImport+"' "+
                "Where "+employee.getFBEmployeeId()+" = '"+item.getBEmployeeId()+"' ";
                max = item.getBEmployeeId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
}
