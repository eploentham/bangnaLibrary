/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangna.objdb;

import com.bangna.object.BItem;
import bangnaLibrary.Config1;
import bangnaLibrary.VTBillingInvoiceSubgroup;
import com.bangna.object.CashierTBillingInvoicePrint;
import com.bangna.object.CashierTBillingInvoicePrintDetail;
//import com.bangna.usecase.connection.ConnectionInf;

/**
 *
 * @author root
 */
public class CashierTBillingInvoicePrintDB {
//    public ConnectionInf theConnectionInf;
    Config1 config1;
    public CashierTBillingInvoicePrint dbObj ;
    final private String idTable = "169";
//    public CashierTBillingInvoicePrintDetail ctbIpD = new CashierTBillingInvoicePrintDetail();
//    public CashierTBillingReceivePrint ctbRp = new CashierTBillingReceivePrint();
//    public CashierTBillingReceivePrintDetail ctbRpD = new CashierTBillingReceivePrintDetail();
    VTBillingInvoiceSubgroup vvb_is = new VTBillingInvoiceSubgroup();
    BItem b_item = new BItem();
    public CashierTBillingInvoicePrintDB(Config1 cf){
        config1 = cf;
        dbObj = new CashierTBillingInvoicePrint();
        initConfig();
    }
    public void initConfig() {
        dbObj.tBillingInvoicePrintId="t_billing_invoice_print_id";
        dbObj.tBillingInvoiceId="t_billing_invoice_id";
        dbObj.tVisitHn="t_visit_hn";
        dbObj.pk_field="t_billing_invoice_print_id";
        dbObj.table="cashier_t_billing_invoice_print";
        
        dbObj.tVisitId="t_visit_id";
        dbObj.patientFullnamet="patient_fullnamet";
        dbObj.patientAge="patient_age";
        dbObj.patientPid="patient_pid";
        dbObj.patientAddress="patient_address";
        
        dbObj.tBillingInvoicePrintActive="t_billing_invoice_print_active";
        dbObj.visitTypeDescription="visit_type_description";
        dbObj.tBillingInvoicePrintDate="t_billing_invoice_print_date";
        dbObj.billingInvoiceNo="billing_invoice_no";
        dbObj.billingInvoiceDate="billing_invoice_date";
        
        dbObj.patientCompanyName="patient_company_name";
        dbObj.injuryNo="injury_no";
        dbObj.sickness="sickness";
        dbObj.visitDate="visit_date";
        dbObj.visitTime="visit_time";
        
        dbObj.dischargeDate="discharge_date";
        dbObj.dischargeTime="discharge_time";
        dbObj.amount="amount";
        dbObj.discount="discount";
        dbObj.nettotal="nettotal";
        
        dbObj.invoiceNumber="invoice_number";
        dbObj.tVisitVn = "t_visit_vn";
    }
//    public int insert(CashierTBillingInvoicePrint d) throws Exception {
//        String sql="";
//        CashierTBillingInvoicePrint p = d;
//        if(p.getObjectId()==null) p.generateOID(idTable);
//        sql ="Insert Into "+dbObj.table+"("+dbObj.pk_field+","+dbObj.deductId+","
//                +dbObj.description+","+dbObj.method+") "
//                + "Values('"+p.getObjectId()+"','"+p.deductId+"','"
//                +p.description+"','"+p.method+"')";
//        sql = Gutil.convertSQLToMySQL(sql,theConnectionInf.gettypeDatabase());
//        return theConnectionInf.eUpdate(sql);
//    }
    
}
