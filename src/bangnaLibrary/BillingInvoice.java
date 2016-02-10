/*
 * BillingInvoice.java
 *
 * Created on 10 ????น 2547, 16:14 ?.
 */
package bangnaLibrary;
import com.bangna.usecase.connection.Persistent;
import java.util.Vector;
/**
 *
 * @author  tong
 */
public class BillingInvoice extends Persistent{

    /** Creates a new instance of BillingInvoice */
    /**
     *@deprecated
     */
    public String billing_invoice_id;

    public String patient_id;
    public String visit_id;
    public String invoice_no;
    public String invoice_date;
    public String payer_share;
    public String patient_share;
    public String payer_share_ceil;
    public String patient_share_ceil;
    public String total;
    public String deposit;
    public String payment_id;
    public String active = "1";
    public String billing_invoice_no = "1";
    public String billing_id ="";
    public String billing_complete = "0"; /*1 : ?????d??????? 0 ??*/
    public String staff_billing_invoice;
    public BillingInvoice() {
    }

    public boolean isActive() {
        return active.equals("1");
    }

    public boolean isBillingComplete() {
        return billing_complete.equals("1");
    }

//    public static BillingInvoice initFromBoiV(Vector vboi) {


//        BillingInvoice bi = new BillingInvoice();
//        double patientprice = 0.00;
//        double payerprice = 0.00;
//        double patientprice_ceil =  0.00;
//        double payerprice_ceil =  0.00;
//        for(int j=0;j<vboi.size();j++) {
//            BillingOrderItem boi = (BillingOrderItem)vboi.get(j);
//            patientprice = patientprice + Double.parseDouble(boi.patientshare);
//            payerprice =  payerprice + Double.parseDouble(boi.payershare);
//            patientprice_ceil = patientprice_ceil + Math.ceil(Double.parseDouble(boi.patientshare));
//            payerprice_ceil =  payerprice_ceil + Math.ceil(Double.parseDouble(boi.payershare));
//        }
//        BillingOrderItem boi = (BillingOrderItem)vboi.get(0);
//        bi.patient_id = boi.patient_id;
//        bi.visit_id = boi.visit_id;
//        bi.invoice_no = "";
//        bi.payer_share = Constant.dicimal(String.valueOf(payerprice));
//        bi.patient_share = Constant.dicimal(String.valueOf(patientprice));
//        bi.payer_share_ceil = Constant.dicimal(String.valueOf(payerprice_ceil));
//        bi.patient_share_ceil = Constant.dicimal(String.valueOf(patientprice_ceil));
//        bi.total = Constant.dicimal(String.valueOf(payerprice + patientprice)) ;
//        bi.deposit = "";
//        bi.payment_id = boi.payment_id;
//        bi.active = Active.isEnable();
//        bi.billing_invoice_no = "1";
//        return bi;
//    }
}
