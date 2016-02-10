package bangnaLibrary;

import com.bangna.object.VTBillingInvoiceSubgroupN;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CashierTBillingInvoicePrintDB {
    Config1 config1;
    public CashierTBillingInvoicePrint ctbIp = new CashierTBillingInvoicePrint();
    public CashierTBillingInvoicePrintDetail ctbIpD = new CashierTBillingInvoicePrintDetail();
    public CashierTBillingReceivePrint ctbRp = new CashierTBillingReceivePrint();
    public CashierTBillingReceivePrintDetail ctbRpD = new CashierTBillingReceivePrintDetail();
    VTBillingInvoiceSubgroup vvb_is = new VTBillingInvoiceSubgroup();
    VTBillingInvoiceSubgroupN vvb_isN = new VTBillingInvoiceSubgroupN();
    BItem b_item = new BItem();
    final private String idtableInvItem = "170";
    final private String idtableInv = "169";
    final private String idtableRecItem = "172";
    final private String idtableRec = "163";

    public CashierTBillingInvoicePrintDB(Config1 cf){
        config1 = cf;
    }
    public String getMaxRowCashierTBillingInvoicePrint(Connection conn) {
        String sql = ""; String max = "";
        try{
          Statement st = conn.createStatement();

          sql = "Select max(" + ctbIp.getFTBillingInvoicePrintId() + ") as cnt From " + ctbIp.getCashierTBillingInvoicePrint();
          ResultSet rs = st.executeQuery(sql);
          while (rs.next()) {
            max = rs.getString("cnt");
          }
          rs.close();
          if ((max != null) && (!max.equals(""))) max = String.valueOf(Integer.parseInt(max) + 1);
          else max = "16900000001";
        }catch (Exception ex) {
          Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowCashierTBillingReceivePrint(Connection conn) {
        String sql = ""; String max = "";
        try{
          Statement st = conn.createStatement();

          sql = "Select max(" + ctbRp.getFTBillingReceivePrintId() + ") as cnt From " + ctbRp.getCashierTBillingReceivePrint();
          ResultSet rs = st.executeQuery(sql);
          while (rs.next()) {
            max = rs.getString("cnt");
          }
          rs.close();
          if ((max != null) && (!max.equals(""))) max = String.valueOf(Integer.parseInt(max) + 1);
          else max = "17300000001";
        }catch (Exception ex) {
          Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowCashierTBillingInvoicePrintDetail(Connection conn) {
        String sql = ""; String max = "";
        try{
            Statement st = conn.createStatement();

            sql = "Select max(" + ctbIpD.getFTBillingInvoicePrintDetailId() + ") as cnt From " + ctbIpD.getCashierTBillingInvoicePrintDetail();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))  max = String.valueOf(Integer.parseInt(max) + 1);
            else max = "17000000001";
        }catch (Exception ex) {
            Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowCashierTBillingInvoicePrintDetail(Statement st) {
        String sql = ""; String max = "";
        try{
//            Statement st = conn.createStatement();
            sql = "Select max(" + ctbIpD.getFTBillingInvoicePrintDetailId() + ") as cnt From " + ctbIpD.getCashierTBillingInvoicePrintDetail();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))  max = String.valueOf(Integer.parseInt(max) + 1);
            else max = "17000000001";
        }catch (Exception ex) {
            Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowCashierTBillingReceivePrintDetail(Connection conn) {
        String sql = ""; String max = "";
        try {
            Statement st = conn.createStatement();

            sql = "Select max(" + ctbRpD.getFTBillingReceivePrintDetailId() + ") as cnt From " + ctbRpD.getCashierTBillingReceivePrintDetail();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals(""))) max = String.valueOf(Integer.parseInt(max) + 1);
            else max = "17200000001";
        }catch (Exception ex) {
            Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }

  public CashierTBillingInvoicePrint getCashierTBillingInvoicePrintByPK(String brach_id, String close_day_invoice_id, String flag) {
    String sql = "";
    try {
      Connection conn = config1.getConnectionBangna();
      Statement stbangna = conn.createStatement();

      if (flag.equals("invoice_number")) {
        sql = "Select * From " + ctbIp.getCashierTBillingInvoicePrint() + " "
                + "Where " + ctbIp.getFInvoiceNumber() + "='" + close_day_invoice_id + "'";
      }else {
        sql = "Select * From " + ctbIp.getCashierTBillingInvoicePrint() + " "
                + "Where " + ctbIp.getFTBillingInvoicePrintId() + "='" + close_day_invoice_id + "'";
      }

      ResultSet rs = stbangna.executeQuery(sql);
      while (rs.next()) {
        ctbIp = new CashierTBillingInvoicePrint();
        ctbIp.setPatientAddress(config1.StringNull(rs.getString(ctbIp.getFPatientAddress())));
        ctbIp.setPatientAge(config1.StringNull(rs.getString(ctbIp.getFPatientAge())));
        ctbIp.setPatientFullnamet(config1.StringNull(rs.getString(ctbIp.getFPatientFullnamet())));
        ctbIp.setPatientPid(config1.StringNull(rs.getString(ctbIp.getFPatientPid())));
        ctbIp.setTBillingInvoiceId(config1.StringNull(rs.getString(ctbIp.getFTBillingInvoiceId())));

        ctbIp.setTBillingInvoicePrintActive(config1.StringNull(rs.getString(ctbIp.getFTBillingInvoicePrintActive())));
        ctbIp.setTBillingInvoicePrintDate(config1.StringNull(rs.getString(ctbIp.getFTBillingInvoicePrintDate())));
        ctbIp.setTBillingInvoicePrintId(config1.StringNull(rs.getString(ctbIp.getFTBillingInvoicePrintId())));
        ctbIp.setTVisitHn(config1.StringNull(rs.getString(ctbIp.getFTVisitHn())));
        ctbIp.setTVisitId(config1.StringNull(rs.getString(ctbIp.getFTVisitId())));

        ctbIp.setTVisitVn(config1.StringNull(rs.getString(ctbIp.getFTVisitVn())));
        ctbIp.setVisitTypeDescription(config1.StringNull(rs.getString(ctbIp.getFVisitTypeDescription())));
        ctbIp.setBillingInvoiceNo(config1.StringNull(rs.getString(ctbIp.getFBillingInvoiceNo())));
        ctbIp.setBillingInvoiceDate(config1.StringNull(rs.getString(ctbIp.getFBillingInvoiceDate())));
        ctbIp.setPatientCompanyName(config1.StringNull(rs.getString(ctbIp.getFPatientCompanyName())));

        ctbIp.setInjuryNo(config1.StringNull(rs.getString(ctbIp.getFInjuryNo())));
        ctbIp.setSickness(config1.StringNull(rs.getString(ctbIp.getFSickness())));
        ctbIp.setVisitDate(config1.StringNull(rs.getString(ctbIp.getFVisitDate())));
        ctbIp.setVisitTime(config1.StringNull(rs.getString(ctbIp.getFVisitTime())));
        ctbIp.setDischargeDate(config1.StringNull(rs.getString(ctbIp.getFDischargeDate())));

        ctbIp.setDischargeTime(config1.StringNull(rs.getString(ctbIp.getFDischargeTime())));
        ctbIp.setAmount(rs.getDouble(ctbIp.getFAmount()));
        ctbIp.setDiscount(rs.getDouble(ctbIp.getFDiscount()));
        ctbIp.setNettotal(rs.getDouble(ctbIp.getFNettotal()));
        ctbIp.setInvoiceNumber(config1.StringNull(rs.getString(ctbIp.getFInvoiceNumber())));
      }

      rs.close();
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ctbIp;
  }

  public CashierTBillingReceivePrint getCashierTBillingReceivePrintByPK(String brach_id, String close_day_invoice_id, String flag) {
    String sql = "";
    try {
      Connection conn = config1.getConnectionBangna();
      Statement stbangna = conn.createStatement();
      sql = "Select * From " + ctbRp.getCashierTBillingReceivePrint() + " " 
              + "Where " + ctbRp.getFTBillingReceivePrintId() + "='" + close_day_invoice_id + "'";
      ResultSet rs = stbangna.executeQuery(sql);
      while (rs.next()) {
        ctbRp = new CashierTBillingReceivePrint();
        ctbRp.setPatientAddress(config1.StringNull(rs.getString(ctbRp.getFPatientAddress())));
        ctbRp.setPatientAge(config1.StringNull(rs.getString(ctbRp.getFPatientAge())));
        ctbRp.setPatientFullnamet(config1.StringNull(rs.getString(ctbRp.getFPatientFullnamet())));
        ctbRp.setPatientPid(config1.StringNull(rs.getString(ctbRp.getFPatientPid())));
        ctbRp.setTBillingInvoiceId(config1.StringNull(rs.getString(ctbRp.getFTBillingInvoiceId())));

        ctbRp.setTBillingReceivePrintActive(config1.StringNull(rs.getString(ctbRp.getFTBillingReceivePrintActive())));
        ctbRp.setTBillingReceivePrintDate(config1.StringNull(rs.getString(ctbRp.getFTBillingReceivePrintDate())));
        ctbRp.setTBillingReceivePrintId(config1.StringNull(rs.getString(ctbRp.getFTBillingReceivePrintId())));
        ctbRp.setTVisitHn(config1.StringNull(rs.getString(ctbRp.getFTVisitHn())));
        ctbRp.setTVisitId(config1.StringNull(rs.getString(ctbRp.getFTVisitId())));

        ctbRp.setTVisitVn(config1.StringNull(rs.getString(ctbRp.getFTVisitVn())));
        ctbRp.setVisitTypeDescription(config1.StringNull(rs.getString(ctbRp.getFVisitTypeDescription())));
        ctbRp.setBillingInvoiceNo(config1.StringNull(rs.getString(ctbRp.getFBillingInvoiceNo())));
        ctbRp.setBillingInvoiceDate(config1.StringNull(rs.getString(ctbRp.getFBillingInvoiceDate())));
        ctbRp.setPatientCompanyName(config1.StringNull(rs.getString(ctbRp.getFPatientCompanyName())));

        ctbRp.setInjuryNo(config1.StringNull(rs.getString(ctbRp.getFInjuryNo())));
        ctbRp.setSickness(config1.StringNull(rs.getString(ctbRp.getFSickness())));
        ctbRp.setVisitDate(config1.StringNull(rs.getString(ctbRp.getFVisitDate())));
        ctbRp.setVisitTime(config1.StringNull(rs.getString(ctbRp.getFVisitTime())));
        ctbRp.setDischargeDate(config1.StringNull(rs.getString(ctbRp.getFDischargeDate())));

        ctbRp.setDischargeTime(config1.StringNull(rs.getString(ctbRp.getFDischargeTime())));
        ctbRp.setAmount(rs.getDouble(ctbRp.getFAmount()));
        ctbRp.setDiscount(rs.getDouble(ctbRp.getFDiscount()));
        ctbRp.setNettotal(rs.getDouble(ctbRp.getFNettotal()));
        ctbRp.setReceiveNumber(config1.StringNull(rs.getString(ctbRp.getFReceiveNumber())));
      }

      rs.close();
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ctbRp;
  }

  public Vector getCashierTBillingInvoicePrint(String brach_id, String close_day_invoice_id, String flag) {
    String sql = "";
    Vector v_t_billing_invoice_print = new Vector();
    try {
      Connection conn = config1.getConnectionBangna();
      Statement stbangna = conn.createStatement();
      sql = "Select * From " + ctbIp.getCashierTBillingInvoicePrint() + " " 
              + "Where " + ctbIp.getFTBillingInvoicePrintId() + "='" + close_day_invoice_id + "'";
      ResultSet rs = stbangna.executeQuery(sql);
      while (rs.next()) {
        ctbIp = new CashierTBillingInvoicePrint();
        ctbIp.setPatientAddress(config1.StringNull(rs.getString(ctbIp.getFPatientAddress())));
        ctbIp.setPatientAge(config1.StringNull(rs.getString(ctbIp.getFPatientAge())));
        ctbIp.setPatientFullnamet(config1.StringNull(rs.getString(ctbIp.getFPatientFullnamet())));
        ctbIp.setPatientPid(config1.StringNull(rs.getString(ctbIp.getFPatientPid())));
        ctbIp.setTBillingInvoiceId(config1.StringNull(rs.getString(ctbIp.getFTBillingInvoiceId())));

        ctbIp.setTBillingInvoicePrintActive(config1.StringNull(rs.getString(ctbIp.getFTBillingInvoicePrintActive())));
        ctbIp.setTBillingInvoicePrintDate(config1.StringNull(rs.getString(ctbIp.getFTBillingInvoicePrintDate())));
        ctbIp.setTBillingInvoicePrintId(config1.StringNull(rs.getString(ctbIp.getFTBillingInvoicePrintId())));
        ctbIp.setTVisitHn(config1.StringNull(rs.getString(ctbIp.getFTVisitHn())));
        ctbIp.setTVisitId(config1.StringNull(rs.getString(ctbIp.getFTVisitId())));

        ctbIp.setTVisitVn(config1.StringNull(rs.getString(ctbIp.getFTVisitVn())));
        ctbIp.setVisitTypeDescription(config1.StringNull(rs.getString(ctbIp.getFVisitTypeDescription())));
        ctbIp.setBillingInvoiceNo(config1.StringNull(rs.getString(ctbIp.getFBillingInvoiceNo())));
        ctbIp.setBillingInvoiceDate(config1.StringNull(rs.getString(ctbIp.getFBillingInvoiceDate())));
        ctbIp.setPatientCompanyName(config1.StringNull(rs.getString(ctbIp.getFPatientCompanyName())));

        ctbIp.setInjuryNo(config1.StringNull(rs.getString(ctbIp.getFInjuryNo())));
        ctbIp.setSickness(config1.StringNull(rs.getString(ctbIp.getFSickness())));
        ctbIp.setVisitDate(config1.StringNull(rs.getString(ctbIp.getFVisitDate())));
        ctbIp.setVisitTime(config1.StringNull(rs.getString(ctbIp.getFVisitTime())));
        ctbIp.setDischargeDate(config1.StringNull(rs.getString(ctbIp.getFDischargeDate())));

        ctbIp.setDischargeTime(config1.StringNull(rs.getString(ctbIp.getFDischargeTime())));
        ctbIp.setAmount(rs.getDouble(ctbIp.getFAmount()));
        ctbIp.setDiscount(rs.getDouble(ctbIp.getFDiscount()));
        ctbIp.setNettotal(rs.getDouble(ctbIp.getFNettotal()));
        ctbIp.setInvoiceNumber(config1.StringNull(rs.getString(ctbIp.getFInvoiceNumber())));

        v_t_billing_invoice_print.add(ctbIp);
      }
      rs.close();
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return v_t_billing_invoice_print;
  }

  public Vector getCashierTBillingReceivePrint(String brach_id, String close_day_invoice_id, String flag) {
    String sql = "";
    Vector v_t_billing_receive_print = new Vector();
    try {
      Connection conn = config1.getConnectionBangna();
      Statement stbangna = conn.createStatement();
      sql = "Select * From " + ctbRp.getCashierTBillingReceivePrint() + " " 
              + "Where " + ctbRp.getFTBillingReceivePrintId() + "='" + close_day_invoice_id + "'";
      ResultSet rs = stbangna.executeQuery(sql);
      while (rs.next()) {
        ctbRp = new CashierTBillingReceivePrint();
        ctbRp.setPatientAddress(config1.StringNull(rs.getString(ctbRp.getFPatientAddress())));
        ctbRp.setPatientAge(config1.StringNull(rs.getString(ctbRp.getFPatientAge())));
        ctbRp.setPatientFullnamet(config1.StringNull(rs.getString(ctbRp.getFPatientFullnamet())));
        ctbRp.setPatientPid(config1.StringNull(rs.getString(ctbRp.getFPatientPid())));
        ctbRp.setTBillingInvoiceId(config1.StringNull(rs.getString(ctbRp.getFTBillingInvoiceId())));

        ctbRp.setTBillingReceivePrintActive(config1.StringNull(rs.getString(ctbRp.getFTBillingReceivePrintActive())));
        ctbRp.setTBillingReceivePrintDate(config1.StringNull(rs.getString(ctbRp.getFTBillingReceivePrintDate())));
        ctbRp.setTBillingReceivePrintId(config1.StringNull(rs.getString(ctbRp.getFTBillingReceivePrintId())));
        ctbRp.setTVisitHn(config1.StringNull(rs.getString(ctbRp.getFTVisitHn())));
        ctbRp.setTVisitId(config1.StringNull(rs.getString(ctbRp.getFTVisitId())));

        ctbRp.setTVisitVn(config1.StringNull(rs.getString(ctbRp.getFTVisitVn())));
        ctbRp.setVisitTypeDescription(config1.StringNull(rs.getString(ctbRp.getFVisitTypeDescription())));
        ctbRp.setBillingInvoiceNo(config1.StringNull(rs.getString(ctbRp.getFBillingInvoiceNo())));
        ctbRp.setBillingInvoiceDate(config1.StringNull(rs.getString(ctbRp.getFBillingInvoiceDate())));
        ctbRp.setPatientCompanyName(config1.StringNull(rs.getString(ctbRp.getFPatientCompanyName())));

        ctbRp.setInjuryNo(config1.StringNull(rs.getString(ctbRp.getFInjuryNo())));
        ctbRp.setSickness(config1.StringNull(rs.getString(ctbRp.getFSickness())));
        ctbRp.setVisitDate(config1.StringNull(rs.getString(ctbRp.getFVisitDate())));
        ctbRp.setVisitTime(config1.StringNull(rs.getString(ctbRp.getFVisitTime())));
        ctbRp.setDischargeDate(config1.StringNull(rs.getString(ctbRp.getFDischargeDate())));

        ctbRp.setDischargeTime(config1.StringNull(rs.getString(ctbRp.getFDischargeTime())));
        ctbRp.setAmount(rs.getDouble(ctbRp.getFAmount()));
        ctbRp.setDiscount(rs.getDouble(ctbRp.getFDiscount()));
        ctbRp.setNettotal(rs.getDouble(ctbRp.getFNettotal()));
        ctbRp.setReceiveNumber(config1.StringNull(rs.getString(ctbRp.getFReceiveNumber())));
        v_t_billing_receive_print.add(ctbRp);
      }

      rs.close();
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return v_t_billing_receive_print;
  }

    public CashierTBillingInvoicePrintDetail getCashierTBillingInvoicePrintDetailByPK(String brach_id, String close_day_invoice_id, String flag) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement stbangna = conn.createStatement();
          sql = "Select * From " + ctbIpD.getCashierTBillingInvoicePrintDetail() + " " 
                  + "Where " + ctbIpD.getFTBillingInvoicePrintDetailId() + "='" + close_day_invoice_id + "'";
          ResultSet rs = stbangna.executeQuery(sql);
          while (rs.next()) {
            ctbIpD = new CashierTBillingInvoicePrintDetail();
            ctbIpD.setCode(config1.StringNull(rs.getString(ctbIpD.getFCode())));
            ctbIpD.setName1(config1.StringNull(rs.getString(ctbIpD.getFName1())));
            ctbIpD.setPrice(rs.getDouble(ctbIpD.getFPrice()));
            ctbIpD.setRow1(rs.getDouble(ctbIpD.getFRow1()));
            ctbIpD.setTBillingInvoicePrintDetailId(config1.StringNull(rs.getString(ctbIpD.getFTBillingInvoicePrintDetailId())));

            ctbIpD.setTBillingInvoicePrintId(config1.StringNull(rs.getString(ctbIpD.getFTBillingInvoicePrintId())));
            ctbIpD.setNode(config1.StringNull(rs.getString(ctbIpD.getFNode())));
            ctbIpD.setSortLine1(rs.getDouble(ctbIpD.getFSortLine1()));
            ctbIpD.setSortLine2(rs.getDouble(ctbIpD.getFSortLine2()));
            ctbIpD.setSortLine3(rs.getDouble(ctbIpD.getFSortLine3()));

            ctbIpD.setSortLine4(rs.getDouble(ctbIpD.getFSortLine4()));
            ctbIpD.setSortLine5(rs.getDouble(ctbIpD.getFSortLine5()));
            ctbIpD.setSortLine6(rs.getDouble(ctbIpD.getFSortLine6()));
          }

          rs.close();
          conn.close();
        } catch (Exception ex) {
            Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ctbIpD;
    }

    public CashierTBillingReceivePrintDetail getCashierTBillingReceivePrintDetailByPK(Connection conn, String brach_id, String close_day_invoice_id, String flag) {
        String sql = "";
        try{
          Statement stbangna = conn.createStatement();
          ctbRpD = new CashierTBillingReceivePrintDetail();
          sql = "Select * From " + ctbRpD.getCashierTBillingReceivePrintDetail() + " " 
                  + "Where " + ctbRpD.getFTBillingReceivePrintDetailId() + "='" + close_day_invoice_id + "'";

          ResultSet rs = stbangna.executeQuery(sql);
          while (rs.next()) {
            ctbRpD = new CashierTBillingReceivePrintDetail();
            ctbRpD.setCode(config1.StringNull(rs.getString(ctbRpD.getFCode())));
            ctbRpD.setName1(config1.StringNull(rs.getString(ctbRpD.getFName1())));
            ctbRpD.setPrice(rs.getDouble(ctbRpD.getFPrice()));
            ctbRpD.setRow1(rs.getDouble(ctbRpD.getFRow1()));
            ctbRpD.setTBillingReceivePrintDetailId(config1.StringNull(rs.getString(ctbRpD.getFTBillingReceivePrintDetailId())));

            ctbRpD.setTBillingReceivePrintId(config1.StringNull(rs.getString(ctbRpD.getFTBillingReceivePrintId())));
            ctbRpD.setNode(config1.StringNull(rs.getString(ctbRpD.getFNode())));
            ctbRpD.setSortLine1(rs.getDouble(ctbRpD.getFSortLine1()));
            ctbRpD.setSortLine2(rs.getDouble(ctbRpD.getFSortLine2()));
            ctbRpD.setSortLine3(rs.getDouble(ctbRpD.getFSortLine3()));

            ctbRpD.setSortLine4(rs.getDouble(ctbRpD.getFSortLine4()));
            ctbRpD.setSortLine5(rs.getDouble(ctbRpD.getFSortLine5()));
            ctbRpD.setSortLine6(rs.getDouble(ctbRpD.getFSortLine6()));
          }

          rs.close();
        }catch (Exception ex) {
          Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ctbRpD;
    }

  public Vector getCashierTBillingReceivePrintDetail(String brach_id, String close_day_invoice_id, String flag) {
    String sql = "";
    Vector v_t_billing_receive_print_detail = new Vector();
    try {
      Connection conn = config1.getConnectionBangna();
      Statement stbangna = conn.createStatement();

      sql = "Select * From " + ctbRpD.getCashierTBillingReceivePrintDetail() + " " 
              + "Where " + ctbRpD.getFTBillingReceivePrintDetailId() + "='" + close_day_invoice_id + "'";

      ResultSet rs = stbangna.executeQuery(sql);
      while (rs.next()) {
        ctbRpD = new CashierTBillingReceivePrintDetail();
        ctbRpD.setCode(config1.StringNull(rs.getString(ctbRpD.getFCode())));
        ctbRpD.setName1(config1.StringNull(rs.getString(ctbRpD.getFName1())));
        ctbRpD.setPrice(rs.getDouble(ctbRpD.getFPrice()));
        ctbRpD.setRow1(rs.getDouble(ctbRpD.getFRow1()));
        ctbRpD.setTBillingReceivePrintDetailId(config1.StringNull(rs.getString(ctbRpD.getFTBillingReceivePrintDetailId())));

        ctbRpD.setTBillingReceivePrintId(config1.StringNull(rs.getString(ctbRpD.getFTBillingReceivePrintId())));
        ctbRpD.setNode(config1.StringNull(rs.getString(ctbRpD.getFNode())));
        ctbRpD.setSortLine1(rs.getDouble(ctbRpD.getFSortLine1()));
        ctbRpD.setSortLine2(rs.getDouble(ctbRpD.getFSortLine2()));
        ctbRpD.setSortLine3(rs.getDouble(ctbRpD.getFSortLine3()));

        ctbRpD.setSortLine4(rs.getDouble(ctbRpD.getFSortLine4()));
        ctbRpD.setSortLine5(rs.getDouble(ctbRpD.getFSortLine5()));
        ctbRpD.setSortLine6(rs.getDouble(ctbRpD.getFSortLine6()));
        v_t_billing_receive_print_detail.add(ctbRpD);
      }

      rs.close();
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return v_t_billing_receive_print_detail;
  }

  public Vector getCashierTBillingInvoicePrintDetail(String brach_id, String close_day_invoice_id, String flag) {
    String sql = "";
    Vector v_t_billing_invoice_print_detail = new Vector();
    try {
      Connection conn = config1.getConnectionBangna();
      Statement stbangna = conn.createStatement();

      sql = "Select * From " + ctbIpD.getCashierTBillingInvoicePrintDetail() + " " 
              + "Where " + ctbIpD.getFTBillingInvoicePrintDetailId() + "='" + close_day_invoice_id + "'";

      ResultSet rs = stbangna.executeQuery(sql);
      while (rs.next()) {
        ctbIpD = new CashierTBillingInvoicePrintDetail();
        ctbIpD.setCode(config1.StringNull(rs.getString(ctbIpD.getFCode())));
        ctbIpD.setName1(config1.StringNull(rs.getString(ctbIpD.getFName1())));
        ctbIpD.setPrice(rs.getDouble(ctbIpD.getFPrice()));
        ctbIpD.setRow1(rs.getDouble(ctbIpD.getFRow1()));
        ctbIpD.setTBillingInvoicePrintDetailId(config1.StringNull(rs.getString(ctbIpD.getFTBillingInvoicePrintDetailId())));

        ctbIpD.setTBillingInvoicePrintId(config1.StringNull(rs.getString(ctbIpD.getFTBillingInvoicePrintId())));
        ctbIpD.setNode(config1.StringNull(rs.getString(ctbIpD.getFNode())));
        ctbIpD.setSortLine1(rs.getDouble(ctbIpD.getFSortLine1()));
        ctbIpD.setSortLine2(rs.getDouble(ctbIpD.getFSortLine2()));
        ctbIpD.setSortLine3(rs.getDouble(ctbIpD.getFSortLine3()));

        ctbIpD.setSortLine4(rs.getDouble(ctbIpD.getFSortLine4()));
        ctbIpD.setSortLine5(rs.getDouble(ctbIpD.getFSortLine5()));
        ctbIpD.setSortLine6(rs.getDouble(ctbIpD.getFSortLine6()));
        v_t_billing_invoice_print_detail.add(ctbIpD);
      }
      rs.close();
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return v_t_billing_invoice_print_detail;
  }
  public String setSaveCashierTBillingInvoicePrint(String branch_id, CashierTBillingInvoicePrint item) throws Exception {
    int chk = 0;
    String sql = ""; String ma_date = ""; String attend_date = ""; String max = "";
    try{
      Connection conn = config1.getConnectionBangna();
      Statement st = conn.createStatement();
      ctbIp = getCashierTBillingInvoicePrintByPK(branch_id, item.getTBillingInvoicePrintId(), "");
      item.setPatientFullnamet(item.getPatientFullnamet().replace("'", "''"));
      item.setPatientCompanyName(item.getPatientCompanyName().replace("'", "''"));
      if (ctbIp.getTBillingInvoicePrintId().equals("")) {
          item.generateOID(idtableInv);
          max = item.getObjectId();
//        max = getMaxRowCashierTBillingInvoicePrint(conn);
        item.setBillingInvoiceNo(max);
        sql = "Insert Into " + ctbIp.getCashierTBillingInvoicePrint() 
                + "(" + ctbIp.getFTBillingInvoicePrintId() + ", " + ctbIp.getFPatientAddress() + ", " 
                + ctbIp.getFPatientAge() + "," + ctbIp.getFPatientFullnamet() + "," 
                + ctbIp.getFPatientPid() + "," + ctbIp.getFTBillingInvoiceId() + "," 
                + ctbIp.getFTBillingInvoicePrintActive() + "," + ctbIp.getFTBillingInvoicePrintDate() + "," 
                + ctbIp.getFTVisitHn() + "," + ctbIp.getFTVisitId() + "," 
                + ctbIp.getFTVisitVn() + "," + ctbIp.getFVisitTypeDescription() + "," 
                + ctbIp.getFBillingInvoiceNo() + "," + ctbIp.getFBillingInvoiceDate() + "," 
                + ctbIp.getFPatientCompanyName() + "," + ctbIp.getFInjuryNo() + "," 
                + ctbIp.getFSickness() + "," + ctbIp.getFVisitDate() + "," 
                + ctbIp.getFVisitTime() + "," + ctbIp.getFDischargeDate() + "," 
                + ctbIp.getFDischargeTime() + "," + ctbIp.getFAmount() + "," 
                + ctbIp.getFDiscount() + "," + ctbIp.getFNettotal() + "," 
                + ctbIp.getFInvoiceNumber() + ")" 
                + "Values('" + max + "','" + item.getPatientAddress() + "','" 
                + item.getPatientAge() + "','" + item.getPatientFullnamet() + "','" 
                + item.getPatientPid() + "','" + item.getTBillingInvoiceId() + "','" 
                + item.getTBillingInvoicePrintActive() + "','" + item.getTBillingInvoicePrintDate() + "','" 
                + item.getTVisitHn() + "','" + item.getTVisitId() + "','" 
                + item.getTVisitVn() + "','" + item.getVisitTypeDescription() + "','" 
                + item.getBillingInvoiceNo() + "','" + item.getBillingInvoiceDate() + "','" 
                + item.getPatientCompanyName() + "','" + item.getInjuryNo() + "','" 
                + item.getSickness() + "','" + item.getVisitDate() + "','" 
                + item.getVisitTime() + "','" + item.getDischargeDate() + "','" 
                + item.getDischargeTime() + "'," + item.getAmount() + "," 
                + item.getDiscount() + "," + item.getNettotal() + ",'" 
                + item.getInvoiceNumber() + "')";
      }else{
        sql = "Update " + ctbIp.getCashierTBillingInvoicePrint() 
                + " set " + ctbIp.getFPatientAddress() + " = '" + item.getPatientAddress() + "', " 
                + ctbIp.getFPatientAge() + " = '" + item.getPatientAge() + "', " 
                + ctbIp.getFPatientFullnamet() + " = '" + item.getPatientFullnamet() + "', " 
                + ctbIp.getFPatientPid() + " = '" + item.getPatientPid() + "', " 
                + ctbIp.getFTBillingInvoiceId() + " = '" + item.getTBillingInvoiceId() + "', " 
                + ctbIp.getFTBillingInvoicePrintActive() + " = '" + item.getTBillingInvoicePrintActive() + "', " 
                + ctbIp.getFTBillingInvoicePrintDate() + " = '" + item.getTBillingInvoicePrintDate() + "', " 
                + ctbIp.getFTVisitHn() + " = '" + item.getTVisitHn() + "', " 
                + ctbIp.getFTVisitId() + " = '" + item.getTVisitId() + "', " 
                + ctbIp.getFTVisitVn() + " = '" + item.getTVisitVn() + "', " 
                + ctbIp.getFVisitTypeDescription() + " = '" + item.getVisitTypeDescription() + "', " 
                + ctbIp.getFBillingInvoiceNo() + " = '" + item.getBillingInvoiceNo() + "', " 
                + ctbIp.getFBillingInvoiceDate() + " = '" + item.getBillingInvoiceDate() + "', " 
                + ctbIp.getFPatientCompanyName() + " = '" + item.getPatientCompanyName() + "', " 
                + ctbIp.getFInjuryNo() + " = '" + item.getInjuryNo() + "', " 
                + ctbIp.getFSickness() + " = '" + item.getSickness() + "', " 
                + ctbIp.getFVisitDate() + " = '" + item.getVisitDate() + "', " 
                + ctbIp.getFVisitTime() + " = '" + item.getVisitTime() + "', " 
                + ctbIp.getFDischargeDate() + " = '" + item.getDischargeDate() + "', " 
                + ctbIp.getFDischargeTime() + " = '" + item.getDischargeTime() + "', " 
                + ctbIp.getFAmount() + " = " + item.getAmount() + ", " 
                + ctbIp.getFDiscount() + " = " + item.getDiscount() + ", " 
                + ctbIp.getFNettotal() + " = " + item.getNettotal() + ", " 
                + ctbIp.getFInvoiceNumber() + " = '" + item.getInvoiceNumber() + "' " 
                + "Where " + ctbIp.getFTBillingInvoicePrintId() + " = '" + item.getTBillingInvoicePrintId() + "'";

        max = item.getTBillingInvoicePrintId();
      }
      chk = st.executeUpdate(sql);
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
      max = ex.getMessage();
    }
    return max;
  }
  public String setSaveCashierTBillingReceivePrint(String branch_id, CashierTBillingReceivePrint item) throws Exception {
    int chk = 0;
    String sql = ""; String ma_date = ""; String attend_date = ""; String max = "";
    try{
      Connection conn = config1.getConnectionBangna();
      Statement st = conn.createStatement();
      ctbRp = getCashierTBillingReceivePrintByPK(branch_id, item.getTBillingReceivePrintId(), "");
      item.setPatientFullnamet(item.getPatientFullnamet().replace("'", "''"));
      item.setPatientCompanyName(item.getPatientCompanyName().replace("'", "''"));
      if (ctbRp.getTBillingReceivePrintId().equals("")) {
//        max = getMaxRowCashierTBillingReceivePrint(conn);
          item.generateOID(idtableRec);
          max = item.getObjectId();
        item.setBillingInvoiceNo(max);
        sql = "Insert Into " + ctbRp.getCashierTBillingReceivePrint() 
                + "(" + ctbRp.getFTBillingReceivePrintId() + ", " + ctbRp.getFPatientAddress() + ", " 
                + ctbRp.getFPatientAge() + "," + ctbRp.getFPatientFullnamet() + "," 
                + ctbRp.getFPatientPid() + "," + ctbRp.getFTBillingInvoiceId() + "," 
                + ctbRp.getFTBillingReceivePrintActive() + "," + ctbRp.getFTBillingReceivePrintDate() + "," 
                + ctbRp.getFTVisitHn() + "," + ctbRp.getFTVisitId() + "," 
                + ctbRp.getFTVisitVn() + "," + ctbRp.getFVisitTypeDescription() + "," 
                + ctbRp.getFBillingInvoiceNo() + "," + ctbRp.getFBillingInvoiceDate() + "," 
                + ctbRp.getFPatientCompanyName() + "," + ctbRp.getFInjuryNo() + "," 
                + ctbRp.getFSickness() + "," + ctbRp.getFVisitDate() + "," 
                + ctbRp.getFVisitTime() + "," + ctbRp.getFDischargeDate() + "," 
                + ctbRp.getFDischargeTime() + "," + ctbRp.getFAmount() + "," 
                + ctbRp.getFDiscount() + "," + ctbRp.getFNettotal() + "," 
                + ctbRp.getFReceiveNumber() + ") " 
                + "Values('" + max + "','" + item.patientAddress + "','" 
                + item.patientAge + "','" + item.patientFullnamet + "','" 
                + item.patientPid + "','" + item.tBillingInvoiceId + "','" 
                + item.tBillingReceivePrintActive + "','" + item.tBillingReceivePrintDate + "','" 
                + item.tVisitHn + "','" + item.tVisitId + "','" 
                + item.tVisitVn + "','" + item.visitTypeDescription + "','" 
                + item.billingInvoiceNo + "','" + item.billingInvoiceDate + "','" 
                + item.patientCompanyName + "','" + item.injuryNo + "','" 
                + item.sickness + "','" + item.visitDate + "','" 
                + item.visitTime + "','" + item.dischargeDate + "','" 
                + item.dischargeTime + "'," + item.amount + "," 
                + item.discount + "," + item.nettotal + ",'" 
                + item.receiveNumber + "')";
      }else{
        sql = "Update " + ctbRp.getCashierTBillingReceivePrint() 
                + " set " + ctbRp.getFPatientAddress() + " = '" + item.getPatientAddress() + "', " 
                + ctbRp.getFPatientAge() + " = '" + item.getPatientAge() + "', " 
                + ctbRp.getFPatientFullnamet() + " = '" + item.getPatientFullnamet() + "', " 
                + ctbRp.getFPatientPid() + " = '" + item.getPatientPid() + "', " 
                + ctbRp.getFTBillingInvoiceId() + " = '" + item.getTBillingInvoiceId() + "', " 
                + ctbRp.getFTBillingReceivePrintActive() + " = '" + item.getTBillingReceivePrintActive() + "', " 
                + ctbRp.getFTBillingReceivePrintDate() + " = '" + item.getTBillingReceivePrintDate() + "', " 
                + ctbRp.getFTVisitHn() + " = '" + item.getTVisitHn() + "' " 
                + ctbRp.getFTVisitId() + " = '" + item.getTVisitId() + "', " 
                + ctbRp.getFTVisitVn() + " = '" + item.getTVisitVn() + "', " 
                + ctbRp.getFVisitTypeDescription() + " = '" + item.getVisitTypeDescription() + "', " 
                + ctbRp.getFBillingInvoiceNo() + " = '" + item.getBillingInvoiceNo() + "', " 
                + ctbRp.getFBillingInvoiceDate() + " = '" + item.getBillingInvoiceDate() + "', " 
                + ctbRp.getFPatientCompanyName() + " = '" + item.getPatientCompanyName() + "', " 
                + ctbRp.getFInjuryNo() + " = '" + item.getInjuryNo() + "', " 
                + ctbRp.getFSickness() + " = '" + item.getSickness() + "', " 
                + ctbRp.getFVisitDate() + " = '" + item.getVisitDate() + "', " 
                + ctbRp.getFVisitTime() + " = '" + item.getVisitTime() + "', " 
                + ctbRp.getFDischargeDate() + " = '" + item.getDischargeDate() + "', " 
                + ctbRp.getFDischargeTime() + " = '" + item.getDischargeTime() + "', " 
                + ctbRp.getFAmount() + " = " + item.getAmount() + ", " 
                + ctbRp.getFDiscount() + " = " + item.getDiscount() + ", " 
                + ctbRp.getFNettotal() + " = " + item.getNettotal() + ", " 
                + ctbRp.getFReceiveNumber() + " = '" + item.getReceiveNumber() + "' " 
                + "Where " + ctbRp.getFTBillingReceivePrintId() + " = '" + item.getTBillingReceivePrintId() + "'";

        max = item.getTBillingReceivePrintId();
      }
      chk = st.executeUpdate(sql);
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
      max = ex.getMessage();
    }
    return max;
  }
  public String setSaveCashierTBillingInvoicePrintDetail(String branch_id, CashierTBillingInvoicePrintDetail item) throws Exception {
    int chk = 0;
    String sql = ""; String ma_date = ""; String attend_date = ""; String max = "";
    try{
      Connection conn = config1.getConnectionBangna();
      Statement st = conn.createStatement();
      ctbIpD = getCashierTBillingInvoicePrintDetailByPK(branch_id, item.getTBillingInvoicePrintDetailId(), "");
      item.setName1(item.getName1().replace("'", "''"));

      if (ctbIpD.getTBillingInvoicePrintDetailId().equals("")) {
          item.generateOID(idtableInvItem);
          max = item.getObjectId();
//        max = getMaxRowCashierTBillingInvoicePrintDetail(conn);
        sql = "Insert Into " + ctbIpD.getCashierTBillingInvoicePrintDetail() 
                + "(" + ctbIpD.getFTBillingInvoicePrintDetailId() + ", " + ctbIpD.getFCode() + ", " + ctbIpD.getFName1() + "," + ctbIpD.getFPrice() + "," + ctbIpD.getFRow1() + "," + ctbIpD.getFTBillingInvoicePrintId() + "," + ctbIpD.getFNode() + "," + ctbIpD.getFSortLine1() + "," + ctbIpD.getFSortLine2() + "," + ctbIpD.getFSortLine3() + "," + ctbIpD.getFSortLine4() + "," + ctbIpD.getFSortLine5()+  "," + ctbIpD.getFSortLine6() + ") " 
                + "Values('" + max + "','" + item.getCode() + "','" + item.getName1() + "'," + item.getPrice() + "," + item.getRow1() + ",'" + item.getTBillingInvoicePrintId() + "','" + item.getNode() + "'," + item.getSortLine1() + "," + item.getSortLine2() + "," + item.getSortLine3() + "," + item.getSortLine4() + "," + item.getSortLine5() +"," + item.getSortLine6() + ")";
      }else{
        sql = "Update " + ctbIpD.getCashierTBillingInvoicePrintDetail() 
                + " set " + ctbIpD.getFCode() + " = '" + item.getCode() + "', " + ctbIpD.getFName1() + " = '" + item.getName1() + "', " 
                + ctbIpD.getFPrice() + " = '" + item.getPrice() + "', " + ctbIpD.getFRow1() + " = '" + item.getRow1() + "', " 
                + ctbIpD.getFTBillingInvoicePrintId() + " = '" + item.getTBillingInvoicePrintId() + "', " 
                + ctbIpD.getFNode() + " = '" + item.getNode() + "', " + ctbIpD.getFSortLine1() + " = '" + item.getSortLine1() + "', " 
                + ctbIpD.getFSortLine2() + " = '" + item.getSortLine2() + "', " + ctbIpD.getFSortLine3() + " = '" + item.getSortLine3() + "', " 
                + ctbIpD.getFSortLine4() + " = '" + item.getSortLine4() + "', " + ctbIpD.getFSortLine5() + " = '" + item.getSortLine5() + "', "
                + ctbIpD.getFSortLine6() + " = '" + item.getSortLine6() + "' " 
                + "Where " + ctbIpD.getFTBillingInvoicePrintDetailId() + " = '" + item.getTBillingInvoicePrintDetailId() + "'";
        max = item.getTBillingInvoicePrintDetailId();
      }
      chk = st.executeUpdate(sql);
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
      max = ex.getMessage();
    }
    return max;
  }
  public String setSaveCashierTBillingInvoicePrintDetail(Statement st,String branch_id, CashierTBillingInvoicePrintDetail item) throws Exception {
    int chk = 0;
    String sql = ""; String ma_date = ""; String attend_date = ""; String max = "";
    try{
//      Connection conn = config1.getConnectionBangna();
//      Statement st = conn.createStatement();
      ctbIpD = getCashierTBillingInvoicePrintDetailByPK(branch_id, item.getTBillingInvoicePrintDetailId(), "");
      item.setName1(item.getName1().replace("'", "''"));

      if (ctbIpD.getTBillingInvoicePrintDetailId().equals("")) {
          item.generateOID(idtableInvItem);
          max = item.getObjectId();
//        max = getMaxRowCashierTBillingInvoicePrintDetail(st);
        sql = "Insert Into " + ctbIpD.getCashierTBillingInvoicePrintDetail() + "(" + ctbIpD.getFTBillingInvoicePrintDetailId() + ", " 
                + ctbIpD.getFCode() + ", " + ctbIpD.getFName1() + "," + ctbIpD.getFPrice() + "," + ctbIpD.getFRow1() + "," 
                + ctbIpD.getFTBillingInvoicePrintId() + "," + ctbIpD.getFNode() + "," + ctbIpD.getFSortLine1() + "," 
                + ctbIpD.getFSortLine2() + "," + ctbIpD.getFSortLine3() + "," + ctbIpD.getFSortLine4() + "," + ctbIpD.getFSortLine5()+  "," 
                + ctbIpD.getFSortLine6() + ") " 
                + "Values('" + max + "','" 
                + item.getCode() + "','" + item.getName1() + "'," + item.getPrice() + "," + item.getRow1() + ",'" 
                + item.getTBillingInvoicePrintId() + "','" + item.getNode() + "'," + item.getSortLine1() + "," 
                + item.getSortLine2() + "," + item.getSortLine3() + "," + item.getSortLine4() + "," + item.getSortLine5() +"," 
                + item.getSortLine6() + ")";
      }else{
        sql = "Update " + ctbIpD.getCashierTBillingInvoicePrintDetail() + " set " + ctbIpD.getFCode() + " = '" + item.getCode() + "', " 
                + ctbIpD.getFName1() + " = '" + item.getName1() + "', " + ctbIpD.getFPrice() + " = '" + item.getPrice() + "', " 
                + ctbIpD.getFRow1() + " = '" + item.getRow1() + "', " 
                + ctbIpD.getFTBillingInvoicePrintId() + " = '" + item.getTBillingInvoicePrintId() + "', " 
                + ctbIpD.getFNode() + " = '" + item.getNode() + "', " + ctbIpD.getFSortLine1() + " = '" + item.getSortLine1() + "', " 
                + ctbIpD.getFSortLine2() + " = '" + item.getSortLine2() + "', " + ctbIpD.getFSortLine3() + " = '" + item.getSortLine3() + "', " 
                + ctbIpD.getFSortLine4() + " = '" + item.getSortLine4() + "', " + ctbIpD.getFSortLine5() + " = '" + item.getSortLine5() + "', "
                + ctbIpD.getFSortLine6() + " = '" + item.getSortLine6() + "' " 
                + "Where " + ctbIpD.getFTBillingInvoicePrintDetailId() + " = '" + item.getTBillingInvoicePrintDetailId() + "'";
        max = item.getTBillingInvoicePrintDetailId();
      }
      chk = st.executeUpdate(sql);
//      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
      max = ex.getMessage();
    }
    return max;
  }
  public String setSaveCashierTBillingReceivePrintDetail(Connection conn, String branch_id, CashierTBillingReceivePrintDetail item) throws Exception {
    int chk = 0;
    String sql = ""; String ma_date = ""; String attend_date = ""; String max = "";
    try {
      Statement st = conn.createStatement();
      ctbRpD = getCashierTBillingReceivePrintDetailByPK(conn, branch_id, item.getTBillingReceivePrintDetailId(), "");
      item.setName1(item.getName1().replace("'", "''"));

      if (ctbRpD.getTBillingReceivePrintDetailId().equals("")) {
//        max = getMaxRowCashierTBillingReceivePrintDetail(conn);
          item.generateOID(idtableRecItem);
          max = item.getObjectId();
        sql = "Insert Into " + ctbRpD.getCashierTBillingReceivePrintDetail()
                + "(" + ctbRpD.getFTBillingReceivePrintDetailId() + ", " + ctbRpD.getFCode() + ", " + ctbRpD.getFName1() + "," 
                + ctbRpD.getFPrice() + "," + ctbRpD.getFRow1() + "," + ctbRpD.getFTBillingReceivePrintId() + "," 
                + ctbRpD.getFNode() + "," + ctbRpD.getFSortLine1() + "," + ctbRpD.getFSortLine2() + "," 
                + ctbRpD.getFSortLine3() + "," + ctbRpD.getFSortLine4() + "," + ctbRpD.getFSortLine5() +"," 
                + ctbRpD.getFSortLine6() + ") " 
                + "Values('" + max + "','" + item.getCode() + "','" + item.getName1() + "'," 
                + item.getPrice() + "," + item.getRow1() + ",'" + item.getTBillingReceivePrintId() + "','" 
                + item.getNode() + "'," + item.getSortLine1() + "," + item.getSortLine2() + "," 
                + item.getSortLine3() + "," + item.getSortLine4() + "," + item.getSortLine5() +"," 
                + item.getSortLine6() + ")";
      }else{
        sql = "Update " + ctbRpD.getCashierTBillingReceivePrintDetail()
                + " set " + ctbRpD.getFCode() + " = '" + item.getCode() + "', "
                + ctbRpD.getFName1() + " = '" + item.getName1() + "', "
                + ctbRpD.getFPrice() + " = '" + item.getPrice() + "', "
                + ctbRpD.getFRow1() + " = '" + item.getRow1() + "', "
                + ctbRpD.getFTBillingReceivePrintId() + " = '" + item.getTBillingReceivePrintId() + "', "
                + ctbRpD.getFNode() + " = '" + item.getNode() + "', "
                + ctbRpD.getFSortLine1() + " = '" + item.getSortLine1() + "', "
                + ctbRpD.getFSortLine2() + " = '" + item.getSortLine2() + "', "
                + ctbRpD.getFSortLine3() + " = '" + item.getSortLine3() + "', "
                + ctbRpD.getFSortLine4() + " = '" + item.getSortLine4() + "', "
                + ctbRpD.getFSortLine5() + " = '" + item.getSortLine5() + "', "
                + ctbRpD.getFSortLine6() + " = '" + item.getSortLine6() + "' "
                + "Where " + ctbRpD.getFTBillingReceivePrintDetailId() + " = '" + item.getTBillingReceivePrintDetailId() + "'";

        max = item.getTBillingReceivePrintDetailId();
      }
      chk = st.executeUpdate(sql);
    }catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
      max = ex.getMessage();
    }
    return max;
  }

    public BItem getBItem(String branch_id, String item_number) {
        String sql = "";
        sql = "Select item_number, item_trade_name From b_item Where item_common_name = '" + item_number + "' and item_active = '0'";
        try{
            Connection conn = config1.getConnectionHospital(branch_id);
            Statement st = conn.createStatement();
            b_item = new BItem();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                b_item = new BItem();
                b_item.setItemNumber(rs.getString("item_number"));
                b_item.setItemCommonName(rs.getString("item_trade_name"));
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return b_item;
    }

  public BItem getBItemSubGroup(String branch_id, String item_number) {
    String sql = "";
    sql = "Select item_billing_subgroup_number, item_billing_subgroup_description,item_billing_subgroup_descriptione "
            + "From b_item_billing_subgroup "
            + "Where item_billing_subgroup_number = '" + item_number + "' and item_billing_subgroup_active = '1'";
    try{
      Connection conn = config1.getConnectionHospital(branch_id);
      Statement st = conn.createStatement();
      b_item = new BItem();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        b_item = new BItem();
        b_item.setItemNumber(rs.getString("item_billing_subgroup_number"));
        b_item.setItemCommonName(rs.getString("item_billing_subgroup_description"));
        b_item.setItemDescriptione(rs.getString("item_billing_subgroup_descriptione"));
      }
      rs.close();
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
    }

    return b_item;
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
    }
    catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return b_item;
  }

  public String setCashierTBillingInvoicePrintActiveVoid(String visit_vn) {
    String sql = "";
    sql = "Update " + ctbIp.getCashierTBillingInvoicePrint()
            + " Set " + ctbIp.getFTBillingInvoicePrintActive() + "='3' "
            + " Where " + ctbIp.getFTVisitVn() + " = '" + visit_vn + "'";
    try{
      Connection conn = config1.getConnectionBangna();
      Statement st = conn.createStatement();
      st.executeUpdate(sql);
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return "";
  }

  public String setCTBIPUpdateNettotal(String billing_invoice_print_id, Double nettotal, Double amount, Double discount) {
    String sql = "";
    sql = "Update " + ctbIp.getCashierTBillingInvoicePrint() + " "
            + "Set " + ctbIp.getFNettotal() + "=" + nettotal+ ", " + ctbIp.getFAmount() + "=" + amount
            + ", " + ctbIp.getFDiscount() + "=" + discount + " "
            + " Where " + ctbIp.getFTBillingInvoicePrintId() + " = '" + billing_invoice_print_id + "'";
    try{
      Connection conn = config1.getConnectionBangna();
      Statement st = conn.createStatement();
      st.executeUpdate(sql);
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return "";
  }

  public String setCTBRPUpdateNettotal(String billing_receive_print_id, Double nettotal, Double amount, Double discount) {
    String sql = "";
    sql = "Update " + ctbRp.getCashierTBillingReceivePrint() + " "
            + "Set " + ctbRp.getFNettotal() + "=" + nettotal + ", " + ctbRp.getFAmount() + "=" + amount
            + ", " + ctbRp.getFDiscount() + "=" + discount + " "
            + " Where " + ctbRp.getFTBillingReceivePrintId() + " = '" + billing_receive_print_id + "'";
    try{
      Connection conn = config1.getConnectionBangna();
      Statement st = conn.createStatement();
      st.executeUpdate(sql);
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return "";
  }

    public Vector getVTBillingInvoiceSubgroup(String branch_id, String where, String visit_vn, String flag
            , String flagLanguage, Connection conn, Connection conn_BItem) {
    String sql = ""; String space1 = ""; String node = ""; String name = "";
    String cnt = ""; String name_english = ""; String name_thai = "", price="";

    Boolean chk = Boolean.valueOf(false);
    Double cnt_item = Double.valueOf(0), price_item = Double.valueOf(0);

    Vector v = new Vector();
    VTBillingInvoiceSubgroup vvc = new VTBillingInvoiceSubgroup();
    VTBillingInvoiceSubgroup vv_t_billing_invoice_subgroup_main = new VTBillingInvoiceSubgroup();
    try {
//      Connection conn = config1.getConnectionHospital(branch_id);
//      Connection conn_BItem = conn
      Statement stbangna = conn.createStatement();
      Statement st_BItem = conn_BItem.createStatement();

      if (flag.equals("receive")) {
        sql = "SELECT b_site.site_full_name, b_site.site_phone_number, min(f_patient_prefix.patient_prefix_description) AS prefix_patient, "
                + "min(t_patient.patient_firstname) AS firstname, min(t_patient.patient_lastname) AS lastname, min(f_sex.sex_description) AS sex, "
                + "t_patient.patient_hn AS hn, min(t_patient.patient_pid) AS pid, min(t_patient.patient_house) AS house, "
                + "min(t_patient.patient_moo) AS moo, min(t_patient.patient_road) AS road, '' AS province, '' AS amphur, "
                + "'' AS tambon, min(t_visit.visit_patient_age) AS patient_age, t_visit.visit_vn AS vn, '' AS plan, '' AS card_no, "
                + "'' AS host_main, '' AS host_sub, t_visit.visit_dx AS diagnosis, "
                + "b_item_billing_subgroup.item_billing_subgroup_description AS billing_subgroup, sum(tor.order_price * tor.order_qty) AS patient_share, "
                + "0 AS draw, b_item_billing_subgroup.item_billing_subgroup_number AS invoice_number, "
                + "b_item_billing_subgroup.item_billing_subgroup_number AS item_number, "
                + "length(b_item_billing_subgroup.item_billing_subgroup_number::text) AS len_item_number, "
                + "CASE length(b_item_billing_subgroup.item_billing_subgroup_number::text) WHEN 13 THEN '                          '::text "
                + "WHEN 12 THEN '                        '::text WHEN 11 THEN '                      '::text "
                + "WHEN 10 THEN '                    '::text WHEN 9 THEN '                  '::text WHEN 8 THEN '                '::text "
                + "WHEN 7 THEN '              '::text WHEN 6 THEN '            '::text WHEN 5 THEN '          '::text "
                + "WHEN 4 THEN '        '::text WHEN 3 THEN '      '::text WHEN 2 THEN '    '::text WHEN 1 THEN '  '::text "
                + "WHEN 0 THEN ''::text ELSE NULL::text END AS space1, "
                + "bi.b_item_id, bi.item_common_name,bi.item_nick_name,tbii.billing_invoice_item_payer_status, "
                + "sum(tbii.billing_invoice_item_payer_share) as billing_invoice_item_payer_share, "
                + "sum(tbii.billing_invoice_item_patient_share) as billing_invoice_item_patient_share,bi.item_descriptione,symtom,"
                + "case(company_responsibility) when null then '' else company_responsibility end as company_responsibility, "
                + "case(company_original_affiliation) when null then '' else company_original_affiliation end as company_original_affiliation,"
                + "discharge_date_time  "
                + "FROM b_site, t_order tor "
                + "LEFT JOIN b_item_billing_subgroup ON b_item_billing_subgroup.b_item_billing_subgroup_id::text = tor.b_item_billing_subgroup_id::text "
                + "LEFT JOIN t_visit ON tor.t_visit_id::text = t_visit.t_visit_id::text "
                + "LEFT JOIN t_patient ON t_visit.t_patient_id::text = t_patient.t_patient_id::text "
                + "LEFT JOIN f_patient_prefix ON t_patient.f_patient_prefix_id::text = f_patient_prefix.f_patient_prefix_id::text "
                + "LEFT JOIN f_sex ON t_patient.f_sex_id::text = f_sex.f_sex_id::text "
                + "LEFT JOIN b_item bi ON b_item_billing_subgroup.item_billing_subgroup_number::text = bi.item_number::text AND bi.item_active::text = '0'::text "
                + "left join t_billing_invoice_item tbii on tor.t_order_id = tbii.t_order_item_id "
                + "left join t_billing_invoice tbi on tbi.t_billing_invoice_id = tbii.t_billing_invoice_id "
                + "WHERE tor.f_order_status_id::text = ANY (ARRAY['1'::text, '2'::text, '4'::text, '5'::text]) and tbii.t_billing_invoice_id = '" + where + "' " 
                + "GROUP BY b_site.site_full_name, b_site.site_phone_number, t_patient.patient_hn, t_visit.visit_vn, t_visit.visit_dx, " 
                + "b_item_billing_subgroup.item_billing_subgroup_description, " + "b_item_billing_subgroup.item_billing_subgroup_number, "
                + "bi.b_item_id, bi.item_common_name,bi.item_nick_name, " + "tbii.billing_invoice_item_payer_status,bi.item_descriptione,symtom,company_responsibility,company_original_affiliation,discharge_date_time ";
      }else if (where.length() > 0) {
        sql = "SELECT b_site.site_full_name, b_site.site_phone_number, min(f_patient_prefix.patient_prefix_description) AS prefix_patient, "
                + "min(t_patient.patient_firstname) AS firstname, min(t_patient.patient_lastname) AS lastname, min(f_sex.sex_description) AS sex, "
                + "t_patient.patient_hn AS hn, min(t_patient.patient_pid) AS pid, min(t_patient.patient_house) AS house, "
                + "min(t_patient.patient_moo) AS moo, min(t_patient.patient_road) AS road, '' AS province, '' AS amphur, '' AS tambon, "
                + "min(t_visit.visit_patient_age) AS patient_age, t_visit.visit_vn AS vn, '' AS plan, '' AS card_no, '' AS host_main, "
                + "'' AS host_sub, t_visit.visit_dx AS diagnosis, b_item_billing_subgroup.item_billing_subgroup_description AS billing_subgroup, "
                + "sum(tor.order_price * tor.order_qty) AS patient_share, 0 AS draw, "
                + "b_item_billing_subgroup.item_billing_subgroup_number AS invoice_number, "
                + "b_item_billing_subgroup.item_billing_subgroup_number AS item_number, "
                + "length(b_item_billing_subgroup.item_billing_subgroup_number::text) AS len_item_number, "
                + "CASE length(b_item_billing_subgroup.item_billing_subgroup_number::text) WHEN 13 THEN '                          '::text "
                + "WHEN 12 THEN '                        '::text WHEN 11 THEN '                      '::text "
                + "WHEN 10 THEN '                    '::text WHEN 9 THEN '                  '::text WHEN 8 THEN '                '::text "
                + "WHEN 7 THEN '              '::text WHEN 6 THEN '            '::text WHEN 5 THEN '          '::text "
                + "WHEN 4 THEN '        '::text WHEN 3 THEN '      '::text WHEN 2 THEN '    '::text WHEN 1 THEN '  '::text "
                + "WHEN 0 THEN ''::text ELSE NULL::text END AS space1, "
                + "bi.b_item_id, bi.item_common_name,bi.item_nick_name,tbii.billing_invoice_item_payer_status, "
                + "sum(tbii.billing_invoice_item_payer_share) as billing_invoice_item_payer_share, "
                + "sum(tbii.billing_invoice_item_patient_share) as  billing_invoice_item_patient_share,bi.item_descriptione,symtom,"
                + "case(company_responsibility) when null then '' else company_responsibility end as company_responsibility, "
                + "case(company_original_affiliation) when null then '' else company_original_affiliation end as company_original_affiliation,"
                + "discharge_date_time "
                + "FROM b_site, t_order tor "
                + "LEFT JOIN b_item_billing_subgroup ON b_item_billing_subgroup.b_item_billing_subgroup_id::text = tor.b_item_billing_subgroup_id::text "
                + "LEFT JOIN t_visit ON tor.t_visit_id::text = t_visit.t_visit_id::text "
                + "LEFT JOIN t_patient ON t_visit.t_patient_id::text = t_patient.t_patient_id::text "
                + "LEFT JOIN f_patient_prefix ON t_patient.f_patient_prefix_id::text = f_patient_prefix.f_patient_prefix_id::text "
                + "LEFT JOIN f_sex ON t_patient.f_sex_id::text = f_sex.f_sex_id::text "
                + "LEFT JOIN b_item bi ON b_item_billing_subgroup.item_billing_subgroup_number::text = bi.item_number::text AND bi.item_active::text = '0'::text "
                + "left join t_billing_invoice_item tbii on tor.t_order_id = tbii.t_order_item_id "
                + "left join t_billing_invoice tbi on tbi.t_billing_invoice_id = tbii.t_billing_invoice_id "
                + "WHERE tor.f_order_status_id::text = ANY (ARRAY['1'::text, '2'::text, '4'::text, '5'::text]) and tbii.t_billing_invoice_id = '" + where + "' " 
                + "GROUP BY b_site.site_full_name, b_site.site_phone_number, t_patient.patient_hn, " + "t_visit.visit_vn, t_visit.visit_dx, "
                + "b_item_billing_subgroup.item_billing_subgroup_description, " + "b_item_billing_subgroup.item_billing_subgroup_number, "
                + "bi.b_item_id, bi.item_common_name,bi.item_nick_name, " + "tbii.billing_invoice_item_payer_status,bi.item_descriptione,"
                + "symtom,company_responsibility,company_original_affiliation,discharge_date_time ";
      }else{
        sql = "Select * From " + vvb_is.getVTBillingInvoiceSubgroup() + " " + "Where " + vvb_is.getFVn() + "='" + visit_vn + "'";
      }

      ResultSet rs = stbangna.executeQuery(sql);
      while (rs.next()) {
        vvb_is = new VTBillingInvoiceSubgroup();
        vvb_is.setPrefixPatient(config1.StringNull(rs.getString(vvb_is.getFPrefixPatient())));
        vvb_is.setAmphur(config1.StringNull(rs.getString(vvb_is.getFAmphur())));
        vvb_is.setBItemId(config1.StringNull(rs.getString(vvb_is.getFBItemId())));
        vvb_is.setBillingSubgroup(config1.StringNull(rs.getString(vvb_is.getFBillingSubgroup())));

        vvb_is.setDiagnosis(config1.StringNull(rs.getString(vvb_is.getFDiagnosis())));
        vvb_is.setDraw(config1.StringNull(rs.getString(vvb_is.getFDraw())));
        vvb_is.setFirstname(config1.StringNull(rs.getString(vvb_is.getFFirstname())));
        vvb_is.setHn(config1.StringNull(rs.getString(vvb_is.getFHn())));

        vvb_is.setHouse(config1.StringNull(rs.getString(vvb_is.getFHouse())));
        vvb_is.setInvoiceNumber(config1.StringNull(rs.getString(vvb_is.getFInvoiceNumber())));
        if (flagLanguage.equals("thai"))
          vvb_is.setItemCommonName(config1.StringNull(rs.getString(vvb_is.getFItemCommonName())));
        else {
            if(vvb_is.getInvoiceNumber().equals("1.1.7.2")){
                sql = "";
            }
          vvb_is.setItemCommonName(config1.StringNull(rs.getString("item_descriptione")));
        }

        vvb_is.setItemNumber(config1.StringNull(rs.getString(vvb_is.getFItemNumber())));

        vvb_is.setLastname(config1.StringNull(rs.getString(vvb_is.getFLastname())));
        if (rs.getString(vvb_is.getFLenItemNumber()) != null)
          vvb_is.setLenItemNumber(rs.getDouble(vvb_is.getFLenItemNumber()));
        else {
          vvb_is.setLenItemNumber(Double.valueOf(0.0D));
        }

        vvb_is.setMoo(config1.StringNull(rs.getString(vvb_is.getFMoo())));
        vvb_is.setPatientAge(config1.StringNull(rs.getString(vvb_is.getFPatientAge())));
        if (where.length() > 0) {
//          if ((rs.getString("billing_invoice_item_payer_status")!=null) && (rs.getString("billing_invoice_item_payer_status").equals("new")) || (rs.getString("billing_invoice_item_payer_status").equals("orginal"))) {
            if (rs.getString("billing_invoice_item_payer_share").equals("0"))
              vvb_is.setPatientShare(rs.getDouble("billing_invoice_item_patient_share"));
            else
              vvb_is.setPatientShare(rs.getDouble("billing_invoice_item_payer_share"));
//          }else
//            vvb_is.setPatientShare(rs.getDouble(vvb_is.getFPatientShare()));
        }else {
          vvb_is.setPatientShare(rs.getDouble(vvb_is.getFPatientShare()));
        }

        vvb_is.setPid(config1.StringNull(rs.getString(vvb_is.getFPid())));

        vvb_is.setPrefixPatient(config1.StringNull(rs.getString(vvb_is.getFPrefixPatient())));
        vvb_is.setProvince(config1.StringNull(rs.getString(vvb_is.getFProvince())));
        vvb_is.setRoad(config1.StringNull(rs.getString(vvb_is.getFRoad())));

        vvb_is.setSex(config1.StringNull(rs.getString(vvb_is.getFSex())));
        vvb_is.setSiteFullName(config1.StringNull(rs.getString(vvb_is.getFSiteFullName())));
        vvb_is.setSitePhoneNumber(config1.StringNull(rs.getString(vvb_is.getFSitePhoneNumber())));
        vvb_is.setSpace1(config1.StringNull(rs.getString(vvb_is.getFSpace1())));

        vvb_is.setTambon(config1.StringNull(rs.getString(vvb_is.getFTambon())));
        vvb_is.setVn(config1.StringNull(rs.getString(vvb_is.getFVn())));
        vvb_is.setItemNickName(config1.StringNull(rs.getString(vvb_is.getFItemNickName())));
        vvb_is.setNode("1");
        vvb_is.setFItemGroupID("");
        vvb_is.setItemNickName(config1.StringNull(rs.getString(vvb_is.getFItemNickName())));
        
        if(where.length()>0){
            vvb_is.setSymtom(config1.StringNull(rs.getString(vvb_is.getFSymtom())));
            vvb_is.setDischargeDateTime(config1.StringNull(vvb_is.getFDischargeDateTime()));
            vvb_is.setCompanyResponsibility(config1.StringNull(rs.getString(vvb_is.getFCompanyResponsibility())));
            vvb_is.setCompanyOriginalAffiliationy(config1.StringNull(rs.getString(vvb_is.getFCompanyOrgiginalAffiliation())));
        }

        v.add(vvb_is);

        if (vvb_is.getItemNumber().equals("B301")) {
          sql = "";
        }
        if(vvb_is.getInvoiceNumber().equals("1.1.5.2.197")){
            sql = "";
        }
        if (vvb_is.getItemNickName().length() > 0) {
            Connection conn_item = config1.getConnectionHospital(branch_id);
            Statement st_item = conn_item.createStatement();
            if (vvb_is.getItemNickName().indexOf("ฟิล์ม") >= 0) {
                name = "";
                sql = "SELECT sum(to_number(trxs.xray_film_amount, '99G999D9S')) as cnt_item, tor.order_price,xray_film_size_description "
                    + "FROM t_order tor "
                    + "LEFT JOIN b_item_billing_subgroup ON b_item_billing_subgroup.b_item_billing_subgroup_id::text = tor.b_item_billing_subgroup_id::text "
                    + "LEFT JOIN t_visit ON tor.t_visit_id::text = t_visit.t_visit_id::text "
                    + "LEFT JOIN b_item bi ON b_item_billing_subgroup.item_billing_subgroup_number::text = bi.item_number::text AND bi.item_active::text = '0'::text "
                    + "left join t_result_xray_size trxs on tor.t_order_id = trxs.t_order_id "
                    + "left join f_xray_film_size fxfs on trxs.f_xray_film_size_id = fxfs.f_xray_film_size_id "
                    + "WHERE tor.f_order_status_id::text = ANY (ARRAY['1'::text, '2'::text, '4'::text, '5'::text]) and t_visit.visit_vn = '" + visit_vn + "' and " + "bi.b_item_id = '" + vvb_is.getBItemId() + "' "
                    + "Group By tor.order_price,xray_film_size_description ";

                ResultSet rs_item = st_item.executeQuery(sql);
                while (rs_item.next()) {
                    if (rs_item.getString(vvb_is.getFCntItem()) != null) {
                        cnt_item = rs_item.getDouble(vvb_is.getFCntItem());
                        price_item = rs_item.getDouble("order_price");
                        name = rs_item.getString("xray_film_size_description");
                    }
                }
                rs_item.close();
                if (cnt_item.doubleValue() >= 1) {
                    cnt = "";
                    name_english = "";
                    name_thai = "";
                    cnt = cnt_item.toString();
                    price_item = price_item / cnt_item;
                    price = config1.NumberFormatN(price_item, ".xx");
                    if ((cnt.indexOf(".") > 0) && (cnt.substring(cnt.length() - 1).equals("0"))) cnt = cnt.substring(0, cnt.indexOf("."));
                    if (vvb_is.getItemNickName().indexOf(",") > 0) {
                        name_english = vvb_is.getItemNickName().substring(vvb_is.getItemNickName().indexOf(",") + 1, vvb_is.getItemNickName().length());
                        name_thai = vvb_is.getItemNickName().substring(0, vvb_is.getItemNickName().indexOf(",") + 1);
                    } else {
                        name_thai = vvb_is.getItemNickName();
                        name_english = vvb_is.getItemNickName();
                    }
                    if (flagLanguage.equals("thai")) name = "ค่าเอ็กซเรย์ " + name + " " + cnt + " " + name_thai + " " + price + " บาท";
                    else name = "X-Ray " + name + " " + cnt + " " + name_english + " " + price + " baht";
                    vvb_is.setItemCommonName(name);
                }
            }else {
            sql = "SELECT sum(tor.order_qty) as cnt_item, tor.order_price "
                    + "FROM t_order tor LEFT JOIN b_item_billing_subgroup ON b_item_billing_subgroup.b_item_billing_subgroup_id::text = tor.b_item_billing_subgroup_id::text "
                    + "LEFT JOIN t_visit ON tor.t_visit_id::text = t_visit.t_visit_id::text "
                    + "LEFT JOIN b_item bi ON b_item_billing_subgroup.item_billing_subgroup_number::text = bi.item_number::text AND bi.item_active::text = '0'::text "
                    + "WHERE tor.f_order_status_id::text = ANY (ARRAY['1'::text, '2'::text, '4'::text, '5'::text]) and t_visit.visit_vn = '" + visit_vn + "' and " + "bi.b_item_id = '" + vvb_is.getBItemId() + "' "
                    + "Group By tor.order_price ";

            ResultSet rs_item = st_item.executeQuery(sql);
            while (rs_item.next()) {
                if (rs_item.getString(vvb_is.getFCntItem()) != null) {
                    cnt_item = rs_item.getDouble(vvb_is.getFCntItem());
                    price_item = rs_item.getDouble("order_price");
                }
            }
            rs_item.close();
            name = "";
            name = vvb_is.getItemCommonName();
            if (cnt_item.doubleValue() >= 1) {
                cnt = "";
                name_english = "";
                name_thai = "";
                cnt = cnt_item.toString();
                if ((cnt.indexOf(".") > 0) && (cnt.substring(cnt.length() - 1).equals("0"))) cnt = cnt.substring(0, cnt.indexOf("."));
                if (vvb_is.getItemNickName().indexOf(",") > 0) {
                    name_english = vvb_is.getItemNickName().substring(vvb_is.getItemNickName().indexOf(",") + 1, vvb_is.getItemNickName().length());
                    name_thai = vvb_is.getItemNickName().substring(0, vvb_is.getItemNickName().indexOf(",") + 1);
                } else {
                    name_thai = vvb_is.getItemNickName();
                    name_english = vvb_is.getItemNickName();
                }
                if (flagLanguage.equals("thai")) name = name + " " + cnt + " " + name_thai + " " + config1.NumberFormat(price_item) + " บาท";
                else name = name + " " + cnt + " " + name_english + " " + config1.NumberFormat(price_item) + " baht";
                vvb_is.setItemCommonName(name);
            }
            }
            conn_item.close();
        }

        String[] node1 = vvb_is.getInvoiceNumber().split("\\.");
        node = "";
        for (int i = 0; i <= node1.length - 1; i++) {
          node = node + node1[i] + ".";
        }
        if(node.equals("1.1.7(1).")){
            sql="";
        }
        if(node1[node1.length-1].indexOf("(")>=0){
          node=node.substring(0, node.indexOf("("));
        }
        if ((node.length() > 0) && (node.substring(node.length() - 1).equals("."))) node = node.substring(0, node.length() - 1);

        vv_t_billing_invoice_subgroup_main = getMainBItem(st_BItem, node, flagLanguage);
        if (vv_t_billing_invoice_subgroup_main.getItemNumber().length() > 0) {
            if(node.equals("1.1.7")){
                sql="";
            }
          vv_t_billing_invoice_subgroup_main.setNode("2");
          chk = Boolean.valueOf(false);
          for (int i = 0; i <= v.size() - 1; i++) {
            vvc = new VTBillingInvoiceSubgroup();
            vvc = (VTBillingInvoiceSubgroup)v.get(i);
            if (vvc.getInvoiceNumber().equals(vv_t_billing_invoice_subgroup_main.getInvoiceNumber())) chk = Boolean.valueOf(true);
          }
          if (!chk.booleanValue()) v.add(vv_t_billing_invoice_subgroup_main);

          node = "";
          for (int i = 0; i <= node1.length - 2; i++) {
            node = node + node1[i] + ".";
          }
          if(node.indexOf("(")>=0){
              node=node.substring(0, node.indexOf("("));
            }
          if ((node.length() > 0) && (node.substring(node.length() - 1).equals("."))) node = node.substring(0, node.length() - 1);

          vv_t_billing_invoice_subgroup_main = getMainBItem(st_BItem, node, flagLanguage);
          if (vv_t_billing_invoice_subgroup_main.getItemNumber().length() > 0) {
            vv_t_billing_invoice_subgroup_main.setNode("3");
            chk = Boolean.valueOf(false);
            for (int i = 0; i <= v.size() - 1; i++) {
              vvc = new VTBillingInvoiceSubgroup();
              vvc = (VTBillingInvoiceSubgroup)v.get(i);
              if (vvc.getInvoiceNumber().equals(vv_t_billing_invoice_subgroup_main.getInvoiceNumber())) chk = Boolean.valueOf(true);
            }
            if (!chk.booleanValue()) v.add(vv_t_billing_invoice_subgroup_main);

            node = "";
            for (int i = 0; i <= node1.length - 3; i++) {
              node = node + node1[i] + ".";
            }
            if(node.indexOf("(")>=0){
              node=node.substring(0, node.indexOf("("));
            }
            if ((node.length() > 0) && (node.substring(node.length() - 1).equals("."))) node = node.substring(0, node.length() - 1);

            vv_t_billing_invoice_subgroup_main = getMainBItem(st_BItem, node, flagLanguage);
            if (vv_t_billing_invoice_subgroup_main.getItemNumber().length() > 0) {
              vv_t_billing_invoice_subgroup_main.setNode("4");
              chk = Boolean.valueOf(false);
              for (int i = 0; i <= v.size() - 1; i++) {
                vvc = new VTBillingInvoiceSubgroup();
                vvc = (VTBillingInvoiceSubgroup)v.get(i);
                if (vvc.getInvoiceNumber().equals(vv_t_billing_invoice_subgroup_main.getInvoiceNumber())) chk = Boolean.valueOf(true);
              }
              if (!chk.booleanValue())  v.add(vv_t_billing_invoice_subgroup_main);

              node = "";
              for (int i = 0; i <= node1.length - 4; i++) {
                node = node + node1[i] + ".";
              }
              if (node.length() > 0) {
                  if(node.indexOf("(")>=0){
                      node=node.substring(0, node.indexOf("("));
                    }
                if (node.substring(node.length() - 1).equals(".")) node = node.substring(0, node.length() - 1);

                vv_t_billing_invoice_subgroup_main = getMainBItem(st_BItem, node, flagLanguage);
                if (vv_t_billing_invoice_subgroup_main.getItemNumber().length() > 0) {
                  vv_t_billing_invoice_subgroup_main.setNode("5");
                  chk = Boolean.valueOf(false);
                  for (int i = 0; i <= v.size() - 1; i++) {
                    vvc = new VTBillingInvoiceSubgroup();
                    vvc = (VTBillingInvoiceSubgroup)v.get(i);
                    if (vvc.getInvoiceNumber().equals(vv_t_billing_invoice_subgroup_main.getInvoiceNumber())) chk = Boolean.valueOf(true);
                  }
                  if (!chk.booleanValue()) v.add(vv_t_billing_invoice_subgroup_main);
                }
              }
            }
          }
            }
        }

      rs.close();
//      conn.close();
//      conn_BItem.close();
    } catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return v;
    }
    public Vector getVTBillingInvoiceSubgroupN(String branch_id, String where, String visit_vn, String flag
            , String flagLanguage, Connection conn, Connection conn_BItem) {
    String sql = ""; String space1 = ""; String node = ""; String name = "";
    String cnt = ""; String name_english = ""; String name_thai = "", price="";

    Boolean chk = false;
    Double cnt_item = 0.0, price_item = 0.0;

    Vector v = new Vector();
    VTBillingInvoiceSubgroupN vvc = new VTBillingInvoiceSubgroupN();
    VTBillingInvoiceSubgroupN vvcM = new VTBillingInvoiceSubgroupN();
    try {
//      Connection conn = config1.getConnectionHospital(branch_id);
//      Connection conn_BItem = conn
      Statement stbangna = conn.createStatement();
      Statement st_BItem = conn_BItem.createStatement();

      if (flag.equals("receive")) {
        sql = "SELECT b_site.site_full_name, b_site.site_phone_number, min(f_patient_prefix.patient_prefix_description) AS prefix_patient, "
                + "min(t_patient.patient_firstname) AS firstname, min(t_patient.patient_lastname) AS lastname, min(f_sex.sex_description) AS sex, "
                + "t_patient.patient_hn AS hn, min(t_patient.patient_pid) AS pid, min(t_patient.patient_house) AS house, "
                + "min(t_patient.patient_moo) AS moo, min(t_patient.patient_road) AS road, '' AS province, '' AS amphur, "
                + "'' AS tambon, min(t_visit.visit_patient_age) AS patient_age, t_visit.visit_vn AS vn, '' AS plan, '' AS card_no, "
                + "'' AS host_main, '' AS host_sub, t_visit.visit_dx AS diagnosis, "
                + "b_item_billing_subgroup.item_billing_subgroup_description AS billing_subgroup, sum(tor.order_price * tor.order_qty) AS patient_share, "
                + "0 AS draw, b_item_billing_subgroup.item_billing_subgroup_number AS invoice_number, "
                + "b_item_billing_subgroup.item_billing_subgroup_number AS item_number, "
                + "length(b_item_billing_subgroup.item_billing_subgroup_number::text) AS len_item_number, "
                + "CASE length(b_item_billing_subgroup.item_billing_subgroup_number::text) WHEN 13 THEN '                          '::text "
                + "WHEN 12 THEN '                        '::text WHEN 11 THEN '                      '::text "
                + "WHEN 10 THEN '                    '::text WHEN 9 THEN '                  '::text WHEN 8 THEN '                '::text "
                + "WHEN 7 THEN '              '::text WHEN 6 THEN '            '::text WHEN 5 THEN '          '::text "
                + "WHEN 4 THEN '        '::text WHEN 3 THEN '      '::text WHEN 2 THEN '    '::text WHEN 1 THEN '  '::text "
                + "WHEN 0 THEN ''::text ELSE NULL::text END AS space1, "
                + "bi.b_item_id, bi.item_common_name,bi.item_nick_name,tbii.billing_invoice_item_payer_status, "
                + "sum(tbii.billing_invoice_item_payer_share) as billing_invoice_item_payer_share, "
                + "sum(tbii.billing_invoice_item_patient_share) as billing_invoice_item_patient_share,bi.item_descriptione,symtom,"
                + "case(company_responsibility) when null then '' else company_responsibility end as company_responsibility, "
                + "case(company_original_affiliation) when null then '' else company_original_affiliation end as company_original_affiliation,"
                + "discharge_date_time,tbi.primary_symptom, tor.order_home  "
                + "FROM b_site, t_order tor "
                + "LEFT JOIN b_item_billing_subgroup ON b_item_billing_subgroup.b_item_billing_subgroup_id::text = tor.b_item_billing_subgroup_id::text "
                + "LEFT JOIN t_visit ON tor.t_visit_id::text = t_visit.t_visit_id::text "
                + "LEFT JOIN t_patient ON t_visit.t_patient_id::text = t_patient.t_patient_id::text "
                + "LEFT JOIN f_patient_prefix ON t_patient.f_patient_prefix_id::text = f_patient_prefix.f_patient_prefix_id::text "
                + "LEFT JOIN f_sex ON t_patient.f_sex_id::text = f_sex.f_sex_id::text "
                + "LEFT JOIN b_item bi ON b_item_billing_subgroup.item_billing_subgroup_number::text = bi.item_number::text AND bi.item_active::text = '0'::text "
                + "left join t_billing_invoice_item tbii on tor.t_order_id = tbii.t_order_item_id "
                + "left join t_billing_invoice tbi on tbi.t_billing_invoice_id = tbii.t_billing_invoice_id "
                + "WHERE tor.f_order_status_id::text = ANY (ARRAY['1'::text, '2'::text, '4'::text, '5'::text]) and tbii.t_billing_invoice_id = '" + where + "' " 
                + "GROUP BY b_site.site_full_name, b_site.site_phone_number, t_patient.patient_hn, t_visit.visit_vn, t_visit.visit_dx, " 
                + "b_item_billing_subgroup.item_billing_subgroup_description, " + "b_item_billing_subgroup.item_billing_subgroup_number, "
                + "bi.b_item_id, bi.item_common_name,bi.item_nick_name, " + "tbii.billing_invoice_item_payer_status,bi.item_descriptione"
                + ",symtom,company_responsibility,company_original_affiliation,discharge_date_time,tbi.primary_symptom, tor.order_home ";
      }else if (where.length() > 0) {
        sql = "SELECT b_site.site_full_name, b_site.site_phone_number, min(f_patient_prefix.patient_prefix_description) AS prefix_patient, "
                + "min(t_patient.patient_firstname) AS firstname, min(t_patient.patient_lastname) AS lastname, min(f_sex.sex_description) AS sex, "
                + "t_patient.patient_hn AS hn, min(t_patient.patient_pid) AS pid, min(t_patient.patient_house) AS house, "
                + "min(t_patient.patient_moo) AS moo, min(t_patient.patient_road) AS road, '' AS province, '' AS amphur, '' AS tambon, "
                + "min(t_visit.visit_patient_age) AS patient_age, t_visit.visit_vn AS vn, '' AS plan, '' AS card_no, '' AS host_main, "
                + "'' AS host_sub, t_visit.visit_dx AS diagnosis, b_item_billing_subgroup.item_billing_subgroup_description AS billing_subgroup, "
                + "sum(tor.order_price * tor.order_qty) AS patient_share, 0 AS draw, "
                + "b_item_billing_subgroup.item_billing_subgroup_number AS invoice_number, "
                + "b_item_billing_subgroup.item_billing_subgroup_number AS item_number, "
                + "length(b_item_billing_subgroup.item_billing_subgroup_number::text) AS len_item_number, "
                + "CASE length(b_item_billing_subgroup.item_billing_subgroup_number::text) WHEN 13 THEN '                          '::text "
                + "WHEN 12 THEN '                        '::text WHEN 11 THEN '                      '::text "
                + "WHEN 10 THEN '                    '::text WHEN 9 THEN '                  '::text WHEN 8 THEN '                '::text "
                + "WHEN 7 THEN '              '::text WHEN 6 THEN '            '::text WHEN 5 THEN '          '::text "
                + "WHEN 4 THEN '        '::text WHEN 3 THEN '      '::text WHEN 2 THEN '    '::text WHEN 1 THEN '  '::text "
                + "WHEN 0 THEN ''::text ELSE NULL::text END AS space1, "
                + "bi.b_item_id, bi.item_common_name,bi.item_nick_name,tbii.billing_invoice_item_payer_status, "
                + "sum(tbii.billing_invoice_item_payer_share) as billing_invoice_item_payer_share, "
                + "sum(tbii.billing_invoice_item_patient_share) as  billing_invoice_item_patient_share,bi.item_descriptione,symtom,"
                + "case(company_responsibility) when null then '' else company_responsibility end as company_responsibility, "
                + "case(company_original_affiliation) when null then '' else company_original_affiliation end as company_original_affiliation,"
                + "discharge_date_time,tbi.primary_symptom, tor.order_home "
                + "FROM b_site, t_order tor "
                + "LEFT JOIN b_item_billing_subgroup ON b_item_billing_subgroup.b_item_billing_subgroup_id::text = tor.b_item_billing_subgroup_id::text "
                + "LEFT JOIN t_visit ON tor.t_visit_id::text = t_visit.t_visit_id::text "
                + "LEFT JOIN t_patient ON t_visit.t_patient_id::text = t_patient.t_patient_id::text "
                + "LEFT JOIN f_patient_prefix ON t_patient.f_patient_prefix_id::text = f_patient_prefix.f_patient_prefix_id::text "
                + "LEFT JOIN f_sex ON t_patient.f_sex_id::text = f_sex.f_sex_id::text "
                + "LEFT JOIN b_item bi ON b_item_billing_subgroup.item_billing_subgroup_number::text = bi.item_number::text AND bi.item_active::text = '0'::text "
                + "left join t_billing_invoice_item tbii on tor.t_order_id = tbii.t_order_item_id "
                + "left join t_billing_invoice tbi on tbi.t_billing_invoice_id = tbii.t_billing_invoice_id "
                + "WHERE tor.f_order_status_id::text = ANY (ARRAY['1'::text, '2'::text, '4'::text, '5'::text]) and tbii.t_billing_invoice_id = '" + where + "' " 
                + "GROUP BY b_site.site_full_name, b_site.site_phone_number, t_patient.patient_hn, " + "t_visit.visit_vn, t_visit.visit_dx, "
                + "b_item_billing_subgroup.item_billing_subgroup_description, " + "b_item_billing_subgroup.item_billing_subgroup_number, "
                + "bi.b_item_id, bi.item_common_name,bi.item_nick_name, " + "tbii.billing_invoice_item_payer_status,bi.item_descriptione,"
                + "symtom,company_responsibility,company_original_affiliation,discharge_date_time,tbi.primary_symptom, tor.order_home ";
      }else{
        sql = "Select * From " + vvb_isN.getVTBillingInvoiceSubgroup() + " " + "Where " + vvb_is.getFVn() + "='" + visit_vn + "'";
      }

      ResultSet rs = stbangna.executeQuery(sql);
      while (rs.next()) {
        vvb_isN = new VTBillingInvoiceSubgroupN();
        vvb_isN.orderHome = config1.StringNull(rs.getString(vvb_isN.getFOrderHome()));
        vvb_isN.prefixPatient = config1.StringNull(rs.getString(vvb_isN.getFPrefixPatient()));
        vvb_isN.firstname = config1.StringNull(rs.getString(vvb_isN.getFFirstname()));
        vvb_isN.lastname = config1.StringNull(rs.getString(vvb_isN.getFLastname()));
        vvb_isN.hn = config1.StringNull(rs.getString(vvb_isN.getFHn()));
        if(where.length()>0){
//            vvb_isN.symtom = config1.StringNull(rs.getString(vvb_isN.getFSymtom()));
            vvb_isN.symtom = config1.StringNull(rs.getString(vvb_isN.getFPrimarySymptom()));
            vvb_isN.primarySymptom = config1.StringNull(rs.getString(vvb_isN.getFPrimarySymptom()));
            vvb_isN.dischargeDateTime = config1.StringNull(vvb_isN.getFDischargeDateTime());
            vvb_isN.companyResponsibility = config1.StringNull(rs.getString(vvb_isN.getFCompanyResponsibility()));
            vvb_isN.companyOriginalAffiliation = config1.StringNull(rs.getString(vvb_isN.getFCompanyOrgiginalAffiliation()));
        }
//        vvb_isN.primarySymptom = "";
        if(vvb_isN.orderHome.equals("1")){
            if (where.length() > 0) {
    //          if ((rs.getString("billing_invoice_item_payer_status")!=null) && (rs.getString("billing_invoice_item_payer_status").equals("new")) || (rs.getString("billing_invoice_item_payer_status").equals("orginal"))) {
                if (rs.getString("billing_invoice_item_payer_share").equals("0"))
                    vvb_isN.patientShare = rs.getDouble("billing_invoice_item_patient_share");
                else
                    vvb_isN.patientShare = rs.getDouble("billing_invoice_item_payer_share");
                vvb_isN.symtom = config1.StringNull(rs.getString(vvb_isN.getFPrimarySymptom()));
                vvb_isN.dischargeDateTime = config1.StringNull(vvb_isN.getFDischargeDateTime());
                vvb_isN.companyResponsibility = config1.StringNull(rs.getString(vvb_isN.getFCompanyResponsibility()));
                vvb_isN.companyOriginalAffiliation = config1.StringNull(rs.getString(vvb_isN.getFCompanyOrgiginalAffiliation()));
    //          }else
    //            vvb_is.setPatientShare(rs.getDouble(vvb_is.getFPatientShare()));
            }else {
                vvb_isN.patientShare = rs.getDouble(vvb_isN.getFPatientShare());
            }
            vvb_isN.vn = config1.StringNull(rs.getString(vvb_isN.getFVn()));
            vvb_isN.itemNickName = config1.StringNull(rs.getString(vvb_isN.getFItemNickName()));
            vvb_isN.node = "1";
            vvb_isN.fItemGroupId = "";
            vvb_isN.itemNickName = config1.StringNull(rs.getString(vvb_isN.getFItemNickName()));
            vvb_isN.invoiceNumber = config1.StringNull(rs.getString(vvb_isN.getFInvoiceNumber()));
            if (flagLanguage.equals("thai")){
                vvb_isN.itemCommonName = config1.StringNull(rs.getString(vvb_isN.getFItemCommonName()));
                vvb_isN.itemCommonName = "ยาผู้ป่วยกลับบ้าน";
            }else {
                if(vvb_isN.invoiceNumber.equals("1.1.7.2")){
                    sql = "";
                }
                vvb_isN.itemCommonName = config1.StringNull(rs.getString("item_descriptione"));
                vvb_isN.itemCommonName = "Home Medication";
            }
            vvb_isN.invoiceNumber = "1.1.1.3";
            
            vvb_isN.itemNumber = config1.StringNull(rs.getString(vvb_isN.getFItemNumber()));
            vvb_isN.bItemId = config1.StringNull(rs.getString(vvb_isN.getFBItemId()));
            vvb_isN.billingSubgroup = config1.StringNull(rs.getString(vvb_isN.getFBillingSubgroup()));
            if (rs.getString(vvb_is.getFLenItemNumber()) != null)
                vvb_isN.lenItemNumber = rs.getDouble(vvb_isN.getFLenItemNumber());
            else 
                vvb_isN.lenItemNumber = 7.0;
            vvb_isN.space1= "       ";
            v.add(vvb_isN);
        }else{
        
//        vvb_isN.prefixPatient = config1.StringNull(rs.getString(vvb_isN.getFPrefixPatient()));
        vvb_isN.amphur = config1.StringNull(rs.getString(vvb_isN.getFAmphur()));
        vvb_isN.bItemId = config1.StringNull(rs.getString(vvb_isN.getFBItemId()));
        vvb_isN.billingSubgroup = config1.StringNull(rs.getString(vvb_isN.getFBillingSubgroup()));

        vvb_isN.diagnosis = config1.StringNull(rs.getString(vvb_isN.getFDiagnosis()));
        vvb_isN.draw = config1.StringNull(rs.getString(vvb_isN.getFDraw()));
//        vvb_isN.firstname = config1.StringNull(rs.getString(vvb_isN.getFFirstname()));
//        vvb_isN.hn = config1.StringNull(rs.getString(vvb_isN.getFHn()));

        vvb_isN.house = config1.StringNull(rs.getString(vvb_isN.getFHouse()));
        vvb_isN.invoiceNumber = config1.StringNull(rs.getString(vvb_isN.getFInvoiceNumber()));
        if (flagLanguage.equals("thai"))
          vvb_isN.itemCommonName = config1.StringNull(rs.getString(vvb_isN.getFItemCommonName()));
        else {
            if(vvb_isN.invoiceNumber.equals("1.1.7.2")){
                sql = "";
            }
          vvb_isN.itemCommonName = config1.StringNull(rs.getString("item_descriptione"));
        }

        vvb_isN.itemNumber = config1.StringNull(rs.getString(vvb_isN.getFItemNumber()));

//        vvb_isN.lastname = config1.StringNull(rs.getString(vvb_isN.getFLastname()));
        if (rs.getString(vvb_is.getFLenItemNumber()) != null)
          vvb_isN.lenItemNumber = rs.getDouble(vvb_isN.getFLenItemNumber());
        else {
          vvb_isN.lenItemNumber = Double.valueOf(0.0D);
        }

        vvb_isN.moo = config1.StringNull(rs.getString(vvb_isN.getFMoo()));
        vvb_isN.patientAge = config1.StringNull(rs.getString(vvb_isN.getFPatientAge()));
        if (where.length() > 0) {
//          if ((rs.getString("billing_invoice_item_payer_status")!=null) && (rs.getString("billing_invoice_item_payer_status").equals("new")) || (rs.getString("billing_invoice_item_payer_status").equals("orginal"))) {
            if (rs.getString("billing_invoice_item_payer_share").equals("0"))
              vvb_isN.patientShare = rs.getDouble("billing_invoice_item_patient_share");
            else
              vvb_isN.patientShare = rs.getDouble("billing_invoice_item_payer_share");
//          }else
//            vvb_is.setPatientShare(rs.getDouble(vvb_is.getFPatientShare()));
        }else {
          vvb_isN.patientShare = rs.getDouble(vvb_isN.getFPatientShare());
        }

        vvb_isN.patientShare = Math.ceil(vvb_isN.patientShare);
        vvb_isN.pid = config1.StringNull(rs.getString(vvb_isN.getFPid()));

        vvb_isN.prefixPatient = config1.StringNull(rs.getString(vvb_isN.getFPrefixPatient()));
        vvb_isN.province = config1.StringNull(rs.getString(vvb_isN.getFProvince()));
        vvb_isN.road = config1.StringNull(rs.getString(vvb_isN.getFRoad()));

        vvb_isN.sex = config1.StringNull(rs.getString(vvb_isN.getFSex()));
        vvb_isN.siteFullName = config1.StringNull(rs.getString(vvb_isN.getFSiteFullName()));
        vvb_isN.sitePhoneNumber = config1.StringNull(rs.getString(vvb_isN.getFSitePhoneNumber()));
        vvb_isN.space1 = config1.StringNull(rs.getString(vvb_isN.getFSpace1()));

        vvb_isN.tambon = config1.StringNull(rs.getString(vvb_isN.getFTambon()));
        vvb_isN.vn = config1.StringNull(rs.getString(vvb_isN.getFVn()));
        vvb_isN.itemNickName = config1.StringNull(rs.getString(vvb_isN.getFItemNickName()));
        vvb_isN.node = "1";
        vvb_isN.fItemGroupId = "";
        vvb_isN.itemNickName = config1.StringNull(rs.getString(vvb_isN.getFItemNickName()));
//        vvb_isN.primarySymptom = config1.StringNull(rs.getString("primary_symptom"));
//        if(where.length()>0){
////            vvb_isN.symtom = config1.StringNull(rs.getString(vvb_isN.getFSymtom()));
//            vvb_isN.symtom = config1.StringNull(rs.getString(vvb_isN.getFPrimarySymptom()));
//            vvb_isN.primarySymptom = config1.StringNull(rs.getString(vvb_isN.getFPrimarySymptom()));
//            vvb_isN.dischargeDateTime = config1.StringNull(vvb_isN.getFDischargeDateTime());
//            vvb_isN.companyResponsibility = config1.StringNull(rs.getString(vvb_isN.getFCompanyResponsibility()));
//            vvb_isN.companyOriginalAffiliation = config1.StringNull(rs.getString(vvb_isN.getFCompanyOrgiginalAffiliation()));
//        }

        v.add(vvb_isN);
        
      }

        if (vvb_isN.itemNumber.equals("B301")) {
          sql = "";
        }
        if(vvb_isN.invoiceNumber.equals("1.1.5.2.197")){
            sql = "";
        }
        if (vvb_isN.itemNickName.length() > 0) {
//            Connection conn_item = config1.getConnectionHospital(branch_id);
//            Statement st_item = conn_item.createStatement();
            if (vvb_isN.itemNickName.indexOf("ฟิล์ม") >= 0) {
                name = "";
                sql = "SELECT sum(to_number(trxs.xray_film_amount, '99G999D9S')) as cnt_item, bip.item_price, xray_film_size_description "
                    + "FROM t_order tor "
                    + "LEFT JOIN b_item_billing_subgroup ON b_item_billing_subgroup.b_item_billing_subgroup_id::text = tor.b_item_billing_subgroup_id::text "
                    + "LEFT JOIN t_visit ON tor.t_visit_id::text = t_visit.t_visit_id::text "
                    + "LEFT JOIN b_item bi ON b_item_billing_subgroup.item_billing_subgroup_number::text = bi.item_number::text "
                    + "Left join t_result_xray_size trxs on tor.t_order_id = trxs.t_order_id "
                    + "Left join f_xray_film_size fxfs on trxs.f_xray_film_size_id = fxfs.f_xray_film_size_id "
                    + "Left join b_item_price bip on bi.b_item_id = bip.b_item_id "
                    + "WHERE tor.f_order_status_id::text = ANY (ARRAY['1'::text, '2'::text, '4'::text, '5'::text]) "
                    + "and t_visit.visit_vn = '" + visit_vn + "' and " 
                    + "bi.b_item_id = '" + vvb_isN.bItemId + "' "
                    + "and bip.item_price_active_date = (Select max(item_price_active_date) From b_item_price Where b_item_price.b_item_id = bi.b_item_id) "
                    + " AND bi.item_active::text = '0'::text "
//                    + " AND bi.item_active::text = '1'::text "
                    + "Group By bip.item_price,xray_film_size_description ";

                ResultSet rs_item = st_BItem.executeQuery(sql);
                while (rs_item.next()) {
                    if (rs_item.getString(vvb_isN.getFCntItem()) != null) {
                        cnt_item = rs_item.getDouble(vvb_isN.getFCntItem());
                        price_item = rs_item.getDouble("item_price");
                        name = rs_item.getString("xray_film_size_description");
                    }
                }
                rs_item.close();
                if (cnt_item.doubleValue() >= 1) {
                    cnt = "";
                    name_english = "";
                    name_thai = "";
                    cnt = cnt_item.toString();
//                    price_item = price_item / cnt_item;
                    price = config1.NumberFormatN(price_item, ".xx");
                    if ((cnt.indexOf(".") > 0) && (cnt.substring(cnt.length() - 1).equals("0"))) cnt = cnt.substring(0, cnt.indexOf("."));
                    if (vvb_isN.itemNickName.indexOf(",") > 0) {
                        name_english = vvb_isN.itemNickName.substring(vvb_isN.itemNickName.indexOf(",") + 1, vvb_isN.itemNickName.length());
                        name_thai = vvb_isN.itemNickName.substring(0, vvb_isN.itemNickName.indexOf(",") + 1);
                    } else {
                        name_thai = vvb_isN.itemNickName;
                        name_english = vvb_isN.itemNickName;
                    }
                    name_thai = name_thai.replace(",", "");
                    if (flagLanguage.equals("thai")) name = "ค่าเอ็กซเรย์ " + name + " " + cnt + " " + name_thai + " " + price + " บาท";
                    else name = "X-Ray " + name + " " + cnt + " " + name_english + " " + price + " baht";
                    vvb_isN.itemCommonName = name;
                }
            }else {
                sql = "SELECT sum(tor.order_qty) as cnt_item, tor.order_price "
                    + "FROM t_order tor LEFT JOIN b_item_billing_subgroup ON b_item_billing_subgroup.b_item_billing_subgroup_id::text = tor.b_item_billing_subgroup_id::text "
                    + "LEFT JOIN t_visit ON tor.t_visit_id::text = t_visit.t_visit_id::text "
                    + "LEFT JOIN b_item bi ON b_item_billing_subgroup.item_billing_subgroup_number::text = bi.item_number::text AND bi.item_active::text = '0'::text "
                    + "WHERE tor.f_order_status_id::text = ANY (ARRAY['1'::text, '2'::text, '4'::text, '5'::text]) "
                    + "and t_visit.visit_vn = '" + visit_vn + "' and " + "bi.b_item_id = '" + vvb_isN.bItemId + "' "
                    + "Group By tor.order_price ";

                ResultSet rs_item = st_BItem.executeQuery(sql);
                while (rs_item.next()) {
                    if (rs_item.getString(vvb_isN.getFCntItem()) != null) {
                        cnt_item = rs_item.getDouble(vvb_isN.getFCntItem());
                        price_item = rs_item.getDouble("order_price");
                    }
                }
                rs_item.close();
                name = "";
                name = vvb_isN.itemCommonName;
                if (cnt_item.doubleValue() >= 1) {
                    cnt = "";
                    name_english = "";
                    name_thai = "";
                    cnt = cnt_item.toString();
                    if ((cnt.indexOf(".") > 0) && (cnt.substring(cnt.length() - 1).equals("0"))) cnt = cnt.substring(0, cnt.indexOf("."));
                    if (vvb_isN.itemNickName.indexOf(",") > 0) {
                        name_english = vvb_isN.itemNickName.substring(vvb_isN.itemNickName.indexOf(",") + 1, vvb_isN.itemNickName.length());
                        name_thai = vvb_isN.itemNickName.substring(0, vvb_isN.itemNickName.indexOf(",") + 1);
                    } else {
                        name_thai = vvb_isN.itemNickName;
                        name_english = vvb_isN.itemNickName;
                    }
                    if (flagLanguage.equals("thai")) name = name + " " + cnt + " " + name_thai + " " + config1.NumberFormat(price_item) + " บาท";
                    else name = name + " " + cnt + " " + name_english + " " + config1.NumberFormat(price_item) + " baht";
                    vvb_isN.itemCommonName = name;
                }
            }
//            conn_item.close();
        }

        String[] node1 = vvb_isN.invoiceNumber.split("\\.");
        node = "";
        for (int i = 0; i <= node1.length - 1; i++) {
          node = node + node1[i] + ".";
        }
        if(node.equals("1.1.7(1).")){
            sql="";
        }
        if(node1[node1.length-1].indexOf("(")>=0){
          node=node.substring(0, node.indexOf("("));
        }
        if ((node.length() > 0) && (node.substring(node.length() - 1).equals("."))) node = node.substring(0, node.length() - 1);

        vvcM = getMainBItemN(st_BItem, node, flagLanguage);
        if (vvcM.invoiceNumber.length() > 0) {
            if(node.equals("1.1.7")){
                sql="";
            }
          vvcM.node = "2";
          chk = Boolean.valueOf(false);
          for (int i = 0; i <= v.size() - 1; i++) {
            vvc = new VTBillingInvoiceSubgroupN();
            vvc = (VTBillingInvoiceSubgroupN)v.get(i);
            if (vvc.invoiceNumber.equals(vvcM.invoiceNumber)) chk = Boolean.valueOf(true);
          }
          if (!chk.booleanValue()) v.add(vvcM);

          node = "";
          for (int i = 0; i <= node1.length - 2; i++) {
            node = node + node1[i] + ".";
          }
          if(node.indexOf("(")>=0){
              node=node.substring(0, node.indexOf("("));
            }
          if ((node.length() > 0) && (node.substring(node.length() - 1).equals("."))) node = node.substring(0, node.length() - 1);

          vvcM = getMainBItemN(st_BItem, node, flagLanguage);
          if (vvcM.invoiceNumber.length() > 0) {
            vvcM.node = "3";
            chk = Boolean.valueOf(false);
            for (int i = 0; i <= v.size() - 1; i++) {
              vvc = new VTBillingInvoiceSubgroupN();
              vvc = (VTBillingInvoiceSubgroupN)v.get(i);
              if (vvc.invoiceNumber.equals(vvcM.invoiceNumber)) chk = Boolean.valueOf(true);
            }
            if (!chk.booleanValue()) v.add(vvcM);

            node = "";
            for (int i = 0; i <= node1.length - 3; i++) {
              node = node + node1[i] + ".";
            }
            if(node.indexOf("(")>=0){
              node=node.substring(0, node.indexOf("("));
            }
            if ((node.length() > 0) && (node.substring(node.length() - 1).equals("."))) node = node.substring(0, node.length() - 1);

            vvcM = getMainBItemN(st_BItem, node, flagLanguage);
            if (vvcM.itemNumber.length() > 0) {
              vvcM.node = "4";
              chk = Boolean.valueOf(false);
              for (int i = 0; i <= v.size() - 1; i++) {
                vvc = new VTBillingInvoiceSubgroupN();
                vvc = (VTBillingInvoiceSubgroupN)v.get(i);
                if (vvc.invoiceNumber.equals(vvcM.invoiceNumber)) chk = Boolean.valueOf(true);
              }
              if (!chk.booleanValue())  v.add(vvcM);

              node = "";
              for (int i = 0; i <= node1.length - 4; i++) {
                node = node + node1[i] + ".";
              }
              if (node.length() > 0) {
                  if(node.indexOf("(")>=0){
                      node=node.substring(0, node.indexOf("("));
                    }
                if (node.substring(node.length() - 1).equals(".")) node = node.substring(0, node.length() - 1);

                vvcM = getMainBItemN(st_BItem, node, flagLanguage);
                if (vvcM.itemNumber.length() > 0) {
                  vvcM.node = "5";
                  chk = Boolean.valueOf(false);
                  for (int i = 0; i <= v.size() - 1; i++) {
                    vvc = new VTBillingInvoiceSubgroupN();
                    vvc = (VTBillingInvoiceSubgroupN)v.get(i);
                    if (vvc.invoiceNumber.equals(vvcM.invoiceNumber)) chk = Boolean.valueOf(true);
                  }
                  if (!chk.booleanValue()) v.add(vvcM);
                }
              }
            }
          }
            }

        }

      rs.close();
//      conn.close();
//      conn_BItem.close();
    } catch (Exception ex) {
      Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return v;
    }
    public VTBillingInvoiceSubgroup getMainBItem(String branch_id, String invoice_number, String flagLanguage) {
        VTBillingInvoiceSubgroup vv_t_billing_invoice_subgroup_main = new VTBillingInvoiceSubgroup();
        String space1 = "";

        String[] node1 = invoice_number.split("\\.");
        getBItemSubGroup(branch_id, invoice_number);

        if (invoice_number.equals("1.1.12.6")) space1 = "";
        if (!b_item.getItemNumber().equals("")) {
            if (node1.length == 0) space1 = "";
            else if (node1.length == 1) space1 = "  ";
            else if (node1.length == 2) space1 = "    ";
            else if (node1.length == 3) space1 = "      ";
            else if (node1.length == 4) space1 = "          ";
            else if (node1.length == 5) space1 = "            ";

            vv_t_billing_invoice_subgroup_main = new VTBillingInvoiceSubgroup();
            vv_t_billing_invoice_subgroup_main.setItemNumber(b_item.getItemNumber());
            if (flagLanguage.equals("thai")) vv_t_billing_invoice_subgroup_main.setItemCommonName(b_item.getItemCommonName());
            else vv_t_billing_invoice_subgroup_main.setItemCommonName(b_item.getItemDescriptione());
            vv_t_billing_invoice_subgroup_main.setInvoiceNumber(b_item.getItemNumber());

            vv_t_billing_invoice_subgroup_main.setSpace1(space1);
        }
        return vv_t_billing_invoice_subgroup_main;
    }
    public VTBillingInvoiceSubgroup getMainBItem(Statement st, String invoice_number, String flagLanguage) {
        VTBillingInvoiceSubgroup v_bism = new VTBillingInvoiceSubgroup();
        String space1 = "";

        String[] node1 = invoice_number.split("\\.");
        getBItemSubGroup(st, invoice_number);
        if (invoice_number.equals("1.1.12.6")) {
          space1 = "";
        }
        if (!b_item.getItemNumber().equals("")) {
            if (node1.length == 0)        space1 = "";
            else if (node1.length == 1)   space1 = "  ";
            else if (node1.length == 2)   space1 = "    ";
            else if (node1.length == 3)   space1 = "      ";
            else if (node1.length == 4)   space1 = "          ";
            else if (node1.length == 5)   space1 = "            ";
            v_bism = new VTBillingInvoiceSubgroup();
            v_bism.setItemNumber(b_item.getItemNumber());
            if (flagLanguage.equals("thai")) v_bism.setItemCommonName(b_item.getItemCommonName());
            else v_bism.setItemCommonName(b_item.getItemDescriptione());
            v_bism.setInvoiceNumber(b_item.getItemNumber());
            v_bism.setSpace1(space1);
        }
        return v_bism;
    }
    public VTBillingInvoiceSubgroupN getMainBItemN(Statement st, String invoice_number, String flagLanguage) {
        VTBillingInvoiceSubgroupN v_bism = new VTBillingInvoiceSubgroupN();
        String space1 = "";

        String[] node1 = invoice_number.split("\\.");
        getBItemSubGroup(st, invoice_number);
        if (invoice_number.equals("1.1.12.6")) {
          space1 = "";
        }
        if (!b_item.getItemNumber().equals("")) {
            if (node1.length == 0)        space1 = "";
            else if (node1.length == 1)   space1 = "  ";
            else if (node1.length == 2)   space1 = "    ";
            else if (node1.length == 3)   space1 = "      ";
            else if (node1.length == 4)   space1 = "          ";
            else if (node1.length == 5)   space1 = "            ";
            v_bism = new VTBillingInvoiceSubgroupN();
            v_bism.itemNumber = b_item.getItemNumber();
            if (flagLanguage.equals("thai")) v_bism.itemCommonName = b_item.getItemCommonName();
            else v_bism.itemCommonName = b_item.getItemDescriptione();
            v_bism.invoiceNumber = b_item.getItemNumber();
            v_bism.space1 = space1;
        }
        return v_bism;
    }
    public void setUpdateTBillingReceipt(String branch_id, String receipt_number, String billing_receipt_id){
        String sql="";
        sql = "Update t_billing_receipt Set receipt_number = '"+receipt_number+"' "
                + "Where t_billing_receipt_id = '"+billing_receipt_id+"'";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionHospital(branch_id);
            st = conn.createStatement();
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getReceiptNumber(String branch_id, String t_billing_id){
        String receipt_number="", sql="";
        sql = "Select receipt_number "
                + "From t_billing_receipt Where t_billing_id = '"+t_billing_id+"' and billing_receipt_active = '1' ";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionHospital(branch_id);
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                receipt_number = rs.getString("receipt_number");
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(CashierTBillingInvoicePrintDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return receipt_number;
    }
}