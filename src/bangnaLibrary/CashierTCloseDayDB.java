/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import bangnaLibrary.*;
import bangnaLibrary.BPeriod;
import bangnaLibrary.Config1;
import com.bangna.usecase.connection.ConnectionDBMgr;
import com.bangna.usecase.connection.ConnectionInf;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class CashierTCloseDayDB {
    BPeriod period;
    Config1 config1;
    CashierTCloseDay closeday, dbObj;
    CashierTCloseDayDetail closeday_detail;
    CashierTCloseDayInvoice cdi;
    String idtable="167", idtableItem="180", idtableinvoice="168";
    public ConnectionInf theConnectionInf;
    //DecimalFormat df = new DecimalFormat("#,##0.00");
    //DecimalFormat intf = new DecimalFormat("#,###");
    public CashierTCloseDayDB(){
        config1 = new Config1();
        initConfig(config1);
    }
    public CashierTCloseDayDB(Config1 cf){
        config1 = cf;
        initConfig(config1);
    }
    public void initConfig(Config1 cf){
        period = new BPeriod();
        closeday = new CashierTCloseDay();
        dbObj = new CashierTCloseDay();
        closeday_detail = new CashierTCloseDayDetail();
        theConnectionInf = new ConnectionDBMgr(config1.host,config1.database, config1.userDB,config1.passDB);
        cdi = new CashierTCloseDayInvoice();
//        dbObj.amtCloseDay="";
//        dbObj.amtPatientVisit="";
//        dbObj.amtPatientVn="";
        dbObj.branchId="";
//        dbObj.cash="";
//        dbObj.cashDelivery="";
//        dbObj.cashInDrawer="";
        dbObj.closeDayActive="";
        dbObj.closeDayDate="";
        dbObj.closeDayId="close_day_id";
        dbObj.closeDayTime="";
//        dbObj.cntCloseDay="";
//        dbObj.cntPatientVisit="";
//        dbObj.cntPatientVn="";
        dbObj.dateCancel="";
        dbObj.dateCreate="";
        dbObj.dateModify="";
//        dbObj.debtor="";
        dbObj.fVisitTypeId="";
        dbObj.fVisitTypeNamet="";
        dbObj.monthId="";
//        dbObj.otherAmt1="";
//        dbObj.otherAmt2="";
//        dbObj.otherAmt3="";
        dbObj.otherDescription1="";
        dbObj.otherDescription2="";
        dbObj.otherDescription3="";
        dbObj.periodId="";
        dbObj.periodNamet="";
        dbObj.staffRecordId="";
        dbObj.staffRecordName="";
        dbObj.statusImport="";
        dbObj.textTr="";
        dbObj.userCancel="";
        dbObj.userCreate="";
        dbObj.userModify="";
        dbObj.yearId="";
        dbObj.pk_field="close_day_id";
        dbObj.table="cashier_t_close_day";
        dbObj.dateMake="date_make";
        dbObj.timeMake="time_make";
        dbObj.timeFinish="time_finish";
    }
    public String getMaxRowCashierTCloseDay(Connection conn){
        String sql="", max="";
        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select max("+closeday.getFCloseDayId()+") as cnt From "+closeday.getCashierTCloseDay();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if(max!=null && !max.equals("")) {
                max =  String.valueOf(Integer.parseInt(max)+1);
            }else {
                max = "1670000001";
            }
        } catch (Exception ex) {
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowCashierTCloseDayInvoice(Connection conn){
        String sql="", max="";
        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select max("+cdi.getFCloseDayInvoiceId()+") as cnt From "+cdi.getCashierTCloseDayInvoice();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if(max!=null && !max.equals("")) {
                max =  String.valueOf(Integer.parseInt(max)+1);
            }else{
                max = "1680000001";
            }
        } catch (Exception ex) {
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowCashierTCloseDayDetail(Connection conn){
        String sql="", max="";
        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select max("+closeday_detail.getFCloseDayDetailId()+") as cnt From "+closeday_detail.getCashierTCloseDayDetail();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if(max!=null && !max.equals("")) {
                max =  String.valueOf(Integer.parseInt(max)+1);
            }else{
                max = "1800000001";
            }
        } catch (Exception ex) {
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public CashierTCloseDay getCashierTCloseDayByPK(String branch_id, String close_day_id) {
    Connection conn;
    String sql="";
    try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            closeday = new CashierTCloseDay();

        sql="Select *, bp.period_namet  "
            +"From "+closeday.getCashierTCloseDay()+" cd "+
            "left join b_period bp on cd."+closeday.getFPeriodId()+" = bp.period_id "+
            "Where "+closeday.getFCloseDayId()+"='"+close_day_id+"' and " +
                    "cd.branch_id = '"+branch_id+"'";
            //+"Order By "+admintbilllab.getFBillLabId()+" desc";
        ResultSet rs = stbangna.executeQuery(sql);
        while(rs.next()){
            closeday = new CashierTCloseDay();
            closeday.setAmtCloseDay(Double.parseDouble(rs.getString(closeday.getFAmtCloseDay())));
            closeday.setAmtPatientVisit(Double.parseDouble(rs.getString(closeday.getFAmtPatientVisit())));
            closeday.setAmtPatientVn(Double.parseDouble(rs.getString(closeday.getFAmtPatientVn())));
            closeday.setBranchId(config1.StringNull(rs.getString(closeday.getFBranchId())));
            closeday.setCash(Double.parseDouble(rs.getString(closeday.getFCash())));

            closeday.setCashDelivery(Double.parseDouble(rs.getString(closeday.getFCashDelivery())));
            closeday.setCashInDrawer(Double.parseDouble(rs.getString(closeday.getFCashInDrawer())));
            closeday.setCloseDayActive(config1.StringNull(rs.getString(closeday.getFCloseDayActive())));
            closeday.setCloseDayDate(config1.StringNull(rs.getString(closeday.getFCloseDayDate())));
            closeday.setCloseDayId(config1.StringNull(rs.getString(closeday.getFCloseDayId())));

            closeday.setCloseDayTime(config1.StringNull(rs.getString(closeday.getFCloseDayTime())));
            closeday.setCntCloseDay(Double.parseDouble(rs.getString(closeday.getFCntCloseDay())));
            closeday.setCntPatientVisit(Double.parseDouble(rs.getString(closeday.getFCntPatientVisit())));
            closeday.setCntPatientVn(Double.parseDouble(rs.getString(closeday.getFCntPatientVn())));
            closeday.setDateCancel(config1.StringNull(rs.getString(closeday.getFDateCancel())));

            closeday.setDateCreate(config1.StringNull(rs.getString(closeday.getFDateCreate())));
            closeday.setDateMake(config1.StringNull(rs.getString(closeday.getFDateMake())));
            closeday.setDateModify(config1.StringNull(rs.getString(closeday.getFDateModify())));
            closeday.setFVisitTypeId(config1.StringNull(rs.getString(closeday.getFFVisitTypeId())));
            closeday.setMonthId(config1.StringNull(rs.getString(closeday.getFMonthId())));

            closeday.setTimeMake(config1.StringNull(rs.getString(closeday.getFTimeMake())));
            closeday.setUserCancel(config1.StringNull(rs.getString(closeday.getFUserCancel())));
            closeday.setUserCreate(config1.StringNull(rs.getString(closeday.getFUserCreate())));
            closeday.setUserModify(config1.StringNull(rs.getString(closeday.getFUserModify())));
            closeday.setYearId(config1.StringNull(rs.getString(closeday.getFYearId())));

            closeday.setOtherAmt1(Double.parseDouble(rs.getString(closeday.getFOtherAmt1())));
            closeday.setOtherAmt2(Double.parseDouble(rs.getString(closeday.getFOtherAmt2())));
            closeday.setOtherAmt3(Double.parseDouble(rs.getString(closeday.getFOtherAmt3())));
            closeday.setOtherDescription1(config1.StringNull(rs.getString(closeday.getFOtherDescription1())));
            closeday.setOtherDescription2(config1.StringNull(rs.getString(closeday.getFOtherDescription2())));

            closeday.setOtherDescription3(config1.StringNull(rs.getString(closeday.getFOtherDescription3())));
            closeday.setDebtor(Double.parseDouble(rs.getString(closeday.getFDebtor())));
            closeday.setStatusImport(config1.StringNull(rs.getString(closeday.getFStatusImport())));
            closeday.setPeriodId(config1.StringNull(rs.getString(closeday.getFPeriodId())));
            closeday.setPeriodNamet(config1.StringNull(rs.getString("period_namet")));

            closeday.setStaffRecordId(config1.StringNull(rs.getString(closeday.getFStaffRecordId())));
            closeday.setStaffRecordName(config1.StringNull(rs.getString(closeday.getFStaffRecordName())));
            if(closeday.getFVisitTypeId().equals("0")) {
                closeday.setFVisitTypeNamet("การเงิน นอก");
            }else {
                closeday.setFVisitTypeNamet("การเงิน ใน");
            }
        }
        rs.close();
        conn.close();
    } catch (Exception ex) {
        Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return closeday;
}
    public Vector getCashierTCloseDay(String branch_id, String where, String close_day_id, String flag) {
    Connection conn;
    Vector v_closeday = new Vector();
    String sql="";
    try {
        conn = config1.getConnectionBangna();
        Statement stbangna = conn.createStatement();
        if(flag.equals("month")){
            sql="Select cd.*, bp.period_namet "
            +"From "+closeday.getCashierTCloseDay()+" cd " +
            "left join b_period bp on cd."+closeday.getFPeriodId()+" = bp.period_id "+
            "Where cd."+closeday.getFYearId()+"='"+where+"' and cd."+closeday.getFMonthId()+"='"+close_day_id+"' and " +
                    "cd.branch_id = '"+branch_id+"' and cd."+closeday.getFCloseDayActive()+"='1' "+
                    "Order By cd."+closeday.getFCloseDayDate()+" desc";
        }else if(flag.equals("day")){
            sql="Select cd.*, bp.period_namet "
            +"From "+closeday.getCashierTCloseDay()+" cd " +
            "left join b_period bp on cd."+closeday.getFPeriodId()+" = bp.period_id "+
            "Where cd."+closeday.getFCloseDayDate()+"='"+close_day_id+"' and " +
                    "cd.branch_id = '"+branch_id+"' and cd."+closeday.getFCloseDayActive()+"='1' "+
                    "Order By cd."+closeday.getFCloseDayDate()+" desc";
        } else{
            sql="Select * "
            +"From "+closeday.getCashierTCloseDay()+" "
            +"Where "+closeday.getFCloseDayId()+"='"+close_day_id+"'";
        }
       
        //+"Order By "+admintbilllab.getFBillLabId()+" desc";
        ResultSet rs = stbangna.executeQuery(sql);
        while(rs.next()){
            closeday = new CashierTCloseDay();
            closeday.setAmtCloseDay(Double.parseDouble(rs.getString(closeday.getFAmtCloseDay())));
            closeday.setAmtPatientVisit(Double.parseDouble(rs.getString(closeday.getFAmtPatientVisit())));
            closeday.setAmtPatientVn(Double.parseDouble(rs.getString(closeday.getFAmtPatientVn())));
            closeday.setBranchId(config1.StringNull(rs.getString(closeday.getFBranchId())));
            closeday.setCash(Double.parseDouble(rs.getString(closeday.getFCash())));

            closeday.setCashDelivery(Double.parseDouble(rs.getString(closeday.getFCashDelivery())));
            closeday.setCashInDrawer(Double.parseDouble(rs.getString(closeday.getFCashInDrawer())));
            closeday.setCloseDayActive(config1.StringNull(rs.getString(closeday.getFCloseDayActive())));
            closeday.setCloseDayDate(config1.StringNull(rs.getString(closeday.getFCloseDayDate())));
            closeday.setCloseDayId(config1.StringNull(rs.getString(closeday.getFCloseDayId())));

            closeday.setCloseDayTime(config1.StringNull(rs.getString(closeday.getFCloseDayTime())));
            closeday.setCntCloseDay(Double.parseDouble(rs.getString(closeday.getFCntCloseDay())));
            closeday.setCntPatientVisit(Double.parseDouble(rs.getString(closeday.getFCntPatientVisit())));
            closeday.setCntPatientVn(Double.parseDouble(rs.getString(closeday.getFCntPatientVn())));
            closeday.setDateCancel(config1.StringNull(rs.getString(closeday.getFDateCancel())));

            closeday.setDateCreate(config1.StringNull(rs.getString(closeday.getFDateCreate())));
            closeday.setDateMake(config1.StringNull(rs.getString(closeday.getFDateMake())));
            closeday.setDateModify(config1.StringNull(rs.getString(closeday.getFDateModify())));
            closeday.setFVisitTypeId(config1.StringNull(rs.getString(closeday.getFFVisitTypeId())));
            closeday.setMonthId(config1.StringNull(rs.getString(closeday.getFMonthId())));

            closeday.setTimeMake(config1.StringNull(rs.getString(closeday.getFTimeMake())));
            closeday.setUserCancel(config1.StringNull(rs.getString(closeday.getFUserCancel())));
            closeday.setUserCreate(config1.StringNull(rs.getString(closeday.getFUserCreate())));
            closeday.setUserModify(config1.StringNull(rs.getString(closeday.getFUserModify())));
            closeday.setYearId(config1.StringNull(rs.getString(closeday.getFYearId())));

            closeday.setOtherAmt1(Double.parseDouble(rs.getString(closeday.getFOtherAmt1())));
            closeday.setOtherAmt2(Double.parseDouble(rs.getString(closeday.getFOtherAmt2())));
            closeday.setOtherAmt3(Double.parseDouble(rs.getString(closeday.getFOtherAmt3())));
            closeday.setOtherDescription1(config1.StringNull(rs.getString(closeday.getFOtherDescription1())));
            closeday.setOtherDescription2(config1.StringNull(rs.getString(closeday.getFOtherDescription2())));
            
            closeday.setOtherDescription3(config1.StringNull(rs.getString(closeday.getFOtherDescription3())));
            closeday.setDebtor(Double.parseDouble(rs.getString(closeday.getFDebtor())));
            closeday.setStatusImport(config1.StringNull(rs.getString(closeday.getFStatusImport())));
            closeday.setPeriodId(config1.StringNull(rs.getString(closeday.getFPeriodId())));
            closeday.setPeriodNamet(config1.StringNull(rs.getString("period_namet")));

            closeday.setStaffRecordId(config1.StringNull(rs.getString(closeday.getFStaffRecordId())));
            closeday.setStaffRecordName(config1.StringNull(rs.getString(closeday.getFStaffRecordName())));
            if(closeday.getFVisitTypeId().equals("0")) {
                closeday.setFVisitTypeNamet("การเงิน นอก");
            }else {
                closeday.setFVisitTypeNamet("การเงิน ใน");
            }

            v_closeday.add(closeday);
            }
        rs.close();
        conn.close();
    } catch (Exception ex) {
        Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return v_closeday;
}
public CashierTCloseDayDetail getCashierTCloseDayDetailByPK(String branch_id, String close_day_detail_id) {
    Connection conn;
    String sql="";
    try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();

        sql="Select * "
            +"From "+closeday_detail.getCashierTCloseDayDetail()+"  "+
            "Where "+closeday_detail.getFCloseDayDetailId()+"='"+close_day_detail_id+"'  " ;
            //+"Order By "+admintbilllab.getFBillLabId()+" desc";
        ResultSet rs = stbangna.executeQuery(sql);
        while(rs.next()){
            closeday_detail = new CashierTCloseDayDetail();
            closeday_detail.setAmount(Double.parseDouble(rs.getString(closeday_detail.getFAmount())));
            closeday_detail.setBContractPlansId(config1.StringNull(rs.getString(closeday_detail.getFBContractPlansId())));
            closeday_detail.setCloseDayDetailId(config1.StringNull(rs.getString(closeday_detail.getFCloseDayDetailId())));
            closeday_detail.setCloseDayId(config1.StringNull(rs.getString(closeday_detail.getFCloseDayId())));
            closeday_detail.setContractPlansDescription(config1.StringNull(rs.getString(closeday_detail.getFContractPlansDescription())));

            closeday_detail.setDiscount(Double.parseDouble(rs.getString(closeday_detail.getFDiscount())));
            closeday_detail.setNettotal(Double.parseDouble(rs.getString(closeday_detail.getFNettotal())));
            closeday_detail.setRemark(config1.StringNull(rs.getString(closeday_detail.getFRemark())));
            closeday_detail.setCntBContractPlan(Double.parseDouble(rs.getString(closeday_detail.getFCntBContractPlans())));
//            if(closeday_detail.getFVisitTypeId().equals("0")) {
//                closeday_detail.setFVisitTypeNamet("การเงิน นอก");
//            }else {
//                closeday_detail.setFVisitTypeNamet("การเงิน ใน");
//            }
        }
        rs.close();
        conn.close();
    } catch (Exception ex) {
        Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return closeday_detail;
}
public Vector getCashierTCloseDayDetail(String branch_id, String where, String close_day_detail_id, String flag) {
    Connection conn;
    String sql="";
    Vector v_closeday_detail = new Vector();
    try {
        conn = config1.getConnectionBangna();
        Statement stbangna = conn.createStatement();
        if(flag.equals("closeday")) {
            sql="Select * "
            +"From "+closeday_detail.getCashierTCloseDayDetail()+"  "+
            "Where "+closeday_detail.getFCloseDayId()+"='"+where+"'  " ;
        }else {
            sql="Select * "
            +"From "+closeday_detail.getCashierTCloseDayDetail()+"  "+
            "Where "+closeday_detail.getFCloseDayDetailId()+"='"+close_day_detail_id+"'  " ;
        }
        
        ResultSet rs = stbangna.executeQuery(sql);
        while(rs.next()){
            closeday_detail = new CashierTCloseDayDetail();
            closeday_detail.setAmount(Double.parseDouble(rs.getString(closeday_detail.getFAmount())));
            closeday_detail.setBContractPlansId(config1.StringNull(rs.getString(closeday_detail.getFBContractPlansId())));
            closeday_detail.setCloseDayDetailId(config1.StringNull(rs.getString(closeday_detail.getFCloseDayDetailId())));
            closeday_detail.setCloseDayId(config1.StringNull(rs.getString(closeday_detail.getFCloseDayId())));
            closeday_detail.setContractPlansDescription(config1.StringNull(rs.getString(closeday_detail.getFContractPlansDescription())));

            closeday_detail.setDiscount(Double.parseDouble(rs.getString(closeday_detail.getFDiscount())));
            closeday_detail.setNettotal(Double.parseDouble(rs.getString(closeday_detail.getFNettotal())));
            closeday_detail.setRemark(config1.StringNull(rs.getString(closeday_detail.getFRemark())));
            closeday_detail.setCntBContractPlan(Double.parseDouble(rs.getString(closeday_detail.getFCntBContractPlans())));
            v_closeday_detail.add(closeday_detail);
        }
        rs.close();
        conn.close();
    } catch (Exception ex) {
        Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return v_closeday_detail;
}
public CashierTCloseDayInvoice getCashierTCloseDayInvoiceByPK(Statement stbangna,String brach_id, String close_day_invoice_id, String flag) {
//    Connection conn;
    String sql="";
    try {
//            conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();

        sql="Select * "
            +"From "+cdi.getCashierTCloseDayInvoice()+" "
            +"Where "+cdi.getFCloseDayInvoiceId()+"='"+close_day_invoice_id+"'";
            //+"Order By "+admintbilllab.getFBillLabId()+" desc";
        ResultSet rs = stbangna.executeQuery(sql);
        while(rs.next()){
            cdi = new CashierTCloseDayInvoice();
            cdi.setBillingInvoicePayerShare(Double.parseDouble(rs.getString(cdi.getFBillingInvoicePayerShare())));
            cdi.setCloseDayActive(config1.StringNull(rs.getString(cdi.getFCloseDayActive())));
            cdi.setCloseDayId(config1.StringNull(rs.getString(cdi.getFCloseDayId())));
            cdi.setCloseDayInvoiceId(config1.StringNull(rs.getString(cdi.getFCloseDayInvoiceId())));
            cdi.setContractPlansDescription(config1.StringNull(rs.getString(cdi.getFContractPlansDescription())));

            cdi.setTBillingId(config1.StringNull(rs.getString(cdi.getFTBillingId())));
            cdi.setTBillingInvoiceId(config1.StringNull(rs.getString(cdi.getFTBillingInvoiceId())));
            cdi.setTPatientId(config1.StringNull(rs.getString(cdi.getFTPatientId())));
            cdi.setTBillInvoiceDateTime(config1.StringNull(rs.getString(cdi.getFTBillInvoiceDateTime())));
            cdi.setCntCloseDayInvoice(Double.parseDouble(cdi.getFCntCloseDayInvoice()));

            }
        rs.close();
//        conn.close();
    } catch (Exception ex) {
        Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
    }
        return cdi;
    }
public Vector getCashierTCloseDayInvoice(String brach_id, String close_day_invoice_id, String flag) {
    Connection conn;
    String sql="";
    Vector v_closeday_invoice = new Vector();
    try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();

        sql="Select * "
            +"From "+cdi.getCashierTCloseDayInvoice()+" "
            +"Where "+cdi.getCloseDayInvoiceId()+"='"+close_day_invoice_id+"'";
            //+"Order By "+admintbilllab.getFBillLabId()+" desc";
        ResultSet rs = stbangna.executeQuery(sql);
        while(rs.next()){
            cdi = new CashierTCloseDayInvoice();
            cdi.setBillingInvoicePayerShare(Double.parseDouble(rs.getString(cdi.getFBillingInvoicePayerShare())));
            cdi.setCloseDayActive(config1.StringNull(rs.getString(cdi.getFCloseDayActive())));
            cdi.setCloseDayId(config1.StringNull(rs.getString(cdi.getFCloseDayId())));
            cdi.setCloseDayInvoiceId(config1.StringNull(rs.getString(cdi.getFCloseDayInvoiceId())));
            cdi.setContractPlansDescription(config1.StringNull(rs.getString(cdi.getFContractPlansDescription())));

            cdi.setTBillingId(config1.StringNull(rs.getString(cdi.getFTBillingId())));
            cdi.setTBillingInvoiceId(config1.StringNull(rs.getString(cdi.getFTBillingInvoiceId())));
            cdi.setTPatientId(config1.StringNull(rs.getString(cdi.getFTPatientId())));
            cdi.setTBillInvoiceDateTime(config1.StringNull(rs.getString(cdi.getFTBillInvoiceDateTime())));
            cdi.setCntCloseDayInvoice(Double.parseDouble(cdi.getFCntCloseDayInvoice()));

            v_closeday_invoice.add(cdi);

            }
        rs.close();
        conn.close();
    } catch (Exception ex) {
        Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
    }
        return v_closeday_invoice;
    }
    public String setSaveCashierTCloseDay(String branch_id, CashierTCloseDay item) throws Exception {
        String max="";
        Connection conn;
        Statement st;
        conn = config1.getConnectionBangna();
        st = conn.createStatement();
        max = setSaveCashierTCloseDay(st, branch_id, item);
        conn.close();
        return max;
    } 
    public String setSaveCashierTCloseDay(Statement st, String branch_id, CashierTCloseDay item) throws Exception {
        int chk=0;
        String sql="", ma_date="", attend_date="", max="";
//        Connection conn;
//        Statement st;
        try {
//            conn = config1.getConnectionBangna();
//            st = conn.createStatement();
            closeday = getCashierTCloseDayByPK(branch_id,item.getCloseDayId());
//            item.setRemark(item.getRemark().replace("'", "''"));
//            item.setDescription(item.getDescription().replace("'", "''"));
            if(closeday.getCloseDayId().equals("")){
                item.generateOID(idtable);
                max = item.getObjectId();
//                max = getMaxRowCashierTCloseDay(conn);
                sql="Insert Into "+closeday.getCashierTCloseDay()+"("+
                        closeday.getFCloseDayId()+", "+closeday.getFAmtPatientVisit()+", "+
                        closeday.getFAmtPatientVn()+","+ closeday.getFBranchId()+","+
                        closeday.getFCash()+","+ closeday.getFCashDelivery()+","+
                        closeday.getFCashInDrawer()+","+ closeday.getFCloseDayActive()+","+
                        closeday.getFCloseDayDate()+","+closeday.getFAmtCloseDay()+"," +
                        closeday.getFCloseDayTime()+","+closeday.getFCntCloseDay()+"," +
                        closeday.getFCntPatientVisit()+","+closeday.getFCntPatientVn()+"," +
                        closeday.getFDateCancel()+","+closeday.getFDateCreate()+"," +
                        closeday.getFDateMake()+","+closeday.getFDateModify()+"," +
                        closeday.getFFVisitTypeId()+","+closeday.getFMonthId()+"," +
                        closeday.getFTimeMake()+","+closeday.getFUserCancel()+"," +
                        closeday.getFUserCreate()+","+closeday.getFUserModify()+"," +
                        closeday.getFYearId()+","+closeday.getFOtherAmt1()+"," +
                        closeday.getFOtherAmt2()+","+closeday.getFOtherAmt3()+"," +
                        closeday.getFOtherDescription1()+","+closeday.getFOtherDescription2()+"," +
                        closeday.getFOtherDescription3()+","+closeday.getFDebtor()+"," +
                        closeday.getFStatusImport()+","+closeday.getFPeriodId()+","
                        + closeday.getFStaffRecordId()+","+closeday.getFStaffRecordName()+") "+
                        "Values('"+max+"',"+item.getAmtPatientVisit()+","+
                        item.getAmtPatientVn() + ",'"+ item.getBranchId()+"',"+
                        item.getCash() + ","+ item.getCashDelivery()+","+
                        item.getCashInDrawer() + ",'"+ item.getCloseDayActive()+"','"+
                        item.getCloseDayDate() + "',"+item.getAmtCloseDay()+",'" +
                        item.getCloseDayTime()+"',"+item.getCntCloseDay()+"," +
                        item.getCntPatientVisit()+","+item.getCntPatientVn()+",'" +
                        item.getDateCancel()+"','"+item.getDateCreate()+"','" +
                        item.getDateMake()+"','"+item.getDateModify()+"','" +
                        item.getFVisitTypeId()+"','"+item.getMonthId()+"','" +
                        item.getTimeMake()+"','"+item.getUserCancel()+"','" +
                        item.getUserCreate()+"','"+item.getUserModify()+"','" +
                        item.getYearId()+"',"+item.getOtherAmt1()+"," +
                        item.getOtherAmt2()+","+item.getOtherAmt3()+",'" +
                        item.getOtherDescription1()+"','"+item.getOtherDescription2()+"','" +
                        item.getOtherDescription3()+"',"+item.getDebtor()+",'" +
                        item.getStatusImport()+"','"+item.getPeriodId()+"','"
                        + item.getStatffRecordId()+"','"+item.getStatffRecordName()+"')";
            }else{
                sql = "Update "+closeday.getCashierTCloseDay()+" set "+
                closeday.getFAmtPatientVisit()+" = "+item.getAmtPatientVisit()+", "+
                closeday.getFAmtPatientVn()+" = "+item.getAmtPatientVn()+", "+
                closeday.getFBranchId()+" = '"+item.getBranchId()+"', "+
                closeday.getFCash()+" = '"+item.getCash()+"', "+
                closeday.getFCashDelivery()+" = "+item.getCashDelivery()+", "+
                closeday.getFCashInDrawer()+" = "+item.getCashInDrawer()+", "+
                closeday.getFCloseDayActive()+" = '"+item.getCloseDayActive()+"', "+
                closeday.getFCloseDayDate()+" = '"+item.getCloseDayDate()+"', "+
                closeday.getFAmtCloseDay()+" = "+item.getAmtCloseDay()+", "+
                closeday.getFCloseDayTime()+" = '"+item.getCloseDayTime()+"', " +
                closeday.getFCntCloseDay()+" = "+item.getCntCloseDay()+", "+
                closeday.getFCntPatientVisit()+" = "+item.getCntPatientVisit()+", "+
                closeday.getFCntPatientVn()+" = "+item.getCntPatientVn()+", "+
                closeday.getFDateCancel()+" = "+item.getDateCancel()+", "+
                closeday.getFDateCreate()+" = "+item.getDateCreate()+", "+
                closeday.getFDateMake()+" = "+item.getDateMake()+", "+
                closeday.getFDateModify()+" = '"+item.getDateModify()+"', "+
                closeday.getFFVisitTypeId()+" = '"+item.getFVisitTypeId()+"', "+
                closeday.getFMonthId()+" = '"+item.getMonthId()+"', "+
                closeday.getFTimeMake()+" = '"+item.getTimeMake()+"', "+
                closeday.getFUserCancel()+" = '"+item.getUserCancel()+"', "+
                closeday.getFUserCreate()+" = '"+item.getUserCreate()+"', "+
                closeday.getFUserModify()+" = '"+item.getUserModify()+"', "+
                closeday.getFYearId()+" = '"+item.getYearId()+"', "+
                closeday.getFOtherAmt1()+"="+item.getOtherAmt1()+", "+
                closeday.getFOtherAmt2()+"="+item.getOtherAmt2()+", "+
                closeday.getFOtherAmt3()+"="+item.getOtherAmt3()+", "+
                closeday.getFOtherDescription1()+"='"+item.getOtherDescription1()+"', "+
                closeday.getFOtherDescription2()+"='"+item.getOtherDescription2()+"', "+
                closeday.getFOtherDescription3()+"='"+item.getOtherDescription3()+"', "+
                closeday.getFDebtor()+"="+item.getDebtor()+", "+
                closeday.getFStatusImport()+"='"+item.getStatusImport()+"', "+
                closeday.getFPeriodId()+"='"+item.getPeriodId()+"' "+
                "Where "+closeday.getFCloseDayId()+" = '"+item.getCloseDayId()+"'";
                max = item.getCloseDayId();
            }
            chk = st.executeUpdate(sql);
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String setSaveCashierTCloseDayDetail(String branch_id, CashierTCloseDayDetail item) throws Exception {
        String chk="";
        Connection conn;
        Statement st;
        conn = config1.getConnectionBangna();
        st = conn.createStatement();
        chk = setSaveCashierTCloseDayDetail(st,branch_id, item);
        conn.close();
        return chk;
    }
    public String setSaveCashierTCloseDayDetail(Statement st,String branch_id, CashierTCloseDayDetail item) throws Exception {
        int chk=0;
        String sql="", ma_date="", attend_date="", max="";
//        Connection conn;
//        Statement st;
        try {
//            conn = config1.getConnectionBangna();
//            st = conn.createStatement();
            closeday_detail = getCashierTCloseDayDetailByPK(branch_id,item.getCloseDayDetailId());
//            item.setRemark(item.getRemark().replace("'", "''"));
//            item.setDescription(item.getDescription().replace("'", "''"));
            if(closeday_detail.getCloseDayDetailId().equals("")){
                item.generateOID(idtableItem);
                max = item.getObjectId();
//                max = getMaxRowCashierTCloseDayDetail(conn);
                sql="Insert Into "+closeday_detail.getCashierTCloseDayDetail()+"("+
                        closeday_detail.getFCloseDayDetailId()+", "+closeday_detail.getFAmount()+", "+
                        closeday_detail.getFBContractPlansId()+","+ closeday_detail.getFCloseDayId()+","+
                        closeday_detail.getFContractPlansDescription()+","+ closeday_detail.getFDiscount()+","+
                        closeday_detail.getFNettotal()+","+closeday_detail.getFRemark()+"," +
                        closeday_detail.getFCntBContractPlans()+") "+
                        "Values('"+max+"',"+item.getAmount()+",'"+
                        item.getBContractPlansId() + "','"+ item.getCloseDayId()+"','"+
                        item.getContractPlansDescription() + "',"+ item.getDiscount()+","+
                        item.getNettotal()+",'"+item.getRemark()+"'," +
                        item.getCntBContractPlans()+")";
            }
            else{
                sql = "Update "+closeday_detail.getCashierTCloseDayDetail()+" set "+
                closeday_detail.getFAmount()+" = "+item.getAmount()+", "+
                closeday_detail.getFBContractPlansId()+"='"+item.getBContractPlansId()+"', "+
                closeday_detail.getFCloseDayId()+"='"+item.getCloseDayId()+"', "+
                closeday_detail.getFContractPlansDescription()+"='"+item.getContractPlansDescription()+"', "+
                closeday_detail.getFDiscount()+"="+item.getDiscount()+", "+
                closeday_detail.getFNettotal()+"='"+item.getNettotal()+"', "+
                closeday_detail.getFRemark()+"='"+item.getRemark()+"', "+
                closeday_detail.getFCntBContractPlans()+"="+item.getCntBContractPlans()+" "+
                "Where "+closeday_detail.getFCloseDayDetailId()+" = '"+item.getCloseDayId()+"'";
                max = item.getCloseDayDetailId();
            }
            chk = st.executeUpdate(sql);
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String setSaveCashierTCloseDayInvoice(String branch_id, CashierTCloseDayInvoice item) throws Exception {
        String max="";
        Connection conn;
        Statement st;
        conn = config1.getConnectionBangna();
        st = conn.createStatement();
        max = setSaveCashierTCloseDayInvoice(st, branch_id, item);
        conn.close();
        return max;
    }
    public String setSaveCashierTCloseDayInvoice(Statement st,String branch_id, CashierTCloseDayInvoice item) throws Exception {
        int chk=0;
        String sql="", ma_date="", attend_date="", max="";
//        Connection conn;
//        Statement st;
        try {
//            conn = config1.getConnectionBangna();
//            st = conn.createStatement();
            cdi = getCashierTCloseDayInvoiceByPK(st, branch_id,item.getCloseDayInvoiceId(),"");
//            item.setRemark(item.getRemark().replace("'", "''"));
//            item.setDescription(item.getDescription().replace("'", "''"));
            if(closeday.getCloseDayId().equals("")) {
                item.generateOID(idtableinvoice);
                max =item.getObjectId();
//                max = getMaxRowCashierTCloseDayInvoice(conn);
                sql="Insert Into "+cdi.getCashierTCloseDayInvoice()+"("+
                        cdi.getFCloseDayInvoiceId()+", "+cdi.getFBillingInvoicePayerShare()+", "+
                        cdi.getFCloseDayActive()+","+ cdi.getFCloseDayId()+","+
                        cdi.getFContractPlansDescription()+","+ cdi.getFTBillingId()+","+
                        cdi.getFTBillingInvoiceId()+","+ cdi.getFTPatientId()+"," +
                        cdi.getFTBillInvoiceDateTime()+","+cdi.getFContractPlansNumber()+"," +
                        cdi.getFCntCloseDayInvoice()+") "+
                        "Values('"+max+"','"+item.getBillingInvoicePayerShare()+"','"+
                        item.getCloseDayActive() + "','"+ item.getCloseDayId()+"','"+
                        item.getContractPlansDescription() + "','"+ item.getTBillingId()+"','"+
                        item.getTBillingInvoiceId() + "','"+ item.getTPatientId()+"','" +
                        item.getTBillInvoiceDateTime()+"','"+item.getContractPlansNumber()+"'," +
                        item.getCntCloseDayInvoice()+")";
            }
            else{
                sql = "Update "+cdi.getCashierTCloseDayInvoice()+" set "+
                cdi.getFBillingInvoicePayerShare()+" = '"+item.getBillingInvoicePayerShare()+"', "+
                cdi.getFCloseDayActive()+" = '"+item.getCloseDayActive()+"', "+
                cdi.getFCloseDayId()+" = '"+item.getCloseDayId()+"', "+
                cdi.getFContractPlansDescription()+" = '"+item.getContractPlansDescription()+"', "+
                cdi.getFTBillingId()+" = '"+item.getTBillingId()+"', "+
                cdi.getFTBillingInvoiceId()+" = '"+item.getTBillingInvoiceId()+"', "+
                cdi.getFTPatientId()+" = '"+item.getTPatientId()+"', "+
                cdi.getFTBillInvoiceDateTime()+" = '"+item.getTBillInvoiceDateTime()+"' "+
                cdi.getFContractPlansNumber()+" = '"+item.getContractPlansNumber()+"', "+
                cdi.getFCntCloseDayInvoice()+" = "+item.getCntCloseDayInvoice()+" "+
                "Where "+cdi.getFCloseDayInvoiceId()+" = '"+item.getCloseDayInvoiceId()+"'";
                max = item.getCloseDayInvoiceId();
            }
            chk = st.executeUpdate(sql);
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public Vector getCloseDayImport(String bracnhd_id, String where, String where2, String flag, String f_visit_type_id) {
        Vector v_closeday_invoice = new Vector();
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionHospital(bracnhd_id);
            st = conn.createStatement();
            v_closeday_invoice = getCloseDayImport(st,bracnhd_id, where, where2, flag, f_visit_type_id);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return v_closeday_invoice;
    }
    public Vector getCloseDayImport(Statement st,String bracnhd_id, String where, String where2, String flag, String f_visit_type_id) {
    Vector v_closeday_invoice = new Vector();
    String sql="", staff_record_search="";
    if(where2.equals(""))
        where2="0";
    if(flag.equals("group")) {
        sql="SELECT CASE WHEN (f_patient_prefix.patient_prefix_description IS NOT NULL "+
        "AND f_patient_prefix.patient_prefix_description <> '' "+
        "AND f_patient_prefix.patient_prefix_description <> 'null' ) "+
        "THEN f_patient_prefix.patient_prefix_description ELSE '' END AS patient_prefix_description , "+
	"t_patient.patient_firstname, t_patient.patient_lastname, t_patient.patient_hn, t_visit.visit_vn, "+
	"t_visit.f_visit_type_id, b_contract_plans.contract_plans_description as plans, "+
//	"sum(t_billing_invoice.billing_invoice_payer_share) AS paid, count(1) as cnt, "+
                "sum(t_billing_invoice.billing_invoice_total) AS paid, count(1) as cnt, "+
	"t_billing_invoice_date_time, t_billing_invoice.t_billing_invoice_id, t_billing_invoice.t_billing_id,t_visit.t_patient_id "+
        "FROM t_billing_invoice "+
	"left JOIN t_visit  ON t_visit.t_visit_id = t_billing_invoice.t_visit_id "+
        "AND t_visit.f_visit_status_id <> '4' AND t_billing_invoice.billing_invoice_active = '1' " +
//        "AND (t_billing_invoice.billing_invoice_payer_share) > 0.00 " +
        "left JOIN t_visit_payment  ON t_billing_invoice.t_payment_id = t_visit_payment.t_visit_payment_id " +
        "LEFT JOIN b_contract_plans  ON t_visit_payment.b_contract_plans_id = b_contract_plans.b_contract_plans_id " +
        "left JOIN t_patient ON t_visit.t_patient_id = t_patient.t_patient_id " +
        "LEFT JOIN f_patient_prefix  " +
        "ON t_patient.f_patient_prefix_id = f_patient_prefix.f_patient_prefix_id " +
        "LEFT JOIN b_employee  ON t_billing_invoice.billing_invoice_staff_record = b_employee.b_employee_id " +
        "LEFT JOIN b_service_point  ON b_employee.b_service_point_id = b_service_point.b_service_point_id " +
        "WHERE t_visit.f_visit_type_id = '"+f_visit_type_id+"' and t_billing_invoice.close_day_id ='0' " +
        "GROUP BY patient_prefix_description ,patient_firstname,patient_lastname,patient_hn,visit_vn,f_visit_type_id, " +
        "contract_plans_description,t_billing_invoice_date_time, t_billing_invoice.t_billing_invoice_id, " +
        "t_billing_invoice.t_billing_id,t_visit.t_patient_id ";
    }else if(flag.equals("get_closeday_sum")) {
        sql="Select q1.plans as plans,sum(q1.paid) as paid,contract_plans_number, count(cnt) as cnt From "+
        "(SELECT CASE WHEN (f_patient_prefix.patient_prefix_description IS NOT NULL "+
        "AND f_patient_prefix.patient_prefix_description <> '' "+
        "AND f_patient_prefix.patient_prefix_description <> 'null' ) "+
        "THEN f_patient_prefix.patient_prefix_description ELSE '' END AS patient_prefix_description , "+
	"t_patient.patient_firstname, t_patient.patient_lastname, t_patient.patient_hn, t_visit.visit_vn, "+
	"t_visit.f_visit_type_id, b_contract_plans.contract_plans_description as plans,b_contract_plans.contract_plans_number, "+
//	"sum(t_billing_invoice.billing_invoice_payer_share) AS paid, count(1) as cnt, "+
                "sum(t_billing_invoice.billing_invoice_total) AS paid, count(1) as cnt, "+
	"t_billing_invoice_date_time, t_billing_invoice.t_billing_invoice_id, t_billing_invoice.t_billing_id,t_visit.t_patient_id " +
//                "min(b_contract_payer.contract_payer_number) as contract_payer_number "+
        "FROM t_billing_invoice "+
	"left JOIN t_visit  ON t_visit.t_visit_id = t_billing_invoice.t_visit_id "+
        "AND t_visit.f_visit_status_id <> '4' AND t_billing_invoice.billing_invoice_active = '1' " +
//        "AND (t_billing_invoice.billing_invoice_payer_share) > 0.00 " +
        "left JOIN t_visit_payment ON t_billing_invoice.t_payment_id = t_visit_payment.t_visit_payment_id " +
        "LEFT JOIN b_contract_plans ON t_visit_payment.b_contract_plans_id = b_contract_plans.b_contract_plans_id " +
        "left JOIN t_patient ON t_visit.t_patient_id = t_patient.t_patient_id " +
        "LEFT JOIN f_patient_prefix  " +
        "ON t_patient.f_patient_prefix_id = f_patient_prefix.f_patient_prefix_id " +
        "LEFT JOIN b_employee ON t_billing_invoice.billing_invoice_staff_record = b_employee.b_employee_id " +
        "LEFT JOIN b_service_point ON b_employee.b_service_point_id = b_service_point.b_service_point_id " +
//        "LEFT JOIN b_contract_payer ON b_contract_payer.b_contract_payer_id = b_contract_payer.b_contract_payer_id " +
        "WHERE t_visit.f_visit_type_id = '"+f_visit_type_id+"' and t_billing_invoice.close_day_id ='"+where+"' " +
        "GROUP BY patient_prefix_description ,patient_firstname,patient_lastname,patient_hn,visit_vn,f_visit_type_id, " +
        "contract_plans_description,t_billing_invoice_date_time, t_billing_invoice.t_billing_invoice_id, " +
        "t_billing_invoice.t_billing_id,t_visit.t_patient_id,b_contract_plans.contract_plans_number) as q1 group by q1.plans,contract_plans_number";
//        sql="Select * From v_closeday_get_sum " +
//                "Where t_visit.f_visit_type_id = '"+f_visit_type_id+"' and t_billing_invoice.close_day_id ='"+where+"' ";
//        sql="SELECT q1.plans, sum(q1.paid) AS paid, q1.contract_plans_number, count(q1.cnt) AS cnt "+
//            "FROM ( SELECT b_contract_plans.contract_plans_description AS plans, b_contract_plans.contract_plans_number,  "+
//            "sum(tbii.billing_invoice_item_total) AS paid, count(1) AS cnt "+
//            "FROM t_billing_invoice tbi "+
//            "LEFT JOIN t_visit ON t_visit.t_visit_id = tbi.t_visit_id AND t_visit.f_visit_status_id <> '4' AND tbi.billing_invoice_active = '1' "+
//            "LEFT JOIN t_visit_payment ON tbi.t_payment_id = t_visit_payment.t_visit_payment_id "+
//            "LEFT JOIN b_contract_plans ON t_visit_payment.b_contract_plans_id = b_contract_plans.b_contract_plans_id "+
//            "LEFT JOIN t_billing_invoice_item tbii ON tbi.t_billing_invoice_id = tbii.t_billing_invoice_id " +
//            "Where t_visit.f_visit_type_id = '"+f_visit_type_id+"' and tbi.close_day_id ='"+where+"' "+
//            "GROUP BY b_contract_plans.contract_plans_description, b_contract_plans.contract_plans_number) q1 "+
//            "GROUP BY q1.plans, q1.contract_plans_number";
    }else if(flag.equals("get_closeday_sum_adjust")) {
        sql="Select q1.plans as plans,sum(q1.paid) as paid,contract_plans_number, count(cnt) as cnt From "+
        "(SELECT CASE WHEN (f_patient_prefix.patient_prefix_description IS NOT NULL "+
        "AND f_patient_prefix.patient_prefix_description <> '' "+
        "AND f_patient_prefix.patient_prefix_description <> 'null' ) "+
        "THEN f_patient_prefix.patient_prefix_description ELSE '' END AS patient_prefix_description , "+
	"t_patient.patient_firstname, t_patient.patient_lastname, t_patient.patient_hn, t_visit.visit_vn, "+
	"t_visit.f_visit_type_id, b_contract_plans.contract_plans_description as plans,b_contract_plans.contract_plans_number, "+
//	"sum(t_billing_invoice.billing_invoice_payer_share) AS paid, count(1) as cnt, "+
                "sum(t_billing_invoice.billing_invoice_total) AS paid, count(1) as cnt, "+
	"t_billing_invoice_date_time, t_billing_invoice.t_billing_invoice_id, t_billing_invoice.t_billing_id,t_visit.t_patient_id " +
//                "min(b_contract_payer.contract_payer_number) as contract_payer_number "+
        "FROM t_billing_invoice "+
	"left JOIN t_visit  ON t_visit.t_visit_id = t_billing_invoice.t_visit_id "+
        "AND t_visit.f_visit_status_id <> '4' AND t_billing_invoice.billing_invoice_active = '1' " +
//        "AND (t_billing_invoice.billing_invoice_payer_share) > 0.00 " +
        "left JOIN t_visit_payment ON t_billing_invoice.t_payment_id = t_visit_payment.t_visit_payment_id " +
        "LEFT JOIN b_contract_plans ON t_visit_payment.b_contract_plans_id = b_contract_plans.b_contract_plans_id " +
        "left JOIN t_patient ON t_visit.t_patient_id = t_patient.t_patient_id " +
        "LEFT JOIN f_patient_prefix  " +
        "ON t_patient.f_patient_prefix_id = f_patient_prefix.f_patient_prefix_id " +
        "LEFT JOIN b_employee ON t_billing_invoice.billing_invoice_staff_record = b_employee.b_employee_id " +
        "LEFT JOIN b_service_point ON b_employee.b_service_point_id = b_service_point.b_service_point_id " +
//        "LEFT JOIN b_contract_payer ON b_contract_payer.b_contract_payer_id = b_contract_payer.b_contract_payer_id " +
        "WHERE t_visit.f_visit_type_id = '"+f_visit_type_id+"' and t_billing_invoice.close_day_id like '"+where+"%' " +
        "GROUP BY patient_prefix_description ,patient_firstname,patient_lastname,patient_hn,visit_vn,f_visit_type_id, " +
        "contract_plans_description,t_billing_invoice_date_time, t_billing_invoice.t_billing_invoice_id, " +
        "t_billing_invoice.t_billing_id,t_visit.t_patient_id,b_contract_plans.contract_plans_number) as q1 group by q1.plans,contract_plans_number";
    }else if(flag.equals("get_closeday_sum_minus")) {//get_closeday_sum_minus_adjust
        sql="SELECT q1.plans, sum(q1.paid) AS paid, q1.contract_plans_number, count(q1.cnt) AS cnt " +
            "FROM ( SELECT b_contract_plans.contract_plans_description AS plans, b_contract_plans.contract_plans_number,  " +
            "sum(tbii.billing_invoice_item_total) AS paid, count(1) AS cnt " +
            "FROM t_billing_invoice tbi " +
            "LEFT JOIN t_visit ON t_visit.t_visit_id = tbi.t_visit_id AND t_visit.f_visit_status_id <> '4' AND tbi.billing_invoice_active = '1' " +
            "LEFT JOIN t_visit_payment ON tbi.t_payment_id = t_visit_payment.t_visit_payment_id "+
            "LEFT JOIN b_contract_plans ON t_visit_payment.b_contract_plans_id = b_contract_plans.b_contract_plans_id " +
            "LEFT JOIN t_billing_invoice_item tbii ON tbi.t_billing_invoice_id = tbii.t_billing_invoice_id " +
            "left join b_item bi on tbii.b_item_id = bi.b_item_id " +
            "Where t_visit.f_visit_type_id = '"+f_visit_type_id+"' and tbi.close_day_id ='"+where+"' and " +
            "b_contract_plans.contract_plans_number = '"+where2+"' and bi.item_number in ('9','99','999') " +
            "GROUP BY b_contract_plans.contract_plans_description, b_contract_plans.contract_plans_number) q1 " +
            "GROUP BY q1.plans, q1.contract_plans_number";
    }else if(flag.equals("get_closeday_sum_minus_adjust")) {//get_closeday_sum_minus_adjust
        sql="SELECT q1.plans, sum(q1.paid) AS paid, q1.contract_plans_number, count(q1.cnt) AS cnt " +
            "FROM ( SELECT b_contract_plans.contract_plans_description AS plans, b_contract_plans.contract_plans_number,  " +
            "sum(tbii.billing_invoice_item_total) AS paid, count(1) AS cnt " +
            "FROM t_billing_invoice tbi " +
            "LEFT JOIN t_visit ON t_visit.t_visit_id = tbi.t_visit_id AND t_visit.f_visit_status_id <> '4' AND tbi.billing_invoice_active = '1' " +
            "LEFT JOIN t_visit_payment ON tbi.t_payment_id = t_visit_payment.t_visit_payment_id "+
            "LEFT JOIN b_contract_plans ON t_visit_payment.b_contract_plans_id = b_contract_plans.b_contract_plans_id " +
            "LEFT JOIN t_billing_invoice_item tbii ON tbi.t_billing_invoice_id = tbii.t_billing_invoice_id " +
            "left join b_item bi on tbii.b_item_id = bi.b_item_id " +
            "Where t_visit.f_visit_type_id = '"+f_visit_type_id+"' and tbi.close_day_id like '"+where+"%' and " +
            "b_contract_plans.contract_plans_number = '"+where2+"' and bi.item_number in ('9','99','999') " +
            "GROUP BY b_contract_plans.contract_plans_description, b_contract_plans.contract_plans_number) q1 " +
            "GROUP BY q1.plans, q1.contract_plans_number";
    }else if(flag.equals("get_closeday_sum_minus_muangsamut")) {
        sql="SELECT q1.plans, sum(q1.paid) AS paid, q1.contract_plans_number, count(q1.cnt) AS cnt " +
            "FROM ( SELECT b_contract_plans.contract_plans_description AS plans, b_contract_plans.contract_plans_number,  " +
            "sum(tbii.billing_invoice_item_total) AS paid, count(1) AS cnt " +
            "FROM t_billing_invoice tbi " +
            "LEFT JOIN t_visit ON t_visit.t_visit_id = tbi.t_visit_id AND t_visit.f_visit_status_id <> '4' AND tbi.billing_invoice_active = '1' " +
            "LEFT JOIN t_visit_payment ON tbi.t_payment_id = t_visit_payment.t_visit_payment_id "+
            "LEFT JOIN b_contract_plans ON t_visit_payment.b_contract_plans_id = b_contract_plans.b_contract_plans_id " +
            "LEFT JOIN t_billing_invoice_item tbii ON tbi.t_billing_invoice_id = tbii.t_billing_invoice_id " +
            "left join b_item bi on tbii.b_item_id = bi.b_item_id " +
            "Where t_visit.f_visit_type_id = '"+f_visit_type_id+"' and tbi.close_day_id ='"+where+"' and " +
            "b_contract_plans.contract_plans_number = '"+where2+"' and bi.item_number in ('9','99','999') " +
            "GROUP BY b_contract_plans.contract_plans_description, b_contract_plans.contract_plans_number) q1 " +
            "GROUP BY q1.plans, q1.contract_plans_number";
    }else if(flag.equals("set_closeday")) {
        sql="SELECT CASE WHEN (f_patient_prefix.patient_prefix_description IS NOT NULL "+
        "AND f_patient_prefix.patient_prefix_description <> '' "+
        "AND f_patient_prefix.patient_prefix_description <> 'null' ) "+
        "THEN f_patient_prefix.patient_prefix_description ELSE '' END AS patient_prefix_description , "+
	"t_patient.patient_firstname, t_patient.patient_lastname, t_patient.patient_hn, t_visit.visit_vn, "+
	"t_visit.f_visit_type_id, b_contract_plans.contract_plans_description as plans, "+
//	"sum(t_billing_invoice.billing_invoice_payer_share) AS paid,b_contract_plans.contract_plans_number, "+
        "sum(t_billing_invoice.billing_invoice_total) AS paid,b_contract_plans.contract_plans_number, "+
	"t_billing_invoice_date_time, t_billing_invoice.t_billing_invoice_id, t_billing_invoice.t_billing_id,t_visit.t_patient_id, count(1) as cnt "+
        "FROM t_billing_invoice "+
	"left JOIN t_visit  ON t_visit.t_visit_id = t_billing_invoice.t_visit_id "+
        "AND t_visit.f_visit_status_id <> '4' AND t_billing_invoice.billing_invoice_active = '1' " +
//        "AND (t_billing_invoice.billing_invoice_payer_share) > 0.00 " +
        "left JOIN t_visit_payment  ON t_billing_invoice.t_payment_id = t_visit_payment.t_visit_payment_id " +
        "LEFT JOIN b_contract_plans  ON t_visit_payment.b_contract_plans_id = b_contract_plans.b_contract_plans_id " +
        "left JOIN t_patient ON t_visit.t_patient_id = t_patient.t_patient_id " +
        "LEFT JOIN f_patient_prefix  " +
        "ON t_patient.f_patient_prefix_id = f_patient_prefix.f_patient_prefix_id " +
        "LEFT JOIN b_employee  ON t_billing_invoice.billing_invoice_staff_record = b_employee.b_employee_id " +
        "LEFT JOIN b_service_point  ON b_employee.b_service_point_id = b_service_point.b_service_point_id " +
        "WHERE t_visit.f_visit_type_id = '"+f_visit_type_id+"' and t_billing_invoice.close_day_id ='0' " +
        "GROUP BY patient_prefix_description ,patient_firstname,patient_lastname,patient_hn,visit_vn,f_visit_type_id, " +
        "contract_plans_description,t_billing_invoice_date_time, t_billing_invoice.t_billing_invoice_id, " +
        "t_billing_invoice.t_billing_id,t_visit.t_patient_id,b_contract_plans.contract_plans_number";
    }else if(flag.equals("set_closeday_adjust")) {
        sql="SELECT CASE WHEN (f_patient_prefix.patient_prefix_description IS NOT NULL "+
        "AND f_patient_prefix.patient_prefix_description <> '' "+
        "AND f_patient_prefix.patient_prefix_description <> 'null' ) "+
        "THEN f_patient_prefix.patient_prefix_description ELSE '' END AS patient_prefix_description , "+
	"t_patient.patient_firstname, t_patient.patient_lastname, t_patient.patient_hn, t_visit.visit_vn, "+
	"t_visit.f_visit_type_id, b_contract_plans.contract_plans_description as plans, "+
//	"sum(t_billing_invoice.billing_invoice_payer_share) AS paid,b_contract_plans.contract_plans_number, "+
        "sum(t_billing_invoice.billing_invoice_total) AS paid,b_contract_plans.contract_plans_number, "+
	"t_billing_invoice_date_time, t_billing_invoice.t_billing_invoice_id, t_billing_invoice.t_billing_id,t_visit.t_patient_id, count(1) as cnt "+
        "FROM t_billing_invoice "+
	"left JOIN t_visit  ON t_visit.t_visit_id = t_billing_invoice.t_visit_id "+
        "AND t_visit.f_visit_status_id <> '4' AND t_billing_invoice.billing_invoice_active = '1' " +
//        "AND (t_billing_invoice.billing_invoice_payer_share) > 0.00 " +
        "left JOIN t_visit_payment  ON t_billing_invoice.t_payment_id = t_visit_payment.t_visit_payment_id " +
        "LEFT JOIN b_contract_plans  ON t_visit_payment.b_contract_plans_id = b_contract_plans.b_contract_plans_id " +
        "left JOIN t_patient ON t_visit.t_patient_id = t_patient.t_patient_id " +
        "LEFT JOIN f_patient_prefix  " +
        "ON t_patient.f_patient_prefix_id = f_patient_prefix.f_patient_prefix_id " +
        "LEFT JOIN b_employee  ON t_billing_invoice.billing_invoice_staff_record = b_employee.b_employee_id " +
        "LEFT JOIN b_service_point  ON b_employee.b_service_point_id = b_service_point.b_service_point_id " +
        "WHERE t_visit.f_visit_type_id = '"+f_visit_type_id+"' and t_billing_invoice.close_day_id like '"+where+"%' " +
        "GROUP BY patient_prefix_description ,patient_firstname,patient_lastname,patient_hn,visit_vn,f_visit_type_id, " +
        "contract_plans_description,t_billing_invoice_date_time, t_billing_invoice.t_billing_invoice_id, " +
        "t_billing_invoice.t_billing_id,t_visit.t_patient_id,b_contract_plans.contract_plans_number";
    }else if(flag.equals("view_closeday")){
        sql="SELECT CASE WHEN (f_patient_prefix.patient_prefix_description IS NOT NULL "+
        "AND f_patient_prefix.patient_prefix_description <> '' "+
        "AND f_patient_prefix.patient_prefix_description <> 'null' ) "+
        "THEN f_patient_prefix.patient_prefix_description ELSE '' END AS patient_prefix_description , "+
	"t_patient.patient_firstname, t_patient.patient_lastname, t_patient.patient_hn, t_visit.visit_vn, "+
	"t_visit.f_visit_type_id, b_contract_plans.contract_plans_description as plans, "+
//	"sum(t_billing_invoice.billing_invoice_payer_share) AS paid,b_contract_plans.contract_plans_number, "+
        "sum(t_billing_invoice.billing_invoice_total) AS paid,b_contract_plans.contract_plans_number, "+
	"t_billing_invoice_date_time, t_billing_invoice.t_billing_invoice_id, t_billing_invoice.t_billing_id,t_visit.t_patient_id, count(1) as cnt "+
        "FROM t_billing_invoice "+
	"left JOIN t_visit  ON t_visit.t_visit_id = t_billing_invoice.t_visit_id "+
        "AND t_visit.f_visit_status_id <> '4' AND t_billing_invoice.billing_invoice_active = '1' " +
//        "AND (t_billing_invoice.billing_invoice_payer_share) > 0.00 " +
        "left JOIN t_visit_payment  ON t_billing_invoice.t_payment_id = t_visit_payment.t_visit_payment_id " +
        "LEFT JOIN b_contract_plans  ON t_visit_payment.b_contract_plans_id = b_contract_plans.b_contract_plans_id " +
        "left JOIN t_patient ON t_visit.t_patient_id = t_patient.t_patient_id " +
        "LEFT JOIN f_patient_prefix  " +
        "ON t_patient.f_patient_prefix_id = f_patient_prefix.f_patient_prefix_id " +
        "LEFT JOIN b_employee  ON t_billing_invoice.billing_invoice_staff_record = b_employee.b_employee_id " +
        "LEFT JOIN b_service_point  ON b_employee.b_service_point_id = b_service_point.b_service_point_id " +
        "WHERE t_visit.f_visit_type_id = '"+f_visit_type_id+"' and t_billing_invoice.close_day_id ='"+where+"' and b_contract_plans.contract_plans_number = '"+where2+"' " +
        "GROUP BY b_contract_plans.contract_plans_number,t_billing_invoice_date_time,patient_prefix_description ,patient_firstname,patient_lastname,patient_hn,visit_vn,f_visit_type_id, " +
        "contract_plans_description, t_billing_invoice.t_billing_invoice_id, " +
        "t_billing_invoice.t_billing_id,t_visit.t_patient_id "+
        "Order By b_contract_plans.contract_plans_number,t_billing_invoice_date_time";
    }else if(flag.equals("view_closeday_detail_muangsamut")){
        sql="SELECT CASE WHEN (f_patient_prefix.patient_prefix_description IS NOT NULL "+
        "AND f_patient_prefix.patient_prefix_description <> '' "+
        "AND f_patient_prefix.patient_prefix_description <> 'null' ) "+
        "THEN f_patient_prefix.patient_prefix_description ELSE '' END AS patient_prefix_description , "+
	"t_patient.patient_firstname, t_patient.patient_lastname, t_patient.patient_hn, t_visit.visit_vn, "+
	"t_visit.f_visit_type_id, b_contract_plans.contract_plans_description as plans, "+
//	"sum(t_billing_invoice.billing_invoice_payer_share) AS paid,b_contract_plans.contract_plans_number, "+
        "sum(t_billing_invoice.billing_invoice_total) AS paid,b_contract_plans.contract_plans_number, "+
	"min(visit_begin_visit_time) as visit_begin_visit_time, t_billing_invoice.t_billing_invoice_id, t_billing_invoice.t_billing_id,t_visit.t_patient_id, count(1) as cnt ,min(visit_financial_discharge_time) as visit_financial_discharge_time "+
        "FROM t_billing_invoice "+
	"left JOIN t_visit  ON t_visit.t_visit_id = t_billing_invoice.t_visit_id "+
        "AND t_visit.f_visit_status_id <> '4' AND t_billing_invoice.billing_invoice_active = '1' " +
//        "AND (t_billing_invoice.billing_invoice_payer_share) > 0.00 " +
        "left JOIN t_visit_payment  ON t_billing_invoice.t_payment_id = t_visit_payment.t_visit_payment_id " +
        "LEFT JOIN b_contract_plans  ON t_visit_payment.b_contract_plans_id = b_contract_plans.b_contract_plans_id " +
        "left JOIN t_patient ON t_visit.t_patient_id = t_patient.t_patient_id " +
        "LEFT JOIN f_patient_prefix  " +
        "ON t_patient.f_patient_prefix_id = f_patient_prefix.f_patient_prefix_id " +
        "LEFT JOIN b_employee  ON t_billing_invoice.billing_invoice_staff_record = b_employee.b_employee_id " +
        "LEFT JOIN b_service_point  ON b_employee.b_service_point_id = b_service_point.b_service_point_id " +
        "WHERE t_visit.f_visit_type_id = '"+f_visit_type_id+"' and t_billing_invoice.close_day_id ='"+where+"' and b_contract_plans.contract_plans_pttype = '"+where2+"' " +
        "GROUP BY b_contract_plans.contract_plans_number,patient_prefix_description ,patient_firstname,patient_lastname,patient_hn,visit_vn,f_visit_type_id, " +
        "contract_plans_description, t_billing_invoice.t_billing_invoice_id, " +
        "t_billing_invoice.t_billing_id,t_visit.t_patient_id "+
        "Order By visit_begin_visit_time";
    }else if(flag.equals("view_closeday_detail")){
        sql="SELECT CASE WHEN (f_patient_prefix.patient_prefix_description IS NOT NULL "+
        "AND f_patient_prefix.patient_prefix_description <> '' "+
        "AND f_patient_prefix.patient_prefix_description <> 'null' ) "+
        "THEN f_patient_prefix.patient_prefix_description ELSE '' END AS patient_prefix_description , "+
	"t_patient.patient_firstname, t_patient.patient_lastname, t_patient.patient_hn, t_visit.visit_vn, "+
	"t_visit.f_visit_type_id, b_contract_plans.contract_plans_description as plans, "+
//	"sum(t_billing_invoice.billing_invoice_payer_share) AS paid,b_contract_plans.contract_plans_number, "+
        "sum(t_billing_invoice.billing_invoice_total) AS paid,b_contract_plans.contract_plans_number, "+
	"min(visit_begin_visit_time) as visit_begin_visit_time, t_billing_invoice.t_billing_invoice_id, t_billing_invoice.t_billing_id,t_visit.t_patient_id, count(1) as cnt ,min(visit_financial_discharge_time) as visit_financial_discharge_time "+
        "FROM t_billing_invoice "+
	"left JOIN t_visit  ON t_visit.t_visit_id = t_billing_invoice.t_visit_id "+
        "AND t_visit.f_visit_status_id <> '4' AND t_billing_invoice.billing_invoice_active = '1' " +
//        "AND (t_billing_invoice.billing_invoice_payer_share) > 0.00 " +
        "left JOIN t_visit_payment  ON t_billing_invoice.t_payment_id = t_visit_payment.t_visit_payment_id " +
        "LEFT JOIN b_contract_plans  ON t_visit_payment.b_contract_plans_id = b_contract_plans.b_contract_plans_id " +
        "left JOIN t_patient ON t_visit.t_patient_id = t_patient.t_patient_id " +
        "LEFT JOIN f_patient_prefix  " +
        "ON t_patient.f_patient_prefix_id = f_patient_prefix.f_patient_prefix_id " +
        "LEFT JOIN b_employee  ON t_billing_invoice.billing_invoice_staff_record = b_employee.b_employee_id " +
        "LEFT JOIN b_service_point  ON b_employee.b_service_point_id = b_service_point.b_service_point_id " +
        "WHERE t_visit.f_visit_type_id = '"+f_visit_type_id+"' and t_billing_invoice.close_day_id ='"+where+"' and b_contract_plans.contract_plans_number = '"+where2+"' " +
        "GROUP BY b_contract_plans.contract_plans_number,patient_prefix_description ,patient_firstname,patient_lastname,patient_hn,visit_vn,f_visit_type_id, " +
        "contract_plans_description, t_billing_invoice.t_billing_invoice_id, " +
        "t_billing_invoice.t_billing_id,t_visit.t_patient_id "+
        "Order By visit_begin_visit_time";
    }else if(flag.equals("get_closeday_sum_muangsamut")) {
        if(!where2.equals("0")){
            staff_record_search = " and tbi.billing_invoice_staff_record = '"+where2+"' ";
        }
        sql="Select q1.plans as plans,sum(q1.paid) as paid, contract_plans_number, count(cnt) as cnt, sum(billing_deduct) as billing_deduct From "+
        "(SELECT "
//                + "CASE WHEN (f_patient_prefix.patient_prefix_description IS NOT NULL "+
//        "AND f_patient_prefix.patient_prefix_description <> '' "+
//        "AND f_patient_prefix.patient_prefix_description <> 'null' ) "+
//        "THEN f_patient_prefix.patient_prefix_description ELSE '' END AS patient_prefix_description , "+
//	"t_patient.patient_firstname, t_patient.patient_lastname, t_patient.patient_hn, t_visit.visit_vn, "+
//	"t_visit.f_visit_type_id, "
        + "case b_contract_plans.contract_plans_pttype "
        + "when 'A1' then 'A1' "        + "when 'A2' then 'A2' "        + "when 'A3' then 'A3' "
        + "when 'A4' then 'A4' "        + "when 'A5' then 'A5' "        + "when 'A6' then 'A6' "
        + "when 'A7' then 'ปกส.ปู่เจ้า' "   + "when 'A8' then 'ปกส.ปากน้ำ' " + "when 'A9' then 'A9' "
        + "when 'AA' then 'AA' "        + "when 'AB' then 'AB' "        + "when 'AC' then 'AC' "
        + "when 'AD' then 'AD' "        + "when 'AE' then 'AE' "        + "when 'AF' then 'AF' "
        + "when 'AG' then 'AG' "        + "when 'AH' then 'AH' "        + "when 'AI' then 'AI' "
        + "when 'AJ' then 'AJ' "        + "when 'AK' then 'AK' "        + "when 'AL' then 'AL' "
        + "when 'AM' then 'AM' "        + "when 'AN' then 'ผู้ป่วยทั่วไป' "  + "when 'AO' then 'AO' "
        + "when 'AP' then 'AP' "        + "when 'AQ' then 'AQ' "        + "when 'AR' then 'AR' "
        + "when 'AS' then 'AS' "        + "when 'AT' then 'AT' "        + "when 'AU' then 'AU' "
        + "when 'AV' then 'AV' "        + "when 'AW' then 'AW' "        + "when 'AX' then 'AX' "
        + "when 'AY' then 'AY' "        + "when 'AZ' then 'AZ' "        + "when 'UC' then 'UC' "
        + "when '99' then 'อื่นๆ' "       + "when 'FN' then 'กรม(กองทุน)' "+ "when 'CO' then 'สัญญาบริษัท' "
        + "when 'CR' then 'ประกันชีวิต' "  + "when 'PP' then 'ประกันภัย' "        + "when 'UC1' then 'มิตรไมตรีคลีนิกเวชกรรม' "
        + "when 'UC2' then 'พงค์แพทย์โพลีคลีนิกเวชกรรม1' "        + "when 'UC3' then 'โพลีคลีนิกมหาชนพระประแดง' "        + "when 'UC4' then 'พงค์แพทย์โพลีคลีนิกเวชกรรม2' "
        + "when 'UC5' then 'สถานพยาบาลเมืองสมุทรบางปู' "        + "when 'UC6' then 'UC6' "        + "when 'UC7' then 'มิตรไมตรีคลีนิกเวชกรรม(แบริ่ง)' "
        + "when 'UC8' then 'UC8' "        + "when 'UC91' then 'วัคซีนโครงการ UC' "        + "when 'UC92' then 'UC งานอนามัยโรงเรียน' "
        + "else contract_plans_pttype end as plans,"
        + "b_contract_plans.contract_plans_pttype as contract_plans_number, "+
//	"sum(t_billing_invoice.billing_invoice_payer_share) AS paid, count(1) as cnt, "+
                "sum(tbi.billing_invoice_total) AS paid, count(1) as cnt, "
//	"t_billing_invoice_date_time, tbi.t_billing_invoice_id, tbi.t_billing_id,t_visit.t_patient_id " +
//                "min(b_contract_payer.contract_payer_number) as contract_payer_number "+
                +" sum(tb.billing_deduct) as billing_deduct "
        +"FROM t_billing_invoice tbi "+
	"left JOIN t_visit  ON t_visit.t_visit_id = tbi.t_visit_id "+
        "AND t_visit.f_visit_status_id <> '4' AND tbi.billing_invoice_active = '1' " +
//        "AND (t_billing_invoice.billing_invoice_payer_share) > 0.00 " +
        "left JOIN t_visit_payment ON tbi.t_payment_id = t_visit_payment.t_visit_payment_id " +
        "LEFT JOIN b_contract_plans ON t_visit_payment.b_contract_plans_id = b_contract_plans.b_contract_plans_id " +
//        "left JOIN t_patient ON t_visit.t_patient_id = t_patient.t_patient_id " +
//        "LEFT JOIN f_patient_prefix  " +
//        "ON t_patient.f_patient_prefix_id = f_patient_prefix.f_patient_prefix_id " +
        "LEFT JOIN b_employee ON tbi.billing_invoice_staff_record = b_employee.b_employee_id " +
        "LEFT JOIN b_service_point ON b_employee.b_service_point_id = b_service_point.b_service_point_id " +
        "LEFT JOIN t_billing tb ON tb.t_billing_id = tbi.t_billing_id " +
        "WHERE t_visit.f_visit_type_id = '"+f_visit_type_id+"' and tbi.close_day_id ='"+where+"' " +staff_record_search+
        "GROUP BY "
//                + "patient_prefix_description ,patient_firstname,patient_lastname,patient_hn,visit_vn,f_visit_type_id, " +
        +"contract_plans_description,"
//        + "t_billing_invoice_date_time, tbi.t_billing_invoice_id, " +
        +"tbi.t_billing_id,t_visit.t_patient_id,b_contract_plans.contract_plans_pttype) as q1 group by q1.plans,contract_plans_number";
    }
    
//    Connection conn;
//    Statement st;
    try {
        cdi = new CashierTCloseDayInvoice();
//        conn = config1.getConnectionHospital(bracnhd_id);
//        st = conn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        while(rs.next()) {
            cdi = new CashierTCloseDayInvoice();
            cdi.setCloseDayId("");
            cdi.setCloseDayInvoiceId("");
            cdi.setCloseDayActive("1");
            //closeday_invoice.set(config1.StringNull(rs.getString("visit_vn")));
            if(flag.equals("group")) {
                cdi.setBillingInvoicePayerShare(Double.parseDouble(rs.getString("paid")));
                cdi.setContractPlansDescription(config1.StringNull(rs.getString("plans")));
            }else if(flag.equals("get_closeday_sum")){
                cdi.setBillingInvoicePayerShare(Double.parseDouble(rs.getString("paid")));
                cdi.setContractPlansDescription(config1.StringNull(rs.getString("plans")));
                cdi.setContractPlansNumber(config1.StringNull(rs.getString("contract_plans_number")));
                cdi.setCntCloseDayInvoice(Double.parseDouble(rs.getString("cnt")));
//                cdi.setDiscount(rs.getDouble("billing_deduct"));
            }else if(flag.equals("get_closeday_sum_muangsamut")){
                cdi.setBillingInvoicePayerShare(Double.parseDouble(rs.getString("paid")));
                cdi.setContractPlansDescription(config1.StringNull(rs.getString("plans")));
                cdi.setContractPlansNumber(config1.StringNull(rs.getString("contract_plans_number")));
                cdi.setCntCloseDayInvoice(Double.parseDouble(rs.getString("cnt")));
                cdi.setDiscount(rs.getDouble("billing_deduct"));
            }else if(flag.equals("get_closeday_sum_minus")){
                cdi.setBillingInvoicePayerShare(Double.parseDouble(rs.getString("paid")));
                cdi.setContractPlansDescription(config1.StringNull(rs.getString("plans")));
                cdi.setContractPlansNumber(config1.StringNull(rs.getString("contract_plans_number")));
                cdi.setCntCloseDayInvoice(Double.parseDouble(rs.getString("cnt")));
            }else if(flag.equals("view_closeday_detail_muangsamut")){
                cdi.setBillingInvoicePayerShare(Double.parseDouble(rs.getString("paid")));
                cdi.setContractPlansDescription(config1.StringNull(rs.getString("plans")));
    //            closeday_invoice.setTBillingId(config1.StringNull(rs.getString("t_billing_invoice_id")));
                cdi.setTBillingInvoiceId(config1.StringNull(rs.getString("t_billing_invoice_id")));
                cdi.setTBillingId(config1.StringNull(rs.getString("t_billing_id")));
//                cdi.setTBillInvoiceDateTime(config1.StringNull(rs.getString("t_billing_invoice_date_time")));
                cdi.setTPatientId(config1.StringNull(rs.getString("t_patient_id")));
                cdi.setContractPlansNumber(config1.StringNull(rs.getString("contract_plans_number")));
                cdi.setCntCloseDayInvoice(Double.parseDouble(rs.getString("cnt")));
                cdi.setPatientFullnamet(config1.StringNull(rs.getString("patient_prefix_description"))+" "+
                    config1.StringNull(rs.getString("patient_firstname"))+" "+config1.StringNull(rs.getString("patient_lastname")));
                cdi.setPatientHn(config1.StringNull(rs.getString("patient_hn")));
                cdi.setVisitVn(config1.StringNull(rs.getString("visit_vn")));
                cdi.setTBillInvoiceDateTime(rs.getString("visit_begin_visit_time"));
                cdi.setCloseDayActive(rs.getString("visit_financial_discharge_time"));
            }else if(flag.equals("view_closeday_detail")){
                cdi.setBillingInvoicePayerShare(Double.parseDouble(rs.getString("paid")));
                cdi.setContractPlansDescription(config1.StringNull(rs.getString("plans")));
    //            closeday_invoice.setTBillingId(config1.StringNull(rs.getString("t_billing_invoice_id")));
                cdi.setTBillingInvoiceId(config1.StringNull(rs.getString("t_billing_invoice_id")));
                cdi.setTBillingId(config1.StringNull(rs.getString("t_billing_id")));
//                cdi.setTBillInvoiceDateTime(config1.StringNull(rs.getString("t_billing_invoice_date_time")));
                cdi.setTPatientId(config1.StringNull(rs.getString("t_patient_id")));
                cdi.setContractPlansNumber(config1.StringNull(rs.getString("contract_plans_number")));
                cdi.setCntCloseDayInvoice(Double.parseDouble(rs.getString("cnt")));
                cdi.setPatientFullnamet(config1.StringNull(rs.getString("patient_prefix_description"))+" "+
                    config1.StringNull(rs.getString("patient_firstname"))+" "+config1.StringNull(rs.getString("patient_lastname")));
                cdi.setPatientHn(config1.StringNull(rs.getString("patient_hn")));
                cdi.setVisitVn(config1.StringNull(rs.getString("visit_vn")));
                cdi.setTBillInvoiceDateTime(rs.getString("visit_begin_visit_time"));
                cdi.setCloseDayActive(rs.getString("visit_financial_discharge_time"));
            }else if(flag.equals("get_closeday_sum_adjust")){
                cdi.setBillingInvoicePayerShare(Double.parseDouble(rs.getString("paid")));
                cdi.setContractPlansDescription(config1.StringNull(rs.getString("plans")));
                cdi.setContractPlansNumber(config1.StringNull(rs.getString("contract_plans_number")));
                cdi.setCntCloseDayInvoice(Double.parseDouble(rs.getString("cnt")));
            }else {
                cdi.setBillingInvoicePayerShare(Double.parseDouble(rs.getString("paid")));
                cdi.setContractPlansDescription(config1.StringNull(rs.getString("plans")));
    //            closeday_invoice.setTBillingId(config1.StringNull(rs.getString("t_billing_invoice_id")));
                cdi.setTBillingInvoiceId(config1.StringNull(rs.getString("t_billing_invoice_id")));
                cdi.setTBillingId(config1.StringNull(rs.getString("t_billing_id")));
                cdi.setTBillInvoiceDateTime(config1.StringNull(rs.getString("t_billing_invoice_date_time")));
                cdi.setTPatientId(config1.StringNull(rs.getString("t_patient_id")));
                cdi.setContractPlansNumber(config1.StringNull(rs.getString("contract_plans_number")));
                cdi.setCntCloseDayInvoice(Double.parseDouble(rs.getString("cnt")));
                cdi.setPatientFullnamet(config1.StringNull(rs.getString("patient_prefix_description"))+" "+
                        config1.StringNull(rs.getString("patient_firstname"))+" "+config1.StringNull(rs.getString("patient_lastname")));
                cdi.setPatientHn(config1.StringNull(rs.getString("patient_hn")));
                cdi.setVisitVn(config1.StringNull(rs.getString("visit_vn")));
                
            }
            v_closeday_invoice.add(cdi);
        }
        rs.close();
//        conn.close();
    } catch (Exception ex) {
        Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
//        max = ex.getMessage();
    }
    return v_closeday_invoice;
}
    public String setCloseDayImport(String branch_id, CashierTCloseDay item){
        /*
         * Step 1 select hospital os -> t_billing_invoice.closeday
         * Step 2 Insert closeday invoice
         * Step 3 Insert closeday
         * Step 4 Update hospital os -> t_billing_invoice.closeday = closeday_id
         */
        Connection connB, connH;
        Statement stB, stH;
        BBranch branch = new BBranch();
        String max="", flag="";
        Double discount=0.0;
        Vector v_closeday_invoice = new Vector();
        Vector v_closeday = new Vector();
        Vector v_closeday_minus = new Vector();
        CashierTCloseDayInvoice closeday_minus = new CashierTCloseDayInvoice();
        CashierTCloseDayDetail closeday_detail = new CashierTCloseDayDetail();
        CashierTCloseDayInvoice cdI1 = new CashierTCloseDayInvoice();
        try {
            connB = config1.getConnectionBangna();
            stB = connB.createStatement();
            connH = config1.getConnectionHospital(branch_id);
            stH = connH.createStatement();
            v_closeday_invoice = getCloseDayImport(stH,branch_id,"","","set_closeday",item.getFVisitTypeId());
//            closeday = new CashierTCloseDay();
//            closeday.setBranchId(branch_id);
//            closeday.setCloseDayDate(config1.DateFormatShow2DB(config1.getDate("ddMMyyyy"),"ddMMyyyy"));
            max = setSaveCashierTCloseDay(stB,branch_id, item);
            branch = config1.getBranch(branch_id);
            if(branch.getBranchNamet().indexOf("เมืองสมุทร")>=0){
                flag= "get_closeday_sum_muangsamut";
            }else{
                flag="get_closeday_sum";
            }
            for(int i=0;i<=v_closeday_invoice.size()-1;i++) {
                try {
                    cdi = (CashierTCloseDayInvoice)v_closeday_invoice.get(i);
                    cdi.setCloseDayId(max);
                    setSaveCashierTCloseDayInvoice(stB,branch_id, cdi);
                } catch (Exception ex) {
                    Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            v_closeday = getCloseDayImport(stH,branch_id, "0",item.getStatffRecordId(), flag,item.getFVisitTypeId());
            for(int i=0;i<=v_closeday.size()-1;i++) {
//                row++;
                cdI1 = (CashierTCloseDayInvoice)v_closeday.get(i);
                v_closeday_minus = getCloseDayImport(stH,branch_id, "0",cdI1.getContractPlansNumber(), "get_closeday_sum_minus",item.getFVisitTypeId());
                closeday_minus = new CashierTCloseDayInvoice();
                if(v_closeday_minus.size()>0){
                    closeday_minus = (CashierTCloseDayInvoice)v_closeday_minus.get(0);
                    discount=closeday_minus.getBillingInvoicePayerShare();
                }else{
                    discount=0.0;
                }
                closeday_detail.setAmount(cdI1.getBillingInvoicePayerShare()- discount);
                closeday_detail.setBContractPlansId(cdI1.getContractPlansNumber());
                closeday_detail.setCloseDayDetailId("");
                closeday_detail.setCloseDayId(max);
                closeday_detail.setContractPlansDescription(cdI1.getContractPlansDescription());
                closeday_detail.setDiscount(discount);
                closeday_detail.setNettotal(cdI1.getBillingInvoicePayerShare());
                closeday_detail.setRemark("");
                closeday_detail.setCntBContractPlan(cdI1.getCntCloseDayInvoice());
                setSaveCashierTCloseDayDetail(stB,branch_id,closeday_detail);
            }
            UpdateTBillingInvoiceCloseday(branch_id, max, item.getFVisitTypeId(),item.getStatffRecordId());
            connB.close();
            connH.close();
            setCloseDayTimeFinish(branch_id, max);
        } catch (Exception ex) {
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String setCloseDayImportAdjust(String branch_id, CashierTCloseDay item, String adjust){
        /*
         * Step 1 select hospital os -> t_billing_invoice.closeday
         * Step 2 Insert closeday invoice
         * Step 3 Insert closeday
         * Step 4 Update hospital os -> t_billing_invoice.closeday = closeday_id
         */
        Connection connB, connH;
        Statement stB, stH;
        BBranch branch = new BBranch();
        String max="", flag="";
        Double discount=0.0;
        Vector v_closeday_invoice = new Vector();
        Vector v_closeday = new Vector();
        Vector v_closeday_minus = new Vector();
        CashierTCloseDayInvoice closeday_minus = new CashierTCloseDayInvoice();
        CashierTCloseDayDetail closeday_detail = new CashierTCloseDayDetail();
        CashierTCloseDayInvoice cdI1 = new CashierTCloseDayInvoice();
        try {
            connB = config1.getConnectionBangna();
            stB = connB.createStatement();
            connH = config1.getConnectionHospital(branch_id);
            stH = connH.createStatement();
            v_closeday_invoice = getCloseDayImport(stH,branch_id,adjust,"","set_closeday_adjust",item.getFVisitTypeId());
//            closeday = new CashierTCloseDay();
//            closeday.setBranchId(branch_id);
//            closeday.setCloseDayDate(config1.DateFormatShow2DB(config1.getDate("ddMMyyyy"),"ddMMyyyy"));
            max = setSaveCashierTCloseDay(stB,branch_id, item);
            branch = config1.getBranch(branch_id);
            if(branch.getBranchNamet().indexOf("เมืองสมุทร")>=0){
                flag= "get_closeday_sum_muangsamut";
            }else{
                flag="get_closeday_sum";
            }
            for(int i=0;i<=v_closeday_invoice.size()-1;i++) {
                try {
                    cdi = (CashierTCloseDayInvoice)v_closeday_invoice.get(i);
                    cdi.setCloseDayId(max);
                    setSaveCashierTCloseDayInvoice(stB,branch_id, cdi);
                } catch (Exception ex) {
                    Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            v_closeday = getCloseDayImport(stH,branch_id, adjust,item.getStatffRecordId(), "get_closeday_sum_adjust",item.getFVisitTypeId());
            for(int i=0;i<=v_closeday.size()-1;i++) {
//                row++;
                cdI1 = (CashierTCloseDayInvoice)v_closeday.get(i);
                v_closeday_minus = getCloseDayImport(stH,branch_id, adjust,cdI1.getContractPlansNumber(), "get_closeday_sum_minus_adjust",item.getFVisitTypeId());
                closeday_minus = new CashierTCloseDayInvoice();
                if(v_closeday_minus.size()>0){
                    closeday_minus = (CashierTCloseDayInvoice)v_closeday_minus.get(0);
                    discount=closeday_minus.getBillingInvoicePayerShare();
                }else{
                    discount=0.0;
                }
                closeday_detail.setAmount(cdI1.getBillingInvoicePayerShare()- discount);
                closeday_detail.setBContractPlansId(cdI1.getContractPlansNumber());
                closeday_detail.setCloseDayDetailId("");
                closeday_detail.setCloseDayId(max);
                closeday_detail.setContractPlansDescription(cdI1.getContractPlansDescription());
                closeday_detail.setDiscount(discount);
                closeday_detail.setNettotal(cdI1.getBillingInvoicePayerShare());
                closeday_detail.setRemark("");
                closeday_detail.setCntBContractPlan(cdI1.getCntCloseDayInvoice());
                setSaveCashierTCloseDayDetail(stB,branch_id,closeday_detail);
            }
            UpdateTBillingInvoiceClosedayAdjust(branch_id, max, item.getFVisitTypeId(),item.getStatffRecordId(), adjust);
            connB.close();
            connH.close();
            setCloseDayTimeFinish(branch_id, max);
        } catch (Exception ex) {
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    private void UpdateTBillingInvoiceCloseday(String branch_id, String close_day_id, String f_visit_type_id, String staff_record_id){
        Connection conn;
        Statement st;
        String sql="", staff_record_search="";
        try {
            if(!staff_record_id.equals("")){
                staff_record_search = " and billing_invoice_staff_record = '"+staff_record_id+"' ";
            }
            cdi = new CashierTCloseDayInvoice();
            conn = config1.getConnectionHospital(branch_id);
            st = conn.createStatement();
            sql = "Update t_billing_invoice Set close_day_id = '"+close_day_id+"' Where close_day_id = '0' and " +
                "t_visit_id in (select t_visit_id from t_visit where f_visit_type_id = '"+f_visit_type_id+"') "
                + " and t_payment_id in (select tvp.t_visit_payment_id from t_visit_payment tvp where t_payment_id = tvp.t_visit_payment_id ) "
                +staff_record_search;
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
    //        max = ex.getMessage();
        }
    }
    private void UpdateTBillingInvoiceClosedayAdjust(String branch_id, String close_day_id, String f_visit_type_id, String staff_record_id, String adjust){
        Connection conn;
        Statement st;
        Integer chk=0;
        String sql="", staff_record_search="";
        try {
            if(!staff_record_id.equals("")){
                staff_record_search = " and billing_invoice_staff_record = '"+staff_record_id+"' ";
            }
            cdi = new CashierTCloseDayInvoice();
            conn = config1.getConnectionHospital(branch_id);
            st = conn.createStatement();
            sql = "Update t_billing_invoice Set close_day_id = '"+close_day_id+"' Where close_day_id like '"+adjust+"%' and " +
                "t_visit_id in (select t_visit_id from t_visit where f_visit_type_id = '"+f_visit_type_id+"') "
                + " and t_payment_id in (select tvp.t_visit_payment_id from t_visit_payment tvp where t_payment_id = tvp.t_visit_payment_id ) "
                +staff_record_search;
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
    //        max = ex.getMessage();
        }
    }
    public void getCloseDayDetail(String branch_id, String closeday_date, String flag){
        String sql="";
//        Connection conn;
//        Statement st;
        try{
//            conn = config1.getConnectionHospital(branch_id);
//            st = conn.createStatement();
            sql = "Select ";

        }catch (Exception ex) {
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
    //        max = ex.getMessage();
        }
    }
    public CashierTCloseDay getTrCloseDay(String branch_id,CashierTCloseDay closeday1, Integer row) {
        CashierTCloseDayInvoice cdi1 = new CashierTCloseDayInvoice();
        String text="", text_child="", node_parent="", node_child="", font_green="",text_child_invoice="",node_child_invoice="";
        String font_blue="",billing_invoice_date="",row_color="", date="", f_visit_type_namet="", sql="";
        StringBuilder textChild = new StringBuilder();
        StringBuilder textChildInv = new StringBuilder();
        Double total=0.0, cnt=0.0;
        Connection conn, connDay;
        Statement st, stDay;
        Vector v_contract_plans = new Vector();
        Vector v_invoice = new Vector();
//        Integer row=0;
//        DecimalFormat df = new DecimalFormat("#,##0.00");

        font_blue="<font color='blue'>";
        font_green="<font color='green'>";
        
        try {
            conn = config1.getConnectionHospital(branch_id);
            st = conn.createStatement();
            connDay = config1.getConnectionHospital(branch_id);
            stDay = connDay.createStatement();
            this.closeday = new CashierTCloseDay();
            v_contract_plans = getCloseDayImport(st,branch_id, closeday1.getCloseDayId(),"", "get_closeday_sum",closeday1.getFVisitTypeId());
            text_child="";
            node_parent="tr_"+closeday1.getCloseDayId();
            billing_invoice_date = config1.DateFormatDB2Show(closeday1.getCloseDayDate(), "ddMMyyyy");
            for(int j=0;j<=v_contract_plans.size()-1;j++) {
                //closeday_invoice = new CashierTCloseDayInvoice();
                if(closeday.getCloseDayId().equals("16700002")){
                    sql="";
                }
                cdi = (CashierTCloseDayInvoice)v_contract_plans.get(j);
                node_child=closeday1.getCloseDayId()+"_"+cdi.getContractPlansNumber()+"_"+j;
                textChild.append("<tr id='").append(node_child).append("' class ='child-of-").append(node_parent).append("'><td>&nbsp;&nbsp;&nbsp;</td>")
                        .append("<td colspan='3' >").append(font_green).append(cdi.getContractPlansDescription()).append(" [")
                        .append(cdi.getContractPlansNumber()).append("]</font></td>")
                        .append("<td colspan='2'>").append(font_green).append("จำนวนเงิน ").append(config1.NumberFormat(cdi.getBillingInvoicePayerShare()))
                        .append("</font></td>")
                        .append("<td>").append(font_green).append(" visit ").append(config1.IntegerFormat(cdi.getCntCloseDayInvoice())).append("</font></td></tr>");
                v_invoice = getCloseDayImport(stDay,branch_id, closeday1.getCloseDayId(),cdi.getContractPlansNumber(), "view_closeday",closeday1.getFVisitTypeId());
//                text_child_invoice="";
                textChildInv.delete(0, textChildInv.length());
                for(int k=0;k<=v_invoice.size()-1;k++) {
                    cdi1 = (CashierTCloseDayInvoice)v_invoice.get(k);
                    node_child_invoice=node_child+"_"+k;
                    textChildInv.append("<tr id ='").append(node_child_invoice).append("' class ='child-of-").append(node_child).append("'>")
                            .append("<td>&nbsp;&nbsp;&nbsp;</td>")
                            .append("<td>&nbsp;&nbsp;</td><td colspan='3'>").append(font_blue+"").append((k+1)).append(" ")
                            .append(cdi1.getPatientFullnamet()).append(" [").append(cdi1.getPatientHn()).append("]</font></td>")
                            .append("<td colspan='2'>").append(font_blue).append(" vn ").append(cdi1.getVisitVn()).append("</td>")
                            .append("<td colspan='2'>").append(font_blue).append(" จำนวนเงิน ").append(config1.NumberFormat(cdi1.getBillingInvoicePayerShare()) ).append("</font></td>")
                            .append("<td colspan='2'>").append(font_blue).append("").append(cdi1.getTBillInvoiceDateTime()).append("</font></td></tr>");
                    cnt++;
                    total +=cdi1.getBillingInvoicePayerShare();
                }
                textChild.append(textChildInv);
//                text_child+=text_child_invoice;
                
            }
            conn.close();
            connDay.close();

            //date_end = config1.DateFormatDB2Show(back_patient_import.getDateEnd(),"ddMMyyyy");
            //visit_date = config1.DateFormatDB2Show(patient_visit.getVisitDate(), "ddMMyyyy");
            //if(closeday_invoice.getSysStutasContact().equals("D")||closeday_invoice.getSysStutasContact().equals("Y")) {
            //    row_color="bgcolor='#FCF1F6'";
            //    }
            //else{
            //    row_color="";
            //   }
            if(closeday1.getFVisitTypeId().equals("0")) {
                f_visit_type_namet="การเงินนอก";
            }else if(closeday1.getFVisitTypeId().equals("1")) {
                f_visit_type_namet="การเงินใน";
            }else{
                f_visit_type_namet="";
            }
            closeday1.setAmtCloseDay(total);
            closeday1.setCntCloseDay(cnt);
            date = closeday1.getCloseDayDate().replace("-", "");
            String closedayID = "";
            if (closeday1.getCloseDayId().length()==8){
                closedayID = closeday1.getCloseDayId();
            }else {
                closedayID = closeday1.closeDayId.substring(3);
            }
            text += "<tr "+row_color+" id='"+node_parent+"'><td width='10' align='center'>"+row.toString()+"</td>"+
            "<td >"+billing_invoice_date+"</td>"+
            "<td >"+closeday1.getPeriodNamet()+"</td>"+
            "<td >"+f_visit_type_namet+"</td>"+
            "<td >"+config1.NumberFormat(closeday1.getAmtCloseDay())+"</td>"+
            "<td >"+config1.IntegerFormat(closeday1.getCntCloseDay())+"</td>"+
            "<td >"+closeday1.getOtherDescription1()+"</td>"+
            "<td >"+config1.NumberFormat(closeday1.getOtherAmt1())+"</td>"+
            "<td >"+closeday1.getOtherDescription2()+"</td>"+
            "<td >"+config1.NumberFormat(closeday1.getOtherAmt2())+"</td>"+
            "<td align='left'><A HREF='javascript:changesubmitprint("+closedayID +","+date+ ");' NAME='anchor' ID='anchor'>พิมพ์ข้อมูล<img src='images/printer-a.png' alt='' width='16' align='middle' height='16' border='0'></a></td>" +
            //"<td align='left'><A HREF='javascript:changesubmitcancel("+closeday1.getCloseDayId()+","+date+ ");' NAME='anchor_cancel' ID='anchor_cancel'>ยกเลิกปิดเวร<img src='images/cancel.png' alt='' width='16' align='middle' height='16' border='0'></a></td>" +
                    "</tr>" ;
            text+=textChild.toString();
            } catch (Exception ex) {
                text=ex.getMessage();
                Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        this.closeday.setBranchId(branch_id);
        this.closeday.setTextTr(text);
        this.closeday.setAmtCloseDay(total);
        this.closeday.setCntCloseDay(cnt);
        return this.closeday;
    }
    public CashierTCloseDay getTrCloseDayMuangsamut(String branch_id,CashierTCloseDay closeday1, Integer row) {
        CashierTCloseDayInvoice closeday_invoice1 = new CashierTCloseDayInvoice();
        String text="", text_child="", node_parent="", node_child="", font_green="",text_child_invoice="",node_child_invoice="";
        String font_blue="",billing_invoice_date="",row_color="", date="", f_visit_type_namet="", sql="";
        StringBuilder textChild = new StringBuilder();
        StringBuilder textChildInv = new StringBuilder();
        Double total=0.0, cnt=0.0;
        Connection conn, connDay;
        Statement st, stDay;
        Vector v_contract_plans = new Vector();
        Vector v_invoice = new Vector();
//        Integer row=0;
//        DecimalFormat df = new DecimalFormat("#,##0.00");
        font_blue="<font color='blue'>";
        font_green="<font color='green'>";
        try {
            conn = config1.getConnectionHospital(branch_id);
            st = conn.createStatement();
            connDay = config1.getConnectionHospital(branch_id);
            stDay = connDay.createStatement();
            this.closeday = new CashierTCloseDay();
            v_contract_plans = getCloseDayImport(st,branch_id, closeday1.getCloseDayId(),"", "get_closeday_sum",closeday1.getFVisitTypeId());
            text_child="";
            node_parent="tr_"+closeday1.getCloseDayId();
            billing_invoice_date = config1.DateFormatDB2Show(closeday1.getCloseDayDate(), "ddMMyyyy");
            for(int j=0;j<=v_contract_plans.size()-1;j++) {
                //closeday_invoice = new CashierTCloseDayInvoice();
                if(closeday.getCloseDayId().equals("16700002")){
                    sql="";
                }
                cdi = (CashierTCloseDayInvoice)v_contract_plans.get(j);
                node_child=closeday1.getCloseDayId()+"_"+cdi.getContractPlansNumber()+"_"+j;
                textChild.append("<tr id='").append(node_child).append("' class ='child-of-").append(node_parent).append("'><td>&nbsp;&nbsp;&nbsp;</td>")
                        .append("<td colspan='3' >").append(font_green).append(cdi.getContractPlansDescription()).append(" [")
                        .append(cdi.getContractPlansNumber()).append("]</font></td>")
                        .append("<td colspan='2'>").append(font_green).append("จำนวนเงิน ").append(config1.NumberFormat(cdi.getBillingInvoicePayerShare()))
                        .append("</font></td>")
                        .append("<td>").append(font_green).append(" visit ").append(config1.IntegerFormat(cdi.getCntCloseDayInvoice())).append("</font></td></tr>");
                v_invoice = getCloseDayImport(stDay,branch_id, closeday1.getCloseDayId(),cdi.getContractPlansNumber(), "view_closeday",closeday1.getFVisitTypeId());
//                text_child_invoice="";
                textChildInv.delete(0, textChildInv.length());
                for(int k=0;k<=v_invoice.size()-1;k++) {
                    closeday_invoice1 = (CashierTCloseDayInvoice)v_invoice.get(k);
                    node_child_invoice=node_child+"_"+k;
                    textChildInv.append("<tr id ='").append(node_child_invoice).append("' class ='child-of-").append(node_child).append("'><td>&nbsp;&nbsp;&nbsp;</td>")
                            .append("<td>&nbsp;&nbsp;</td><td colspan='3'>").append(font_blue+"").append((k+1)).append(" ")
                            .append(closeday_invoice1.getPatientFullnamet()).append(" ["+closeday_invoice1.getPatientHn()).append("]</font></td>")
                            .append("<td colspan='2'>").append(font_blue).append(" vn ").append(closeday_invoice1.getVisitVn()).append("</td>")
                            .append("<td colspan='2'>").append(font_blue).append(" จำนวนเงิน ")
                            .append(config1.NumberFormat(closeday_invoice1.getBillingInvoicePayerShare())).append("</font></td>")
                            .append("<td colspan='2'>").append(font_blue).append("").append(closeday_invoice1.getTBillInvoiceDateTime()).append("</font></td></tr>");
                    cnt++;
                    total +=closeday_invoice1.getBillingInvoicePayerShare();
                    }
                textChild.append(textChildInv);
            }
            conn.close();
            connDay.close();
            //date_end = config1.DateFormatDB2Show(back_patient_import.getDateEnd(),"ddMMyyyy");
            //visit_date = config1.DateFormatDB2Show(patient_visit.getVisitDate(), "ddMMyyyy");
            //if(closeday_invoice.getSysStutasContact().equals("D")||closeday_invoice.getSysStutasContact().equals("Y")) {
            //    row_color="bgcolor='#FCF1F6'";
            //    }
            //else{
            //    row_color="";
            //   }
            if(closeday1.getFVisitTypeId().equals("0")) {
                f_visit_type_namet="การเงินนอก";
            }else if(closeday1.getFVisitTypeId().equals("1")) {
                f_visit_type_namet="การเงินใน";
            }else{
                f_visit_type_namet="";
            }
            closeday1.setAmtCloseDay(total);
            closeday1.setCntCloseDay(cnt);
            date = closeday1.getCloseDayDate().replace("-", "");
            text += "<tr "+row_color+" id='"+node_parent+"'><td width='10' align='center'>"+row.toString()+"</td>"+
            "<td >"+billing_invoice_date+"</td>"+
            "<td >"+closeday1.getPeriodNamet()+"</td>"+
            "<td >"+f_visit_type_namet+"</td>"+
            "<td >"+closeday1.getStatffRecordName()+"</td>"+
            "<td >"+config1.NumberFormat(closeday1.getAmtCloseDay())+"</td>"+
            "<td >"+config1.IntegerFormat(closeday1.getCntCloseDay())+"</td>"+
            "<td >"+closeday1.getOtherDescription1()+"</td>"+
            "<td >"+config1.NumberFormat(closeday1.getOtherAmt1())+"</td>"+
            "<td >"+closeday1.getOtherDescription2()+"</td>"+
            "<td >"+config1.NumberFormat(closeday1.getOtherAmt2())+"</td>"+
            "<td align='left'><A HREF='javascript:changesubmitprint("+closeday1.getCloseDayId()+","+date+ ");' NAME='anchor' ID='anchor'>พิมพ์ข้อมูล<img src='images/printer-a.png' alt='' width='16' align='middle' height='16' border='0'></a></td>" +
            //"<td align='left'><A HREF='javascript:changesubmitcancel("+closeday1.getCloseDayId()+","+date+ ");' NAME='anchor_cancel' ID='anchor_cancel'>ยกเลิกปิดเวร<img src='images/cancel.png' alt='' width='16' align='middle' height='16' border='0'></a></td>" +
                    "</tr>" ;
            text+=textChild.toString();
            } catch (Exception ex) {
                text=ex.getMessage();
                Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        this.closeday.setBranchId(branch_id);
        this.closeday.setTextTr(text);
        this.closeday.setAmtCloseDay(total);
        this.closeday.setCntCloseDay(cnt);
        return this.closeday;
    }
    public String setUpdateCloseDayImport(String branch_id, String closeday_date){
        Integer chk=0;
        Connection conn = null;
        Statement st;
        String sql="";
        sql = "Update "+closeday.getCashierTCloseDay()+" Set "+closeday.getFStatusImport()+"='1' " +
                "Where "+closeday.getFCloseDayDate()+" = '"+closeday_date+"' and "+closeday.getFBranchId()+"='"+branch_id+"'";
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            chk = st.executeUpdate(sql);
        } catch (Exception ex) {
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String getTrCloseDayFront(String branch_id, String paidId, String fvtId){
        StringBuilder txt= new StringBuilder();
        String t_head="", link="",txtF="";
        Vector v_visit = new Vector();
        PatientVisit pv = new PatientVisit();
        BBranch branch = new BBranch();
        Integer i=0;
        Double total=0.0;
        try {
            branch = config1.getBranch(branch_id);
            if(branch.getBranchNamet().equals("เมืองสมุทรปู่เจ้า")){
                v_visit = getCloseDayImport(branch_id, "0",paidId, "view_closeday_detail_muangsamut",fvtId);
            }else{
                v_visit = getCloseDayImport(branch_id, "0",paidId, "view_closeday_detail",fvtId);
            }

            for(i=0;i<=v_visit.size()-1;i++){
                cdi = (CashierTCloseDayInvoice)v_visit.get(i);
                link = cdi.getPatientFullnamet();
                total += cdi.getBillingInvoicePayerShare();
                txt.append("<tr><td>").append(i+1).append("</td><td>").append(link).append("</td><td>")
                .append(cdi.getPatientHn()).append("</td><td>").append(cdi.getVisitVn()).append("</td><td>")
                .append(config1.DateFormatDB2Show(cdi.getTBillInvoiceDateTime(),"ddMMyyyy")).append(" ").append(cdi.getTBillInvoiceDateTime().substring(11)).append("</td><td>")
                .append(config1.DateFormatDB2Show(cdi.getCloseDayActive(),"ddMMyyyy")).append("</td><td>").append(cdi.getContractPlansDescription()).append("</td><td align='right'>")
                .append(config1.NumberFormat(cdi.getBillingInvoicePayerShare())).append("</td><td align='right'>").append(config1.NumberFormat(cdi.getDiscount())).append("</td><td align='right'>").append(config1.NumberFormat(cdi.getBillingInvoicePayerShare() - cdi.getDiscount())).append("</td></tr>");
            }
            txtF = "<tr> <td colspan='7' align='right'>รวม :</td><td align='right'>"+config1.NumberFormat(total)+"</td></tr>";
            t_head="<table class ='tablecolors' id='t_left'><tr><th>ลำดับ</th><th>ชื่อ-นามสกุล</th>"
                    + "<th>hn</th><th>vn</th><th>วันเข้า</th><th>วันออก</th><th>สิทธิ</th><th>ยอดรักษา</th>"
                    +"<th>ส่วนลด</th><th>ยอดสุทธิ</th>"
                    + "<input type='hidden' id='txt_row' value='"+i+"'></tr>";
        } catch (Exception ex) {
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
            txt.append(ex.getMessage());
        }
        return t_head+txt.toString()+txtF+"</table>";
    }
    public String getTrClosedayDate(String branchId, String closeDayDate){
        String txt = "", txtH="", closedayDate="";
        Vector vCloseDay = new Vector();
        vCloseDay = getCashierTCloseDay(branchId, "", closeDayDate,"day");
        for(int i=0;i<=vCloseDay.size()-1;i++){
            closeday = (CashierTCloseDay)vCloseDay.get(i);
            closedayDate = closeday.getCloseDayDate().replaceAll("-", "");
            if(config1.branch.getBranchNamet().equals("เมืองสมุทรปู่เจ้า")){
                txt += "<tr><td width='100' alipn='center'>"+closeday.getPeriodNamet()+"&nbsp;</td>"
                    + "<td align='right'>"+config1.NumberFormat(closeday.getAmtPatientVisit())+"</td>"
                    +"<td>"+closeday.getStatffRecordName()+"</td>"
                    + "<td><a href='javascript:changesubmitprint("+closeday.getCloseDayId().substring(3) +","+closedayDate+")'>พิมพ์ข้อมูล&nbsp;<img src='images/printer-a.png' alt='' width='16' align='middle' height='16' border='0'></a></td></tr>";
            }else{
                txt += "<tr>"
                        + "<td width='100'>"+closeday.getFVisitTypeNamet()+"&nbsp;</td>"
                        + "<td width='100' alipn='center'>"+closeday.getPeriodNamet()+"&nbsp;</td>"
                    + "<td align='right'>"+config1.NumberFormat(closeday.getAmtPatientVisit())+"</td>"
                    + "<td><a href='javascript:changesubmitprint("+closeday.getCloseDayId().substring(3)+","+closedayDate+")'>พิมพ์ข้อมูล&nbsp;<img src='images/printer-a.png' alt='' width='16' align='middle' height='16' border='0'></a></td></tr>";
            }
            
        }
        if(config1.branch.getBranchNamet().equals("เมืองสมุทรปู่เจ้า")){
            txtH = "<table><tr><th>รอบเวร</th><th align='right'>จำนวนเงิน</th><th></th><th></th></tr>";
        }else{
            txtH = "<table><tr><th>การเงิน</th><th>รอบเวร</th><th align='right'>จำนวนเงิน</th><th></th></tr>";
        }
        
        return txtH+txt+"</table>";
    }
    public String getCloseDayId(String close_day_date){
        String sql="", txt="", date="";
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            date =  String.valueOf(Integer.parseInt(close_day_date.substring(0, 4))-543)+ close_day_date.substring(4);
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select close_day_id "
                    +"From cashier_t_close_day "
                    +"Where close_day_date = '"+date+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                txt+="'"+rs.getString("close_day_id")+"',";
            }
            txt = txt.substring(0, txt.length()-1);
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return txt;
    }
    public String[] getCloseDayId(String branchId,String close_day_date){
        String sql="", date="", txt="";
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
//            date =  String.valueOf(Integer.parseInt(close_day_date.substring(0, 4))-543)+ close_day_date.substring(4);
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select close_day_id "
                    +"From cashier_t_close_day "
                    +"Where close_day_date = '"+close_day_date+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                txt+=rs.getString("close_day_id")+",";
            }
            txt = txt.substring(0, txt.length()-1);
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] txt1 = txt.split(",");
        return txt1;
    }
    public String setCloseDayTimeFinish(String brnachId, String closeDayId){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        String timeFinish=config1.getDateDBHospital("yyyyMMdd hh:mm:ss");
        
        sql.append("Update ").append(dbObj.table).append(" Set ").append(dbObj.timeFinish).append("='").append(timeFinish).append("' ")
            .append("Where ").append(dbObj.pk_field).append("='").append(closeDayId).append("' ");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(CashierTCloseDayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
}
