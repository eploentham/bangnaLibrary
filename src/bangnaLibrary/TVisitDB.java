/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import bangnaLibrary.Config1;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class TVisitDB {
    public Config1 config1 = new Config1();
    TVisit t_visit = new TVisit();
    VVisit v_visit = new VVisit();
    public TVisitDB(){
        config1 = new Config1();
    }
    public TVisitDB(Config1 cf){
        config1 = cf;
    }
    public String getMaxRowCashierTBillingInvoicePrint(Connection conn) {
        String sql="", max="";
        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select max("+t_visit.getFTVisitId()+") as cnt From "+t_visit.getTVisit();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if(max!=null && !max.equals("")) {
                max =  String.valueOf(Integer.parseInt(max)+1);
            }
            else{
                max = "16900001";
            }
        } catch (Exception ex) {
            Logger.getLogger(TVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public TVisit getTVisitByPK(String brach_id, String where, String t_visit_id, String flag) {
        Connection conn;
        String sql="";
        try {
            conn = config1.getConnectionHospital(brach_id);
            Statement stbangna = conn.createStatement();

            if(flag.equals("visit_vn")){
                sql="Select * "
                +"From "+t_visit.getTVisit()+" "
                +"Where "+t_visit.getFVisitVn()+"='"+t_visit_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }else{
                sql="Select * "
                +"From "+t_visit.getTVisit()+" "
                +"Where "+t_visit.getFTVisitId()+"='"+t_visit_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                t_visit = new TVisit();
                t_visit.setBNcdGroupId(config1.StringNull(rs.getString(t_visit.getFBNcdGroupId())));
                t_visit.setBServicePointId(config1.StringNull(rs.getString(t_visit.getFBServicePointId())));
                t_visit.setBVisitClinicId(config1.StringNull(rs.getString(t_visit.getFBVisitClinicId())));
                t_visit.setBVisitOfficeIdReferIn(config1.StringNull(rs.getString(t_visit.getFBVisitOfficeIdReferIn())));
                t_visit.setBVisitOfficeIdReferOut(config1.StringNull(rs.getString(t_visit.getFBVisitOfficeIdReferOut())));

                t_visit.setBVisitWardId(config1.StringNull(rs.getString(t_visit.getFBVisitWardId())));
                t_visit.setFEmergencyStatusId(config1.StringNull(rs.getString(t_visit.getFFEmergencyStatusId())));
                t_visit.setFReferCauseId(config1.StringNull(rs.getString(t_visit.getFFReferCauseId())));
                t_visit.setFVisitIpdDischargeStatusId(config1.StringNull(rs.getString(t_visit.getFFVisitIpdDischargeStatusId())));
                t_visit.setFVisitIpdDischargeTypeId(config1.StringNull(rs.getString(t_visit.getFFVisitIpdDischargeTypeId())));

                t_visit.setFVisitOpdDischargeStatusId(config1.StringNull(rs.getString(t_visit.getFFVisitOpdDischargeStatusId())));
                t_visit.setFVisitStatusId(config1.StringNull(rs.getString(t_visit.getFFVisitStatusId())));
                t_visit.setFVisitTypeId(config1.StringNull(rs.getString(t_visit.getFFVisitTypeId())));
                t_visit.setTPatientAppointmentId(config1.StringNull(rs.getString(t_visit.getFTPatientAppointmentId())));
                t_visit.setTPatientId(config1.StringNull(rs.getString(t_visit.getFTPatientId())));

                t_visit.setTVisitId(config1.StringNull(rs.getString(t_visit.getFTVisitId())));
                t_visit.setVisitAn(config1.StringNull(rs.getString(t_visit.getFVisitAn())));
                t_visit.setVisitBed(config1.StringNull(rs.getString(t_visit.getFVisitBed())));
                t_visit.setVisitBeginAdmitDateTime(config1.StringNull(rs.getString(t_visit.getFVisitBeginAdmitDateTime())));
                t_visit.setVisitBeginVisitTime(config1.StringNull(rs.getString(t_visit.getFVisitBeginVisitTime())));

                t_visit.setVisitCalDateAppointment(config1.StringNull(rs.getString(t_visit.getFVisitCalDateAppointment())));
                t_visit.setVisitCauseAppointment(config1.StringNull(rs.getString(t_visit.getFVisitCauseAppointment())));
                t_visit.setVisitDenyAllergy(config1.StringNull(rs.getString(t_visit.getFVisitDenyAllergy())));
                t_visit.setVisitDiagnosisNotice(config1.StringNull(rs.getString(t_visit.getFVisitDiagnosisNotice())));
                t_visit.setVisitDoctorDischargeStatus(config1.StringNull(rs.getString(t_visit.getFVisitDoctorDischargeStatus())));

                t_visit.setVisitDx(config1.StringNull(rs.getString(t_visit.getFVisitDx())));
                t_visit.setVisitDxStat(config1.StringNull(rs.getString(t_visit.getFVisitDxStat())));
                t_visit.setVisitEmergencyStaff(config1.StringNull(rs.getString(t_visit.getFVisitEmergencyStaff())));
                t_visit.setVisitFinancialDischargeTime(config1.StringNull(rs.getString(t_visit.getFVisitFinancialDischargeTime())));
                t_visit.setVisitFirstVisit(config1.StringNull(rs.getString(t_visit.getFVisitFirstVisit())));

                t_visit.setVisitHaveAdmit(config1.StringNull(rs.getString(t_visit.getFVisitHaveAdmit())));
                t_visit.setVisitHaveAppointment(config1.StringNull(rs.getString(t_visit.getFVisitHaveAppointment())));
                t_visit.setVisitHaveRefer(config1.StringNull(rs.getString(t_visit.getFVisitHaveRefer())));
                t_visit.setVisitHn(config1.StringNull(rs.getString(t_visit.getFVisitHn())));
                t_visit.setVisitHospitalService(config1.StringNull(rs.getString(t_visit.getFVisitHospitalService())));

                t_visit.setVisitIpdDischargeStatus(config1.StringNull(rs.getString(t_visit.getFVisitIpdDischargeStatus())));
                t_visit.setVisitLabStatusId(config1.StringNull(rs.getString(t_visit.getFVisitLabStatusId())));
                t_visit.setVisitLockDateTime(config1.StringNull(rs.getString(t_visit.getFVisitLockDateTime())));
                t_visit.setVisitLocking(config1.StringNull(rs.getString(t_visit.getFVisitLocking())));
                t_visit.setVisitMoneyDischargeStatus(config1.StringNull(rs.getString(t_visit.getFVisitMoneyDischargeStatus())));

                t_visit.setVisitNcd(config1.StringNull(rs.getString(t_visit.getFVisitNcd())));
                t_visit.setVisitNotice(config1.StringNull(rs.getString(t_visit.getFVisitNotice())));
                t_visit.setVisitObserve(config1.StringNull(rs.getString(t_visit.getFVisitObserve())));
                t_visit.setVisitPatientAge(config1.StringNull(rs.getString(t_visit.getFVisitPatientAge())));
                t_visit.setVisitPatientSelfDoctor(config1.StringNull(rs.getString(t_visit.getFVisitPatientSelfDoctor())));

                t_visit.setVisitPatientType(config1.StringNull(rs.getString(t_visit.getFVisitPatientType())));
                t_visit.setVisitPregnant(config1.StringNull(rs.getString(t_visit.getFVisitPregnant())));
                t_visit.setVisitPcuService(config1.StringNull(rs.getString(t_visit.getFVisitPcuService())));
                t_visit.setVisitQueue(config1.StringNull(rs.getString(t_visit.getFVisitQueue())));
                t_visit.setVisitStaffDoctorDischarge(config1.StringNull(rs.getString(t_visit.getFVisitStaffDoctorDischarge())));

                t_visit.setVisitStaffDoctorDischargeDateTime(config1.StringNull(rs.getString(t_visit.getFVisitStaffDoctorDischargeDateTime())));
                t_visit.setVisitStaffFinancialDischarge(config1.StringNull(rs.getString(t_visit.getFVisitStaffFinancialDischarge())));
                t_visit.setVisitStaffLock(config1.StringNull(rs.getString(t_visit.getFVisitStaffLock())));
                t_visit.setVisitStaffObserve(config1.StringNull(rs.getString(t_visit.getFVisitStaffObserve())));
                t_visit.setVisitVn(config1.StringNull(rs.getString(t_visit.getFVisitVn())));

                t_visit.setContactId(config1.StringNull(rs.getString(t_visit.getFContactId())));
                t_visit.setContactNamet(config1.StringNull(rs.getString(t_visit.getFContactNamet())));
                t_visit.setSurveillanceCaseId(config1.StringNull(rs.getString(t_visit.getFSurveillanceCaseId())));
                t_visit.setContactJoinId(config1.StringNull(rs.getString(t_visit.getFContactJoinId())));
                t_visit.setContactJoinNamet(config1.StringNull(rs.getString(t_visit.getFContactJoinNamet())));

                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(TVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t_visit;
    }
    public Vector getTVisit(String brach_id, String where, String t_visit_id, String flag) {
        Connection conn;
        String sql="";
        Vector v_t_visit = new Vector();
        try {
            conn = config1.getConnectionHospital(brach_id);
            Statement stbangna = conn.createStatement();
            if(flag.equals("visit_hn")){
                sql="Select tv.*, bcp.contract_plans_description, bsp.service_point_description "
                +"From "+t_visit.getTVisit()+" tv "
                + "left join b_contract_plans bcp on tv."+t_visit.getFBContractPlansId()+"= bcp.b_contract_plans_id "
                + "left join b_service_point bsp on tv."+t_visit.getFBServicePointId()+"=bsp.b_service_point_id "
                +"Where tv."+t_visit.getFVisitHn()+"='"+t_visit_id+"' and tv."+t_visit.getFFVisitStatusId()+" <> '4' "
                +"Order By tv."+t_visit.getFVisitBeginVisitTime()+" asc";
            }else{
                sql="Select * "
                +"From "+t_visit.getTVisit()+" "
                +"Where "+t_visit.getFTVisitId()+"='"+t_visit_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                t_visit = new TVisit();
                t_visit.setBNcdGroupId(config1.StringNull(rs.getString(t_visit.getFBNcdGroupId())));
                t_visit.setBServicePointId(config1.StringNull(rs.getString(t_visit.getFBServicePointId())));
                t_visit.setBVisitClinicId(config1.StringNull(rs.getString(t_visit.getFBVisitClinicId())));
                t_visit.setBVisitOfficeIdReferIn(config1.StringNull(rs.getString(t_visit.getFBVisitOfficeIdReferIn())));
                t_visit.setBVisitOfficeIdReferOut(config1.StringNull(rs.getString(t_visit.getFBVisitOfficeIdReferOut())));

                t_visit.setBVisitWardId(config1.StringNull(rs.getString(t_visit.getFBVisitWardId())));
                t_visit.setFEmergencyStatusId(config1.StringNull(rs.getString(t_visit.getFFEmergencyStatusId())));
                t_visit.setFReferCauseId(config1.StringNull(rs.getString(t_visit.getFFReferCauseId())));
                t_visit.setFVisitIpdDischargeStatusId(config1.StringNull(rs.getString(t_visit.getFFVisitIpdDischargeStatusId())));
                t_visit.setFVisitIpdDischargeTypeId(config1.StringNull(rs.getString(t_visit.getFFVisitIpdDischargeTypeId())));

                t_visit.setFVisitOpdDischargeStatusId(config1.StringNull(rs.getString(t_visit.getFFVisitOpdDischargeStatusId())));
                t_visit.setFVisitStatusId(config1.StringNull(rs.getString(t_visit.getFFVisitStatusId())));
                t_visit.setFVisitTypeId(config1.StringNull(rs.getString(t_visit.getFFVisitTypeId())));
                t_visit.setTPatientAppointmentId(config1.StringNull(rs.getString(t_visit.getFTPatientAppointmentId())));
                t_visit.setTPatientId(config1.StringNull(rs.getString(t_visit.getFTPatientId())));

                t_visit.setTVisitId(config1.StringNull(rs.getString(t_visit.getFTVisitId())));
                t_visit.setVisitAn(config1.StringNull(rs.getString(t_visit.getFVisitAn())));
                t_visit.setVisitBed(config1.StringNull(rs.getString(t_visit.getFVisitBed())));
                t_visit.setVisitBeginAdmitDateTime(config1.StringNull(rs.getString(t_visit.getFVisitBeginAdmitDateTime())));
                t_visit.setVisitBeginVisitTime(config1.StringNull(rs.getString(t_visit.getFVisitBeginVisitTime())));

                t_visit.setVisitCalDateAppointment(config1.StringNull(rs.getString(t_visit.getFVisitCalDateAppointment())));
                t_visit.setVisitCauseAppointment(config1.StringNull(rs.getString(t_visit.getFVisitCauseAppointment())));
                t_visit.setVisitDenyAllergy(config1.StringNull(rs.getString(t_visit.getFVisitDenyAllergy())));
                t_visit.setVisitDiagnosisNotice(config1.StringNull(rs.getString(t_visit.getFVisitDiagnosisNotice())));
                t_visit.setVisitDoctorDischargeStatus(config1.StringNull(rs.getString(t_visit.getFVisitDoctorDischargeStatus())));

                t_visit.setVisitDx(config1.StringNull(rs.getString(t_visit.getFVisitDx())));
                t_visit.setVisitDxStat(config1.StringNull(rs.getString(t_visit.getFVisitDxStat())));
                t_visit.setVisitEmergencyStaff(config1.StringNull(rs.getString(t_visit.getFVisitEmergencyStaff())));
                t_visit.setVisitFinancialDischargeTime(config1.StringNull(rs.getString(t_visit.getFVisitFinancialDischargeTime())));
                t_visit.setVisitFirstVisit(config1.StringNull(rs.getString(t_visit.getFVisitFirstVisit())));

                t_visit.setVisitHaveAdmit(config1.StringNull(rs.getString(t_visit.getFVisitHaveAdmit())));
                t_visit.setVisitHaveAppointment(config1.StringNull(rs.getString(t_visit.getFVisitHaveAppointment())));
                t_visit.setVisitHaveRefer(config1.StringNull(rs.getString(t_visit.getFVisitHaveRefer())));
                t_visit.setVisitHn(config1.StringNull(rs.getString(t_visit.getFVisitHn())));
                t_visit.setVisitHospitalService(config1.StringNull(rs.getString(t_visit.getFVisitHospitalService())));

                t_visit.setVisitIpdDischargeStatus(config1.StringNull(rs.getString(t_visit.getFVisitIpdDischargeStatus())));
                t_visit.setVisitLabStatusId(config1.StringNull(rs.getString(t_visit.getFVisitLabStatusId())));
                t_visit.setVisitLockDateTime(config1.StringNull(rs.getString(t_visit.getFVisitLockDateTime())));
                t_visit.setVisitLocking(config1.StringNull(rs.getString(t_visit.getFVisitLocking())));
                t_visit.setVisitMoneyDischargeStatus(config1.StringNull(rs.getString(t_visit.getFVisitMoneyDischargeStatus())));

                t_visit.setVisitNcd(config1.StringNull(rs.getString(t_visit.getFVisitNcd())));
                t_visit.setVisitNotice(config1.StringNull(rs.getString(t_visit.getFVisitNotice())));
                t_visit.setVisitObserve(config1.StringNull(rs.getString(t_visit.getFVisitObserve())));
                t_visit.setVisitPatientAge(config1.StringNull(rs.getString(t_visit.getFVisitPatientAge())));
                t_visit.setVisitPatientSelfDoctor(config1.StringNull(rs.getString(t_visit.getFVisitPatientSelfDoctor())));

                t_visit.setVisitPatientType(config1.StringNull(rs.getString(t_visit.getFVisitPatientType())));
                t_visit.setVisitPregnant(config1.StringNull(rs.getString(t_visit.getFVisitPregnant())));
                t_visit.setVisitPcuService(config1.StringNull(rs.getString(t_visit.getFVisitPcuService())));
                t_visit.setVisitQueue(config1.StringNull(rs.getString(t_visit.getFVisitQueue())));
                t_visit.setVisitStaffDoctorDischarge(config1.StringNull(rs.getString(t_visit.getFVisitStaffDoctorDischarge())));

                t_visit.setVisitStaffDoctorDischargeDateTime(config1.StringNull(rs.getString(t_visit.getFVisitStaffDoctorDischargeDateTime())));
                t_visit.setVisitStaffFinancialDischarge(config1.StringNull(rs.getString(t_visit.getFVisitStaffFinancialDischarge())));
                t_visit.setVisitStaffLock(config1.StringNull(rs.getString(t_visit.getFVisitStaffLock())));
                t_visit.setVisitStaffObserve(config1.StringNull(rs.getString(t_visit.getFVisitStaffObserve())));
                t_visit.setVisitVn(config1.StringNull(rs.getString(t_visit.getFVisitVn())));

                t_visit.setContactId(config1.StringNull(rs.getString(t_visit.getFContactId())));
                t_visit.setContactNamet(config1.StringNull(rs.getString(t_visit.getFContactNamet())));
                t_visit.setSurveillanceCaseId(config1.StringNull(rs.getString(t_visit.getFSurveillanceCaseId())));
                t_visit.setContactJoinId(config1.StringNull(rs.getString(t_visit.getFContactJoinId())));
                t_visit.setContactJoinNamet(config1.StringNull(rs.getString(t_visit.getFContactJoinNamet())));

                t_visit.setServicePointDescription(config1.StringNull(rs.getString("service_point_description")));
                t_visit.setContractPlansDescription(config1.StringNull(rs.getString("contract_plans_description")));

                v_t_visit.add(t_visit);

            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(TVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_t_visit;
    }
    public Vector getVVisit(String brach_id, String visit_date_start, String visit_date_end, String discharge, 
            String days, String visit_vn, String visit_hn, String flag) {
        Connection conn;
        String sql="", w_visit_date_start="", w_visit_date_end="", w_days="", w_visit_vn="", w_visit_hn="", w_discharge="", where="";
        Vector v_v_visit = new Vector();
        try {
            conn = config1.getConnectionHospital(brach_id);
            Statement stbangna = conn.createStatement();
            if(!discharge.equals("")){
                w_discharge = " and "+t_visit.getFVisitFinancialDischargeTime()+" = '' ";
            }
            if(!days.equals("")){
                if(flag.equals("doctor_appointment")){
                    
                }
                w_days = " and "+t_visit.getFVisitFinancialDischargeTime()+" = '' ";
            }
            if(flag.equals("admit")){
                sql="Select * "
                +"From "+v_visit.getVVisit()+" "
                +"Where f_visit_type_id = '1' and f_visit_status_id = '1' "+where;
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }else if(flag.equals("search_vn")){
                if(!visit_vn.equals("")){
                    where = " visit_vn in ("+visit_vn+") ";
                }
                sql="Select * "
                +"From "+v_visit.getVVisit()+" "
                +"Where "+where;
            }else{
                sql="Select * "
                    +"From "+v_visit.getVVisit()+" "
                    +"Where "+where;
                    //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                v_visit = new VVisit();
                v_visit.setBNcdGroupId(config1.StringNull(rs.getString(t_visit.getFBNcdGroupId())));
                v_visit.setBServicePointId(config1.StringNull(rs.getString(t_visit.getFBServicePointId())));
                v_visit.setBVisitClinicId(config1.StringNull(rs.getString(t_visit.getFBVisitClinicId())));
                v_visit.setBVisitOfficeIdReferIn(config1.StringNull(rs.getString(t_visit.getFBVisitOfficeIdReferIn())));
                v_visit.setBVisitOfficeIdReferOut(config1.StringNull(rs.getString(t_visit.getFBVisitOfficeIdReferOut())));

                v_visit.setBVisitWardId(config1.StringNull(rs.getString(t_visit.getFBVisitWardId())));
                v_visit.setFEmergencyStatusId(config1.StringNull(rs.getString(t_visit.getFFEmergencyStatusId())));
                v_visit.setFReferCauseId(config1.StringNull(rs.getString(t_visit.getFFReferCauseId())));
                v_visit.setFVisitIpdDischargeStatusId(config1.StringNull(rs.getString(t_visit.getFFVisitIpdDischargeStatusId())));
                v_visit.setFVisitIpdDischargeTypeId(config1.StringNull(rs.getString(t_visit.getFFVisitIpdDischargeTypeId())));

                v_visit.setFVisitOpdDischargeStatusId(config1.StringNull(rs.getString(t_visit.getFFVisitOpdDischargeStatusId())));
                v_visit.setFVisitStatusId(config1.StringNull(rs.getString(t_visit.getFFVisitStatusId())));
                v_visit.setFVisitTypeId(config1.StringNull(rs.getString(t_visit.getFFVisitTypeId())));
                v_visit.setTPatientAppointmentId(config1.StringNull(rs.getString(t_visit.getFTPatientAppointmentId())));
                v_visit.setTPatientId(config1.StringNull(rs.getString(t_visit.getFTPatientId())));

                v_visit.setTVisitId(config1.StringNull(rs.getString(t_visit.getFTVisitId())));
                v_visit.setVisitAn(config1.StringNull(rs.getString(t_visit.getFVisitAn())));
                v_visit.setVisitBed(config1.StringNull(rs.getString(t_visit.getFVisitBed())));
                v_visit.setVisitBeginAdmitDateTime(config1.StringNull(rs.getString(t_visit.getFVisitBeginAdmitDateTime())));
                v_visit.setVisitBeginVisitTime(config1.StringNull(rs.getString(t_visit.getFVisitBeginVisitTime())));

                v_visit.setVisitCalDateAppointment(config1.StringNull(rs.getString(t_visit.getFVisitCalDateAppointment())));
                v_visit.setVisitCauseAppointment(config1.StringNull(rs.getString(t_visit.getFVisitCauseAppointment())));
                v_visit.setVisitDenyAllergy(config1.StringNull(rs.getString(t_visit.getFVisitDenyAllergy())));
                v_visit.setVisitDiagnosisNotice(config1.StringNull(rs.getString(t_visit.getFVisitDiagnosisNotice())));
                v_visit.setVisitDoctorDischargeStatus(config1.StringNull(rs.getString(t_visit.getFVisitDoctorDischargeStatus())));

                v_visit.setVisitDx(config1.StringNull(rs.getString(t_visit.getFVisitDx())));
                v_visit.setVisitDxStat(config1.StringNull(rs.getString(t_visit.getFVisitDxStat())));
                v_visit.setVisitEmergencyStaff(config1.StringNull(rs.getString(t_visit.getFVisitEmergencyStaff())));
                v_visit.setVisitFinancialDischargeTime(config1.StringNull(rs.getString(t_visit.getFVisitFinancialDischargeTime())));
                v_visit.setVisitFirstVisit(config1.StringNull(rs.getString(t_visit.getFVisitFirstVisit())));

                v_visit.setVisitHaveAdmit(config1.StringNull(rs.getString(t_visit.getFVisitHaveAdmit())));
                v_visit.setVisitHaveAppointment(config1.StringNull(rs.getString(t_visit.getFVisitHaveAppointment())));
                v_visit.setVisitHaveRefer(config1.StringNull(rs.getString(t_visit.getFVisitHaveRefer())));
                v_visit.setVisitHn(config1.StringNull(rs.getString(t_visit.getFVisitHn())));
                v_visit.setVisitHospitalService(config1.StringNull(rs.getString(t_visit.getFVisitHospitalService())));

                v_visit.setVisitIpdDischargeStatus(config1.StringNull(rs.getString(t_visit.getFVisitIpdDischargeStatus())));
                v_visit.setVisitLabStatusId(config1.StringNull(rs.getString(t_visit.getFVisitLabStatusId())));
                v_visit.setVisitLockDateTime(config1.StringNull(rs.getString(t_visit.getFVisitLockDateTime())));
                v_visit.setVisitLocking(config1.StringNull(rs.getString(t_visit.getFVisitLocking())));
                v_visit.setVisitMoneyDischargeStatus(config1.StringNull(rs.getString(t_visit.getFVisitMoneyDischargeStatus())));

                v_visit.setVisitNcd(config1.StringNull(rs.getString(t_visit.getFVisitNcd())));
                v_visit.setVisitNotice(config1.StringNull(rs.getString(t_visit.getFVisitNotice())));
                v_visit.setVisitObserve(config1.StringNull(rs.getString(t_visit.getFVisitObserve())));
                v_visit.setVisitPatientAge(config1.StringNull(rs.getString(t_visit.getFVisitPatientAge())));
                v_visit.setVisitPatientSelfDoctor(config1.StringNull(rs.getString(t_visit.getFVisitPatientSelfDoctor())));

                v_visit.setVisitPatientType(config1.StringNull(rs.getString(t_visit.getFVisitPatientType())));
                v_visit.setVisitPregnant(config1.StringNull(rs.getString(t_visit.getFVisitPregnant())));
                v_visit.setVisitPcuService(config1.StringNull(rs.getString(t_visit.getFVisitPcuService())));
                v_visit.setVisitQueue(config1.StringNull(rs.getString(t_visit.getFVisitQueue())));
                v_visit.setVisitStaffDoctorDischarge(config1.StringNull(rs.getString(t_visit.getFVisitStaffDoctorDischarge())));

                v_visit.setVisitStaffDoctorDischargeDateTime(config1.StringNull(rs.getString(t_visit.getFVisitStaffDoctorDischargeDateTime())));
                v_visit.setVisitStaffFinancialDischarge(config1.StringNull(rs.getString(t_visit.getFVisitStaffFinancialDischarge())));
                v_visit.setVisitStaffLock(config1.StringNull(rs.getString(t_visit.getFVisitStaffLock())));
                v_visit.setVisitStaffObserve(config1.StringNull(rs.getString(t_visit.getFVisitStaffObserve())));
                v_visit.setVisitVn(config1.StringNull(rs.getString(t_visit.getFVisitVn())));

                v_visit.setContactId(config1.StringNull(rs.getString("contact_id")));
                v_visit.setContactNamet(config1.StringNull(rs.getString("contact_namet")));
                v_visit.setContractPlansDescription(config1.StringNull(rs.getString("contract_plans_description")));
                v_visit.setVisitClinicDescription(config1.StringNull(rs.getString("visit_clinic_description")));
                v_visit.setEmployeeFirstname(config1.StringNull(rs.getString("employee_firstname")));

                v_visit.setEmployeeLastname(config1.StringNull(rs.getString("employee_lastname")));
                v_visit.setPatientFirstname(config1.StringNull(rs.getString("patient_firstname")));
                v_visit.setPatientLastname(config1.StringNull(rs.getString("patient_lastname")));
                v_visit.setPatientPrefixDescription(config1.StringNull(rs.getString("patient_prefix_description")));
                v_visit.setVisitBeginVisitDate(config1.StringNull(rs.getString("visit_begin_visit_date")));

                v_visit.setVisitFinancialDischargeDate(config1.StringNull(rs.getString("visit_financial_discharge_date")));
                v_visit.visitWardName = config1.StringNull(rs.getString("visit_ward_description"));
//                v_visit.setContactId(config1.StringNull(rs.getString("contact_id")));

                v_v_visit.add(v_visit);

                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(TVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_v_visit;
    }
    public String getTrVisit(String branch_id, String visit_hn, String flag){
        Vector v_visit = new Vector();
        String txt="", t_header="", ipd="";
        v_visit = getTVisit(branch_id,"", visit_hn, flag);
        for(int i=0;i<=v_visit.size()-1;i++){
            try {
                t_visit = new TVisit();
                t_visit = (TVisit)v_visit.get(i);
                if(t_visit.getFFVisitTypeId().equals("0")){
                    ipd="OPD";
                }else{
                    ipd=t_visit.getVisitBed();
                }
                txt+="<tr><td>"+(i+1)+"</td>"
                        +"<td>"+t_visit.getVisitVn()+"</td>"
                        +"<td width='20'>"+config1.DateFormatDB2ShowHospital(t_visit.getVisitBeginVisitTime(),"ddMMyy")+"</td>"
                        +"<td>"+config1.getPaidShortName(t_visit.getContractPlansDescription())+"</td>"
                        +"<td>"+t_visit.getServicePointDescription()+"</td>"
                        +"<td>"+t_visit.getVisitNotice()+"</td>"
                        +"<td>"+t_visit.getVisitDiagnosisNotice()+"</td>"
                        +"<td>"+ipd+"</td></tr>";
            } catch (Exception ex) {
                Logger.getLogger(TVisitDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        t_header = "<table class='tablecolors'><tr bgcolor='#87876a'>"
                + "<td>ลำดับ</td>"
                + "<td>VN</td>"
                + "<td width='20'>วันที่เข้า</td>"
                + "<td>ประเภท</td>"
                + "<td>แผนก</td>"
                + "<td>อาการ</td>"
                + "<td>Dx</td>"
                + "<td>OPD/IPD</td>"
                + "</tr>";

        return t_header+txt+"</table>";
    }
    public void setUpdateVisitPlan(String branch_id, String plan_id, String t_visit_id){
        Connection conn;
        String sql="Update t_visit Set b_contract_plans_id = '"+plan_id+"' Where t_visit_id = '"+t_visit_id+"'";
        System.err.println("sql : "+sql);
        try {
            conn = config1.getConnectionHospital(branch_id);
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            sql = "Update t_visit_queue_transfer Set b_contract_plans_id = '"+plan_id+"' Where t_visit_id = '"+t_visit_id+"'";
            System.err.println("sql : "+sql);
            st.executeUpdate(sql);//pop update ไปได้เลย ถ้าไม่มี ก็ไม่ได้ถูกแก้ไขสิทธิ
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(TVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
