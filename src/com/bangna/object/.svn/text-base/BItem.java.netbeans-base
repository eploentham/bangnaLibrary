/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangna.object;

import com.bangna.usecase.connection.CommonInf;
import com.bangna.usecase.connection.Persistent;

/**
 *
 * @author root
 */
public class BItem extends Persistent implements CommonInf {
    public String bItemId="";
    public String itemNamet="", itemNumber="", itemCommonName="",itemTradeName="", itemStatusDoctor="",itemDescriptione="", itemNickname="";
    public String itemActive="";
    public Double itemPriceCost=0.0;
    public Double itemPriceSale=0.0;
    public String itemIdOld="";

    public BItem() {
    }
    public void initial(){
        bItemId="";
        itemNamet=""; itemNumber=""; itemCommonName="";itemTradeName=""; itemStatusDoctor="";itemDescriptione="";itemNickname="";
        itemActive="";
        itemPriceCost=0.0;
        itemPriceSale=0.0;
        itemIdOld="";
    }
    public String getCode() {
       return getObjectId();
    }
   
    public String getName() {
        return itemCommonName;
    }
    public String toString(){
        return itemNumber;
    }
}
