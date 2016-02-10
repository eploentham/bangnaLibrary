/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import com.bangna.usecase.connection.Persistent;
//import java.io.Serializable;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;

/**
 *
 * @author root
 */
//@Entity
//@Table(name = "bangna_t_contact_detail", catalog = "bangna", schema = "public")
//@NamedQueries({@NamedQuery(name = "BangnaTContactDetail.findAll", query = "SELECT b FROM BangnaTContactDetail b"), @NamedQuery(name = "BangnaTContactDetail.findByTContactDetailId", query = "SELECT b FROM BangnaTContactDetail b WHERE b.tContactDetailId = :tContactDetailId"), @NamedQuery(name = "BangnaTContactDetail.findByTContactId", query = "SELECT b FROM BangnaTContactDetail b WHERE b.tContactId = :tContactId"), @NamedQuery(name = "BangnaTContactDetail.findByContactId", query = "SELECT b FROM BangnaTContactDetail b WHERE b.contactId = :contactId"), @NamedQuery(name = "BangnaTContactDetail.findByContactDetailDate", query = "SELECT b FROM BangnaTContactDetail b WHERE b.contactDetailDate = :contactDetailDate"), @NamedQuery(name = "BangnaTContactDetail.findByPatientHn", query = "SELECT b FROM BangnaTContactDetail b WHERE b.patientHn = :patientHn"), @NamedQuery(name = "BangnaTContactDetail.findByPatientId", query = "SELECT b FROM BangnaTContactDetail b WHERE b.patientId = :patientId"), @NamedQuery(name = "BangnaTContactDetail.findByPtType", query = "SELECT b FROM BangnaTContactDetail b WHERE b.ptType = :ptType"), @NamedQuery(name = "BangnaTContactDetail.findByRemark", query = "SELECT b FROM BangnaTContactDetail b WHERE b.remark = :remark"), @NamedQuery(name = "BangnaTContactDetail.findByDateCreate", query = "SELECT b FROM BangnaTContactDetail b WHERE b.dateCreate = :dateCreate"), @NamedQuery(name = "BangnaTContactDetail.findByDateModify", query = "SELECT b FROM BangnaTContactDetail b WHERE b.dateModify = :dateModify"), @NamedQuery(name = "BangnaTContactDetail.findByDateCancel", query = "SELECT b FROM BangnaTContactDetail b WHERE b.dateCancel = :dateCancel"), @NamedQuery(name = "BangnaTContactDetail.findByUserCreate", query = "SELECT b FROM BangnaTContactDetail b WHERE b.userCreate = :userCreate"), @NamedQuery(name = "BangnaTContactDetail.findByUserModify", query = "SELECT b FROM BangnaTContactDetail b WHERE b.userModify = :userModify"), @NamedQuery(name = "BangnaTContactDetail.findByUserCancel", query = "SELECT b FROM BangnaTContactDetail b WHERE b.userCancel = :userCancel"), @NamedQuery(name = "BangnaTContactDetail.findByTContactDetailActive", query = "SELECT b FROM BangnaTContactDetail b WHERE b.tContactDetailActive = :tContactDetailActive"), @NamedQuery(name = "BangnaTContactDetail.findByContactDetailTime", query = "SELECT b FROM BangnaTContactDetail b WHERE b.contactDetailTime = :contactDetailTime"), @NamedQuery(name = "BangnaTContactDetail.findByPatientFullnamet", query = "SELECT b FROM BangnaTContactDetail b WHERE b.patientFullnamet = :patientFullnamet")})
public class BangnaTContactDetail extends Persistent{
//    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @Column(name = "t_contact_detail_id", nullable = false, length = 255)
    private String tContactDetailId="";
//    @Column(name = "t_contact_id", length = 255)
    private String tContactId="";
//    @Column(name = "contact_id", length = 255)
    private String contactId="", contactNamet="";
//    @Column(name = "contact_detail_date", length = 255)
    private String contactDetailDate="";
//    @Column(name = "patient_hn", length = 255)
    private String patientHn="";
//    @Column(name = "patient_id", length = 255)
    private String patientId="";
//    @Column(name = "pt_type", length = 255)
    private String ptType="";
//    @Column(name = "remark", length = 255)
    private String remark="";
//    @Column(name = "date_create", length = 255)
    private String dateCreate="";
//    @Column(name = "date_modify", length = 255)
    private String dateModify="";
//    @Column(name = "date_cancel", length = 255)
    private String dateCancel="";
//    @Column(name = "user_create", length = 255)
    private String userCreate="";
//    @Column(name = "user_modify", length = 255)
    private String userModify="";
//    @Column(name = "user_cancel", length = 255)
    private String userCancel="";
//    @Column(name = "t_contact_detail_active", length = 255)
    private String tContactDetailActive="";
//    @Column(name = "contact_detail_time", length = 255)
    private String contactDetailTime="";
//    @Column(name = "patient_fullnamet", length = 255)
    private String patientFullnamet="";

    public BangnaTContactDetail() {
    }

    public String getBangnaTContactDetail(){
        return "bangna_t_contact_detail";
    }

    public String getFTContactDetailId(){
        return "t_contact_detail_id";
    }
    public String getFTContactId(){
        return "t_contact_id";
    }
    public String getFContactId(){
        return "contact_id";
    }
    public String getFContactDetailDate(){
        return "contact_detail_date";
    }
    public String getFPatientHn(){
        return "patient_hn";
    }
    public String getFPatientId(){
        return "patient_id";
    }
    public String getFPtType(){
        return "pt_type";
    }
    public String getFRemark(){
        return "remark";
    }
    public String getFDateCreate(){
        return "date_create";
    }
    public String getFDateModify(){
        return "date_modify";
    }
    public String getFDateCancel(){
        return "date_cancel";
    }
    public String getFUserCreate(){
        return "user_create";
    }
    public String getFUserModify(){
        return "user_modify";
    }
    public String getFUserCancel(){
        return "user_cancel";
    }
    public String getFTContactDetailActive(){
        return "t_contact_detail_active";
    }
    public String getFContactDetailTime(){
        return "contact_detail_time";
    }
    public String getFPatientFullnamet(){
        return "patient_fullnamet";
    }
    public String getFContactNamet(){
        return "contact_namet";
    }

    public BangnaTContactDetail(String tContactDetailId) {
        this.tContactDetailId = tContactDetailId;
    }

    public String getTContactDetailId() {
        return tContactDetailId;
    }

    public void setTContactDetailId(String tContactDetailId) {
        this.tContactDetailId = tContactDetailId;
    }

    public String getTContactId() {
        return tContactId;
    }
    public void setTContactId(String tContactId) {
        this.tContactId = tContactId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getContactDetailDate() {
        return contactDetailDate;
    }

    public void setContactDetailDate(String contactDetailDate) {
        this.contactDetailDate = contactDetailDate;
    }

    public String getPatientHn() {
        return patientHn;
    }
    public void setPatientHn(String patientHn) {
        this.patientHn = patientHn;
    }

    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPtType() {
        return ptType;
    }
    public void setPtType(String ptType) {
        this.ptType = ptType;
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDateModify() {
        return dateModify;
    }

    public void setDateModify(String dateModify) {
        this.dateModify = dateModify;
    }

    public String getDateCancel() {
        return dateCancel;
    }

    public void setDateCancel(String dateCancel) {
        this.dateCancel = dateCancel;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public String getUserModify() {
        return userModify;
    }

    public void setUserModify(String userModify) {
        this.userModify = userModify;
    }

    public String getUserCancel() {
        return userCancel;
    }

    public void setUserCancel(String userCancel) {
        this.userCancel = userCancel;
    }

    public String getTContactDetailActive() {
        return tContactDetailActive;
    }

    public void setTContactDetailActive(String tContactDetailActive) {
        this.tContactDetailActive = tContactDetailActive;
    }

    public String getContactDetailTime() {
        return contactDetailTime;
    }

    public void setContactDetailTime(String contactDetailTime) {
        this.contactDetailTime = contactDetailTime;
    }

    public String getPatientFullnamet() {
        return patientFullnamet;
    }
    public void setPatientFullnamet(String patientFullnamet) {
        this.patientFullnamet = patientFullnamet;
    }

    public String getContactNamet() {
        return contactNamet;
    }
    public void setContactNamet(String contactNamet) {
        this.contactNamet = contactNamet;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (tContactDetailId != null ? tContactDetailId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof BangnaTContactDetail)) {
//            return false;
//        }
//        BangnaTContactDetail other = (BangnaTContactDetail) object;
//        if ((this.tContactDetailId == null && other.tContactDetailId != null) || (this.tContactDetailId != null && !this.tContactDetailId.equals(other.tContactDetailId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "bangnaLibrary.BangnaTContactDetail[tContactDetailId=" + tContactDetailId + "]";
//    }

}
