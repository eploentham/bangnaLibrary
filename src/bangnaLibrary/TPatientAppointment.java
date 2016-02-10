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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author root
 */
@Entity
@Table(name = "t_patient_appointment", catalog = "front_bangna5", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"t_patient_appointment_id"})})
@NamedQueries({
    @NamedQuery(name = "TPatientAppointment.findAll", query = "SELECT t FROM TPatientAppointment t"),
    @NamedQuery(name = "TPatientAppointment.findByTPatientAppointmentId", query = "SELECT t FROM TPatientAppointment t WHERE t.tPatientAppointmentId = :tPatientAppointmentId"),
    @NamedQuery(name = "TPatientAppointment.findByTPatientId", query = "SELECT t FROM TPatientAppointment t WHERE t.tPatientId = :tPatientId"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointDateTime", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointDateTime = :patientAppointDateTime"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointmentDate", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointmentDate = :patientAppointmentDate"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointmentTime", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointmentTime = :patientAppointmentTime"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointment", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointment = :patientAppointment"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointmentDoctor", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointmentDoctor = :patientAppointmentDoctor"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointmentClinic", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointmentClinic = :patientAppointmentClinic"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointmentNotice", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointmentNotice = :patientAppointmentNotice"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointmentStaff", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointmentStaff = :patientAppointmentStaff"),
    @NamedQuery(name = "TPatientAppointment.findByTVisitId", query = "SELECT t FROM TPatientAppointment t WHERE t.tVisitId = :tVisitId"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointmentAutoVisit", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointmentAutoVisit = :patientAppointmentAutoVisit"),
    @NamedQuery(name = "TPatientAppointment.findByBVisitQueueSetupId", query = "SELECT t FROM TPatientAppointment t WHERE t.bVisitQueueSetupId = :bVisitQueueSetupId"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointmentStatus", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointmentStatus = :patientAppointmentStatus"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointmentVn", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointmentVn = :patientAppointmentVn"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointmentStaffRecord", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointmentStaffRecord = :patientAppointmentStaffRecord"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointmentRecordDateTime", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointmentRecordDateTime = :patientAppointmentRecordDateTime"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointmentStaffUpdate", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointmentStaffUpdate = :patientAppointmentStaffUpdate"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointmentUpdateDateTime", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointmentUpdateDateTime = :patientAppointmentUpdateDateTime"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointmentStaffCancel", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointmentStaffCancel = :patientAppointmentStaffCancel"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointmentCancelDateTime", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointmentCancelDateTime = :patientAppointmentCancelDateTime"),
    @NamedQuery(name = "TPatientAppointment.findByPatientAppointmentActive", query = "SELECT t FROM TPatientAppointment t WHERE t.patientAppointmentActive = :patientAppointmentActive")})
public class TPatientAppointment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "t_patient_appointment_id", nullable = false, length = 255)
    private String tPatientAppointmentId="";
    @Column(name = "t_patient_id", length = 255)
    private String tPatientId="";
    @Column(name = "patient_appoint_date_time", length = 255)
    private String patientAppointDateTime="";
    @Column(name = "patient_appointment_date", length = 255)
    private String patientAppointmentDate="";
    @Column(name = "patient_appointment_time", length = 255)
    private String patientAppointmentTime="";
    @Column(name = "patient_appointment", length = 255)
    private String patientAppointment="";
    @Column(name = "patient_appointment_doctor", length = 255)
    private String patientAppointmentDoctor="";
    @Column(name = "patient_appointment_clinic", length = 255)
    private String patientAppointmentClinic="";
    @Column(name = "patient_appointment_notice", length = 255)
    private String patientAppointmentNotice="";
    @Column(name = "patient_appointment_staff", length = 255)
    private String patientAppointmentStaff="";
    @Column(name = "t_visit_id", length = 255)
    private String tVisitId="";
    @Column(name = "patient_appointment_auto_visit", length = 255)
    private String patientAppointmentAutoVisit="";
    @Column(name = "b_visit_queue_setup_id", length = 255)
    private String bVisitQueueSetupId="";
    @Column(name = "patient_appointment_status", length = 255)
    private String patientAppointmentStatus="";
    @Column(name = "patient_appointment_vn", length = 255)
    private String patientAppointmentVn="";
    @Column(name = "patient_appointment_staff_record", length = 255)
    private String patientAppointmentStaffRecord="";
    @Column(name = "patient_appointment_record_date_time", length = 255)
    private String patientAppointmentRecordDateTime="";
    @Column(name = "patient_appointment_staff_update", length = 255)
    private String patientAppointmentStaffUpdate="";
    @Column(name = "patient_appointment_update_date_time", length = 255)
    private String patientAppointmentUpdateDateTime="";
    @Column(name = "patient_appointment_staff_cancel", length = 255)
    private String patientAppointmentStaffCancel="";
    @Column(name = "patient_appointment_cancel_date_time", length = 255)
    private String patientAppointmentCancelDateTime="";
    @Column(name = "patient_appointment_active", length = 255)
    private String patientAppointmentActive="";
    @Column(name = "patient_appointment_clinicname", length = 255)
    private String patientAppointmentClinicName="";
    @Column(name = "patient_appointment_doctorname", length = 255)
    private String patientAppointmentDoctorName="";
    @Column(name = "patient_fullname", length = 255)
    private String patientFullname="";
    @Column(name = "patient_hn", length = 255)
    private String patientHn="";
    @Column(name = "patient_age", length = 255)
    private String patientAge="";
    

    public TPatientAppointment() {
    }
    public void initial(){
        tPatientAppointmentId="";
        tPatientId="";
        patientAppointDateTime="";
        patientAppointmentDate="";
        patientAppointmentTime="";
        patientAppointment="";
        patientAppointmentDoctor="";
        patientAppointmentClinic="";
        patientAppointmentNotice="";
        patientAppointmentStaff="";
        tVisitId="";
        patientAppointmentAutoVisit="";
        bVisitQueueSetupId="";
        patientAppointmentStatus="";
        patientAppointmentVn="";
        patientAppointmentStaffRecord="";
        patientAppointmentRecordDateTime="";
        patientAppointmentStaffUpdate="";
        patientAppointmentUpdateDateTime="";
        patientAppointmentStaffCancel="";
        patientAppointmentCancelDateTime="";
        patientAppointmentActive="";
        patientAppointmentClinicName="";
        patientAppointmentDoctorName="";
        patientFullname="";
        patientHn="";
        patientAge="";
    }
    
    public String getTPatientAppoitment(){
        return "t_patient_appointment";
    }

    public String getFTPatientAppoitmentId(){
        return "t_patient_appointment_id";
    }
    public String getFTPatientId(){
        return "t_patient_id";
    }
    public String getFPatientAppoitDateTime(){
        return "patient_appoint_date_time";
    }
    public String getFPatientAppoitmentDate(){
        return "patient_appointment_date";
    }
    public String getFPatientAppoitmentTime(){
        return "patient_appointment_time";
    }
    public String getFPatientAppoitment(){
        return "patient_appointment";
    }
    public String getFPatientAppoitmentDoctor(){
        return "patient_appointment_doctor";
    }
    public String getFPatientAppoitmentClinic(){
        return "patient_appointment_clinic";
    }
    public String getFPatientAppoitmentNotice(){
        return "patient_appointment_notice";
    }
    public String getFPatientAppoitmentStaff(){
        return "patient_appointment_staff";
    }
    public String getFTVisitId(){
        return "t_visit_id";
    }
    public String getFPatientAppoitmentAutoVisit(){
        return "patient_appointment_auto_visit";
    }
    public String getFBVisitQueueSetupId(){
        return "b_visit_queue_setup_id";
    }
    public String getFPatientAppoitmentStatus(){
        return "patient_appointment_status";
    }
    public String getFPatientAppoitmentVn(){
        return "patient_appointment_vn";
    }
    public String getFPatientAppoitmentStaffRecord(){
        return "patient_appointment_staff_record";
    }
    public String getFPatientAppoitmentRecordDateTime(){
        return "patient_appointment_record_date_time";
    }
    public String getFPatientAppoitmentStaffUpdate(){
        return "patient_appointment_staff_update";
    }
    public String getFPatientAppoitmentUpdateDateTime(){
        return "patient_appointment_update_date_time";
    }
    public String getFPatientAppoitmentStaffCancel(){
        return "patient_appointment_staff_cancel";
    }
    public String getFPatientAppoitmentCancelDateTime(){
        return "patient_appointment_cancel_date_time";
    }
    public String getFPatientAppoitmentActive(){
        return "patient_appointment_active";
    }
    

    public TPatientAppointment(String tPatientAppointmentId) {
        this.tPatientAppointmentId = tPatientAppointmentId;
    }

    public String getTPatientAppointmentId() {
        return tPatientAppointmentId;
    }

    public void setTPatientAppointmentId(String tPatientAppointmentId) {
        this.tPatientAppointmentId = tPatientAppointmentId;
    }

    public String getTPatientId() {
        return tPatientId;
    }

    public void setTPatientId(String tPatientId) {
        this.tPatientId = tPatientId;
    }

    public String getPatientAppointDateTime() {
        return patientAppointDateTime;
    }

    public void setPatientAppointDateTime(String patientAppointDateTime) {
        this.patientAppointDateTime = patientAppointDateTime;
    }

    public String getPatientAppointmentDate() {
        return patientAppointmentDate;
    }

    public void setPatientAppointmentDate(String patientAppointmentDate) {
        this.patientAppointmentDate = patientAppointmentDate;
    }

    public String getPatientAppointmentTime() {
        return patientAppointmentTime;
    }

    public void setPatientAppointmentTime(String patientAppointmentTime) {
        this.patientAppointmentTime = patientAppointmentTime;
    }

    public String getPatientAppointment() {
        return patientAppointment;
    }

    public void setPatientAppointment(String patientAppointment) {
        this.patientAppointment = patientAppointment;
    }

    public String getPatientAppointmentDoctor() {
        return patientAppointmentDoctor;
    }
    public void setPatientAppointmentDoctor(String patientAppointmentDoctor) {
        this.patientAppointmentDoctor = patientAppointmentDoctor;
    }

    public String getPatientAppointmentClinic() {
        return patientAppointmentClinic;
    }
    public void setPatientAppointmentClinic(String patientAppointmentClinic) {
        this.patientAppointmentClinic = patientAppointmentClinic;
    }

    public String getPatientAppointmentNotice() {
        return patientAppointmentNotice;
    }

    public void setPatientAppointmentNotice(String patientAppointmentNotice) {
        this.patientAppointmentNotice = patientAppointmentNotice;
    }

    public String getPatientAppointmentStaff() {
        return patientAppointmentStaff;
    }

    public void setPatientAppointmentStaff(String patientAppointmentStaff) {
        this.patientAppointmentStaff = patientAppointmentStaff;
    }

    public String getTVisitId() {
        return tVisitId;
    }

    public void setTVisitId(String tVisitId) {
        this.tVisitId = tVisitId;
    }

    public String getPatientAppointmentAutoVisit() {
        return patientAppointmentAutoVisit;
    }

    public void setPatientAppointmentAutoVisit(String patientAppointmentAutoVisit) {
        this.patientAppointmentAutoVisit = patientAppointmentAutoVisit;
    }

    public String getBVisitQueueSetupId() {
        return bVisitQueueSetupId;
    }

    public void setBVisitQueueSetupId(String bVisitQueueSetupId) {
        this.bVisitQueueSetupId = bVisitQueueSetupId;
    }

    public String getPatientAppointmentStatus() {
        return patientAppointmentStatus;
    }

    public void setPatientAppointmentStatus(String patientAppointmentStatus) {
        this.patientAppointmentStatus = patientAppointmentStatus;
    }

    public String getPatientAppointmentVn() {
        return patientAppointmentVn;
    }

    public void setPatientAppointmentVn(String patientAppointmentVn) {
        this.patientAppointmentVn = patientAppointmentVn;
    }

    public String getPatientAppointmentStaffRecord() {
        return patientAppointmentStaffRecord;
    }

    public void setPatientAppointmentStaffRecord(String patientAppointmentStaffRecord) {
        this.patientAppointmentStaffRecord = patientAppointmentStaffRecord;
    }

    public String getPatientAppointmentRecordDateTime() {
        return patientAppointmentRecordDateTime;
    }

    public void setPatientAppointmentRecordDateTime(String patientAppointmentRecordDateTime) {
        this.patientAppointmentRecordDateTime = patientAppointmentRecordDateTime;
    }

    public String getPatientAppointmentStaffUpdate() {
        return patientAppointmentStaffUpdate;
    }

    public void setPatientAppointmentStaffUpdate(String patientAppointmentStaffUpdate) {
        this.patientAppointmentStaffUpdate = patientAppointmentStaffUpdate;
    }

    public String getPatientAppointmentUpdateDateTime() {
        return patientAppointmentUpdateDateTime;
    }

    public void setPatientAppointmentUpdateDateTime(String patientAppointmentUpdateDateTime) {
        this.patientAppointmentUpdateDateTime = patientAppointmentUpdateDateTime;
    }

    public String getPatientAppointmentStaffCancel() {
        return patientAppointmentStaffCancel;
    }

    public void setPatientAppointmentStaffCancel(String patientAppointmentStaffCancel) {
        this.patientAppointmentStaffCancel = patientAppointmentStaffCancel;
    }

    public String getPatientAppointmentCancelDateTime() {
        return patientAppointmentCancelDateTime;
    }

    public void setPatientAppointmentCancelDateTime(String patientAppointmentCancelDateTime) {
        this.patientAppointmentCancelDateTime = patientAppointmentCancelDateTime;
    }

    public String getPatientAppointmentActive() {
        return patientAppointmentActive;
    }

    public void setPatientAppointmentActive(String patientAppointmentActive) {
        this.patientAppointmentActive = patientAppointmentActive;
    }

    public String getPatientAppointmentClinicName() {
        return patientAppointmentClinicName;
    }
    public void setPatientAppointmentClinicName(String patientAppointmentClinicName) {
        this.patientAppointmentClinicName = patientAppointmentClinicName;
    }

    public String getPatientAppointmentDoctorName() {
        return patientAppointmentDoctorName;
    }
    public void setPatientAppointmentDoctorName(String patientAppointmentDoctorName) {
        this.patientAppointmentDoctorName = patientAppointmentDoctorName;
    }

    public String getPatientFullname() {
        return patientFullname;
    }
    public void setPatientFullname(String patientFullname) {
        this.patientFullname = patientFullname;
    }

    public String getPatientHn() {
        return patientHn;
    }
    public void setPatientHn(String patientHn) {
        this.patientHn = patientHn;
    }

    public String getPatientAge() {
        return patientAge;
    }
    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tPatientAppointmentId != null ? tPatientAppointmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPatientAppointment)) {
            return false;
        }
        TPatientAppointment other = (TPatientAppointment) object;
        if ((this.tPatientAppointmentId == null && other.tPatientAppointmentId != null) || (this.tPatientAppointmentId != null && !this.tPatientAppointmentId.equals(other.tPatientAppointmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.TPatientAppointment[tPatientAppointmentId=" + tPatientAppointmentId + "]";
    }

}
