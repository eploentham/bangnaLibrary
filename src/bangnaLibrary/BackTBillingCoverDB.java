package bangnaLibrary;

import com.bangna.object.BackTPatientVisitFundsBillingTemp;
import com.bangna.object.BackTPatientVisitFundsBilling;
import com.bangna.objdb.BackTPatientVisitFundsBillingDB;
import com.bangna.objdb.BackTPatientVisitContactBillingDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BackTBillingCoverDB{
    public BackTBillingCover billing_cover;
    String idtable="162";
    BackTPatientVisitFundsBillingDB bpv_fbdb;
    Config1 config1;
    public BackTBillingCoverDB(){
        config1 = new Config1();
        initConfig(config1);
    }
    public BackTBillingCoverDB(Config1 cf){
        config1 = cf;
        initConfig(cf);
    }
    public void initConfig(Config1 cf){
        billing_cover = new BackTBillingCover();
        bpv_fbdb = new BackTPatientVisitFundsBillingDB(cf);
    }
    public String getMaxRowBackBillingCover(Connection conn) {
    String sql = ""; String max = "";
        try {
            Statement st = conn.createStatement();
            sql = "Select max(" + billing_cover.getFBillingCoverId() + ") as cnt From " + billing_cover.getBackTBillingCover();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))
                max = String.valueOf(Integer.parseInt(max) + 1);
            else
                max = "1620000001";
        }catch (Exception ex) {
          Logger.getLogger(BackTBillingCoverDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }

    public BackTBillingCover getBackTBillingCoverByPK(String branch_id, String billing_cover_id) {
        String sql = "";
        try {
//            billing_cover.initial();
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            sql = "Select * From " + billing_cover.getBackTBillingCover() + " " + "Where " + billing_cover.getFBillingCoverId() + "='" + billing_cover_id + "'";

            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                billing_cover = new BackTBillingCover();
                billing_cover.setBTransferId(config1.StringNull(rs.getString(billing_cover.getFBTransferId())));
                billing_cover.setBillingCoverActive(config1.StringNull(rs.getString(billing_cover.getFBillingCoverActive())));
                billing_cover.setBillingCoverDate(config1.StringNull(rs.getString(billing_cover.getFBillingCoverDate())));
                billing_cover.setBillingCoverDescription(config1.StringNull(rs.getString(billing_cover.getFBillingCoverDescription())));
                billing_cover.setBillingCoverId(config1.StringNull(rs.getString(billing_cover.getFBillingCoverId())));

                billing_cover.setBillingCoverNumber(config1.StringNull(rs.getString(billing_cover.getFBillingCoverNumber())));
                billing_cover.setBillingCoverRemark(config1.StringNull(rs.getString(billing_cover.getFBillingCoverRemark())));
                billing_cover.setBillingCoverCnt(Double.parseDouble(rs.getString(billing_cover.getFBillingCoverCnt())));
                billing_cover.setBillingCoverAmount(Double.parseDouble(rs.getString(billing_cover.getFBillingCoverAmount())));
                billing_cover.setStatusPrint(config1.StringNull(rs.getString(billing_cover.getFStatusPrint())));

                billing_cover.setBDepartmentId(config1.StringNull(rs.getString(billing_cover.getFBDepartmentId())));
                billing_cover.setBranchId(config1.StringNull(rs.getString(billing_cover.getFBranchId())));
                billing_cover.setContactName(config1.StringNull(rs.getString(billing_cover.getFContactName())));
                billing_cover.setBillingCoverStaffNamet(config1.StringNull(rs.getString(billing_cover.getFBillingCoverStaffNamet())));
                billing_cover.recordDatetime = config1.StringNull(rs.getString(billing_cover.getFRecordDatetime()));
            }

            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTBillingCoverDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return billing_cover;
    }

    public Vector getBackTBillingCover(String branch_id, String billing_cover_id, String flag) {
        String sql = "";
        Vector v_billing_cover = new Vector();
        try {
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            if (flag.equals("status_print")) {
                sql = "Select * From " + billing_cover.getBackTBillingCover() + " " + "Where " + billing_cover.getFStatusPrint() + "='" + billing_cover_id + "' and " + billing_cover.getFBillingCoverActive() + "='1'";
            }else{
                sql = "Select * From " + billing_cover.getBackTBillingCover() + " " + "Where " + billing_cover.getFBillingCoverId() + "='" + billing_cover_id + "'";
            }
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                billing_cover = new BackTBillingCover();
                billing_cover.setBTransferId(config1.StringNull(rs.getString(billing_cover.getFBTransferId())));
                billing_cover.setBillingCoverActive(config1.StringNull(rs.getString(billing_cover.getFBillingCoverActive())));
                billing_cover.setBillingCoverDate(config1.StringNull(rs.getString(billing_cover.getFBillingCoverDate())));
                billing_cover.setBillingCoverDescription(config1.StringNull(rs.getString(billing_cover.getFBillingCoverDescription())));
                billing_cover.setBillingCoverId(config1.StringNull(rs.getString(billing_cover.getFBillingCoverId())));

                billing_cover.setBillingCoverNumber(config1.StringNull(rs.getString(billing_cover.getFBillingCoverNumber())));
                billing_cover.setBillingCoverRemark(config1.StringNull(rs.getString(billing_cover.getFBillingCoverRemark())));
                billing_cover.setBillingCoverCnt(Double.valueOf(Double.parseDouble(rs.getString(billing_cover.getFBillingCoverCnt()))));
                billing_cover.setBillingCoverAmount(Double.valueOf(Double.parseDouble(rs.getString(billing_cover.getFBillingCoverAmount()))));
                billing_cover.setStatusPrint(config1.StringNull(rs.getString(billing_cover.getFStatusPrint())));

                billing_cover.setBDepartmentId(config1.StringNull(rs.getString(billing_cover.getFBDepartmentId())));
                billing_cover.setBranchId(config1.StringNull(rs.getString(billing_cover.getFBranchId())));
                billing_cover.setContactName(config1.StringNull(rs.getString(billing_cover.getFContactName())));
                billing_cover.setBillingCoverStaffNamet(config1.StringNull(rs.getString(billing_cover.getFBillingCoverStaffNamet())));
                billing_cover.recordDatetime = config1.StringNull(rs.getString(billing_cover.getFRecordDatetime()));

                v_billing_cover.add(billing_cover);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTBillingCoverDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_billing_cover;
    }
    public String setSaveBackTBillingCover(String branch_id, BackTBillingCover item) throws Exception {
        int chk = 0;
        String sql = ""; String max = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            billing_cover = getBackTBillingCoverByPK(branch_id, item.getBillingCoverId());
            item.setBillingCoverDescription(config1.StringNull(item.getBillingCoverDescription()).replace("'", "''"));
            item.setBillingCoverRemark(config1.StringNull(item.getBillingCoverRemark()).replace("'", "''"));
            item.billingCoverStaffNamet = config1.StringNull(item.billingCoverStaffNamet).replace("'", "''");
            item.recordDatetime = config1.getDateDBHospital("yyyyMMdd");
            if (billing_cover.getBillingCoverId().equals("")) {
                item.generateOID(idtable);
                max = item.getObjectId();
//                max = getMaxRowBackBillingCover(conn);
                sql = "Insert Into " + billing_cover.getBackTBillingCover() 
                    + "(" + billing_cover.getFBillingCoverId() + ", " + billing_cover.getFBTransferId() + ", "
                    + billing_cover.getFBillingCoverActive() + "," + billing_cover.getFBillingCoverDate() + ","
                    + billing_cover.getFBillingCoverDescription() + "," + billing_cover.getFBillingCoverNumber() + ","
                    + billing_cover.getFBillingCoverRemark() + "," + billing_cover.getFBillingCoverCnt() + ","
                    + billing_cover.getFBillingCoverAmount() + "," + billing_cover.getFStatusPrint() + ","
                    + billing_cover.getFBDepartmentId() + ","+billing_cover.getFBranchId()+","
                    + billing_cover.getFContactName()+","+billing_cover.getFBillingCoverStaffNamet()+","
                    + billing_cover.getFRecordDatetime()+") "
                    + "Values('" + max + "','" + item.getBTransferId() + "','"
                    + item.getBillingCoverActive() + "','" + item.getBillingCoverDate() + "','"
                    + item.getBillingCoverDescription() + "','" + item.getBillingCoverNumber() + "','"
                    + item.getBillingCoverRemark() + "'," + item.getBillingCoverCnt() + ","
                    + item.getBillingCoverAmount() + ",'" + item.getStatusPrint() + "','"
                    + item.getBDepartmentId() + "','"+item.getBranchId()+"','"
                    + item.contactName+"','"+item.billingCoverStaffNamet+"','"
                    + item.recordDatetime+"')";
            }else{
                sql = "Update " + billing_cover.getBackTBillingCover()
                    + " set " + billing_cover.getFBTransferId() + " = '" + item.getBTransferId() + "', "
                    + billing_cover.getFBillingCoverActive() + " = '" + item.getBillingCoverActive() + "', "
                    + billing_cover.getFBillingCoverDate() + " = '" + item.getBillingCoverDate() + "', "
                    + billing_cover.getFBillingCoverDescription() + " = '" + item.getBillingCoverDescription() + "', "
                    + billing_cover.getFBillingCoverNumber() + " = '" + item.getBillingCoverNumber() + "', "
                    + billing_cover.getFBillingCoverRemark() + " = '" + item.getBillingCoverRemark() + "', "
                    + billing_cover.getFBillingCoverCnt() + " = " + item.getBillingCoverCnt() + ", "
                    + billing_cover.getFBillingCoverAmount() + " = " + item.getBillingCoverAmount() + ", "
                    + billing_cover.getFStatusPrint() + " = '" + item.getStatusPrint() + "', "
                    + billing_cover.getFBDepartmentId() + " = '" + item.getBDepartmentId() + "', "
                    + billing_cover.getFBranchId() + " = '" + item.getBranchId() + "', "
                    + billing_cover.getFContactName() + " = '" + item.getContactName() + "' "
                    + "Where " + billing_cover.getFBillingCoverId() + " = '" + item.getBillingCoverId() + "'";
                max = item.getBillingCoverId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTBillingCoverDB.class.getName()).log(Level.SEVERE, null, ex);
          max = ex.getMessage();
        }
        return max;
    }
    private String setUpdateBillingCoverAmount(Statement st, String branch_id,String billing_cover_id, Double total,
            String totalBaht, Double cnt){
        Integer chk=0;
        String sql = "Update "+billing_cover.getBackTBillingCover()
                +" Set "+billing_cover.getFBillingCoverAmount()+"="+total+","
                +billing_cover.getFBillingCoverCnt()+"="+cnt+", "
                +billing_cover.getFBillingCoverAmountBaht()+"='(#"+totalBaht+"#)' "
                +"Where "+billing_cover.getFBillingCoverId()+"='"+billing_cover_id+"' and "+billing_cover.getFBranchId()+"='"+branch_id+"' ";
        try {
            chk = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BackTBillingCoverDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String getTrCoverBillingInvoice(String branch_id, String status_print) {
        String text = ""; String sql = ""; String text_header = "";
        Vector v_cover = new Vector();
        v_cover = getBackTBillingCover(branch_id, status_print, "status_print");
        for (int i = 0; i <= v_cover.size() - 1; i++) {
            try {
                billing_cover = new BackTBillingCover();
                billing_cover = ((BackTBillingCover)v_cover.get(i));
                text = text + "<tr><td>" + i + "</td>" + "<td>" + billing_cover.getBillingCoverNumber() + "</td>"
                        + "<td>" + config1.DateFormatDB2ShowHospital(billing_cover.getBillingCoverDate(), "ddMMyyyy") + "</td>"
                        + "<td>" + billing_cover.getBillingCoverDescription() + "</td>"
                        + "<td>" + config1.IntegerFormat(billing_cover.getBillingCoverCnt()) + "</td>"
                        + "<td>" + config1.NumberFormat(billing_cover.getBillingCoverAmount()) + "</td>" + "</tr>";
            }catch (Exception ex){
                Logger.getLogger(BackTBillingCoverDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        text_header = "<table width='100%'><thead><tr align='center' class='style14r'><th width='5' align='center'>ลำดับ</th> <th width='5' align='center'>เลขที่ใบปะหน้า</th> <th width='5' align='center'>วันที่</th> <th width='5' align='center'>รายละเอียด</th> <th width='5' align='center'>จนbill</th> <th width='5' align='center'>มูลค่า</th> </tr></thead>";
        return text_header + text + "</table>";
    }
    public String setUpdateFundsBillingCover(String branch_id, String data, String contact_name,
            String description, String remark, String cover_date, String subsystem, String flag, String staffName){
        String sql = "",billing_number="",billing_cover_id="",bpv_fb_id="",doc_number="",date_current="";
        String[] aaa = data.split("\\^");
        BDocNumberDB doc_numberdb = new BDocNumberDB();
        BackTPatientVisitFundsBilling bpv_fb = new BackTPatientVisitFundsBilling();
//        BackTPatientVisitFundsBillingDB bpv_fbdb = new BackTPatientVisitFundsBillingDB();
        BackTPatientVisitFundsBillingTemp bpv_fbt = new BackTPatientVisitFundsBillingTemp();
        Vector v_bpv_fbt = new Vector();
        Connection conn;
        Double total = 0.0, discount = 0.0, cnt=0.0;
        Integer cnt_row=0 ,chk=0;
        try {
            conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            if(cover_date.equals("")) {
                date_current = config1.getDateDBHospital("yyyyMMdd");
            }else {
                date_current = config1.DateFormatShow2DB(cover_date,"ddMMyyyy");
            }
            billing_cover = new BackTBillingCover();
            doc_number = doc_numberdb.getRunningDocNumber(branch_id, conn,"000", "back_office");
            billing_cover.setBranchId(branch_id);
            billing_cover.setContactName(contact_name);
            billing_cover.setStatusPrint("1");
            billing_cover.setBillingCoverRemark(remark);
            billing_cover.setBillingCoverDescription(description);
            billing_cover.setBillingCoverNumber(doc_number);
            billing_cover.setBillingCoverDate(date_current);
            billing_cover.setBillingCoverActive("1");
            billing_cover.setBDepartmentId(subsystem);
            billing_cover.setBTransferId("");
            billing_cover.setBillingCoverId("");
//            billing_cover.setBillingCoverStaffNamet("");
            billing_cover.billingCoverStaffNamet = staffName;
            billing_cover_id = setSaveBackTBillingCover(branch_id,billing_cover);
            if(flag.equals("cover_old")){
//                v_bpv_fbt = bpv_fbdb.getBackTPatientVisitFundsBillingTemp(branch_id,"", "2");
                v_bpv_fbt = bpv_fbdb.getBackTPatientVisitFundsBillingTemp("","", "2");
                cnt_row = v_bpv_fbt.size();
            }else{
                cnt_row = aaa.length;
            }
            for (int i = 0; i <= cnt_row - 1; i++) {
                try {
                    if(flag.equals("cover_old")){
                        bpv_fbt = (BackTPatientVisitFundsBillingTemp)v_bpv_fbt.get(i);
                        bpv_fb = bpv_fbdb.getBackTPatientVisitFundsBillingByPK(branch_id, bpv_fbt.getBillingInvoiceNumber(),"billing_payment");
                        bpv_fb_id = bpv_fb.getPatientVisitFundsBillingId();
                    }else{
                        bpv_fb_id = aaa[i];
                    }
                    if (bpv_fb_id.length() <= 0) {
                        continue;
                    }
                    cnt++;
                    bpv_fb = bpv_fbdb.getBackTPatientVisitFundsBillingByPK(branch_id, bpv_fb_id, "");
                    total += bpv_fb.getVisitTotal();
                    discount += bpv_fb.getVisitDiscount();
//                    debtordb.setSaveDebtor(branch_id, doc_number, "", bpv_fb.getVisitTotal(), date_current, "14501", "",
//                            bpv_fb.getPatientVisitFundsBillingId(), bpv_fb.getCloseDayDate());
                    sql = "Update " + bpv_fb.getBackTPatientVisitFundsBilling()
                            + " Set " + bpv_fb.getFBillingCoverNumber() + "='"+doc_number+"' "
                            + "Where " + bpv_fb.getFPatientVisitFundsBillingId() + "='" + bpv_fb_id + "'";
                    chk = st.executeUpdate(sql);
//                    sql = "Update " + bpv_fbdb.bpv_fdb.bpv_f.getBackTPatientVisitFunds()
//                            + " Set " + bpv_fbdb.bpv_fdb.bpv_f.getFReceiveDate() + "='2', "
//                            +bpv_fdb.bpv_f.getFBillingInvoiceNumber()+"='"+doc_number+"' "
//                            + "Where " + bpv_fdb.bpv_f.getFInjuryNumber() + "='" + bpv_fb.getInjuryNumber() + "' and "
//                            +bpv_fdb.bpv_f.getFBillingInvoiceNumber()+"=''";
//                    st.executeUpdate(sql);
        //          conn.close();
                }
                catch (Exception ex) {
                  Logger.getLogger(BackTBillingCoverDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            setUpdateBillingCoverAmount(st, branch_id,billing_cover_id, total+discount,config1.readCurrencyInThai(total+discount, "บาทถ้วน", "สตางค์"), cnt);
            if(flag.equals("cover_old")){
                bpv_fbdb.setDeleteAllBackTPatientVisitBillingTemp(branch_id, "2");
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTBillingCoverDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return billing_cover_id;
    }
    public String setUpdateContactBillingCover(String branch_id, String data, String contact_name,
            String description, String remark, String cover_date, String subsystem, String bTranferId, String staffNamet,
            String contact_join_id, String flag, String amountCover1){
        BContactDB contactdb = new BContactDB();
        String sql = "",contact_join_namet="",billing_cover_id="",bpv_cb_id="",doc_number="",date_current="",amountCoverItem="";
        String[] aaa = data.split("\\^");
        String[] amount1 = amountCover1.split("\\^");
        BDocNumberDB doc_numberdb = new BDocNumberDB(config1);
        BackTPatientVisitContactBillingDB bpv_cbdb = new BackTPatientVisitContactBillingDB(config1);
        Connection conn;
        Double total = 0.0, discount = 0.0, cnt=0.0, amountCover=0.0;
        Integer cnt_row=0, chk=0;
        try {
            conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            if(cover_date.equals("")) {
                cover_date = config1.getDateDBHospital("yyyyMMdd");
            }
            contactdb.contact = contactdb.getBContactByPK(branch_id, "", contact_join_id, "contact");
            if(contactdb.contact.contactFullname.equals("") && !contact_join_id.equals("")){
                contactdb.contact = contactdb.getBContactByPK(branch_id, "", contact_join_id, "contact_number");
            }
            billing_cover = new BackTBillingCover();
            bpv_cb_id = aaa[0];
            if(bpv_cb_id.equals("")){
                if(aaa.length>1){
                    bpv_cb_id = aaa[1];
                }
            }
            bpv_cbdb.bpvCb = bpv_cbdb.getBackTPatientVisitContactBillingByPK(branch_id, bpv_cb_id, "");
            if(bpv_cbdb.bpvCb.injuryNumber.equals("")){
                doc_number = doc_numberdb.getRunningDocNumber(branch_id, conn,"001", "back_office");
            }else{
                doc_number = bpv_cbdb.bpvCb.injuryNumber;
            }
            billing_cover.setBranchId(branch_id);
            billing_cover.setContactName(contactdb.contact.contactFullname);
            billing_cover.setStatusPrint("1");
            billing_cover.setBillingCoverRemark(remark);
            billing_cover.setBillingCoverDescription(description);
            billing_cover.setBillingCoverNumber(doc_number);
            billing_cover.setBillingCoverDate(cover_date);
            billing_cover.setBillingCoverActive("1");
            billing_cover.setBDepartmentId(subsystem);
            billing_cover.setBTransferId(bTranferId);
            billing_cover.setBillingCoverStaffNamet(staffNamet);
            billing_cover.setBillingCoverId("");
            billing_cover_id = setSaveBackTBillingCover(branch_id,billing_cover);
            for (int i=0; i<aaa.length; i++) {
                try {
                    bpv_cb_id = aaa[i];
                    if (bpv_cb_id.length() <= 0) 
                        continue;
                    amountCoverItem = amount1[i];
                    amountCoverItem = config1.NumberFormatRemove(amountCoverItem);
                    if(amountCoverItem.equals("")){
                        amountCoverItem="0.0";
                    }
                    amountCover += Double.parseDouble(amountCoverItem);
//                    bpv_cbdb.bpvCb = bpv_cbdb.getBackTPatientVisitContactBillingByPK(branch_id, bpv_cb_id, "");
//                    total += bpv_cbdb.bpvCb.getVisitTotal();
//                    discount += bpv_cbdb.bpvCb.getVisitDiscount();
//                    debtordb.setSaveDebtor(branch_id, doc_number, "", bpv_fb.getVisitTotal(), date_current, "14501", "",
//                            bpv_fb.getPatientVisitFundsBillingId(), bpv_fb.getCloseDayDate());
                    sql = "Update " + bpv_cbdb.bpvCb.getBackTPatientVisitContactBilling()
                        + " Set " + bpv_cbdb.bpvCb.getFBillingCoverNumber() + "='"+doc_number+"', "
                        + bpv_cbdb.bpvCb.getFAmountCover()+"="+amountCoverItem+" "
                        + "Where " + bpv_cbdb.bpvCb.getFPatientVisitContactBillingId() + "='" + bpv_cb_id + "'";
                    chk = st.executeUpdate(sql);

                }catch (Exception ex) {
                  Logger.getLogger(BackTBillingCoverDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//            setUpdateBillingCoverAmount(st, branch_id,billing_cover_id, total+discount,config1.readCurrencyInThai(total+discount, "บาทถ้วน", "สตางค์"), cnt);
            setUpdateBillingCoverAmount(st, branch_id,billing_cover_id, amountCover,config1.readCurrencyInThai(amountCover, "บาทถ้วน", "สตางค์"), cnt);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTBillingCoverDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return billing_cover_id;
    }
}