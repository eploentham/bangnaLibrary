package bangnaLibrary;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



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
 * @author pop
 */
@Entity
@Table(name = "f_sex", catalog = "hospital_osv3", schema = "public", uniqueConstraints = {@UniqueConstraint(columnNames = {"f_sex_id"})})
@NamedQueries({@NamedQuery(name = "FSex.findAll", query = "SELECT f FROM FSex f"), @NamedQuery(name = "FSex.findByFSexId", query = "SELECT f FROM FSex f WHERE f.fSexId = :fSexId"), @NamedQuery(name = "FSex.findBySexDescription", query = "SELECT f FROM FSex f WHERE f.sexDescription = :sexDescription")})
public class FSex implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "f_sex_id", nullable = false, length = 255)
    private String fSexId="";
    @Column(name = "sex_description", length = 255)
    private String sexDescription="";

    public FSex() {
    }
    public void initial(){
        fSexId="";
        sexDescription="";
    }
    public String getFSex() {
        return "f_sex";
    }
    public String getFFSexId() {
        return "f_sex_id";
    }
    public String getFSexDescription() {
        return "sex_description";
    }

    public FSex(String fSexId) {
        this.fSexId = fSexId;
    }

    public String getFSexId() {
        return fSexId;
    }

    public void setFSexId(String fSexId) {
        this.fSexId = fSexId;
    }

    public String getSexDescription() {
        return sexDescription;
    }

    public void setSexDescription(String sexDescription) {
        this.sexDescription = sexDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fSexId != null ? fSexId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FSex)) {
            return false;
        }
        FSex other = (FSex) object;
        if ((this.fSexId == null && other.fSexId != null) || (this.fSexId != null && !this.fSexId.equals(other.fSexId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaintranet.FSex[fSexId=" + fSexId + "]";
    }

}
