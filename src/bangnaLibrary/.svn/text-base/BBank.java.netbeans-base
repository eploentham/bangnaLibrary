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
@Table(name = "b_bank", catalog = "bangna", schema = "public")
@NamedQueries({@NamedQuery(name = "BBank.findAll", query = "SELECT b FROM BBank b"), @NamedQuery(name = "BBank.findByBBankId", query = "SELECT b FROM BBank b WHERE b.bBankId = :bBankId"), @NamedQuery(name = "BBank.findByBBankNamet", query = "SELECT b FROM BBank b WHERE b.bBankNamet = :bBankNamet"), @NamedQuery(name = "BBank.findByBBankActive", query = "SELECT b FROM BBank b WHERE b.bBankActive = :bBankActive")})
public class BBank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "b_bank_id", nullable = false, length = 255)
    private String bBankId="";
    @Basic(optional = false)
    @Column(name = "b_bank_namet", nullable = false, length = 255)
    private String bBankNamet="";
    @Column(name = "b_bank_active", length = 255)
    private String bBankActive="";

    public BBank() {
    }
    public void initial(){
        bBankId="";
        bBankNamet="";
        bBankActive="";
    }
    public String getBBank(){
        return "b_bank";
    }
    public String getFBBankId(){
        return "b_bank_id";
    }
    public String getFBBankNamet(){
        return "b_bank_namet";
    }
    public String getFBBankActive(){
        return "b_bank_active";
    }

    public BBank(String bBankId) {
        this.bBankId = bBankId;
    }

    public BBank(String bBankId, String bBankNamet) {
        this.bBankId = bBankId;
        this.bBankNamet = bBankNamet;
    }

    public String getBBankId() {
        return bBankId;
    }

    public void setBBankId(String bBankId) {
        this.bBankId = bBankId;
    }

    public String getBBankNamet() {
        return bBankNamet;
    }

    public void setBBankNamet(String bBankNamet) {
        this.bBankNamet = bBankNamet;
    }

    public String getBBankActive() {
        return bBankActive;
    }

    public void setBBankActive(String bBankActive) {
        this.bBankActive = bBankActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bBankId != null ? bBankId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BBank)) {
            return false;
        }
        BBank other = (BBank) object;
        if ((this.bBankId == null && other.bBankId != null) || (this.bBankId != null && !this.bBankId.equals(other.bBankId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.BBank[bBankId=" + bBankId + "]";
    }

}
