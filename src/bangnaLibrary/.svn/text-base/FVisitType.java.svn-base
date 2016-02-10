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
@Table(name = "f_visit_type", catalog = "front_bangna5", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"f_visit_type_id"})})
@NamedQueries({
    @NamedQuery(name = "FVisitType.findAll", query = "SELECT f FROM FVisitType f"),
    @NamedQuery(name = "FVisitType.findByFVisitTypeId", query = "SELECT f FROM FVisitType f WHERE f.fVisitTypeId = :fVisitTypeId"),
    @NamedQuery(name = "FVisitType.findByVisitTypeDescription", query = "SELECT f FROM FVisitType f WHERE f.visitTypeDescription = :visitTypeDescription")})
public class FVisitType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "f_visit_type_id", nullable = false, length = 255)
    private String fVisitTypeId="";
    @Column(name = "visit_type_description", length = 255)
    private String visitTypeDescription="";

    public void initial(){
        fVisitTypeId="";
        visitTypeDescription="";
    }
    public FVisitType() {
    }
    public String  getFVisitType() {
        return "f_visit_type";
    }
    public String  getFFVisitTypeId() {
        return "f_visit_type_id";
    }
    public String  getFVisitTypeDescription() {
        return "visit_type_description";
    }

    public FVisitType(String fVisitTypeId) {
        this.fVisitTypeId = fVisitTypeId;
    }

    public String getFVisitTypeId() {
        return fVisitTypeId;
    }

    public void setFVisitTypeId(String fVisitTypeId) {
        this.fVisitTypeId = fVisitTypeId;
    }

    public String getVisitTypeDescription() {
        return visitTypeDescription;
    }

    public void setVisitTypeDescription(String visitTypeDescription) {
        this.visitTypeDescription = visitTypeDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fVisitTypeId != null ? fVisitTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FVisitType)) {
            return false;
        }
        FVisitType other = (FVisitType) object;
        if ((this.fVisitTypeId == null && other.fVisitTypeId != null) || (this.fVisitTypeId != null && !this.fVisitTypeId.equals(other.fVisitTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.FVisitType[fVisitTypeId=" + fVisitTypeId + "]";
    }

}
