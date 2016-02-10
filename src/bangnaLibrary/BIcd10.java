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
@Table(name = "b_icd10", catalog = "front_bangna5", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"b_icd10_id"})})
@NamedQueries({
    @NamedQuery(name = "BIcd10.findAll", query = "SELECT b FROM BIcd10 b"),
    @NamedQuery(name = "BIcd10.findByBIcd10Id", query = "SELECT b FROM BIcd10 b WHERE b.bIcd10Id = :bIcd10Id"),
    @NamedQuery(name = "BIcd10.findByIcd10Number", query = "SELECT b FROM BIcd10 b WHERE b.icd10Number = :icd10Number"),
    @NamedQuery(name = "BIcd10.findByIcd10Description", query = "SELECT b FROM BIcd10 b WHERE b.icd10Description = :icd10Description"),
    @NamedQuery(name = "BIcd10.findByIcd10OtherDescription", query = "SELECT b FROM BIcd10 b WHERE b.icd10OtherDescription = :icd10OtherDescription"),
    @NamedQuery(name = "BIcd10.findByIcd10GenerateCode", query = "SELECT b FROM BIcd10 b WHERE b.icd10GenerateCode = :icd10GenerateCode")})
public class BIcd10 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "b_icd10_id", nullable = false, length = 255)
    private String bIcd10Id="";
    @Column(name = "icd10_number", length = 255)
    private String icd10Number="";
    @Column(name = "icd10_description", length = 255)
    private String icd10Description="";
    @Column(name = "icd10_other_description", length = 255)
    private String icd10OtherDescription="";
    @Column(name = "icd10_generate_code", length = 255)
    private String icd10GenerateCode="";

    public BIcd10() {
    }
    public void initial(){
        bIcd10Id="";
        icd10Number="";
        icd10Description="";
        icd10OtherDescription="";
        icd10GenerateCode="";
    }
    public String getBIcd10(){
        return "b_icd10";
    }
    public String getFBIcd10Id(){
        return "b_icd10_id";
    }
    public String getFIcd10Number(){
        return "icd10_number";
    }
    public String getFIcd10Description(){
        return "icd10_description";
    }
    public String getFIcd10OtherDescription(){
        return "icd10_other_description";
    }
    public String getFIcd10GenerateCode(){
        return "icd10_generate_code";
    }

    public BIcd10(String bIcd10Id) {
        this.bIcd10Id = bIcd10Id;
    }

    public String getBIcd10Id() {
        return bIcd10Id;
    }

    public void setBIcd10Id(String bIcd10Id) {
        this.bIcd10Id = bIcd10Id;
    }

    public String getIcd10Number() {
        return icd10Number;
    }

    public void setIcd10Number(String icd10Number) {
        this.icd10Number = icd10Number;
    }

    public String getIcd10Description() {
        return icd10Description;
    }

    public void setIcd10Description(String icd10Description) {
        this.icd10Description = icd10Description;
    }

    public String getIcd10OtherDescription() {
        return icd10OtherDescription;
    }

    public void setIcd10OtherDescription(String icd10OtherDescription) {
        this.icd10OtherDescription = icd10OtherDescription;
    }

    public String getIcd10GenerateCode() {
        return icd10GenerateCode;
    }

    public void setIcd10GenerateCode(String icd10GenerateCode) {
        this.icd10GenerateCode = icd10GenerateCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bIcd10Id != null ? bIcd10Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BIcd10)) {
            return false;
        }
        BIcd10 other = (BIcd10) object;
        if ((this.bIcd10Id == null && other.bIcd10Id != null) || (this.bIcd10Id != null && !this.bIcd10Id.equals(other.bIcd10Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.BIcd10[bIcd10Id=" + bIcd10Id + "]";
    }

}
