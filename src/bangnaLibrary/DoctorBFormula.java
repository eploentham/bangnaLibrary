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
@Table(name = "doctor_b_formula", catalog = "bangna5", schema = "public")
@NamedQueries({
    @NamedQuery(name = "DoctorBFormula.findAll", query = "SELECT b FROM DoctorBFormula b"),
    @NamedQuery(name = "DoctorBFormula.findByFormulaId", query = "SELECT b FROM DoctorBFormula b WHERE b.formulaId = :formulaId"),
    @NamedQuery(name = "DoctorBFormula.findByFormulaNamet", query = "SELECT b FROM DoctorBFormula b WHERE b.formulaNamet = :formulaNamet"),
    @NamedQuery(name = "DoctorBFormula.findByFormulaActive", query = "SELECT b FROM DoctorBFormula b WHERE b.formulaActive = :formulaActive")})
public class DoctorBFormula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "formula_id", nullable = false, length = 255)
    private String formulaId="";
    @Column(name = "formula_namet", length = 255)
    private String formulaNamet="";
    @Column(name = "formula_active", length = 255)
    private String formulaActive="";
    @Column(name = "branch_id", length = 255)
    private String branchId="";
    @Column(name = "remark", length = 255)
    private String remark="";
    @Column(name = "status_formula", length = 255)
    private String statusFormula="";

    public DoctorBFormula() {
    }
    public void initial(){
        formulaId="";
        formulaNamet="";
        formulaActive="";
        branchId="";
        remark="";
    }
    public String getDoctorBFormula(){
        return "doctor_b_formula";
    }
    public String getFFormulaId(){
        return "formula_id";
    }
    public String getFFormulaNamet(){
        return "formula_namet";
    }
    public String getFFormulaActive(){
        return "formula_active";
    }
    public String getFBranchId(){
        return "branch_id";
    }
    public String getFRemark(){
        return "remark";
    }
    public String getFStatusFormula(){
        return "status_formula";
    }

    public DoctorBFormula(String formulaId) {
        this.formulaId = formulaId;
    }

    public String getFormulaId() {
        return formulaId;
    }

    public void setFormulaId(String formulaId) {
        this.formulaId = formulaId;
    }

    public String getFormulaNamet() {
        return formulaNamet;
    }

    public void setFormulaNamet(String formulaNamet) {
        this.formulaNamet = formulaNamet;
    }

    public String getFormulaActive() {
        return formulaActive;
    }
    public void setFormulaActive(String formulaActive) {
        this.formulaActive = formulaActive;
    }

    public String getBranchId() {
        return branchId;
    }
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatusFormula() {
        return statusFormula;
    }
    public void setStatusFormula(String statusFormula) {
        this.statusFormula = statusFormula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formulaId != null ? formulaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoctorBFormula)) {
            return false;
        }
        DoctorBFormula other = (DoctorBFormula) object;
        if ((this.formulaId == null && other.formulaId != null) || (this.formulaId != null && !this.formulaId.equals(other.formulaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.BackBDoctorPayFormula[formulaId=" + formulaId + "]";
    }

}
