/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangna.control;

import bangnaLibrary.BContactDB;
import bangnaLibrary.Config1;

/**
 *
 * @author root
 */
public class ContactControl {
    Config1 config1;
    BContactDB contactdb;
    public ContactControl(){
        config1 = new Config1();
    }
    public ContactControl(Config1 cf){
        config1 = cf;
    }
    private void initConfig(Config1 cf){
        contactdb = new BContactDB(cf);
    }
}
