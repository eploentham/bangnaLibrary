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
@Table(name = "f_patient_nation", catalog = "bangna", schema = "public", uniqueConstraints = {@UniqueConstraint(columnNames = {"f_patient_nation_id"})})
@NamedQueries({@NamedQuery(name = "FPatientNation.findAll", query = "SELECT f FROM FPatientNation f"), @NamedQuery(name = "FPatientNation.findByFPatientNationId", query = "SELECT f FROM FPatientNation f WHERE f.fPatientNationId = :fPatientNationId"), @NamedQuery(name = "FPatientNation.findByPatientNationDescription", query = "SELECT f FROM FPatientNation f WHERE f.patientNationDescription = :patientNationDescription"), @NamedQuery(name = "FPatientNation.findByPatientNationDescriptione", query = "SELECT f FROM FPatientNation f WHERE f.patientNationDescriptione = :patientNationDescriptione")})
public class FPatientNation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "f_patient_nation_id", nullable = false, length = 255)
    private String fPatientNationId="";
    @Column(name = "patient_nation_description", length = 255)
    private String patientNationDescription="";
    @Column(name = "patient_nation_descriptione", length = 255)
    private String patientNationDescriptione="";

    public FPatientNation() {
    }
    public void initial(){
        fPatientNationId="";
        patientNationDescription="";
        patientNationDescriptione="";
    }
    public String getFPatientNation() {
        return "f_patient_nation";
    }
    public String getFFPatientNationId() {
        return "f_patient_nation_id";
    }
    public String getFPatientNationDescription() {
        return "patient_nation_description";
    }
    public String getFPatientNationDescriptione() {
        return "patient_nation_descriptione";
    }

    public FPatientNation(String fPatientNationId) {
        this.fPatientNationId = fPatientNationId;
    }

    public String getFPatientNationId() {
        return fPatientNationId;
    }

    public void setFPatientNationId(String fPatientNationId) {
        this.fPatientNationId = fPatientNationId;
    }

    public String getPatientNationDescription() {
        return patientNationDescription;
    }

    public void setPatientNationDescription(String patientNationDescription) {
        this.patientNationDescription = patientNationDescription;
    }

    public String getPatientNationDescriptione() {
        return patientNationDescriptione;
    }

    public void setPatientNationDescriptione(String patientNationDescriptione) {
        this.patientNationDescriptione = patientNationDescriptione;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fPatientNationId != null ? fPatientNationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FPatientNation)) {
            return false;
        }
        FPatientNation other = (FPatientNation) object;
        if ((this.fPatientNationId == null && other.fPatientNationId != null) || (this.fPatientNationId != null && !this.fPatientNationId.equals(other.fPatientNationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaintranet.FPatientNation[fPatientNationId=" + fPatientNationId + "]";
    }

}
