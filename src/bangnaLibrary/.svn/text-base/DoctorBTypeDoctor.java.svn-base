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
@Table(name = "doctor_b_type_doctor")
@NamedQueries({
    @NamedQuery(name = "DoctorBTypeDoctor.findAll", query = "SELECT d FROM DoctorBTypeDoctor d")})
public class DoctorBTypeDoctor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "type_doctor_id")
    private String typeDoctorId;
    @Column(name = "type_doctor_namet")
    private String typeDoctorNamet;
    @Column(name = "type_doctor_active")
    private String typeDoctorActive;
    @Column(name = "type_doctor_remark")
    private String typeDoctorRemark;
    @Column(name = "branch_id")
    private String branchId;

    public DoctorBTypeDoctor() {
    }
    public String getDoctorBTypeDoctor() {
        return "doctor_b_type_doctor";
    }
    public String getFTypeDoctorId() {
        return "type_doctor_id";
    }
    public String getFTypeDoctorNamet() {
        return "type_doctor_namet";
    }
    public String getFTypeDoctorActive() {
        return "type_doctor_active";
    }
    public String getFTypeDoctorRemark() {
        return "type_doctor_remark";
    }
    public String getFBranchId() {
        return "branch_id";
    }

    public DoctorBTypeDoctor(String typeDoctorId) {
        this.typeDoctorId = typeDoctorId;
    }

    public String getTypeDoctorId() {
        return typeDoctorId;
    }

    public void setTypeDoctorId(String typeDoctorId) {
        this.typeDoctorId = typeDoctorId;
    }

    public String getTypeDoctorNamet() {
        return typeDoctorNamet;
    }

    public void setTypeDoctorNamet(String typeDoctorNamet) {
        this.typeDoctorNamet = typeDoctorNamet;
    }

    public String getTypeDoctorActive() {
        return typeDoctorActive;
    }

    public void setTypeDoctorActive(String typeDoctorActive) {
        this.typeDoctorActive = typeDoctorActive;
    }

    public String getTypeDoctorRemark() {
        return typeDoctorRemark;
    }
    public void setTypeDoctorRemark(String typeDoctorRemark) {
        this.typeDoctorRemark = typeDoctorRemark;
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
        hash += (typeDoctorId != null ? typeDoctorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoctorBTypeDoctor)) {
            return false;
        }
        DoctorBTypeDoctor other = (DoctorBTypeDoctor) object;
        if ((this.typeDoctorId == null && other.typeDoctorId != null) || (this.typeDoctorId != null && !this.typeDoctorId.equals(other.typeDoctorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.DoctorBTypeDoctor[typeDoctorId=" + typeDoctorId + "]";
    }

}
