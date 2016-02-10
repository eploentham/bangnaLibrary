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
@Table(name = "chi_b_billgroup")
@NamedQueries({
    @NamedQuery(name = "ChiBBillgroup.findAll", query = "SELECT c FROM ChiBBillgroup c")})
public class ChiBBillgroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "b_item_id")
    private String bItemId="";
    @Column(name = "item_number")
    private String itemNumber="";
    @Column(name = "billgroup_id")
    private String billgroupId="",billgroupName="";
    @Column(name = "item_common_name")
    private String itemCommonName="";
    @Column(name = "simbgroup")
    private String simbgroup="";
    @Column(name = "definition")
    private String definition="";
    @Column(name = "unit")
    private String unit="";
    @Column(name = "rate")
    private Double rate=0.0;
    @Column(name = "revrate")
    private Double revrate=0.0;
    @Column(name = "dateeff")
    private String dateeff="";
    @Column(name = "dateexp")
    private String dateexp="";
    @Column(name = "sid")
    private String sid="";
    @Column(name = "tmp_code")
    private String tmpCode="";
    @Column(name = "cscode")
    private String csCode="";
    @Column(name = "csrate")
    private Double csRate=0.0;
    @Column(name = "csrevrate")
    private String csRevRate="";
    @Column(name = "billinggroup_active")
    private String billinggroupActive="";

    public ChiBBillgroup() {
    }
    public String getChiBBillgroup(){
        return "chi_b_billgroup";
    }
    public String getFBItemId(){
        return "b_item_id";
    }
    public String getFItemNumber(){
        return "item_number";
    }
    public String getFBillgroupId(){
        return "billgroup_id";
    }
    public String getFItemCommonName(){
        return "item_common_name";
    }
    public String getFSimbgroup(){
        return "simbgroup";
    }
    public String getFDefinition(){
        return "definition";
    }
    public String getFUnit(){
        return "unit";
    }
    public String getFRate(){
        return "rate";
    }
    public String getFRevrate(){
        return "revrate";
    }
    public String getFDateeff(){
        return "dateeff";
    }
    public String getFDateexp(){
        return "dateexp";
    }
    public String getFSid(){
        return "sid";
    }
    public String getFTmpCode(){
        return "tmp_code";
    }
    public String getFCsCode(){
        return "cscode";
    }
    public String getFCsRate(){
        return "csrate";
    }
    public String getFCsRevRate(){
        return "csrevrate";
    }
    public String getFBillinggroupActive(){
        return "billinggroup_active";
    }

    public ChiBBillgroup(String bItemId) {
        this.bItemId = bItemId;
    }

    public String getBItemId() {
        return bItemId;
    }

    public void setBItemId(String bItemId) {
        this.bItemId = bItemId;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getBillgroupId() {
        return billgroupId;
    }
    public void setBillgroupId(String billgroupId) {
        this.billgroupId = billgroupId;
    }

    public String getItemCommonName() {
        return itemCommonName;
    }
    public void setItemCommonName(String itemCommonName) {
        this.itemCommonName = itemCommonName;
    }

    public String getSimbgroup() {
        return simbgroup;
    }
    public void setSimbgroup(String simbgroup) {
        this.simbgroup = simbgroup;
    }

    public String getDefinition() {
        return definition;
    }
    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getRate() {
        return rate;
    }
    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getRevrate() {
        return revrate;
    }
    public void setRevrate(Double revrate) {
        this.revrate = revrate;
    }

    public String getDateeff() {
        return dateeff;
    }
    public void setDateeff(String dateeff) {
        this.dateeff = dateeff;
    }

    public String getDateexp() {
        return dateexp;
    }
    public void setDateexp(String dateexp) {
        this.dateexp = dateexp;
    }

    public String getSid() {
        return sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getBillgroupName() {
        return billgroupName;
    }
    public void setBillgroupName(String billgroupName) {
        this.billgroupName = billgroupName;
    }

    public String getTmpCode() {
        return tmpCode;
    }
    public void setTmpCode(String tmpCode) {
        this.tmpCode = tmpCode;
    }

    public String getCsCode() {
        return csCode;
    }
    public void setCsCode(String csCode) {
        this.csCode = csCode;
    }

    public Double getCsRate() {
        return csRate;
    }
    public void setCsRate(Double csRate) {
        this.csRate = csRate;
    }

    public String getCsRevRate() {
        return csRevRate;
    }
    public void setCsRevRate(String csRevRate) {
        this.csRevRate = csRevRate;
    }
    public String getBillinggroupActive() {
        return billinggroupActive;
    }
    public void setBillinggroupActive(String billinggroupActive) {
        this.billinggroupActive = billinggroupActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bItemId != null ? bItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiBBillgroup)) {
            return false;
        }
        ChiBBillgroup other = (ChiBBillgroup) object;
        if ((this.bItemId == null && other.bItemId != null) || (this.bItemId != null && !this.bItemId.equals(other.bItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaadmin.ChiBBillgroup[bItemId=" + bItemId + "]";
    }

}
