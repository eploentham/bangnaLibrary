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
@Table(name = "chi_f_billgroup")
@NamedQueries({
    @NamedQuery(name = "ChiFBillgroup.findAll", query = "SELECT c FROM ChiFBillgroup c")})
public class ChiFBillgroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "billgroup_id")
    private String billgroupId="";
    @Column(name = "billgroup_namet")
    private String billgroupNamet="";
    @Column(name = "billgroup_active")
    private String billgroupActive="";
    @Column(name = "status_16_group")
    private String status16Group="";
    @Column(name = "item_16_group_number")
    private String item16GroupNumber="";

    public ChiFBillgroup() {
    }
    public String getChiFBillgroup() {
        return "chi_f_billgroup";
    }
    public String getFBillgroupId() {
        return "billgroup_id";
    }
    public String getFBillgroupNamet() {
        return "billgroup_namet";
    }
    public String getFBillgroupActive() {
        return "billgroup_active";
    }
    public String getFStatus16Group() {
        return "status_16_group";
    }
    public String getFItem16GroupNumber() {
        return "item_16_group_number";
    }

    public ChiFBillgroup(String billgroupId) {
        this.billgroupId = billgroupId;
    }

    public String getBillgroupId() {
        return billgroupId;
    }

    public void setBillgroupId(String billgroupId) {
        this.billgroupId = billgroupId;
    }

    public String getBillgroupNamet() {
        return billgroupNamet;
    }

    public void setBillgroupNamet(String billgroupNamet) {
        this.billgroupNamet = billgroupNamet;
    }

    public String getBillgroupActive() {
        return billgroupActive;
    }
    public void setBillgroupActive(String billgroupActive) {
        this.billgroupActive = billgroupActive;
    }

    public String getStatus16Group() {
        return status16Group;
    }
    public void setStatus16Group(String status16Group) {
        this.status16Group = status16Group;
    }

    public String getItem16GroupNumber() {
        return item16GroupNumber;
    }
    public void setItem16GroupNumber(String item16GroupNumber) {
        this.item16GroupNumber = item16GroupNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billgroupId != null ? billgroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiFBillgroup)) {
            return false;
        }
        ChiFBillgroup other = (ChiFBillgroup) object;
        if ((this.billgroupId == null && other.billgroupId != null) || (this.billgroupId != null && !this.billgroupId.equals(other.billgroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaadmin.ChiFBillgroup[billgroupId=" + billgroupId + "]";
    }

}
