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
@Table(name = "f_patient_blood_group", catalog = "hospital_osv3", schema = "public", uniqueConstraints = {@UniqueConstraint(columnNames = {"f_patient_blood_group_id"})})
@NamedQueries({@NamedQuery(name = "FPatientBloodGroup.findAll", query = "SELECT f FROM FPatientBloodGroup f"), @NamedQuery(name = "FPatientBloodGroup.findByFPatientBloodGroupId", query = "SELECT f FROM FPatientBloodGroup f WHERE f.fPatientBloodGroupId = :fPatientBloodGroupId"), @NamedQuery(name = "FPatientBloodGroup.findByPatientBloodGroupDescription", query = "SELECT f FROM FPatientBloodGroup f WHERE f.patientBloodGroupDescription = :patientBloodGroupDescription")})
public class FPatientBloodGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "f_patient_blood_group_id", nullable = false, length = 255)
    private String fPatientBloodGroupId="";
    @Column(name = "patient_blood_group_description", length = 255)
    private String patientBloodGroupDescription="";

    public FPatientBloodGroup() {
    }
    public void initial(){
        fPatientBloodGroupId="";
        patientBloodGroupDescription="";
    }
    public String getFPatientBloodGroup() {
        return "f_patient_blood_group";
    }
    public String getFFPatientBloodGroupId() {
        return "f_patient_blood_group_id";
    }
    public String getFPatientBloodGroupDescription() {
        return "patient_blood_group_description";
    }

    public FPatientBloodGroup(String fPatientBloodGroupId) {
        this.fPatientBloodGroupId = fPatientBloodGroupId;
    }

    public String getFPatientBloodGroupId() {
        return fPatientBloodGroupId;
    }

    public void setFPatientBloodGroupId(String fPatientBloodGroupId) {
        this.fPatientBloodGroupId = fPatientBloodGroupId;
    }

    public String getPatientBloodGroupDescription() {
        return patientBloodGroupDescription;
    }

    public void setPatientBloodGroupDescription(String patientBloodGroupDescription) {
        this.patientBloodGroupDescription = patientBloodGroupDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fPatientBloodGroupId != null ? fPatientBloodGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FPatientBloodGroup)) {
            return false;
        }
        FPatientBloodGroup other = (FPatientBloodGroup) object;
        if ((this.fPatientBloodGroupId == null && other.fPatientBloodGroupId != null) || (this.fPatientBloodGroupId != null && !this.fPatientBloodGroupId.equals(other.fPatientBloodGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaintranet.FPatientBloodGroup[fPatientBloodGroupId=" + fPatientBloodGroupId + "]";
    }

}
