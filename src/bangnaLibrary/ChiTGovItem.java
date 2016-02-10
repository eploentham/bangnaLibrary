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
@Table(name = "chi_t_gov_item")
@NamedQueries({
    @NamedQuery(name = "ChiTGovItem.findAll", query = "SELECT c FROM ChiTGovItem c")})
public class ChiTGovItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "chi_gov_item_id")
    private String chiGovItemId="";
    @Basic(optional = false)
    @Column(name = "chi_gov_id")
    private String chiGovId;
    @Column(name = "visit_hn")
    private String visitHn="";
    @Column(name = "visit_id")
    private String visitId="";
    @Column(name = "visit_vn")
    private String visitVn="";
    @Column(name = "patient_fullnamet")
    private String patientFullnamet="";
    @Column(name = "status_chi")
    private String statusChi="";
    @Column(name = "chi_gov_item_active")
    private String chiGovItemActive="";
    @Column(name = "visit_total")
    private Double visitTotal=0.0;
    @Column(name = "chi_paid")
    private Double chiPaid=0.0;
    @Column(name = "remark_chi_gov")
    private String remarkChiGov="";
    @Column(name = "remark_chi")
    private String remarkChi="";
    @Column(name = "chi_gov_item_date")
    private String chiGovItemDate="";
    @Column(name = "paid_id")
    private String paidId="";
    @Column(name = "auth_code")
    private String authCode="";
    @Column(name = "auth_dt")
    private String authDt="";
    @Column(name = "t_visit_payment_id")
    private String tVisitPaymentId="";
    @Column(name = "visit_an")
    private String visitAn="";
    @Column(name = "pid")
    private String pid="";
    @Column(name = "surcharge_id")
    private String surchargeId="";
    @Column(name = "admit_day")
    private Double admitDay=0.0;

    public ChiTGovItem() {
    }
    public String getChiTGovItem() {
        return "chi_t_gov_item";
    }
    public String getFChiGovItemId() {
        return "chi_gov_item_id";
    }
    public String getFChiGovId() {
        return "chi_gov_id";
    }
    public String getFVisitHn() {
        return "visit_hn";
    }
    public String getFVisitVn() {
        return "visit_vn";
    }
    public String getFVisitId() {
        return "visit_id";
    }
    public String getFPatientFullnamet() {
        return "patient_fullnamet";
    }
    public String getFStatusChi() {
        return "status_chi";
    }
    public String getFChiGovItemActive() {
        return "chi_gov_item_active";
    }
    public String getFVisitTotal() {
        return "visit_total";
    }
    public String getFChiPaid() {
        return "chi_paid";
    }
    public String getFRemarkChiGov() {
        return "remark_chi_gov";
    }
    public String getFRemarkChi() {
        return "remark_chi";
    }
    public String getFChiGovItemDate() {
        return "chi_gov_item_date";
    }
    public String getFPaidId() {
        return "paid_id";
    }
    public String getFAuthCode() {
        return "auth_code";
    }
    public String getFAuthDt() {
        return "auth_dt";
    }
    public String getFTVisitPaymentId() {
        return "t_visit_payment_id";
    }
    public String getFVisitAn() {
        return "visit_an";
    }
    public String getFPid() {
        return "pid";
    }
    public String getFSurchargeId() {
        return "surcharge_id";
    }
    public String getFAdmitDay() {
        return "admit_day";
    }

    public ChiTGovItem(String chiGovItemId) {
        this.chiGovItemId = chiGovItemId;
    }

    public ChiTGovItem(String chiGovItemId, String chiGovId) {
        this.chiGovItemId = chiGovItemId;
        this.chiGovId = chiGovId;
    }

    public String getChiGovItemId() {
        return chiGovItemId;
    }

    public void setChiGovItemId(String chiGovItemId) {
        this.chiGovItemId = chiGovItemId;
    }

    public String getChiGovId() {
        return chiGovId;
    }

    public void setChiGovId(String chiGovId) {
        this.chiGovId = chiGovId;
    }

    public String getVisitHn() {
        return visitHn;
    }

    public void setVisitHn(String visitHn) {
        this.visitHn = visitHn;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }
    
    public String getVisitVn() {
        return visitVn;
    }
    public void setVisitVn(String visitVn) {
        this.visitVn = visitVn;
    }

    public String getPatientFullnamet() {
        return patientFullnamet;
    }

    public void setPatientFullnamet(String patientFullnamet) {
        this.patientFullnamet = patientFullnamet;
    }

    public String getStatusChi() {
        return statusChi;
    }

    public void setStatusChi(String statusChi) {
        this.statusChi = statusChi;
    }

    public String getChiGovItemActive() {
        return chiGovItemActive;
    }

    public void setChiGovItemActive(String chiGovItemActive) {
        this.chiGovItemActive = chiGovItemActive;
    }

    public Double getVisitTotal() {
        return visitTotal;
    }

    public void setVisitTotal(Double visitTotal) {
        this.visitTotal = visitTotal;
    }

    public Double getChiPaid() {
        return chiPaid;
    }
    public void setChiPaid(Double chiPaid) {
        this.chiPaid = chiPaid;
    }

    public String getRemarkChiGov() {
        return remarkChiGov;
    }

    public void setRemarkChiGov(String remarkChiGov) {
        this.remarkChiGov = remarkChiGov;
    }

    public String getRemarkChi() {
        return remarkChi;
    }

    public void setRemarkChi(String remarkChi) {
        this.remarkChi = remarkChi;
    }

    public String getChiGovItemDate() {
        return chiGovItemDate;
    }

    public void setChiGovItemDate(String chiGovItemDate) {
        this.chiGovItemDate = chiGovItemDate;
    }

    public String getPaidId() {
        return paidId;
    }
    public void setPaidId(String paidId) {
        this.paidId = paidId;
    }

    public String getAuthCode() {
        return authCode;
    }
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getAuthDt() {
        return authDt;
    }
    public void setAuthDt(String authDt) {
        this.authDt = authDt;
    }

    public String getTVisitPaymentId() {
        return tVisitPaymentId;
    }
    public void setTVisitPaymentId(String tVisitPaymentId) {
        this.tVisitPaymentId = tVisitPaymentId;
    }

    public String getVisitAn() {
        return visitAn;
    }
    public void setVisitAn(String visitAn) {
        this.visitAn = visitAn;
    }

    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSurchargeId() {
        return surchargeId;
    }
    public void setSurchargeId(String surchargeId) {
        this.surchargeId = surchargeId;
    }

    public Double getAdmitDay() {
        return admitDay;
    }
    public void setAdmitDay(Double admitDay) {
        this.admitDay = admitDay;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chiGovItemId != null ? chiGovItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTGovItem)) {
            return false;
        }
        ChiTGovItem other = (ChiTGovItem) object;
        if ((this.chiGovItemId == null && other.chiGovItemId != null) || (this.chiGovItemId != null && !this.chiGovItemId.equals(other.chiGovItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaadmin.ChiTGovItem[chiGovItemId=" + chiGovItemId + "]";
    }

}
