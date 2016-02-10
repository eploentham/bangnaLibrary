package com.bangna.objdb;

import bangnaLibrary.BContact;
import bangnaLibrary.BackBTransfer;
import bangnaLibrary.BackTInjuryDB;
import bangnaLibrary.BackTPatientVisitDB;
import com.bangna.object.BackTPatientVisitFunds;
import com.bangna.object.BackTPatientVisitFundsItem;
import bangnaLibrary.Config1;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BackTPatientVisitFundsDB {
    Config1 config1 ;
//  private bpvdb.config1 bpvdb.config1 = new bpvdb.config1();
//  private BBranch branch = new BBranch();
  public BackTPatientVisitFunds bpvF;
  public BackTPatientVisitFundsItem bpv_fi;
//  private BackTPatientVisitFundsBilling bpv_fb = new BackTPatientVisitFundsBilling();
//  private BackTPatientVisitFundsBillingItem bpv_fbi = new BackTPatientVisitFundsBillingItem();
  public BackTPatientVisitDB bpvdb;
  private BackTInjuryDB t_injurydb;
  private BackBTransfer b_transfer;
  public BContact contact;
//  private BackTPatientVisit bpv = new BackTPatientVisit();
//  private BackTPatientVisitItem bpvi = new BackTPatientVisitItem();
//  private BItem b_item = new BItem();
  private StringBuilder txt = new StringBuilder();
  private StringBuilder sql = new StringBuilder();

  String idtable="148", idtableItem="151";
    public BackTPatientVisitFundsDB(){
        config1 = new Config1();
        initConfig(config1);
    }
    public BackTPatientVisitFundsDB(Config1 cf){
        config1 = cf;
        initConfig(config1);
    }
    public void initConfig(Config1 cf){
        bpvF = new BackTPatientVisitFunds();
        bpv_fi = new BackTPatientVisitFundsItem();
        bpvdb = new BackTPatientVisitDB(cf);
        t_injurydb = new BackTInjuryDB(cf);
        b_transfer = new BackBTransfer();
        contact = new BContact();
    }
  public String getMaxRowBackTPatientVisitFunds(Connection conn) {
      String sql = ""; String max = "";
    try {
      Statement st = conn.createStatement();
      sql = "Select max(" + bpvF.getFPatientVisitFundsId() + ") as cnt From " + bpvF.getBackTPatientVisitFunds();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        max = rs.getString("cnt");
      }
      rs.close();
      if ((max != null) && (!max.equals("")))
        max = String.valueOf(Integer.parseInt(max) + 1);
      else
        max = "1480000001";
    } catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return max; }

    public String getMaxRowBackTPatientVisitFundsItem(Connection conn) {
        String sql = ""; String max = "";
        try {
            Statement st = conn.createStatement();
            sql = "Select max(" + bpv_fi.getFPatientVisitFundsItemId() + ") as cnt " + "From " + bpv_fi.getBackTPatientVisitFundsItem();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))
                max = String.valueOf(Integer.parseInt(max) + 1);
            else
                max = "1510000001";
        }catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }

    public BackTPatientVisitFunds getBackTPatientVisitFundsByPK(String branch_id, String bpv_f_id, String flag) {
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            bpvF = getBackTPatientVisitFundsByPK(stbangna, branch_id, bpv_f_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpvF;
    }
    public BackTPatientVisitFunds getBackTPatientVisitFundsByPK(Statement stbangna, String branch_id, String bpv_f_id, String flag) {
        String sql = "";
        try {
            //      Connection conn = config1.getConnectionBangna();bpv_f = new BackTPatientVisitFunds();
            //      Statement stbangna = conn.createStatement();
            if (flag.equals("patient_visit_id")) {
                sql = "Select * From "+bpvF.getBackTPatientVisitFunds()+" "
                    +"Where "+bpvF.getFPatientVisitId()+"='"+bpv_f_id+"' and "
                    +bpvF.getFBranchId() + "='"+branch_id+"' and "+bpvF.getFPatientVisitFundsActive()+"='1'";
            }else if(flag.equals("visit_hn")) {
                sql = "Select * From "+bpvF.getBackTPatientVisitFunds()+" "
                    +"Where "+bpvF.getFVisitHn()+" = '"+bpv_f_id+"' and "+bpvF.getFPatientVisitFundsActive()+"='1' and "
                    + bpvF.getFPatientVisitFundsId() +"=min("+bpvF.getFPatientVisitFundsId()+") "
                    + "Order By "+bpvF.getFPatientVisitFundsId()+" asc";
            }else if(flag.equals("visit_vn")) {
              sql = "Select * From "+bpvF.getBackTPatientVisitFunds()+" "
                  +"Where "+bpvF.getFVisitVn()+" = '"+bpv_f_id+"' and "+bpvF.getFPatientVisitFundsActive()+"='1' "
                  + "Order By "+bpvF.getFPatientVisitFundsId()+" asc";
            }else if (flag.equals("injury_number")) {
              sql = "Select * From "+bpvF.getBackTPatientVisitFunds()+" "
                  +"Where "+bpvF.getFInjuryNumber()+" = '"+bpv_f_id+"' and "+bpvF.getFPatientVisitFundsActive()+"='1' and "
                  + bpvF.getFPatientVisitFundsId() +"=min("+bpvF.getFPatientVisitFundsId()+") "
                  + "Order By "+bpvF.getFPatientVisitFundsId()+" asc";
            }else if(flag.equals("visit_hn_record_status_1")) {
                sql = "Select * From "+bpvF.getBackTPatientVisitFunds()+" "
                    +"Where "+bpvF.getFVisitHn()+" = '"+bpv_f_id+"' and "+bpvF.getFPatientVisitFundsActive()+"='1' and "
                    + bpvF.getFRecordStatus() +"='1' ";
            }else if(flag.equals("billing_number")) {
                sql = "Select * From "+bpvF.getBackTPatientVisitFunds()+" "
                    +"Where "+bpvF.getFBillingInvoiceNumber()+" = '"+bpv_f_id+"' and "+bpvF.getFPatientVisitFundsActive()+"='1' "
                    + "Order By "+bpvF.getFPatientVisitFundsId() ;
            }else {
                sql = "Select * From " + bpvF.getBackTPatientVisitFunds() + " "
                    + "Where " + bpvF.getFPatientVisitFundsId() + "='" + bpv_f_id + "' and "
                    + bpvF.getFBranchId() + "='" + branch_id + "'";
            }
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpvF = new BackTPatientVisitFunds();
                bpvF.setBServicePointId(config1.StringNull(rs.getString(bpvF.getFBServicePointId())));
                bpvF.setBVisitClinicId(config1.StringNull(rs.getString(bpvF.getFBVisitClinicId())));
                bpvF.setVisitClaimId(config1.StringNull(rs.getString(bpvF.getFVisitClaimId())));
                bpvF.setVisitPaidId(config1.StringNull(rs.getString(bpvF.getFVisitPaidId())));
                bpvF.setPatientFullnamet(config1.StringNull(rs.getString(bpvF.getFPatientFullnamet())));

                bpvF.setPatientVisitId(config1.StringNull(rs.getString(bpvF.getFPatientVisitId())));
                bpvF.setTPatientId(config1.StringNull(rs.getString(bpvF.getFTPatientId())));
                bpvF.setVisitBeginVisitTime(config1.StringNull(rs.getString(bpvF.getFVisitBeginVisitTime())));
                bpvF.setVisitDate(config1.StringNull(rs.getString(bpvF.getFVisitDate())));
                bpvF.setVisitDiagnosisNotice(config1.StringNull(rs.getString(bpvF.getFVisitDiagnosisNotice())));

                bpvF.setVisitFinancialDischargeTime(config1.StringNull(rs.getString(bpvF.getFVisitFinancialDischargeTime())));
                bpvF.setVisitFirstVisit(config1.StringNull(rs.getString(bpvF.getFVisitFirstVisit())));
                bpvF.setVisitHn(config1.StringNull(rs.getString(bpvF.getFVisitHn())));
                bpvF.setVisitHospitalService(config1.StringNull(rs.getString(bpvF.getFVisitHospitalService())));
                bpvF.setVisitNotice(config1.StringNull(rs.getString(bpvF.getFVisitNotice())));

                bpvF.setVisitPatientAge(config1.StringNull(rs.getString(bpvF.getFVisitPatientAge())));
                bpvF.setVisitPatientSelfDoctor(config1.StringNull(rs.getString(bpvF.getFVisitPatientSelfDoctor())));
                bpvF.setVisitVn(config1.StringNull(rs.getString(bpvF.getFVisitVn())));
                bpvF.setVisitClaimNamet(config1.StringNull(rs.getString(bpvF.getFVisitClaimNamet())));
                bpvF.setVisitPaidNamet(config1.StringNull(rs.getString(bpvF.getFVisitPaidNamet())));

                bpvF.setDepartmentNamet(config1.StringNull(rs.getString(bpvF.getFDepartmentNamet())));
                bpvF.setDoctorNamet(config1.StringNull(rs.getString(bpvF.getFDoctorNamet())));
                bpvF.setPatientImportId(config1.StringNull(rs.getString(bpvF.getFPatientImportId())));
                bpvF.setBranchId(config1.StringNull(rs.getString(bpvF.getFBranchId())));
                bpvF.setSysStatus(config1.StringNull(rs.getString(bpvF.getFSysStatus())));

                bpvF.setVisitPaid(Double.valueOf(rs.getString(bpvF.getFVisitPaid())));
                bpvF.setVisitTotal(Double.valueOf(rs.getString(bpvF.getFVisitTotal())));
                bpvF.setVisitDiscount(Double.valueOf(rs.getString(bpvF.getFVisitDiscount())));
                bpvF.setPatientVisitId(config1.StringNull(rs.getString(bpvF.getFPatientVisitId())));
                bpvF.setVisitContactId(config1.StringNull(rs.getString(bpvF.getFVisitContactId())));

                bpvF.setVisitContactNamet(config1.StringNull(rs.getString(bpvF.getFVisitContactNamet())));
                bpvF.setPatientVisitFundsId(config1.StringNull(rs.getString(bpvF.getFPatientVisitFundsId())));
                bpvF.setPatientVisitFundsActive(config1.StringNull(rs.getString(bpvF.getFPatientVisitFundsActive())));
                bpvF.setStatusBilling(config1.StringNull(rs.getString(bpvF.getFStatusBilling())));
                bpvF.setInjuryNumber(config1.StringNull(rs.getString(bpvF.getFInjuryNumber())));

                bpvF.setRecordStatus(config1.StringNull(rs.getString(bpvF.getFRecordStatus())));
                bpvF.setCloseDayDate(config1.StringNull(rs.getString(bpvF.getFCloseDayDate())));
                bpvF.setVisitContactJoinId(config1.StringNull(rs.getString(bpvF.getFVisitContactJoinId())));
                bpvF.setVisitContactJoinNamet(config1.StringNull(rs.getString(bpvF.getFVisitContactJoinNamet())));
                bpvF.setBillingInvoiceNumber(config1.StringNull(rs.getString(bpvF.getFBillingInvoiceNumber())));

                bpvF.setReceiveAmount(Double.valueOf(rs.getString(bpvF.getFReceiveAmount())));
                bpvF.setBillingPaymentItemId(config1.StringNull(rs.getString(bpvF.getFBillingPaymentItemId())));
                bpvF.setPatientVisitFundsBillingId(config1.StringNull(rs.getString(bpvF.getFPatientVisitFundsBillingId())));
                bpvF.statusDebtorVoid = config1.StringNull(rs.getString(bpvF.getFStatusDebtorVoid()));
                bpvF.cntDebtorVoid = config1.StringNull(rs.getString(bpvF.getFCntDebtorVoid()));
                bpvF.statusUnbilling = config1.StringNull(rs.getString(bpvF.getFStatusUnbilling()));
            }
            rs.close();
            //      conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpvF;
    }

    public Vector getBackTPatientVisitFunds(String branch_id, String patient_visit_funds_id, String where, String flag) {
        Connection conn;
        Vector v_back_patient_visit_funds = new Vector();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            v_back_patient_visit_funds = getBackTPatientVisitFunds(stbangna, branch_id, patient_visit_funds_id, where, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_back_patient_visit_funds;
    }
    
    public Vector getBackTPatientVisitFunds(Statement stbangna,String branch_id, String bpvFId, String where, String flag) {
        String sql = ""; String hn_search = ""; String date_end = "";
        Vector v_back_patient_visit_funds = new Vector();
        try {
            //      Connection conn = config1.getConnectionBangna();
            //      Statement stbangna = conn.createStatement();
            if (!where.equals("")) {
                hn_search = " and " + bpvF.getFVisitHn() + " like '%" + where + "'";
            }
            if (!bpvFId.equals("")) {
                date_end = " and " + bpvF.getFCloseDayDate() + " <= '" + config1.DateFormatShow2DB(bpvFId, "ddMMyyyy") + "' ";
            }
            if (flag.equals("status_billing_no")) {
                sql = "Select * From " + bpvF.getBackTPatientVisitFunds() + " "
                    + "Where "+bpvF.getFStatusBilling() + "='0' and " + bpvF.getFBranchId() + "='" + branch_id + "' and "
                    + bpvF.getFPatientVisitFundsActive() + "='1' " + hn_search + date_end
                    + "Order By " + bpvF.getFPatientVisitFundsId() + " asc";
            }else if (flag.equals("injury_number_billing_no")) {//ต้องใช้ vn เพราะจะได้
                sql = "Select min("+bpvF.getFVisitVn()+") as "+bpvF.getFVisitVn()+"_min, "+"max("+bpvF.getFVisitVn()+") as visit_vn_max, "
                        + "count("+bpvF.getFInjuryNumber()+") as cnt, sum("+bpvF.getFVisitTotal()+") as "+bpvF.getFVisitTotal()+" "
                        + "From " + bpvF.getBackTPatientVisitFunds() + " "
                    + "Where "+bpvF.getFStatusBilling() + "='0' and " + bpvF.getFBranchId() + "='" + branch_id + "' and "
                    + bpvF.getFPatientVisitFundsActive() + "='1' and "+bpvF.getFInjuryNumber()+" <> '-' "+date_end+hn_search
                    + "Group By "+bpvF.getFInjuryNumber()+" "
                    + "Order By " + bpvF.getFVisitVn() + "_min asc";
            }else if (flag.equals("injury_number_billing_yes")) {
                sql = "Select min("+bpvF.getFPatientVisitFundsId()+") as "+bpvF.getFPatientVisitFundsId()+", "
                        + "count("+bpvF.getFInjuryNumber()+") as cnt, sum("+bpvF.getFVisitTotal()+") as "+bpvF.getFVisitTotal()+" "
                        + "From " + bpvF.getBackTPatientVisitFunds() + " "
                    + "Where "+bpvF.getFStatusBilling() + "='1' and " + bpvF.getFBranchId() + "='" + branch_id + "' and "
                    + bpvF.getFPatientVisitFundsActive() + "='1' and "+bpvF.getFInjuryNumber()+" <> '-' "+date_end
                    + "Group By "+bpvF.getFInjuryNumber()+" "
                    + "Order By " + bpvF.getFPatientVisitFundsId() + " asc";
            }else if (flag.equals("patient_import_id")) {
                sql = "Select * From " + bpvF.getBackTPatientVisitFunds() + " "
                        + "Where " + bpvF.getFPatientImportId() + "='" + bpvFId + "' and "+bpvF.getFPatientVisitFundsActive()+"='1' ";
            }else if(flag.equals("billing_number")) {
                sql = "Select * From "+bpvF.getBackTPatientVisitFunds()+" "
                    +"Where "+bpvF.getFBillingInvoiceNumber()+" = '"+bpvFId+"' and "+bpvF.getFPatientVisitFundsActive()+"='1' "
                    + "Order By "+bpvF.getFPatientVisitFundsId() ;
            }else if(flag.equals("billing_number_sort_by_visit_date")) {
                sql = "Select * From "+bpvF.getBackTPatientVisitFunds()+" "
                    +"Where "+bpvF.getFBillingInvoiceNumber()+" = '"+bpvFId+"' and "+bpvF.getFPatientVisitFundsActive()+"='1' and "
                    +bpvF.getFVisitHn()+"='"+where+"' "
                    + "Order By "+bpvF.getFVisitDate()+","+bpvF.getFVisitBeginVisitTime() ;
            }else if(flag.equals("injury_number_sort_by_visit_date")) {
                
                sql = "Select * From "+bpvF.getBackTPatientVisitFunds()+" "
                    +"Where "+bpvF.getFInjuryNumber()+" = '"+bpvFId+"' and "+bpvF.getFPatientVisitFundsActive()+"='1' and "
                    +bpvF.getFVisitHn()+"='"+where+"' "
                    + "Order By "+bpvF.getFVisitDate()+","+bpvF.getFVisitBeginVisitTime() ;
            }else if(flag.equals("injury_number_sort_by_visit_date_less_than_visit_date")) {
                String visitHn="", visitDate="";
                String[] tmp1 = where.split("@");
                if(tmp1.length>1){
                    visitDate = tmp1[0];
                    visitHn = tmp1[1];
                }
                sql = "Select * From "+bpvF.getBackTPatientVisitFunds()+" "
                    +"Where "+bpvF.getFInjuryNumber()+" = '"+bpvFId+"' and "+bpvF.getFPatientVisitFundsActive()+"='1' and "
                    +bpvF.getFVisitDate()+" <'"+visitDate+"' and "+bpvF.getFVisitHn()+"='"+visitHn+"' "
                    + "Order By "+bpvF.getFVisitDate()+","+bpvF.getFVisitBeginVisitTime() ;
            }else if(flag.equals("billing_number_status_billing_complete")) {// check status bill ว่า รับชำระหมดแล้วหรือไม่ เพื่อจะได้นำค่าไป update funds_billing
                sql = "Select * From "+bpvF.getBackTPatientVisitFunds()+" "// คือ ต้องการ check ว่า มี bill ที่ยังรับชำระไม่หมดหรือไม่
                    +"Where "+bpvF.getFBillingInvoiceNumber()+" = '"+bpvFId+"' and "+bpvF.getFPatientVisitFundsActive()+"='1' "
                    +" and "+bpvF.getFStatusBilling()+"<>'4' "
                    + "Order By "+bpvF.getFPatientVisitFundsId() ;
            }else if(flag.equals("billing_number_hn")) {//ดึงข้อมูลที่ตั้งหนี้แล้ว
                sql = "Select * From "+bpvF.getBackTPatientVisitFunds()+" "
                    +"Where "+bpvF.getFVisitHn()+" = '"+bpvFId+"' and "+bpvF.getFPatientVisitFundsActive()+"='1' "
                    + " and "+bpvF.getFStatusBilling() +"='2' "
                    + "Order By "+bpvF.getFPatientVisitFundsId() ;
            }else if(flag.equals("searchhnvoid")) {//ดึงข้อมูลที่รับชำระแล้ว
                sql = "Select * From "+bpvF.getBackTPatientVisitFunds()+" "
                    +"Where "+bpvF.getFVisitHn()+" = '"+bpvFId+"' and "+bpvF.getFPatientVisitFundsActive()+"='1' "
                    + " and "+bpvF.getFStatusBilling() +"='4' "
                    + "Order By "+bpvF.getFPatientVisitFundsId() ;
            }else if(flag.equals("searchPaymentIdVoid")) {//ดึงข้อมูลที่รับชำระแล้ว
                sql = "Select * From "+bpvF.getBackTPatientVisitFunds()+" "
                    +"Where "+bpvF.getFPatientVisitFundsId()+" = '"+bpvFId+"' and "+bpvF.getFPatientVisitFundsActive()+"='1' "
//                    + " and "+bpv_f.getFStatusBilling() +"='4' "
                    + "Order By "+bpvF.getFPatientVisitFundsId() ;
            }else if(flag.equals("visitHn_autosearch")) {
                sql="Select Distinct "+bpvF.getFVisitHn()+","+bpvF.getFPatientFullnamet()+" From "+bpvF.getBackTPatientVisitFunds()+" "
                    +"Where "+bpvF.getFPatientVisitFundsActive()+"='1' and "+bpvF.getFVisitHn()+" like '"+where+"%'  "
                    + "Order By "+bpvF.getFVisitHn() +" limit 40";
            }else if(flag.equals("visitHnNoBilling")) {
                sql="Select * From "+bpvF.getBackTPatientVisitFunds()+" "
                    +"Where "+bpvF.getFPatientVisitFundsActive()+"='1' and "+bpvF.getFVisitHn()+" = '"+where+"'  "
                    + "Order By "+bpvF.getFVisitHn() +" ";
            }else {
                sql = "Select * From " + bpvF.getBackTPatientVisitFunds() + " "
                        + "Where " + bpvF.getFPatientVisitFundsId() + "='" + bpvFId + "' " ;
            }

            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpvF = new BackTPatientVisitFunds();
                if(flag.equals("injury_number_billing_yes")){
                    bpvF.setPatientVisitFundsId(rs.getString(bpvF.getFPatientVisitFundsId()));
                    bpvF.setVisitTotal(Double.parseDouble(rs.getString(bpvF.getFVisitTotal())));
                    bpvF.setBServicePointId(rs.getString("cnt"));
                }else if(flag.equals("injury_number_billing_no")){
                    bpvF.setVisitVn(rs.getString("visit_vn_min"));
                    bpvF.setPatientVisitFundsId(rs.getString("visit_vn_max"));
                    bpvF.setVisitTotal(Double.parseDouble(rs.getString(bpvF.getFVisitTotal())));
                    bpvF.setBServicePointId(rs.getString("cnt"));
                }else if(flag.equals("visitHn_autosearch")) {
                    bpvF.visitHn = config1.StringNull(rs.getString(bpvF.getFVisitHn()));
                    bpvF.patientFullnamet = config1.StringNull(rs.getString(bpvF.getFPatientFullnamet()));
                }else{
                    bpvF.setBServicePointId(config1.StringNull(rs.getString(bpvF.getFBServicePointId())));
                    bpvF.setBVisitClinicId(config1.StringNull(rs.getString(bpvF.getFBVisitClinicId())));
                    bpvF.setVisitClaimId(config1.StringNull(rs.getString(bpvF.getFVisitClaimId())));
                    bpvF.setVisitPaidId(config1.StringNull(rs.getString(bpvF.getFVisitPaidId())));
                    bpvF.setPatientFullnamet(config1.StringNull(rs.getString(bpvF.getFPatientFullnamet())));

                    bpvF.setPatientVisitId(config1.StringNull(rs.getString(bpvF.getFPatientVisitId())));
                    bpvF.setTPatientId(config1.StringNull(rs.getString(bpvF.getFTPatientId())));
                    bpvF.setVisitBeginVisitTime(config1.StringNull(rs.getString(bpvF.getFVisitBeginVisitTime())));
                    bpvF.setVisitDate(config1.StringNull(rs.getString(bpvF.getFVisitDate())));
                    bpvF.setVisitDiagnosisNotice(config1.StringNull(rs.getString(bpvF.getFVisitDiagnosisNotice())));

                    bpvF.setVisitFinancialDischargeTime(config1.StringNull(rs.getString(bpvF.getFVisitFinancialDischargeTime())));
                    bpvF.setVisitFirstVisit(config1.StringNull(rs.getString(bpvF.getFVisitFirstVisit())));
                    bpvF.setVisitHn(config1.StringNull(rs.getString(bpvF.getFVisitHn())));
                    bpvF.setVisitHospitalService(config1.StringNull(rs.getString(bpvF.getFVisitHospitalService())));
                    bpvF.setVisitNotice(config1.StringNull(rs.getString(bpvF.getFVisitNotice())));

                    bpvF.setVisitPatientAge(config1.StringNull(rs.getString(bpvF.getFVisitPatientAge())));
                    bpvF.setVisitPatientSelfDoctor(config1.StringNull(rs.getString(bpvF.getFVisitPatientSelfDoctor())));
                    bpvF.setVisitVn(config1.StringNull(rs.getString(bpvF.getFVisitVn())));
                    bpvF.setVisitClaimNamet(config1.StringNull(rs.getString(bpvF.getFVisitClaimNamet())));
                    bpvF.setVisitPaidNamet(config1.StringNull(rs.getString(bpvF.getFVisitPaidNamet())));

                    bpvF.setDepartmentNamet(config1.StringNull(rs.getString(bpvF.getFDepartmentNamet())));
                    bpvF.setDoctorNamet(config1.StringNull(rs.getString(bpvF.getFDoctorNamet())));
                    bpvF.setPatientImportId(config1.StringNull(rs.getString(bpvF.getFPatientImportId())));
                    bpvF.setBranchId(config1.StringNull(rs.getString(bpvF.getFBranchId())));
                    bpvF.setSysStatus(config1.StringNull(rs.getString(bpvF.getFSysStatus())));

                    bpvF.setVisitPaid(Double.valueOf(rs.getString(bpvF.getFVisitPaid())));
                    bpvF.setVisitTotal(Double.valueOf(rs.getString(bpvF.getFVisitTotal())));
                    bpvF.setVisitDiscount(Double.valueOf(rs.getString(bpvF.getFVisitDiscount())));
                    bpvF.setPatientVisitId(config1.StringNull(rs.getString(bpvF.getFPatientVisitId())));
                    bpvF.setVisitContactId(config1.StringNull(rs.getString(bpvF.getFVisitContactId())));

                    bpvF.setVisitContactNamet(config1.StringNull(rs.getString(bpvF.getFVisitContactNamet())));
                    bpvF.setPatientVisitFundsId(config1.StringNull(rs.getString(bpvF.getFPatientVisitFundsId())));
                    bpvF.setPatientVisitFundsActive(config1.StringNull(rs.getString(bpvF.getFPatientVisitFundsActive())));
                    bpvF.setStatusBilling(config1.StringNull(rs.getString(bpvF.getFStatusBilling())));
                    bpvF.setInjuryNumber(config1.StringNull(rs.getString(bpvF.getFInjuryNumber())));

                    bpvF.setRecordStatus(config1.StringNull(rs.getString(bpvF.getFRecordStatus())));
                    bpvF.setCloseDayDate(config1.StringNull(rs.getString(bpvF.getFCloseDayDate())));
                    bpvF.setVisitContactJoinId(config1.StringNull(rs.getString(bpvF.getFVisitContactJoinId())));
                    bpvF.setVisitContactJoinNamet(config1.StringNull(rs.getString(bpvF.getFVisitContactJoinNamet())));
                    bpvF.setBillingInvoiceNumber(config1.StringNull(rs.getString(bpvF.getFBillingInvoiceNumber())));

                    bpvF.setReceiveAmount(Double.valueOf(rs.getString(bpvF.getFReceiveAmount())));
                    bpvF.setBillingPaymentItemId(config1.StringNull(rs.getString(bpvF.getFBillingPaymentItemId())));
                    bpvF.setPatientVisitFundsBillingId(config1.StringNull(rs.getString(bpvF.getFPatientVisitFundsBillingId())));
                    bpvF.statusDebtorVoid = config1.StringNull(rs.getString(bpvF.getFStatusDebtorVoid()));
                    bpvF.cntDebtorVoid = config1.StringNull(rs.getString(bpvF.getFCntDebtorVoid()));
                    bpvF.statusUnbilling = config1.StringNull(rs.getString(bpvF.getFStatusUnbilling()));
                }

                v_back_patient_visit_funds.add(bpvF);
            }
            rs.close();
        //      conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_back_patient_visit_funds;
    }
    public BackTPatientVisitFundsItem getBackTPatientVisitFundsItemByPK(String branch_id,String bpv_fi_id,String flag){
        try {
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            bpv_fi = getBackTPatientVisitFundsItemByPK(stbangna, branch_id,bpv_fi_id,flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpv_fi;
    }
    public BackTPatientVisitFundsItem getBackTPatientVisitFundsItemByPK(Statement stbangna, String branch_id,String bpv_fi_id,String flag) {
        String sql = "";
        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();
            if(flag.equals("sum_item")){
                sql="Select sum(item_total)as item_total, sum(item_discount) as item_discount, sum(item_paid) as item_paid "
                        + "From "+bpv_fi.getBackTPatientVisitFundsItem()+ " "
                        +"Where "+bpv_fi.getFPatientVisitFundsId()+" = '"+bpv_fi_id+"' and "+bpv_fi.getFBillingInvoiceItemActive()+"='1' ";
            }else if(flag.equals("bpviId")){
                sql = "Select * From " + bpv_fi.getBackTPatientVisitFundsItem() + " "
                  + "Where " + bpv_fi.getFPatientVisitItemId() + "='" + bpv_fi_id + "'";
            }else{
                sql = "Select * From " + bpv_fi.getBackTPatientVisitFundsItem() + " "
                  + "Where " + bpv_fi.getFPatientVisitFundsItemId() + "='" + bpv_fi_id + "'";
            }

            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpv_fi = new BackTPatientVisitFundsItem();
                if(flag.equals("sum_item")){
                    bpv_fi.setPatientVisitFundsId(bpv_fi_id);
                    bpv_fi.setItemDiscount(Double.valueOf(rs.getString(bpv_fi.getFItemDiscount())));
                    bpv_fi.setItemPaid(Double.valueOf(rs.getString(bpv_fi.getFItemPaid())));
                    bpv_fi.setItemTotal(Double.valueOf(rs.getString(bpv_fi.getFItemTotal())));
                }else{
                    bpv_fi.setBItemBillingSubgroupId(rs.getString(bpv_fi.getFBItemBillingSubgroupId()));
                    bpv_fi.setBItemId(rs.getString(bpv_fi.getFBItemId()));
                    bpv_fi.setBillingInvoiceItemActive(rs.getString(bpv_fi.getFBillingInvoiceItemActive()));
                    bpv_fi.setBillingInvoiceItemTotal(Double.valueOf(rs.getString(bpv_fi.getFBillingInvoiceItemTotal())));
                    bpv_fi.setBillingInvoiceNumber(rs.getString(bpv_fi.getFBillingInvoiceNumber()));

                    bpv_fi.setClaimId(rs.getString(bpv_fi.getFClaimId()));
                    bpv_fi.setClaimNamet(rs.getString(bpv_fi.getFClaimNamet()));
                    bpv_fi.setDepartmentNamet(rs.getString(bpv_fi.getFDepartmentNamet()));
                    bpv_fi.setPatientVisitFundsItemId(rs.getString(bpv_fi.getFPatientVisitFundsItemId()));
                    bpv_fi.setPatientVisitId(rs.getString(bpv_fi.getFPatientVisitId()));

                    bpv_fi.setTBillingId(rs.getString(bpv_fi.getFTBillingId()));
                    bpv_fi.setTBillingInvoiceDateTime(rs.getString(bpv_fi.getFTBillingInvoiceDateTime()));
                    bpv_fi.setTBillingInvoiceItemId(rs.getString(bpv_fi.getFTBillingInvoiceItemId()));
                    bpv_fi.setTBillingInvoiceItemNamet(rs.getString(bpv_fi.getFTBillingInvoiceItemNamet()));
                    bpv_fi.setTBillingInvoiceTime(rs.getString(bpv_fi.getFTBillingInvoiceTime()));

                    bpv_fi.setTOrderItemId(rs.getString(bpv_fi.getFTOrderItemId()));
                    bpv_fi.setTPatientId(rs.getString(bpv_fi.getFTPatientId()));
                    bpv_fi.setTPaymentId(rs.getString(bpv_fi.getFTPaymentId()));
                    bpv_fi.setVisitId(rs.getString(bpv_fi.getFVisitId()));
                    bpv_fi.setVisitPatientSelfDoctor(rs.getString(bpv_fi.getFVisitPatientSeftDoctor()));

                    bpv_fi.setVisitVn(rs.getString(bpv_fi.getFVisitVn()));
                    bpv_fi.setDepartmentId(rs.getString(bpv_fi.getFDepartmentId()));
                    bpv_fi.setVisitHn(rs.getString(bpv_fi.getFVisitHn()));
                    bpv_fi.setBranchId(config1.StringNull(rs.getString(bpv_fi.getFBranchId())));
                    bpv_fi.setSysStatus(config1.StringNull(rs.getString(bpv_fi.getFSysStatus())));

                    bpv_fi.setItemDiscount(Double.valueOf(rs.getString(bpv_fi.getFItemDiscount())));
                    bpv_fi.setItemPaid(Double.valueOf(rs.getString(bpv_fi.getFItemPaid())));
                    bpv_fi.setItemTotal(Double.valueOf(rs.getString(bpv_fi.getFItemTotal())));
                    bpv_fi.setItemNametEditStatus(config1.StringNull(rs.getString(bpv_fi.getFItemNametEditStatus())));
                    bpv_fi.setRecordStatus(config1.StringNull(rs.getString(bpv_fi.getFRecordStatus())));

                    bpv_fi.setPatientVisitItemId(config1.StringNull(rs.getString(bpv_fi.getFPatientVisitItemId())));
                    bpv_fi.setItemTotalOrginal(Double.valueOf(rs.getString(bpv_fi.getFItemTotalOrginal())));
                    bpv_fi.setPatientVisitFundsId(config1.StringNull(rs.getString(bpv_fi.getFPatientVisitFundsId())));
                    bpv_fi.setFItemGroupId(config1.StringNull(rs.getString(bpv_fi.getFFItemGroupId())));
                    bpv_fi.setItemNametEdit(config1.StringNull(rs.getString(bpv_fi.getFItemNametEdit())));

                    bpv_fi.setItemTotalEditStatus(config1.StringNull(rs.getString(bpv_fi.getFItemTotalEditStatus())));
                    bpv_fi.setItemTotalEdit(Double.valueOf(rs.getString(bpv_fi.getFItemTotalEdit())));
                    bpv_fi.setInjuryNumber(config1.StringNull(rs.getString(bpv_fi.getFInjuryNumber())));
                    bpv_fi.doctorId = config1.StringNull(rs.getString(bpv_fi.getFDoctorId()));
                    bpv_fi.doctorNamet = config1.StringNull(rs.getString(bpv_fi.getFDoctorNamet()));
                    bpv_fi.orderHome = config1.StringNull(rs.getString(bpv_fi.getFOrderHome()));
                }
            }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpv_fi;
    }
    public Vector getBackTPatientVisitFundsItem(String branch_id, String visit_hn, String bpv_f_id, String flag) {
        Vector v_bpv_fbi = new Vector();
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            v_bpv_fbi = getBackTPatientVisitFundsItem(stbangna,branch_id,visit_hn, bpv_f_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return v_bpv_fbi;
    }
  public Vector getBackTPatientVisitFundsItem(Statement stbangna,String branch_id, String visit_hn, String bpv_f_id, String flag) {
    String sql = "", where="";
    Vector v_bpv_fbi = new Vector();
    try {
//      Connection conn = config1.getConnectionBangna();
//      Statement stbangna = conn.createStatement();

      if (flag.equals("billing")) {
        sql = "Select * From " + bpv_fi.getBackTPatientVisitFundsItem() + " "
                + "Where " + bpv_fi.getFPatientVisitFundsId() + "='" + bpv_f_id + "' and "
                + bpv_fi.getFBillingInvoiceItemActive() + "='1' "
                + "Order By " + bpv_fi.getFPatientVisitFundsItemId() + " asc";
      } else if (flag.equals("billing_item") || flag.equals("injury_number") || flag.equals("bill_visit_id")) {
          if(flag.equals("injury_number")){
              where = " bpv_f."+bpvF.getFInjuryNumber() + "='" + bpv_f_id+"' and bpv_f."+bpvF.getFPatientVisitFundsActive()+"='1' and bpv_f."
                      + bpvF.getFVisitHn()+"='"+visit_hn+"' ";
          }else if(flag.equals("visit_vn")){
              where = " bpv_f."+bpvF.getFVisitVn() + "='" + bpv_f_id+"' and bpv_f."+bpvF.getFPatientVisitFundsActive()+"='1' and bpv_f."
                      + bpvF.getFVisitHn()+"='"+visit_hn+"' ";
          }else{
              where = " bpv_fi."+bpv_fi.getFPatientVisitFundsId() + "='" + bpv_f_id+"' and bpv_f."
                      + bpvF.getFVisitHn()+"='"+visit_hn+"' ";
          }
        sql = "Select min(bpv_fi." + bpv_fi.getFBItemBillingSubgroupId() + ") as " + bpv_fi.getFBItemBillingSubgroupId() + ","
                + "min(bpv_fi." + bpv_fi.getFBItemId() + ") as " + bpv_fi.getFBItemId() + ","
                + "min(bpv_fi." + bpv_fi.getFBillingInvoiceItemActive() + ") as " + bpv_fi.getFBillingInvoiceItemActive() + ","
                + "sum(bpv_fi." + bpv_fi.getFBillingInvoiceItemTotal() + ") as " + bpv_fi.getFBillingInvoiceItemTotal() + ","
                + "min(bpv_fi." + bpv_fi.getFBillingInvoiceNumber() + ") as " + bpv_fi.getFBillingInvoiceNumber() + ","
                + "min(bpv_fi." + bpv_fi.getFBranchId() + ") as " + bpv_fi.getFBranchId() + ","
                + "min(bpv_fi." + bpv_fi.getFClaimId() + ") as " + bpv_fi.getFClaimId() + ","
                + "min(bpv_fi." + bpv_fi.getFClaimNamet() + ") as " + bpv_fi.getFClaimNamet() + ","
                + "min(bpv_fi." + bpv_fi.getFDepartmentId() + ") as " + bpv_fi.getFDepartmentId() + ","
                + "min(bpv_fi." + bpv_fi.getFDepartmentNamet() + ") as " + bpv_fi.getFDepartmentNamet() + ","
                + "min(bpv_fi." + bpv_fi.getFFItemGroupId() + ") as " + bpv_fi.getFFItemGroupId() + ","
                + "sum(bpv_fi." + bpv_fi.getFItemDiscount() + ") as " + bpv_fi.getFItemDiscount() + ","
                + "min(bpv_fi." + bpv_fi.getFItemNametEdit() + ") as " + bpv_fi.getFItemNametEdit() + ","
                + "min(bpv_fi." + bpv_fi.getFItemNametEditStatus() + ") as " + bpv_fi.getFItemNametEditStatus() + ","
                + "sum(bpv_fi." + bpv_fi.getFItemPaid() + ") as " + bpv_fi.getFItemPaid() + ","
                + "sum(bpv_fi." + bpv_fi.getFItemTotal() + ") as " + bpv_fi.getFItemTotal() + ","
                + "min(bpv_fi." + bpv_fi.getFItemTotalEdit() + ") as " + bpv_fi.getFItemTotalEdit() + ","
                + "min(bpv_fi." + bpv_fi.getFItemTotalEditStatus() + ") as " + bpv_fi.getFItemTotalEditStatus() + ","
                + "sum(bpv_fi." + bpv_fi.getFItemTotalOrginal() + ") as " + bpv_fi.getFItemTotalOrginal() + ","
                + "min(bpv_fi." + bpv_fi.getFPatientVisitFundsId() + ") as " + bpv_fi.getFPatientVisitFundsId() + ","
                + "min(bpv_fi." + bpv_fi.getFPatientVisitId() + ") as " + bpv_fi.getFPatientVisitId() + ","
                + "min(bpv_fi." + bpv_fi.getFPatientVisitItemId() + ") as " + bpv_fi.getFPatientVisitItemId() + ","
                + "min(bpv_fi." + bpv_fi.getFRecordStatus() + ") as " + bpv_fi.getFRecordStatus() + ","
                + "min(bpv_fi." + bpv_fi.getFSysStatus() + ") as " + bpv_fi.getFSysStatus() + ","
                + "min(bpv_fi." + bpv_fi.getFTBillingId() + ") as " + bpv_fi.getFTBillingId() + ","
                + "min(bpv_fi." + bpv_fi.getFTBillingInvoiceDateTime() + ") as " + bpv_fi.getFTBillingInvoiceDateTime() + ","
                + "min(bpv_fi." + bpv_fi.getFTBillingInvoiceItemId() + ") as " + bpv_fi.getFTBillingInvoiceItemId() + ","
                + "min(bpv_fi." + bpv_fi.getFTBillingInvoiceItemNamet() + ") as " + bpv_fi.getFTBillingInvoiceItemNamet() + ","
                + "min(bpv_fi." + bpv_fi.getFTBillingInvoiceTime() + ") as " + bpv_fi.getFTBillingInvoiceTime() + ","
                + "min(bpv_fi." + bpv_fi.getFTOrderItemId() + ") as " + bpv_fi.getFTOrderItemId() + ","
                + "min(bpv_fi." + bpv_fi.getFTPatientId() + ") as " + bpv_fi.getFTPatientId() + ","
                + "min(bpv_fi." + bpv_fi.getFTPaymentId() + ") as " + bpv_fi.getFTPaymentId() + ","
                + "min(bpv_fi." + bpv_fi.getFVisitHn() + ") as " + bpv_fi.getFVisitHn() + ","
                + "min(bpv_fi." + bpv_fi.getFVisitId() + ") as " + bpv_fi.getFVisitId() + ","
                + "min(bpv_fi." + bpv_fi.getFVisitPatientSeftDoctor() + ") as " + bpv_fi.getFVisitPatientSeftDoctor() + ","
                + "min(bpv_fi." + bpv_fi.getFVisitVn() + ") as " + bpv_fi.getFVisitVn() + ","
                + "min(bpv_fi." + bpv_fi.getFInjuryNumber() + ") as " + bpv_fi.getFInjuryNumber() + ","
                + "min(bpv_fi." + bpv_fi.getFOrderHome() + ") as " + bpv_fi.getFOrderHome() + ","
                + "'' as " + bpv_fi.getFPatientVisitFundsItemId() + " "
                + "From " + bpv_fi.getBackTPatientVisitFundsItem() + " as bpv_fi "
                + "inner join "+bpvF.getBackTPatientVisitFunds()+" as bpv_f on "
                + "bpv_f."+bpvF.getFPatientVisitFundsId()+" = bpv_fi."+bpv_fi.getFPatientVisitFundsId()+"  "
                + "Where " + where + " and bpv_fi."
                + bpv_fi.getFBillingInvoiceItemActive() + "='1' and bpv_fi." + bpv_fi.getFBranchId() + "='" + branch_id + "' and bpv_f."+bpvF.getFStatusBilling()+"='1'"
                + "Group by bpv_fi.b_item_billing_subgroup_id ";
      } else if (flag.equals("prepare_billing")) {
          if(flag.equals("prepare_billing")){
              where = " bpv_f."+bpvF.getFInjuryNumber() + "='" + bpv_f_id+"' and bpv_f."+bpvF.getFPatientVisitFundsActive()+"='1' and bpv_f."
                      + bpvF.getFVisitHn()+"='"+visit_hn+"' ";
          }else{
              where = " bpv_fi."+bpv_fi.getFPatientVisitFundsId() + "='" + bpv_f_id+"' ";
          }
        sql = "Select min(bpv_fi." + bpv_fi.getFBItemBillingSubgroupId() + ") as " + bpv_fi.getFBItemBillingSubgroupId() + ","
                + "min(bpv_fi." + bpv_fi.getFBItemId() + ") as " + bpv_fi.getFBItemId() + ","
                + "min(bpv_fi." + bpv_fi.getFBillingInvoiceItemActive() + ") as " + bpv_fi.getFBillingInvoiceItemActive() + ","
                + "sum(bpv_fi." + bpv_fi.getFBillingInvoiceItemTotal() + ") as " + bpv_fi.getFBillingInvoiceItemTotal() + ","
                + "min(bpv_fi." + bpv_fi.getFBillingInvoiceNumber() + ") as " + bpv_fi.getFBillingInvoiceNumber() + ","
                + "min(bpv_fi." + bpv_fi.getFBranchId() + ") as " + bpv_fi.getFBranchId() + ","
                + "min(bpv_fi." + bpv_fi.getFClaimId() + ") as " + bpv_fi.getFClaimId() + ","
                + "min(bpv_fi." + bpv_fi.getFClaimNamet() + ") as " + bpv_fi.getFClaimNamet() + ","
                + "min(bpv_fi." + bpv_fi.getFDepartmentId() + ") as " + bpv_fi.getFDepartmentId() + ","
                + "min(bpv_fi." + bpv_fi.getFDepartmentNamet() + ") as " + bpv_fi.getFDepartmentNamet() + ","
                + "min(bpv_fi." + bpv_fi.getFFItemGroupId() + ") as " + bpv_fi.getFFItemGroupId() + ","
                + "sum(bpv_fi." + bpv_fi.getFItemDiscount() + ") as " + bpv_fi.getFItemDiscount() + ","
                + "min(bpv_fi." + bpv_fi.getFItemNametEdit() + ") as " + bpv_fi.getFItemNametEdit() + ","
                + "min(bpv_fi." + bpv_fi.getFItemNametEditStatus() + ") as " + bpv_fi.getFItemNametEditStatus() + ","
                + "sum(bpv_fi." + bpv_fi.getFItemPaid() + ") as " + bpv_fi.getFItemPaid() + ","
                + "sum(bpv_fi." + bpv_fi.getFItemTotal() + ") as " + bpv_fi.getFItemTotal() + ","
                + "min(bpv_fi." + bpv_fi.getFItemTotalEdit() + ") as " + bpv_fi.getFItemTotalEdit() + ","
                + "min(bpv_fi." + bpv_fi.getFItemTotalEditStatus() + ") as " + bpv_fi.getFItemTotalEditStatus() + ","
                + "sum(bpv_fi." + bpv_fi.getFItemTotalOrginal() + ") as " + bpv_fi.getFItemTotalOrginal() + ","
                + "min(bpv_fi." + bpv_fi.getFPatientVisitFundsId() + ") as " + bpv_fi.getFPatientVisitFundsId() + ","
                + "min(bpv_fi." + bpv_fi.getFPatientVisitId() + ") as " + bpv_fi.getFPatientVisitId() + ","
                + "min(bpv_fi." + bpv_fi.getFPatientVisitItemId() + ") as " + bpv_fi.getFPatientVisitItemId() + ","
                + "min(bpv_fi." + bpv_fi.getFRecordStatus() + ") as " + bpv_fi.getFRecordStatus() + ","
                + "min(bpv_fi." + bpv_fi.getFSysStatus() + ") as " + bpv_fi.getFSysStatus() + ","
                + "min(bpv_fi." + bpv_fi.getFTBillingId() + ") as " + bpv_fi.getFTBillingId() + ","
                + "min(bpv_fi." + bpv_fi.getFTBillingInvoiceDateTime() + ") as " + bpv_fi.getFTBillingInvoiceDateTime() + ","
                + "min(bpv_fi." + bpv_fi.getFTBillingInvoiceItemId() + ") as " + bpv_fi.getFTBillingInvoiceItemId() + ","
                + "min(bpv_fi." + bpv_fi.getFTBillingInvoiceItemNamet() + ") as " + bpv_fi.getFTBillingInvoiceItemNamet() + ","
                + "min(bpv_fi." + bpv_fi.getFTBillingInvoiceTime() + ") as " + bpv_fi.getFTBillingInvoiceTime() + ","
                + "min(bpv_fi." + bpv_fi.getFTOrderItemId() + ") as " + bpv_fi.getFTOrderItemId() + ","
                + "min(bpv_fi." + bpv_fi.getFTPatientId() + ") as " + bpv_fi.getFTPatientId() + ","
                + "min(bpv_fi." + bpv_fi.getFTPaymentId() + ") as " + bpv_fi.getFTPaymentId() + ","
                + "min(bpv_fi." + bpv_fi.getFVisitHn() + ") as " + bpv_fi.getFVisitHn() + ","
                + "min(bpv_fi." + bpv_fi.getFVisitId() + ") as " + bpv_fi.getFVisitId() + ","
                + "min(bpv_fi." + bpv_fi.getFVisitPatientSeftDoctor() + ") as " + bpv_fi.getFVisitPatientSeftDoctor() + ","
                + "min(bpv_fi." + bpv_fi.getFVisitVn() + ") as " + bpv_fi.getFVisitVn() + ","
                + "min(bpv_fi." + bpv_fi.getFInjuryNumber() + ") as " + bpv_fi.getFInjuryNumber() + ","
                + "min(bpv_fi." + bpv_fi.getFOrderHome() + ") as " + bpv_fi.getFOrderHome() + ","
                + "'' as " + bpv_fi.getFPatientVisitFundsItemId() + " "
                + "From " + bpv_fi.getBackTPatientVisitFundsItem() + " as bpv_fi "
                + "inner join "+bpvF.getBackTPatientVisitFunds()+" as bpv_f on "
                + "bpv_f."+bpvF.getFPatientVisitFundsId()+" = bpv_fi."+bpv_fi.getFPatientVisitFundsId()+" "
                + "Where " + where + " and bpv_fi."
                + bpv_fi.getFBillingInvoiceItemActive() + "='1' and bpv_fi." + bpv_fi.getFBranchId() + "='" + branch_id + "' and bpv_f."+bpvF.getFStatusBilling()+"='0' "
                + "Group by bpv_fi.b_item_billing_subgroup_id ";
      } else if (flag.equals("view_status_y")) {
        sql = "Select bpv_fi.* From " + bpv_fi.getBackTPatientVisitFundsItem() + " bpv_fi "
                + " inner join " + bpvF.getBackTPatientVisitFunds() + " bpv_f on bpv_fi."
                + bpv_fi.getFPatientVisitFundsId() + " = bpv_f." + bpvF.getFPatientVisitFundsId() + " and bpv_f."
                + bpvF.getFPatientVisitFundsActive() + "='1' "
                + "Where bpv_fi." + bpv_fi.getFPatientVisitId() + "='" + bpv_f_id + "' and bpv_fi."
                + bpv_fi.getFBillingInvoiceItemActive() + "='1' "
                + "Order By bpv_fi." + bpv_fi.getFPatientVisitFundsItemId() + " asc";
      }else{
        sql = "Select * From " + bpv_fi.getBackTPatientVisitFundsItem() + " " 
                + "Where " + bpv_fi.getFPatientVisitFundsId() + "='" + bpv_f_id + "' and "
                + bpv_fi.getFBillingInvoiceItemActive() + "='1' " + "Order By " + bpv_fi.getFPatientVisitFundsItemId() + " asc";
      }

      ResultSet rs = stbangna.executeQuery(sql);
      while (rs.next()) {
          bpv_fi = new BackTPatientVisitFundsItem();
        bpv_fi.setBItemBillingSubgroupId(rs.getString(bpv_fi.getFBItemBillingSubgroupId()));
        bpv_fi.setBItemId(rs.getString(bpv_fi.getFBItemId()));
        bpv_fi.setBillingInvoiceItemActive(rs.getString(bpv_fi.getFBillingInvoiceItemActive()));
        bpv_fi.setBillingInvoiceItemTotal(Double.valueOf(rs.getString(bpv_fi.getFBillingInvoiceItemTotal())));
        bpv_fi.setBillingInvoiceNumber(rs.getString(bpv_fi.getFBillingInvoiceNumber()));

        bpv_fi.setClaimId(rs.getString(bpv_fi.getFClaimId()));
        bpv_fi.setClaimNamet(rs.getString(bpv_fi.getFClaimNamet()));
        bpv_fi.setDepartmentNamet(rs.getString(bpv_fi.getFDepartmentNamet()));
        bpv_fi.setPatientVisitFundsItemId(rs.getString(bpv_fi.getFPatientVisitFundsItemId()));
        bpv_fi.setPatientVisitId(rs.getString(bpv_fi.getFPatientVisitId()));

        bpv_fi.setTBillingId(rs.getString(bpv_fi.getFTBillingId()));
        bpv_fi.setTBillingInvoiceDateTime(rs.getString(bpv_fi.getFTBillingInvoiceDateTime()));
        bpv_fi.setTBillingInvoiceItemId(rs.getString(bpv_fi.getFTBillingInvoiceItemId()));
        bpv_fi.setTBillingInvoiceItemNamet(rs.getString(bpv_fi.getFTBillingInvoiceItemNamet()));
        bpv_fi.setTBillingInvoiceTime(rs.getString(bpv_fi.getFTBillingInvoiceTime()));

        bpv_fi.setTOrderItemId(rs.getString(bpv_fi.getFTOrderItemId()));
        bpv_fi.setTPatientId(rs.getString(bpv_fi.getFTPatientId()));
        bpv_fi.setTPaymentId(rs.getString(bpv_fi.getFTPaymentId()));
        bpv_fi.setVisitId(rs.getString(bpv_fi.getFVisitId()));
        bpv_fi.setVisitPatientSelfDoctor(rs.getString(bpv_fi.getFVisitPatientSeftDoctor()));

        bpv_fi.setVisitVn(rs.getString(bpv_fi.getFVisitVn()));
        bpv_fi.setDepartmentId(rs.getString(bpv_fi.getFDepartmentId()));
        bpv_fi.setVisitHn(rs.getString(bpv_fi.getFVisitHn()));
        bpv_fi.setBranchId(config1.StringNull(rs.getString(bpv_fi.getFBranchId())));
        bpv_fi.setSysStatus(config1.StringNull(rs.getString(bpv_fi.getFSysStatus())));

        bpv_fi.setItemDiscount(Double.valueOf(rs.getString(bpv_fi.getFItemDiscount())));
        bpv_fi.setItemPaid(Double.valueOf(rs.getString(bpv_fi.getFItemPaid())));
        bpv_fi.setItemTotal(Double.valueOf(rs.getString(bpv_fi.getFItemTotal())));
        bpv_fi.setItemNametEditStatus(config1.StringNull(rs.getString(bpv_fi.getFItemNametEditStatus())));
        bpv_fi.setRecordStatus(config1.StringNull(rs.getString(bpv_fi.getFRecordStatus())));

        bpv_fi.setPatientVisitItemId(config1.StringNull(rs.getString(bpv_fi.getFPatientVisitItemId())));
        bpv_fi.setItemTotalOrginal(Double.valueOf(rs.getString(bpv_fi.getFItemTotalOrginal())));
        bpv_fi.setPatientVisitFundsId(config1.StringNull(rs.getString(bpv_fi.getFPatientVisitFundsId())));
        bpv_fi.setFItemGroupId(config1.StringNull(rs.getString(bpv_fi.getFFItemGroupId())));
        bpv_fi.setItemNametEdit(config1.StringNull(rs.getString(bpv_fi.getFItemNametEdit())));

        bpv_fi.setItemTotalEditStatus(config1.StringNull(rs.getString(bpv_fi.getFItemTotalEditStatus())));
        bpv_fi.setItemTotalEdit(Double.valueOf(rs.getString(bpv_fi.getFItemTotalEdit())));
        bpv_fi.setInjuryNumber(config1.StringNull(rs.getString(bpv_fi.getFInjuryNumber())));
        bpv_fi.orderHome = config1.StringNull(rs.getString(bpv_fi.getFOrderHome()));
        v_bpv_fbi.add(bpv_fi);
      }
      rs.close();
//      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return v_bpv_fbi;
  }
    public String setSaveBackTPatientVisitFunds(String branch_id, BackTPatientVisitFunds item) throws Exception {
        int chk = 0;
        String sql = ""; String max = "";
        try{
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            bpvF = getBackTPatientVisitFundsByPK(branch_id, item.getPatientVisitFundsId(), "");
            item.setPatientFullnamet(config1.StringNull(item.getPatientFullnamet()).replace("'", "''"));
            item.setVisitNotice(config1.StringNull(item.getVisitNotice()).replace("'", "''"));
            item.setVisitDiagnosisNotice(config1.StringNull(item.getVisitDiagnosisNotice()).replace("'", "''"));
            if (bpvF.getPatientVisitFundsId().equals("")) {
                item.generateOID(idtable);
                max = item.getObjectId();
//            max = getMaxRowBackTPatientVisitFunds(conn);
            sql = "Insert Into " + bpvF.getBackTPatientVisitFunds()
                    + "(" + bpvF.getFPatientVisitFundsId() + ", " + bpvF.getFBServicePointId() + ", "
                    + bpvF.getFBVisitClinicId() + "," + bpvF.getFVisitClaimId() + ","
                    + bpvF.getFVisitPaidId() + "," + bpvF.getFPatientFullnamet() + ","
                    + bpvF.getFPatientImportId() + "," + bpvF.getFTPatientId() + ","
                    + bpvF.getFVisitBeginVisitTime() + "," + bpvF.getFVisitDate() + ","
                    + bpvF.getFVisitDiagnosisNotice() + "," + bpvF.getFVisitFinancialDischargeTime() + ","
                    + bpvF.getFVisitFirstVisit() + "," + bpvF.getFVisitHn() + ","
                    + bpvF.getFVisitHospitalService() + "," + bpvF.getFVisitNotice() + ", "
                    + bpvF.getFVisitPatientAge() + "," + bpvF.getFVisitPatientSelfDoctor() + ", "
                    + bpvF.getFVisitVn() + "," + bpvF.getFVisitClaimNamet() + ","
                    + bpvF.getFVisitPaidNamet() + "," + bpvF.getFDepartmentNamet() + ","
                    + bpvF.getFDoctorNamet() + "," + bpvF.getFBranchId() + ","
                    + bpvF.getFSysStatus() + "," + bpvF.getFPatientVisitId() + ","
                    + bpvF.getFVisitContactId() + "," + bpvF.getFVisitContactNamet() + ","
                    + bpvF.getFPatientVisitFundsActive() + "," + bpvF.getFStatusBilling() + ","
                    + bpvF.getFVisitTotal() + "," + bpvF.getFVisitDiscount() + ","
                    + bpvF.getFVisitPaid() + "," + bpvF.getFInjuryNumber() + ","
                    + bpvF.getFRecordStatus() + "," + bpvF.getFCloseDayDate() + ","
                    + bpvF.getFBillingInvoiceNumber()+","+bpvF.getFReceiveAmount()+","
                    + bpvF.getFBillingPaymentItemId()+","+bpvF.getFPatientVisitFundsBillingId()+","
                    + bpvF.getFSurveillanceCaseId()+","+bpvF.getFFirstVisitDate()+","
                    + bpvF.getFFirstVisitVn()+","+ bpvF.getFStatusUnbilling()+ ") "
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
                    + item.getPatientVisitFundsActive() + "','" + item.getStatusBilling() + "',"
                    + item.getVisitTotal() + "," + item.getVisitDiscount() + ","
                    + item.getVisitPaid() + ",'" + item.getInjuryNumber() +"','"
                    + item.getRecordStatus() + "','" + item.getCloseDayDate() + "','"
                    + item.getBillingInvoiceNumber()+"',"+item.getReceiveAmount()+",'"
                    + item.getBillingPaymentItemId()+"','"+item.getPatientVisitFundsBillingId()+"','"
                    + item.surveillanceCaseId+"','"+item.firstVisitDate+"','"
                    + item.firstVisitVn+"','"+ item.statusUnbilling+"')";
            }else{
            sql = "Update " + bpvF.getBackTPatientVisitFunds()
                    + " set " + bpvF.getFBServicePointId() + " = '" + item.getBServicePointId() + "', "
                    + bpvF.getFBVisitClinicId() + " = '" + item.getBVisitClinicId() + "', "
                    + bpvF.getFVisitClaimId() + " = '" + item.getVisitClaimId() + "', "
                    + bpvF.getFVisitPaidId() + " = '" + item.getVisitPaidId() + "', "
                    + bpvF.getFPatientFullnamet() + " = '" + item.getPatientFullnamet() + "', "
                    + bpvF.getFPatientImportId() + " = '" + item.getPatientImportId() + "', "
                    + bpvF.getFTPatientId() + " = '" + item.getTPatientId() + "', "
                    + bpvF.getFVisitBeginVisitTime() + " = '" + item.getVisitBeginVisitTime() + "', "
                    + bpvF.getFVisitDate() + " = '" + item.getVisitDate() + "', "
                    + bpvF.getFVisitDiagnosisNotice() + " = '" + item.getVisitDiagnosisNotice() + "',"
                    + bpvF.getFVisitFinancialDischargeTime() + " = '" + item.getVisitFinancialDischargeTime() + "',"
                    + bpvF.getFVisitFirstVisit() + " = '" + item.getVisitFirstVisit() + "', "
                    + bpvF.getFVisitHn() + " = " + item.getVisitHn() + ", "
                    + bpvF.getFVisitHospitalService() + " = " + item.getVisitHospitalService() + ", "
                    + bpvF.getFVisitNotice() + " = " + item.getVisitNotice() + ", "
                    + bpvF.getFVisitPatientAge() + " = " + item.getVisitPatientAge() + ", "
                    + bpvF.getFVisitPatientSelfDoctor() + " = " + item.getVisitPatientSelfDoctor() + ", "
                    + bpvF.getFVisitVn() + " = " + item.getVisitVn() + ", "
                    + bpvF.getFVisitClaimNamet() + " = " + item.getVisitClaimNamet() + ", "
                    + bpvF.getFVisitPaidNamet() + " = " + item.getVisitPaidNamet() + ", "
                    + bpvF.getFDepartmentNamet() + " = " + item.getDepartmentNamet() + ", "
                    + bpvF.getFDoctorNamet() + " = " + item.getDoctorNamet() + ", "
                    + bpvF.getFBranchId() + " = " + item.getBranchId() + ", "
                    + bpvF.getFSysStatus() + " = " + item.getSysStatus() + ", "
                    + bpvF.getFPatientVisitId() + " = " + item.getPatientVisitId() + ", "
                    + bpvF.getFVisitContactId() + " = " + item.getVisitContactId() + ", "
                    + bpvF.getFVisitContactNamet() + " = " + item.getVisitContactNamet() + ", "
                    + bpvF.getFPatientVisitFundsActive() + " = " + item.getPatientVisitFundsActive() + ", "
                    + bpvF.getFVisitTotal() + " = " + item.getVisitTotal() + ", "
                    + bpvF.getFVisitDiscount() + " = " + item.getVisitDiscount() + ", "
                    + bpvF.getFVisitPaid() + " = " + item.getVisitPaid() + ", "
                    + bpvF.getFStatusBilling() + " = " + item.getStatusBilling() + ", "
                    + bpvF.getFInjuryNumber() + " = " + item.getInjuryNumber() + ", "
                    + bpvF.getFRecordStatus() + " = '" + item.getRecordStatus() + "', "
                    + bpvF.getFCloseDayDate() + " = '" + item.getCloseDayDate() + "', "
                    + bpvF.getFBillingInvoiceNumber() + " = '" + item.getBillingInvoiceNumber() + "', "
                    + bpvF.getFReceiveAmount() + " = " + item.getReceiveAmount() + ", "
                    + bpvF.getFPatientVisitFundsBillingId() + " = '" + item.getPatientVisitFundsBillingId() + "' "
                    + "Where " + bpvF.getFPatientVisitFundsId() + " = '" + item.getPatientVisitFundsId() + "'";

            max = item.getPatientVisitId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String setSaveBackTPatientVisitFundsItem(BackTPatientVisitFundsItem item) throws Exception {
        int chk = 0;
        String sql = ""; String max = "";
        try{
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            bpv_fi = getBackTPatientVisitFundsItemByPK(st,item.getBranchId(),item.getPatientVisitFundsItemId(),"");
            item.setClaimNamet(item.getClaimNamet().replace("'", "''"));
            item.setDepartmentNamet(item.getDepartmentNamet().replace("'", "''"));
            item.setTBillingInvoiceItemNamet(item.getTBillingInvoiceItemNamet().replace("'", "''"));
            item.doctorNamet = item.doctorNamet.replace("'", "''");
            if (bpv_fi.getPatientVisitFundsItemId().equals("")) {
                item.generateOID(idtableItem);
                max = item.getObjectId();
//                max = getMaxRowBackTPatientVisitFundsItem(conn);
                sql = "Insert Into " + bpv_fi.getBackTPatientVisitFundsItem()
                    +"(" + bpv_fi.getFPatientVisitFundsItemId() + ", " + bpv_fi.getFBItemBillingSubgroupId() + ", "
                    +bpv_fi.getFBItemId() + "," + bpv_fi.getFBillingInvoiceItemActive() + ","
                    +bpv_fi.getFBillingInvoiceItemTotal() + "," + bpv_fi.getFBillingInvoiceNumber() + ","
                    +bpv_fi.getFClaimId() + "," + bpv_fi.getFClaimNamet() + ","
                    +bpv_fi.getFDepartmentId() + "," + bpv_fi.getFDepartmentNamet() + ","
                    +bpv_fi.getFPatientVisitId() + "," + bpv_fi.getFTBillingId() + ","
                    +bpv_fi.getFPatientVisitItemId() + "," + bpv_fi.getFTBillingInvoiceDateTime() + ","
                    +bpv_fi.getFTBillingInvoiceItemId() + "," + bpv_fi.getFTBillingInvoiceItemNamet() + ", "
                    +bpv_fi.getFTBillingInvoiceTime() + "," + bpv_fi.getFTOrderItemId() + ", "
                    +bpv_fi.getFTPatientId() + "," + bpv_fi.getFTPaymentId() + ","
                    +bpv_fi.getFVisitHn() + "," + bpv_fi.getFVisitId() + ","
                    +bpv_fi.getFVisitPatientSeftDoctor() + "," + bpv_fi.getFVisitVn() + ","
                    +bpv_fi.getFBranchId() + "," + bpv_fi.getFSysStatus() + ","
                    +bpv_fi.getFItemDiscount() + "," + bpv_fi.getFItemPaid() + ","
                    +bpv_fi.getFItemTotal() + "," + bpv_fi.getFItemNametEditStatus() + ","
                    +bpv_fi.getFPatientVisitFundsId() + "," + bpv_fi.getFItemTotalOrginal() + ","
                    +bpv_fi.getFFItemGroupId() + ","+bpv_fi.getFInjuryNumber()+","
                    + bpv_fi.getFItemNametEdit()+","+bpv_fi.getFItemTotalEdit()+","
                    + bpv_fi.getFItemTotalEditStatus()+","+bpv_fi.getFDoctorId()+","
                    + bpv_fi.getFDoctorNamet()+","+bpv_fi.getFOrderHome()+ ") "
                    +"Values('" + max + "','" + item.getBItemBillingSubgroupId() + "','"
                    +item.getBItemId() + "','" + item.getBillingInvoiceItemActive() + "','"
                    +item.getBillingInvoiceItemTotal() + "','" + item.getBillingInvoiceNumber() + "','"
                    +item.getClaimId() + "','" + item.getClaimNamet() + "','"
                    +item.getDepartmentId() + "','" + item.getDepartmentNamet() + "','"
                    +item.getPatientVisitId() + "','" + item.getTBillingId() + "','"
                    +item.getPatientVisitItemId() + "','" + item.getTBillingInvoiceDateTime() + "','"
                    +item.getTBillingInvoiceItemId() + "','" + item.getTBillingInvoiceItemNamet() + "','"
                    +item.getTBillingInvoiceTime() + "','" + item.getTOrderItemId() + "','"
                    +item.getTPatientId() + "','" + item.getVisitId() + "','"
                    +item.getVisitHn() + "','" + item.getDepartmentNamet() + "','"
                    +item.getVisitPatientSelfDoctor() + "','" + item.getVisitVn() + "','"
                    +item.getBranchId() + "','" + item.getSysStatus() + "',"
                    +item.getItemDiscount() + "," + item.getItemPaid() + ","
                    +item.getItemTotal() + ",'" + item.getItemNametEditStatus() + "','"
                    +item.getPatientVisitFundsId() + "'," + item.getItemTotalOrginal() + ",'"
                    +item.getFItemGroupId() + "','"+item.getInjuryNumber()+"','"
                    +item.getItemNametEdit()+"','"+item.getItemTotalEdit()+"','"
                    +item.getItemTotalEditStatus()+"','"+item.doctorId+"','"
                    +item.doctorNamet+"','"+item.orderHome+"')";
                }else{
                sql = "Update " + bpv_fi.getBackTPatientVisitFundsItem()
                    +" set " + bpv_fi.getFBItemBillingSubgroupId() + " = '" + item.getBItemBillingSubgroupId() + "', "
                    +bpv_fi.getFBItemId() + " = '" + item.getBItemId() + "', "
                    +bpv_fi.getFBillingInvoiceItemActive() + " = '" + item.getBillingInvoiceItemActive() + "', "
                    +bpv_fi.getFBillingInvoiceItemTotal() + " = '" + item.getBillingInvoiceItemTotal() + "', "
                    +bpv_fi.getFBillingInvoiceNumber() + " = '" + item.getBillingInvoiceNumber() + "', "
                    +bpv_fi.getFClaimId() + " = '" + item.getClaimId() + "', "
                    +bpv_fi.getFClaimNamet() + " = '" + item.getClaimNamet() + "', "
                    +bpv_fi.getFDepartmentId() + " = '" + item.getDepartmentId() + "', "
                    +bpv_fi.getFDepartmentNamet() + " = '" + item.getDepartmentNamet() + "', "
                    +bpv_fi.getFPatientVisitId() + " = '" + item.getPatientVisitId() + "',"
                    +bpv_fi.getFTBillingId() + " = '" + item.getTBillingId() + "',"
                    +bpv_fi.getFTBillingInvoiceDateTime() + " = " + item.getTBillingInvoiceDateTime() + ", "
                    +bpv_fi.getFTBillingInvoiceItemId() + " = " + item.getTBillingInvoiceItemId() + ", "
                    +bpv_fi.getFTBillingInvoiceItemNamet() + " = " + item.getTBillingInvoiceItemNamet() + ", "
                    +bpv_fi.getFTBillingInvoiceTime() + " = " + item.getTBillingInvoiceTime() + ", "
                    +bpv_fi.getFTOrderItemId() + " = " + item.getTOrderItemId() + ", "
                    +bpv_fi.getFTPatientId() + " = " + item.getTPatientId() + ", "
                    +bpv_fi.getFVisitId() + " = " + item.getVisitId() + ", "
                    +bpv_fi.getFVisitHn() + " = " + item.getVisitHn() + ", "
                    +bpv_fi.getFDepartmentNamet() + " = " + item.getDepartmentNamet() + ", "
                    +bpv_fi.getFVisitPatientSeftDoctor() + " = " + item.getVisitPatientSelfDoctor() + ", "
                    +bpv_fi.getFVisitVn() + " = " + item.getVisitVn() + ", "
                    +bpv_fi.getFBranchId() + " = " + item.getBranchId() + ", "
                    +bpv_fi.getFSysStatus() + " = " + item.getSysStatus() + ", "
                    +bpv_fi.getFItemDiscount() + " = " + item.getItemDiscount() + ", "
                    +bpv_fi.getFItemPaid() + " = " + item.getItemPaid() + ", "
                    +bpv_fi.getFItemTotal() + " = " + item.getItemTotal() + ", "
                    +bpv_fi.getFItemNametEditStatus() + " = " + item.getItemNametEditStatus() + ", "
                    +bpv_fi.getFPatientVisitFundsId() + " = " + item.getFPatientVisitFundsId() + ", "
                    +bpv_fi.getFFItemGroupId() + " = " + item.getFItemGroupId() + " "
                    +"Where " + bpv_fi.getFPatientVisitFundsItemId() + " = '" + item.getFPatientVisitFundsItemId() + "'";

                max = item.getPatientVisitId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
          max = ex.getMessage();
        }
        return max;
    }
  
//  public BackTPatientVisitFundsItem setCastPatientVisitFundsItem(BackTPatientVisitItem bpvi) {
//    bpv_fi = new BackTPatientVisitFundsItem();
//    bpv_fi.setBItemBillingSubgroupId(bpvi.getBItemBillingSubgroupId());
//    bpv_fi.setBItemId(bpvi.getBItemId());
//    bpv_fi.setBillingInvoiceItemActive(bpvi.getBillingInvoiceItemActive());
//    bpv_fi.setBillingInvoiceItemTotal(bpvi.getBillingInvoiceItemTotal());
//    bpv_fi.setBillingInvoiceNumber(bpvi.getBillingInvoiceNumber());
//
//    bpv_fi.setClaimId(bpvi.getClaimId());
//    bpv_fi.setClaimNamet(bpvi.getClaimNamet());
//    bpv_fi.setDepartmentNamet(bpvi.getDepartmentNamet());
//    bpv_fi.setPatientVisitFundsItemId("");
//    bpv_fi.setPatientVisitId(bpvi.getPatientVisitId());
//
//    bpv_fi.setTBillingId(bpvi.getTBillingId());
//    bpv_fi.setTBillingInvoiceDateTime(bpvi.getTBillingInvoiceDateTime());
//    bpv_fi.setTBillingInvoiceItemId(bpvi.getTBillingInvoiceItemId());
//    bpv_fi.setTBillingInvoiceItemNamet(bpvi.getTBillingInvoiceItemNamet());
//    bpv_fi.setTBillingInvoiceTime(bpvi.getTBillingInvoiceTime());
//
//    bpv_fi.setTOrderItemId(bpvi.getTOrderItemId());
//    bpv_fi.setTPatientId(bpvi.getTPatientId());
//    bpv_fi.setTPaymentId(bpvi.getTPaymentId());
//    bpv_fi.setVisitId(bpvi.getVisitId());
//    bpv_fi.setVisitPatientSelfDoctor(bpvi.getVisitPatientSelfDoctor());
//
//    bpv_fi.setVisitVn(bpvi.getVisitVn());
//    bpv_fi.setDepartmentId(bpvi.getDepartmentId());
//    bpv_fi.setVisitHn(bpvi.getVisitHn());
//    bpv_fi.setBranchId(config1.StringNull(bpvi.getBranchId()));
//    bpv_fi.setSysStatus(config1.StringNull(bpvi.getSysStatus()));
//
//    bpv_fi.setItemDiscount(bpvi.getItemDiscount());
//    bpv_fi.setItemPaid(bpvi.getItemPaid());
//    bpv_fi.setItemTotal(bpvi.getItemTotal());
//    bpv_fi.setItemNametEditStatus(config1.StringNull(bpvi.getEditStatus()));
//    bpv_fi.setRecordStatus("0");
//
//    bpv_fi.setPatientVisitItemId(config1.StringNull(bpvi.getPatientVisitBillingItemId()));
//    bpv_fi.setItemTotalOrginal(bpvi.getItemTotal());
//    bpv_fi.setFItemGroupId(config1.StringNull(bpvi.getFItemGroupId()));
//    return bpv_fi;
//  }
//  public BackTPatientVisitFunds setCastPatientVisitFunds(BackTPatientVisit bpv) {
//    bpv_f = new BackTPatientVisitFunds();
//    bpv_f.setBServicePointId(bpv.getBServicePointId());
//    bpv_f.setBVisitClinicId(bpv.getBVisitClinicId());
//    bpv_f.setBranchId(bpv.getBranchId());
//    bpv_f.setDepartmentNamet(bpv.getDepartmentNamet());
//    bpv_f.setDoctorNamet(bpv.getDoctorNamet());
//
//    bpv_f.setPatientFullnamet(bpv.getPatientFullnamet());
//    bpv_f.setPatientImportId(bpv.getPatientImportId());
//    bpv_f.setPatientVisitId(bpv.getPatientVisitId());
//    bpv_f.setSysStatus(bpv.getSysStatus());
//    bpv_f.setTPatientId(bpv.getTPatientId());
//
//    bpv_f.setVisitBeginVisitTime(bpv.getVisitBeginVisitTime());
//    bpv_f.setVisitClaimId(bpv.getVisitClaimId());
//    bpv_f.setVisitClaimNamet(bpv.getVisitClaimNamet());
//    bpv_f.setVisitContactId(bpv.getVisitContactId());
//    bpv_f.setVisitDate(bpv.getVisitDate());
//
//    bpv_f.setVisitDiagnosisNotice(bpv.getVisitDiagnosisNotice());
//    bpv_f.setVisitDiscount(bpv.getVisitDiscount());
//    bpv_f.setVisitFinancialDischargeTime(bpv.getVisitFinancialDischargeTime());
//    bpv_f.setVisitFirstVisit(bpv.getVisitFirstVisit());
//    bpv_f.setVisitHn(bpv.getVisitHn());
//
//    bpv_f.setVisitHospitalService(bpv.getVisitHospitalService());
//    bpv_f.setVisitNotice(bpv.getVisitNotice());
//    bpv_f.setVisitPaid(bpv.getVisitPaid());
//    bpv_f.setVisitPaidId(bpv.getVisitPaidId());
//    bpv_f.setVisitPaidNamet(bpv.getVisitPaidNamet());
//
//    bpv_f.setVisitPatientAge(bpv.getVisitPatientAge());
//    bpv_f.setVisitPatientSelfDoctor(bpv.getVisitPatientSelfDoctor());
//    bpv_f.setVisitTotal(bpv.getVisitTotal());
//    bpv_f.setVisitVn(bpv.getVisitVn());
//    bpv_f.setVisitContactNamet(bpv.getVisitContactNamet());
//
//    bpv_f.setPatientVisitFundsId("");
//    bpv_f.setVisitContactJoinId(bpv.getVisitContactJoinId());
//    bpv_f.setVisitContactJoinNamet(bpv.getVisitContactJoinNamet());
//    bpv_f.setCloseDayDate(bpv.getCloseDayDate());
//    bpv_f.setBillingInvoiceNumber("");
//    return bpv_f;
//  }
//  public BackTPatientVisitFunds setCastPatientVisitFunds(BackTPatientVisitFundsBilling bpv_fb) {
//    bpv_f = new BackTPatientVisitFunds();
//    bpv_f.setBServicePointId(bpv_fb.getBServicePointId());
//    bpv_f.setBVisitClinicId(bpv_fb.getBVisitClinicId());
//    bpv_f.setBranchId(bpv_fb.getBranchId());
//    bpv_f.setDepartmentNamet(bpv_fb.getDepartmentNamet());
//    bpv_f.setDoctorNamet(bpv_fb.getDoctorNamet());
//
//    bpv_f.setPatientFullnamet(bpv_fb.getPatientFullnamet());
//    bpv_f.setPatientImportId(bpv_fb.getPatientImportId());
//    bpv_f.setPatientVisitId(bpv_fb.getPatientVisitId());
//    bpv_f.setSysStatus(bpv_fb.getSysStatus());
//    bpv_f.setTPatientId(bpv_fb.getTPatientId());
//
//    bpv_f.setVisitBeginVisitTime(bpv_fb.getVisitBeginVisitTime());
//    bpv_f.setVisitClaimId(bpv_fb.getVisitClaimId());
//    bpv_f.setVisitClaimNamet(bpv_fb.getVisitClaimNamet());
//    bpv_f.setVisitContactId(bpv_fb.getVisitContactId());
//    bpv_f.setVisitDate(bpv_fb.getVisitDate());
//
//    bpv_f.setVisitDiagnosisNotice(bpv_fb.getVisitDiagnosisNotice());
//    bpv_f.setVisitDiscount(bpv_fb.getVisitDiscount());
//    bpv_f.setVisitFinancialDischargeTime(bpv_fb.getVisitFinancialDischargeTime());
//    bpv_f.setVisitFirstVisit(bpv_fb.getVisitFirstVisit());
//    bpv_f.setVisitHn(bpv_fb.getVisitHn());
//
//    bpv_f.setVisitHospitalService(bpv_fb.getVisitHospitalService());
//    bpv_f.setVisitNotice(bpv_fb.getVisitNotice());
//    bpv_f.setVisitPaid(bpv_fb.getVisitPaid());
//    bpv_f.setVisitPaidId(bpv_fb.getVisitPaidId());
//    bpv_f.setVisitPaidNamet(bpv_fb.getVisitPaidNamet());
//
//    bpv_f.setVisitPatientAge(bpv_fb.getVisitPatientAge());
//    bpv_f.setVisitPatientSelfDoctor(bpv_fb.getVisitPatientSelfDoctor());
//    bpv_f.setVisitTotal(bpv_fb.getVisitTotal());
//    bpv_f.setVisitVn(bpv_fb.getVisitVn());
//    bpv_f.setVisitContactNamet(bpv_fb.getVisitContactNamet());
//
//    bpv_f.setPatientVisitFundsId("");
//
//    return bpv_f;
//  }
    
//    public Integer setReceiveFunds(String branch_id, String patient_import_id, String sub_system_id, String flag) {
//        String sql = ""; String patient_visit_contact_id = ""; String patient_visit_funds_id = ""; String patient_visit_doctor_id = "";
//        Integer cnt = Integer.valueOf(0);
//        Vector v_patient_visit = new Vector();
//        Vector v_patient_visit_item = new Vector();
//        try {
//          v_patient_visit = bpvdb.getBackTPatientVisit(branch_id, patient_import_id, sub_system_id, flag);
//          for (int i = 0; i <= v_patient_visit.size() - 1; i++)
//            try {
//              bpvdb.bpv = new BackTPatientVisit();
//              bpvdb.bpv = (BackTPatientVisit)v_patient_visit.get(i);
//              if (bpvdb.bpv.getVisitHn().equals("535003844"))
//                sql = "";
////                bpv_f.initial();
//                bpv_f = setCastPatientVisitFunds(bpvdb.bpv);
//                bpv_f.setPatientVisitFundsActive("1");
//                bpv_f.setStatusBilling("0");
//                bpv_f.setInjuryNumber("-");
//                patient_visit_funds_id = setSaveBackTPatientVisitFunds(branch_id, bpv_f);
//                cnt++;
//                v_patient_visit_item = new Vector();
//                v_patient_visit_item = bpvdb.getBackTPatientVisitItem(bpvdb.bpv.getPatientVisitId(), "", "", "", "subsystem_import");
//                for (int j = 0; j <= v_patient_visit_item.size() - 1; j++) {
//                  bpvdb.bpvi = new BackTPatientVisitItem();
//                  bpv_fi = new BackTPatientVisitFundsItem();
//                  bpvdb.bpvi = (BackTPatientVisitItem)v_patient_visit_item.get(j);
//                  bpv_fi = setCastPatientVisitFundsItem(bpvdb.bpvi);
//                  bpv_fi.setPatientVisitFundsId(patient_visit_funds_id);
//                  setSaveBackTPatientVisitFundsItem(bpv_fi);
//                }
//            } catch (Exception ex) {
//              Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }catch (Exception ex) {
//          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return cnt;
//    }
    public void setUpdatePatientVisitFundsItemEditClear(String branch_id, String patient_visit_funds_id) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpv_fi.getBackTPatientVisitFundsItem()
                  + " Set " + bpv_fi.getFItemNametEdit() + "='', " + bpv_fi.getFItemNametEditStatus() + "='', "
                  + bpv_fi.getFItemTotalEditStatus() + "='', " + bpv_fi.getFItemTotalEdit() + "=0.0 "
                  + "Where " + bpv_fi.getFPatientVisitFundsId() + "='" + patient_visit_funds_id + "'";

          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitFundsItemCancel(String branch_id, String bpv_f_id, String patient_visit_funds_item_id) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpv_fi.getBackTPatientVisitFundsItem() 
                  + " Set " + bpv_fi.getFBillingInvoiceItemActive() + "='3' "
                  + "Where " + bpv_fi.getFPatientVisitFundsItemId() + "='" + patient_visit_funds_item_id + "'";
          st.executeUpdate(sql);
          setUpdatePatientVisitFundsTotal(st, branch_id, bpv_f_id);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitFunds(String branch_id, String patient_visit_funds_id, String patient_fullnamet,
            String visit_vn, String visit_hn, String visit_date, String claim_id, String paid_id, String visit_notive,
            String claim_name, String paid_name, String injury_number, String visit_contact_id, String visit_contact_namet,
            String visit_contact_join_id, String visit_contact_join_namet){
        String sql = "";
        try {
            patient_fullnamet = patient_fullnamet.replace("'", "''");
            claim_name = claim_name.replace("'", "''");
            paid_name = paid_name.replace("'", "''");

            visit_notive = visit_notive.replace("'", "''");
            visit_contact_namet = visit_contact_namet.replace("'", "''");
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpvF.getBackTPatientVisitFunds()
              + " Set " + bpvF.getFPatientFullnamet() + "='" + patient_fullnamet + "',"
              + bpvF.getFVisitHn() + "='" + visit_hn + "'," + bpvF.getFVisitVn() + "='" + visit_vn + "',"
              + bpvF.getFVisitDate() + "='" + visit_date + "'," + bpvF.getFVisitClaimId() + "='" + claim_id + "',"
              + bpvF.getFVisitPaidId() + "='" + paid_id + "', " + bpvF.getFVisitNotice() + "='" + visit_notive + "', "
              + bpvF.getFVisitClaimNamet() + "='" + claim_name + "', " + bpvF.getFVisitPaidNamet() + "='" + paid_name + "', "
              + bpvF.getFInjuryNumber() + "='" + injury_number + "', "
              +bpvF.getFVisitContactId()+"='"+visit_contact_id+"', "
              + bpvF.getFVisitContactNamet() + "='" + visit_contact_namet + "', "
              + bpvF.getFVisitContactJoinId() + "='" + visit_contact_join_id + "', "
              + bpvF.getFVisitContactJoinNamet() + "='" + visit_contact_join_namet + "' "
              + "Where " + bpvF.getFPatientVisitFundsId() + "='" + patient_visit_funds_id + "'";

            st.executeUpdate(sql);
            t_injurydb.setInjuryNumber(st,branch_id, visit_hn, visit_date, injury_number);
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setUpdatePatientVisitFundsVoid(String branch_id, String patient_visit_funds_id) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvF.getBackTPatientVisitFunds()
                  + " Set " + bpvF.getFPatientVisitFundsActive() + "='3' "
                  + "Where " + bpvF.getFPatientVisitFundsId() + "='" + patient_visit_funds_id + "'";

          st.executeUpdate(sql);
          sql = "Update " + bpv_fi.getBackTPatientVisitFundsItem()
                  + " Set " + bpv_fi.getFBillingInvoiceItemActive() + "='3' "
                  + "Where " + bpv_fi.getFPatientVisitFundsId() + "='" + patient_visit_funds_id + "'";

          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitFundsRecordStatus(String branch_id, String patient_visit_funds_id) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvF.getBackTPatientVisitFunds()
                  + " Set " + bpvF.getFRecordStatus() + "='1' "
                  + "Where " + bpvF.getFPatientVisitFundsId() + "='" + patient_visit_funds_id + "'";

          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String setUpdatePatientVisitFundsStatusPayment(String branch_id, String bpv_f_id,
            String billing_payment_id, String status_payment, Double receive_amount, String receive_date) {
        String sql = "", chk="";
        Integer row=0;
        //Step ในการ Update
        //1. update receive_amount
        //2. Check ว่ายอดเงิน >= visitTotal
        //3. ถ้า ยอดเงิน >= visitTotal จริง ให้ update status_payment ให้เป็น '4'
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvF.getBackTPatientVisitFunds()//step 1
                  + " Set " + bpvF.getFBillingPaymentItemId() + "='"+billing_payment_id+"',"
//                  +bpv_f.getFStatusBilling()+"='"+status_payment+"', "
                  +bpvF.getFReceiveAmount()+"="+bpvF.getFReceiveAmount()+"+"+receive_amount+", "
                  +bpvF.getFReceiveDate()+"='"+receive_date+"' "
                  + "Where " + bpvF.getFPatientVisitFundsId() + "='" + bpv_f_id + "'";
          row = st.executeUpdate(sql);
          bpvF = getBackTPatientVisitFundsByPK(branch_id, bpv_f_id, "");//step 2
          if(bpvF.getVisitTotal() <= bpvF.getReceiveAmount()){// step3  ต้อง check เพราะจะมี method void จะเข้าใข้ methoed นี้เหมือนกัน
              sql="Update "+bpvF.getBackTPatientVisitFunds()+" Set "+bpvF.getFStatusBilling()+"='"+status_payment+"' "
                      + "Where "+bpvF.getFPatientVisitFundsId()+"='"+bpv_f_id+"'";
              row = st.executeUpdate(sql);
              Vector v = new Vector();
              v = getBackTPatientVisitFunds(branch_id, bpvF.getBillingInvoiceNumber(),status_payment, "billing_number_status_billing_complete");//ดึงตาม billing แล้ว check ว่ารับชำระหมดแล้วหรือไม่
              if(v.isEmpty()){
                  chk="4";
              }else{
                  chk="2";
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
        return chk;
    }
    public String setUpdatePatientVisitFundsStatusPaymentVoid(String branch_id, String bpv_f_id,
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
          sql = "Update " + bpvF.getBackTPatientVisitFunds()//step 1
                  + " Set " + bpvF.getFBillingPaymentItemId() + "='"+billing_payment_id+"',"
//                  +bpv_f.getFStatusBilling()+"='"+status_payment+"', "
                  +bpvF.getFReceiveAmount()+"="+bpvF.getFReceiveAmount()+"-"+VoidAmount+", "
//                  +bpvF.getFVoidDate()+"='"+VoidDate+"' "
                  +bpvF.getFVoidPaymentDate()+"='"+VoidDate+"' "
                  + "Where " + bpvF.getFPatientVisitFundsId() + "='" + bpv_f_id + "'";
          chk = st.executeUpdate(sql);
          bpvF = getBackTPatientVisitFundsByPK(branch_id, bpv_f_id, "");//step 2
//          if(bpvF.visitTotal <= bpvF.receiveAmount){// step3  ต้อง check เพราะจะมี method void จะเข้าใข้ methoed นี้เหมือนกัน
          if(bpvF.visitTotal >= bpvF.receiveAmount){// step3  ต้อง check เพราะจะมี method void จะเข้าใข้ methoed นี้เหมือนกัน
              sql="Update "+bpvF.getBackTPatientVisitFunds()+" Set "+bpvF.getFStatusBilling()+"='2' "
                      + "Where "+bpvF.getFPatientVisitFundsId()+"='"+bpv_f_id+"'";
              chk = st.executeUpdate(sql);
              Vector v = new Vector();
              v = getBackTPatientVisitFunds(branch_id, bpvF.getBillingInvoiceNumber(),"2", "billing_number_status_billing_complete");//ดึงตาม billing แล้ว check ว่ารับชำระหมดแล้วหรือไม่
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
    public void setUpdatePatientVisitFundsItemNametEdit(String branch_id, String patient_visit_funds_item_id, String item_namet) {
        String sql = "";
        try {
          item_namet = item_namet.replace("'", "''");
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpv_fi.getBackTPatientVisitFundsItem()
                  + " Set " + bpv_fi.getFTBillingInvoiceItemNamet() + "='" + item_namet + "', "
                  + bpv_fi.getFItemNametEditStatus() + "='1', " + bpv_fi.getFRecordStatus() + "='1' "
                  + "Where " + bpv_fi.getFPatientVisitFundsItemId() + "='" + patient_visit_funds_item_id + "'";

          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitFundsItemEditCommit(String branch_id, String patient_visit_funds_id) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpv_fi.getBackTPatientVisitFundsItem() 
                  + " Set " + bpv_fi.getFTBillingInvoiceItemNamet() + "=" + bpv_fi.getFItemNametEdit() + ", "
                  + bpv_fi.getFItemNametEditStatus() + "='2' "
                  + "Where " + bpv_fi.getFPatientVisitFundsId() + "='" + patient_visit_funds_id + "' and "
                  + bpv_fi.getFItemNametEditStatus() + "='1'";

          st.executeUpdate(sql);
          sql = "Update " + bpv_fi.getBackTPatientVisitFundsItem() 
                  + " Set " + bpv_fi.getFItemTotal() + "=" + bpv_fi.getFItemTotalEdit() + ", "
                  + bpv_fi.getFItemTotalEditStatus() + "='2' "
                  + "Where " + bpv_fi.getFPatientVisitFundsId() + "='" + patient_visit_funds_id + "' and "
                  + bpv_fi.getFItemTotalEditStatus() + "='1'";

          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String setUpdatePatientVisitFundsInjuryNumber(String branchId, String bpvFId, String injuryNumber) {
        String sql = "";
        Integer chk=0;
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpvF.getBackTPatientVisitFunds()
                  + " Set " + bpvF.getFInjuryNumber() + "='"+injuryNumber+"' "
                  + "Where " + bpvF.getFPatientVisitFundsId() + "='" + bpvFId + "'";

          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public void setUpdatePatientVisitFundsTotal(String branch_id, String bpv_f_id) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
//          bpv_fi = getBackTPatientVisitFundsItemByPK(st,branch_id, bpv_f_id, "sum_item");
//          sql = "Update " + bpv_f.getBackTPatientVisitFunds()
//                  + " Set " + bpv_f.getFVisitTotal() + "=" + bpv_fi.getItemTotal() + ", "
//                  + bpv_f.getFVisitPaid() + "="+bpv_fi.getItemPaid()+", "
//                  + bpv_f.getFVisitDiscount() + "="+bpv_fi.getItemDiscount()+" "
//                  + "Where " + bpv_f.getFPatientVisitFundsId() + "='" + bpv_f_id + "' and "+bpv_f.getFBranchId()+"='"+branch_id+"' ";
//          st.executeUpdate(sql);
          setUpdatePatientVisitFundsTotal(st, branch_id, bpv_f_id);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitFundsTotal(Statement st,String branch_id, String bpv_f_id) {
        String sql = "";
        try {
//          Connection conn = config1.getConnectionBangna();
//          Statement st = conn.createStatement();
          bpv_fi = getBackTPatientVisitFundsItemByPK(st,branch_id, bpv_f_id, "sum_item");
          sql = "Update " + bpvF.getBackTPatientVisitFunds()
                  + " Set " + bpvF.getFVisitTotal() + "=" + bpv_fi.getItemTotal() + ", "
                  + bpvF.getFVisitPaid() + "="+bpv_fi.getItemPaid()+", " 
                  + bpvF.getFVisitDiscount() + "="+bpv_fi.getItemDiscount()+" "
                  + "Where " + bpvF.getFPatientVisitFundsId() + "='" + bpv_f_id + "' and "+bpvF.getFBranchId()+"='"+branch_id+"' ";

          st.executeUpdate(sql);
//          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitFundsItemTotalEdit(String branch_id, String bpv_f_id, String bpv_fi_id, String item_price) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpv_fi.getBackTPatientVisitFundsItem()
                  + " Set " + bpv_fi.getFItemTotal() + "=" + item_price + ", "
                  + bpv_fi.getFItemTotalEditStatus() + "='1', " + bpv_fi.getFRecordStatus() + "='1' "
                  + "Where " + bpv_fi.getFPatientVisitFundsItemId() + "='" + bpv_fi_id + "'";

          st.executeUpdate(sql);
          setUpdatePatientVisitFundsTotal(st, branch_id, bpv_f_id);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public BackBTransfer getBTransferByPk(String branch_id, String b_transfer_id, String flag) {
        String sql = ""; String txt = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          if (flag.equals("paid_id2department_id")) {
            sql = "Select * From " + b_transfer.getBackBTransfer() + " " 
                    + "Where " + b_transfer.getFPaidId() + "='" + b_transfer_id + "' and "
                    + b_transfer.getFBranchId() + "='" + branch_id + "'";
          }else{
            sql = "Select * From " + b_transfer.getBackBTransfer();
          }

          ResultSet rs = st.executeQuery(sql);
          while (rs.next()) {
            b_transfer = new BackBTransfer();
            b_transfer.setBDepartmentId(rs.getString(b_transfer.getFBDepartmentId()));
            b_transfer.setBDepartmentId(rs.getString(b_transfer.getFBDepartmentId()));
            b_transfer.setBTransferId(rs.getString(b_transfer.getFBTransferId()));
            b_transfer.setBranchId(rs.getString(b_transfer.getFBranchId()));
            b_transfer.setPaidId(rs.getString(b_transfer.getFPaidId()));

            b_transfer.setPaidNamet(rs.getString(b_transfer.getFPaidNamet()));
            b_transfer.setTransferActive(rs.getString(b_transfer.getFTransferActive()));
          }
          rs.close();
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b_transfer;
    }
    public void setVoidPatientVisit(String branch_id, String patient_import_id, String sub_system){
        String sql = "";
        Integer row = Integer.valueOf(0);
        try{
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          if (sub_system.equals("contact")) {
        //        sql = "Update " + bpv_c.getBackTPatientVisitContact() + " Set " + bpv_c.getFPatientVisitContactActive() + "='3' " + "Where " + bpv_c.getFPatientImportId() + "='" + patient_import_id + "' and " + bpv_c.getFBranchId() + "='" + branch_id + "' ";

        //        row = Integer.valueOf(st.executeUpdate(sql));
        //        sql = "Update " + bp_i.getBackTPatientImport() + " Set " + bp_i.getFStatusContactReceive() + "='3' " + "Where " + bp_i.getFPatientImportId() + "='" + patient_import_id + "' and " + bp_i.getFBranchId() + "='" + branch_id + "' ";
        //
        //        row = Integer.valueOf(st.executeUpdate(sql));
          } else if (sub_system.equals("funds")) {
            sql = "Update " + bpvF.getBackTPatientVisitFunds()
                    + " Set " + bpvF.getFPatientVisitFundsActive() + "='3' "
                    + "Where " + bpvF.getFPatientImportId() + "='" + patient_import_id + "' and "
                    + bpvF.getFBranchId() + "='" + branch_id + "' ";

            row = Integer.valueOf(st.executeUpdate(sql));
            sql = "Update " + bpvdb.bpi.getBackTPatientImport()
                    + " Set " + bpvdb.bpi.getFStatusFundsReceive() + "='3' "
                    + "Where " + bpvdb.bpi.getFPatientImportId() + "='" + patient_import_id + "' and "
                    + bpvdb.bpi.getFBranchId() + "='" + branch_id + "' ";

            row = Integer.valueOf(st.executeUpdate(sql));
          } else if (!sub_system.equals("doctor"));
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getSumFundsItemInjuryNumber(Statement st, String injury_number, String flag){
        String total = "", sql="";
        if(flag.equals("injury_number")){
            sql = "Select sum(bpv_fi."+bpv_fi.getFItemTotal()+") as "+bpv_fi.getFItemTotal()+" "
                + "From "+bpv_fi.getBackTPatientVisitFundsItem()+" as bpv_fi "
                + "inner join "+bpvF.getBackTPatientVisitFunds()+" as bpv_f on bpv_f."+bpvF.getFPatientVisitFundsId()+" = bpv_fi."+bpv_fi.getFPatientVisitFundsId()+" "
                + "Where bpv_f."+bpv_fi.getFInjuryNumber()+" = '"+injury_number+"' and "
                + "bpv_fi."+bpv_fi.getFBillingInvoiceItemActive()+"='1' and "+bpvF.getFStatusBilling()+" <> '2' ";
        }else if(flag.equals("injury_number_prepare_billing")){
            sql = "Select sum(bpv_fi."+bpv_fi.getFItemTotal()+") as "+bpv_fi.getFItemTotal()+" "
                + "From "+bpv_fi.getBackTPatientVisitFundsItem()+" as bpv_fi "
                + "inner join "+bpvF.getBackTPatientVisitFunds()+" as bpv_f on bpv_f."+bpvF.getFPatientVisitFundsId()+" = bpv_fi."+bpv_fi.getFPatientVisitFundsId()+" "
                + "Where bpv_f."+bpv_fi.getFInjuryNumber()+" = '"+injury_number+"' and "
                + "bpv_fi."+bpv_fi.getFBillingInvoiceItemActive()+"='1' and "+bpvF.getFStatusBilling()+" = '0' and "
                + bpvF.getFPatientVisitFundsActive()+" = '1' ";
        }else if(flag.equals("billing_number")){
            sql = "Select sum(bpv_fi."+bpv_fi.getFItemTotal()+") as "+bpv_fi.getFItemTotal()+" "
                + "From "+bpv_fi.getBackTPatientVisitFundsItem()+" as bpv_fi "
                + "inner join "+bpvF.getBackTPatientVisitFunds()+" as bpv_f on bpv_f."+bpvF.getFPatientVisitFundsId()+" = bpv_fi."+bpv_fi.getFPatientVisitFundsId()+" "
                + "Where bpv_f."+bpvF.getFBillingInvoiceNumber()+" = '"+injury_number+"' and "
                + "bpv_fi."+bpv_fi.getFBillingInvoiceItemActive()+"='1' and "+bpvF.getFStatusBilling()+" = '2' ";
        }else if(flag.equals("funds_id_billinged")){
            sql = "Select sum(bpv_fi."+bpv_fi.getFItemTotal()+") as "+bpv_fi.getFItemTotal()+" "
                + "From "+bpv_fi.getBackTPatientVisitFundsItem()+" as bpv_fi "
                + "inner join "+bpvF.getBackTPatientVisitFunds()+" as bpv_f on bpv_f."+bpvF.getFPatientVisitFundsId()+" = bpv_fi."+bpv_fi.getFPatientVisitFundsId()+" "
                + "Where bpv_f."+bpv_fi.getFPatientVisitFundsId()+" = '"+injury_number+"' and "
                + "bpv_fi."+bpv_fi.getFBillingInvoiceItemActive()+"='1' and "+bpvF.getFStatusBilling()+" = '2' ";
        }else if(flag.equals("funds_id")){
            sql = "Select sum(bpv_fi."+bpv_fi.getFItemTotal()+") as "+bpv_fi.getFItemTotal()+" "
                + "From "+bpv_fi.getBackTPatientVisitFundsItem()+" as bpv_fi "
                + "inner join "+bpvF.getBackTPatientVisitFunds()+" as bpv_f on bpv_f."+bpvF.getFPatientVisitFundsId()+" = bpv_fi."+bpv_fi.getFPatientVisitFundsId()+" "
                + "Where bpv_f."+bpv_fi.getFPatientVisitFundsId()+" = '"+injury_number+"' and "
                + "bpv_fi."+bpv_fi.getFBillingInvoiceItemActive()+"='1' and "+bpvF.getFStatusBilling()+" <> '2' ";
        }
        ResultSet rs;
        try {
            rs = st.executeQuery(sql);
            while(rs.next()){
                if(rs.getString(bpv_fi.getFItemTotal()) != null){
                    total = rs.getString(bpv_fi.getFItemTotal());
                }else{
                    total = "0";
                }
                
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    public String getSumPatientVisitFundsItemTotalByItem(Statement st,String branchId, String bpvFId) {
        String sum = "";
        try {
          bpv_fi = getBackTPatientVisitFundsItemByPK(st,branchId, bpvFId, "sum_item");
          sum = config1.NumberFormat(bpv_fi.itemTotal);
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sum;
    }
    public String getInjuryNumberFromSurveillanceByVisitId(String branchId, String visitVn){
        String surId="", sql="", visitVn1="";
        
        sql = "Select distinct surveillance_case_id "
                + "From surveillance_t_case_detail svcd "
                + "Where svcd.visit_vn = '"+visitVn+"' and svcd.surveillance_case_detail_active = '1' ";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();

          ResultSet rs = st.executeQuery(sql);
          while (rs.next()) {
              surId = rs.getString("surveillance_case_id");
          }
          rs.close();
          sql = "Select visit_vn "
                  + "From surveillance_t_case_detail "
                  + "Where surveillance_case_id = '"+surId+"' and status_first_visit = '1' and surveillance_case_detail_active = '1' ";
          rs = st.executeQuery(sql);
          while (rs.next()) {
              visitVn1 = rs.getString("visit_vn");
          }
          rs.close();
          
          bpvF = getBackTPatientVisitFundsByPK(st, branchId, visitVn1,"visit_vn");
          
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bpvF.injuryNumber;
    }
    public String getInjuryNumberFromSurveillanceByVisitId1(String branchId, String visitVn){
        String firstVisitVn="", sql="", injuryNumber="", viistDate="", surveillanceId="";
        try {
            Connection conn = config1.getConnectionHospital(branchId);
            Statement st = conn.createStatement();
            sql="Select first_visit_vn,surveillance_id From t_visit_surveillance Where visit_vn = '"+visitVn+"' and surveillance_active = '1' ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                firstVisitVn = rs.getString("first_visit_vn");
                surveillanceId = rs.getString("surveillance_id");
            }
            rs.close();
            conn.close();

            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select injury_number,visit_date "
                    + "From back_t_patient_visit_funds "
                    + "Where visit_vn = '"+firstVisitVn+"' and patient_visit_funds_active = '1' ";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                injuryNumber = rs.getString("injury_number");
                viistDate = rs.getString("visit_date");
            }
            rs.close();
            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return firstVisitVn+"@"+injuryNumber+"@"+viistDate+"@"+surveillanceId;
    }
    public Vector getContactFunds(String branchId){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select * "+" "
                    +"From "+contact.getBContact()+" "
                    + "Where "+contact.getFContactActive()+"='1' and "
                    +contact.getFBranchId()+"='"+branchId+"' and "+contact.getFStatusFunds()+"='1' ";
            rs = st.executeQuery(sql);
            while(rs.next()){
                contact = new BContact();
                contact.contactNamet = rs.getString(contact.getFContactNamet());
                contact.contactId = rs.getString(contact.getFContactId());
                v_result.add(contact);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitFundsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
}