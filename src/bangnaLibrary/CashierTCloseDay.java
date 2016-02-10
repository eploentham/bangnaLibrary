/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import com.bangna.usecase.connection.Persistent;
//import java.io.Serializable;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;

/**
 *
 * @author root
 */
public class CashierTCloseDay extends Persistent{
    public String closeDayId="";
    public String closeDayDate="";
    public String yearId="";
    public String monthId="";
    public Double cntPatientVn=0.0;
    public Double cntPatientVisit=0.0;
    public Double amtPatientVn=0.0;
    public Double amtPatientVisit=0.0;
    public Double amtCloseDay=0.0;
    public Double cntCloseDay=0.0;
    public String closeDayTime="";
    public String dateMake="";
    public String timeMake="";
    public String closeDayActive="";
    public String dateCreate="";
    public String dateModify="";
    public String dateCancel="";
    public String userCreate="";
    public String userModify="";
    public String userCancel="";
    public String branchId="";
    public String fVisitTypeId="", fVisitTypeNamet="";
    public Double cash=0.0;
    public Double cashInDrawer=0.0;
    public Double cashDelivery=0.0;
    public Double otherAmt1=0.0;
    public Double otherAmt2=0.0;
    public Double otherAmt3=0.0;
    public String otherDescription1="";
    public String otherDescription2="";
    public String otherDescription3="", textTr="";
    public Double debtor=0.0;
    public String statusImport="";
    public String periodId="", periodNamet="";
    public String staffRecordId="";
    public String staffRecordName="";
    public String timeFinish="";

    public CashierTCloseDay() {
    }
    public void initial(){
        closeDayId="";
        closeDayDate="";
        yearId="";
        monthId="";
        cntPatientVn=0.0;
        cntPatientVisit=0.0;
        amtPatientVn=0.0;
        amtPatientVisit=0.0;
        amtCloseDay=0.0;
        cntCloseDay=0.0;
        closeDayTime="";
        dateMake="";
        timeMake="";
        closeDayActive="";
        dateCreate="";
        dateModify="";
        dateCancel="";
        userCreate="";
        userModify="";
        userCancel="";
        branchId="";
        fVisitTypeId=""; fVisitTypeNamet="";
        cash=0.0;
        cashInDrawer=0.0;
        cashDelivery=0.0;
        otherAmt1=0.0;
        otherAmt2=0.0;
        otherAmt3=0.0;
        otherDescription1="";
        otherDescription2="";
        otherDescription3=""; textTr="";
        debtor=0.0;
        statusImport="";
        periodId=""; periodNamet="";
    }

    public String getCashierTCloseDay(){
        return "cashier_t_close_day";
    }
    public String getFCloseDayId(){
        return "close_day_id";
    }
    public String getFCloseDayDate(){
        return "close_day_date";
    }
    public String getFYearId(){
        return "year_id";
    }
    public String getFMonthId(){
        return "month_id";
    }
    public String getFCntPatientVn(){
        return "cnt_patient_vn";
    }
    public String getFCntPatientVisit(){
        return "cnt_patient_visit";
    }
    public String getFAmtPatientVn(){
        return "amt_patient_vn";
    }
    public String getFAmtPatientVisit(){
        return "amt_patient_visit";
    }
    public String getFAmtCloseDay(){
        return "amt_close_day";
    }
    public String getFCntCloseDay(){
        return "cnt_close_day";
    }
    public String getFCloseDayTime(){
        return "close_day_time";
    }
    public String getFDateMake(){
        return "date_make";
    }
    public String getFTimeMake(){
        return "time_make";
    }
    public String getFCloseDayActive(){
        return "close_day_active";
    }
    public String getFDateCreate(){
        return "date_create";
    }
    public String getFDateModify(){
        return "date_modify";
    }
    public String getFDateCancel(){
        return "date_cancel";
    }
    public String getFUserCreate(){
        return "user_create";
    }
    public String getFUserModify(){
        return "user_modify";
    }
    public String getFUserCancel(){
        return "user_cancel";
    }
    public String getFBranchId(){
        return "branch_id";
    }
    public String getFFVisitTypeId(){
        return "f_visit_type_id";
    }
    public String getFCash(){
        return "cash";
    }
    public String getFCashInDrawer(){
        return "cash_in_drawer";
    }
    public String getFCashDelivery(){
        return "cash_delivery";
    }
    public String getFOtherDescription1(){
        return "other_description1";
    }
    public String getFOtherDescription2(){
        return "other_description2";
    }
    public String getFOtherDescription3(){
        return "other_description3";
    }
    public String getFOtherAmt1(){
        return "other_amt1";
    }
    public String getFOtherAmt2(){
        return "other_amt2";
    }
    public String getFOtherAmt3(){
        return "other_amt3";
    }
    public String getFDebtor(){
        return "debtor";
    }
    public String getFStatusImport(){
        return "status_import";
    }
    public String getFPeriodId(){
        return "period_id";
    }
    public String getFStaffRecordId(){
        return "staff_record_id";
    }
    public String getFStaffRecordName(){
        return "staff_record_name";
    }

    public CashierTCloseDay(String closeDayId) {
        this.closeDayId = closeDayId;
    }

    public String getCloseDayId() {
        return closeDayId;
    }
    public void setCloseDayId(String closeDayId) {
        this.closeDayId = closeDayId;
    }

    public String getCloseDayDate() {
        return closeDayDate;
    }
    public void setCloseDayDate(String closeDayDate) {
        this.closeDayDate = closeDayDate;
    }

    public String getYearId() {
        return yearId;
    }
    public void setYearId(String yearId) {
        this.yearId = yearId;
    }

    public String getMonthId() {
        return monthId;
    }
    public void setMonthId(String monthId) {
        this.monthId = monthId;
    }

    public Double getCntPatientVn() {
        return cntPatientVn;
    }
    public void setCntPatientVn(Double cntPatientVn) {
        this.cntPatientVn = cntPatientVn;
    }

    public Double getCntPatientVisit() {
        return cntPatientVisit;
    }
    public void setCntPatientVisit(Double cntPatientVisit) {
        this.cntPatientVisit = cntPatientVisit;
    }

    public Double getAmtPatientVn() {
        return amtPatientVn;
    }
    public void setAmtPatientVn(Double amtPatientVn) {
        this.amtPatientVn = amtPatientVn;
    }

    public Double getAmtPatientVisit() {
        return amtPatientVisit;
    }
    public void setAmtPatientVisit(Double amtPatientVisit) {
        this.amtPatientVisit = amtPatientVisit;
    }

    public Double getAmtCloseDay() {
        return amtCloseDay;
    }
    public void setAmtCloseDay(Double amtCloseDay) {
        this.amtCloseDay = amtCloseDay;
    }

    public Double getCntCloseDay() {
        return cntCloseDay;
    }
    public void setCntCloseDay(Double cntCloseDay) {
        this.cntCloseDay = cntCloseDay;
    }

    public String getCloseDayTime() {
        return closeDayTime;
    }
    public void setCloseDayTime(String closeDayTime) {
        this.closeDayTime = closeDayTime;
    }

    public String getDateMake() {
        return dateMake;
    }
    public void setDateMake(String dateMake) {
        this.dateMake = dateMake;
    }

    public String getTimeMake() {
        return timeMake;
    }
    public void setTimeMake(String timeMake) {
        this.timeMake = timeMake;
    }

    public String getCloseDayActive() {
        return closeDayActive;
    }
    public void setCloseDayActive(String closeDayActive) {
        this.closeDayActive = closeDayActive;
    }

    public String getDateCreate() {
        return dateCreate;
    }
    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDateModify() {
        return dateModify;
    }
    public void setDateModify(String dateModify) {
        this.dateModify = dateModify;
    }

    public String getDateCancel() {
        return dateCancel;
    }
    public void setDateCancel(String dateCancel) {
        this.dateCancel = dateCancel;
    }

    public String getUserCreate() {
        return userCreate;
    }
    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public String getUserModify() {
        return userModify;
    }
    public void setUserModify(String userModify) {
        this.userModify = userModify;
    }

    public String getUserCancel() {
        return userCancel;
    }
    public void setUserCancel(String userCancel) {
        this.userCancel = userCancel;
    }

    public String getBranchId() {
        return branchId;
    }
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getFVisitTypeId() {
        return fVisitTypeId;
    }
    public void setFVisitTypeId(String fVisitTypeId) {
        this.fVisitTypeId = fVisitTypeId;
    }

    public Double getCash() {
        return cash;
    }
    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Double getCashInDrawer() {
        return cashInDrawer;
    }
    public void setCashInDrawer(Double cashInDrawer) {
        this.cashInDrawer = cashInDrawer;
    }

    public Double getCashDelivery() {
        return cashDelivery;
    }
    public void setCashDelivery(Double cashDelivery) {
        this.cashDelivery = cashDelivery;
    }

    public String getOtherDescription1() {
        return otherDescription1;
    }
    public void setOtherDescription1(String otherDescription1) {
        this.otherDescription1 = otherDescription1;
    }
    public String getOtherDescription2() {
        return otherDescription2;
    }
    public void setOtherDescription2(String otherDescription2) {
        this.otherDescription2 = otherDescription2;
    }
    public String getOtherDescription3() {
        return otherDescription3;
    }
    public void setOtherDescription3(String otherDescription3) {
        this.otherDescription3 = otherDescription3;
    }

    public Double getOtherAmt1() {
        return otherAmt1;
    }
    public void setOtherAmt1(Double otherAmt1) {
        this.otherAmt1 = otherAmt1;
    }
    public Double getOtherAmt2() {
        return otherAmt2;
    }
    public void setOtherAmt2(Double otherAmt2) {
        this.otherAmt2 = otherAmt2;
    }
    public Double getOtherAmt3() {
        return otherAmt3;
    }
    public void setOtherAmt3(Double otherAmt3) {
        this.otherAmt3 = otherAmt3;
    }

    public String getTextTr() {
        return textTr;
    }
    public void setTextTr(String textTr) {
        this.textTr = textTr;
    }

    public Double getDebtor() {
        return debtor;
    }
    public void setDebtor(Double debtor) {
        this.debtor = debtor;
    }
    public String getStatusImport() {
        return statusImport;
    }
    public void setStatusImport(String statusImport) {
        this.statusImport = statusImport;
    }
    public String getPeriodId() {
        return periodId;
    }
    public void setPeriodId(String periodId) {
        this.periodId = periodId;
    }
    public String getPeriodNamet() {
        return periodNamet;
    }
    public void setPeriodNamet(String periodNamet) {
        this.periodNamet = periodNamet;
    }

    public String getFVisitTypeNamet() {
        return fVisitTypeNamet;
    }
    public void setFVisitTypeNamet(String fVisitTypeNamet) {
        this.fVisitTypeNamet = fVisitTypeNamet;
    }

    public String getStatffRecordId() {
        return staffRecordId;
    }
    public void setStaffRecordId(String staffRecordId) {
        this.staffRecordId = staffRecordId;
    }

    public String getStatffRecordName() {
        return staffRecordName;
    }
    public void setStaffRecordName(String staffRecordName) {
        this.staffRecordName = staffRecordName;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (closeDayId != null ? closeDayId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof CashierTCloseDay)) {
//            return false;
//        }
//        CashierTCloseDay other = (CashierTCloseDay) object;
//        if ((this.closeDayId == null && other.closeDayId != null) || (this.closeDayId != null && !this.closeDayId.equals(other.closeDayId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "bangnacloseday.CashierTCloseDay[closeDayId=" + closeDayId + "]";
//    }

}
