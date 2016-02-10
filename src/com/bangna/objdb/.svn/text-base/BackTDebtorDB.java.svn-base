package com.bangna.objdb;

import bangnaLibrary.BackTBillingPaymentDB;
import bangnaLibrary.BackTDebtor;
import bangnaLibrary.Config1;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BackTDebtorDB {
    Config1 config1;
    BackTDebtor debtor;
    String idtable="187";

    public BackTDebtorDB(){
        config1 = new Config1();
        initConfig(config1);
    }
    public BackTDebtorDB(Config1 cf){
        config1 = cf;
        initConfig(config1);
    }
    public void initConfig(Config1 cf){
        debtor = new BackTDebtor();
    }
        
    public String getMaxRowBackTDebtor(Connection conn) {
        String sql = ""; String max = "";
        try {
            Statement st = conn.createStatement();
            sql = "Select max(" + debtor.getFDebtorId() + ") as cnt From " + debtor.getBackTDebtor();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))
                max = String.valueOf(Integer.parseInt(max) + 1);
            else
                max = "1870000001";
        }catch (Exception ex) {
            Logger.getLogger(BackTDebtorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }

    public BackTDebtor getBackTDebtorByPK(String branch_id, String debtor_id) {
        String sql = "";
        try {
            debtor = new BackTDebtor();
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();

            sql = "Select * From " + debtor.getBackTDebtor() + " "
                    + "Where " + debtor.getFDebtorId() + "='" + debtor_id + "'";
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                debtor.setBDepartmentId(config1.StringNull(rs.getString(debtor.getFBDepartmentId())));
                debtor.setBillingCoverNumber(config1.StringNull(rs.getString(debtor.getFBillingCoverNumber())));
                debtor.setBillingInvoiceNumber(config1.StringNull(rs.getString(debtor.getFBillingInvoiceNumber())));
                debtor.setDateCancel(config1.StringNull(rs.getString(debtor.getFDateCancel())));
                debtor.setDateCreate(config1.StringNull(rs.getString(debtor.getFDateCreate())));

                debtor.setDateModify(config1.StringNull(rs.getString(debtor.getFDateModify())));
                debtor.setDateReceive(config1.StringNull(rs.getString(debtor.getFDateReceive())));
                debtor.setDebtorActive(config1.StringNull(rs.getString(debtor.getFDebtorActive())));
                debtor.setDebtorAmount(Double.valueOf(Double.parseDouble(rs.getString(debtor.getFDebtorAmount()))));
                debtor.setDebtorBEmployeeId(config1.StringNull(rs.getString(debtor.getFDebtorBEmployeeId())));

                debtor.setDebtorContactId(config1.StringNull(rs.getString(debtor.getFDebtorContactId())));
                debtor.setDebtorDate(config1.StringNull(rs.getString(debtor.getFDebtorDate())));
                debtor.setDebtorId(config1.StringNull(rs.getString(debtor.getFDebtorId())));
                debtor.setDebtorRemark(config1.StringNull(rs.getString(debtor.getFDebtorRemark())));
                debtor.setReceiveAmount(Double.valueOf(Double.parseDouble(rs.getString(debtor.getFReceiveAmount()))));

                debtor.setReceiveBEmployeeId(config1.StringNull(rs.getString(debtor.getFReceiveBEmployeeId())));
                debtor.setReceiveContactId(config1.StringNull(rs.getString(debtor.getFReceiveContactId())));
                debtor.setReceiveRemark(config1.StringNull(rs.getString(debtor.getFReceiveRemark())));
                debtor.setUserCancel(config1.StringNull(rs.getString(debtor.getFUserCancel())));
                debtor.setUserCreate(config1.StringNull(rs.getString(debtor.getFUserCreate())));

                debtor.setUserModify(config1.StringNull(rs.getString(debtor.getFUserModify())));
                debtor.setMonthId(config1.StringNull(debtor.getFMonthId()));
                debtor.setYearId(config1.StringNull(debtor.getFYearId()));
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTDebtorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return debtor;
    }

    public Vector getBackTDebtor(String branch_id, String debtor_id) {
        Vector v_debtor = new Vector();
        String sql = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            sql = "Select * From " + debtor.getBackTDebtor() + " "
                    + "Where " + debtor.getFDebtorId() + "='" + debtor_id + "'";
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                debtor = new BackTDebtor();
                debtor.setBDepartmentId(config1.StringNull(rs.getString(debtor.getFBDepartmentId())));
                debtor.setBillingCoverNumber(config1.StringNull(rs.getString(debtor.getFBillingCoverNumber())));
                debtor.setBillingInvoiceNumber(config1.StringNull(rs.getString(debtor.getFBillingInvoiceNumber())));
                debtor.setDateCancel(config1.StringNull(rs.getString(debtor.getFDateCancel())));
                debtor.setDateCreate(config1.StringNull(rs.getString(debtor.getFDateCreate())));

                debtor.setDateModify(config1.StringNull(rs.getString(debtor.getFDateModify())));
                debtor.setDateReceive(config1.StringNull(rs.getString(debtor.getFDateReceive())));
                debtor.setDebtorActive(config1.StringNull(rs.getString(debtor.getFDebtorActive())));
                debtor.setDebtorAmount(Double.valueOf(Double.parseDouble(rs.getString(debtor.getFDebtorAmount()))));
                debtor.setDebtorBEmployeeId(config1.StringNull(rs.getString(debtor.getFDebtorBEmployeeId())));

                debtor.setDebtorContactId(config1.StringNull(rs.getString(debtor.getFDebtorContactId())));
                debtor.setDebtorDate(config1.StringNull(rs.getString(debtor.getFDebtorDate())));
                debtor.setDebtorId(config1.StringNull(rs.getString(debtor.getFDebtorId())));
                debtor.setDebtorRemark(config1.StringNull(rs.getString(debtor.getFDebtorRemark())));
                debtor.setReceiveAmount(Double.valueOf(Double.parseDouble(rs.getString(debtor.getFReceiveAmount()))));

                debtor.setReceiveBEmployeeId(config1.StringNull(rs.getString(debtor.getFReceiveBEmployeeId())));
                debtor.setReceiveContactId(config1.StringNull(rs.getString(debtor.getFReceiveContactId())));
                debtor.setReceiveRemark(config1.StringNull(rs.getString(debtor.getFReceiveRemark())));
                debtor.setUserCancel(config1.StringNull(rs.getString(debtor.getFUserCancel())));
                debtor.setUserCreate(config1.StringNull(rs.getString(debtor.getFUserCreate())));

                debtor.setUserModify(config1.StringNull(rs.getString(debtor.getFUserModify())));
                debtor.setMonthId(config1.StringNull(debtor.getFMonthId()));
                debtor.setYearId(config1.StringNull(debtor.getFYearId()));
                v_debtor.add(debtor);
            }

            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTDebtorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_debtor;
    }
    public String setSaveBackTDebtor(String branch_id, BackTDebtor item) throws Exception {
        int chk = 0;
        String sql = ""; String max = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            debtor = getBackTDebtorByPK(branch_id, item.getDebtorId());
            item.setReceiveRemark(config1.StringNull(item.getReceiveRemark()).replace("'", "''"));
            item.setDebtorRemark(config1.StringNull(item.getDebtorRemark()).replace("'", "''"));

            if (debtor.getDebtorId().equals("")) {
                item.generateOID(idtable);
                max = item.getObjectId();
//                max = getMaxRowBackTDebtor(conn);
                sql = "Insert Into " + debtor.getBackTDebtor()
                        + "(" + debtor.getFDebtorId() + ", " + debtor.getFBillingCoverNumber() + ", "
                        + debtor.getFBillingInvoiceNumber() + "," + debtor.getFDateCancel() + ","
                        + debtor.getFDateCreate() + "," + debtor.getFDateModify() + ","
                        + debtor.getFDateReceive() + "," + debtor.getFDebtorActive() + ","
                        + debtor.getFDebtorAmount() + "," + debtor.getFDebtorBEmployeeId() + ","
                        + debtor.getFDebtorContactId() + "," + debtor.getFDebtorDate() + ","
                        + debtor.getFBDepartmentId() + "," + debtor.getFDebtorRemark() + ","
                        + debtor.getFReceiveAmount() + "," + debtor.getFReceiveBEmployeeId() + ", "
                        + debtor.getFReceiveContactId() + "," + debtor.getFReceiveRemark() + ", "
                        + debtor.getFUserCancel() + "," + debtor.getFUserCreate() + ","
                        + debtor.getFUserModify() + ","+debtor.getFMonthId()+","
                        + debtor.getFYearId()+") "
                        + "Values('" + max + "','" + item.getBillingCoverNumber() + "','"
                        + item.getBillingInvoiceNumber() + "','" + item.getDateCancel() + "','"
                        + item.getDateCreate() + "','" + item.getDateModify() + "','"
                        + item.getDateReceive() + "','" + item.getDebtorActive() + "',"
                        + item.getDebtorAmount() + ",'" + item.getDebtorBEmployeeId() + "','"
                        + item.getDebtorContactId() + "','" + item.getDebtorDate() + "','"
                        + item.getBDepartmentId() + "','" + item.getDebtorRemark() + "',"
                        + item.getReceiveAmount() + ",'" + item.getReceiveBEmployeeId() + "','"
                        + item.getReceiveContactId() + "','" + item.getReceiveRemark() + "','"
                        + item.getUserCancel() + "','" + item.getUserCreate() + "','"
                        + item.getUserModify() + "','"+item.getMonthId()+"','"
                        + item.getYearId()+"')";
            }else{
                sql = "Update " + debtor.getBackTDebtor()
                        + " set " + debtor.getFBillingCoverNumber() + " = '" + item.getBillingCoverNumber() + "', "
                        + debtor.getFBillingInvoiceNumber() + " = '" + item.getBillingInvoiceNumber() + "', "
                        + debtor.getFDateCancel() + " = '" + item.getDateCancel() + "', "
                        + debtor.getFDateCreate() + " = '" + item.getDateCreate() + "', "
                        + debtor.getFDateModify() + " = '" + item.getDateModify() + "', "
                        + debtor.getFDateReceive() + " = '" + item.getDateReceive() + "', "
                        + debtor.getFDebtorAmount() + " = " + item.getDebtorAmount() + ", "
                        + debtor.getFDebtorBEmployeeId() + " = '" + item.getDebtorBEmployeeId() + "', "
                        + debtor.getFDebtorContactId() + " = '" + item.getDebtorContactId() + "', "
                        + debtor.getFDebtorDate() + " = '" + item.getDebtorDate() + "',"
                        + debtor.getFBDepartmentId() + " = '" + item.getBDepartmentId() + "',"
                        + debtor.getFDebtorRemark() + " = '" + item.getDebtorRemark() + "', "
                        + debtor.getFReceiveAmount() + " = " + item.getReceiveAmount() + ", "
                        + debtor.getFReceiveBEmployeeId() + " = '" + item.getReceiveBEmployeeId() + "', "
                        + debtor.getFReceiveContactId() + " = '" + item.getReceiveContactId() + "', "
                        + debtor.getFReceiveRemark() + " = '" + item.getReceiveRemark() + "', "
                        + debtor.getFUserCancel() + " = '" + item.getUserCancel() + "', "
                        + debtor.getFUserCreate() + " = '" + item.getUserCreate() + "', "
                        + debtor.getFUserModify() + " = '" + item.getUserModify() + "', "
                        + debtor.getFMonthId() + " = '" + item.getMonthId() + "', "
                        + debtor.getFYearId() + " = '" + item.getYearId() + "' "
                        + "Where " + debtor.getFDebtorId() + " = '" + item.getDebtorId() + "'";

                max = item.getDebtorId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTDebtorDB.class.getName()).log(Level.SEVERE, null, ex);
          max = ex.getMessage();
        }
        return max;
    }

    public String setSaveDebtor(String branch_id, String billing_invoice_number, String billing_cover_number,
          Double debtor_amount, String debtor_date, String b_department_id, String debtor_remark, 
          String debtor_contact_id, String close_day_date) {
        try {
            debtor = new BackTDebtor();
            debtor.setBDepartmentId(b_department_id);
            debtor.setBillingCoverNumber("");
            debtor.setBillingInvoiceNumber(billing_invoice_number);
            debtor.setDebtorActive("1");
            debtor.setDebtorAmount(debtor_amount);
            debtor.setDebtorContactId(debtor_contact_id);
            debtor.setDebtorDate(debtor_date);
            debtor.setDebtorId("");
            debtor.setDebtorRemark(debtor_remark);
            debtor.setBillingCoverNumber(billing_cover_number);
            debtor.setStatusPayment("2");
            if(close_day_date.length()>=10){
                debtor.setMonthId(close_day_date.substring(5,7));
                debtor.setYearId(close_day_date.substring(0, 4));
            }
            setSaveBackTDebtor(branch_id, debtor);
        } catch (Exception ex) {
            Logger.getLogger(BackTDebtorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    public String setUpdateBackTDebtorPayment(String brannd_id, String bpv_cb_id, String contact_id, String remark, Double receive_amount){
        String sql="";
        Integer chk=0;
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
//            st.executeUpdate(sql);
            sql = "Update "+debtor.getBackTDebtor()+" Set "+debtor.getFStatusPayment()+"='4', "
                +debtor.getFReceiveRemark()+"='"+remark+"', "
                +debtor.getFReceiveAmount()+"="+debtor.getFReceiveAmount()+"+"+receive_amount+", "
                +debtor.getFReceiveContactId()+"='"+contact_id+"' "
                +"Where "+debtor.getFDebtorContactId()+"='"+bpv_cb_id+"'";
            chk = st.executeUpdate(sql);
        } catch (Exception ex) {
            Logger.getLogger(BackTBillingPaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setUpdateBackTDebtorVoid(String branchId, String billingInvoiceNumber){
        String sql="";
        Integer chk=0;
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
//            st.executeUpdate(sql);
            sql = "Update "+debtor.getBackTDebtor()+" Set "+debtor.getFDebtorActive()+"='3' "
                +"Where "+debtor.getFBillingInvoiceNumber()+"='"+billingInvoiceNumber+"'";
            chk = st.executeUpdate(sql);
        } catch (Exception ex) {
            Logger.getLogger(BackTBillingPaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
}