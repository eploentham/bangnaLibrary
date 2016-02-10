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
public class BackTPatientVisitContactBillingTemp extends Persistent{
    public String billingInvoiceNumber="", bpvCId="", bpvCbId="",remark="";
    public Double amount=0.0, discountTax=0.0, discountPayment=0.0, receiveOver=0.0, receivePayment=0.0;

    public BackTPatientVisitContactBillingTemp() {
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

    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof BackTPatientVisitContactBillingTemp)) {
//            return false;
//        }
//        BackTPatientVisitContactBillingTemp other = (BackTPatientVisitContactBillingTemp) object;
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "bangnaLibrary.BackTPatientVisitContactBillingTemp[backTPatientVisitContactBillingTempPK=" + billingInvoiceNumber + "]";
//    }

}
