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
@Table(name = "back_b_department_sub", catalog = "bangna", schema = "public")
@NamedQueries({@NamedQuery(name = "BackBDepartmentSub.findAll", query = "SELECT b FROM BackBDepartmentSub b")})
public class BackBDepartmentSub implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "b_department_sub_id", nullable = false, length = 255)
    private String bDepartmentSubId="";
    @Column(name = "b_department_sub_namet", length = 255)
    private String bDepartmentSubNamet="";
    @Column(name = "b_department_id", length = 255)
    private String bDepartmentId="";
    @Column(name = "branch_id", length = 255)
    private String branchId="";
    @Column(name = "paid_id", length = 255)
    private String paidId="";
    @Column(name = "department_sub_active", length = 255)
    private String departmentSubActive="";

    public BackBDepartmentSub() {
    }
    public void initial(){
        bDepartmentSubId="";
        bDepartmentSubNamet="";
        bDepartmentId="";
        branchId="";
        paidId="";
        departmentSubActive="";
    }
    public String getBackBDepartmentSub(){
        return "back_b_department_sub";
    }
    public String getFBDepartmentSubId(){
        return "b_department_sub_id";
    }
    public String getFBDepartmentSubNamet(){
        return "b_department_sub_namet";
    }
    public String getFBDepartmentId(){
        return "b_department_id";
    }
    public String getFBranchId(){
        return "branch_id";
    }
    public String getFPaidId(){
        return "paid_id";
    }
    public String getFDepartmentSubActive(){
        return "department_sub_active";
    }

    public BackBDepartmentSub(String bDepartmentSubId) {
        this.bDepartmentSubId = bDepartmentSubId;
    }

    public String getBDepartmentSubId() {
        return bDepartmentSubId;
    }

    public void setBDepartmentSubId(String bDepartmentSubId) {
        this.bDepartmentSubId = bDepartmentSubId;
    }

    public String getBDepartmentSubNamet() {
        return bDepartmentSubNamet;
    }

    public void setBDepartmentSubNamet(String bDepartmentSubNamet) {
        this.bDepartmentSubNamet = bDepartmentSubNamet;
    }

    public String getBDepartmentId() {
        return bDepartmentId;
    }

    public void setBDepartmentId(String bDepartmentId) {
        this.bDepartmentId = bDepartmentId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getPaidId() {
        return paidId;
    }

    public void setPaidId(String paidId) {
        this.paidId = paidId;
    }

    public String getDepartmentSubActive() {
        return departmentSubActive;
    }

    public void setDepartmentSubActive(String departmentSubActive) {
        this.departmentSubActive = departmentSubActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bDepartmentSubId != null ? bDepartmentSubId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BackBDepartmentSub)) {
            return false;
        }
        BackBDepartmentSub other = (BackBDepartmentSub) object;
        if ((this.bDepartmentSubId == null && other.bDepartmentSubId != null) || (this.bDepartmentSubId != null && !this.bDepartmentSubId.equals(other.bDepartmentSubId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.BackBDepartmentSub[bDepartmentSubId=" + bDepartmentSubId + "]";
    }

}
