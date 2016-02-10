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
@Table(name = "chi_t_gov")
@NamedQueries({
    @NamedQuery(name = "ChiTGov.findAll", query = "SELECT c FROM ChiTGov c")})
public class ChiTGov implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "chi_gov_id")
    private String chiGovId="";
    @Column(name = "status_chi_gov")
    private String statusChiGov="";
    @Column(name = "chi_gov_active")
    private String chiGovActive="";
    @Column(name = "description")
    private String description="";
    @Column(name = "remark")
    private String remark="";
    @Column(name = "chi_gov_date")
    private String chiGovDate="", cnt="", visitTotal="";
    @Column(name = "auth_code")
    private String authCode="";
    @Column(name = "auth_dt")
    private String authDt="";

    public ChiTGov() {
    }
    public String getChiTGov(){
        return "chi_t_gov";
    }
    public String getFChiGovId(){
        return "chi_gov_id";
    }
    public String getFStatusChiGov(){
        return "status_chi_gov";
    }
    public String getFChiGovActive(){
        return "chi_gov_active";
    }
    public String getFDescription(){
        return "description";
    }
    public String getFRemark(){
        return "remark";
    }
    public String getFChiGovDate(){
        return "chi_gov_date";
    }
    public String getFAuthCode(){
        return "auth_code";
    }
    public String getFAuthDt(){
        return "auth_dt";
    }

    public ChiTGov(String chiGovId) {
        this.chiGovId = chiGovId;
    }

    public String getChiGovId() {
        return chiGovId;
    }

    public void setChiGovId(String chiGovId) {
        this.chiGovId = chiGovId;
    }

    public String getStatusChiGov() {
        return statusChiGov;
    }

    public void setStatusChiGov(String statusChiGov) {
        this.statusChiGov = statusChiGov;
    }

    public String getChiGovActive() {
        return chiGovActive;
    }

    public void setChiGovActive(String chiGovActive) {
        this.chiGovActive = chiGovActive;
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

    public String getChiGovDate() {
        return chiGovDate;
    }
    public void setChiGovDate(String chiGovDate) {
        this.chiGovDate = chiGovDate;
    }

    public String getVisitTotal() {
        return visitTotal;
    }
    public void setVisitTotal(String visitTotal) {
        this.visitTotal = visitTotal;
    }

    public String getCntItem() {
        return cnt;
    }
    public void setCntItem(String cnt) {
        this.cnt = cnt;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chiGovId != null ? chiGovId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTGov)) {
            return false;
        }
        ChiTGov other = (ChiTGov) object;
        if ((this.chiGovId == null && other.chiGovId != null) || (this.chiGovId != null && !this.chiGovId.equals(other.chiGovId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaadmin.ChiTGov[chiGovId=" + chiGovId + "]";
    }

}
