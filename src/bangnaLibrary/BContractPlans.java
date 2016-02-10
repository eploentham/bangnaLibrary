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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author root
 */
@Entity
@Table(name = "b_contract_plans", catalog = "front_bangna5", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"b_contract_plans_id"})})
@NamedQueries({
    @NamedQuery(name = "BContractPlans.findAll", query = "SELECT b FROM BContractPlans b"),
    @NamedQuery(name = "BContractPlans.findByBContractPlansId", query = "SELECT b FROM BContractPlans b WHERE b.bContractPlansId = :bContractPlansId"),
    @NamedQuery(name = "BContractPlans.findByContractPlansNumber", query = "SELECT b FROM BContractPlans b WHERE b.contractPlansNumber = :contractPlansNumber"),
    @NamedQuery(name = "BContractPlans.findByContractPlansDescription", query = "SELECT b FROM BContractPlans b WHERE b.contractPlansDescription = :contractPlansDescription"),
    @NamedQuery(name = "BContractPlans.findByContractPlansActiveFrom", query = "SELECT b FROM BContractPlans b WHERE b.contractPlansActiveFrom = :contractPlansActiveFrom"),
    @NamedQuery(name = "BContractPlans.findByContractPlansActiveTo", query = "SELECT b FROM BContractPlans b WHERE b.contractPlansActiveTo = :contractPlansActiveTo"),
    @NamedQuery(name = "BContractPlans.findByContractPlansActive", query = "SELECT b FROM BContractPlans b WHERE b.contractPlansActive = :contractPlansActive"),
    @NamedQuery(name = "BContractPlans.findByContractPlansPttype", query = "SELECT b FROM BContractPlans b WHERE b.contractPlansPttype = :contractPlansPttype"),
    @NamedQuery(name = "BContractPlans.findByBContractPayerId", query = "SELECT b FROM BContractPlans b WHERE b.bContractPayerId = :bContractPayerId"),
    @NamedQuery(name = "BContractPlans.findByBContractId", query = "SELECT b FROM BContractPlans b WHERE b.bContractId = :bContractId"),
    @NamedQuery(name = "BContractPlans.findByContractPlansMoneyLimit", query = "SELECT b FROM BContractPlans b WHERE b.contractPlansMoneyLimit = :contractPlansMoneyLimit"),
    @NamedQuery(name = "BContractPlans.findByContractPlansSortIndex", query = "SELECT b FROM BContractPlans b WHERE b.contractPlansSortIndex = :contractPlansSortIndex")})
public class BContractPlans implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "b_contract_plans_id", nullable = false, length = 255)
    private String bContractPlansId="";
    @Column(name = "contract_plans_number", length = 255)
    private String contractPlansNumber="";
    @Column(name = "contract_plans_description", length = 255)
    private String contractPlansDescription="";
    @Column(name = "contract_plans_active_from", length = 255)
    private String contractPlansActiveFrom="";
    @Column(name = "contract_plans_active_to", length = 255)
    private String contractPlansActiveTo="";
    @Column(name = "contract_plans_active", length = 255)
    private String contractPlansActive="";
    @Column(name = "contract_plans_pttype", length = 255)
    private String contractPlansPttype="";
    @Column(name = "b_contract_payer_id", length = 255)
    private String bContractPayerId="";
    @Column(name = "b_contract_id", length = 255)
    private String bContractId="";
    @Column(name = "contract_plans_money_limit", length = 255)
    private String contractPlansMoneyLimit="";
    @Column(name = "contract_plans_sort_index", length = 255)
    private String contractPlansSortIndex="";

    public BContractPlans() {
    }
    public void initial(){
        bContractPlansId="";
        contractPlansNumber="";
        contractPlansDescription="";
        contractPlansActiveFrom="";
        contractPlansActiveTo="";
        contractPlansActive="";
        contractPlansPttype="";
        bContractPayerId="";
        bContractId="";
        contractPlansMoneyLimit="";
        contractPlansSortIndex="";
    }

    public BContractPlans(String bContractPlansId) {
        this.bContractPlansId = bContractPlansId;
    }

    public String getBContractPlansId() {
        return bContractPlansId;
    }

    public void setBContractPlansId(String bContractPlansId) {
        this.bContractPlansId = bContractPlansId;
    }

    public String getContractPlansNumber() {
        return contractPlansNumber;
    }

    public void setContractPlansNumber(String contractPlansNumber) {
        this.contractPlansNumber = contractPlansNumber;
    }

    public String getContractPlansDescription() {
        return contractPlansDescription;
    }

    public void setContractPlansDescription(String contractPlansDescription) {
        this.contractPlansDescription = contractPlansDescription;
    }

    public String getContractPlansActiveFrom() {
        return contractPlansActiveFrom;
    }

    public void setContractPlansActiveFrom(String contractPlansActiveFrom) {
        this.contractPlansActiveFrom = contractPlansActiveFrom;
    }

    public String getContractPlansActiveTo() {
        return contractPlansActiveTo;
    }

    public void setContractPlansActiveTo(String contractPlansActiveTo) {
        this.contractPlansActiveTo = contractPlansActiveTo;
    }

    public String getContractPlansActive() {
        return contractPlansActive;
    }

    public void setContractPlansActive(String contractPlansActive) {
        this.contractPlansActive = contractPlansActive;
    }

    public String getContractPlansPttype() {
        return contractPlansPttype;
    }

    public void setContractPlansPttype(String contractPlansPttype) {
        this.contractPlansPttype = contractPlansPttype;
    }

    public String getBContractPayerId() {
        return bContractPayerId;
    }

    public void setBContractPayerId(String bContractPayerId) {
        this.bContractPayerId = bContractPayerId;
    }

    public String getBContractId() {
        return bContractId;
    }

    public void setBContractId(String bContractId) {
        this.bContractId = bContractId;
    }

    public String getContractPlansMoneyLimit() {
        return contractPlansMoneyLimit;
    }

    public void setContractPlansMoneyLimit(String contractPlansMoneyLimit) {
        this.contractPlansMoneyLimit = contractPlansMoneyLimit;
    }

    public String getContractPlansSortIndex() {
        return contractPlansSortIndex;
    }

    public void setContractPlansSortIndex(String contractPlansSortIndex) {
        this.contractPlansSortIndex = contractPlansSortIndex;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bContractPlansId != null ? bContractPlansId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BContractPlans)) {
            return false;
        }
        BContractPlans other = (BContractPlans) object;
        if ((this.bContractPlansId == null && other.bContractPlansId != null) || (this.bContractPlansId != null && !this.bContractPlansId.equals(other.bContractPlansId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.BContractPlans[bContractPlansId=" + bContractPlansId + "]";
    }

}
