/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "t_billing_invoice", catalog = "front_bangna3", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TBillingInvoice.findAll", query = "SELECT t FROM TBillingInvoice t"),
    @NamedQuery(name = "TBillingInvoice.findByTBillingInvoiceId", query = "SELECT t FROM TBillingInvoice t WHERE t.tBillingInvoiceId = :tBillingInvoiceId"),
    @NamedQuery(name = "TBillingInvoice.findByTPatientId", query = "SELECT t FROM TBillingInvoice t WHERE t.tPatientId = :tPatientId"),
    @NamedQuery(name = "TBillingInvoice.findByTVisitId", query = "SELECT t FROM TBillingInvoice t WHERE t.tVisitId = :tVisitId"),
    @NamedQuery(name = "TBillingInvoice.findByBillingInvoiceNumber", query = "SELECT t FROM TBillingInvoice t WHERE t.billingInvoiceNumber = :billingInvoiceNumber"),
    @NamedQuery(name = "TBillingInvoice.findByTBillingInvoiceDateTime", query = "SELECT t FROM TBillingInvoice t WHERE t.tBillingInvoiceDateTime = :tBillingInvoiceDateTime"),
    @NamedQuery(name = "TBillingInvoice.findByBillingInvoiceDeposit", query = "SELECT t FROM TBillingInvoice t WHERE t.billingInvoiceDeposit = :billingInvoiceDeposit"),
    @NamedQuery(name = "TBillingInvoice.findByTPaymentId", query = "SELECT t FROM TBillingInvoice t WHERE t.tPaymentId = :tPaymentId"),
    @NamedQuery(name = "TBillingInvoice.findByBillingInvoiceActive", query = "SELECT t FROM TBillingInvoice t WHERE t.billingInvoiceActive = :billingInvoiceActive"),
    @NamedQuery(name = "TBillingInvoice.findByBillingInvoiceQuantity", query = "SELECT t FROM TBillingInvoice t WHERE t.billingInvoiceQuantity = :billingInvoiceQuantity"),
    @NamedQuery(name = "TBillingInvoice.findByTBillingId", query = "SELECT t FROM TBillingInvoice t WHERE t.tBillingId = :tBillingId"),
    @NamedQuery(name = "TBillingInvoice.findByBillingInvoiceComplete", query = "SELECT t FROM TBillingInvoice t WHERE t.billingInvoiceComplete = :billingInvoiceComplete"),
    @NamedQuery(name = "TBillingInvoice.findByBillingInvoicePatientShare", query = "SELECT t FROM TBillingInvoice t WHERE t.billingInvoicePatientShare = :billingInvoicePatientShare"),
    @NamedQuery(name = "TBillingInvoice.findByBillingInvoicePayerShare", query = "SELECT t FROM TBillingInvoice t WHERE t.billingInvoicePayerShare = :billingInvoicePayerShare"),
    @NamedQuery(name = "TBillingInvoice.findByBillingInvoiceTotal", query = "SELECT t FROM TBillingInvoice t WHERE t.billingInvoiceTotal = :billingInvoiceTotal"),
    @NamedQuery(name = "TBillingInvoice.findByBillingInvoiceStaffRecord", query = "SELECT t FROM TBillingInvoice t WHERE t.billingInvoiceStaffRecord = :billingInvoiceStaffRecord"),
    @NamedQuery(name = "TBillingInvoice.findByBillingInvoicePatientShareCeil", query = "SELECT t FROM TBillingInvoice t WHERE t.billingInvoicePatientShareCeil = :billingInvoicePatientShareCeil"),
    @NamedQuery(name = "TBillingInvoice.findByBillingInvoicePayerShareCeil", query = "SELECT t FROM TBillingInvoice t WHERE t.billingInvoicePayerShareCeil = :billingInvoicePayerShareCeil"),
    @NamedQuery(name = "TBillingInvoice.findByCloseday", query = "SELECT t FROM TBillingInvoice t WHERE t.closeday = :closeday")})
public class TBillingInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "t_billing_invoice_id", nullable = false, length = 255)
    private String tBillingInvoiceId="";
    @Column(name = "t_patient_id", length = 255)
    private String tPatientId="";
    @Column(name = "t_visit_id", length = 255)
    private String tVisitId="";
    @Column(name = "billing_invoice_number", length = 255)
    private String billingInvoiceNumber="";
    @Column(name = "t_billing_invoice_date_time", length = 255)
    private String tBillingInvoiceDateTime="";
    @Column(name = "billing_invoice_deposit", length = 255)
    private String billingInvoiceDeposit="";
    @Column(name = "t_payment_id", length = 255)
    private String tPaymentId="";
    @Column(name = "billing_invoice_active", length = 255)
    private String billingInvoiceActive="";
    @Column(name = "billing_invoice_quantity", length = 255)
    private String billingInvoiceQuantity="";
    @Column(name = "t_billing_id", length = 255)
    private String tBillingId="";
    @Column(name = "billing_invoice_complete", length = 255)
    private String billingInvoiceComplete="";
    @Column(name = "billing_invoice_patient_share", precision = 17, scale = 17)
    private Double billingInvoicePatientShare=0.0;
    @Column(name = "billing_invoice_payer_share", precision = 17, scale = 17)
    private Double billingInvoicePayerShare=0.0;
    @Column(name = "billing_invoice_total", precision = 17, scale = 17)
    private Double billingInvoiceTotal=0.0;
    @Column(name = "billing_invoice_staff_record", length = 255)
    private String billingInvoiceStaffRecord="";
    @Column(name = "billing_invoice_patient_share_ceil", length = 255)
    private String billingInvoicePatientShareCeil="";
    @Column(name = "billing_invoice_payer_share_ceil", length = 255)
    private String billingInvoicePayerShareCeil="";
    @Column(name = "closeday", length = 255)
    private String closeday="";
    @Column(name = "status_export", length = 255)
    private String statusExport="";

    public TBillingInvoice() {
    }
    public void initial(){
        tBillingInvoiceId="";
        tPatientId="";
        tVisitId="";
        billingInvoiceNumber="";
        tBillingInvoiceDateTime="";
        billingInvoiceDeposit="";
        tPaymentId="";
        billingInvoiceActive="";
        billingInvoiceQuantity="";
        tBillingId="";
        billingInvoiceComplete="";
        billingInvoicePatientShare=0.0;
        billingInvoicePayerShare=0.0;
        billingInvoiceTotal=0.0;
        billingInvoiceStaffRecord="";
        billingInvoicePatientShareCeil="";
        billingInvoicePayerShareCeil="";
        closeday="";
        statusExport="";
    }
    public String getTBillingInvoice(){
        return "t_billing_invoice";
    }
    public String getFTBillingInvoiceId(){
        return "t_billing_invoice_id";
    }
    public String getFTPatientId(){
        return "t_patient_id";
    }
    public String getFIVisitId(){
        return "t_visit_id";
    }
    public String getFBillingInvoiceNumber(){
        return "billing_invoice_number";
    }
    public String getFTBillingInvoiceDateTime(){
        return "t_billing_invoice_date_time";
    }
    public String getFBillingInvoiceDeposit(){
        return "billing_invoice_deposit";
    }
    public String getFTPaymentId(){
        return "t_payment_id";
    }
    public String getFBillingInvoiceActive(){
        return "billing_invoice_active";
    }
    public String getFBillingInvoiceQuantity(){
        return "billing_invoice_quantity";
    }
    public String getFTBillingId(){
        return "t_billing_id";
    }
    public String getFBillingInvoiceComplete(){
        return "billing_invoice_complete";
    }
    public String getFBillingInvoicePatientShare(){
        return "billing_invoice_patient_share";
    }
    public String getFBillingInvoicePayerShare(){
        return "billing_invoice_payer_share";
    }
    public String getFBillingInvoiceTotal(){
        return "billing_invoice_total";
    }
    public String getFBillingInvoiceStaffRecord(){
        return "billing_invoice_staff_record";
    }
    public String getFBillingInvoicePatientShareCeil(){
        return "billing_invoice_patient_share_ceil";
    }
    public String getFBillingInvoicePayerShareCeil(){
        return "billing_invoice_payer_share_ceil";
    }
    public String getFCloseDayId(){
        return "close_day_id";
    }
    public String getFStatusExport(){
        return "status_export";
    }

    public TBillingInvoice(String tBillingInvoiceId) {
        this.tBillingInvoiceId = tBillingInvoiceId;
    }

    public String getTBillingInvoiceId() {
        return tBillingInvoiceId;
    }

    public void setTBillingInvoiceId(String tBillingInvoiceId) {
        this.tBillingInvoiceId = tBillingInvoiceId;
    }

    public String getTPatientId() {
        return tPatientId;
    }

    public void setTPatientId(String tPatientId) {
        this.tPatientId = tPatientId;
    }

    public String getTVisitId() {
        return tVisitId;
    }

    public void setTVisitId(String tVisitId) {
        this.tVisitId = tVisitId;
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

    public String getBillingInvoiceDeposit() {
        return billingInvoiceDeposit;
    }

    public void setBillingInvoiceDeposit(String billingInvoiceDeposit) {
        this.billingInvoiceDeposit = billingInvoiceDeposit;
    }

    public String getTPaymentId() {
        return tPaymentId;
    }

    public void setTPaymentId(String tPaymentId) {
        this.tPaymentId = tPaymentId;
    }

    public String getBillingInvoiceActive() {
        return billingInvoiceActive;
    }

    public void setBillingInvoiceActive(String billingInvoiceActive) {
        this.billingInvoiceActive = billingInvoiceActive;
    }

    public String getBillingInvoiceQuantity() {
        return billingInvoiceQuantity;
    }

    public void setBillingInvoiceQuantity(String billingInvoiceQuantity) {
        this.billingInvoiceQuantity = billingInvoiceQuantity;
    }

    public String getTBillingId() {
        return tBillingId;
    }

    public void setTBillingId(String tBillingId) {
        this.tBillingId = tBillingId;
    }

    public String getBillingInvoiceComplete() {
        return billingInvoiceComplete;
    }

    public void setBillingInvoiceComplete(String billingInvoiceComplete) {
        this.billingInvoiceComplete = billingInvoiceComplete;
    }

    public Double getBillingInvoicePatientShare() {
        return billingInvoicePatientShare;
    }

    public void setBillingInvoicePatientShare(Double billingInvoicePatientShare) {
        this.billingInvoicePatientShare = billingInvoicePatientShare;
    }

    public Double getBillingInvoicePayerShare() {
        return billingInvoicePayerShare;
    }

    public void setBillingInvoicePayerShare(Double billingInvoicePayerShare) {
        this.billingInvoicePayerShare = billingInvoicePayerShare;
    }

    public Double getBillingInvoiceTotal() {
        return billingInvoiceTotal;
    }

    public void setBillingInvoiceTotal(Double billingInvoiceTotal) {
        this.billingInvoiceTotal = billingInvoiceTotal;
    }

    public String getBillingInvoiceStaffRecord() {
        return billingInvoiceStaffRecord;
    }

    public void setBillingInvoiceStaffRecord(String billingInvoiceStaffRecord) {
        this.billingInvoiceStaffRecord = billingInvoiceStaffRecord;
    }

    public String getBillingInvoicePatientShareCeil() {
        return billingInvoicePatientShareCeil;
    }

    public void setBillingInvoicePatientShareCeil(String billingInvoicePatientShareCeil) {
        this.billingInvoicePatientShareCeil = billingInvoicePatientShareCeil;
    }

    public String getBillingInvoicePayerShareCeil() {
        return billingInvoicePayerShareCeil;
    }

    public void setBillingInvoicePayerShareCeil(String billingInvoicePayerShareCeil) {
        this.billingInvoicePayerShareCeil = billingInvoicePayerShareCeil;
    }

    public String getCloseday() {
        return closeday;
    }
    public void setCloseday(String closeday) {
        this.closeday = closeday;
    }
    public String getStatusExport() {
        return statusExport;
    }
    public void setStatusExport(String statusExport) {
        this.statusExport = statusExport;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tBillingInvoiceId != null ? tBillingInvoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TBillingInvoice)) {
            return false;
        }
        TBillingInvoice other = (TBillingInvoice) object;
        if ((this.tBillingInvoiceId == null && other.tBillingInvoiceId != null) || (this.tBillingInvoiceId != null && !this.tBillingInvoiceId.equals(other.tBillingInvoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.TBillingInvoice[tBillingInvoiceId=" + tBillingInvoiceId + "]";
    }

}
