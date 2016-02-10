/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bangna.objdb;

import bangnaLibrary.BDocNumberDB;
import bangnaLibrary.BItem;
import bangnaLibrary.BackTBillingPaymentDB;
import bangnaLibrary.BackTInjuryDB;
import bangnaLibrary.BackTPatientVisitDB;
import com.bangna.object.BackTPatientVisitFundsBilling;
import com.bangna.object.BackTPatientVisitFundsBillingItem;
import com.bangna.object.BackTPatientVisitFundsBillingTemp;
import bangnaLibrary.ComboDB;
import bangnaLibrary.Config1;
import bangnaLibrary.PatientVisit;
import com.bangna.objdb.BackTDebtorDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class BackTPatientVisitFundsBillingDB {
    Config1 config1;
//    bpv_fdb.bpvdb.config1 bpv_fdb.bpvdb.config1 = new bpv_fdb.bpvdb.config1();
//    private BBranch branch = new BBranch();
    public BackTPatientVisitFundsDB bpv_fdb;
//    private BackTPatientVisitFunds bpv_f = new BackTPatientVisitFunds();
//    private BackTPatientVisitFundsItem bpv_fi = new BackTPatientVisitFundsItem();
    public BackTPatientVisitFundsBilling bpvFb;
    public BackTPatientVisitFundsBillingItem bpv_fbi;
//    private BackTPatientVisitDB bpvdb = new BackTPatientVisitDB();
    private BackTDebtorDB debtordb;
    private BackTPatientVisitFundsBillingTemp bpv_fbt;
//    private BackTBillingPayment bp = new BackTBillingPayment();
//    private BackTBillingPaymentItem bbpi = new BackTBillingPaymentItem();
    private BackTBillingPaymentDB bpdb ;
    private BItem b_item;
    private StringBuilder txt = new StringBuilder();
    private StringBuilder sql = new StringBuilder();
    private StringBuilder space1 = new StringBuilder();
    String idtable="156", idtableItem="159";

    public BackTPatientVisitFundsBillingDB(){
        config1 = new Config1();
        initConfig(config1);
    }
    public BackTPatientVisitFundsBillingDB(Config1 cf){
        config1 = cf;
        initConfig(config1);
    }
    public void initConfig(Config1 cf){
        bpv_fdb = new BackTPatientVisitFundsDB(cf);
        bpvFb = new BackTPatientVisitFundsBilling();
        bpv_fbi = new BackTPatientVisitFundsBillingItem();
        debtordb = new BackTDebtorDB(cf);
        bpv_fbt = new BackTPatientVisitFundsBillingTemp();
        bpdb = new BackTBillingPaymentDB(cf);
        b_item = new BItem();
    }
    public String getMaxRowBackTPatientVisitFundsBilling(Connection conn) {
        String sql = "", max = "";
        try {
            Statement st = conn.createStatement();
            sql = "Select max(" + bpvFb.getFPatientVisitFundsBillingId() + ") as cnt From " + bpvFb.getBackTPatientVisitFundsBilling();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))
                max = String.valueOf(Integer.parseInt(max) + 1);
            else
                max = "1560000001";
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowBackTPatientVisitFundsBillingItem(Statement st) {
        String sql = "", max = "";
        try {
            //      Statement st = conn.createStatement();
            sql = "Select max(" + bpv_fbi.getFPatientVisitFundsBillingItemId() + ") as cnt " + "From " + bpv_fbi.getBackTPatientVisitFundsBillingItem();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals(""))) {
                max = String.valueOf(Integer.parseInt(max) + 1);
            } else
            max = "1590000001";
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public BackTPatientVisitFundsBilling getBackTPatientVisitFundsBillingByPK(String branch_id, String bpv_fb_id,
          String flag) {
        String sql = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            if(flag.equals("billing_payment")){
                sql = "Select * "
                +"From "+bpvFb.getBackTPatientVisitFundsBilling() + " "
                +"Where "+bpvFb.getFBillingInvoiceNumber() + "='" + bpv_fb_id + "' and "
                +bpvFb.getFStatusPayment()+"='2' ";
            }else if(flag.equals("billing_number")){
                sql = "Select * "
                +"From "+bpvFb.getBackTPatientVisitFundsBilling() + " "
                +"Where "+bpvFb.getFBillingInvoiceNumber() + "='" + bpv_fb_id + "' ";
            }else if(flag.equals("billing_paymented")){
                sql = "Select * "
                +"From "+bpvFb.getBackTPatientVisitFundsBilling() + " "
                +"Where "+bpvFb.getFPatientVisitFundsBillingId() + "='" + bpv_fb_id + "' and "
                +bpvFb.getFStatusPayment()+"='4' ";
            }else if(flag.equals("injury_number")){
                sql = "Select * "
                +"From "+bpvFb.getBackTPatientVisitFundsBilling() + " "
                +"Where "+bpvFb.getFInjuryNumber() + "='" + bpv_fb_id + "' and "
                +bpvFb.getFPatientVisitFundsBillingActive()+"='1' ";
            }else if (flag.equals("bill_visit_id")){
                sql = "Select * "
                +"From "+bpvFb.getBackTPatientVisitFundsBilling() + " "
                +"Where "+bpvFb.getFVisitVn() + "='" + bpv_fb_id + "' and "+bpvFb.getFRecordStatus()+" = '2' and "
                +bpvFb.getFPatientVisitFundsBillingActive()+"='1' ";
            }else if (flag.equals("bpvFId")){
                sql = "Select * "
                +"From "+bpvFb.getBackTPatientVisitFundsBilling() + " "
                +"Where "+bpvFb.getFPatientVisitFundsId() + "='" + bpv_fb_id + "' and "
                +bpvFb.getFPatientVisitFundsBillingActive()+"='1' ";
            }else{
                sql = "Select * From " + bpvFb.getBackTPatientVisitFundsBilling() + " "
                  + "Where " + bpvFb.getFPatientVisitFundsBillingId() + "='" + bpv_fb_id + "'";
            }
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpvFb = new BackTPatientVisitFundsBilling();
                bpvFb.setBServicePointId(config1.StringNull(rs.getString(bpvFb.getFBServicePointId())));
                bpvFb.setBVisitClinicId(config1.StringNull(rs.getString(bpvFb.getFBVisitClinicId())));
                bpvFb.setVisitClaimId(config1.StringNull(rs.getString(bpvFb.getFVisitClaimId())));
                bpvFb.setVisitPaidId(config1.StringNull(rs.getString(bpvFb.getFVisitPaidId())));
                bpvFb.setPatientFullnamet(config1.StringNull(rs.getString(bpvFb.getFPatientFullnamet())));

                bpvFb.setPatientVisitId(config1.StringNull(rs.getString(bpvFb.getFPatientVisitId())));
                bpvFb.setTPatientId(config1.StringNull(rs.getString(bpvFb.getFTPatientId())));
                bpvFb.setVisitBeginVisitTime(config1.StringNull(rs.getString(bpvFb.getFVisitBeginVisitTime())));
                bpvFb.setVisitDate(config1.StringNull(rs.getString(bpvFb.getFVisitDate())));
                bpvFb.setVisitDiagnosisNotice(config1.StringNull(rs.getString(bpvFb.getFVisitDiagnosisNotice())));

                bpvFb.setVisitFinancialDischargeTime(config1.StringNull(rs.getString(bpvFb.getFVisitFinancialDischargeTime())));
                bpvFb.setVisitFirstVisit(config1.StringNull(rs.getString(bpvFb.getFVisitFirstVisit())));
                bpvFb.setVisitHn(config1.StringNull(rs.getString(bpvFb.getFVisitHn())));
                bpvFb.setVisitHospitalService(config1.StringNull(rs.getString(bpvFb.getFVisitHospitalService())));
                bpvFb.setVisitNotice(config1.StringNull(rs.getString(bpvFb.getFVisitNotice())));

                bpvFb.setVisitPatientAge(config1.StringNull(rs.getString(bpvFb.getFVisitPatientAge())));
                bpvFb.setVisitPatientSelfDoctor(config1.StringNull(rs.getString(bpvFb.getFVisitPatientSelfDoctor())));
                bpvFb.setVisitVn(config1.StringNull(rs.getString(bpvFb.getFVisitVn())));
                bpvFb.setVisitClaimNamet(config1.StringNull(rs.getString(bpvFb.getFVisitClaimNamet())));
                bpvFb.setVisitPaidNamet(config1.StringNull(rs.getString(bpvFb.getFVisitPaidNamet())));

                bpvFb.setDepartmentNamet(config1.StringNull(rs.getString(bpvFb.getFDepartmentNamet())));
                bpvFb.setDoctorNamet(config1.StringNull(rs.getString(bpvFb.getFDoctorNamet())));
                bpvFb.setPatientImportId(config1.StringNull(rs.getString(bpvFb.getFPatientImportId())));
                bpvFb.setBranchId(config1.StringNull(rs.getString(bpvFb.getFBranchId())));
                bpvFb.setSysStatus(config1.StringNull(rs.getString(bpvFb.getFSysStatus())));

                if(rs.getString(bpvFb.getFVisitPaid()) != null){
                    bpvFb.setVisitPaid(rs.getDouble(bpvFb.getFVisitPaid()));
                }
                if(rs.getString(bpvFb.getFVisitTotal()) != null){
                    bpvFb.setVisitTotal(rs.getDouble(bpvFb.getFVisitTotal()));
                }
                if(rs.getString(bpvFb.getFVisitDiscount()) != null){
                    bpvFb.setVisitDiscount(rs.getDouble(bpvFb.getFVisitDiscount()));
                }
                bpvFb.setBillingCoverNumber(config1.StringNull(rs.getString(bpvFb.getFBillingCoverNumber())));
                bpvFb.setVisitContactId(config1.StringNull(rs.getString(bpvFb.getFVisitContactId())));

                bpvFb.setVisitContactNamet(config1.StringNull(rs.getString(bpvFb.getFVisitContactNamet())));
                bpvFb.setPatientVisitFundsId(config1.StringNull(rs.getString(bpvFb.getFPatientVisitFundsId())));
                bpvFb.setPatientVisitFundsBillingActive(config1.StringNull(rs.getString(bpvFb.getFPatientVisitFundsBillingActive())));
                bpvFb.setStatusPrint(config1.StringNull(rs.getString(bpvFb.getFStatusPrint())));
                bpvFb.setStatusPayment(config1.StringNull(rs.getString(bpvFb.getFStatusPayment())));

                bpvFb.setBillingInvoiceNumber(config1.StringNull(rs.getString(bpvFb.getFBillingInvoiceNumber())));
                bpvFb.setPatientVisitFundsBillingId(config1.StringNull(rs.getString(bpvFb.getFPatientVisitFundsBillingId())));
                bpvFb.setSickness(config1.StringNull(rs.getString(bpvFb.getFSickness())));
                bpvFb.setInvoiceNumber(config1.StringNull(rs.getString(bpvFb.getFInvoiceNumber())));
                bpvFb.setReceiptNumber(config1.StringNull(rs.getString(bpvFb.getFReceiptNumber())));

                bpvFb.setVisitTotalBaht(config1.StringNull(rs.getString(bpvFb.getFVisitTotalBaht())));
                bpvFb.setInjuryNumber(config1.StringNull(rs.getString(bpvFb.getFInjuryNumber())));
                bpvFb.setRecordStatus(config1.StringNull(rs.getString(bpvFb.getFRecordStatus())));
                bpvFb.statusDebtorVoid = config1.StringNull(rs.getString(bpvFb.getFStatusDebtorVoid()));
                bpvFb.cntDebtorVoid = config1.StringNull(rs.getString(bpvFb.getFCntDebtorVoid()));
                
                bpvFb.remark = config1.StringNull(rs.getString(bpvFb.getFRemark()));
            }

            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpvFb;
    }
    public Vector getBackTPatientVisitFundsBilling(String branch_id, String bpv_fb_id, String where, String flagpage) {
        String sql = "", hn_search="";
        Vector v_bpvfb = new Vector();
        try {
            if(!where.equals("")){
                hn_search = " and "+bpvFb.getFVisitHn()+" like '%"+where+"' ";
            }
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            if (flagpage.equals("status_billing_yes")){
                sql = "Select * "
                    + "From " + bpvFb.getBackTPatientVisitFundsBilling() + " "
                    + "Where " + bpvFb.getFStatusPrint() + "='0' and "
                    + bpvFb.getFPatientVisitFundsBillingActive() + "='1' and "
                    + bpvFb.getFBranchId() + "='" + branch_id + "' "
                    + "Order By " + bpvFb.getFPatientVisitFundsBillingId() + " asc";
            }else if(flagpage.equals("status_billing_in")){
                sql = "Select * "
                    + "From " + bpvFb.getBackTPatientVisitFundsBilling() + " "
                    + "Where " + bpvFb.getFStatusPrint() + "='0' and "
                    + bpvFb.getFPatientVisitFundsBillingActive() + "='1' and "
                    + bpvFb.getFBranchId() + "='" + branch_id + "' and "
                    +bpvFb.getFPatientVisitFundsId()+" in ("+bpv_fb_id+") "
                    + "Order By " + bpvFb.getFPatientVisitFundsBillingId() + " asc";
            }else if(flagpage.equals("billing_no_debtor")){
                sql = "Select * "
                    + "From " + bpvFb.getBackTPatientVisitFundsBilling() + " "
                    + "Where " + bpvFb.getFStatusPayment() + "='1' and "
                    + bpvFb.getFPatientVisitFundsBillingActive() + "='1' and "+bpvFb.getFRecordStatus()+" = '1' and "//เรื่อง bill ตาม visit เวลาตั้งหนี้
                    + bpvFb.getFBranchId() + "='" + branch_id + "' "+hn_search
                    + "Order By " + bpvFb.getFPatientVisitFundsBillingId() + " asc";
            }else if(flagpage.equals("debtor_no_print")){
                sql = "Select * "
                    + "From " + bpvFb.getBackTPatientVisitFundsBilling() + " "
                    + "Where " + bpvFb.getFStatusPayment() + "='2' and "
                    + bpvFb.getFPatientVisitFundsBillingActive() + "='1' and "
                    + bpvFb.getFBranchId() + "='" + branch_id + "' and " +bpvFb.getFStatusPrint()+"='0' "
                    + "Order By " + bpvFb.getFPatientVisitFundsBillingId() + " asc";
            }else if(flagpage.equals("debtor_yes_print")){
                sql = "Select * "
                    + "From " + bpvFb.getBackTPatientVisitFundsBilling() + " "
                    + "Where " + bpvFb.getFStatusPayment() + "= '2' and "
                    + bpvFb.getFPatientVisitFundsBillingActive() + "= '1' and "
                    + bpvFb.getFBranchId() + "='" + branch_id + "' and "+bpvFb.getFStatusPrint()+"='0' "
                    + "Order By " + bpvFb.getFPatientVisitFundsBillingId() + " asc";
            }else if(flagpage.equals("print_cover")){
                String date_search="";
                if(!bpv_fb_id.equals("")){
                    date_search = " and "+bpvFb.getFVisitDate()+" <= '"+bpv_fb_id+"' ";
                }
                sql = "Select * "
                    + "From " + bpvFb.getBackTPatientVisitFundsBilling() + " "
                    + "Where " + bpvFb.getFStatusPayment() + "='2' and "
                    + bpvFb.getFPatientVisitFundsBillingActive() + "='1' and "
                    + bpvFb.getFBranchId() + "='" + branch_id + "' and "+bpvFb.getFStatusPrint()+"='0' "+hn_search +date_search
                    + "Order By " + bpvFb.getFPatientVisitFundsBillingId() + " asc";
            }else if(flagpage.equals("search_cover_billing")){
                sql = "Select * "
                    + "From " + bpvFb.getBackTPatientVisitFundsBilling() + " "
                    + "Where " + bpvFb.getFBillingInvoiceNumber() + "= '"+bpv_fb_id+"' and "
                    + bpvFb.getFPatientVisitFundsBillingActive() + "= '1' and "
                    + bpvFb.getFBranchId() + "='" + branch_id + "' "
                    + "Order By " + bpvFb.getFPatientVisitFundsBillingId() + " asc";
            }else if(flagpage.equals("debtor_no_payment_by_hn")){
                sql = "Select * "
                    + "From " + bpvFb.getBackTPatientVisitFundsBilling() + " "
                    + "Where " + bpvFb.getFStatusPayment() + "= '2' and "
                    + bpvFb.getFPatientVisitFundsBillingActive() + "= '1' and "
                    + bpvFb.getFBranchId() + "='" + branch_id + "' and "+bpvFb.getFVisitHn()+"='"+bpv_fb_id+"' "
                    + "Order By " + bpvFb.getFPatientVisitFundsBillingId() + " asc";
            }else{
                sql = "Select * From " + bpvFb.getBackTPatientVisitFundsBilling() + " "
                        + "Where " + bpvFb.getFPatientVisitFundsBillingId() + "='" + bpv_fb_id + "'";
            }
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpvFb = new BackTPatientVisitFundsBilling();
                bpvFb.setBServicePointId(config1.StringNull(rs.getString(bpvFb.getFBServicePointId())));
                bpvFb.setBVisitClinicId(config1.StringNull(rs.getString(bpvFb.getFBVisitClinicId())));
                bpvFb.setVisitClaimId(config1.StringNull(rs.getString(bpvFb.getFVisitClaimId())));
                bpvFb.setVisitPaidId(config1.StringNull(rs.getString(bpvFb.getFVisitPaidId())));
                bpvFb.setPatientFullnamet(config1.StringNull(rs.getString(bpvFb.getFPatientFullnamet())));

                bpvFb.setPatientVisitId(config1.StringNull(rs.getString(bpvFb.getFPatientVisitId())));
                bpvFb.setTPatientId(config1.StringNull(rs.getString(bpvFb.getFTPatientId())));
                bpvFb.setVisitBeginVisitTime(config1.StringNull(rs.getString(bpvFb.getFVisitBeginVisitTime())));
                bpvFb.setVisitDate(config1.StringNull(rs.getString(bpvFb.getFVisitDate())));
                bpvFb.setVisitDiagnosisNotice(config1.StringNull(rs.getString(bpvFb.getFVisitDiagnosisNotice())));

                bpvFb.setVisitFinancialDischargeTime(config1.StringNull(rs.getString(bpvFb.getFVisitFinancialDischargeTime())));
                bpvFb.setVisitFirstVisit(config1.StringNull(rs.getString(bpvFb.getFVisitFirstVisit())));
                bpvFb.setVisitHn(config1.StringNull(rs.getString(bpvFb.getFVisitHn())));
                bpvFb.setVisitHospitalService(config1.StringNull(rs.getString(bpvFb.getFVisitHospitalService())));
                bpvFb.setVisitNotice(config1.StringNull(rs.getString(bpvFb.getFVisitNotice())));

                bpvFb.setVisitPatientAge(config1.StringNull(rs.getString(bpvFb.getFVisitPatientAge())));
                bpvFb.setVisitPatientSelfDoctor(config1.StringNull(rs.getString(bpvFb.getFVisitPatientSelfDoctor())));
                bpvFb.setVisitVn(config1.StringNull(rs.getString(bpvFb.getFVisitVn())));
                bpvFb.setVisitClaimNamet(config1.StringNull(rs.getString(bpvFb.getFVisitClaimNamet())));
                bpvFb.setVisitPaidNamet(config1.StringNull(rs.getString(bpvFb.getFVisitPaidNamet())));

                bpvFb.setDepartmentNamet(config1.StringNull(rs.getString(bpvFb.getFDepartmentNamet())));
                bpvFb.setDoctorNamet(config1.StringNull(rs.getString(bpvFb.getFDoctorNamet())));
                bpvFb.setPatientImportId(config1.StringNull(rs.getString(bpvFb.getFPatientImportId())));
                bpvFb.setBranchId(config1.StringNull(rs.getString(bpvFb.getFBranchId())));
                bpvFb.setSysStatus(config1.StringNull(rs.getString(bpvFb.getFSysStatus())));                
                if(rs.getString(bpvFb.getFVisitPaid()) !=null){
                    bpvFb.setVisitPaid(rs.getDouble(bpvFb.getFVisitPaid()));
                }else{
                    bpvFb.setVisitPaid(0.0);
                }
                if(rs.getString(bpvFb.getFVisitTotal()) !=null){
                    bpvFb.setVisitTotal(rs.getDouble(bpvFb.getFVisitTotal()));
                }else{
                    bpvFb.setVisitTotal(0.0);
                }
                if(rs.getString(bpvFb.getFVisitDiscount()) !=null){
                    bpvFb.setVisitDiscount(rs.getDouble(bpvFb.getFVisitDiscount()));
                }else{
                    bpvFb.setVisitDiscount(0.0);
                }
                
                bpvFb.setBillingCoverNumber(config1.StringNull(rs.getString(bpvFb.getFBillingCoverNumber())));
                bpvFb.setVisitContactId(config1.StringNull(rs.getString(bpvFb.getFVisitContactId())));

                bpvFb.setVisitContactNamet(config1.StringNull(rs.getString(bpvFb.getFVisitContactNamet())));
                bpvFb.setPatientVisitFundsId(config1.StringNull(rs.getString(bpvFb.getFPatientVisitFundsId())));
                bpvFb.setPatientVisitFundsBillingActive(config1.StringNull(rs.getString(bpvFb.getFPatientVisitFundsBillingActive())));
                bpvFb.setStatusPrint(config1.StringNull(rs.getString(bpvFb.getFStatusPrint())));
                bpvFb.setStatusPayment(config1.StringNull(rs.getString(bpvFb.getFStatusPayment())));

                bpvFb.setBillingInvoiceNumber(config1.StringNull(rs.getString(bpvFb.getFBillingInvoiceNumber())));
                bpvFb.setPatientVisitFundsBillingId(config1.StringNull(rs.getString(bpvFb.getFPatientVisitFundsBillingId())));
                bpvFb.setSickness(config1.StringNull(rs.getString(bpvFb.getFSickness())));
                bpvFb.setInvoiceNumber(config1.StringNull(rs.getString(bpvFb.getFInvoiceNumber())));
                bpvFb.setReceiptNumber(config1.StringNull(rs.getString(bpvFb.getFReceiptNumber())));

                bpvFb.setVisitTotalBaht(config1.StringNull(rs.getString(bpvFb.getFVisitTotalBaht())));
                bpvFb.setInjuryNumber(config1.StringNull(rs.getString(bpvFb.getFInjuryNumber())));
                bpvFb.setRecordStatus(config1.StringNull(rs.getString(bpvFb.getFRecordStatus())));
                bpvFb.statusDebtorVoid = config1.StringNull(rs.getString(bpvFb.getFStatusDebtorVoid()));
                bpvFb.cntDebtorVoid = config1.StringNull(rs.getString(bpvFb.getFCntDebtorVoid()));
                
                bpvFb.remark = config1.StringNull(rs.getString(bpvFb.getFRemark()));

                v_bpvfb.add(bpvFb);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_bpvfb;
    }
    public String setSaveBackTPatientVisitFundsBilling(String branch_id, BackTPatientVisitFundsBilling item) throws Exception {
    int chk = 0;
    String sql = "", max = "";
    try {
        Connection conn = config1.getConnectionBangna();
        Statement st = conn.createStatement();
//        bpv_fb.initial();
        bpvFb = getBackTPatientVisitFundsBillingByPK(branch_id, item.getPatientVisitFundsBillingId(),"");
        item.setPatientFullnamet(config1.StringNull(item.getPatientFullnamet()).replace("'", "''"));
        item.setVisitNotice(config1.StringNull(item.getVisitNotice()).replace("'", "''"));
        item.setVisitDiagnosisNotice(config1.StringNull(item.getVisitDiagnosisNotice()).replace("'", "''"));
        if (bpvFb.getPatientVisitFundsBillingId().equals("")) {
            item.generateOID(idtable);
            max = item.getObjectId();
//        max = getMaxRowBackTPatientVisitFundsBilling(conn);
        sql = "Insert Into " + bpvFb.getBackTPatientVisitFundsBilling()
                +"("+bpvFb.getFPatientVisitFundsBillingId() + ", " + bpvFb.getFBServicePointId() + ", "
                + bpvFb.getFBVisitClinicId() + "," + bpvFb.getFVisitClaimId() + ","
                + bpvFb.getFVisitPaidId() + "," + bpvFb.getFPatientFullnamet() + ","
                + bpvFb.getFPatientImportId() + "," + bpvFb.getFTPatientId() + ","
                + bpvFb.getFVisitBeginVisitTime() + "," + bpvFb.getFVisitDate() + ","
                + bpvFb.getFVisitDiagnosisNotice() + "," + bpvFb.getFVisitFinancialDischargeTime() + ","
                + bpvFb.getFVisitFirstVisit() + "," + bpvFb.getFVisitHn() + ","
                + bpvFb.getFVisitHospitalService() + "," + bpvFb.getFVisitNotice() + ", "
                + bpvFb.getFVisitPatientAge() + "," + bpvFb.getFVisitPatientSelfDoctor() + ", "
                + bpvFb.getFVisitVn() + "," + bpvFb.getFVisitClaimNamet() + ","
                + bpvFb.getFVisitPaidNamet() + "," + bpvFb.getFDepartmentNamet() + ","
                + bpvFb.getFDoctorNamet() + "," + bpvFb.getFBranchId() + ","
                + bpvFb.getFSysStatus() + "," + bpvFb.getFPatientVisitId() + ","
                + bpvFb.getFVisitContactId() + "," + bpvFb.getFVisitContactNamet() + ","
                + bpvFb.getFPatientVisitFundsBillingActive() + "," + bpvFb.getFPatientVisitFundsId() + ","
                + bpvFb.getFSickness() + "," + bpvFb.getFInjuryNumber() + ","
                + bpvFb.getFReceiptNumber() + "," + bpvFb.getFVisitTotal() + ","
                + bpvFb.getFVisitDiscount() + "," + bpvFb.getFVisitPaid() + ","
                + bpvFb.getFVisitTotalBaht() + "," + bpvFb.getFInvoiceNumber() + ","
                + bpvFb.getFStatusPayment() + "," + bpvFb.getFStatusPrint() + ","
                + bpvFb.getFBillingInvoiceNumber()+","+bpvFb.getFRecordStatus()+") "
                + "Values('" + max + "','" + item.getBServicePointId() + "','"
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
                + item.getPatientVisitFundsBillingActive() + "','" + item.getPatientVisitFundsId() + "','"
                + item.getSickness() + "','" + item.getInjuryNumber() + "','"
                + item.getReceiptNumber() + "'," + item.getVisitTotal() + ","
                + item.getVisitDiscount() + "," + item.getVisitPaid() + ",'"
                + item.getVisitTotalBaht() + "','" + item.getInvoiceNumber() + "','"
                + item.getStatusPayment() + "','" + item.getStatusPrint() + "','"
                + item.getBillingInvoiceNumber()+"','"+item.getRecordStatus()+"')";
        }else{
            sql = "Update " + bpvFb.getBackTPatientVisitFundsBilling()
                + " set " + bpvFb.getFBServicePointId() + " = '" + item.getBServicePointId() + "', "
                + bpvFb.getFBVisitClinicId() + " = '" + item.getBVisitClinicId() + "', "
                + bpvFb.getFVisitClaimId() + " = '" + item.getVisitClaimId() + "', "
                + bpvFb.getFVisitPaidId() + " = '" + item.getVisitPaidId() + "', "
                + bpvFb.getFPatientFullnamet() + " = '" + item.getPatientFullnamet() + "', "
                + bpvFb.getFPatientImportId() + " = '" + item.getPatientImportId() + "', "
                + bpvFb.getFTPatientId() + " = '" + item.getTPatientId() + "', "
                + bpvFb.getFVisitBeginVisitTime() + " = '" + item.getVisitBeginVisitTime() + "', "
                + bpvFb.getFVisitDate() + " = '" + item.getVisitDate() + "', "
                + bpvFb.getFVisitDiagnosisNotice() + " = '" + item.getVisitDiagnosisNotice() + "',"
                + bpvFb.getFVisitFinancialDischargeTime() + " = '" + item.getVisitFinancialDischargeTime() + "',"
                + bpvFb.getFVisitFirstVisit() + " = '" + item.getVisitFirstVisit() + "', "
                + bpvFb.getFVisitHn() + " = '" + item.getVisitHn() + "', "
                + bpvFb.getFVisitHospitalService() + " = '" + item.getVisitHospitalService() + "', "
                + bpvFb.getFVisitNotice() + " = '" + item.getVisitNotice() + "', "
                + bpvFb.getFVisitPatientAge() + " = " + item.getVisitPatientAge() + ", "
                + bpvFb.getFVisitPatientSelfDoctor() + " = '" + item.getVisitPatientSelfDoctor() + "', "
                + bpvFb.getFVisitVn() + " = '" + item.getVisitVn() + "', "
                + bpvFb.getFVisitClaimNamet() + " = '" + item.getVisitClaimNamet() + "', "
                + bpvFb.getFVisitPaidNamet() + " = '" + item.getVisitPaidNamet() + "', "
                + bpvFb.getFDepartmentNamet() + " = '" + item.getDepartmentNamet() + "', "
                + bpvFb.getFDoctorNamet() + " = '" + item.getDoctorNamet() + "', "
                + bpvFb.getFBranchId() + " = '" + item.getBranchId() + "', "
                + bpvFb.getFSysStatus() + " = '" + item.getSysStatus() + "', "
                + bpvFb.getFPatientVisitId() + " = '" + item.getPatientVisitId() + "', "
                + bpvFb.getFVisitContactId() + " = '" + item.getVisitContactId() + "', "
                + bpvFb.getFVisitContactNamet() + " = '" + item.getVisitContactNamet() + "', "
                + bpvFb.getFPatientVisitFundsBillingActive() + " = '" + item.getPatientVisitFundsBillingActive() + "', "
                + bpvFb.getFVisitTotal() + " = " + item.getVisitTotal() + ", "
                + bpvFb.getFVisitPaid() + " = " + item.getVisitPaid() + ", "
                + bpvFb.getFVisitDiscount() + " = " + item.getVisitDiscount() + ", "
                + bpvFb.getFBillingCoverNumber() + " = '" + item.getBillingCoverNumber() + "', "
                + bpvFb.getFBillingInvoiceNumber() + " = '" + item.getBillingInvoiceNumber() + "', "
                + bpvFb.getFStatusPayment() + " = '" + item.getStatusPayment() + "', "
                + bpvFb.getFStatusPrint() + " = '" + item.getStatusPrint() + "', "
                + bpvFb.getFSickness() + " = '" + item.getSickness() + "', "
                + bpvFb.getFInvoiceNumber() + " = '" + item.getInvoiceNumber() + "', "
                + bpvFb.getFReceiptNumber() + " = '" + item.getReceiptNumber() + "', "
                + bpvFb.getFVisitTotalBaht() + " = '" + item.getVisitTotalBaht() + "', "
                + bpvFb.getFRecordStatus() + " = '" + item.getRecordStatus() + "' "
                + "Where " + bpvFb.getFPatientVisitFundsBillingId() + " = '" + item.getPatientVisitFundsBillingId() + "'";

            max = item.getPatientVisitId();
        }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public BackTPatientVisitFundsBillingItem getBackTPatientVisitFundsBillingItemByPK(String branch_id, 
            String patient_visit_funds_billing_itemid) {
    String sql = "";
    try {
      Connection conn = config1.getConnectionBangna();
      Statement stbangna = conn.createStatement();
          sql = "Select * From " + bpv_fbi.getBackTPatientVisitFundsBillingItem() + " "
              + "Where " + bpv_fbi.getFPatientVisitFundsBillingItemId() + "='" + patient_visit_funds_billing_itemid + "'";
      
      ResultSet rs = stbangna.executeQuery(sql);
      while (rs.next()) {
          bpv_fbi = new BackTPatientVisitFundsBillingItem();
        bpv_fbi.setBItemBillingSubgroupId(rs.getString(bpv_fbi.getFBItemBillingSubgroupId()));
        bpv_fbi.setBItemId(rs.getString(bpv_fbi.getFBItemId()));
        bpv_fbi.setBillingInvoiceItemActive(rs.getString(bpv_fbi.getFBillingInvoiceItemActive()));
        bpv_fbi.setBillingInvoiceItemTotal(rs.getDouble(bpv_fbi.getFBillingInvoiceItemTotal()));
        bpv_fbi.setBillingInvoiceNumber(rs.getString(bpv_fbi.getFBillingInvoiceNumber()));

        bpv_fbi.setClaimId(rs.getString(bpv_fbi.getFClaimId()));
        bpv_fbi.setClaimNamet(rs.getString(bpv_fbi.getFClaimNamet()));
        bpv_fbi.setDepartmentNamet(rs.getString(bpv_fbi.getFDepartmentNamet()));
        bpv_fbi.setPatientVisitFundsItemId(rs.getString(bpv_fbi.getFPatientVisitFundsItemId()));
        bpv_fbi.setPatientVisitId(rs.getString(bpv_fbi.getFPatientVisitId()));

        bpv_fbi.setTBillingId(rs.getString(bpv_fbi.getFTBillingId()));
        bpv_fbi.setTBillingInvoiceDateTime(rs.getString(bpv_fbi.getFTBillingInvoiceDateTime()));
        bpv_fbi.setTBillingInvoiceItemId(rs.getString(bpv_fbi.getFTBillingInvoiceItemId()));
        bpv_fbi.setTBillingInvoiceItemNamet(rs.getString(bpv_fbi.getFTBillingInvoiceItemNamet()));
        bpv_fbi.setTBillingInvoiceTime(rs.getString(bpv_fbi.getFTBillingInvoiceTime()));

        bpv_fbi.setTOrderItemId(rs.getString(bpv_fbi.getFTOrderItemId()));
        bpv_fbi.setTPatientId(rs.getString(bpv_fbi.getFTPatientId()));
        bpv_fbi.setTPaymentId(rs.getString(bpv_fbi.getFTPaymentId()));
        bpv_fbi.setVisitId(rs.getString(bpv_fbi.getFVisitId()));
        bpv_fbi.setVisitPatientSelfDoctor(rs.getString(bpv_fbi.getFVisitPatientSelfDoctor()));

        bpv_fbi.setVisitVn(rs.getString(bpv_fbi.getFVisitVn()));
        bpv_fbi.setDepartmentId(rs.getString(bpv_fbi.getFDepartmentId()));
        bpv_fbi.setVisitHn(rs.getString(bpv_fbi.getFVisitHn()));
        bpv_fbi.setBranchId(config1.StringNull(rs.getString(bpv_fbi.getFBranchId())));
        bpv_fbi.setSysStatus(config1.StringNull(rs.getString(bpv_fbi.getFSysStatus())));

        bpv_fbi.setItemDiscount(rs.getDouble(bpv_fbi.getFItemDiscount()));
        bpv_fbi.setItemPaid(rs.getDouble(bpv_fbi.getFItemPaid()));
        bpv_fbi.setItemTotal(rs.getDouble(bpv_fbi.getFItemTotal()));
        bpv_fbi.setEditStatus(config1.StringNull(rs.getString(bpv_fbi.getFEditStatus())));
        bpv_fbi.setRecordStatus(config1.StringNull(rs.getString(bpv_fbi.getFRecordStatus())));

        bpv_fbi.setPatientVisitItemId(config1.StringNull(rs.getString(bpv_fbi.getFPatientVisitItemId())));
        bpv_fbi.setPatientVisitFundsId(config1.StringNull(rs.getString(bpv_fbi.getFPatientVisitFundsId())));
        bpv_fbi.setPatientVisitFundsBillingId(config1.StringNull(rs.getString(bpv_fbi.getFPatientVisitFundsBillingId())));
        bpv_fbi.setPatientVisitFundsBillingItemActive(config1.StringNull(rs.getString(bpv_fbi.getFPatientVisitFundsBillingItemActive())));
        bpv_fbi.setPatientVisitFundsBillingItemId(config1.StringNull(rs.getString(bpv_fbi.getFPatientVisitFundsBillingItemId())));

        bpv_fbi.setCode(config1.StringNull(rs.getString(bpv_fbi.getFCode())));
        bpv_fbi.setNode(config1.StringNull(rs.getString(bpv_fbi.getFNode())));
        bpv_fbi.setSortLine1(rs.getDouble(bpv_fbi.getFSortLine1()));
        bpv_fbi.setSortLine2(rs.getDouble(bpv_fbi.getFSortLine2()));
        bpv_fbi.setSortLine3(rs.getDouble(bpv_fbi.getFSortLine3()));

        bpv_fbi.setSortLine4(rs.getDouble(bpv_fbi.getFSortLine4()));
        bpv_fbi.setSortLine5(rs.getDouble(bpv_fbi.getFSortLine5()));
        bpv_fbi.setFItemGroupId(config1.StringNull(rs.getString(bpv_fbi.getFFItemGroupId())));
        bpv_fbi.doctorId = config1.StringNull(bpv_fbi.getFDoctorId());
        bpv_fbi.doctorNamet = config1.StringNull(bpv_fbi.getFDoctorNamet());
      }
      rs.close();
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return bpv_fbi;
  }
    public Vector getBackTPatientVisitFundsBillingItem(String branch_id, String bpv_fbi_id, String flag) {
        String sql = "";
        Vector v_bpvfbi = new Vector();
        try {
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            if(flag.equals("bpv_fb_id")){
              sql = "Select * From " + bpv_fbi.getBackTPatientVisitFundsBillingItem() + " "
                  + "Where " + bpv_fbi.getFPatientVisitFundsBillingId() + "='" + bpv_fbi_id + "' and "
                  + bpv_fbi.getFPatientVisitFundsBillingItemActive()+"='1' "
                  + "Order By "+bpv_fbi.getFSortLine1()+","+bpv_fbi.getFSortLine2()+","+bpv_fbi.getFSortLine3()+","+bpv_fbi.getFSortLine4()+","+bpv_fbi.getFSortLine5()+" ";
            }else{
              sql = "Select * From " + bpv_fbi.getBackTPatientVisitFundsBillingItem() + " "
                  + "Where " + bpv_fbi.getFPatientVisitFundsBillingItemId() + "='" + bpv_fbi_id + "'";
            }

            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpv_fbi = new BackTPatientVisitFundsBillingItem();
                bpv_fbi.setBItemBillingSubgroupId(rs.getString(bpv_fbi.getFBItemBillingSubgroupId()));
                bpv_fbi.setBItemId(rs.getString(bpv_fbi.getFBItemId()));
                bpv_fbi.setBillingInvoiceItemActive(rs.getString(bpv_fbi.getFBillingInvoiceItemActive()));
                bpv_fbi.setBillingInvoiceItemTotal(Double.valueOf(Double.parseDouble(rs.getString(bpv_fbi.getFBillingInvoiceItemTotal()))));
                bpv_fbi.setBillingInvoiceNumber(rs.getString(bpv_fbi.getFBillingInvoiceNumber()));

                bpv_fbi.setClaimId(rs.getString(bpv_fbi.getFClaimId()));
                bpv_fbi.setClaimNamet(rs.getString(bpv_fbi.getFClaimNamet()));
                bpv_fbi.setDepartmentNamet(rs.getString(bpv_fbi.getFDepartmentNamet()));
                bpv_fbi.setPatientVisitFundsItemId(rs.getString(bpv_fbi.getFPatientVisitFundsItemId()));
                bpv_fbi.setPatientVisitId(rs.getString(bpv_fbi.getFPatientVisitId()));

                bpv_fbi.setTBillingId(rs.getString(bpv_fbi.getFTBillingId()));
                bpv_fbi.setTBillingInvoiceDateTime(rs.getString(bpv_fbi.getFTBillingInvoiceDateTime()));
                bpv_fbi.setTBillingInvoiceItemId(rs.getString(bpv_fbi.getFTBillingInvoiceItemId()));
                bpv_fbi.setTBillingInvoiceItemNamet(rs.getString(bpv_fbi.getFTBillingInvoiceItemNamet()));
                bpv_fbi.setTBillingInvoiceTime(rs.getString(bpv_fbi.getFTBillingInvoiceTime()));

                bpv_fbi.setTOrderItemId(rs.getString(bpv_fbi.getFTOrderItemId()));
                bpv_fbi.setTPatientId(rs.getString(bpv_fbi.getFTPatientId()));
                bpv_fbi.setTPaymentId(rs.getString(bpv_fbi.getFTPaymentId()));
                bpv_fbi.setVisitId(rs.getString(bpv_fbi.getFVisitId()));
                bpv_fbi.setVisitPatientSelfDoctor(rs.getString(bpv_fbi.getFVisitPatientSelfDoctor()));

                bpv_fbi.setVisitVn(rs.getString(bpv_fbi.getFVisitVn()));
                bpv_fbi.setDepartmentId(rs.getString(bpv_fbi.getFDepartmentId()));
                bpv_fbi.setVisitHn(rs.getString(bpv_fbi.getFVisitHn()));
                bpv_fbi.setBranchId(config1.StringNull(rs.getString(bpv_fbi.getFBranchId())));
                bpv_fbi.setSysStatus(config1.StringNull(rs.getString(bpv_fbi.getFSysStatus())));

                bpv_fbi.setItemDiscount(Double.valueOf(Double.parseDouble(rs.getString(bpv_fbi.getFItemDiscount()))));
                bpv_fbi.setItemPaid(Double.valueOf(Double.parseDouble(rs.getString(bpv_fbi.getFItemPaid()))));
                bpv_fbi.setItemTotal(Double.valueOf(Double.parseDouble(rs.getString(bpv_fbi.getFItemTotal()))));
                bpv_fbi.setEditStatus(config1.StringNull(rs.getString(bpv_fbi.getFEditStatus())));
                bpv_fbi.setRecordStatus(config1.StringNull(rs.getString(bpv_fbi.getFRecordStatus())));

                bpv_fbi.setPatientVisitItemId(config1.StringNull(rs.getString(bpv_fbi.getFPatientVisitItemId())));
                bpv_fbi.setPatientVisitFundsId(config1.StringNull(rs.getString(bpv_fbi.getFPatientVisitFundsId())));
                bpv_fbi.setPatientVisitFundsBillingId(config1.StringNull(rs.getString(bpv_fbi.getFPatientVisitFundsBillingId())));
                bpv_fbi.setPatientVisitFundsBillingItemActive(config1.StringNull(rs.getString(bpv_fbi.getFPatientVisitFundsBillingItemActive())));
                bpv_fbi.setPatientVisitFundsBillingItemId(config1.StringNull(rs.getString(bpv_fbi.getFPatientVisitFundsBillingItemId())));

                bpv_fbi.setCode(config1.StringNull(rs.getString(bpv_fbi.getFCode())));
                bpv_fbi.setNode(config1.StringNull(rs.getString(bpv_fbi.getFNode())));
                bpv_fbi.setSortLine1(Double.valueOf(Double.parseDouble(rs.getString(bpv_fbi.getFSortLine1()))));
                bpv_fbi.setSortLine2(Double.valueOf(Double.parseDouble(rs.getString(bpv_fbi.getFSortLine2()))));
                bpv_fbi.setSortLine3(Double.valueOf(Double.parseDouble(rs.getString(bpv_fbi.getFSortLine3()))));

                bpv_fbi.setSortLine4(Double.valueOf(Double.parseDouble(rs.getString(bpv_fbi.getFSortLine4()))));
                bpv_fbi.setSortLine5(Double.valueOf(Double.parseDouble(rs.getString(bpv_fbi.getFSortLine5()))));
                bpv_fbi.setFItemGroupId(config1.StringNull(rs.getString(bpv_fbi.getFFItemGroupId())));
                bpv_fbi.doctorId = config1.StringNull(bpv_fbi.getFDoctorId());
                bpv_fbi.doctorNamet = config1.StringNull(bpv_fbi.getFDoctorNamet());
                v_bpvfbi.add(bpv_fbi);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_bpvfbi;
    }
    public String setSaveBackTPatientVisitFundsBillingItem(String branch_id, BackTPatientVisitFundsBillingItem item) throws Exception {
        String max="";
        Connection conn = config1.getConnectionBangna();
        Statement st = conn.createStatement();
        max = setSaveBackTPatientVisitFundsBillingItem(st, branch_id, item);
        conn.close();
        return max;
    }
    public String setSaveBackTPatientVisitFundsBillingItem(Statement st,String branch_id, BackTPatientVisitFundsBillingItem item) throws Exception {
        int chk = 0;
        String sql = "", max = "";
        try {
//          Connection conn = config1.getConnectionBangna();
//          Statement st = conn.createStatement();
//            bpv_fbi.initial();
          bpv_fbi = getBackTPatientVisitFundsBillingItemByPK(branch_id, item.getPatientVisitFundsBillingItemId());

          if (bpv_fbi.getPatientVisitFundsBillingItemId().equals("")) {
            item.generateOID(idtableItem);
            max = item.getObjectId();
//            max = getMaxRowBackTPatientVisitFundsBillingItem(st);
            sql = "Insert Into " + bpv_fbi.getBackTPatientVisitFundsBillingItem() 
                    +"(" + bpv_fbi.getFPatientVisitFundsBillingItemId() + ", " + bpv_fbi.getFBItemBillingSubgroupId() + ", "
                    +bpv_fbi.getFBItemId() + "," + bpv_fbi.getFBillingInvoiceItemActive() + ","
                    +bpv_fbi.getFBillingInvoiceItemTotal() + "," + bpv_fbi.getFBillingInvoiceNumber() + ","
                    +bpv_fbi.getFClaimId() + "," + bpv_fbi.getFClaimNamet() + ","
                    +bpv_fbi.getFDepartmentId() + "," + bpv_fbi.getFDepartmentNamet() + ","
                    +bpv_fbi.getFPatientVisitId() + "," + bpv_fbi.getFTBillingId() + ","
                    +bpv_fbi.getFPatientVisitItemId() + "," + bpv_fbi.getFTBillingInvoiceDateTime() + ","
                    +bpv_fbi.getFTBillingInvoiceItemId() + "," + bpv_fbi.getFTBillingInvoiceItemNamet() + ", "
                    +bpv_fbi.getFTBillingInvoiceTime() + "," + bpv_fbi.getFTOrderItemId() + ", "
                    +bpv_fbi.getFTPatientId() + "," + bpv_fbi.getFTPaymentId() + ","
                    +bpv_fbi.getFVisitHn() + "," + bpv_fbi.getFVisitId() + ","
                    +bpv_fbi.getFVisitPatientSelfDoctor() + "," + bpv_fbi.getFVisitVn() + ","
                    +bpv_fbi.getFBranchId() + "," + bpv_fbi.getFSysStatus() + ","
                    +bpv_fbi.getFItemDiscount() + "," + bpv_fbi.getFItemPaid() + ","
                    +bpv_fbi.getFItemTotal() + "," + bpv_fbi.getFEditStatus() + ","
                    +bpv_fbi.getFPatientVisitFundsId() + "," + bpv_fbi.getFPatientVisitFundsItemId() + ","
                    +bpv_fbi.getFPatientVisitFundsBillingItemActive() + "," + bpv_fbi.getFPatientVisitFundsBillingId() + ","
                    +bpv_fbi.getFRecordStatus() + "," + bpv_fbi.getFCode() + ","
                    +bpv_fbi.getFNode() + "," + bpv_fbi.getFSortLine1() + ","
                    +bpv_fbi.getFSortLine2() + "," + bpv_fbi.getFSortLine3() + ","
                    +bpv_fbi.getFSortLine4() + "," + bpv_fbi.getFSortLine5() + ","
                    +bpv_fbi.getFFItemGroupId() + "," + bpv_fbi.getFItemBillingSubgroupNumber() + ","
                    + bpv_fbi.getFDoctorId()+","+bpv_fbi.getFDoctorNamet()+") "
                    +"Values('" + max + "','" + item.getBItemBillingSubgroupId() + "','"
                    +item.getBItemId() + "','" + item.getBillingInvoiceItemActive() + "','"
                    +item.getBillingInvoiceItemTotal() + "','" + item.getBillingInvoiceNumber() + "','"
                    +item.getClaimId() + "','" + item.getClaimNamet() + "','"
                    +item.getDepartmentId() + "','" + item.getDepartmentNamet() + "','"
                    +item.getPatientVisitId() + "','" + item.getTBillingId() + "','"
                    +item.getTBillingInvoiceItemId() + "','" + item.getTBillingInvoiceDateTime() + "','"
                    +item.getTBillingInvoiceItemId() + "','" + item.getTBillingInvoiceItemNamet() + "','"
                    +item.getTBillingInvoiceTime() + "','" + item.getTOrderItemId() + "','"
                    +item.getTPatientId() + "','" + item.getVisitId() + "','"
                    +item.getVisitHn() + "','" + item.getDepartmentNamet() + "','"
                    +item.getVisitPatientSelfDoctor() + "','" + item.getVisitVn() + "','"
                    +item.getBranchId() + "','" + item.getSysStatus() + "',"
                    +item.getItemDiscount() + "," + item.getItemPaid() + ","
                    +item.getItemTotal() + ",'" + item.getEditStatus() + "','"
                    +item.getPatientVisitFundsId() + "','" + item.getPatientVisitFundsItemId() + "','"
                    +item.getPatientVisitFundsBillingItemActive() + "','" + item.getPatientVisitFundsBillingId() + "','"
                    +item.getRecordStatus() + "','" + item.getCode() + "','"
                    +item.getNode() + "'," + item.getSortLine1() + ","
                    +item.getSortLine2() + "," + item.getSortLine3() + ","
                    +item.getSortLine4() + "," + item.getSortLine5() + ",'"
                    +item.getFItemGroupId() + "','" + item.getItemBillingSubgroupNumber() + "','"
                    + item.doctorId+"','"+item.doctorNamet+"')";
          }else{
            sql = "Update " + bpv_fbi.getBackTPatientVisitFundsBillingItem() 
                    +" set " + bpv_fbi.getFBItemBillingSubgroupId() + " = '" + item.getBItemBillingSubgroupId() + "', "
                    +bpv_fbi.getFBItemId() + " = '" + item.getBItemId() + "', "
                    +bpv_fbi.getFBillingInvoiceItemActive() + " = '" + item.getBillingInvoiceItemActive() + "', "
                    +bpv_fbi.getFBillingInvoiceItemTotal() + " = '" + item.getBillingInvoiceItemTotal() + "', "
                    +bpv_fbi.getFBillingInvoiceNumber() + " = '" + item.getBillingInvoiceNumber() + "', "
                    +bpv_fbi.getFClaimId() + " = '" + item.getClaimId() + "', "
                    +bpv_fbi.getFClaimNamet() + " = '" + item.getClaimNamet() + "', "
                    +bpv_fbi.getFDepartmentId() + " = '" + item.getDepartmentId() + "', "
                    +bpv_fbi.getFDepartmentNamet() + " = '" + item.getDepartmentNamet() + "', "
                    +bpv_fbi.getFPatientVisitId() + " = '" + item.getPatientVisitId() + "',"
                    +bpv_fbi.getFTBillingId() + " = '" + item.getTBillingId() + "',"
                    +bpv_fbi.getFTBillingInvoiceDateTime() + " = " + item.getTBillingInvoiceDateTime() + ", "
                    +bpv_fbi.getFTBillingInvoiceItemId() + " = " + item.getTBillingInvoiceItemId() + ", "
                    +bpv_fbi.getFTBillingInvoiceItemNamet() + " = " + item.getTBillingInvoiceItemNamet() + ", "
                    +bpv_fbi.getFTBillingInvoiceTime() + " = " + item.getTBillingInvoiceTime() + ", "
                    +bpv_fbi.getFTOrderItemId() + " = " + item.getTOrderItemId() + ", "
                    +bpv_fbi.getFTPatientId() + " = " + item.getTPatientId() + ", "
                    +bpv_fbi.getFVisitId() + " = " + item.getVisitId() + ", "
                    +bpv_fbi.getFVisitHn() + " = " + item.getVisitHn() + ", "
                    +bpv_fbi.getFDepartmentNamet() + " = " + item.getDepartmentNamet() + ", "
                    +bpv_fbi.getFVisitPatientSelfDoctor() + " = " + item.getVisitPatientSelfDoctor() + ", "
                    +bpv_fbi.getFVisitVn() + " = " + item.getVisitVn() + ", "
                    +bpv_fbi.getFBranchId() + " = " + item.getBranchId() + ", "
                    +bpv_fbi.getFSysStatus() + " = " + item.getSysStatus() + ", "
                    +bpv_fbi.getFItemDiscount() + " = " + item.getItemDiscount() + ", "
                    +bpv_fbi.getFItemPaid() + " = " + item.getItemPaid() + ", "
                    +bpv_fbi.getFItemTotal() + " = " + item.getItemTotal() + ", "
                    +bpv_fbi.getFEditStatus() + " = '" + item.getEditStatus() + "', "
                    +bpv_fbi.getFPatientVisitFundsId() + " = '" + item.getPatientVisitFundsId() + "', "
                    +bpv_fbi.getFPatientVisitFundsBillingItemActive() + " = '" + item.getPatientVisitFundsId() + "', "
                    +bpv_fbi.getFPatientVisitFundsBillingId() + " = '" + item.getPatientVisitFundsBillingId() + "', "
                    +bpv_fbi.getFRecordStatus() + " = '" + item.getRecordStatus() + "', "
                    +bpv_fbi.getFCode() + " = '" + item.getCode() + "', "
                    +bpv_fbi.getFNode() + " = '" + item.getNode() + "', "
                    +bpv_fbi.getFSortLine1() + " = " + item.getSortLine1() + ", "
                    +bpv_fbi.getFSortLine2() + " = " + item.getSortLine2() + ", "
                    +bpv_fbi.getFSortLine3() + " = " + item.getSortLine3() + ", "
                    +bpv_fbi.getFSortLine4() + " = " + item.getSortLine4() + ", "
                    +bpv_fbi.getFSortLine5() + " = " + item.getSortLine5() + ", "
                    +bpv_fbi.getFFItemGroupId() + " = '" + item.getFItemGroupId() + "', "
                    +bpv_fbi.getFItemBillingSubgroupNumber() + " = '" + item.getItemBillingSubgroupNumber() + "' "
                    +"Where " + bpv_fbi.getFPatientVisitFundsItemId() + " = '" + item.getPatientVisitFundsItemId() + "'";
            max = item.getPatientVisitId();
          }
          chk = st.executeUpdate(sql);
//          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
          max = ex.getMessage();
        }
        return max;
    }
    public void setUpdateFundsDebtor(String branch_id, String data, String flag){
        String sql = "",billing_number="",injury_number="",bpv_fb_id="",doc_number="",date_current="";
        String[] aaa = data.split("\\^");
        BDocNumberDB doc_numberdb = new BDocNumberDB();
        Connection conn;
        Double total = 0.0, discount = 0.0;
        Integer chk=0;
        try {
            conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            date_current = config1.getDateDB("yyyyMMdd");
            for (int i = 0; i <= aaa.length - 1; i++) {
                try {
                    bpv_fb_id = aaa[i];
                    if (bpv_fb_id.length() <= 0) {
                        continue;
                    }
                    bpvFb = getBackTPatientVisitFundsBillingByPK(branch_id, bpv_fb_id, "");
                    if(flag.equals("debtor_enable_edit")){
                        doc_number = bpvFb.billingInvoiceNumber;
                    }else{
                        doc_number = doc_numberdb.getRunningDocNumber(branch_id, conn,bpvFb.getVisitPaidId(), "back_office");
                    }
                    
                    debtordb.setSaveDebtor(branch_id, doc_number, "", bpvFb.getVisitTotal(), date_current, "14501", "", 
                            bpvFb.getPatientVisitFundsBillingId(), bpvFb.getCloseDayDate());
                    sql = "Update " + bpvFb.getBackTPatientVisitFundsBilling()
                            + " Set " + bpvFb.getFStatusPayment() + "='2', "+bpvFb.getFStatusDebtorVoid()+"='0', "
                            +bpvFb.getFBillingInvoiceNumber()+"='"+doc_number+"' "
                            + "Where " + bpvFb.getFPatientVisitFundsBillingId() + "='" + bpv_fb_id + "'";
                    chk = st.executeUpdate(sql);
//                    sql = "Update " + bpv_fdb.bpv_f.getBackTPatientVisitFunds()
//                            + " Set " + bpv_fdb.bpv_f.getFStatusBilling() + "='2', "
//                            +bpv_fdb.bpv_f.getFBillingInvoiceNumber()+"='"+doc_number+"' "
//                            + "Where " + bpv_fdb.bpv_f.getFInjuryNumber() + "='" + bpvFb.getInjuryNumber() + "' and "
//                            +bpv_fdb.bpv_f.getFBillingInvoiceNumber()+"='' and "+bpvFb.getFVisitHn()+"='"+bpvFb.getVisitHn()+"'";
                    sql = "Update " + bpv_fdb.bpvF.getBackTPatientVisitFunds()
                            + " Set " + bpv_fdb.bpvF.getFStatusBilling() + "='2', "+bpv_fdb.bpvF.getFStatusDebtorVoid()+"='0', "
                            +bpv_fdb.bpvF.getFBillingInvoiceNumber()+"='"+doc_number+"' "
                            + "Where " + bpv_fdb.bpvF.getFInjuryNumber() + "='" + bpvFb.getInjuryNumber() + "' and "
                            +bpv_fdb.bpvF.getFPatientVisitFundsBillingId()+"='"+bpv_fb_id+"' and "+bpv_fdb.bpvF.getFVisitHn()+"='"+bpvFb.getVisitHn()+"'";
                    chk = st.executeUpdate(sql);
        //          conn.close();
                }
                catch (Exception ex) {
                  Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public String setSaveBillingFundsPrepareBill(String branch_id, String data, String sub_system, String flag) {
//        Boolean chk = false;
//        String bpv_cb_id = "", node = "", flagLanguage = "", bpv_f_id = "", bpv_fb_id = "", error = "";
//        String doc_number="", date_current="", visit_vn_max="", visit_discharge_date="", record_status="";
//        Integer len = 8, len_data = 0, cut = 0;
//        Double total = 0.0, discount = 0.0;
//
//        Vector v_billing_item = new Vector();
//        Vector v_save = new Vector();
//        BackTPatientVisit bpv = new BackTPatientVisit();
//        BackTPatientVisitFundsBillingItem bpvfbi_save = new BackTPatientVisitFundsBillingItem();
//        BackTPatientVisitFundsBillingItem bpvfbi_node_head = new BackTPatientVisitFundsBillingItem();
//        CashierTBillingInvoicePrintDB cbi_db = new CashierTBillingInvoicePrintDB(config1);
////        CashierTBillingInvoicePrint cbi = new CashierTBillingInvoicePrint();
////        BDocNumberDB doc_numberdb = new BDocNumberDB();
//        try {
//            flagLanguage = "thai";
//            Connection conn_BItem = config1.getConnectionHospital(branch_id);
//            Connection conn_bangna = config1.getConnectionBangna();
//            Connection conn_hospital = config1.getConnectionHospital(branch_id);
//            Statement st_BItem = conn_BItem.createStatement();
//            Statement st_bangna = conn_bangna.createStatement();
//            Statement st_hospital = conn_hospital.createStatement();
//            len_data = Integer.valueOf(data.length());
//            String[] aaa = data.split("\\^");
//            date_current = config1.getDateDB("yyyyMMdd");
//            for (int i = 0; i <= aaa.length - 1; i++) {
//                try {
//                    bpv_f_id = aaa[i];
//                    if (bpv_f_id.length() <= 0) {
//                        continue;
//                    }
//                    String[] bbb = bpv_f_id.split("@");
//                    bpv_f_id = bbb[0]; // min
//                    visit_vn_max = bbb[1]; // max
//                    //1.1.7.1.47
////                    errorsetUpdatePatientVisitFundsBilling = "001 i=" + i;
//                    total = Double.valueOf(0.0D);
//                    discount = Double.valueOf(0.0D);
//                    bpv_fdb.bpv_f = new BackTPatientVisitFunds();
//                    bpv_fdb.bpv_f = bpv_fdb.getBackTPatientVisitFundsByPK(st_bangna,branch_id, visit_vn_max, "visit_vn");
//                    visit_discharge_date = bpv_fdb.bpv_f.getVisitFinancialDischargeTime();
//                    bpv_fdb.bpv_f = new BackTPatientVisitFunds();
//                    if(flag.equals("bill_visit_id")){
//                        bpv_fdb.bpv_f = bpv_fdb.getBackTPatientVisitFundsByPK(st_bangna,branch_id, bpv_f_id, "visit_vn");
//                        record_status = "2";
//                    }else{
//                        bpv_fdb.bpv_f = bpv_fdb.getBackTPatientVisitFundsByPK(st_bangna,branch_id, bpv_f_id, "");
//                        record_status = "1";
//                    }
//                    bpv_fb = setCastPatientVisitFundsBilling(bpv_fdb.bpv_f);
//                    bpv_fb.setVisitFinancialDischargeTime(visit_discharge_date);
//                    bpv = new BackTPatientVisit();
//                    bpv = bpv_fdb.bpvdb.getBackTPatientVisitByPK(conn_bangna, st_bangna, bpv_fb.getPatientVisitId(), "");
//                    cbi_db.ctbIp = new CashierTBillingInvoicePrint();
//                    cbi_db.ctbIp = cbi_db.getCashierTBillingInvoicePrintByPK(branch_id, bpv.getInvoiceNumber(), "invoice_number");
//                    bpv_fb.setVisitDate(config1.DateFormatShow2DB(config1.DateFormatDB2ShowHospital(bpv_fb.getVisitDate(),"ddMMyyyy"),"ddMMyyyy"));
//                    bpv_fb.setInvoiceNumber(bpv.getInvoiceNumber());
//                    bpv_fb.setReceiptNumber(bpv.getReceiveNumber());
//                    bpv_fb.setSickness(cbi_db.ctbIp.getSickness());
//                    bpv_fb.setStatusPayment("1");
//                    bpv_fb.setRecordStatus(record_status);
//                    if (!flag.equals("print_preview")) {
//                        //doc_number = doc_numberdb.getRunningDocNumber(branch_id, conn_bangna,bpv_fb.getVisitPaidId(), "back_office");
//                    }
//                    bpv_fb.setBillingInvoiceNumber(doc_number);
//                    bpv_fb_id = setSaveBackTPatientVisitFundsBilling(branch_id, bpv_fb);
//                    if(flag.equals("bill_visit_id")){//เป็นการดึง bill ตาม visit_vn เลยต้องดึงใหม่
////                        v_billing_item = bpv_fdb.getBackTPatientVisitFundsItem(st_bangna,branch_id, bpv_fdb.bpv_f.getVisitHn(), bpv_fdb.bpv_f.getInjuryNumber(), flag);
//                        v_billing_item = bpv_fdb.bpvdb.getBackTPatientVisitItem(bpv_fdb.bpv_f.getVisitVn(), "", "", "", "visit_vn");
//                    }else{
//                        v_billing_item = bpv_fdb.getBackTPatientVisitFundsItem(st_bangna,branch_id, bpv_fdb.bpv_f.getVisitHn(), bpv_fdb.bpv_f.getInjuryNumber(), "prepare_billing");
//                    }
//                    
//                    v_save = new Vector();
//                    for (int j = 0; j <= v_billing_item.size() - 1; j++) {
//                        bpv_fdb.bpv_fi = new BackTPatientVisitFundsItem();
//                        if(flag.equals("bill_visit_id")){
//                            bpv_fdb.bpvdb.bpvi = new BackTPatientVisitItem();
//                            bpv_fdb.bpvdb.bpvi = (BackTPatientVisitItem)v_billing_item.get(j);
//                            bpv_fdb.bpv_fi = bpv_fdb.setCastPatientVisitFundsItem(bpv_fdb.bpvdb.bpvi);
//                            bpv_fdb.bpv_fi.setPatientVisitFundsId("");
////                            bpv_fdb.bpv_fi.setPatientVisitFundsId("");
//                        }else{
//                            bpv_fdb.bpv_fi = (BackTPatientVisitFundsItem)v_billing_item.get(j);
//                        }
//                        bpv_fbi = setCastPatientVisitFundsBillingItem(bpv_fdb.bpv_fi);
//                        bpv_fbi.setPatientVisitFundsBillingId(bpv_fb_id);
//                        bpv_fbi.setPatientVisitFundsId(bpv_fb.getPatientVisitFundsId());
//                        bpv_fbi.setPatientVisitFundsBillingItemActive("1");
//                        bpv_fbi.setNode("1");
//                        if(bpv_fbi.getBillingInvoiceNumber().equals("9")||bpv_fbi.getBillingInvoiceNumber().equals("999")) {
//                            discount+=bpv_fbi.getItemTotal();
//                        }
//                        total = Double.valueOf(total.doubleValue() + bpv_fbi.getItemTotal().doubleValue());
//                        v_save.add(bpv_fbi);
//                    }
//                    setUpdatePatientVisitFundsBillingTotalBaht(branch_id, bpv_fb_id,total, total-discount, discount);
//                    if (!flag.equals("print_preview")) {
//                        //debtordb.setSaveDebtor(branch_id, doc_number, "", total, date_current, "14501", "", bpv_fb.getPatientVisitFundsId());
//                    }
//                    bpv_fb.setStatusPayment("1");
//                    bpv_fb.setStatusPrint("1");
//
//                    v_billing_item = (Vector)v_save.clone();
////                    error = "002";
//                  for (int j = 0; j <= v_billing_item.size() - 1; j++) {
//                    bpv_fbi = new BackTPatientVisitFundsBillingItem();
//                    bpv_fbi = (BackTPatientVisitFundsBillingItem)v_billing_item.get(j);
//
//                    b_item = getInvoicePrint(st_hospital, bpv_fbi.getBItemId());
//
////                    error = "002.1 i=" + i + " j = " + j;
//                    if(!b_item.getItemNickname().equals("")){
//                        bpv_fbi.setTBillingInvoiceItemNamet(setCommonnameRoomXRay(st_BItem, b_item.getItemCommonName(), b_item.getItemNickname(),bpv_fb.getVisitVn(),b_item.getBItemId()));
//                    }else{
////                        if (b_item.getItemCommonName().equals(""))
//                        bpv_fbi.setTBillingInvoiceItemNamet(b_item.getItemCommonName().trim());
//                    }                    
////                    error = "002.2 i=" + i + " j = " + j;
//                    bpv_fbi.setCode(b_item.getItemNumber().trim());
//                    bpv_fbi.setSpace1(b_item.getItemTradeName());
//                    String[] node1 = bpv_fbi.getCode().split("\\.");
//                    setSortLineFunds(bpv_fbi, node1);
//
////                    error = "002.3 i=" + i + " j = " + j;
//                    node = "";
//                    for (int ii = 0; ii <= node1.length - 2; ii++) {
//                      node = node + node1[ii] + ".";
//                    }
//                    error = "002 i=" + i + " j = " + j + " node " + node;
//                    if ((node.length() > 0) && (node.substring(node.length() - 1).equals("."))) {
//                      node = node.substring(0, node.length() - 1);
//                    }
//                    bpvfbi_node_head = new BackTPatientVisitFundsBillingItem();
//                    getMainBItemFunds(st_BItem,bpvfbi_node_head, node, flagLanguage);
//                    error = "0021 i=" + i + " j = " + j;
//                    if (bpvfbi_node_head.getCode().length() > 0) {
//                      bpvfbi_node_head.setNode("2");
//                      bpvfbi_node_head.setPatientVisitFundsBillingItemActive("1");
//                      error = "022 i=" + i + " j = " + j;
//                      setNodeHeadFunds(bpvfbi_node_head, bpv_fbi);
//                      error = "023 i=" + i + " j = " + j;
//                      chk = Boolean.valueOf(false);
//                      for (int ii = 0; ii <= v_save.size() - 1; ii++) {
//                        bpvfbi_save = new BackTPatientVisitFundsBillingItem();
//                        bpvfbi_save = (BackTPatientVisitFundsBillingItem)v_save.get(ii);
//                        if (bpvfbi_save.getCode().equals(bpvfbi_node_head.getCode())) {
//                          chk = Boolean.valueOf(true);
//                          break;
//                        }
//                      }
//                      error = "003 i=" + i + " j = " + j;
//                      if (!chk.booleanValue()) {
//                        node1 = bpvfbi_node_head.getCode().split("\\.");
//                        setSortLineFunds(bpvfbi_node_head, node1);
//                        v_save.add(bpvfbi_node_head);
//                      }
//
//                      node = "";
//                      for (int ii = 0; ii <= node1.length - 2; ii++) {
//                        node = node + node1[ii] + ".";
//                      }
//                      if ((node.length() > 0) && (node.substring(node.length() - 1).equals("."))) {
//                        node = node.substring(0, node.length() - 1);
//                      }
//                      bpvfbi_node_head = new BackTPatientVisitFundsBillingItem();
//                      getMainBItemFunds(st_BItem,bpvfbi_node_head, node, flagLanguage);
//                      if (bpvfbi_node_head.getCode().length() > 0) {
//                        bpvfbi_node_head.setNode("3");
//                        bpvfbi_node_head.setPatientVisitFundsBillingItemActive("1");
//                        setNodeHeadFunds(bpvfbi_node_head, bpv_fbi);
//                        error = "004 i=" + i + " j = " + j;
//                        chk = Boolean.valueOf(false);
//                        for (int ii = 0; ii <= v_save.size() - 1; ii++) {
//                          bpvfbi_save = new BackTPatientVisitFundsBillingItem();
//                          bpvfbi_save = (BackTPatientVisitFundsBillingItem)v_save.get(ii);
//                          if (bpvfbi_save.getCode().equals(bpvfbi_node_head.getCode())) {
//                            chk = Boolean.valueOf(true);
//                            break;
//                          }
//                        }
//                        if (!chk.booleanValue()) {
//                          node1 = bpvfbi_node_head.getCode().split("\\.");
//                          setSortLineFunds(bpvfbi_node_head, node1);
//                          v_save.add(bpvfbi_node_head);
//                        }
//                        error = "005 i=" + i + " j = " + j;
//
//                        node = "";
//                        for (int ii = 0; ii <= node1.length - 2; ii++) {
//                          node = node + node1[ii] + ".";
//                        }
//                        if ((node.length() > 0) && (node.substring(node.length() - 1).equals("."))) {
//                          node = node.substring(0, node.length() - 1);
//                        }
//                        bpvfbi_node_head = new BackTPatientVisitFundsBillingItem();
//                        getMainBItemFunds(st_BItem,bpvfbi_node_head, node, flagLanguage);
//                        error = "006 i=" + i + " j = " + j;
//                        if (bpvfbi_node_head.getCode().length() > 0) {
//                          bpvfbi_node_head.setNode("4");
//                          bpvfbi_node_head.setPatientVisitFundsBillingItemActive("1");
//                          setNodeHeadFunds(bpvfbi_node_head, bpv_fbi);
//                          chk = Boolean.valueOf(false);
//                          for (int ii = 0; ii <= v_save.size() - 1; ii++) {
//                            bpvfbi_save = new BackTPatientVisitFundsBillingItem();
//                            bpvfbi_save = (BackTPatientVisitFundsBillingItem)v_save.get(ii);
//                            if (bpvfbi_save.getCode().equals(bpvfbi_node_head.getCode())) {
//                              chk = Boolean.valueOf(true);
//                              break;
//                            }
//                          }
//                          error = "007 i=" + i + " j = " + j;
//                          if (!chk.booleanValue()) {
//                            node1 = bpvfbi_node_head.getCode().split("\\.");
//                            setSortLineFunds(bpvfbi_node_head, node1);
//                            v_save.add(bpvfbi_node_head);
//                          }
//                          node = "";
//                          for (int ii = 0; ii <= node1.length - 2; ii++) {
//                            node = node + node1[ii] + ".";
//                          }
//                          if ((node.length() > 0) && (node.substring(node.length() - 1).equals("."))) {
//                            node = node.substring(0, node.length() - 1);
//                          }
//                          if (node.length() <= 0)
//                            continue;
//                          bpvfbi_node_head = new BackTPatientVisitFundsBillingItem();
//                          getMainBItemFunds(st_BItem,bpvfbi_node_head, node, flagLanguage);
//                          error = "008 i=" + i + " j = " + j;
//                          if (bpvfbi_node_head.getCode().length() > 0) {
//                            bpvfbi_node_head.setNode("5");
//                            bpvfbi_node_head.setPatientVisitFundsBillingItemActive("1");
//                            setNodeHeadFunds(bpvfbi_node_head, bpv_fbi);
//                            chk = Boolean.valueOf(false);
//                            error = "009 i=" + i + " j = " + j;
//                            for (int ii = 0; ii <= v_save.size() - 1; ii++) {
//                              bpvfbi_save = new BackTPatientVisitFundsBillingItem();
//                              bpvfbi_save = (BackTPatientVisitFundsBillingItem)v_save.get(ii);
//                              if (bpvfbi_save.getCode().equals(bpvfbi_node_head.getCode())) {
//                                chk = Boolean.valueOf(true);
//                                break;
//                              }
//                            }
//                            if (!chk.booleanValue()) {
//                              node1 = bpvfbi_node_head.getCode().split("\\.");
//                              setSortLineFunds(bpvfbi_node_head, node1);
//                              v_save.add(bpvfbi_node_head);
//                            }
//                          }
//                        }
//                      }
//                    }
//                  }
//                  error = "010 ";
//                  if(!record_status.equals("2")){
//                      setSavePatientVisitFundsStatusBilling(st_bangna,branch_id, bpv_fdb.bpv_f.getVisitHn(), bpv_fdb.bpv_f.getInjuryNumber(),doc_number, bpv_fb_id);
//                  }
//                  
//                  for (int j = 0; j <= v_save.size() - 1; j++) {
//                    bpv_fbi = new BackTPatientVisitFundsBillingItem();
//                    bpv_fbi = (BackTPatientVisitFundsBillingItem)v_save.get(j);
//                    bpv_fbi.setCode(bpv_fbi.getSpace1() + bpv_fbi.getCode());
//                //            bpv_fbi = bpv_fdb.setCastPatientVisitFundsBillingItem(bpv_fbi);
//                    bpv_cb_id = setSaveBackTPatientVisitFundsBillingItem(st_bangna,branch_id, bpv_fbi);
//                  }
//                } catch (Exception ex) {
//                  Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            conn_BItem.close();
//            conn_bangna.close();
//            conn_hospital.close();
//        }catch (Exception ex) {
//            Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return bpv_fb_id;
//    }
//    private void setSortLineFunds(BackTPatientVisitFundsBillingItem bpvfbi, String[] node1) {
//        try {
//            for (int k = 0; k <= node1.length - 1; k++) {
//            if (k == 0) {
//              if ((node1[k] != null) && (!node1[k].equals("")))
//                bpvfbi.setSortLine1(Double.valueOf(Double.parseDouble(node1[k])));
//              else
//                bpvfbi.setSortLine1(Double.valueOf(0.0D));
//            }
//            else if (k == 1) {
//              if ((node1[k] != null) && (!node1[k].equals("")))
//                bpvfbi.setSortLine2(Double.valueOf(Double.parseDouble(node1[k])));
//              else {
//                bpvfbi.setSortLine2(Double.valueOf(0.0D));
//              }
//            }
//            if (k == 2) {
//              if ((node1[k] != null) && (!node1[k].equals("")))
//                bpvfbi.setSortLine3(Double.valueOf(Double.parseDouble(node1[k])));
//              else {
//                bpvfbi.setSortLine3(Double.valueOf(0.0D));
//              }
//            }
//            if (k == 3) {
//              if ((node1[k] != null) && (!node1[k].equals("")))
//                bpvfbi.setSortLine4(Double.valueOf(Double.parseDouble(node1[k])));
//              else {
//                bpvfbi.setSortLine4(Double.valueOf(0.0D));
//              }
//            }
//            if (k == 4)
//              if ((node1[k] != null) && (!node1[k].equals("")))
//                bpvfbi.setSortLine5(Double.valueOf(Double.parseDouble(node1[k])));
//              else
//                bpvfbi.setSortLine5(Double.valueOf(0.0D));
//            }
//        }catch (Exception ex){
//          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public void getMainBItemFunds(Statement st,BackTPatientVisitFundsBillingItem bpvfbi1, String invoice_number, String flagLanguage)  {
////        BackTPatientVisitFundsBillingItem bpvfbi1 = new BackTPatientVisitFundsBillingItem();
//        String[] node1 = invoice_number.split("\\.");
//        b_item = getBItemSubGroup(st, invoice_number);
////        if (invoice_number.equals("1.1.12.6")) {
//          space1.delete(0, space1.length());
////        }
//        if (!b_item.getItemNumber().equals("")) {
//            if (node1.length == 0)
//                space1.append("");
//            else if (node1.length == 1)
//                space1.append("  ");
//            else if (node1.length == 2)
//                space1.append("    ");
//            else if (node1.length == 3)
//                space1.append("      ");
//            else if (node1.length == 4)
//                space1.append("          ");
//            else if (node1.length == 5) {
//                space1.append("            ");
//            }
//            if (flagLanguage.equals("thai"))
//                bpvfbi1.setTBillingInvoiceItemNamet(b_item.getItemCommonName());
//            else {
//                bpvfbi1.setTBillingInvoiceItemNamet(b_item.getItemDescriptione());
//            }
//            bpvfbi1.setVisitPatientSelfDoctor(space1.toString());
//            bpvfbi1.setCode(b_item.getItemNumber());
//            bpvfbi1.setSpace1(space1.toString());
//        }
////        return bpvfbi1;
//    }
    private void setNodeHeadFunds(BackTPatientVisitFundsBillingItem bpvFbINhead, BackTPatientVisitFundsBillingItem bpvcbi){
        bpvFbINhead.setPatientVisitFundsBillingId(bpvcbi.getPatientVisitFundsBillingId());
        bpvFbINhead.setPatientVisitFundsItemId(bpvcbi.getPatientVisitFundsItemId());
        bpvFbINhead.setPatientVisitId(bpvcbi.getPatientVisitId());
        bpvFbINhead.setTPatientId(bpvcbi.getTPatientId());
        bpvFbINhead.setTPaymentId(bpvcbi.getTPaymentId());

        bpvFbINhead.setTPatientId(bpvcbi.getTPatientId());
        bpvFbINhead.setVisitHn(bpvcbi.getVisitHn());
        bpvFbINhead.setVisitVn(bpvcbi.getVisitVn());
        bpvFbINhead.setSysStatus(bpvcbi.getSysStatus());

        bpvFbINhead.setBranchId(bpvcbi.getBranchId());
        bpvFbINhead.setEditStatus(bpvcbi.getEditStatus());
        bpvFbINhead.setVisitId(bpvFbINhead.getVisitId());
        bpvFbINhead.setBillingInvoiceItemActive(bpvFbINhead.getBillingInvoiceItemActive());
        bpvFbINhead.setBItemId(bpvFbINhead.getBItemId());

        bpvFbINhead.setTBillingInvoiceItemId(bpvFbINhead.getTBillingInvoiceItemId());
        bpvFbINhead.setTOrderItemId(bpvFbINhead.getTOrderItemId());
        bpvFbINhead.setBItemBillingSubgroupId(bpvFbINhead.getBItemBillingSubgroupId());
        bpvFbINhead.setVisitPatientSelfDoctor(bpvFbINhead.getVisitPatientSelfDoctor());
        bpvFbINhead.setClaimId(bpvFbINhead.getClaimId());

        bpvFbINhead.setClaimNamet(bpvFbINhead.getClaimNamet());
        bpvFbINhead.setPatientVisitItemId(bpvFbINhead.getPatientVisitItemId());
        bpvFbINhead.setBillingInvoiceItemActive(bpvFbINhead.getBillingInvoiceItemActive());
        bpvFbINhead.setTBillingInvoiceDateTime(bpvFbINhead.getTBillingInvoiceDateTime());
        bpvFbINhead.setTBillingInvoiceTime(bpvFbINhead.getTBillingInvoiceTime());

        bpvFbINhead.setPatientVisitFundsBillingItemActive("1");
        bpvFbINhead.setRecordStatus("0");
        bpvFbINhead.setPatientVisitFundsId(bpvFbINhead.getPatientVisitFundsId());
        bpvFbINhead.setPatientVisitFundsBillingId(bpvFbINhead.getPatientVisitFundsBillingId());
        bpvFbINhead.setFItemGroupId(bpvFbINhead.getFItemGroupId());
    }
    public void setSavePatientVisitFundsStatusBilling(Statement st,String branch_id, String visit_hn,
        String injury_number, String billing_number, String bpv_fb_id) {
        String sql = "";
        try {
            sql = "Update " + bpv_fdb.bpvF.getBackTPatientVisitFunds()
                + " Set " + bpv_fdb.bpvF.getFStatusBilling() + "='1', "
                +bpv_fdb.bpvF.getFBillingInvoiceNumber()+"='"+billing_number+"', "
                +bpv_fdb.bpvF.getFPatientVisitFundsBillingId()+" = '"+bpv_fb_id +"' "
                + "Where " + bpv_fdb.bpvF.getFInjuryNumber() + "='" + injury_number + "' and "
                +bpv_fdb.bpvF.getFStatusBilling()+"='0' and "+bpv_fdb.bpvF.getFVisitHn()+"='"+visit_hn+"' ";
          st.executeUpdate(sql);
//          conn.close();
        }
        catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitFundsBillingTotalBaht(String branch_id, String patient_visit_funds_billing_id, Double nettotal, Double total,
            Double discount) {
        String sql = "", baht = config1.readCurrencyInThai(nettotal.doubleValue(), "บาทถ้วน", "สตางค์");
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpvFb.getBackTPatientVisitFundsBilling() + " "
                  + "Set " + bpvFb.getFVisitTotalBaht() + "='" +baht + "', "
                  + bpvFb.getFVisitTotal() + "=" + total + ", "
                  + bpvFb.getFVisitDiscount() + "=" + discount + ", "
                  + bpvFb.getFVisitPaid() + "=" + nettotal + " "
                  + "Where " + bpvFb.getFPatientVisitFundsBillingId() + "='" + patient_visit_funds_billing_id + "' and "
                  + bpvFb.getFBranchId() + "='" + branch_id + "' ";

            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitFundsBillingStatusPrint(String branch_id, String bpv_fb_id, String status_print) {
        String sql = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpvFb.getBackTPatientVisitFundsBilling() + " "
                  + "Set " + bpvFb.getFStatusPrint() + "='" + status_print + "' "
                  + "Where " + bpvFb.getFPatientVisitFundsBillingId() + "='" + bpv_fb_id + "' and "
                  + bpvFb.getFBranchId() + "='" + branch_id + "' ";
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String setUpdatePatientVisitFundsBillingRemark(String branch_id, String bpvFbId, String remark) {
        String sql = "";
        Integer chk=0;
        try {
            remark = remark.replace("'", "''");
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpvFb.getBackTPatientVisitFundsBilling() + " "
                  + "Set " + bpvFb.getFRemark() + "='" +remark + "' "
                  + "Where " + bpvFb.getFPatientVisitFundsBillingId() + "='" + bpvFbId + "' and "
                  + bpvFb.getFBranchId() + "='" + branch_id + "' ";

            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setUpdateVisitNoticeBySurveillance(String branch_id, String bpvFbId, String sickness) {
        String sql = "";
        Integer chk=0;
        try {
            sickness = sickness.replace("'", "''");
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpvFb.getBackTPatientVisitFundsBilling() + " "
                  + "Set " + bpvFb.getFSickness() + "='" +sickness + "' "
                  + "Where " + bpvFb.getFPatientVisitFundsBillingId() + "='" + bpvFbId + "' and "
                  + bpvFb.getFBranchId() + "='" + branch_id + "' ";

            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
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
            Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b_item;
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
            Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
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
                    .append("bi.b_item_id, bi.item_common_name, bi.item_descriptione, bi.item_nick_name ")
                    .append("FROM b_item bi1 ")
                    .append("LEFT JOIN b_item_billing_subgroup ")
                    .append("ON b_item_billing_subgroup.b_item_billing_subgroup_id::text = bi1.b_item_billing_subgroup_id::text  ")
//                    .append("ON b_item_billing_subgroup.b_item_billing_subgroup_id::text = bi1.b_item_billing_subgroup_id::text and ")//comment เพราะมีข้อมูลที่ front ไป unactive ทำให้ดึงข้อมูลไม่ขึ้น
//                    .append("bi1.item_active = '1'  ")//comment เพราะมีข้อมูลที่ front ไป unactive ทำให้ดึงข้อมูลไม่ขึ้น
                    .append("LEFT JOIN b_item bi ON b_item_billing_subgroup.item_billing_subgroup_number::text = bi.item_number::text ")
//                    .append("bi.item_active::text = '0'::text ")
                    .append("WHERE bi1.b_item_id = '").append(b_item_id1).append("' and bi.item_active::text = '0' ");
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
                b_item.setItemNickname(config1.StringNull(rs_hospital.getString(b_item.getFItemNickname())));
            }
            rs_hospital.close();
        }catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b_item;
    }
//    public void setSavePayment(String branch_id, BackTBillingPayment bp, String status){
//        Vector v_bpv_fbt = new Vector();
//        String billing_payment_id="", bbpi_id="";
//        try {
//            billing_payment_id = bpdb.setSaveBackTBillingPayment(branch_id, bp);
//            v_bpv_fbt = getBackTPatientVisitFundsBillingTemp(branch_id,"", status);
//            for(int i=0;i<=v_bpv_fbt.size()-1;i++){
//                bpv_fbt = new BackTPatientVisitFundsBillingTemp();
//                bpv_fb = new BackTPatientVisitFundsBilling();
//                bpv_fbt = (BackTPatientVisitFundsBillingTemp)v_bpv_fbt.get(i);
//                bpv_fb = getBackTPatientVisitFundsBillingByPK(branch_id, bpv_fbt.getBillingInvoiceNumber(),"billing_payment");
//                bpdb.bbpi = new BackTBillingPaymentItem();
//                bpdb.bbpi.setBillingPaymentId(billing_payment_id);
//                bpdb.bbpi.setBillingPaymentItemActive("1");
//                bpdb.bbpi.setBillingPaymentItemId("");
//                bpdb.bbpi.setRemark("");
//                bpdb.bbpi.setPatientVisitXBillingId(bpv_fb.getPatientVisitFundsBillingId());
//                bpdb.bbpi.setAmount(bpv_fbt.getAmount());
//                bpdb.bbpi.setVisitTotal(bpv_fb.getVisitTotal());
//                bpdb.bbpi.setPatientVisitId(bpv_fb.getPatientVisitId());
//                bpdb.bbpi.setBillingInvoiceNumber(bpv_fb.getBillingInvoiceNumber());
//                bpdb.bbpi.setVisitHn(bpv_fb.getVisitHn());
//                bpdb.bbpi.setPatientFullnamet(bpv_fb.getPatientFullnamet());
//                bpdb.bbpi.setVisitContactJoinId(bpv_fb.getVisitContactId());
//                bpdb.bbpi.setVisitContactJoinNamet(bpv_fb.getVisitContactNamet());
//
//                bbpi_id=bpdb.setSaveBackTBillingPaymentItem(branch_id, bpdb.bbpi);
//                bpdb.setUpdateBackTPatientFundsBilling(branch_id, bbpi_id,bpv_fb.getPatientVisitFundsBillingId());
//                bpv_fdb.setUpdatePatientVisitFundsStatusPayment(branch_id, bpv_fb.getPatientVisitFundsId(), billing_payment_id, "4", bpv_fbt.getAmount(), bp.getReceiveDate());
//                debtordb.setUpdateBackTDebtorPayment(branch_id, bpv_fb.getPatientVisitFundsBillingId(), "", "", bpv_fbt.getAmount());
//            }
//            setDeleteAllBackTPatientVisitBillingTemp(branch_id,status);
//        } catch (Exception ex) {
//            Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public void setSavePayment(String branch_id, BackTBillingPayment bp, String status, String data){
//        Vector v_bpv_fbt = new Vector();
//        String billing_payment_id="", bbpi_id="",bpvFId="", statusBill="";
//        try {
//            String[] aaa = data.split("\\^");
//            for(int i=0;i<=aaa.length-1;i++){
//                bpvFId += "'"+aaa[i]+"',";
//            }
////            bpvFId = "'"+bpvFId;
//            if(bpvFId.substring(bpvFId.length()-1).equals(",")){
//                bpvFId = bpvFId.substring(0,bpvFId.length()-1);
//            }
//            billing_payment_id = bpdb.setSaveBackTBillingPayment(branch_id, bp);
//            v_bpv_fbt = getBackTPatientVisitFundsBillingTemp(bpvFId,"", status);
//            for(int i=0;i<=v_bpv_fbt.size()-1;i++){
//                
//                bpv_fbt = new BackTPatientVisitFundsBillingTemp();
//                bpv_fdb.bpv_f = new BackTPatientVisitFunds();
//                bpv_fbt = (BackTPatientVisitFundsBillingTemp)v_bpv_fbt.get(i);
//                bpv_fdb.bpv_f = bpv_fdb.getBackTPatientVisitFundsByPK(branch_id, bpv_fbt.getBpvFId(),"");
//                bpdb.bbpi = new BackTBillingPaymentItem();
//                bpdb.bbpi.setBillingPaymentId(billing_payment_id);
//                bpdb.bbpi.setBillingPaymentItemActive("1");
//                bpdb.bbpi.setBillingPaymentItemId("");
//                bpdb.bbpi.setRemark("");
//                bpdb.bbpi.setPatientVisitXBillingId(bpv_fdb.bpv_f.getPatientVisitFundsBillingId());
//                bpdb.bbpi.setAmount(bpv_fbt.getAmount());
//                bpdb.bbpi.setVisitTotal(bpv_fdb.bpv_f.getVisitTotal());
//                bpdb.bbpi.setPatientVisitId(bpv_fdb.bpv_f.getPatientVisitId());
//                bpdb.bbpi.setBillingInvoiceNumber(bpv_fdb.bpv_f.getBillingInvoiceNumber());
//                bpdb.bbpi.setVisitHn(bpv_fdb.bpv_f.getVisitHn());
//                bpdb.bbpi.setPatientFullnamet(bpv_fdb.bpv_f.getPatientFullnamet());
//                bpdb.bbpi.setVisitContactJoinId(bpv_fdb.bpv_f.getVisitContactId());
//                bpdb.bbpi.setVisitContactJoinNamet(bpv_fdb.bpv_f.getVisitContactNamet());
//                bpdb.bbpi.setPatientVisitXId(bpv_fdb.bpv_f.getPatientVisitFundsId());
//
//                //Step ในการ Update
//                //1. update receive_amount
//                //2. Check ว่ายอดเงิน >= visitTotal
//                //3. ถ้า ยอดเงิน >= visitTotal จริง ให้ update status_payment ให้เป็น '4'
//                //4. และถ้า status_payment = '4' ให้ chcek ว่า funds_billing รับชำระครบไหม ถ้าครบก็ให้ update status_billing ด้วย
//                bbpi_id=bpdb.setSaveBackTBillingPaymentItem(branch_id, bpdb.bbpi);//เก็บ record รับชำระ
//                statusBill = bpv_fdb.setUpdatePatientVisitFundsStatusPayment(branch_id, bpv_fdb.bpv_f.getPatientVisitFundsId(), billing_payment_id, "4", bpv_fbt.getAmount(), bp.getReceiveDate());
//                if(statusBill.equals("4")){
//                    bpdb.setUpdateBackTPatientFundsBillingStatusPayment(branch_id, bbpi_id,bpv_fb.getPatientVisitFundsBillingId(),statusBill);
//                }
//                
//                debtordb.setUpdateBackTDebtorPayment(branch_id, bpv_fb.getPatientVisitFundsBillingId(), "", "", bpv_fbt.getAmount());
//            }
//            setDeleteAllBackTPatientVisitBillingTemp(branch_id,status);
//        } catch (Exception ex) {
//            Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public Vector getBackTPatientVisitFundsBillingTemp(String bpvFId, String billing_invoice_number, String status) {
        String sql = "", billing_invoice_number_search="", status_search="", bpvFSearch="";
        Vector v_bpv_fbt = new Vector();
        try {
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            if(!billing_invoice_number.equals("")){
                billing_invoice_number_search = " billing_invoice_number = '"+billing_invoice_number+"' ";
            }
            if(!status.equals("")){
                status_search = " and status = '"+status+"' ";
            }
            if(billing_invoice_number_search.equals("") && status_search.length()>0){
                status_search = status_search.replace("and", "");
            }
            if(!bpvFId.equals("")){
                bpvFSearch = " and patient_visit_funds_id in ("+bpvFId+")";
            }
            sql = "Select * From back_t_patient_visit_funds_billing_temp "
                    +"Where "+billing_invoice_number_search+status_search+bpvFSearch;
          ResultSet rs = stbangna.executeQuery(sql);
          while (rs.next()) {
            bpv_fbt = new BackTPatientVisitFundsBillingTemp();
            bpv_fbt.setBillingInvoiceNumber(config1.StringNull(rs.getString("billing_invoice_number")));
            bpv_fbt.setAmount(Double.parseDouble(rs.getString("amount")));
            bpv_fbt.setBpvFId(rs.getString("patient_visit_funds_id"));

            v_bpv_fbt.add(bpv_fbt);
          }
          rs.close();
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_bpv_fbt;
    }
    public BackTPatientVisitFundsBillingTemp getCntSumBackTPatientVisitFundsBillingTemp(String branch_id, String status) {
        String sql = "";
        Vector v_bpvcb = new Vector();
        try {
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            sql = "Select count(*) as cnt, sum(amount) as amount From back_t_patient_visit_funds_billing_temp "
                    + "Where status = '"+status+"'" ;
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpv_fbt = new BackTPatientVisitFundsBillingTemp();
                bpv_fbt.setBillingInvoiceNumber(rs.getString("cnt"));
                bpv_fbt.setAmount(Double.parseDouble(rs.getString("amount")));
                v_bpvcb.add(bpv_fbt);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpv_fbt;
    }
    public BackTPatientVisitFundsBillingTemp getCntSumBackTPatientVisitFundsBillingItem(String branch_id, String bpv_fb_id) {
        String sql = "";
        Vector v_bpvcb = new Vector();
        try {
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            sql = "Select count(*) as cnt, sum("+bpv_fbi.getFItemTotal()+") as amount "
                    + "From "+bpv_fbi.getBackTPatientVisitFundsBillingItem()
                    +" Where "+bpv_fbi.getFPatientVisitFundsBillingId()+" = '"+bpv_fb_id+"' and "+bpv_fbi.getFBillingInvoiceItemActive()+"='1' ";
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpv_fbt = new BackTPatientVisitFundsBillingTemp();
                bpv_fbt.setBillingInvoiceNumber(rs.getString("cnt"));
                bpv_fbt.setAmount(Double.parseDouble(rs.getString("amount")));
                v_bpvcb.add(bpv_fbt);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpv_fbt;
    }
//    public String getTrBackTPatientVisitFundsBillingTemp(String branch_id, String billing_number, String status, String flag) {
//        String txt="", t_header="", txt_sum="", alert="", td_total="", td_remark="", th_total="", th_remark="";
//        Vector v_bpv_fbt = new Vector();
//        if(flag.equals("delete_billing_all")){
//            setDeleteAllBackTPatientVisitBillingTemp(branch_id, status);
//        }else if(flag.equals("delete_billing_item")){
//            setDeleteBackTPatientVisitBillingTemp(branch_id, billing_number, status);
//        }else if(flag.equals("delete_cover_all")){
//            setDeleteAllBackTPatientVisitBillingTemp(branch_id, status);
//        }else if(flag.equals("delete_cover_item")){
//            setDeleteBackTPatientVisitBillingTemp(branch_id, billing_number, status);
//        }else{
//            v_bpv_fbt = getBackTPatientVisitFundsBillingTemp(branch_id,billing_number, status);
//            if(v_bpv_fbt.size()>0){
//                alert = "<script type='text/javascript' charset='TIS-620'>alert('รหัสซ้ำ');</script>";
//            }else{
////                bpv_fb = getBackTPatientVisitFundsBillingByPK(branch_id, billing_number,"billing_number");// เปลี่ยนให้ สามารถรับชำระตาม bpv_f_id ได้
////                if(bpv_fb.getStatusPayment().equals("4")){
////                    alert = "<script type='text/javascript' charset='TIS-620'>alert('รายการนี้รับชำระไปแล้ว');</script>";
////                }else if(bpv_fb.getPatientVisitFundsBillingId().equals("")){
////                    alert = "<script type='text/javascript' charset='TIS-620'>alert('ไม่พบรหัส');</script>";
////                }else {
////                    setSaveBackTPatientVisitBillingTemp(branch_id, billing_number, bpv_fb.getVisitTotal(), status, bpv_fb.getPatientVisitFundsId());
////                }
//                bpv_fdb.bpv_f = bpv_fdb.getBackTPatientVisitFundsByPK(branch_id, billing_number,"billing_number");
//                if(bpv_fdb.bpv_f.getStatusBilling().equals("4")){
//                    alert = "<script type='text/javascript' charset='TIS-620'>alert('รายการนี้รับชำระไปแล้ว');</script>";
//                }else if(bpv_fdb.bpv_f.getPatientVisitFundsId().equals("")){
//                    alert = "<script type='text/javascript' charset='TIS-620'>alert('ไม่พบรหัส');</script>";
//                }else {
//                    setSaveBackTPatientVisitBillingTemp(branch_id, billing_number, bpv_fb.getVisitTotal(), status, bpv_fb.getPatientVisitFundsId());
//                }
//            }
//        }
//        v_bpv_fbt = getBackTPatientVisitFundsBillingTemp(branch_id,"", status);
//        for(int i=0;i<= v_bpv_fbt.size()-1;i++){
//            bpv_fbt = new BackTPatientVisitFundsBillingTemp();
//            bpv_fb = new BackTPatientVisitFundsBilling();
//            bpv_fbt = (BackTPatientVisitFundsBillingTemp)v_bpv_fbt.get(i);
//            bpv_fb = getBackTPatientVisitFundsBillingByPK(branch_id, bpv_fbt.getBillingInvoiceNumber(),"billing_payment");
//            if(status.equals("1")){
//                td_total = "<td><input type='text' id='txt_fb_amount"+i+"' value='"+bpv_fb.getVisitTotal()+"' size='8'/></td>";
//                td_remark = "<td><input type='text' id='txt_fb_remark"+i+"' size='15'/></td>";
//            }else{
//                td_total="<td><input type='hidden' id='txt_fb_amount"+i+"' value='"+bpv_fb.getVisitTotal()+"' size='8'/></td>";
//                td_remark="";
//            }
//            txt+="<tr style='font-size: 12px'>"
//                    + "<td>"+(i+1)+"</td>"
//                    + "<td><label><input type='checkbox' name='chk_"+i+"' id ='chk_"+i+ "' value='' >เลือก</label></td>"
//                    + "<td>"+bpv_fb.getBillingInvoiceNumber()+"<input type='hidden' id='txt_"+i+"' value='"+bpv_fb.getBillingInvoiceNumber()+"'/></td>"
//                    + "<td>"+bpv_fb.getPatientFullnamet()+"</td>"
//                    + "<td>"+bpv_fb.getInjuryNumber()+"</td>"
//                    + "<td>"+bpv_fb.getVisitTotal()+"</td>"
//                    + td_total + td_remark
//                    + "</tr>";
//        }
//        bpv_fbt = new BackTPatientVisitFundsBillingTemp();
//        bpv_fbt = getCntSumBackTPatientVisitFundsBillingTemp(branch_id, status);
//        if(status.equals("1")){
//            th_total = "<td>รับชำระ</td>";
//            th_remark = "<td>หมายเหตุ</td>";
//        }else{
//            th_total = "";
//            th_remark = "";
//        }
//        t_header="<tr style='font-size: 12px'>"
//                + "<td>ลำดับ</td>"
//                + "<td></td>"
//                + "<td>เลขที่</td>"
//                + "<td>ชื่อ-นามสกุล</td>"
//                + "<td>เลขที่ผู้ประสบอันตราย</td>"
//                + "<td>ยอด</td>"
//                + th_total + th_remark + "</tr>";
//        txt_sum = "<table style='font-size: 12px'><tr><td>จำนวนบิล</td>"
//                + "<td><input type='text' id='txt_qty_bill' value='"+bpv_fbt.getBillingInvoiceNumber()+"' size='8' readonly></td>"
//                + "<td>จำนวนเงิน</td><td><input type='text' id='txt_amount_bill' value='"+bpv_fbt.getAmount()+"' size='8' readonly></td></tr></table>";
//        return txt_sum+"<table>"+t_header+txt+"</table>"+alert;
//    }
//    public String getTrBackTPatientVisitFundsBillingTemp(String branch_id, String billing_number, String status, String flag) throws Exception {
//        String txt="", t_header="", txt_sum="", alert="", td_total="", td_remark="", th_total="", th_remark="";
//        String remarkDisable="";
//        Double amount=0.0;
//        Vector v_bpv_fbt = new Vector();
//        Vector v_bpv_f = new Vector();
//        if(flag.equals("delete_billing_all")){
//            setDeleteAllBackTPatientVisitBillingTemp(branch_id, status);
//        }else if(flag.equals("delete_billing_item")){
//            setDeleteBackTPatientVisitBillingTemp(branch_id, billing_number, status);
//        }else if(flag.equals("delete_cover_all")){
//            setDeleteAllBackTPatientVisitBillingTemp(branch_id, status);
//        }else if(flag.equals("delete_cover_item")){
//            setDeleteBackTPatientVisitBillingTemp(branch_id, billing_number, status);
//        }else{
//            v_bpv_fbt = getBackTPatientVisitFundsBillingTemp("",billing_number, status);
//            if(v_bpv_fbt.size()>0){
//                alert = "<script type='text/javascript' charset='TIS-620'>alert('รหัสซ้ำ');</script>";
//            }else{
////                bpv_fb = getBackTPatientVisitFundsBillingByPK(branch_id, billing_number,"billing_number");// เปลี่ยนให้ สามารถรับชำระตาม bpv_f_id ได้
////                if(bpv_fb.getStatusPayment().equals("4")){
////                    alert = "<script type='text/javascript' charset='TIS-620'>alert('รายการนี้รับชำระไปแล้ว');</script>";
////                }else if(bpv_fb.getPatientVisitFundsBillingId().equals("")){
////                    alert = "<script type='text/javascript' charset='TIS-620'>alert('ไม่พบรหัส');</script>";
////                }else {
////                    setSaveBackTPatientVisitBillingTemp(branch_id, billing_number, bpv_fb.getVisitTotal(), status, bpv_fb.getPatientVisitFundsId());
////                }
//                if(flag.equals("search_billing")){
//                    v_bpv_f = bpv_fdb.getBackTPatientVisitFunds(branch_id, billing_number,"","billing_number");
//                }else{
//                    v_bpv_f = bpv_fdb.getBackTPatientVisitFunds(branch_id, billing_number,"","billing_number_hn");
//                }
//                for(int i=0;i<=v_bpv_f.size()-1;i++){
//                    bpv_fdb.bpv_f = (BackTPatientVisitFunds)v_bpv_f.get(i);
//                    if(bpv_fdb.bpv_f.getStatusBilling().equals("4")){
//                        alert = "<script type='text/javascript' charset='TIS-620'>alert('รายการนี้รับชำระไปแล้ว');</script>";
//                    }else if(bpv_fdb.bpv_f.getPatientVisitFundsId().equals("")){
//                        alert = "<script type='text/javascript' charset='TIS-620'>alert('ไม่พบรหัส');</script>";
//                    }else {
//                        setSaveBackTPatientVisitBillingTemp(branch_id, billing_number, bpv_fdb.bpv_f.getVisitTotal(),
//                                status, bpv_fdb.bpv_f.getPatientVisitFundsId());
//                    }
//                }
//            }
//        }
//        v_bpv_fbt = getBackTPatientVisitFundsBillingTemp("","", status);
//        for(int i=0;i<= v_bpv_fbt.size()-1;i++) {
//            bpv_fbt = new BackTPatientVisitFundsBillingTemp();
//            bpv_fdb.bpv_f = new BackTPatientVisitFunds();
//            bpv_fbt = (BackTPatientVisitFundsBillingTemp)v_bpv_fbt.get(i);
//            bpv_fdb.bpv_f = bpv_fdb.getBackTPatientVisitFundsByPK(branch_id, bpv_fbt.getBpvFId(),"");
////            amount = bpv_fdb.bpv_f.getVisitTotal() - bpv_fdb.bpv_f.getReceiveAmount();
//            if(status.equals("1")){
//                amount = bpv_fdb.bpv_f.getVisitTotal() - bpv_fdb.bpv_f.getReceiveAmount();
//                td_total = "<td align='right'><input type='text' id='txt_total"+i+"' value='"+amount+"' size='8' readonly/></td>"
//                        +"<td align='right'><input type='text' id='txt_fb_amount"+i+"' value='0.00' size='8' onchange='setAmount("+i+")' "+remarkDisable+" readonly /></td>"
//                        +"<td><input type='text' id='txt_fb_onhand"+i+"' value='0.00' size='8' onchange='setOnhand("+i+")' readonly/>"
//                        +"<input type='hidden' id='txt_fb_amounttemp"+i+"' value='0.00' size='8' /></td>";
//                td_remark = "<td><input type='text' id='txt_fb_remark"+i+"' size='10' onchange='setRemark("+i+")' "+remarkDisable+"/></td>";
//            }else{
//                td_total="<td><input type='hidden' id='txt_fb_amount"+i+"' value='"+bpv_fdb.bpv_f.getVisitTotal()+"' size='8' onchange='setAmount("+i+")'/></td>";
//                td_remark="";
//            }
//            txt+="<tr style='font-size: 12px'>"
//                    + "<td>"+(i+1)+"</td>"
//                    + "<td width='60'><label><input type='checkbox' name='chk_"+i+"' id ='chk_"+i+ "' value='' onchange='cal("+i+");'>เลือก</label></td>"
//                    + "<td>"+bpv_fdb.bpv_f.getBillingInvoiceNumber()+"<input type='hidden' id='txt_"+i+"' value='"+bpv_fdb.bpv_f.getBillingInvoiceNumber()+"'/><input type='hidden' id='txt_bpv_f_id"+i+"' value='"+bpv_fdb.bpv_f.getPatientVisitFundsId()+"'/></td>"
//                    + "<td>"+bpv_fdb.bpv_f.getPatientFullnamet()+"</td>"
//                    + "<td>"+bpv_fdb.bpv_f.getInjuryNumber()+"</td>"
//                    + "<td>"+config1.DateFormatDB2ShowHospital(bpv_fdb.bpv_f.getVisitDate(),"ddMMyyyy")+"</td>"
//                    + "<td>"+config1.NumberFormat(bpv_fdb.bpv_f.getVisitTotal())+"</td>"
//                    + td_total + td_remark
//                    + "</tr>";
//        }
//        bpv_fbt = new BackTPatientVisitFundsBillingTemp();
//        bpv_fbt = getCntSumBackTPatientVisitFundsBillingTemp(branch_id, status);
//        if(status.equals("1")){
//            th_total = "<td>คงเหลือ</td><td>รับชำระ</td><td>&nbsp;</td>";
//            th_remark = "<td>หมายเหตุ</td>";
//        }else{
//            th_total = "";
//            th_remark = "";
//        }
//        t_header="<tr style='font-size: 12px'>"
//                + "<td>ลำดับ</td>"
//                + "<td width='60'></td>"
//                + "<td>เลขที่</td>"
//                + "<td>ชื่อ-นามสกุล</td>"
//                + "<td>เลขที่สป</td>"+ "<td>วันที่รักษา</td>"
//                + "<td>ยอด</td>"
//                + th_total + th_remark + "</tr>";
//        txt_sum = "<table style='font-size: 12px'><tr><td>จำนวนบิล</td>"
//                + "<td><input type='text' id='txt_qty_bill' value='"+bpv_fbt.getBillingInvoiceNumber()+"' size='8' readonly></td>"
//                + "<td>จำนวนเงิน</td><td><input type='text' id='txt_amount_bill' value='"+bpv_fbt.getAmount()+"' size='8' readonly></td></tr></table>";
//        return txt_sum+"<table width='100%'>"+t_header+txt+"</table>"+alert;
//    }
    public void setDeleteAllBackTPatientVisitBillingTemp(String branch_id, String status) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Delete From back_t_patient_visit_funds_billing_temp Where status = '"+status+"'";
          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public Vector getBilling(String branch_id, String billing_id, String sub_system, String flag, String paid_id) {
//        Vector v_billing = new Vector();
//          if (flag.equals("status_billing_no"))
//            v_billing = bpv_fdb.getBackTPatientVisitFunds(branch_id, billing_id, paid_id, flag);
//          else if (flag.equals("status_billing_yes")) {
//            v_billing = getBackTPatientVisitFundsBilling(branch_id, billing_id, "", flag);
//          }else if(flag.equals("status_billing_in")){
//              v_billing = getBackTPatientVisitFundsBilling(branch_id, billing_id, "", flag);
//          }
//        return v_billing;
//    }
//    public String getTrBilling(String branch_id, String billing_id, String sub_system, String flag, String paid_id) {
//        String node_parent = "", text_h = "", chk_print = "", chk_src = "", script = "", billing_in_id="";
//        StringBuilder txt = new StringBuilder();
//        Vector v_billing = new Vector();
//        if(flag.equals("status_billing_in")){
//            billing_in_id = paid_id.replace(".", "','");
//            if(billing_in_id.substring(0, 3).equals("','")){
//                billing_in_id = billing_in_id.substring(2)+"'";
//            }
//        }else{
//            billing_in_id = billing_id;
//        }
//        v_billing = getBilling(branch_id, billing_in_id, sub_system, flag, paid_id);
//        for (int i = 0; i <= v_billing.size() - 1; i++) {
//            try {
//              if (flag.equals("status_billing_no")) {
//                node_parent = "chk_" + i;
//                bpv_fdb.bpv_f = new BackTPatientVisitFunds();
//                bpv_fdb.bpv_f = ((BackTPatientVisitFunds)v_billing.get(i));
//                if (bpv_fdb.bpv_f.getStatusBilling().equals("0")) {
//                  chk_print = "checked";
//                  chk_src = "images/print_red.png";
//                } else {
//                  chk_print = "";
//                  chk_src = "";
//                }
//                txt.append("<tr class='style14r'><td align='center'>").append((i + 1)).append("</td>")
//        .append("<td><label><input type='checkbox' name='").append(node_parent).append("' id ='").append(node_parent).append("' value='' ").append(chk_print).append(" onchange='chkbilling(").append(")' >").append(bpv_fdb.bpv_f.getVisitVn()).append("</label></td>")
//        .append("<td>").append(bpv_fdb.bpv_f.getPatientFullnamet()).append("</td>")
//        .append("<td align='center'>").append(config1.DateFormatDB2ShowHospital(bpv_fdb.bpv_f.getVisitDate(), "ddMMyyyy")).append("</td>")
//        .append("<td align='right'>").append(config1.NumberFormat(bpv_fdb.bpv_f.getVisitTotal())).append("</td>")
//        .append("<td>").append(bpv_fdb.bpv_f.getVisitPaidNamet()).append("</td>")
//        .append("<td align='right'>").append(bpv_fdb.bpv_f.getInjuryNumber()).append("</td>")
//        .append("<td><img id='img_" + i + "' name = 'img_").append(i).append("' src='").append(chk_src)
//                        .append("' alt='' align='top' border='0' title='พิมพ์ billing' onclick='chkbilling(").append(i).append(")'/>")
//                        .append("<input type='hidden' id='txt_patient_funds_id").append(i).append("' value='")
//                        .append(bpv_fdb.bpv_f.getPatientVisitFundsId()).append("'><input type='hidden' id='txt_total").append(i)
//                        .append("' value='").append(bpv_fdb.bpv_f.getVisitTotal()).append("'></td></tr>");
//              }else if (flag.equals("status_billing_yes") || (flag.equals("status_billing_in"))) {
//                node_parent = "chk_" + i;
//                bpv_fb = new BackTPatientVisitFundsBilling();
//                bpv_fb = ((BackTPatientVisitFundsBilling)v_billing.get(i));
//                if (bpv_fb.getStatusPrint().equals("0")) {
//                  chk_print = "checked";
//                  chk_src = "images/print_green.png";
//                } else {
//                  chk_print = "";
//                  chk_src = "";
//                }
//                txt.append("<tr class='style14r'><td align='center'>txt_patient_funds_billing_id").append((i + 1)).append("</td>")
//        .append("<td><label><input type='checkbox' name='").append(node_parent).append("' id ='").append(node_parent).append("' value='' ").append(chk_print).append(" onchange='chkbilling(").append(i).append(")' >").append(bpv_fb.getVisitVn()).append("</label></td>")
//        .append("<td>").append(bpv_fb.getPatientFullnamet()).append("</td>").append("<td align='center'>").append(config1.DateFormatDB2ShowHospital(bpv_fb.getVisitDate(), "ddMMyyyy")).append("</td>")
//        .append("<td align='right'>").append(config1.NumberFormat(bpv_fb.getVisitTotal())).append("</td>")
//        .append("<td>").append(bpv_fb.getVisitPaidNamet()).append("</td>").append("<td align='right'>").append(bpv_fb.getBillingInvoiceNumber()).append("</td>")
//        .append("<td><img id='img_").append(i).append("' name = 'img_").append(i).append("' src='").append(chk_src).append("' alt='' align='top' border='0' title='พิมพ์ billing' onclick='printBilling(").append(i).append(")'/>")
//        .append("<input type='hidden' id='txt_patient_funds_billing_id").append(i).append("' value='").append(bpv_fb.getPatientVisitFundsBillingId()).append("'>")
//        .append("<input type='hidden' id='txt_total").append(i).append("' value='").append(bpv_fb.getVisitTotal()).append("'></td></tr>");
//              }
//          }catch (Exception ex){
//            Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
//          }
//        }
//        text_h = "<thead> <tr align='center' class='style14r'><th width='5' align='center'>ลำดับ</th> <th width='100' align='left'>VN</th> <th width='250' align='left'>ชื่อ-นามสกุล</th> <th width='85' align='left'>วันที่รักษา</th> <th width='80' align='left'>มูลค่า</th> <th width='80' align='left'>รับชำระ</th> <th width='60' align='left'>เลขที่ </th> <th width='40' align='left'>พิมพ์</th> </tr></thead>";
//        return "<table width='100%'>" + text_h + txt + "<input type='hidden' id='txt_billing_cover_row' value='" + (v_billing.size() - 1) + "'></table>" + script;
//    }
    public void setSaveBackTPatientVisitBillingTemp(String branch_id, String billing_number, Double amount, String status, String bpvFId, String statusDebtorVoid) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Insert Into back_t_patient_visit_funds_billing_temp "
                  + "(billing_invoice_number, amount, status, patient_visit_funds_id, status_debtor_void) "
                  + "Values ('"+billing_number+"',"+amount+",'"+status+"','"+bpvFId+"','"+statusDebtorVoid+"')";
          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setDeleteBackTPatientVisitBillingTemp(String branch_id, String billing_number, String status) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Delete From back_t_patient_visit_funds_billing_temp "
                  + "Where billing_invoice_number = '"+ billing_number+"' and status = '"+status+"'";
          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public BackTPatientVisitFundsBillingItem setCastPatientVisitFundsBillingItem(BackTPatientVisitContactBillingItem bpv_cbi) {
//        bpv_fbi = new BackTPatientVisitFundsBillingItem();
//        bpv_fbi.setBItemBillingSubgroupId(bpv_cbi.getBItemBillingSubgroupId());
//        bpv_fbi.setBItemId(bpv_cbi.getBItemId());
//        bpv_fbi.setBillingInvoiceItemActive(bpv_cbi.getBillingInvoiceItemActive());
//        bpv_fbi.setBillingInvoiceItemTotal(bpv_cbi.getBillingInvoiceItemTotal());
//        bpv_fbi.setBillingInvoiceNumber(bpv_cbi.getBillingInvoiceNumber());
//
//        bpv_fbi.setClaimId(bpv_cbi.getClaimId());
//        bpv_fbi.setClaimNamet(bpv_cbi.getClaimNamet());
//        bpv_fbi.setDepartmentNamet(bpv_cbi.getDepartmentNamet());
//        bpv_fbi.setPatientVisitFundsItemId("");
//        bpv_fbi.setPatientVisitId(bpv_cbi.getPatientVisitId());
//
//        bpv_fbi.setTBillingId(bpv_cbi.getTBillingId());
//        bpv_fbi.setTBillingInvoiceDateTime(bpv_cbi.getTBillingInvoiceDateTime());
//        bpv_fbi.setTBillingInvoiceItemId(bpv_cbi.getTBillingInvoiceItemId());
//        bpv_fbi.setTBillingInvoiceItemNamet(bpv_cbi.getTBillingInvoiceItemNamet());
//        bpv_fbi.setTBillingInvoiceTime(bpv_cbi.getTBillingInvoiceTime());
//
//        bpv_fbi.setTOrderItemId(bpv_cbi.getTOrderItemId());
//        bpv_fbi.setTPatientId(bpv_cbi.getTPatientId());
//        bpv_fbi.setTPaymentId(bpv_cbi.getTPaymentId());
//        bpv_fbi.setVisitId(bpv_cbi.getVisitId());
//        bpv_fbi.setVisitPatientSelfDoctor(bpv_cbi.getVisitPatientSelfDoctor());
//
//        bpv_fbi.setVisitVn(bpv_cbi.getVisitVn());
//        bpv_fbi.setDepartmentId(bpv_cbi.getDepartmentId());
//        bpv_fbi.setVisitHn(bpv_cbi.getVisitHn());
//        bpv_fbi.setBranchId(config1.StringNull(bpv_cbi.getBranchId()));
//        bpv_fbi.setSysStatus(config1.StringNull(bpv_cbi.getSysStatus()));
//
//        bpv_fbi.setItemDiscount(bpv_cbi.getItemDiscount());
//        bpv_fbi.setItemPaid(bpv_cbi.getItemPaid());
//        bpv_fbi.setItemTotal(bpv_cbi.getItemTotal());
//        bpv_fbi.setCode(config1.StringNull(bpv_cbi.getCode()));
//        bpv_fbi.setRecordStatus("0");
//
//        bpv_fbi.setPatientVisitFundsItemId(config1.StringNull(bpv_cbi.getPatientVisitContactItemId()));
//        bpv_fbi.setFItemGroupId(config1.StringNull(bpv_cbi.getFItemGroupId()));
//        bpv_fbi.setPatientVisitFundsBillingItemActive("1");
//        bpv_fbi.setNode(config1.StringNull(bpv_cbi.getNode()));
//        bpv_fbi.setSortLine1(bpv_cbi.getSortLine1());
//        bpv_fbi.setSortLine2(bpv_cbi.getSortLine2());
//
//        bpv_fbi.setSortLine3(bpv_cbi.getSortLine3());
//        bpv_fbi.setSortLine4(bpv_cbi.getSortLine4());
//        bpv_fbi.setSortLine5(bpv_cbi.getSortLine5());
//        bpv_fbi.setPatientVisitFundsBillingId(bpv_cbi.getPatientVisitContactBillingId());
//        bpv_fbi.setPatientVisitFundsBillingItemId("");
//
//        bpv_fbi.setEditStatus(bpv_cbi.getEditStatus());
//        return bpv_fbi;
//    }
//    public BackTPatientVisitFundsBillingItem setCastPatientVisitFundsBillingItem(BackTPatientVisitItem bpvi) {
//        bpv_fbi = new BackTPatientVisitFundsBillingItem();
//        bpv_fbi.setBItemBillingSubgroupId(bpvi.getBItemBillingSubgroupId());
//        bpv_fbi.setBItemId(bpvi.getBItemId());
//        bpv_fbi.setBillingInvoiceItemActive(bpvi.getBillingInvoiceItemActive());
//        bpv_fbi.setBillingInvoiceItemTotal(bpvi.getBillingInvoiceItemTotal());
//        bpv_fbi.setBillingInvoiceNumber(bpvi.getBillingInvoiceNumber());
//
//        bpv_fbi.setClaimId(bpvi.getClaimId());
//        bpv_fbi.setClaimNamet(bpvi.getClaimNamet());
//        bpv_fbi.setDepartmentNamet(bpvi.getDepartmentNamet());
//        bpv_fbi.setPatientVisitFundsItemId("");
//        bpv_fbi.setPatientVisitId(bpvi.getPatientVisitId());
//
//        bpv_fbi.setTBillingId(bpvi.getTBillingId());
//        bpv_fbi.setTBillingInvoiceDateTime(bpvi.getTBillingInvoiceDateTime());
//        bpv_fbi.setTBillingInvoiceItemId(bpvi.getTBillingInvoiceItemId());
//        bpv_fbi.setTBillingInvoiceItemNamet(bpvi.getTBillingInvoiceItemNamet());
//        bpv_fbi.setTBillingInvoiceTime(bpvi.getTBillingInvoiceTime());
//
//        bpv_fbi.setTOrderItemId(bpvi.getTOrderItemId());
//        bpv_fbi.setTPatientId(bpvi.getTPatientId());
//        bpv_fbi.setTPaymentId(bpvi.getTPaymentId());
//        bpv_fbi.setVisitId(bpvi.getVisitId());
//        bpv_fbi.setVisitPatientSelfDoctor(bpvi.getVisitPatientSelfDoctor());
//
//        bpv_fbi.setVisitVn(bpvi.getVisitVn());
//        bpv_fbi.setDepartmentId(bpvi.getDepartmentId());
//        bpv_fbi.setVisitHn(bpvi.getVisitHn());
//        bpv_fbi.setBranchId(config1.StringNull(bpvi.getBranchId()));
//        bpv_fbi.setSysStatus(config1.StringNull(bpvi.getSysStatus()));
//
//        bpv_fbi.setItemDiscount(bpvi.getItemDiscount());
//        bpv_fbi.setItemPaid(bpvi.getItemPaid());
//        bpv_fbi.setItemTotal(bpvi.getItemTotal());
//        bpv_fbi.setEditStatus(config1.StringNull(bpvi.getEditStatus()));
//        bpv_fbi.setRecordStatus("0");
//
//        bpv_fbi.setPatientVisitItemId(config1.StringNull(bpvi.getPatientVisitBillingItemId()));
//        bpv_fbi.setFItemGroupId(config1.StringNull(bpvi.getFItemGroupId()));
//        bpv_fbi.setPatientVisitFundsBillingItemActive("1");
//
//        return bpv_fbi;
//    }
//    public BackTPatientVisitFundsBillingItem setCastPatientVisitFundsBillingItem(BackTPatientVisitFundsItem bpv_fi) {
//        bpv_fbi = new BackTPatientVisitFundsBillingItem();
//        bpv_fbi.setBItemBillingSubgroupId(bpv_fi.getBItemBillingSubgroupId());
//        bpv_fbi.setBItemId(bpv_fi.getBItemId());
//        bpv_fbi.setBillingInvoiceItemActive(bpv_fi.getBillingInvoiceItemActive());
//        bpv_fbi.setBillingInvoiceItemTotal(bpv_fi.getBillingInvoiceItemTotal());
//        bpv_fbi.setBillingInvoiceNumber(bpv_fi.getBillingInvoiceNumber());
//
//        bpv_fbi.setClaimId(bpv_fi.getClaimId());
//        bpv_fbi.setClaimNamet(bpv_fi.getClaimNamet());
//        bpv_fbi.setDepartmentNamet(bpv_fi.getDepartmentNamet());
//        bpv_fbi.setPatientVisitFundsItemId("");
//        bpv_fbi.setPatientVisitId(bpv_fi.getPatientVisitId());
//
//        bpv_fbi.setTBillingId(bpv_fi.getTBillingId());
//        bpv_fbi.setTBillingInvoiceDateTime(bpv_fi.getTBillingInvoiceDateTime());
//        bpv_fbi.setTBillingInvoiceItemId(bpv_fi.getTBillingInvoiceItemId());
//        bpv_fbi.setTBillingInvoiceItemNamet(bpv_fi.getTBillingInvoiceItemNamet());
//        bpv_fbi.setTBillingInvoiceTime(bpv_fi.getTBillingInvoiceTime());
//
//        bpv_fbi.setTOrderItemId(bpv_fi.getTOrderItemId());
//        bpv_fbi.setTPatientId(bpv_fi.getTPatientId());
//        bpv_fbi.setTPaymentId(bpv_fi.getTPaymentId());
//        bpv_fbi.setVisitId(bpv_fi.getVisitId());
//        bpv_fbi.setVisitPatientSelfDoctor(bpv_fi.getVisitPatientSelfDoctor());
//
//        bpv_fbi.setVisitVn(bpv_fi.getVisitVn());
//        bpv_fbi.setDepartmentId(bpv_fi.getDepartmentId());
//        bpv_fbi.setVisitHn(bpv_fi.getVisitHn());
//        bpv_fbi.setBranchId(config1.StringNull(bpv_fi.getBranchId()));
//        bpv_fbi.setSysStatus(config1.StringNull(bpv_fi.getSysStatus()));
//
//        bpv_fbi.setItemDiscount(bpv_fi.getItemDiscount());
//        bpv_fbi.setItemPaid(bpv_fi.getItemPaid());
//        bpv_fbi.setItemTotal(bpv_fi.getItemTotal());
//        //    bpv_fbi.setCode(bpvdb.config1.StringNull(bpv_fi.getCode()));
//        bpv_fbi.setRecordStatus("0");
//
//        //    bpv_fbi.setPatientVisitFundsItemId(bpvdb.config1.StringNull(bpv_fi.getPatientVisitContactItemId()));
//        bpv_fbi.setFItemGroupId(config1.StringNull(bpv_fi.getFItemGroupId()));
//        bpv_fbi.setPatientVisitFundsBillingItemActive("1");
//        //    bpv_fbi.setNode(bpvdb.config1.StringNull(bpv_fi.getNode()));
//        //    bpv_fbi.setSortLine1(bpv_fi.getSortLine1());
//        //    bpv_fbi.setSortLine2(bpv_fi.getSortLine2());
//
//        //    bpv_fbi.setSortLine3(bpv_fi.getSortLine3());
//        //    bpv_fbi.setSortLine4(bpv_fi.getSortLine4());
//        //    bpv_fbi.setSortLine5(bpv_fi.getSortLine5());
//        //    bpv_fbi.setPatientVisitFundsBillingId(bpv_fi.getPatientVisitContactBillingId());
//        bpv_fbi.setPatientVisitFundsBillingItemId("");
//
//        //    bpv_fbi.setEditStatus(bpv_fi.getEditStatus());
//        return bpv_fbi;
//    }
//    public BackTPatientVisitFundsBilling setCastPatientVisitFundsBilling(BackTPatientVisitFunds bpv_f) {
//        try {
//          bpv_fb = new BackTPatientVisitFundsBilling();
//          bpv_fb.setBServicePointId(bpv_f.getBServicePointId());
//          bpv_fb.setBVisitClinicId(bpv_f.getBVisitClinicId());
//          bpv_fb.setBranchId(bpv_f.getBranchId());
//          bpv_fb.setDepartmentNamet(bpv_f.getDepartmentNamet());
//          bpv_fb.setDoctorNamet(bpv_f.getDoctorNamet());
//
//          bpv_fb.setPatientFullnamet(bpv_f.getPatientFullnamet());
//          bpv_fb.setPatientImportId(bpv_f.getPatientImportId());
//          bpv_fb.setPatientVisitId(bpv_f.getPatientVisitId());
//          bpv_fb.setSysStatus(bpv_f.getSysStatus());
//          bpv_fb.setTPatientId(bpv_f.getTPatientId());
//
//          bpv_fb.setVisitBeginVisitTime(bpv_f.getVisitBeginVisitTime());
//          bpv_fb.setVisitClaimId(bpv_f.getVisitClaimId());
//          bpv_fb.setVisitClaimNamet(bpv_f.getVisitClaimNamet());
//          bpv_fb.setVisitContactId(bpv_f.getVisitContactId());
//          bpv_fb.setVisitDate(bpv_f.getVisitDate());
//          bpv_fb.setVisitDiagnosisNotice(bpv_f.getVisitDiagnosisNotice());
//          bpv_fb.setVisitDiscount(bpv_f.getVisitDiscount());
//          bpv_fb.setVisitFinancialDischargeTime(bpv_f.getVisitFinancialDischargeTime());
//          bpv_fb.setVisitFirstVisit(bpv_f.getVisitFirstVisit());
//          bpv_fb.setVisitHn(bpv_f.getVisitHn());
//
//          bpv_fb.setVisitHospitalService(bpv_f.getVisitHospitalService());
//          bpv_fb.setVisitNotice(bpv_f.getVisitNotice());
//          bpv_fb.setVisitPaid(bpv_f.getVisitPaid());
//          bpv_fb.setVisitPaidId(bpv_f.getVisitPaidId());
//          bpv_fb.setVisitPaidNamet(bpv_f.getVisitPaidNamet());
//
//          bpv_fb.setVisitPatientAge(bpv_f.getVisitPatientAge());
//          bpv_fb.setVisitPatientSelfDoctor(bpv_f.getVisitPatientSelfDoctor());
//          bpv_fb.setVisitTotal(bpv_f.getVisitTotal());
//          bpv_fb.setVisitVn(bpv_f.getVisitVn());
//          bpv_fb.setVisitContactNamet(bpv_f.getVisitContactNamet());
//
//          bpv_fb.setPatientVisitFundsId(bpv_f.getPatientVisitFundsId());
//          bpv_fb.setPatientVisitFundsBillingId("");
//          bpv_fb.setPatientVisitFundsBillingActive("1");
//          bpv_fb.setBillingCoverNumber("");
//          bpv_fb.setBillingInvoiceNumber("");
//
//          bpv_fb.setStatusPrint("0");
//          bpv_fb.setStatusPayment("0");
//          bpv_fb.setInjuryNumber(bpv_f.getInjuryNumber());
//        } catch (Exception ex) {
//          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return bpv_fb;
//    }
//    public BackTPatientVisitFundsBilling setCastPatientVisitFundsBilling(BackTPatientVisitContactBilling bpv_cb) {
//        bpv_fb = new BackTPatientVisitFundsBilling();
//        bpv_fb.setBServicePointId(bpv_cb.getBServicePointId());
//        bpv_fb.setBVisitClinicId(bpv_cb.getBVisitClinicId());
//        bpv_fb.setBranchId(bpv_cb.getBranchId());
//        bpv_fb.setDepartmentNamet(bpv_cb.getDepartmentNamet());
//        bpv_fb.setDoctorNamet(bpv_cb.getDoctorNamet());
//
//        bpv_fb.setPatientFullnamet(bpv_cb.getPatientFullnamet());
//        bpv_fb.setPatientImportId(bpv_cb.getPatientImportId());
//        bpv_fb.setPatientVisitId(bpv_cb.getPatientVisitId());
//        bpv_fb.setSysStatus(bpv_cb.getSysStatus());
//        bpv_fb.setTPatientId(bpv_cb.getTPatientId());
//
//        bpv_fb.setVisitBeginVisitTime(bpv_cb.getVisitBeginVisitTime());
//        bpv_fb.setVisitClaimId(bpv_cb.getVisitClaimId());
//        bpv_fb.setVisitClaimNamet(bpv_cb.getVisitClaimNamet());
//        bpv_fb.setVisitContactId(bpv_cb.getVisitContactId());
//        bpv_fb.setVisitDate(bpv_cb.getVisitDate());
//
//        bpv_fb.setVisitDiagnosisNotice(bpv_cb.getVisitDiagnosisNotice());
//        bpv_fb.setVisitDiscount(bpv_cb.getVisitDiscount());
//        bpv_fb.setVisitFinancialDischargeTime(bpv_cb.getVisitFinancialDischargeTime());
//        bpv_fb.setVisitFirstVisit(bpv_cb.getVisitFirstVisit());
//        bpv_fb.setVisitHn(bpv_cb.getVisitHn());
//
//        bpv_fb.setVisitHospitalService(bpv_cb.getVisitHospitalService());
//        bpv_fb.setVisitNotice(bpv_cb.getVisitNotice());
//        bpv_fb.setVisitPaid(bpv_cb.getVisitPaid());
//        bpv_fb.setVisitPaidId(bpv_cb.getVisitPaidId());
//        bpv_fb.setVisitPaidNamet(bpv_cb.getVisitPaidNamet());
//
//        bpv_fb.setVisitPatientAge(bpv_cb.getVisitPatientAge());
//        bpv_fb.setVisitPatientSelfDoctor(bpv_cb.getVisitPatientSelfDoctor());
//        bpv_fb.setVisitTotal(bpv_cb.getVisitTotal());
//        bpv_fb.setVisitVn(bpv_cb.getVisitVn());
//        bpv_fb.setVisitContactNamet(bpv_cb.getVisitContactNamet());
//
//        bpv_fb.setPatientVisitFundsId(bpv_cb.getPatientVisitContactId());
//        bpv_fb.setPatientVisitFundsBillingId("");
//        bpv_fb.setPatientVisitFundsBillingActive("1");
//        bpv_fb.setBillingCoverNumber("");
//        bpv_fb.setBillingInvoiceNumber("");
//
//        bpv_fb.setStatusPrint("0");
//        bpv_fb.setStatusPayment("0");
//
//        return bpv_fb;
//    }
//    public String getTrPatientVisitFundsBilling(String branch_id, String flagpage, String status_billing, String date_end, String visit_hn) {
//        String node_parent="", node_child="", node_vn="", paid="", data_item="",link_void="", helpLink="",helpStatusBill="";
//        String date_visit="", injury_number="",hn_search="",date_search="", billing_number_search="";
//        Integer row=100, row_detail=100,row_item=1, row_vn=1;
//        StringBuilder link_vn = new StringBuilder();
//        StringBuilder chk_box = new StringBuilder();
//        StringBuilder link_injury = new StringBuilder();
//        //        Double paid=0.0, paid_item=0.0, paid_detail=0.0;
//        //        BContact contact = new BContact();
//        sql.delete(0, sql.length());
//        txt.delete(0, txt.length());
//        if (visit_hn.equals(""))
//            hn_search = "";
//        else 
//            hn_search = " and bpv_c." + bpv_fdb.bpv_f.getFVisitHn() + " like '%" + visit_hn + "' ";
//        if (date_end.equals(""))
//            date_search = "";
//        else 
//            date_search = " and bpv_c." + bpv_fdb.bpv_f.getFCloseDayDate() + " <= '" + date_end + "' ";
//        sql.append("Select bpv_c.").append(bpv_fdb.bpv_f.getFVisitContactId()).append(", min(")
//            .append(bpv_fdb.bpv_f.getFVisitContactNamet()).append(") as ").append(bpv_fdb.bpv_f.getFVisitContactNamet())
//            .append(", ").append("count(1) as cnt ")
//            .append(" From ").append(bpv_fdb.bpv_f.getBackTPatientVisitFunds()).append(" as bpv_c ")
//            .append("Where ").append(bpv_fdb.bpv_f.getFPatientVisitFundsActive()).append("='1' and ")
//            .append(bpv_fdb.bpv_f.getFStatusBilling()).append(" in (").append(status_billing).append(") and ")
//            .append(bpv_fdb.bpv_f.getFBranchId()).append(" ='").append(branch_id).append("' ").append(hn_search).append(date_search)
//            .append("Group By ").append(bpv_fdb.bpv_f.getFVisitContactId())
//            .append(" Order By ").append(bpv_fdb.bpv_f.getFVisitContactNamet());
//        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement st = conn.createStatement();
//            Statement st_detail = conn.createStatement();
//            Statement st_vn = conn.createStatement();
//            Statement st_item = conn.createStatement();
//            //      Statement st_item = conn.createStatement();
//            ResultSet rs = st.executeQuery(sql.toString());
//            //      Integer localInteger1;
//            while (rs.next()) {
//            node_parent = row.toString();
//            txt.append("<tr id='tr_").append(node_parent).append("'><td >")
//                .append(chk_box.toString()).append("<font color='black'><b>")
//                .append(rs.getString(bpv_fdb.bpv_f.getFVisitContactNamet())).append("</b></font></td>")
//                .append("<td align='center'>").append(rs.getString("cnt").toString()).append("[visit]</td>")
//                .append("<td><input type='hidden' id='td_").append(node_parent).append("' name='td_").append(node_parent)
//                .append("'value='").append(rs.getString("cnt").toString()).append("'>").append("</td></tr>");
//            sql.delete(0, sql.length());
//    sql.append("Select bpv_c.").append(bpv_fdb.bpv_f.getFPatientFullnamet()).append(" as ").append(bpv_fdb.bpv_f.getFPatientFullnamet())
//    .append(",min(bpv_c.").append(bpv_fdb.bpv_f.getFVisitHn()).append(") as ").append(bpv_fdb.bpv_f.getFVisitHn()).append(",")
//    .append(" count(1) as cnt, sum(").append(bpv_fdb.bpv_fi.getFItemTotal()).append(") as paid, bpv_c.")
//    .append(bpv_fdb.bpv_f.getFInjuryNumber()).append(", bpv_c.").append(bpv_fdb.bpv_f.getFStatusBilling()).append(", bpv_c.")
//    .append(bpv_fdb.bpv_f.getFBillingInvoiceNumber()).append(", min(bpv_c.").append(bpv_fdb.bpv_f.getFPatientVisitFundsBillingId()).append(") as ").append(bpv_fdb.bpv_f.getFPatientVisitFundsBillingId())
//    .append(" From ").append(bpv_fdb.bpv_f.getBackTPatientVisitFunds()).append(" as bpv_c ")
//    .append("left join ").append(bpv_fdb.bpv_fi.getBackTPatientVisitFundsItem()).append(" as bpv_ci on ")
//    .append(bpv_fdb.bpv_fi.getFBillingInvoiceItemActive()).append("='1' and ")
//    .append(" bpv_c.").append(bpv_fdb.bpv_f.getFPatientVisitFundsId()).append(" = bpv_ci.").append(bpv_fdb.bpv_fi.getFPatientVisitFundsId())
//    .append(" ")
//    .append("Where bpv_c.").append(bpv_fdb.bpv_f.getFBranchId()).append(" = '").append(branch_id).append("' and bpv_c.")
//    .append(bpv_fdb.bpv_f.getFStatusBilling()).append(" in (").append(status_billing).append(") and bpv_c.")
//    .append(bpv_fdb.bpv_f.getFVisitContactId()).append("='").append(rs.getString(bpv_fdb.bpv_f.getFVisitContactId())).append("' and ")
//    .append(bpv_fdb.bpv_f.getFPatientVisitFundsActive()).append("='1' ").append(hn_search).append(date_search)
//    .append(" Group By bpv_c.").append(bpv_fdb.bpv_f.getFPatientFullnamet()).append(", bpv_c.")
//    .append(bpv_fdb.bpv_f.getFInjuryNumber()).append(", ").append(bpv_fdb.bpv_f.getFStatusBilling()).append(", bpv_c.")
//    .append(bpv_fdb.bpv_f.getFBillingInvoiceNumber())
//    .append(" Order By bpv_c.").append(bpv_fdb.bpv_f.getFPatientFullnamet());
//            ResultSet rs_detail = st_detail.executeQuery(sql.toString());
//            while (rs_detail.next()) {
//                helpLink="";
//              node_child = "";
//              link_injury.delete(0, link_injury.length());
//              injury_number = "";//.append("</font> ""<font color='red'> <b>Injury no [").append(injury_number).append("] </b></font>")
//              node_child = row.toString() + row_detail.toString();
//              injury_number = config1.StringNull(rs_detail.getString(bpv_fdb.bpv_f.getFInjuryNumber()));
//              if(injury_number.equals("333333333333")){
//                  data_item="";
//              }
//              if(rs_detail.getString(bpv_fdb.bpv_f.getFStatusBilling()).equals("1") && (rs_detail.getString(bpv_fdb.bpv_f.getFPatientVisitFundsBillingId()).length()>0)){//รวม bill
//                  link_injury.append("<a href='javascript:showInjury(").append(rs_detail.getString(bpv_fdb.bpv_f.getFPatientVisitFundsBillingId())).append(")'/><font color='blue'><b>").append(rs_detail.getString(bpv_fdb.bpv_f.getFPatientFullnamet())).append("</b> hn ")
//                      .append(rs_detail.getString(bpv_fdb.bpv_f.getFVisitHn())).append("</font> <font color='red'> <b>Injury no [").append(injury_number).append("] </b></font></a>");
//              }else if(rs_detail.getString(bpv_fdb.bpv_f.getFStatusBilling()).equals("2")){
//                  link_injury.append("<font color='blue'><b>").append(rs_detail.getString(bpv_fdb.bpv_f.getFPatientFullnamet())).append("</b> hn ")
//                      .append(rs_detail.getString(bpv_fdb.bpv_f.getFVisitHn())).append("</font> <font color='red'> <b>Injury no [").append(injury_number).append("] </b></font>")
//                      .append("<font color ='orange'><b> เลขที่บิล ").append(rs_detail.getString(bpv_fdb.bpv_f.getFBillingInvoiceNumber())).append("</b></font>");
//              }else{
//                  link_void="";
//                  if(rs_detail.getString(bpv_fdb.bpv_f.getFStatusBilling()).equals("0") && rs_detail.getString(bpv_fdb.bpv_f.getFBillingInvoiceNumber()).length()>0){
//                      link_void = "<font color ='pink'><b> เลขที่บิล "+rs_detail.getString(bpv_fdb.bpv_f.getFBillingInvoiceNumber())+"[ยกเลิก]</b></font>";
//                  }
//                  link_injury.append("<font color='blue'><b>").append(rs_detail.getString(bpv_fdb.bpv_f.getFPatientFullnamet())).append("</b> hn ")
//                      .append(rs_detail.getString(bpv_fdb.bpv_f.getFVisitHn())).append("</font> <font color='blue'> <b>Injury no [").append(injury_number).append("] </b></font>")
//                      .append(link_void);
//              }
//              if(rs_detail.getString(bpv_fdb.bpv_f.getFStatusBilling()).equals("0")){
//                  helpStatusBill="รับข้อมูล ยังไม่ออกบิล";
//              }else if(rs_detail.getString(bpv_fdb.bpv_f.getFStatusBilling()).equals("1")){
//                  helpStatusBill="รวมบิล";
//              }else if(rs_detail.getString(bpv_fdb.bpv_f.getFStatusBilling()).equals("2")){
//                  helpStatusBill="ตั้งหนี้แล้ว";
//              }
//              helpLink = " title = 'สถานะบิล "+rs_detail.getString(bpv_fdb.bpv_f.getFStatusBilling())+" "+helpStatusBill+" billing_id "+rs_detail.getString(bpv_fdb.bpv_f.getFPatientVisitFundsBillingId())+"'";
//                if (rs_detail.getString(bpv_fdb.bpv_f.getFBillingInvoiceNumber()) == null)
//                    billing_number_search = " and bpv_c."+bpv_fdb.bpv_f.getFBillingInvoiceNumber() + " is null ";
//                else 
//                    billing_number_search = " and bpv_c."+bpv_fdb.bpv_f.getFBillingInvoiceNumber() + " = '"+rs_detail.getString(bpv_fdb.bpv_f.getFBillingInvoiceNumber()).replace("'", "''")+"' ";
//                if(rs_detail.getString("paid") != null)
//                    paid = rs_detail.getString("paid");
//                else
//                    paid = "0.0";
//              txt.append("<tr "+helpLink+" id ='tr_").append(node_child).append("' class='child-of-tr_").append(node_parent).append("'><td>")
//                      .append(chk_box.toString()).append("<font color='blue'>").append(link_injury.toString()).append("</font></td>")
//                      .append("<td align='center'><font color='blue'>").append(rs_detail.getString("cnt")).append("[item]</font></td>")
//                      .append("<td align='center'><font color='blue'>").append(config1.NumberFormat(paid)).append("[บาท]</font>")
//                      .append("<input type='hidden' id='row_").append(node_child).append("' name='row_").append(node_child)
//                      .append("'value='").append(rs_detail.getString("paid")).append("'>").append("<input type='hidden' id='txt_")
//                      .append(node_child).append("' name='txt_").append(node_child).append("'value='")
//                      .append(rs_detail.getString(bpv_fdb.bpv_f.getFVisitHn())).append("'>")
//                      .append("<input type='hidden' id='txt_injury_number").append(node_child).append("' value='").append(injury_number).append("' />").append("</td></tr>");
//              sql.delete(0, sql.length());
//              sql.append("Select bpv_c.").append(bpv_fdb.bpv_f.getFVisitBeginVisitTime()).append(" ,bpv_c.")
//                  .append(bpv_fdb.bpv_f.getFVisitVn()).append(" ,").append("bpv_c.").append(bpv_fdb.bpv_f.getFVisitDate())
//                  .append(", ").append("bpv_c.").append(bpv_fdb.bpv_f.getFPatientVisitFundsId()).append(" ")
//                  .append("From ").append(bpv_fdb.bpv_f.getBackTPatientVisitFunds()).append(" as bpv_c ")
//                  .append("Where bpv_c.").append(bpv_fdb.bpv_f.getFBranchId()).append(" = '").append(branch_id)
//                  .append("' and bpv_c.").append(bpv_fdb.bpv_f.getFStatusBilling()).append(" in (").append(status_billing)
//                  .append(") and bpv_c.").append(bpv_fdb.bpv_f.getFVisitContactId()).append("='").append(rs.getString(bpv_fdb.bpv_f.getFVisitContactId()))
//                  .append("' and ").append(bpv_fdb.bpv_f.getFPatientVisitFundsActive()).append("='1' and bpv_c.")
//                  .append(bpv_fdb.bpv_f.getFInjuryNumber()).append("='").append(injury_number).append("' ")
//                  .append(hn_search).append(date_search).append(" and bpv_c.")
//                  .append(bpv_fdb.bpv_f.getFStatusBilling()).append(" = '").append(rs_detail.getString(bpv_fdb.bpv_f.getFStatusBilling())).append("' ")
//                  .append(billing_number_search)
//                  .append("Order By bpv_c.").append(bpv_fdb.bpv_f.getFVisitDate())
//                  .append(", bpv_c.").append(bpv_fdb.bpv_f.getFVisitBeginVisitTime());
//              ResultSet rs_vn = st_vn.executeQuery(sql.toString());
//              while (rs_vn.next()) {
//                node_vn = "";
//                helpLink="";
//                link_vn.delete(0, link_vn.length());
//                date_visit = config1.DateFormatDB2ShowHospital(rs_vn.getString(bpv_fdb.bpv_f.getFVisitDate()), "ddMMyyyy");
//                node_vn = row_vn.toString() + node_child + "-" + rs_vn.getString(bpv_fdb.bpv_f.getFVisitVn());
//                if(rs_detail.getString(bpv_fdb.bpv_f.getFStatusBilling()).equals("0")){
//                    data_item = config1.NumberFormat(bpv_fdb.getSumFundsItemInjuryNumber(st_item, rs_vn.getString(bpv_fdb.bpv_f.getFPatientVisitFundsId()),"funds_id"));
//                    link_vn.append("<a href='javascript:showVn(").append(rs_vn.getString(bpv_fdb.bpv_f.getFPatientVisitFundsId()))
//                        .append(")'>").append("vn ").append(rs_vn.getString(bpv_fdb.bpv_f.getFVisitVn())).append(" วันที่ ")
//                        .append(date_visit).append(" ").append(rs_vn.getString(bpv_fdb.bpv_f.getFVisitBeginVisitTime()))
//                        .append("</a> ");
//                }else if(rs_detail.getString(bpv_fdb.bpv_f.getFStatusBilling()).equals("2")){
//                    data_item = config1.NumberFormat(bpv_fdb.getSumFundsItemInjuryNumber(st_item, rs_vn.getString(bpv_fdb.bpv_f.getFPatientVisitFundsId()),"funds_id_billinged"));
//                    link_vn.append("<font color='organge'><b>vn ").append(rs_vn.getString(bpv_fdb.bpv_f.getFVisitVn())).append(" วันที่ ")
//                        .append(date_visit).append(" ").append(rs_vn.getString(bpv_fdb.bpv_f.getFVisitBeginVisitTime())).append("</b></font>");
//                }else{
//                    data_item = config1.NumberFormat(bpv_fdb.getSumFundsItemInjuryNumber(st_item, rs_vn.getString(bpv_fdb.bpv_f.getFPatientVisitFundsId()),"funds_id"));
//                    link_vn.append("vn ").append(rs_vn.getString(bpv_fdb.bpv_f.getFVisitVn())).append(" วันที่ ")
//                        .append(date_visit).append(" ").append(rs_vn.getString(bpv_fdb.bpv_f.getFVisitBeginVisitTime()));
//                }
//                helpLink = " title = 'สถานะบิล "+rs_detail.getString(bpv_fdb.bpv_f.getFStatusBilling())+" "+helpStatusBill+" vn' ";
//                txt.append("<tr "+helpLink+" id ='tr_").append(node_vn).append("' class='child-of-tr_").append(node_child).append("' name = '")
//                        .append(node_parent).append("'><td><font color='red'>").append(link_vn.toString()).append("</td>")
//                        .append("<td></td><td align='center'><font color='red'>").append(data_item)
//                        .append("</font>").append("</td></font></tr>");
//            //            localInteger1 = row_vn; localInteger2 = row_vn = Integer.valueOf(row_vn.intValue() + 1);
//              }
//              rs_vn.close();
//              row_detail++;
//            //          localInteger1 = row_detail; localInteger2 = row_detail = Integer.valueOf(row_detail.intValue() + 1);
//            }
//            row_detail=100;
//            rs_detail.close();
//            row++;
//            }
//            rs.close();
//            conn.close();
//            txt.append("<input type='hidden' id='row' name='row'value='" + row + "'>");
//        } catch (Exception ex) {
//          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
//          txt.append(ex.getMessage());
//        }
//        return txt.toString();
//    }
    public String setUpdatePatientVisitFundsBillingItemNametEdit(String branch_id, String bpv_fbi_id, String item_namet) {
        String sql = "";
        Integer chk=0;
        try {
          item_namet = item_namet.replace("'", "''");
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpv_fbi.getBackTPatientVisitFundsBillingItem()
                  + " Set " + bpv_fbi.getFTBillingInvoiceItemNamet() + "='" + item_namet + "', "
//                  + bpv_fbi.getFItemNametEditStatus() + "='1', "
                  + bpv_fbi.getFRecordStatus() + "='1' "
                  + "Where " + bpv_fbi.getFPatientVisitFundsBillingItemId() + "='" + bpv_fbi_id + "'";

          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public void setUpdatePatientVisitFundsBilling(String branch_id, String bpv_fb_id, String patient_fullnamet,
            String visit_vn, String visit_hn, String visit_date, String claim_id, String paid_id, String sickness,
            String claim_name, String paid_name, String injury_number, String visit_contact_id, String visit_contact_namet,
            String visit_contact_join_id, String visit_contact_join_namet, String visit_final_discharge){
        String sql = "";
        BackTInjuryDB t_injurydb = new BackTInjuryDB();
        try {
          patient_fullnamet = patient_fullnamet.replace("'", "''");
          claim_name = claim_name.replace("'", "''");
          paid_name = paid_name.replace("'", "''");

          sickness = sickness.replace("'", "''");
            visit_contact_namet = visit_contact_namet.replace("'", "''");
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvFb.getBackTPatientVisitFundsBilling()
                  + " Set " + bpvFb.getFPatientFullnamet() + "='" + patient_fullnamet + "',"
                  + bpvFb.getFVisitHn() + "='" + visit_hn + "'," + bpvFb.getFVisitVn() + "='" + visit_vn + "',"
                  + bpvFb.getFVisitDate() + "='" + visit_date + "'," + bpvFb.getFVisitClaimId() + "='" + claim_id + "',"
                  + bpvFb.getFVisitPaidId() + "='" + paid_id + "', " + bpvFb.getFSickness() + "='" + sickness + "', "
                  + bpvFb.getFVisitClaimNamet() + "='" + claim_name + "', " + bpvFb.getFVisitPaidNamet() + "='" + paid_name + "', "
                  + bpvFb.getFInjuryNumber() + "='" + injury_number + "', "
                  + bpvFb.getFVisitContactNamet() + "='" + visit_contact_namet + "', "
                  + bpvFb.getFVisitFinancialDischargeTime() + "='" + visit_final_discharge + "' "
                  + "Where " + bpvFb.getFPatientVisitFundsBillingId() + "='" + bpv_fb_id + "'";

          st.executeUpdate(sql);
          t_injurydb.setInjuryNumber(branch_id, visit_hn, visit_date, injury_number);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitFundsBillingSickness(String branchId, String bpvFbId, String sickness){
        String sql = "";
        BackTInjuryDB t_injurydb = new BackTInjuryDB();
        try {

          sickness = sickness.replace("'", "''");
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvFb.getBackTPatientVisitFundsBilling()
                  + " Set " + bpvFb.getFSickness() + "='" + sickness + "' "
                  + "Where " + bpvFb.getFPatientVisitFundsBillingId() + "='" + bpvFbId + "'";

          st.executeUpdate(sql);
//          t_injurydb.setInjuryNumber(branchId, visit_hn, visit_date, injury_number);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String setUpdatePatientVisitFundsBillingItemTotalEdit(String branch_id, String bpvFbIId, String item_price) {
        String sql = "";
        Integer chk=0;
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpv_fbi.getBackTPatientVisitFundsBillingItem()
                  + " Set " + bpv_fbi.getFItemTotal() + "='" + item_price + "', "
                  + bpv_fbi.getFItemTotalEditStatus() + "='1', " + bpv_fbi.getFRecordStatus() + "='1' "
                  + "Where " + bpv_fbi.getFPatientVisitFundsBillingItemId() + "='" + bpvFbIId + "'";
          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public void setUpdatePatientVisitFundsBillingItemVoid(String branch_id, String bpv_fbi_id, String item_price) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpv_fbi.getBackTPatientVisitFundsBillingItem()
                  + " Set " + bpv_fbi.getFBillingInvoiceItemActive() + "='3' "
                  + "Where " + bpv_fbi.getFPatientVisitFundsBillingItemId() + "='" + bpv_fbi_id + "'";
          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitFundsBillingVoid(String branch_id, String bpv_fb_id) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvFb.getBackTPatientVisitFundsBilling()
                  + " Set " + bpvFb.getFPatientVisitFundsBillingActive() + "='3' "
                  + "Where " + bpvFb.getFPatientVisitFundsBillingId() + "='" + bpv_fb_id + "'";
          st.executeUpdate(sql);
          sql = "Update " + bpv_fbi.getBackTPatientVisitFundsBillingItem()
                  + " Set " + bpv_fbi.getFBillingInvoiceItemActive() + "='3' "
                  + "Where " + bpv_fbi.getFPatientVisitFundsBillingId() + "='" + bpv_fb_id + "'";
          st.executeUpdate(sql);
          bpvFb = getBackTPatientVisitFundsBillingByPK(branch_id, bpv_fb_id,"");
          sql = "Update " + bpv_fdb.bpvF.getBackTPatientVisitFunds()
                  + " Set " + bpv_fdb.bpvF.getFStatusBilling() + "='0', "+bpv_fdb.bpvF.getFBillingInvoiceNumber()+"='' "
                  + "Where " + bpv_fdb.bpvF.getFInjuryNumber() + "='" + bpvFb.getInjuryNumber() + "' and "
                  + bpv_fdb.bpvF.getFVisitHn()+" = '"+bpvFb.getVisitHn()+"' ";
          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public String getTrBillingPrepareDebtor(String branch_id, String billing_id, String paid_id, String flag) {
//        String node_parent = "", text_h = "", chk_print = "", chk_src = "", script = "", bpv_f_id="", cnt="", total="";
//        StringBuilder txt = new StringBuilder();
////        Connection conn;
//        Vector v_billing = new Vector();
//        try {
////            conn = config1.getConnectionBangna();
////            Statement st = conn.createStatement();
//            if(flag.equals("debtor")){
//                v_billing = getBackTPatientVisitFundsBilling(branch_id, billing_id, paid_id, "billing_no_debtor");
//            }else if(flag.equals("debtor_no_print")){
//                v_billing = getBackTPatientVisitFundsBilling(branch_id, billing_id, paid_id, flag);
//            }else if(flag.equals("debtor_yes_print")){
//                v_billing = getBackTPatientVisitFundsBilling(branch_id, billing_id, paid_id, flag);
//            }
//    //        for(int row=0;row<=v_billing.size()-1;row++){
//    //            bpv_f = new BackTPatientVisitFunds();
//    //            bpv_f = (BackTPatientVisitFunds)v_billing.get(row);
//    //            bpv_f_id = bpv_f.getPatientVisitFundsId();
//    //            bpv_f = getBackTPatientVisitFundsByPK(branch_id, bpv_f_id, "");
//    //        }
//            for (int i = 0; i < v_billing.size(); i++) {
//                try {
//                    node_parent = "chk_" + i;
//                    bpv_fb = new BackTPatientVisitFundsBilling();
//                    bpv_fb = (BackTPatientVisitFundsBilling)v_billing.get(i);
//                    bpv_fbt = getCntSumBackTPatientVisitFundsBillingItem(branch_id, bpv_fb.getPatientVisitFundsBillingId());
//    //                bpv_f_id = bpv_f.getPatientVisitFundsId();
////                    cnt = bpv_fb.getBServicePointId();//count billing
////                    total = bpv_fb.getVisitTotal().toString();
////                    bpv_f = new BackTPatientVisitFunds();
////                    bpv_fb = getBackTPatientVisitFundsBillingByPK(branch_id, bpv_fb.getPatientVisitFundsBillingId(), "");
//                    if (bpv_fb.getStatusPayment().equals("2")) {
//                        chk_print = "";
//                        chk_src = "images/print_green.png";
//                    }else{
//                        chk_print = "checked";
//                        chk_src = "images/print_red.png";
//                    }
//                    txt.append("<tr class='style14r'><td align='center'>").append((i + 1)).append("</td>")
//            .append("<td><label><input type='checkbox' name='").append(node_parent).append("' id ='").append(node_parent).append("' value='' ").append(chk_print).append(" onchange='chkbilling(").append(")' >").append(bpv_fb.getVisitHn()).append("</label></td>")
//            .append("<td>").append(bpv_fb.getPatientFullnamet()).append("</td>")
//            .append("<td align='center'>").append(config1.DateFormatDB2Show(bpv_fb.getVisitDate(), "ddMMyyyy")).append("</td>")
//            .append("<td align='right'>").append(config1.NumberFormat(bpv_fbt.getAmount())).append("</td>")
//            .append("<td align='right'>").append(bpv_fbt.getBillingInvoiceNumber()).append("</td>")
//            .append("<td align='right'>").append(bpv_fb.getInjuryNumber()).append("</td>")
//            .append("<td><img id='img_" + i + "' name = 'img_").append(i).append("' src='").append(chk_src)
//                            .append("' alt='' align='top' border='0' title='พิมพ์ billing' onclick='printBilling(").append(i).append(")'/>")
//                            .append("<input type='hidden' id='txt_patient_visit_funds_billing_id").append(i).append("' value='")
//                            .append(bpv_fb.getPatientVisitFundsBillingId()).append("'><input type='hidden' id='txt_total").append(i)
//                            .append("' value='").append(bpv_fb.getVisitTotal()).append("'></td></tr>");
//              }catch (Exception ex){
//                Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
//              }
//            }
//            text_h = "<thead> <tr align='center' class='style14r'>"
//                    + "<th width='5' align='center'>ลำดับ</th> "
//                    + "<th width='100' align='left'>HN</th> "
//                    + "<th width='250' align='left'>ชื่อ-นามสกุล</th> "
//                    + "<th width='85' align='left'>วันที่รักษา</th> "
//                    + "<th width='80' align='left'>มูลค่า</th> "
//                    + "<th width='80' align='left'>จำนวนบิล</th> "
//                    + "<th width='100' align='left'>เลขที่ สบ</th> "
//                    + "<th width='40' align='left'>พิมพ์</th> </tr></thead>";
////            conn.close();
//        } catch (Exception ex) {
//            Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return "<table width='100%'>" + text_h + txt + "<input type='hidden' id='txt_billing_cover_row' value='" + (v_billing.size() - 1) + "'></table>" + script;
//    }
    public String getTrBillingVoidDebtor(String branch_id, String billing_id, String flag) {
        String node_parent = "", text_h = "", chk_print = "", chk_active = "", script = "", chk_unactive="", cnt="", total="";
        String status_payment="", status_print="";
        StringBuilder txt = new StringBuilder();
        StringBuilder txt_item = new StringBuilder();
        Vector v_billing = new Vector();
        try {
            if(!billing_id.equals("")){
                bpvFb = getBackTPatientVisitFundsBillingByPK(branch_id, billing_id, "billing_number");
                //v_billing = getBackTPatientVisitFundsBillingItem(branch_id, bpv_fb.getPatientVisitFundsBillingId(), "bpv_fb_id");
                //for(int i=0;i<=v_billing.size()-1;i++){
                //    bpv_fbi = (BackTPatientVisitFundsBillingItem)v_billing.get(i);
                //    txt_item.append("<tr>")
                //        .append("<td>เลขที่</td> <td><input type='text' id='txt_billing_invoice_number' value='"+bpv_fb.getBillingInvoiceNumber()+"' size='10'>&nbsp;<img src='images/search1.jpeg' alt='' name='billing_search' id='billing_search' border='0' align='button' title='ค้นหา billing...' onclick='searchVoidDebtor()'></td>")
                //}
            }
            if(bpvFb.getPatientVisitFundsBillingActive().equals("1")) {
                chk_active="'checked'";
                chk_unactive="";
            }else{
                chk_active="";
                chk_unactive="'checked'";
            }
            if(bpvFb.getStatusPayment().equals("1")){
                status_payment="รวม bill แล้ว รอตั้งหนี้";
            }else if(bpvFb.getStatusPayment().equals("2")){
                status_payment="ตั้งหนี้แล้ว รอรับชำระ";
            }else if(bpvFb.getStatusPayment().equals("4")){
                status_payment="รับชำระแล้ว จบกระบวนการ";
            }else if(bpvFb.getStatusPayment().equals("0")){
                status_payment="เริ่มต้น กระบวนการ";
            }else{
                status_payment="ไม่ระบุสถานะ";
            }
            if(bpvFb.getStatusPrint().equals("1")){
                status_print="   สถานะพิมพ์ พิมพ์ bill แล้ว";
            }else if(bpvFb.getStatusPrint().equals("0")){
                status_print="   สถานะพิมพ์ ยังไม่พิมพ์ bill ";
            }else{
                status_print="   สถานะพิมพ์  ไม่ระบุสถานะ";
            }
        txt.append("<table width='100%'><tr>")
        .append("<tr>")
        .append("<td>เลขที่ billing</td> <td><input type='text' id='txt_billing_invoice_number' value='").append(bpvFb.getBillingInvoiceNumber()).append("' size='12'>&nbsp;<img src='images/search1.jpeg' alt='' name='billing_search' id='billing_search' border='0' align='button' title='ค้นหา billing...' onclick='searchVoidDebtor()'></td>")
        .append("<td>สถานะ</td><td><label><input type='radio' name ='chk_patient_visit_funds_billing_active' id='chk_funds_billing_enable' value='1'").append(chk_active).append(" />ใช้งาน</label>")
        .append("<label><input type='radio' name ='chk_patient_visit_funds_billing_active' id='chk_funds_billing_disable' value='3' ").append(chk_unactive).append("/>ยกเลิกใช้งาน</label></td>")
        .append("</tr>")
        .append("<tr><td>ชื่อ-นามสกุล</td> <td><input type='text' id='txt_patient_fullnamet' value='").append(bpvFb.getPatientFullnamet()).append("' size='30' readonly></td>")
        .append("<td>HN</td> <td><input type='text' id='txt_remark' value='").append(bpvFb.getVisitHn()).append("' size='12' readonly>&nbsp;&nbsp;VN<input type='text' id='txt_remark' value='").append(bpvFb.getVisitVn()).append("' size='12' readonly></td></tr>")
        .append("<tr>")
        .append("<td>จำนวนเงิน</td><td ><input type='text' id='txt_visit_total' value='").append(bpvFb.getVisitTotal()).append("' size='8' readonly>&nbsp;&nbsp;เลขที่สป<input type='text' id='txt_rinjury_number' value='").append(bpvFb.getInjuryNumber()).append("' size='15' readonly></td>")
        .append("<td colspan='2'>บริษัท<input type='text' id='txt_visit_contact_namet' value='").append(bpvFb.getVisitContactNamet()).append("' size='35' readonly></td>")
        .append("</tr>")
        .append("<tr>")
        .append("<td>อาการ</td><td ><input type='text' id='txt_visit_notice' value='").append(bpvFb.getVisitNotice()).append("' size='30'  readonly></td>")
        .append("<td>sickness</td><td><input type='text' id='txt_sickness' value='").append(bpvFb.getSickness()).append("' size='30' readonly></td>")
        .append("</tr>")
        .append("<tr>")
        .append("<td>invoice number</td><td ><input type='text' id='txt_invoice_number' value='").append(bpvFb.getInvoiceNumber()).append("' size='20' readonly></td>")
        .append("<td>receipt number</td><td><input type='text' id='txt_receipt_number' value='").append(bpvFb.getReceiptNumber()).append("' size='20' readonly></td>")
        .append("</tr>")
        .append("<tr>")
        .append("<td>เลขที่</td><td ><input type='text' id='txt_patient_visit_funds_billing_id' value='").append(bpvFb.getPatientVisitFundsBillingId()).append("' size='12' readonly><input type='text' id='txt_patient_visit_funds_id' value='").append(bpvFb.getPatientVisitFundsId()).append("' size='12' readonly></td>")
        .append("<td>สิทธิ</td><td><input type='text' id='txt_visit_paid_namet' value='").append(bpvFb.getVisitPaidNamet()).append("' size='20' readonly></td>")
        .append("</tr>")
        .append("<tr>")
        .append("<td>สถานะ bill</td><td colspan='3'>").append(status_payment).append(status_print).append("</td>")
        .append("</tr></table>");
            txt.append(txt_item);
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "<table width='100%'>" + text_h + txt + "<input type='hidden' id='txt_billing_cover_row' value='" + (v_billing.size() - 1) + "'></table>" + script;
    }
    public void setUpdatePatientVisitFundsBillingStatusDebtorVoid(String branch_id, String bpv_fb_id, String bpv_f_id, String billing_invoice_number) {
        String sql = "";
        Integer chk=0;
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvFb.getBackTPatientVisitFundsBilling()
                  + " Set " + bpvFb.getFStatusPrint() + "='0', "+bpvFb.getFStatusPayment()+"='1', "
                  +bpvFb.getFBillingInvoiceNumber()+"='' "
                  + "Where " + bpvFb.getFPatientVisitFundsBillingId() + "='" + bpv_fb_id + "'";
          chk = st.executeUpdate(sql);
          sql = "Update " + bpv_fdb.bpvF.getBackTPatientVisitFunds()
                  + " Set " + bpv_fdb.bpvF.getFStatusBilling() + "='1', "+bpv_fdb.bpvF.getFBillingInvoiceNumber()+"='' "
                  + "Where " + bpv_fdb.bpvF.getFBillingInvoiceNumber() + "='" + billing_invoice_number + "'";
          chk = st.executeUpdate(sql);
          sql = "Update " + debtordb.debtor.getBackTDebtor()
                  + " Set " + debtordb.debtor.getFDebtorActive() + "='3' "
                  + "Where " + debtordb.debtor.getFBillingInvoiceNumber() + "='" + billing_invoice_number + "'";
          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitFundsBillingStatusDebtorVoidEnableEdit(String branch_id, String bpv_fb_id, String bpv_f_id, String billing_invoice_number) {
        String sql = "";
        Integer chk=0;
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvFb.getBackTPatientVisitFundsBilling()
                + " Set " + bpvFb.getFCntDebtorVoid()+"= "+bpvFb.getFCntDebtorVoid()+"+1, "+bpvFb.getFStatusDebtorVoid()+"='1' "
                + "Where " + bpvFb.getFPatientVisitFundsBillingId() + "='" + bpv_fb_id + "'";
          chk = st.executeUpdate(sql);
          sql = "Update " + bpv_fdb.bpvF.getBackTPatientVisitFunds()
                + " Set " + bpv_fdb.bpvF.getFCntDebtorVoid()+"= "+bpv_fdb.bpvF.getFCntDebtorVoid()+"+1, "+bpv_fdb.bpvF.getFStatusDebtorVoid()+"='1' "
//                  + " Set " + bpv_fdb.bpv_f.getFStatusBilling() + "='1', "+bpv_fdb.bpv_f.getFBillingInvoiceNumber()+"='' "
                + "Where " + bpv_fdb.bpvF.getFBillingInvoiceNumber() + "='" + billing_invoice_number + "'";
          chk = st.executeUpdate(sql);
          sql = "Update " + debtordb.debtor.getBackTDebtor()
                + " Set " + debtordb.debtor.getFDebtorActive() + "='3' "
                + "Where " + debtordb.debtor.getFBillingInvoiceNumber() + "='" + billing_invoice_number + "'";
          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdateBackTPatientVisitBillingDiscount(String branch_id, String bpv_fb_id) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "update back_t_patient_visit_funds_billing "
                + "set visit_discount = (select sum(item_total) from back_t_patient_visit_funds_billing_item "
                +"where patient_visit_funds_billing_id = '"+bpv_fb_id+"' and billing_invoice_number in ('9','999')) "
                +"where patient_visit_funds_billing_id = '"+bpv_fb_id+"'; ";
          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String setUpdateBackTPatientVisitBillingVisitTotal(String branch_id, String bpvFbId) {
        String sql = "";
        Integer chk=0;
        Double total=0.0, discount=0.0, paid=0.0;
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Select sum(item_total) as item_total From back_t_patient_visit_funds_billing_item "
                +"where patient_visit_funds_billing_id = '"+bpvFbId+"' and patient_visit_funds_billing_item_active = '1' ";
          ResultSet rs = st.executeQuery(sql);
          while(rs.next()){
              total = rs.getDouble("item_total");
          }
          rs.close();
          sql = "Select sum(item_total) as item_total From back_t_patient_visit_funds_billing_item "
                +"where patient_visit_funds_billing_id = '"+bpvFbId+"' and patient_visit_funds_billing_item_active = '1' and billing_invoice_number in ('9','999')";
          rs = st.executeQuery(sql);
          while(rs.next()){
              discount = rs.getDouble("item_total");
          }
          paid = total + discount;
          rs.close();
//          sql = "update back_t_patient_visit_funds_billing "
//                + "set visit_total ="+total+", "
//                +" visit_discount ="+discount+", "
//                +" visit_paid ="+paid+" "
//                +"where patient_visit_funds_billing_id = '"+bpvFbId+"'; ";
//          chk = st.executeUpdate(sql);
//          conn.close();
          setUpdatePatientVisitFundsBillingTotalBaht(branch_id,bpvFbId,paid,total,discount);
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
//    public String getTrPrintCover(String branch_id, String date_end, String visit_hn, String flag) {//pop พิมพ์ซ้ำ
//        String node_parent = "", text_h = "", chk_print = "", chk_src = "", script = "", bpv_f_id="", cnt="", total="";
//        StringBuilder txt = new StringBuilder();
////        Connection conn;
//        Vector v_billing = new Vector();
//        try {
//            v_billing = getBackTPatientVisitFundsBilling(branch_id, date_end, visit_hn, flag);
//            for (int i = 0; i <= v_billing.size() - 1; i++) {
//                try {
//                    node_parent = "chk_" + i;
//                    bpv_fb = new BackTPatientVisitFundsBilling();
//                    bpv_fb = (BackTPatientVisitFundsBilling)v_billing.get(i);
//                    bpv_fbt = getCntSumBackTPatientVisitFundsBillingItem(branch_id, bpv_fb.getPatientVisitFundsBillingId());
//                    if (bpv_fb.getStatusPayment().equals("2")) {
//                        chk_print = "";
//                        chk_src = "images/print_green.png";
//                    }else{
//                        chk_print = "checked";
//                        chk_src = "images/print_red.png";
//                    }
//                    txt.append("<tr class='style14r'><td align='center'>").append((i + 1)).append("</td>")
//            .append("<td><label><input type='checkbox' name='").append(node_parent).append("' id ='").append(node_parent).append("' value='' ").append(chk_print).append(" onchange='chkbilling(").append(")' >").append(bpv_fb.getVisitHn()).append("</label></td>")
//            .append("<td>").append(bpv_fb.getPatientFullnamet()).append("</td>")
//            .append("<td align='center'>").append(config1.DateFormatDB2Show(bpv_fb.getVisitDate(), "ddMMyyyy")).append("</td>")
//            .append("<td align='right'>").append(config1.NumberFormat(bpv_fbt.getAmount())).append("</td>")
//            .append("<td align='right'>").append(bpv_fbt.getBillingInvoiceNumber()).append("</td>")
//            .append("<td align='right'>").append(bpv_fb.getInjuryNumber()).append("</td>")
//            .append("<td><img id='img_" + i + "' name = 'img_").append(i).append("' src='").append(chk_src)
//                            .append("' alt='' align='top' border='0' title='พิมพ์ billing' onclick='printBilling(").append(i).append(")'/>")
//                            .append("<input type='hidden' id='txt_patient_visit_funds_billing_id").append(i).append("' value='")
//                            .append(bpv_fb.getPatientVisitFundsBillingId()).append("'><input type='hidden' id='txt_total").append(i)
//                            .append("' value='").append(bpv_fb.getVisitTotal()).append("'></td></tr>");
//              }catch (Exception ex){
//                Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
//              }
//            }
//            text_h = "<thead> <tr align='center' class='style14r'>"
//                    + "<th width='5' align='center'>ลำดับ</th> "
//                    + "<th width='100' align='left'>HN</th> "
//                    + "<th width='250' align='left'>ชื่อ-นามสกุล</th> "
//                    + "<th width='85' align='left'>วันที่รักษา</th> "
//                    + "<th width='80' align='left'>มูลค่า</th> "
//                    + "<th width='80' align='left'>จำนวนบิล</th> "
//                    + "<th width='100' align='left'>เลขที่ สบ</th> "
//                    + "<th width='40' align='left'>พิมพ์</th> </tr></thead>";
////            conn.close();
//        } catch (Exception ex) {
//            Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return "<table width='100%'>" + text_h + txt + "<input type='hidden' id='txt_billing_cover_row' value='" + (v_billing.size() - 1) + "'></table>" + script;
//    }
//    public BackTPatientVisitFundsBilling getBillVisitVn(String branch_id, String visit_vn, String flag){
//        String bpv_fb_id="";
//        bpv_fb = getBackTPatientVisitFundsBillingByPK(branch_id,visit_vn,flag);// ดึง 2 ครั้งเพราะจะได้ดึงตาม pk 
//        if(bpv_fb.getVisitVn().equals("")){// เป็น case ใหม่
//            bpv_fb_id = setSaveBillingFundsPrepareBill(branch_id,visit_vn+"@"+visit_vn,"",flag);//ต้องเป็นแบบนี้
//            bpv_fb = getBackTPatientVisitFundsBillingByPK(branch_id,bpv_fb_id,"");
//        }else{ // case เก่า คือได้ดึงมาแล้ว 
//            bpv_fb = getBackTPatientVisitFundsBillingByPK(branch_id,bpv_fb.getPatientVisitFundsBillingId(),"");
//        }
//        return bpv_fb;
//    }
//    public String CboPatientVisitShowDate(String branch_id, String visit_hn, String selected) {
//        String txt="",sql="";
//        Vector v_vn = new Vector();
//        PatientVisit patient_visit = new PatientVisit();
//        v_vn = getPatientVisit(branch_id, visit_hn);
//        txt="<option value='' selected></option>";
//        for(int i=0;i<=v_vn.size()-1;i++) {
//            patient_visit = (PatientVisit) v_vn.get(i);
//            if(patient_visit.getPatientHn().equals(selected)) {
//                txt += "<option value='"+patient_visit.getVisitVn()+"' selected>"+patient_visit.getCloseDayDate()+" "+patient_visit.getVisitVn()+"</option>";
//                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
//            }else{
//                txt += "<option value='"+patient_visit.getVisitVn()+"' >"+patient_visit.getCloseDayDate()+" "+patient_visit.getVisitVn()+"</option>";
//                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
//            }
//            if(i==4){
//                sql="";
//            }
//        }
//        return txt;
//    }
    public Vector getPatientVisit(String branch_id, String visit_hn) {
        Vector v_patient_visit = new Vector();
        String time="", visit_date="";
        String sql="Select patient_visit_funds_id, close_day_date,visit_vn,visit_hn "
                + "From back_t_patient_visit_funds "
                + "Where visit_hn = '"+visit_hn+"' and patient_visit_funds_active = '1' "
                + "Order By visit_vn";
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        PatientVisit patient_visit = new PatientVisit();
        try {
            connmainhis = config1.getConnectionBangna();
            stmainhis = connmainhis.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()) {
                patient_visit = new PatientVisit();
                patient_visit.setCloseDayDate(rsmainhis.getString("close_day_date"));
                patient_visit.setCloseDayId(rsmainhis.getString("patient_visit_funds_id"));
                patient_visit.setVisitVn(rsmainhis.getString("visit_vn"));
                patient_visit.setPatientHn(rsmainhis.getString("visit_hn"));
                v_patient_visit.add(patient_visit);
            }
            rsmainhis.close();
            connmainhis.close();
        }
        catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_patient_visit;
    }
    public void setUpdatePatientVisitFundsBillingTempAmount(String branchId, String bpvFId, Double amount, String status) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update back_t_patient_visit_funds_billing_temp"
                  + " Set amount ="+amount+ " "
                  + "Where patient_visit_funds_id = '" + bpvFId + "' and status = '"+status+"'";
          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdateBackTPatientVisitBillingInjuryNumber(String branchId, String bpvFbId, String injuryNumberNew) {
        String sql = "";
        Integer chk=0;
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "update back_t_patient_visit_funds_billing "
                + "set injury_number = '"+injuryNumberNew+"' "
                +"where patient_visit_funds_billing_id = '"+bpvFbId+"'; ";
          chk = st.executeUpdate(sql);
          
          sql = "update back_t_patient_visit_funds "
                + "set injury_number = '"+injuryNumberNew+"' "
                +"where patient_visit_funds_billing_id = '"+bpvFbId+"'; ";
          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
