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
public class BackTPatientImport extends Persistent{
    public String patientImportId="";
    public String patientImportDate="";
    public String branchId="";
    public String patientImportYear="";
    public String patientImportMonth="";
    public String dateStart="";
    public String dateEnd="";
    public String description="";
    public String remark="";
    public Double cntPatientVisit=0.0;
    public Double cntPatientVisitVn=0.0;
    public String patientVisitId="";
    public Double cntPatientVisitContact=0.0;
    public Double cntPatientVisitFunds=0.0;
    public Double cntPatientVisitDoctor=0.0;
    public Double amountPatientVisitContact=0.0;
    public Double amountPatientVisitFunds=0.0;
    public Double amountPatientVisitDoctor=0.0;
    public String patientImportActive="";
    public String sysStatusContact="";
    public Double amountPatientVisit=0.0;
    public String sysStatusFunds="";
    public String sysStatusDoctor="";
    public Double cntContactReceive=0.0;
    public Double cntFundsReceive=0.0;
    public Double cntDoctorReceive=0.0;
    public String statusContactReceive="";
    public String statusFundsReceive="";
    public String statusDoctorReceive="";
    public Double amountCloseDay=0.0;
    public String timeMake="";
    public String timeFinish="";
    public String doctorTimeMake="";
    public String doctorTimeFinish="";
    public String fundsTimeMake="";
    public String fundsTimeFinish="";
    public String contactTimeMake="";
    public String contactTimeFinish="";

    public BackTPatientImport() {
    }
    public void initial(){
        patientImportId="";
        patientImportDate="";
        branchId="";
        patientImportYear="";
        patientImportMonth="";
        dateStart="";
        dateEnd="";
        description="";
        remark="";
        cntPatientVisit=0.0;
        cntPatientVisitVn=0.0;
        patientVisitId="";
        cntPatientVisitContact=0.0;
        cntPatientVisitFunds=0.0;
        cntPatientVisitDoctor=0.0;
        amountPatientVisitContact=0.0;
        amountPatientVisitFunds=0.0;
        amountPatientVisitDoctor=0.0;
        patientImportActive="";
        sysStatusContact="";
        amountPatientVisit=0.0;
        sysStatusFunds="";
        sysStatusDoctor="";
        cntContactReceive=0.0;
        cntFundsReceive=0.0;
        cntDoctorReceive=0.0;
        statusContactReceive="";
        statusFundsReceive="";
        statusDoctorReceive="";
    }

    public BackTPatientImport(String patientImportId) {
        this.patientImportId = patientImportId;
    }
    public String getBackTPatientImport(){
        return "back_t_patient_import";
    }
    public String getFPatientImportId(){
        return "patient_import_id";
    }
    public String getFPatientImportDate(){
        return "patient_import_date";
    }
    public String getFBranchId(){
        return "branch_id";
    }
    public String getFPatientImportYear(){
        return "patient_import_year";
    }
    public String getFPatientImportMonth(){
        return "patient_import_month";
    }
    public String getFDateStart(){
        return "date_start";
    }
    public String getFDateEnd(){
        return "date_end";
    }
    public String getFDescription(){
        return "description";
    }
    public String getFRemark(){
        return "remark";
    }
    public String getFCntPatientVisit(){
        return "cnt_patient_visit";
    }
    public String getFCntPatientVisitVn(){
        return "cnt_patient_visit_vn";
    }
    public String getFPatientVisitId(){
        return "patient_visit_id";
    }
    public String getFCntPatientVisitContact(){
        return "cnt_patient_visit_contact";
    }
    public String getFCntPatientVisitFunds(){
        return "cnt_patient_visit_funds";
    }
    public String getFCntPatientVisitDoctor(){
        return "cnt_patient_visit_doctor";
    }
    public String getFAmountPatientVisitContact(){
        return "amount_patient_visit_contact";
    }
    public String getFAmountPatientVisitFunds(){
        return "amount_patient_visit_funds";
    }
    public String getFAmountPatientVisitDoctor(){
        return "amount_patient_visit_doctor";
    }
    public String getFPatientImportActive(){
        return "patient_import_active";
    }
    public String getFSysStatusContact(){
        return "sys_status_contact";
    }
    public String getFAmountPatientVisit(){
        return "amount_patient_visit";
    }
    public String getFSysStatusFunds(){
        return "sys_status_funds";
    }
    public String getFSysStatusDoctor(){
        return "sys_status_doctor";
    }
    public String getFCntContactReceive(){
        return "cnt_contact_receive";
    }
    public String getFCntFundsReceive(){
        return "cnt_funds_receive";
    }
    public String getFCntDoctorReceive(){
        return "cnt_doctor_receive";
    }
    public String getFStatusContactReceive(){
        return "status_contact_receive";
    }
    public String getFStatusFundsReceive(){
        return "status_funds_receive";
    }
    public String getFStatusDoctorReceive(){
        return "status_doctor_receive";
    }
    public String getFAmountCloseDay(){
        return "amount_close_day";
    }

    public String getPatientImportId() {
        return patientImportId;
    }

    public void setPatientImportId(String patientImportId) {
        this.patientImportId = patientImportId;
    }

    public String getPatientImportDate() {
        return patientImportDate;
    }

    public void setPatientImportDate(String patientImportDate) {
        this.patientImportDate = patientImportDate;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getPatientImportYear() {
        return patientImportYear;
    }

    public void setPatientImportYear(String patientImportYear) {
        this.patientImportYear = patientImportYear;
    }

    public String getPatientImportMonth() {
        return patientImportMonth;
    }

    public void setPatientImportMonth(String patientImportMonth) {
        this.patientImportMonth = patientImportMonth;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getCntPatientVisit() {
        return cntPatientVisit;
    }

    public void setCntPatientVisit(Double cntPatientVisit) {
        this.cntPatientVisit = cntPatientVisit;
    }

    public Double getCntPatientVisitVn() {
        return cntPatientVisitVn;
    }
    public void setCntPatientVisitVn(Double cntPatientVisitVn) {
        this.cntPatientVisitVn = cntPatientVisitVn;
    }

    public String getPatientVisitId() {
        return patientVisitId;
    }
    public void setPatientVisitId(String patientVisitId) {
        this.patientVisitId = patientVisitId;
    }
    public Double getCntPatientVisitContact() {
        return cntPatientVisitContact;
    }
    public void setCntPatientVisitContact(Double cntPatientVisitContact) {
        this.cntPatientVisitContact = cntPatientVisitContact;
    }
    public Double getCntPatientVisitFunds() {
        return cntPatientVisitFunds;
    }
    public void setCntPatientVisitFunds(Double cntPatientVisitFunds) {
        this.cntPatientVisitFunds = cntPatientVisitFunds;
    }
    public Double getCntPatientVisitDoctor() {
        return cntPatientVisitDoctor;
    }
    public void setCntPatientVisitDoctor(Double cntPatientVisitDoctor) {
        this.cntPatientVisitDoctor = cntPatientVisitDoctor;
    }
    public Double getAmountPatientVisitContact() {
        return amountPatientVisitContact;
    }
    public void setAmountPatientVisitContact(Double amountPatientVisitContact) {
        this.amountPatientVisitContact = amountPatientVisitContact;
    }
    public Double getAmountPatientVisitFunds() {
        return amountPatientVisitFunds;
    }
    public void setAmountPatientVisitFunds(Double amountPatientVisitFunds) {
        this.amountPatientVisitFunds = amountPatientVisitFunds;
    }
    public Double getAmountPatientVisitDoctor() {
        return amountPatientVisitDoctor;
    }
    public void setAmountPatientVisitDoctor(Double amountPatientVisitDoctor) {
        this.amountPatientVisitDoctor = amountPatientVisitDoctor;
    }

    public String getPatientImportActive() {
        return patientImportActive;
    }
    public void setPatientImportActive(String patientImportActive) {
        this.patientImportActive = patientImportActive;
    }

    public String getSysStutasContact() {
        return sysStatusContact;
    }
    public void setSysStatusContact(String sysStatusContact) {
        this.sysStatusContact = sysStatusContact;
    }
    public Double getAmountPatientVisit() {
        return amountPatientVisit;
    }
    public void setAmountPatientVisit(Double amountPatientVisit) {
        this.amountPatientVisit = amountPatientVisit;
    }
    public String getSysStutasFunds() {
        return sysStatusFunds;
    }
    public void setSysStatusFunds(String sysStatusFunds) {
        this.sysStatusFunds = sysStatusFunds;
    }
    
    public String getSysStutasDoctor() {
        return sysStatusDoctor;
    }
    public void setSysStatusDoctor(String sysStatusDoctor) {
        this.sysStatusDoctor = sysStatusDoctor;
    }

    public Double getCntContactReceive() {
        return cntContactReceive;
    }
    public void setCntContactReceive(Double cntContactReceive) {
        this.cntContactReceive = cntContactReceive;
    }

    public Double getCntFundsReceive() {
        return cntFundsReceive;
    }
    public void setCntFundsReceive(Double cntFundsReceive) {
        this.cntFundsReceive = cntFundsReceive;
    }

    public Double getCntDoctorReceive() {
        return cntDoctorReceive;
    }
    public void setCntDoctorReceive(Double cntDoctorReceive) {
        this.cntDoctorReceive = cntDoctorReceive;
    }

    public String getStutasContactReceive() {
        return statusContactReceive;
    }
    public void setStatusContactReceive(String statusContactReceive) {
        this.statusContactReceive = statusContactReceive;
    }

    public String getStutasFundsReceive() {
        return statusFundsReceive;
    }
    public void setStutasFundsReceive(String statusFundsReceive) {
        this.statusFundsReceive = statusFundsReceive;
    }

    public String getStutasDoctorReceive() {
        return statusDoctorReceive;
    }
    public void setStutasDoctorReceive(String statusDoctorReceive) {
        this.statusDoctorReceive = statusDoctorReceive;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (patientImportId != null ? patientImportId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof BackTPatientImport)) {
//            return false;
//        }
//        BackTPatientImport other = (BackTPatientImport) object;
//        if ((this.patientImportId == null && other.patientImportId != null) || (this.patientImportId != null && !this.patientImportId.equals(other.patientImportId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "bangnaAdmin.BackTPatientImport[patientImportId=" + patientImportId + "]";
//    }

}
