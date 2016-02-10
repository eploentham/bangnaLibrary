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
@Table(name = "b_contact_type", catalog = "bangna", schema = "public")
@NamedQueries({@NamedQuery(name = "BContactType.findAll", query = "SELECT b FROM BContactType b"), @NamedQuery(name = "BContactType.findByContactTypeId", query = "SELECT b FROM BContactType b WHERE b.contactTypeId = :contactTypeId"), @NamedQuery(name = "BContactType.findByContactTypeNamet", query = "SELECT b FROM BContactType b WHERE b.contactTypeNamet = :contactTypeNamet"), @NamedQuery(name = "BContactType.findByContactTypeActive", query = "SELECT b FROM BContactType b WHERE b.contactTypeActive = :contactTypeActive"), @NamedQuery(name = "BContactType.findBySort1", query = "SELECT b FROM BContactType b WHERE b.sort1 = :sort1")})
public class BContactType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "contact_type_id", nullable = false, length = 255)
    private String contactTypeId="";
    @Column(name = "contact_type_namet", length = 255)
    private String contactTypeNamet="";
    @Column(name = "contact_type_active", length = 255)
    private String contactTypeActive="";
    @Column(name = "sort1", length = 255)
    private String sort1="";

    public BContactType() {
    }
    public void initial(){
        contactTypeId="";
        contactTypeNamet="";
        contactTypeActive="";
        sort1="";
    }
    public String getBContactType() {
        return "b_contact_type";
    }
    public String getFContactTypeId() {
        return "contact_type_id";
    }
    public String getFContactTypeNamet() {
        return "contact_type_namet";
    }
    public String getFContactActive() {
        return "contact_type_active";
    }
    public String getFSort1() {
        return "sort1";
    }


    public BContactType(String contactTypeId) {
        this.contactTypeId = contactTypeId;
    }

    public String getContactTypeId() {
        return contactTypeId;
    }

    public void setContactTypeId(String contactTypeId) {
        this.contactTypeId = contactTypeId;
    }

    public String getContactTypeNamet() {
        return contactTypeNamet;
    }

    public void setContactTypeNamet(String contactTypeNamet) {
        this.contactTypeNamet = contactTypeNamet;
    }

    public String getContactTypeActive() {
        return contactTypeActive;
    }

    public void setContactTypeActive(String contactTypeActive) {
        this.contactTypeActive = contactTypeActive;
    }

    public String getSort1() {
        return sort1;
    }

    public void setSort1(String sort1) {
        this.sort1 = sort1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactTypeId != null ? contactTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BContactType)) {
            return false;
        }
        BContactType other = (BContactType) object;
        if ((this.contactTypeId == null && other.contactTypeId != null) || (this.contactTypeId != null && !this.contactTypeId.equals(other.contactTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangna.BContactType[contactTypeId=" + contactTypeId + "]";
    }

}
