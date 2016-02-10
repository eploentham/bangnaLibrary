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
@Table(name = "doctor_b_specialist")
@NamedQueries({
    @NamedQuery(name = "DoctorBSpecialist.findAll", query = "SELECT d FROM DoctorBSpecialist d")})
public class DoctorBSpecialist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "specialist_id")
    private String specialistId;
    @Column(name = "specialist_namet")
    private String specialistNamet;
    @Column(name = "specialist_active")
    private String specialistActive;
    @Column(name = "sort1")
    private String sort1;
    @Column(name = "branch_id")
    private String branchId;

    public DoctorBSpecialist() {
    }
    public String getDoctorBSpecialist() {
        return "doctor_b_specialist";
    }

    public String getFSpecialistId() {
        return "specialist_id";
    }
    public String getFSpecialistNamet() {
        return "specialist_namet";
    }
    public String getFSpecialistActive() {
        return "specialist_active";
    }
    public String getFSort1() {
        return "sort1";
    }
    public String getFBranchId() {
        return "branch_id";
    }

    public DoctorBSpecialist(String specialistId) {
        this.specialistId = specialistId;
    }

    public String getSpecialistId() {
        return specialistId;
    }

    public void setSpecialistId(String specialistId) {
        this.specialistId = specialistId;
    }

    public String getSpecialistNamet() {
        return specialistNamet;
    }

    public void setSpecialistNamet(String specialistNamet) {
        this.specialistNamet = specialistNamet;
    }

    public String getSpecialistActive() {
        return specialistActive;
    }

    public void setSpecialistActive(String specialistActive) {
        this.specialistActive = specialistActive;
    }

    public String getSort1() {
        return sort1;
    }
    public void setSort1(String sort1) {
        this.sort1 = sort1;
    }

    public String getBranchId() {
        return branchId;
    }
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specialistId != null ? specialistId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoctorBSpecialist)) {
            return false;
        }
        DoctorBSpecialist other = (DoctorBSpecialist) object;
        if ((this.specialistId == null && other.specialistId != null) || (this.specialistId != null && !this.specialistId.equals(other.specialistId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.DoctorBSpecialist[specialistId=" + specialistId + "]";
    }

}
