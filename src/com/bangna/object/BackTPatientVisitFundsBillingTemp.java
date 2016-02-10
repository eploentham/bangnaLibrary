/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bangna.object;

import com.bangna.usecase.connection.Persistent;

/**
 *
 * @author root
 */
public class BackTPatientVisitFundsBillingTemp extends Persistent{
    public String billingInvoiceNumber="", bpv_f_id="";
    public Double amount=0.0;

    public BackTPatientVisitFundsBillingTemp() {
    }
    public void initial(){
        billingInvoiceNumber="";
        amount=0.0;
    }

    public String getBillingInvoiceNumber() {
        return billingInvoiceNumber;
    }
    public void setBillingInvoiceNumber(String billingInvoiceNumber) {
        this.billingInvoiceNumber = billingInvoiceNumber;
    }

    public String getBpvFId() {
        return bpv_f_id;
    }
    public void setBpvFId(String bpv_f_id) {
        this.bpv_f_id = bpv_f_id;
    }

    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
