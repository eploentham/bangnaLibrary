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
//@Entity
//@Table(name = "cashier_t_close_day_detail", catalog = "bangna5", schema = "public")
//@NamedQueries({
//    @NamedQuery(name = "CashierTCloseDayDetail.findAll", query = "SELECT c FROM CashierTCloseDayDetail c"),
//    @NamedQuery(name = "CashierTCloseDayDetail.findByCloseDayDetailId", query = "SELECT c FROM CashierTCloseDayDetail c WHERE c.closeDayDetailId = :closeDayDetailId"),
//    @NamedQuery(name = "CashierTCloseDayDetail.findByBContractPlansId", query = "SELECT c FROM CashierTCloseDayDetail c WHERE c.bContractPlansId = :bContractPlansId"),
//    @NamedQuery(name = "CashierTCloseDayDetail.findByContractPlansDescription", query = "SELECT c FROM CashierTCloseDayDetail c WHERE c.contractPlansDescription = :contractPlansDescription"),
//    @NamedQuery(name = "CashierTCloseDayDetail.findByCloseDayId", query = "SELECT c FROM CashierTCloseDayDetail c WHERE c.closeDayId = :closeDayId"),
//    @NamedQuery(name = "CashierTCloseDayDetail.findByAmount", query = "SELECT c FROM CashierTCloseDayDetail c WHERE c.amount = :amount"),
//    @NamedQuery(name = "CashierTCloseDayDetail.findByDiscount", query = "SELECT c FROM CashierTCloseDayDetail c WHERE c.discount = :discount"),
//    @NamedQuery(name = "CashierTCloseDayDetail.findByNettotal", query = "SELECT c FROM CashierTCloseDayDetail c WHERE c.nettotal = :nettotal"),
//    @NamedQuery(name = "CashierTCloseDayDetail.findByRemark", query = "SELECT c FROM CashierTCloseDayDetail c WHERE c.remark = :remark")})
public class CashierTCloseDayDetail extends Persistent{
//    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @Column(name = "close_day_detail_id", nullable = false, length = 255)
    private String closeDayDetailId="";
//    @Column(name = "b_contract_plans_id", length = 255)
    private String bContractPlansId="";
//    @Column(name = "contract_plans_description", length = 255)
    private String contractPlansDescription="";
//    @Column(name = "close_day_id", length = 255)
    private String closeDayId="";
//    @Column(name = "amount", precision = 17, scale = 17)
    private Double amount=0.0;
//    @Column(name = "discount", precision = 17, scale = 17)
    private Double discount=0.0;
//    @Column(name = "nettotal", precision = 17, scale = 17)
    private Double nettotal=0.0;
//    @Column(name = "remark", length = 255)
    private String remark="";
//    @Column(name = "cnt_b_contract_plans", precision = 17, scale = 17)
    private Double cntBContractPlans=0.0;

    public CashierTCloseDayDetail() {
    }
    public void initial(){
        closeDayDetailId="";
        bContractPlansId="";
        contractPlansDescription="";
        closeDayId="";
        amount=0.0;
        discount=0.0;
         nettotal=0.0;
        remark="";
        cntBContractPlans=0.0;
    }
    public String getCashierTCloseDayDetail() {
        return "cashier_t_close_day_detail";
    }
    public String getFCloseDayDetailId() {
        return "close_day_detail_id";
    }
    public String getFBContractPlansId() {
        return "b_contract_plans_id";
    }
    public String getFContractPlansDescription() {
        return "contract_plans_description";
    }
    public String getFCloseDayId() {
        return "close_day_id";
    }
    public String getFAmount() {
        return "amount";
    }
    public String getFDiscount() {
        return "discount";
    }
    public String getFNettotal() {
        return "nettotal";
    }
    public String getFRemark() {
        return "remark";
    }
    public String getFCntBContractPlans() {
        return "cnt_b_contract_plans";
    }

    public CashierTCloseDayDetail(String closeDayDetailId) {
        this.closeDayDetailId = closeDayDetailId;
    }

    public String getCloseDayDetailId() {
        return closeDayDetailId;
    }

    public void setCloseDayDetailId(String closeDayDetailId) {
        this.closeDayDetailId = closeDayDetailId;
    }

    public String getBContractPlansId() {
        return bContractPlansId;
    }

    public void setBContractPlansId(String bContractPlansId) {
        this.bContractPlansId = bContractPlansId;
    }

    public String getContractPlansDescription() {
        return contractPlansDescription;
    }

    public void setContractPlansDescription(String contractPlansDescription) {
        this.contractPlansDescription = contractPlansDescription;
    }

    public String getCloseDayId() {
        return closeDayId;
    }

    public void setCloseDayId(String closeDayId) {
        this.closeDayId = closeDayId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getNettotal() {
        return nettotal;
    }

    public void setNettotal(Double nettotal) {
        this.nettotal = nettotal;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getCntBContractPlans() {
        return cntBContractPlans;
    }

    public void setCntBContractPlan(Double cntBContractPlans) {
        this.cntBContractPlans = cntBContractPlans;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (closeDayDetailId != null ? closeDayDetailId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//         TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof CashierTCloseDayDetail)) {
//            return false;
//        }
//        CashierTCloseDayDetail other = (CashierTCloseDayDetail) object;
//        if ((this.closeDayDetailId == null && other.closeDayDetailId != null) || (this.closeDayDetailId != null && !this.closeDayDetailId.equals(other.closeDayDetailId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "bangnacashier.CashierTCloseDayDetail[closeDayDetailId=" + closeDayDetailId + "]";
//    }

}
