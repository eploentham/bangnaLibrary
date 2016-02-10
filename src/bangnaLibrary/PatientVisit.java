package bangnaLibrary;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author pop
 */
public class PatientVisit extends Patient {
    private String visit_date ="", visit_doctor_id="",visit_doctor_namet="", contract_plans_pttype="",invoice_number="",receive_number="", contract_payer_number="";
    private String visit_paid_id="", visit_paid_namet="", visit_diagnosis_notice="", visit_contact_join_id="", visit_contact_join_namet=""; //�Է��㹡�ê����Թ
    private Double paid=0.0, amount=0.0, discount=0.0,billing_patient_share=0.0,billing_payer_share=0.0;//�Թ������㹡���ѡ�� ���¨�ԧ, �ʹ�Թ���, ��ǹŴ
    private String visit_vn="", visit_time="", visit_contact_id="", visit_contact_namet="", f_visit_type_id="", close_day_id="", close_day_date="";
    private String visit_clinic_id="", visit_clinic_namet="", visit_financial_discharge_time="";//clinic ����ѡ�� �����Ἱ�����������
    private String claim_id="", claim_namet="", visit_notice="", t_visit_id="",b_service_point_id="", visit_hospital_service="",t_visit_payment_id=""; //�Է��㹡���ѡ��
    private String visitAn="", statusUnbilling="";
    public String bed="", wardName="", room="", docCD="";
    public void initial(){
        visit_date =""; visit_doctor_id="";visit_doctor_namet=""; contract_plans_pttype="";invoice_number="";receive_number=""; contract_payer_number="";
        visit_paid_id=""; visit_paid_namet=""; visit_diagnosis_notice=""; visit_contact_join_id=""; visit_contact_join_namet=""; //�Է��㹡�ê����Թ
        paid=0.0; amount=0.0; discount=0.0;billing_patient_share=0.0;billing_payer_share=0.0;//�Թ������㹡���ѡ�� ���¨�ԧ; �ʹ�Թ���; ��ǹŴ
        visit_vn=""; visit_time=""; visit_contact_id=""; visit_contact_namet=""; f_visit_type_id=""; close_day_id=""; close_day_date="";
        visit_clinic_id=""; visit_clinic_namet=""; visit_financial_discharge_time="";//clinic ����ѡ�� �����Ἱ�����������
        claim_id=""; claim_namet=""; visit_notice=""; t_visit_id="";b_service_point_id=""; visit_hospital_service="";t_visit_payment_id="";
        bed=""; wardName=""; room="";//�Է��㹡���ѡ��
    }
    public String getVisitDate(){
        return visit_date;
    }
    public void setVisitDate(String visit_date){
        this.visit_date = visit_date;
    }

    public String getVisitDoctorId(){
        return visit_doctor_id;
    }
    public void setVisitDoctorId(String visit_doctor_id){
        this.visit_doctor_id = visit_doctor_id;
    }
    public String getVisitDoctorNamet(){
        return visit_doctor_namet;
    }
    public void setVisitDoctorNamet(String visit_doctor_namet){
        this.visit_doctor_namet = visit_doctor_namet;
    }
    public String getVisitPaidId(){
        return visit_paid_id;
    }
    public void setVisitPaidId(String paid_id){
        this.visit_paid_id = paid_id;
    }
    public String getVisitPaidNamet(){
        return visit_paid_namet;
    }
    public void setVisitPaidNamet(String paid_namet){
        this.visit_paid_namet = paid_namet;
    }
    public String getVisitTime(){
        return visit_time;
    }
    public void setVisitTime(String visitTime){
        this.visit_time = visitTime;
    }
    public String getVisitVn(){
        return visit_vn;
    }
    public void setVisitVn(String visit_vn){
        this.visit_vn = visit_vn;
    }
    public String getVisitClinicId(){
        return visit_clinic_id;
    }
    public void setVisitClinicId(String visit_clinic_id){
        this.visit_clinic_id = visit_clinic_id;
    }
    public String getVisitClinicNamet(){
        return visit_clinic_namet;
    }
    public void setVisitClinicNamet(String visit_clinic_namet){
        this.visit_clinic_namet = visit_clinic_namet;
    }

    public String getVisitNotice(){
        return visit_notice;
    }
    public void setVisitNotice(String visit_notice){
        this.visit_notice = visit_notice;
    }

    public String getVisitContactId(){
        return visit_contact_id;
    }
    public void setVisitContactId(String visit_contact_id){
        this.visit_contact_id = visit_contact_id;
    }

    public String getVisitContactNamet(){
        return visit_contact_namet;
    }
    public void setVisitContactNamet(String visit_contact_namet){
        this.visit_contact_namet = visit_contact_namet;
    }
    public String getTVisitId(){
        return t_visit_id;
    }
    public void setTVisitId(String t_visit_id){
        this.t_visit_id = t_visit_id;
    }
    public Double getPaid(){
        return paid;
    }
    public void setPaid(Double paid){
        this.paid = paid;
    }
    public Double getAmount(){
        return amount;
    }
    public void setAmount(Double amount){
        this.amount = amount;
    }
    public Double getDiscount(){
        return discount;
    }
    public void setDiscount(Double discount){
        this.discount = discount;
    }
    public String getBServerPointId(){
        return b_service_point_id;
    }
    public void setBServerPointId(String b_service_point_id){
        this.b_service_point_id = b_service_point_id;
    }
    public String getVisitHospitalService(){
        return visit_hospital_service;
    }
    public void setVisitHospitalService(String visit_hospital_service){
        this.visit_hospital_service = visit_hospital_service;
    }
    public String getVisitDiagnosisNotice(){
        return visit_diagnosis_notice;
    }
    public void setVisitDiagnosisNotice(String visit_diagnosis_notice){
        this.visit_diagnosis_notice = visit_diagnosis_notice;
    }
    public String getVisitFinancialDischargeTime(){
        return visit_financial_discharge_time;
    }
    public void setVisitFinancialDischargeTime(String visit_financial_discharge_time){
        this.visit_financial_discharge_time = visit_financial_discharge_time;
    }
    public String getTVisitPaymentId(){
        return t_visit_payment_id;
    }
    public void setTVisitPayment(String t_visit_payment_id){
        this.t_visit_payment_id = t_visit_payment_id;
    }
    public Double getBillingPatientShare(){
        return billing_patient_share;
    }
    public void setBillingPatientShare(Double billing_patient_share){
        this.billing_patient_share = billing_patient_share;
    }
    public Double getBillingPayerShare(){
        return billing_payer_share;
    }
    public void setBillingPayerShare(Double billing_payer_share){
        this.billing_payer_share = billing_payer_share;
    }
    public String getFVisitTypeId(){
        return f_visit_type_id;
    }
    public void setFVisitTypeId(String f_visit_type_id){
        this.f_visit_type_id = f_visit_type_id;
    }
    public String getContractPlansPttype(){
        return contract_plans_pttype;
    }
    public void setContractPlansPttype(String contract_plans_pttype){
        this.contract_plans_pttype = contract_plans_pttype;
    }

    public String getInvoiceNumber(){
        return invoice_number;
    }
    public void setInvoiceNumber(String invoice_number){
        this.invoice_number = invoice_number;
    }

    public String getReceiptNumber(){
        return receive_number;
    }
    public void setReceiptNumber(String receive_number){
        this.receive_number = receive_number;
    }

    public String getContractPayerNumber(){
        return contract_payer_number;
    }
    public void setContractPayerNumber(String contract_payer_number){
        this.contract_payer_number = contract_payer_number;
    }

    public String getCloseDayId(){
        return close_day_id;
    }
    public void setCloseDayId(String close_day_id){
        this.close_day_id = close_day_id;
    }

    public String getVisitContactJoinId(){
        return visit_contact_join_id;
    }
    public void setVisitContactJoinId(String contact_join_id){
        this.visit_contact_join_id = contact_join_id;
    }

    public String getVisitContactJoinNamet(){
        return visit_contact_join_namet;
    }
    public void setVisitContactJoinNamet(String contact_join_namet){
        this.visit_contact_join_namet = contact_join_namet;
    }

    public String getCloseDayDate(){
        return close_day_date;
    }
    public void setCloseDayDate(String close_day_date){
        this.close_day_date = close_day_date;
    }
    public String getVisitAn(){
        return visitAn;
    }
    public void setVisitAn(String visitAn){
        this.visitAn = visitAn;
    }
    
    public String getStatusUnbilling(){
        return statusUnbilling;
    }
    public void setStatusUnbilling(String statusUnbilling){
        this.statusUnbilling = statusUnbilling;
    }

}
