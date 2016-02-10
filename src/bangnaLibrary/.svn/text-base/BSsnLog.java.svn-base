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
@Table(name = "b_ssn_log", catalog = "bangna", schema = "public")
@NamedQueries({@NamedQuery(name = "BSsnLog.findAll", query = "SELECT b FROM BSsnLog b"), @NamedQuery(name = "BSsnLog.findByBSsnLogId", query = "SELECT b FROM BSsnLog b WHERE b.bSsnLogId = :bSsnLogId"), @NamedQuery(name = "BSsnLog.findByYearId", query = "SELECT b FROM BSsnLog b WHERE b.yearId = :yearId"), @NamedQuery(name = "BSsnLog.findByMonthId", query = "SELECT b FROM BSsnLog b WHERE b.monthId = :monthId"), @NamedQuery(name = "BSsnLog.findByBranchId", query = "SELECT b FROM BSsnLog b WHERE b.branchId = :branchId"), @NamedQuery(name = "BSsnLog.findByPeriodId", query = "SELECT b FROM BSsnLog b WHERE b.periodId = :periodId"), @NamedQuery(name = "BSsnLog.findByFilename", query = "SELECT b FROM BSsnLog b WHERE b.filename = :filename"), @NamedQuery(name = "BSsnLog.findBySsnLogActive", query = "SELECT b FROM BSsnLog b WHERE b.ssnLogActive = :ssnLogActive"), @NamedQuery(name = "BSsnLog.findByCnt", query = "SELECT b FROM BSsnLog b WHERE b.cnt = :cnt")})
public class BSsnLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "b_ssn_log_id", nullable = false, length = 255)
    private String bSsnLogId="";
    @Column(name = "year_id", length = 255)
    private String yearId="";
    @Column(name = "month_id", length = 255)
    private String monthId="";
    @Column(name = "branch_id", length = 255)
    private String branchId="";
    @Column(name = "period_id", length = 255)
    private String periodId="";
    @Column(name = "filename1", length = 255)
    private String filename1="";
    @Column(name = "filename2", length = 255)
    private String filename2="";
    @Column(name = "filename5", length = 255)
    private String filename5="";
    @Column(name = "ssn_log_active", length = 255)
    private String ssnLogActive="";
    @Column(name = "cnt1", precision = 17, scale = 17)
    private Double cnt1=0.0;
    @Column(name = "description", length = 255)
    private String description="";
    @Column(name = "cnt2", precision = 17, scale = 17)
    private Double cnt2=0.0;
    @Column(name = "cnt5", precision = 17, scale = 17)
    private Double cnt5=0.0;

    public BSsnLog() {
    }
    public void initial(){
        bSsnLogId="";
        yearId="";
        monthId="";
        branchId="";
        periodId="";
        filename1="";
        filename2="";
        filename5="";
        ssnLogActive="";
        cnt1=0.0;
        description="";
        cnt2=0.0;
        cnt5=0.0;
    }

    public String getBSsnLog() {
        return "b_ssn_log";
    }

    public String getFBSsnLogId() {
        return "b_ssn_log_id";
    }
    public String getFYearId() {
        return "year_id";
    }
    public String getFMonthId() {
        return "month_id";
    }
    public String getFBranchId() {
        return "branch_id";
    }
    public String getFPeriodId() {
        return "period_id";
    }
    public String getFFilename2() {
        return "filename2";
    }
    public String getFFilename5() {
        return "filename5";
    }
    public String getFFilename1() {
        return "filename1";
    }
    public String getFSsnLogActive() {
        return "ssn_log_active";
    }
    public String getFCnt1() {
        return "cnt_1";
    }
    public String getFDescription() {
        return "description";
    }
    public String getFCnt2() {
        return "cnt_2";
    }
    public String getFCnt5() {
        return "cnt_5";
    }

    public BSsnLog(String bSsnLogId) {
        this.bSsnLogId = bSsnLogId;
    }

    public String getBSsnLogId() {
        return bSsnLogId;
    }

    public void setBSsnLogId(String bSsnLogId) {
        this.bSsnLogId = bSsnLogId;
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

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getPeriodId() {
        return periodId;
    }

    public void setPeriodId(String periodId) {
        this.periodId = periodId;
    }

    public String getFilename1() {
        return filename1;
    }
    public void setFilename1(String filename1) {
        this.filename1 = filename1;
    }

    public String getFilename2() {
        return filename2;
    }
    public void setFilename2(String filename2) {
        this.filename2 = filename2;
    }

    public String getFilename5() {
        return filename5;
    }
    public void setFilename5(String filename5) {
        this.filename5 = filename5;
    }

    public String getSsnLogActive() {
        return ssnLogActive;
    }
    public void setSsnLogActive(String ssnLogActive) {
        this.ssnLogActive = ssnLogActive;
    }

    public Double getCnt1() {
        return cnt1;
    }
    public void setCnt1(Double cnt1) {
        this.cnt1 = cnt1;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCnt2() {
        return cnt2;
    }
    public void setCnt2(Double cnt2) {
        this.cnt2 = cnt2;
    }

    public Double getCnt5() {
        return cnt5;
    }
    public void setCnt5(Double cnt5) {
        this.cnt5 = cnt5;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bSsnLogId != null ? bSsnLogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BSsnLog)) {
            return false;
        }
        BSsnLog other = (BSsnLog) object;
        if ((this.bSsnLogId == null && other.bSsnLogId != null) || (this.bSsnLogId != null && !this.bSsnLogId.equals(other.bSsnLogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.BSsnLog[bSsnLogId=" + bSsnLogId + "]";
    }

}
