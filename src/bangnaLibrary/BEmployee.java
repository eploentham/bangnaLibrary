/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import com.bangna.usecase.connection.Persistent;

/**
 *
 * @author root
 */
public class BEmployee extends Persistent {
    public String bEmployeeId="";
    public String employeeLogin="";
    public String employeePassword="";
    public String employeeFirstname="";
    public String employeeLastname="";
    public String employeeNumber="";
    public String employeeLastLogin="";
    public String employeeLastLogout="";
    public String employeeActive="";
    public String bServicePointId="";
    public String fEmployeeLevelId="";
    public String fEmployeeRuleId="";
    public String fEmployeeAuthenticationId="";
    public String bEmployeeDefaultTab="";
    public String employeeWarningDx="";
    public String employeeStatus="";
    public Double salary=0.0;
    public Double salaryWarranty=0.0;
    public String bBankId="";
    public String bBankNamet="";
    public String bookBankId="";
    public String bookBankNamet="";
    public String paymentStatusId="";
    public String paymentStatusNamet="";
    public Double charge=0.0;
    public String branchId="";
    public String addressLine1="";
    public String addressLine2="";
    public Double taxRate=0.0;
    public String pid="";
    public String formulaId="";
    public String taxId="";
    public String statusEmployee="";
    public String doctorId="";
    public String employeePrefixId="";
    public String employeeDepartment="";
    public String employeeSection="";
    public String sex="";
    public String age ="";
    public String typeIncomeId ="";
    public String employeeDate ="";
    public String mobile ="";
    public String statusDoctor ="";
    public String bVisitClinicId ="";
    public String typeDoctorId="";
    public String statusFormula="";
    public String specialistId="";
    public String employeeShortName="";
    public String statusNoCloseDayImport="";
    public String dateNoCloseDayImport="";

    public BEmployee() {
    }
    public void initial(){
        bEmployeeId="";
        employeeLogin="";
        employeePassword="";
        employeeFirstname="";
        employeeLastname="";
        employeeNumber="";
        employeeLastLogin="";
        employeeLastLogout="";
        employeeActive="";
        bServicePointId="";
        fEmployeeLevelId="";
        fEmployeeRuleId="";
        fEmployeeAuthenticationId="";
        bEmployeeDefaultTab="";
        employeeWarningDx="";
        employeeStatus="";
        salary=0.0;
        salaryWarranty=0.0;
        bBankId="";
        bBankNamet="";
        bookBankId="";
        bookBankNamet="";
        paymentStatusId="";
        paymentStatusNamet="";
        charge=0.0;
        branchId="";
        addressLine1="";
        addressLine2="";
        taxRate=0.0;
        pid="";
        formulaId="";
        taxId="";
        statusEmployee="";
        doctorId="";
        employeePrefixId="";
        employeeDepartment="";
        employeeSection="";
        employeeShortName="";
    }

    public String getBEmployee(){
        return "b_employee";
    }
    public String getFBEmployeeId(){
        return "b_employee_id";
    }
    public String getFEmployeeLogin(){
        return "employee_login";
    }
    public String getFEmployeePassword(){
        return "employee_password";
    }
    public String getFEmployeeFirstname(){
        return "employee_firstname";
    }
    public String getFEmployeeLastname(){
        return "employee_lastname";
    }
    public String getFEmployeeNumber(){
        return "employee_number";
    }
    public String getFEmployeeLastLogin(){
        return "employee_last_login";
    }
    public String getFEmployeeLastLogout(){
        return "employee_last_logout";
    }
    public String getFEmployeeActive(){
        return "employee_active";
    }
    public String getFBServicePointId(){
        return "b_service_point_id";
    }
    public String getFFEmployeeLevelId(){
        return "f_employee_level_id";
    }
    public String getFFEmployeeRuleId(){
        return "f_employee_rule_id";
    }
    public String getFFEmployeeAuthenticationId(){
        return "f_employee_authentication_id";
    }
    public String getFBEmployeeDefaultTab(){
        return "b_employee_default_tab";
    }
    public String getFEmployeeWarningDx(){
        return "employee_warning_dx";
    }
    public String getFEmployeeStatus(){
        return "employee_status";
    }
    public String getFSalary(){
        return "salary";
    }
    public String getFSalaryWarranty(){
        return "salary_warranty";
    }
    public String getFBBankId(){
        return "b_bank_id";
    }
    public String getFBBankNamet(){
        return "b_bank_namet";
    }
    public String getFBookBankId(){
        return "book_bank_id";
    }
    public String getFBookBankNamet(){
        return "book_bank_namet";
    }
    public String getFPaymentStatusId(){
        return "payment_status_id";
    }
    public String getFPaymentStatusNamet(){
        return "payment_status_namet";
    }
    public String getFCharge(){
        return "charge";
    }
    public String getFBranchId(){
        return "branch_id";
    }
    public String getFAddressLine1(){
        return "address_line1";
    }
    public String getFAddressLine2(){
        return "address_line2";
    }
    public String getFPid(){
        return "pid";
    }
    public String getFTaxRate(){
        return "tax_rate";
    }
    public String getFFormulaId(){
        return "formula_id";
    }
    public String getFTaxId(){
        return "tax_id";
    }
    public String getFStatusEmployee(){
        return "status_employee";
    }
    public String getFDoctorId(){
        return "doctor_id";
    }
    public String getFTypeIncomeId(){
        return "type_income_id";
    }
    public String getFEmployeeDate(){
        return "employee_date";
    }
    public String getFMobile(){
        return "mobile";
    }
    public String getFStatusDoctor(){
        return "status_doctor";
    }
    public String getFBVisitClinicId(){
        return "b_visit_clinic_id";
    }
    public String getFTypeDoctorId() {
        return "type_doctor_id";
    }
    public String getFStatusFormula() {
        return "status_formula";
    }
    public String getFSpecialistId() {
        return "specialist_id";
    }
    public String getFEmployeeshortName() {
        return "employee_shortname";
    }
    public String getFStatusNoCloseDayImport() {
        return "status_no_close_day_import";
    }
    public String getFDateNoCloseDayImport() {
        return "date_no_close_day_import";
    }


    public BEmployee(String bEmployeeId) {
        this.bEmployeeId = bEmployeeId;
    }

    public String getBEmployeeId() {
        return bEmployeeId;
    }

    public void setBEmployeeId(String bEmployeeId) {
        this.bEmployeeId = bEmployeeId;
    }

    public String getEmployeeLogin() {
        return employeeLogin;
    }

    public void setEmployeeLogin(String employeeLogin) {
        this.employeeLogin = employeeLogin;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeFirstname() {
        return employeeFirstname;
    }

    public void setEmployeeFirstname(String employeeFirstname) {
        this.employeeFirstname = employeeFirstname;
    }

    public String getEmployeeLastname() {
        return employeeLastname;
    }

    public void setEmployeeLastname(String employeeLastname) {
        this.employeeLastname = employeeLastname;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeLastLogin() {
        return employeeLastLogin;
    }

    public void setEmployeeLastLogin(String employeeLastLogin) {
        this.employeeLastLogin = employeeLastLogin;
    }

    public String getEmployeeLastLogout() {
        return employeeLastLogout;
    }

    public void setEmployeeLastLogout(String employeeLastLogout) {
        this.employeeLastLogout = employeeLastLogout;
    }

    public String getEmployeeActive() {
        return employeeActive;
    }

    public void setEmployeeActive(String employeeActive) {
        this.employeeActive = employeeActive;
    }

    public String getBServicePointId() {
        return bServicePointId;
    }

    public void setBServicePointId(String bServicePointId) {
        this.bServicePointId = bServicePointId;
    }

    public String getFEmployeeLevelId() {
        return fEmployeeLevelId;
    }

    public void setFEmployeeLevelId(String fEmployeeLevelId) {
        this.fEmployeeLevelId = fEmployeeLevelId;
    }

    public String getFEmployeeRuleId() {
        return fEmployeeRuleId;
    }

    public void setFEmployeeRuleId(String fEmployeeRuleId) {
        this.fEmployeeRuleId = fEmployeeRuleId;
    }

    public String getFEmployeeAuthenticationId() {
        return fEmployeeAuthenticationId;
    }

    public void setFEmployeeAuthenticationId(String fEmployeeAuthenticationId) {
        this.fEmployeeAuthenticationId = fEmployeeAuthenticationId;
    }

    public String getBEmployeeDefaultTab() {
        return bEmployeeDefaultTab;
    }

    public void setBEmployeeDefaultTab(String bEmployeeDefaultTab) {
        this.bEmployeeDefaultTab = bEmployeeDefaultTab;
    }

    public String getEmployeeWarningDx() {
        return employeeWarningDx;
    }
    public void setEmployeeWarningDx(String employeeWarningDx) {
        this.employeeWarningDx = employeeWarningDx;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }
    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getSalaryWarranty() {
        return salaryWarranty;
    }
    public void setSalaryWarranty(Double salaryWarranty) {
        this.salaryWarranty = salaryWarranty;
    }

    public Double getCharge() {
        return charge;
    }
    public void setCharge(Double charge) {
        this.charge = charge;
    }
    public String getBBankId() {
        return bBankId;
    }
    public void setBBankId(String bBankId) {
        this.bBankId = bBankId;
    }
    public String getBBankNamet() {
        return bBankNamet;
    }
    public void setBBankNamet(String bBankNamet) {
        this.bBankNamet = bBankNamet;
    }
    public String getBookBankId() {
        return bookBankId;
    }
    public void setBookBankId(String bookBankId) {
        this.bookBankId = bookBankId;
    }
    public String getBookBankNamet() {
        return bookBankNamet;
    }
    public void setBookBankNamet(String bookBankNamet) {
        this.bookBankNamet = bookBankNamet;
    }
    public String getPaymentStatusId() {
        return paymentStatusId;
    }
    public void setPaymentStatusId(String paymentStatusId) {
        this.paymentStatusId = paymentStatusId;
    }
    public String getPaymentStatusNamet() {
        return paymentStatusNamet;
    }
    public void setPaymentStatusNamet(String paymentStatusNamet) {
        this.paymentStatusNamet = paymentStatusNamet;
    }
    public String getBranchId() {
        return branchId;
    }
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getAddressLine1() {
        return addressLine1;
    }
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Double getTaxRate() {
        return taxRate;
    }
    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getFormulaId() {
        return formulaId;
    }
    public void setFormulaId(String formulaId) {
        this.formulaId = formulaId;
    }

    public String getTaxId() {
        return taxId;
    }
    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    /**
     * 1=doctor
     * 2=คณะบุคคล
     * @return
     */
    public String getStatusEmpoyee() {
        return statusEmployee;
    }
    public void setStatusEmpoyee(String statusEmployee) {
        this.statusEmployee = statusEmployee;
    }

    public String getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getEmployeePrefixId() {
        return employeePrefixId;
    }
    public void setEmployeePrefixId(String employeePrefixId) {
        this.employeePrefixId = employeePrefixId;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }
    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public String getEmployeeSection() {
        return employeeSection;
    }
    public void setEmployeeSection(String employeeSection) {
        this.employeeSection = employeeSection;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public String getTypeIncomeId() {
        return typeIncomeId;
    }
    public void setTypeIncomeId(String typeIncomeId) {
        this.typeIncomeId = typeIncomeId;
    }
    public String getEmployeeDate() {
        return employeeDate;
    }
    public void setEmployeeDate(String employeeDate) {
        this.employeeDate = employeeDate;
    }

    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 1=fulltime
     * 2=parttime
     * @return
     */
    public String getStatusDoctor() {
        return statusDoctor;
    }
    public void setStatusDoctor(String statusDoctor) {
        this.statusDoctor = statusDoctor;
    }

    public String getBVisitClinicId() {
        return bVisitClinicId;
    }
    public void setBVisitClinicId(String bVisitClinicId) {
        this.bVisitClinicId = bVisitClinicId;
    }

    public String getTypeDoctorId() {
        return typeDoctorId;
    }
    public void setTypeDoctorId(String typeDoctorId) {
        this.typeDoctorId = typeDoctorId;
    }

    public String getStatusFormula() {
        return statusFormula;
    }
    public void setStatusFormula(String statusFormula) {
        this.statusFormula = statusFormula;
    }

    public String getSpecialistId() {
        return specialistId;
    }
    public void setSpecialistId(String specialistId) {
        this.specialistId = specialistId;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (bEmployeeId != null ? bEmployeeId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof BEmployee)) {
//            return false;
//        }
//        BEmployee other = (BEmployee) object;
//        if ((this.bEmployeeId == null && other.bEmployeeId != null) || (this.bEmployeeId != null && !this.bEmployeeId.equals(other.bEmployeeId))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "bangnaLibrary.BEmployee[bEmployeeId=" + bEmployeeId + "]";
    }

}
