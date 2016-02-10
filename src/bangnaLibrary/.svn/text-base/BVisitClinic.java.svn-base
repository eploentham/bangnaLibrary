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
@Table(name = "b_visit_clinic")
@NamedQueries({
    @NamedQuery(name = "BVisitClinic.findAll", query = "SELECT b FROM BVisitClinic b")})
public class BVisitClinic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "b_visit_clinic_id")
    private String bVisitClinicId;
    @Column(name = "visit_clinic_number")
    private String visitClinicNumber;
    @Column(name = "visit_clinic_description")
    private String visitClinicDescription;
    @Column(name = "f_service_group_id")
    private String fServiceGroupId;
    @Column(name = "visit_clinic_active")
    private String visitClinicActive;

    public BVisitClinic() {
    }
    public String getBVisitClinic(){
        return "b_visit_clinic";
    }
    public String getFBVisitClinicId(){
        return "b_visit_clinic_id";
    }
    public String getFBVisitClinicNumber(){
        return "visit_clinic_number";
    }
    public String getFVisitClinicDescription(){
        return "visit_clinic_description";
    }
    public String getFFServiceGroupId(){
        return "f_service_group_id";
    }
    public String getFVisitClinicActive(){
        return "visit_clinic_active";
    }

    public BVisitClinic(String bVisitClinicId) {
        this.bVisitClinicId = bVisitClinicId;
    }

    public String getBVisitClinicId() {
        return bVisitClinicId;
    }

    public void setBVisitClinicId(String bVisitClinicId) {
        this.bVisitClinicId = bVisitClinicId;
    }

    public String getVisitClinicNumber() {
        return visitClinicNumber;
    }

    public void setVisitClinicNumber(String visitClinicNumber) {
        this.visitClinicNumber = visitClinicNumber;
    }

    public String getVisitClinicDescription() {
        return visitClinicDescription;
    }

    public void setVisitClinicDescription(String visitClinicDescription) {
        this.visitClinicDescription = visitClinicDescription;
    }

    public String getFServiceGroupId() {
        return fServiceGroupId;
    }

    public void setFServiceGroupId(String fServiceGroupId) {
        this.fServiceGroupId = fServiceGroupId;
    }

    public String getVisitClinicActive() {
        return visitClinicActive;
    }

    public void setVisitClinicActive(String visitClinicActive) {
        this.visitClinicActive = visitClinicActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bVisitClinicId != null ? bVisitClinicId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BVisitClinic)) {
            return false;
        }
        BVisitClinic other = (BVisitClinic) object;
        if ((this.bVisitClinicId == null && other.bVisitClinicId != null) || (this.bVisitClinicId != null && !this.bVisitClinicId.equals(other.bVisitClinicId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.BVisitClinic[bVisitClinicId=" + bVisitClinicId + "]";
    }

}
