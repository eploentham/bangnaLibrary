package bangnaLibrary;

import com.bangna.object.BackTPatientVisitFundsBilling;
import com.bangna.objdb.BackTDebtorDB;
import com.bangna.objdb.BackTPatientVisitContactDB;
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

public class BackTPatientVisitBillingDB{
    Config1 config1 ;
    private BackTPatientVisitContactBilling bpv_cb = new BackTPatientVisitContactBilling();
    private BackTPatientVisitContactBillingItem bpv_cbi = new BackTPatientVisitContactBillingItem();
    private BackTPatientVisitContact bpv_c = new BackTPatientVisitContact();
    private BackTPatientVisitContactItem bpv_ci = new BackTPatientVisitContactItem();
    private BackTPatientVisitContactDB bpv_cdb = new BackTPatientVisitContactDB();
    private BackTPatientVisitDB bpvdb = new BackTPatientVisitDB();
    private BackTDebtorDB debtordb = new BackTDebtorDB();
    private BackTBillingPayment bp = new BackTBillingPayment();
    private BackTBillingPaymentItem bpi = new BackTBillingPaymentItem();
    private BackTBillingPaymentDB bpdb = new BackTBillingPaymentDB();
    BBranch branch = new BBranch();
    BItem b_item = new BItem();

    VTBillingInvoiceSubgroup vv_t_billing_invoice_subgroup_main = new VTBillingInvoiceSubgroup();

    public BackTPatientVisitBillingDB(Config1 cf){
        config1 = cf;
    }
    public String getMaxRowBackTPatientVisitContactBilling(Connection conn) {
        String sql = "", max = "";
        try {
            Statement st = conn.createStatement();
            sql = "Select max(" + bpv_cb.getFPatientVisitContactBillingId() + ") as cnt From " + bpv_cb.getBackTPatientVisitContactBilling();
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
            Logger.getLogger(BackTPatientVisitBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowBackTPatientVisitContactBillingItem(Connection conn) {
        String sql = "", max = "";
        try{
            Statement st = conn.createStatement();
            sql = "Select max(" + bpv_cbi.getFPatientVisitContactBillingItemId() + ") as cnt " + "From " + bpv_cbi.getBackTPatientVisitContactBillingItem();
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
          Logger.getLogger(BackTPatientVisitBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
  
    public BackTPatientVisitContactBilling getBackTPatientVisitContactBillingByPK(String branch_id, String patient_visit_contact_billing_id){
        String sql = "";
        try {
            bpv_cb = new BackTPatientVisitContactBilling();
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            sql = "Select * From " + bpv_cb.getBackTPatientVisitContactBilling() + " " + "Where " + bpv_cb.getFPatientVisitContactBillingId() + "='" + patient_visit_contact_billing_id + "'";
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpv_cb.setBServicePointId(config1.StringNull(rs.getString(bpv_cb.getFBServicePointId())));
                bpv_cb.setBVisitClinicId(config1.StringNull(rs.getString(bpv_cb.getFBVisitClinicId())));
                bpv_cb.setVisitClaimId(config1.StringNull(rs.getString(bpv_cb.getFVisitClaimId())));
                bpv_cb.setVisitPaidId(config1.StringNull(rs.getString(bpv_cb.getFVisitPaidId())));
                bpv_cb.setPatientFullnamet(config1.StringNull(rs.getString(bpv_cb.getFPatientFullnamet())));

                bpv_cb.setPatientVisitId(config1.StringNull(rs.getString(bpv_cb.getFPatientVisitId())));
                bpv_cb.setTPatientId(config1.StringNull(rs.getString(bpv_cb.getFTPatientId())));
                bpv_cb.setVisitBeginVisitTime(config1.StringNull(rs.getString(bpv_cb.getFVisitBeginVisitTime())));
                bpv_cb.setVisitDate(config1.StringNull(rs.getString(bpv_cb.getFVisitDate())));
                bpv_cb.setVisitDiagnosisNotice(config1.StringNull(rs.getString(bpv_cb.getFVisitDiagnosisNotice())));

                bpv_cb.setVisitFinancialDischargeTime(config1.StringNull(rs.getString(bpv_cb.getFVisitFinancialDischargeTime())));
                bpv_cb.setVisitFirstVisit(config1.StringNull(rs.getString(bpv_cb.getFVisitFirstVisit())));
                bpv_cb.setVisitHn(config1.StringNull(rs.getString(bpv_cb.getFVisitHn())));
                bpv_cb.setVisitHospitalService(config1.StringNull(rs.getString(bpv_cb.getFVisitHospitalService())));
                bpv_cb.setVisitNotice(config1.StringNull(rs.getString(bpv_cb.getFVisitNotice())));

                bpv_cb.setVisitPatientAge(config1.StringNull(rs.getString(bpv_cb.getFVisitPatientAge())));
                bpv_cb.setVisitPatientSelfDoctor(config1.StringNull(rs.getString(bpv_cb.getFVisitPatientSelfDoctor())));
                bpv_cb.setVisitVn(config1.StringNull(rs.getString(bpv_cb.getFVisitVn())));
                bpv_cb.setVisitClaimNamet(config1.StringNull(rs.getString(bpv_cb.getFVisitClaimNamet())));
                bpv_cb.setVisitPaidNamet(config1.StringNull(rs.getString(bpv_cb.getFVisitPaidNamet())));

                bpv_cb.setDepartmentNamet(config1.StringNull(rs.getString(bpv_cb.getFDepartmentNamet())));
                bpv_cb.setDoctorNamet(config1.StringNull(rs.getString(bpv_cb.getFDoctorNamet())));
                bpv_cb.setPatientImportId(config1.StringNull(rs.getString(bpv_cb.getFPatientImportId())));
                bpv_cb.setBranchId(config1.StringNull(rs.getString(bpv_cb.getFBranchId())));
                bpv_cb.setSysStatus(config1.StringNull(rs.getString(bpv_cb.getFSysStatus())));

                bpv_cb.setVisitPaid(Double.valueOf(Double.parseDouble(rs.getString(bpv_cb.getFVisitPaid()))));
                bpv_cb.setVisitTotal(Double.valueOf(Double.parseDouble(rs.getString(bpv_cb.getFVisitTotal()))));
                bpv_cb.setVisitDiscount(Double.valueOf(Double.parseDouble(rs.getString(bpv_cb.getFVisitDiscount()))));
                bpv_cb.setBillingCoverNumber(config1.StringNull(rs.getString(bpv_cb.getFBillingCoverNumber())));
                bpv_cb.setVisitContactId(config1.StringNull(rs.getString(bpv_cb.getFVisitContactId())));

                bpv_cb.setVisitContactNamet(config1.StringNull(rs.getString(bpv_cb.getFVisitContactNamet())));
                bpv_cb.setPatientVisitContactId(config1.StringNull(rs.getString(bpv_cb.getPatientVisitContactId())));
                bpv_cb.setPatientVisitContactBillingActive(config1.StringNull(bpv_cb.getPatientVisitContactBillingActive()));
                bpv_cb.setStatusPrint(config1.StringNull(bpv_cb.getFStatusPrint()));
                bpv_cb.setStatusPayment(config1.StringNull(bpv_cb.getFStatusPayment()));

                bpv_cb.setBillingInvoiceNumber(config1.StringNull(bpv_cb.getFBillingInvoiceNumber()));
                bpv_cb.setPatientVisitContactBillingId(config1.StringNull(bpv_cb.getFPatientVisitContactBillingId()));
                bpv_cb.setSickness(config1.StringNull(bpv_cb.getFSickness()));
                bpv_cb.setInvoiceNumber(config1.StringNull(bpv_cb.getFInvoiceNumber()));
                bpv_cb.setReceiptNumber(config1.StringNull(bpv_cb.getFReceiptNumber()));

                bpv_cb.setVisitTotalBaht(config1.StringNull(bpv_cb.getFVisitTotalBaht()));
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpv_cb;
    }
    public Vector getBackTPatientVisitContactBilling(String branch_id, String patient_visit_contact_billing_id, String where, String paid_id, String flagpage) {
        String sql = "";
        Vector v_bpvcb = new Vector();
        try {
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            if (flagpage.equals("billing_print")) {
                sql = "Select * From " + bpv_cb.getBackTPatientVisitContactBilling() + " " + "Where " + bpv_cb.getFStatusPrint() + "='" + where + "'";
            } else if (flagpage.equals("billing_print_contact_id")) {
                if (paid_id.equals("")) {
                    sql = "Select * From " + bpv_cb.getBackTPatientVisitContactBilling() + " " + "Where " + bpv_cb.getFStatusPrint() + "='" + where + "' and " + bpv_cb.getFVisitContactId() + "='" + patient_visit_contact_billing_id + "' and " + bpv_cb.getFPatientVisitContactBillingActive() + "='1'";
                }else {
                    sql = "Select * From " + bpv_cb.getBackTPatientVisitContactBilling() + " " + "Where " + bpv_cb.getFStatusPrint() + "='" + where + "' and " + bpv_cb.getFVisitContactId() + "='" + patient_visit_contact_billing_id + "' and " + bpv_cb.getFPatientVisitContactBillingActive() + "='1' and " + bpv_cb.getFVisitPaidId() + "='" + paid_id + "'";
                }
            }else{
                sql = "Select * From " + bpv_cb.getBackTPatientVisitContactBilling() + " " + "Where " + bpv_cb.getFPatientVisitContactBillingId() + "='" + patient_visit_contact_billing_id + "'";
            }
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpv_cb = new BackTPatientVisitContactBilling();
                bpv_cb.setBServicePointId(config1.StringNull(rs.getString(bpv_cb.getFBServicePointId())));
                bpv_cb.setBVisitClinicId(config1.StringNull(rs.getString(bpv_cb.getFBVisitClinicId())));
                bpv_cb.setVisitClaimId(config1.StringNull(rs.getString(bpv_cb.getFVisitClaimId())));
                bpv_cb.setVisitPaidId(config1.StringNull(rs.getString(bpv_cb.getFVisitPaidId())));
                bpv_cb.setPatientFullnamet(config1.StringNull(rs.getString(bpv_cb.getFPatientFullnamet())));

                bpv_cb.setPatientVisitId(config1.StringNull(rs.getString(bpv_cb.getFPatientVisitId())));
                bpv_cb.setTPatientId(config1.StringNull(rs.getString(bpv_cb.getFTPatientId())));
                bpv_cb.setVisitBeginVisitTime(config1.StringNull(rs.getString(bpv_cb.getFVisitBeginVisitTime())));
                bpv_cb.setVisitDate(config1.StringNull(rs.getString(bpv_cb.getFVisitDate())));
                bpv_cb.setVisitDiagnosisNotice(config1.StringNull(rs.getString(bpv_cb.getFVisitDiagnosisNotice())));

                bpv_cb.setVisitFinancialDischargeTime(config1.StringNull(rs.getString(bpv_cb.getFVisitFinancialDischargeTime())));
                bpv_cb.setVisitFirstVisit(config1.StringNull(rs.getString(bpv_cb.getFVisitFirstVisit())));
                bpv_cb.setVisitHn(config1.StringNull(rs.getString(bpv_cb.getFVisitHn())));
                bpv_cb.setVisitHospitalService(config1.StringNull(rs.getString(bpv_cb.getFVisitHospitalService())));
                bpv_cb.setVisitNotice(config1.StringNull(rs.getString(bpv_cb.getFVisitNotice())));

                bpv_cb.setVisitPatientAge(config1.StringNull(rs.getString(bpv_cb.getFVisitPatientAge())));
                bpv_cb.setVisitPatientSelfDoctor(config1.StringNull(rs.getString(bpv_cb.getFVisitPatientSelfDoctor())));
                bpv_cb.setVisitVn(config1.StringNull(rs.getString(bpv_cb.getFVisitVn())));
                bpv_cb.setVisitClaimNamet(config1.StringNull(rs.getString(bpv_cb.getFVisitClaimNamet())));
                bpv_cb.setVisitPaidNamet(config1.StringNull(rs.getString(bpv_cb.getFVisitPaidNamet())));

                bpv_cb.setDepartmentNamet(config1.StringNull(rs.getString(bpv_cb.getFDepartmentNamet())));
                bpv_cb.setDoctorNamet(config1.StringNull(rs.getString(bpv_cb.getFDoctorNamet())));
                bpv_cb.setPatientImportId(config1.StringNull(rs.getString(bpv_cb.getFPatientImportId())));
                bpv_cb.setBranchId(config1.StringNull(rs.getString(bpv_cb.getFBranchId())));
                bpv_cb.setSysStatus(config1.StringNull(rs.getString(bpv_cb.getFSysStatus())));

                bpv_cb.setVisitPaid(Double.valueOf(Double.parseDouble(rs.getString(bpv_cb.getFVisitPaid()))));
                bpv_cb.setVisitTotal(Double.valueOf(Double.parseDouble(rs.getString(bpv_cb.getFVisitTotal()))));
                bpv_cb.setVisitDiscount(Double.valueOf(Double.parseDouble(rs.getString(bpv_cb.getFVisitDiscount()))));
                bpv_cb.setBillingCoverNumber(config1.StringNull(rs.getString(bpv_cb.getFBillingCoverNumber())));
                bpv_cb.setVisitContactId(config1.StringNull(rs.getString(bpv_cb.getFVisitContactId())));

                bpv_cb.setVisitContactNamet(config1.StringNull(rs.getString(bpv_cb.getFVisitContactNamet())));
                bpv_cb.setPatientVisitContactId(config1.StringNull(rs.getString(bpv_cb.getFPatientVisitContactId())));
                bpv_cb.setPatientVisitContactBillingActive(config1.StringNull(rs.getString(bpv_cb.getFPatientVisitContactBillingActive())));
                bpv_cb.setStatusPrint(config1.StringNull(rs.getString(bpv_cb.getFStatusPrint())));
                bpv_cb.setStatusPayment(config1.StringNull(rs.getString(bpv_cb.getFStatusPayment())));

                bpv_cb.setBillingInvoiceNumber(config1.StringNull(rs.getString(bpv_cb.getFBillingInvoiceNumber())));
                bpv_cb.setPatientVisitContactBillingId(config1.StringNull(rs.getString(bpv_cb.getFPatientVisitContactBillingId())));
                bpv_cb.setSickness(config1.StringNull(bpv_cb.getFSickness()));
                bpv_cb.setInvoiceNumber(config1.StringNull(bpv_cb.getFInvoiceNumber()));
                bpv_cb.setReceiptNumber(config1.StringNull(bpv_cb.getFReceiptNumber()));

                bpv_cb.setVisitTotalBaht(config1.StringNull(bpv_cb.getFVisitTotalBaht()));

                v_bpvcb.add(bpv_cb);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_bpvcb;
    }
    public BackTPatientVisitContactBillingItem getBackTPatientVisitContactBillingItemByPK(String branch_id, String patient_visit_contact_billing_itemid) {
        String sql = "";
        try {
            bpv_cbi = new BackTPatientVisitContactBillingItem();
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            sql = "Select * From " + bpv_cbi.getBackTPatientVisitContactBillingItem() + " " + "Where " + bpv_cbi.getFPatientVisitContactBillingItemId() + "='" + patient_visit_contact_billing_itemid + "'";
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()){
                bpv_cbi.setBItemBillingSubgroupId(rs.getString(bpv_cbi.getFBItemBillingSubgroupId()));
                bpv_cbi.setBItemId(rs.getString(bpv_cbi.getFBItemId()));
                bpv_cbi.setBillingInvoiceItemActive(rs.getString(bpv_cbi.getFBillingInvoiceItemActive()));
                bpv_cbi.setBillingInvoiceItemTotal(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFBillingInvoiceItemTotal()))));
                bpv_cbi.setBillingInvoiceNumber(rs.getString(bpv_cbi.getFBillingInvoiceNumber()));

                bpv_cbi.setClaimId(rs.getString(bpv_cbi.getFClaimId()));
                bpv_cbi.setClaimNamet(rs.getString(bpv_cbi.getFClaimNamet()));
                bpv_cbi.setDepartmentNamet(rs.getString(bpv_cbi.getFDepartmentNamet()));
                bpv_cbi.setPatientVisitContactItemId(rs.getString(bpv_cbi.getFPatientVisitContactItemId()));
                bpv_cbi.setPatientVisitId(rs.getString(bpv_cbi.getFPatientVisitId()));

                bpv_cbi.setTBillingId(rs.getString(bpv_cbi.getFTBillingId()));
                bpv_cbi.setTBillingInvoiceDateTime(rs.getString(bpv_cbi.getFTBillingInvoiceDateTime()));
                bpv_cbi.setTBillingInvoiceItemId(rs.getString(bpv_cbi.getFTBillingInvoiceItemId()));
                bpv_cbi.setTBillingInvoiceItemNamet(rs.getString(bpv_cbi.getFTBillingInvoiceItemNamet()));
                bpv_cbi.setTBillingInvoiceTime(rs.getString(bpv_cbi.getFTBillingInvoiceTime()));

                bpv_cbi.setTOrderItemId(rs.getString(bpv_cbi.getFTOrderItemId()));
                bpv_cbi.setTPatientId(rs.getString(bpv_cbi.getFTPatientId()));
                bpv_cbi.setTPaymentId(rs.getString(bpv_cbi.getFTPaymentId()));
                bpv_cbi.setVisitId(rs.getString(bpv_cbi.getFVisitId()));
                bpv_cbi.setVisitPatientSelfDoctor(rs.getString(bpv_cbi.getFVisitPatientSelfDoctor()));

                bpv_cbi.setVisitVn(rs.getString(bpv_cbi.getFVisitVn()));
                bpv_cbi.setDepartmentId(rs.getString(bpv_cbi.getFDepartmentId()));
                bpv_cbi.setVisitHn(rs.getString(bpv_cbi.getFVisitHn()));
                bpv_cbi.setBranchId(config1.StringNull(rs.getString(bpv_cbi.getFBranchId())));
                bpv_cbi.setSysStatus(config1.StringNull(rs.getString(bpv_cbi.getFSysStatus())));

                bpv_cbi.setItemDiscount(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFItemDiscount()))));
                bpv_cbi.setItemPaid(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFItemPaid()))));
                bpv_cbi.setItemTotal(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFItemTotal()))));
                bpv_cbi.setEditStatus(config1.StringNull(rs.getString(bpv_cbi.getFEditStatus())));
                bpv_cbi.setRecordStatus(config1.StringNull(rs.getString(bpv_cbi.getFRecordStatus())));

                bpv_cbi.setPatientVisitItemId(config1.StringNull(rs.getString(bpv_cbi.getFPatientVisitItemId())));
                bpv_cbi.setPatientVisitContactId(config1.StringNull(rs.getString(bpv_cbi.getFPatientVisitContactId())));
                bpv_cbi.setPatientVisitContactBillingId(config1.StringNull(rs.getString(bpv_cbi.getFPatientVisitContactBillingId())));
                bpv_cbi.setPatientVisitContactBillingItemActive(config1.StringNull(rs.getString(bpv_cbi.getFPatientVisitContactBillingItemActive())));
                bpv_cbi.setPatientVisitContactBillingItemId(config1.StringNull(rs.getString(bpv_cbi.getFPatientVisitContactBillingItemId())));

                bpv_cbi.setCode(config1.StringNull(rs.getString(bpv_cbi.getFCode())));
                bpv_cbi.setNode(config1.StringNull(rs.getString(bpv_cbi.getFNode())));
                bpv_cbi.setSortLine1(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFSortLine1()))));
                bpv_cbi.setSortLine2(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFSortLine2()))));
                bpv_cbi.setSortLine3(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFSortLine3()))));

                bpv_cbi.setSortLine4(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFSortLine4()))));
                bpv_cbi.setSortLine5(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFSortLine5()))));
                bpv_cbi.setFItemGroupId(config1.StringNull(rs.getString(bpv_cbi.getFFItemGroupId())));
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpv_cbi;
    }
    public Vector getBackTPatientVisitContactBillingItem(String branch_id, String patient_visit_contact_billing_id) {
        String sql = "";
        Vector v_bpvcbi = new Vector();
        try {
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            sql = "Select * From " + bpv_cbi.getBackTPatientVisitContactBillingItem() + " " + "Where " + bpv_cbi.getFPatientVisitContactBillingId() + "='" + patient_visit_contact_billing_id + "'";
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpv_cbi = new BackTPatientVisitContactBillingItem();
                bpv_cbi.setBItemBillingSubgroupId(rs.getString(bpv_cbi.getFBItemBillingSubgroupId()));
                bpv_cbi.setBItemId(rs.getString(bpv_cbi.getFBItemId()));
                bpv_cbi.setBillingInvoiceItemActive(rs.getString(bpv_cbi.getFBillingInvoiceItemActive()));
                bpv_cbi.setBillingInvoiceItemTotal(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFBillingInvoiceItemTotal()))));
                bpv_cbi.setBillingInvoiceNumber(rs.getString(bpv_cbi.getFBillingInvoiceNumber()));

                bpv_cbi.setClaimId(rs.getString(bpv_cbi.getFClaimId()));
                bpv_cbi.setClaimNamet(rs.getString(bpv_cbi.getFClaimNamet()));
                bpv_cbi.setDepartmentNamet(rs.getString(bpv_cbi.getFDepartmentNamet()));
                bpv_cbi.setPatientVisitContactItemId(rs.getString(bpv_cbi.getFPatientVisitContactItemId()));
                bpv_cbi.setPatientVisitId(rs.getString(bpv_cbi.getFPatientVisitId()));

                bpv_cbi.setTBillingId(rs.getString(bpv_cbi.getFTBillingId()));
                bpv_cbi.setTBillingInvoiceDateTime(rs.getString(bpv_cbi.getFTBillingInvoiceDateTime()));
                bpv_cbi.setTBillingInvoiceItemId(rs.getString(bpv_cbi.getFTBillingInvoiceItemId()));
                bpv_cbi.setTBillingInvoiceItemNamet(rs.getString(bpv_cbi.getFTBillingInvoiceItemNamet()));
                bpv_cbi.setTBillingInvoiceTime(rs.getString(bpv_cbi.getFTBillingInvoiceTime()));

                bpv_cbi.setTOrderItemId(rs.getString(bpv_cbi.getFTOrderItemId()));
                bpv_cbi.setTPatientId(rs.getString(bpv_cbi.getFTPatientId()));
                bpv_cbi.setTPaymentId(rs.getString(bpv_cbi.getFTPaymentId()));
                bpv_cbi.setVisitId(rs.getString(bpv_cbi.getFVisitId()));
                bpv_cbi.setVisitPatientSelfDoctor(rs.getString(bpv_cbi.getFVisitPatientSelfDoctor()));

                bpv_cbi.setVisitVn(rs.getString(bpv_cbi.getFVisitVn()));
                bpv_cbi.setDepartmentId(rs.getString(bpv_cbi.getFDepartmentId()));
                bpv_cbi.setVisitHn(rs.getString(bpv_cbi.getFVisitHn()));
                bpv_cbi.setBranchId(config1.StringNull(rs.getString(bpv_cbi.getFBranchId())));
                bpv_cbi.setSysStatus(config1.StringNull(rs.getString(bpv_cbi.getFSysStatus())));

                bpv_cbi.setItemDiscount(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFItemDiscount()))));
                bpv_cbi.setItemPaid(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFItemPaid()))));
                bpv_cbi.setItemTotal(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFItemTotal()))));
                bpv_cbi.setEditStatus(config1.StringNull(rs.getString(bpv_cbi.getFEditStatus())));
                bpv_cbi.setRecordStatus(config1.StringNull(rs.getString(bpv_cbi.getFRecordStatus())));

                bpv_cbi.setPatientVisitItemId(config1.StringNull(rs.getString(bpv_cbi.getFPatientVisitItemId())));
                bpv_cbi.setPatientVisitContactId(config1.StringNull(rs.getString(bpv_cbi.getFPatientVisitContactId())));
                bpv_cbi.setPatientVisitContactBillingId(config1.StringNull(rs.getString(bpv_cbi.getFPatientVisitContactBillingId())));
                bpv_cbi.setPatientVisitContactBillingItemActive(config1.StringNull(rs.getString(bpv_cbi.getFPatientVisitContactBillingItemActive())));
                bpv_cbi.setPatientVisitContactBillingItemId(config1.StringNull(rs.getString(bpv_cbi.getFPatientVisitContactBillingItemId())));

                bpv_cbi.setCode(config1.StringNull(rs.getString(bpv_cbi.getFCode())));
                bpv_cbi.setNode(config1.StringNull(rs.getString(bpv_cbi.getFNode())));
                bpv_cbi.setSortLine1(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFSortLine1()))));
                bpv_cbi.setSortLine2(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFSortLine2()))));
                bpv_cbi.setSortLine3(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFSortLine3()))));

                bpv_cbi.setSortLine4(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFSortLine4()))));
                bpv_cbi.setSortLine5(Double.valueOf(Double.parseDouble(rs.getString(bpv_cbi.getFSortLine5()))));
                bpv_cbi.setFItemGroupId(config1.StringNull(rs.getString(bpv_cbi.getFFItemGroupId())));
                v_bpvcbi.add(bpv_cbi);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_bpvcbi;
    }
  
  
    public BItem getInvoicePrint(Statement st_hospital, String b_item_id1){
        String b_item_id = "", item_number = "", sql = "", item_descriptione = "", space1 = "", len_item_number = "", item_common_name = "";
        try {
            sql = "SELECT b_item_billing_subgroup.item_billing_subgroup_number AS item_number, length(b_item_billing_subgroup.item_billing_subgroup_number::text) AS len_item_number, CASE length(b_item_billing_subgroup.item_billing_subgroup_number::text) WHEN 13 THEN '                          '::text WHEN 12 THEN '                        '::text WHEN 11 THEN '                      '::text WHEN 10 THEN '                    '::text WHEN 9 THEN '                  '::text WHEN 8 THEN '                '::text WHEN 7 THEN '              '::text WHEN 6 THEN '            '::text WHEN 5 THEN '          '::text WHEN 4 THEN '        '::text WHEN 3 THEN '      '::text WHEN 2 THEN '    '::text WHEN 1 THEN '  '::text WHEN 0 THEN ''::text ELSE NULL::text END AS space1, bi.b_item_id, bi.item_common_name, bi.item_descriptione FROM b_item bi1 LEFT JOIN b_item_billing_subgroup ON b_item_billing_subgroup.b_item_billing_subgroup_id::text = bi1.b_item_billing_subgroup_id::text and bi1.item_active = '1'  LEFT JOIN b_item bi ON b_item_billing_subgroup.item_billing_subgroup_number::text = bi.item_number::text AND bi.item_active::text = '0'::text WHERE bi1.b_item_id = '" + b_item_id1 + "' ";
            ResultSet rs_hospital = st_hospital.executeQuery(sql);
            while (rs_hospital.next()) {
                b_item = new BItem();
                item_number = rs_hospital.getString("item_number");
                len_item_number = rs_hospital.getString("len_item_number");
                space1 = rs_hospital.getString("space1");
                b_item_id = rs_hospital.getString("b_item_id");
                item_descriptione = rs_hospital.getString("item_descriptione");
                item_common_name = rs_hospital.getString("item_common_name");
                b_item.setItemDescriptione(config1.StringNull(item_descriptione));
                b_item.setItemNumber(config1.StringNull(item_number));
                b_item.setItemCommonName(config1.StringNull(item_common_name));
                b_item.setBItemId(b_item_id);
                b_item.setItemTradeName(space1);
                b_item.setItemNamet(len_item_number);
            }
            rs_hospital.close();
        }catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b_item;
    }
    public String setSaveBackTPatientVisitContactBilling(String branch_id, BackTPatientVisitContactBilling item) throws Exception {
        int chk = 0;
        String sql = "", max = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            bpv_cb = getBackTPatientVisitContactBillingByPK(branch_id, item.getPatientVisitContactBillingId());
            item.setPatientFullnamet(config1.StringNull(item.getPatientFullnamet()).replace("'", "''"));
            item.setVisitNotice(config1.StringNull(item.getVisitNotice()).replace("'", "''"));
            item.setVisitDiagnosisNotice(config1.StringNull(item.getVisitDiagnosisNotice()).replace("'", "''"));
            if (bpv_cb.getPatientVisitContactBillingId().equals("")) {
                max = getMaxRowBackTPatientVisitContactBilling(conn);
                sql = "Insert Into " + bpv_cb.getBackTPatientVisitContactBilling() 
                        + "(" + bpv_cb.getFPatientVisitContactBillingId() + ", " + bpv_cb.getFBServicePointId() + ", "
                        + bpv_cb.getFBVisitClinicId() + "," + bpv_cb.getFVisitClaimId() + ","
                        + bpv_cb.getFVisitPaidId() + "," + bpv_cb.getFPatientFullnamet() + ","
                        + bpv_cb.getFPatientImportId() + "," + bpv_cb.getFTPatientId() + ","
                        + bpv_cb.getFVisitBeginVisitTime() + "," + bpv_cb.getFVisitDate() + ","
                        + bpv_cb.getFVisitDiagnosisNotice() + "," + bpv_cb.getFVisitFinancialDischargeTime() + ","
                        + bpv_cb.getFVisitFirstVisit() + "," + bpv_cb.getFVisitHn() + ","
                        + bpv_cb.getFVisitHospitalService() + "," + bpv_cb.getFVisitNotice() + ", "
                        + bpv_cb.getFVisitPatientAge() + "," + bpv_cb.getFVisitPatientSelfDoctor() + ", "
                        + bpv_cb.getFVisitVn() + "," + bpv_cb.getFVisitClaimNamet() + ","
                        + bpv_cb.getFVisitPaidNamet() + "," + bpv_cb.getFDepartmentNamet() + ","
                        + bpv_cb.getFDoctorNamet() + "," + bpv_cb.getFBranchId() + ","
                        + bpv_cb.getFSysStatus() + "," + bpv_cb.getFPatientVisitId() + ","
                        + bpv_cb.getFVisitContactId() + "," + bpv_cb.getFVisitContactNamet() + ","
                        + bpv_cb.getFPatientVisitContactBillingActive() + "," + bpv_cb.getFPatientVisitContactId() + ","
                        + bpv_cb.getFStatusPayment() + "," + bpv_cb.getFStatusPrint() + ","
                        + bpv_cb.getFVisitTotal() + "," + bpv_cb.getFVisitPaid() + ","
                        + bpv_cb.getFVisitDiscount() + "," + bpv_cb.getFSickness() + ","
                        + bpv_cb.getFInvoiceNumber() + "," + bpv_cb.getFReceiptNumber() + ","
                        + bpv_cb.getFVisitTotalBaht() + ") "
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
                        + item.getPatientVisitContactBillingActive() + "','" + item.getPatientVisitContactId() + "','"
                        + item.getStatusPayment() + "','" + item.getStatusPrint() + "',"
                        + item.getVisitTotal() + "," + item.getVisitPaid() + ","
                        + item.getVisitDiscount() + ",'" + item.getSickness() + "','"
                        + item.getInvoiceNumber() + "','" + item.getReceiptNumber() + "','"
                        + item.getVisitTotalBaht() + "')";
            }else{
                sql = "Update " + bpv_cb.getBackTPatientVisitContactBilling() 
                        + " set " + bpv_cb.getFBServicePointId() + " = '" + item.getBServicePointId() + "', "
                        + bpv_cb.getFBVisitClinicId() + " = '" + item.getBVisitClinicId() + "', "
                        + bpv_cb.getFVisitClaimId() + " = '" + item.getVisitClaimId() + "', "
                        + bpv_cb.getFVisitPaidId() + " = '" + item.getVisitPaidId() + "', "
                        + bpv_cb.getFPatientFullnamet() + " = '" + item.getPatientFullnamet() + "', "
                        + bpv_cb.getFPatientImportId() + " = '" + item.getPatientImportId() + "', "
                        + bpv_cb.getFTPatientId() + " = '" + item.getTPatientId() + "', "
                        + bpv_cb.getFVisitBeginVisitTime() + " = '" + item.getVisitBeginVisitTime() + "', "
                        + bpv_cb.getFVisitDate() + " = '" + item.getVisitDate() + "', "
                        + bpv_cb.getFVisitDiagnosisNotice() + " = '" + item.getVisitDiagnosisNotice() + "',"
                        + bpv_cb.getFVisitFinancialDischargeTime() + " = '" + item.getVisitFinancialDischargeTime() + "',"
                        + bpv_cb.getFVisitFirstVisit() + " = '" + item.getVisitFirstVisit() + "', "
                        + bpv_cb.getFVisitHn() + " = '" + item.getVisitHn() + "', "
                        + bpv_cb.getFVisitHospitalService() + " = '" + item.getVisitHospitalService() + "', "
                        + bpv_cb.getFVisitNotice() + " = '" + item.getVisitNotice() + "', "
                        + bpv_cb.getFVisitPatientAge() + " = " + item.getVisitPatientAge() + ", "
                        + bpv_cb.getFVisitPatientSelfDoctor() + " = '" + item.getVisitPatientSelfDoctor() + "', "
                        + bpv_cb.getFVisitVn() + " = '" + item.getVisitVn() + "', "
                        + bpv_cb.getFVisitClaimNamet() + " = '" + item.getVisitClaimNamet() + "', "
                        + bpv_cb.getFVisitPaidNamet() + " = '" + item.getVisitPaidNamet() + "', "
                        + bpv_cb.getFDepartmentNamet() + " = '" + item.getDepartmentNamet() + "', "
                        + bpv_cb.getFDoctorNamet() + " = '" + item.getDoctorNamet() + ", "
                        + bpv_cb.getFBranchId() + " = '" + item.getBranchId() + "', "
                        + bpv_cb.getFSysStatus() + " = '" + item.getSysStatus() + "', "
                        + bpv_cb.getFPatientVisitId() + " = '" + item.getPatientVisitId() + "', "
                        + bpv_cb.getFVisitContactId() + " = '" + item.getVisitContactId() + "', "
                        + bpv_cb.getFVisitContactNamet() + " = '" + item.getVisitContactNamet() + "', "
                        + bpv_cb.getFPatientVisitContactBillingActive() + " = '" + item.getPatientVisitContactBillingActive() + "', "
                        + bpv_cb.getFVisitTotal() + " = " + item.getVisitTotal() + ", "
                        + bpv_cb.getFVisitPaid() + " = " + item.getVisitPaid() + ", "
                        + bpv_cb.getFVisitDiscount() + " = " + item.getVisitDiscount() + ", "
                        + bpv_cb.getFBillingCoverNumber() + " = '" + item.getBillingCoverNumber() + "', "
                        + bpv_cb.getFBillingInvoiceNumber() + " = '" + item.getBillingInvoiceNumber() + "', "
                        + bpv_cb.getFStatusPayment() + " = '" + item.getStatusPayment() + "', "
                        + bpv_cb.getFStatusPrint() + " = '" + item.getStatusPrint() + "', "
                        + bpv_cb.getFSickness() + " = '" + item.getSickness() + "', "
                        + bpv_cb.getFInvoiceNumber() + " = '" + item.getInvoiceNumber() + "', "
                        + bpv_cb.getFReceiptNumber() + " = '" + item.getReceiptNumber() + "', "
                        + bpv_cb.getFVisitTotalBaht() + " = '" + item.getVisitTotalBaht() + "' "
                        + "Where " + bpv_cb.getFPatientVisitContactBillingId() + " = '" + item.getPatientVisitContactBillingId() + "'";
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
    public String setSaveBackTPatientVisitContactBillingItem(String branch_id, BackTPatientVisitContactBillingItem item) throws Exception {
        int chk = 0;
        String sql = "", max = "";
        try{
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            bpv_cbi = getBackTPatientVisitContactBillingItemByPK(branch_id, item.getPatientVisitContactBillingItemId());

            if (bpv_cbi.getPatientVisitContactBillingItemId().equals("")) {
            max = getMaxRowBackTPatientVisitContactBillingItem(conn);
            sql = "Insert Into " + bpv_cbi.getBackTPatientVisitContactBillingItem()
                + "(" + bpv_cbi.getFPatientVisitContactBillingItemId() + ", " + bpv_cbi.getFBItemBillingSubgroupId() + ", "
                + bpv_cbi.getFBItemId() + "," + bpv_cbi.getFBillingInvoiceItemActive() + ","
                + bpv_cbi.getFBillingInvoiceItemTotal() + "," + bpv_cbi.getFBillingInvoiceNumber() + ","
                + bpv_cbi.getFClaimId() + "," + bpv_cbi.getFClaimNamet() + ","
                + bpv_cbi.getFDepartmentId() + "," + bpv_cbi.getFDepartmentNamet() + ","
                + bpv_cbi.getFPatientVisitId() + "," + bpv_cbi.getFTBillingId() + ","
                + bpv_cbi.getFPatientVisitItemId() + "," + bpv_cbi.getFTBillingInvoiceDateTime() + ","
                + bpv_cbi.getFTBillingInvoiceItemId() + "," + bpv_cbi.getFTBillingInvoiceItemNamet() + ", "
                + bpv_cbi.getFTBillingInvoiceTime() + "," + bpv_cbi.getFTOrderItemId() + ", "
                + bpv_cbi.getFTPatientId() + "," + bpv_cbi.getFTPaymentId() + ","
                + bpv_cbi.getFVisitHn() + "," + bpv_cbi.getFVisitId() + ","
                + bpv_cbi.getFVisitPatientSelfDoctor() + "," + bpv_cbi.getFVisitVn() + ","
                + bpv_cbi.getFBranchId() + "," + bpv_cbi.getFSysStatus() + ","
                + bpv_cbi.getFItemDiscount() + "," + bpv_cbi.getFItemPaid() + ","
                + bpv_cbi.getFItemTotal() + "," + bpv_cbi.getFEditStatus() + ","
                + bpv_cbi.getFPatientVisitContactId() + "," + bpv_cbi.getFPatientVisitContactItemId() + ","
                + bpv_cbi.getFPatientVisitContactBillingItemActive() + "," + bpv_cbi.getFPatientVisitContactBillingId() + ","
                + bpv_cbi.getFRecordStatus() + "," + bpv_cbi.getFCode() + ","
                + bpv_cbi.getFNode() + "," + bpv_cbi.getFSortLine1() + ","
                + bpv_cbi.getFSortLine2() + "," + bpv_cbi.getFSortLine3() + ","
                + bpv_cbi.getFSortLine4() + "," + bpv_cbi.getFSortLine5() + ","
                + bpv_cbi.getFFItemGroupId() + ") "
                + "Values('" + max + "','" + item.getBItemBillingSubgroupId() + "','"
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
            sql = "Update " + bpv_cbi.getBackTPatientVisitContactBillingItem()
                    + " set " + bpv_cbi.getFBItemBillingSubgroupId() + " = '" + item.getBItemBillingSubgroupId() + "', "
                    + bpv_cbi.getFBItemId() + " = '" + item.getBItemId() + "', "
                    + bpv_cbi.getFBillingInvoiceItemActive() + " = '" + item.getBillingInvoiceItemActive() + "', "
                    + bpv_cbi.getFBillingInvoiceItemTotal() + " = '" + item.getBillingInvoiceItemTotal() + "', "
                    + bpv_cbi.getFBillingInvoiceNumber() + " = '" + item.getBillingInvoiceNumber() + "', "
                    + bpv_cbi.getFClaimId() + " = '" + item.getClaimId() + "', "
                    + bpv_cbi.getFClaimNamet() + " = '" + item.getClaimNamet() + "', "
                    + bpv_cbi.getFDepartmentId() + " = '" + item.getDepartmentId() + "', "
                    + bpv_cbi.getFDepartmentNamet() + " = '" + item.getDepartmentNamet() + "', "
                    + bpv_cbi.getFPatientVisitId() + " = '" + item.getPatientVisitId() + "',"
                    + bpv_cbi.getFTBillingId() + " = '" + item.getTBillingId() + "',"
                    + bpv_cbi.getFTBillingInvoiceDateTime() + " = " + item.getTBillingInvoiceDateTime() + ", "
                    + bpv_cbi.getFTBillingInvoiceItemId() + " = " + item.getTBillingInvoiceItemId() + ", "
                    + bpv_cbi.getFTBillingInvoiceItemNamet() + " = " + item.getTBillingInvoiceItemNamet() + ", "
                    + bpv_cbi.getFTBillingInvoiceTime() + " = " + item.getTBillingInvoiceTime() + ", "
                    + bpv_cbi.getFTOrderItemId() + " = " + item.getTOrderItemId() + ", "
                    + bpv_cbi.getFTPatientId() + " = " + item.getTPatientId() + ", "
                    + bpv_cbi.getFVisitId() + " = " + item.getVisitId() + ", "
                    + bpv_cbi.getFVisitHn() + " = " + item.getVisitHn() + ", "
                    + bpv_cbi.getFDepartmentNamet() + " = " + item.getDepartmentNamet() + ", "
                    + bpv_cbi.getFVisitPatientSelfDoctor() + " = " + item.getVisitPatientSelfDoctor() + ", "
                    + bpv_cbi.getFVisitVn() + " = " + item.getVisitVn() + ", "
                    + bpv_cbi.getFBranchId() + " = " + item.getBranchId() + ", "
                    + bpv_cbi.getFSysStatus() + " = " + item.getSysStatus() + ", "
                    + bpv_cbi.getFItemDiscount() + " = " + item.getItemDiscount() + ", "
                    + bpv_cbi.getFItemPaid() + " = " + item.getItemPaid() + ", "
                    + bpv_cbi.getFItemTotal() + " = " + item.getItemTotal() + ", "
                    + bpv_cbi.getFEditStatus() + " = '" + item.getEditStatus() + "', "
                    + bpv_cbi.getFPatientVisitContactId() + " = '" + item.getPatientVisitContactId() + "', "
                    + bpv_cbi.getFPatientVisitContactBillingItemActive() + " = '" + item.getPatientVisitContactId() + "', "
                    + bpv_cbi.getFPatientVisitContactBillingId() + " = '" + item.getPatientVisitContactBillingId() + "', "
                    + bpv_cbi.getFRecordStatus() + " = '" + item.getRecordStatus() + "', "
                    + bpv_cbi.getFCode() + " = '" + item.getCode() + "', "
                    + bpv_cbi.getFNode() + " = '" + item.getNode() + "', "
                    + bpv_cbi.getFSortLine1() + " = " + item.getSortLine1() + ", "
                    + bpv_cbi.getFSortLine2() + " = " + item.getSortLine2() + ", "
                    + bpv_cbi.getFSortLine3() + " = " + item.getSortLine3() + ", "
                    + bpv_cbi.getFSortLine4() + " = " + item.getSortLine4() + ", "
                    + bpv_cbi.getFSortLine5() + " = " + item.getSortLine5() + ", "
                    + bpv_cbi.getFFItemGroupId() + " = '" + item.getFItemGroupId() + "' "
                    + "Where " + bpv_cbi.getFPatientVisitContactItemId() + " = '" + item.getPatientVisitContactItemId() + "'";

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
  
    public BackTPatientVisitContactBillingItem getMainBItem(Statement st, String invoice_number, String flagLanguage)  {
        BackTPatientVisitContactBillingItem bpvcbi1 = new BackTPatientVisitContactBillingItem();
        String space1 = "";
        String[] node1 = invoice_number.split("\\.");
        b_item = getBItemSubGroup(st, invoice_number);
        if (invoice_number.equals("1.1.12.6")) {
          space1 = "";
        }
        if (!b_item.getItemNumber().equals("")) {
            if (node1.length == 0)
                space1 = "";
            else if (node1.length == 1)
                space1 = "  ";
            else if (node1.length == 2)
                space1 = "    ";
            else if (node1.length == 3)
                space1 = "      ";
            else if (node1.length == 4)
                space1 = "          ";
            else if (node1.length == 5) {
                space1 = "            ";
            }
            if (flagLanguage.equals("thai"))
                bpvcbi1.setTBillingInvoiceItemNamet(b_item.getItemCommonName());
            else {
                bpvcbi1.setTBillingInvoiceItemNamet(b_item.getItemDescriptione());
            }
            bpvcbi1.setVisitPatientSelfDoctor(space1);
            bpvcbi1.setCode(b_item.getItemNumber());
            bpvcbi1.setSpace1(space1);
        }
        return bpvcbi1;
    }
    
    public BItem getBItemSubGroup(Statement st, String item_number) {
        String sql = "";
        sql = "Select item_billing_subgroup_number, item_billing_subgroup_description,item_billing_subgroup_descriptione "
                + "From b_item_billing_subgroup "
                + "Where item_billing_subgroup_number = '" + item_number + "' and item_billing_subgroup_active = '1'";
        try{
            b_item = new BItem();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                b_item = new BItem();
                b_item.setItemNumber(rs.getString("item_billing_subgroup_number"));
                b_item.setItemCommonName(rs.getString("item_billing_subgroup_description"));
                b_item.setItemDescriptione(rs.getString("item_billing_subgroup_descriptione"));
            }
            rs.close();
        }catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b_item;
    }
  public String setSaveBilling(String branch_id, String data, String sub_system, String flag) {
    Boolean chk = false;
    String patient_visit_contact_billing_item_id = "", node = "", flagLanguage = "", bpv_c_id = "", patient_visit_contact_billing_id = "", error = "";
    String doc_number="", date_current="";
    Integer len = 8, len_data = 0, cut = 0;
    Double total = 0.0, discount = 0.0;

    Vector v_billing_item = new Vector();
    Vector v_save = new Vector();
    BackTPatientVisit bpv = new BackTPatientVisit();
    BackTPatientVisitContactBillingItem bpvcbi_save = new BackTPatientVisitContactBillingItem();
    BackTPatientVisitContactBillingItem bpvcbi_node_head = new BackTPatientVisitContactBillingItem();
    CashierTBillingInvoicePrintDB cbi_db = new CashierTBillingInvoicePrintDB(config1);
    CashierTBillingInvoicePrint cbi = new CashierTBillingInvoicePrint();
    BDocNumberDB doc_numberdb = new BDocNumberDB();
    try {
      flagLanguage = "thai";
      Connection conn_BItem = config1.getConnectionHospital(branch_id);
      Connection conn_bangna = config1.getConnectionBangna();
      Connection conn_hospital = config1.getConnectionHospital(branch_id);
      Statement st_BItem = conn_BItem.createStatement();
      Statement st_bangna = conn_bangna.createStatement();
      Statement st_hospital = conn_hospital.createStatement();
      len_data = Integer.valueOf(data.length());
      String[] aaa = data.split("\\.");
      date_current = config1.getDateDB("yyyyMMdd");
      for (int i = 0; i <= aaa.length - 1; i++) {
        try {
          bpv_c_id = aaa[i];
          if (bpv_c_id.length() <= 0) {
            continue;
          }
          //1.1.7.1.47
          error = "001 i=" + i;
          total = Double.valueOf(0.0D);
          discount = Double.valueOf(0.0D);
//          if (sub_system.equals("contact")) {
            bpv_c = bpv_cdb.getBackTPatientVisitContactByPK(st_bangna,branch_id, bpv_c_id, "");
            bpv_cb = bpv_cdb.setCastPatientVisitContactBilling(bpv_c);
            patient_visit_contact_billing_id = setSaveBackTPatientVisitContactBilling(branch_id, bpv_cb);
            v_billing_item = bpv_cdb.getBackTPatientVisitContactItem(branch_id, bpv_c_id, "billing_item");
            for (int j = 0; j <= v_billing_item.size() - 1; j++) {
              bpv_ci = new BackTPatientVisitContactItem();
              bpv_ci = ((BackTPatientVisitContactItem)v_billing_item.get(j));
              bpv_cbi = bpv_cdb.setCastPatientVisitContactBillingItem(bpv_ci);
              bpv_cbi.setPatientVisitContactBillingId(patient_visit_contact_billing_id);
              bpv_cbi.setPatientVisitContactId(bpv_cb.getPatientVisitContactId());
              bpv_cbi.setPatientVisitContactBillingItemActive("1");
              bpv_cbi.setNode("1");
              total = Double.valueOf(total.doubleValue() + bpv_cbi.getItemTotal().doubleValue());
              v_save.add(bpv_cbi);
            }
            setUpdatePatientVisitContactBillingTotalBaht(branch_id, patient_visit_contact_billing_id, total, discount, Config1.readCurrencyInThai(total.doubleValue() - discount.doubleValue(), "บาทถ้วน", "สตางค์"));
            if (!flag.equals("print_preview")) {
                debtordb.setSaveDebtor(branch_id, "", "", bpv_cb.getVisitTotal(), bpv_cb.getVisitDate(), "", "", 
                        bpv_cb.getVisitContactId(), bpv_cb.getVisitBeginVisitTime());
            }
          bpv_cb.setStatusPayment("1");
          bpv_cb.setStatusPrint("1");
          
          v_billing_item = (Vector)v_save.clone();
          error = "002";
          for (int j = 0; j <= v_billing_item.size() - 1; j++) {
            bpv_cbi = new BackTPatientVisitContactBillingItem();
            bpv_cbi = ((BackTPatientVisitContactBillingItem)v_billing_item.get(j));

            b_item = getInvoicePrint(st_hospital, bpv_cbi.getBItemId());

            error = "002.1 i=" + i + " j = " + j;
            if (b_item.getItemCommonName().equals(""));
            bpv_cbi.setTBillingInvoiceItemNamet(b_item.getItemCommonName().trim());

            error = "002.2 i=" + i + " j = " + j;
            bpv_cbi.setCode(b_item.getItemNumber().trim());
            bpv_cbi.setSpace1(b_item.getItemTradeName());
            String[] node1 = bpv_cbi.getCode().split("\\.");
            setSortLine(bpv_cbi, node1);

            error = "002.3 i=" + i + " j = " + j;
            node = "";
            for (int ii = 0; ii <= node1.length - 2; ii++) {
              node = node + node1[ii] + ".";
            }
            error = "002 i=" + i + " j = " + j + " node " + node;
            if ((node.length() > 0) && (node.substring(node.length() - 1).equals("."))) {
              node = node.substring(0, node.length() - 1);
            }
            bpvcbi_node_head = getMainBItem(st_BItem, node, flagLanguage);
            error = "0021 i=" + i + " j = " + j;
            if (bpvcbi_node_head.getCode().length() > 0) {
              bpvcbi_node_head.setNode("2");
              bpvcbi_node_head.setPatientVisitContactBillingItemActive("1");
              error = "022 i=" + i + " j = " + j;
              setNodeHead(bpvcbi_node_head, bpv_cbi);
              error = "023 i=" + i + " j = " + j;
              chk = Boolean.valueOf(false);
              for (int ii = 0; ii <= v_save.size() - 1; ii++) {
                bpvcbi_save = new BackTPatientVisitContactBillingItem();
                bpvcbi_save = (BackTPatientVisitContactBillingItem)v_save.get(ii);
                if (bpvcbi_save.getCode().equals(bpvcbi_node_head.getCode())) {
                  chk = Boolean.valueOf(true);
                  break;
                }
              }
              error = "003 i=" + i + " j = " + j;
              if (!chk.booleanValue()) {
                node1 = bpvcbi_node_head.getCode().split("\\.");
                setSortLine(bpvcbi_node_head, node1);
                v_save.add(bpvcbi_node_head);
              }

              node = "";
              for (int ii = 0; ii <= node1.length - 2; ii++) {
                node = node + node1[ii] + ".";
              }
              if ((node.length() > 0) && (node.substring(node.length() - 1).equals("."))) {
                node = node.substring(0, node.length() - 1);
              }
              bpvcbi_node_head = getMainBItem(st_BItem, node, flagLanguage);
              if (bpvcbi_node_head.getCode().length() > 0) {
                bpvcbi_node_head.setNode("3");
                bpvcbi_node_head.setPatientVisitContactBillingItemActive("1");
                setNodeHead(bpvcbi_node_head, bpv_cbi);
                error = "004 i=" + i + " j = " + j;
                chk = Boolean.valueOf(false);
                for (int ii = 0; ii <= v_save.size() - 1; ii++) {
                  bpvcbi_save = new BackTPatientVisitContactBillingItem();
                  bpvcbi_save = (BackTPatientVisitContactBillingItem)v_save.get(ii);
                  if (bpvcbi_save.getCode().equals(bpvcbi_node_head.getCode())) {
                    chk = Boolean.valueOf(true);
                    break;
                  }
                }
                if (!chk.booleanValue()) {
                  node1 = bpvcbi_node_head.getCode().split("\\.");
                  setSortLine(bpvcbi_node_head, node1);
                  v_save.add(bpvcbi_node_head);
                }
                error = "005 i=" + i + " j = " + j;

                node = "";
                for (int ii = 0; ii <= node1.length - 2; ii++) {
                  node = node + node1[ii] + ".";
                }
                if ((node.length() > 0) && (node.substring(node.length() - 1).equals("."))) {
                  node = node.substring(0, node.length() - 1);
                }
                bpvcbi_node_head = getMainBItem(st_BItem, node, flagLanguage);
                error = "006 i=" + i + " j = " + j;
                if (bpvcbi_node_head.getCode().length() > 0) {
                  bpvcbi_node_head.setNode("4");
                  bpvcbi_node_head.setPatientVisitContactBillingItemActive("1");
                  setNodeHead(bpvcbi_node_head, bpv_cbi);
                  chk = Boolean.valueOf(false);
                  for (int ii = 0; ii <= v_save.size() - 1; ii++) {
                    bpvcbi_save = new BackTPatientVisitContactBillingItem();
                    bpvcbi_save = (BackTPatientVisitContactBillingItem)v_save.get(ii);
                    if (bpvcbi_save.getCode().equals(bpvcbi_node_head.getCode())) {
                      chk = Boolean.valueOf(true);
                      break;
                    }
                  }
                  error = "007 i=" + i + " j = " + j;
                  if (!chk.booleanValue()) {
                    node1 = bpvcbi_node_head.getCode().split("\\.");
                    setSortLine(bpvcbi_node_head, node1);
                    v_save.add(bpvcbi_node_head);
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
                  bpvcbi_node_head = getMainBItem(st_BItem, node, flagLanguage);
                  error = "008 i=" + i + " j = " + j;
                  if (bpvcbi_node_head.getCode().length() > 0) {
                    bpvcbi_node_head.setNode("5");
                    bpvcbi_node_head.setPatientVisitContactBillingItemActive("1");
                    setNodeHead(bpvcbi_node_head, bpv_cbi);
                    chk = Boolean.valueOf(false);
                    error = "009 i=" + i + " j = " + j;
                    for (int ii = 0; ii <= v_save.size() - 1; ii++) {
                      bpvcbi_save = new BackTPatientVisitContactBillingItem();
                      bpvcbi_save = (BackTPatientVisitContactBillingItem)v_save.get(ii);
                      if (bpvcbi_save.getCode().equals(bpvcbi_node_head.getCode())) {
                        chk = Boolean.valueOf(true);
                        break;
                      }
                    }
                    if (!chk.booleanValue()) {
                      node1 = bpvcbi_node_head.getCode().split("\\.");
                      setSortLine(bpvcbi_node_head, node1);
                      v_save.add(bpvcbi_node_head);
                    }
                  }
                }
              }
            }
          }
          error = "010 ";
//          setSavePatientVisitStatusBilling(branch_id, sub_system, patient_visit_contact_id,doc_number);
          for (int j = 0; j <= v_save.size() - 1; j++) {
            bpv_cbi = new BackTPatientVisitContactBillingItem();
            bpv_cbi = ((BackTPatientVisitContactBillingItem)v_save.get(j));
            bpv_cbi.setCode(bpv_cbi.getSpace1() + bpv_cbi.getCode());

            if (sub_system.equals("contact")) {
              patient_visit_contact_billing_item_id = setSaveBackTPatientVisitContactBillingItem(branch_id, bpv_cbi);
            } else {
//              bpv_fbi = bpv_fdb.setCastPatientVisitFundsBillingItem(bpv_cbi);
//              patient_visit_contact_billing_item_id = setSaveBackTPatientVisitFundsBillingItem(branch_id, bpv_fbi);
            }
          }
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn_BItem.close();
        conn_bangna.close();;
        conn_hospital.close();;
      }
    }catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitBillingDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return patient_visit_contact_billing_id;
  }
    
    private void setSortLine(BackTPatientVisitContactBillingItem bpvcbi, String[] node1) {
        try {
            for (int k = 0; k <= node1.length - 1; k++) {
            if (k == 0) {
              if ((node1[k] != null) && (!node1[k].equals("")))
                bpvcbi.setSortLine1(Double.valueOf(Double.parseDouble(node1[k])));
              else
                bpvcbi.setSortLine1(Double.valueOf(0.0D));
            }
            else if (k == 1) {
              if ((node1[k] != null) && (!node1[k].equals("")))
                bpvcbi.setSortLine2(Double.valueOf(Double.parseDouble(node1[k])));
              else {
                bpvcbi.setSortLine2(Double.valueOf(0.0D));
              }
            }
            if (k == 2) {
              if ((node1[k] != null) && (!node1[k].equals("")))
                bpvcbi.setSortLine3(Double.valueOf(Double.parseDouble(node1[k])));
              else {
                bpvcbi.setSortLine3(Double.valueOf(0.0D));
              }
            }
            if (k == 3) {
              if ((node1[k] != null) && (!node1[k].equals("")))
                bpvcbi.setSortLine4(Double.valueOf(Double.parseDouble(node1[k])));
              else {
                bpvcbi.setSortLine4(Double.valueOf(0.0D));
              }
            }
            if (k == 4)
              if ((node1[k] != null) && (!node1[k].equals("")))
                bpvcbi.setSortLine5(Double.valueOf(Double.parseDouble(node1[k])));
              else
                bpvcbi.setSortLine5(Double.valueOf(0.0D));
            }
        }catch (Exception ex){
          Logger.getLogger(BackTPatientVisitBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    private void setNodeHead(BackTPatientVisitContactBillingItem bpvcbi_node_head, BackTPatientVisitContactBillingItem bpvcbi){
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
  
    public void setUpdateBillingInvoiceNumberCoverNumber(String branch_id, String cover_id, String doc_number, String patient_visit_contact_billing_id, String subsystem) {
        String sql = "";
        try{
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            if (subsystem.equals("contact")) {
                sql = "Update " + bpv_cb.getBackTPatientVisitContactBilling() + " "
                    + "Set " + bpv_cb.getFBillingInvoiceNumber() + "='" + doc_number + "', "
                    + bpv_cb.getFBillingCoverNumber() + "='" + cover_id + "',"
                    + bpv_cb.getFStatusPrint() + "='2' "
                    + "Where " + bpv_cb.getFPatientVisitContactBillingId() + "='" + patient_visit_contact_billing_id + "' and "
                    + bpv_cb.getFBranchId() + "='" + branch_id + "' ";
            }
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  public String getTrBillingInvoice() {
    String txt = "";
    Vector v_cover = new Vector();

    return txt;
  }
    public void setUpdatePatientVisitContactBillingTotalBaht(String branch_id, String patient_visit_contact_billing_id, Double total, Double discount, String total_baht) {
        String sql = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpv_cb.getBackTPatientVisitContactBilling() + " " 
                    + "Set " + bpv_cb.getFVisitTotalBaht() + "='" + total_baht + "', "
                    + bpv_cb.getFVisitTotal() + "=" + total + ", "
                    + bpv_cb.getFVisitDiscount() + "=" + discount + ", "
                    + bpv_cb.getFVisitPaid() + "=" + (total.doubleValue() + discount.doubleValue()) + " "
                    + "Where " + bpv_cb.getFPatientVisitContactBillingId() + "='" + patient_visit_contact_billing_id + "' and "
                    + bpv_cb.getFBranchId() + "='" + branch_id + "' ";

            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void setUpdatePatientVisitFundsBillingTotalBaht(String branch_id, String patient_visit_funds_billing_id, Double total, Double discount, String total_baht) {
//        String sql = "";
//        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement st = conn.createStatement();
//            sql = "Update " + bpv_fb.getBackTPatientVisitFundsBilling() + " "
//                    + "Set " + bpv_fb.getFVisitTotalBaht() + "='" + total_baht + "', "
//                    + bpv_fb.getFVisitTotal() + "=" + total + ", "
//                    + bpv_fb.getFVisitDiscount() + "=" + discount + ", "
//                    + bpv_fb.getFVisitPaid() + "=" + (total.doubleValue() + discount.doubleValue()) + " "
//                    + "Where " + bpv_fb.getFPatientVisitFundsBillingId() + "='" + patient_visit_funds_billing_id + "' and "
//                    + bpv_fb.getFBranchId() + "='" + branch_id + "' ";
//
//            st.executeUpdate(sql);
//            conn.close();
//        } catch (Exception ex) {
//            Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
  
//    public void setUpdateBackTPatientVisitStatusPayment(String branch_id, String billing_payment_number) {
//        String sql = "";
//        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement st = conn.createStatement();
//            sql = "Update "+bpv_fb.getBackTPatientVisitFundsBilling()+" Set "+bpv_fb.getFStatusPayment()+"  = '2' "
//              + "Where "+bpv_fb.getBillingInvoiceNumber() +"='"+billing_payment_number+"'";
//            st.executeUpdate(sql);
//            conn.close();
//        } catch (Exception ex) {
//            Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    public void setCastBillingPayment(BackTPatientVisitFundsBilling bpv_fb){
        bp.setBBankId("");
        bp.setBTransferId("144011");
        bp.setBillingPaymentActive("1");
        bp.setBillingPaymentDate("");
        bp.setBillingPaymentId("");
        bp.setBillingPaymentNumber("");
        bp.setChequeNumber("");
        bp.setDescription("");
        //        bp.set
    }
}