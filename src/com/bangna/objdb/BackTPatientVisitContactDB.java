package com.bangna.objdb;

import bangnaLibrary.*;
import com.bangna.object.BackTPatientVisitFunds;
import com.bangna.object.BackTPatientVisitFundsItem;
import com.bangna.control.BangnaLogControl;
import com.bangna.object.BackTPatientVisitContactBilling;
import com.bangna.object.BackTPatientVisitContactItem;
import com.bangna.object.BackTPatientVisitContact;
import com.bangna.object.BackTPatientVisitContactBillingItem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BackTPatientVisitContactDB{
    Config1 config1 = new Config1();
//  public bpvdb.config1 bpvdb.config1 = new bpvdb.config1();
//  private BBranch branch = new BBranch();
    public BackTPatientVisitContact bpvC;
    public BackTPatientVisitContactItem bpvCi;
    private BackTPatientVisitContactBilling bpv_cb;
    private BackTPatientVisitContactBillingItem bpv_cbi;
    public BContact contact;
    public BackTPatientVisitDB bpvdb;
    final private String idtableItem = "150";
    final private String idtable = "147";
    public BangnaLogControl blc;
//    private BackTPatientVisit bpv = new BackTPatientVisit();
    //private BackTPatientVisitItem bpvi = new BackTPatientVisitItem();

    public BackTPatientVisitContactDB(){
        config1 = new Config1();
        initConfig(config1);
    }
    public BackTPatientVisitContactDB(Config1 cf){
        config1 = cf;
        initConfig(config1);
    }
    public void initConfig(Config1 cf){
        bpvC = new BackTPatientVisitContact();
        bpvCi = new BackTPatientVisitContactItem();
        bpv_cb = new BackTPatientVisitContactBilling();
        bpv_cbi = new BackTPatientVisitContactBillingItem();
        contact = new BContact();
        
        bpvdb = new BackTPatientVisitDB(cf);
        blc = new BangnaLogControl(cf);
    }
    public String getMaxRowBackTPatientVisitContact(Connection conn) {
        String sql = ""; String max = "";
        try {
            Statement st = conn.createStatement();
            sql = "Select max(" + bpvC.getFPatientVisitContactId() + ") as cnt "
                  + "From " + bpvC.getBackTPatientVisitContact();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals(""))) max = String.valueOf(Integer.parseInt(max) + 1);
            else max = "1470000001";
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowBackTPatientVisitContactItem(Connection conn) {
        String sql = ""; String max = "";
        try {
            Statement st = conn.createStatement();
            sql = "Select max(" + bpvCi.getFPatientVisitContactItemId() + ") as cnt "
                  + "From " + bpvCi.getBackTPatientVisitContactItem();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))
                max = String.valueOf(Integer.parseInt(max) + 1);
            else
                max = "1500000001";
        }
        catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public BackTPatientVisitContact getBackTPatientVisitContactByPK(String branch_id, String where, String bpv_c_id, String flag) {
        Vector v_patient_visit_contact = new Vector();
        try {
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            bpvC = getBackTPatientVisitContactByPK(stbangna, branch_id, bpv_c_id, flag);
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpvC;
    }
    public BackTPatientVisitContact getBackTPatientVisitContactByPK(Statement stbangna,String branch_id, String bpv_c_id, String flag) {
        String sql = "";
        try {
            bpvC = new BackTPatientVisitContact();
//            Connection conn = bpvdb.config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();
            if (flag.equals("patient_import_id")) {
                sql = "Select * From " + bpvC.getBackTPatientVisitContact() + " "
                    + "Where " + bpvC.getFPatientImportId() + "='" + bpv_c_id + "' and "
                    + bpvC.getFBranchId() + "='" + branch_id + "' and " + bpvC.getFPatientVisitContactActive() + "='1' ";
            }else if(flag.equals("visit_vn")){
                sql = "Select * From " + bpvC.getBackTPatientVisitContact() + " "
                    + "Where " + bpvC.getFVisitVn() + "='" + bpv_c_id + "' and "
                    + bpvC.getFBranchId() + "='" + branch_id + "' ";
            }else{
                sql = "Select * From " + bpvC.getBackTPatientVisitContact() + " "
                    + "Where " + bpvC.getFPatientVisitContactId() + "='" + bpv_c_id + "' and "
                    + bpvC.getFBranchId() + "='" + branch_id + "' ";
            }
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpvC.setBServicePointId(config1.StringNull(rs.getString(bpvC.getFBServicePointId())));
                bpvC.setBVisitClinicId(config1.StringNull(rs.getString(bpvC.getFBVisitClinicId())));
                bpvC.setVisitClaimId(config1.StringNull(rs.getString(bpvC.getFVisitClaimId())));
                bpvC.setVisitPaidId(config1.StringNull(rs.getString(bpvC.getFVisitPaidId())));
                bpvC.setPatientFullnamet(config1.StringNull(rs.getString(bpvC.getFPatientFullnamet())));

                bpvC.setPatientVisitId(config1.StringNull(rs.getString(bpvC.getFPatientVisitId())));
                bpvC.setTPatientId(config1.StringNull(rs.getString(bpvC.getFTPatientId())));
                bpvC.setVisitBeginVisitTime(config1.StringNull(rs.getString(bpvC.getFVisitBeginVisitTime())));
                bpvC.setVisitDate(config1.StringNull(rs.getString(bpvC.getFVisitDate())));
                bpvC.setVisitDiagnosisNotice(config1.StringNull(rs.getString(bpvC.getFVisitDiagnosisNotice())));

                bpvC.setVisitFinancialDischargeTime(config1.StringNull(rs.getString(bpvC.getFVisitFinancialDischargeTime())));
                bpvC.setVisitFirstVisit(config1.StringNull(rs.getString(bpvC.getFVisitFirstVisit())));
                bpvC.setVisitHn(config1.StringNull(rs.getString(bpvC.getFVisitHn())));
                bpvC.setVisitHospitalService(config1.StringNull(rs.getString(bpvC.getFVisitHospitalService())));
                bpvC.setVisitNotice(config1.StringNull(rs.getString(bpvC.getFVisitNotice())));

                bpvC.setVisitPatientAge(config1.StringNull(rs.getString(bpvC.getFVisitPatientAge())));
                bpvC.setVisitPatientSelfDoctor(config1.StringNull(rs.getString(bpvC.getFVisitPatientSelfDoctor())));
                bpvC.setVisitVn(config1.StringNull(rs.getString(bpvC.getFVisitVn())));
                bpvC.setVisitClaimNamet(config1.StringNull(rs.getString(bpvC.getFVisitClaimNamet())));
                bpvC.setVisitPaidNamet(config1.StringNull(rs.getString(bpvC.getFVisitPaidNamet())));

                bpvC.setDepartmentNamet(config1.StringNull(rs.getString(bpvC.getFDepartmentNamet())));
                bpvC.setDoctorNamet(config1.StringNull(rs.getString(bpvC.getFDoctorNamet())));
                bpvC.setPatientImportId(config1.StringNull(rs.getString(bpvC.getFPatientImportId())));
                bpvC.setBranchId(config1.StringNull(rs.getString(bpvC.getFBranchId())));
                bpvC.setSysStatus(config1.StringNull(rs.getString(bpvC.getFSysStatus())));

                bpvC.setVisitPaid(Double.parseDouble(rs.getString(bpvC.getFVisitPaid())));
                bpvC.setVisitTotal(Double.parseDouble(rs.getString(bpvC.getFVisitTotal())));
                bpvC.setVisitDiscount(Double.parseDouble(rs.getString(bpvC.getFVisitDiscount())));
                bpvC.setVisitContactId(config1.StringNull(rs.getString(bpvC.getFVisitContactId())));
                bpvC.setVisitContactNamet(config1.StringNull(rs.getString(bpvC.getFVisitContactNamet())));
                
                bpvC.setPatientVisitContactId(config1.StringNull(rs.getString(bpvC.getFPatientVisitContactId())));
                bpvC.setPatientVisitContactActive(config1.StringNull(rs.getString(bpvC.getFPatientVisitContactActive())));
                bpvC.setStatusBilling(config1.StringNull(rs.getString(bpvC.getFStatusBilling())));
                bpvC.setRecordStatus(config1.StringNull(rs.getString(bpvC.getFRecordStatus())));
                bpvC.setVisitContactJoinId(config1.StringNull(rs.getString(bpvC.getFVisitContactJoinId())));
                
                bpvC.setVisitContactJoinNamet(config1.StringNull(rs.getString(bpvC.getFVisitContactJoinNamet())));
                bpvC.setCloseDayDate(config1.StringNull(rs.getString(bpvC.getFCloseDayDate())));
                bpvC.setBillingInvoiceNumber(config1.StringNull(rs.getString(bpvC.getFBillingInvoiceNumber())));
                bpvC.setReceiveAmount(Double.parseDouble(rs.getString(bpvC.getFReceiveAmount())));
                bpvC.setBillingPaymentItemid(config1.StringNull(rs.getString(bpvC.getFBillingPaymentItemId())));
                
                bpvC.setPatientVisitContactBillingId(config1.StringNull(rs.getString(bpvC.getFPatientVisitContactBillingId())));
                bpvC.injuryNumber = config1.StringNull(rs.getString(bpvC.getFInjuryNumber()));
                bpvC.insuranceNumber = config1.StringNull(rs.getString(bpvC.getFInsuranceNumber()));
                bpvC.discountPayment = Double.parseDouble(rs.getString(bpvC.getFDiscountPayment()));
                bpvC.discountTax = Double.parseDouble(rs.getString(bpvC.getFDiscountTax()));
                
                bpvC.receiveOver = Double.parseDouble(rs.getString(bpvC.getFReceiveOver()));
                bpvC.statusUnbilling=config1.StringNull(rs.getString(bpvC.getFStatusUnbilling()));

            }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpvC;
    }
    public Vector getBackTPatientVisitContact(String branch_id, String visit_hn, String date_end, String where, String bpv_c_id, String flag) {
        Vector v_bpv_c = new Vector();
        try {
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            v_bpv_c = getBackTPatientVisitContact(stbangna,branch_id, visit_hn, date_end, where, bpv_c_id, flag);
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_bpv_c;
    }
    public Vector getBackTPatientVisitContact(Statement stbangna,String branch_id, String visit_hn, String date_end, String where,
            String bpv_c_id, String flag) {
        Vector v_patient_visit_contact = new Vector();
        String sql = "", date_search="",hn_search="", paid_search="", contact_search="", whereDeptNumber="", whereContactJoinNumber="";
        try {
            if (flag.equals("patient_import_id")) {
            sql = "Select * From " + bpvC.getBackTPatientVisitContact() + " "
                    + "Where " + bpvC.getFPatientImportId() + "='" + bpv_c_id + "' and "
                    + bpvC.getFBranchId() + "='" + branch_id + "' and " + bpvC.getFPatientVisitContactActive() + "='1'";
            }else if (flag.equals("prepare_debtor")) {
                if (!visit_hn.equals("")) {
                    hn_search = " and " + bpvC.getFVisitHn() + " like '%" + visit_hn + "'";
                }
                if (!date_end.equals("")){
                    date_search = " and " + bpvC.getFCloseDayDate() + " <= '" + bpvdb.config1.DateFormatShow2DB(date_end, "ddMMyyyy") + "' ";
                }
                if (!where.equals("")) {
                    paid_search = " and " + bpvC.getFVisitPaidId() + " like '" + where + "'%";
                }
                if (!bpv_c_id.equals("")) {
                    contact_search = " and ((" + bpvC.getFVisitContactJoinNamet() + " like '" + bpv_c_id + "%') Or ("
                        + bpvC.getFVisitContactJoinId() + " like '" + bpv_c_id + "%'))";
                }
                sql = "Select * From " + bpvC.getBackTPatientVisitContact() + " "
                    + "Where " + bpvC.getFBranchId()+"='" + branch_id + "' and "
                    + bpvC.getFStatusBilling()+" in ('0','1') and "
                    + bpvC.getFPatientVisitContactActive() + "='1' " + date_search + paid_search + contact_search+hn_search
                    +" Order By "+ bpvC.getFCloseDayDate();
            }else if(flag.equals("billing_number")){
                sql = "Select * From " + bpvC.getBackTPatientVisitContact() + " "
                    + "Where " + bpvC.getFBillingInvoiceNumber() + "='" + where + "' and "
                    + bpvC.getFBranchId() + branch_id + " and " + bpvC.getFPatientVisitContactActive() + "='1' "
                    + " and "+bpvC.getFStatusBilling() +"='2' ";
            }else if(flag.equals("billing_cover_number")){
                sql = "Select bpvC.* From " + bpvC.getBackTPatientVisitContact() + " bpvC "
                    + "Left Join "+bpv_cb.getBackTPatientVisitContactBilling()+" bvpCb on bpvC."+bpvC.getFPatientVisitContactId()+"=bpvCb."+bpv_cb.getFPatientVisitContactId()
                    + " Where bpvC." + bpv_cb.getFBillingCoverNumber() + "='" + where + "' and bpvC."
                    + bpvC.getFBranchId() + branch_id + " and bpvC." + bpvC.getFPatientVisitContactActive() + "='1' "
                    + " and bpvC."+bpvC.getFStatusBilling() +"='2' and bpvCb."+bpv_cb.getFPatientVisitContactBillingActive()+"='1' ";
            }else if(flag.equals("billing_number_hn")) {//ดึงข้อมูลที่ตั้งหนี้แล้ว
                sql = "Select * From "+bpvC.getBackTPatientVisitContact()+" "
                    +"Where "+bpvC.getFVisitHn()+" = '"+bpv_c_id+"' and "+bpvC.getFPatientVisitContactActive()+"='1' "
                    + " and "+bpvC.getFStatusBilling() +"='2' "
                    + "Order By "+bpvC.getFPatientVisitContactId() ;
            }else if(flag.equals("billing_number_status_billing_complete")) {// check status bill ว่า รับชำระหมดแล้วหรือไม่ เพื่อจะได้นำค่าไป update funds_billing
                sql = "Select * From "+bpvC.getBackTPatientVisitContact()+" "// คือ ต้องการ check ว่า มี bill ที่ยังรับชำระไม่หมดหรือไม่
                    +"Where "+bpvC.getFBillingInvoiceNumber()+" = '"+bpv_c_id+"' and "+bpvC.getFPatientVisitContactActive()+"='1' "
                    +" and "+bpvC.getFStatusBilling()+"<>'4' "
                    + "Order By "+bpvC.getFPatientVisitContactId() ;
            }else if(flag.equals("searchPaymentIdVoid")) {//ดึงข้อมูลที่รับชำระแล้ว
                sql = "Select * From "+bpvC.getBackTPatientVisitContact()+" "
                    +"Where "+bpvC.getFPatientVisitContactBillingId()+" = '"+bpv_c_id+"' and "+bpvC.getFPatientVisitContactActive()+"='1' "
//                    + " and "+bpv_f.getFStatusBilling() +"='4' "
                    + "Order By "+bpvC.getFPatientVisitContactId() ;
            }else if(flag.equals("autoSearchHnNoPayment")) {//
                if(!bpv_c_id.equals("")){
                    whereDeptNumber = " and "+bpvC.getFContractPayerNumber()+"='"+bpv_c_id+"' ";
                }
                if(!where.equals("")){
                    if(where.indexOf("@")>0) whereContactJoinNumber = where.substring(0, where.indexOf("@"));
                    whereContactJoinNumber = " and "+bpvC.getFVisitContactJoinId()+" like '"+whereContactJoinNumber+"%' ";
                }
                sql = "Select Distinct "+bpvC.getFVisitHn()+","+bpvC.getFPatientFullnamet()+" From "+bpvC.getBackTPatientVisitContact()+" "
                    +"Where "+bpvC.getFVisitHn()+" like '"+visit_hn+"%' and "+bpvC.getFPatientVisitContactActive()+"='1' "
                    + " and "+bpvC.getFStatusBilling() +"<>'4' "+whereDeptNumber+whereContactJoinNumber
                    + "Order By "+bpvC.getFVisitHn() +" limit 20" ;
            }else if (flag.equals("contact_select")) {
                if(!bpv_c_id.equals("")){
                    whereDeptNumber = " and "+bpvC.getFContractPayerNumber()+"='"+bpv_c_id+"' ";
                }
                sql = "Select Distinct "+bpvC.getFVisitContactJoinId()+","+bpvC.getFVisitContactJoinNamet()
                    +" From "+bpvC.getBackTPatientVisitContact()+" "
                    +"Where "+bpvC.getFPatientVisitContactActive()+"='1' and "+bpvC.getFStatusBilling() +"<>'4' "+whereDeptNumber
                    + "Order By "+bpvC.getFVisitContactJoinNamet();
            }else if (flag.equals("hn_select")) {
                if(!bpv_c_id.equals("")){
                    whereDeptNumber = " and "+bpvC.getFContractPayerNumber()+"='"+bpv_c_id+"' ";
                }
                sql = "Select Distinct "+bpvC.getFVisitHn()+","+bpvC.getFPatientFullnamet()
                    +" From "+bpvC.getBackTPatientVisitContact()+" "
                    +"Where "+bpvC.getFPatientVisitContactActive()+"='1' and "+bpvC.getFStatusBilling() +"<>'4' "+whereDeptNumber
                    + "Order By "+bpvC.getFPatientFullnamet();
            }else if(flag.equals("visitHnNoBilling")) {
                sql="Select * From "+bpvC.getBackTPatientVisitContact()+" "
                    +"Where "+bpvC.getFPatientVisitContactActive()+"='1' and "+bpvC.getFVisitHn()+" = '"+where+"'  "
                    + "Order By "+bpvC.getFVisitHn() +" ";
            }else if(flag.equals("auto_search_injury")) {
                if (!visit_hn.equals("")) {
                    hn_search = " and " + bpvC.getFInjuryNumber() + " like '%" + visit_hn + "'";
                }
                sql = "Select Distinct "+bpvC.getFInjuryNumber()+" From "+bpvC.getBackTPatientVisitContact()+" "
                    +"Where "+bpvC.getFPatientVisitContactActive()+"='1' "
                    + " and "+bpvC.getFStatusBilling() +"='4' "+hn_search
                    + "Order By "+bpvC.getFInjuryNumber() +" limit 20" ;
            }else{
                sql = "Select * From " + bpvC.getBackTPatientVisitContact() + " "
                    + "Where " + bpvC.getFPatientVisitContactId() + "='" + bpv_c_id + "' and "
                    + bpvC.getFBranchId() + branch_id + " and " + bpvC.getFPatientVisitContactActive() + "='1' ";
            }
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpvC = new BackTPatientVisitContact();
                if(flag.equals("autoSearchHnNoPayment")) {
                    bpvC.setVisitHn(config1.StringNull(rs.getString(bpvC.getFVisitHn())));
                    bpvC.setPatientFullnamet(config1.StringNull(rs.getString(bpvC.getFPatientFullnamet())));
                }else if(flag.equals("contact_select")) {
                    bpvC.visitContactJoinId = config1.StringNull(rs.getString(bpvC.getFVisitContactJoinId()));
                    bpvC.visitContactJoinNamet = config1.StringNull(rs.getString(bpvC.getFVisitContactJoinNamet()));
                }else if(flag.equals("auto_search_injury")) {
                    bpvC.injuryNumber = config1.StringNull(rs.getString(bpvC.getFInjuryNumber()));
//                    bpvC.patientFullnamet = config1.StringNull(rs.getString(bpvC.getFPatientFullnamet()));
                }else if(flag.equals("hn_select")) {
                    
                }else{
                    bpvC.setBServicePointId(config1.StringNull(rs.getString(bpvC.getFBServicePointId())));
                    bpvC.setBVisitClinicId(config1.StringNull(rs.getString(bpvC.getFBVisitClinicId())));
                    bpvC.setVisitClaimId(config1.StringNull(rs.getString(bpvC.getFVisitClaimId())));
                    bpvC.setVisitPaidId(config1.StringNull(rs.getString(bpvC.getFVisitPaidId())));
                    bpvC.setPatientFullnamet(config1.StringNull(rs.getString(bpvC.getFPatientFullnamet())));

                    bpvC.setPatientVisitId(config1.StringNull(rs.getString(bpvC.getFPatientVisitId())));
                    bpvC.setTPatientId(config1.StringNull(rs.getString(bpvC.getFTPatientId())));
                    bpvC.setVisitBeginVisitTime(config1.StringNull(rs.getString(bpvC.getFVisitBeginVisitTime())));
                    bpvC.setVisitDate(config1.StringNull(rs.getString(bpvC.getFVisitDate())));
                    bpvC.setVisitDiagnosisNotice(config1.StringNull(rs.getString(bpvC.getFVisitDiagnosisNotice())));

                    bpvC.setVisitFinancialDischargeTime(config1.StringNull(rs.getString(bpvC.getFVisitFinancialDischargeTime())));
                    bpvC.setVisitFirstVisit(config1.StringNull(rs.getString(bpvC.getFVisitFirstVisit())));
                    bpvC.setVisitHn(config1.StringNull(rs.getString(bpvC.getFVisitHn())));
                    bpvC.setVisitHospitalService(config1.StringNull(rs.getString(bpvC.getFVisitHospitalService())));
                    bpvC.setVisitNotice(config1.StringNull(rs.getString(bpvC.getFVisitNotice())));

                    bpvC.setVisitPatientAge(config1.StringNull(rs.getString(bpvC.getFVisitPatientAge())));
                    bpvC.setVisitPatientSelfDoctor(config1.StringNull(rs.getString(bpvC.getFVisitPatientSelfDoctor())));
                    bpvC.setVisitVn(config1.StringNull(rs.getString(bpvC.getFVisitVn())));
                    bpvC.setVisitClaimNamet(config1.StringNull(rs.getString(bpvC.getFVisitClaimNamet())));
                    bpvC.setVisitPaidNamet(config1.StringNull(rs.getString(bpvC.getFVisitPaidNamet())));

                    bpvC.setDepartmentNamet(config1.StringNull(rs.getString(bpvC.getFDepartmentNamet())));
                    bpvC.setDoctorNamet(config1.StringNull(rs.getString(bpvC.getFDoctorNamet())));
                    bpvC.setPatientImportId(config1.StringNull(rs.getString(bpvC.getFPatientImportId())));
                    bpvC.setBranchId(config1.StringNull(rs.getString(bpvC.getFBranchId())));
                    bpvC.setSysStatus(config1.StringNull(rs.getString(bpvC.getFSysStatus())));

                    bpvC.setVisitPaid(Double.parseDouble(rs.getString(bpvC.getFVisitPaid())));
                    bpvC.setVisitTotal(Double.parseDouble(rs.getString(bpvC.getFVisitTotal())));
                    bpvC.setVisitDiscount(Double.parseDouble(rs.getString(bpvC.getFVisitDiscount())));
                    bpvC.setVisitContactId(config1.StringNull(rs.getString(bpvC.getFVisitContactId())));
                    bpvC.setVisitContactNamet(config1.StringNull(rs.getString(bpvC.getFVisitContactNamet())));

                    bpvC.setPatientVisitContactId(config1.StringNull(rs.getString(bpvC.getFPatientVisitContactId())));
                    bpvC.setPatientVisitContactActive(config1.StringNull(rs.getString(bpvC.getFPatientVisitContactActive())));
                    bpvC.setStatusBilling(config1.StringNull(rs.getString(bpvC.getFStatusBilling())));
                    bpvC.setRecordStatus(config1.StringNull(rs.getString(bpvC.getFRecordStatus())));
                    bpvC.setVisitContactJoinId(config1.StringNull(rs.getString(bpvC.getFVisitContactJoinId())));

                    bpvC.setVisitContactJoinNamet(config1.StringNull(rs.getString(bpvC.getFVisitContactJoinNamet())));
                    bpvC.setCloseDayDate(config1.StringNull(rs.getString(bpvC.getFCloseDayDate())));
                    bpvC.setBillingInvoiceNumber(config1.StringNull(rs.getString(bpvC.getFBillingInvoiceNumber())));
                    bpvC.setReceiveAmount(Double.parseDouble(rs.getString(bpvC.getFReceiveAmount())));
                    bpvC.setBillingPaymentItemid(config1.StringNull(rs.getString(bpvC.getFBillingPaymentItemId())));

                    bpvC.setPatientVisitContactBillingId(config1.StringNull(rs.getString(bpvC.getFPatientVisitContactBillingId())));
                    bpvC.injuryNumber = config1.StringNull(rs.getString(bpvC.getFInjuryNumber()));
                    bpvC.insuranceNumber = config1.StringNull(rs.getString(bpvC.getFInsuranceNumber()));
                    bpvC.discountPayment = Double.parseDouble(rs.getString(bpvC.getFDiscountPayment()));
                    bpvC.discountTax = Double.parseDouble(rs.getString(bpvC.getFDiscountTax()));
                    
                    bpvC.receiveOver = Double.parseDouble(rs.getString(bpvC.getFReceiveOver()));
                    bpvC.statusUnbilling=config1.StringNull(rs.getString(bpvC.getFStatusUnbilling()));
                }
                

                v_patient_visit_contact.add(bpvC);
            }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_patient_visit_contact;
    }
    public BackTPatientVisitContactItem getBackTPatientVisitContactItemByPK(String patient_visit_contact_billing_invoice_itemid) {
        String sql = "";
        try {
            bpvCi = new BackTPatientVisitContactItem();
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            sql = "Select * From " + bpvCi.getBackTPatientVisitContactItem() + " "
              + "Where " + bpvCi.getFPatientVisitContactItemId() + "='" + patient_visit_contact_billing_invoice_itemid + "'";
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpvCi.setBItemBillingSubgroupId(rs.getString(bpvCi.getFBItemBillingSubgroupId()));
                bpvCi.setBItemId(rs.getString(bpvCi.getFBItemId()));
                bpvCi.setBillingInvoiceItemActive(rs.getString(bpvCi.getFBillingInvoiceItemActive()));
                bpvCi.setBillingInvoiceItemTotal(Double.parseDouble(rs.getString(bpvCi.getFBillingInvoiceItemTotal())));
                bpvCi.setBillingInvoiceNumber(rs.getString(bpvCi.getFBillingInvoiceNumber()));

                bpvCi.setClaimId(rs.getString(bpvCi.getFClaimId()));
                bpvCi.setClaimNamet(rs.getString(bpvCi.getFClaimNamet()));
                bpvCi.setDepartmentNamet(rs.getString(bpvCi.getFDepartmentNamet()));
                bpvCi.setPatientVisitContactItemId(rs.getString(bpvCi.getFPatientVisitContactItemId()));
                bpvCi.setPatientVisitId(rs.getString(bpvCi.getFPatientVisitId()));

                bpvCi.setTBillingId(rs.getString(bpvCi.getFTBillingId()));
                bpvCi.setTBillingInvoiceDateTime(rs.getString(bpvCi.getFTBillingInvoiceDateTime()));
                bpvCi.setTBillingInvoiceItemId(rs.getString(bpvCi.getFTBillingInvoiceItemId()));
                bpvCi.setTBillingInvoiceItemNamet(rs.getString(bpvCi.getFTBillingInvoiceItemNamet()));
                bpvCi.setTBillingInvoiceTime(rs.getString(bpvCi.getFTBillingInvoiceTime()));

                bpvCi.setTOrderItemId(rs.getString(bpvCi.getFTOrderItemId()));
                bpvCi.setTPatientId(rs.getString(bpvCi.getFTPatientId()));
                bpvCi.setTPaymentId(rs.getString(bpvCi.getFTPaymentId()));
                bpvCi.setVisitId(rs.getString(bpvCi.getFVisitId()));
                bpvCi.setVisitPatientSelfDoctor(rs.getString(bpvCi.getFVisitPatientSeftDoctor()));

                bpvCi.setVisitVn(rs.getString(bpvCi.getFVisitVn()));
                bpvCi.setDepartmentId(rs.getString(bpvCi.getFDepartmentId()));
                bpvCi.setVisitHn(rs.getString(bpvCi.getFVisitHn()));
                bpvCi.setBranchId(config1.StringNull(rs.getString(bpvCi.getFBranchId())));
                bpvCi.setSysStatus(config1.StringNull(rs.getString(bpvCi.getFSysStatus())));

                bpvCi.setItemDiscount(Double.parseDouble(rs.getString(bpvCi.getFItemDiscount())));
                bpvCi.setItemPaid(Double.parseDouble(rs.getString(bpvCi.getFItemPaid())));
                bpvCi.setItemTotal(Double.parseDouble(rs.getString(bpvCi.getFItemTotal())));
                bpvCi.setItemNametEditStatus(config1.StringNull(rs.getString(bpvCi.getFItemNametEditStatus())));
                bpvCi.setRecordStatus(config1.StringNull(rs.getString(bpvCi.getFRecordStatus())));

                bpvCi.setPatientVisitItemId(config1.StringNull(rs.getString(bpvCi.getFPatientVisitItemId())));
                bpvCi.setPatientVisitContactId(config1.StringNull(rs.getString(bpvCi.getFPatientVisitContactId())));
                bpvCi.setItemTotalOrginal(Double.parseDouble(rs.getString(bpvCi.getFItemTotalOrginal())));
                bpvCi.setFItemGroupId(config1.StringNull(rs.getString(bpvCi.getFFItemGroupId())));
                bpvCi.setItemNametEdit(config1.StringNull(rs.getString(bpvCi.getFItemNametEdit())));

                bpvCi.setItemTotalEditStatus(config1.StringNull(rs.getString(bpvCi.getFItemTotalEditStatus())));
                bpvCi.setItemTotalEdit(Double.parseDouble(rs.getString(bpvCi.getFItemTotalEdit())));
                bpvCi.orderHome = config1.StringNull(rs.getString(bpvCi.getFOrderHome()));
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpvCi;
    }
    public Vector getBackTPatientVisitContactItem(String branch_id, String bpv_ci_id, String flag) {
        Vector v_bpv_c = new Vector();
        try {
            Connection conn = bpvdb.config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            v_bpv_c = getBackTPatientVisitContactItem(stbangna,branch_id, bpv_ci_id, flag);
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_bpv_c;
    }
    public Vector getBackTPatientVisitContactItem(Statement stbangna,String branch_id, String bpv_ci_id, String flag) {
        String sql = "";
        Vector v_back_patient_visit_contact_item = new Vector();
        try {
//          Connection conn = bpvdb.config1.getConnectionBangna();
//          Statement stbangna = conn.createStatement();
          if (flag.equals("billing")) {
            sql = "Select * From " + bpvCi.getBackTPatientVisitContactItem() + " "
                    + "Where " + bpvCi.getFPatientVisitContactId() + "='" + bpv_ci_id + "' and "
                    + bpvCi.getFBillingInvoiceItemActive() + "='1' " + "Order By " + bpvCi.getFPatientVisitContactItemId() + " asc";
          }else if (flag.equals("billing_item") || flag.equals("prepare_billing")) {
            sql = "Select " + bpvCi.getFBItemBillingSubgroupId() + ", "
                    + "min(" + bpvCi.getFBItemId() + ") as " + bpvCi.getFBItemId() + ", "
                    + "min(" + bpvCi.getFBillingInvoiceItemActive() + ") as " + bpvCi.getFBillingInvoiceItemActive() + ", "
                    + "min(" + bpvCi.getFBillingInvoiceItemTotal() + ") as " + bpvCi.getFBillingInvoiceItemTotal() + ", "
                    + "min(" + bpvCi.getFBillingInvoiceNumber() + ") as " + bpvCi.getFBillingInvoiceNumber() + ", "
                    + "min(" + bpvCi.getFBranchId() + ") as " + bpvCi.getFBranchId() + ", "
                    + "min(" + bpvCi.getFClaimId() + ") as " + bpvCi.getFClaimId() + ", "
                    + "min(" + bpvCi.getFClaimNamet() + ") as " + bpvCi.getFClaimNamet() + ", "
                    + "min(" + bpvCi.getFDepartmentId() + ") as " + bpvCi.getFDepartmentId() + ", "
                    + "min(" + bpvCi.getFDepartmentNamet() + ") as " + bpvCi.getFDepartmentNamet() + ", "
                    + "min(" + bpvCi.getFItemNametEditStatus() + ") as " + bpvCi.getFItemNametEditStatus() + ", "
                    + "sum(" + bpvCi.getFItemDiscount() + ") as " + bpvCi.getFItemDiscount() + ", "
                    + "sum(" + bpvCi.getFItemPaid() + ") as " + bpvCi.getFItemPaid() + ", "
                    + "sum(" + bpvCi.getFItemTotal() + ") as " + bpvCi.getFItemTotal() + ", "
                    + "sum(" + bpvCi.getFItemTotalOrginal() + ") as " + bpvCi.getFItemTotalOrginal() + ", "
                    + "min(" + bpvCi.getFPatientVisitContactId() + ") as " + bpvCi.getFPatientVisitContactId() + ", "
                    + "min(" + bpvCi.getFPatientVisitContactItemId() + ") as " + bpvCi.getFPatientVisitContactItemId() + ", "
                    + "min(" + bpvCi.getFPatientVisitId() + ") as " + bpvCi.getFPatientVisitId() + ", "
                    + "min(" + bpvCi.getFPatientVisitItemId() + ") as " + bpvCi.getFPatientVisitItemId() + ", "
                    + "min(" + bpvCi.getFRecordStatus() + ") as " + bpvCi.getFRecordStatus() + ", "
                    + "min(" + bpvCi.getFSysStatus() + ") as " + bpvCi.getFSysStatus() + ", "
                    + "min(" + bpvCi.getFTBillingId() + ") as " + bpvCi.getFTBillingId() + ", "
                    + "min(" + bpvCi.getFTBillingInvoiceDateTime() + ") as " + bpvCi.getFTBillingInvoiceDateTime() + ", "
                    + "min(" + bpvCi.getFTBillingInvoiceItemId() + ") as " + bpvCi.getFTBillingInvoiceItemId() + ", "
                    + "min(" + bpvCi.getFTBillingInvoiceItemNamet() + ") as " + bpvCi.getFTBillingInvoiceItemNamet() + ", "
                    + "min(" + bpvCi.getFTBillingInvoiceTime() + ") as " + bpvCi.getFTBillingInvoiceTime() + ", "
                    + "min(" + bpvCi.getFTOrderItemId() + ") as " + bpvCi.getFTOrderItemId() + ", "
                    + "min(" + bpvCi.getFTPatientId() + ") as " + bpvCi.getFTPatientId() + ", "
                    + "min(" + bpvCi.getFTPaymentId() + ") as " + bpvCi.getFTPaymentId() + ", "
                    + "min(" + bpvCi.getFVisitHn() + ") as " + bpvCi.getFVisitHn() + ", "
                    + "min(" + bpvCi.getFVisitId() + ") as " + bpvCi.getFVisitId() + ", "
                    + "min(" + bpvCi.getFVisitPatientSeftDoctor() + ") as " + bpvCi.getFVisitPatientSeftDoctor() + ", "
                    + "min(" + bpvCi.getFVisitVn() + ") as " + bpvCi.getFVisitVn() + ", "
                    + "min(" + bpvCi.getFFItemGroupId() + ") as " + bpvCi.getFFItemGroupId() + ", "
                    + "min("+bpvCi.getFOrderHome()+") as "+bpvCi.getFOrderHome()+" "
                    + "From " + bpvCi.getBackTPatientVisitContactItem() + " "
                    + "Where " + bpvCi.getFPatientVisitContactId() + "='" + bpv_ci_id + "' and "
                    + bpvCi.getFBillingInvoiceItemActive() + "='1' " + "Group By " + bpvCi.getFBItemBillingSubgroupId() + " "
                    + "Order By " + bpvCi.getFPatientVisitContactItemId() + " asc";
          }else{
            sql = "Select * From " + bpvCi.getBackTPatientVisitContactItem() + " "
                    + "Where " + bpvCi.getFPatientVisitContactId() + "='" + bpv_ci_id + "' and "
                    + bpvCi.getFBillingInvoiceItemActive() + "='1' " + "Order By " + bpvCi.getFPatientVisitContactItemId() + " asc";
          }
          ResultSet rs = stbangna.executeQuery(sql);
          while (rs.next()) {
            bpvCi = new BackTPatientVisitContactItem();
            bpvCi.setBItemBillingSubgroupId(config1.StringNull(rs.getString(bpvCi.getFBItemBillingSubgroupId())));
            bpvCi.setBItemId(config1.StringNull(rs.getString(bpvCi.getFBItemId())));
            bpvCi.setBillingInvoiceItemActive(config1.StringNull(rs.getString(bpvCi.getFBillingInvoiceItemActive())));
            bpvCi.setBillingInvoiceItemTotal(Double.parseDouble(rs.getString(bpvCi.getFBillingInvoiceItemTotal())));
            bpvCi.setBillingInvoiceNumber(config1.StringNull(rs.getString(bpvCi.getFBillingInvoiceNumber())));

            bpvCi.setClaimId(config1.StringNull(rs.getString(bpvCi.getFClaimId())));
            bpvCi.setClaimNamet(config1.StringNull(rs.getString(bpvCi.getFClaimNamet())));
            bpvCi.setDepartmentNamet(config1.StringNull(rs.getString(bpvCi.getFDepartmentNamet())));
            bpvCi.setPatientVisitContactItemId(config1.StringNull(rs.getString(bpvCi.getFPatientVisitContactItemId())));
            bpvCi.setPatientVisitId(config1.StringNull(rs.getString(bpvCi.getFPatientVisitId())));

            bpvCi.setTBillingId(rs.getString(config1.StringNull(bpvCi.getFTBillingId())));
            bpvCi.setTBillingInvoiceDateTime(config1.StringNull(rs.getString(bpvCi.getFTBillingInvoiceDateTime())));
            bpvCi.setTBillingInvoiceItemId(config1.StringNull(rs.getString(bpvCi.getFTBillingInvoiceItemId())));
            bpvCi.setTBillingInvoiceItemNamet(config1.StringNull(rs.getString(bpvCi.getFTBillingInvoiceItemNamet())));
            bpvCi.setTBillingInvoiceTime(config1.StringNull(rs.getString(bpvCi.getFTBillingInvoiceTime())));

            bpvCi.setTOrderItemId(config1.StringNull(rs.getString(bpvCi.getFTOrderItemId())));
            bpvCi.setTPatientId(config1.StringNull(rs.getString(bpvCi.getFTPatientId())));
            bpvCi.setTPaymentId(config1.StringNull(rs.getString(bpvCi.getFTPaymentId())));
            bpvCi.setVisitId(config1.StringNull(rs.getString(bpvCi.getFVisitId())));
            bpvCi.setVisitPatientSelfDoctor(config1.StringNull(rs.getString(bpvCi.getFVisitPatientSeftDoctor())));

            bpvCi.setVisitVn(rs.getString(bpvCi.getFVisitVn()));
            bpvCi.setDepartmentId(rs.getString(bpvCi.getFDepartmentId()));
            bpvCi.setVisitHn(rs.getString(bpvCi.getFVisitHn()));
            bpvCi.setBranchId(config1.StringNull(rs.getString(bpvCi.getFBranchId())));
            bpvCi.setSysStatus(config1.StringNull(rs.getString(bpvCi.getFSysStatus())));

            bpvCi.setItemDiscount(Double.parseDouble(rs.getString(bpvCi.getFItemDiscount())));
            bpvCi.setItemPaid(Double.parseDouble(rs.getString(bpvCi.getFItemPaid())));
            bpvCi.setItemTotal(Double.parseDouble(rs.getString(bpvCi.getFItemTotal())));
            bpvCi.setItemNametEditStatus(config1.StringNull(rs.getString(bpvCi.getFItemNametEditStatus())));
            bpvCi.setRecordStatus(config1.StringNull(rs.getString(bpvCi.getFRecordStatus())));

            bpvCi.setPatientVisitItemId(config1.StringNull(rs.getString(bpvCi.getFPatientVisitItemId())));
            bpvCi.setPatientVisitContactId(config1.StringNull(rs.getString(bpvCi.getFPatientVisitContactId())));
            bpvCi.setItemTotalOrginal(Double.parseDouble(rs.getString(bpvCi.getFItemTotalOrginal())));
            bpvCi.setFItemGroupId(config1.StringNull(rs.getString(bpvCi.getFFItemGroupId())));
            if (!flag.equals("billing_item") && !flag.equals("prepare_billing")) {
              bpvCi.setItemNametEdit(config1.StringNull(rs.getString(bpvCi.getFItemNametEdit())));

              bpvCi.setItemTotalEditStatus(config1.StringNull(rs.getString(bpvCi.getFItemTotalEditStatus())));
              bpvCi.setItemTotalEdit(Double.parseDouble(rs.getString(bpvCi.getFItemTotalEdit())));
              bpvCi.orderHome = config1.StringNull(rs.getString(bpvCi.getFOrderHome()));
            }
            v_back_patient_visit_contact_item.add(bpvCi);
          }
          rs.close();
//          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_back_patient_visit_contact_item;
    }
    public String setSaveBackTPatientVisitContact(BackTPatientVisitContact item) throws Exception {
        int chk = 0;
        String sql = ""; String max = "";
        try{
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          bpvC = getBackTPatientVisitContactByPK(st,item.getBranchId(), item.getPatientVisitContactId(), "");
          item.setPatientFullnamet(config1.StringNull(item.getPatientFullnamet()).replace("'", "''"));
          item.setVisitNotice(config1.StringNull(item.getVisitNotice()).replace("'", "''"));
          item.setVisitDiagnosisNotice(config1.StringNull(item.getVisitDiagnosisNotice()).replace("'", "''"));
          item.setVisitContactNamet(config1.StringNull(item.getVisitContactNamet()).replace("'", "''"));
          item.setVisitContactJoinNamet(config1.StringNull(item.getVisitContactJoinNamet()).replace("'", "''"));
          if (bpvC.getPatientVisitContactId().equals("")) {
//            max = getMaxRowBackTPatientVisitContact(conn);
            item.generateOID(idtable);
            max = item.getObjectId();
            sql = "Insert Into " + bpvC.getBackTPatientVisitContact()
                    + "(" + bpvC.getFPatientVisitContactId() + ", " + bpvC.getFBServicePointId() + ", "
                    + bpvC.getFBVisitClinicId() + "," + bpvC.getFVisitClaimId() + ","
                    + bpvC.getFVisitPaidId() + "," + bpvC.getFPatientFullnamet() + ","
                    + bpvC.getFPatientImportId() + "," + bpvC.getFTPatientId() + ","
                    + bpvC.getFVisitBeginVisitTime() + "," + bpvC.getFVisitDate() + ","
                    + bpvC.getFVisitDiagnosisNotice() + "," + bpvC.getFVisitFinancialDischargeTime() + ","
                    + bpvC.getFVisitFirstVisit() + "," + bpvC.getFVisitHn() + ","
                    + bpvC.getFVisitHospitalService() + "," + bpvC.getFVisitNotice() + ", "
                    + bpvC.getFVisitPatientAge() + "," + bpvC.getFVisitPatientSelfDoctor() + ", "
                    + bpvC.getFVisitVn() + "," + bpvC.getFVisitClaimNamet() + ","
                    + bpvC.getFVisitPaidNamet() + "," + bpvC.getFDepartmentNamet() + ","
                    + bpvC.getFDoctorNamet() + "," + bpvC.getFBranchId() + ","
                    + bpvC.getFSysStatus() + "," + bpvC.getFPatientVisitId() + ","
                    + bpvC.getFVisitContactId() + "," + bpvC.getFVisitContactNamet() + ","
                    + bpvC.getFPatientVisitContactActive() + "," + bpvC.getFStatusBilling() + ","
                    + bpvC.getFVisitTotal() + "," + bpvC.getFVisitDiscount() + ","
                    + bpvC.getFVisitPaid() + "," + bpvC.getFRecordStatus() + ","
                    + bpvC.getFContractPayerNumber() + "," + bpvC.getFCloseDayDate() + ","
                    + bpvC.getFVisitContactJoinId()+","+bpvC.getFVisitContactJoinNamet()+","
                    + bpvC.getFStatusUnbilling()+") "
//                    + "Values('" + max + "','" + item.getBServicePointId() + "','"
                    + "Values('" + item.getObjectId() + "','" + item.getBServicePointId() + "','"
                    + item.getBVisitClinicId() + "','" + item.getVisitClaimId() + "','"
                    + item.getVisitPaidId() + "','" + item.getPatientFullnamet() + "','"
                    + item.getPatientImportId() + "','" + item.getTPatientId() + "','"
                    + item.getVisitBeginVisitTime() + "','" + item.getVisitDate() + "','"
                    + item.getVisitDiagnosisNotice() + "','" + item.getVisitFinancialDischargeTime() + "','"
                    + item.getVisitFirstVisit() + "','" + item.getVisitHn() + "','"
                    + item.getVisitHospitalService() + "','" + item.getVisitNotice() + "','"
                    + item.getVisitPatientAge() + "','" + item.getVisitPatientSelfDoctor() + "','"
                    + item.getVisitVn() + "','" + item.getVisitClaimNamet() + "','"
                    + item.getVisitPaidNamet() + "','" + item.getDepartmentNamet() + "','"
                    + item.getDoctorNamet() + "','" + item.getBranchId() + "','"
                    + item.getSysStatus() + "','" + item.getPatientVisitId() + "','"
                    + item.getVisitContactId() + "','" + item.getVisitContactNamet() + "','"
                    + item.getPatientVisitContactActive() + "','" + item.getStatusBilling() + "',"
                    + item.getVisitTotal() + "," + item.getVisitDiscount() + ","
                    + item.getVisitPaid() + ",'" + item.getRecordStatus() + "','"
                    + item.getContractPayerNumber() + "','" + item.getCloseDayDate() + "','"
                    + item.getVisitContactJoinId()+"','"+item.getVisitContactJoinNamet()+ "','"
                    + item.statusUnbilling+"')";
          }else{
            sql = "Update " + bpvC.getBackTPatientVisitContact()
                    + " set " + bpvC.getFBServicePointId() + " = '" + item.getBServicePointId() + "', "
                    + bpvC.getFBVisitClinicId() + " = '" + item.getBVisitClinicId() + "', "
                    + bpvC.getFVisitClaimId() + " = '" + item.getVisitClaimId() + "', "
                    + bpvC.getFVisitPaidId() + " = '" + item.getVisitPaidId() + "', "
                    + bpvC.getFPatientFullnamet() + " = '" + item.getPatientFullnamet() + "', "
                    + bpvC.getFPatientImportId() + " = '" + item.getPatientImportId() + "', "
                    + bpvC.getFTPatientId() + " = '" + item.getTPatientId() + "', "
                    + bpvC.getFVisitBeginVisitTime() + " = '" + item.getVisitBeginVisitTime() + "', "
                    + bpvC.getFVisitDate() + " = '" + item.getVisitDate() + "', "
                    + bpvC.getFVisitDiagnosisNotice() + " = '" + item.getVisitDiagnosisNotice() + "',"
                    + bpvC.getFVisitFinancialDischargeTime() + " = '" + item.getVisitFinancialDischargeTime() + "',"
                    + bpvC.getFVisitFirstVisit() + " = '" + item.getVisitFirstVisit() + "', "
                    + bpvC.getFVisitHn() + " = '" + item.getVisitHn() + "', "
                    + bpvC.getFVisitHospitalService() + " = '" + item.getVisitHospitalService() + "', "
                    + bpvC.getFVisitNotice() + " = '" + item.getVisitNotice() + "', "
                    + bpvC.getFVisitPatientAge() + " = " + item.getVisitPatientAge() + ", "
                    + bpvC.getFVisitPatientSelfDoctor() + " = '" + item.getVisitPatientSelfDoctor() + "', "
                    + bpvC.getFVisitVn() + " = '" + item.getVisitVn() + "', "
                    + bpvC.getFVisitClaimNamet() + " = '" + item.getVisitClaimNamet() + "', "
                    + bpvC.getFVisitPaidNamet() + " = '" + item.getVisitPaidNamet() + "', "
                    + bpvC.getFDepartmentNamet() + " = '" + item.getDepartmentNamet() + "', "
                    + bpvC.getFDoctorNamet() + " = '" + item.getDoctorNamet() + "', "
                    + bpvC.getFBranchId() + " = '" + item.getBranchId() + "', "
                    + bpvC.getFSysStatus() + " = '" + item.getSysStatus() + "', "
                    + bpvC.getFPatientVisitId() + " = '" + item.getPatientVisitId() + "', "
                    + bpvC.getFVisitContactId() + " = '" + item.getVisitContactId() + "', "
                    + bpvC.getFVisitContactNamet() + " = '" + item.getVisitContactNamet() + "', "
                    + bpvC.getFPatientVisitContactActive() + " = '" + item.getPatientVisitContactActive() + "', "
                    + bpvC.getFStatusBilling() + " = '" + item.getStatusBilling() + "', "
                    + bpvC.getFVisitPaid() + " = " + item.getVisitPaid() + ", "
                    + bpvC.getFVisitDiscount() + " = " + item.getVisitDiscount() + ", "
                    + bpvC.getFVisitTotal() + " = " + item.getVisitTotal() + ", "
                    + bpvC.getFRecordStatus() + " = '" + item.getRecordStatus() + "', "
                    + bpvC.getFContractPayerNumber() + " = '" + item.getContractPayerNumber() + "', "
                    + bpvC.getFCloseDayDate() + " = '" + item.getCloseDayDate() + "' "
                    + "Where " + bpvC.getFPatientVisitContactId() + " = '" + item.getPatientVisitContactId() + "'";
            max = item.getPatientVisitId();
          }
          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
          max = ex.getMessage();
          blc.saveLog("bangnacontact.BackTPatientVisitContactDB", "", "", "setSaveBackTPatientVisitContact ex="+ex.getMessage(), config1.getDateDBHospital("yyyyMMdd hh:mm:ss"), 
                    "", "", "sql="+sql);
        }
        return max;
    }
  public String setSaveBackTPatientVisitContactItem(BackTPatientVisitContactItem item) throws Exception {
    int chk = 0;
    String sql = ""; String max = "";
    try {
      Connection conn = config1.getConnectionBangna();
      Statement st = conn.createStatement();
      bpvCi = getBackTPatientVisitContactItemByPK(item.getPatientVisitContactItemId());
      item.setClaimNamet(item.getClaimNamet().replace("'", "''"));
      item.setDepartmentNamet(item.getDepartmentNamet().replace("'", "''"));
      item.setTBillingInvoiceItemNamet(item.getTBillingInvoiceItemNamet().replace("'", "''"));
      if (bpvCi.getPatientVisitContactItemId().equals("")) {
//        max = getMaxRowBackTPatientVisitContactItem(conn);
        item.generateOID(idtableItem);
        max = item.getObjectId();
        sql = "Insert Into " + bpvCi.getBackTPatientVisitContactItem() 
                + "(" + bpvCi.getFPatientVisitContactItemId() + ", " + bpvCi.getFBItemBillingSubgroupId() + ", "
                + bpvCi.getFBItemId() + "," + bpvCi.getFBillingInvoiceItemActive() + ","
                + bpvCi.getFBillingInvoiceItemTotal() + "," + bpvCi.getFBillingInvoiceNumber() + ","
                + bpvCi.getFClaimId() + "," + bpvCi.getFClaimNamet() + ","
                + bpvCi.getFDepartmentId() + "," + bpvCi.getFDepartmentNamet() + ","
                + bpvCi.getFPatientVisitId() + "," + bpvCi.getFTBillingId() + ","
                + bpvCi.getFPatientVisitItemId() + "," + bpvCi.getFTBillingInvoiceDateTime() + ","
                + bpvCi.getFTBillingInvoiceItemId() + "," + bpvCi.getFTBillingInvoiceItemNamet() + ", "
                + bpvCi.getFTBillingInvoiceTime() + "," + bpvCi.getFTOrderItemId() + ", "
                + bpvCi.getFTPatientId() + "," + bpvCi.getFTPaymentId() + ","
                + bpvCi.getFVisitHn() + "," + bpvCi.getFVisitId() + ","
                + bpvCi.getFVisitPatientSeftDoctor() + "," + bpvCi.getFVisitVn() + ","
                + bpvCi.getFBranchId() + "," + bpvCi.getFSysStatus() + ","
                + bpvCi.getFItemDiscount() + "," + bpvCi.getFItemPaid() + ","
                + bpvCi.getFItemTotal() + "," + bpvCi.getFItemNametEditStatus() + ","
                + bpvCi.getFPatientVisitContactId() + "," + bpvCi.getFItemTotalOrginal() + ","
                + bpvCi.getFFItemGroupId() + "," + bpvCi.getFOrderHome() + ") "
//                + "Values('" + max + "','" + item.getBItemBillingSubgroupId() + "','"
                + "Values('" + item.getObjectId() + "','" + item.getBItemBillingSubgroupId() + "','"
                + item.getBItemId() + "','" + item.getBillingInvoiceItemActive() + "','"
                + item.getBillingInvoiceItemTotal() + "','" + item.getBillingInvoiceNumber() + "','"
                + item.getClaimId() + "','" + item.getClaimNamet() + "','"
                + item.getDepartmentId() + "','" + item.getDepartmentNamet() + "','"
                + item.getPatientVisitId() + "','" + item.getTBillingId() + "','"
                + item.getTBillingInvoiceItemId() + "','" + item.getTBillingInvoiceDateTime() + "','"
                + item.getTBillingInvoiceItemId() + "','" + item.getTBillingInvoiceItemNamet() + "','"
                + item.getTBillingInvoiceTime() + "','" + item.getTOrderItemId() + "','"
                + item.getTPatientId() + "','" + item.getVisitId() + "','"
                + item.getVisitHn() + "','" + item.getDepartmentNamet() + "','"
                + item.getVisitPatientSelfDoctor() + "','" + item.getVisitVn() + "','"
                + item.getBranchId() + "','" + item.getSysStatus() + "',"
                + item.getItemDiscount() + "," + item.getItemPaid() + ","
                + item.getItemTotal() + ",'" + item.getItemNametEditStatus() + "','"
                + item.getPatientVisitContactId() + "'," + item.getItemTotalOrginal() + ",'"
                + item.getFItemGroupId() + "','" + item.orderHome + "')";
      }else{
        sql = "Update " + bpvCi.getBackTPatientVisitContactItem()
                + " set " + bpvCi.getFBItemBillingSubgroupId() + " = '" + item.getBItemBillingSubgroupId() + "', "
                + bpvCi.getFBItemId() + " = '" + item.getBItemId() + "', "
                + bpvCi.getFBillingInvoiceItemActive() + " = '" + item.getBillingInvoiceItemActive() + "', "
                + bpvCi.getFBillingInvoiceItemTotal() + " = '" + item.getBillingInvoiceItemTotal() + "', "
                + bpvCi.getFBillingInvoiceNumber() + " = '" + item.getBillingInvoiceNumber() + "', "
                + bpvCi.getFClaimId() + " = '" + item.getClaimId() + "', "
                + bpvCi.getFClaimNamet() + " = '" + item.getClaimNamet() + "', "
                + bpvCi.getFDepartmentId() + " = '" + item.getDepartmentId() + "', "
                + bpvCi.getFDepartmentNamet() + " = '" + item.getDepartmentNamet() + "', "
                + bpvCi.getFPatientVisitId() + " = '" + item.getPatientVisitId() + "',"
                + bpvCi.getFTBillingId() + " = '" + item.getTBillingId() + "',"
                + bpvCi.getFTBillingInvoiceDateTime() + " = " + item.getTBillingInvoiceDateTime() + ", "
                + bpvCi.getFTBillingInvoiceItemId() + " = " + item.getTBillingInvoiceItemId() + ", "
                + bpvCi.getFTBillingInvoiceItemNamet() + " = " + item.getTBillingInvoiceItemNamet() + ", "
                + bpvCi.getFTBillingInvoiceTime() + " = " + item.getTBillingInvoiceTime() + ", "
                + bpvCi.getFTOrderItemId() + " = " + item.getTOrderItemId() + ", "
                + bpvCi.getFTPatientId() + " = " + item.getTPatientId() + ", "
                + bpvCi.getFVisitId() + " = " + item.getVisitId() + ", "
                + bpvCi.getFVisitHn() + " = " + item.getVisitHn() + ", "
                + bpvCi.getFDepartmentNamet() + " = " + item.getDepartmentNamet() + ", "
                + bpvCi.getFVisitPatientSeftDoctor() + " = " + item.getVisitPatientSelfDoctor() + ", "
                + bpvCi.getFVisitVn() + " = " + item.getVisitVn() + ", "
                + bpvCi.getFBranchId() + " = " + item.getBranchId() + ", "
                + bpvCi.getFSysStatus() + " = " + item.getSysStatus() + ", "
                + bpvCi.getFItemDiscount() + " = " + item.getItemDiscount() + ", "
                + bpvCi.getFItemPaid() + " = " + item.getItemPaid() + ", "
                + bpvCi.getFItemTotal() + " = " + item.getItemTotal() + ", "
                + bpvCi.getFItemNametEditStatus() + " = '" + item.getItemNametEditStatus() + "', "
                + bpvCi.getFPatientVisitContactId() + " = '" + item.getPatientVisitContactId() + "', "
                + bpvCi.getFFItemGroupId() + " = '" + item.getFItemGroupId() + "' "
                + "Where " + bpvCi.getFPatientVisitContactItemId() + " = '" + item.getPatientVisitContactItemId() + "'";
        max = item.getPatientVisitId();
      }
      chk = st.executeUpdate(sql);
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
      max = ex.getMessage();
      blc.saveLog("bangnacontact.BackTPatientVisitContactDB", "", "", "setSaveBackTPatientVisitContactItem ex="+ex.getMessage(), config1.getDateDBHospital("yyyyMMdd hh:mm:ss"), 
                    "", "", "sql="+sql);
    }
    return max;
  }
    public BackTPatientVisitContact setCastPatientVisitContact(BackTPatientVisitFunds bpv_f) {
        bpvC = new BackTPatientVisitContact();
        bpvC.setBServicePointId(bpv_f.getBServicePointId());
        bpvC.setBVisitClinicId(bpv_f.getBVisitClinicId());
        bpvC.setBranchId(bpv_f.getBranchId());
        bpvC.setDepartmentNamet(bpv_f.getDepartmentNamet());
        bpvC.setDoctorNamet(bpv_f.getDoctorNamet());
        bpvC.setPatientFullnamet(bpv_f.getPatientFullnamet());
        bpvC.setPatientImportId(bpv_f.getPatientImportId());
        bpvC.setPatientVisitId(bpv_f.getPatientVisitId());
        bpvC.setSysStatus(bpv_f.getSysStatus());
        bpvC.setTPatientId(bpv_f.getTPatientId());
        bpvC.setVisitBeginVisitTime(bpv_f.getVisitBeginVisitTime());
        bpvC.setVisitClaimId(bpv_f.getVisitClaimId());
        bpvC.setVisitClaimNamet(bpv_f.getVisitClaimNamet());
        bpvC.setVisitContactId(bpv_f.getVisitContactId());
        bpvC.setVisitDate(bpv_f.getVisitDate());
        bpvC.setVisitDiagnosisNotice(bpv_f.getVisitDiagnosisNotice());
        bpvC.setVisitDiscount(bpv_f.getVisitDiscount());
        bpvC.setVisitFinancialDischargeTime(bpv_f.getVisitFinancialDischargeTime());
        bpvC.setVisitFirstVisit(bpv_f.getVisitFirstVisit());
        bpvC.setVisitHn(bpv_f.getVisitHn());
        bpvC.setVisitHospitalService(bpv_f.getVisitHospitalService());
        bpvC.setVisitNotice(bpv_f.getVisitNotice());
        bpvC.setVisitPaid(bpv_f.getVisitPaid());
        bpvC.setVisitPaidId(bpv_f.getVisitPaidId());
        bpvC.setVisitPaidNamet(bpv_f.getVisitPaidNamet());
        bpvC.setVisitPatientAge(bpv_f.getVisitPatientAge());
        bpvC.setVisitPatientSelfDoctor(bpv_f.getVisitPatientSelfDoctor());
        bpvC.setVisitTotal(bpv_f.getVisitTotal());
        bpvC.setVisitVn(bpv_f.getVisitVn());
        bpvC.setVisitContactNamet(bpv_f.getVisitContactNamet());
        bpvC.setPatientVisitContactId(bpv_f.getPatientVisitFundsId());
        bpvC.setVisitContactJoinId(bpv_f.getVisitContactJoinId());
        bpvC.setVisitContactJoinNamet(bpv_f.getVisitContactJoinNamet());
        return bpvC;
    }
    public BackTPatientVisitContactItem setCastPatientVisitContactItem(BackTPatientVisitFundsItem bpv_fi){
        bpvCi = new BackTPatientVisitContactItem();
        bpvCi.setBItemBillingSubgroupId(bpv_fi.getBItemBillingSubgroupId());
        bpvCi.setBItemId(bpv_fi.getBItemId());
        bpvCi.setBillingInvoiceItemActive(bpv_fi.getBillingInvoiceItemActive());
        bpvCi.setBillingInvoiceItemTotal(bpv_fi.getBillingInvoiceItemTotal());
        bpvCi.setBillingInvoiceNumber(bpv_fi.getBillingInvoiceNumber());

        bpvCi.setClaimId(bpv_fi.getClaimId());
        bpvCi.setClaimNamet(bpv_fi.getClaimNamet());
        bpvCi.setDepartmentNamet(bpv_fi.getDepartmentNamet());
        bpvCi.setPatientVisitContactItemId(bpv_fi.getPatientVisitFundsItemId());
        bpvCi.setPatientVisitId(bpv_fi.getPatientVisitId());

        bpvCi.setTBillingId(bpv_fi.getTBillingId());
        bpvCi.setTBillingInvoiceDateTime(bpv_fi.getTBillingInvoiceDateTime());
        bpvCi.setTBillingInvoiceItemId(bpv_fi.getTBillingInvoiceItemId());
        bpvCi.setTBillingInvoiceItemNamet(bpv_fi.getTBillingInvoiceItemNamet());
        bpvCi.setTBillingInvoiceTime(bpv_fi.getTBillingInvoiceTime());

        bpvCi.setTOrderItemId(bpv_fi.getTOrderItemId());
        bpvCi.setTPatientId(bpv_fi.getTPatientId());
        bpvCi.setTPaymentId(bpv_fi.getTPaymentId());
        bpvCi.setVisitId(bpv_fi.getVisitId());
        bpvCi.setVisitPatientSelfDoctor(bpv_fi.getVisitPatientSelfDoctor());

        bpvCi.setVisitVn(bpv_fi.getVisitVn());
        bpvCi.setDepartmentId(bpv_fi.getDepartmentId());
        bpvCi.setVisitHn(bpv_fi.getVisitHn());
        bpvCi.setBranchId(config1.StringNull(bpv_fi.getBranchId()));
        bpvCi.setSysStatus(config1.StringNull(bpv_fi.getSysStatus()));

        bpvCi.setItemDiscount(bpv_fi.getItemDiscount());
        bpvCi.setItemPaid(bpv_fi.getItemPaid());
        bpvCi.setItemTotal(bpv_fi.getItemTotal());
        bpvCi.setItemNametEditStatus(config1.StringNull(bpv_fi.getItemNametEditStatus()));
        bpvCi.setItemTotalOrginal(bpv_fi.getItemTotal());

        bpvCi.setRecordStatus(bpv_fi.getRecordStatus());
        bpvCi.setPatientVisitItemId(config1.StringNull(bpv_fi.getPatientVisitItemId()));
        bpvCi.setPatientVisitContactId(config1.StringNull(bpv_fi.getPatientVisitFundsId()));
        bpvCi.setFItemGroupId(config1.StringNull(bpv_fi.getFItemGroupId()));
        bpvCi.setItemNametEdit(config1.StringNull(bpv_fi.getItemNametEditStatus()));

        bpvCi.setItemTotalEdit(bpv_fi.getItemTotalEdit());
        bpvCi.setItemTotalEditStatus(config1.StringNull(bpv_fi.getItemTotalEditStatus()));
        return bpvCi;
    }
//    public BackTPatientVisitContactItem setCastPatientVisitContactItem(BackTPatientVisitItem bpvi){
//        bpv_ci = new BackTPatientVisitContactItem();
//        bpv_ci.setBItemBillingSubgroupId(bpvi.getBItemBillingSubgroupId());
//        bpv_ci.setBItemId(bpvi.getBItemId());
//        bpv_ci.setBillingInvoiceItemActive(bpvi.getBillingInvoiceItemActive());
//        bpv_ci.setBillingInvoiceItemTotal(bpvi.getBillingInvoiceItemTotal());
//        bpv_ci.setBillingInvoiceNumber(bpvi.getBillingInvoiceNumber());
//
//        bpv_ci.setClaimId(bpvi.getClaimId());
//        bpv_ci.setClaimNamet(bpvi.getClaimNamet());
//        bpv_ci.setDepartmentNamet(bpvi.getDepartmentNamet());
//        bpv_ci.setPatientVisitContactItemId("");
//        bpv_ci.setPatientVisitId(bpvi.getPatientVisitId());
//
//        bpv_ci.setTBillingId(bpvi.getTBillingId());
//        bpv_ci.setTBillingInvoiceDateTime(bpvi.getTBillingInvoiceDateTime());
//        bpv_ci.setTBillingInvoiceItemId(bpvi.getTBillingInvoiceItemId());
//        bpv_ci.setTBillingInvoiceItemNamet(bpvi.getTBillingInvoiceItemNamet());
//        bpv_ci.setTBillingInvoiceTime(bpvi.getTBillingInvoiceTime());
//
//        bpv_ci.setTOrderItemId(bpvi.getTOrderItemId());
//        bpv_ci.setTPatientId(bpvi.getTPatientId());
//        bpv_ci.setTPaymentId(bpvi.getTPaymentId());
//        bpv_ci.setVisitId(bpvi.getVisitId());
//        bpv_ci.setVisitPatientSelfDoctor(bpvi.getVisitPatientSelfDoctor());
//
//        bpv_ci.setVisitVn(bpvi.getVisitVn());
//        bpv_ci.setDepartmentId(bpvi.getDepartmentId());
//        bpv_ci.setVisitHn(bpvi.getVisitHn());
//        bpv_ci.setBranchId(bpvdb.config1.StringNull(bpvi.getBranchId()));
//        bpv_ci.setSysStatus(bpvdb.config1.StringNull(bpvi.getSysStatus()));
//
//        bpv_ci.setItemDiscount(bpvi.getItemDiscount());
//        bpv_ci.setItemPaid(bpvi.getItemPaid());
//        bpv_ci.setItemTotal(bpvi.getItemTotal());
//        bpv_ci.setItemNametEditStatus(bpvdb.config1.StringNull(bpvi.getEditStatus()));
//        bpv_ci.setItemTotalOrginal(bpvi.getItemTotal());
//
//        bpv_ci.setRecordStatus("0");
//        bpv_ci.setPatientVisitItemId(bpvdb.config1.StringNull(bpvi.getPatientVisitBillingItemId()));
//        bpv_ci.setFItemGroupId(bpvdb.config1.StringNull(bpvi.getFItemGroupId()));
//        return bpv_ci;
//    }
    public BackTPatientVisitContactBillingItem setCastPatientVisitContactBillingItem(BackTPatientVisitContactItem bpv_ci) {
        bpv_cbi = new BackTPatientVisitContactBillingItem();
        bpv_cbi.setBItemBillingSubgroupId(bpv_ci.getBItemBillingSubgroupId());
        bpv_cbi.setBItemId(bpv_ci.getBItemId());
        bpv_cbi.setBillingInvoiceItemActive(bpv_ci.getBillingInvoiceItemActive());
        bpv_cbi.setBillingInvoiceItemTotal(bpv_ci.getBillingInvoiceItemTotal());
        bpv_cbi.setBillingInvoiceNumber(bpv_ci.getBillingInvoiceNumber());

        bpv_cbi.setClaimId(bpv_ci.getClaimId());
        bpv_cbi.setClaimNamet(bpv_ci.getClaimNamet());
        bpv_cbi.setDepartmentNamet(bpv_ci.getDepartmentNamet());
        bpv_cbi.setPatientVisitContactItemId("");
        bpv_cbi.setPatientVisitId(bpv_ci.getPatientVisitId());

        bpv_cbi.setTBillingId(bpv_ci.getTBillingId());
        bpv_cbi.setTBillingInvoiceDateTime(bpv_ci.getTBillingInvoiceDateTime());
        bpv_cbi.setTBillingInvoiceItemId(bpv_ci.getTBillingInvoiceItemId());
        bpv_cbi.setTBillingInvoiceItemNamet(bpv_ci.getTBillingInvoiceItemNamet());
        bpv_cbi.setTBillingInvoiceTime(bpv_ci.getTBillingInvoiceTime());

        bpv_cbi.setTOrderItemId(bpv_ci.getTOrderItemId());
        bpv_cbi.setTPatientId(bpv_ci.getTPatientId());
        bpv_cbi.setTPaymentId(bpv_ci.getTPaymentId());
        bpv_cbi.setVisitId(bpv_ci.getVisitId());
        bpv_cbi.setVisitPatientSelfDoctor(bpv_ci.getVisitPatientSelfDoctor());

        bpv_cbi.setVisitVn(bpv_ci.getVisitVn());
        bpv_cbi.setDepartmentId(bpv_ci.getDepartmentId());
        bpv_cbi.setVisitHn(bpv_ci.getVisitHn());
        bpv_cbi.setBranchId(config1.StringNull(bpv_ci.getBranchId()));
        bpv_cbi.setSysStatus(config1.StringNull(bpv_ci.getSysStatus()));

        bpv_cbi.setItemDiscount(bpv_ci.getItemDiscount());
        bpv_cbi.setItemPaid(bpv_ci.getItemPaid());
        bpv_cbi.setItemTotal(bpv_ci.getItemTotal());
        bpv_cbi.setEditStatus(config1.StringNull(bpv_ci.getItemNametEditStatus()));
        bpv_cbi.setRecordStatus("0");

        bpv_cbi.setPatientVisitContactItemId(config1.StringNull(bpv_ci.getPatientVisitContactItemId()));
        bpv_cbi.setFItemGroupId(config1.StringNull(bpv_ci.getFItemGroupId()));
        bpv_cbi.setPatientVisitContactBillingItemActive("1");
        return bpv_cbi;
    }
    public BackTPatientVisitContactBillingItem setCastPatientVisitContactBillingItem(BackTPatientVisitFundsItem bpv_fi) {
        bpv_cbi = new BackTPatientVisitContactBillingItem();
        bpv_cbi.setBItemBillingSubgroupId(bpv_fi.getBItemBillingSubgroupId());
        bpv_cbi.setBItemId(bpv_fi.getBItemId());
        bpv_cbi.setBillingInvoiceItemActive(bpv_fi.getBillingInvoiceItemActive());
        bpv_cbi.setBillingInvoiceItemTotal(bpv_fi.getBillingInvoiceItemTotal());
        bpv_cbi.setBillingInvoiceNumber(bpv_fi.getBillingInvoiceNumber());

        bpv_cbi.setClaimId(bpv_fi.getClaimId());
        bpv_cbi.setClaimNamet(bpv_fi.getClaimNamet());
        bpv_cbi.setDepartmentNamet(bpv_fi.getDepartmentNamet());
        bpv_cbi.setPatientVisitContactItemId("");
        bpv_cbi.setPatientVisitId(bpv_fi.getPatientVisitId());

        bpv_cbi.setTBillingId(bpv_fi.getTBillingId());
        bpv_cbi.setTBillingInvoiceDateTime(bpv_fi.getTBillingInvoiceDateTime());
        bpv_cbi.setTBillingInvoiceItemId(bpv_fi.getTBillingInvoiceItemId());
        bpv_cbi.setTBillingInvoiceItemNamet(bpv_fi.getTBillingInvoiceItemNamet());
        bpv_cbi.setTBillingInvoiceTime(bpv_fi.getTBillingInvoiceTime());

        bpv_cbi.setTOrderItemId(bpv_fi.getTOrderItemId());
        bpv_cbi.setTPatientId(bpv_fi.getTPatientId());
        bpv_cbi.setTPaymentId(bpv_fi.getTPaymentId());
        bpv_cbi.setVisitId(bpv_fi.getVisitId());
        bpv_cbi.setVisitPatientSelfDoctor(bpv_fi.getVisitPatientSelfDoctor());

        bpv_cbi.setVisitVn(bpv_fi.getVisitVn());
        bpv_cbi.setDepartmentId(bpv_fi.getDepartmentId());
        bpv_cbi.setVisitHn(bpv_fi.getVisitHn());
        bpv_cbi.setBranchId(config1.StringNull(bpv_fi.getBranchId()));
        bpv_cbi.setSysStatus(config1.StringNull(bpv_fi.getSysStatus()));

        bpv_cbi.setItemDiscount(bpv_fi.getItemDiscount());
        bpv_cbi.setItemPaid(bpv_fi.getItemPaid());
        bpv_cbi.setItemTotal(bpv_fi.getItemTotal());
        bpv_cbi.setEditStatus(config1.StringNull(bpv_fi.getItemNametEditStatus()));
        bpv_cbi.setRecordStatus("0");

        bpv_cbi.setPatientVisitContactItemId(config1.StringNull(bpv_fi.getPatientVisitFundsItemId()));
        bpv_cbi.setFItemGroupId(config1.StringNull(bpv_fi.getFItemGroupId()));
        bpv_cbi.setPatientVisitContactBillingItemActive("1");
        bpv_cbi.setPatientVisitItemId(bpv_fi.getPatientVisitItemId());
        bpv_cbi.setPatientVisitItemId(config1.StringNull(bpv_fi.getPatientVisitItemId()));
        return bpv_cbi;
    }
//    public BackTPatientVisitContact setCastPatientVisitContact(BackTPatientVisit bpv){
//        bpv_c = new BackTPatientVisitContact();
//        bpv_c.setBServicePointId(bpv.getBServicePointId());
//        bpv_c.setBVisitClinicId(bpv.getBVisitClinicId());
//        bpv_c.setBranchId(bpv.getBranchId());
//        bpv_c.setDepartmentNamet(bpv.getDepartmentNamet());
//        bpv_c.setDoctorNamet(bpv.getDoctorNamet());
//        bpv_c.setPatientFullnamet(bpv.getPatientFullnamet());
//        bpv_c.setPatientImportId(bpv.getPatientImportId());
//        bpv_c.setPatientVisitId(bpv.getPatientVisitId());
//        bpv_c.setSysStatus(bpv.getSysStatus());
//        bpv_c.setTPatientId(bpv.getTPatientId());
//        bpv_c.setVisitBeginVisitTime(bpv.getVisitBeginVisitTime());
//        bpv_c.setVisitClaimId(bpv.getVisitClaimId());
//        bpv_c.setVisitClaimNamet(bpv.getVisitClaimNamet());
//        bpv_c.setVisitContactId(bpv.getVisitContactId());
//        bpv_c.setVisitDate(bpv.getVisitDate());
//        bpv_c.setVisitDiagnosisNotice(bpv.getVisitDiagnosisNotice());
//        bpv_c.setVisitDiscount(bpv.getVisitDiscount());
//        bpv_c.setVisitFinancialDischargeTime(bpv.getVisitFinancialDischargeTime());
//        bpv_c.setVisitFirstVisit(bpv.getVisitFirstVisit());
//        bpv_c.setVisitHn(bpv.getVisitHn());
//        bpv_c.setVisitHospitalService(bpv.getVisitHospitalService());
//        bpv_c.setVisitNotice(bpv.getVisitNotice());
//        bpv_c.setVisitPaid(bpv.getVisitPaid());
//        bpv_c.setVisitPaidId(bpv.getVisitPaidId());
//        bpv_c.setVisitPaidNamet(bpv.getVisitPaidNamet());
//        bpv_c.setVisitPatientAge(bpv.getVisitPatientAge());
//        bpv_c.setVisitPatientSelfDoctor(bpv.getVisitPatientSelfDoctor());
//        bpv_c.setVisitTotal(bpv.getVisitTotal());
//        bpv_c.setVisitVn(bpv.getVisitVn());
//        bpv_c.setVisitContactNamet(bpv.getVisitContactNamet());
//        bpv_c.setPatientVisitContactId("");
//        bpv_c.setContractPayerNumber(bpv.getContractPayerNumber());
//        bpv_c.setCloseDayDate(bpv.getCloseDayDate());
//        bpv_c.setVisitContactJoinId(bpv.getVisitContactJoinId());
//        bpv_c.setVisitContactJoinNamet(bpv.getVisitContactJoinNamet());
//        return bpv_c;
//    }
    public BackTPatientVisitContactBilling setCastPatientVisitContactBilling(BackTPatientVisitContact bpv_c) {
        bpv_cb = new BackTPatientVisitContactBilling();
        bpv_cb.setBServicePointId(bpv_c.getBServicePointId());
        bpv_cb.setBVisitClinicId(bpv_c.getBVisitClinicId());
        bpv_cb.setBranchId(bpv_c.getBranchId());
        bpv_cb.setDepartmentNamet(bpv_c.getDepartmentNamet());
        bpv_cb.setDoctorNamet(bpv_c.getDoctorNamet());

        bpv_cb.setPatientFullnamet(bpv_c.getPatientFullnamet());
        bpv_cb.setPatientImportId(bpv_c.getPatientImportId());
        bpv_cb.setPatientVisitId(bpv_c.getPatientVisitId());
        bpv_cb.setSysStatus(bpv_c.getSysStatus());
        bpv_cb.setTPatientId(bpv_c.getTPatientId());

        bpv_cb.setVisitBeginVisitTime(bpv_c.getVisitBeginVisitTime());
        bpv_cb.setVisitClaimId(bpv_c.getVisitClaimId());
        bpv_cb.setVisitClaimNamet(bpv_c.getVisitClaimNamet());
        bpv_cb.setVisitContactId(bpv_c.getVisitContactId());
        bpv_cb.setVisitDate(bpv_c.getVisitDate());

        bpv_cb.setVisitDiagnosisNotice(bpv_c.getVisitDiagnosisNotice());
        bpv_cb.setVisitDiscount(bpv_c.getVisitDiscount());
        bpv_cb.setVisitFinancialDischargeTime(bpv_c.getVisitFinancialDischargeTime());
        bpv_cb.setVisitFirstVisit(bpv_c.getVisitFirstVisit());
        bpv_cb.setVisitHn(bpv_c.getVisitHn());

        bpv_cb.setVisitHospitalService(bpv_c.getVisitHospitalService());
        bpv_cb.setVisitNotice(bpv_c.getVisitNotice());
        bpv_cb.setVisitPaid(bpv_c.getVisitPaid());
        bpv_cb.setVisitPaidId(bpv_c.getVisitPaidId());
        bpv_cb.setVisitPaidNamet(bpv_c.getVisitPaidNamet());

        bpv_cb.setVisitPatientAge(bpv_c.getVisitPatientAge());
        bpv_cb.setVisitPatientSelfDoctor(bpv_c.getVisitPatientSelfDoctor());
        bpv_cb.setVisitTotal(bpv_c.getVisitTotal());
        bpv_cb.setVisitVn(bpv_c.getVisitVn());
        bpv_cb.setVisitContactNamet(bpv_c.getVisitContactNamet());

        bpv_cb.setPatientVisitContactId(bpv_c.getPatientVisitContactId());
        bpv_cb.setPatientVisitContactBillingId("");
        bpv_cb.setPatientVisitContactBillingActive("1");
        bpv_cb.setBillingCoverNumber("");
        bpv_cb.setBillingInvoiceNumber("");

        bpv_cb.setStatusPrint("0");
        bpv_cb.setStatusPayment("0");

        return bpv_cb;
    }
    public BackTPatientVisitContactBilling setCastPatientVisitContactBilling(BackTPatientVisitFunds bpv_f) {
        bpv_cb = new BackTPatientVisitContactBilling();
        bpv_cb.setBServicePointId(bpv_f.getBServicePointId());
        bpv_cb.setBVisitClinicId(bpv_f.getBVisitClinicId());
        bpv_cb.setBranchId(bpv_f.getBranchId());
        bpv_cb.setDepartmentNamet(bpv_f.getDepartmentNamet());
        bpv_cb.setDoctorNamet(bpv_f.getDoctorNamet());

        bpv_cb.setPatientFullnamet(bpv_f.getPatientFullnamet());
        bpv_cb.setPatientImportId(bpv_f.getPatientImportId());
        bpv_cb.setPatientVisitId(bpv_f.getPatientVisitId());
        bpv_cb.setSysStatus(bpv_f.getSysStatus());
        bpv_cb.setTPatientId(bpv_f.getTPatientId());

        bpv_cb.setVisitBeginVisitTime(bpv_f.getVisitBeginVisitTime());
        bpv_cb.setVisitClaimId(bpv_f.getVisitClaimId());
        bpv_cb.setVisitClaimNamet(bpv_f.getVisitClaimNamet());
        bpv_cb.setVisitContactId(bpv_f.getVisitContactId());
        bpv_cb.setVisitDate(bpv_f.getVisitDate());

        bpv_cb.setVisitDiagnosisNotice(bpv_f.getVisitDiagnosisNotice());
        bpv_cb.setVisitDiscount(bpv_f.getVisitDiscount());
        bpv_cb.setVisitFinancialDischargeTime(bpv_f.getVisitFinancialDischargeTime());
        bpv_cb.setVisitFirstVisit(bpv_f.getVisitFirstVisit());
        bpv_cb.setVisitHn(bpv_f.getVisitHn());

        bpv_cb.setVisitHospitalService(bpv_f.getVisitHospitalService());
        bpv_cb.setVisitNotice(bpv_f.getVisitNotice());
        bpv_cb.setVisitPaid(bpv_f.getVisitPaid());
        bpv_cb.setVisitPaidId(bpv_f.getVisitPaidId());
        bpv_cb.setVisitPaidNamet(bpv_f.getVisitPaidNamet());

        bpv_cb.setVisitPatientAge(bpv_f.getVisitPatientAge());
        bpv_cb.setVisitPatientSelfDoctor(bpv_f.getVisitPatientSelfDoctor());
        bpv_cb.setVisitTotal(bpv_f.getVisitTotal());
        bpv_cb.setVisitVn(bpv_f.getVisitVn());
        bpv_cb.setVisitContactNamet(bpv_f.getVisitContactNamet());

        bpv_cb.setPatientVisitContactId(bpv_f.getPatientVisitFundsId());
        bpv_cb.setPatientVisitContactBillingId("");
        bpv_cb.setPatientVisitContactBillingActive("1");
        bpv_cb.setBillingCoverNumber("");
        bpv_cb.setBillingInvoiceNumber("");

        bpv_cb.setStatusPrint("0");
        bpv_cb.setStatusPayment("0");

        return bpv_cb;
    }
    public void setSavePatientVisitContactStatusBilling(String branch_id, String sub_system,
          String patient_visit_contact_id, String billing_number) {
        String sql = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpvC.getBackTPatientVisitContact()
                + " Set " + bpvC.getFStatusBilling() + "='1' "
                + "Where " + bpvC.getFPatientVisitContactId() + "='" + patient_visit_contact_id + "'";
            st.executeUpdate(sql);
            conn.close();
        }
        catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public Integer setReceiveContact(String branch_id, String patient_import_id, String sub_system_id, String flag) {
//        String sql = "", patient_visit_contact_id = "";
//        Integer cnt = Integer.valueOf(0);
//        Vector v_patient_visit = new Vector();
//        Vector v_patient_visit_item = new Vector();
//        try {
//            v_patient_visit = bpvdb.getBackTPatientVisit(branch_id, patient_import_id, sub_system_id, flag);
//            for (int i = 0; i <= v_patient_visit.size() - 1; i++){
//                try {
//                    bpvdb.bpv = new BackTPatientVisit();
//                    bpvdb.bpv = (BackTPatientVisit)v_patient_visit.get(i);
//                    if (bpvdb.bpv.getVisitHn().equals("535003844"))
//                    sql = "";
//                    bpv_c = new BackTPatientVisitContact();
//                    bpv_c = setCastPatientVisitContact(bpvdb.bpv);
//                    bpv_c.setPatientVisitContactActive("1");
//                    bpv_c.setStatusBilling("0");
//                    patient_visit_contact_id = setSaveBackTPatientVisitContact(bpv_c);
//                    cnt++;
//                    v_patient_visit_item = new Vector();
//                    v_patient_visit_item = bpvdb.getBackTPatientVisitItem(bpvdb.bpv.getPatientVisitId(), "", "", "", "subsystem_import");
//                    for (int j = 0; j <= v_patient_visit_item.size() - 1; j++) {
//                      bpvdb.bpvi = new BackTPatientVisitItem();
//                      bpv_ci = new BackTPatientVisitContactItem();
//                      bpvdb.bpvi = (BackTPatientVisitItem)v_patient_visit_item.get(j);
//                      bpv_ci = setCastPatientVisitContactItem(bpvdb.bpvi);
//                      bpv_ci.setPatientVisitContactId(patient_visit_contact_id);
//                      setSaveBackTPatientVisitContactItem(bpv_ci);
//                    }
//                } catch (Exception ex) {
//                    Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }catch (Exception ex) {
//          Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return cnt;
//    }
    public void setUpdatePatientVisitContactItemEditClear(String branch_id, String patient_visit_contact_id) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvCi.getBackTPatientVisitContactItem()
                  + " Set " + bpvCi.getFItemNametEdit() + "='', " + bpvCi.getFItemNametEditStatus() + "='', "
                  + bpvCi.getFItemTotalEditStatus() + "='', " + bpvCi.getFItemTotalEdit() + "=0.0 "
                  + "Where " + bpvCi.getFPatientVisitContactId() + "='" + patient_visit_contact_id + "'";

          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitContactItemNametEdit(String branch_id, String patient_visit_contact_item_id, String item_namet) {
        String sql = "";
        try{
          item_namet = item_namet.replace("'", "''");
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvCi.getBackTPatientVisitContactItem() 
                  + " Set " + bpvCi.getFItemNametEdit() + "='" + item_namet + "', " + bpvCi.getFItemNametEditStatus() + "='1', "
                  + bpvCi.getFRecordStatus() + "='1' "
                  + "Where " + bpvCi.getFPatientVisitContactItemId() + "='" + patient_visit_contact_item_id + "'";

          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitContactItemTotalEdit(String branch_id, String patient_visit_contact_item_id, String item_price) {
        String sql = "";
        try{
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvCi.getBackTPatientVisitContactItem()
                  + " Set " + bpvCi.getFItemTotalEdit() + "='" + item_price + "', " + bpvCi.getFItemTotalEditStatus() + "='1', "
                  + bpvCi.getFRecordStatus() + "='1' "
                  + "Where " + bpvCi.getFPatientVisitContactItemId() + "='" + patient_visit_contact_item_id + "'";

          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String setUpdatePatientVisitContact(String branch_id, String patient_visit_contact_id, String patient_fullnamet,
            String visit_vn, String visit_hn, String visit_date, String claim_id, String paid_id, String visit_notive,
            String claim_name, String paid_name, String visit_contact_id, String visit_contact_namet, String visit_contact_join_id,
            String visit_contact_join_namet, String visitTotal, String injuryNumber, String insuranceNumber) {
        String sql = "";
        Integer chk=0;
        try{
          patient_fullnamet = patient_fullnamet.replace("'", "''");
          claim_name = claim_name.replace("'", "''");
          paid_name = paid_name.replace("'", "''");
          visit_contact_namet = visit_contact_namet.replace("'", "''");
          visit_contact_join_namet = visit_contact_join_namet.replace("'", "''");
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          if(visitTotal.equals("")) visitTotal = "0.0";
          sql = "Update " + bpvC.getBackTPatientVisitContact()
                + " Set " + bpvC.getFPatientFullnamet() + "='" + patient_fullnamet + "',"
                + bpvC.getFVisitHn() + "='" + visit_hn + "'," 
                + bpvC.getFVisitVn() + "='" + visit_vn + "',"
                + bpvC.getFVisitDate() + "='" + visit_date + "'," 
                + bpvC.getFVisitClaimId() + "='" + claim_id + "',"
                + bpvC.getFVisitPaidId() + "='" + paid_id + "', " 
                + bpvC.getFVisitNotice() + "='" + visit_notive + "', "
                + bpvC.getFVisitClaimNamet() + "='" + claim_name + "', " 
                + bpvC.getFVisitPaidNamet() + "='" + paid_name + "', "
                + bpvC.getFVisitContactId() + "='" + visit_contact_id + "', " 
                + bpvC.getFVisitContactNamet() + "='" + visit_contact_namet + "', "
                + bpvC.getFVisitContactJoinId() + "='" + visit_contact_join_id + "', " 
                + bpvC.getFVisitContactJoinNamet() + "='" + visit_contact_join_namet + "', "
                +bpvC.getFVisitTotal()+"="+visitTotal+", "
                +bpvC.getFInjuryNumber()+"='"+injuryNumber+"', "
                  +bpvC.getFInsuranceNumber()+"='"+insuranceNumber+"' "
            + "Where " + bpvC.getFPatientVisitContactId() + "='" + patient_visit_contact_id + "'";

          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setUpdatePatientVisitContactVoid(String branch_id, String patient_visit_contact_id) {
        String sql = "";
        Integer chk=0;
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvC.getBackTPatientVisitContact()
                  + " Set " + bpvC.getFPatientVisitContactActive() + "='3' "
                  + "Where " + bpvC.getFPatientVisitContactId() + "='" + patient_visit_contact_id + "'";

          chk = st.executeUpdate(sql);
          sql = "Update " + bpvCi.getBackTPatientVisitContactItem()
                  + " Set " + bpvCi.getFBillingInvoiceItemActive() + "='3' "
                  + "Where " + bpvCi.getFPatientVisitContactId() + "='" + patient_visit_contact_id + "'";

          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setUpdatePatientVisitContactItemEditCommit(String branch_id, String patient_visit_contact_id) {
        String sql = "";
        Integer chk=0;
    try {
        Connection conn = config1.getConnectionBangna();
        Statement st = conn.createStatement();
        sql = "Update " + bpvCi.getBackTPatientVisitContactItem() 
                + " Set " + bpvCi.getFTBillingInvoiceItemNamet() + "=" + bpvCi.getFItemNametEdit() + ", "
                + bpvCi.getFItemNametEditStatus() + "='2' "
                + "Where " + bpvCi.getFPatientVisitContactId() + "='" + patient_visit_contact_id + "' and "
                + bpvCi.getFItemNametEditStatus() + "='1'";

        chk = st.executeUpdate(sql);
        sql = "Update " + bpvCi.getBackTPatientVisitContactItem() 
                + " Set " + bpvCi.getFItemTotal() + "=" + bpvCi.getFItemTotalEdit() + ", "
                + bpvCi.getFItemTotalEditStatus() + "='2' "
                + "Where " + bpvCi.getFPatientVisitContactId() + "='" + patient_visit_contact_id + "' and "
                + bpvCi.getFItemTotalEditStatus() + "='1'";

        chk = st.executeUpdate(sql);
        conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String getComboContactJoin(String branch_id, String visit_hn, String date_end, String paid_id, String contact_id, String flag){
        String txt="", sql="", date_search="", paid_search="", contact_search="", hn_search="";
        Connection conn;
        Statement st;
            try {
                txt="<select id='cbo_contact_debtor' name='cbo_contact_debtor' onchange='setcontact();'><option value='' selected></option>";
                conn = config1.getConnectionBangna();
                st = conn.createStatement();
                if (!visit_hn.equals("")) {
                    hn_search = " and " + bpvC.getFVisitHn() + " like '%" + visit_hn + "'";
                }
                if (!date_end.equals("")) {
                    date_search = " and " + bpvC.getFCloseDayDate() + " <= '" + bpvdb.config1.DateFormatShow2DB(date_end, "ddMMyyyy") + "' ";
                }
                if (!paid_id.equals("")) {
                    paid_search = " and " + bpvC.getFVisitPaidId() + " like '" + paid_id + "'%";
                }
                if(!contact_id.equals("")){
                    contact_search = " and " + bpvC.getFVisitContactJoinNamet() + " like '" + contact_id + "%'";
                }
                sql="Select distinct "+bpvC.getFVisitContactJoinId()+","+bpvC.getFVisitContactJoinNamet()+" From "+bpvC.getBackTPatientVisitContact()
                +" Where " + bpvC.getFBranchId()+"='" + branch_id + "' and "
                    + bpvC.getFStatusBilling()+"='0' and "
                    + bpvC.getFPatientVisitContactActive() + "='1' " +hn_search+date_search+paid_search+contact_search+" "
                    + "Order By "+bpvC.getFVisitContactJoinNamet();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
//                    if(f_visit_type.getFVisitTypeId().equals(selected)){
                        txt += "<option value='"+rs.getString(bpvC.getFVisitContactJoinId())+"' >"+rs.getString(bpvC.getFVisitContactJoinNamet())+"</option>";
//                    }else{
//                        txt += "<option value='"+f_visit_type.getFVisitTypeId()+"' >"+f_visit_type.getVisitTypeDescription()+"</option>";
//                    }
                }
                rs.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return txt+"</select>";
    }
    public String getComboBillingContactJoin(String branch_id, String visit_hn, String date_end, String paid_id, String contact_id, String flag){
        String txt="", sql="", date_search="", paid_search="", contact_search="", hn_search="";
        Connection conn;
        Statement st;
            try {
//                txt="<select id='cbo_contact_cover' name='cbo_contact_cover' onchange='setcontactcover();'><option value='' selected></option>";
                conn = config1.getConnectionBangna();
                st = conn.createStatement();
                if (!visit_hn.equals("")) {
                    hn_search = " and " + bpv_cb.getFVisitHn() + " like '%" + visit_hn + "'";
                }
                if (!date_end.equals("")) {
                    date_search = " and " + bpv_cb.getFCloseDayDate() + " <= '" + config1.DateFormatShow2DB(date_end, "ddMMyyyy") + "' ";
                }
                if (!paid_id.equals("")) {
                    paid_search = " and " + bpv_cb.getFVisitPaidId() + " like '" + paid_id + "'%";
                }
                if(!contact_id.equals("")){
                    contact_search = " and " + bpv_cb.getFVisitContactJoinNamet() + " like '" + contact_id + "%'";
                }
                if(flag.equals("combo_contact_join_prepare_debtor")){//bpv_c
                    txt="<select id='divContactJoinPrepareDebtor' name='divContactJoinPrepareDebtor'><option value='' selected></option>";
                sql="Select distinct "+bpvC.getFVisitContactJoinId()+","+bpvC.getFVisitContactJoinNamet()+" "
                + "From "+bpvC.getBackTPatientVisitContact()
                +" Where " + bpvC.getFBranchId()+"='" + branch_id + "' and "
                    + bpvC.getFStatusBilling()+" in ('0','1') and "//ตั้งหนี้แล้ว และไม่ต้อง checkว่าพิมพ์ใบปะหน้าแล้วหรือยัง
                    + bpvC.getFPatientVisitContactActive() + "='1' " +hn_search+date_search+paid_search+contact_search+" "
                    + "Order By "+bpv_cb.getFVisitContactJoinNamet();
                }else{//bpv_cb
                    txt="<select id='divContactJoinCover' name='divContactJoinCover' ><option value='' selected></option>";
                sql="Select distinct "+bpv_cb.getFVisitContactJoinId()+","+bpv_cb.getFVisitContactJoinNamet()+" "
                + "From "+bpv_cb.getBackTPatientVisitContactBilling()
                +" Where " + bpv_cb.getFBranchId()+"='" + branch_id + "' and "
                    + bpv_cb.getFStatusPayment()+"='2' and "//ตั้งหนี้แล้ว และไม่ต้อง checkว่าพิมพ์ใบปะหน้าแล้วหรือยัง
                    + bpv_cb.getFPatientVisitContactBillingActive() + "='1' " +hn_search+date_search+paid_search+contact_search+" "
                    + "Order By "+bpvC.getFVisitContactJoinNamet();
                }
                
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
//                    if(f_visit_type.getFVisitTypeId().equals(selected)){
                        txt += "<option value='"+rs.getString(bpvC.getFVisitContactJoinId())+"' >"+rs.getString(bpvC.getFVisitContactJoinNamet())+"</option>";
//                    }else{
//                        txt += "<option value='"+f_visit_type.getFVisitTypeId()+"' >"+f_visit_type.getVisitTypeDescription()+"</option>";
//                    }
                }
                rs.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        return txt+"</select>";
    }
//    public String getTrBillingPrepareBilling(String branchId, String visitHn, String date_end, String paid_id, String contact_id,
//            String flag) {
//        String node_parent = "", text_h = "", chk_print = "", chk_src = "", script = "", bpv_f_id="", cnt="", total="";
////        BackTPatientVisitFunds bpv_f_max = new BackTPatientVisitFunds();
//        String visit_vn_min="", visit_vn_max="", visit_discharge_date="",hn_search="", date_search="", txt_hidden="";
//        StringBuilder txt = new StringBuilder();
//        Connection conn;
//        Vector v_billing = new Vector();
//        try {
//            conn = config1.getConnectionBangna();
//            Statement st = conn.createStatement();
//            if (!visitHn.equals("")) {
//                hn_search = " and " + bpvC.getFVisitHn() + " like '%" + visitHn + "'";
//            }
//            if (!date_end.equals("")) {
//                date_search = " and " + bpvC.getFCloseDayDate() + " <= '" + config1.DateFormatShow2DB(date_end, "ddMMyyyy") + "' ";
//            }
////            if(flag.equals("debtor")){
////                v_billing = getBackTPatientVisitContact(st,branch_id,visit_hn, date_end, paid_id, contact_id, "injury_number_billing_yes");
////            }else{
//                v_billing = getBackTPatientVisitContact(st,branchId,visitHn, date_end, paid_id, contact_id, flag);
////            }
//    //        for(int row=0;row<=v_billing.size()-1;row++){
//    //            bpv_f = new BackTPatientVisitFunds();
//    //            bpv_f = (BackTPatientVisitFunds)v_billing.get(row);
//    //            bpv_f_id = bpv_f.getPatientVisitFundsId();
//    //            bpv_f = getBackTPatientVisitFundsByPK(branch_id, bpv_f_id, "");
//    //        }
//            for (int i = 0; i <= v_billing.size() - 1; i++) {
//                try {
//                    node_parent = "chk_" + i;
//                    bpvC = new BackTPatientVisitContact();
////                    bpv_f_max = new BackTPatientVisitFunds();
//                    bpvC = (BackTPatientVisitContact)v_billing.get(i);
//                    visit_vn_min = bpvC.getVisitVn();
//                    visit_vn_max = bpvC.getPatientVisitContactId();
////                    bpv_f_max = getBackTPatientVisitFundsByPK(st,branch_id, visit_vn_max, "visit_vn");
////                    visit_discharge_date = bpv_f_max.getVisitFinancialDischargeTime();
//    //                bpv_f_id = bpv_f.getPatientVisitFundsId();
//                    cnt = bpvC.getVisitContactJoinNamet();//count billing
////                    total = bpvdb.config1.NumberFormat(bpv_f.getVisitTotal().toString());
//
////                    bpv_f = new BackTPatientVisitFunds();
//                    //bpv_c = getBackTPatientVisitContactByPK(st,branch_id, visit_vn_min, "visit_vn");
//                    total = config1.NumberFormat(getSumContactItem(st, bpvC.getPatientVisitContactId(),"prepare_billing"));//ยังไม่ตรง
//                    if (bpvC.getStatusBilling().equals("0")) {
////                      chk_print = "checked";
//                      chk_print = "";
//                      chk_src = "images/print_red.png";
//                    }else {
//                      chk_print = "";
//                      chk_src = "";
//                    }
//                    txt.append("<tr class='style14r'><td align='center'>").append((i + 1)).append("</td>")
//            .append("<td><label><input type='checkbox' name='").append(node_parent).append("' id ='").append(node_parent).append("' value='' ").append(chk_print).append(" onchange='chkbilling(").append(")' >").append(bpvC.getVisitHn()).append("</label></td>")
//            .append("<td>").append(bpvC.getPatientFullnamet()).append("</td>")
//            .append("<td align='center'>").append(config1.DateFormatDB2ShowHospital(bpvC.getVisitDate(), "ddMMyyyy")).append("</td>")
//            .append("<td align='right'>").append(total).append("</td>")
//            .append("<td>").append(cnt).append("</td>")
//            .append("<td><img id='img_").append(i ).append("' name = 'img_").append(i).append("' src='").append(chk_src)
//                            .append("' alt='' align='top' border='0' title='พิมพ์ billing' onclick='chkbilling(").append(i).append(")'/>")
//                            .append("<input type='hidden' id='txt_patient_visit_contact_id").append(i).append("' value='")
//                            .append(bpvC.getPatientVisitContactId()).append("'><input type='hidden' id='txt_total").append(i)
//                            .append("' value='").append(bpvC.getVisitTotal())
//                            .append("'><input type='hidden' id='txt_visit_vn_max").append(i).append("' value='").append(visit_vn_max).append("'></td></tr>");
//              }catch (Exception ex){
//                Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
//              }
//            }
//            text_h = "<thead> <tr align='center' class='style14r'>"
//                    + "<th width='5' align='center'>ลำดับ</th> "
//                    + "<th width='100' align='left'>HN</th> "
//                    + "<th width='220' align='left'>ชื่อ-นามสกุล</th> "
//                    + "<th width='85' align='left'>วันที่รักษา</th> "
//                    + "<th width='80' align='left'>มูลค่า</th> "
//                    + "<th align='left'>บริษัท</th> "
//                    + "<th width='40' align='left'>พิมพ์</th> </tr></thead>";
//            conn.close();
//        } catch (Exception ex) {
//            Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if(contact_id.indexOf("^")>0){
////            String aaa = contact_id.substring(0, contact_id.indexOf("^"));
////            String bbb = contact_id.substring(contact_id.indexOf("^")+1);
////            txt_hidden="<input type='text' id='txt_contact_join_check' value='"+aaa+"'>"
////                    + "<input type='text' id='txt_contact_join_hi' value='"+bbb+"'>";
//        }
//        return "<table width='100%'>" + text_h + txt + "<input type='hidden' id='txt_billing_cover_row' value='" + (v_billing.size() - 1) + "'></table>" + script+txt_hidden;
//    }
    public String getSumContactItem(Statement st, String bpv_c_id, String flag){
        String total = "", sql="";
        if(flag.equals("prepare_billing")){
            sql = "Select sum(bpv_fi."+bpvCi.getFItemTotal()+") as "+bpvCi.getFItemTotal()+" "
                + "From "+bpvCi.getBackTPatientVisitContactItem()+" as bpv_fi "
                + "inner join "+bpvC.getBackTPatientVisitContact()+" as bpv_f on bpv_f."+bpvC.getFPatientVisitContactId()+" = bpv_fi."+bpvCi.getFPatientVisitContactId()+" "
                + "Where bpv_f."+bpvCi.getFPatientVisitContactId()+" = '"+bpv_c_id+"' and "
                + "bpv_fi."+bpvCi.getFBillingInvoiceItemActive()+"='1' and "+bpvC.getFStatusBilling()+" = '0' and "
                + bpvC.getFPatientVisitContactActive()+" = '1' ";
        }else if(flag.equals("billing_number")){
            sql = "Select sum(bpv_fi."+bpvCi.getFItemTotal()+") as "+bpvCi.getFItemTotal()+" "
                + "From "+bpvCi.getBackTPatientVisitContactItem()+" as bpv_fi "
                + "inner join "+bpvC.getBackTPatientVisitContact()+" as bpv_f on bpv_f."+bpvC.getFPatientVisitContactId()+" = bpv_fi."+bpvCi.getFPatientVisitContactId()+" "
                + "Where bpv_f."+bpvC.getFBillingInvoiceNumber()+" = '"+bpv_c_id+"' and "
                + "bpv_fi."+bpvCi.getFBillingInvoiceItemActive()+"='1' and "+bpvC.getFStatusBilling()+" = '2' ";
        }else if(flag.equals("funds_id_billinged")){
            sql = "Select sum(bpv_fi."+bpvCi.getFItemTotal()+") as "+bpvCi.getFItemTotal()+" "
                + "From "+bpvCi.getBackTPatientVisitContactItem()+" as bpv_fi "
                + "inner join "+bpvC.getBackTPatientVisitContact()+" as bpv_f on bpv_f."+bpvC.getFPatientVisitContactId()+" = bpv_fi."+bpvCi.getFPatientVisitContactId()+" "
                + "Where bpv_f."+bpvCi.getFPatientVisitContactId()+" = '"+bpv_c_id+"' and "
                + "bpv_fi."+bpvCi.getFBillingInvoiceItemActive()+"='1' and "+bpvC.getFStatusBilling()+" = '2' ";
        }else if(flag.equals("contact_id")){
            sql = "Select sum(bpv_fi."+bpvCi.getFItemTotal()+") as "+bpvCi.getFItemTotal()+" "
                + "From "+bpvCi.getBackTPatientVisitContactItem()+" as bpv_fi "
                + "inner join "+bpvC.getBackTPatientVisitContact()+" as bpv_f on bpv_f."+bpvC.getFPatientVisitContactId()+" = bpv_fi."+bpvCi.getFPatientVisitContactId()+" "
                + "Where bpv_f."+bpvCi.getFPatientVisitContactId()+" = '"+bpv_c_id+"' and "
                + "bpv_fi."+bpvCi.getFBillingInvoiceItemActive()+"='1' and "+bpvC.getFStatusBilling()+" <> '2' ";
        }
        ResultSet rs;
        try {
            rs = st.executeQuery(sql);
            while(rs.next()){
                if(rs.getString(bpvCi.getFItemTotal()) != null){
                    total = rs.getString(bpvCi.getFItemTotal());
                }else{
                    total = "0";
                }

            }
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    public void setUpdatePatientVisitContactStatusPayment(String branch_id, String bpv_c_id,
            String billing_payment_id, String status_payment, Double receive_amount) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvC.getBackTPatientVisitContact()
                  + " Set " + bpvC.getFBillingPaymentItemId() + "='"+billing_payment_id+"',"
                  +bpvC.getFStatusBilling()+"='"+status_payment+"', "
                  +bpvC.getFReceiveAmount()+"="+receive_amount+" "
                  + "Where " + bpvC.getFPatientVisitContactId() + "='" + bpv_c_id + "'";

          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String setUpdatePatientVisitTotalN(String branch_id, String bpvCId, Double total) {
        String sql = "";
        Integer chk = 0;
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpvC.getBackTPatientVisitContact()
                + " Set " + bpvC.getFVisitTotal() + "="+ total + " "
                + "Where " + bpvC.getFPatientVisitContactId() + "='" + bpvCId + "' and "
                + bpvC.getFBranchId() + "='" + branch_id + "'";

          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public Integer setUpdatePatientVisitDiscount(String branch_id, String bpvCId, Double discount) {
        String sql = "";
        int chk = 0;
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpvC.getBackTPatientVisitContact() 
                + " Set " + bpvC.getFVisitDiscount() + "=" + discount + " "
                + "Where " + bpvC.getFPatientVisitContactId() + "='" + bpvCId + "' and " + bpvC.getFBranchId() + "='" + branch_id + "'";
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    public Integer setUpdatePatientVisitContactStatusPaymentDiscount(String branch_id, String bpvCId, Double discountTax, Double discountPayment, Double receiveOver) {
        String sql = "";
        int chk = 0;
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpvC.getBackTPatientVisitContact() 
                + " Set " + bpvC.getFDiscountPayment() + "=" + discountPayment + ", "
                    + bpvC.getFDiscountTax() + "=" + discountTax + ", "
                    + bpvC.getFReceiveOver() + "=" + receiveOver + " "
                + "Where " + bpvC.getFPatientVisitContactId() + "='" + bpvCId + "' and " + bpvC.getFBranchId() + "='" + branch_id + "'";
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    public String setUpdatePatientVisitContactStatusPayment(String branchId, String bpvCId,
            String billingPaymentId, String status_payment, Double receive_amount, String receive_date) {
        String sql = "", chk="";
        Integer row=0;
        //Step ในการ Update
        //1. update receive_amount
        //2. Check ว่ายอดเงิน >= visitTotal
        //3. ถ้า ยอดเงิน >= visitTotal จริง ให้ update status_payment ให้เป็น '4'
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvC.getBackTPatientVisitContact()//step 1
                  + " Set " + bpvC.getFBillingPaymentItemId() + "='"+billingPaymentId+"',"
//                  +bpv_f.getFStatusBilling()+"='"+status_payment+"', "
                  +bpvC.getFReceiveAmount()+"="+bpvC.getFReceiveAmount()+"+"+receive_amount+", "
                  +bpvC.getFReceiveDate()+"='"+receive_date+"' "
                  + "Where " + bpvC.getFPatientVisitContactId() + "='" + bpvCId + "'";
          row = st.executeUpdate(sql);
          bpvC = getBackTPatientVisitContactByPK(branchId,"", bpvCId, "");//step 2
          if(bpvC.visitTotal <= bpvC.receiveAmount){// step3  ต้อง check เพราะจะมี method void จะเข้าใข้ methoed นี้เหมือนกัน
              sql="Update "+bpvC.getBackTPatientVisitContact()+" Set "+bpvC.getFStatusBilling()+"='"+status_payment+"' "
                      + "Where "+bpvC.getFPatientVisitContactId()+"='"+bpvCId+"'";
              row = st.executeUpdate(sql);
              Vector v = new Vector();
              v = getBackTPatientVisitContact(branchId,"", bpvC.billingInvoiceNumber,status_payment,bpvC.patientVisitContactId, "billing_number_status_billing_complete");//ดึงตาม billing แล้ว check ว่ารับชำระหมดแล้วหรือไม่
              if(v.isEmpty()){
                  chk="4";
              }else{
                  chk="2";
              }
          }else{
              chk="2";
          }

          conn.close();
        }catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    public String setUpdatePatientVisitContactStatusPaymentVoid(String branch_id, String bpvCId,
            String billing_payment_id, Double VoidAmount, String VoidDate) {
        String sql = "", chked="";
        Integer chk=0;
        //Step ในการ Update
        //1. update receive_amount
        //2. Check ว่ายอดเงิน >= visitTotal
        //3. ถ้า ยอดเงิน >= visitTotal จริง ให้ update status_payment ให้เป็น '4'
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvC.getBackTPatientVisitContact()//step 1
                  + " Set " + bpvC.getFBillingPaymentItemId() + "='"+billing_payment_id+"',"
//                  +bpv_f.getFStatusBilling()+"='"+status_payment+"', "
                  +bpvC.getFReceiveAmount()+"="+bpvC.getFReceiveAmount()+"-"+VoidAmount+", "
//                  +bpvF.getFVoidDate()+"='"+VoidDate+"' "
                  +bpvC.getFVoidPaymentDate()+"='"+VoidDate+"' "
                  + "Where " + bpvC.getFPatientVisitContactId() + "='" + bpvCId + "'";
          chk = st.executeUpdate(sql);
          bpvC = getBackTPatientVisitContactByPK(branch_id,"", bpvCId, "");//step 2
//          if(bpvF.visitTotal <= bpvF.receiveAmount){// step3  ต้อง check เพราะจะมี method void จะเข้าใข้ methoed นี้เหมือนกัน
          if(bpvC.visitTotal >= bpvC.receiveAmount){// step3  ต้อง check เพราะจะมี method void จะเข้าใข้ methoed นี้เหมือนกัน
              sql="Update "+bpvC.getBackTPatientVisitContact()+" Set "+bpvC.getFStatusBilling()+"='2' "
                      + "Where "+bpvC.getFPatientVisitContactId()+"='"+bpvCId+"'";
              chk = st.executeUpdate(sql);
              Vector v = new Vector();
              v = getBackTPatientVisitContact(branch_id,"","","", bpvC.billingInvoiceNumber, "billing_number_status_billing_complete");//ดึงตาม billing แล้ว check ว่ารับชำระหมดแล้วหรือไม่
              if(v.isEmpty()){
                  chked="4";
              }else{
                  chked="2";
              }
//          }else{
//              sql="Update "+bpv_f.getBackTPatientVisitFunds()+" Set "+bpv_f.getFStatusBilling()+"='"+status_payment+"' "
//                      + "Where "+bpv_f.getFPatientVisitFundsId()+"='"+bpv_f_id+"'";
//              st.executeUpdate(sql);
//              chk="2";
          }
          conn.close();
        }catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chked;
    }
    public Vector getBContact(String branch_id, String visitHn, String deptNumber, String where, String flagpage) {
        Connection conn;
//        BContact contact = new BContact();
        Vector v_contact = new Vector();
        String sql="", whereContact="", whereDeptNumber="", whereVisitHn="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
//            if(!where.equals("")) {
                if(flagpage.equals("search_namet")) {
                }else if(flagpage.equals("search_all")){
                    if(!visitHn.equals("")){
                        if(visitHn.indexOf("@")>0) whereVisitHn = visitHn.substring(0, visitHn.indexOf("@"));
                        whereVisitHn = " and bpvC."+bpvC.getFVisitHn()+" like '"+whereVisitHn+"%' ";
                    }
                    if(!deptNumber.equals("")){
                        whereDeptNumber = " and bpvC."+bpvC.getFContractPayerNumber()+" = '"+deptNumber+"' ";
                    }
                    if(!where.equals("")){
                        whereContact  =" and (bpvC."+bpvC.getFVisitContactJoinId()+" like '"+where+"%' Or bpvC."
                                +bpvC.getFVisitContactJoinNamet()+" like '"+where+"%' )";
                    }
                    sql="Select Distinct bc."+contact.getFContactNumber()+", bc."+contact.getFContactNamet()+" "
                        + "From "+bpvC.getBackTPatientVisitContact()+" bpvC "
                        + "left join b_contact bc on bpvC.visit_contact_join_id = bc.contact_number "
                        + "Where bc.contact_active = '1' and (bpvC."+bpvC.getFPatientVisitContactActive()+"='1') "
                        +whereContact+whereDeptNumber+whereVisitHn+" Limit 40 ";
                }else{
                    sql="Select * "
                    +"From "+contact.getBContact()+" "
                    +"Where "+contact.getFContactActive()+"='1' "+
                    "Order By "+contact.getFContactNamet()+" asc";
                }
//            }
            if(!sql.equals("")){
                ResultSet rs = stbangna.executeQuery(sql);
                while(rs.next()){
                    contact = new BContact();
                    contact.contactNumber = (config1.StringNull(rs.getString(contact.getFContactNumber())));
                    contact.contactNamet = (config1.StringNull(rs.getString(contact.getFContactNamet())));
                    v_contact.add(contact);
                    }
                rs.close();
            }

            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_contact;
    }
    public String setUpdatePatientVisitContactInjuryNumber(String branchId, String bpvCId, String injuryNumber) {
        String sql = "";
        Integer chk=0;
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpvC.getBackTPatientVisitContact() + " "
                  + "Set " + bpvC.getFInjuryNumber() + "='" + injuryNumber + "' "
                  + "Where " + bpvC.getFPatientVisitContactId() + "='" + bpvCId + "' and "
                  + bpvC.getFBranchId() + "='" + branchId + "' ";
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
}