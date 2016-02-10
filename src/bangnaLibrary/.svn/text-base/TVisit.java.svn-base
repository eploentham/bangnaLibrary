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
@Table(name = "t_visit", catalog = "front_bangna3", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"t_visit_id"})})
@NamedQueries({
    @NamedQuery(name = "TVisit.findAll", query = "SELECT t FROM TVisit t"),
    @NamedQuery(name = "TVisit.findByTVisitId", query = "SELECT t FROM TVisit t WHERE t.tVisitId = :tVisitId"),
    @NamedQuery(name = "TVisit.findByVisitHn", query = "SELECT t FROM TVisit t WHERE t.visitHn = :visitHn"),
    @NamedQuery(name = "TVisit.findByVisitVn", query = "SELECT t FROM TVisit t WHERE t.visitVn = :visitVn"),
    @NamedQuery(name = "TVisit.findByFVisitTypeId", query = "SELECT t FROM TVisit t WHERE t.fVisitTypeId = :fVisitTypeId"),
    @NamedQuery(name = "TVisit.findByVisitBeginVisitTime", query = "SELECT t FROM TVisit t WHERE t.visitBeginVisitTime = :visitBeginVisitTime"),
    @NamedQuery(name = "TVisit.findByVisitFinancialDischargeTime", query = "SELECT t FROM TVisit t WHERE t.visitFinancialDischargeTime = :visitFinancialDischargeTime"),
    @NamedQuery(name = "TVisit.findByVisitNotice", query = "SELECT t FROM TVisit t WHERE t.visitNotice = :visitNotice"),
    @NamedQuery(name = "TVisit.findByBVisitOfficeIdReferIn", query = "SELECT t FROM TVisit t WHERE t.bVisitOfficeIdReferIn = :bVisitOfficeIdReferIn"),
    @NamedQuery(name = "TVisit.findByBVisitOfficeIdReferOut", query = "SELECT t FROM TVisit t WHERE t.bVisitOfficeIdReferOut = :bVisitOfficeIdReferOut"),
    @NamedQuery(name = "TVisit.findByVisitDiagnosisNotice", query = "SELECT t FROM TVisit t WHERE t.visitDiagnosisNotice = :visitDiagnosisNotice"),
    @NamedQuery(name = "TVisit.findByFVisitOpdDischargeStatusId", query = "SELECT t FROM TVisit t WHERE t.fVisitOpdDischargeStatusId = :fVisitOpdDischargeStatusId"),
    @NamedQuery(name = "TVisit.findByFVisitIpdDischargeTypeId", query = "SELECT t FROM TVisit t WHERE t.fVisitIpdDischargeTypeId = :fVisitIpdDischargeTypeId"),
    @NamedQuery(name = "TVisit.findByFVisitIpdDischargeStatusId", query = "SELECT t FROM TVisit t WHERE t.fVisitIpdDischargeStatusId = :fVisitIpdDischargeStatusId"),
    @NamedQuery(name = "TVisit.findByVisitLocking", query = "SELECT t FROM TVisit t WHERE t.visitLocking = :visitLocking"),
    @NamedQuery(name = "TVisit.findByVisitStaffLock", query = "SELECT t FROM TVisit t WHERE t.visitStaffLock = :visitStaffLock"),
    @NamedQuery(name = "TVisit.findByVisitLockDateTime", query = "SELECT t FROM TVisit t WHERE t.visitLockDateTime = :visitLockDateTime"),
    @NamedQuery(name = "TVisit.findByFVisitStatusId", query = "SELECT t FROM TVisit t WHERE t.fVisitStatusId = :fVisitStatusId"),
    @NamedQuery(name = "TVisit.findByVisitPregnant", query = "SELECT t FROM TVisit t WHERE t.visitPregnant = :visitPregnant"),
    @NamedQuery(name = "TVisit.findByBVisitClinicId", query = "SELECT t FROM TVisit t WHERE t.bVisitClinicId = :bVisitClinicId"),
    @NamedQuery(name = "TVisit.findByBVisitWardId", query = "SELECT t FROM TVisit t WHERE t.bVisitWardId = :bVisitWardId"),
    @NamedQuery(name = "TVisit.findByVisitBed", query = "SELECT t FROM TVisit t WHERE t.visitBed = :visitBed"),
    @NamedQuery(name = "TVisit.findByVisitObserve", query = "SELECT t FROM TVisit t WHERE t.visitObserve = :visitObserve"),
    @NamedQuery(name = "TVisit.findByVisitPatientType", query = "SELECT t FROM TVisit t WHERE t.visitPatientType = :visitPatientType"),
    @NamedQuery(name = "TVisit.findByVisitQueue", query = "SELECT t FROM TVisit t WHERE t.visitQueue = :visitQueue"),
    @NamedQuery(name = "TVisit.findByBServicePointId", query = "SELECT t FROM TVisit t WHERE t.bServicePointId = :bServicePointId"),
    @NamedQuery(name = "TVisit.findByVisitStaffObserve", query = "SELECT t FROM TVisit t WHERE t.visitStaffObserve = :visitStaffObserve"),
    @NamedQuery(name = "TVisit.findByVisitDx", query = "SELECT t FROM TVisit t WHERE t.visitDx = :visitDx"),
    @NamedQuery(name = "TVisit.findByVisitIpdDischargeStatus", query = "SELECT t FROM TVisit t WHERE t.visitIpdDischargeStatus = :visitIpdDischargeStatus"),
    @NamedQuery(name = "TVisit.findByVisitMoneyDischargeStatus", query = "SELECT t FROM TVisit t WHERE t.visitMoneyDischargeStatus = :visitMoneyDischargeStatus"),
    @NamedQuery(name = "TVisit.findByVisitDoctorDischargeStatus", query = "SELECT t FROM TVisit t WHERE t.visitDoctorDischargeStatus = :visitDoctorDischargeStatus"),
    @NamedQuery(name = "TVisit.findByTPatientId", query = "SELECT t FROM TVisit t WHERE t.tPatientId = :tPatientId"),
    @NamedQuery(name = "TVisit.findByVisitStaffFinancialDischarge", query = "SELECT t FROM TVisit t WHERE t.visitStaffFinancialDischarge = :visitStaffFinancialDischarge"),
    @NamedQuery(name = "TVisit.findByVisitStaffDoctorDischarge", query = "SELECT t FROM TVisit t WHERE t.visitStaffDoctorDischarge = :visitStaffDoctorDischarge"),
    @NamedQuery(name = "TVisit.findByVisitStaffDoctorDischargeDateTime", query = "SELECT t FROM TVisit t WHERE t.visitStaffDoctorDischargeDateTime = :visitStaffDoctorDischargeDateTime"),
    @NamedQuery(name = "TVisit.findByVisitAn", query = "SELECT t FROM TVisit t WHERE t.visitAn = :visitAn"),
    @NamedQuery(name = "TVisit.findByVisitDxStat", query = "SELECT t FROM TVisit t WHERE t.visitDxStat = :visitDxStat"),
    @NamedQuery(name = "TVisit.findByVisitBeginAdmitDateTime", query = "SELECT t FROM TVisit t WHERE t.visitBeginAdmitDateTime = :visitBeginAdmitDateTime"),
    @NamedQuery(name = "TVisit.findByVisitDenyAllergy", query = "SELECT t FROM TVisit t WHERE t.visitDenyAllergy = :visitDenyAllergy"),
    @NamedQuery(name = "TVisit.findByVisitFirstVisit", query = "SELECT t FROM TVisit t WHERE t.visitFirstVisit = :visitFirstVisit"),
    @NamedQuery(name = "TVisit.findByVisitPatientSelfDoctor", query = "SELECT t FROM TVisit t WHERE t.visitPatientSelfDoctor = :visitPatientSelfDoctor"),
    @NamedQuery(name = "TVisit.findByVisitPatientAge", query = "SELECT t FROM TVisit t WHERE t.visitPatientAge = :visitPatientAge"),
    @NamedQuery(name = "TVisit.findByVisitPcuService", query = "SELECT t FROM TVisit t WHERE t.visitPcuService = :visitPcuService"),
    @NamedQuery(name = "TVisit.findByVisitHospitalService", query = "SELECT t FROM TVisit t WHERE t.visitHospitalService = :visitHospitalService"),
    @NamedQuery(name = "TVisit.findByVisitLabStatusId", query = "SELECT t FROM TVisit t WHERE t.visitLabStatusId = :visitLabStatusId"),
    @NamedQuery(name = "TVisit.findByVisitNcd", query = "SELECT t FROM TVisit t WHERE t.visitNcd = :visitNcd"),
    @NamedQuery(name = "TVisit.findByBNcdGroupId", query = "SELECT t FROM TVisit t WHERE t.bNcdGroupId = :bNcdGroupId"),
    @NamedQuery(name = "TVisit.findByFReferCauseId", query = "SELECT t FROM TVisit t WHERE t.fReferCauseId = :fReferCauseId"),
    @NamedQuery(name = "TVisit.findByFEmergencyStatusId", query = "SELECT t FROM TVisit t WHERE t.fEmergencyStatusId = :fEmergencyStatusId"),
    @NamedQuery(name = "TVisit.findByVisitEmergencyStaff", query = "SELECT t FROM TVisit t WHERE t.visitEmergencyStaff = :visitEmergencyStaff"),
    @NamedQuery(name = "TVisit.findByVisitHaveAppointment", query = "SELECT t FROM TVisit t WHERE t.visitHaveAppointment = :visitHaveAppointment"),
    @NamedQuery(name = "TVisit.findByVisitHaveAdmit", query = "SELECT t FROM TVisit t WHERE t.visitHaveAdmit = :visitHaveAdmit"),
    @NamedQuery(name = "TVisit.findByVisitHaveRefer", query = "SELECT t FROM TVisit t WHERE t.visitHaveRefer = :visitHaveRefer"),
    @NamedQuery(name = "TVisit.findByTPatientAppointmentId", query = "SELECT t FROM TVisit t WHERE t.tPatientAppointmentId = :tPatientAppointmentId"),
    @NamedQuery(name = "TVisit.findByVisitCalDateAppointment", query = "SELECT t FROM TVisit t WHERE t.visitCalDateAppointment = :visitCalDateAppointment"),
    @NamedQuery(name = "TVisit.findByVisitCauseAppointment", query = "SELECT t FROM TVisit t WHERE t.visitCauseAppointment = :visitCauseAppointment")})
public class TVisit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "t_visit_id", nullable = false, length = 255)
    private String tVisitId="";
    @Column(name = "visit_hn", length = 255)
    private String visitHn="";
    @Column(name = "visit_vn", length = 255)
    private String visitVn="";
    @Column(name = "f_visit_type_id", length = 255)
    private String fVisitTypeId="";
    @Column(name = "visit_begin_visit_time", length = 255)
    private String visitBeginVisitTime="";
    @Column(name = "visit_financial_discharge_time", length = 255)
    private String visitFinancialDischargeTime="", financialDischargeDate="";
    @Column(name = "visit_notice", length = 255)
    private String visitNotice="";
    @Column(name = "b_visit_office_id_refer_in", length = 255)
    private String bVisitOfficeIdReferIn="";
    @Column(name = "b_visit_office_id_refer_out", length = 255)
    private String bVisitOfficeIdReferOut="";
    @Column(name = "visit_diagnosis_notice", length = 5000)
    private String visitDiagnosisNotice="";
    @Column(name = "f_visit_opd_discharge_status_id", length = 255)
    private String fVisitOpdDischargeStatusId="";
    @Column(name = "f_visit_ipd_discharge_type_id", length = 255)
    private String fVisitIpdDischargeTypeId="";
    @Column(name = "f_visit_ipd_discharge_status_id", length = 255)
    private String fVisitIpdDischargeStatusId="";
    @Column(name = "visit_locking", length = 255)
    private String visitLocking="";
    @Column(name = "visit_staff_lock", length = 255)
    private String visitStaffLock="";
    @Column(name = "visit_lock_date_time", length = 255)
    private String visitLockDateTime="";
    @Column(name = "f_visit_status_id", length = 255)
    private String fVisitStatusId="";
    @Column(name = "visit_pregnant", length = 255)
    private String visitPregnant="";
    @Column(name = "b_visit_clinic_id", length = 255)
    private String bVisitClinicId="";
    @Column(name = "b_visit_ward_id", length = 255)
    private String bVisitWardId="";
    @Column(name = "visit_bed", length = 255)
    private String visitBed="";
    @Column(name = "visit_observe", length = 255)
    private String visitObserve="";
    @Column(name = "visit_patient_type", length = 255)
    private String visitPatientType="";
    @Column(name = "visit_queue", length = 255)
    private String visitQueue="";
    @Column(name = "b_service_point_id", length = 255)
    private String bServicePointId="";
    @Column(name = "visit_staff_observe", length = 255)
    private String visitStaffObserve="";
    @Column(name = "visit_dx", length = 255)
    private String visitDx="";
    @Column(name = "visit_ipd_discharge_status", length = 255)
    private String visitIpdDischargeStatus="";
    @Column(name = "visit_money_discharge_status", length = 255)
    private String visitMoneyDischargeStatus="";
    @Column(name = "visit_doctor_discharge_status", length = 255)
    private String visitDoctorDischargeStatus="";
    @Column(name = "t_patient_id", length = 255)
    private String tPatientId="";
    @Column(name = "visit_staff_financial_discharge", length = 255)
    private String visitStaffFinancialDischarge="";
    @Column(name = "visit_staff_doctor_discharge", length = 255)
    private String visitStaffDoctorDischarge="";
    @Column(name = "visit_staff_doctor_discharge_date_time", length = 255)
    private String visitStaffDoctorDischargeDateTime="";
    @Column(name = "visit_an", length = 255)
    private String visitAn="";
    @Column(name = "visit_dx_stat", length = 255)
    private String visitDxStat="";
    @Column(name = "visit_begin_admit_date_time", length = 255)
    private String visitBeginAdmitDateTime="", visitDate="", visitTime="";
    @Column(name = "visit_deny_allergy", length = 255)
    private String visitDenyAllergy="";
    @Column(name = "visit_first_visit", length = 255)
    private String visitFirstVisit="";
    @Column(name = "visit_patient_self_doctor", length = 255)
    private String visitPatientSelfDoctor="";
    @Column(name = "visit_patient_age", length = 255)
    private String visitPatientAge="";
    @Column(name = "visit_pcu_service", length = 255)
    private String visitPcuService="";
    @Column(name = "visit_hospital_service", length = 255)
    private String visitHospitalService="";
    @Column(name = "visit_lab_status_id", length = 255)
    private String visitLabStatusId="";
    @Column(name = "visit_ncd", length = 255)
    private String visitNcd="";
    @Column(name = "b_ncd_group_id", length = 255)
    private String bNcdGroupId="";
    @Column(name = "f_refer_cause_id", length = 255)
    private String fReferCauseId="";
    @Column(name = "f_emergency_status_id", length = 255)
    private String fEmergencyStatusId="";
    @Column(name = "visit_emergency_staff", length = 255)
    private String visitEmergencyStaff="";
    @Column(name = "visit_have_appointment", length = 255)
    private String visitHaveAppointment="";
    @Column(name = "visit_have_admit", length = 255)
    private String visitHaveAdmit="";
    @Column(name = "visit_have_refer", length = 255)
    private String visitHaveRefer="";
    @Column(name = "t_patient_appointment_id", length = 255)
    private String tPatientAppointmentId="";
    @Column(name = "visit_cal_date_appointment", length = 255)
    private String visitCalDateAppointment="";
    @Column(name = "visit_cause_appointment", length = 255)
    private String visitCauseAppointment="";
    @Column(name = "b_contract_plans_id", length = 255)
    private String bContractPlansId="";
    @Column(name = "contact_id", length = 255)
    private String contactId="";
    @Column(name = "contact_namet", length = 255)
    private String contactNamet="";
    @Column(name = "contact_join_id", length = 255)
    private String contactJoinId="";
    @Column(name = "contact_join_namet", length = 255)
    private String contactJoinNamet="";
    @Column(name = "surveillance_case_id", length = 255)
    private String surveillanceCaseId="";
    @Column(name = "contract_plans_description", length = 255)
    private String contractPlansDescription="";
    @Column(name = "service_point_description", length = 255)
    private String servicePointDescription="";

    public TVisit() {
    }
    public void initial(){
        tVisitId="";
        visitHn="";
        visitVn="";
        fVisitTypeId="";
        visitBeginVisitTime="";
        visitFinancialDischargeTime=""; financialDischargeDate="";
        visitNotice="";
        bVisitOfficeIdReferIn="";
        bVisitOfficeIdReferOut="";
        visitDiagnosisNotice="";
        fVisitOpdDischargeStatusId="";
        fVisitIpdDischargeTypeId="";
        fVisitIpdDischargeStatusId="";
        visitLocking="";
        visitStaffLock="";
        visitLockDateTime="";
        fVisitStatusId="";
        visitPregnant="";
        bVisitClinicId="";
        bVisitWardId="";
        visitBed="";
        visitObserve="";
        visitPatientType="";
        visitQueue="";
        bServicePointId="";
        visitStaffObserve="";
        visitDx="";
        visitIpdDischargeStatus="";
        visitMoneyDischargeStatus="";
        visitDoctorDischargeStatus="";
        tPatientId="";
        visitStaffFinancialDischarge="";
        visitStaffDoctorDischarge="";
        visitStaffDoctorDischargeDateTime="";
        visitAn="";
        visitDxStat="";
        visitBeginAdmitDateTime=""; visitDate=""; visitTime="";
        visitDenyAllergy="";
        visitFirstVisit="";
        visitPatientSelfDoctor="";
        visitPatientAge="";
        visitPcuService="";
        visitHospitalService="";
        visitLabStatusId="";
        visitNcd="";
        bNcdGroupId="";
        fReferCauseId="";
        fEmergencyStatusId="";
        visitEmergencyStaff="";
        visitHaveAppointment="";
        visitHaveAdmit="";
        visitHaveRefer="";
        tPatientAppointmentId="";
        visitCalDateAppointment="";
        visitCauseAppointment="";
        bContractPlansId="";
        contactId="";
        contactNamet="";
        contactJoinId="";
        contactJoinNamet="";
        surveillanceCaseId="";
        contractPlansDescription="";
        servicePointDescription="";
    }
    public String getTVisit(){
        return "t_visit";
    }
    public String getFTVisitId(){
        return "t_visit_id";
    }
    public String getFVisitHn(){
        return "visit_hn";
    }
    public String getFVisitVn(){
        return "visit_vn";
    }
    public String getFFVisitTypeId(){
        return "f_visit_type_id";
    }
    public String getFVisitBeginVisitTime(){
        return "visit_begin_visit_time";
    }
    public String getFVisitFinancialDischargeTime(){
        return "visit_financial_discharge_time";
    }
    public String getFVisitNotice(){
        return "visit_notice";
    }
    public String getFBVisitOfficeIdReferIn(){
        return "b_visit_office_id_refer_in";
    }
    public String getFBVisitOfficeIdReferOut(){
        return "b_visit_office_id_refer_out";
    }
    public String getFVisitDiagnosisNotice(){
        return "visit_diagnosis_notice";
    }
    public String getFFVisitOpdDischargeStatusId(){
        return "f_visit_opd_discharge_status_id";
    }
    public String getFFVisitIpdDischargeTypeId(){
        return "f_visit_ipd_discharge_type_id";
    }
    public String getFFVisitIpdDischargeStatusId(){
        return "f_visit_ipd_discharge_status_id";
    }
    public String getFVisitLocking(){
        return "visit_locking";
    }
    public String getFVisitStaffLock(){
        return "visit_staff_lock";
    }
    public String getFVisitLockDateTime(){
        return "visit_lock_date_time";
    }
    public String getFFVisitStatusId(){
        return "f_visit_status_id";
    }
    public String getFVisitPregnant(){
        return "visit_pregnant";
    }
    public String getFBVisitClinicId(){
        return "b_visit_clinic_id";
    }
    public String getFBVisitWardId(){
        return "b_visit_ward_id";
    }
    public String getFVisitBed(){
        return "visit_bed";
    }
    public String getFVisitObserve(){
        return "visit_observe";
    }
    public String getFVisitPatientType(){
        return "visit_patient_type";
    }
    public String getFVisitQueue(){
        return "visit_queue";
    }
    public String getFBServicePointId(){
        return "b_service_point_id";
    }
    public String getFVisitStaffObserve(){
        return "visit_staff_observe";
    }
    public String getFVisitDx(){
        return "visit_dx";
    }
    public String getFVisitIpdDischargeStatus(){
        return "visit_ipd_discharge_status";
    }
    public String getFVisitMoneyDischargeStatus(){
        return "visit_money_discharge_status";
    }
    public String getFVisitDoctorDischargeStatus(){
        return "visit_doctor_discharge_status";
    }
    public String getFTPatientId(){
        return "t_patient_id";
    }
    public String getFVisitStaffFinancialDischarge(){
        return "visit_staff_financial_discharge";
    }
    public String getFVisitStaffDoctorDischarge(){
        return "visit_staff_doctor_discharge";
    }
    public String getFVisitStaffDoctorDischargeDateTime(){
        return "visit_staff_doctor_discharge_date_time";
    }
    public String getFVisitAn(){
        return "visit_an";
    }
    public String getFVisitDxStat(){
        return "visit_dx_stat";
    }
    public String getFVisitBeginAdmitDateTime(){
        return "visit_begin_admit_date_time";
    }
    public String getFVisitFirstVisit(){
        return "visit_first_visit";
    }
    public String getFVisitPatientSelfDoctor(){
        return "visit_patient_self_doctor";
    }
    public String getFVisitPatientAge(){
        return "visit_patient_age";
    }
    public String getFVisitPcuService(){
        return "visit_pcu_service";
    }
    public String getFVisitHospitalService(){
        return "visit_hospital_service";
    }
    public String getFVisitLabStatusId(){
        return "visit_lab_status_id";
    }
    public String getFVisitNcd(){
        return "visit_ncd";
    }
    public String getFBNcdGroupId(){
        return "b_ncd_group_id";
    }
    public String getFFReferCauseId(){
        return "f_refer_cause_id";
    }
    public String getFFEmergencyStatusId(){
        return "f_emergency_status_id";
    }
    public String getFVisitEmergencyStaff(){
        return "visit_emergency_staff";
    }
    public String getFVisitHaveAppointment(){
        return "visit_have_appointment";
    }
    public String getFVisitHaveAdmit(){
        return "visit_have_admit";
    }
    public String getFVisitHaveRefer(){
        return "visit_have_refer";
    }
    public String getFTPatientAppointmentId(){
        return "t_patient_appointment_id";
    }
    public String getFVisitCalDateAppointment(){
        return "visit_cal_date_appointment";
    }
    public String getFVisitCauseAppointment(){
        return "visit_cause_appointment";
    }
    public String getFVisitDenyAllergy(){
        return "visit_deny_allergy";
    }
    public String getFBContractPlansId(){
        return "b_contract_plans_id";
    }
    public String getFContactId(){
        return "contact_id";
    }
    public String getFContactNamet(){
        return "contact_namet";
    }
    public String getFContactJoinId(){
        return "contact_join_id";
    }
    public String getFContactJoinNamet(){
        return "contact_join_namet";
    }
    public String getFSurveillanceCaseId(){
        return "surveillance_case_id";
    }

    public TVisit(String tVisitId) {
        this.tVisitId = tVisitId;
    }

    public String getTVisitId() {
        return tVisitId;
    }

    public void setTVisitId(String tVisitId) {
        this.tVisitId = tVisitId;
    }

    public String getVisitHn() {
        return visitHn;
    }
    public void setVisitHn(String visitHn) {
        this.visitHn = visitHn;
    }

    public String getVisitVn() {
        return visitVn;
    }

    public void setVisitVn(String visitVn) {
        this.visitVn = visitVn;
    }

    public String getFVisitTypeId() {
        return fVisitTypeId;
    }

    public void setFVisitTypeId(String fVisitTypeId) {
        this.fVisitTypeId = fVisitTypeId;
    }

    public String getVisitBeginVisitTime() {
        return visitBeginVisitTime;
    }

    public void setVisitBeginVisitTime(String visitBeginVisitTime) {
        this.visitBeginVisitTime = visitBeginVisitTime;
    }

    public String getVisitFinancialDischargeTime() {
        return visitFinancialDischargeTime;
    }

    public void setVisitFinancialDischargeTime(String visitFinancialDischargeTime) {
        this.visitFinancialDischargeTime = visitFinancialDischargeTime;
    }

    public String getVisitNotice() {
        return visitNotice;
    }

    public void setVisitNotice(String visitNotice) {
        this.visitNotice = visitNotice;
    }

    public String getBVisitOfficeIdReferIn() {
        return bVisitOfficeIdReferIn;
    }

    public void setBVisitOfficeIdReferIn(String bVisitOfficeIdReferIn) {
        this.bVisitOfficeIdReferIn = bVisitOfficeIdReferIn;
    }

    public String getBVisitOfficeIdReferOut() {
        return bVisitOfficeIdReferOut;
    }

    public void setBVisitOfficeIdReferOut(String bVisitOfficeIdReferOut) {
        this.bVisitOfficeIdReferOut = bVisitOfficeIdReferOut;
    }

    public String getVisitDiagnosisNotice() {
        return visitDiagnosisNotice;
    }

    public void setVisitDiagnosisNotice(String visitDiagnosisNotice) {
        this.visitDiagnosisNotice = visitDiagnosisNotice;
    }

    public String getFVisitOpdDischargeStatusId() {
        return fVisitOpdDischargeStatusId;
    }

    public void setFVisitOpdDischargeStatusId(String fVisitOpdDischargeStatusId) {
        this.fVisitOpdDischargeStatusId = fVisitOpdDischargeStatusId;
    }

    public String getFVisitIpdDischargeTypeId() {
        return fVisitIpdDischargeTypeId;
    }

    public void setFVisitIpdDischargeTypeId(String fVisitIpdDischargeTypeId) {
        this.fVisitIpdDischargeTypeId = fVisitIpdDischargeTypeId;
    }

    public String getFVisitIpdDischargeStatusId() {
        return fVisitIpdDischargeStatusId;
    }

    public void setFVisitIpdDischargeStatusId(String fVisitIpdDischargeStatusId) {
        this.fVisitIpdDischargeStatusId = fVisitIpdDischargeStatusId;
    }

    public String getVisitLocking() {
        return visitLocking;
    }

    public void setVisitLocking(String visitLocking) {
        this.visitLocking = visitLocking;
    }

    public String getVisitStaffLock() {
        return visitStaffLock;
    }

    public void setVisitStaffLock(String visitStaffLock) {
        this.visitStaffLock = visitStaffLock;
    }

    public String getVisitLockDateTime() {
        return visitLockDateTime;
    }

    public void setVisitLockDateTime(String visitLockDateTime) {
        this.visitLockDateTime = visitLockDateTime;
    }

    public String getFVisitStatusId() {
        return fVisitStatusId;
    }

    public void setFVisitStatusId(String fVisitStatusId) {
        this.fVisitStatusId = fVisitStatusId;
    }

    public String getVisitPregnant() {
        return visitPregnant;
    }

    public void setVisitPregnant(String visitPregnant) {
        this.visitPregnant = visitPregnant;
    }

    public String getBVisitClinicId() {
        return bVisitClinicId;
    }

    public void setBVisitClinicId(String bVisitClinicId) {
        this.bVisitClinicId = bVisitClinicId;
    }

    public String getBVisitWardId() {
        return bVisitWardId;
    }

    public void setBVisitWardId(String bVisitWardId) {
        this.bVisitWardId = bVisitWardId;
    }

    public String getVisitBed() {
        return visitBed;
    }

    public void setVisitBed(String visitBed) {
        this.visitBed = visitBed;
    }

    public String getVisitObserve() {
        return visitObserve;
    }

    public void setVisitObserve(String visitObserve) {
        this.visitObserve = visitObserve;
    }

    public String getVisitPatientType() {
        return visitPatientType;
    }

    public void setVisitPatientType(String visitPatientType) {
        this.visitPatientType = visitPatientType;
    }

    public String getVisitQueue() {
        return visitQueue;
    }

    public void setVisitQueue(String visitQueue) {
        this.visitQueue = visitQueue;
    }

    public String getBServicePointId() {
        return bServicePointId;
    }

    public void setBServicePointId(String bServicePointId) {
        this.bServicePointId = bServicePointId;
    }

    public String getVisitStaffObserve() {
        return visitStaffObserve;
    }

    public void setVisitStaffObserve(String visitStaffObserve) {
        this.visitStaffObserve = visitStaffObserve;
    }

    public String getVisitDx() {
        return visitDx;
    }

    public void setVisitDx(String visitDx) {
        this.visitDx = visitDx;
    }

    public String getVisitIpdDischargeStatus() {
        return visitIpdDischargeStatus;
    }

    public void setVisitIpdDischargeStatus(String visitIpdDischargeStatus) {
        this.visitIpdDischargeStatus = visitIpdDischargeStatus;
    }

    public String getVisitMoneyDischargeStatus() {
        return visitMoneyDischargeStatus;
    }

    public void setVisitMoneyDischargeStatus(String visitMoneyDischargeStatus) {
        this.visitMoneyDischargeStatus = visitMoneyDischargeStatus;
    }

    public String getVisitDoctorDischargeStatus() {
        return visitDoctorDischargeStatus;
    }

    public void setVisitDoctorDischargeStatus(String visitDoctorDischargeStatus) {
        this.visitDoctorDischargeStatus = visitDoctorDischargeStatus;
    }

    public String getTPatientId() {
        return tPatientId;
    }

    public void setTPatientId(String tPatientId) {
        this.tPatientId = tPatientId;
    }

    public String getVisitStaffFinancialDischarge() {
        return visitStaffFinancialDischarge;
    }

    public void setVisitStaffFinancialDischarge(String visitStaffFinancialDischarge) {
        this.visitStaffFinancialDischarge = visitStaffFinancialDischarge;
    }

    public String getVisitStaffDoctorDischarge() {
        return visitStaffDoctorDischarge;
    }

    public void setVisitStaffDoctorDischarge(String visitStaffDoctorDischarge) {
        this.visitStaffDoctorDischarge = visitStaffDoctorDischarge;
    }

    public String getVisitStaffDoctorDischargeDateTime() {
        return visitStaffDoctorDischargeDateTime;
    }

    public void setVisitStaffDoctorDischargeDateTime(String visitStaffDoctorDischargeDateTime) {
        this.visitStaffDoctorDischargeDateTime = visitStaffDoctorDischargeDateTime;
    }

    public String getVisitAn() {
        return visitAn;
    }

    public void setVisitAn(String visitAn) {
        this.visitAn = visitAn;
    }

    public String getVisitDxStat() {
        return visitDxStat;
    }

    public void setVisitDxStat(String visitDxStat) {
        this.visitDxStat = visitDxStat;
    }

    public String getVisitBeginAdmitDateTime() {
        return visitBeginAdmitDateTime;
    }

    public void setVisitBeginAdmitDateTime(String visitBeginAdmitDateTime) {
        this.visitBeginAdmitDateTime = visitBeginAdmitDateTime;
    }

    public String getVisitDenyAllergy() {
        return visitDenyAllergy;
    }

    public void setVisitDenyAllergy(String visitDenyAllergy) {
        this.visitDenyAllergy = visitDenyAllergy;
    }

    public String getVisitFirstVisit() {
        return visitFirstVisit;
    }

    public void setVisitFirstVisit(String visitFirstVisit) {
        this.visitFirstVisit = visitFirstVisit;
    }

    public String getVisitPatientSelfDoctor() {
        return visitPatientSelfDoctor;
    }

    public void setVisitPatientSelfDoctor(String visitPatientSelfDoctor) {
        this.visitPatientSelfDoctor = visitPatientSelfDoctor;
    }

    public String getVisitPatientAge() {
        return visitPatientAge;
    }

    public void setVisitPatientAge(String visitPatientAge) {
        this.visitPatientAge = visitPatientAge;
    }

    public String getVisitPcuService() {
        return visitPcuService;
    }

    public void setVisitPcuService(String visitPcuService) {
        this.visitPcuService = visitPcuService;
    }

    public String getVisitHospitalService() {
        return visitHospitalService;
    }

    public void setVisitHospitalService(String visitHospitalService) {
        this.visitHospitalService = visitHospitalService;
    }

    public String getVisitLabStatusId() {
        return visitLabStatusId;
    }

    public void setVisitLabStatusId(String visitLabStatusId) {
        this.visitLabStatusId = visitLabStatusId;
    }

    public String getVisitNcd() {
        return visitNcd;
    }

    public void setVisitNcd(String visitNcd) {
        this.visitNcd = visitNcd;
    }

    public String getBNcdGroupId() {
        return bNcdGroupId;
    }

    public void setBNcdGroupId(String bNcdGroupId) {
        this.bNcdGroupId = bNcdGroupId;
    }

    public String getFReferCauseId() {
        return fReferCauseId;
    }

    public void setFReferCauseId(String fReferCauseId) {
        this.fReferCauseId = fReferCauseId;
    }

    public String getFEmergencyStatusId() {
        return fEmergencyStatusId;
    }

    public void setFEmergencyStatusId(String fEmergencyStatusId) {
        this.fEmergencyStatusId = fEmergencyStatusId;
    }

    public String getVisitEmergencyStaff() {
        return visitEmergencyStaff;
    }

    public void setVisitEmergencyStaff(String visitEmergencyStaff) {
        this.visitEmergencyStaff = visitEmergencyStaff;
    }

    public String getVisitHaveAppointment() {
        return visitHaveAppointment;
    }

    public void setVisitHaveAppointment(String visitHaveAppointment) {
        this.visitHaveAppointment = visitHaveAppointment;
    }

    public String getVisitHaveAdmit() {
        return visitHaveAdmit;
    }

    public void setVisitHaveAdmit(String visitHaveAdmit) {
        this.visitHaveAdmit = visitHaveAdmit;
    }

    public String getVisitHaveRefer() {
        return visitHaveRefer;
    }

    public void setVisitHaveRefer(String visitHaveRefer) {
        this.visitHaveRefer = visitHaveRefer;
    }

    public String getTPatientAppointmentId() {
        return tPatientAppointmentId;
    }

    public void setTPatientAppointmentId(String tPatientAppointmentId) {
        this.tPatientAppointmentId = tPatientAppointmentId;
    }

    public String getVisitCalDateAppointment() {
        return visitCalDateAppointment;
    }

    public void setVisitCalDateAppointment(String visitCalDateAppointment) {
        this.visitCalDateAppointment = visitCalDateAppointment;
    }

    public String getVisitCauseAppointment() {
        return visitCauseAppointment;
    }
    public void setVisitCauseAppointment(String visitCauseAppointment) {
        this.visitCauseAppointment = visitCauseAppointment;
    }

    public String getVisitDate() {
        if(visitBeginVisitTime.length()>=10){
            visitDate = visitBeginVisitTime.substring(0, 10);
        }
        return visitDate;
    }

    public String getVisitTime() {
        if(visitBeginVisitTime.length()>=15){
            visitTime = visitBeginVisitTime.substring(11,16);
        }
        return visitTime;
    }
    public String getVisitDischargeDate() {
        if(visitFinancialDischargeTime.length()>=15){
            financialDischargeDate = visitFinancialDischargeTime.substring(0,10);
        }
        return financialDischargeDate;
    }
    public void setVisitDischargeDate(String financialDischargeDate){
        this.financialDischargeDate = financialDischargeDate;
    }

    public String getBContactPlansId() {
        return bContractPlansId;
    }
    public void setBContactPlansId(String bContractPlansId) {
        this.bContractPlansId = bContractPlansId;
    }

    public String getContactId() {
        return contactId;
    }
    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getContactNamet() {
        return contactNamet;
    }
    public void setContactNamet(String contactNamet) {
        this.contactNamet = contactNamet;
    }

    public String getContactJoinId() {
        return contactJoinId;
    }
    public void setContactJoinId(String contactJoinId) {
        this.contactJoinId = contactJoinId;
    }

    public String getContactJoinNamet() {
        return contactJoinNamet;
    }
    public void setContactJoinNamet(String contactJoinNamet) {
        this.contactJoinNamet = contactJoinNamet;
    }

    public String getSurveillanceCaseId() {
        return surveillanceCaseId;
    }
    public void setSurveillanceCaseId(String surveillanceCaseId) {
        this.surveillanceCaseId = surveillanceCaseId;
    }

    public String getServicePointDescription() {
        return servicePointDescription;
    }
    public void setServicePointDescription(String servicePointDescription) {
        this.servicePointDescription = servicePointDescription;
    }

    public String getContractPlansDescription() {
        return contractPlansDescription;
    }
    public void setContractPlansDescription(String contractPlansDescription) {
        this.contractPlansDescription = contractPlansDescription;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tVisitId != null ? tVisitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TVisit)) {
            return false;
        }
        TVisit other = (TVisit) object;
        if ((this.tVisitId == null && other.tVisitId != null) || (this.tVisitId != null && !this.tVisitId.equals(other.tVisitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaextend.TVisit[tVisitId=" + tVisitId + "]";
    }

}
