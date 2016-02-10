/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import com.bangna.object.BackTPatientVisitFundsItem;
import com.bangna.object.BackTPatientVisitFundsBillingItem;
import com.bangna.object.BackTPatientVisitFunds;
import com.bangna.object.BackTPatientVisitFundsBilling;
import com.bangna.object.BackTPatientVisitContactBilling;
import com.bangna.object.BackTPatientVisitContactItem;
import com.bangna.object.BackTPatientVisitContact;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class BackTBillingPaymentDB {
    Config1 config1;
//    bpvdb.config1 bpvdb.config1 = new bpvdb.config1();
    public BackTPatientVisitDB bpvdb;
//    private BBranch branch = new BBranch();
    public BackTBillingPayment bbp;
    public BackTBillingPaymentItem bbpi;
    private BackTPatientVisitFunds bpvF;
    private BackTPatientVisitFundsItem bpv_fi;
    private BackTPatientVisitFundsBilling bpvFb;
    private BackTPatientVisitFundsBillingItem bpv_fbi;
    private BackTPatientVisitContact bpv_c ;
    private BackTPatientVisitContactItem bpv_ci;
    private BackTPatientVisitContactBilling bpvCb;
    private BackTDebtor debtor;
    private StringBuilder txt = new StringBuilder();
    private StringBuilder sql = new StringBuilder();
    String idtable="163", idtableItem="131";
    public BackTBillingPaymentDB(){
        config1 = new Config1();
        initConfig(config1);
    }
    public BackTBillingPaymentDB(Config1 cf){
        config1 = cf;
        initConfig(config1);
    }
    public void initConfig(Config1 cf){
        bpvdb = new BackTPatientVisitDB(cf);
        bbp = new BackTBillingPayment();
        bbpi = new BackTBillingPaymentItem();
        bpvF = new BackTPatientVisitFunds();
        bpv_fi = new BackTPatientVisitFundsItem();
        bpvFb = new BackTPatientVisitFundsBilling();
        bpv_fbi = new BackTPatientVisitFundsBillingItem();
        bpv_c = new BackTPatientVisitContact();
        bpv_ci = new BackTPatientVisitContactItem();
        bpvCb = new BackTPatientVisitContactBilling();
        debtor = new BackTDebtor();
    }
    public String getMaxRowBackBillingPayment(Connection conn) {
        String sql = ""; String max = "";
        try {
          Statement st = conn.createStatement();
          sql = "Select max(" + bbp.getFBillingPaymentId() + ") as cnt From " + bbp.getBackTBillingPayment();
          ResultSet rs = st.executeQuery(sql);
          while (rs.next()) {
            max = rs.getString("cnt");
          }
          rs.close();
          if ((max != null) && (!max.equals("")))
            max = String.valueOf(Integer.parseInt(max) + 1);
          else
            max = "1630000001";
        }catch (Exception ex) {
          Logger.getLogger(BackTBillingPaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowBackBillingPaymentItem(Connection conn) {
        String sql = ""; String max = "";
        try {
          Statement st = conn.createStatement();
          sql = "Select max(" + bbpi.getFBillingPaymentItemId() + ") as cnt From " + bbpi.getBackTBillingPaymentItem();
          ResultSet rs = st.executeQuery(sql);
          while (rs.next()) {
            max = rs.getString("cnt");
          }
          rs.close();
          if ((max != null) && (!max.equals("")))
            max = String.valueOf(Integer.parseInt(max) + 1);
          else
            max = "1310000001";
        }catch (Exception ex) {
          Logger.getLogger(BackTBillingPaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public BackTBillingPayment getBackTBillingPaymentByPK(String branch_id, String billing_payment_id) {
        String sql = "";
        try {
//            bbp.initial();
            Connection conn = bpvdb.config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            sql = "Select * From " + bbp.getBackTBillingPayment() + " " + "Where " + bbp.getFBillingPaymentId() + "='" + billing_payment_id + "'";
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bbp = new BackTBillingPayment();
                bbp.setBBankId(config1.StringNull(rs.getString(bbp.getFBBankId())));
                bbp.setBTransferId(config1.StringNull(rs.getString(bbp.getFBTransferId())));
                bbp.setBillingPaymentActive(config1.StringNull(rs.getString(bbp.getFBillingPaymentActive())));
                bbp.setBillingPaymentDate(config1.StringNull(rs.getString(bbp.getFBillingPaymentDate())));
                bbp.setBillingPaymentId(config1.StringNull(rs.getString(bbp.getFBillingPaymentId())));

                bbp.setBillingPaymentNumber(config1.StringNull(rs.getString(bbp.getFBillingPaymentNumber())));
                bbp.setChequeNumber(config1.StringNull(rs.getString(bbp.getFChequeNumber())));
                bbp.setDescription(config1.StringNull(rs.getString(bbp.getFDescription())));
                bbp.setReceiveAmount(Double.parseDouble(rs.getString(bbp.getFReceiveAmount())));
                bbp.setReceiveBaht(config1.StringNull(rs.getString(bbp.getFReceiveBaht())));

                bbp.setReceiveDate(config1.StringNull(rs.getString(bbp.getFReceiveDate())));
                bbp.setRemark(config1.StringNull(rs.getString(bbp.getFRemark())));
                bbp.setStatusPayment(config1.StringNull(rs.getString(bbp.getFStatusPayment())));
            }

          rs.close();
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTBillingPaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bbp;
    }
    public Vector getBackTBillingPayment(String branch_id, String where, String billing_payment_id, String flag) {
        String sql = "";
        Vector v_bbp = new Vector();
        try {
          Connection conn = bpvdb.config1.getConnectionBangna();
          Statement stbangna = conn.createStatement();
          if(flag.equals("search_date")){
              sql = "Select bbp.*, bank.b_bank_namet "
                      + "From " + bbp.getBackTBillingPayment() + " as bbp "
                      + "left join b_bank bank on bbp."+bbp.getFBBankId()+" = bank.b_bank_id "
                  + "Where bbp." + bbp.getFBillingPaymentDate() + ">='" + where + "' and bbp."
                  +bbp.getFBillingPaymentDate()+"<= '"+billing_payment_id+"' and bbp."+bbp.getFBillingPaymentActive()+"='1'";
          }else{
              sql = "Select * From " + bbp.getBackTBillingPayment() + " "
                  + "Where " + bbp.getFBillingPaymentId() + "='" + billing_payment_id + "'";
          }
          
          ResultSet rs = stbangna.executeQuery(sql);
          while (rs.next()) {
            bbp = new BackTBillingPayment();
            bbp.setBBankId(config1.StringNull(rs.getString(bbp.getFBBankId())));
            bbp.setBTransferId(config1.StringNull(rs.getString(bbp.getFBTransferId())));
            bbp.setBillingPaymentActive(config1.StringNull(rs.getString(bbp.getFBillingPaymentActive())));
            bbp.setBillingPaymentDate(config1.StringNull(rs.getString(bbp.getFBillingPaymentDate())));
            bbp.setBillingPaymentId(config1.StringNull(rs.getString(bbp.getFBillingPaymentId())));

            bbp.setBillingPaymentNumber(config1.StringNull(rs.getString(bbp.getFBillingPaymentNumber())));
            bbp.setChequeNumber(config1.StringNull(rs.getString(bbp.getFChequeNumber())));
            bbp.setDescription(config1.StringNull(rs.getString(bbp.getFDescription())));
            bbp.setReceiveAmount(Double.parseDouble(rs.getString(bbp.getFReceiveAmount())));
            bbp.setReceiveBaht(config1.StringNull(rs.getString(bbp.getFReceiveBaht())));

            bbp.setReceiveDate(config1.StringNull(rs.getString(bbp.getFReceiveDate())));
            bbp.setRemark(config1.StringNull(rs.getString(bbp.getFRemark())));
            bbp.setStatusPayment(config1.StringNull(rs.getString(bbp.getFStatusPayment())));
            if(flag.equals("search_date")){
                bbp.setBBankNamet(config1.StringNull(rs.getString("b_bank_namet")));
            }
            v_bbp.add(bbp);
          }
          rs.close();
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTBillingPaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_bbp;
    }
    public BackTBillingPaymentItem getBackTBillingPaymentItemByPK(String branch_id, String bbpiId) {
        String sql = "";
        try {
//            bbpi.initial();
            Connection conn = bpvdb.config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            sql = "Select * From " + bbpi.getBackTBillingPaymentItem() + " "
                  + "Where " + bbpi.getFBillingPaymentItemId() + "='" + bbpiId + "' ";
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bbpi = new BackTBillingPaymentItem();
                bbpi.setAmount(Double.parseDouble(rs.getString(bbpi.getFAmount())));
                bbpi.setBillingPaymentId(config1.StringNull(rs.getString(bbpi.getFBillingPaymentId())));
                bbpi.setBillingPaymentItemActive(config1.StringNull(rs.getString(bbpi.getFBillingPaymentItemActive())));
                bbpi.setBillingPaymentItemId(config1.StringNull(rs.getString(bbpi.getFBillingPaymentItemId())));
                bbpi.setPatientVisitId(config1.StringNull(rs.getString(bbpi.getFPatientVisitId())));

                bbpi.setPatientVisitXBillingId(config1.StringNull(rs.getString(bbpi.getFPatientVisitXBillingId())));
                bbpi.setRemark(config1.StringNull(rs.getString(bbpi.getFRemark())));
                bbpi.setVisitTotal(Double.parseDouble(rs.getString(bbpi.getFVisitTotal())));
                bbpi.setBillingInvoiceNumber(config1.StringNull(rs.getString(bbpi.getFBillingInvoiceNumber())));
                bbpi.setVisitContactJoinId(config1.StringNull(rs.getString(bbpi.getFVisitContactJoinId())));

                bbpi.setVisitContactJoinNamet(config1.StringNull(rs.getString(bbpi.getFVisitContactJoinNamet())));
                bbpi.setVisitHn(config1.StringNull(rs.getString(bbpi.getFVisitHn())));
                bbpi.setPatientFullnamet(config1.StringNull(rs.getString(bbpi.getFPatientFullnamet())));
                bbpi.setPatientVisitXId(config1.StringNull(rs.getString(bbpi.getFPatientVisitXId())));
                bbpi.statusContactFunds = config1.StringNull(rs.getString(bbpi.getFStatusContactFunds()));
                
                bbpi.discountPayment = config1.StringNull(rs.getString(bbpi.getFDiscountPayment()));
                bbpi.discountTax = config1.StringNull(rs.getString(bbpi.getFDiscountTax()));
                bbpi.receivePayment = config1.StringNull(rs.getString(bbpi.getFReceivePayment()));
                bbpi.receiveOver = config1.StringNull(rs.getString(bbpi.getFReceiveOver()));
                bbpi.invoiceNumber = config1.StringNull(rs.getString(bbpi.getFInvoiceNumber()));
                
                bbpi.injuryNumber = config1.StringNull(rs.getString(bbpi.getFInjuryNumber()));
            }

            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTBillingPaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bbpi;
    }
    public Vector getBackTBillingPaymentItem(String branch_id, String bbpiId, String flag) {
        String sql = "";
        Vector v_bbpi = new Vector();
        try {
          Connection conn = config1.getConnectionBangna();
          Statement stbangna = conn.createStatement();
          if(flag.equals("hn")){
              sql = "Select * From " + bbpi.getBackTBillingPaymentItem() + " "
                  + "Where " + bbpi.getFVisitHn() + "='" + bbpiId + "' and "+bbpi.getFBillingPaymentItemActive()+"='1' "
                  + "Order By "+bbpi.getFBillingInvoiceNumber()+","+bbpi.getFBillingPaymentItemId();
          }else if(flag.equals("injuryNumber")){
              sql = "Select * From " + bbpi.getBackTBillingPaymentItem() + " "
                  + "Where " + bbpi.getFInjuryNumber() + "='" + bbpiId + "' and "+bbpi.getFBillingPaymentItemActive()+"='1' "
                  + "Order By "+bbpi.getFBillingInvoiceNumber()+","+bbpi.getFBillingPaymentItemId();
          }else{
              sql = "Select * From " + bbpi.getBackTBillingPaymentItem() + " "
                  + "Where " + bbpi.getFBillingPaymentItemId() + "='" + bbpiId + "'";
          }
          
          ResultSet rs = stbangna.executeQuery(sql);
          while (rs.next()) {
            bbpi = new BackTBillingPaymentItem();
            bbpi.setAmount(Double.parseDouble(rs.getString(bbpi.getFAmount())));
            bbpi.setBillingPaymentId(config1.StringNull(rs.getString(bbpi.getFBillingPaymentId())));
            bbpi.setBillingPaymentItemActive(config1.StringNull(rs.getString(bbpi.getFBillingPaymentItemActive())));
            bbpi.setBillingPaymentItemId(config1.StringNull(rs.getString(bbpi.getFBillingPaymentItemId())));
            bbpi.setPatientVisitId(config1.StringNull(rs.getString(bbpi.getFPatientVisitId())));

            bbpi.setPatientVisitXBillingId(config1.StringNull(rs.getString(bbpi.getFPatientVisitXBillingId())));
            bbpi.setRemark(config1.StringNull(rs.getString(bbpi.getFRemark())));
            bbpi.setVisitTotal(Double.parseDouble(rs.getString(bbpi.getFVisitTotal())));
            bbpi.setBillingInvoiceNumber(config1.StringNull(rs.getString(bbpi.getFBillingInvoiceNumber())));
            bbpi.setVisitContactJoinId(config1.StringNull(rs.getString(bbpi.getFVisitContactJoinId())));

            bbpi.setVisitContactJoinNamet(config1.StringNull(rs.getString(bbpi.getFVisitContactJoinNamet())));
            bbpi.setVisitHn(config1.StringNull(rs.getString(bbpi.getFVisitHn())));
            bbpi.setPatientFullnamet(config1.StringNull(rs.getString(bbpi.getFPatientFullnamet())));
            bbpi.setPatientVisitXId(config1.StringNull(rs.getString(bbpi.getFPatientVisitXId())));
            bbpi.statusContactFunds = config1.StringNull(rs.getString(bbpi.getFStatusContactFunds()));
            
            bbpi.discountPayment = config1.StringNull(rs.getString(bbpi.getFDiscountPayment()));
            bbpi.discountTax = config1.StringNull(rs.getString(bbpi.getFDiscountTax()));
            bbpi.receivePayment = config1.StringNull(rs.getString(bbpi.getFReceivePayment()));
            bbpi.receiveOver = config1.StringNull(rs.getString(bbpi.getFReceiveOver()));
            bbpi.invoiceNumber = config1.StringNull(rs.getString(bbpi.getFInvoiceNumber()));
            
            bbpi.injuryNumber = config1.StringNull(rs.getString(bbpi.getFInjuryNumber()));
            v_bbpi.add(bbpi);
          }

          rs.close();
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTBillingPaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_bbpi;
    }
    public String setSaveBackTBillingPayment(String branch_id, BackTBillingPayment item) throws Exception {
        int chk = 0;
        String sql = ""; String max = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
//          bbp.initial();
          bbp = getBackTBillingPaymentByPK(branch_id, item.getBillingPaymentId());
          item.setRemark(config1.StringNull(item.getRemark()).replace("'", "''"));
          item.setDescription(config1.StringNull(item.getDescription()).replace("'", "''"));
          if (bbp.getBillingPaymentId().equals("")) {
              item.generateOID(idtable);
              max = item.getObjectId();
//            max = getMaxRowBackBillingPayment(conn);
            sql = "Insert Into " + bbp.getBackTBillingPayment() + "("
                    + bbp.getFBillingPaymentId()+","+bbp.getFBBankId()+","+bbp.getFBTransferId()+","
                    + bbp.getFBillingPaymentActive()+","+bbp.getFBillingPaymentDate()+","
                    + bbp.getFBillingPaymentNumber()+","+bbp.getFChequeNumber()+","+bbp.getFDescription()+","
                    + bbp.getFReceiveAmount()+","+bbp.getFReceiveBaht()+","+bbp.getFReceiveDate()+","
                    + bbp.getFRemark()+","+bbp.getFStatusPayment()+") "
                    + "Values('"+max+"','"+item.getBBankId()+"','"+item.getBTransferId()+"','"
                    +item.getBillingPaymentActive()+"','"+item.getBillingPaymentDate()+"','"
                    +item.getBillingPaymentNumber()+"','"+item.getChequeNumber()+"','"+item.getDescription()+"',"
                    +item.getReceiveAmount()+",'"+item.getReceiveBaht()+"','"+item.getReceiveDate()+"','"
                    +item.getRemark()+"','"+item.getStatusPayment()+"')";
          }else{
            sql = "Update " + bbp.getBackTBillingPayment()
                    +" set "+bbp.getFBBankId()+" = '" + item.getBBankId() + "', "
                    + bbp.getFBTransferId() + " = '" + item.getBTransferId() + "', "
                    + bbp.getFBillingPaymentActive() + " = '" + item.getBillingPaymentActive() + "', "
                    + bbp.getFBillingPaymentDate() + " = '" + item.getBillingPaymentDate() + "', "
                    + bbp.getFBillingPaymentNumber() + " = '" + item.getBillingPaymentNumber() + "', "
                    + bbp.getFChequeNumber() + " = " + item.getChequeNumber() + ", "
                    + bbp.getFDescription() + " = " + item.getDescription() + ", "
                    + bbp.getFReceiveAmount() + " = '" + item.getReceiveAmount() + "', "
                    + bbp.getFReceiveBaht() + " = '" + item.getReceiveBaht() + "', "
                    + bbp.getFReceiveDate() + " = '" + item.getReceiveDate() + "', "
                    + bbp.getFRemark() + " = '" + item.getRemark() + "', "
                    + bbp.getFStatusPayment() + " = '" + item.getStatusPayment() + "' "
                    + "Where " + bbp.getFBillingPaymentId() + " = '" + item.getBillingPaymentId() + "'";
            max = item.getBillingPaymentId();
          }
          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTBillingPaymentDB.class.getName()).log(Level.SEVERE, null, ex);
          max = ex.getMessage();
        }
        return max;
    }
    public String setSaveBackTBillingPaymentItem(String branch_id, BackTBillingPaymentItem item) throws Exception {
        int chk = 0;
        String sql = ""; String max = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
//          bbpi.initial();
          bbpi = getBackTBillingPaymentItemByPK(branch_id, item.getBillingPaymentItemId());
          item.setRemark(config1.StringNull(item.getRemark()).replace("'", "''"));
          if(item.receiveOver.equals("")){
              item.receiveOver="0.0";
          }
          if(item.discountTax.equals("")){
              item.discountTax="0.0";
          }
          if(item.receivePayment.equals("")){
              item.receivePayment="0.0";
          }
          if(item.discountPayment.equals("")){
              item.discountPayment="0.0";
          }
          if (bbpi.billingPaymentItemId.equals("")) {
              item.generateOID(idtableItem);
              max = item.getObjectId();
//            max = getMaxRowBackBillingPaymentItem(conn);
            sql = "Insert Into " + bbpi.getBackTBillingPaymentItem() + "("
                    +bbpi.getFBillingPaymentItemId()+","+bbpi.getFAmount()+","
                    +bbpi.getFBillingPaymentId()+","+bbpi.getFBillingPaymentItemActive()+","
                    +bbpi.getFPatientVisitId()+","+bbpi.getFPatientVisitXBillingId()+","
                    +bbpi.getFRemark()+","+bbpi.getFVisitTotal()+","
                    + bbpi.getFBillingInvoiceNumber()+","+bbpi.getFVisitContactJoinId()+","
                    + bbpi.getFVisitContactJoinNamet()+","+bbpi.getFVisitHn()+","
                    + bbpi.getFPatientFullnamet()+","+bbpi.getFPatientVisitXId()+", "
                    + bbpi.getFStatusContactFunds()+","+bbpi.getFDiscountPayment()+","
                    + bbpi.getFDiscountTax()+","+bbpi.getFReceivePayment()+","
                    + bbpi.getFReceiveOver()+","+bbpi.getFInvoiceNumber() +","
                    + bbpi.getFInjuryNumber()+")"
                    +"Values('"+max+"',"+item.getAmount()+",'"
                    +item.getBillingPaymentId()+"','"+item.getBillingPaymentItemActive()+"','"
                    +item.getPatientVisitId()+"','"+item.getPatientVisitXBillingId()+"','"
                    +item.getRemark()+"',"+item.getVisitTotal()+",'"
                    +item.getBillingInvoiceNumber()+"','"+item.getVisitContactJoinId()+"','"
                    +item.getVisitContactJoinNamet()+"','"+item.getVisitHn()+"','"
                    +item.getPatientFullnamet()+"','"+item.getPatientVisitXId()+"','"
                    +item.statusContactFunds+"',"+item.discountPayment+","
                    +item.discountTax+","+item.receivePayment+","
                    +item.receiveOver+",'"+item.invoiceNumber+"','"
                    +item.injuryNumber+"')";
          }else{
            sql = "Update " + bbpi.getBackTBillingPaymentItem()
                    +" set "+bbpi.getFAmount()+" = " + item.getAmount() + ", "
                    + bbpi.getFBillingPaymentId() + " = '" + item.getBillingPaymentId() + "', "
                    + bbpi.getFBillingPaymentItemActive() + " = '" + item.getBillingPaymentItemActive() + "', "
                    + bbpi.getFPatientVisitId() + " = '" + item.getPatientVisitId() + "', "
                    + bbpi.getFPatientVisitXBillingId() + " = '" + item.getPatientVisitXBillingId() + "', "
                    + bbpi.getFRemark() + " = '" + item.getRemark() + "', "
                    + bbpi.getFVisitTotal() + " = " + item.getVisitTotal() + ", "
                    + bbpi.getFBillingInvoiceNumber() + " = '" + item.getBillingInvoiceNumber() + "', "
                    + bbpi.getFVisitContactJoinId() + " = '" + item.getVisitContactJoinId() + "', "
                    + bbpi.getFVisitContactJoinNamet() + " = '" + item.getVisitContactJoinNamet() + "' "
                    + "Where " + bbpi.getFBillingPaymentItemId() + " = '" + item.getBillingPaymentItemId() + "'";
            max = item.getBillingPaymentItemId();
          }
          chk = st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTBillingPaymentDB.class.getName()).log(Level.SEVERE, null, ex);
          max = ex.getMessage();
        }
        return max;
    }
    public String getTrBillingPayment(String branch_id, String date_start, String date_end, String flag){
        Vector v_payment = new Vector();
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            txt.delete(0, txt.length());
            v_payment = getBackTBillingPayment(branch_id, date_start, date_end, "search_date");
            for(int i=0;i<=v_payment.size()-1;i++){
                bbp = (BackTBillingPayment)v_payment.get(i);
                txt.append("<tr><td>").append(bbp.getBillingPaymentId()).append("</td><td>")
                        .append(bbp.getBillingPaymentDate()).append("</td><td>")
                        .append(bbp.getDescription()).append("</td><td>")
                        .append(bbp.getRemark()).append("</td><td>")
                        .append(bbp.getReceiveAmount()).append("</td><td>")
                        .append(bbp.getStatusPaymentNamet()).append("</td><td>")
                        .append(bbp.getBBankNamet()).append("</td><td>")
                        .append(bbp.getChequeNumber()).append("</td></tr>");
            }
        } catch (Exception ex) {
            Logger.getLogger(BackTBillingPaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return txt.toString();
    }
    public String getTrPatientVisitFundsBillingPayment(String branch_id, String flagpage, String status_billing, String date_end, String visit_hn) {
        String node_parent="", node_child="", data_child="", node_item="", data_item="";
        String injury_number="",hn_search="",date_search="";
        Integer row=100, row_detail=100,row_item=1, row_vn=1;
        StringBuilder data_vn = new StringBuilder();
        StringBuilder chk_box = new StringBuilder();
        StringBuilder node_vn = new StringBuilder();
        StringBuilder date_visit = new StringBuilder();
        //        Double paid=0.0, paid_item=0.0, paid_detail=0.0;
        //        BContact contact = new BContact();
        sql.delete(0, sql.length());
        txt.delete(0, txt.length());
        if (visit_hn.equals(""))
          hn_search = "";
        else {
          hn_search = " and bpv_c." + bpvF.getFVisitHn() + " like '%" + visit_hn + "' ";
        }
        if (date_end.equals(""))
          date_search = "";
        else {
          date_search = " and bpv_c." + bpvF.getFCloseDayDate() + " <= '" + date_end + "' ";
        }
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          Statement st_detail = conn.createStatement();
          Statement st_vn = conn.createStatement();
          Statement st_item = conn.createStatement();
        node_parent = row.toString();
        sql.delete(0, sql.length());
        sql.append("Select bpv_c.").append(bpvF.getFPatientFullnamet()).append(" as ").append(bpvF.getFPatientFullnamet())
                .append(",min(bpv_c.").append(bpvF.getFVisitHn()).append(") as ").append(bpvF.getFVisitHn()).append(",")
                .append(" count(1) as cnt, sum(").append(bpv_fi.getFItemTotal()).append(") as paid, bpv_c.").append(bpvF.getFInjuryNumber()).append(" ")
                .append("From ").append(bpvF.getBackTPatientVisitFunds()).append(" as bpv_c ")
                .append("left join ").append(bpv_fi.getBackTPatientVisitFundsItem()).append(" as bpv_ci on ")
                .append(bpv_fi.getFBillingInvoiceItemActive()).append("='1' and ").append(" bpv_c.")
                .append(bpvF.getFPatientVisitFundsId()).append(" = bpv_ci.").append(bpv_fi.getFPatientVisitFundsId()).append(" ")
                .append("Where bpv_c.").append(bpvF.getFBranchId()).append(" = '").append(branch_id).append("' and bpv_c.")
                .append(bpvF.getFStatusBilling()).append("='").append(status_billing).append("' and bpv_c.")
                .append(bpvF.getFPatientVisitFundsActive()).append("='1' ").append(hn_search).append(date_search)
                .append("Group By bpv_c.").append(bpvF.getFPatientFullnamet()).append(", bpv_c.").append(bpvF.getFInjuryNumber())
                .append(" ").append("Order By bpv_c.").append(bpvF.getFPatientFullnamet());
        ResultSet rs_detail = st_detail.executeQuery(sql.toString());
        while (rs_detail.next()) {
            row_detail++;
          node_child = "";
          data_child = "";
          injury_number = "";
//          node_parent = row_detail.toString();
          injury_number = config1.StringNull(rs_detail.getString(bpvF.getFInjuryNumber()));
          data_child = "<font color='blue'><b>" + rs_detail.getString(bpvF.getFPatientFullnamet()) + "</b> hn " 
                  + rs_detail.getString(bpvF.getFVisitHn()) + "</font> " + "<font color='red'> <b>Injury no ["
                  + injury_number + "] </b></font>";
          txt.append("<tr id ='tr_").append(row_detail.toString()).append("'><td>")
                  .append(chk_box.toString()).append("<font color='blue'>").append(data_child).append("</font></td>")
                  .append("<td align='center'><font color='blue'>").append(rs_detail.getString("cnt")).append("[item]</font></td>")
                  .append("<td align='center'><font color='blue'>").append(rs_detail.getString("paid")).append("[บาท]</font>")
                  .append("<input type='hidden' id='row_").append(node_child).append("' name='row_").append(node_child)
                  .append("'value='").append(rs_detail.getString("paid")).append("'>")
                  .append("<input type='hidden' id='txt_").append(node_child).append("' name='txt_").append(node_child)
                  .append("'value='").append(rs_detail.getString(bpvF.getFVisitHn())).append("'></td></tr>");
          sql.delete(0, sql.length());
          sql.append("Select bpv_c.").append(bpvF.getFVisitBeginVisitTime()).append(" ,bpv_c.")
              .append(bpvF.getFVisitVn()).append(" ,").append("bpv_c.").append(bpvF.getFVisitDate()).append(", ").append("bpv_c.")
              .append(bpvF.getFPatientVisitFundsId()).append(" ")
              .append("From ").append(bpvF.getBackTPatientVisitFunds()).append(" as bpv_c ")
              .append("Where bpv_c.").append(bpvF.getFBranchId()).append(" = '").append(branch_id).append("' and bpv_c.")
              .append(bpvF.getFStatusBilling()).append("='").append(status_billing)
              .append("' and bpv_c.").append(bpvF.getFPatientVisitFundsActive()).append("='1' and bpv_c.")
              .append(bpvF.getFInjuryNumber()).append("='").append(injury_number).append("' ").append(hn_search).append(date_search)
              .append("Order By bpv_c.").append(bpvF.getFVisitDate()).append(", bpv_c.").append(bpvF.getFVisitBeginVisitTime());
          ResultSet rs_vn = st_vn.executeQuery(sql.toString());
          while (rs_vn.next()) {
              node_vn.delete(0, node_vn.length());
//            node_vn = "";
            data_vn.delete(0, data_vn.length());
            date_visit.delete(0, date_visit.length());
            date_visit.append(bpvdb.config1.DateFormatDB2ShowHospital(rs_vn.getString(bpvF.getFVisitDate()), "ddMMyyyy"));
            node_vn.append(row_vn.toString()).append(node_child).append("-").append(rs_vn.getString(bpvF.getFVisitVn()));
            data_vn.append("<a href='javascript:showInjury(").append(rs_vn.getString(bpvF.getFPatientVisitFundsId())).append(")'>")
                    .append("vn ").append(rs_vn.getString(bpvF.getFVisitVn())).append(" วันที่ ").append(date_visit.toString()).append(" ")
                    .append(rs_vn.getString(bpvF.getFVisitBeginVisitTime())).append("</a> ");
            txt.append("<tr id ='tr_").append(node_vn.toString()).append("' class='child-of-tr_").append(row_detail.toString())
                    .append("' name = '")
                    .append(row_detail.toString()).append("'><td><font color='red'>").append(data_vn.toString()).append("</td>")
                    .append("<td></td><td align='center'><font color='red'>").append(rs_vn.getString(bpvF.getFVisitVn()))
                    .append("</font>").append("</td></font></tr>");
    //            localInteger1 = row_vn; localInteger2 = row_vn = Integer.valueOf(row_vn.intValue() + 1);
          }
          rs_vn.close();
    //          localInteger1 = row_detail; localInteger2 = row_detail = Integer.valueOf(row_detail.intValue() + 1);
        }
        row_detail = 100;
        rs_detail.close();
        row++;
          conn.close();
          txt.append("<input type='hidden' id='row' name='row'value='" + row + "'>");
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
          txt.append(ex.getMessage());
        }
        return txt.toString();
    }
    public String setUpdateBackTPatientFundsBillingStatusPayment(String bracndId, String Billing_payment_item_id, String bpvFbId, String statusBill){
        String sql="";
        Integer chk=0;
        sql = "Update "+bpvFb.getBackTPatientVisitFundsBilling()+" "
                + "Set "+bpvFb.getFStatusPayment()+"='"+statusBill+"', "
                +bpvFb.getFBillingPaymentItemId()+"= '"+Billing_payment_item_id+"' "
                + "Where "+bpvFb.getFPatientVisitFundsBillingId()+"='"+bpvFbId+"' and "+bpvFb.getFBranchId()+"='"+bracndId+"'";
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTBillingPaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setUpdateBackTPatientContactBillingStatusPayment(String bracndId, String Billing_payment_item_id, String bpvCbId, String statusBill){
        String sql="";
        Integer chk=0;
        sql = "Update "+bpvCb.getBackTPatientVisitContactBilling()+" "
                + "Set "+bpvCb.getFStatusPayment()+"='"+statusBill+"', "
                +bpvCb.getFBillingPaymentItemId()+"= '"+Billing_payment_item_id+"' "
                + "Where "+bpvCb.getFPatientVisitContactBillingId()+"='"+bpvCbId+"' and "+bpvCb.getFBranchId()+"='"+bracndId+"'";
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTBillingPaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public void setUpdateBackTPatientContactBilling(String brannd_id, String Billing_payment_item_id, String bpv_cb_id){
        String sql="";
        sql = "Update "+bpvCb.getBackTPatientVisitContactBilling()+" "
                + "Set "+bpvCb.getFStatusPayment()+"='4', "
                +bpvCb.getFBillingPaymentItemId()+"= '"+Billing_payment_item_id+"' "
                + "Where "+bpvCb.getFPatientVisitContactBillingId()+"='"+bpv_cb_id+"'";
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTBillingPaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String setUpdateBackTBillingPaymentItemVoid(String brannd_id, String bbpiId){
        String sql="";
        Integer chk=0;
        sql = "Update "+bbpi.getBackTBillingPaymentItem()+" "
                + "Set "+bbpi.getFBillingPaymentItemActive()+"='3' "
                + "Where "+bbpi.getFBillingPaymentItemId()+"='"+bbpiId+"'";
        Connection conn;
        try {
            conn = bpvdb.config1.getConnectionBangna();
            Statement st = conn.createStatement();
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTBillingPaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public void setDeleteAllBackTPatientVisitBillingTemp(String branch_id) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Delete From back_t_patient_visit_funds_billing_temp ";
          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getTrPatientVisitContactBillingPayment(String branch_id, String flagpage, String status_billing, String date_end, String visit_hn) {
        String node_parent="", node_child="", data_child="", node_item="", data_item="";
        String injury_number="",hn_search="",date_search="";
        Integer row=100, row_detail=100,row_item=1, row_vn=1;
        StringBuilder data_vn = new StringBuilder();
        StringBuilder chk_box = new StringBuilder();
        StringBuilder node_vn = new StringBuilder();
        StringBuilder date_visit = new StringBuilder();
        //        Double paid=0.0, paid_item=0.0, paid_detail=0.0;
        //        BContact contact = new BContact();
        sql.delete(0, sql.length());
        txt.delete(0, txt.length());
        if (visit_hn.equals(""))
          hn_search = "";
        else {
          hn_search = " and bpv_c." + bpv_c.getFVisitHn() + " like '%" + visit_hn + "' ";
        }
        if (date_end.equals(""))
          date_search = "";
        else {
          date_search = " and bpv_c." + bpv_c.getFCloseDayDate() + " <= '" + date_end + "' ";
        }
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          Statement st_detail = conn.createStatement();
          Statement st_vn = conn.createStatement();
          Statement st_item = conn.createStatement();
        node_parent = row.toString();
        sql.delete(0, sql.length());
        sql.append("Select bpv_c.").append(bpv_c.getFPatientFullnamet()).append(" as ").append(bpv_c.getFPatientFullnamet())
                .append(",min(bpv_c.").append(bpv_c.getFVisitHn()).append(") as ").append(bpv_c.getFVisitHn()).append(",")
                .append(" count(1) as cnt, sum(").append(bpv_ci.getFItemTotal()).append(") as paid ")
                .append("From ").append(bpv_c.getBackTPatientVisitContact()).append(" as bpv_c ")
                .append("left join ").append(bpv_ci.getBackTPatientVisitContactItem()).append(" as bpv_ci on ")
                .append(bpv_ci.getFBillingInvoiceItemActive()).append("='1' and ").append(" bpv_c.")
                .append(bpv_c.getFPatientVisitContactId()).append(" = bpv_ci.").append(bpv_ci.getFPatientVisitContactId()).append(" ")
                .append("Where bpv_c.").append(bpv_c.getFBranchId()).append(" = '").append(branch_id).append("' and bpv_c.")
                .append(bpv_c.getFStatusBilling()).append("='").append(status_billing).append("' and bpv_c.")
                .append(bpv_c.getFPatientVisitContactActive()).append("='1' ").append(hn_search).append(date_search)
                .append("Group By bpv_c.").append(bpv_c.getFPatientFullnamet()).append(" ")
                .append("Order By bpv_c.").append(bpv_c.getFPatientFullnamet());
        ResultSet rs_detail = st_detail.executeQuery(sql.toString());
        while (rs_detail.next()) {
            row_detail++;
          node_child = "";
          data_child = "";
          injury_number = "";
//          node_parent = row_detail.toString();
//          injury_number = bpvdb.config1.StringNull(rs_detail.getString(bpv_c.getFInjuryNumber()));
          data_child = "<font color='blue'><b>" + rs_detail.getString(bpv_c.getFPatientFullnamet()) + "</b> hn "
                  + rs_detail.getString(bpv_c.getFVisitHn()) + "</font> " ;//+ "<font color='red'> <b>Injury no ["
                  //+ injury_number + "] </b></font>";
          txt.append("<tr id ='tr_").append(row_detail.toString()).append("'><td>")
                  .append(chk_box.toString()).append("<font color='blue'>").append(data_child).append("</font></td>")
                  .append("<td align='center'><font color='blue'>").append(rs_detail.getString("cnt")).append("[item]</font></td>")
                  .append("<td align='center'><font color='blue'>").append(rs_detail.getString("paid")).append("[บาท]</font>")
                  .append("<input type='hidden' id='row_").append(node_child).append("' name='row_").append(node_child)
                  .append("'value='").append(rs_detail.getString("paid")).append("'>")
                  .append("<input type='hidden' id='txt_").append(node_child).append("' name='txt_").append(node_child)
                  .append("'value='").append(rs_detail.getString(bpv_c.getFVisitHn())).append("'></td></tr>");
          sql.delete(0, sql.length());
          sql.append("Select bpv_c.").append(bpv_c.getFVisitBeginVisitTime()).append(" ,bpv_c.")
              .append(bpv_c.getFVisitVn()).append(" ,").append("bpv_c.").append(bpv_c.getFVisitDate()).append(", ").append("bpv_c.")
              .append(bpv_c.getFPatientVisitContactId()).append(" ")
              .append("From ").append(bpv_c.getBackTPatientVisitContact()).append(" as bpv_c ")
              .append("Where bpv_c.").append(bpv_c.getFBranchId()).append(" = '").append(branch_id).append("' and bpv_c.")
              .append(bpv_c.getFStatusBilling()).append("='").append(status_billing)
              .append("' and bpv_c.").append(bpv_c.getFPatientVisitContactActive()).append("='1' ").append(hn_search).append(date_search)
              .append("Order By bpv_c.").append(bpv_c.getFVisitDate()).append(", bpv_c.").append(bpv_c.getFVisitBeginVisitTime());
          ResultSet rs_vn = st_vn.executeQuery(sql.toString());
          while (rs_vn.next()) {
              node_vn.delete(0, node_vn.length());
//            node_vn = "";
            data_vn.delete(0, data_vn.length());
            date_visit.delete(0, date_visit.length());
            date_visit.append(bpvdb.config1.DateFormatDB2ShowHospital(rs_vn.getString(bpv_c.getFVisitDate()), "ddMMyyyy"));
            node_vn.append(row_vn.toString()).append(node_child).append("-").append(rs_vn.getString(bpv_c.getFVisitVn()));
            data_vn.append("<a href='javascript:showInjury(").append(rs_vn.getString(bpv_c.getFPatientVisitContactId())).append(")'>")
                    .append("vn ").append(rs_vn.getString(bpv_c.getFVisitVn())).append(" วันที่ ").append(date_visit.toString()).append(" ")
                    .append(rs_vn.getString(bpv_c.getFVisitBeginVisitTime())).append("</a> ");
            txt.append("<tr id ='tr_").append(node_vn.toString()).append("' class='child-of-tr_").append(row_detail.toString())
                    .append("' name = '")
                    .append(row_detail.toString()).append("'><td><font color='red'>").append(data_vn.toString()).append("</td>")
                    .append("<td></td><td align='center'><font color='red'>").append(rs_vn.getString(bpv_c.getFVisitVn()))
                    .append("</font>").append("</td></font></tr>");
    //            localInteger1 = row_vn; localInteger2 = row_vn = Integer.valueOf(row_vn.intValue() + 1);
          }
          rs_vn.close();
    //          localInteger1 = row_detail; localInteger2 = row_detail = Integer.valueOf(row_detail.intValue() + 1);
        }
        row_detail = 100;
        rs_detail.close();
        row++;
          conn.close();
          txt.append("<input type='hidden' id='row' name='row'value='" + row + "'>");
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB1.class.getName()).log(Level.SEVERE, null, ex);
          txt.append(ex.getMessage());
        }
        return txt.toString();
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
          Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public String getTrPaymentItem(String branchId, String visitHn) throws Exception{
//        String txtSum="",tHeader="",tHidden="", paymentDate="", bbpId="";
//        Integer i=0;
//        Double total=0.0;
//        txt.delete(0, txt.length());
//        Vector vPaymentItem = new Vector();
//        vPaymentItem =getBackTBillingPaymentItem(branchId, visitHn, "hn");
//        for(i=0;i<=vPaymentItem.size()-1;i++){
//            bbpi = (BackTBillingPaymentItem)vPaymentItem.get(i);
//            bbpId = bbpi.getBillingPaymentId();
//            total = bbpi.getAmount();
//            tHidden = "<input type='hidden' id='txt_bbpid"+i+"' value='"+bbpi.getBillingPaymentItemId()+"' size='8' />";
//            txt.append("<tr><td>").append((i+1)).append("</td><td><label><input type='checkbox' name='chk_").append(i)
//                .append("' id ='chk_").append(i).append("' value='' onchange='cal(").append(i).append(");'>เลือก</label></td><td>")
//                .append(bbpi.getBillingInvoiceNumber()).append("</td><td>").append(bbpi.getPatientFullnamet()).append("</td><td align='right'>")
//                .append(bpvdb.config1.NumberFormat(bbpi.getVisitTotal())).append("</td><td align='right'>").append(tHidden).append(bpvdb.config1.NumberFormat(bbpi.getAmount())).append("</td></tr>");
//        }
//        bbp = getBackTBillingPaymentByPK(branchId, bbpId);
//        paymentDate = bpvdb.config1.DateFormatDB2Show(bbp.getBillingPaymentDate(),"ddMMyyyy");
//        tHeader="<tr style='font-size: 12px'>"
//                + "<td>ลำดับ</td>"
//                + "<td></td>"
//                + "<td>เลขที่</td>"
//                + "<td>ชื่อ-นามสกุล</td>"
//                + "<td>ยอด</td>"
//                + "<td>รับชำระ</td>"
////                + "<td>วันที่</td>"
//                + "</tr>";
//        txtSum = "<table style='font-size: 12px'><tr><td>จำนวนบิล</td>"
//                + "<td><input type='text' id='txt_qty_bill' value='"+i+"' size='8' readonly></td>"
//                + "<td>จำนวนเงิน</td><td><input type='text' id='txt_amount_bill' value='"+bpvdb.config1.NumberFormat(total)+"' size='8' readonly></td>"
//                + "<td>"+paymentDate+"</td></tr></table>";
//        return txtSum+"<table>"+tHeader+txt.toString()+"</table>";
//    }
//    public void setUpdatePaymentItemVoid(String branchId, String data){
//        String bbpiId="", currDate="",statusBill="";
//        String[] aaa = data.split("\\^");
//        BackTPatientVisitFundsDB bpvFdb = new BackTPatientVisitFundsDB();
//        Vector vBpvF = new Vector();
//        //step 1. ยกเลิก payment
//        //step 2. คืน status '2' ให้กลับ module ที่รับชำระ และ field receive_amount ต้องทอนออกด้วย
//        //step 3.
//        currDate = bpvdb.config1.getDateDBHospital("ddMMyyyy");
//        for(int i=0;i<=aaa.length-1;i++) {
//            bbpiId = aaa[i];
//            bbpi = getBackTBillingPaymentItemByPK(branchId, bbpiId);
//            setUpdateBackTBillingPaymentItemVoid(branchId, bbpiId);
//            vBpvF = bpvFdb.getBackTPatientVisitFunds(branchId, bbpi.getBillingInvoiceNumber(),"","billing_number_hn");
//            for(int j=0;j<=vBpvF.size()-1;j++){
//                bpvFdb.bpv_f = (BackTPatientVisitFunds)vBpvF.get(j);
//                statusBill = bpvFdb.setUpdatePatientVisitFundsStatusPayment(branchId, bpvFdb.bpv_f.getPatientVisitFundsId(),
//                        bbpi.getBillingPaymentItemId(), "2", bbpi.getAmount(), currDate);
//                if(statusBill.equals("2")){
//                    setUpdateBackTPatientFundsBillingStatusPayment(branchId,bbpi.getBillingPaymentItemId(),bpvFdb.bpv_f.getPatientVisitFundsBillingId(),statusBill);
//                }
//            }
//        }
//    }
}
