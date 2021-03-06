/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bangna.object;

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
public class BackTPatientVisitContactBilling extends Persistent{
    public String patientVisitContactBillingId="";
    public String patientVisitContactId="";
    public String billingInvoiceNumber="";
    public String visitHn="";
    public String visitVn="";
    public String visitDate="";
    public String visitBeginVisitTime="";
    public String patientFullnamet="";
    public String visitClaimId="";
    public String visitPaidId="";
    public String visitFinancialDischargeTime="";
    public String visitNotice="";
    public String visitDiagnosisNotice="";
    public String bVisitClinicId="";
    public String visitFirstVisit="";
    public String visitHospitalService="";
    public String visitPatientSelfDoctor="";
    public String bServicePointId="";
    public String visitPatientAge="";
    public String tPatientId="";
    public String visitClaimNamet="";
    public String visitPaidNamet="";
    public String patientImportId="";
    public String doctorNamet="";
    public String departmentNamet="";
    public String branchId="";
    public String sysStatus="";
    public String patientVisitId="";
    public Double visitTotal=0.0;
    public Double visitDiscount=0.0;
    public Double visitPaid=0.0;
    public String visitContactId="";
    public String visitContactNamet="";
    public String billingCoverNumber="";
    public String statusPrint="";
    public String statusPayment="";
    public String patientVisitContactBillingActive="";
    public String contractPayerNumber="";
    public String visitContactJoinId="";
    public String visitContactJoinNamet="";
    public String sickness="";
    public String invoiceNumber="";
    public String receiptNumber="";
    public String visitTotalBaht="";
    public String closeDayDate="";
    public String billingPaymentItemId="";
    public String patientVisitContactBillingDate="";
    public Double receiveAmount=0.0;
    public String statusDebtorVoid="0";
    public String injuryNumber="";
    public String insuranceNumber="";
    public Double discountTax=0.0;
    public Double discountPayment=0.0;
    public Double receiveOver=0.0;
    public Double amountCover=0.0;

    public BackTPatientVisitContactBilling() {
        
    }
      public String getBackTPatientVisitContactBilling() {
        return "back_t_patient_visit_contact_billing";
      }
      public String getFPatientVisitContactBillingId() {
        return "patient_visit_contact_billing_id";
      }
      public String getFPatientVisitContactId() {
        return "patient_visit_contact_id";
      }
      public String getFBillingInvoiceNumber() {
        return "billing_invoice_number";
      }
      public String getFVisitHn() {
        return "visit_hn";
      }
      public String getFVisitVn() {
        return "visit_vn";
      }
      public String getFVisitDate() {
        return "visit_date";
      }
      public String getFVisitBeginVisitTime() {
        return "visit_begin_visit_time";
      }
      public String getFPatientFullnamet() {
        return "patient_fullnamet";
      }
      public String getFVisitClaimId() {
        return "visit_claim_id";
      }
      public String getFVisitPaidId() {
        return "visit_paid_id";
      }
      public String getFVisitFinancialDischargeTime() {
        return "visit_financial_discharge_time";
      }
      public String getFVisitNotice() {
        return "visit_notice";
      }
      public String getFVisitDiagnosisNotice() {
        return "visit_diagnosis_notice";
      }
      public String getFBVisitClinicId() {
        return "b_visit_clinic_id";
      }
      public String getFVisitFirstVisit() {
        return "visit_first_visit";
      }
      public String getFVisitHospitalService() {
        return "visit_hospital_service";
      }
      public String getFVisitPatientSelfDoctor() {
        return "visit_patient_self_doctor";
      }
      public String getFBServicePointId() {
        return "b_service_point_id";
      }
      public String getFVisitPatientAge() {
        return "visit_patient_age";
      }
      public String getFTPatientId() {
        return "t_patient_id";
      }
      public String getFVisitClaimNamet() {
        return "visit_claim_namet";
      }
      public String getFVisitPaidNamet() {
        return "visit_paid_namet";
      }
      public String getFPatientImportId() {
        return "patient_import_id";
      }
      public String getFDoctorNamet() {
        return "doctor_namet";
      }
      public String getFDepartmentNamet() {
        return "department_namet";
      }
      public String getFBranchId() {
        return "branch_id";
      }
      public String getFSysStatus() {
        return "sys_status";
      }
      public String getFPatientVisitId() {
        return "patient_visit_id";
      }
      public String getFVisitTotal() {
        return "visit_total";
      }
      public String getFVisitDiscount() {
        return "visit_discount";
      }
      public String getFVisitPaid() {
        return "visit_paid";
      }
      public String getFVisitContactId() {
        return "visit_contact_id";
      }
      public String getFVisitContactNamet() {
        return "visit_contact_namet";
      }
      public String getFBillingCoverNumber() {
        return "billing_cover_number";
      }
      public String getFStatusPrint() {
        return "status_print";
      }
      public String getFStatusPayment() {
        return "status_payment";
      }
      public String getFPatientVisitContactBillingActive() {
        return "patient_visit_contact_billing_active";
      }
      public String getFVisitContactJoinId() {
        return "visit_contact_join_id";
      }
      public String getFVisitContactJoinNamet() {
        return "visit_contact_join_namet";
      }
      public String getFSickness() {
        return "sickness";
      }
      public String getFInvoiceNumber() {
        return "invoice_number";
      }
      public String getFReceiptNumber() {
        return "receipt_number";
      }
      public String getFVisitTotalBaht() {
        return "visit_total_baht";
      }
      public String getFBillingPaymentItemId() {
        return "billing_payment_item_id";
      }
      public String getFPatientCisitContactBillingDate() {
        return "patient_visit_contact_billing_date";
      }
      public String getFReceiveAmount() {
        return "receive_amount";
      }
      public String getFCloseDayDate() {
        return "close_day_date";
      }
      public String getFStatusDebtorVoid() {
        return "status_debtor_void";
      }
    public String getFReceiveDate() {
        return "receive_date";
    }
    public String getFVoidPaymentDate() {
        return "void_payment_date";
    }
    public String getFInjuryNumber() {
        return "injury_number";
    }
    public String getFInsuranceNumber() {
        return "insurance_number";
    }
    public String getFDiscountTax() {
        return "discount_tax";
    }
    public String getFDiscountPayment() {
        return "discount_payment";
    }
    public String getFReceiveOver() {
        return "receive_over";
    }
    public String getFAmountCover() {
        return "amount_cover";
    }

    public BackTPatientVisitContactBilling(String patientVisitContactBillingId) {
        this.patientVisitContactBillingId = patientVisitContactBillingId;
    }

    public String getPatientVisitContactBillingId() {
        return patientVisitContactBillingId;
    }

    public void setPatientVisitContactBillingId(String patientVisitContactBillingId) {
        this.patientVisitContactBillingId = patientVisitContactBillingId;
    }

    public String getPatientVisitContactId() {
        return patientVisitContactId;
    }

    public void setPatientVisitContactId(String patientVisitContactId) {
        this.patientVisitContactId = patientVisitContactId;
    }

    public String getBillingInvoiceNumber() {
        return billingInvoiceNumber;
    }

    public void setBillingInvoiceNumber(String billingInvoiceNumber) {
        this.billingInvoiceNumber = billingInvoiceNumber;
    }

    public String getVisitHn() {
        return visitHn;
    }

    public void setVisitHn(String visitHn) {
        this.visitHn = visitHn;
    }

    public String getVisitVn() {
        return visitVn;
    }

    public void setVisitVn(String visitVn) {
        this.visitVn = visitVn;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitBeginVisitTime() {
        return visitBeginVisitTime;
    }

    public void setVisitBeginVisitTime(String visitBeginVisitTime) {
        this.visitBeginVisitTime = visitBeginVisitTime;
    }

    public String getPatientFullnamet() {
        return patientFullnamet;
    }

    public void setPatientFullnamet(String patientFullnamet) {
        this.patientFullnamet = patientFullnamet;
    }

    public String getVisitClaimId() {
        return visitClaimId;
    }

    public void setVisitClaimId(String visitClaimId) {
        this.visitClaimId = visitClaimId;
    }

    public String getVisitPaidId() {
        return visitPaidId;
    }

    public void setVisitPaidId(String visitPaidId) {
        this.visitPaidId = visitPaidId;
    }

    public String getVisitFinancialDischargeTime() {
        return visitFinancialDischargeTime;
    }

    public void setVisitFinancialDischargeTime(String visitFinancialDischargeTime) {
        this.visitFinancialDischargeTime = visitFinancialDischargeTime;
    }

    public String getVisitNotice() {
        return visitNotice;
    }

    public void setVisitNotice(String visitNotice) {
        this.visitNotice = visitNotice;
    }

    public String getVisitDiagnosisNotice() {
        return visitDiagnosisNotice;
    }

    public void setVisitDiagnosisNotice(String visitDiagnosisNotice) {
        this.visitDiagnosisNotice = visitDiagnosisNotice;
    }

    public String getBVisitClinicId() {
        return bVisitClinicId;
    }

    public void setBVisitClinicId(String bVisitClinicId) {
        this.bVisitClinicId = bVisitClinicId;
    }

    public String getVisitFirstVisit() {
        return visitFirstVisit;
    }

    public void setVisitFirstVisit(String visitFirstVisit) {
        this.visitFirstVisit = visitFirstVisit;
    }

    public String getVisitHospitalService() {
        return visitHospitalService;
    }

    public void setVisitHospitalService(String visitHospitalService) {
        this.visitHospitalService = visitHospitalService;
    }

    public String getVisitPatientSelfDoctor() {
        return visitPatientSelfDoctor;
    }

    public void setVisitPatientSelfDoctor(String visitPatientSelfDoctor) {
        this.visitPatientSelfDoctor = visitPatientSelfDoctor;
    }

    public String getBServicePointId() {
        return bServicePointId;
    }

    public void setBServicePointId(String bServicePointId) {
        this.bServicePointId = bServicePointId;
    }

    public String getVisitPatientAge() {
        return visitPatientAge;
    }

    public void setVisitPatientAge(String visitPatientAge) {
        this.visitPatientAge = visitPatientAge;
    }

    public String getTPatientId() {
        return tPatientId;
    }

    public void setTPatientId(String tPatientId) {
        this.tPatientId = tPatientId;
    }

    public String getVisitClaimNamet() {
        return visitClaimNamet;
    }

    public void setVisitClaimNamet(String visitClaimNamet) {
        this.visitClaimNamet = visitClaimNamet;
    }

    public String getVisitPaidNamet() {
        return visitPaidNamet;
    }

    public void setVisitPaidNamet(String visitPaidNamet) {
        this.visitPaidNamet = visitPaidNamet;
    }

    public String getPatientImportId() {
        return patientImportId;
    }

    public void setPatientImportId(String patientImportId) {
        this.patientImportId = patientImportId;
    }

    public String getDoctorNamet() {
        return doctorNamet;
    }

    public void setDoctorNamet(String doctorNamet) {
        this.doctorNamet = doctorNamet;
    }

    public String getDepartmentNamet() {
        return departmentNamet;
    }

    public void setDepartmentNamet(String departmentNamet) {
        this.departmentNamet = departmentNamet;
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

    public String getPatientVisitId() {
        return patientVisitId;
    }

    public void setPatientVisitId(String patientVisitId) {
        this.patientVisitId = patientVisitId;
    }

    public Double getVisitTotal() {
        return visitTotal;
    }

    public void setVisitTotal(Double visitTotal) {
        this.visitTotal = visitTotal;
    }

    public Double getVisitDiscount() {
        return visitDiscount;
    }

    public void setVisitDiscount(Double visitDiscount) {
        this.visitDiscount = visitDiscount;
    }

    public Double getVisitPaid() {
        return visitPaid;
    }

    public void setVisitPaid(Double visitPaid) {
        this.visitPaid = visitPaid;
    }

    public String getVisitContactId() {
        return visitContactId;
    }

    public void setVisitContactId(String visitContactId) {
        this.visitContactId = visitContactId;
    }

    public String getVisitContactNamet() {
        return visitContactNamet;
    }

    public void setVisitContactNamet(String visitContactNamet) {
        this.visitContactNamet = visitContactNamet;
    }

    public String getBillingCoverNumber() {
        return billingCoverNumber;
    }

    public void setBillingCoverNumber(String billingCoverNumber) {
        this.billingCoverNumber = billingCoverNumber;
    }

    public String getStatusPrint() {
        return statusPrint;
    }

    public void setStatusPrint(String statusPrint) {
        this.statusPrint = statusPrint;
    }

    public String getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(String statusPayment) {
        this.statusPayment = statusPayment;
    }

    public String getPatientVisitContactBillingActive() {
        return patientVisitContactBillingActive;
    }

    public void setPatientVisitContactBillingActive(String patientVisitContactBillingActive) {
        this.patientVisitContactBillingActive = patientVisitContactBillingActive;
    }

    public String getContractPayerNumber() {
        return contractPayerNumber;
    }

    public void setContractPayerNumber(String contractPayerNumber) {
        this.contractPayerNumber = contractPayerNumber;
    }

    public String getVisitContactJoinId() {
        return visitContactJoinId;
    }

    public void setVisitContactJoinId(String visitContactJoinId) {
        this.visitContactJoinId = visitContactJoinId;
    }

    public String getVisitContactJoinNamet() {
        return visitContactJoinNamet;
    }

    public void setVisitContactJoinNamet(String visitContactJoinNamet) {
        this.visitContactJoinNamet = visitContactJoinNamet;
    }

    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getVisitTotalBaht() {
        return visitTotalBaht;
    }
    public void setVisitTotalBaht(String visitTotalBaht) {
        this.visitTotalBaht = visitTotalBaht;
    }

    public String getCloseDayDate() {
        return closeDayDate;
    }
    public void setCloseDayDate(String closeDayDate) {
        this.closeDayDate = closeDayDate;
    }

    public String getBillingPaymentItemId() {
        return billingPaymentItemId;
    }
    public void setBillingPaymentItemId(String billingPaymentItemId) {
        this.billingPaymentItemId = billingPaymentItemId;
    }

    public String getPatientVisitContactBillingDate() {
        return patientVisitContactBillingDate;
    }
    public void setPatientVisitContactBillingDate(String patientVisitContactBillingDate) {
        this.patientVisitContactBillingDate = patientVisitContactBillingDate;
    }

    public Double getReceiveAmount() {
        return receiveAmount;
    }
    public void setReceiveAmount(Double receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (patientVisitContactBillingId != null ? patientVisitContactBillingId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof BackTPatientVisitContactBilling)) {
//            return false;
//        }
//        BackTPatientVisitContactBilling other = (BackTPatientVisitContactBilling) object;
//        if ((this.patientVisitContactBillingId == null && other.patientVisitContactBillingId != null) || (this.patientVisitContactBillingId != null && !this.patientVisitContactBillingId.equals(other.patientVisitContactBillingId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "bangnaLibrary.BackTPatientVisitContactBilling[patientVisitContactBillingId=" + patientVisitContactBillingId + "]";
//    }

}
