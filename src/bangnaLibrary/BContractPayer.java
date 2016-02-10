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
@Table(name = "b_contract_payer", catalog = "front_bangna5", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"b_contract_payer_id"})})
@NamedQueries({
    @NamedQuery(name = "BContractPayer.findAll", query = "SELECT b FROM BContractPayer b"),
    @NamedQuery(name = "BContractPayer.findByBContractPayerId", query = "SELECT b FROM BContractPayer b WHERE b.bContractPayerId = :bContractPayerId"),
    @NamedQuery(name = "BContractPayer.findByContractPayerNumber", query = "SELECT b FROM BContractPayer b WHERE b.contractPayerNumber = :contractPayerNumber"),
    @NamedQuery(name = "BContractPayer.findByContractPayerDescription", query = "SELECT b FROM BContractPayer b WHERE b.contractPayerDescription = :contractPayerDescription"),
    @NamedQuery(name = "BContractPayer.findByContractPayerActive", query = "SELECT b FROM BContractPayer b WHERE b.contractPayerActive = :contractPayerActive")})
public class BContractPayer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "b_contract_payer_id", nullable = false, length = 255)
    private String bContractPayerId="";
    @Column(name = "contract_payer_number", length = 255)
    private String contractPayerNumber="";
    @Column(name = "contract_payer_description", length = 255)
    private String contractPayerDescription="";
    @Column(name = "contract_payer_active", length = 255)
    private String contractPayerActive="";

    public BContractPayer() {
    }
    public void initial(){
        bContractPayerId="";
        contractPayerNumber="";
        contractPayerDescription="";
        contractPayerActive="";
    }
    public String getBContractPayer(){
        return "b_contract_payer";
    }
    public String getFBContractPayerId(){
        return "b_contract_payer_id";
    }
    public String getFContractPayerNumber(){
        return "contract_payer_number";
    }
    public String getFContractPayerDescription(){
        return "contract_payer_description";
    }
    public String getFContractPayerActive(){
        return "contract_payer_active";
    }

    public BContractPayer(String bContractPayerId) {
        this.bContractPayerId = bContractPayerId;
    }

    public String getBContractPayerId() {
        return bContractPayerId;
    }

    public void setBContractPayerId(String bContractPayerId) {
        this.bContractPayerId = bContractPayerId;
    }

    public String getContractPayerNumber() {
        return contractPayerNumber;
    }

    public void setContractPayerNumber(String contractPayerNumber) {
        this.contractPayerNumber = contractPayerNumber;
    }

    public String getContractPayerDescription() {
        return contractPayerDescription;
    }

    public void setContractPayerDescription(String contractPayerDescription) {
        this.contractPayerDescription = contractPayerDescription;
    }

    public String getContractPayerActive() {
        return contractPayerActive;
    }

    public void setContractPayerActive(String contractPayerActive) {
        this.contractPayerActive = contractPayerActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bContractPayerId != null ? bContractPayerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BContractPayer)) {
            return false;
        }
        BContractPayer other = (BContractPayer) object;
        if ((this.bContractPayerId == null && other.bContractPayerId != null) || (this.bContractPayerId != null && !this.bContractPayerId.equals(other.bContractPayerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.BContractPayer[bContractPayerId=" + bContractPayerId + "]";
    }

}
