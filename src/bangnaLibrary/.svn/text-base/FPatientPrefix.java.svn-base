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
@Table(name = "f_patient_prefix", catalog = "bangna", schema = "public", uniqueConstraints = {@UniqueConstraint(columnNames = {"f_patient_prefix_id"})})
@NamedQueries({@NamedQuery(name = "FPatientPrefix.findAll", query = "SELECT f FROM FPatientPrefix f"), @NamedQuery(name = "FPatientPrefix.findByFPatientPrefixId", query = "SELECT f FROM FPatientPrefix f WHERE f.fPatientPrefixId = :fPatientPrefixId"), @NamedQuery(name = "FPatientPrefix.findByPatientPrefixDescription", query = "SELECT f FROM FPatientPrefix f WHERE f.patientPrefixDescription = :patientPrefixDescription"), @NamedQuery(name = "FPatientPrefix.findByFSexId", query = "SELECT f FROM FPatientPrefix f WHERE f.fSexId = :fSexId"), @NamedQuery(name = "FPatientPrefix.findByFTlockId", query = "SELECT f FROM FPatientPrefix f WHERE f.fTlockId = :fTlockId"), @NamedQuery(name = "FPatientPrefix.findByActive", query = "SELECT f FROM FPatientPrefix f WHERE f.active = :active"), @NamedQuery(name = "FPatientPrefix.findByPatientPrefixDescriptione", query = "SELECT f FROM FPatientPrefix f WHERE f.patientPrefixDescriptione = :patientPrefixDescriptione")})
public class FPatientPrefix implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "f_patient_prefix_id", nullable = false, length = 255)
    private String fPatientPrefixId="";
    @Column(name = "patient_prefix_description", length = 255)
    private String patientPrefixDescription="";
    @Column(name = "f_sex_id", length = 255)
    private String fSexId="";
    @Column(name = "f_tlock_id", length = 255)
    private String fTlockId="";
    @Column(name = "active", length = 255)
    private String active="";
    @Column(name = "patient_prefix_descriptione", length = 255)
    private String patientPrefixDescriptione="";

    public FPatientPrefix() {
    }
    public void initial(){
        fPatientPrefixId="";
        patientPrefixDescription="";
        fSexId="";
        fTlockId="";
        active="";
        patientPrefixDescriptione="";
    }
    public String getFPatientPrefix() {
        return "f_patient_prefix";
    }
    public String getFFPatientPrefixId() {
        return "f_patient_prefix_id";
    }
    public String getFPatientPrefixDescription() {
        return "patient_prefix_description";
    }
    public String getFFSexId() {
        return "f_sex_id";
    }
    public String getFFTlockId() {
        return "f_tlock_id";
    }
    public String getFActive() {
        return "active";
    }
    public String getFPatientPrefixDescriptione() {
        return "patient_prefix_descriptione";
    }

    public FPatientPrefix(String fPatientPrefixId) {
        this.fPatientPrefixId = fPatientPrefixId;
    }

    public String getFPatientPrefixId() {
        return fPatientPrefixId;
    }

    public void setFPatientPrefixId(String fPatientPrefixId) {
        this.fPatientPrefixId = fPatientPrefixId;
    }

    public String getPatientPrefixDescription() {
        return patientPrefixDescription;
    }

    public void setPatientPrefixDescription(String patientPrefixDescription) {
        this.patientPrefixDescription = patientPrefixDescription;
    }

    public String getFSexId() {
        return fSexId;
    }

    public void setFSexId(String fSexId) {
        this.fSexId = fSexId;
    }

    public String getFTlockId() {
        return fTlockId;
    }

    public void setFTlockId(String fTlockId) {
        this.fTlockId = fTlockId;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getPatientPrefixDescriptione() {
        return patientPrefixDescriptione;
    }

    public void setPatientPrefixDescriptione(String patientPrefixDescriptione) {
        this.patientPrefixDescriptione = patientPrefixDescriptione;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fPatientPrefixId != null ? fPatientPrefixId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FPatientPrefix)) {
            return false;
        }
        FPatientPrefix other = (FPatientPrefix) object;
        if ((this.fPatientPrefixId == null && other.fPatientPrefixId != null) || (this.fPatientPrefixId != null && !this.fPatientPrefixId.equals(other.fPatientPrefixId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaintranet.FPatientPrefix[fPatientPrefixId=" + fPatientPrefixId + "]";
    }

}
