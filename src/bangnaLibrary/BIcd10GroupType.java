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
@Table(name = "b_icd10_group_type", catalog = "front_bangna5", schema = "public")
@NamedQueries({
    @NamedQuery(name = "BIcd10GroupType.findAll", query = "SELECT b FROM BIcd10GroupType b"),
    @NamedQuery(name = "BIcd10GroupType.findByBIcd10GroupTypeId", query = "SELECT b FROM BIcd10GroupType b WHERE b.bIcd10GroupTypeId = :bIcd10GroupTypeId"),
    @NamedQuery(name = "BIcd10GroupType.findByIcd10GroupTypeName", query = "SELECT b FROM BIcd10GroupType b WHERE b.icd10GroupTypeName = :icd10GroupTypeName"),
    @NamedQuery(name = "BIcd10GroupType.findByIcd10GroupTypeDescription", query = "SELECT b FROM BIcd10GroupType b WHERE b.icd10GroupTypeDescription = :icd10GroupTypeDescription")})
public class BIcd10GroupType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "b_icd10_group_type_id", nullable = false, length = 255)
    private String bIcd10GroupTypeId="";
    @Basic(optional = false)
    @Column(name = "icd10_group_type_name", nullable = false, length = 255)
    private String icd10GroupTypeName="";
    @Basic(optional = false)
    @Column(name = "icd10_group_type_description", nullable = false, length = 255)
    private String icd10GroupTypeDescription="";

    public BIcd10GroupType() {
    }
    public void initial(){
        bIcd10GroupTypeId="";
        icd10GroupTypeName="";
        icd10GroupTypeDescription="";
    }
    public String getBIcd10GroupType() {
        return "b_icd10_group_type";
    }
    public String getFBIcd10GroupTypeId() {
        return "b_icd10_group_type_id";
    }
    public String getFIcd10GroupTypeName() {
        return "icd10_group_type_name";
    }
    public String getFIcd10GroupTypeDescription() {
        return "icd10_group_type_description";
    }

    public BIcd10GroupType(String bIcd10GroupTypeId) {
        this.bIcd10GroupTypeId = bIcd10GroupTypeId;
    }

    public BIcd10GroupType(String bIcd10GroupTypeId, String icd10GroupTypeName, String icd10GroupTypeDescription) {
        this.bIcd10GroupTypeId = bIcd10GroupTypeId;
        this.icd10GroupTypeName = icd10GroupTypeName;
        this.icd10GroupTypeDescription = icd10GroupTypeDescription;
    }

    public String getBIcd10GroupTypeId() {
        return bIcd10GroupTypeId;
    }

    public void setBIcd10GroupTypeId(String bIcd10GroupTypeId) {
        this.bIcd10GroupTypeId = bIcd10GroupTypeId;
    }

    public String getIcd10GroupTypeName() {
        return icd10GroupTypeName;
    }

    public void setIcd10GroupTypeName(String icd10GroupTypeName) {
        this.icd10GroupTypeName = icd10GroupTypeName;
    }

    public String getIcd10GroupTypeDescription() {
        return icd10GroupTypeDescription;
    }

    public void setIcd10GroupTypeDescription(String icd10GroupTypeDescription) {
        this.icd10GroupTypeDescription = icd10GroupTypeDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bIcd10GroupTypeId != null ? bIcd10GroupTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BIcd10GroupType)) {
            return false;
        }
        BIcd10GroupType other = (BIcd10GroupType) object;
        if ((this.bIcd10GroupTypeId == null && other.bIcd10GroupTypeId != null) || (this.bIcd10GroupTypeId != null && !this.bIcd10GroupTypeId.equals(other.bIcd10GroupTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.BIcd10GroupType[bIcd10GroupTypeId=" + bIcd10GroupTypeId + "]";
    }

}
