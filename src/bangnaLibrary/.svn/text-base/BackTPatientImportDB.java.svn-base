/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import com.bangna.usecase.connection.ConnectionDBMgr;
import com.bangna.usecase.connection.ConnectionInf;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class BackTPatientImportDB {
    public BackTPatientImport bpi, dbObj;
    public Config1 config1 ;
    public ConnectionInf theConnectionInf;
//    public  BackTPatientVisitDB1 bpvdb1;
    public BackTPatientImportDB(){
        config1 = new Config1();
        initConfig(config1);
//        bpvdb1 = new BackTPatientVisitDB1(config1);
    }
    public BackTPatientImportDB(Config1 cf){
        config1 = cf;
        initConfig(cf);
//        bpvdb1 = new BackTPatientVisitDB1(cf);
    }
    public void initConfig(Config1 cf){
        bpi = new BackTPatientImport();
        dbObj = new BackTPatientImport();
        theConnectionInf = new ConnectionDBMgr(config1.host,config1.database, config1.userDB,config1.passDB);
//        bpi.contactTimeFinish="contact_time_finish";
        dbObj.contactTimeMake="contact_time_make";
        dbObj.doctorTimeFinish="doctor_time_finish";
        dbObj.contactTimeFinish="contact_time_finish";
        dbObj.doctorTimeMake="doctor_time_make";
        dbObj.fundsTimeFinish="funds_time_finish";
        dbObj.fundsTimeMake="funds_time_make";
        dbObj.timeFinish="time_finish";
        dbObj.timeMake="time_make";
        dbObj.table="back_t_patient_import";
        dbObj.pk_field="patient_import_id";
    }
    public String getMaxRowBackTPatientImport(Connection conn){
        String sql="", max="";
        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select max("+bpi.getFPatientImportId()+") as cnt From "+bpi.getBackTPatientImport();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if(max!=null && !max.equals("")) {
                max =  String.valueOf(Integer.parseInt(max)+1);
            }else{
                max = "1420000001";
            }
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientImportDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public BackTPatientImport getBackTPatientImportByPK(String patient_import_id, String flag) {
        Connection conn;
        String sql="";
        try {
//            bpi.initial();
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            if(flag.equals("patient_import_id")){
                sql="Select * "
                +"From "+bpi.getBackTPatientImport()+" "
                +"Where "+bpi.getFPatientImportId()+"='"+patient_import_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }else{
                sql="Select * "
                +"From "+bpi.getBackTPatientImport()+" "
                +"Where "+bpi.getFDateStart()+"='"+patient_import_id+"' and "+bpi.getFPatientImportActive()+"='1' ";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                bpi = new BackTPatientImport();
                bpi.setBranchId(config1.StringNull(rs.getString(bpi.getFBranchId())));
                bpi.setCntPatientVisit(Double.parseDouble(rs.getString(bpi.getFCntPatientVisit())));
                bpi.setCntPatientVisitVn(Double.parseDouble(rs.getString(bpi.getFCntPatientVisitVn())));
                bpi.setDateEnd(config1.StringNull(rs.getString(bpi.getFDateEnd())));
                bpi.setDateStart(config1.StringNull(rs.getString(bpi.getFDateStart())));

                bpi.setDescription(config1.StringNull(rs.getString(bpi.getFDescription())));
                bpi.setPatientImportDate(config1.StringNull(rs.getString(bpi.getFPatientImportDate())));
                bpi.setPatientImportId(config1.StringNull(rs.getString(bpi.getFPatientImportId())));
                bpi.setPatientImportMonth(config1.StringNull(rs.getString(bpi.getFPatientImportMonth())));
                bpi.setPatientImportYear(config1.StringNull(rs.getString(bpi.getFPatientImportYear())));

                bpi.setRemark(config1.StringNull(rs.getString(bpi.getFRemark())));
                bpi.setPatientVisitId(config1.StringNull(rs.getString(bpi.getFPatientVisitId())));
                bpi.setCntPatientVisitContact(Double.parseDouble(rs.getString(bpi.getFCntPatientVisitContact())));
                bpi.setCntPatientVisitFunds(Double.parseDouble(rs.getString(bpi.getFCntPatientVisitFunds())));
                bpi.setCntPatientVisitDoctor(Double.parseDouble(rs.getString(bpi.getFCntPatientVisitDoctor())));

                bpi.setAmountPatientVisitContact(Double.parseDouble(rs.getString(bpi.getFAmountPatientVisitContact())));
                bpi.setAmountPatientVisitFunds(Double.parseDouble(rs.getString(bpi.getFAmountPatientVisitFunds())));
                bpi.setAmountPatientVisitDoctor(Double.parseDouble(rs.getString(bpi.getFAmountPatientVisitDoctor())));
                bpi.setPatientImportActive(config1.StringNull(rs.getString(bpi.getFPatientImportActive())));
                bpi.setSysStatusContact(config1.StringNull(rs.getString(bpi.getFSysStatusContact())));

                bpi.setAmountPatientVisit(Double.parseDouble(rs.getString(bpi.getFAmountPatientVisit())));
                bpi.setSysStatusFunds(config1.StringNull(rs.getString(bpi.getFSysStatusFunds())));
                bpi.setSysStatusDoctor(config1.StringNull(rs.getString(bpi.getFSysStatusDoctor())));
                bpi.setCntContactReceive(Double.parseDouble(rs.getString(bpi.getFCntContactReceive())));
                bpi.setCntFundsReceive(Double.parseDouble(rs.getString(bpi.getFCntFundsReceive())));

                bpi.setCntDoctorReceive(Double.parseDouble(rs.getString(bpi.getFCntDoctorReceive())));
                bpi.setStatusContactReceive(config1.StringNull(rs.getString(bpi.getFStatusContactReceive())));
                bpi.setStutasDoctorReceive(config1.StringNull(rs.getString(bpi.getFStatusDoctorReceive())));
                bpi.setStutasFundsReceive(config1.StringNull(rs.getString(bpi.getFStatusFundsReceive())));
                bpi.amountCloseDay = Double.parseDouble(rs.getString(bpi.getFAmountCloseDay()));

                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientImportDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpi;
    }
    public Vector getBackTPatientImport(String branch_id, String year, String month, String flagpage, String sub_system) {
        Connection conn;
        String sql="", status="";
        Vector v_patient_import = new Vector();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();

            if(flagpage.equals("viewmonth")) {
                if(sub_system.equals("contact")){

                }else if(sub_system.equals("funds")){

                }else if(sub_system.equals("doctor")){

                }
                sql="Select * "+
                "From "+bpi.getBackTPatientImport()+" "+
                "Where "+bpi.getFBranchId()+"='"+branch_id+"' and "+
                bpi.getFPatientImportYear()+" ='"+year+"' and "+
                bpi.getFPatientImportMonth()+"='"+month+"' and "+
                bpi.getFPatientImportActive()+" <> '3' " +
                "Order By "+bpi.getFDateStart()+" desc";
            }else if(flagpage.equals("transfer")) {
                sql="Select * "+
                "From "+bpi.getBackTPatientImport()+" "+
                "Where "+bpi.getFBranchId()+"='"+branch_id+"' and "+bpi.getFSysStatusContact()+" = 'A' and "+
                        bpi.getFPatientImportActive()+" <> '3' "+
                "Order By "+bpi.getFPatientImportId()+" asc";
            }else if(flagpage.equals("view_status_d")||flagpage.equals("view_status_y")) {
                if(flagpage.length()>1){
                    status = flagpage.substring(flagpage.length()-1).toUpperCase();
                }
                if(sub_system.equals("contact")){
                    if(month.equals("")){
                        sql="Select * "+
                "From "+bpi.getBackTPatientImport()+" "+
                "Where "+bpi.getFBranchId()+"='"+branch_id+"' and "+bpi.getFSysStatusContact()+" = '"+status+"' and "+
                        bpi.getFPatientImportActive()+" <> '3' "+
                "Order By "+bpi.getFPatientImportId()+" asc";
                    }else{
                        sql="Select * "+
                "From "+bpi.getBackTPatientImport()+" "+
                "Where "+bpi.getFBranchId()+"='"+branch_id+"' and "+bpi.getFSysStatusContact()+" = '"+status+"' and "+
bpi.getFPatientImportActive()+" <> '3' and "+bpi.getFPatientImportMonth()+" ='"+month +"' and "+bpi.getFPatientImportYear()+"='"+year+"' "+
                "Order By "+bpi.getFPatientImportId()+" asc";
                    }
                }else if(sub_system.equals("funds")){
                    if(month.equals("")){
                        sql="Select * "+
                "From "+bpi.getBackTPatientImport()+" "+
                "Where "+bpi.getFBranchId()+"='"+branch_id+"' and "+bpi.getFSysStatusFunds()+" = '"+status+"' and "+
                        bpi.getFPatientImportActive()+" <> '3' "+
                "Order By "+bpi.getFPatientImportId()+" asc";
                    }else{
                        sql="Select * "+
                "From "+bpi.getBackTPatientImport()+" "+
                "Where "+bpi.getFBranchId()+"='"+branch_id+"' and "+bpi.getFSysStatusFunds()+" = '"+status+"' and "+
bpi.getFPatientImportActive()+" <> '3' and "+bpi.getFPatientImportMonth()+" ='"+month +"' and "+bpi.getFPatientImportYear()+"='"+year+"' and "+
                        bpi.getFPatientImportActive()+" <> '3' "+
                "Order By "+bpi.getFPatientImportId()+" asc";
                    }

                }else if(sub_system.equals("doctor")){
                    if(month.equals("")){
                        sql="Select * "+
                "From "+bpi.getBackTPatientImport()+" "+
                "Where "+bpi.getFBranchId()+"='"+branch_id+"' and "+bpi.getFSysStatusDoctor()+" = '"+status+"' and "+
                        bpi.getFPatientImportActive()+" <> '3' "+
                "Order By "+bpi.getFPatientImportId()+" asc";
                    }else{
                        sql="Select * "+
                "From "+bpi.getBackTPatientImport()+" "+
                "Where "+bpi.getFBranchId()+"='"+branch_id+"' and "+bpi.getFSysStatusDoctor()+" = '"+status+"' and "+
bpi.getFPatientImportActive()+" <> '3' and "+bpi.getFPatientImportMonth()+" ='"+month +"' and "+bpi.getFPatientImportYear()+"='"+year+"' "+
                "Order By "+bpi.getFPatientImportId()+" asc";
                    }

                }
            }else if(flagpage.equals("period_date")) {
                sql="Select * "+
                "From "+bpi.getBackTPatientImport()+" "+
                "Where "+bpi.getFBranchId()+"='"+branch_id+"' and "+bpi.getFDateStart()+" >= '"+year+"' and "+
                bpi.getFDateEnd()+" <= '"+month+"' and "+bpi.getFPatientImportActive()+" <> '3' "+
                "Order By "+bpi.getFPatientImportId()+" asc";
            }else{
                sql="Select * "+
                "From "+bpi.getBackTPatientImport()+" "+
                "Where "+bpi.getFBranchId()+"='"+branch_id+"' and "+
                        bpi.getFPatientImportActive()+" <> '3' "+
                "Order By "+bpi.getFPatientImportId()+" asc";
            }
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                bpi = new BackTPatientImport();
                bpi.setBranchId(config1.StringNull(rs.getString(bpi.getFBranchId())));
                bpi.setCntPatientVisit(Double.parseDouble(rs.getString(bpi.getFCntPatientVisit())));
                bpi.setCntPatientVisitVn(Double.parseDouble(rs.getString(bpi.getFCntPatientVisitVn())));
                bpi.setDateEnd(config1.StringNull(rs.getString(bpi.getFDateEnd())));
                bpi.setDateStart(config1.StringNull(rs.getString(bpi.getFDateStart())));

                bpi.setDescription(config1.StringNull(rs.getString(bpi.getFDescription())));
                bpi.setPatientImportDate(config1.StringNull(rs.getString(bpi.getFPatientImportDate())));
                bpi.setPatientImportId(config1.StringNull(rs.getString(bpi.getFPatientImportId())));
                bpi.setPatientImportMonth(config1.StringNull(rs.getString(bpi.getFPatientImportMonth())));
                bpi.setPatientImportYear(config1.StringNull(rs.getString(bpi.getFPatientImportYear())));

                bpi.setRemark(config1.StringNull(rs.getString(bpi.getFRemark())));
                bpi.setPatientVisitId(config1.StringNull(rs.getString(bpi.getFPatientVisitId())));
                bpi.setCntPatientVisitContact(Double.parseDouble(rs.getString(bpi.getFCntPatientVisitContact())));
                bpi.setCntPatientVisitFunds(Double.parseDouble(rs.getString(bpi.getFCntPatientVisitFunds())));
                bpi.setCntPatientVisitDoctor(Double.parseDouble(rs.getString(bpi.getFCntPatientVisitDoctor())));

                bpi.setAmountPatientVisitContact(Double.parseDouble(rs.getString(bpi.getFAmountPatientVisitContact())));
                bpi.setAmountPatientVisitFunds(Double.parseDouble(rs.getString(bpi.getFAmountPatientVisitFunds())));
                bpi.setAmountPatientVisitDoctor(Double.parseDouble(rs.getString(bpi.getFAmountPatientVisitDoctor())));
                bpi.setPatientImportActive(config1.StringNull(rs.getString(bpi.getFPatientImportActive())));
                bpi.setSysStatusContact(config1.StringNull(rs.getString(bpi.getFSysStatusContact())));

                bpi.setAmountPatientVisit(Double.parseDouble(rs.getString(bpi.getFAmountPatientVisit())));
                bpi.setSysStatusFunds(config1.StringNull(rs.getString(bpi.getFSysStatusFunds())));
                bpi.setSysStatusDoctor(config1.StringNull(rs.getString(bpi.getFSysStatusDoctor())));
                bpi.setCntContactReceive(Double.parseDouble(rs.getString(bpi.getFCntContactReceive())));
                bpi.setCntFundsReceive(Double.parseDouble(rs.getString(bpi.getFCntFundsReceive())));

                bpi.setCntDoctorReceive(Double.parseDouble(rs.getString(bpi.getFCntDoctorReceive())));
                bpi.setStatusContactReceive(config1.StringNull(rs.getString(bpi.getFStatusContactReceive())));
                bpi.setStutasDoctorReceive(config1.StringNull(rs.getString(bpi.getFStatusDoctorReceive())));
                bpi.setStutasFundsReceive(config1.StringNull(rs.getString(bpi.getFStatusFundsReceive())));
                bpi.amountCloseDay = Double.parseDouble(rs.getString(bpi.getFAmountCloseDay()));

                v_patient_import.add(bpi);

                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientImportDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_patient_import;
    }
    public String setSaveBackTPatientImport(BackTPatientImport item) throws Exception {
        int chk=0;
        String sql="", max="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            bpi = getBackTPatientImportByPK(item.getPatientImportId(),"patient_import_id");
            item.setRemark(item.getRemark().replace("'", "''"));
            item.setDescription(item.getDescription().replace("'", "''"));
            if(bpi.getPatientImportId().equals("")) {
                max = getMaxRowBackTPatientImport(conn);
                sql="Insert Into "+bpi.getBackTPatientImport()+"("
                        +bpi.getFPatientImportId()+", "+bpi.getFBranchId()+", "
                        +bpi.getFCntPatientVisit()+","+ bpi.getFCntPatientVisitVn()+","
                        +bpi.getFDateEnd()+","+ bpi.getFDateStart()+","
                        +bpi.getFDescription()+","+ bpi.getFPatientImportDate()+","
                        +bpi.getFPatientImportMonth()+","+bpi.getFPatientImportYear()+"," +
                        bpi.getFRemark()+","+bpi.getFPatientVisitId()+"," +
                        bpi.getFCntPatientVisitContact()+","+bpi.getFCntPatientVisitDoctor()+"," +
                        bpi.getFCntPatientVisitFunds()+","+bpi.getFAmountPatientVisitContact()+"," +
                        bpi.getFAmountPatientVisitDoctor()+","+bpi.getFAmountPatientVisitFunds()+"," +
                        bpi.getFPatientImportActive()+","+bpi.getFSysStatusContact()+"," +
                        bpi.getFAmountPatientVisit()+","+bpi.getFSysStatusDoctor()+"," +
                        bpi.getFSysStatusFunds()+","+bpi.getFCntContactReceive()+","
                        + bpi.getFCntDoctorReceive()+","+bpi.getFCntFundsReceive()+","
                        + bpi.getFStatusContactReceive()+","+bpi.getFStatusDoctorReceive()+","
                        + bpi.getFStatusFundsReceive()+","+dbObj.timeMake+") "
                        +"Values('"+max+"','"+item.getBranchId()+"','"
                        +item.getCntPatientVisit() + "','"+ item.getCntPatientVisitVn()+"','"
                        +item.getDateEnd() + "','"+ item.getDateStart()+"','"
                        +item.getDescription() + "','"+ item.getPatientImportDate()+"','"
                        +item.getPatientImportMonth() + "','"+item.getPatientImportYear()+"','" +
                        item.getRemark()+"','"+item.getPatientVisitId()+"'," +
                        item.getCntPatientVisitContact()+","+item.getCntPatientVisitDoctor()+"," +
                        item.getCntPatientVisitFunds()+","+item.getAmountPatientVisitContact()+"," +
                        item.getAmountPatientVisitDoctor()+","+item.getAmountPatientVisitFunds()+",'" +
                        item.getPatientImportActive()+"','"+item.getSysStutasContact()+"'," +
                        item.getAmountPatientVisit()+",'"+item.getSysStutasDoctor()+"','" +
                        item.getSysStutasFunds()+"',"+item.getCntContactReceive()+","
                        + item.getCntDoctorReceive()+","+item.getCntFundsReceive()+",'"
                        + item.getStutasContactReceive()+"','"+item.getStutasDoctorReceive()+"','"
                        + item.getStutasFundsReceive()+"','"+item.timeMake+"')";
            }else{
                sql = "Update "+bpi.getBackTPatientImport()+" set "
                +bpi.getFBranchId()+" = '"+item.getBranchId()+"', "
                +bpi.getFCntPatientVisit()+" = '"+item.getCntPatientVisit()+"', "
                +bpi.getFCntPatientVisitVn()+" = '"+item.getCntPatientVisitVn()+"', "
                +bpi.getFDateEnd()+" = '"+item.getDateEnd()+"', "
                +bpi.getFDateStart()+" = '"+item.getDateStart()+"', "
                +bpi.getFDescription()+" = '"+item.getDescription()+"', "
                +bpi.getFPatientImportDate()+" = '"+item.getPatientImportDate()+"', "+
                bpi.getFPatientImportMonth()+" = '"+item.getPatientImportMonth()+"', "+
                bpi.getFPatientImportYear()+" = '"+item.getPatientImportYear()+"', " +
                bpi.getFCntPatientVisitContact()+" = "+item.getCntPatientVisitContact()+", "+
                bpi.getFCntPatientVisitFunds()+" = "+item.getCntPatientVisitFunds()+", "+
                bpi.getFCntPatientVisitDoctor()+" = "+item.getCntPatientVisitDoctor()+", "+
                bpi.getFAmountPatientVisitContact()+" = "+item.getAmountPatientVisitContact()+", "+
                bpi.getFAmountPatientVisitFunds()+" = "+item.getAmountPatientVisitFunds()+", "+
                bpi.getFAmountPatientVisitDoctor()+" = "+item.getAmountPatientVisitDoctor()+", "+
                bpi.getFPatientImportActive()+" = '"+item.getPatientImportActive()+"', "+
                bpi.getFSysStatusContact()+" = '"+item.getSysStutasContact()+"', "+
                bpi.getFAmountPatientVisit()+" = "+item.getAmountPatientVisit()+", "+
                bpi.getFSysStatusFunds()+" = '"+item.getSysStutasFunds()+"', "+
                bpi.getFSysStatusDoctor()+" = '"+item.getSysStutasDoctor()+"', "+
                bpi.getFCntContactReceive()+" = "+item.getCntContactReceive()+", "+
                bpi.getFCntFundsReceive()+" = "+item.getCntFundsReceive()+", "+
                bpi.getFCntDoctorReceive()+" = "+item.getCntDoctorReceive()+", "+
                        bpi.getFCntDoctorReceive()+" = '"+item.getCntDoctorReceive()+"', "+
                        bpi.getFCntDoctorReceive()+" = '"+item.getCntDoctorReceive()+"', "+
                        bpi.getFCntDoctorReceive()+" = '"+item.getCntDoctorReceive()+"' "+
                "Where "+bpi.getFPatientImportId()+" = '"+item.getPatientImportId()+"'";
                max = item.getPatientImportId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientImportDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String setUpdatePatientVisitImportCnt(String bpiId, BackTPatientImport item){
        Integer chk=0;
        String sql="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Update "+bpi.getBackTPatientImport()+" set "
                +bpi.getFCntPatientVisit()+" = '"+item.getCntPatientVisit()+"', "
                +bpi.getFCntPatientVisitVn()+" = '"+item.getCntPatientVisitVn()+"', "+
                bpi.getFCntPatientVisitContact()+" = "+item.getCntPatientVisitContact()+", "+
                bpi.getFCntPatientVisitFunds()+" = "+item.getCntPatientVisitFunds()+", "+
                bpi.getFCntPatientVisitDoctor()+" = "+item.getCntPatientVisitDoctor()+", "+
                bpi.getFAmountPatientVisitContact()+" = "+item.getAmountPatientVisitContact()+", "+
                bpi.getFAmountPatientVisitFunds()+" = "+item.getAmountPatientVisitFunds()+", "+
                bpi.getFAmountPatientVisitDoctor()+" = "+item.getAmountPatientVisitDoctor()+", "+
                bpi.getFAmountPatientVisit()+" = "+item.getAmountPatientVisit()+" "+
//                bpi.getFCntContactReceive()+" = "+item.getCntContactReceive()+", "+
//                bpi.getFCntFundsReceive()+" = "+item.getCntFundsReceive()+", "+
//                bpi.getFCntDoctorReceive()+" = "+item.getCntDoctorReceive()+", "+
//                bpi.getFCntDoctorReceive()+" = '"+item.getCntDoctorReceive()+"', "+
//                bpi.getFCntDoctorReceive()+" = '"+item.getCntDoctorReceive()+"', "+
//                bpi.getFCntDoctorReceive()+" = '"+item.getCntDoctorReceive()+"' "+
                "Where "+bpi.getFPatientImportId()+" = '"+bpiId+"'";
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientImportDB.class.getName()).log(Level.SEVERE, null, ex);
//            max = ex.getMessage();
        }
        return chk.toString();
    }
    public String getTrBackTPatientVisitImport(String branch_id,String year_id,String month_id,String flag, String subsystem ){
        String date_start="", date_end="", cnt="",row_color="",cnt_receive="",text_h="";
        StringBuilder txt = new StringBuilder();
        Integer row=0;
        Vector v_patient_visit = new Vector();
        if(flag.equals("view_status_d")){
            v_patient_visit = getBackTPatientImport(branch_id, year_id, "", flag,subsystem);
        }else if(flag.equals("view_status_y")){
            v_patient_visit = getBackTPatientImport(branch_id, year_id, month_id, flag,subsystem);
        }else{
            //v_patient_visit = patient_visitdb.getBackTPatientImport(branch_id, year, "", flagpage,sub_system);
        }
        for(int i=0;i<=v_patient_visit.size()-1;i++) {
            row++;
            bpi = (BackTPatientImport)v_patient_visit.get(i);
            try {
                date_start = config1.DateFormatDB2ShowHospital(bpi.getDateStart(), "ddMMyyyy");
                date_end = config1.DateFormatDB2ShowHospital(bpi.getDateEnd(),"ddMMyyyy");
                if(subsystem.equals("funds")) {
                    cnt = bpi.getCntPatientVisitFunds().toString();
                    cnt_receive = bpi.getCntFundsReceive().toString();
                    if(bpi.getStutasFundsReceive().equals("3")){
                        row_color = "bgcolor='#F3BDE1'";
                    }else{
                        row_color = "";
                    }
                }else if(subsystem.equals("contact")) {
                    cnt = bpi.getCntPatientVisitContact().toString();
                    cnt_receive = bpi.getCntContactReceive().toString();
                    if(bpi.getStutasContactReceive().equals("3")){
                        row_color = "bgcolor='#F3BDE1'";
                    }else{
                        row_color = "";
                    }
                }
                //visit_date = config1.DateFormatDB2Show(patient_visit.getVisitDate(), "ddMMyyyy");
                txt.append("<tr class='style14' ").append(row_color).append("><td width='10' align='center'>").append(row.toString()).append("</td>").append(
                "<td >").append(config1.getMonthNamet(bpi.getPatientImportMonth(),"code_name")).append(" ").append(bpi.getPatientImportYear() ).append("</td>").append(
                "<td ><a href='back_funds_add.jsp?patient_import_id=").append(bpi.getPatientImportId()).append("&flagpage=")
                        .append(flag).append("&sub_system_id=").append(subsystem).append("&sub_system=")
                        .append(subsystem).append("'>").append(date_start).append(" ").append(date_end).append("</a></td>").append(
                "<td >").append(bpi.getDescription()).append("</td>").append(
                "<td align='center'>").append(config1.IntegerFormat(bpi.getCntPatientVisitVn())).append("</td>").append(
                "<td align='center'>").append(config1.IntegerFormat(cnt)).append("</td>").append(
                "<td align='center'>").append(config1.IntegerFormat(cnt_receive)).append("</td></tr>") ;
            } catch (Exception ex) {
                Logger.getLogger(BackTPatientImportDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    //text = patient_visitdb.getTrPatientVisitGroupPaidNamet(patient_import_id);
    text_h="<thead> " +
            "<tr align='center' class='style14r'><th width='55' align='center'>ลำดับที่</th> " +
                "<th width='100' align='left'>ประจำ</th> " +
                "<th width='150' align='left'>วันที่เริ่มต้น ถึงวันที่</th> " +
                "<th width='300' align='left'>รายละเอียด</th> " +
                "<th width='40' align='center'>Visit</th> " +
                "<th width='40' align='center'>VN</th> " +
                "<th width='50' align='center'>นำเข้า</th> " +
        "</tr></thead>";
        return "<table id='table' widht='100%'>"+text_h+"<tbody>"+txt.toString()+"</tbody></table>";
    }
    public void setUpdatePatientVisitFundsBillingId(String branch_id ) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          Statement st1 = conn.createStatement();
          sql = "Select patient_visit_funds_id,patient_visit_funds_billing_id From back_t_patient_visit_funds_billing ";
          //st.executeUpdate(sql);
          ResultSet rs = st.executeQuery(sql);
          while(rs.next()){
              sql = "Update back_t_patient_visit_funds "
                  + " Set patient_visit_funds_billing_id ='"+rs.getString("patient_visit_funds_billing_id")+"' "
                  + "Where patient_visit_funds_id = '" + rs.getString("patient_visit_funds_id")+"'";
              st1.executeUpdate(sql);
          }
          rs.close();
          
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String setPatientImportCloseDayUpdate(String branchId, String closeDayDate){
        Integer chk=0;
        String sql="";
        Double amountCloseDay=0.0;
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          
          CashierTCloseDayDB closeDaydb = new CashierTCloseDayDB(config1);
          String[] arrayCloseDayId = closeDaydb.getCloseDayId(branchId,closeDayDate);
          for(int i=0;i<arrayCloseDayId.length;i++){
              CashierTCloseDay closeday = closeDaydb.getCashierTCloseDayByPK(branchId, arrayCloseDayId[i]);
              amountCloseDay += closeday.getAmtPatientVisit();
          }
          bpi = getBackTPatientImportByPK(branchId, closeDayDate);
          sql = "Update "+bpi.getBackTPatientImport()+" Set "+bpi.getFAmountCloseDay()+"="+amountCloseDay
                  +" Where "+bpi.getFPatientImportId()+"='"+bpi.getPatientImportId()+"'";
          chk = st.executeUpdate(sql);
          
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setPatientImportTimeFinish(String brnachId, String bpiId){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        String timeFinish=config1.getDateDBHospital("yyyyMMdd hh:mm:ss");
        
        sql.append("Update ").append(dbObj.table).append(" Set ").append(dbObj.timeFinish).append("='").append(timeFinish).append("' ")
            .append("Where ").append(dbObj.pk_field).append("='").append(bpiId).append("' ");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setPatientImportDoctorTimeMake(String brnachId, String bpiId){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        String timeMake=config1.getDateDBHospital("yyyyMMdd hh:mm:ss");
        sql.append("Update ").append(dbObj.table).append(" Set ").append(dbObj.doctorTimeMake).append("='").append(timeMake).append("' ")
            .append("Where ").append(dbObj.pk_field).append("='").append(bpiId).append("' ");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setPatientImportDoctorTimeFinish(String brnachId, String bpiId){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        String timeFinish=config1.getDateDBHospital("yyyyMMdd hh:mm:ss");
        sql.append("Update ").append(dbObj.table).append(" Set ").append(dbObj.doctorTimeFinish).append("='").append(timeFinish).append("' ")
            .append("Where ").append(dbObj.pk_field).append("='").append(bpiId).append("' ");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setPatientImportFundsTimeMake(String brnachId, String bpiId){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        String timeMake=config1.getDateDBHospital("yyyyMMdd hh:mm:ss");
        sql.append("Update ").append(dbObj.table).append(" Set ").append(dbObj.fundsTimeMake).append("='").append(timeMake).append("' ")
            .append("Where ").append(dbObj.pk_field).append("='").append(bpiId).append("' ");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setPatientImportFundsTimeFinish(String brnachId, String bpiId){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        String timeFinish=config1.getDateDBHospital("yyyyMMdd hh:mm:ss");
        
        sql.append("Update ").append(dbObj.table).append(" Set ").append(dbObj.fundsTimeFinish).append("='").append(timeFinish).append("' ")
            .append("Where ").append(dbObj.pk_field).append("='").append(bpiId).append("' ");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setPatientImportContactTimeMake(String brnachId, String bpiId){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        String timeMake=config1.getDateDBHospital("yyyyMMdd hh:mm:ss");
        sql.append("Update ").append(dbObj.table).append(" Set ").append(dbObj.contactTimeMake).append("='").append(timeMake).append("' ")
            .append("Where ").append(dbObj.pk_field).append("='").append(bpiId).append("' ");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setPatientImportContactTimeFinish(String brnachId, String bpiId){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        String timeFinish=config1.getDateDBHospital("yyyyMMdd hh:mm:ss");
        
        sql.append("Update ").append(dbObj.table).append(" Set ").append(dbObj.contactTimeFinish).append("='").append(timeFinish).append("' ")
            .append("Where ").append(dbObj.pk_field).append("='").append(bpiId).append("' ");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }

}
