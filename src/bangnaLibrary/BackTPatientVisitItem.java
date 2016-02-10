package bangnaLibrary;

import com.bangna.usecase.connection.Persistent;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author root
 */
public class BackTPatientVisitItem extends Persistent{
    public String patientVisitBillingItemId="";
    public String patientVisitId="";
    public String tPatientId="";
    public String visitId="";
    public String billingInvoiceNumber="";
    public String tBillingInvoiceDateTime="";
    public String tBillingInvoiceTime="";
    public String billingInvoiceItemActive="";
    public Double billingInvoiceItemTotal=0.0;
    public String tBillingId="";
    public String tPaymentId="";
    public String visitVn="";
    public String tOrderItemId="";
    public String tBillingInvoiceItemId="";
    public String bItemId="";
    public String tBillingInvoiceItemNamet="";
    public String bItemBillingSubgroupId="";
    public String visitPatientSelfDoctor="";
    public String departmentId="";
    public String departmentNamet="";
    public String claimId="";
    public String claimNamet="";
    public String visitHn="";
    public String branchId="";
    public String sysStatus="";
    public Double itemTotal=0.0;
    public Double itemDiscount=0.0;
    public Double itemPaid=0.0;
    public String editStatus="";
    public String itemStatusDoctor="";
    public String doctorId="";
    public String fItemGroupId="";
    public String orderDateTime="";
    public String orderStartTime="";
    public String orderEndTime="";
    public String statusRate="";
    public String orderOperationNo="";
    public String orderOperationStatus="";
    public String statusNoCloseDayImport="";
    public String orderHome="";

    public BackTPatientVisitItem() {
    }
    public void initial(){
        patientVisitBillingItemId="";
        patientVisitId="";
        tPatientId="";
        visitId="";
        billingInvoiceNumber="";
        tBillingInvoiceDateTime="";
        tBillingInvoiceTime="";
        billingInvoiceItemActive="";
        billingInvoiceItemTotal=0.0;
        tBillingId="";
        tPaymentId="";
        visitVn="";
        tOrderItemId="";
        tBillingInvoiceItemId="";
        bItemId="";
        tBillingInvoiceItemNamet="";
        bItemBillingSubgroupId="";
        visitPatientSelfDoctor="";
        departmentId="";
        departmentNamet="";
        claimId="";
        claimNamet="";
        visitHn="";
        branchId="";
        sysStatus="";
        itemTotal=0.0;
        itemDiscount=0.0;
        itemPaid=0.0;
        editStatus="";
        itemStatusDoctor="";
        doctorId="";
        fItemGroupId="";
        orderDateTime="";
        orderHome="";
    }
    public String getBackTPatientVisitItem() {
        return "back_t_patient_visit_item";
    }

    public String getFPatientVisitItemId() {
        return "patient_visit_item_id";
    }
    public String getFPatientVisitId() {
        return "patient_visit_id";
    }
    public String getFTPatientId() {
        return "t_patient_id";
    }
    public String getFVisitId() {
        return "visit_id";
    }
    public String getFBillingInvoiceNumber() {
        return "billing_invoice_number";
    }
    public String getFTBillingInvoiceDateTime() {
        return "t_billing_invoice_date_time";
    }
    public String getFTBillingInvoiceTime() {
        return "t_billing_invoice_time";
    }
    public String getFBillingInvoiceItemActive() {
        return "billing_invoice_item_active";
    }
    public String getFBillingInvoiceItemTotal() {
        return "billing_invoice_item_total";
    }
    public String getFTBillingId() {
        return "t_billing_id";
    }
    public String getFTPaymentId() {
        return "t_payment_id";
    }
    public String getFVisitVn() {
        return "visit_vn";
    }
    public String getFTOrderItemId() {
        return "t_order_item_id";
    }
    public String getFTBillingInvoiceItemId() {
        return "t_billing_invoice_item_id";
    }
    public String getFBItemId() {
        return "b_item_id";
    }
    public String getFTBillingInvoiceItemNamet() {
        return "t_billing_invoice_item_namet";
    }
    public String getFBItemBillingSubgroupId() {
        return "b_item_billing_subgroup_id";
    }
    public String getFVisitPatientSeftDoctor() {
        return "visit_patient_self_doctor";
    }
    public String getFDepartmentId() {
        return "department_id";
    }
    public String getFDepartmentNamet() {
        return "department_namet";
    }
    public String getFClaimId() {
        return "claim_id";
    }
    public String getFClaimNamet() {
        return "claim_namet";
    }
    public String getFVisitHn() {
        return "visit_hn";
    }
    public String getFBranchId(){
        return "branch_id";
    }
    public String getFSysStatus(){
        return "sys_status";
    }
    public String getFItemTotal(){
        return "item_total";
    }
    public String getFItemDiscount(){
        return "item_discount";
    }
    public String getFItemPaid(){
        return "item_paid";
    }
    public String getFEditStatus(){
        return "edit_status";
    }
    public String getFItemStatusDoctor(){
        return "item_status_doctor";
    }
    public String getFDoctorId(){
        return "doctor_id";
    }
    public String getFFItemGroupId(){
        return "f_item_group_id";
    }
    public String getFOrderDateTime(){
        return "order_date_time";
    }
    public String getFOrderStartTime(){
        return "order_start_time";
    }
    public String getFOrderEndTime(){
        return "order_end_time";
    }
    public String getFStatusRate(){
        return "status_rate";
    }
    public String getFOrderOperationNo(){
        return "order_operation_no";
    }
    public String getFOrderOperationStatus(){
        return "order_operation_status";
    }
    public String getFStatusNoCloseDayImport() {
        return "status_no_close_day_import";
    }
    public String getFOrderHome() {
        return "order_home";
    }

    public BackTPatientVisitItem(String patientVisitBillingItemId) {
        this.patientVisitBillingItemId = patientVisitBillingItemId;
    }

    public String getPatientVisitBillingItemId() {
        return patientVisitBillingItemId;
    }

    public void setPatientVisitBillingItemId(String patientVisitBillingItemId) {
        this.patientVisitBillingItemId = patientVisitBillingItemId;
    }

    public String getPatientVisitId() {
        return patientVisitId;
    }

    public void setPatientVisitId(String patientVisitId) {
        this.patientVisitId = patientVisitId;
    }

    public String getTPatientId() {
        return tPatientId;
    }

    public void setTPatientId(String tPatientId) {
        this.tPatientId = tPatientId;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getBillingInvoiceNumber() {
        return billingInvoiceNumber;
    }

    public void setBillingInvoiceNumber(String billingInvoiceNumber) {
        this.billingInvoiceNumber = billingInvoiceNumber;
    }

    public String getTBillingInvoiceDateTime() {
        return tBillingInvoiceDateTime;
    }

    public void setTBillingInvoiceDateTime(String tBillingInvoiceDateTime) {
        this.tBillingInvoiceDateTime = tBillingInvoiceDateTime;
    }

    public String getTBillingInvoiceTime() {
        return tBillingInvoiceTime;
    }

    public void setTBillingInvoiceTime(String tBillingInvoiceTime) {
        this.tBillingInvoiceTime = tBillingInvoiceTime;
    }

    public String getBillingInvoiceItemActive() {
        return billingInvoiceItemActive;
    }

    public void setBillingInvoiceItemActive(String billingInvoiceItemActive) {
        this.billingInvoiceItemActive = billingInvoiceItemActive;
    }

    public Double getBillingInvoiceItemTotal() {
        return billingInvoiceItemTotal;
    }

    public void setBillingInvoiceItemTotal(Double billingInvoiceItemTotal) {
        this.billingInvoiceItemTotal = billingInvoiceItemTotal;
    }

    public String getTBillingId() {
        return tBillingId;
    }

    public void setTBillingId(String tBillingId) {
        this.tBillingId = tBillingId;
    }

    public String getTPaymentId() {
        return tPaymentId;
    }

    public void setTPaymentId(String tPaymentId) {
        this.tPaymentId = tPaymentId;
    }

    public String getVisitVn() {
        return visitVn;
    }

    public void setVisitVn(String visitVn) {
        this.visitVn = visitVn;
    }

    public String getTOrderItemId() {
        return tOrderItemId;
    }

    public void setTOrderItemId(String tOrderItemId) {
        this.tOrderItemId = tOrderItemId;
    }

    public String getTBillingInvoiceItemId() {
        return tBillingInvoiceItemId;
    }

    public void setTBillingInvoiceItemId(String tBillingInvoiceItemId) {
        this.tBillingInvoiceItemId = tBillingInvoiceItemId;
    }

    public String getBItemId() {
        return bItemId;
    }

    public void setBItemId(String bItemId) {
        this.bItemId = bItemId;
    }

    public String getTBillingInvoiceItemNamet() {
        return tBillingInvoiceItemNamet;
    }

    public void setTBillingInvoiceItemNamet(String tBillingInvoiceItemNamet) {
        this.tBillingInvoiceItemNamet = tBillingInvoiceItemNamet;
    }

    public String getBItemBillingSubgroupId() {
        return bItemBillingSubgroupId;
    }

    public void setBItemBillingSubgroupId(String bItemBillingSubgroupId) {
        this.bItemBillingSubgroupId = bItemBillingSubgroupId;
    }

    public String getVisitPatientSelfDoctor() {
        return visitPatientSelfDoctor;
    }

    public void setVisitPatientSelfDoctor(String visitPatientSelfDoctor) {
        this.visitPatientSelfDoctor = visitPatientSelfDoctor;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentNamet() {
        return departmentNamet;
    }

    public void setDepartmentNamet(String departmentNamet) {
        this.departmentNamet = departmentNamet;
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public String getClaimNamet() {
        return claimNamet;
    }
    public void setClaimNamet(String claimNamet) {
        this.claimNamet = claimNamet;
    }
    public String getVisitHn() {
        return visitHn;
    }
    public void setVisitHn(String visitHn) {
        this.visitHn = visitHn;
    }
    public String getBranchId() {
        return branchId;
    }
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getSysStatus() {
        return sysStatus;
    }
    public void setSysStatus(String sysStatus) {
        this.sysStatus = sysStatus;
    }

    public Double getItemTotal() {
        return itemTotal;
    }
    public void setItemTotal(Double itemTotal) {
        this.itemTotal = itemTotal;
    }
    public Double getItemDiscount() {
        return itemDiscount;
    }
    public void setItemDiscount(Double itemDiscount) {
        this.itemDiscount = itemDiscount;
    }
    public Double getItemPaid() {
        return itemPaid;
    }
    public void setItemPaid(Double itemPaid) {
        this.itemPaid = itemPaid;
    }

    public String getEditStatus() {
        return editStatus;
    }
    public void setEditStatus(String editStatus) {
        this.editStatus = editStatus;
    }

    public String getItemStatusDoctor() {
        return itemStatusDoctor;
    }
    public void setItemStatusDoctor(String itemStatusDoctor) {
        this.itemStatusDoctor = itemStatusDoctor;
    }

    public String getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getFItemGroupId() {
        return fItemGroupId;
    }
    public void setFItemGroupId(String fItemGroupId) {
        this.fItemGroupId = fItemGroupId;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }
    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }
    
    //    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (patientVisitBillingItemId != null ? patientVisitBillingItemId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof BackTPatientVisitItem)) {
//            return false;
//        }
//        BackTPatientVisitItem other = (BackTPatientVisitItem) object;
//        if ((this.patientVisitBillingItemId == null && other.patientVisitBillingItemId != null) || (this.patientVisitBillingItemId != null && !this.patientVisitBillingItemId.equals(other.patientVisitBillingItemId))) {
//            return false;
//        }
//        return true;
//    }

//    @Override
//    public String toString() {
//        return "bangnaAdmin.BackTPatientVisitBillingInvoiceItem[patientVisitBillingItemId=" + patientVisitBillingItemId + "]";
//    }

}
