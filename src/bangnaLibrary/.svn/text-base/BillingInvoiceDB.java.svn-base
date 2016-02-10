/*
 * BillingInvoiceDB.java
 *
 * Created on 10 มิถุนายน 2547, 16:48 น.
 */
package bangnaLibrary;
import java.util.*;
import java.sql.*;
/**
 *
 * @author  tong
 */
public class BillingInvoiceDB{

    private Config1 config1 = new Config1();
    /** Creates a new instance of BillingInvoiceDB */
    public BillingInvoice tbi;
    final private String idtable = "122";
    public BillingInvoiceDB() {
        tbi = new BillingInvoice();
        initConfig();
    }
    public boolean initConfig(){

        tbi.table="t_billing_invoice";
        tbi.pk_field="t_billing_invoice_id";
        tbi.patient_id   ="t_patient_id";
        tbi.visit_id   ="t_visit_id";
        tbi.invoice_no   ="billing_invoice_number";
        tbi.invoice_date   ="t_billing_invoice_date_time";
        tbi.payer_share   ="billing_invoice_payer_share";
        tbi.patient_share   ="billing_invoice_patient_share";
        tbi.payer_share_ceil   ="billing_invoice_payer_share_ceil";
        tbi.patient_share_ceil   ="billing_invoice_patient_share_ceil";
        tbi.total   ="billing_invoice_total";
        tbi.deposit   ="billing_invoice_deposit";
        tbi.payment_id   ="t_payment_id";
        tbi.active   ="billing_invoice_active";
        tbi.billing_invoice_no   ="billing_invoice_quantity";
        tbi.billing_id   ="t_billing_id";
        tbi.billing_complete ="billing_invoice_complete";
        tbi.staff_billing_invoice = "billing_invoice_staff_record";

        return true;
    }
    public static void updateField(BillingInvoice obj) {
//        obj.payer_share = (obj.payer_share);
//        obj.patient_share = Constant.getSDouble(obj.patient_share);
//        obj.total = Constant.getSDouble(obj.total);
    }

    /**
     * @param cmd
     * @param o
     * @return int
     * @roseuid 3F6574DE0394
     */
//    public int insert(BillingInvoice p) throws Exception{
//        updateField(p);
//        p.generateOID(idtable);
//        String sql="insert into " + dbObj.table + " ("
//        + dbObj.pk_field
//        + " ,"	+ dbObj.patient_id
//        + " ,"	+ dbObj.visit_id
//        + " ,"	+ dbObj.invoice_no
//        + " ,"	+ dbObj.invoice_date
//        + " ,"	+ dbObj.payer_share
//        + " ,"	+ dbObj.patient_share
//        + " ,"	+ dbObj.payer_share_ceil
//        + " ,"	+ dbObj.patient_share_ceil
//        + " ,"	+ dbObj.total
//        + " ,"	+ dbObj.deposit
//        + " ,"	+ dbObj.payment_id
//        + " ,"	+ dbObj.active
//        + " ,"	+ dbObj.billing_invoice_no
//        + " ,"	+ dbObj.billing_id
//        + " ,"	+ dbObj.staff_billing_invoice
//        + " ,"	+ dbObj.billing_complete
//        + " ) values ('"
//        + p.getObjectId()
//        + "','" + p.patient_id
//        + "','" + p.visit_id
//        + "','" + p.invoice_no
//        + "','" +  p.invoice_date
//        + "'," +  p.payer_share        //ดูดีดีนะว่ามันเป็น double  by  henbe
//        + "," +  p.patient_share        //ดูดีดีนะว่ามันเป็น double  by  henbe
//        + ",'" +  p.payer_share_ceil
//        + "','" +  p.patient_share_ceil
//        + "'," +  p.total        //ดูดีดีนะว่ามันเป็น double  by  henbe
//        + ",'" +  p.deposit
//        + "','" +  p.payment_id
//        + "','" + p.active
//        + "','" + p.billing_invoice_no
//        + "','" + p.billing_id
//        + "','" + p.staff_billing_invoice
//        + "','" + p.billing_complete
//        + "')";
//
////        sql = Gutil.convertSQLToMySQL(sql,theConnectionInf.gettypeDatabase());
////        return theConnectionInf.eUpdate(sql);
//    }
//    public int update(BillingInvoice p) throws Exception{
//        updateField(p);
//        String sql="update " + dbObj.table + " set ";
//        String field =""
//        + "', " +  dbObj.patient_id + "='" + p.patient_id
//        + "', " +  dbObj.visit_id + "='" + p.visit_id
//        + "', " +  dbObj.invoice_no + "='" + p.invoice_no
//        + "', " +  dbObj.invoice_date + "='" + p.invoice_date
//        + "', " +  dbObj.payer_share + "=" + p.payer_share        //ดูดีดีนะว่ามันเป็น double  by  henbe
//        + ", " +  dbObj.patient_share + "=" + p.patient_share        //ดูดีดีนะว่ามันเป็น double  by  henbe
//        + ", " +  dbObj.payer_share_ceil + "='" + p.payer_share_ceil
//        + "', " +  dbObj.patient_share_ceil + "='" + p.patient_share_ceil
//        + "', " +  dbObj.total + "=" + p.total        //ดูดีดีนะว่ามันเป็น double  by  henbe
//        + ", " +  dbObj.deposit + "='" + p.deposit
//        + "', " +  dbObj.payment_id + "='" + p.payment_id
//        + "', " +  dbObj.active + "='" + p.active
//        + "', " +  dbObj.billing_invoice_no + "='" + p.billing_invoice_no
//        + "', " +  dbObj.billing_id + "='" + p.billing_id
//        + "', " +  dbObj.staff_billing_invoice + "='" + p.staff_billing_invoice
//        + "', " +  dbObj. billing_complete + "='" + p.billing_complete
//        + "' where " + dbObj.pk_field + "='" + p.getObjectId() +"'";
//
//        sql = Gutil.convertSQLToMySQL(sql+field.substring(2),theConnectionInf.gettypeDatabase());
//        return theConnectionInf.eUpdate(sql);
//    }

//    public int delete(BillingInvoice o) throws Exception {
//        String sql="delete from " + dbObj.table
//        + " where " + dbObj.pk_field + "='" + o.getObjectId() +"'";
//        return theConnectionInf.eUpdate(sql);
//    }

    public BillingInvoice selectByPK(String branch_id,String pk) throws Exception {
        String sql="select * from " + tbi.table
        + " where " + tbi.pk_field
        + " = '" + pk + "'" ;

        Vector v=eQuery(branch_id,sql);
        if(v.size()==0)
            return null;
        else
            return (BillingInvoice)v.get(0);
    }

    public Vector selectAll(String branch_id) throws Exception {
        String sql="select * from " + tbi.table;

        Vector v=eQuery(branch_id,sql);
        if(v.size()==0)
            return null;
        else
            return v;
    }

    public Vector selectByPatientId(String branch_id,String pk) throws Exception{
        String sql="select * from " + tbi.table
        + " where " + tbi.patient_id
        + " = '" + pk + "' and " + tbi.active + " = '1' order by " + tbi.invoice_date  + " desc"  ;

        Vector v=eQuery(branch_id,sql);
        if(v.size()==0)
            return null;
        else
            return v;
    }

    public Vector selectByVisitId(String branch_id,String pk) throws Exception {
        String sql="select * from " + tbi.table
        + " where " + tbi.visit_id
        + " = '" + pk + "' and " + tbi.active + " = '1' order by " + tbi.invoice_date + " desc" ;
                /*amp: เพราะมันเป็น string เมื่อ หลักไม่เท่ากัน มันจะ orderby ไม่ถูก dbObj.billing_invoice_no*/
        return eQuery(branch_id,sql);
    }
    public Vector selectByVisitVn(String branch_id,String pk) throws Exception {
        String sql="select bi.* "
                + "from " + tbi.table +" as bi "
                + "left join t_visit tv on bi.t_visit_id = tv.t_visit_id "
                + " where bi." + tbi.visit_id +"  "+ " = '" + pk + "' and bi." + tbi.active + " = '1' "
                + "order by bi." + tbi.invoice_date + " desc" ;
                /*amp: เพราะมันเป็น string เมื่อ หลักไม่เท่ากัน มันจะ orderby ไม่ถูก dbObj.billing_invoice_no*/
        return eQuery(branch_id,sql);
    }
    public Vector listBillingInvoiceByPaymenyID(String branch_id,String visit_id,String payment_id) throws Exception {
        initConfig();
        String sql="select * from " + tbi.table
        + " where " + tbi.visit_id + " = '" + visit_id + "'"
        + " and " + tbi.payment_id + " = '" +  payment_id + "'"
        + " order by " + tbi.billing_invoice_no + " desc" ;
        return eQuery(branch_id,sql);
    }
    public Vector listBillingInvoiceByVisitIdBillingID(String branch_id,String visit_id,String billing_id) throws Exception{
        String sql="select * from " + tbi.table
        + " where " + tbi.visit_id + " = '" + visit_id + "'"
        + " and " + tbi.billing_id + " = '" +  billing_id + "'"
        + " order by " + tbi.billing_invoice_no + " desc" ;

        Vector v=eQuery(branch_id,sql);
        if(v.size()==0)
            return null;
        else
            return v;
    }

    public Vector selectByVisitIdBillingIDNULL(String branch_id,String pk) throws Exception {
        String sql="select * from " + tbi.table
        + " where " + tbi.visit_id + " = '" + pk
        + "' and " + tbi.active + " = '1' "
        + " and " + tbi.billing_id + " = '' "
        + " order by " + tbi.billing_invoice_no + " desc" ;

        Vector v=eQuery(branch_id,sql);
        if(v.size()==0)
            return null;
        else
            return v;
    }
    //หาใบแจ้งหนี้ที่ยังไม่ได้คำนวนค่าใช้จ่ายที คือที่ยังไม่เรียบร้อย
//    public int countBillingInvoiceNotCompleteByVisitID(String visit_id) throws Exception{
//        String sql ="select count("+ dbObj.billing_complete +") from " + dbObj.table + " " +
//        " where " + dbObj.visit_id + "= '"+ visit_id + "'" +
//        " and " + dbObj.active + "='" + Active.isEnable()+ "'" +
//        " and " + dbObj.billing_complete + "= '" +Active.isDisable() + "'";
//
//        ResultSet rs = theConnectionInf.eQuery(sql);
//
//        int i =0;
//        while(rs.next()) {
//            i = rs.getInt(1);
//        }
//        sql = null;
//        rs.close();
//        rs = null;
//        return i;
//    }

    public Vector eQuery(String branch_id,String sql) throws Exception {
        BillingInvoice p;
        Vector list = new Vector();
        Connection conn;
        Statement st;
        conn = config1.getConnectionHospital(branch_id);
        st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) {
            p = new BillingInvoice();
            p.setObjectId(rs.getString(tbi.pk_field));
            p.patient_id = rs.getString(tbi.patient_id);
            p.visit_id = rs.getString(tbi.visit_id);
            p.invoice_no = rs.getString(tbi.invoice_no);
            p.invoice_date = rs.getString(tbi.invoice_date);
            p.payer_share= rs.getString(tbi.payer_share);
            p.patient_share= rs.getString(tbi.patient_share);
            p.payer_share_ceil = rs.getString(tbi.payer_share_ceil);
            p.patient_share_ceil = rs.getString(tbi.patient_share_ceil);
            p.total = rs.getString(tbi.total);
            p.deposit = rs.getString(tbi.deposit);
            p.payment_id = rs.getString(tbi.payment_id);
            p.active = rs.getString(tbi.active);
            p.billing_invoice_no = rs.getString(tbi.billing_invoice_no);
            p.staff_billing_invoice = rs.getString(tbi.staff_billing_invoice);
            p.billing_id = rs.getString(tbi.billing_id);
            p.billing_complete = rs.getString(tbi.billing_complete);
            list.add(p);
        }
        rs.close();
        conn.close();
        return list;
    }

    /*build 7*/
//    public void checkField()throws Exception {
//        String sql = "";
//         try{
//             sql = "SELECT " + dbObj.staff_billing_invoice + " from " + dbObj.table;
//             this.theConnectionInf.getConnection().createStatement().executeQuery(sql);
//         } catch(Exception ex) {
//             sql = "Alter table " + dbObj.table + " ADD " + dbObj.staff_billing_invoice + " varchar (255)";
//             this.theConnectionInf.eUpdate(sql);
//
//         }
//    }
}
