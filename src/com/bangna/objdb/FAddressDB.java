/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangna.objdb;

import bangnaLibrary.Config1;
import bangnaLibrary.FAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class FAddressDB {
    Config1 config1;
    FAddress address = new FAddress();
    public FAddressDB(){
        config1 = new Config1();
        initConfig(config1);
    }
    public FAddressDB(Config1 cf){
        config1 = cf;
        initConfig(cf);
    }
    public void initConfig(Config1 cf){
        address = new FAddress();
        
    }
    public Vector getAddress(String whereChangwat, String whereAmphur, String whereTambon,String flag) {
        Vector v_address = new Vector();
        String time="";
        String sql="", searchWhere="", searchWhereChangwat="", searchWhereTambon="";
        
        if(flag.equals("1")){//changwat
            if(!whereChangwat.equals("")){
                searchWhere=" and changwat."+address.getFAddressDescription() +" like '"+whereChangwat+"%' ";
            }
            sql="Select changwat.* "+
                "From "+address.getFAddress()+" as changwat "
                    + "" +
                "Where changwat."+address.getFAddressTambonType()+"='"+flag+"' " +searchWhere+" Order By changwat."+address.getFAddressDescription();
        }else if(flag.equals("2")){//amphur
            if(!whereAmphur.equals("")){
                searchWhere=" and amphur."+address.getFAddressDescription() +" like '"+whereAmphur+"%' ";
            }
            if(!whereChangwat.equals("")){
                searchWhereChangwat=" and changwat."+address.getFAddressDescription() +" like '"+whereChangwat+"%' ";
            }
            sql="Select amphur.* "+
                "From "+address.getFAddress()+" as changwat "
                + "Left Join " +address.getFAddress()+" as amphur on changwat."+address.getFFAddressId()+" = amphur."+address.getFAddressChangwatId()+" "
                +"Where amphur."+address.getFAddressTambonType()+"='"+flag+"' " +searchWhere+searchWhereChangwat
                    +" Order By amphur."+address.getFAddressDescription();
        }else if(flag.equals("3")){//tambon
            if(!whereAmphur.equals("")){
                searchWhere=" and amphur."+address.getFAddressDescription() +" like '"+whereAmphur+"%' ";
            }
            if(!whereChangwat.equals("")){
                searchWhereChangwat=" and changwat."+address.getFAddressDescription() +" like '"+whereChangwat+"%' ";
            }
            if(!whereTambon.equals("")){
                searchWhereTambon=" and tambon."+address.getFAddressDescription() +" like '"+whereTambon+"%' ";
            }
            sql="Select tambon.* "+
                "From "+address.getFAddress()+" as changwat "
                + "Left Join " +address.getFAddress()+" as amphur on changwat."+address.getFFAddressId()+" = amphur."+address.getFAddressChangwatId()+" "
                + "Left Join "+address.getFAddress()+" as tambon on amphur."+address.getFFAddressId()+" = tambon."+address.getFAddressAmphurId()+" "
                +"Where tambon."+address.getFAddressTambonType()+"='"+flag+"' " +searchWhere+searchWhereChangwat+searchWhereTambon
                    +" Order By tambon."+address.getFAddressDescription();
        }
        
        Connection connbangna;
        Statement stmainhis;
        ResultSet rsmainhis;
        try {
            connbangna = config1.getConnectionBangna();
            stmainhis = connbangna.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                address = new FAddress();
                if(flag.equals("1")){
                    address.setAddressChangwatId(rsmainhis.getString(address.getFAddressChangwatId()));
                }else if(flag.equals("2")){
                    address.setAddressChangwatId(rsmainhis.getString(address.getFAddressAmphurId()));
                }else if(flag.equals("3")){
                    address.setAddressChangwatId(rsmainhis.getString(address.getFFAddressId()));
                }
                address.setAddressDescription(rsmainhis.getString(address.getFAddressDescription()));
                v_address.add(address);
            }
            rsmainhis.close();
            connbangna.close();
        }catch (Exception ex) {
            Logger.getLogger(FAddressDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_address;
    }
    public List getAddressL(String whereChangwat, String whereAmphur, String whereTambon,String flag) {
        List lAddress = new ArrayList<FAddress>();
        String time="";
        String sql="", searchWhere="", searchWhereChangwat="", searchWhereTambon="";
        
        if(flag.equals("1")){//changwat
            if(!whereChangwat.equals("")){
                searchWhere=" and changwat."+address.getFAddressDescription() +" like '"+whereChangwat+"%' ";
            }
            sql="Select changwat.* "+
                "From "+address.getFAddress()+" as changwat "
                    + "" +
                "Where changwat."+address.getFAddressTambonType()+"='"+flag+"' " +searchWhere+" Order By changwat."+address.getFAddressDescription();
        }else if(flag.equals("2")){//amphur
            if(!whereAmphur.equals("")){
                searchWhere=" and amphur."+address.getFAddressDescription() +" like '"+whereAmphur+"%' ";
            }
            if(!whereChangwat.equals("")){
                searchWhereChangwat=" and changwat."+address.getFAddressDescription() +" like '"+whereChangwat+"%' ";
            }
            sql="Select amphur.* "+
                "From "+address.getFAddress()+" as changwat "
                + "Left Join " +address.getFAddress()+" as amphur on changwat."+address.getFFAddressId()+" = amphur."+address.getFAddressChangwatId()+" "
                +"Where amphur."+address.getFAddressTambonType()+"='"+flag+"' " +searchWhere+searchWhereChangwat
                    +" Order By amphur."+address.getFAddressDescription();
        }else if(flag.equals("3")){//tambon
            if(!whereAmphur.equals("")){
                searchWhere=" and amphur."+address.getFAddressDescription() +" like '"+whereAmphur+"%' ";
            }
            if(!whereChangwat.equals("")){
                searchWhereChangwat=" and changwat."+address.getFAddressDescription() +" like '"+whereChangwat+"%' ";
            }
            if(!whereTambon.equals("")){
                searchWhereTambon=" and tambon."+address.getFAddressDescription() +" like '"+whereTambon+"%' ";
            }
            sql="Select tambon.* "+
                "From "+address.getFAddress()+" as changwat "
                + "Left Join " +address.getFAddress()+" as amphur on changwat."+address.getFFAddressId()+" = amphur."+address.getFAddressChangwatId()+" "
                + "Left Join "+address.getFAddress()+" as tambon on amphur."+address.getFFAddressId()+" = tambon."+address.getFAddressAmphurId()+" "
                +"Where tambon."+address.getFAddressTambonType()+"='"+flag+"' " +searchWhere+searchWhereChangwat+searchWhereTambon
                    +" Order By tambon."+address.getFAddressDescription();
        }
        
        Connection connbangna;
        Statement stmainhis;
        ResultSet rsmainhis;
        try {
            connbangna = config1.getConnectionBangna();
            stmainhis = connbangna.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                address = new FAddress();
                if(flag.equals("1")){
                    address.setAddressChangwatId(rsmainhis.getString(address.getFAddressChangwatId()));
                    address.fAddressId = rsmainhis.getString(address.getFAddressChangwatId());
                }else if(flag.equals("2")){
                    address.setAddressChangwatId(rsmainhis.getString(address.getFAddressAmphurId()));
                    address.fAddressId = rsmainhis.getString(address.getFAddressAmphurId());
                }else if(flag.equals("3")){
                    address.setAddressChangwatId(rsmainhis.getString(address.getFFAddressId()));
                    address.fAddressId = rsmainhis.getString(address.getFFAddressId());
                }
                address.setAddressDescription(rsmainhis.getString(address.getFAddressDescription()));
                lAddress.add(address);
            }
            rsmainhis.close();
            connbangna.close();
        }catch (Exception ex) {
            Logger.getLogger(FAddressDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lAddress;
    }
}
