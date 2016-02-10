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
public class BackTBillingCover extends Persistent{
    public String billingCoverId="";
    public String billingCoverNumber="";
    public String billingCoverDate="";
    public String billingCoverActive="";
    public String bTransferId="";
    public String billingCoverDescription="";
    public String billingCoverRemark="";
    public Double billingCoverCnt=0.0;
    public Double billingCoverAmount=0.0;
    public String statusPrint="";
    public String bDepartmentId="";
    public String branchId="";
    public String contactName="";
    public String billingCoverAmountBaht="";
    public String billingCoverStaffNamet="";
    public String recordDatetime="";

    public BackTBillingCover() {
    }
    public void initial(){
        billingCoverId="";
        billingCoverNumber="";
        billingCoverDate="";
        billingCoverActive="";
        bTransferId="";
        billingCoverDescription="";
        billingCoverRemark="";
        billingCoverCnt=0.0;
        billingCoverAmount=0.0;
        statusPrint="";
        bDepartmentId="";
        branchId="";
        contactName="";
        billingCoverAmountBaht="";
    }
    public String getBackTBillingCover() {
        return "back_t_billing_cover";
    }
    public String getFBillingCoverId() {
        return "billing_cover_id";
    }
    public String getFBillingCoverNumber() {
        return "billing_cover_number";
    }
    public String getFBillingCoverDate() {
        return "billing_cover_date";
    }
    public String getFBillingCoverActive() {
        return "billing_cover_active";
    }
    public String getFBTransferId() {
        return "b_transfer_id";
    }
    public String getFBillingCoverDescription() {
        return "billing_cover_description";
    }
    public String getFBillingCoverRemark() {
        return "billing_cover_remark";
    }
    public String getFBillingCoverCnt() {
        return "billing_cover_cnt";
    }
    public String getFBillingCoverAmount() {
        return "billing_cover_amount";
    }
    public String getFStatusPrint() {
        return "status_print";
    }
    public String getFBDepartmentId() {
        return "b_department_id";
    }
    public String getFBranchId() {
        return "branch_id";
    }
    public String getFContactName() {
        return "contact_name";
    }
    public String getFBillingCoverAmountBaht() {
        return "billing_cover_amount_baht";
    }
    public String getFBillingCoverStaffNamet() {
        return "billing_cover_staff_namet";
    }
    public String getFRecordDatetime() {
        return "record_date_time";
    }

    public BackTBillingCover(String billingCoverId) {
        this.billingCoverId = billingCoverId;
    }

    public String getBillingCoverId() {
        return billingCoverId;
    }

    public void setBillingCoverId(String billingCoverId) {
        this.billingCoverId = billingCoverId;
    }

    public String getBillingCoverNumber() {
        return billingCoverNumber;
    }

    public void setBillingCoverNumber(String billingCoverNumber) {
        this.billingCoverNumber = billingCoverNumber;
    }

    public String getBillingCoverDate() {
        return billingCoverDate;
    }

    public void setBillingCoverDate(String billingCoverDate) {
        this.billingCoverDate = billingCoverDate;
    }

    public String getBillingCoverActive() {
        return billingCoverActive;
    }

    public void setBillingCoverActive(String billingCoverActive) {
        this.billingCoverActive = billingCoverActive;
    }

    public String getBTransferId() {
        return bTransferId;
    }

    public void setBTransferId(String bTransferId) {
        this.bTransferId = bTransferId;
    }

    public String getBillingCoverDescription() {
        return billingCoverDescription;
    }
    public void setBillingCoverDescription(String billingCoverDescription) {
        this.billingCoverDescription = billingCoverDescription;
    }

    public String getBillingCoverRemark() {
        return billingCoverRemark;
    }
    public void setBillingCoverRemark(String billingCoverRemark) {
        this.billingCoverRemark = billingCoverRemark;
    }

    public Double getBillingCoverCnt() {
        return billingCoverCnt;
    }
    public void setBillingCoverCnt(Double billingCoverCnt) {
        this.billingCoverCnt = billingCoverCnt;
    }

    public Double getBillingCoverAmount() {
        return billingCoverAmount;
    }
    public void setBillingCoverAmount(Double billingCoverAmount) {
        this.billingCoverAmount = billingCoverAmount;
    }

    public String getStatusPrint() {
        return statusPrint;
    }
    public void setStatusPrint(String statusPrint) {
        this.statusPrint = statusPrint;
    }

    public String getBDepartmentId() {
        return bDepartmentId;
    }
    public void setBDepartmentId(String bDepartmentId) {
        this.bDepartmentId = bDepartmentId;
    }

    public String getBranchId() {
        return branchId;
    }
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getBillingCoverAmountBaht() {
        return billingCoverAmountBaht;
    }
    public void setBillingCoverAmountBaht(String billingCoverAmountBaht) {
        this.billingCoverAmountBaht = billingCoverAmountBaht;
    }

    public String getBillingCoverStaffNamet() {
        return billingCoverStaffNamet;
    }
    public void setBillingCoverStaffNamet(String billingCoverStaffNamet) {
        this.billingCoverStaffNamet = billingCoverStaffNamet;
    }

}
