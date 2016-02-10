/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangna.control;

import bangnaLibrary.Config1;

/**
 *
 * @author root
 */
public class BangnaControl {
    public Config1 config1;
    public BillingControl billingC;
    public BangnaControl(){
        config1 = new Config1();
        billingC = new BillingControl(config1);
    }
}
