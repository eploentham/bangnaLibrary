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
@Table(name = "back_b_department", catalog = "bangna", schema = "public")
@NamedQueries({@NamedQuery(name = "BackBDepartment.findAll", query = "SELECT b FROM BackBDepartment b")})
public class BackBDepartment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "b_department_id", nullable = false, length = 255)
    private String bDepartmentId="";
    @Column(name = "b_department_namet", length = 255)
    private String bDepartmentNamet="";
    @Column(name = "b_department_active", length = 255)
    private String bDepartmentActive="";

    public BackBDepartment() {
    }
    public void initial(){
        bDepartmentId="";
        bDepartmentNamet="";
        bDepartmentActive="";
    }

    public String getBackBDepartment(){
        return "back_b_department";
    }
    public String getFBDepartmentId(){
        return "b_department_id";
    }
    public String getFBDepartmentNamet(){
        return "b_department_namet";
    }
    public String getFBDepartmentActive(){
        return "b_department_active";
    }

    public BackBDepartment(String bDepartmentId) {
        this.bDepartmentId = bDepartmentId;
    }

    public String getBDepartmentId() {
        return bDepartmentId;
    }

    public void setBDepartmentId(String bDepartmentId) {
        this.bDepartmentId = bDepartmentId;
    }

    public String getBDepartmentNamet() {
        return bDepartmentNamet;
    }

    public void setBDepartmentNamet(String bDepartmentNamet) {
        this.bDepartmentNamet = bDepartmentNamet;
    }

    public String getBDepartmentActive() {
        return bDepartmentActive;
    }

    public void setBDepartmentActive(String bDepartmentActive) {
        this.bDepartmentActive = bDepartmentActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bDepartmentId != null ? bDepartmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BackBDepartment)) {
            return false;
        }
        BackBDepartment other = (BackBDepartment) object;
        if ((this.bDepartmentId == null && other.bDepartmentId != null) || (this.bDepartmentId != null && !this.bDepartmentId.equals(other.bDepartmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.BackBDepartment[bDepartmentId=" + bDepartmentId + "]";
    }

}
