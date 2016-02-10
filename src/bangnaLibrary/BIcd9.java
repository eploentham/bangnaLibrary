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
@Table(name = "b_icd9", catalog = "front_bangna5", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"b_icd9_id"})})
@NamedQueries({
    @NamedQuery(name = "BIcd9.findAll", query = "SELECT b FROM BIcd9 b"),
    @NamedQuery(name = "BIcd9.findByBIcd9Id", query = "SELECT b FROM BIcd9 b WHERE b.bIcd9Id = :bIcd9Id"),
    @NamedQuery(name = "BIcd9.findByIcd9Number", query = "SELECT b FROM BIcd9 b WHERE b.icd9Number = :icd9Number"),
    @NamedQuery(name = "BIcd9.findByIcd9Description", query = "SELECT b FROM BIcd9 b WHERE b.icd9Description = :icd9Description"),
    @NamedQuery(name = "BIcd9.findByIcd9OtherDescription", query = "SELECT b FROM BIcd9 b WHERE b.icd9OtherDescription = :icd9OtherDescription")})
public class BIcd9 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "b_icd9_id", nullable = false, length = 255)
    private String bIcd9Id="";
    @Column(name = "icd9_number", length = 255)
    private String icd9Number="";
    @Column(name = "icd9_description", length = 255)
    private String icd9Description="";
    @Column(name = "icd9_other_description", length = 255)
    private String icd9OtherDescription="";

    public BIcd9() {
    }
    public void initial(){
        bIcd9Id="";
        icd9Number="";
        icd9Description="";
        icd9OtherDescription="";
    }
    public String getBIcd9() {
        return "b_icd9";
    }
    public String getFBIcd9Id() {
        return "b_icd9_id";
    }
    public String getFIcd9IdNumber() {
        return "icd9_number";
    }
    public String getFIcd9Description() {
        return "icd9_description";
    }
    public String getFIcd9OtherDescription() {
        return "icd9_other_description";
    }

    public BIcd9(String bIcd9Id) {
        this.bIcd9Id = bIcd9Id;
    }

    public String getBIcd9Id() {
        return bIcd9Id;
    }

    public void setBIcd9Id(String bIcd9Id) {
        this.bIcd9Id = bIcd9Id;
    }

    public String getIcd9Number() {
        return icd9Number;
    }

    public void setIcd9Number(String icd9Number) {
        this.icd9Number = icd9Number;
    }

    public String getIcd9Description() {
        return icd9Description;
    }

    public void setIcd9Description(String icd9Description) {
        this.icd9Description = icd9Description;
    }

    public String getIcd9OtherDescription() {
        return icd9OtherDescription;
    }

    public void setIcd9OtherDescription(String icd9OtherDescription) {
        this.icd9OtherDescription = icd9OtherDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bIcd9Id != null ? bIcd9Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BIcd9)) {
            return false;
        }
        BIcd9 other = (BIcd9) object;
        if ((this.bIcd9Id == null && other.bIcd9Id != null) || (this.bIcd9Id != null && !this.bIcd9Id.equals(other.bIcd9Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.BIcd9[bIcd9Id=" + bIcd9Id + "]";
    }

}
