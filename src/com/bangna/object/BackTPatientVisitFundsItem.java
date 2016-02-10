/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bangna.object;

import com.bangna.usecase.connection.Persistent;

/**
 *
 * @author root
 */
public class BackTPatientVisitFundsItem extends Persistent{
    public String patientVisitFundsItemId="";
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
    public String patientVisitItemId="";
    public String itemNametEditStatus="";
    public String recordStatus="";
    public Double itemTotal=0.0;
    public Double itemDiscount=0.0;
    public Double itemPaid=0.0;
    public String patientVisitFundsId="";
    public Double itemTotalOrginal=0.0;
    public String fItemGroupId="";
    public String itemNametEdit="";
    public Double itemTotalEdit=0.0;
    public String itemTotalEditStatus="";
    public String injuryNumber="";
    public String doctorId="";
    public String doctorNamet="";
    public String orderHome="";

    public BackTPatientVisitFundsItem() {
    }
    public void initial(){
        new BackTPatientVisitFundsItem();
        patientVisitFundsItemId="";
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
        patientVisitItemId="";
        itemNametEditStatus="";
        recordStatus="";
        itemTotal=0.0;
        itemDiscount=0.0;
        itemPaid=0.0;
        patientVisitFundsId="";
        itemTotalOrginal=0.0;
        fItemGroupId="";
        itemNametEdit="";
        itemTotalEdit=0.0;
        itemTotalEditStatus="";
        injuryNumber="";
        orderHome="";

    }

    public String getBackTPatientVisitFundsItem() {
        return "back_t_patient_visit_funds_item";
    }
    public String getFPatientVisitFundsItemId() {
        return "patient_visit_funds_item_id";
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
        return "departmnet_id";
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
    public String getFBranchId() {
        return "branch_id";
    }
    public String getFSysStatus() {
        return "sys_status";
    }
    public String getFPatientVisitItemId() {
        return "patient_visit_item_id";
    }
    public String getFItemTotal() {
        return "item_total";
    }
    public String getFItemDiscount() {
        return "item_discount";
    }
    public String getFItemPaid() {
        return "item_paid";
    }
    public String getFItemNametEditStatus() {
        return "item_namet_edit_status";
    }
    public String getFRecordStatus() {
        return "record_status";
    }
    public String getFPatientVisitFundsId() {
        return "patient_visit_funds_id";
    }
    public String getFStatusPrint() {
        return "status_print";
    }
    public String getFStatusPayment() {
        return "status_payment";
    }
    public String getFItemTotalOrginal() {
        return "item_total_orginal";
    }
    public String getFFItemGroupId() {
        return "f_item_group_id";
    }
    public String getFItemNametEdit() {
        return "item_namet_edit";
    }
    public String getFItemTotalEdit() {
        return "item_total_edit";
    }
    public String getFItemTotalEditStatus() {
        return "item_total_edit_status";
    }
    public String getFInjuryNumber() {
        return "injury_number";
    }
    public String getFDoctorId() {
        return "doctor_id";
    }
    public String getFDoctorNamet() {
        return "doctor_namet";
    }
    public String getFOrderHome(){
        return  "order_home";
    }

    public BackTPatientVisitFundsItem(String patientVisitFundsItemId) {
        this.patientVisitFundsItemId = patientVisitFundsItemId;
    }

    public String getPatientVisitFundsItemId() {
        return patientVisitFundsItemId;
    }

    public void setPatientVisitFundsItemId(String patientVisitFundsItemId) {
        this.patientVisitFundsItemId = patientVisitFundsItemId;
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

    public String getPatientVisitItemId() {
        return patientVisitItemId;
    }

    public void setPatientVisitItemId(String patientVisitItemId) {
        this.patientVisitItemId = patientVisitItemId;
    }

    public String getItemNametEditStatus() {
        return itemNametEditStatus;
    }

    public void setItemNametEditStatus(String itemNametEditStatus) {
        this.itemNametEditStatus = itemNametEditStatus;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
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

    public String getPatientVisitFundsId() {
        return patientVisitFundsId;
    }

    public void setPatientVisitFundsId(String patientVisitFundsId) {
        this.patientVisitFundsId = patientVisitFundsId;
    }

    public Double getItemTotalOrginal() {
        return itemTotalOrginal;
    }

    public void setItemTotalOrginal(Double itemTotalOrginal) {
        this.itemTotalOrginal = itemTotalOrginal;
    }

    public String getFItemGroupId() {
        return fItemGroupId;
    }

    public void setFItemGroupId(String fItemGroupId) {
        this.fItemGroupId = fItemGroupId;
    }

    public String getItemNametEdit() {
        return itemNametEdit;
    }

    public void setItemNametEdit(String itemNametEdit) {
        this.itemNametEdit = itemNametEdit;
    }

    public Double getItemTotalEdit() {
        return itemTotalEdit;
    }

    public void setItemTotalEdit(Double itemTotalEdit) {
        this.itemTotalEdit = itemTotalEdit;
    }

    public String getItemTotalEditStatus() {
        return itemTotalEditStatus;
    }
    public void setItemTotalEditStatus(String itemTotalEditStatus) {
        this.itemTotalEditStatus = itemTotalEditStatus;
    }

    public String getInjuryNumber() {
        return injuryNumber;
    }
    public void setInjuryNumber(String injuryNumber) {
        this.injuryNumber = injuryNumber;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (patientVisitFundsItemId != null ? patientVisitFundsItemId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof BackTPatientVisitFundsItem)) {
//            return false;
//        }
//        BackTPatientVisitFundsItem other = (BackTPatientVisitFundsItem) object;
//        if ((this.patientVisitFundsItemId == null && other.patientVisitFundsItemId != null) || (this.patientVisitFundsItemId != null && !this.patientVisitFundsItemId.equals(other.patientVisitFundsItemId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "bangnaLibrary.BackTPatientVisitFundsItem[patientVisitFundsItemId=" + patientVisitFundsItemId + "]";
//    }

}
