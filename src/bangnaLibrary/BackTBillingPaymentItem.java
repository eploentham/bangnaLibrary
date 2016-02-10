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
public class BackTBillingPaymentItem extends Persistent{
    public String billingPaymentItemId="";
    public String billingPaymentId="";
    public String billingPaymentItemActive="";
    public String remark="";
    public String patientVisitXBillingId="";
    public String patientVisitId="";
    public Double visitTotal=0.0;
    public Double amount=0.0;
    public String billingInvoiceNumber="";
    public String visitContactJoinId="";
    public String visitContactJoinNamet="";
    public String visitHn="";
    public String patientFullnamet="";
    public String patientVisitXId="";
    public String statusContactFunds = "";
    public String discountTax = "";
    public String discountPayment = "";
    public String receivePayment = "";
    public String receiveOver = "";
    public String invoiceNumber = "";
    public String injuryNumber = "";
    
    public void initial(){
        billingPaymentItemId="";
        billingPaymentId="";
        billingPaymentItemActive="";
        remark="";
        patientVisitXBillingId="";
        patientVisitId="";
        visitTotal=0.0;
        amount=0.0;
        billingInvoiceNumber="";
        visitContactJoinId="";
        visitContactJoinNamet="";
        visitHn="";
        patientFullnamet="";

    }
    public BackTBillingPaymentItem() {
    }

    public String  getBackTBillingPaymentItem() {
        return "back_t_billing_payment_item";
    }
    public String  getFBillingPaymentItemId() {
        return "billing_payment_item_id";
    }
    public String  getFBillingPaymentId() {
        return "billing_payment_id";
    }
    public String  getFBillingPaymentItemActive() {
        return "billing_payment_item_active";
    }
    public String  getFRemark() {
        return "remark";
    }
    public String  getFPatientVisitXBillingId() {
        return "patient_visit_x_billing_id";
    }
    public String  getFPatientVisitId() {
        return "patient_visit_id";
    }
    public String  getFVisitTotal() {
        return "visit_total";
    }
    public String  getFAmount() {
        return "amount";
    }
    public String  getFBillingInvoiceNumber() {
        return "billing_invoice_number";
    }
    public String  getFVisitContactJoinId() {
        return "visit_contact_join_id";
    }
    public String  getFVisitContactJoinNamet() {
        return "visit_contact_join_namet";
    }
    public String  getFVisitHn() {
        return "visit_hn";
    }
    public String  getFPatientFullnamet() {
        return "patient_fullnamet";
    }
    public String  getFPatientVisitXId() {
        return "patient_visit_x_id";
    }
    public String  getFStatusContactFunds() {
        return "status_contact_funds";
    }
    public String  getFDiscountTax() {
        return "discount_tax";
    }
    public String  getFDiscountPayment() {
        return "discount_payment";
    }
    public String  getFReceivePayment() {
        return "receive_payment";
    }
    public String  getFReceiveOver() {
        return "receive_over";
    }
    public String  getFInvoiceNumber() {
        return "invoice_number";
    }
    public String  getFInjuryNumber() {
        return "injury_number";
    }

    public BackTBillingPaymentItem(String billingPaymentIdItem) {
        this.billingPaymentItemId = billingPaymentIdItem;
    }

    public String getBillingPaymentItemId() {
        return billingPaymentItemId;
    }

    public void setBillingPaymentItemId(String billingPaymentItemId) {
        this.billingPaymentItemId = billingPaymentItemId;
    }

    public String getBillingPaymentId() {
        return billingPaymentId;
    }

    public void setBillingPaymentId(String billingPaymentId) {
        this.billingPaymentId = billingPaymentId;
    }

    public String getBillingPaymentItemActive() {
        return billingPaymentItemActive;
    }

    public void setBillingPaymentItemActive(String billingPaymentItemActive) {
        this.billingPaymentItemActive = billingPaymentItemActive;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPatientVisitXBillingId() {
        return patientVisitXBillingId;
    }

    public void setPatientVisitXBillingId(String patientVisitXBillingId) {
        this.patientVisitXBillingId = patientVisitXBillingId;
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
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getBillingInvoiceNumber() {
        return billingInvoiceNumber;
    }
    public void setBillingInvoiceNumber(String billingInvoiceNumber) {
        this.billingInvoiceNumber = billingInvoiceNumber;
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

    public String getVisitHn() {
        return visitHn;
    }
    public void setVisitHn(String visitHn) {
        this.visitHn = visitHn;
    }

    public String getPatientFullnamet() {
        return patientFullnamet;
    }
    public void setPatientFullnamet(String patientFullnamet) {
        this.patientFullnamet = patientFullnamet;
    }

    public String getPatientVisitXId() {
        return patientVisitXId;
    }
    public void setPatientVisitXId(String patientVisitXId) {
        this.patientVisitXId = patientVisitXId;
    }

}
