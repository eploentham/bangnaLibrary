/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bangna.object;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.*;
import java.util.*;
/**
 *
 * @author pop
 */
@Entity
@Table(name = "b_department", catalog = "bangna", schema = "public")
@NamedQueries({@NamedQuery(name = "BDepartment.findAll", query = "SELECT b FROM BDepartment b"), @NamedQuery(name = "BDepartment.findByDepartmentId", query = "SELECT b FROM BDepartment b WHERE b.departmentId = :departmentId"), @NamedQuery(name = "BDepartment.findByDepartmentNamet", query = "SELECT b FROM BDepartment b WHERE b.departmentNamet = :departmentNamet"), @NamedQuery(name = "BDepartment.findByDepartmentActive", query = "SELECT b FROM BDepartment b WHERE b.departmentActive = :departmentActive"), @NamedQuery(name = "BDepartment.findByBranchId", query = "SELECT b FROM BDepartment b WHERE b.branchId = :branchId")})
public class BDepartment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "department_id", nullable = false, length = 255)
    private String departmentId;
    @Column(name = "department_namet", length = 255)
    private String departmentNamet;
    @Column(name = "department_active", length = 255)
    private String departmentActive;
    @Column(name = "branch_id", length = 255)
    private String branchId;
    @Column(name = "sort1", length = 255)
    private String sort1;
    @Column(name = "telephone", length = 255)
    private String telephone;
    
    public BDepartment() {
    }

    public String getBDepartment() {
        return "b_department";
    }

    public BDepartment(String departmentId) {
        this.departmentId = departmentId;
    }
    public String getFDepartmentId() {
        return "department_id";
    }
    public String getFDepartmentNamet(){
        return "department_namet";
    }
    public String getFDepartmentActive(){
        return "department_active";
    }
    public String getFBranchId() {
        return "branch_id";
    }
    public String getFSort1() {
        return "sort1";
    }
    public String getFTelephone() {
        return "telephone";
    }

    public String getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentNamet() {
        return departmentNamet;
    }
    public void setDepartmentNamet(String departmentNamet) {
        this.departmentNamet = departmentNamet;
    }

    public String getDepartmentActive() {
        return departmentActive;
    }
    public void setDepartmentActive(String departmentActive) {
        this.departmentActive = departmentActive;
    }

    public String getBranchId() {
        return branchId;
    }
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }
    public String getSort1() {
        return sort1;
    }
    public void setSort1(String sort1) {
        this.sort1 = sort1;
    }
    
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BDepartment)) {
            return false;
        }
        BDepartment other = (BDepartment) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaintranet.BDepartment[departmentId=" + departmentId + "]";
    }
    
}
