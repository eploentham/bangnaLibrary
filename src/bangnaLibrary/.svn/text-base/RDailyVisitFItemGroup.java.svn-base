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
@Table(name = "r_daily_visit_f_item_group")
@NamedQueries({
    @NamedQuery(name = "RDailyVisitFItemGroup.findAll", query = "SELECT r FROM RDailyVisitFItemGroup r")})
public class RDailyVisitFItemGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "r_id")
    private String rId;
    @Column(name = "visit_vn")
    private String visitVn;
    @Column(name = "patient_fullnamet")
    private String patientFullnamet;
    @Column(name = "visit_hn")
    private String visitHn;
    @Column(name = "item_group_drug")
    private Double itemGroupDrug;
    @Column(name = "item_group_supply")
    private Double itemGroupSupply;
    @Column(name = "item_group_lab")
    private Double itemGroupLab;
    @Column(name = "item_group_xray")
    private Double itemGroupXray;
    @Column(name = "item_group_dental")
    private Double itemGroupDental;
    @Column(name = "item_group_service")
    private Double itemGroupService;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "remark")
    private String remark;

    public RDailyVisitFItemGroup() {
    }
    public String getRDailyVisitFItemGroup(){
        return "r_daily_visit_f_item_group";
    }
    public String getFRId(){
        return "r_id";
    }
    public String getFVisitVn(){
        return "visit_vn";
    }
    public String getFPatientFullnamet(){
        return "patient_fullnamet";
    }
    public String getFVisitHn(){
        return "visit_hn";
    }
    public String getFItemGroupDrug(){
        return "item_group_drug";
    }
    public String getFItemGroupSupply(){
        return "item_group_supply";
    }
    public String getFItemGroupLab(){
        return "item_group_lab";
    }
    public String getFItemGroupXray(){
        return "item_group_xray";
    }
    public String getFItemGroupDental(){
        return "item_group_dental";
    }
    public String getFItemGroupService(){
        return "item_group_service";
    }
    public String getFAmount(){
        return "amount";
    }
    public String getFRmark(){
        return "remark";
    }

    public RDailyVisitFItemGroup(String rId) {
        this.rId = rId;
    }

    public String getRId() {
        return rId;
    }

    public void setRId(String rId) {
        this.rId = rId;
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

    public String getVisitHn() {
        return visitHn;
    }

    public void setVisitHn(String visitHn) {
        this.visitHn = visitHn;
    }

    public Double getItemGroupDrug() {
        return itemGroupDrug;
    }

    public void setItemGroupDrug(Double itemGroupDrug) {
        this.itemGroupDrug = itemGroupDrug;
    }

    public Double getItemGroupSupply() {
        return itemGroupSupply;
    }

    public void setItemGroupSupply(Double itemGroupSupply) {
        this.itemGroupSupply = itemGroupSupply;
    }

    public Double getItemGroupLab() {
        return itemGroupLab;
    }

    public void setItemGroupLab(Double itemGroupLab) {
        this.itemGroupLab = itemGroupLab;
    }

    public Double getItemGroupXray() {
        return itemGroupXray;
    }

    public void setItemGroupXray(Double itemGroupXray) {
        this.itemGroupXray = itemGroupXray;
    }

    public Double getItemGroupDental() {
        return itemGroupDental;
    }

    public void setItemGroupDental(Double itemGroupDental) {
        this.itemGroupDental = itemGroupDental;
    }

    public Double getItemGroupService() {
        return itemGroupService;
    }

    public void setItemGroupService(Double itemGroupService) {
        this.itemGroupService = itemGroupService;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rId != null ? rId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RDailyVisitFItemGroup)) {
            return false;
        }
        RDailyVisitFItemGroup other = (RDailyVisitFItemGroup) object;
        if ((this.rId == null && other.rId != null) || (this.rId != null && !this.rId.equals(other.rId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.RDailyVisitFItemGroup[rId=" + rId + "]";
    }

}
