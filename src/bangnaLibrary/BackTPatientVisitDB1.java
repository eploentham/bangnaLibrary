/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * Update by Ekapop 55-02-21
 * Ticket Id : 
 * m1
 * Update by ekapop 55-03-09
 * Ticket Id : 
 * m2
 * Update By ekapop 55-03-16
 * m3
 */
package bangnaLibrary;

import com.bangna.object.BackTPatientVisitFunds;
import com.bangna.object.BackTPatientVisitContactItem;
import com.bangna.object.BackTPatientVisitContact;
import com.bangna.control.BangnaLogControl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BackTPatientVisitDB1 {
    public Config1 config1;
    private BackTPatientImport bp_i;
    public BackTPatientVisitDB bpvdb;
    public BackTPatientImportDB bpidb ;
    CashierTCloseDayDB closedaydb ;
//    private BangnaLogControl blc;
    private BackTPatientVisitContact bpv_c;
    private BackTPatientVisitFunds bpv_f;
    private BackTPatientVisitContactItem bpv_ci;

    private BackBTransfer b_transfer;
    private BServicePoint service_point;

    private StringBuilder txt = new StringBuilder();
    private StringBuilder sql = new StringBuilder();

  public BackTPatientVisitDB1(){
        config1 = new Config1();
        initConfig(config1);
    }
    public BackTPatientVisitDB1(Config1 cf){
        config1 = cf;
        initConfig(cf);
    }
    public void initConfig(Config1 cf){
        bp_i = new BackTPatientImport();
        bpvdb = new BackTPatientVisitDB(cf);
        bpidb = new BackTPatientImportDB(cf);
        closedaydb = new CashierTCloseDayDB(cf);
//        blc = new BangnaLogControl(cf);
        bpv_c = new BackTPatientVisitContact();
        bpv_f = new BackTPatientVisitFunds();
        bpv_ci = new BackTPatientVisitContactItem();
        b_transfer = new BackBTransfer();
        service_point = new BServicePoint();
    }
  public void setUpdatePatientVisitContactItemCancel(String branch_id, String patient_visit_contact_item_id) {
    String sql = "";
    try{
      Connection conn = bpvdb.config1.getConnectionBangna();
      Statement st = conn.createStatement();
      sql = "Update " + bpv_ci.getBackTPatientVisitContactItem() + " Set " + bpv_ci.getFBillingInvoiceItemActive() + "='3' " + "Where " + bpv_ci.getFPatientVisitContactItemId() + "='" + patient_visit_contact_item_id + "'";

      st.executeUpdate(sql);
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  

  public void setUpdatePatientVisitContactRecordStatus(String branch_id, String patient_visit_contact_id) {
    String sql = "";
    try{
      Connection conn = bpvdb.config1.getConnectionBangna();
      Statement st = conn.createStatement();
      sql = "Update " + bpv_c.getBackTPatientVisitContact() + " Set " + bpv_c.getFRecordStatus() + "='1' " + "Where " + bpv_c.getFPatientVisitContactId() + "='" + patient_visit_contact_id + "'";

      st.executeUpdate(sql);
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
           
  public String getTrPaientVisitContactBillingPayment(String branch_id, String contact_id, String status_billing){
    String sql = ""; String text = ""; String node_child = ""; String data_child = ""; String chk_box = ""; String node_item = ""; String data_item = "";

    Integer row = Integer.valueOf(100); Integer row_detail = Integer.valueOf(100);
    try {
      Connection conn = bpvdb.config1.getConnectionBangna();
      Statement st_detail = conn.createStatement();
      Statement st_item = conn.createStatement();
      sql = "Select bpvc." + bpv_c.getFPatientFullnamet() + ",bpvc." + bpv_c.getFVisitHn() + ",bpvc." + bpv_c.getFVisitVn() + ",bpvc." + bpv_c.getFVisitDate() + ",bpvc." + bpv_c.getFVisitBeginVisitTime() + ",bpvc." + bpv_c.getFVisitPaid() + ",bpvc." + bpv_c.getFPatientVisitContactId() + ", bpvc." + bpv_c.getFVisitPaidNamet() + ",bpvc." + bpv_c.getFVisitNotice() + ", bpvc." + bpv_c.getFVisitHospitalService() + ",bpvc." + bpv_c.getFDoctorNamet() + ", sum(" + bpv_ci.getFItemPaid() + ") as paid, " + " count(1) as cnt, bpvc." + bpv_c.getFPatientVisitContactId() + " " + "From " + bpv_c.getBackTPatientVisitContact() + " as bpvc " + "left join " + bpv_ci.getBackTPatientVisitContactItem() + " as bpvci " + "on bpvc." + bpv_c.getFPatientVisitContactId() + " = bpvci." + bpv_ci.getFPatientVisitContactId() + " " + "Where bpvc." + bpv_c.getFBranchId() + " = '" + branch_id + "' and bpvc." + bpv_c.getFStatusBilling() + "='" + status_billing + "' and bpvc." + bpv_c.getFVisitContactId() + "='" + contact_id + "' " + "Group By bpvc." + bpv_c.getFPatientFullnamet() + ",bpvc." + bpv_c.getFVisitHn() + ",bpvc." + bpv_c.getFVisitVn() + ",bpvc." + bpv_c.getFVisitDate() + ",bpvc." + bpv_c.getFVisitBeginVisitTime() + ",bpvc." + bpv_c.getFVisitPaid() + ",bpvc." + bpv_c.getFPatientVisitContactId() + ", bpvc." + bpv_c.getFVisitPaidNamet() + ",bpvc." + bpv_c.getFVisitNotice() + ", bpvc." + bpv_c.getFVisitHospitalService() + ",bpvc." + bpv_c.getFDoctorNamet() + ", bpvc." + bpv_c.getFPatientVisitContactId() + " " + "Order By bpvc." + bpv_c.getFVisitDate() + ", bpvc." + bpv_c.getFVisitBeginVisitTime();

      ResultSet rs_detail = st_detail.executeQuery(sql);
      Integer localInteger1;
      while (rs_detail.next()){
        node_child = row.toString() + row_detail.toString();
        data_child = "<a href='javascript:showDetail(" + rs_detail.getString(bpv_c.getFPatientVisitContactId()) + ")'>" + bpvdb.config1.DateFormatDB2Show(rs_detail.getString(bpv_c.getFVisitDate()), "ddMMyyyy") + " " + rs_detail.getString(bpv_c.getFPatientFullnamet()) + " " + rs_detail.getString(bpv_c.getFVisitHn()) + " " + rs_detail.getString(bpv_c.getFVisitVn()) + " " + rs_detail.getString(bpv_c.getFVisitPaidNamet()) + " " + rs_detail.getString(bpv_c.getFVisitNotice()) + " " + rs_detail.getString(bpv_c.getFVisitHospitalService()) + " " + rs_detail.getString(bpv_c.getFDoctorNamet()) + "</a>";

        chk_box = "";

        text = text + "<tr id ='tr_" + node_child + "'><td>" + chk_box + "<font color='blue'>" + data_child + "</font></td>" + "<td align='center'><font color='blue'>" + rs_detail.getString("cnt") + "[item]</font></td>" + "<td align='center'><font color='blue'>" + rs_detail.getString("paid") + "[บาท]</font>" + "<input type='hidden' id='row_" + node_child + "' name='row_" + node_child + "'value='" + rs_detail.getString("paid") + "'>" + "<input type='hidden' id='txt_" + node_child + "' name='txt_" + node_child + "'value='" + rs_detail.getString(bpv_c.getFPatientVisitContactId()) + "'></td></tr>";

        sql = "Select " + bpv_ci.getFBItemId() + "," + bpv_ci.getFTBillingInvoiceItemNamet() + "," + bpv_ci.getFItemPaid() + ", " + bpv_ci.getFPatientVisitContactItemId() + " " + "From " + bpv_ci.getBackTPatientVisitContactItem() + " " + "Where " + bpv_ci.getFBranchId() + " = '" + branch_id + "' and " + bpv_ci.getFPatientVisitContactId() + " = '" + rs_detail.getString(bpv_c.getFPatientVisitContactId()) + "' ";

        ResultSet rs_item = st_item.executeQuery(sql);
        while (rs_item.next()) {
          node_item = node_child + "-" + rs_item.getString(bpv_ci.getFPatientVisitContactItemId());
          data_item = rs_item.getString(bpv_ci.getFBItemId()) + " " + rs_item.getString(bpv_ci.getFTBillingInvoiceItemNamet()) + " ";

          text = text + "<tr id ='tr_" + node_item + "' class='child-of-tr_" + node_child + "' name = '" + node_child + "'><td><font color='red'>" + data_item + "</td>" + "<td></td><td align='center'><font color='red'>" + rs_item.getString(bpv_ci.getFItemPaid()) + "</font>" + "</td></font>" + "</tr>";
        }

        rs_item.close();
        localInteger1 = row_detail; Integer localInteger2 = row_detail = Integer.valueOf(row_detail.intValue() + 1);
      }
    }
    catch (Exception ex) {
    }
    return text;
  }
  
  public String getTrPatientVisitContactBillingEdit(String branch_id, String patient_visit_contact_id, String flagpage) {
    String sql = ""; String text = ""; String node_parent = ""; String node_child = ""; String data_child = ""; String data_item = ""; String node_item = "";
    String b_item_id = ""; String b_item_billing_sub_group_id = ""; String t_billing_invoice_item_namet = ""; String item_paid = "";
    Integer row = Integer.valueOf(0); Integer row_detail = Integer.valueOf(0);

    sql = "Select * From " + bpv_ci.getBackTPatientVisitContactItem() + " " + "Where " + bpv_ci.getFBillingInvoiceItemActive() + " = '1' and " + bpv_ci.getFPatientVisitContactId() + " = '" + patient_visit_contact_id + "' and " + bpv_ci.getFBranchId() + " = '" + branch_id + "' ";
    try {
      Connection conn = bpvdb.config1.getConnectionBangna();
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        b_item_id = rs.getString(bpv_ci.getFBItemId());
        b_item_billing_sub_group_id = rs.getString(bpv_ci.getFBItemBillingSubgroupId());
        t_billing_invoice_item_namet = rs.getString(bpv_ci.getFTBillingInvoiceItemNamet());
        item_paid = rs.getString(bpv_ci.getFItemPaid());
        text = text + "<tr><td>" + rs.getString(bpv_ci.getFPatientVisitContactItemId()) + "</td>" + "<td><div class='edit_area' id='b_item_id'>" + b_item_id + "</div></td>" + "<td><div class='edit_area' id='b_item_billing_sub_group_id'>" + b_item_billing_sub_group_id + "</div></td>" + "<td><div class='edit_area' id='t_billing_invoice_item_namet'>" + t_billing_invoice_item_namet + "</div></td>" + "<td><div class='edit_area' id='item_paid'>" + item_paid + "</div></td>" + "</tr>";
      }

      rs.close();
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
      text = ex.getMessage();
    }
    return text;
  }
  public BackBTransfer getBTransferByPk(String branch_id, String b_transfer_id, String flag) {
    String sql = ""; String txt = "";
    try{
      Connection conn = bpvdb.config1.getConnectionBangna();
      Statement st = conn.createStatement();
      if (flag.equals("paid_id2department_id")) {
        sql = "Select * From " + b_transfer.getBackBTransfer() + " " + "Where " + b_transfer.getFPaidId() + "='" + b_transfer_id + "' and " + b_transfer.getFBranchId() + "='" + branch_id + "'";
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
      Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
    }
    return b_transfer;
  }

  public void setVoidPatientVisit(String branch_id, String patient_import_id, String sub_system){
    String sql = "";
    Integer row = Integer.valueOf(0);
    try{
      Connection conn = bpvdb.config1.getConnectionBangna();
      Statement st = conn.createStatement();
      if (sub_system.equals("contact")) {
        sql = "Update " + bpv_c.getBackTPatientVisitContact() + " Set " + bpv_c.getFPatientVisitContactActive() + "='3' " + "Where " + bpv_c.getFPatientImportId() + "='" + patient_import_id + "' and " + bpv_c.getFBranchId() + "='" + branch_id + "' ";

        row = Integer.valueOf(st.executeUpdate(sql));
        sql = "Update " + bp_i.getBackTPatientImport() + " Set " + bp_i.getFStatusContactReceive() + "='3' " + "Where " + bp_i.getFPatientImportId() + "='" + patient_import_id + "' and " + bp_i.getFBranchId() + "='" + branch_id + "' ";

        row = Integer.valueOf(st.executeUpdate(sql));
      } else if (sub_system.equals("funds")) {
        sql = "Update " + bpv_f.getBackTPatientVisitFunds() + " Set " + bpv_f.getFPatientVisitFundsActive() + "='3' " + "Where " + bpv_f.getFPatientImportId() + "='" + patient_import_id + "' and " + bpv_f.getFBranchId() + "='" + branch_id + "' ";

        row = Integer.valueOf(st.executeUpdate(sql));
        sql = "Update " + bp_i.getBackTPatientImport() + " Set " + bp_i.getFStatusFundsReceive() + "='3' " + "Where " + bp_i.getFPatientImportId() + "='" + patient_import_id + "' and " + bp_i.getFBranchId() + "='" + branch_id + "' ";

        row = Integer.valueOf(st.executeUpdate(sql));
      } else if (!sub_system.equals("doctor"));
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public Vector getPatientVisitBillingInvoice(Statement st, Statement st_order, BBranch branch, String visti_date_start, 
          String visit_date_end, String visit_hn, String billing_invoice_id, String flag) {
    Vector v_patient_visit = new Vector();
    String time = ""; String visit_date = ""; String description = ""; String vn = ""; String vn_seq = "", error="";
    try{
      sql.delete(0, sql.length());
      if (branch.getBranchProgram().equals("hospital_osv3")){
        if (flag.equals("hn")) {
//          sql.append("Select tv.visit_vn as mnc_vn_no, substring(tv.visit_financial_discharge_time,12) as MNC_FN_TIME, ")//m3-
//            .append("substring(tv.visit_financial_discharge_time,0,11) as MNC_FN_DAT, tv.visit_hn, tbii.b_item_id, ")
//            .append("tbii.billing_invoice_item_patient_share, ").append("billing_invoice_number, tvp.b_contract_plans_id, tv.b_visit_clinic_id as mnc_dep_no, bvc.visit_clinic_description as mnc_fn_typ_cd, ").append("tv.t_visit_id, visit_staff_doctor_discharge, tbii.billing_invoice_item_patient_share, tbii.billing_invoice_item_total, ").append("tbii.t_order_item_id, tvp.t_visit_payment_id, bcp.contract_plans_description,").append("tv.visit_hn as mnc_hn_no,tbii.billing_invoice_item_patient_share as mnc_fn_pad, ").append("tbii.billing_invoice_item_total as mnc_fn_amt, 0.0 as mnc_fn_dis,").append("visit_staff_doctor_discharge as MNC_DOT_CD_DF, tv.t_patient_id,tbii.t_billing_invoice_item_id, tbi.t_billing_id,").append("bi.item_common_name,tbii.t_billing_invoice_id,bi.b_item_billing_subgroup_id, tbii.t_payment_id, bi.item_status_doctor, ").append("bisg.f_item_group_id, bi.item_number ").append("From t_visit tv ").append("left join t_billing_invoice_item tbii on tbii.t_visit_id = tv.t_visit_id and tbii.billing_invoice_item_active = '1' ").append("left join t_billing_invoice tbi on tbii.t_billing_invoice_id = tbi.t_billing_invoice_id ").append("left join t_visit_payment tvp on tv.t_visit_id = tvp.t_visit_id and tbii.t_payment_id = tvp.t_visit_payment_id ")
//            .append("left join b_contract_plans bcp on tvp.b_contract_plans_id = bcp.b_contract_plans_id ")
//            .append("left join b_visit_clinic bvc on tv.b_visit_clinic_id = bvc.b_visit_clinic_id ")
//            .append("left join b_item bi on tbii.b_item_id = bi.b_item_id ")
//            .append("left join b_item_subgroup bisg on bi.b_item_subgroup_id = bisg.b_item_subgroup_id ")
//            .append("Where tv.visit_hn = '").append(visit_hn).append("' and substring(tv.visit_financial_discharge_time,0,11) >= '")
//            .append(visti_date_start).append("' and substring(tv.visit_financial_discharge_time,0,11) <= '").append(visit_date_end).append("' ");
          sql.append("Select tv.visit_vn as mnc_vn_no, substring(tv.visit_financial_discharge_time,12) as MNC_FN_TIME, ")//m3+
            .append("substring(tv.visit_financial_discharge_time,0,11) as MNC_FN_DAT, tv.visit_hn, tbii.b_item_id, ")
            .append("tbii.billing_invoice_item_patient_share, ").append("billing_invoice_number, tvp.b_contract_plans_id, tv.b_visit_clinic_id as mnc_dep_no, bvc.visit_clinic_description as mnc_fn_typ_cd, ")
            .append("tv.t_visit_id, visit_staff_doctor_discharge, tbii.billing_invoice_item_patient_share, tbii.billing_invoice_item_total, ")
            .append("tbii.t_order_item_id, tvp.t_visit_payment_id, bcp.contract_plans_description,").append("tv.visit_hn as mnc_hn_no,tbii.billing_invoice_item_patient_share as mnc_fn_pad, ").append("tbii.billing_invoice_item_total as mnc_fn_amt, 0.0 as mnc_fn_dis,")
            .append("visit_staff_doctor_discharge as MNC_DOT_CD_DF, tv.t_patient_id,tbii.t_billing_invoice_item_id, tbi.t_billing_id,")
            .append("bi.item_common_name,tbii.t_billing_invoice_id,bi.b_item_billing_subgroup_id, tbii.t_payment_id, bi.item_specified as item_status_doctor, ").append("bisg.f_item_group_id, bi.item_number ").append(",tor.order_home ")
                  
            .append("From t_visit tv ")
            .append("left join t_billing_invoice_item tbii on tbii.t_visit_id = tv.t_visit_id ")
            .append("left join t_billing_invoice tbi on tbii.t_billing_invoice_id = tbi.t_billing_invoice_id ")
            .append("left join t_visit_payment tvp on tv.t_visit_id = tvp.t_visit_id and tbii.t_payment_id = tvp.t_visit_payment_id ")
            .append("left join b_contract_plans bcp on tvp.b_contract_plans_id = bcp.b_contract_plans_id ")
            .append("left join b_visit_clinic bvc on tv.b_visit_clinic_id = bvc.b_visit_clinic_id ")
            .append("left join b_item bi on tbii.b_item_id = bi.b_item_id ")
            .append("left join b_item_subgroup bisg on bi.b_item_subgroup_id = bisg.b_item_subgroup_id ")
            .append("left join t_order tor on tor.t_order_id = tbii.t_order_item_id ")
            .append("Where tv.visit_hn = '").append(visit_hn).append("' and tbii.billing_invoice_item_active = '1' and substring(tv.visit_financial_discharge_time,0,11) >= '")
            .append(visti_date_start).append("' and substring(tv.visit_financial_discharge_time,0,11) <= '").append(visit_date_end).append("' ");
        }else{
//          sql.append("Select tv.visit_vn as mnc_vn_no, substring(tv.visit_financial_discharge_time,12) as MNC_FN_TIME, ")//m3-
//            .append("substring(tv.visit_financial_discharge_time,0,11) as MNC_FN_DAT, tv.visit_hn, tbii.b_item_id, ")
//            .append("tbii.billing_invoice_item_patient_share, ").append("billing_invoice_number, tvp.b_contract_plans_id, tv.b_visit_clinic_id as mnc_dep_no, bvc.visit_clinic_description as mnc_fn_typ_cd, ")
//            .append("tv.t_visit_id, visit_staff_doctor_discharge, tbii.billing_invoice_item_patient_share, tbii.billing_invoice_item_total, ")
//            .append("tbii.t_order_item_id, tvp.t_visit_payment_id, bcp.contract_plans_description,").append("tv.visit_hn as mnc_hn_no,tbii.billing_invoice_item_patient_share as mnc_fn_pad, ")
//            .append("tbii.billing_invoice_item_total as mnc_fn_amt, 0.0 as mnc_fn_dis,").append("visit_staff_doctor_discharge as MNC_DOT_CD_DF, tv.t_patient_id,tbii.t_billing_invoice_item_id, tbi.t_billing_id,")
//            .append("bi.item_common_name,tbii.t_billing_invoice_id,bi.b_item_billing_subgroup_id, tbii.t_payment_id, bi.item_status_doctor,")//item_specified
//            .append("bisg.f_item_group_id, bi.item_number ")
//            .append("From t_visit tv ")
//            .append("left join t_billing_invoice_item tbii on tbii.t_visit_id = tv.t_visit_id and tbii.billing_invoice_item_active = '1' ")
//            .append("left join t_billing_invoice tbi on tbii.t_billing_invoice_id = tbi.t_billing_invoice_id ")
//            .append("left join t_visit_payment tvp on tv.t_visit_id = tvp.t_visit_id and tbii.t_payment_id = tvp.t_visit_payment_id ")
//            .append("left join b_contract_plans bcp on tvp.b_contract_plans_id = bcp.b_contract_plans_id ")
//            .append("left join b_visit_clinic bvc on tv.b_visit_clinic_id = bvc.b_visit_clinic_id ")
//            .append("left join b_item bi on tbii.b_item_id = bi.b_item_id ")
//            .append("left join b_item_subgroup bisg on bi.b_item_subgroup_id = bisg.b_item_subgroup_id ")
//            .append("Where tv.visit_hn = '").append(visit_hn).append("' and tvp.t_visit_payment_id = '").append(billing_invoice_id).append("'");
          sql.append("Select tv.visit_vn as mnc_vn_no, substring(tv.visit_financial_discharge_time,12) as MNC_FN_TIME, ")//m3+
            .append("substring(tv.visit_financial_discharge_time,0,11) as MNC_FN_DAT, tv.visit_hn, tbii.b_item_id, ")
            .append("tbii.billing_invoice_item_patient_share, ").append("billing_invoice_number, tvp.b_contract_plans_id, tv.b_visit_clinic_id as mnc_dep_no, bvc.visit_clinic_description as mnc_fn_typ_cd, ")
            .append("tv.t_visit_id, visit_staff_doctor_discharge, tbii.billing_invoice_item_patient_share, tbii.billing_invoice_item_total, ")
            .append("tbii.t_order_item_id, tvp.t_visit_payment_id, bcp.contract_plans_description,").append("tv.visit_hn as mnc_hn_no,tbii.billing_invoice_item_patient_share as mnc_fn_pad, ")
            .append("tbii.billing_invoice_item_total as mnc_fn_amt, 0.0 as mnc_fn_dis,").append("visit_staff_doctor_discharge as MNC_DOT_CD_DF, tv.t_patient_id,tbii.t_billing_invoice_item_id, tbi.t_billing_id,")
            .append("bi.item_common_name,tbii.t_billing_invoice_id,bi.b_item_billing_subgroup_id, tbii.t_payment_id, bi.item_specified as item_status_doctor ,")//item_specified
            .append("bisg.f_item_group_id, bi.item_number ")
            .append(",tor.order_home ")
            .append("From t_visit tv ")
            .append("left join t_billing_invoice_item tbii on tbii.t_visit_id = tv.t_visit_id ")
            .append("left join t_billing_invoice tbi on tbii.t_billing_invoice_id = tbi.t_billing_invoice_id ")
            .append("left join t_visit_payment tvp on tv.t_visit_id = tvp.t_visit_id and tbii.t_payment_id = tvp.t_visit_payment_id ")
            .append("left join b_contract_plans bcp on tvp.b_contract_plans_id = bcp.b_contract_plans_id ")
            .append("left join b_visit_clinic bvc on tv.b_visit_clinic_id = bvc.b_visit_clinic_id ")
            .append("left join b_item bi on tbii.b_item_id = bi.b_item_id ")
            .append("left join b_item_subgroup bisg on bi.b_item_subgroup_id = bisg.b_item_subgroup_id ")
            .append("left join t_order tor on tor.t_order_id = tbii.t_order_item_id ")
            .append("Where tv.visit_hn = '").append(visit_hn).append("' and tbii.billing_invoice_item_active = '1' and tvp.t_visit_payment_id = '").append(billing_invoice_id).append("'");
        }

      }else {
        String[] vn_temp = billing_invoice_id.split("\\.");
        if (vn_temp.length > 0) {
          vn = vn_temp[0];
          vn_seq = vn_temp[1];
        }
        if (flag.equals("period_date")) {
          sql.append("Select pt01.mnc_vn_no, pt01.mnc_vn_seq, ft03.MNC_FN_NO, ft03.MNC_FN_DAT, ft03.MNC_HN_NO, ft03.MNC_PRE_NO, ")
                  .append("ft03.MNC_FN_TYP_CD, ft03.MNC_FN_PAD, fm01.MNC_FN_DSCT, ft03.MNC_DOT_CD_DF, ft03.MNC_DEP_NO, ft03.MNC_FN_TIME, ft03.MNC_FN_DAT ")
                  .append(", ft03.MNC_FN_AMT, ft03.MNC_FN_OUT, ft03.MNC_FN_DIS")
                  .append("From finance_t03 ft03 left join patient_t01 pt01 on ft03.mnc_hn_no = pt01.mnc_hn_no ").append("and ft03.mnc_hn_yr = pt01.mnc_hn_yr and ft03.mnc_pre_no = pt01.mnc_pre_no ").append("left join finance_m01 fm01 on ft03.MNC_FN_CD = fm01.MNC_FN_CD  ")
                  .append("Where ft03.MNC_FN_DAT = '").append(visti_date_start).append("' and ft03.MNC_FN_DAT ='").append(visit_date_end).append("' and ft03.MNC_FN_PAD is not null ").append(" and pt01.mnc_sts <> 'C' ").append("Order By ft03.MNC_FN_DAT, ft03.MNC_FN_TIME ");
        }else if (flag.equals("hn")) {
          sql.append("Select pt01.mnc_vn_no, pt01.mnc_vn_seq, ft03.MNC_FN_NO, ft03.MNC_FN_DAT, ft03.MNC_HN_NO, ft03.MNC_PRE_NO, ")
                  .append("ft03.MNC_FN_TYP_CD, ft03.MNC_FN_PAD, fm01.MNC_FN_DSCT, ft03.MNC_DOT_CD_DF, ft03.MNC_DEP_NO, ft03.MNC_FN_TIME, ft03.MNC_FN_DAT ").append(", ft03.MNC_FN_AMT, ft03.MNC_FN_OUT, ft03.MNC_FN_DIS ").append("From finance_t03 ft03 left join patient_t01 pt01 on ft03.mnc_hn_no = pt01.mnc_hn_no ").append("and ft03.mnc_hn_yr = pt01.mnc_hn_yr and ft03.mnc_pre_no = pt01.mnc_pre_no ").append("left join finance_m01 fm01 on ft03.MNC_FN_CD = fm01.MNC_FN_CD  ")
                  .append("Where ft03.MNC_FN_DAT = '").append(visti_date_start).append("' and ft03.MNC_FN_DAT ='").append(visit_date_end).append("' and ft03.MNC_FN_PAD is not null ").append(" and pt01.mnc_sts <> 'C' and pt01.mnc_hn_no = '").append(visit_hn).append("' ")
                  .append("Order By ft03.MNC_FN_DAT, ft03.MNC_FN_TIME ");
        }else if (flag.equals("visit_payment_id")) {
            String docNo="", docCD="";
            if(visit_date_end.indexOf("@")>0){
                docCD = visit_date_end.substring(0, visit_date_end.indexOf("@"));
                docNo = visit_date_end.substring(visit_date_end.indexOf("@")+1);
            }
            if(docCD.equals("ON1")){
                sql.append("Select pt01.mnc_vn_no, pt01.mnc_vn_seq, ft03.MNC_FN_NO, ft03.MNC_FN_DAT, ft03.MNC_HN_NO, ft03.MNC_PRE_NO, ")
            .append("pt01.MNC_FN_TYP_CD, ft03.MNC_FN_PAD, fm01.MNC_FN_DSCT, ft03.MNC_DOT_CD_DF, ft03.MNC_DEP_NO, ft03.MNC_FN_TIME, ft03.MNC_FN_DAT ").append(", ft03.MNC_FN_AMT, ft03.MNC_FN_OUT, ft03.MNC_FN_DIS, ft03.MNC_DOT_CD_DF ")
            .append("From finance_t03 ft03 left join patient_t01 pt01 on ft03.mnc_hn_no = pt01.mnc_hn_no ")
            .append("and ft03.mnc_hn_yr = pt01.mnc_hn_yr and ft03.mnc_pre_no = pt01.mnc_pre_no ")
            .append("left join finance_m01 fm01 on ft03.MNC_FN_CD = fm01.MNC_FN_CD  ")
            .append("Where ft03.MNC_FN_DAT = '").append(visti_date_start).append("' and ft03.MNC_DOC_NO ='").append(docNo)
            .append("' and ft03.mnc_doc_cd = '").append(docCD)
            .append("' and ft03.MNC_FN_PAD is not null ").append(" and pt01.mnc_sts <> 'C' and pt01.mnc_hn_no = '").append(visit_hn)
            .append("' and pt01.mnc_vn_no = '").append(vn).append("' and pt01.mnc_vn_seq = '").append(vn_seq).append("' ")
            .append("Order By ft03.MNC_FN_DAT, ft03.MNC_FN_TIME ");
            }else{
                sql.append("Select ft03.MNC_FN_NO, ft03.MNC_FN_DAT, ft03.MNC_PRE_NO, ")
            .append("pt01.MNC_FN_TYP_CD, ft03.MNC_FN_PAD, fm01.MNC_FN_DSCT, ft03.MNC_DOT_CD_DF, ft03.MNC_DEP_NO, ft03.MNC_FN_TIME, ft03.MNC_FN_DAT ").append(", ft03.MNC_FN_AMT, ft03.MNC_FN_OUT, ft03.MNC_FN_DIS, ft03.MNC_DOT_CD_DF ")
            .append("From finance_t06 ft03 left join finance_t01 pt01 on ft03.MNC_DOC_CD = pt01.MNC_DOC_CD and ft03.MNC_PRE_NO = pt01.MNC_PRE_NO and ft03.MNC_DOC_YR = pt01.MNC_DOC_YR and ft03.MNC_DOC_NO = pt01.MNC_DOC_NO ")
            .append("left join finance_m01 fm01 on ft03.MNC_FN_CD = fm01.MNC_FN_CD  ")
            .append("Where ft03.MNC_FN_DAT = '").append(visti_date_start).append("' and ft03.MNC_DOC_NO ='").append(docNo)
            .append("' and ft03.mnc_doc_cd = '").append(docCD)
            .append("' and ft03.MNC_FN_PAD is not null ").append(" and pt01.mnc_hn_no = '").append(visit_hn).append("' ")
//            .append("' and pt01.mnc_vn_no = '").append(vn).append("' and pt01.mnc_vn_seq = '").append(vn_seq).append("' ")
            .append("Order By ft03.MNC_FN_DAT, ft03.MNC_FN_TIME ");
            }
          
        }else{
          sql.append("Select pt01.mnc_vn_no, pt01.mnc_vn_seq, ft03.MNC_FN_NO, ft03.MNC_FN_DAT, ft03.MNC_HN_NO, ft03.MNC_PRE_NO, ").append("ft03.MNC_FN_TYP_CD, ft03.MNC_FN_PAD, fm01.MNC_FN_DSCT, ft03.MNC_DOT_CD_DF, ft03.MNC_DEP_NO, ft03.MNC_FN_TIME, ft03.MNC_FN_DAT ").append(", ft03.MNC_FN_AMT, ft03.MNC_FN_OUT, ft03.MNC_FN_DIS ").append("From finance_t03 ft03 left join patient_t01 pt01 on ft03.mnc_hn_no = pt01.mnc_hn_no ").append("and ft03.mnc_hn_yr = pt01.mnc_hn_yr and ft03.mnc_pre_no = pt01.mnc_pre_no ").append("left join finance_m01 fm01 on ft03.MNC_FN_CD = fm01.MNC_FN_CD  ")
                  .append("Where ft03.MNC_FN_DAT = '").append(visti_date_start).append("' and ft03.MNC_FN_DAT ='").append(visit_date_end).append("' and ft03.MNC_FN_PAD is not null ").append(" and pt01.mnc_sts <> 'C' ").append("Order By ft03.MNC_FN_DAT, ft03.MNC_FN_TIME ");
        }
      }

      ResultSet rsmainhis = st.executeQuery(sql.toString());
      while (rsmainhis.next()) {
        if (branch.getBranchProgram().equals("hospital_osv3")) {
            error="0100";
          if (rsmainhis.getString("MNC_FN_TIME") == null)
            time = "0000";
          else {
            time = rsmainhis.getString("MNC_FN_TIME");
          }
          error="0200";
          if(time.length()>=5) time = time.substring(0, 5);
          if (rsmainhis.getString("MNC_FN_DAT").length() >= 10)
            visit_date = rsmainhis.getString("MNC_FN_DAT").substring(0, 10);
          else {
            visit_date = rsmainhis.getString("MNC_FN_DAT");
          }
          error="1000";

          bpvdb.bpvi = new BackTPatientVisitItem();
          bpvdb.bpvi.setBItemBillingSubgroupId(rsmainhis.getString("b_item_billing_subgroup_id"));
          bpvdb.bpvi.setBItemId(rsmainhis.getString("b_item_id"));
          bpvdb.bpvi.setBillingInvoiceItemActive("1");
          bpvdb.bpvi.setBillingInvoiceItemTotal(Double.valueOf(Double.parseDouble(rsmainhis.getString("MNC_FN_PAD"))));
          bpvdb.bpvi.setBillingInvoiceNumber(rsmainhis.getString("item_number"));

          bpvdb.bpvi.setClaimId(rsmainhis.getString("b_contract_plans_id"));
          bpvdb.bpvi.setClaimNamet(rsmainhis.getString("contract_plans_description"));
          bpvdb.bpvi.setDepartmentNamet(rsmainhis.getString("MNC_DEP_NO"));
//          bpvdb.bpvi.setPatientVisitBillingItemId(rsmainhis.getString("t_billing_invoice_item_id"));//bug m1-
          bpvdb.bpvi.setPatientVisitBillingItemId("");//m1+
          bpvdb.bpvi.setPatientVisitId(rsmainhis.getString("t_visit_id"));

          bpvdb.bpvi.setTBillingId(rsmainhis.getString("t_billing_id"));
          bpvdb.bpvi.setTBillingInvoiceDateTime(visit_date);
//          bpvdb.bpvi.setTBillingInvoiceItemId(rsmainhis.getString("t_billing_invoice_id"));//bug m1-
          bpvdb.bpvi.setTBillingInvoiceItemId(rsmainhis.getString("t_billing_invoice_item_id"));//m1+

          bpvdb.bpvi.setTBillingInvoiceTime(time);

          bpvdb.bpvi.setTOrderItemId(rsmainhis.getString("t_order_item_id"));
          bpvdb.bpvi.setTPatientId(rsmainhis.getString("t_patient_id"));
          bpvdb.bpvi.setTPaymentId(rsmainhis.getString("t_visit_payment_id"));
          bpvdb.bpvi.setVisitId(rsmainhis.getString("t_visit_id"));
          bpvdb.bpvi.setBranchId(branch.getBranchId());
          bpvdb.bpvi.setTBillingInvoiceItemNamet(rsmainhis.getString("item_common_name"));

          if (rsmainhis.getString("MNC_DOT_CD_DF") == null) {
            bpvdb.bpvi.setVisitPatientSelfDoctor("");
          }else {
            bpvdb.bpvi.setVisitPatientSelfDoctor(rsmainhis.getString("MNC_DOT_CD_DF"));
          }

          error="2000";
          bpvdb.bpvi.setVisitVn(rsmainhis.getString("mnc_vn_no"));
          bpvdb.bpvi.setVisitHn(rsmainhis.getString("mnc_hn_no"));
          bpvdb.bpvi.setDepartmentId(rsmainhis.getString("MNC_DEP_NO"));
          if (rsmainhis.getString("item_status_doctor") ==null)
            bpvdb.bpvi.setItemStatusDoctor("0");
          else if(rsmainhis.getString("item_status_doctor").equals(""))
              bpvdb.bpvi.setItemStatusDoctor("0");
          else {
            bpvdb.bpvi.setItemStatusDoctor(rsmainhis.getString("item_status_doctor"));
          }
          error="2100";
          if (bpvdb.bpvi.getItemStatusDoctor().equals("1")) {
            getDoctorIdTOrder(branch.getBranchId(), st_order, bpvdb.bpvi);
          }
          bpvdb.bpvi.setFItemGroupId(rsmainhis.getString("f_item_group_id"));
          if (rsmainhis.getString("MNC_FN_DIS") == null)
            bpvdb.bpvi.setItemDiscount(Double.valueOf(0.0D));
          else {
            bpvdb.bpvi.setItemDiscount(Double.valueOf(Double.parseDouble(rsmainhis.getString("MNC_FN_DIS"))));
          }
          error="2200";
          if (rsmainhis.getString("MNC_FN_PAD") == null)
            bpvdb.bpvi.setItemPaid(Double.valueOf(0.0D));
          else {
            bpvdb.bpvi.setItemPaid(Double.valueOf(Double.parseDouble(rsmainhis.getString("MNC_FN_PAD"))));
          }
          error="2300";
          if (rsmainhis.getString("MNC_FN_AMT") == null)
            bpvdb.bpvi.setItemTotal(Double.valueOf(0.0D));
          else
            bpvdb.bpvi.setItemTotal(Double.valueOf(Double.parseDouble(rsmainhis.getString("MNC_FN_AMT"))));
          error="3000";
          bpvdb.bpvi.orderHome = config1.StringNull(rsmainhis.getString("order_home"));
        }else {
            if (visit_hn.equals("1463462")) {
                error = "";
            }
          if (rsmainhis.getString("MNC_FN_TIME") == null)
            time = "0000";
          else {
            time = "0000" + rsmainhis.getString("MNC_FN_TIME");
          }
          time = time.substring(time.length() - 4, time.length());
          if (rsmainhis.getString("MNC_FN_DAT").length() >= 10) visit_date = rsmainhis.getString("MNC_FN_DAT").substring(0, 10);
          else  visit_date = rsmainhis.getString("MNC_FN_DAT");
          description = rsmainhis.getString("MNC_FN_DSCT");
          description = description.replace("'", "''");
          if(visit_hn.equals("1463462")){
              error="3000";
          }
          if(rsmainhis.getString("MNC_DOT_CD_DF")!= null){
              
          }
          bpvdb.bpvi = new BackTPatientVisitItem();
          bpvdb.bpvi.setBItemBillingSubgroupId(rsmainhis.getString("MNC_FN_NO"));
          bpvdb.bpvi.setBItemId(rsmainhis.getString("MNC_FN_NO"));
          bpvdb.bpvi.setBillingInvoiceItemActive("1");
          bpvdb.bpvi.setBillingInvoiceItemTotal(Double.valueOf(Double.parseDouble(rsmainhis.getString("MNC_FN_PAD"))));
          bpvdb.bpvi.setBillingInvoiceNumber("");

          bpvdb.bpvi.setClaimId(rsmainhis.getString("MNC_FN_TYP_CD"));
          bpvdb.bpvi.setClaimNamet(rsmainhis.getString("MNC_FN_TYP_CD"));
          bpvdb.bpvi.setDepartmentNamet(rsmainhis.getString("MNC_DEP_NO"));
          bpvdb.bpvi.setPatientVisitBillingItemId("");
          bpvdb.bpvi.setPatientVisitId("");

          bpvdb.bpvi.setTBillingId("");
          bpvdb.bpvi.setTBillingInvoiceDateTime(visit_date);
          bpvdb.bpvi.setTBillingInvoiceItemId(rsmainhis.getString("MNC_FN_NO"));
          bpvdb.bpvi.setTBillingInvoiceItemNamet(description);
          bpvdb.bpvi.setTBillingInvoiceTime(time);

          bpvdb.bpvi.setTOrderItemId("");
          bpvdb.bpvi.setTPatientId("");
          bpvdb.bpvi.setTPaymentId(rsmainhis.getString("MNC_PRE_NO"));
          bpvdb.bpvi.setVisitId("");
          bpvdb.bpvi.setBranchId(branch.getBranchId());

          if (rsmainhis.getString("MNC_DOT_CD_DF") == null){
              bpvdb.bpvi.setVisitPatientSelfDoctor("");
              bpvdb.bpvi.setItemStatusDoctor("0");
          }else{
              bpvdb.bpvi.setVisitPatientSelfDoctor("");
              bpvdb.bpvi.setItemStatusDoctor("0");
              if(!rsmainhis.getString("MNC_DOT_CD_DF").equals("")){
                  bpvdb.bpvi.setVisitPatientSelfDoctor(rsmainhis.getString("MNC_DOT_CD_DF"));
                    bpvdb.bpvi.setItemStatusDoctor("1");
                    bpvdb.bpvi.setDoctorId(rsmainhis.getString("mnc_dot_cd_df"));
              }
          }

          bpvdb.bpvi.setVisitVn(vn + "." + vn_seq);
          
          bpvdb.bpvi.setVisitHn(visit_hn);
          bpvdb.bpvi.setDepartmentId(rsmainhis.getString("MNC_DEP_NO"));
          if (rsmainhis.getString("MNC_FN_DIS") == null)
            bpvdb.bpvi.setItemDiscount(Double.valueOf(0.0D));
          else bpvdb.bpvi.setItemDiscount(Double.valueOf(Double.parseDouble(rsmainhis.getString("MNC_FN_DIS"))));
          if (rsmainhis.getString("MNC_FN_PAD") == null) 
              bpvdb.bpvi.setItemPaid(Double.valueOf(0.0D));
            else {
              bpvdb.bpvi.setItemPaid(Double.valueOf(Double.parseDouble(rsmainhis.getString("MNC_FN_PAD"))));
              bpvdb.bpvi.setItemTotal(Double.valueOf(Double.parseDouble(rsmainhis.getString("MNC_FN_PAD"))));
          }
            
//          if (rsmainhis.getString("MNC_FN_AMT") == null) bpvdb.bpvi.setItemTotal(Double.valueOf(0.0D));
//            else bpvdb.bpvi.setItemTotal(Double.valueOf(Double.parseDouble(rsmainhis.getString("MNC_FN_PAD"))));
          
        }
        error="4000";
        v_patient_visit.add(bpvdb.bpvi);
      }
      rsmainhis.close();
    }catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
//      blc.saveLog("bangnaadmin.BackTPatientVisitDB1", error, error, "error"+ex.getMessage(), config1.getDateDBHospital("yyyyMMdd"), vn, vn, "error"+error+",billing_invoice_id="+billing_invoice_id+",visit_hn="+visit_hn);
    }
    return v_patient_visit;
  }
  public Double getCntPatientVisit(String branch_id, String date_start, String date_end) {
    Double row = Double.valueOf(0.0D);
    String sql = "";
    try {
      bpvdb.branch = bpvdb.config1.getBranch(branch_id);
      Connection conn;
      if (bpvdb.branch.getBranchProgram().equals("hospital_osv3")) {
        sql = "Select count(pt01.visit_vn) as cnt From t_visit pt01 Where substring(pt01.visit_financial_discharge_time,1,11) >= '" + date_start + "' and substring(pt01.visit_financial_discharge_time,1,11) <= '" + date_end + "' " + " ";
        conn = bpvdb.config1.getConnectionHospital(branch_id);
      }else{
        if (branch_id.equals("103001")) {
          sql = "Select count(pt01.MNC_VN_NO) as cnt From patient_t01 pt01 Where pt01.mnc_date >= '" + date_start + "' and pt01.mnc_date <= '" + date_end + "' and pt01.MNC_STS <> 'C' and pt01.MNC_VN_SUM = 1";
          conn = bpvdb.config1.getConnectionMainHIS(branch_id);
        } else{
          if (branch_id.equals("103002")) {
            sql = "Select count(pt01.MNC_VN_NO) as cnt From patient_t01 pt01 Where pt01.mnc_date >= '" + date_start + "' and pt01.mnc_date <= '" + date_end + "' and pt01.MNC_STS <> 'C' and pt01.MNC_VN_SUM = 1";
            conn = bpvdb.config1.getConnectionMainHIS(branch_id);
          } else {
            sql = "Select count(pt01.MNC_VN_NO) as cnt From patient_t01 pt01 Where pt01.mnc_date >= '" + date_start + "' and pt01.mnc_date <= '" + date_end + "' and pt01.MNC_STS <> 'C' and pt01.MNC_VN_SUM = 1";
            conn = bpvdb.config1.getConnectionMainHIS(branch_id);
          }
        }
      }
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        row = Double.valueOf(Double.parseDouble(rs.getString("cnt")));
      }
      rs.close();
      conn.close();
    }catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
    }
    return row;
  }
    private void getDoctorIdTOrder(String branch_id, Statement st, BackTPatientVisitItem bpvi) {
        String sql = "";
//        sql = "Select order_notice, doctor_id, order_date_time "
//            + "From t_order Where t_order_id = '" + bpvi.getTOrderItemId() + "'";
        sql = "Select order_notice, doctor_id, order_date_time, order_start_time, order_end_time, status_rate,order_operation_no"
                + ",order_operation_status,status_no_close_day_import "
            + "From t_order "
            + "Where t_order_id = '" + bpvi.getTOrderItemId() + "' ";
        try{
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if ((rs.getString("doctor_id") != null) && (!rs.getString("doctor_id").equals(""))) {
                    bpvi.setDoctorId(rs.getString("doctor_id"));
                }else {
                    bpvi.setDoctorId(rs.getString("order_notice"));
                }
                bpvi.orderDateTime = rs.getString("order_date_time");
                bpvi.orderStartTime = rs.getString("order_start_time");
                bpvi.orderEndTime = rs.getString("order_end_time");
                bpvi.statusRate = rs.getString("status_rate");
                bpvi.orderOperationNo = rs.getString("order_operation_no");
                if(bpvi.orderOperationNo==null) bpvi.orderOperationNo = "";
                if(bpvi.orderOperationNo.equals("0")) bpvi.orderOperationNo="";
                if(!bpvi.orderOperationNo.equals("0"))
                    sql="";
                bpvi.orderOperationStatus = rs.getString("order_operation_status");
                bpvi.statusNoCloseDayImport = config1.StringNull(rs.getString("status_no_close_day_import"));
            }
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  public BackTPatientImport setPatientImportCntSumFromPatientVisit(BackTPatientImport patient_import, String flag) {
    String sql = ""; String sql1 = "";
    Double paid = 0.0, cnt = 0.0, paid_funds =0.0,  paid_contact = 0.0, cnt_funds = 0.0, cnt_contact = 0.0, cnt_doctor = 0.0, paid_doctor = 0.0;

    BackBTransfer b_tranfer = new BackBTransfer();
    try {
      Connection conn = bpvdb.config1.getConnectionBangna();
      Statement stbangna = conn.createStatement();
      Statement st = conn.createStatement();

      sql1 = "Select * From " + b_tranfer.getBackBTransfer() + " " 
              + "Where " + b_tranfer.getFBranchId() + " = '" + patient_import.getBranchId() + "' and " + b_tranfer.getFTransferActive() + " = '1' " 
              + "Order By " + b_tranfer.getFPaidId();

      ResultSet rs1 = stbangna.executeQuery(sql1);
      while (rs1.next()) {
        sql = "Select count(" + bpvdb.bpv.getFVisitHn() + ") as cnt, sum(" + bpvdb.bpv.getFVisitTotal() + ") as paid, "
                + bpvdb.bpv.getFVisitPaidId() + " " + "From " + bpvdb.bpv.getBackTPatientVisit() + " "
                + "Where " + bpvdb.bpv.getFPatientImportId() + "='" + patient_import.getPatientImportId() + "' and "
                + bpvdb.bpv.getFContractPayerNumber() + " ='" + rs1.getString("paid_id") + "' " + "Group By " + bpvdb.bpv.getFVisitPaidId();

        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
          paid = Double.valueOf(paid.doubleValue() + Double.parseDouble(rs.getString("paid")));
          cnt = Double.valueOf(cnt.doubleValue() + Double.parseDouble(rs.getString("cnt")));
          if (rs1.getString(b_tranfer.getFBDepartmentId()).equals("14501")) {
            paid_funds = Double.valueOf(paid_funds.doubleValue() + Double.parseDouble(rs.getString("paid")));
            cnt_funds = Double.valueOf(cnt_funds.doubleValue() + Double.parseDouble(rs.getString("cnt")));
          }
          if (rs1.getString(b_tranfer.getFBDepartmentId()).equals("14502")) {
            paid_contact = Double.valueOf(paid_contact.doubleValue() + Double.parseDouble(rs.getString("paid")));
            cnt_contact = Double.valueOf(cnt_contact.doubleValue() + Double.parseDouble(rs.getString("cnt")));
          }
        }
        rs.close();
      }
      rs1.close();
      sql = "Select count(" + bpvdb.bpv.getFVisitHn() + ") as cnt, sum(" + bpvdb.bpv.getFVisitTotal() + ") as paid, "
            + bpvdb.bpv.getFVisitPaidId() + " " + "From " + bpvdb.bpv.getBackTPatientVisit() + " "
            + "Where " + bpvdb.bpv.getFPatientImportId() + "='" + patient_import.getPatientImportId() + "' "
            + "Group By " + bpvdb.bpv.getFVisitPaidId();

      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        paid = Double.valueOf(paid.doubleValue() + Double.parseDouble(rs.getString("paid")));
        cnt = Double.valueOf(cnt.doubleValue() + Double.parseDouble(rs.getString("cnt")));
      }
      rs.close();
      sql = "Select count(1) as cnt From " + bpvdb.bpv.getBackTPatientVisit() + " "
            + "Where " + bpvdb.bpv.getFPatientImportId() + "='" + patient_import.getPatientImportId() + "' and "
            + bpvdb.bpv.getFItemStatusDoctor() + "='1' and "+bpvdb.bpv.getFPatientVisitActive()+"='1'";

      rs = st.executeQuery(sql);
      while (rs.next()) {
        cnt_doctor = Double.valueOf(Double.parseDouble(rs.getString("cnt")));
      }
      rs.close();
      sql = "Select sum(bpvi." + bpvdb.bpvi.getFItemTotal() + ") as paid " + " "
            + "From " + bpvdb.bpvi.getBackTPatientVisitItem() + " as bpvi "
            + "left join " + bpvdb.bpv.getBackTPatientVisit() + " as bpv on bpv."
            + bpvdb.bpv.getFPatientVisitId() + "= bpvi." + bpvdb.bpvi.getFPatientVisitId() + " "
            + "Where bpv." + bpvdb.bpv.getFPatientImportId() + "='" + patient_import.getPatientImportId() 
            + "' and bpvi." + bpvdb.bpvi.getFItemStatusDoctor() + "='1' ";

      rs = st.executeQuery(sql);
      while (rs.next()) {
          if(rs.getString("paid")!=null) paid_doctor = Double.parseDouble(rs.getString("paid"));
          else paid_doctor=0.0;
      }
      rs.close();
      

      patient_import.setCntPatientVisitFunds(cnt_funds);
      patient_import.setCntPatientVisitContact(cnt_contact);
      patient_import.setAmountPatientVisitFunds(paid_funds);
      patient_import.setAmountPatientVisitContact(paid_contact);
      patient_import.setCntPatientVisitDoctor(cnt_doctor);
      patient_import.setAmountPatientVisitDoctor(paid_doctor);

      patient_import.setCntPatientVisitVn(cnt);
      patient_import.setCntPatientVisit(getCntPatientVisit(patient_import.getBranchId(), patient_import.getDateStart(), patient_import.getDateEnd()));
      patient_import.setAmountPatientVisit(paid);
      patient_import.setSysStatusContact("A");
      patient_import.setPatientImportActive("1");
      if(flag.equals("update")){
          bpidb.setUpdatePatientVisitImportCnt(patient_import.getPatientImportId(),patient_import);
      }
      conn.close();
    }catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
    }
    return patient_import;
  }
  public String setImportPatientNew(String branch_id, String date_start, String date_end, String patient_import_id, String flag) {
//      Vector v_patient_visit = new Vector();
      setImportPatient(branch_id, date_start, date_end, patient_import_id, flag, "");
      return patient_import_id;
  }
    
    public String setImportFront(String branch_id, String dateImport, String description, String remark, String date_start, String date_end, String flag){
        String date_startdb="", chk="",import_date="", month="", year="",patient_import_id="";
//        Vector v_patient_visit = new Vector();
      
        bp_i = new BackTPatientImport();
        try {
//            date_startdb = config1.DateFormatShow2DB(date_start, "ddMMyyyy");
//            date_enddb = config1.DateFormatShow2DB(date_end, "ddMMyyyy");
//            import_date = config1.DateFormatShow2DB(dateImport, "ddMMyyyy");
            month = date_start.substring(5, 7);
            year = date_start.substring(0, 4);
            bp_i.setBranchId(branch_id);
            bp_i.setDateStart(date_start);
            bp_i.setDateEnd(date_end);
            bp_i.setCntPatientVisit(0.0);
            bp_i.setCntPatientVisitVn(0.0);
            bp_i.setDescription(description);
            bp_i.setPatientImportId("");
            bp_i.setPatientImportMonth(month);
            bp_i.setPatientImportYear(year);
            bp_i.setRemark(remark);
            bp_i.setPatientImportDate(dateImport);
            bp_i.setSysStatusContact("A");
            bp_i.setSysStatusFunds("A");
            bp_i.setSysStatusDoctor("A");
            bp_i.setPatientImportActive("1");

            patient_import_id = bpidb.setSaveBackTPatientImport(bp_i);//save
            
            setImportPatient(branch_id, date_start, date_end, patient_import_id, flag, "noreturn");
            setImportPatient(branch_id, date_start, date_end, patient_import_id, "close_day_unbilling", "noreturn");
            bp_i.setPatientImportId(patient_import_id);
            bp_i = setPatientImportCntSumFromPatientVisit(bp_i, "update");//หายอด sum, count ต่างๆ
//            bpvdb.setSavePatientVisitImportId(patient_import_id);// update
            chk = closedaydb.setUpdateCloseDayImport(branch_id, date_start);
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      return patient_import_id;
  }
    public Vector setImportPatient(String branch_id, String date_start, String date_end, String patient_import_id, String flag, String flagReturn) {
        String bpvId = ""; String sql = ""; String date_start1 = ""; String date_end1 = ""; String year_start = ""; String year_end = "";
        Vector vBpv = new Vector();
        Vector vBilling = new Vector();
        PatientVisit pv = new PatientVisit();
        BackTPatientVisit bpv ;
        PatientVisitPaid patientvisitpaid = new PatientVisitPaid();

        Double discount = 0.0, total=0.0;
    try {
        bpvdb.branch = config1.getBranch(branch_id);
        Connection conn_bangna = config1.getConnectionBangna();
        Connection conn_order;
        Connection conn;
      if (bpvdb.branch.getBranchProgram().equals("hospital_osv3")) {
        if (flag.equals("close_day") || (flag.equals("close_day_unbilling"))) {
          date_start1 = date_start;
          date_end1 = date_end;
          year_start = date_start1.substring(0, 4);
          year_end = date_end1.substring(0, 4);
          if (Integer.parseInt(year_start) < 2500) {
            date_start1 = String.valueOf(Integer.parseInt(year_start) + 543) + date_start1.substring(4);
          }
          if (Integer.parseInt(year_end) < 2500)
            date_end1 = String.valueOf(Integer.parseInt(year_end) + 543) + date_end1.substring(4);
        }else {
          date_start1 = date_start;
          date_end1 = date_end;
        }
        conn = config1.getConnectionHospital(branch_id);
        conn_order = config1.getConnectionHospital(branch_id);
      }else {
        date_start1 = date_start;
        date_end1 = date_end;
        conn = config1.getConnectionMainHIS(branch_id);
        conn_order = config1.getConnectionMainHIS(branch_id);
      }
      Statement st = conn_bangna.createStatement();
      Statement st_hospital = conn.createStatement();
      Statement st_order = conn_order.createStatement();
      vBpv = config1.getPatientVisit(bpvdb.branch, date_start1, date_end1, "", flag);
        for (int i = 0; i <= vBpv.size() - 1; i++) {
            pv = (PatientVisit)vBpv.get(i);
            try{
                if (pv.getVisitVn().equals("153000643")) {
                    sql = "";
                }
                bpv = setCastPatientVisit(branch_id, st_hospital,date_start,date_end,patient_import_id,pv,flag);
//                if (!bpvdb.branch.getBranchProgram().equals("hospital_osv3")) {
//                    patientvisitpaid = new PatientVisitPaid();
//                    patientvisitpaid = bpvdb.config1.getPatientVisitPaidByVn(conn, st, branch_id, pv.getVisitDate(), pv.getPatientHn(), pv.getVisitVn());
//                    bpv.setVisitPaid(patientvisitpaid.getPaid());
//                    bpv.setVisitTotal(patientvisitpaid.getAmount());
//                    bpv.setVisitDiscount(patientvisitpaid.discount);
//                    bpv.setDepartmentNamet(pv.getVisitClinicNamet());
//                    bpv.setFVisitTypeId(pv.getFVisitTypeId());
//                }
                if (bpv.getVisitHn().equals("5047556")) {
                    sql = "";
                }
//                if(patient_hn_no.equals("1768725")){
//                    sql="";
//                }

                if (bpvdb.branch.getBranchProgram().equals("hospital_osv3")){
                    vBilling = getPatientVisitBillingInvoice(st_hospital, st_order, bpvdb.branch, date_start1, date_end1, pv.getPatientHn(), pv.getTVisitPaymentId(), "visit_payment_id");
                }else {
                    vBilling = getPatientVisitBillingInvoice(st_hospital, st_order, bpvdb.branch, date_start1, pv.docCD+"@"+pv.getInvoiceNumber(), pv.getPatientHn(), pv.getVisitVn(), "visit_payment_id");
                }
                bpvId = bpvdb.setSaveBackTPatientVisit(conn_bangna, st, bpv);
                discount = Double.valueOf(0);
                total = 0.0;
                if (vBilling.size() <= 0) {
                    bpvdb.bpvi = new BackTPatientVisitItem();
                    bpvdb.bpvi.setPatientVisitId(bpvId);
                    bpvdb.bpvi.setSysStatus("A");
                    bpvdb.bpvi.setEditStatus("0");
                    bpvdb.bpvi.setItemStatusDoctor("1");
                    bpvdb.setUpdatePatientVisitItemStatusDoctor(branch_id, bpvId, bpvdb.bpvi.getItemStatusDoctor());
                    bpvdb.setSaveBackTPatientVisitItem(conn_bangna, st, bpvdb.bpvi);
                }
                for (int j = 0; j < vBilling.size(); j++) {
                    try {
                        bpvdb.bpvi = new BackTPatientVisitItem();
                        bpvdb.bpvi = ((BackTPatientVisitItem)vBilling.get(j));
                        bpvdb.bpvi.setPatientVisitId(bpvId);
                        bpvdb.bpvi.setSysStatus("A");
                        bpvdb.bpvi.setEditStatus("0");
                        if (bpvdb.bpvi.getItemStatusDoctor().equals("1")) {
                            bpvdb.setUpdatePatientVisitItemStatusDoctor(branch_id, bpvId, bpvdb.bpvi.getItemStatusDoctor());
                        }
                        total += bpvdb.bpvi.getItemTotal().doubleValue();
                        if ((bpvdb.bpvi.getBillingInvoiceNumber().equals("9")) || (bpvdb.bpvi.getBillingInvoiceNumber().equals("999"))) {
                            discount = Double.valueOf(discount.doubleValue() + bpvdb.bpvi.getItemTotal().doubleValue());
                        }
                        bpvdb.setSaveBackTPatientVisitItem(conn_bangna, st, bpvdb.bpvi);
                    } catch (Exception ex) {
                        Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                if (!bpvdb.branch.getBranchProgram().equals("hospital_osv3")){
//                    bpvdb.setUpdatePatientVisitDiscount(st, branch_id, patient_visit_id, discount);
//                    bpvdb.setUpdatePatientVisitTotal(st, branch_id, patient_visit_id, Double.valueOf(total - discount.doubleValue()));
                }else{
                    if (discount.doubleValue() < 0) {
                        bpvdb.setUpdatePatientVisitDiscount(st, branch_id, bpvId, discount);
                        bpvdb.setUpdatePatientVisitTotal(st, branch_id, bpvId, Double.valueOf(bpv.getVisitTotal().doubleValue() - discount.doubleValue()));
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            conn.close();
            conn_bangna.close();
            conn_order.close();
            if(flagReturn.equals(""))  vBpv = bpvdb.getBackTPatientVisit(branch_id, "", "", "patient_import");
            } catch (Exception ex) {
                Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
            }
        return vBpv;
    }
    public Vector getReImportDirect(String branch_id, String bpIId){
        String date_start1 = "";
        Vector vBpv = new Vector();
        Vector vBp = new Vector();
        BackTPatientVisit bpv ;
        PatientVisit pv = new PatientVisit();
        Connection conn;
        try {
            bpvdb.branch = config1.getBranch(branch_id);
            bp_i = bpidb.getBackTPatientImportByPK(bpIId, "patient_import_id");
            date_start1 = config1.DateFormatDB2ShowHospital(bp_i.getDateStart(),"ddMMyyyy");
            date_start1 = config1.DateFormatShow2DB(date_start1, "ddMMyyyy");
            conn = config1.getConnectionHospital(branch_id);
            Statement st_hospital = conn.createStatement();
            vBp = config1.getPatientVisit(bpvdb.branch, date_start1, date_start1, "", "close_day");
            for (int i = 0; i < vBp.size(); i++) {
                pv = (PatientVisit)vBp.get(i);
                bpv = setCastPatientVisit(branch_id, st_hospital,bp_i.getDateStart(),bp_i.getDateStart(),"",pv,"close_day");
                vBpv.add(bpv);
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return vBpv;
    }
    public BackTPatientVisit setCastPatientVisit(String branch_id,Statement st, String date_start, 
            String date_end, String patient_import_id,PatientVisit pv, String flag){
        BackTPatientVisit bpv;
        bpv = new BackTPatientVisit();
        bpv.setPatientFullnamet(pv.getPatientNamet());
        bpv.setVisitHn(pv.getPatientHn());
        bpv.setVisitVn(pv.getVisitVn());
        bpv.setVisitDate(pv.getVisitDate());
        bpv.setVisitBeginVisitTime(pv.getVisitTime());
        bpv.setVisitPaidId(pv.getVisitPaidId());
        bpv.setVisitClaimId(pv.getVisitPaidId());
        bpv.setVisitPaidNamet(pv.getVisitPaidNamet());
        bpv.setBServicePointId(pv.getBServerPointId());
        bpv.setContractPayerNumber(pv.getContractPayerNumber());
        bpv.setVisitPatientSelfDoctor(pv.getVisitDoctorId());
        bpv.setVisitPatientAge(pv.getPatientAge());
        bpv.setVisitNotice(pv.getVisitNotice());
        bpv.setVisitClinicDescription(pv.getVisitClinicNamet());
        bpv.setDoctorNamet(pv.getVisitDoctorNamet());
        bpv.setVisitContactId(pv.getVisitContactId());
        bpv.setVisitContactNamet(pv.getVisitContactNamet());

        bpv.setBranchId(branch_id);
        bpv.setSysStatus("A");
        bpv.setSysStatusDoctor("A");
        bpv.setEditStatus("0");
        bpv.setBVisitClinicId(pv.getVisitClinicId());
        bpv.setVisitClaimNamet(pv.getVisitPaidNamet());
        bpv.setTPatientId(pv.getPatientId());
        bpv.setVisitHospitalService(pv.getVisitHospitalService());
        bpv.setVisitDiagnosisNotice(pv.getVisitDiagnosisNotice());
        if (!pv.getVisitFinancialDischargeTime().equals(""))
            bpv.setVisitFinancialDischargeTime(pv.getVisitFinancialDischargeTime());
        else 
            bpv.setVisitFinancialDischargeTime(pv.getVisitDate());
        bpv.setBillingPatientShare(pv.getBillingPatientShare());
        bpv.setBillingPayerShare(pv.getBillingPayerShare());
        bpv.setItemStatusDoctor("0");

        bpv.setVisitPaid(pv.getPaid());
        bpv.setVisitTotal(pv.getAmount());
        bpv.setVisitDiscount(pv.getDiscount());
        service_point = bpvdb.getPatientVisitServicePoint(st, pv.getVisitVn());
        bpv.setBServicePointId(service_point.getBServicePointId());
        bpv.setDepartmentNamet(service_point.getServicePointDescription());
        bpv.setTVisitId(pv.getTVisitId());
        bpv.setTVisitPaymentId(pv.getTVisitPaymentId());
        bpv.setFVisitTypeId(pv.getFVisitTypeId());
        bpv.setContractPlansPttype(pv.getContractPlansPttype());
        bpv.setReceiveNumber(pv.getReceiptNumber());
        bpv.setInvoiceNumber(pv.getInvoiceNumber());
        bpv.setCloseDayId(pv.getCloseDayId());
        bpv.setVisitContactJoinId(pv.getVisitContactJoinId());
        bpv.setVisitContactJoinNamet(pv.getVisitContactJoinNamet());
        bpv.setStatusUnbilling("0");
        bpv.setPatientVisitActive("1");
        if (flag.equals("close_day")){
            bpv.setStatusUnbilling("0");
            bpv.setCloseDayDate(date_start);
            bpv.setPatientImportId(patient_import_id);
        }else if(flag.equals("close_day_unbilling")){
            bpv.setCloseDayDate(date_start);
            bpv.setStatusUnbilling("1");
            bpv.setPatientVisitActive("3");
            bpv.setPatientImportId(patient_import_id);
        }else {
          bpv.setCloseDayDate(date_end);
          bpv.setPatientImportId(patient_import_id);
        }
        
        bpv.setVisitDiscount(pv.getDiscount());
        return bpv;
    }
    public Vector setUpdateDiscount(String branch_id, String date_start, String date_end) {
    String patient_visit_id = ""; String sql = ""; String date_start1 = ""; String date_end1 = ""; String year_start = ""; String year_end = "";
    Vector v_patient_visit = new Vector();
    Vector v_patient_visit_billing = new Vector();
    PatientVisit patient_visit = new PatientVisit();
    PatientVisitPaid patientvisitpaid = new PatientVisitPaid();

    Double discount = 0.0,totalBill=0.0;
    Integer chk = Integer.valueOf(0), total = Integer.valueOf(0), chk1 = Integer.valueOf(0);
    BackTPatientVisit bpv_old = new BackTPatientVisit();
    try{
        bpvdb.branch = bpvdb.config1.getBranch(branch_id);
        Connection conn_bangna = bpvdb.config1.getConnectionBangna();
        Connection conn_update = bpvdb.config1.getConnectionBangna();
        Connection conn_order;
        Connection conn;
        if (bpvdb.branch.getBranchProgram().equals("hospital_osv3")) {
            date_start1 = date_start;
            date_end1 = date_end;
            year_start = date_start1.substring(0, 4);
            year_end = date_end1.substring(0, 4);
            if (Integer.parseInt(year_start) < 2500) {
              date_start1 = String.valueOf(Integer.parseInt(year_start) + 543) + date_start1.substring(4);
            }
            if (Integer.parseInt(year_end) < 2500) {
              date_end1 = String.valueOf(Integer.parseInt(year_end) + 543) + date_end1.substring(4);
            }
            conn = bpvdb.config1.getConnectionHospital(branch_id);
            conn_order = bpvdb.config1.getConnectionHospital(branch_id);
        } else {
            date_start1 = date_start;
            date_end1 = date_end;
            conn = bpvdb.config1.getConnectionMainHIS(branch_id);
            conn_order = bpvdb.config1.getConnectionMainHIS(branch_id);
        }
        Statement st = conn_bangna.createStatement();
        Statement st_update = conn_update.createStatement();
        Statement st_hospital = conn.createStatement();
        Statement st_order = conn_order.createStatement();
//        bpvdb.setUpdatePatientVisitDiscountCloseDay(st_update, branch_id, date_start, Double.valueOf(0.0D));
        v_patient_visit = bpvdb.config1.getPatientVisit(bpvdb.branch, date_start1, date_end1, "", "close_day");
        for (int i = 0; i <= v_patient_visit.size() - 1; i++) {
        patient_visit = (PatientVisit)v_patient_visit.get(i);
        try {
          if (patient_visit.getVisitVn().equals("055012912(1)")) {
            sql = "";
          }
          bpvdb.bpv = new BackTPatientVisit();
          bpvdb.bpv.setPatientFullnamet(patient_visit.getPatientNamet());
          bpvdb.bpv.setVisitHn(patient_visit.getPatientHn());
          bpvdb.bpv.setVisitVn(patient_visit.getVisitVn());
          bpvdb.bpv.setVisitDate(patient_visit.getVisitDate());
          bpvdb.bpv.setVisitBeginVisitTime(patient_visit.getVisitTime());
          bpvdb.bpv.setVisitPaidId(patient_visit.getVisitPaidId());
          bpvdb.bpv.setVisitClaimId(patient_visit.getVisitPaidId());
          bpvdb.bpv.setVisitPaidNamet(patient_visit.getVisitPaidNamet());
          bpvdb.bpv.setBServicePointId(patient_visit.getBServerPointId());
          bpvdb.bpv.setContractPayerNumber(patient_visit.getContractPayerNumber());
          bpvdb.bpv.setVisitPatientSelfDoctor(patient_visit.getVisitDoctorId());
          bpvdb.bpv.setVisitPatientAge(patient_visit.getPatientAge());
          bpvdb.bpv.setVisitNotice(patient_visit.getVisitNotice());
          bpvdb.bpv.setVisitClinicDescription(patient_visit.getVisitClinicNamet());
          bpvdb.bpv.setDoctorNamet(patient_visit.getVisitDoctorNamet());
          bpvdb.bpv.setVisitContactId(patient_visit.getVisitContactId());
          bpvdb.bpv.setVisitContactNamet(patient_visit.getVisitContactNamet());
          if (bpvdb.branch.getBranchProgram().equals("hospital_osv3")) {
            bpvdb.bpv.setVisitPaid(patient_visit.getPaid());
            bpvdb.bpv.setVisitTotal(patient_visit.getAmount());
            bpvdb.bpv.setVisitDiscount(patient_visit.getDiscount());
            service_point = bpvdb.getPatientVisitServicePoint(st_hospital, patient_visit.getVisitVn());
            bpvdb.bpv.setBServicePointId(service_point.getBServicePointId());
            bpvdb.bpv.setDepartmentNamet(service_point.getServicePointDescription());
            bpvdb.bpv.setTVisitId(patient_visit.getTVisitId());
            bpvdb.bpv.setTVisitPaymentId(patient_visit.getTVisitPaymentId());
            bpvdb.bpv.setFVisitTypeId(patient_visit.getFVisitTypeId());
            bpvdb.bpv.setContractPlansPttype(patient_visit.getContractPlansPttype());
            bpvdb.bpv.setReceiveNumber(patient_visit.getReceiptNumber());
            bpvdb.bpv.setInvoiceNumber(patient_visit.getInvoiceNumber());
            bpvdb.bpv.setCloseDayId(patient_visit.getCloseDayId());
            bpvdb.bpv.setVisitContactJoinId(patient_visit.getVisitContactJoinId());
            bpvdb.bpv.setVisitContactJoinNamet(patient_visit.getVisitContactJoinNamet());
            bpvdb.bpv.setCloseDayDate(date_start);
            bpvdb.bpv.setTVisitPaymentId(patient_visit.getTVisitPaymentId());
          }else {
            patientvisitpaid = new PatientVisitPaid();
            patientvisitpaid = bpvdb.config1.getPatientVisitPaidByVn(conn, st, branch_id, patient_visit.getVisitDate(), patient_visit.getPatientHn(), patient_visit.getVisitVn());
            bpvdb.bpv.setVisitPaid(patientvisitpaid.getPaid());
            bpvdb.bpv.setVisitTotal(patientvisitpaid.getAmount());
            bpvdb.bpv.setVisitDiscount(Double.valueOf(0));
            bpvdb.bpv.setDepartmentNamet(patient_visit.getVisitClinicNamet());
            bpvdb.bpv.setFVisitTypeId(patient_visit.getFVisitTypeId());
          }
          bpvdb.bpv.setBranchId(branch_id);
          bpvdb.bpv.setSysStatus("A");
          bpvdb.bpv.setSysStatusDoctor("A");
          bpvdb.bpv.setEditStatus("0");
          bpvdb.bpv.setBVisitClinicId(patient_visit.getVisitClinicId());

          bpvdb.bpv.setVisitClaimNamet(patient_visit.getVisitPaidNamet());

          bpvdb.bpv.setTPatientId(patient_visit.getPatientId());
          bpvdb.bpv.setVisitHospitalService(patient_visit.getVisitHospitalService());
          bpvdb.bpv.setVisitDiagnosisNotice(patient_visit.getVisitDiagnosisNotice());
          if (!patient_visit.getVisitFinancialDischargeTime().equals(""))
            bpvdb.bpv.setVisitFinancialDischargeTime(patient_visit.getVisitFinancialDischargeTime());
          else {
            bpvdb.bpv.setVisitFinancialDischargeTime(patient_visit.getVisitDate());
          }
          bpvdb.bpv.setBillingPatientShare(patient_visit.getBillingPatientShare());
          bpvdb.bpv.setBillingPayerShare(patient_visit.getBillingPayerShare());
          bpvdb.bpv.setItemStatusDoctor("0");
          if (bpvdb.bpv.getVisitHn().equals("535005538")) {
            sql = "";
          }

          if (bpvdb.branch.getBranchProgram().equals("hospital_osv3"))
            v_patient_visit_billing = getPatientVisitBillingInvoice(st_hospital, st_order, bpvdb.branch, date_start1, date_end1, patient_visit.getPatientHn(), patient_visit.getTVisitPaymentId(), "visit_payment_id");
          else {
            v_patient_visit_billing = getPatientVisitBillingInvoice(st_hospital, st_order, bpvdb.branch, date_start1, date_end1, patient_visit.getPatientHn(), patient_visit.getVisitVn(), "visit_payment_id");
          }

          discount = Double.valueOf(0);
          totalBill=0.0;
          for (int j = 0; j <= v_patient_visit_billing.size() - 1; j++) {
            try {
              bpvdb.bpvi = ((BackTPatientVisitItem)v_patient_visit_billing.get(j));
              bpvdb.bpvi.setPatientVisitId(patient_visit_id);
              bpvdb.bpvi.setSysStatus("A");
              bpvdb.bpvi.setEditStatus("0");
              if (bpvdb.bpvi.getItemStatusDoctor().equals("1")) {
//                bpvdb.setUpdatePatientVisitItemStatusDoctor(branch_id, patient_visit_id, bpvdb.bpvi.getItemStatusDoctor());
              }
              if ((bpvdb.bpvi.getBillingInvoiceNumber().equals("9")) || (bpvdb.bpvi.getBillingInvoiceNumber().equals("999")))
                discount = Double.valueOf(discount.doubleValue() + bpvdb.bpvi.getItemTotal().doubleValue());
              else totalBill +=bpvdb.bpvi.getItemTotal().doubleValue();
            } catch (Exception ex){
              Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
//          if (discount.doubleValue() < 0) {
        //            j = total; ex = total = Integer.valueOf(total.intValue() + 1);
//              bpv_old = bpvdb.getBackTPatientVisitByPK(null, st, bpvdb.bpv.getVisitVn(), "visit_vn");
            bpv_old = bpvdb.getBackTPatientVisitByPK(null, st, bpvdb.bpv.getTVisitPaymentId(), "visit_payment_id");
            chk = bpvdb.setUpdatePatientVisitDiscount(st_update, branch_id, bpv_old.getPatientVisitId(), discount);
            bpvdb.setUpdatePatientVisitTotalN(st, branch_id, bpv_old.getPatientVisitId(), totalBill);
            if (chk.intValue() == 0) {
        //              j = chk1; ex = chk1 = Integer.valueOf(chk1.intValue() + 1);
              sql = "";
            }
//          }

        } catch (Exception ex){
          Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        conn.close();
        conn_bangna.close();
        conn_order.close();
        conn_update.close();
        v_patient_visit = bpvdb.getBackTPatientVisit(branch_id, "", "", "patient_import");
    } catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
    }

        return v_patient_visit;
    }
    public void setUpdatePatientVisitTotalFromBpviId(String branchId, String bpviId){
        String sql="";
        Double total=0.0;
        
//        setUpdatePatientVisitTotal
        ResultSet rs;
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            bpvdb.bpvi = bpvdb.getBackTPatientVisitItemByPK(conn, st, bpviId);
            sql = "Select sum(bpvi." + bpvdb.bpvi.getFItemTotal() + ") as paid " + " "
                + "From " + bpvdb.bpvi.getBackTPatientVisitItem() + " as bpvi "
                + "Where bpvi." + bpvdb.bpvi.getFPatientVisitId() + "='" + bpvdb.bpvi.getPatientVisitId() + "' and bpvi." + bpvdb.bpvi.getFBranchId() + "='"+branchId+"' "
                + "and bpvi."+bpvdb.bpvi.getFBillingInvoiceItemActive()+"='1'";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                if(rs.getString("paid")!=null) total = Double.parseDouble(rs.getString("paid"));
                else total=0.0;
            }
            rs.close();
            bpvdb.setUpdatePatientVisitTotal(st, branchId, bpvdb.bpvi.getPatientVisitId(), total);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}