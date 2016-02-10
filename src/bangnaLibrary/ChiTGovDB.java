package bangnaLibrary;

import bangnaLibrary.ChiBBillgroup;
import bangnaLibrary.BBranch;
import bangnaLibrary.BItem;
import bangnaLibrary.BackTPatientVisitDB;
import bangnaLibrary.CashierTBillingInvoicePrintDB;
import bangnaLibrary.Config1;
import bangnaLibrary.PatientVisit;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class ChiTGovDB {
    public Config1 config1 = new Config1();
    public ChiTGov cgov = new ChiTGov();
    public ChiTGovItem cgovi = new ChiTGovItem();
    public BBranch branch = new BBranch();
    private BItem bitem = new BItem();
    PatientVisit pv = new PatientVisit();
    public ChiBBillgroup cbg = new ChiBBillgroup();
    private ChiFBillgroup cfbg = new ChiFBillgroup();
    public ChiBSurcharge cbs = new ChiBSurcharge();
//    private ChiNhso nhso = new ChiNhso();

    public String getMaxRowChiTGov(Statement st) {
        String sql = "", max = "";
        try {
//            Statement st = conn.createStatement();
            sql = "Select max(" + cgov.getFChiGovId() + ") as cnt From " + cgov.getChiTGov();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))
                max = String.valueOf(Integer.parseInt(max) + 1);
            else
                max = "1290000001";
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowChiTGovItem(Statement st) {
        String sql = "", max = "";
        try {
//            Statement st = st.createStatement();
            sql = "Select max(" + cgovi.getFChiGovItemId() + ") as cnt From " + cgovi.getChiTGovItem();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))
                max = String.valueOf(Integer.parseInt(max) + 1);
            else
                max = "1950000001";
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowChiBBillgroup(Statement st) {
        String sql = "", max = "";
        try {
//            Statement st = st.createStatement();
            sql = "Select max(" + cbg.getFBItemId() + ") as cnt From " + cbg.getChiBBillgroup();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))
                max = String.valueOf(Integer.parseInt(max) + 1);
            else
                max = "1960000001";
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowChiBSurcharge(Statement st) {
        String sql = "", max = "";
        try {
//            Statement st = st.createStatement();
            sql = "Select max(" + cbs.getFSurchargeId() + ") as cnt From " + cbs.getChiBSurcharge();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))
                max = String.valueOf(Integer.parseInt(max) + 1);
            else
                max = "2020000001";
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public ChiTGov getChiTGovByPK(String branch_id, String cgov_id,  String flag){
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            cgov = getChiTGovByPK(stbangna, branch_id, cgov_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cgov;
    }
    public ChiTGov getChiTGovByPK(Statement stbangna, String branch_id, String cgov_id,  String flag) {
        String sql = "";
        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();
            sql = "Select * "
            +"From "+cgov.getChiTGov() + " "
            +"Where "+cgov.getFChiGovId() + "='" + cgov_id + "' ";
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                cgov = new ChiTGov();
                cgov.setChiGovActive(config1.StringNull(rs.getString(cgov.getFChiGovActive())));
                cgov.setChiGovDate(config1.StringNull(rs.getString(cgov.getFChiGovDate())));
                cgov.setChiGovId(config1.StringNull(rs.getString(cgov.getFChiGovId())));
                cgov.setDescription(config1.StringNull(rs.getString(cgov.getFDescription())));
                cgov.setRemark(config1.StringNull(rs.getString(cgov.getFRemark())));

                cgov.setStatusChiGov(config1.StringNull(rs.getString(cgov.getFStatusChiGov())));
                cgov.setAuthCode(config1.StringNull(rs.getString(cgov.getFAuthCode())));
                cgov.setAuthDt(config1.StringNull(rs.getString(cgov.getFAuthDt())));
            }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cgov;
    }
    public ChiBBillgroup getChiBBillgroupByPK(String branch_id, String b_item_id,  String flag){
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            cbg = getChiBBillgroupByPK(stbangna, branch_id, b_item_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cbg;
    }
    public ChiBBillgroup getChiBBillgroupByPK(Statement stbangna, String branch_id, String bItemId,  String flag) {
        String sql = "";
        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();
            if(flag.equals("itemnumber")){
                sql = "Select * "
            +"From "+cbg.getChiBBillgroup() + " "
            +"Where "+cbg.getFItemNumber() + "='" + bItemId + "' ";
            }else if(flag.equals("cscode")){
                sql = "Select * "
            +"From "+cbg.getChiBBillgroup() + " "
            +"Where "+cbg.getFCsCode() + "='" + bItemId + "' ";
            }else{
                sql = "Select * "
            +"From "+cbg.getChiBBillgroup() + " "
            +"Where "+cbg.getFBItemId() + "='" + bItemId + "' ";
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                cbg = new ChiBBillgroup();
                cbg.setBItemId(config1.StringNull(rs.getString(cbg.getFBItemId())));
                cbg.setBillgroupId(config1.StringNull(rs.getString(cbg.getFBillgroupId())));
                cbg.setItemNumber(config1.StringNull(rs.getString(cbg.getFItemNumber())));
                cbg.setItemCommonName(config1.StringNull(rs.getString(cbg.getFItemCommonName())));
                cbg.setDateeff(config1.StringNull(rs.getString(cbg.getFDateeff())));

                cbg.setDateexp(config1.StringNull(rs.getString(cbg.getFDateexp())));
                cbg.setDefinition(config1.StringNull(rs.getString(cbg.getFDefinition())));
                cbg.setRate(rs.getDouble(cbg.getFRate()));
                cbg.setRevrate(rs.getDouble(cbg.getFRevrate()));
                cbg.setSid(config1.StringNull(rs.getString(cbg.getFSid())));

                cbg.setSimbgroup(config1.StringNull(rs.getString(cbg.getFSimbgroup())));
                cbg.setUnit(config1.StringNull(rs.getString(cbg.getFUnit())));
                cbg.setTmpCode(config1.StringNull(rs.getString(cbg.getFTmpCode())));
                cbg.setCsCode(config1.StringNull(rs.getString(cbg.getFCsCode())));
                cbg.setCsRate(rs.getDouble(cbg.getFCsRate()));

                cbg.setCsRevRate(config1.StringNull(rs.getString(cbg.getFCsRevRate())));
                cbg.setBillinggroupActive(config1.StringNull(rs.getString(cbg.getFBillinggroupActive())));

            }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cbg;
    }
    public ChiBBillgroup getChiFBillgroupByPK(String branch_id, String billgroup_id,  String flag){
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            cfbg = getChiFBillgroupByPK(stbangna, branch_id, billgroup_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cbg;
    }
    public ChiFBillgroup getChiFBillgroupByPK(Statement stbangna, String branch_id, String billgroup_id,  String flag) {
        String sql = "";
        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();
            sql = "Select * "
            +"From "+cfbg.getChiFBillgroup() + " "
            +"Where "+cfbg.getFBillgroupId() + "='" + billgroup_id + "' ";
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                cfbg = new ChiFBillgroup();
                cfbg.setBillgroupActive(config1.StringNull(rs.getString(cfbg.getFBillgroupActive())));
                cfbg.setBillgroupId(config1.StringNull(rs.getString(cfbg.getFBillgroupId())));
                cfbg.setBillgroupNamet(config1.StringNull(rs.getString(cfbg.getFBillgroupNamet())));
                cfbg.setStatus16Group(config1.StringNull(rs.getString(cfbg.getFStatus16Group())));
                cfbg.setItem16GroupNumber(config1.StringNull(rs.getString(cfbg.getFItem16GroupNumber())));
            }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cfbg;
    }
    public ChiBSurcharge getChiBSurchareByPK(String branch_id, String b_item_id,  String flag){
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            cbs = getChiBSurchareByPK(stbangna, branch_id, b_item_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cbs;
    }
    public ChiBSurcharge getChiBSurchareByPK(Statement stbangna, String branch_id, String surchargeId,  String flag) {
        String sql = "";
        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();
            if(flag.equals("itemnumber")){
                sql = "Select * "
            +"From "+cbs.getChiBSurcharge() + " "
            +"Where "+cbs.getFItemNumber() + "='" + surchargeId + "' ";
            }else{
                sql = "Select * "
            +"From "+cbs.getChiBSurcharge() + " "
            +"Where "+cbs.getFSurchargeId() + "='" + surchargeId + "' ";
            }

            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                cbs = new ChiBSurcharge();
                cbs.setBranchId(config1.StringNull(rs.getString(cbs.getFBranchId())));
                cbs.setDefinition(config1.StringNull(rs.getString(cbs.getFDefinition())));
                cbs.setItemNumber(config1.StringNull(rs.getString(cbs.getFItemNumber())));
                cbs.setRateA(rs.getDouble(cbs.getFRateA()));
                cbs.setRateB(rs.getDouble(cbs.getFRateB()));

                cbs.setRateC(rs.getDouble(cbs.getFRateC()));
                cbs.setRateD(rs.getDouble(cbs.getFRateD()));
                cbs.setSurcharge(rs.getDouble(cbs.getFSurcharge()));
                cbs.setSurchargeActive(rs.getString(cbs.getFSurchargeActive()));
                cbs.setSurchargeId(config1.StringNull(rs.getString(cbs.getFSurchargeId())));

                cbs.setTmpCode(config1.StringNull(rs.getString(cbs.getFTmpCode())));

            }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cbs;
    }
    public Vector getChiTGov(String branch_id, String cgov_id,  String flag){
        Connection conn;
        Vector v_cgov = new Vector();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            v_cgov = getChiTGov(stbangna, branch_id, cgov_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_cgov;
    }
    public Vector getChiTGov(Statement stbangna,String branch_id, String cgov_id,  String flag) {
        String sql = "";
        Vector v_cgov = new Vector();
        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();
            if(flag.equals("year_id")){
                sql = "Select min(cgov."+cgov.getFDescription()+") as "+cgov.getFDescription()+", "
                        +"min(cgov."+cgov.getFRemark()+") as "+cgov.getFRemark()+", "
                        +"min(cgov."+cgov.getFChiGovActive()+") as "+cgov.getFChiGovActive()+", "
                        +"min(cgov."+cgov.getFChiGovDate()+") as "+cgov.getFChiGovDate()+", "
                        +"cgov."+cgov.getFChiGovId()+" as "+cgov.getFChiGovId()+", "
                        +"min(cgov."+cgov.getFStatusChiGov()+") as "+cgov.getFStatusChiGov()+", "
                        + "sum("+cgovi.getFVisitTotal()+") as visit_total, count(1) as cnt, "
                        + "min(cgov."+cgov.getFAuthCode()+") as "+cgov.getFAuthCode()+","
                        + "min(cgov."+cgov.getFAuthDt()+") as "+cgov.getFAuthDt()+" "
            +"From "+cgov.getChiTGov() + " cgov "
            + "left join "+cgovi.getChiTGovItem() +" cgovi on cgov."+cgov.getFChiGovId()+"=cgovi."+cgovi.getFChiGovId()+" and "
            +cgovi.getFChiGovItemActive()+"='1' "
            +"Where substring(cgov."+cgov.getFChiGovDate() + ",0,5) ='" + cgov_id + "' and cgov."+cgov.getFChiGovActive()+"='1' "
                        + "Group By cgov."+cgov.getFChiGovId()+" "
                        + "Order By "+cgov.getFChiGovId();
            }else{
                sql = "Select *, '0' as cnt, '0' as visit_total "
            +"From "+cgov.getChiTGov() + " "
            +"Where "+cgov.getFChiGovId() + "='" + cgov_id + "' "
                        + "Order By "+cgov.getFChiGovId();
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                cgov = new ChiTGov();
                cgov.setChiGovActive(config1.StringNull(rs.getString(cgov.getFChiGovActive())));
                cgov.setChiGovDate(config1.StringNull(rs.getString(cgov.getFChiGovDate())));
                cgov.setChiGovId(config1.StringNull(rs.getString(cgov.getFChiGovId())));
                cgov.setDescription(config1.StringNull(rs.getString(cgov.getFDescription())));
                cgov.setRemark(config1.StringNull(rs.getString(cgov.getFRemark())));

                cgov.setStatusChiGov(config1.StringNull(rs.getString(cgov.getFStatusChiGov())));
                cgov.setVisitTotal(config1.StringNull(rs.getString("visit_total")));
                cgov.setCntItem(config1.StringNull(rs.getString("cnt")));
                cgov.setAuthCode(config1.StringNull(rs.getString(cgov.getFAuthCode())));
                cgov.setAuthDt(config1.StringNull(rs.getString(cgov.getFAuthDt())));
                v_cgov.add(cgov);
            }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_cgov;
    }
    public Vector getChiBBillgroup(String branch_id, String b_item_id,  String flag){
        Connection conn;
        Vector v_cbg = new Vector();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            v_cbg = getChiBBillgroup(stbangna, branch_id, b_item_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_cbg;
    }
    public Vector getChiBBillgroup(Statement stbangna, String branch_id, String billgroup,  String flag) {
        String sql = "";
        Vector v_cbg = new Vector();
        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();
            if(flag.equals("billgroup")){
                sql = "Select cbg.*, cfbg."+cfbg.getFBillgroupNamet()+" "
            +"From "+cbg.getChiBBillgroup() + " cbg "
            + "left join "+cfbg.getChiFBillgroup() +" cfbg on cbg."+cbg.getFBillgroupId()+"=cfbg."+cfbg.getFBillgroupId()+" "
            +"Where cbg."+cbg.getFBillgroupId() + "='" + billgroup + "' ";
            }else{
                sql = "Select * "
            +"From "+cbg.getChiBBillgroup() + " "
            +"Where "+cbg.getFBItemId() + "='" + billgroup + "' ";
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                cbg = new ChiBBillgroup();
                cbg.setBItemId(config1.StringNull(rs.getString(cbg.getFBItemId())));
                cbg.setBillgroupId(config1.StringNull(rs.getString(cbg.getFBillgroupId())));
                cbg.setItemNumber(config1.StringNull(rs.getString(cbg.getFItemNumber())));
                cbg.setItemCommonName(config1.StringNull(rs.getString(cbg.getFItemCommonName())));
                cbg.setDateeff(config1.StringNull(rs.getString(cbg.getFDateeff())));

                cbg.setDateexp(config1.StringNull(rs.getString(cbg.getFDateexp())));
                cbg.setDefinition(config1.StringNull(rs.getString(cbg.getFDefinition())));
                cbg.setRate(rs.getDouble(cbg.getFRate()));
                cbg.setRevrate(rs.getDouble(cbg.getFRevrate()));
                cbg.setSid(config1.StringNull(rs.getString(cbg.getFSid())));

                cbg.setSimbgroup(config1.StringNull(rs.getString(cbg.getFSimbgroup())));
                cbg.setUnit(config1.StringNull(rs.getString(cbg.getFUnit())));
                cbg.setBillgroupName(config1.StringNull(rs.getString(cfbg.getFBillgroupNamet())));
                cbg.setTmpCode(config1.StringNull(rs.getString(cbg.getFTmpCode())));
                cbg.setCsCode(config1.StringNull(rs.getString(cbg.getFCsCode())));
                cbg.setCsRate(rs.getDouble(cbg.getFCsRate()));
                cbg.setBillinggroupActive(config1.StringNull(rs.getString(cbg.getFBillinggroupActive())));

                cbg.setCsRevRate(config1.StringNull(rs.getString(cbg.getFCsRevRate())));
                v_cbg.add(cbg);
            }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_cbg;
    }
    public Vector getChiBSurchare(String branch_id, String b_item_id,  String flag){
        Connection conn;
        Vector v_cbs = new Vector();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            v_cbs = getChiBSurchare(stbangna, branch_id, b_item_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_cbs;
    }
    public Vector getChiBSurchare(Statement stbangna, String branch_id, String surchargeId,  String flag) {
        String sql = "";
        Vector v_cbs = new Vector();
        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();
            if(flag.equals("itemnumber")){
                sql = "Select * "
            +"From "+cbs.getChiBSurcharge() + " "
            +"Where "+cbs.getFItemNumber() + "='" + surchargeId + "' ";
            }else if(flag.equals("search_surcharge")){
                sql = "Select * "
            +"From "+cbs.getChiBSurcharge() + " "
            +"Where "+cbs.getFSurchargeActive() + "='1' ";
            }else{
                sql = "Select * "
            +"From "+cbs.getChiBSurcharge() + " "
            +"Where "+cbs.getFSurchargeId() + "='" + surchargeId + "' ";
            }

            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                cbs = new ChiBSurcharge();
                cbs.setBranchId(config1.StringNull(rs.getString(cbs.getFBranchId())));
                cbs.setDefinition(config1.StringNull(rs.getString(cbs.getFDefinition())));
                cbs.setItemNumber(config1.StringNull(rs.getString(cbs.getFItemNumber())));
                cbs.setRateA(rs.getDouble(cbs.getFRateA()));
                cbs.setRateB(rs.getDouble(cbs.getFRateB()));

                cbs.setRateC(rs.getDouble(cbs.getFRateC()));
                cbs.setRateD(rs.getDouble(cbs.getFRateD()));
                cbs.setSurcharge(rs.getDouble(cbs.getFSurcharge()));
                cbs.setSurchargeActive(rs.getString(cbs.getFSurchargeActive()));
                cbs.setSurchargeId(config1.StringNull(rs.getString(cbs.getFSurchargeId())));

                cbs.setTmpCode(config1.StringNull(rs.getString(cbs.getFTmpCode())));
                v_cbs.add(cbs);

            }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_cbs;
    }
    public Vector getChiFBillgroup(String branch_id, String billgroup_id,  String flag){
        Connection conn;
        Vector v_cfbg = new Vector();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            v_cfbg = getChiFBillgroup(stbangna, branch_id, billgroup_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_cfbg;
    }
    public Vector getChiFBillgroup(Statement stbangna, String branch_id, String billgroup_id,  String flag) {
        String sql = "", billgroup_search="";
        Vector v_cfbg = new Vector();
        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();
            if(flag.equals("billgroup")){
                if(!billgroup_id.equals("")){
                    billgroup_search=" and "+cfbg.getFBillgroupId()+"='"+billgroup_id+"'";
                }
                sql = "Select * "
                +"From "+cfbg.getChiFBillgroup() + " "
                +"Where "+cfbg.getFBillgroupActive()+"='1' "+billgroup_search+" "
                + "Order By "+cfbg.getFBillgroupId();
            }else{
                sql = "Select * "
                +"From "+cfbg.getChiFBillgroup() + " "
                +"Where "+cfbg.getFBillgroupId() + "='" + billgroup_id + "' ";
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                cfbg = new ChiFBillgroup();
                cfbg.setBillgroupActive(config1.StringNull(rs.getString(cfbg.getFBillgroupActive())));
                cfbg.setBillgroupId(config1.StringNull(rs.getString(cfbg.getFBillgroupId())));
                cfbg.setBillgroupNamet(config1.StringNull(rs.getString(cfbg.getFBillgroupNamet())));
                cfbg.setStatus16Group(config1.StringNull(rs.getString(cfbg.getFStatus16Group())));
                cfbg.setItem16GroupNumber(config1.StringNull(rs.getString(cfbg.getFItem16GroupNumber())));
                v_cfbg.add(cfbg);
            }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_cfbg;
    }
    public ChiTGovItem getChiTGovItemByPK(String branch_id, String cgovi_id,  String flag){
        Connection conn;
        Vector v_cgov = new Vector();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            cgovi = getChiTGovItemByPK(stbangna, branch_id, cgovi_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cgovi;
    }
    public ChiTGovItem getChiTGovItemByPK(Statement stbangna,String branch_id, String cgovi_id,  String flag) {
        String sql = "";
        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();
            sql = "Select * "
            +"From "+cgovi.getChiTGovItem() + " "
            +"Where "+cgovi.getFChiGovItemId() + "='" + cgovi_id + "' "
                    + "Order By "+cgov.getChiGovId();
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                cgovi = new ChiTGovItem();
                cgovi.setChiGovId(config1.StringNull(rs.getString(cgovi.getFChiGovId())));
                cgovi.setChiGovItemActive(config1.StringNull(rs.getString(cgovi.getFChiGovItemActive())));
                cgovi.setChiGovItemDate(config1.StringNull(rs.getString(cgovi.getFChiGovItemDate())));
                cgovi.setChiGovItemId(config1.StringNull(rs.getString(cgovi.getFChiGovItemId())));
                cgovi.setChiPaid(rs.getDouble(cgovi.getFChiPaid()));

                cgovi.setPaidId(config1.StringNull(rs.getString(cgovi.getFPaidId())));
                cgovi.setPatientFullnamet(config1.StringNull(rs.getString(cgovi.getFPatientFullnamet())));
                cgovi.setRemarkChi(config1.StringNull(rs.getString(cgovi.getFRemarkChi())));
                cgovi.setRemarkChiGov(config1.StringNull(rs.getString(cgovi.getFRemarkChiGov())));
                cgovi.setStatusChi(config1.StringNull(rs.getString(cgovi.getFStatusChi())));

                cgovi.setVisitHn(config1.StringNull(rs.getString(cgovi.getFVisitHn())));
                cgovi.setVisitId(config1.StringNull(rs.getString(cgovi.getFVisitId())));
                cgovi.setVisitTotal(rs.getDouble(cgovi.getFVisitTotal()));
                cgovi.setVisitVn(config1.StringNull(rs.getString(cgovi.getFVisitVn())));
                cgovi.setAuthCode(config1.StringNull(rs.getString(cgovi.getFAuthCode())));
                
                cgovi.setAuthDt(config1.StringNull(rs.getString(cgovi.getFAuthDt())));
                cgovi.setTVisitPaymentId(config1.StringNull(rs.getString(cgovi.getFTVisitPaymentId())));
                cgovi.setVisitAn(config1.StringNull(rs.getString(cgovi.getFVisitAn())));
                cgovi.setPid(config1.StringNull(rs.getString(cgovi.getFPid())));
                cgovi.setSurchargeId(config1.StringNull(rs.getString(cgovi.getFSurchargeId())));

                cgovi.setAdmitDay(rs.getDouble(cgovi.getFAdmitDay()));
            }

            rs.close();
//            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cgovi;
    }
    public Vector getChiTGovItem(String branch_id, String cgovi_id,  String flag){
        Connection conn;
        Vector v_cgov = new Vector();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            v_cgov = getChiTGovItem(stbangna, branch_id, cgovi_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_cgov;
    }
    public Vector getChiTGovItem(Statement stbangna,String branch_id, String cgovi_id,  String flag) {
        String sql = "";
        Vector v_chi = new Vector();
        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();

            if(flag.equals("")){
                sql = "Select * "
            +"From "+cgovi.getChiTGovItem() + " "
            +"Where "+cgovi.getFChiGovId() + "='" + cgovi_id + "' and "+cgovi.getFChiGovItemActive()+"='1' "
                    + "Order By "+cgovi.getFChiGovItemId();
            }else{
                sql = "Select * "
            +"From "+cgovi.getChiTGovItem() + " "
            +"Where "+cgovi.getFChiGovId() + "='" + cgovi_id + "' and "+cgovi.getFChiGovItemActive()+"='1' "
                    + "Order By "+cgovi.getFChiGovItemId();
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                cgovi = new ChiTGovItem();
                cgovi.setChiGovId(config1.StringNull(rs.getString(cgovi.getFChiGovId())));
                cgovi.setChiGovItemActive(config1.StringNull(rs.getString(cgovi.getFChiGovItemActive())));
                cgovi.setChiGovItemDate(config1.StringNull(rs.getString(cgovi.getFChiGovItemDate())));
                cgovi.setChiGovItemId(config1.StringNull(rs.getString(cgovi.getFChiGovItemId())));
                cgovi.setChiPaid(rs.getDouble(cgovi.getFChiPaid()));

                cgovi.setPaidId(config1.StringNull(rs.getString(cgovi.getFPaidId())));
                cgovi.setPatientFullnamet(config1.StringNull(rs.getString(cgovi.getFPatientFullnamet())));
                cgovi.setRemarkChi(config1.StringNull(rs.getString(cgovi.getFRemarkChi())));
                cgovi.setRemarkChiGov(config1.StringNull(rs.getString(cgovi.getFRemarkChiGov())));
                cgovi.setStatusChi(config1.StringNull(rs.getString(cgovi.getFStatusChi())));

                cgovi.setVisitHn(config1.StringNull(rs.getString(cgovi.getFVisitHn())));
                cgovi.setVisitId(config1.StringNull(rs.getString(cgovi.getFVisitId())));
                cgovi.setVisitTotal(rs.getDouble(cgovi.getFVisitTotal()));
                cgovi.setVisitVn(config1.StringNull(rs.getString(cgovi.getFVisitVn())));
                cgovi.setAuthCode(config1.StringNull(rs.getString(cgovi.getFAuthCode())));
                
                cgovi.setAuthDt(config1.StringNull(rs.getString(cgovi.getFAuthDt())));
                cgovi.setTVisitPaymentId(config1.StringNull(rs.getString(cgovi.getFTVisitPaymentId())));
                cgovi.setVisitAn(config1.StringNull(rs.getString(cgovi.getFVisitAn())));
                cgovi.setPid(config1.StringNull(rs.getString(cgovi.getFPid())));
                cgovi.setSurchargeId(config1.StringNull(rs.getString(cgovi.getFSurchargeId())));

                cgovi.setAdmitDay(rs.getDouble(cgovi.getFAdmitDay()));
                v_chi.add(cgovi);
            }

            rs.close();
//            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_chi;
    }
    public String setSaveChiTGov(String branch_id,ChiTGov item) throws Exception {
        int chk = 0;
        String sql = "", max = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            cgov = getChiTGovByPK(branch_id, item.getChiGovId(),"");
            item.setDescription(config1.StringNull(item.getDescription()).replace("'", "''"));
            item.setRemark(config1.StringNull(item.getRemark()).replace("'", "''"));
//            item.setVisitDiagnosisNotice(config1.StringNull(item.getVisitDiagnosisNotice()).replace("'", "''"));
            if (cgov.getChiGovId().equals("")) {
                max = getMaxRowChiTGov(st);
                sql = "Insert Into " + cgov.getChiTGov()
                    + "(" + cgov.getFChiGovId() + ", " + cgov.getFChiGovActive() + ", "
                    + cgov.getFDescription() + "," + cgov.getFRemark() + ","
                    + cgov.getFStatusChiGov() + "," + cgov.getFChiGovDate() + ","
                    + cgov.getFAuthCode()+","+cgov.getFAuthDt()+") "
                    + "Values('" + max + "','" + item.getChiGovActive() + "','"
                    + item.getDescription() + "','" + item.getRemark() + "','"
                    + item.getStatusChiGov() + "','" + item.getChiGovDate() + "','"
                    + item.getAuthCode()+"','"+item.getAuthDt()+"')";
            }else{
                sql = "Update " + cgov.getChiTGov()
                    + " set " + cgov.getFChiGovActive() + " = '" + item.getChiGovActive() + "', "
                    + cgov.getFDescription() + " = '" + item.getDescription() + "', "
                    + cgov.getFRemark() + " = '" + item.getRemark() + "', "
                    + cgov.getFStatusChiGov() + " = '" + item.getStatusChiGov() + "', "
                    + cgov.getFChiGovDate() + " = '" + item.getChiGovDate() + "' "
                    + "Where " + cgov.getFChiGovId() + " = '" + item.getChiGovId() + "'";
                max = item.getFChiGovId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String setSaveChiTGovItem(String branch_id,ChiTGovItem item) throws Exception {
        int chk = 0;
        String sql = "", max = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            cgovi = getChiTGovItemByPK(branch_id, item.getChiGovItemId(),"");
            item.setPatientFullnamet(config1.StringNull(item.getPatientFullnamet()).replace("'", "''"));
            item.setRemarkChi(config1.StringNull(item.getRemarkChi()).replace("'", "''"));
            item.setRemarkChiGov(config1.StringNull(item.getRemarkChiGov()).replace("'", "''"));
            if (cgovi.getChiGovItemId().equals("")) {
                max = getMaxRowChiTGovItem(st);
                sql = "Insert Into " + cgovi.getChiTGovItem()
                    + "(" + cgovi.getFChiGovItemId() + ", " + cgovi.getFChiGovId() + ", "
                    + cgovi.getFChiGovItemDate() + "," + cgovi.getFChiPaid() + ","
                    + cgovi.getFPaidId() + "," + cgovi.getFPatientFullnamet() + ","
                    + cgovi.getFRemarkChi() + "," + cgovi.getFRemarkChiGov() + ","
                    + cgovi.getFStatusChi() + "," + cgovi.getFVisitHn() + ","
                    + cgovi.getFVisitId() + "," + cgovi.getFVisitTotal() + ","
                    + cgovi.getFVisitVn() + "," + cgovi.getFChiGovItemActive() + ","
                    + cgovi.getFAuthCode()+","+cgovi.getFAuthDt()+","
                    + cgovi.getFTVisitPaymentId()+","+cgovi.getFVisitAn()+","
                    + cgovi.getFPid()+","+cgovi.getFSurchargeId()+","
                    + cgovi.getFAdmitDay()+") "
                    + "Values('" + max + "','" + item.getChiGovId() + "','"
                    + item.getChiGovItemDate() + "'," + item.getChiPaid() + ",'"
                    + item.getPaidId() + "','" + item.getPatientFullnamet() + "','"
                    + item.getRemarkChi() + "','" + item.getRemarkChiGov() + "','"
                    + item.getStatusChi() + "','" + item.getVisitHn() + "','"
                    + item.getVisitId() + "'," + item.getVisitTotal() + ",'"
                    + item.getVisitVn() + "','" + item.getChiGovItemActive() + "','"
                    + item.getAuthCode()+"','"+item.getAuthDt()+"','"
                    + item.getTVisitPaymentId()+"','"+item.getVisitAn()+"','"
                    + item.getPid()+"','"+item.getSurchargeId()+"',"
                    + item.getAdmitDay()+")";
            }else{
                sql = "Update " + cgovi.getChiTGovItem()
                    + " set " + cgovi.getFChiGovId() + " = '" + item.getChiGovId() + "', "
                    + cgovi.getFChiGovItemDate() + " = '" + item.getChiGovItemDate() + "', "
                    + cgovi.getFChiPaid() + " = " + item.getChiPaid() + ", "
                    + cgovi.getFPaidId() + " = '" + item.getPaidId() + "', "
                    + cgovi.getFPatientFullnamet() + " = '" + item.getPatientFullnamet() + "', "
                    + cgovi.getFRemarkChi() + " = '" + item.getRemarkChi() + "', "
                    + cgovi.getFRemarkChiGov() + " = '" + item.getRemarkChiGov() + "', "
                    + cgovi.getFStatusChi() + " = '" + item.getStatusChi() + "', "
                    + cgovi.getFVisitHn() + " = '" + item.getVisitHn() + "', "
                    + cgovi.getFVisitId() + " = '" + item.getVisitId() + "', "
                    + cgovi.getFVisitTotal() + " = " + item.getVisitTotal() + ", "
                    + cgovi.getFVisitVn() + " = '" + item.getVisitVn() + "', "
                    + cgovi.getFChiGovItemActive() + " = '" + item.getChiGovItemActive() + "' "
                    + "Where " + cgovi.getFChiGovItemId() + " = '" + item.getChiGovItemId() + "'";
                max = item.getChiGovItemId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String setSaveChiBBillgroup(String branch_id,ChiBBillgroup item) throws Exception {
        int chk = 0;
        String sql = "", max = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            cbg = getChiBBillgroupByPK(branch_id, item.getBItemId(),"");
            item.setDefinition(config1.StringNull(item.getDefinition()).replace("'", "''"));
            item.setItemCommonName(config1.StringNull(item.getItemCommonName()).replace("'", "''"));
//            item.(config1.StringNull(item.getVisitDiagnosisNotice()).replace("'", "''"));
            if (cbg.getBItemId().equals("")) {
                max = getMaxRowChiBBillgroup(st);
                sql = "Insert Into " + cbg.getChiBBillgroup()
                    + "(" + cbg.getFBItemId() + ", " + cbg.getFBillgroupId() + ", "
                    + cbg.getFItemNumber() + ","+cbg.getFDateeff()+","
                    + cbg.getFDateexp()+","+cbg.getFDefinition()+","
                    + cbg.getFItemCommonName()+","+cbg.getFRate()+","
                    + cbg.getFRevrate()+","+cbg.getFSid()+","
                    + cbg.getFSimbgroup()+","+cbg.getFUnit()+","
                    + cbg.getFTmpCode()+","+cbg.getFCsCode()+","
                    + cbg.getFCsRate()+","+cbg.getFCsRevRate()+","
                    + cbg.getFBillinggroupActive()+") "
                    + "Values('" + max + "','" + item.getBillgroupId() + "','"
                    + item.getItemNumber() + "','"+item.getDateeff()+"','"
                    + item.getDateexp()+"','"+item.getDefinition()+"','"
                    + item.getItemCommonName()+"',"+item.getRate()+","
                    + item.getRevrate()+",'"+item.getSid()+"','"
                    + item.getSimbgroup()+"','"+item.getUnit()+"','"
                    + item.getTmpCode()+"','"+item.getCsCode()+"',"
                    + item.getCsRate()+",'"+item.getCsRevRate()+"','"
                    + item.getBillinggroupActive()+"') ";
            }else{
                sql="Update "+cbg.getChiBBillgroup()+" Set "
                    +cbg.getFBillgroupId()+"='"+item.getBillgroupId()+"',"
                    +cbg.getFDateeff()+"='"+item.getDateeff()+"',"
                    +cbg.getFDateexp()+"='"+item.getDateexp()+"',"
                    +cbg.getFDefinition()+"='"+item.getDefinition()+"',"
                    +cbg.getFItemCommonName()+"='"+item.getItemCommonName()+"',"
                    +cbg.getFItemNumber()+"='"+item.getItemNumber()+"',"
                    +cbg.getFRate()+"="+item.getRate()+","
                    +cbg.getFRevrate()+"="+item.getRevrate()+","
                    +cbg.getFSid()+"='"+item.getSid()+"',"
                    +cbg.getFSimbgroup()+"='"+item.getSimbgroup()+"',"
                    +cbg.getFUnit()+"='"+item.getUnit()+"', "
                    +cbg.getFTmpCode()+"='"+item.getTmpCode()+"', "
                    +cbg.getFCsCode()+"='"+item.getCsCode()+"', "
                    +cbg.getFCsRate()+"="+item.getCsRate()+", "
                    +cbg.getFCsRevRate()+"='"+item.getCsRevRate()+"' "
                    + "Where "+cbg.getFBItemId()+"='"+item.getBItemId()+"'";
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String setSaveChiBSurcharge(String branch_id,ChiBSurcharge item) throws Exception {
        int chk = 0;
        String sql = "", max = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            cbs = getChiBSurchareByPK(branch_id, item.getSurchargeId(),"");
            item.setDefinition(config1.StringNull(item.getDefinition()).replace("'", "''"));
//            item.setItemCommonName(config1.StringNull(item.getItemCommonName()).replace("'", "''"));
//            item.(config1.StringNull(item.getVisitDiagnosisNotice()).replace("'", "''"));
            if (cbs.getSurchargeId().equals("")) {
                max = getMaxRowChiBSurcharge(st);
                sql = "Insert Into " + cbs.getChiBSurcharge()
                    + "(" + cbs.getFSurchargeId() + ", " + cbs.getFBranchId() + ", "
                    + cbs.getFDefinition() + ","+cbs.getFItemNumber()+","
                    + cbs.getFRateA()+","+cbs.getFRateB()+","
                    + cbs.getFRateC()+","+cbs.getFRateD()+","
                    + cbs.getFSurcharge()+","+cbs.getFSurchargeActive()+","
                    + cbs.getFTmpCode()+") "
                    + "Values('" + max + "','" + item.getBranchId() + "','"
                    + item.getDefinition() + "','"+item.getItemNumber()+"',"
                    + item.getRateA()+","+item.getRateB()+","
                    + item.getRateC()+","+item.getRateD()+","
                    + item.getSurcharge()+",'"+item.getSurchargeActive()+"','"
                    + item.getTmpCode()+"') ";
            }else{
                sql="Update "+cbs.getChiBSurcharge()+" Set "
                    +cbs.getFBranchId()+"='"+item.getBranchId()+"',"
                    +cbs.getFDefinition()+"='"+item.getDefinition()+"',"
                    +cbs.getFItemNumber()+"='"+item.getItemNumber()+"',"
                    +cbs.getFRateA()+"='"+item.getRateA()+"',"
                    +cbs.getFRateB()+"='"+item.getRateB()+"',"
                    +cbs.getFRateC()+"='"+item.getRateC()+"',"
                    +cbs.getFRateD()+"="+item.getRateD()+","
                    +cbs.getFSurcharge()+"="+item.getSurcharge()+","
                    +cbs.getFSurchargeActive()+"='"+item.getSurchargeActive()+"',"
                    +cbs.getFTmpCode()+"='"+item.getTmpCode()+"',"
                    + "Where "+cbs.getFSurchargeId()+"='"+item.getSurchargeId()+"'";
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String getTrChiGovFront(String branch_id, String date_start, String date_end, String paidId){
        StringBuilder txt= new StringBuilder();
        String t_head="", link="";
        Vector v_visit = new Vector();
        Integer i=0;
        try {
            branch = config1.getBranch(branch_id);
            if(branch.getBranchNamet().equals("เมืองสมุทรปู่เจ้า")){
                v_visit = config1.getPatientVisit(branch, date_start, date_end, "", "period_date_muangsamut");
            }else{
                v_visit = config1.getPatientVisit(branch, date_start, date_end, paidId, "period_date");
            }
            
            for(i=0;i<=v_visit.size()-1;i++){
                pv = (PatientVisit)v_visit.get(i);
                link = "<label><input type='checkbox' id ='chk_"+i+"'/>"+pv.getPatientNamet()+"</lable>";
                txt.append("<tr><td>").append(i+1).append("</td><td>").append(link).append("</td><td>")
                .append(pv.getPatientHn()).append("</td><td>").append(pv.getVisitVn()).append("</td><td>")
                .append(config1.DateFormatDB2ShowHospital(pv.getVisitDate(),"ddMMyyyy")).append(" ").append(pv.getVisitTime()).append("</td><td>")
                .append(config1.DateFormatDB2Show(pv.getVisitFinancialDischargeTime(),"ddMMyyyy")).append("</td><td>").append(pv.getContractPayerNumber()).append("</td><td>")
                .append(pv.getPaid()).append("<input type='hidden' id='txt_visit_id").append(i).append("' value='").append(pv.getTVisitId()).append("' />")
                .append("<input type='hidden' id='txt_payment_id").append(i).append("' value='").append(pv.getTVisitPaymentId()).append("' />").append("</td></tr>");
            }
            t_head="<table class ='tablecolors' id='t_left'><tr><th>ลำดับ</th><th>ชื่อ-นามสกุล</th>"
                    + "<th>hn</th><th>vn</th><th>วันเข้า</th><th>วันออก</th><th>สิทธิ</th><th>ยอดรักษา<input type='hidden' id='txt_row' value='"+i+"'></th></tr>";
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t_head+txt.toString()+"</table>";
    }
    public String getTrChiGovItem(String branch_id, String cgov_id){
        StringBuilder txt = new StringBuilder();
        String t_head="", script="", link_del="", link="",txtHidden="";
        Vector v_cgov = new Vector();
        v_cgov = getChiTGovItem(branch_id, cgov_id,"");
        for(int i=0;i<=v_cgov.size()-1;i++){
            cgovi = (ChiTGovItem)v_cgov.get(i);
            txtHidden = "<input type='hidden' id='txtfullname"+cgovi.getChiGovItemId()+"' value='"+cgovi.getPatientFullnamet()+"'>";
            txtHidden += "<input type='hidden' id='txtpid"+cgovi.getChiGovItemId()+"' value='"+cgovi.getPid()+"'>";
            txtHidden += "<input type='hidden' id='txtsurchargeid"+cgovi.getChiGovItemId()+"' value='"+cgovi.getSurchargeId()+"'>";
            txtHidden += "<input type='hidden' id='txtan"+cgovi.getChiGovItemId()+"' value='"+cgovi.getVisitAn()+"'>";
            txtHidden += "<input type='hidden' id='txtadmitday"+cgovi.getChiGovItemId()+"' value='"+cgovi.getAdmitDay()+"'>";
            link = "<a href='javascript:showDialogEditItem("+cgovi.getChiGovItemId()+")'/>"+cgovi.getPatientFullnamet()+"</a>";
            link_del = "<a href='javascript:showDialogVoidItem("+cgovi.getChiGovItemId()+")'/><img src='images/trash1.gif' alt='' name='item_void' id='item_void' border='0' align='top' title='ลบข้อมูล...' /></a>";
            txt.append("<tr><td>").append(i+1).append("</td><td>").append(link).append("</td><td>")
                    .append(cgovi.getVisitHn()).append("</td><td>").append(cgovi.getVisitVn()).append("</td><td>")
                    .append(cgovi.getVisitTotal()).append("</td><td>").append(link_del).append(txtHidden).append("</td></tr>");
        }
        script = "<script> $('#txt_chi_gov_id').val("+cgov_id+"); </script>";
        t_head = "<table><tr><th>ลำดับ</th><th>ชื่อ-นามสกุล</th><th>hn</th><th>vn</th><th>จำนวนเงิน</th<th></th></tr>";
        return t_head+txt.toString()+"</table>"+script;
    }
    public String setSaveChiGov(String branch_id, String data, String cgov_id, String chi_gov_date, String description,
            String remark, String auth_code, String auth_dt){
        Integer len_data = 0;
        String visit_id="", cgov_id1="", sql="", payment_id="";
        String[] aaa = data.split("\\^");
        len_data = Integer.valueOf(data.length());
        BackTPatientVisitDB bpvdb = new BackTPatientVisitDB();
        Vector v_visit = new Vector();
        PatientDB patientdb = new PatientDB();
//        Connection conn;
//        Statement st;
        try {
            branch = config1.getBranch(branch_id);
            cgov.setChiGovId(cgov_id);
            cgov.setChiGovActive("1");
            cgov.setChiGovDate(config1.DateFormatShow2DB(chi_gov_date,"ddMMyyyy"));
            cgov.setDescription(description);
            cgov.setStatusChiGov("1");
            cgov.setRemark(remark);
            cgov.setAuthCode(auth_code);
            cgov.setAuthDt(auth_dt);
            cgov_id1= setSaveChiTGov(branch_id, cgov);
            for (int i = 0; i <= aaa.length - 1; i++) {
                try {
                    visit_id = aaa[i];
                    if (visit_id.length() <= 0) {
                        continue;
                    }
                    String[] bbb = visit_id.split("\\:");
                    visit_id = bbb[0];
                    payment_id = bbb[1];
                    if (visit_id.length() <= 0) {
                        continue;
                    }
                    v_visit = config1.getPatientVisit(branch, payment_id, "", "", "t_visit_payment_id");
                    if(v_visit.size()>0){
                        pv = (PatientVisit)v_visit.get(0);
                        patientdb.vpatient = patientdb.getPatientV(branch_id, pv.getPatientHn(), sql);
    //                    bpvdb.bpv = bpvdb.getBackTPatientVisitByPK(visit_id, "visit_id");
                        cgovi = new ChiTGovItem();
                        cgovi.setChiGovId(cgov_id1);
                        cgovi.setChiGovItemActive("1");
                        cgovi.setChiGovItemDate(pv.getVisitDate());
                        cgovi.setChiGovItemId("");
                        cgovi.setVisitId(pv.getTVisitId());
                        cgovi.setVisitTotal(pv.getPaid());
                        cgovi.setVisitHn(pv.getPatientHn());
                        cgovi.setVisitVn(pv.getVisitVn());
                        cgovi.setPatientFullnamet(pv.getPatientNamet());
                        cgovi.setStatusChi("1");
                        cgovi.setPaidId(pv.getVisitPaidId());
                        cgovi.setAuthCode(auth_code);
                        cgovi.setAuthDt(auth_dt);
                        cgovi.setTVisitPaymentId(pv.getTVisitPaymentId());
                        cgovi.setVisitAn(pv.getVisitAn());
                        cgovi.setPid(patientdb.vpatient.getPatientPid());
                        cgovi.setSurchargeId("");
                        cgovi.setAdmitDay(0.0);
                        setSaveChiTGovItem(branch_id, cgovi);
                    }
                    
                } catch (Exception ex) {
                    Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cgov_id1;
    }
    public void setDocChiGoc(String branch_id,String cgov_id){
//        nhso.createXmlChiNhso(branch_id, cgov_id);
    }
    public String setChiGov(String branch_id, String data, String cgov_id, String chi_gov_date, String description, String remark,
            String auth_code, String auth_dt) {
        String cgob_id1 = setSaveChiGov(branch_id, data, cgov_id, chi_gov_date, description, remark, auth_code, auth_dt);
        String txt = getTrChiGovItem(branch_id, cgob_id1);
        return txt;
    }
    public String setChiGovItemVoid(String branch_id, String cgov_id, String cgovi_id){
        setUpdateChiGovItemVoid(branch_id, cgovi_id);
        String txt = getTrChiGovItem(branch_id, cgov_id);
        return txt;
    }
    public void setUpdateChiGovItemVoid(String branch_id, String cgovi_id) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + cgovi.getChiTGovItem()
                  + " Set " + cgovi.getFChiGovItemActive() + "='3' "
                  + "Where " + cgovi.getFChiGovItemId() + "='" + cgovi_id + "'";

          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdateChiGovItemPid(String branch_id, String cgovi_id, String pid, String surchargeId, String an, String admitDay) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + cgovi.getChiTGovItem()
                  + " Set " + cgovi.getFPid() + "='"+pid+"', "
                  +cgovi.getFSurchargeId()+"='"+surchargeId+"', "
                  +cgovi.getFVisitAn()+"='"+an+"', "
                  +cgovi.getFAdmitDay()+"='"+admitDay+"' "
                  + "Where " + cgovi.getFChiGovItemId() + "='" + cgovi_id + "'";

          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getTrChiGov(String branch_id, String cgov_id, String flag){
        StringBuilder txt = new StringBuilder();
        String t_head="", script="", t_footer="", link="";
        Vector v_cgov = new Vector();
        v_cgov = getChiTGov(branch_id, cgov_id,flag);
        for(int i=0;i<=v_cgov.size()-1;i++){
            cgov = (ChiTGov)v_cgov.get(i);
            if(!cgov.getDescription().equals("")){
                link = "<a href='javascript:showCgov("+cgov.getChiGovId()+")'>"+cgov.getDescription()+"</a>";
            }else{
                link = "<a href='javascript:showCgov("+cgov.getChiGovId()+")'>-</a>";
            }
            if(!cgov.getRemark().equals("")){
                link += cgov.getRemark();
            }
            txt.append("<tr><td>").append(i+1).append("</td><td>").append(link).append("</td><td>").append(cgov.getCntItem()).append("</td><td>").append(cgov.getVisitTotal()).append("</td></tr>");
        }
        //script = "<script> $('#txt_chi_gov_id').val("+cgov_id+"); </script>";
        //t_head = "<table><tr><th>ลำดับ</th><th>ชื่อ-นามสกุล</th><th>hn</th><th>vn</th><th>จำนวนเงิน</th></tr>";
        //t_footer = "</table>";
        return t_head+txt.toString()+t_footer+script;
    }
    public String getTrBitem(String branch_id, String where, String flag){
        StringBuilder txt = new StringBuilder();
        String t_head="", script="", t_footer="", link="";
        Vector v_bitem = new Vector();
        v_bitem = config1.getBItem(branch_id, where);
        for(int i=0;i<=v_bitem.size()-1;i++){
            bitem = (BItem)v_bitem.get(i);
            if(!bitem.getItemCommonName().equals("")){
                link = "<a href='javascript:showCgov("+bitem.getItemNumber()+")'>"+bitem.getItemCommonName()+"</a>";
            }else{
                link = "<a href='javascript:showCgov("+bitem.getItemNumber()+")'>-</a>";
            }
            txt.append("<tr><td>").append(i+1).append("</td><td>").append(link).append("</td><td>").append(cgov.getCntItem()).append("</td><td>").append(cgov.getVisitTotal()).append("</td></tr>");
        }
        //script = "<script> $('#txt_chi_gov_id').val("+cgov_id+"); </script>";
        //t_head = "<table><tr><th>ลำดับ</th><th>ชื่อ-นามสกุล</th><th>hn</th><th>vn</th><th>จำนวนเงิน</th></tr>";
        //t_footer = "</table>";
        return t_head+txt.toString()+t_footer+script;
    }
    public String getTrChiFBillgroup(String branch_id, String where, String flag){
        StringBuilder txt = new StringBuilder();
        String t_head="", script="", t_footer="", link="", txt_billgroup_id="", txt_billgroup_name="", chk_status_16="", txt_item16_number="";
        String chk16="", unchk16="",txt_row="",txt_name="";
        Vector v_billgroup = new Vector();
        v_billgroup = getChiFBillgroup(branch_id, where,flag);
        Integer ii=0;
        for(int i=0;i<=v_billgroup.size()-1;i++){
            cfbg = (ChiFBillgroup)v_billgroup.get(i);
            if(cfbg.getStatus16Group().equals("1")) {
                chk16="checked";
                unchk16="";
//                link = "<a href='javascript:showCgov("+bitem.getItemNumber()+")'>"+bitem.getItemCommonName()+"</a>";
            }else{
                chk16="";
                unchk16="checked";
//                link = "<a href='javascript:showCgov("+bitem.getItemNumber()+")'>-</a>";
            }
            ii++;
            
            txt_billgroup_id = "<input type='text' id='txt_billgroup_id"+i+"' value='"+cfbg.getBillgroupId()+"' size='5'>";
            txt_name = "<input type='text' id='txt_billgroup_name"+i+"' value='"+cfbg.getBillgroupNamet()+"' size='40'>";
            txt_item16_number = "<input type='text' id='txt_item16_number"+i+"' value='"+cfbg.getItem16GroupNumber()+"' size='5'>";
            chk_status_16 = "<label><input type='radio' "+chk16+" id='chk_use_status_16"+i+"' name = 'chk_status_16"+i+"' value='1' onchange='setitem16group("+i+")' > ใช้ item16group</label>"
                    + "<label><input type='radio' "+unchk16+" id='chk_unuse_status_16"+i+"' name = 'chk_status_16"+i+"' value='0' onchange='setitem16group("+i+")'> ไม่ใช้ item16group</label>";
            txt.append("<tr><td>").append(i+1).append("</td><td>").append(txt_billgroup_id).append("</td><td>").append(txt_name)
                .append("</td><td>").append(chk_status_16).append("</td><td>").append(txt_item16_number)
                .append("</td><td><img src='images/savedrafticon.gif' alt='' name='save_f_billgroup").append(i).append("' id='save_f_billgroup").append(i).append("' border='0' align='top' title='บันทึกข้อมูล' onclick='showDialogSaveFBillGroup(").append(i).append(");'></td></tr>");
        }
        txt_row = "<input type='hidden' id='txt_row_fbillgroup' value='"+ii.toString()+"'>";
        script = "<script>setitem16groupall(); </script>";
        t_head = "<table id='tr_billgroup'><tr><th width='5'>ลำดับ</th><th width='10'>รหัส</th><th>รายการ</th><th>status billgroup</th>"
                + "<th width='15'>item16groupnumber</th><th></th></tr>";
        t_footer = "</table>";
        return t_head+txt.toString()+t_footer+txt_row+script;
    }
    public String getTrChiBSurcharge(String branchId, String where, String flag){
        StringBuilder txt = new StringBuilder();
        String t_head="", script="", t_footer="", link="",txt_row="", txtItemNumber="", txtTmpCode="", txtDefinition="", txtRateA="";
        String txtRateB="", txtRateC="", txtRateD="",txtSurcharge="", txtSurchargeId="";
        Vector vbSurcharge = new Vector();
        vbSurcharge = getChiBSurchare(branchId, where,flag);
        Integer i=0;
        for(i=0;i<=vbSurcharge.size()-1;i++){
            cbs = (ChiBSurcharge)vbSurcharge.get(i);
            txtItemNumber = "<input type='text' id='txtItemNumber"+i+"' value='"+cbs.getItemNumber()+"' size='8'/>";
            txtTmpCode = "<input type='text' id='txtTmpCode"+i+"' value='"+cbs.getTmpCode()+"' size='8'/>";
            txtDefinition = "<input type='text' id='txtDefinition"+i+"' value='"+cbs.getDefinition()+"' size='40'/>";
            txtRateA = "<input type='text' id='txtRateA"+i+"' value='"+cbs.getRateA()+"' size='8' class='numeric'/>";
            txtRateB = "<input type='text' id='txtRateB"+i+"' value='"+cbs.getRateB()+"' size='8' class='numeric'/>";
            txtRateC = "<input type='text' id='txtRateC"+i+"' value='"+cbs.getRateC()+"' size='8' class='numeric'/>";
            txtRateD = "<input type='text' id='txtRateD"+i+"' value='"+cbs.getRateD()+"' size='8' class='numeric'/>";
            txtSurcharge = "<input type='text' id='txtSurcharge"+i+"' value='"+cbs.getSurcharge()+"' size='8' class='numeric'/>";
            txtSurchargeId = "<input type='hidden' id='txtSurchargeId"+i+"' value='"+cbs.getSurchargeId()+"' />";
            txt.append("<tr><td>").append(i+1).append("</td><td>").append(txtItemNumber).append("</td><td>").append(txtTmpCode)
                    .append("</td><td>").append(txtDefinition).append("</td><td>").append(txtRateA)
                    .append("</td><td>").append(txtRateB).append("</td><td>").append(txtRateC)
                    .append("</td><td>").append(txtRateD).append("</td><td>").append(txtSurcharge).append(txtSurchargeId)
                    .append("</td></tr>");
        }
        txt_row = "<input type='hidden' id='txt_row_bsurcharge' value='"+i.toString()+"'>";
        t_head = "<table id='tr_surcharge'><tr><th width='5'>ลำดับ</th><th width='10'>รหัส</th><th width='10'>tmpcode</th>"
                + "<th>รายการ</th><th>rateA</th><th>rateB</th><th>rateC</th><th>rateD</th><th>surcharge</th>";
        t_footer = "</table>";
        return t_head+txt.toString()+t_footer+txt_row+script;
    }
    public void setUpdateChiFBillgroup(String branch_id, String billgroup_id, String billgroup_name, String status16group,
            String item16groupnumber) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + cfbg.getChiFBillgroup()
                  + " Set " + cfbg.getFBillgroupId() + "='"+billgroup_id+"', "
                  + cfbg.getFBillgroupNamet() + "='"+billgroup_name+"', "
                  + cfbg.getFStatus16Group() + "='"+status16group+"', "
                  + cfbg.getFItem16GroupNumber() + "='"+item16groupnumber+"' "
                  + "Where " + cfbg.getFBillgroupId() + "='" + billgroup_id + "'";

          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getTrChiBBillgroup(String branch_id, String where, String flag){
        StringBuilder txt = new StringBuilder();
        String t_head="", script="", t_footer="", link="",txt_row="", hidden="", link1="", linkvoid="";
        Vector v_billgroup = new Vector();
        v_billgroup = getChiBBillgroup(branch_id, where,flag);
        for(int i=0;i<=v_billgroup.size()-1;i++){
            cbg = (ChiBBillgroup)v_billgroup.get(i);
            link = "<a href='javascript:showBBillinggroup("+i+")'/>"+cbg.getDefinition()+"</a>";
            link1 = "<img src='images/new.gif'  id='loadernew"+i+"' alt='' onclick='showBBillinggroup("+i+")'>";
            linkvoid = "<img src='images/trash1.gif'  id='loadervoid"+i+"' alt='' onclick='showVoid("+i+")'>";
            hidden = "<input type='hidden' id='txtbitemid"+i+"' value='"+cbg.getBItemId()+"' />";
            hidden += "<input type='hidden' id='txtitemnumber"+i+"' value='"+cbg.getItemNumber()+"' />";
            hidden += "<input type='hidden' id='txtbillinggroupid"+i+"' value='"+cbg.getBillgroupId()+"' />";
            hidden += "<input type='hidden' id='txtitemcommonname"+i+"' value='"+cbg.getItemCommonName()+"' />";
            hidden += "<input type='hidden' id='txtsimb"+i+"' value='"+cbg.getSimbgroup()+"' />";
            hidden += "<input type='hidden' id='txtdefinition"+i+"' value='"+cbg.getDefinition()+"' />";
            hidden += "<input type='hidden' id='txtunit"+i+"' value='"+cbg.getUnit()+"' />";
            hidden += "<input type='hidden' id='txtrate"+i+"' value='"+cbg.getRate()+"' />";
            hidden += "<input type='hidden' id='txtrevrate"+i+"' value='"+cbg.getRevrate()+"' />";
            hidden += "<input type='hidden' id='txtdateeff"+i+"' value='"+cbg.getDateeff()+"' />";
            hidden += "<input type='hidden' id='txtdateexp"+i+"' value='"+cbg.getDateexp()+"' />";
            hidden += "<input type='hidden' id='txtsid"+i+"' value='"+cbg.getSid()+"' />";
            hidden += "<input type='hidden' id='txtbillinggroupname"+i+"' value='"+cbg.getBillgroupName()+"' />";
            hidden += "<input type='hidden' id='txttmpcode"+i+"' value='"+cbg.getTmpCode()+"' />";
            hidden += "<input type='hidden' id='txtcscode"+i+"' value='"+cbg.getCsCode()+"' />";
            hidden += "<input type='hidden' id='txtcsrate"+i+"' value='"+cbg.getCsRate()+"' />";
            hidden += "<input type='hidden' id='txtcsrevrate"+i+"' value='"+cbg.getCsRevRate()+"' />";
            txt.append("<tr><td>").append(i+1).append("</td><td>").append(cbg.getItemNumber()).append("</td><td>").append(cbg.getItemCommonName()).append("</td><td>")
                    .append(cbg.getSimbgroup()).append("</td><td>").append(link).append("</td><td>").append(cbg.getUnit()).append("</td><td>").append(config1.NumberFormat(cbg.getRate())).append("</td><td>")
                    .append(config1.NumberFormat(cbg.getRevrate())).append(hidden).append("</td><td>").append(link1).append("</td><td>").append(linkvoid).append("</td></tr>");
        }

        t_head = "<table id='tr_billgroup'><tr><th width='5'>ลำดับ</th><th width='10'>รหัส</th><th>รายการ</th><th>simbgroup</th>"
                + "<th>definition</th><th>unit</th><th>rate</th><th>revrate</th><th>แก้ไข</th><th>ยกเลิก</th></tr>";
        return t_head+txt.toString()+t_footer+txt_row+script;
    }
    private void setUpdateBItemCSCODE(String branchId,String itemNumber, String cscode){
        String sql="";
        try {
          Connection conn = config1.getConnectionHospital(branchId);
          Statement st = conn.createStatement();
          sql = "Update b_item Set cscode = '"+cscode+"' Where item_number = '"+itemNumber+"' ";
          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setChiBBillinggroup(String branchId, ChiBBillgroup item){
        try {
            setSaveChiBBillgroup(branchId, item);
            setUpdateBItemCSCODE(branchId,item.getItemNumber(), item.getCsCode());
        } catch (Exception ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void setUpdateBBillingGroupVoid(String branchId,String bItemid){
        String sql="";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update "+cbg.getChiBBillgroup()+" Set "+cbg.getFBillinggroupActive()+" = '3' "
                  + "Where "+cbg.getFBItemId()+" = '"+bItemid+"' ";
          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getEndNote(String data){
        String endNote="";
        String CRLF="\r\n";
        try {
            endNote = AeSimpleMD5.MD5(data);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ChiTGovDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return endNote;
    }
}
