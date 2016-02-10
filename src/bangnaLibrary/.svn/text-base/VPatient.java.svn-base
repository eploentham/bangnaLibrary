/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "v_patient", catalog = "front_bangna5", schema = "public")
@NamedQueries({
    @NamedQuery(name = "VPatient.findAll", query = "SELECT v FROM VPatient v"),
    @NamedQuery(name = "VPatient.findByTPatientId", query = "SELECT v FROM VPatient v WHERE v.tPatientId = :tPatientId"),
    @NamedQuery(name = "VPatient.findByPatientHn", query = "SELECT v FROM VPatient v WHERE v.patientHn = :patientHn"),
    @NamedQuery(name = "VPatient.findByPatientFirstname", query = "SELECT v FROM VPatient v WHERE v.patientFirstname = :patientFirstname"),
    @NamedQuery(name = "VPatient.findByPatientLastname", query = "SELECT v FROM VPatient v WHERE v.patientLastname = :patientLastname"),
    @NamedQuery(name = "VPatient.findByPatientBirthday", query = "SELECT v FROM VPatient v WHERE v.patientBirthday = :patientBirthday"),
    @NamedQuery(name = "VPatient.findByPatientPid", query = "SELECT v FROM VPatient v WHERE v.patientPid = :patientPid"),
    @NamedQuery(name = "VPatient.findBySexDescription", query = "SELECT v FROM VPatient v WHERE v.sexDescription = :sexDescription"),
    @NamedQuery(name = "VPatient.findByFPatientRelationId", query = "SELECT v FROM VPatient v WHERE v.fPatientRelationId = :fPatientRelationId"),
    @NamedQuery(name = "VPatient.findByPatientPrefixDescription", query = "SELECT v FROM VPatient v WHERE v.patientPrefixDescription = :patientPrefixDescription"),
    @NamedQuery(name = "VPatient.findByPatientOccupationDescription", query = "SELECT v FROM VPatient v WHERE v.patientOccupationDescription = :patientOccupationDescription"),
    @NamedQuery(name = "VPatient.findByPatientNationDescription", query = "SELECT v FROM VPatient v WHERE v.patientNationDescription = :patientNationDescription"),
    @NamedQuery(name = "VPatient.findByPatientMarriageStatusDescription", query = "SELECT v FROM VPatient v WHERE v.patientMarriageStatusDescription = :patientMarriageStatusDescription"),
    @NamedQuery(name = "VPatient.findByPatientBloodGroupDescription", query = "SELECT v FROM VPatient v WHERE v.patientBloodGroupDescription = :patientBloodGroupDescription"),
    @NamedQuery(name = "VPatient.findByPatientTambon", query = "SELECT v FROM VPatient v WHERE v.patientTambon = :patientTambon"),
    @NamedQuery(name = "VPatient.findByPatientAmphur", query = "SELECT v FROM VPatient v WHERE v.patientAmphur = :patientAmphur"),
    @NamedQuery(name = "VPatient.findByPatientChangwat", query = "SELECT v FROM VPatient v WHERE v.patientChangwat = :patientChangwat"),
    @NamedQuery(name = "VPatient.findByPatientPhoneNumber", query = "SELECT v FROM VPatient v WHERE v.patientPhoneNumber = :patientPhoneNumber"),
    @NamedQuery(name = "VPatient.findByPatientContactPhoneNumber", query = "SELECT v FROM VPatient v WHERE v.patientContactPhoneNumber = :patientContactPhoneNumber"),
    @NamedQuery(name = "VPatient.findByPatientPatientMobilePhone", query = "SELECT v FROM VPatient v WHERE v.patientPatientMobilePhone = :patientPatientMobilePhone"),
    @NamedQuery(name = "VPatient.findByPatientContactMobilePhone", query = "SELECT v FROM VPatient v WHERE v.patientContactMobilePhone = :patientContactMobilePhone"),
    @NamedQuery(name = "VPatient.findByContactNamet", query = "SELECT v FROM VPatient v WHERE v.contactNamet = :contactNamet"),
    @NamedQuery(name = "VPatient.findByRemark1", query = "SELECT v FROM VPatient v WHERE v.remark1 = :remark1"),
    @NamedQuery(name = "VPatient.findByRemark2", query = "SELECT v FROM VPatient v WHERE v.remark2 = :remark2"),
    @NamedQuery(name = "VPatient.findByContactJoinNamet", query = "SELECT v FROM VPatient v WHERE v.contactJoinNamet = :contactJoinNamet")})
public class VPatient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "t_patient_id", length = 255)
    @Id
    private String tPatientId="";
    @Column(name = "patient_hn", length = 255)
    private String patientHn="";
    @Column(name = "patient_firstname", length = 255)
    private String patientFirstname="";
    @Column(name = "patient_lastname", length = 255)
    private String patientLastname="";
    @Column(name = "patient_birthday", length = 255)
    private String patientBirthday="";
    @Column(name = "patient_pid", length = 255)
    private String patientPid="";
    @Column(name = "sex_description", length = 255)
    private String sexDescription="";
    @Column(name = "f_patient_relation_id", length = 255)
    private String fPatientRelationId="";
    @Column(name = "patient_prefix_description", length = 255)
    private String patientPrefixDescription="";
    @Column(name = "patient_occupation_description", length = 255)
    private String patientOccupationDescription="";
    @Column(name = "patient_nation_description", length = 255)
    private String patientNationDescription="";
    @Column(name = "patient_marriage_status_description", length = 255)
    private String patientMarriageStatusDescription="";
    @Column(name = "patient_blood_group_description", length = 255)
    private String patientBloodGroupDescription="";
    @Column(name = "patient_tambon", length = 255)
    private String patientTambon="";
    @Column(name = "patient_amphur", length = 255)
    private String patientAmphur="";
    @Column(name = "patient_changwat", length = 255)
    private String patientChangwat="";
    @Column(name = "patient_phone_number", length = 255)
    private String patientPhoneNumber="";
    @Column(name = "patient_contact_phone_number", length = 255)
    private String patientContactPhoneNumber="";
    @Column(name = "patient_patient_mobile_phone", length = 255)
    private String patientPatientMobilePhone="";
    @Column(name = "patient_contact_mobile_phone", length = 255)
    private String patientContactMobilePhone="";
    @Column(name = "contact_namet", length = 255)
    private String contactNamet="";
    @Column(name = "remark1", length = 2000)
    private String remark1="";
    @Column(name = "remark2", length = 2000)
    private String remark2="";
    @Column(name = "contact_join_namet", length = 255)
    private String contactJoinNamet="";
    @Column(name = "age1", length = 255)
    private String age1="";

    public VPatient() {
    }
    public void initial(){
        tPatientId="";
        patientHn="";
        patientFirstname="";
        patientLastname="";
        patientBirthday="";
        patientPid="";
        sexDescription="";
        fPatientRelationId="";
        patientPrefixDescription="";
        patientOccupationDescription="";
        patientNationDescription="";
        patientMarriageStatusDescription="";
        patientBloodGroupDescription="";
        patientTambon="";
        patientAmphur="";
        patientChangwat="";
        patientPhoneNumber="";
        patientContactPhoneNumber="";
        patientPatientMobilePhone="";
        patientContactMobilePhone="";
        contactNamet="";
        remark1="";
        remark2="";
        contactJoinNamet="";
        age1="";
    }

    public String getVPatient() {
        return "v_patient";
    }

    public String getFTPatientId(){
        return "t_patient_id";
    }
    public String getFPatientHn(){
        return "patient_hn";
    }
    public String getFPatientFirstname(){
        return "patient_firstname";
    }
    public String getFPatientLastname(){
        return "patient_lastname";
    }
    public String getFPatientBirthday(){
        return "patient_birthday";
    }
    public String getFPatientPid(){
        return "patient_pid";
    }
    public String getFSexDescription(){
        return "sex_description";
    }
    public String getFFPatientRelationId(){
        return "f_patient_relation_id";
    }
    public String getFPatientPrefixDescription(){
        return "patient_prefix_description";
    }
    public String getFPatientOccupationDescription(){
        return "patient_occupation_description";
    }
    public String getFPatientNationDescription(){
        return "patient_nation_description";
    }
    public String getFPatientMarriageStatusDescription(){
        return "patient_marriage_status_description";
    }
    public String getFPatientBloodGroupDescription(){
        return "patient_blood_group_description";
    }
    public String getFPatientTambon(){
        return "patient_tambon";
    }
    public String getFPatientAmphur(){
        return "patient_amphur";
    }
    public String getFPatientChangwat(){
        return "patient_changwat";
    }
    public String getFPatientPhoneNumber(){
        return "patient_phone_number";
    }
    public String getFPatientContactPhoneNumber(){
        return "patient_contact_phone_number";
    }
    public String getFPatientPatientMobilePhone(){
        return "patient_patient_mobile_phone";
    }
    public String getFPatientContactMobilePhone(){
        return "patient_contact_mobile_phone";
    }
    public String getFContactNamet(){
        return "contact_namet";
    }
    public String getFRemark1(){
        return "remark1";
    }
    public String getFRemark2(){
        return "remark2";
    }
    public String getFContactJoinNamet(){
        return "contact_join_namet";
    }
    public String getFAge1(){
        return "age1";
    }
    

    public String getTPatientId() {
        return tPatientId;
    }

    public void setTPatientId(String tPatientId) {
        this.tPatientId = tPatientId;
    }

    public String getPatientHn() {
        return patientHn;
    }

    public void setPatientHn(String patientHn) {
        this.patientHn = patientHn;
    }

    public String getPatientFirstname() {
        return patientFirstname;
    }

    public void setPatientFirstname(String patientFirstname) {
        this.patientFirstname = patientFirstname;
    }

    public String getPatientLastname() {
        return patientLastname;
    }

    public void setPatientLastname(String patientLastname) {
        this.patientLastname = patientLastname;
    }

    public String getPatientBirthday() {
        return patientBirthday;
    }

    public void setPatientBirthday(String patientBirthday) {
        this.patientBirthday = patientBirthday;
    }

    public String getPatientPid() {
        return patientPid;
    }

    public void setPatientPid(String patientPid) {
        this.patientPid = patientPid;
    }

    public String getSexDescription() {
        return sexDescription;
    }

    public void setSexDescription(String sexDescription) {
        this.sexDescription = sexDescription;
    }

    public String getFPatientRelationId() {
        return fPatientRelationId;
    }

    public void setFPatientRelationId(String fPatientRelationId) {
        this.fPatientRelationId = fPatientRelationId;
    }

    public String getPatientPrefixDescription() {
        return patientPrefixDescription;
    }

    public void setPatientPrefixDescription(String patientPrefixDescription) {
        this.patientPrefixDescription = patientPrefixDescription;
    }

    public String getPatientOccupationDescription() {
        return patientOccupationDescription;
    }

    public void setPatientOccupationDescription(String patientOccupationDescription) {
        this.patientOccupationDescription = patientOccupationDescription;
    }

    public String getPatientNationDescription() {
        return patientNationDescription;
    }

    public void setPatientNationDescription(String patientNationDescription) {
        this.patientNationDescription = patientNationDescription;
    }

    public String getPatientMarriageStatusDescription() {
        return patientMarriageStatusDescription;
    }

    public void setPatientMarriageStatusDescription(String patientMarriageStatusDescription) {
        this.patientMarriageStatusDescription = patientMarriageStatusDescription;
    }

    public String getPatientBloodGroupDescription() {
        return patientBloodGroupDescription;
    }

    public void setPatientBloodGroupDescription(String patientBloodGroupDescription) {
        this.patientBloodGroupDescription = patientBloodGroupDescription;
    }

    public String getPatientTambon() {
        return patientTambon;
    }

    public void setPatientTambon(String patientTambon) {
        this.patientTambon = patientTambon;
    }

    public String getPatientAmphur() {
        return patientAmphur;
    }

    public void setPatientAmphur(String patientAmphur) {
        this.patientAmphur = patientAmphur;
    }

    public String getPatientChangwat() {
        return patientChangwat;
    }

    public void setPatientChangwat(String patientChangwat) {
        this.patientChangwat = patientChangwat;
    }

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    public String getPatientContactPhoneNumber() {
        return patientContactPhoneNumber;
    }

    public void setPatientContactPhoneNumber(String patientContactPhoneNumber) {
        this.patientContactPhoneNumber = patientContactPhoneNumber;
    }

    public String getPatientPatientMobilePhone() {
        return patientPatientMobilePhone;
    }

    public void setPatientPatientMobilePhone(String patientPatientMobilePhone) {
        this.patientPatientMobilePhone = patientPatientMobilePhone;
    }

    public String getPatientContactMobilePhone() {
        return patientContactMobilePhone;
    }

    public void setPatientContactMobilePhone(String patientContactMobilePhone) {
        this.patientContactMobilePhone = patientContactMobilePhone;
    }

    public String getContactNamet() {
        return contactNamet;
    }

    public void setContactNamet(String contactNamet) {
        this.contactNamet = contactNamet;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getContactJoinNamet() {
        return contactJoinNamet;
    }

    public void setContactJoinNamet(String contactJoinNamet) {
        this.contactJoinNamet = contactJoinNamet;
    }

    public String getAge1() {
        return age1;
    }

    public void setAge1(String age1) {
        this.age1 = age1;
    }

}
