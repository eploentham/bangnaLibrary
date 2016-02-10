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
@Table(name = "chi_b_surcharge")
@NamedQueries({
    @NamedQuery(name = "ChiBSurcharge.findAll", query = "SELECT c FROM ChiBSurcharge c")})
public class ChiBSurcharge implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "surcharge_id")
    private String surchargeId;
    @Column(name = "item_number")
    private String itemNumber;
    @Column(name = "tmp_code")
    private String tmpCode;
    @Column(name = "definition")
    private String definition;
    @Column(name = "rate_a")
    private Double rateA;
    @Column(name = "rate_b")
    private Double rateB;
    @Column(name = "rate_c")
    private Double rateC;
    @Column(name = "rate_d")
    private Double rateD;
    @Column(name = "surcharge")
    private Double surcharge;
    @Column(name = "branch_id")
    private String branchId;
    @Column(name = "surcharge_active")
    private String surchargeActive;

    public ChiBSurcharge() {
    }

    public String getChiBSurcharge() {
        return "chi_b_surcharge";
    }
    public String getFSurchargeId() {
        return "surcharge_id";
    }
    public String getFItemNumber() {
        return "item_number";
    }
    public String getFTmpCode() {
        return "tmp_code";
    }
    public String getFDefinition() {
        return "definition";
    }
    public String getFRateA() {
        return "rate_a";
    }
    public String getFRateB() {
        return "rate_b";
    }
    public String getFRateC() {
        return "rate_c";
    }
    public String getFRateD() {
        return "rate_d";
    }
    public String getFSurcharge() {
        return "surcharge";
    }
    public String getFBranchId() {
        return "branch_id";
    }
    public String getFSurchargeActive() {
        return "surcharge_active";
    }

    public ChiBSurcharge(String surchargeId) {
        this.surchargeId = surchargeId;
    }

    public String getSurchargeId() {
        return surchargeId;
    }

    public void setSurchargeId(String surchargeId) {
        this.surchargeId = surchargeId;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getTmpCode() {
        return tmpCode;
    }

    public void setTmpCode(String tmpCode) {
        this.tmpCode = tmpCode;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Double getRateA() {
        return rateA;
    }

    public void setRateA(Double rateA) {
        this.rateA = rateA;
    }

    public Double getRateB() {
        return rateB;
    }

    public void setRateB(Double rateB) {
        this.rateB = rateB;
    }

    public Double getRateC() {
        return rateC;
    }

    public void setRateC(Double rateC) {
        this.rateC = rateC;
    }

    public Double getRateD() {
        return rateD;
    }

    public void setRateD(Double rateD) {
        this.rateD = rateD;
    }

    public Double getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(Double surcharge) {
        this.surcharge = surcharge;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getSurchargeActive() {
        return surchargeActive;
    }

    public void setSurchargeActive(String surchargeActive) {
        this.surchargeActive = surchargeActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (surchargeId != null ? surchargeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiBSurcharge)) {
            return false;
        }
        ChiBSurcharge other = (ChiBSurcharge) object;
        if ((this.surchargeId == null && other.surchargeId != null) || (this.surchargeId != null && !this.surchargeId.equals(other.surchargeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.ChiBSurcharge[surchargeId=" + surchargeId + "]";
    }

}
