/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import java.io.Serializable;
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
@Table(name = "v_patient_visit_department_detail", catalog = "front_bangna3", schema = "public")
@NamedQueries({
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findAll", query = "SELECT v FROM VPatientVisitDepartmentDetail v"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByNameServicepoint", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.nameServicepoint = :nameServicepoint"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitHn", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitHn = :visitHn"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitVn", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitVn = :visitVn"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByPatientPrefixDescription", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.patientPrefixDescription = :patientPrefixDescription"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByPatientFirstname", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.patientFirstname = :patientFirstname"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByPatientLastname", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.patientLastname = :patientLastname"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitFinancialDischargeTime", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitFinancialDischargeTime = :visitFinancialDischargeTime"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitBeginVisitTime", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitBeginVisitTime = :visitBeginVisitTime"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitBeginVisitDate", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitBeginVisitDate = :visitBeginVisitDate"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitFinancialDischargeDate", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitFinancialDischargeDate = :visitFinancialDischargeDate"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByBServicePointId", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.bServicePointId = :bServicePointId"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitNotice", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitNotice = :visitNotice"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitDiagnosisNotice", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitDiagnosisNotice = :visitDiagnosisNotice"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitDx", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitDx = :visitDx"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitDxStat", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitDxStat = :visitDxStat"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitNcd", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitNcd = :visitNcd"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitHaveAdmit", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitHaveAdmit = :visitHaveAdmit"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitHaveRefer", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitHaveRefer = :visitHaveRefer"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitHaveAppointment", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitHaveAppointment = :visitHaveAppointment"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitPatientAge", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitPatientAge = :visitPatientAge"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitPregnant", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitPregnant = :visitPregnant"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitStaffDoctorDischarge", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitStaffDoctorDischarge = :visitStaffDoctorDischarge"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByEmployeeFirstname", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.employeeFirstname = :employeeFirstname"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByEmployeeLastname", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.employeeLastname = :employeeLastname"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByBNcdGroupId", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.bNcdGroupId = :bNcdGroupId"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByNcdGroupDescription", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.ncdGroupDescription = :ncdGroupDescription"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByFReferCauseId", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.fReferCauseId = :fReferCauseId"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByReferCauseDescription", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.referCauseDescription = :referCauseDescription"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByVisitCauseAppointment", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.visitCauseAppointment = :visitCauseAppointment"),
    @NamedQuery(name = "VPatientVisitDepartmentDetail.findByTVisitId", query = "SELECT v FROM VPatientVisitDepartmentDetail v WHERE v.tVisitId = :tVisitId")})
public class VPatientVisitDepartmentDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "name_servicepoint", length = 255)
    private String nameServicepoint="";
    @Column(name = "visit_hn", length = 255)
    private String visitHn="";
    @Column(name = "visit_vn", length = 255)
    private String visitVn="";
    @Column(name = "patient_prefix_description", length = 255)
    private String patientPrefixDescription="";
    @Column(name = "patient_firstname", length = 255)
    private String patientFirstname="";
    @Column(name = "patient_lastname", length = 255)
    private String patientLastname="";
    @Column(name = "visit_financial_discharge_time", length = 2147483647)
    private String visitFinancialDischargeTime="";
    @Column(name = "visit_begin_visit_time", length = 255)
    private String visitBeginVisitTime="";
    @Column(name = "visit_begin_visit_date", length = 2147483647)
    private String visitBeginVisitDate="";
    @Column(name = "visit_financial_discharge_date", length = 2147483647)
    private String visitFinancialDischargeDate="";
    @Column(name = "b_service_point_id", length = 255)
    private String bServicePointId="";
    @Column(name = "visit_notice", length = 255)
    private String visitNotice="";
    @Column(name = "visit_diagnosis_notice", length = 5000)
    private String visitDiagnosisNotice="";
    @Column(name = "visit_dx", length = 255)
    private String visitDx="";
    @Column(name = "visit_dx_stat", length = 255)
    private String visitDxStat="";
    @Column(name = "visit_ncd", length = 255)
    private String visitNcd="";
    @Column(name = "visit_have_admit", length = 255)
    private String visitHaveAdmit="";
    @Column(name = "visit_have_refer", length = 255)
    private String visitHaveRefer="";
    @Column(name = "visit_have_appointment", length = 255)
    private String visitHaveAppointment="";
    @Column(name = "visit_patient_age", length = 255)
    private String visitPatientAge="";
    @Column(name = "visit_pregnant", length = 255)
    private String visitPregnant="";
    @Column(name = "visit_staff_doctor_discharge", length = 255)
    private String visitStaffDoctorDischarge="";
    @Column(name = "employee_firstname", length = 255)
    private String employeeFirstname="";
    @Column(name = "employee_lastname", length = 255)
    private String employeeLastname="";
    @Column(name = "b_ncd_group_id", length = 255)
    private String bNcdGroupId="";
    @Column(name = "ncd_group_description", length = 255)
    private String ncdGroupDescription="";
    @Column(name = "f_refer_cause_id", length = 255)
    private String fReferCauseId="";
    @Column(name = "refer_cause_description", length = 255)
    private String referCauseDescription="";
    @Column(name = "visit_cause_appointment", length = 255)
    private String visitCauseAppointment="";
    @Column(name = "t_visit_id", length = 255)
    @Id
    private String tVisitId="";
    @Column(name = "contract_plans_description", length = 255)
    private String contractPlansDescription="";
    @Column(name = "visit_clinic_description", length = 255)
    private String visitClinicDescription="";
    @Column(name = "billing_total", length = 255)
    private Double billingTotal=0.0;
    

    public VPatientVisitDepartmentDetail() {
    }
    public void initial(){
        nameServicepoint="";
        visitHn="";
        visitVn="";
        patientPrefixDescription="";
        patientFirstname="";
        patientLastname="";
        visitFinancialDischargeTime="";
        visitBeginVisitTime="";
        visitBeginVisitDate="";
        visitFinancialDischargeDate="";
        bServicePointId="";
        visitNotice="";
        visitDiagnosisNotice="";
        visitDx="";
        visitDxStat="";
        visitNcd="";
        visitHaveAdmit="";
        visitHaveRefer="";
        visitHaveAppointment="";
        visitPatientAge="";
        visitPregnant="";
        visitStaffDoctorDischarge="";
        employeeFirstname="";
        employeeLastname="";
        bNcdGroupId="";
        ncdGroupDescription="";
        fReferCauseId="";
        referCauseDescription="";
        visitCauseAppointment="";
        tVisitId="";
        contractPlansDescription="";
        visitClinicDescription="";
        billingTotal=0.0;
    }
    public String getVPatientVisitDepartmentDetail(){
        return "v_patient_visit_department_detail";
    }

    public String getFNameServicepoint(){
        return "name_servicepoint";
    }
    public String getFVisitHn(){
        return "visit_hn";
    }
    public String getFVisitVn(){
        return "visit_vn";
    }
    public String getFPatientPrefixDescription(){
        return "patient_prefix_description";
    }
    public String getFPatientFirstname(){
        return "patient_firstname";
    }
    public String getFPatientLastname(){
        return "patient_lastname";
    }
    public String getFVisitFinancialDischargeTime(){
        return "visit_financial_discharge_time";
    }
    public String getFVisitBeginVisitTime(){
        return "visit_begin_visit_time";
    }
    public String getFVisitBeginVisitDate(){
        return "visit_begin_visit_date";
    }
    public String getFVisitFinancialDischargeDate(){
        return "visit_financial_discharge_date";
    }
    public String getFBServicePointId(){
        return "b_service_point_id";
    }
    public String getFVisitNotice(){
        return "visit_notice";
    }
    public String getFVisitDiagnosisNotice(){
        return "visit_diagnosis_notice";
    }
    public String getFVisitDx(){
        return "visit_dx";
    }
    public String getFVisitDxStat(){
        return "visit_dx_stat";
    }
    public String getFVisitNcd(){
        return "visit_ncd";
    }
    public String getFVisitHaveAdmit(){
        return "visit_have_admit";
    }
    public String getFVisitHaveRefer(){
        return "visit_have_refer";
    }
    public String getFVisitHaveAppointment(){
        return "visit_have_appointment";
    }
    public String getFVisitPatientAge(){
        return "visit_patient_age";
    }
    public String getFVisitPregnant(){
        return "visit_pregnant";
    }
    public String getFVisitStaffDoctorDischarge(){
        return "visit_staff_doctor_discharge";
    }
    public String getFEmployeeFirstname(){
        return "employee_firstname";
    }
    public String getFEmployeeLastname(){
        return "employee_lastname";
    }
    public String getFBNcdGroupId(){
        return "b_ncd_group_id";
    }
    public String getFNcdGroupDescription(){
        return "ncd_group_description";
    }
    public String getFFReferCauseId(){
        return "f_refer_cause_id";
    }
    public String getFReferCauseDescription(){
        return "refer_cause_description";
    }
    public String getFVisitCauseAppointment(){
        return "visit_cause_appointment";
    }
    public String getFTVisitId(){
        return "t_visit_id";
    }
    public String getFContractPlansDescription(){
        return "contract_plans_description";
    }
    public String getFVisitClinicDescription(){
        return "visit_clinic_description";
    }
    public String getFBillingTotal(){
        return "billing_total";
    }

    public String getNameServicepoint() {
        return nameServicepoint;
    }

    public void setNameServicepoint(String nameServicepoint) {
        if(nameServicepoint ==null){
            this.nameServicepoint = nameServicepoint;
        }else{
            this.nameServicepoint = "";
        }
        
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

    public String getPatientPrefixDescription() {
        return patientPrefixDescription;
    }

    public void setPatientPrefixDescription(String patientPrefixDescription) {
        this.patientPrefixDescription = patientPrefixDescription;
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

    public String getVisitFinancialDischargeTime() {
        return visitFinancialDischargeTime;
    }

    public void setVisitFinancialDischargeTime(String visitFinancialDischargeTime) {
        this.visitFinancialDischargeTime = visitFinancialDischargeTime;
    }

    public String getVisitBeginVisitTime() {
        return visitBeginVisitTime;
    }

    public void setVisitBeginVisitTime(String visitBeginVisitTime) {
        this.visitBeginVisitTime = visitBeginVisitTime;
    }

    public String getVisitBeginVisitDate() {
        return visitBeginVisitDate;
    }

    public void setVisitBeginVisitDate(String visitBeginVisitDate) {
        this.visitBeginVisitDate = visitBeginVisitDate;
    }

    public String getVisitFinancialDischargeDate() {
        return visitFinancialDischargeDate;
    }

    public void setVisitFinancialDischargeDate(String visitFinancialDischargeDate) {
        this.visitFinancialDischargeDate = visitFinancialDischargeDate;
    }

    public String getBServicePointId() {
        return bServicePointId;
    }

    public void setBServicePointId(String bServicePointId) {
        this.bServicePointId = bServicePointId;
    }

    public String getVisitNotice() {
        return visitNotice;
    }

    public void setVisitNotice(String visitNotice) {
        this.visitNotice = visitNotice;
    }

    public String getVisitDiagnosisNotice() {
        return visitDiagnosisNotice;
    }

    public void setVisitDiagnosisNotice(String visitDiagnosisNotice) {
        this.visitDiagnosisNotice = visitDiagnosisNotice;
    }

    public String getVisitDx() {
        return visitDx;
    }

    public void setVisitDx(String visitDx) {
        this.visitDx = visitDx;
    }

    public String getVisitDxStat() {
        return visitDxStat;
    }

    public void setVisitDxStat(String visitDxStat) {
        this.visitDxStat = visitDxStat;
    }

    public String getVisitNcd() {
        return visitNcd;
    }

    public void setVisitNcd(String visitNcd) {
        this.visitNcd = visitNcd;
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

    public String getVisitHaveAppointment() {
        return visitHaveAppointment;
    }

    public void setVisitHaveAppointment(String visitHaveAppointment) {
        this.visitHaveAppointment = visitHaveAppointment;
    }

    public String getVisitPatientAge() {
        return visitPatientAge;
    }

    public void setVisitPatientAge(String visitPatientAge) {
        this.visitPatientAge = visitPatientAge;
    }

    public String getVisitPregnant() {
        return visitPregnant;
    }

    public void setVisitPregnant(String visitPregnant) {
        this.visitPregnant = visitPregnant;
    }

    public String getVisitStaffDoctorDischarge() {
        return visitStaffDoctorDischarge;
    }

    public void setVisitStaffDoctorDischarge(String visitStaffDoctorDischarge) {
        this.visitStaffDoctorDischarge = visitStaffDoctorDischarge;
    }

    public String getEmployeeFirstname() {
        return employeeFirstname;
    }

    public void setEmployeeFirstname(String employeeFirstname) {
        this.employeeFirstname = employeeFirstname;
    }

    public String getEmployeeLastname() {
        return employeeLastname;
    }

    public void setEmployeeLastname(String employeeLastname) {
        this.employeeLastname = employeeLastname;
    }

    public String getBNcdGroupId() {
        return bNcdGroupId;
    }

    public void setBNcdGroupId(String bNcdGroupId) {
        this.bNcdGroupId = bNcdGroupId;
    }

    public String getNcdGroupDescription() {
        return ncdGroupDescription;
    }

    public void setNcdGroupDescription(String ncdGroupDescription) {
        this.ncdGroupDescription = ncdGroupDescription;
    }

    public String getFReferCauseId() {
        return fReferCauseId;
    }

    public void setFReferCauseId(String fReferCauseId) {
        this.fReferCauseId = fReferCauseId;
    }

    public String getReferCauseDescription() {
        return referCauseDescription;
    }

    public void setReferCauseDescription(String referCauseDescription) {
        this.referCauseDescription = referCauseDescription;
    }

    public String getVisitCauseAppointment() {
        return visitCauseAppointment;
    }

    public void setVisitCauseAppointment(String visitCauseAppointment) {
        this.visitCauseAppointment = visitCauseAppointment;
    }

    public String getTVisitId() {
        return tVisitId;
    }

    public void setTVisitId(String tVisitId) {
        this.tVisitId = tVisitId;
    }
    public String getContractPlansDescription() {
        return contractPlansDescription;
    }
    public void setContractPlansDescription(String contractPlansDescription) {
        this.contractPlansDescription = contractPlansDescription;
    }
    public String getVisitClinicDescription() {
        return visitClinicDescription;
    }
    public void setVisitClinicDescription(String visitClinicDescription) {
        this.visitClinicDescription = visitClinicDescription;
    }
    public Double getBillingTotal() {
        return billingTotal;
    }
    public void setBillingTotal(Double billingTotal) {
        this.billingTotal = billingTotal;
    }

}
