/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bangna.objdb;

import bangnaLibrary.BDocNumberDB;
import bangnaLibrary.BItem;
import bangnaLibrary.BackBTransfer;
import bangnaLibrary.BackTBillingCover;
import bangnaLibrary.BackTBillingPayment;
import bangnaLibrary.BackTBillingPaymentDB;
import bangnaLibrary.BackTBillingPaymentItem;
import bangnaLibrary.BackTPatientVisit;
import bangnaLibrary.BackTPatientVisitBillingDB;
import bangnaLibrary.BackTPatientVisitDB;
import bangnaLibrary.CashierTBillingInvoicePrint;
import bangnaLibrary.CashierTBillingInvoicePrintDB;
import bangnaLibrary.Config1;
import com.bangna.object.BackTPatientVisitContactBilling;
import com.bangna.object.BackTPatientVisitContactItem;
import com.bangna.object.BackTPatientVisitContact;
import com.bangna.object.BackTPatientVisitContactBillingItem;
import com.bangna.object.BackTPatientVisitContactBillingTemp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class BackTPatientVisitContactBillingDB {
    Config1 config1;
    private StringBuilder txt;
    private StringBuilder sql;
    private StringBuilder space1;
    public BackTPatientVisitContactDB bpvCdb;
    public BackTPatientVisitContact bpvC;
    public BackTPatientVisitContactBilling bpvCb;
    public BackTPatientVisitContactBillingItem bpvCbI;
    public BackTPatientVisitDB bpvdb;
    private BackTPatientVisitContactBillingTemp bpv_cbt;
    private BackTBillingPaymentDB bpdb;
    private BackTBillingCover bbC;
    private BackBTransfer bbT;
    private BItem b_item;
    private BackTDebtorDB debtordb;
    final private String idtableItem = "158";
    final private String idtable = "154";
    public BackTPatientVisitContactBillingDB(){
        config1 = new Config1();
        initConfig(config1);
    }
    public BackTPatientVisitContactBillingDB(Config1 cf){
        config1 = cf;
        initConfig(cf);
    }
    public void initConfig(Config1 cf){
        txt = new StringBuilder();
        sql = new StringBuilder();
        space1 = new StringBuilder();
        bpvCb = new BackTPatientVisitContactBilling();
        bpvCbI = new BackTPatientVisitContactBillingItem();
        bpvC = new BackTPatientVisitContact();
        bpv_cbt = new BackTPatientVisitContactBillingTemp();
        b_item = new BItem();
        bbC = new BackTBillingCover();
        bbT = new BackBTransfer();
        
        bpvCdb = new BackTPatientVisitContactDB(cf);
        bpvdb = new BackTPatientVisitDB(cf);
        bpdb = new BackTBillingPaymentDB(cf);
        debtordb = new BackTDebtorDB(cf);
    }
    public String getMaxRowBackTPatientVisitContactBilling(Connection conn) {
        String sql = "", max = "";
        try {
            Statement st = conn.createStatement();
            sql = "Select max(" + bpvCb.getFPatientVisitContactBillingId() + ") as cnt From " + bpvCb.getBackTPatientVisitContactBilling();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))
                max = String.valueOf(Integer.parseInt(max) + 1);
            else
                max = "1540000001";
        }catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowBackTPatientVisitContactBillingItem(Statement st) {
        String sql = "", max = "";
        try{
//            Statement st = conn.createStatement();
            sql = "Select max(" + bpvCbI.getFPatientVisitContactBillingItemId() + ") as cnt " + "From " + bpvCbI.getBackTPatientVisitContactBillingItem();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals(""))) {
                max = String.valueOf(Integer.parseInt(max) + 1);
            } else
                max = "1580000001";
        }catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }

    public BackTPatientVisitContactBilling getBackTPatientVisitContactBillingByPK(String branch_id, String bpv_cb_id, String flag){
        String sql = "", search="";
        try {
            bpvCb = new BackTPatientVisitContactBilling();
            Connection conn = bpvdb.config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            if(flag.equals("billing_number")){
                sql = "Select * From " + bpvCb.getBackTPatientVisitContactBilling() + " "
                        + "Where " + bpvCb.getFBillingInvoiceNumber() + "='" + bpv_cb_id + "' ";
            }else if(flag.equals("billing_payment")){
                sql = "Select * From " + bpvCb.getBackTPatientVisitContactBilling() + " "
                        + "Where " + bpvCb.getFBillingInvoiceNumber() + "='" + bpv_cb_id + "' and "
                        +bpvCb.getFStatusPayment()+"='2' ";
            }else{
                sql = "Select * From " + bpvCb.getBackTPatientVisitContactBilling() + " "
                        + "Where " + bpvCb.getFPatientVisitContactBillingId() + "='" + bpv_cb_id + "'";
            }
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpvCb.setBServicePointId(config1.StringNull(rs.getString(bpvCb.getFBServicePointId())));
                bpvCb.setBVisitClinicId(config1.StringNull(rs.getString(bpvCb.getFBVisitClinicId())));
                bpvCb.setVisitClaimId(config1.StringNull(rs.getString(bpvCb.getFVisitClaimId())));
                bpvCb.setVisitPaidId(config1.StringNull(rs.getString(bpvCb.getFVisitPaidId())));
                bpvCb.setPatientFullnamet(config1.StringNull(rs.getString(bpvCb.getFPatientFullnamet())));

                bpvCb.setPatientVisitId(config1.StringNull(rs.getString(bpvCb.getFPatientVisitId())));
                bpvCb.setTPatientId(config1.StringNull(rs.getString(bpvCb.getFTPatientId())));
                bpvCb.setVisitBeginVisitTime(config1.StringNull(rs.getString(bpvCb.getFVisitBeginVisitTime())));
                bpvCb.setVisitDate(config1.StringNull(rs.getString(bpvCb.getFVisitDate())));
                bpvCb.setVisitDiagnosisNotice(config1.StringNull(rs.getString(bpvCb.getFVisitDiagnosisNotice())));

                bpvCb.setVisitFinancialDischargeTime(config1.StringNull(rs.getString(bpvCb.getFVisitFinancialDischargeTime())));
                bpvCb.setVisitFirstVisit(config1.StringNull(rs.getString(bpvCb.getFVisitFirstVisit())));
                bpvCb.setVisitHn(config1.StringNull(rs.getString(bpvCb.getFVisitHn())));
                bpvCb.setVisitHospitalService(config1.StringNull(rs.getString(bpvCb.getFVisitHospitalService())));
                bpvCb.setVisitNotice(config1.StringNull(rs.getString(bpvCb.getFVisitNotice())));

                bpvCb.setVisitPatientAge(config1.StringNull(rs.getString(bpvCb.getFVisitPatientAge())));
                bpvCb.setVisitPatientSelfDoctor(config1.StringNull(rs.getString(bpvCb.getFVisitPatientSelfDoctor())));
                bpvCb.setVisitVn(config1.StringNull(rs.getString(bpvCb.getFVisitVn())));
                bpvCb.setVisitClaimNamet(config1.StringNull(rs.getString(bpvCb.getFVisitClaimNamet())));
                bpvCb.setVisitPaidNamet(config1.StringNull(rs.getString(bpvCb.getFVisitPaidNamet())));

                bpvCb.setDepartmentNamet(config1.StringNull(rs.getString(bpvCb.getFDepartmentNamet())));
                bpvCb.setDoctorNamet(config1.StringNull(rs.getString(bpvCb.getFDoctorNamet())));
                bpvCb.setPatientImportId(config1.StringNull(rs.getString(bpvCb.getFPatientImportId())));
                bpvCb.setBranchId(config1.StringNull(rs.getString(bpvCb.getFBranchId())));
                bpvCb.setSysStatus(config1.StringNull(rs.getString(bpvCb.getFSysStatus())));

                bpvCb.setVisitPaid(Double.parseDouble(rs.getString(bpvCb.getFVisitPaid())));
                bpvCb.setVisitTotal(Double.parseDouble(rs.getString(bpvCb.getFVisitTotal())));
                bpvCb.setVisitDiscount(Double.valueOf(Double.parseDouble(rs.getString(bpvCb.getFVisitDiscount()))));
                bpvCb.setBillingCoverNumber(config1.StringNull(rs.getString(bpvCb.getFBillingCoverNumber())));
                bpvCb.setVisitContactId(config1.StringNull(rs.getString(bpvCb.getFVisitContactId())));

                bpvCb.setVisitContactNamet(config1.StringNull(rs.getString(bpvCb.getFVisitContactNamet())));
                bpvCb.setPatientVisitContactId(config1.StringNull(rs.getString(bpvCb.getFPatientVisitContactId())));
                bpvCb.setPatientVisitContactBillingActive(config1.StringNull(rs.getString(bpvCb.getFPatientVisitContactBillingActive())));
                bpvCb.setStatusPrint(config1.StringNull(rs.getString(bpvCb.getFStatusPrint())));
                bpvCb.setStatusPayment(config1.StringNull(rs.getString(bpvCb.getFStatusPayment())));

                bpvCb.setBillingInvoiceNumber(config1.StringNull(rs.getString(bpvCb.getFBillingInvoiceNumber())));
                bpvCb.setPatientVisitContactBillingId(config1.StringNull(rs.getString(bpvCb.getFPatientVisitContactBillingId())));
                bpvCb.setSickness(config1.StringNull(rs.getString(bpvCb.getFSickness())));
                bpvCb.setInvoiceNumber(config1.StringNull(rs.getString(bpvCb.getFInvoiceNumber())));
                bpvCb.setReceiptNumber(config1.StringNull(rs.getString(bpvCb.getFReceiptNumber())));

                bpvCb.setVisitTotalBaht(config1.StringNull(rs.getString(bpvCb.getFVisitTotalBaht())));
                bpvCb.setVisitContactJoinId(config1.StringNull(rs.getString(bpvCb.getFVisitContactJoinId())));
                bpvCb.setVisitContactJoinNamet(config1.StringNull(rs.getString(bpvCb.getFVisitContactJoinNamet())));
                bpvCb.receiveAmount = Double.parseDouble(rs.getString(bpvCb.getFReceiveAmount()));
                bpvCb.injuryNumber = config1.StringNull(rs.getString(bpvCb.getFInjuryNumber()));
                
                bpvCb.insuranceNumber = config1.StringNull(rs.getString(bpvCb.getFInsuranceNumber()));
                bpvCb.discountPayment = Double.parseDouble(rs.getString(bpvCb.getFDiscountPayment()));
                bpvCb.discountTax = Double.parseDouble(rs.getString(bpvCb.getFDiscountTax()));
                bpvCb.receiveOver = Double.parseDouble(rs.getString(bpvCb.getFReceiveOver()));
                bpvCb.amountCover = Double.parseDouble(rs.getString(bpvCb.getFAmountCover()));
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpvCb;
    }
    public Vector getBackTPatientVisitContactBilling(String branch_id, String bpv_cb_id, String where, String paid_id, String flagpage) {
        String sql = "",hn_search="",paid_search="", contact_join_search="";
        Vector v_bpvcb = new Vector();
        try {
            Connection conn = bpvdb.config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            if(!where.equals("")){
                hn_search = " and "+bpvCb.getFVisitHn()+" like '%"+where+"' ";
            }
            if(!paid_id.equals("")){
                paid_search = " and "+bpvCb.getFVisitPaidId()+" like '%"+paid_id+"' ";
            }
            if (flagpage.equals("billing_print")) {
                sql = "Select * From " + bpvCb.getBackTPatientVisitContactBilling() + " "
                        + "Where " + bpvCb.getFStatusPrint() + "='" + where + "'";
            }else if(flagpage.equals("debtor_no_print")){
                sql = "Select * "
                    + "From " + bpvCb.getBackTPatientVisitContactBilling() + " "
                    + "Where " + bpvCb.getFStatusPayment() + "='2' and "+bpvCb.getFStatusPrint()+"='0' and "
                    + bpvCb.getFPatientVisitContactBillingActive() + "='1' and "
                    + bpvCb.getFBranchId() + "='" + branch_id + "' "+hn_search
                    + "Order By " + bpvCb.getFPatientVisitContactBillingId() + " asc";
            }else if(flagpage.equals("billing_no_debtor")) {
                sql = "Select * "
                    + "From " + bpvCb.getBackTPatientVisitContactBilling() + " "
                    + "Where " + bpvCb.getFStatusPayment() + "='1' and "
                    + bpvCb.getFPatientVisitContactBillingActive() + "='1' and "
                    + bpvCb.getFBranchId() + "='" + branch_id + "' "+hn_search
                    + "Order By " + bpvCb.getFPatientVisitContactBillingId() + " asc";
            }else if(flagpage.equals("contact_cover_print")) {
                if(!bpv_cb_id.equals("")){
                    contact_join_search = " and "+bpvCb.getFVisitContactJoinId()+" like '%"+bpv_cb_id+"' ";
                }
                sql = "Select * "
                    + "From " + bpvCb.getBackTPatientVisitContactBilling() + " "
                    + "Where " + bpvCb.getFStatusPayment() + "='2' and "//ต้องตั้งหนี้แล้วถึงพิมพ์ใบปะหน้าได้
                    + bpvCb.getFPatientVisitContactBillingActive() + "='1' and "
                    + bpvCb.getFBranchId() + "='" + branch_id + "' "+hn_search+contact_join_search
                    + "Order By "+bpvCb.getFVisitDate()+"," + bpvCb.getFVisitVn() + " asc";
            }else if(flagpage.equals("search_cover_billing")){
                sql = "Select * "
                    + "From " + bpvCb.getBackTPatientVisitContactBilling() + " "
                    + "Where " + bpvCb.getFBillingInvoiceNumber() + "= '"+bpv_cb_id+"' and "
                    + bpvCb.getFPatientVisitContactBillingActive() + "= '1' and "
                    + bpvCb.getFBranchId() + "='" + branch_id + "' "
                    + "Order By " + bpvCb.getFPatientVisitContactBillingId() + " asc";
            }else if(flagpage.equals("search_cover_billing1")){
                sql = "Select * "
                    + "From " + bpvCb.getBackTPatientVisitContactBilling() + " "
                    + "Where " + bpvCb.getFBillingCoverNumber() + "= '"+bpv_cb_id+"' and "
                    + bpvCb.getFPatientVisitContactBillingActive() + "= '1' and "
                    + bpvCb.getFBranchId() + "='" + branch_id + "' "
                    + "Order By " + bpvCb.getFPatientVisitContactBillingId() + " asc";
            }else if(flagpage.equals("billing_number_status_billing_complete")) {// check status bill ว่า รับชำระหมดแล้วหรือไม่ เพื่อจะได้นำค่าไป update funds_billing
                sql = "Select * From "+bpvCb.getBackTPatientVisitContactBilling()+" "// คือ ต้องการ check ว่า มี bill ที่ยังรับชำระไม่หมดหรือไม่
                    +"Where "+bpvCb.getFBillingInvoiceNumber()+" = '"+bpv_cb_id+"' and "+bpvCb.getFPatientVisitContactBillingActive()+"='1' "
                    +" and "+bpvCb.getFStatusPayment()+"<>'4' "
                    + "Order By "+bpvCb.getFPatientVisitContactId() ;
            }else if(flagpage.equals("injury_number")){
                if(!where.equals("")){
                    hn_search = " and "+bpvCb.getFInjuryNumber()+" = '"+where+"' ";
                }
                sql = "Select * "
                    + "From " + bpvCb.getBackTPatientVisitContactBilling() + " "
                    + "Where " + bpvCb.getFStatusPayment() + "='2' and "//ต้องตั้งหนี้แล้วถึงพิมพ์ใบปะหน้าได้
                    + bpvCb.getFPatientVisitContactBillingActive() + "='1' and "
                    + bpvCb.getFBranchId() + "='" + branch_id + "' "+hn_search+contact_join_search
                    + "Order By " + bpvCb.getFPatientVisitContactBillingId() + " asc";
            }else if(flagpage.equals("auto_search_injury")){
                if(!where.equals("")){
                    hn_search = " and "+bpvCb.getFInjuryNumber()+" like '"+where+"%' ";
                }
                sql = "Select Distinct "+bpvCb.getFInjuryNumber()+" "
                    + "From " + bpvCb.getBackTPatientVisitContactBilling() + " "
                    + "Where " + bpvCb.getFStatusPayment() + "='4' and "//ต้องตั้งหนี้แล้วถึงพิมพ์ใบปะหน้าได้
                    + bpvCb.getFPatientVisitContactBillingActive() + "='1' and "
                    + bpvCb.getFBranchId() + "='" + branch_id + "' "+hn_search
                    + "Order By " + bpvCb.getFInjuryNumber() + " asc";
            }else{
                sql = "Select * From " + bpvCb.getBackTPatientVisitContactBilling() + " "
                        + "Where " + bpvCb.getFPatientVisitContactBillingId() + "='" + bpv_cb_id + "'";
            }
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpvCb = new BackTPatientVisitContactBilling();
                if(flagpage.equals("auto_search_injury")){
                    bpvCb.injuryNumber = config1.StringNull(rs.getString(bpvCb.getFInjuryNumber()));
                }else{
                    bpvCb.setBServicePointId(config1.StringNull(rs.getString(bpvCb.getFBServicePointId())));
                    bpvCb.setBVisitClinicId(config1.StringNull(rs.getString(bpvCb.getFBVisitClinicId())));
                    bpvCb.setVisitClaimId(config1.StringNull(rs.getString(bpvCb.getFVisitClaimId())));
                    bpvCb.setVisitPaidId(config1.StringNull(rs.getString(bpvCb.getFVisitPaidId())));
                    bpvCb.setPatientFullnamet(config1.StringNull(rs.getString(bpvCb.getFPatientFullnamet())));

                    bpvCb.setPatientVisitId(config1.StringNull(rs.getString(bpvCb.getFPatientVisitId())));
                    bpvCb.setTPatientId(config1.StringNull(rs.getString(bpvCb.getFTPatientId())));
                    bpvCb.setVisitBeginVisitTime(config1.StringNull(rs.getString(bpvCb.getFVisitBeginVisitTime())));
                    bpvCb.setVisitDate(config1.StringNull(rs.getString(bpvCb.getFVisitDate())));
                    bpvCb.setVisitDiagnosisNotice(config1.StringNull(rs.getString(bpvCb.getFVisitDiagnosisNotice())));

                    bpvCb.setVisitFinancialDischargeTime(config1.StringNull(rs.getString(bpvCb.getFVisitFinancialDischargeTime())));
                    bpvCb.setVisitFirstVisit(config1.StringNull(rs.getString(bpvCb.getFVisitFirstVisit())));
                    bpvCb.setVisitHn(config1.StringNull(rs.getString(bpvCb.getFVisitHn())));
                    bpvCb.setVisitHospitalService(config1.StringNull(rs.getString(bpvCb.getFVisitHospitalService())));
                    bpvCb.setVisitNotice(config1.StringNull(rs.getString(bpvCb.getFVisitNotice())));

                    bpvCb.setVisitPatientAge(config1.StringNull(rs.getString(bpvCb.getFVisitPatientAge())));
                    bpvCb.setVisitPatientSelfDoctor(config1.StringNull(rs.getString(bpvCb.getFVisitPatientSelfDoctor())));
                    bpvCb.setVisitVn(config1.StringNull(rs.getString(bpvCb.getFVisitVn())));
                    bpvCb.setVisitClaimNamet(config1.StringNull(rs.getString(bpvCb.getFVisitClaimNamet())));
                    bpvCb.setVisitPaidNamet(config1.StringNull(rs.getString(bpvCb.getFVisitPaidNamet())));

                    bpvCb.setDepartmentNamet(config1.StringNull(rs.getString(bpvCb.getFDepartmentNamet())));
                    bpvCb.setDoctorNamet(config1.StringNull(rs.getString(bpvCb.getFDoctorNamet())));
                    bpvCb.setPatientImportId(config1.StringNull(rs.getString(bpvCb.getFPatientImportId())));
                    bpvCb.setBranchId(config1.StringNull(rs.getString(bpvCb.getFBranchId())));
                    bpvCb.setSysStatus(config1.StringNull(rs.getString(bpvCb.getFSysStatus())));

                    bpvCb.setVisitPaid(Double.parseDouble(rs.getString(bpvCb.getFVisitPaid())));
                    bpvCb.setVisitTotal(Double.parseDouble(rs.getString(bpvCb.getFVisitTotal())));
                    bpvCb.setVisitDiscount(Double.valueOf(Double.parseDouble(rs.getString(bpvCb.getFVisitDiscount()))));
                    bpvCb.setBillingCoverNumber(config1.StringNull(rs.getString(bpvCb.getFBillingCoverNumber())));
                    bpvCb.setVisitContactId(config1.StringNull(rs.getString(bpvCb.getFVisitContactId())));

                    bpvCb.setVisitContactNamet(config1.StringNull(rs.getString(bpvCb.getFVisitContactNamet())));
                    bpvCb.setPatientVisitContactId(config1.StringNull(rs.getString(bpvCb.getFPatientVisitContactId())));
                    bpvCb.setPatientVisitContactBillingActive(config1.StringNull(rs.getString(bpvCb.getFPatientVisitContactBillingActive())));
                    bpvCb.setStatusPrint(config1.StringNull(rs.getString(bpvCb.getFStatusPrint())));
                    bpvCb.setStatusPayment(config1.StringNull(rs.getString(bpvCb.getFStatusPayment())));

                    bpvCb.setBillingInvoiceNumber(config1.StringNull(rs.getString(bpvCb.getFBillingInvoiceNumber())));
                    bpvCb.setPatientVisitContactBillingId(config1.StringNull(rs.getString(bpvCb.getFPatientVisitContactBillingId())));
                    bpvCb.setSickness(config1.StringNull(rs.getString(bpvCb.getFSickness())));
                    bpvCb.setInvoiceNumber(config1.StringNull(rs.getString(bpvCb.getFInvoiceNumber())));
                    bpvCb.setReceiptNumber(config1.StringNull(rs.getString(bpvCb.getFReceiptNumber())));

                    bpvCb.setVisitTotalBaht(config1.StringNull(rs.getString(bpvCb.getFVisitTotalBaht())));
                    bpvCb.setVisitContactJoinId(config1.StringNull(rs.getString(bpvCb.getFVisitContactJoinId())));
                    bpvCb.setVisitContactJoinNamet(config1.StringNull(rs.getString(bpvCb.getFVisitContactJoinNamet())));
                    bpvCb.receiveAmount = Double.parseDouble(rs.getString(bpvCb.getFReceiveAmount()));
                    bpvCb.injuryNumber = config1.StringNull(rs.getString(bpvCb.getFInjuryNumber()));

                    bpvCb.insuranceNumber = config1.StringNull(rs.getString(bpvCb.getFInsuranceNumber()));
                    bpvCb.discountPayment = Double.parseDouble(rs.getString(bpvCb.getFDiscountPayment()));
                    bpvCb.discountTax = Double.parseDouble(rs.getString(bpvCb.getFDiscountTax()));

                    bpvCb.receiveOver = Double.parseDouble(rs.getString(bpvCb.getFReceiveOver()));
                    if(rs.getString(bpvCb.getFAmountCover()) == null || rs.getString(bpvCb.getFAmountCover()).equals("")){
                        bpvCb.amountCover = 0.0;
                    }else{
                        bpvCb.amountCover = Double.parseDouble(rs.getString(bpvCb.getFAmountCover()));
                    }
                }
                v_bpvcb.add(bpvCb);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_bpvcb;
    }
    public BackTPatientVisitContactBillingItem getBackTPatientVisitContactBillingItemByPK(String branch_id, String bpv_cbi_id) {
        String sql = "";
        try {
            bpvCbI = new BackTPatientVisitContactBillingItem();
            Connection conn = bpvdb.config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            sql = "Select * From " + bpvCbI.getBackTPatientVisitContactBillingItem() + " " + "Where " + bpvCbI.getFPatientVisitContactBillingItemId() + "='" + bpv_cbi_id + "'";
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()){
                bpvCbI.setBItemBillingSubgroupId(rs.getString(bpvCbI.getFBItemBillingSubgroupId()));
                bpvCbI.setBItemId(rs.getString(bpvCbI.getFBItemId()));
                bpvCbI.setBillingInvoiceItemActive(rs.getString(bpvCbI.getFBillingInvoiceItemActive()));
                bpvCbI.setBillingInvoiceItemTotal(Double.parseDouble(rs.getString(bpvCbI.getFBillingInvoiceItemTotal())));
                bpvCbI.setBillingInvoiceNumber(rs.getString(bpvCbI.getFBillingInvoiceNumber()));

                bpvCbI.setClaimId(rs.getString(bpvCbI.getFClaimId()));
                bpvCbI.setClaimNamet(rs.getString(bpvCbI.getFClaimNamet()));
                bpvCbI.setDepartmentNamet(rs.getString(bpvCbI.getFDepartmentNamet()));
                bpvCbI.setPatientVisitContactItemId(rs.getString(bpvCbI.getFPatientVisitContactItemId()));
                bpvCbI.setPatientVisitId(rs.getString(bpvCbI.getFPatientVisitId()));

                bpvCbI.setTBillingId(rs.getString(bpvCbI.getFTBillingId()));
                bpvCbI.setTBillingInvoiceDateTime(rs.getString(bpvCbI.getFTBillingInvoiceDateTime()));
                bpvCbI.setTBillingInvoiceItemId(rs.getString(bpvCbI.getFTBillingInvoiceItemId()));
                bpvCbI.setTBillingInvoiceItemNamet(rs.getString(bpvCbI.getFTBillingInvoiceItemNamet()));
                bpvCbI.setTBillingInvoiceTime(rs.getString(bpvCbI.getFTBillingInvoiceTime()));

                bpvCbI.setTOrderItemId(rs.getString(bpvCbI.getFTOrderItemId()));
                bpvCbI.setTPatientId(rs.getString(bpvCbI.getFTPatientId()));
                bpvCbI.setTPaymentId(rs.getString(bpvCbI.getFTPaymentId()));
                bpvCbI.setVisitId(rs.getString(bpvCbI.getFVisitId()));
                bpvCbI.setVisitPatientSelfDoctor(rs.getString(bpvCbI.getFVisitPatientSelfDoctor()));

                bpvCbI.setVisitVn(rs.getString(bpvCbI.getFVisitVn()));
                bpvCbI.setDepartmentId(rs.getString(bpvCbI.getFDepartmentId()));
                bpvCbI.setVisitHn(rs.getString(bpvCbI.getFVisitHn()));
                bpvCbI.setBranchId(config1.StringNull(rs.getString(bpvCbI.getFBranchId())));
                bpvCbI.setSysStatus(config1.StringNull(rs.getString(bpvCbI.getFSysStatus())));

                bpvCbI.setItemDiscount(Double.parseDouble(rs.getString(bpvCbI.getFItemDiscount())));
                bpvCbI.setItemPaid(Double.parseDouble(rs.getString(bpvCbI.getFItemPaid())));
                bpvCbI.setItemTotal(Double.parseDouble(rs.getString(bpvCbI.getFItemTotal())));
                bpvCbI.setEditStatus(config1.StringNull(rs.getString(bpvCbI.getFEditStatus())));
                bpvCbI.setRecordStatus(config1.StringNull(rs.getString(bpvCbI.getFRecordStatus())));

                bpvCbI.setPatientVisitItemId(config1.StringNull(rs.getString(bpvCbI.getFPatientVisitItemId())));
                bpvCbI.setPatientVisitContactId(config1.StringNull(rs.getString(bpvCbI.getFPatientVisitContactId())));
                bpvCbI.setPatientVisitContactBillingId(config1.StringNull(rs.getString(bpvCbI.getFPatientVisitContactBillingId())));
                bpvCbI.setPatientVisitContactBillingItemActive(config1.StringNull(rs.getString(bpvCbI.getFPatientVisitContactBillingItemActive())));
                bpvCbI.setPatientVisitContactBillingItemId(config1.StringNull(rs.getString(bpvCbI.getFPatientVisitContactBillingItemId())));

                bpvCbI.setCode(config1.StringNull(rs.getString(bpvCbI.getFCode())));
                bpvCbI.setNode(config1.StringNull(rs.getString(bpvCbI.getFNode())));
                bpvCbI.setSortLine1(Double.parseDouble(rs.getString(bpvCbI.getFSortLine1())));
                bpvCbI.setSortLine2(Double.parseDouble(rs.getString(bpvCbI.getFSortLine2())));
                bpvCbI.setSortLine3(Double.parseDouble(rs.getString(bpvCbI.getFSortLine3())));

                bpvCbI.setSortLine4(Double.parseDouble(rs.getString(bpvCbI.getFSortLine4())));
                bpvCbI.setSortLine5(Double.parseDouble(rs.getString(bpvCbI.getFSortLine5())));
                bpvCbI.setFItemGroupId(bpvdb.config1.StringNull(rs.getString(bpvCbI.getFFItemGroupId())));
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpvCbI;
    }
    public Vector getBackTPatientVisitContactBillingItem(String branch_id, String patient_visit_contact_billing_id) {
        String sql = "";
        Vector v_bpvcbi = new Vector();
        try {
            Connection conn = bpvdb.config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            sql = "Select * From " + bpvCbI.getBackTPatientVisitContactBillingItem() + " "
                    + "Where " + bpvCbI.getFPatientVisitContactBillingId() + "='" + patient_visit_contact_billing_id + "' "
                    + "Order By "+bpvCbI.getFSortLine1()+","+bpvCbI.getFSortLine2()+","+bpvCbI.getFSortLine3()+","+bpvCbI.getFSortLine4()+","+bpvCbI.getFSortLine5()+" ";
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpvCbI = new BackTPatientVisitContactBillingItem();
                bpvCbI.setBItemBillingSubgroupId(rs.getString(bpvCbI.getFBItemBillingSubgroupId()));
                bpvCbI.setBItemId(rs.getString(bpvCbI.getFBItemId()));
                bpvCbI.setBillingInvoiceItemActive(rs.getString(bpvCbI.getFBillingInvoiceItemActive()));
                bpvCbI.setBillingInvoiceItemTotal(Double.parseDouble(rs.getString(bpvCbI.getFBillingInvoiceItemTotal())));
                bpvCbI.setBillingInvoiceNumber(rs.getString(bpvCbI.getFBillingInvoiceNumber()));

                bpvCbI.setClaimId(rs.getString(bpvCbI.getFClaimId()));
                bpvCbI.setClaimNamet(rs.getString(bpvCbI.getFClaimNamet()));
                bpvCbI.setDepartmentNamet(rs.getString(bpvCbI.getFDepartmentNamet()));
                bpvCbI.setPatientVisitContactItemId(rs.getString(bpvCbI.getFPatientVisitContactItemId()));
                bpvCbI.setPatientVisitId(rs.getString(bpvCbI.getFPatientVisitId()));

                bpvCbI.setTBillingId(rs.getString(bpvCbI.getFTBillingId()));
                bpvCbI.setTBillingInvoiceDateTime(rs.getString(bpvCbI.getFTBillingInvoiceDateTime()));
                bpvCbI.setTBillingInvoiceItemId(rs.getString(bpvCbI.getFTBillingInvoiceItemId()));
                bpvCbI.setTBillingInvoiceItemNamet(rs.getString(bpvCbI.getFTBillingInvoiceItemNamet()));
                bpvCbI.setTBillingInvoiceTime(rs.getString(bpvCbI.getFTBillingInvoiceTime()));

                bpvCbI.setTOrderItemId(rs.getString(bpvCbI.getFTOrderItemId()));
                bpvCbI.setTPatientId(rs.getString(bpvCbI.getFTPatientId()));
                bpvCbI.setTPaymentId(rs.getString(bpvCbI.getFTPaymentId()));
                bpvCbI.setVisitId(rs.getString(bpvCbI.getFVisitId()));
                bpvCbI.setVisitPatientSelfDoctor(rs.getString(bpvCbI.getFVisitPatientSelfDoctor()));

                bpvCbI.setVisitVn(rs.getString(bpvCbI.getFVisitVn()));
                bpvCbI.setDepartmentId(rs.getString(bpvCbI.getFDepartmentId()));
                bpvCbI.setVisitHn(rs.getString(bpvCbI.getFVisitHn()));
                bpvCbI.setBranchId(config1.StringNull(rs.getString(bpvCbI.getFBranchId())));
                bpvCbI.setSysStatus(config1.StringNull(rs.getString(bpvCbI.getFSysStatus())));

                bpvCbI.setItemDiscount(Double.parseDouble(rs.getString(bpvCbI.getFItemDiscount())));
                bpvCbI.setItemPaid(Double.parseDouble(rs.getString(bpvCbI.getFItemPaid())));
                bpvCbI.setItemTotal(Double.parseDouble(rs.getString(bpvCbI.getFItemTotal())));
                bpvCbI.setEditStatus(config1.StringNull(rs.getString(bpvCbI.getFEditStatus())));
                bpvCbI.setRecordStatus(config1.StringNull(rs.getString(bpvCbI.getFRecordStatus())));

                bpvCbI.setPatientVisitItemId(config1.StringNull(rs.getString(bpvCbI.getFPatientVisitItemId())));
                bpvCbI.setPatientVisitContactId(config1.StringNull(rs.getString(bpvCbI.getFPatientVisitContactId())));
                bpvCbI.setPatientVisitContactBillingId(config1.StringNull(rs.getString(bpvCbI.getFPatientVisitContactBillingId())));
                bpvCbI.setPatientVisitContactBillingItemActive(config1.StringNull(rs.getString(bpvCbI.getFPatientVisitContactBillingItemActive())));
                bpvCbI.setPatientVisitContactBillingItemId(config1.StringNull(rs.getString(bpvCbI.getFPatientVisitContactBillingItemId())));

                bpvCbI.setCode(config1.StringNull(rs.getString(bpvCbI.getFCode())));
                bpvCbI.setNode(config1.StringNull(rs.getString(bpvCbI.getFNode())));
                bpvCbI.setSortLine1(Double.parseDouble(rs.getString(bpvCbI.getFSortLine1())));
                bpvCbI.setSortLine2(Double.parseDouble(rs.getString(bpvCbI.getFSortLine2())));
                bpvCbI.setSortLine3(Double.parseDouble(rs.getString(bpvCbI.getFSortLine3())));

                bpvCbI.setSortLine4(Double.parseDouble(rs.getString(bpvCbI.getFSortLine4())));
                bpvCbI.setSortLine5(Double.parseDouble(rs.getString(bpvCbI.getFSortLine5())));
                bpvCbI.setFItemGroupId(config1.StringNull(rs.getString(bpvCbI.getFFItemGroupId())));
                v_bpvcbi.add(bpvCbI);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_bpvcbi;
    }
    public String setSaveBackTPatientVisitContactBilling(String branch_id, BackTPatientVisitContactBilling item) throws Exception {
        int chk = 0;
        String sql = "", max = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            bpvCb = getBackTPatientVisitContactBillingByPK(branch_id, item.getPatientVisitContactBillingId(),"");
            item.setPatientFullnamet(config1.StringNull(item.getPatientFullnamet()).replace("'", "''"));
            item.setVisitNotice(config1.StringNull(item.getVisitNotice()).replace("'", "''"));
            item.setVisitDiagnosisNotice(config1.StringNull(item.getVisitDiagnosisNotice()).replace("'", "''"));
            if (bpvCb.getPatientVisitContactBillingId().equals("")) {
//                max = getMaxRowBackTPatientVisitContactBilling(conn);
                item.generateOID(idtable);
                max = item.getObjectId();
                sql = "Insert Into " + bpvCb.getBackTPatientVisitContactBilling()
                    + "(" + bpvCb.getFPatientVisitContactBillingId() + ", " + bpvCb.getFBServicePointId() + ", "
                    + bpvCb.getFBVisitClinicId() + "," + bpvCb.getFVisitClaimId() + ","
                    + bpvCb.getFVisitPaidId() + "," + bpvCb.getFPatientFullnamet() + ","
                    + bpvCb.getFPatientImportId() + "," + bpvCb.getFTPatientId() + ","
                    + bpvCb.getFVisitBeginVisitTime() + "," + bpvCb.getFVisitDate() + ","
                    + bpvCb.getFVisitDiagnosisNotice() + "," + bpvCb.getFVisitFinancialDischargeTime() + ","
                    + bpvCb.getFVisitFirstVisit() + "," + bpvCb.getFVisitHn() + ","
                    + bpvCb.getFVisitHospitalService() + "," + bpvCb.getFVisitNotice() + ", "
                    + bpvCb.getFVisitPatientAge() + "," + bpvCb.getFVisitPatientSelfDoctor() + ", "
                    + bpvCb.getFVisitVn() + "," + bpvCb.getFVisitClaimNamet() + ","
                    + bpvCb.getFVisitPaidNamet() + "," + bpvCb.getFDepartmentNamet() + ","
                    + bpvCb.getFDoctorNamet() + "," + bpvCb.getFBranchId() + ","
                    + bpvCb.getFSysStatus() + "," + bpvCb.getFPatientVisitId() + ","
                    + bpvCb.getFVisitContactId() + "," + bpvCb.getFVisitContactNamet() + ","
                    + bpvCb.getFPatientVisitContactBillingActive() + "," + bpvCb.getFPatientVisitContactId() + ","
                    + bpvCb.getFStatusPayment() + "," + bpvCb.getFStatusPrint() + ","
                    + bpvCb.getFVisitTotal() + "," + bpvCb.getFVisitPaid() + ","
                    + bpvCb.getFVisitDiscount() + "," + bpvCb.getFSickness() + ","
                    + bpvCb.getFInvoiceNumber() + "," + bpvCb.getFReceiptNumber() + ","
                    + bpvCb.getFVisitTotalBaht() + ","+bpvCb.getFCloseDayDate()+","
                    + bpvCb.getFVisitContactJoinId()+","+bpvCb.getFVisitContactJoinNamet()+","
                    + bpvCb.getFPatientCisitContactBillingDate()+","+bpvCb.getFBillingInvoiceNumber()+","
                    + bpvCb.getFInjuryNumber()+") "
//                        + "Values('" + max + "','" + item.getBServicePointId() + "','"
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
                    + item.getPatientVisitContactBillingActive() + "','" + item.getPatientVisitContactId() + "','"
                    + item.getStatusPayment() + "','" + item.getStatusPrint() + "',"
                    + item.getVisitTotal() + "," + item.getVisitPaid() + ","
                    + item.getVisitDiscount() + ",'" + item.getSickness() + "','"
                    + item.getInvoiceNumber() + "','" + item.getReceiptNumber() + "','"
                    + item.getVisitTotalBaht() + "','"+item.getCloseDayDate()+"','"
                    + item.getVisitContactJoinId()+"','"+item.getVisitContactJoinNamet()+"','"
                    + item.getPatientVisitContactBillingDate()+"','"+item.billingInvoiceNumber+"','"
                    + item.injuryNumber+"')";
            }else{
                sql = "Update " + bpvCb.getBackTPatientVisitContactBilling()
                    + " set " + bpvCb.getFBServicePointId() + " = '" + item.getBServicePointId() + "', "
                    + bpvCb.getFBVisitClinicId() + " = '" + item.getBVisitClinicId() + "', "
                    + bpvCb.getFVisitClaimId() + " = '" + item.getVisitClaimId() + "', "
                    + bpvCb.getFVisitPaidId() + " = '" + item.getVisitPaidId() + "', "
                    + bpvCb.getFPatientFullnamet() + " = '" + item.getPatientFullnamet() + "', "
                    + bpvCb.getFPatientImportId() + " = '" + item.getPatientImportId() + "', "
                    + bpvCb.getFTPatientId() + " = '" + item.getTPatientId() + "', "
                    + bpvCb.getFVisitBeginVisitTime() + " = '" + item.getVisitBeginVisitTime() + "', "
                    + bpvCb.getFVisitDate() + " = '" + item.getVisitDate() + "', "
                    + bpvCb.getFVisitDiagnosisNotice() + " = '" + item.getVisitDiagnosisNotice() + "',"
                    + bpvCb.getFVisitFinancialDischargeTime() + " = '" + item.getVisitFinancialDischargeTime() + "',"
                    + bpvCb.getFVisitFirstVisit() + " = '" + item.getVisitFirstVisit() + "', "
                    + bpvCb.getFVisitHn() + " = '" + item.getVisitHn() + "', "
                    + bpvCb.getFVisitHospitalService() + " = '" + item.getVisitHospitalService() + "', "
                    + bpvCb.getFVisitNotice() + " = '" + item.getVisitNotice() + "', "
                    + bpvCb.getFVisitPatientAge() + " = " + item.getVisitPatientAge() + ", "
                    + bpvCb.getFVisitPatientSelfDoctor() + " = '" + item.getVisitPatientSelfDoctor() + "', "
                    + bpvCb.getFVisitVn() + " = '" + item.getVisitVn() + "', "
                    + bpvCb.getFVisitClaimNamet() + " = '" + item.getVisitClaimNamet() + "', "
                    + bpvCb.getFVisitPaidNamet() + " = '" + item.getVisitPaidNamet() + "', "
                    + bpvCb.getFDepartmentNamet() + " = '" + item.getDepartmentNamet() + "', "
                    + bpvCb.getFDoctorNamet() + " = '" + item.getDoctorNamet() + ", "
                    + bpvCb.getFBranchId() + " = '" + item.getBranchId() + "', "
                    + bpvCb.getFSysStatus() + " = '" + item.getSysStatus() + "', "
                    + bpvCb.getFPatientVisitId() + " = '" + item.getPatientVisitId() + "', "
                    + bpvCb.getFVisitContactId() + " = '" + item.getVisitContactId() + "', "
                    + bpvCb.getFVisitContactNamet() + " = '" + item.getVisitContactNamet() + "', "
                    + bpvCb.getFPatientVisitContactBillingActive() + " = '" + item.getPatientVisitContactBillingActive() + "', "
                    + bpvCb.getFVisitTotal() + " = " + item.getVisitTotal() + ", "
                    + bpvCb.getFVisitPaid() + " = " + item.getVisitPaid() + ", "
                    + bpvCb.getFVisitDiscount() + " = " + item.getVisitDiscount() + ", "
                    + bpvCb.getFBillingCoverNumber() + " = '" + item.getBillingCoverNumber() + "', "
                    + bpvCb.getFBillingInvoiceNumber() + " = '" + item.getBillingInvoiceNumber() + "', "
                    + bpvCb.getFStatusPayment() + " = '" + item.getStatusPayment() + "', "
                    + bpvCb.getFStatusPrint() + " = '" + item.getStatusPrint() + "', "
                    + bpvCb.getFSickness() + " = '" + item.getSickness() + "', "
                    + bpvCb.getFInvoiceNumber() + " = '" + item.getInvoiceNumber() + "', "
                    + bpvCb.getFReceiptNumber() + " = '" + item.getReceiptNumber() + "', "
                    + bpvCb.getFVisitTotalBaht() + " = '" + item.getVisitTotalBaht() + "', "
                    + bpvCb.getFCloseDayDate() + " = '" + item.getCloseDayDate() + "' "
                    + "Where " + bpvCb.getFPatientVisitContactBillingId() + " = '" + item.getPatientVisitContactBillingId() + "'";
                max = item.getPatientVisitId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitBillingDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String setSaveBackTPatientVisitContactBillingItem(String branch_id, BackTPatientVisitContactBillingItem item) {
        String max="";
        try {
            Connection conn = bpvdb.config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            max = setSaveBackTPatientVisitContactBillingItem(stbangna,branch_id, item);
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String setSaveBackTPatientVisitContactBillingItem(Statement st,String branch_id, BackTPatientVisitContactBillingItem item) throws Exception {
        int chk = 0;
        String sql = "", max = "";
        try{
//            Connection conn = bpvdb.config1.getConnectionBangna();
//            Statement st = conn.createStatement();
            bpvCbI = getBackTPatientVisitContactBillingItemByPK(branch_id, item.getPatientVisitContactBillingItemId());

            if (bpvCbI.getPatientVisitContactBillingItemId().equals("")) {
//            max = getMaxRowBackTPatientVisitContactBillingItem(st);
            item.generateOID(idtableItem);
            max = item.getObjectId();
            sql = "Insert Into " + bpvCbI.getBackTPatientVisitContactBillingItem()
                + "(" + bpvCbI.getFPatientVisitContactBillingItemId() + ", " + bpvCbI.getFBItemBillingSubgroupId() + ", "
                + bpvCbI.getFBItemId() + "," + bpvCbI.getFBillingInvoiceItemActive() + ","
                + bpvCbI.getFBillingInvoiceItemTotal() + "," + bpvCbI.getFBillingInvoiceNumber() + ","
                + bpvCbI.getFClaimId() + "," + bpvCbI.getFClaimNamet() + ","
                + bpvCbI.getFDepartmentId() + "," + bpvCbI.getFDepartmentNamet() + ","
                + bpvCbI.getFPatientVisitId() + "," + bpvCbI.getFTBillingId() + ","
                + bpvCbI.getFPatientVisitItemId() + "," + bpvCbI.getFTBillingInvoiceDateTime() + ","
                + bpvCbI.getFTBillingInvoiceItemId() + "," + bpvCbI.getFTBillingInvoiceItemNamet() + ", "
                + bpvCbI.getFTBillingInvoiceTime() + "," + bpvCbI.getFTOrderItemId() + ", "
                + bpvCbI.getFTPatientId() + "," + bpvCbI.getFTPaymentId() + ","
                + bpvCbI.getFVisitHn() + "," + bpvCbI.getFVisitId() + ","
                + bpvCbI.getFVisitPatientSelfDoctor() + "," + bpvCbI.getFVisitVn() + ","
                + bpvCbI.getFBranchId() + "," + bpvCbI.getFSysStatus() + ","
                + bpvCbI.getFItemDiscount() + "," + bpvCbI.getFItemPaid() + ","
                + bpvCbI.getFItemTotal() + "," + bpvCbI.getFEditStatus() + ","
                + bpvCbI.getFPatientVisitContactId() + "," + bpvCbI.getFPatientVisitContactItemId() + ","
                + bpvCbI.getFPatientVisitContactBillingItemActive() + "," + bpvCbI.getFPatientVisitContactBillingId() + ","
                + bpvCbI.getFRecordStatus() + "," + bpvCbI.getFCode() + ","
                + bpvCbI.getFNode() + "," + bpvCbI.getFSortLine1() + ","
                + bpvCbI.getFSortLine2() + "," + bpvCbI.getFSortLine3() + ","
                + bpvCbI.getFSortLine4() + "," + bpvCbI.getFSortLine5() + ","
                + bpvCbI.getFFItemGroupId() + ") "
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
                + item.getItemTotal() + ",'" + item.getEditStatus() + "','"
                + item.getPatientVisitContactId() + "','" + item.getPatientVisitContactItemId() + "','"
                + item.getPatientVisitContactBillingItemActive() + "','" + item.getPatientVisitContactBillingId() + "','"
                + item.getRecordStatus() + "','" + item.getCode() + "','"
                + item.getNode() + "'," + item.getSortLine1() + ","
                + item.getSortLine2() + "," + item.getSortLine3() + ","
                + item.getSortLine4() + "," + item.getSortLine5() + ",'"
                + item.getFItemGroupId() + "')";
            }else{
            sql = "Update " + bpvCbI.getBackTPatientVisitContactBillingItem()
                    + " set " + bpvCbI.getFBItemBillingSubgroupId() + " = '" + item.getBItemBillingSubgroupId() + "', "
                    + bpvCbI.getFBItemId() + " = '" + item.getBItemId() + "', "
                    + bpvCbI.getFBillingInvoiceItemActive() + " = '" + item.getBillingInvoiceItemActive() + "', "
                    + bpvCbI.getFBillingInvoiceItemTotal() + " = '" + item.getBillingInvoiceItemTotal() + "', "
                    + bpvCbI.getFBillingInvoiceNumber() + " = '" + item.getBillingInvoiceNumber() + "', "
                    + bpvCbI.getFClaimId() + " = '" + item.getClaimId() + "', "
                    + bpvCbI.getFClaimNamet() + " = '" + item.getClaimNamet() + "', "
                    + bpvCbI.getFDepartmentId() + " = '" + item.getDepartmentId() + "', "
                    + bpvCbI.getFDepartmentNamet() + " = '" + item.getDepartmentNamet() + "', "
                    + bpvCbI.getFPatientVisitId() + " = '" + item.getPatientVisitId() + "',"
                    + bpvCbI.getFTBillingId() + " = '" + item.getTBillingId() + "',"
                    + bpvCbI.getFTBillingInvoiceDateTime() + " = " + item.getTBillingInvoiceDateTime() + ", "
                    + bpvCbI.getFTBillingInvoiceItemId() + " = " + item.getTBillingInvoiceItemId() + ", "
                    + bpvCbI.getFTBillingInvoiceItemNamet() + " = " + item.getTBillingInvoiceItemNamet() + ", "
                    + bpvCbI.getFTBillingInvoiceTime() + " = " + item.getTBillingInvoiceTime() + ", "
                    + bpvCbI.getFTOrderItemId() + " = " + item.getTOrderItemId() + ", "
                    + bpvCbI.getFTPatientId() + " = " + item.getTPatientId() + ", "
                    + bpvCbI.getFVisitId() + " = " + item.getVisitId() + ", "
                    + bpvCbI.getFVisitHn() + " = " + item.getVisitHn() + ", "
                    + bpvCbI.getFDepartmentNamet() + " = " + item.getDepartmentNamet() + ", "
                    + bpvCbI.getFVisitPatientSelfDoctor() + " = " + item.getVisitPatientSelfDoctor() + ", "
                    + bpvCbI.getFVisitVn() + " = " + item.getVisitVn() + ", "
                    + bpvCbI.getFBranchId() + " = " + item.getBranchId() + ", "
                    + bpvCbI.getFSysStatus() + " = " + item.getSysStatus() + ", "
                    + bpvCbI.getFItemDiscount() + " = " + item.getItemDiscount() + ", "
                    + bpvCbI.getFItemPaid() + " = " + item.getItemPaid() + ", "
                    + bpvCbI.getFItemTotal() + " = " + item.getItemTotal() + ", "
                    + bpvCbI.getFEditStatus() + " = '" + item.getEditStatus() + "', "
                    + bpvCbI.getFPatientVisitContactId() + " = '" + item.getPatientVisitContactId() + "', "
                    + bpvCbI.getFPatientVisitContactBillingItemActive() + " = '" + item.getPatientVisitContactId() + "', "
                    + bpvCbI.getFPatientVisitContactBillingId() + " = '" + item.getPatientVisitContactBillingId() + "', "
                    + bpvCbI.getFRecordStatus() + " = '" + item.getRecordStatus() + "', "
                    + bpvCbI.getFCode() + " = '" + item.getCode() + "', "
                    + bpvCbI.getFNode() + " = '" + item.getNode() + "', "
                    + bpvCbI.getFSortLine1() + " = " + item.getSortLine1() + ", "
                    + bpvCbI.getFSortLine2() + " = " + item.getSortLine2() + ", "
                    + bpvCbI.getFSortLine3() + " = " + item.getSortLine3() + ", "
                    + bpvCbI.getFSortLine4() + " = " + item.getSortLine4() + ", "
                    + bpvCbI.getFSortLine5() + " = " + item.getSortLine5() + ", "
                    + bpvCbI.getFFItemGroupId() + " = '" + item.getFItemGroupId() + "' "
                    + "Where " + bpvCbI.getFPatientVisitContactItemId() + " = '" + item.getPatientVisitContactItemId() + "'";

            max = item.getPatientVisitId();
            }
            chk = st.executeUpdate(sql);
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String getTrPatientVisitContactBilling(String branch_id, String flagpage, String status_billing,
          String date_end, String hnSearch, String departNumber, String contact_name_search) {
        String node_parent = ""; String node_child = ""; String chk_box = ""; String billingId = "",whereVisitHn="",date_search="";
        String whereContactJoin="", whereDept="",contactJoinNumber="",paid="",helpStatusBill="",helpLink="";
        StringBuilder link_data = new StringBuilder();
        Integer row = 100,row_detail =100;

        sql.delete(0, sql.length());
        if (hnSearch.indexOf("@")>0){
            whereVisitHn = hnSearch.substring(0, hnSearch.indexOf("@"));
            whereVisitHn = " and bpv_c." + bpvC.getFVisitHn() + " like '%" + whereVisitHn + "' ";
        }else {
            whereVisitHn = " and bpv_c." + bpvC.getFVisitHn() + " like '%" + hnSearch + "' ";
        }
        if (date_end.equals("")){
            date_search = "";
        }else{
            date_search = " and bpv_c." + bpvC.getFCloseDayDate() + " <= '" + date_end + "' ";
        }
        if (departNumber.equals("")){
            whereDept = "";
        }else {
//            contact_id_search1 = " and bpv_c." + bpvC.getFVisitContactId() + " like '" + contact_id_search + "%' ";
            whereDept = " and bpv_c." + bpvC.getFContractPayerNumber() + " = '" + departNumber + "' ";
        }
        if (contact_name_search.equals("")){
            whereContactJoin = "";
        }else {
            if (contact_name_search.indexOf("@")>0){
                contactJoinNumber = contact_name_search.substring(0, contact_name_search.indexOf("@"));
            }else
                contactJoinNumber = contact_name_search;
            whereContactJoin = " and ((bpv_c." + bpvC.getFVisitContactJoinNamet() + " like '" + contactJoinNumber + "%') Or "
                    + " (bpv_c." + bpvC.getFVisitContactJoinId() + " like '" + contactJoinNumber + "%')) ";
        }
        sql.append("Select bpv_c.").append(bpvC.getFVisitContactJoinId()).append(",bpv_c.").append(bpvC.getFVisitContactJoinNamet()).append(", ")
            .append("count(1) as cnt ").append("From ").append(bpvC.getBackTPatientVisitContact()).append(" as bpv_c ")
            .append("Where bpv_c.").append(bpvC.getFPatientVisitContactActive()).append("='1' and bpv_c.")
            .append(bpvC.getFStatusBilling()).append(" in (").append(status_billing).append(") and bpv_c.")
            .append(bpvC.getFBranchId()).append(" ='").append(branch_id).append("' ")
            .append(whereVisitHn).append(date_search).append(whereDept).append(whereContactJoin)
            .append("Group By bpv_c.").append(bpvC.getFVisitContactJoinId()).append(",bpv_c.")
            .append(bpvC.getFVisitContactJoinNamet());
        try{
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          Statement st_detail = conn.createStatement();
          Statement st_item = conn.createStatement();
          txt.delete(0, txt.length());
          ResultSet rs = st.executeQuery(sql.toString());
        //      Integer localInteger1;
          while (rs.next()) {
              row++;
            node_parent = row.toString();
            chk_box = "";
            sql.delete(0, sql.length());
            if (flagpage.equals("billing_view")) {
              chk_box = "<input type='checkbox' name='" + node_parent + "' id ='" + node_parent + "' value='OFF' onchange='chk(" + node_parent.toString() + ")' >";
            }
            txt.append("<tr id='tr_").append(node_parent).append("'><td >").append(chk_box).append("<font color='black'><b>").append(rs.getString(bpvCdb.bpvC.getFVisitContactJoinNamet())).append(" ").append(rs.getString(bpvCdb.bpvC.getFVisitContactJoinId())).append("</b></font></td>")
                    .append("<td align='center'>").append(rs.getString("cnt").toString()).append("[visit]</td>")
                    .append("<td><input type='hidden' id='td_").append(node_parent).append("' name='td_").append(node_parent).append("'value='").append(rs.getString("cnt").toString()).append("'>").append("</td></tr>");
            sql.append("Select min(bpv_c.").append(bpvC.getFPatientFullnamet()).append(") as ").append(bpvC.getFPatientFullnamet())
            .append(",min(bpv_c.").append(bpvC.getFVisitHn()).append(") as ").append(bpvC.getFVisitHn())
            .append(",min(bpv_c.").append(bpvC.getFVisitVn()).append(") as ").append(bpvC.getFVisitVn())
            .append(",min(bpv_c.").append(bpvC.getFVisitDate()).append(") as ").append(bpvC.getFVisitDate())
            .append(",bpv_c.").append(bpvC.getFStatusBilling()).append(" as ").append(bpvC.getFStatusBilling())
            .append(",min(bpv_c.").append(bpvC.getFPatientVisitContactBillingId()).append(") as ").append(bpvC.getFPatientVisitContactBillingId())
            .append(",min(bpv_c.").append(bpvC.getFPatientVisitContactId()).append(") as ").append(bpvC.getFPatientVisitContactId())
            .append(", min(bpv_c.").append(bpvC.getFVisitPaidNamet()).append(") as ").append(bpvC.getFVisitPaidNamet())
            .append(", min(bpv_c.").append(bpvC.getFReceiveDate()).append(") as ").append(bpvC.getFReceiveDate())
            .append(", min(bpv_c.").append(bpvC.getFBillingInvoiceNumber()).append(") as ").append(bpvC.getFBillingInvoiceNumber())
            .append(", min(bpv_c.").append(bpvC.getFReceiveAmount()).append(") as ").append(bpvC.getFReceiveAmount())
            .append(", sum(").append(bpvCdb.bpvCi.getFItemTotal()).append(") as paid, ").append(" count(1) as cnt, bpv_c.").append(bpvC.getFPatientVisitContactId())
            .append(" ").append("From ").append(bpvC.getBackTPatientVisitContact()).append(" as bpv_c ")
            .append("left join ").append(bpvCdb.bpvCi.getBackTPatientVisitContactItem()).append(" as bpv_ci on ")
            .append(" bpv_c.").append(bpvC.getFPatientVisitContactId()).append(" = bpv_ci.").append(bpvCdb.bpvCi.getFPatientVisitContactId()).append(" ")
            .append("Where bpv_c.").append(bpvC.getFBranchId()).append(" = '").append(branch_id).append("' and bpv_c.")
            .append(bpvC.getFStatusBilling()).append(" in (").append(status_billing).append(") and bpv_c.")
            .append(bpvC.getFVisitContactJoinId()).append("='").append(rs.getString(bpvC.getFVisitContactJoinId())).append("' and bpv_c.")
            .append(bpvC.getFPatientVisitContactActive()).append("='1' and ").append(bpvCdb.bpvCi.getFBillingInvoiceItemActive()).append("='1' ")
//            .append(whereVisitHn).append(date_search)
            .append(whereVisitHn).append(date_search).append(whereDept)
            .append("Group By bpv_c.").append(bpvC.getFBillingInvoiceNumber()).append(",bpv_c.").append(bpvC.getFPatientVisitContactId()).append(", bpv_c.").append(bpvC.getFVisitDate())
            .append(", bpv_c.").append(bpvC.getFStatusBilling()).append(" ")
            .append("Order By bpv_c.").append(bpvC.getFBillingInvoiceNumber()).append(",bpv_c.").append(bpvC.getFVisitDate()).append(", ").append(bpvC.getFPatientFullnamet());

            ResultSet rs_detail = st_detail.executeQuery(sql.toString());
            while (rs_detail.next()) {
              node_child = row.toString() + row_detail.toString();
              link_data.delete(0, link_data.length());
              if(rs_detail.getString(bpvC.getFStatusBilling()).equals("0")){
                  billingId = rs_detail.getString(bpvC.getFPatientVisitContactId());
                  if(billingId.length()>=11) billingId = billingId.substring(3);
                  link_data.append("<a href='javascript:showDetail(").append(billingId)
                      .append(")'>").append(rs_detail.getString(bpvC.getFPatientFullnamet())).append(" ")
                      .append(rs_detail.getString(bpvC.getFVisitHn())).append(" สิทธิ ").append(rs_detail.getString(bpvC.getFVisitPaidNamet())).append(" ").append(config1.DateFormatDB2Show(rs_detail.getString(bpvC.getFVisitDate()),"ddMMyyyy")).append("</a>");
              }else if(rs_detail.getString(bpvC.getFStatusBilling()).equals("2")){//ตั้งหนี้
                  billingId = rs_detail.getString(bpvC.getFPatientVisitContactBillingId());
                  if(billingId.length()>=11) billingId = billingId.substring(3);
                  link_data.append("<a href='javascript:showBilling(").append(billingId)
                      .append(")'>").append("<font color='blue'><b>").append(rs_detail.getString(bpvC.getFPatientFullnamet())).append("</b> hn ")
                      .append(rs_detail.getString(bpvC.getFVisitHn())).append(" สิทธิ ").append(rs_detail.getString(bpvC.getFVisitPaidNamet())).append(" ").append(config1.DateFormatDB2Show(rs_detail.getString(bpvC.getFVisitDate()),"ddMMyyyy")).append("</font> ")
                      .append("<font color ='orange'><b> เลขที่บิล ").append(rs_detail.getString(bpvC.getFBillingInvoiceNumber())).append("</b></font>");
              }else if(rs_detail.getString(bpvC.getFStatusBilling()).equals("4")){//รับชำระแล้ว
                  paid = config1.NumberFormat(bpvC.receiveAmount);
                  link_data.append("<font color='blue'><b>").append(rs_detail.getString(bpvC.getFPatientFullnamet())).append("</b> hn ")
                      .append(rs_detail.getString(bpvC.getFVisitHn())).append("</font> ")
                      .append("<font color ='orange'><b> เลขที่บิล ").append(rs_detail.getString(bpvC.getFBillingInvoiceNumber())).append("</b></font>")
                    .append("<font color ='green'><b> วันที่รับชำระ ").append(config1.DateFormatDB2Show(rs_detail.getString(bpvC.getFReceiveDate()),"ddMMyyyy")).append(" จำนวนเงินรับชำระ ").append(config1.NumberFormat(rs_detail.getString(bpvC.getFReceiveAmount()))).append("</b></font>");
              }else{
                  link_data.append("<font color='blue'><b>").append(rs_detail.getString(bpvC.getFPatientFullnamet())).append("</b> hn ")
                      .append(rs_detail.getString(bpvC.getFVisitHn())).append(" สิทธิ ").append(rs_detail.getString(bpvC.getFVisitPaidNamet())).append("</font> ");
              }
              if(rs_detail.getString(bpvC.getFStatusBilling()).equals("0")){
                  helpStatusBill="รับข้อมูล ยังไม่ออกบิล";
              }else if(rs_detail.getString(bpvC.getFStatusBilling()).equals("1")){
                  helpStatusBill="รวมบิล";
              }else if(rs_detail.getString(bpvC.getFStatusBilling()).equals("2")){
                  helpStatusBill="ตั้งหนี้แล้ว";
              }
              helpLink = " title = 'สถานะบิล "+rs_detail.getString(bpvC.getFStatusBilling())+" "+helpStatusBill+" billing_id "+rs_detail.getString(bpvC.getFPatientVisitContactBillingId())+"'";
//              link_data.append("<a href='javascript:showDetail(").append(rs_detail.getString(bpv_cdb.bpv_c.getFPatientVisitContactId()))
//                      .append(")'>").append(rs_detail.getString(bpv_cdb.bpv_c.getFPatientFullnamet())).append(" ")
//                      .append(rs_detail.getString(bpv_cdb.bpv_c.getFVisitHn())).append(" ").append(bpv_cdb.bpvdb.config1.DateFormatDB2Show(rs_detail.getString(bpv_cdb.bpv_c.getFVisitDate()),"ddMMyyyy")).append("</a>");
              chk_box = "";
              if (flagpage.equals("billing_view")) {
                chk_box = "<input type='checkbox' name='chk_contact_" + node_child + "' id ='chk_contact_" + node_child + "' onchange='cal()' />";
              }
              txt.append("<tr ").append(helpLink).append("id ='tr_").append(node_child).append("' class='child-of-tr_").append(node_parent)
                      .append("'><td>").append(chk_box).append("<font color='blue'>").append(link_data.toString()).append("</font></td>")
                      .append("<td align='center'><font color='blue'>").append(rs_detail.getString("cnt")).append("[item]</font></td>")
                      .append("<td align='center'><font color='blue'>").append(config1.NumberFormat(rs_detail.getString("paid"))).append("[บาท]</font>")
                      .append("<input type='hidden' id='row_").append(node_child).append("' name='row_").append(node_child)
                      .append("'value='").append(rs_detail.getString("paid")).append("'>").append("<input type='hidden' id='txt_")
                      .append(node_child).append("' name='txt_").append(node_child).append("'value='")
                      .append(rs_detail.getString(bpvC.getFPatientVisitContactId())).append("'></td></tr>");

        //          localInteger1 = row_detail; localInteger2 = row_detail = Integer.valueOf(row_detail.intValue() + 1);
            }
            row_detail = Integer.valueOf(100);
            rs_detail.close();
        //        localInteger1 = row; Integer localInteger2 = row = Integer.valueOf(row.intValue() + 1);
          }
          rs.close();
          conn.close();
          txt.append("<input type='hidden' id='row' name='row'value='" ).append(row).append("'>");
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
          txt.append(ex.getMessage());
        }
        return txt.toString();
    }
    public String setUpdatePatientVisitContactBillingItemNametEdit(String branch_id, String bpv_cbi_id, String item_namet) {
        String sql = "";
        Integer chk=0;
        try{
          item_namet = item_namet.replace("'", "''");
          Connection conn = bpvdb.config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvCbI.getBackTPatientVisitContactBillingItem()
                  + " Set " + bpvCbI.getFTBillingInvoiceItemNamet() + "='" + item_namet + "', "
                  + bpvCbI.getFRecordStatus() + "='1' "
                  + "Where " + bpvCbI.getFPatientVisitContactBillingItemId() + "='" + bpv_cbi_id + "'";

          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setUpdatePatientVisitContactBillingItemTotalEdit(String branch_id, String bpv_cbi_id, String item_price) {
        String sql = "";
        Integer chk=0;
        try {
          Connection conn = bpvCdb.bpvdb.config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvCbI.getBackTPatientVisitContactBillingItem()
                  + " Set " + bpvCbI.getFItemTotal() + "='" + item_price + "', "
                  + bpvCbI.getFRecordStatus() + "='1' "
                  + "Where " + bpvCbI.getFPatientVisitContactBillingItemId() + "='" + bpv_cbi_id + "'";
          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public void setUpdatePatientVisitContactBillingVoid(String branch_id, String bpv_cb_id) {
        String sql = "";
        Integer chk=0;
        try {
          Connection conn = bpvCdb.bpvdb.config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvCb.getBackTPatientVisitContactBilling()
                  + " Set " + bpvCb.getFPatientVisitContactBillingActive() + "='3' "
                  + "Where " + bpvCb.getFPatientVisitContactBillingId() + "='" + bpv_cb_id + "'";
          chk = st.executeUpdate(sql);
          sql = "Update " + bpvCbI.getBackTPatientVisitContactBillingItem()
                  + " Set " + bpvCbI.getFBillingInvoiceItemActive() + "='3' "
                  + "Where " + bpvCbI.getFPatientVisitContactBillingId() + "='" + bpv_cb_id + "'";
          chk = st.executeUpdate(sql);
//          bpv_cb = getBackTPatientVisitContactBillingByPK(branch_id, bpv_cb_id,"");
          sql = "Update " + bpvCdb.bpvC.getBackTPatientVisitContact()
                  + " Set " + bpvCdb.bpvC.getFStatusBilling() + "='0', "+bpvCdb.bpvC.getFBillingInvoiceNumber()+" = '' "
                  + "Where " + bpvCdb.bpvC.getFPatientVisitContactBillingId() + "='" + bpv_cb_id + "'";
          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Vector getBillingContact(String branch_id, String date_end) {
        String sql = "", txt = "", date_search="";
        Vector v_result = new Vector();
        try {
            if (!date_end.equals("")) {
                date_search = " and " + bpvCdb.bpvC.getFCloseDayDate() + " <= '" + date_end + "' ";
            }
            Connection conn = bpvdb.config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Select distinct " + bpvCdb.bpvC.getFVisitContactId() + ", " + bpvCdb.bpvC.getFVisitContactNamet() + " "
              + "From " + bpvCdb.bpvC.getBackTPatientVisitContact() + " "
              + "Where " + bpvCdb.bpvC.getFPatientVisitContactActive() + " = '1' and "
              + bpvCdb.bpvC.getFBranchId() + "='" + branch_id + "' and " + bpvCdb.bpvC.getFStatusBilling() + " = '0' "+date_search;

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                bpvCdb.bpvC = new BackTPatientVisitContact();
                bpvCdb.bpvC.setVisitContactId(rs.getString(bpvCb.getFVisitContactId()));
                bpvCdb.bpvC.setVisitContactNamet(rs.getString(bpvCb.getFVisitContactNamet()));
                v_result.add(bpvCdb.bpvC);
            }
          rs.close();
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getComboBillingContact(String branch_id, String date_end, String selected) {
        String txt = "", sql = "";
        Vector v_billing_contact = new Vector();
        v_billing_contact = getBillingContact(branch_id, date_end);
        txt = "<option value='' selected></option>";
        for (int i = 0; i <= v_billing_contact.size() - 1; i++) {
            bpvCdb.bpvC = (BackTPatientVisitContact)v_billing_contact.get(i);
            if (bpvCdb.bpvC.getVisitContactId().equals(selected))
                txt = txt + "<option value='" + bpvCdb.bpvC.getVisitContactId() + "' selected>" + bpvCdb.bpvC.getVisitContactNamet() + "</option>";
            else {
                txt = txt + "<option value='" + bpvCdb.bpvC.getVisitContactId() + "' >" + bpvCdb.bpvC.getVisitContactNamet() + "</option>";
            }
            if (i == 4) {
                sql = "";
            }
        }
        return txt;
    }
    public String getTrBillingPrepareDebtor(String branch_id, String billing_id, String paid_id, String flag) {
        String node_parent = "", text_h = "", chk_print = "", chk_src = "", script = "", bpv_f_id="", cnt="", total="";
        StringBuilder txt = new StringBuilder();
//        Connection conn;
        Vector v_billing = new Vector();
        try {
//            conn = bpv_fdb.bpvdb.config1.getConnectionBangna();
//            Statement st = conn.createStatement();
            if(flag.equals("debtor")){
                v_billing = getBackTPatientVisitContactBilling(branch_id,"", billing_id, paid_id, "billing_no_debtor");
            }else if(flag.equals("debtor_no_print")){
                v_billing = getBackTPatientVisitContactBilling(branch_id,"", billing_id, paid_id, flag);
            }else if(flag.equals("debtor_yes_print")){
                v_billing = getBackTPatientVisitContactBilling(branch_id,"", billing_id, paid_id, flag);
            }
    //        for(int row=0;row<=v_billing.size()-1;row++){
    //            bpv_f = new BackTPatientVisitFunds();
    //            bpv_f = (BackTPatientVisitFunds)v_billing.get(row);
    //            bpv_f_id = bpv_f.getPatientVisitFundsId();
    //            bpv_f = getBackTPatientVisitFundsByPK(branch_id, bpv_f_id, "");
    //        }
            for (int i = 0; i <= v_billing.size() - 1; i++) {
                try {
                    node_parent = "chk_" + i;
                    bpvCb = new BackTPatientVisitContactBilling();
                    bpvCb = (BackTPatientVisitContactBilling)v_billing.get(i);
                    bpv_cbt = getCntSumBackTPatientVisitContactBillingItem(branch_id, bpvCb.getPatientVisitContactBillingId());
    //                bpv_f_id = bpv_f.getPatientVisitFundsId();
//                    cnt = bpv_fb.getBServicePointId();//count billing
//                    total = bpv_fb.getVisitTotal().toString();
//                    bpv_f = new BackTPatientVisitFunds();
//                    bpv_fb = getBackTPatientVisitFundsBillingByPK(branch_id, bpv_fb.getPatientVisitFundsBillingId(), "");
                    if (bpvCb.getStatusPayment().equals("2")) {
                        chk_print = "";
                        chk_src = "images/print_green.png";
                    }else{
                        chk_print = "checked";
//                        chk_print = "";
                        chk_src = "images/print_red.png";
                    }
                    txt.append("<tr class='style14r'><td align='center'>").append((i + 1)).append("</td>")
            .append("<td><label><input type='checkbox' name='").append(node_parent).append("' id ='").append(node_parent).append("' value='' ").append(chk_print).append(" onchange='chkbilling(").append(")' >").append(bpvCb.getVisitHn()).append("</label></td>")
            .append("<td>").append(bpvCb.getPatientFullnamet()).append("</td>")
            .append("<td align='center'>").append(config1.DateFormatDB2Show(bpvCb.getVisitDate(), "ddMMyyyy")).append("</td>")
            .append("<td align='right'>").append(config1.NumberFormat(bpv_cbt.getAmount())).append("</td>")
            .append("<td align='right'>").append(bpv_cbt.getBillingInvoiceNumber()).append("</td>")
            .append("<td><img id='img_").append(i).append("' name = 'img_").append(i).append("' src='").append(chk_src)
            .append("' alt='' align='top' border='0' title='พิมพ์ billing' onclick='printBilling(").append(i).append(")'/>")
            .append("<input type='hidden' id='txt_patient_visit_contact_billing_id").append(i).append("' value='")
            .append(bpvCb.getPatientVisitContactBillingId()).append("'><input type='hidden' id='txt_total").append(i)
            .append("' value='").append(bpvCb.getVisitTotal()).append("'></td></tr>");
              }catch (Exception ex){
                Logger.getLogger(BackTPatientVisitBillingDB.class.getName()).log(Level.SEVERE, null, ex);
              }
            }
            text_h = "<thead> <tr align='center' class='style14r'>"
                    + "<th width='5' align='center'>ลำดับ</th> "
                    + "<th width='100' align='left'>HN</th> "
                    + "<th width='250' align='left'>ชื่อ-นามสกุล</th> "
                    + "<th width='85' align='left'>วันที่รักษา</th> "
                    + "<th width='80' align='left'>มูลค่า</th> "
                    + "<th width='80' align='left'>จำนวนบิล</th> "
                    + "<th width='40' align='left'>พิมพ์</th> </tr></thead>";
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "<table width='100%'>" + text_h + txt + "<input type='hidden' id='txt_billing_cover_row' value='" + (v_billing.size() - 1) + "'></table>" + script;
    }
    public BackTPatientVisitContactBillingTemp getCntSumBackTPatientVisitContactBillingItem(String branch_id, String bpv_fb_id) {
        String sql = "";
        Vector v_bpvcb = new Vector();
        try {
            Connection conn = bpvCdb.bpvdb.config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            sql = "Select count(*) as cnt, sum("+bpvCbI.getFItemTotal()+") as amount "
                    + "From "+bpvCbI.getBackTPatientVisitContactBillingItem()
                    +" Where "+bpvCbI.getFPatientVisitContactBillingId()+" = '"+bpv_fb_id+"' and "
                    +bpvCbI.getFBillingInvoiceItemActive()+"='1' ";
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpv_cbt = new BackTPatientVisitContactBillingTemp();
                bpv_cbt.setBillingInvoiceNumber(rs.getString("cnt"));
                bpv_cbt.setAmount(Double.parseDouble(rs.getString("amount")));
                v_bpvcb.add(bpv_cbt);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpv_cbt;
    }
    public String setCommonnameRoomXRay(Statement st, String item_common_name, String item_nick_name,String visit_vn, String b_item_id ){
        sql.delete(0, sql.length());
        Double cnt_item=0.0, price_item=0.0;
        String name="";
        try {
            if(item_nick_name.indexOf("ฟิล์ม")>=0){// xray
                name="";
                sql.append("SELECT sum(to_number(trxs.xray_film_amount, '99G999D9S')) as cnt_item, tor.order_price,xray_film_size_description " +
                        "FROM t_order tor " +
                        "LEFT JOIN b_item_billing_subgroup ON b_item_billing_subgroup.b_item_billing_subgroup_id::text = tor.b_item_billing_subgroup_id::text " +
                        "LEFT JOIN t_visit ON tor.t_visit_id::text = t_visit.t_visit_id::text " +
                        "LEFT JOIN b_item bi ON b_item_billing_subgroup.item_billing_subgroup_number::text = bi.item_number::text AND bi.item_active::text = '0'::text " +
                        "left join t_result_xray_size trxs on tor.t_order_id = trxs.t_order_id " +
                        "left join f_xray_film_size fxfs on trxs.f_xray_film_size_id = fxfs.f_xray_film_size_id " +
                        "WHERE tor.f_order_status_id::text = ANY (ARRAY['1'::text, '2'::text, '4'::text, '5'::text]) and " +
                        "t_visit.visit_vn = '").append(visit_vn).append("' and ").append(
                        "bi.b_item_id = '").append(b_item_id).append("' ").append(
                        "Group By tor.order_price,xray_film_size_description ");
                ResultSet rs_item;
                rs_item = st.executeQuery(sql.toString());
                while(rs_item.next()) {
                    if(rs_item.getString("cnt_item") != null) {
                        cnt_item = Double.parseDouble(rs_item.getString("cnt_item"));
                        price_item=Double.parseDouble(rs_item.getString("order_price"));
                        name = rs_item.getString("xray_film_size_description");
                    }
                }
                rs_item.close();
                if(cnt_item >=1) {
                    String cnt="";
                    cnt = cnt_item.toString();
                    if((cnt.indexOf(".")>0)&&(cnt.substring(cnt.length()-1).equals("0"))) {
                        cnt = cnt.substring(0, cnt.indexOf("."));
                    }
                    name = "ค่าเอ็กซเรย์ "+name+" "+cnt+" "+item_nick_name+" "+price_item.toString()+" บาท";
//                    vv_t_billing_invoice_subgroup.setItemCommonName(name);
                }
            }else {
                sql.append("SELECT sum(tor.order_qty) as cnt_item, tor.order_price ").append(
                    "FROM t_order tor ").append(
                    "LEFT JOIN b_item_billing_subgroup ON b_item_billing_subgroup.b_item_billing_subgroup_id::text = tor.b_item_billing_subgroup_id::text ").append(
                    "LEFT JOIN t_visit ON tor.t_visit_id::text = t_visit.t_visit_id::text ").append(
                    "LEFT JOIN b_item bi ON b_item_billing_subgroup.item_billing_subgroup_number::text = bi.item_number::text AND bi.item_active::text = '0'::text ").append(
                    "WHERE tor.f_order_status_id::text = ANY (ARRAY['1'::text, '2'::text, '4'::text, '5'::text]) and ").append(
                    "t_visit.visit_vn = '").append(visit_vn).append("' and ").append(
                    "bi.b_item_id = '").append(b_item_id).append("' ").append(
                    "Group By tor.order_price ");
                ResultSet rs_item = st.executeQuery(sql.toString());
                while(rs_item.next()){
                    if(rs_item.getString("cnt_item") != null) {
                        cnt_item = Double.parseDouble(rs_item.getString("cnt_item"));
                        price_item=Double.parseDouble(rs_item.getString("order_price"));
                    }
                }
                rs_item.close();
                name="";
                name = item_common_name;
                if(cnt_item >=1){
                    String cnt="";
                    cnt = cnt_item.toString();
                    if((cnt.indexOf(".")>0)&&(cnt.substring(cnt.length()-1).equals("0"))) {
                        cnt = cnt.substring(0, cnt.indexOf("."));
                    }
                    name = name+" "+cnt+" "+item_nick_name+" "+price_item.toString()+" บาท";
//                    vv_t_billing_invoice_subgroup.setItemCommonName(name);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }
    public String setSaveBillingContactPrepareBill(String branch_id, String data, String billing_date, String flag) {
        Boolean chk = false;
        String node = "", flagLanguage = "", bpv_c_id = "", bpv_cb_id = "", error = "";
        String doc_number="", date_current="", visit_vn_max="", visit_discharge_date="";
        Integer len = 8, len_data = 0, cut = 0;
        Double total = 0.0, discount = 0.0;

        Vector v_billing_item = new Vector();
        Vector v_save = new Vector();
        BackTPatientVisit bpv = new BackTPatientVisit();
        BackTPatientVisitContactBillingItem bpv_cbi_save = new BackTPatientVisitContactBillingItem();
        BackTPatientVisitContactBillingItem bpv_cbi_node_head = new BackTPatientVisitContactBillingItem();
        CashierTBillingInvoicePrintDB cbi_db = new CashierTBillingInvoicePrintDB(config1);
        CashierTBillingInvoicePrint cbi = new CashierTBillingInvoicePrint();
        BDocNumberDB docNumberdb = new BDocNumberDB(config1);
        try {
            flagLanguage = "thai";
            Connection conn_BItem = config1.getConnectionHospital(branch_id);
            Connection conn_bangna = config1.getConnectionBangna();
            Connection conn_hospital = config1.getConnectionHospital(branch_id);
            Statement st_BItem = conn_BItem.createStatement();
            Statement st_bangna = conn_bangna.createStatement();
            Statement st_hospital = conn_hospital.createStatement();
            len_data = Integer.valueOf(data.length());
            String[] aaa = data.split("\\^");
            date_current = config1.getDateDB("yyyyMMdd");
            for (int i = 0; i <= aaa.length - 1; i++) {
                try {
                    bpv_c_id = aaa[i];
                    if (bpv_c_id.length() <= 0) {
                        continue;
                    }
//                    String[] bbb = bpv_c_id.split("@");
//                    bpv_c_id = bbb[0];
//                    visit_vn_max = bbb[1];
                    //1.1.7.1.47
//                    errorsetUpdatePatientVisitFundsBilling = "001 i=" + i;
                    total = Double.valueOf(0.0D);
                    discount = Double.valueOf(0.0D);
//                    bpv_cdb.bpv_c = new BackTPatientVisitContact();
//                    bpv_cdb.bpv_c = bpv_cdb.getBackTPatientVisitContactByPK(st_bangna,branch_id, visit_vn_max, "visit_vn");
//                    visit_discharge_date = bpv_cdb.bpv_c.getVisitFinancialDischargeTime();
                    bpvCdb.bpvC = new BackTPatientVisitContact();
                    bpvCdb.bpvC = bpvCdb.getBackTPatientVisitContactByPK(st_bangna,branch_id, bpv_c_id, "");

                    visit_discharge_date = bpvCdb.bpvC.visitFinancialDischargeTime;
                    bpvCb = setCastPatientVisitContactBilling(bpvCdb.bpvC);
                    bpvCb.setVisitFinancialDischargeTime(visit_discharge_date);
                    bpv = new BackTPatientVisit();
                    bpv = bpvCdb.bpvdb.getBackTPatientVisitByPK(conn_bangna, st_bangna, bpvCb.patientVisitId, "");
                    cbi = new CashierTBillingInvoicePrint();
                    cbi = cbi_db.getCashierTBillingInvoicePrintByPK(branch_id, bpv.invoiceNumber, "invoice_number");
                    //bpvCb.setVisitDate(config1.DateFormatShow2DB(config1.DateFormatDB2ShowHospital(bpvCb.visitDate,"ddMMyyyy"),"ddMMyyyy"));
//                    bpvCb.visitDate = "";
                    bpvCb.setInvoiceNumber(bpv.invoiceNumber);
                    bpvCb.setReceiptNumber(bpv.receiveNumber);
                    bpvCb.setSickness(cbi.getSickness());
                    bpvCb.setStatusPayment("2");
                    bpvCb.setPatientVisitContactBillingDate(config1.DateFormatShow2DB(billing_date,"ddMMyyyy"));
                    if (!flag.equals("print_preview")) {
                        doc_number = docNumberdb.getRunningDocNumber(branch_id, conn_bangna,bpvCb.visitPaidId, "back_office_contact");
                    }
//                    if(doc_number.equals("")) 
//                        return;
                    bpvCb.setBillingInvoiceNumber(doc_number);
                    bpv_cb_id = setSaveBackTPatientVisitContactBilling(branch_id, bpvCb);
                    
                    v_billing_item = bpvCdb.getBackTPatientVisitContactItem(st_bangna,branch_id, bpvCdb.bpvC.patientVisitContactId, "prepare_billing");
                    v_save = new Vector();
                    for (int j = 0; j <= v_billing_item.size() - 1; j++) {
                        bpvCdb.bpvCi = new BackTPatientVisitContactItem();
                        bpvCdb.bpvCi = (BackTPatientVisitContactItem)v_billing_item.get(j);
                        bpvCbI = setCastPatientVisitContactBillingItem(bpvCdb.bpvCi);
                        bpvCbI.setPatientVisitContactBillingId(bpv_cb_id);
                        bpvCbI.setPatientVisitContactId(bpvCb.patientVisitContactId);
                        bpvCbI.setPatientVisitContactBillingItemActive("1");
                        bpvCbI.setNode("1");
                        if(bpvCbI.getBillingInvoiceNumber().equals("9")||bpvCbI.billingInvoiceNumber.equals("999")) {
                            discount+=bpvCbI.getItemTotal();
                        }
                        total = Double.valueOf(total + bpvCbI.itemTotal.doubleValue());
                        v_save.add(bpvCbI);
                    }
                    setUpdatePatientVisitContactBillingTotalBaht(st_bangna,branch_id, bpv_cb_id, total, discount,
                            config1.readCurrencyInThai(total.doubleValue() - discount.doubleValue(), "บาทถ้วน", "สตางค์"));
                    if (!flag.equals("print_preview")) {//pop ต้องวางไว้หล้ง save bill และต้องใช้ bpv_cdb.bpv_c.getVisitPaidId()
                         setUpdateContactDebtor(st_bangna, branch_id, doc_number, bpv_cb_id,
                                bpvCdb.bpvC.patientVisitContactId,total, bpvCdb.bpvC.closeDayDate);
                    }
//                    bpv_cb.setStatusPayment("2");
//                    bpv_cb.setStatusPrint("0");

                    v_billing_item = (Vector)v_save.clone();
//                    error = "002";
                  for (int j = 0; j <= v_billing_item.size() - 1; j++) {
                    bpvCbI = new BackTPatientVisitContactBillingItem();
                    bpvCbI = (BackTPatientVisitContactBillingItem)v_billing_item.get(j);

                    b_item = getInvoicePrint(st_hospital, bpvCbI.bItemId);

                    if(!b_item.getItemNickname().equals("")){
                        bpvCbI.setTBillingInvoiceItemNamet(setCommonnameRoomXRay(st_BItem, b_item.itemCommonName, b_item.itemNickname,bpvCb.visitVn,b_item.getBItemId()));
                    }else{
//                        if (b_item.getItemCommonName().equals(""))
                        bpvCbI.setTBillingInvoiceItemNamet(b_item.itemCommonName.trim());
                    }
//                    error = "002.1 i=" + i + " j = " + j;
                    //if (b_item.getItemCommonName().equals(""));
                    //bpv_cbi.setTBillingInvoiceItemNamet(b_item.getItemCommonName().trim());

//                    error = "002.2 i=" + i + " j = " + j;
                    bpvCbI.setCode(b_item.itemNumber.trim());
                    bpvCbI.setSpace1(b_item.itemTradeName);
                    String[] node1 = bpvCbI.getCode().split("\\.");
                    setSortLineContact(bpvCbI, node1);

//                    error = "002.3 i=" + i + " j = " + j;
                    node = "";
                    for (int ii = 0; ii <= node1.length - 2; ii++) {
                      node = node + node1[ii] + ".";
                    }
                    error = "002 i=" + i + " j = " + j + " node " + node;
                    if ((node.length() > 0) && (node.substring(node.length() - 1).equals("."))) {
                      node = node.substring(0, node.length() - 1);
                    }
                    bpv_cbi_node_head = new BackTPatientVisitContactBillingItem();
                    getMainBItemContact(st_BItem,bpv_cbi_node_head, node, flagLanguage);
                    error = "0021 i=" + i + " j = " + j;
                    if (bpv_cbi_node_head.getCode().length() > 0) {
                      bpv_cbi_node_head.setNode("2");
                      bpv_cbi_node_head.setPatientVisitContactBillingItemActive("1");
                      error = "022 i=" + i + " j = " + j;
                      setNodeHeadContact(bpv_cbi_node_head, bpvCbI);
                      error = "023 i=" + i + " j = " + j;
                      chk = Boolean.valueOf(false);
                      for (int ii = 0; ii <= v_save.size() - 1; ii++) {
                        bpv_cbi_save = new BackTPatientVisitContactBillingItem();
                        bpv_cbi_save = (BackTPatientVisitContactBillingItem)v_save.get(ii);
                        if (bpv_cbi_save.getCode().equals(bpv_cbi_node_head.getCode())) {
                          chk = Boolean.valueOf(true);
                          break;
                        }
                      }
                      error = "003 i=" + i + " j = " + j;
                      if (!chk.booleanValue()) {
                        node1 = bpv_cbi_node_head.getCode().split("\\.");
                        setSortLineContact(bpv_cbi_node_head, node1);
                        v_save.add(bpv_cbi_node_head);
                      }

                      node = "";
                      for (int ii = 0; ii <= node1.length - 2; ii++) {
                        node = node + node1[ii] + ".";
                      }
                      if ((node.length() > 0) && (node.substring(node.length() - 1).equals("."))) {
                        node = node.substring(0, node.length() - 1);
                      }
                      bpv_cbi_node_head = new BackTPatientVisitContactBillingItem();
                      getMainBItemContact(st_BItem,bpv_cbi_node_head, node, flagLanguage);
                      if (bpv_cbi_node_head.getCode().length() > 0) {
                        bpv_cbi_node_head.setNode("3");
                        bpv_cbi_node_head.setPatientVisitContactBillingItemActive("1");
                        setNodeHeadContact(bpv_cbi_node_head, bpvCbI);
                        error = "004 i=" + i + " j = " + j;
                        chk = Boolean.valueOf(false);
                        for (int ii = 0; ii <= v_save.size() - 1; ii++) {
                          bpv_cbi_save = new BackTPatientVisitContactBillingItem();
                          bpv_cbi_save = (BackTPatientVisitContactBillingItem)v_save.get(ii);
                          if (bpv_cbi_save.getCode().equals(bpv_cbi_node_head.getCode())) {
                            chk = Boolean.valueOf(true);
                            break;
                          }
                        }
                        if (!chk.booleanValue()) {
                          node1 = bpv_cbi_node_head.getCode().split("\\.");
                          setSortLineContact(bpv_cbi_node_head, node1);
                          v_save.add(bpv_cbi_node_head);
                        }
                        error = "005 i=" + i + " j = " + j;

                        node = "";
                        for (int ii = 0; ii <= node1.length - 2; ii++) {
                          node = node + node1[ii] + ".";
                        }
                        if ((node.length() > 0) && (node.substring(node.length() - 1).equals("."))) {
                          node = node.substring(0, node.length() - 1);
                        }
                        bpv_cbi_node_head = new BackTPatientVisitContactBillingItem();
                        getMainBItemContact(st_BItem,bpv_cbi_node_head, node, flagLanguage);
                        error = "006 i=" + i + " j = " + j;
                        if (bpv_cbi_node_head.getCode().length() > 0) {
                          bpv_cbi_node_head.setNode("4");
                          bpv_cbi_node_head.setPatientVisitContactBillingItemActive("1");
                          setNodeHeadContact(bpv_cbi_node_head, bpvCbI);
                          chk = Boolean.valueOf(false);
                          for (int ii = 0; ii <= v_save.size() - 1; ii++) {
                            bpv_cbi_save = new BackTPatientVisitContactBillingItem();
                            bpv_cbi_save = (BackTPatientVisitContactBillingItem)v_save.get(ii);
                            if (bpv_cbi_save.getCode().equals(bpv_cbi_node_head.getCode())) {
                              chk = Boolean.valueOf(true);
                              break;
                            }
                          }
                          error = "007 i=" + i + " j = " + j;
                          if (!chk.booleanValue()) {
                            node1 = bpv_cbi_node_head.getCode().split("\\.");
                            setSortLineContact(bpv_cbi_node_head, node1);
                            v_save.add(bpv_cbi_node_head);
                          }
                          node = "";
                          for (int ii = 0; ii <= node1.length - 2; ii++) {
                            node = node + node1[ii] + ".";
                          }
                          if ((node.length() > 0) && (node.substring(node.length() - 1).equals("."))) {
                            node = node.substring(0, node.length() - 1);
                          }
                          if (node.length() <= 0)
                            continue;
                          bpv_cbi_node_head = new BackTPatientVisitContactBillingItem();
                          getMainBItemContact(st_BItem,bpv_cbi_node_head, node, flagLanguage);
                          error = "008 i=" + i + " j = " + j;
                          if (bpv_cbi_node_head.getCode().length() > 0) {
                            bpv_cbi_node_head.setNode("5");
                            bpv_cbi_node_head.setPatientVisitContactBillingItemActive("1");
                            setNodeHeadContact(bpv_cbi_node_head, bpvCbI);
                            chk = Boolean.valueOf(false);
                            error = "009 i=" + i + " j = " + j;
                            for (int ii = 0; ii <= v_save.size() - 1; ii++) {
                              bpv_cbi_save = new BackTPatientVisitContactBillingItem();
                              bpv_cbi_save = (BackTPatientVisitContactBillingItem)v_save.get(ii);
                              if (bpv_cbi_save.getCode().equals(bpv_cbi_node_head.getCode())) {
                                chk = Boolean.valueOf(true);
                                break;
                              }
                            }
                            if (!chk.booleanValue()) {
                              node1 = bpv_cbi_node_head.getCode().split("\\.");
                              setSortLineContact(bpv_cbi_node_head, node1);
                              v_save.add(bpv_cbi_node_head);
                            }
                          }
                        }
                      }
                    }
                  }
                  error = "010 ";
//                  setSavePatientVisitContactStatusBilling(st_bangna,branch_id, bpv_cdb.bpv_c.getPatientVisitContactId(),doc_number, bpv_cb_id);
                  for (int j = 0; j <= v_save.size() - 1; j++) {
                    bpvCbI = new BackTPatientVisitContactBillingItem();
                    bpvCbI = (BackTPatientVisitContactBillingItem)v_save.get(j);
                    bpvCbI.setCode(bpvCbI.space1 + bpvCbI.code);
                //            bpv_fbi = bpv_fdb.setCastPatientVisitFundsBillingItem(bpv_fbi);
                    bpv_cb_id = setSaveBackTPatientVisitContactBillingItem(st_bangna,branch_id, bpvCbI);
                  }
                } catch (Exception ex) {
                  Logger.getLogger(BackTPatientVisitBillingDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            conn_BItem.close();
            conn_bangna.close();
            conn_hospital.close();
        }catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpv_cb_id;
    }
    public BackTPatientVisitContactBilling setCastPatientVisitContactBilling(BackTPatientVisitContact bpv_c) {
        try {
          bpvCb = new BackTPatientVisitContactBilling();
          bpvCb.setBServicePointId(bpv_c.getBServicePointId());
          bpvCb.setBVisitClinicId(bpv_c.getBVisitClinicId());
          bpvCb.setBranchId(bpv_c.getBranchId());
          bpvCb.setDepartmentNamet(bpv_c.getDepartmentNamet());
          bpvCb.setDoctorNamet(bpv_c.getDoctorNamet());

          bpvCb.setPatientFullnamet(bpv_c.getPatientFullnamet());
          bpvCb.setPatientImportId(bpv_c.getPatientImportId());
          bpvCb.setPatientVisitId(bpv_c.getPatientVisitId());
          bpvCb.setSysStatus(bpv_c.getSysStatus());
          bpvCb.setTPatientId(bpv_c.getTPatientId());

          bpvCb.setVisitBeginVisitTime(bpv_c.getVisitBeginVisitTime());
          bpvCb.setVisitClaimId(bpv_c.getVisitClaimId());
          bpvCb.setVisitClaimNamet(bpv_c.getVisitClaimNamet());
          bpvCb.setVisitContactId(bpv_c.getVisitContactId());
          bpvCb.setVisitDate(bpv_c.getVisitDate());
          bpvCb.setVisitDiagnosisNotice(bpv_c.getVisitDiagnosisNotice());
          bpvCb.setVisitDiscount(bpv_c.getVisitDiscount());
          bpvCb.setVisitFinancialDischargeTime(bpv_c.getVisitFinancialDischargeTime());
          bpvCb.setVisitFirstVisit(bpv_c.getVisitFirstVisit());
          bpvCb.setVisitHn(bpv_c.getVisitHn());

          bpvCb.setVisitHospitalService(bpv_c.getVisitHospitalService());
          bpvCb.setVisitNotice(bpv_c.getVisitNotice());
          bpvCb.setVisitPaid(bpv_c.getVisitPaid());
          bpvCb.setVisitPaidId(bpv_c.getVisitPaidId());
          bpvCb.setVisitPaidNamet(bpv_c.getVisitPaidNamet());

          bpvCb.setVisitPatientAge(bpv_c.getVisitPatientAge());
          bpvCb.setVisitPatientSelfDoctor(bpv_c.getVisitPatientSelfDoctor());
          bpvCb.setVisitTotal(bpv_c.getVisitTotal());
          bpvCb.setVisitVn(bpv_c.getVisitVn());
          bpvCb.setVisitContactNamet(bpv_c.getVisitContactNamet());

          bpvCb.setPatientVisitContactId(bpv_c.getPatientVisitContactId());
          bpvCb.setPatientVisitContactBillingId("");
          bpvCb.setPatientVisitContactBillingActive("1");
          bpvCb.setBillingCoverNumber("");
          bpvCb.setBillingInvoiceNumber("");

          bpvCb.setStatusPrint("0");
          bpvCb.setStatusPayment("2");
          bpvCb.setCloseDayDate(bpv_c.getCloseDayDate());
          bpvCb.setVisitContactJoinId(bpv_c.getVisitContactJoinId());
          bpvCb.setVisitContactJoinNamet(bpv_c.getVisitContactJoinNamet());
          bpvCb.injuryNumber = bpv_c.injuryNumber;
          bpvCb.insuranceNumber = bpv_c.insuranceNumber;
//          bpv_cb.setInjuryNumber(bpv_f.getInjuryNumber());
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpvCb;
    }
    public BackTPatientVisitContactBillingItem setCastPatientVisitContactBillingItem(BackTPatientVisitContactItem bpv_ci) {
        bpvCbI = new BackTPatientVisitContactBillingItem();
        bpvCbI.setBItemBillingSubgroupId(bpv_ci.getBItemBillingSubgroupId());
        bpvCbI.setBItemId(bpv_ci.getBItemId());
        bpvCbI.setBillingInvoiceItemActive(bpv_ci.getBillingInvoiceItemActive());
        bpvCbI.setBillingInvoiceItemTotal(bpv_ci.getBillingInvoiceItemTotal());
        bpvCbI.setBillingInvoiceNumber(bpv_ci.getBillingInvoiceNumber());

        bpvCbI.setClaimId(bpv_ci.getClaimId());
        bpvCbI.setClaimNamet(bpv_ci.getClaimNamet());
        bpvCbI.setDepartmentNamet(bpv_ci.getDepartmentNamet());
        bpvCbI.setPatientVisitContactItemId("");
        bpvCbI.setPatientVisitId(bpv_ci.getPatientVisitId());

        bpvCbI.setTBillingId(bpv_ci.getTBillingId());
        bpvCbI.setTBillingInvoiceDateTime(bpv_ci.getTBillingInvoiceDateTime());
        bpvCbI.setTBillingInvoiceItemId(bpv_ci.getTBillingInvoiceItemId());
        bpvCbI.setTBillingInvoiceItemNamet(bpv_ci.getTBillingInvoiceItemNamet());
        bpvCbI.setTBillingInvoiceTime(bpv_ci.getTBillingInvoiceTime());

        bpvCbI.setTOrderItemId(bpv_ci.getTOrderItemId());
        bpvCbI.setTPatientId(bpv_ci.getTPatientId());
        bpvCbI.setTPaymentId(bpv_ci.getTPaymentId());
        bpvCbI.setVisitId(bpv_ci.getVisitId());
        bpvCbI.setVisitPatientSelfDoctor(bpv_ci.getVisitPatientSelfDoctor());

        bpvCbI.setVisitVn(bpv_ci.getVisitVn());
        bpvCbI.setDepartmentId(bpv_ci.getDepartmentId());
        bpvCbI.setVisitHn(bpv_ci.getVisitHn());
        bpvCbI.setBranchId(config1.StringNull(bpv_ci.getBranchId()));
        bpvCbI.setSysStatus(config1.StringNull(bpv_ci.getSysStatus()));

        bpvCbI.setItemDiscount(bpv_ci.getItemDiscount());
        bpvCbI.setItemPaid(bpv_ci.getItemPaid());
        bpvCbI.setItemTotal(bpv_ci.getItemTotal());
        //    bpv_cbi.setCode(bpvdb.config1.StringNull(bpv_fi.getCode()));
        bpvCbI.setRecordStatus("0");

        //    bpv_cbi.setPatientVisitFundsItemId(bpvdb.config1.StringNull(bpv_fi.getPatientVisitContactItemId()));
        bpvCbI.setFItemGroupId(config1.StringNull(bpv_ci.getFItemGroupId()));
        bpvCbI.setPatientVisitContactBillingItemActive("1");
        //    bpv_cbi.setNode(bpvdb.config1.StringNull(bpv_fi.getNode()));
        //    bpv_cbi.setSortLine1(bpv_fi.getSortLine1());
        //    bpv_cbi.setSortLine2(bpv_fi.getSortLine2());

        //    bpv_cbi.setSortLine3(bpv_fi.getSortLine3());
        //    bpv_cbi.setSortLine4(bpv_fi.getSortLine4());
        //    bpv_cbi.setSortLine5(bpv_fi.getSortLine5());
        //    bpv_cbi.setPatientVisitFundsBillingId(bpv_fi.getPatientVisitContactBillingId());
        bpvCbI.setPatientVisitContactBillingItemId("");

        //    bpv_cbi.setEditStatus(bpv_fi.getEditStatus());
        return bpvCbI;
    }
    public void setUpdatePatientVisitContactBillingTotalBaht(Statement st,String branch_id, String bpv_cb_id, Double total, Double discount,
            String total_baht) {
        String sql = "";
        try {
//            Connection conn = bpv_cdb.bpvdb.config1.getConnectionBangna();
//            Statement st = conn.createStatement();
            sql = "Update " + bpvCb.getBackTPatientVisitContactBilling() + " "
                  + "Set " + bpvCb.getFVisitTotalBaht() + "='" + total_baht + "', "
                  + bpvCb.getFVisitTotal() + "=" + total + ", "
                  + bpvCb.getFVisitDiscount() + "=" + discount + ", "
                  + bpvCb.getFVisitPaid() + "=" + (total.doubleValue() + discount.doubleValue()) + " "
                  + "Where " + bpvCb.getFPatientVisitContactBillingId() + "='" + bpv_cb_id + "' and "
                  + bpvCb.getFBranchId() + "='" + branch_id + "' ";

            st.executeUpdate(sql);
//            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public BItem getInvoicePrint(Statement st_hospital, String b_item_id1){
//        String b_item_id = "", item_number = "", sql = "", item_descriptione = "", space1 = "", len_item_number = "", item_common_name = "";
        try {
            sql.delete(0, sql.length());
            sql.append("SELECT b_item_billing_subgroup.item_billing_subgroup_number AS item_number, ")
                    .append("length(b_item_billing_subgroup.item_billing_subgroup_number::text) AS len_item_number, ")
                    .append("CASE length(b_item_billing_subgroup.item_billing_subgroup_number::text) ")
                    .append("WHEN 13 THEN '                          '::text ")
                    .append("WHEN 12 THEN '                        '::text ")
                    .append("WHEN 11 THEN '                      '::text ")
                    .append("WHEN 10 THEN '                    '::text ")
                    .append("WHEN 9 THEN '                  '::text ")
                    .append("WHEN 8 THEN '                '::text ")
                    .append("WHEN 7 THEN '              '::text ")
                    .append("WHEN 6 THEN '            '::text ")
                    .append("WHEN 5 THEN '          '::text ")
                    .append("WHEN 4 THEN '        '::text ")
                    .append("WHEN 3 THEN '      '::text ")
                    .append("WHEN 2 THEN '    '::text ")
                    .append("WHEN 1 THEN '  '::text ")
                    .append("WHEN 0 THEN ''::text ELSE NULL::text END AS space1, ")
                    .append("bi.b_item_id, bi.item_common_name, bi.item_descriptione ")
                    .append("FROM b_item bi1 ")
                    .append("LEFT JOIN b_item_billing_subgroup ")
                    .append("ON b_item_billing_subgroup.b_item_billing_subgroup_id::text = bi1.b_item_billing_subgroup_id::text and ")
                    .append("bi1.item_active = '1'  ")
                    .append("LEFT JOIN b_item bi ON b_item_billing_subgroup.item_billing_subgroup_number::text = bi.item_number::text AND ")
                    .append("bi.item_active::text = '0'::text ")
                    .append("WHERE bi1.b_item_id = '").append(b_item_id1).append("' ");
            ResultSet rs_hospital = st_hospital.executeQuery(sql.toString());
            while (rs_hospital.next()) {
                b_item = new BItem();
//                item_number = rs_hospital.getString("item_number");
//                len_item_number = rs_hospital.getString("len_item_number");
//                space1 = rs_hospital.getString("space1");
//                b_item_id = rs_hospital.getString("b_item_id");
//                item_descriptione = rs_hospital.getString("item_descriptione");
//                item_common_name = rs_hospital.getString("item_common_name");
                b_item.setItemDescriptione(config1.StringNull(rs_hospital.getString("item_descriptione")));
                b_item.setItemNumber(config1.StringNull(rs_hospital.getString("item_number")));
                b_item.setItemCommonName(config1.StringNull(rs_hospital.getString("item_common_name")));
                b_item.setBItemId(rs_hospital.getString("b_item_id"));
                b_item.setItemTradeName(rs_hospital.getString("space1"));
                b_item.setItemNamet(rs_hospital.getString("len_item_number"));
            }
            rs_hospital.close();
        }catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b_item;
    }
    private void setSortLineContact(BackTPatientVisitContactBillingItem bpv_cbi, String[] node1) {
        try {
            for (int k = 0; k <= node1.length - 1; k++) {
            if (k == 0) {
              if ((node1[k] != null) && (!node1[k].equals("")))
                bpv_cbi.setSortLine1(Double.parseDouble(node1[k]));
              else
                bpv_cbi.setSortLine1(Double.valueOf(0.0D));
            }
            else if (k == 1) {
              if ((node1[k] != null) && (!node1[k].equals("")))
                bpv_cbi.setSortLine2(Double.parseDouble(node1[k]));
              else {
                bpv_cbi.setSortLine2(0.0);
              }
            }
            if (k == 2) {
              if ((node1[k] != null) && (!node1[k].equals("")))
                bpv_cbi.setSortLine3(Double.parseDouble(node1[k]));
              else {
                bpv_cbi.setSortLine3(0.0);
              }
            }
            if (k == 3) {
              if ((node1[k] != null) && (!node1[k].equals("")))
                bpv_cbi.setSortLine4(Double.parseDouble(node1[k]));
              else {
                bpv_cbi.setSortLine4(0.0);
              }
            }
            if (k == 4)
              if ((node1[k] != null) && (!node1[k].equals("")))
                bpv_cbi.setSortLine5(Double.parseDouble(node1[k]));
              else
                bpv_cbi.setSortLine5(0.0);
            }
        }catch (Exception ex){
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getMainBItemContact(Statement st,BackTPatientVisitContactBillingItem bpvfbi1, String invoice_number, String flagLanguage)  {
//        BackTPatientVisitFundsBillingItem bpvfbi1 = new BackTPatientVisitFundsBillingItem();
        String[] node1 = invoice_number.split("\\.");
        b_item = getBItemSubGroup(st, invoice_number);
//        if (invoice_number.equals("1.1.12.6")) {
          space1.delete(0, space1.length());
//        }
        if (!b_item.getItemNumber().equals("")) {
            if (node1.length == 0)
                space1.append("");
            else if (node1.length == 1)
                space1.append("  ");
            else if (node1.length == 2)
                space1.append("    ");
            else if (node1.length == 3)
                space1.append("      ");
            else if (node1.length == 4)
                space1.append("          ");
            else if (node1.length == 5) {
                space1.append("            ");
            }
            if (flagLanguage.equals("thai"))
                bpvfbi1.setTBillingInvoiceItemNamet(b_item.getItemCommonName());
            else {
                bpvfbi1.setTBillingInvoiceItemNamet(b_item.getItemDescriptione());
            }
            bpvfbi1.setVisitPatientSelfDoctor(space1.toString());
            bpvfbi1.setCode(b_item.getItemNumber());
            bpvfbi1.setSpace1(space1.toString());
        }
//        return bpvfbi1;
    }
    public BItem getBItemSubGroup(Statement st, String item_number) {
    //    String sql = "";
        sql.delete(0, sql.length());
        sql.append("Select item_billing_subgroup_number, item_billing_subgroup_description,item_billing_subgroup_descriptione ")
            .append("From b_item_billing_subgroup ")
            .append("Where item_billing_subgroup_number = '").append(item_number).append("' and item_billing_subgroup_active = '1'");
        try{

        ResultSet rs = st.executeQuery(sql.toString());
        while (rs.next()) {
            b_item = new BItem();
            b_item.setItemNumber(rs.getString("item_billing_subgroup_number"));
            b_item.setItemCommonName(rs.getString("item_billing_subgroup_description"));
            b_item.setItemDescriptione(rs.getString("item_billing_subgroup_descriptione"));
        }
        rs.close();
        }catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b_item;
    }
    private void setNodeHeadContact(BackTPatientVisitContactBillingItem bpvcbi_node_head, BackTPatientVisitContactBillingItem bpvcbi){
        bpvcbi_node_head.setPatientVisitContactBillingId(bpvcbi.getPatientVisitContactBillingId());
        bpvcbi_node_head.setPatientVisitContactItemId(bpvcbi.getPatientVisitContactItemId());
        bpvcbi_node_head.setPatientVisitId(bpvcbi.getPatientVisitId());
        bpvcbi_node_head.setTPatientId(bpvcbi.getTPatientId());
        bpvcbi_node_head.setTPaymentId(bpvcbi.getTPaymentId());

        bpvcbi_node_head.setTPatientId(bpvcbi.getTPatientId());
        bpvcbi_node_head.setVisitHn(bpvcbi.getVisitHn());
        bpvcbi_node_head.setVisitVn(bpvcbi.getVisitVn());
        bpvcbi_node_head.setSysStatus(bpvcbi.getSysStatus());

        bpvcbi_node_head.setBranchId(bpvcbi.getBranchId());
        bpvcbi_node_head.setEditStatus(bpvcbi.getEditStatus());
        bpvcbi_node_head.setVisitId(bpvcbi_node_head.getVisitId());
        bpvcbi_node_head.setBillingInvoiceItemActive(bpvcbi_node_head.getBillingInvoiceItemActive());
        bpvcbi_node_head.setBItemId(bpvcbi_node_head.getBItemId());

        bpvcbi_node_head.setTBillingInvoiceItemId(bpvcbi_node_head.getTBillingInvoiceItemId());
        bpvcbi_node_head.setTOrderItemId(bpvcbi_node_head.getTOrderItemId());
        bpvcbi_node_head.setBItemBillingSubgroupId(bpvcbi_node_head.getBItemBillingSubgroupId());
        bpvcbi_node_head.setVisitPatientSelfDoctor(bpvcbi_node_head.getVisitPatientSelfDoctor());
        bpvcbi_node_head.setClaimId(bpvcbi_node_head.getClaimId());

        bpvcbi_node_head.setClaimNamet(bpvcbi_node_head.getClaimNamet());
        bpvcbi_node_head.setPatientVisitItemId(bpvcbi_node_head.getPatientVisitItemId());
        bpvcbi_node_head.setBillingInvoiceItemActive(bpvcbi_node_head.getBillingInvoiceItemActive());
        bpvcbi_node_head.setTBillingInvoiceDateTime(bpvcbi_node_head.getTBillingInvoiceDateTime());
        bpvcbi_node_head.setTBillingInvoiceTime(bpvcbi_node_head.getTBillingInvoiceTime());

        bpvcbi_node_head.setPatientVisitContactBillingItemActive("1");
        bpvcbi_node_head.setRecordStatus("0");
        bpvcbi_node_head.setPatientVisitContactId(bpvcbi_node_head.getPatientVisitContactId());
        bpvcbi_node_head.setPatientVisitContactBillingId(bpvcbi_node_head.getPatientVisitContactBillingId());
        bpvcbi_node_head.setFItemGroupId(bpvcbi_node_head.getFItemGroupId());
    }
    public void setSavePatientVisitContactStatusBilling(Statement st,String branch_id,
        String bpv_c_id, String billing_number, String bpv_cb_id) {
        String sql = "";
        try {
            sql = "Update " + bpvCdb.bpvC.getBackTPatientVisitContact()
                + " Set " + bpvCdb.bpvC.getFStatusBilling() + "='2', "//ใส่ 2 ได้เลยเพราะ contact ไม่มีการรวม bill
                +bpvCdb.bpvC.getFBillingInvoiceNumber()+"='"+billing_number+"', "
                +bpvCdb.bpvC.getFPatientVisitContactBillingId()+" = '"+bpv_cb_id +"' "
                + "Where " + bpvCdb.bpvC.getFPatientVisitContactId() + "='" + bpv_c_id + "' and "
                +bpvCdb.bpvC.getFStatusBilling()+"='0'";
          st.executeUpdate(sql);
//          conn.close();
        }
        catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitContactBillingStatusDebtorVoid(String branch_id, String bpv_cb_id, String bpv_c_id, String billing_invoice_number) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvCb.getBackTPatientVisitContactBilling()
                  + " Set " + bpvCb.getFStatusPrint() + "='0', "+bpvCb.getFStatusPayment()+"='1', "
                  +bpvCb.getFBillingInvoiceNumber()+"='' "
                  + "Where " + bpvCbI.getFPatientVisitContactBillingId() + "='" + bpv_cb_id + "'";
          st.executeUpdate(sql);
          sql = "Update " + bpvCdb.bpvC.getBackTPatientVisitContact()
                  + " Set " + bpvCdb.bpvC.getFStatusBilling() + "='1', "+bpvCdb.bpvC.getFBillingInvoiceNumber()+"='' "
                  + "Where " + bpvCdb.bpvC.getFBillingInvoiceNumber() + "='" + billing_invoice_number + "'";
          st.executeUpdate(sql);
          sql = "Update " + debtordb.debtor.getBackTDebtor()
                  + " Set " + debtordb.debtor.getFDebtorActive() + "='3' "
                  + "Where " + debtordb.debtor.getFBillingInvoiceNumber() + "='" + billing_invoice_number + "'";
          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdateContactDebtor(Connection conn, Statement st,String branch_id, String paid_id, String bpv_cb_id, 
            String bpv_c_id, Double total, String close_day_date){
        String sql = "",billing_number="",injury_number="",doc_number="",date_current="";
        BDocNumberDB doc_numberdb = new BDocNumberDB();
        Double discount = 0.0;
        try {
            date_current = config1.getDateDBHospital("yyyyMMdd");
//            bpv_cb = getBackTPatientVisitContactBillingByPK(branch_id, bpv_cb_id);
            doc_number = doc_numberdb.getRunningDocNumber(branch_id, conn,paid_id, "back_office");
            debtordb.setSaveDebtor(branch_id, doc_number, "", total, date_current, "14502", "",
                    bpv_cb_id, close_day_date);
            sql = "Update " + bpvCb.getBackTPatientVisitContactBilling()
                    + " Set " + bpvCb.getFStatusPayment() + "='2', "
                    +bpvCb.getFBillingInvoiceNumber()+"='"+doc_number+"' "
                    + "Where " + bpvCb.getFPatientVisitContactBillingId() + "='" + bpv_cb_id + "'";
            st.executeUpdate(sql);
            sql = "Update " + bpvCdb.bpvC.getBackTPatientVisitContact()
                    + " Set " + bpvCdb.bpvC.getFStatusBilling() + "='2', "
                    +bpvCdb.bpvC.getFBillingInvoiceNumber()+"='"+doc_number+"', "+bpvCdb.bpvC.getFPatientVisitContactBillingId()+"='"+bpv_cb_id+"' "
                    + "Where " + bpvCdb.bpvC.getFPatientVisitContactId() + "='" + bpv_c_id + "' ";
            st.executeUpdate(sql);
        //          conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void setUpdateContactDebtor(Statement st,String branch_id, String doctorNumber, String bpv_cb_id, 
            String bpv_c_id, Double total, String close_day_date){
        String sql = "",billing_number="",injury_number="",doc_number="",date_current="";
//        BDocNumberDB doc_numberdb = new BDocNumberDB();
        Double discount = 0.0;
        try {
            date_current = config1.getDateDBHospital("yyyyMMdd");
//            bpv_cb = getBackTPatientVisitContactBillingByPK(branch_id, bpv_cb_id);
//            doc_number = doc_numberdb.getRunningDocNumber(branch_id, conn,paid_id, "back_office");
            debtordb.setSaveDebtor(branch_id, doctorNumber, "", total, date_current, "14502", "",
                    bpv_cb_id, close_day_date);
            sql = "Update " + bpvCb.getBackTPatientVisitContactBilling()
                    + " Set " + bpvCb.getFStatusPayment() + "='2' "
                    + "Where " + bpvCb.getFPatientVisitContactBillingId() + "='" + bpv_cb_id + "'";
            st.executeUpdate(sql);
            sql = "Update " + bpvCdb.bpvC.getBackTPatientVisitContact()
                    + " Set " + bpvCdb.bpvC.getFStatusBilling() + "='2', "
                    +bpvCdb.bpvC.getFBillingInvoiceNumber()+"='"+doctorNumber+"', "+bpvCdb.bpvC.getFPatientVisitContactBillingId()+"='"+bpv_cb_id+"' "
                    + "Where " + bpvCdb.bpvC.getFPatientVisitContactId() + "='" + bpv_c_id + "' ";
            st.executeUpdate(sql);
        //          conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void setUpdatePatientVisitContactBillingStatusPrint(String branch_id, String bpv_cb_id, String status_print) {
        String sql = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpvCb.getBackTPatientVisitContactBilling() + " "
                  + "Set " + bpvCb.getFStatusPrint() + "='" + status_print + "' "
                  + "Where " + bpvCb.getFPatientVisitContactBillingId() + "='" + bpv_cb_id + "' and "
                  + bpvCb.getFBranchId() + "='" + branch_id + "' ";
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdateBackTPatientVisitBillingDiscount(String branch_id, String bpv_fb_id) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "update "+bpvC.getBackTPatientVisitContact()
                + " set visit_discount = (select sum(item_total) from back_t_patient_visit_contact_billing_item "
                +"where patient_visit_contact_billing_id = '"+bpv_fb_id+"' and billing_invoice_number in ('9','999')) ";
          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setDeleteAllBackTPatientVisitContactBillingTemp(String branch_id) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Delete From back_t_patient_visit_contact_billing_temp ";
          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setDeleteAllBackTPatientVisitContactBillingTemp(String branch_id, String status) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Delete From back_t_patient_visit_contact_billing_temp Where status = '"+status+"'";
          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setDeleteBackTPatientVisitContactBillingTemp(String branch_id, String billing_number) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Delete From back_t_patient_visit_contact_billing_temp "
                  + "Where billing_invoice_number = '"+ billing_number+"'";
          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setDeleteBackTPatientVisitContactBillingTemp(String branch_id, String billing_number, String status) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Delete From back_t_patient_visit_contact_billing_temp "
                  + "Where billing_invoice_number = '"+ billing_number+"' and status = '"+status+"'";
          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Vector getBackTPatientVisitContactBillingTemp(String branch_id, String billing_invoice_number) {
        String sql = "", billing_invoice_number_search="";
        Vector v_bpv_fbt = new Vector();
        try {
          Connection conn = config1.getConnectionBangna();
          Statement stbangna = conn.createStatement();
          if(!billing_invoice_number.equals("")){
              billing_invoice_number_search = " Where billing_invoice_number = '"+billing_invoice_number+"'";
          }
          sql = "Select * From back_t_patient_visit_contact_billing_temp "+billing_invoice_number_search ;
          ResultSet rs = stbangna.executeQuery(sql);
          while (rs.next()) {
            bpv_cbt = new BackTPatientVisitContactBillingTemp();
            bpv_cbt.setBillingInvoiceNumber(config1.StringNull(rs.getString("billing_invoice_number")));
            bpv_cbt.setAmount(Double.parseDouble(rs.getString("amount")));
            bpv_cbt.bpvCId = config1.StringNull(rs.getString("patient_visit_contact_id"));
            bpv_cbt.bpvCbId = config1.StringNull(rs.getString("patient_visit_contact_billing_id"));
            bpv_cbt.discountPayment = rs.getDouble("discount_payment");
            bpv_cbt.discountTax = rs.getDouble("discount_tax");
            bpv_cbt.receivePayment = rs.getDouble("receive_payment");
            bpv_cbt.receiveOver = rs.getDouble("receive_over");
            bpv_cbt.remark = config1.StringNull(rs.getString("remark"));

            v_bpv_fbt.add(bpv_cbt);
          }
          rs.close();
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_bpv_fbt;
    }
    public BackTPatientVisitContactBillingTemp getCntSumBackTPatientVisitContactBillingTemp(String branch_id) {
        String sql = "";
        Vector v_bpvcb = new Vector();
        try {
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            sql = "Select count(*) as cnt, sum(amount) as amount From back_t_patient_visit_contact_billing_temp" ;
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpv_cbt = new BackTPatientVisitContactBillingTemp();
                bpv_cbt.setBillingInvoiceNumber(rs.getString("cnt"));
                bpv_cbt.setAmount(Double.parseDouble(rs.getString("amount")));
                v_bpvcb.add(bpv_cbt);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpv_cbt;
    }
//    public String getTrBackTPatientVisitContactBillingTemp(String branch_id, String billing_number, String flag) {
//        String txt="", t_header="", txt_sum="", alert="";
//        Vector v_bpv_fbt = new Vector();
//        if(flag.equals("delete_all")){
//            setDeleteAllBackTPatientVisitContactBillingTemp(branch_id);
//        }else if(flag.equals("delete_item")){
//            setDeleteBackTPatientVisitContactBillingTemp(branch_id, billing_number);
//        }else{
//            v_bpv_fbt = getBackTPatientVisitContactBillingTemp(branch_id,billing_number);
//            if(v_bpv_fbt.size()>0){
//                alert = "<script type='text/javascript' charset='TIS-620'>alert('รหัสซ้ำ');</script>";
//            }else{
//                bpvCb = getBackTPatientVisitContactBillingByPK(branch_id, billing_number,"billing_number");
//                if(bpvCb.getStatusPayment().equals("4")){
//                    alert = "<script type='text/javascript' charset='TIS-620'>alert('รายการนี้รับชำระไปแล้ว');</script>";
//                }else if(bpvCb.getPatientVisitContactBillingId().equals("")){
//                    alert = "<script type='text/javascript' charset='TIS-620'>alert('ไม่พบรหัส');</script>";
//                }else {
//                    setSaveBackTPatientVisitContactBillingTemp(branch_id, billing_number, bpvCb.getVisitTotal());
//                }
//            }
//        }
//        v_bpv_fbt = getBackTPatientVisitContactBillingTemp(branch_id,"");
//        for(int i=0;i<= v_bpv_fbt.size()-1;i++){
//            bpv_cbt = new BackTPatientVisitContactBillingTemp();
//            bpvCb = new BackTPatientVisitContactBilling();
//            bpv_cbt = (BackTPatientVisitContactBillingTemp)v_bpv_fbt.get(i);
//            bpvCb = getBackTPatientVisitContactBillingByPK(branch_id, bpv_cbt.getBillingInvoiceNumber(),"billing_payment");
//            txt+="<tr style='font-size: 12px'>"
//                    + "<td>"+(i+1)+"</td>"
//                    + "<td><label><input type='checkbox' name='chk_"+i+"' id ='chk_"+i+ "' value='' >เลือก</label></td>"
//                    + "<td>"+bpvCb.getBillingInvoiceNumber()+"<input type='hidden' id='txt_"+i+"' value='"+bpvCb.getPatientVisitContactBillingId()+"'/></td>"
//                    + "<td>"+bpvCb.getPatientFullnamet()+"</td>"
//                    + "<td>"+bpvCb.getVisitTotal()+"</td>"
//                    + "<td><input type='text' id='txt_fb_amount"+i+"' value='"+bpvCb.getVisitTotal()+"' size='8'/></td>"
//                    + "<td><input type='text' id='txt_fb_remark"+i+"' size='15'/></td>"
//                    + "</tr>";
//        }
//        bpv_cbt = new BackTPatientVisitContactBillingTemp();
//        bpv_cbt = getCntSumBackTPatientVisitContactBillingTemp(branch_id);
//        t_header="<tr style='font-size: 12px'>"
//                + "<td>ลำดับ</td>"
//                + "<td></td>"
//                + "<td>เลขที่</td>"
//                + "<td>ชื่อ-นามสกุล</td>"
//                + "<td>ยอด</td>"
//                + "<td>รับชำระ</td>"
//                + "<td>หมายเหตุ</td>"
//                + "</tr>";
//        txt_sum = "<table style='font-size: 12px'><tr><td>จำนวนบิล</td>"
//                + "<td><input type='text' id='txt_qty_bill' value='"+bpv_cbt.getBillingInvoiceNumber()+"' size='8' readonly></td>"
//                + "<td>จำนวนเงิน</td><td><input type='text' id='txt_qty_bill' value='"+bpv_cbt.getAmount()+"' size='8' readonly></td></tr></table>";
//        return txt_sum+"<table>"+t_header+txt+"</table>"+alert;
//    }
    public String setSaveBackTPatientVisitBillingTemp(String branch_id, String billing_number, Double visitTotal, String status, String bpvCbId, String statusDebtorVoid) {
        String sql = "";
        Integer chk=0;
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Insert Into back_t_patient_visit_contact_billing_temp "
                  + "(billing_invoice_number, visit_total, status, patient_visit_contact_billing_id, status_debtor_void) "
                  + "Values ('"+billing_number+"',"+visitTotal+",'"+status+"','"+bpvCbId+"','"+statusDebtorVoid+"')";
          chk = st.executeUpdate(sql);
          conn.close();
        }catch(Exception ex){
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
//    public void setSavePayment(String branch_id, BackTBillingPayment bp){
//        Vector v_bpv_fbt = new Vector();
//        String billing_payment_id="", bbpi_id="";
//        try {
//            billing_payment_id = bpdb.setSaveBackTBillingPayment(branch_id, bp);
//            v_bpv_fbt = getBackTPatientVisitContactBillingTemp(branch_id,"");
//            for(int i=0;i<=v_bpv_fbt.size()-1;i++){
//                bpv_cbt = new BackTPatientVisitContactBillingTemp();
//                bpvCb = new BackTPatientVisitContactBilling();
//                bpv_cbt = (BackTPatientVisitContactBillingTemp)v_bpv_fbt.get(i);
//                bpvCb = getBackTPatientVisitContactBillingByPK(branch_id, bpv_cbt.getBillingInvoiceNumber(),"billing_payment");
//                bpdb.bbpi = new BackTBillingPaymentItem();
//                bpdb.bbpi.setBillingPaymentId(billing_payment_id);
//                bpdb.bbpi.setBillingPaymentItemActive("1");
//                bpdb.bbpi.setBillingPaymentItemId("");
//                bpdb.bbpi.setRemark("");
//                bpdb.bbpi.setPatientVisitXBillingId(bpvCb.getPatientVisitContactBillingId());
//                bpdb.bbpi.setAmount(bpv_cbt.getAmount());
//                bpdb.bbpi.setVisitTotal(bpvCb.getVisitTotal());
//                bpdb.bbpi.setPatientVisitId(bpvCb.getPatientVisitId());
//                bpdb.bbpi.setBillingInvoiceNumber(bpvCb.getBillingInvoiceNumber());
//                bpdb.bbpi.setVisitHn(bpvCb.getVisitHn());
//                bpdb.bbpi.setPatientFullnamet(bpvCb.getPatientFullnamet());
//                bpdb.bbpi.setVisitContactJoinId(bpvCb.getVisitContactId());
//                bpdb.bbpi.setVisitContactJoinNamet(bpvCb.getVisitContactNamet());
//
//                bbpi_id=bpdb.setSaveBackTBillingPaymentItem(branch_id, bpdb.bbpi);
//                bpdb.setUpdateBackTPatientContactBilling(branch_id, bbpi_id,bpvCb.getPatientVisitContactBillingId());
//                bpvCdb.setUpdatePatientVisitContactStatusPayment(branch_id, bpvCb.getPatientVisitContactId(), billing_payment_id, "4", bpv_cbt.getAmount());
//                debtordb.setUpdateBackTDebtorPayment(branch_id, bpvCb.getPatientVisitContactBillingId(), bpvCb.getVisitContactId(), "", bpv_cbt.getAmount());
//            }
//            setDeleteAllBackTPatientVisitContactBillingTemp(branch_id);
//        } catch (Exception ex) {
//            Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public String setUpdatePatientVisitContactBilling(String branch_id, String bpv_cb_id, String patient_fullnamet,
            String visit_vn, String visit_hn, String visit_date, String claim_id, String paid_id, String visit_notive,
            String claim_name, String paid_name, String visit_contact_id, String visit_contact_namet, String visit_contact_join_id,
            String visit_contact_join_namet, String injuryNumber, String insuranceNumber) {
        String sql = "";
        Integer chk = 0;
        try{
          patient_fullnamet = patient_fullnamet.replace("'", "''");
          claim_name = claim_name.replace("'", "''");
          paid_name = paid_name.replace("'", "''");
          visit_contact_namet = visit_contact_namet.replace("'", "''");
          visit_contact_join_namet = visit_contact_join_namet.replace("'", "''");
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvCb.getBackTPatientVisitContactBilling()
                  + " Set " + bpvCb.getFPatientFullnamet() + "='" + patient_fullnamet + "',"
                  + bpvCb.getFVisitHn() + "='" + visit_hn + "'," 
                  + bpvCb.getFVisitVn() + "='" + visit_vn + "',"
                  + bpvCb.getFVisitDate() + "='" + visit_date + "'," 
                  + bpvCb.getFVisitClaimId() + "='" + claim_id + "',"
                  + bpvCb.getFVisitPaidId() + "='" + paid_id + "', " 
                  + bpvCb.getFVisitNotice() + "='" + visit_notive + "', "
                  + bpvCb.getFVisitClaimNamet() + "='" + claim_name + "', " 
                  + bpvCb.getFVisitPaidNamet() + "='" + paid_name + "', "
                  + bpvCb.getFVisitContactId() + "='" + visit_contact_id + "', " 
                  + bpvCb.getFVisitContactNamet() + "='" + visit_contact_namet + "', "
                  + bpvCb.getFVisitContactJoinId() + "='" + visit_contact_join_id + "', " 
                  + bpvCb.getFVisitContactJoinNamet() + "='" + visit_contact_join_namet + "', "
                  + bpvCb.getFInjuryNumber() + "='" + injuryNumber + "', "
                  + bpvCb.getFInsuranceNumber() + "='" + insuranceNumber + "' "
                  + "Where " + bpvCb.getFPatientVisitContactBillingId() + "='" + bpv_cb_id + "'";

          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String getTrBillingVoidDebtor(String branch_id, String billing_id, String flag) {
        String node_parent = "", text_h = "", chk_print = "", chk_active = "", script = "", chk_unactive="", cnt="", total="";
        String status_payment="", status_print="";
        StringBuilder txt = new StringBuilder();
        StringBuilder txt_item = new StringBuilder();
        Vector v_billing = new Vector();
        try {
            if(!billing_id.equals("")){
                bpvCb = getBackTPatientVisitContactBillingByPK(branch_id, billing_id, "billing_number");
                //v_billing = getBackTPatientVisitFundsBillingItem(branch_id, bpv_fb.getPatientVisitFundsBillingId(), "bpv_fb_id");
                //for(int i=0;i<=v_billing.size()-1;i++){
                //    bpv_fbi = (BackTPatientVisitFundsBillingItem)v_billing.get(i);
                //    txt_item.append("<tr>")
                //        .append("<td>เลขที่</td> <td><input type='text' id='txt_billing_invoice_number' value='"+bpv_fb.getBillingInvoiceNumber()+"' size='10'>&nbsp;<img src='images/search1.jpeg' alt='' name='billing_search' id='billing_search' border='0' align='button' title='ค้นหา billing...' onclick='searchVoidDebtor()'></td>")
                //}
            }
            if(bpvCb.getPatientVisitContactBillingActive().equals("1")) {
                chk_active="'checked'";
                chk_unactive="";
            }else{
                chk_active="";
                chk_unactive="'checked'";
            }
            if(bpvCb.getStatusPayment().equals("1")){
                status_payment="รวม bill แล้ว รอตั้งหนี้";
            }else if(bpvCb.getStatusPayment().equals("2")){
                status_payment="ตั้งหนี้แล้ว รอรับชำระ";
            }else if(bpvCb.getStatusPayment().equals("4")){
                status_payment="รับชำระแล้ว จบกระบวนการ";
            }else if(bpvCb.getStatusPayment().equals("0")){
                status_payment="เริ่มต้น กระบวนการ";
            }else{
                status_payment="ไม่ระบุสถานะ";
            }
            if(bpvCb.getStatusPrint().equals("1")){
                status_print="   สถานะพิมพ์ พิมพ์ bill แล้ว";
            }else if(bpvCb.getStatusPrint().equals("0")){
                status_print="   สถานะพิมพ์ ยังไม่พิมพ์ bill ";
            }else{
                status_print="   สถานะพิมพ์  ไม่ระบุสถานะ";
            }
            txt.append("<table width='100%'><tr>")
        .append("<tr>")
        .append("<td>เลขที่ billing</td> <td><input type='text' id='txt_billing_invoice_number' value='").append(bpvCb.getBillingInvoiceNumber()).append("' size='12'>&nbsp;<img src='images/search1.jpeg' alt='' name='billing_search' id='billing_search' border='0' align='button' title='ค้นหา billing...' onclick='searchVoidDebtor()'></td>")
        .append("<td>สถานะ</td><td><label><input type='radio' name ='chk_patient_visit_funds_billing_active' id='chk_funds_billing_enable' value='1'").append(chk_active).append(" />ใช้งาน</label>")
        .append("<label><input type='radio' name ='chk_patient_visit_funds_billing_active' id='chk_funds_billing_disable' value='3' ").append(chk_unactive).append("/>ยกเลิกใช้งาน</label></td>")
        .append("</tr>")
        .append("<tr><td>ชื่อ-นามสกุล</td> <td><input type='text' id='txt_patient_fullnamet' value='").append(bpvCb.getPatientFullnamet()).append("' size='30' readonly></td>")
        .append("<td>HN</td> <td><input type='text' id='txt_remark' value='").append(bpvCb.getVisitHn()).append("' size='12' readonly>&nbsp;&nbsp;VN<input type='text' id='txt_remark' value='").append(bpvCb.getVisitVn()).append("' size='12' readonly></td></tr>")
        .append("<tr>")
        .append("<td>จำนวนเงิน</td><td ><input type='text' id='txt_visit_total' value='").append(bpvCb.getVisitTotal()).append("' size='8' readonly>&nbsp;&nbsp;</td>")
        .append("<td colspan='2'>บริษัท<input type='text' id='txt_visit_contact_namet' value='").append(bpvCb.getVisitContactNamet()).append("' size='35' readonly></td>")
        .append("</tr>")
        .append("<tr>")
        .append("<td>อาการ</td><td ><input type='text' id='txt_visit_notice' value='").append(bpvCb.getVisitNotice()).append("' size='30'  readonly></td>")
        .append("<td>sickness</td><td><input type='text' id='txt_sickness' value='").append(bpvCb.getSickness()).append("' size='30' readonly></td>")
        .append("</tr>")
        .append("<tr>")
        .append("<td>invoice number</td><td ><input type='text' id='txt_invoice_number' value='").append(bpvCb.getInvoiceNumber()).append("' size='20' readonly></td>")
        .append("<td>receipt number</td><td><input type='text' id='txt_receipt_number' value='").append(bpvCb.getReceiptNumber()).append("' size='20' readonly></td>")
        .append("</tr>")
        .append("<tr>")
        .append("<td>เลขที่</td><td ><input type='text' id='txt_patient_visit_funds_billing_id' value='").append(bpvCb.getPatientVisitContactBillingId()).append("' size='12' readonly><input type='text' id='txt_patient_visit_funds_id' value='").append(bpvCb.getPatientVisitContactId()).append("' size='12' readonly></td>")
        .append("<td>สิทธิ</td><td><input type='text' id='txt_visit_paid_namet' value='").append(bpvCb.getVisitPaidNamet()).append("' size='20' readonly></td>")
        .append("</tr>")
        .append("<tr>")
        .append("<td>สถานะ bill</td><td colspan='3'>").append(status_payment).append(status_print).append("</td>")
        .append("</tr></table>");
            txt.append(txt_item);
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "<table width='100%'>" + text_h + txt + "<input type='hidden' id='txt_billing_cover_row' value='" + (v_billing.size() - 1) + "'></table>" + script;
    }
    public String getTrPrintCover(String branch_id, String contact_join_id, String visit_hn, String flag) {//pop พิมพ์ซ้ำ
        String node_parent = "", text_h = "", chk_print = "", chk_src = "", script = "", bpv_f_id="", cnt="", total="";
        String contact_namet="";
        StringBuilder txt = new StringBuilder();
//        Connection conn;
        Vector v_billing = new Vector();
        try {
            v_billing = getBackTPatientVisitContactBilling(branch_id,contact_join_id, visit_hn, "", flag);
            for (int i = 0; i <= v_billing.size() - 1; i++) {
                try {
                    node_parent = "chk_" + i;
                    bpvCb = new BackTPatientVisitContactBilling();
                    bpvCb = (BackTPatientVisitContactBilling)v_billing.get(i);
//                    bpv_cb = getCntSumBackTPatientVisitContactBillingItem(branch_id, bpv_cb.getPatientVisitContactBillingId());
//                    if (bpv_cb.getStatusPayment().equals("2")) {
//                        chk_print = "";
//                        chk_src = "images/print_green.png";
//                    }else{
//                        chk_print = "checked";
                        chk_print = "";
                        chk_src = "images/print_orange.png";
//                    }
                    if(bpvCb.getVisitContactNamet().length()>30){
                        contact_namet = bpvCb.getVisitContactNamet().substring(0, 30);
                    }else{
                        contact_namet = bpvCb.getVisitContactNamet();
                    }
                    txt.append("<tr class='style14r'><td align='center'>").append((i + 1)).append("</td>")
            .append("<td><label><input type='checkbox' name='").append(node_parent).append("' id ='").append(node_parent)
            .append("' value='' ").append(chk_print).append(" onchange='chkbillingPrint(").append(i).append(")' >").append(bpvCb.getVisitHn()).append("</label></td>")
            .append("<td>").append(bpvCb.getPatientFullnamet()).append("</td>")
            .append("<td align='center'>").append(bpvCdb.bpvdb.config1.DateFormatDB2Show(bpvCb.getVisitDate(), "ddMMyyyy")).append("</td>")
            .append("<td align='right'>").append(bpvCdb.bpvdb.config1.NumberFormat(bpvCb.getVisitTotal())).append("</td>")
            .append("<td>").append(contact_namet).append("</td>")
            //.append("<td align='right'>").append(bpv_cb.getInjuryNumber()).append("</td>")
            .append("<td><img id='img_").append( i).append("' name = 'img_").append(i).append("' src='").append(chk_src)
                            .append("' alt='' align='top' border='0' title='พิมพ์ billing' onclick='printBilling(").append(i).append(")'/>")
                            .append("<input type='hidden' id='txt_bpv_cb_id").append(i).append("' value='")
                            .append(bpvCb.getPatientVisitContactBillingId()).append("'><input type='hidden' id='txt_cb_amount").append(i)
                            .append("' value='").append(bpvCb.getVisitTotal()).append("'></td></tr>");
                }catch (Exception ex){
                    Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            text_h = "<thead> <tr align='center' class='style14r'>"
                    + "<th align='center'>ลำดับ</th> "
                    + "<th width='90' align='left'>HN</th> "
                    + "<th width='200' align='left'>ชื่อ-นามสกุล</th> "
                    + "<th width='75' align='left'>วันที่รักษา</th> "
                    + "<th width='50' align='left'>มูลค่า</th> "
                    + "<th width='280' align='left'>บริษัท</th> "
                    //+ "<th width='100' align='left'>เลขที่ สบ</th> "
                    + "<th width='40' align='left'>พิมพ์</th> </tr>"
                    + "</thead>";
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "<table width='100%'>" + text_h + txt + "<input type='hidden' id='txt_billing_cover_print_row' value='" + (v_billing.size()) + "'></table>" + script;
    }
    public String setUpdatePatientVisitContactBillingTempAmount(String branchId, String bpvCbId, Double amount, String status) {
        String sql = "";
        Integer chk=0;
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update back_t_patient_visit_contact_billing_temp"
                  + " Set amount ="+amount+ " "
                  + "Where patient_visit_contact_billing_id = '" + bpvCbId + "' and status = '"+status+"'";
          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setUpdatePatientVisitContactBillingTempAmountN(String branchId, String bpvCbId, Double amount, String status,
            Double discountTax, Double discountPayment, Double receicePayment, Double receiveOver) {
        String sql = "";
        Integer chk=0;
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update back_t_patient_visit_contact_billing_temp"
                  + " Set amount ="+amount+ ", "
                  +" discount_tax ="+discountTax+","
                  +" discount_payment ="+discountPayment+","
                  +" receive_payment ="+receicePayment+","
                  +" receive_over ="+receiveOver+" "
                  + "Where patient_visit_contact_billing_id = '" + bpvCbId + "' and status = '"+status+"'";
          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public Integer setUpdatePatientVisitContactStatusPaymentDiscount(String branch_id, String bpvCbId, Double discountTax, Double discountPayment, Double receiveOver) {
        String sql = "";
        int chk = 0;
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpvCb.getBackTPatientVisitContactBilling() 
                + " Set " + bpvCb.getFDiscountPayment() + "=" + discountPayment + ", "
                    + bpvCb.getFDiscountTax() + "=" + discountTax + ", "
                    + bpvCb.getFReceiveOver() + "=" + receiveOver + " "
                + "Where " + bpvCb.getFPatientVisitContactBillingId() + "='" + bpvCbId + "' and " + bpvC.getFBranchId() + "='" + branch_id + "'";
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    public String setUpdatePatientVisitContactStatusPayment(String branchId, String bpvCbId,
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
          sql = "Update " + bpvCb.getBackTPatientVisitContactBilling()//step 1
                  + " Set " + bpvCb.getFBillingPaymentItemId() + "='"+billingPaymentId+"',"
//                  +bpv_f.getFStatusBilling()+"='"+status_payment+"', "
                  +bpvCb.getFReceiveAmount()+"="+bpvCb.getFReceiveAmount()+"+"+receive_amount+", "
                  +bpvCb.getFReceiveDate()+"='"+receive_date+"' "
                  + "Where " + bpvCb.getFPatientVisitContactBillingId() + "='" + bpvCbId + "'";
          row = st.executeUpdate(sql);
          bpvCb = getBackTPatientVisitContactBillingByPK(branchId, bpvCbId, "");//step 2
          if(bpvCb.visitTotal <= bpvCb.receiveAmount){// step3  ต้อง check เพราะจะมี method void จะเข้าใข้ methoed นี้เหมือนกัน
              sql="Update "+bpvCb.getBackTPatientVisitContactBilling()+" Set "+bpvCb.getFStatusPayment()+"='4' "
                      + "Where "+bpvCb.getFPatientVisitContactBillingId()+"='"+bpvCbId+"'";
              row = st.executeUpdate(sql);
              Vector v = new Vector();
//              if(v.isEmpty()){
            chk="4";
          }else{
              chk="2";
          }

          conn.close();
        }catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    public String setUpdatePatientVisitContactBillingStatusPaymentVoid(String branch_id, String bpvCbId,
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
          sql = "Update " + bpvCb.getBackTPatientVisitContactBilling()//step 1
                  + " Set " + bpvCb.getFBillingPaymentItemId() + "='"+billing_payment_id+"',"
//                  +bpv_f.getFStatusBilling()+"='"+status_payment+"', "
                  +bpvCb.getFReceiveAmount()+"="+bpvCb.getFReceiveAmount()+"-"+VoidAmount+", "
//                  +bpvF.getFVoidDate()+"='"+VoidDate+"' "
                  +bpvCb.getFVoidPaymentDate()+"='"+VoidDate+"' "
                  + "Where " + bpvCb.getFPatientVisitContactBillingId() + "='" + bpvCbId + "'";
          chk = st.executeUpdate(sql);
          bpvCb = getBackTPatientVisitContactBillingByPK(branch_id, bpvCbId, "");//step 2
//          if(bpvF.visitTotal <= bpvF.receiveAmount){// step3  ต้อง check เพราะจะมี method void จะเข้าใข้ methoed นี้เหมือนกัน
          if(bpvCb.visitTotal >= bpvCb.receiveAmount){// step3  ต้อง check เพราะจะมี method void จะเข้าใข้ methoed นี้เหมือนกัน
              sql="Update "+bpvCb.getBackTPatientVisitContactBilling()+" Set "+bpvCb.getFStatusPayment()+"='2' "
                      + "Where "+bpvCb.getFPatientVisitContactBillingId()+"='"+bpvCbId+"'";
              chk = st.executeUpdate(sql);
              Vector v = new Vector();
              v = getBackTPatientVisitContactBilling(branch_id,"","", bpvCb.billingInvoiceNumber, "billing_number_status_billing_complete");//ดึงตาม billing แล้ว check ว่ารับชำระหมดแล้วหรือไม่
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
    public String setUpdatePatientVisitContactBillingInjuryNumber(String branchId, String bpvCbId, String injuryNumber) {
        String sql = "";
        Integer chk=0;
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpvCb.getBackTPatientVisitContactBilling() + " "
                  + "Set " + bpvCb.getFInjuryNumber() + "='" + injuryNumber + "' "
                  + "Where " + bpvCb.getFPatientVisitContactBillingId() + "='" + bpvCbId + "' and "
                  + bpvCb.getFBranchId() + "='" + branchId + "' ";
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String getMaxInjuryNumber(String branchId, String depId) {
        String sql = "", max = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Select max(" + bpvCb.getFInjuryNumber() + ") as cnt From " + bpvCb.getBackTPatientVisitContactBilling()
                +" Where "+bpvCb.getFPatientVisitContactBillingActive()+"='1' and "+bpvCb.getFVisitPaidId()+"='"+depId+"' "
                    + " " ;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals(""))){
                max = String.valueOf(Integer.parseInt(max) + 1);
            }else{
                max = "";
            }
            conn.close();
        }catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public List getInjuryMax(String branchId){
        List <BackTBillingCover> list = new ArrayList<BackTBillingCover>();
        String sql="", release="";
        Connection conn, conn1;
        try {
            conn = config1.getConnectionBangna();
            conn1 = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            Statement st1 = conn.createStatement();
            sql = "Select "+bbT.getFPaidId()+" ,"+bbT.getFBDepartmentNamet()
                +" From " +bbT.getBackBTransfer()+" bbT "
                +" Where "+bbT.getFTransferActive()+"='1' and "+bbT.getFBDepartmentId()+"='14502' and "+bbT.getFBranchId()+"='"+branchId+"' ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                bbC = new BackTBillingCover();
                release="";
                bbT.paidId = rs.getString(bbT.getFPaidId());
                sql = "Select "+bbC.getFBillingCoverNumber() +" From "+bbC.getBackTBillingCover()
                    +" Where "+bbC.getFBTransferId()+"='"+bbT.paidId+"'  and "+bbC.getFBranchId()+"='"+branchId+"' "
                    + "Order By "+bbC.getFRecordDatetime()+" desc Limit 1 ";
                ResultSet rs1 = st1.executeQuery(sql);
                while (rs1.next()) {
                    release = rs1.getString(bbC.getFBillingCoverNumber());
                }
                rs1.close();
                bbC.bTransferId = rs.getString(bbT.getFPaidId());
                bbC.billingCoverDescription = rs.getString(bbT.getFBDepartmentNamet());
                bbC.billingCoverNumber = release;
                list.add(bbC);
            }
            rs.close();
            conn.close();
            conn1.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitContactBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
