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
@Table(name = "f_patient_marriage_status", catalog = "hospital_osv3", schema = "public", uniqueConstraints = {@UniqueConstraint(columnNames = {"f_patient_marriage_status_id"})})
@NamedQueries({@NamedQuery(name = "FPatientMarriageStatus.findAll", query = "SELECT f FROM FPatientMarriageStatus f"), @NamedQuery(name = "FPatientMarriageStatus.findByFPatientMarriageStatusId", query = "SELECT f FROM FPatientMarriageStatus f WHERE f.fPatientMarriageStatusId = :fPatientMarriageStatusId"), @NamedQuery(name = "FPatientMarriageStatus.findByPatientMarriageStatusDescription", query = "SELECT f FROM FPatientMarriageStatus f WHERE f.patientMarriageStatusDescription = :patientMarriageStatusDescription")})
public class FPatientMarriageStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "f_patient_marriage_status_id", nullable = false, length = 255)
    private String fPatientMarriageStatusId="";
    @Column(name = "patient_marriage_status_description", length = 255)
    private String patientMarriageStatusDescription="";

    public FPatientMarriageStatus() {
    }
    public void initial(){
        fPatientMarriageStatusId="";
        patientMarriageStatusDescription="";
    }

    public String getFPatientMarriageStatus() {
        return "f_patient_marriage_status";
    }
    public String getFFPatientMarriageStatusId() {
        return "f_patient_marriage_status_id";
    }
    public String getFPatientMarriageStatusDescription() {
        return "patient_marriage_status_description";
    }

    public FPatientMarriageStatus(String fPatientMarriageStatusId) {
        this.fPatientMarriageStatusId = fPatientMarriageStatusId;
    }

    public String getFPatientMarriageStatusId() {
        return fPatientMarriageStatusId;
    }

    public void setFPatientMarriageStatusId(String fPatientMarriageStatusId) {
        this.fPatientMarriageStatusId = fPatientMarriageStatusId;
    }

    public String getPatientMarriageStatusDescription() {
        return patientMarriageStatusDescription;
    }

    public void setPatientMarriageStatusDescription(String patientMarriageStatusDescription) {
        this.patientMarriageStatusDescription = patientMarriageStatusDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fPatientMarriageStatusId != null ? fPatientMarriageStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FPatientMarriageStatus)) {
            return false;
        }
        FPatientMarriageStatus other = (FPatientMarriageStatus) object;
        if ((this.fPatientMarriageStatusId == null && other.fPatientMarriageStatusId != null) || (this.fPatientMarriageStatusId != null && !this.fPatientMarriageStatusId.equals(other.fPatientMarriageStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaintranet.FPatientMarriageStatus[fPatientMarriageStatusId=" + fPatientMarriageStatusId + "]";
    }

}
