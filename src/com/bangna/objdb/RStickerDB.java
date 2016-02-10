/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangna.objdb;

import bangnaLibrary.Config1;
import com.bangna.object.RSticker;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class RStickerDB {
    public Config1 config1;
    public RSticker dbObj;
    final private String idtable = "207";
    public RStickerDB(Config1 cf){
        config1 = cf;
        dbObj = new RSticker();
        initConfig();
    }
    public void initConfig() {
        dbObj.stickerId="sticker_id";
        dbObj.stickerNo="sticker_no";
        dbObj.stickerName="sticker_name";
        dbObj.visitHn="visit_hn";
        dbObj.visitVn="visit_vn";
        dbObj.visitAge="visit_age";
        dbObj.visitWardName="visit_ward_name";
        dbObj.contractPlansDescription="contract_plans_description";
        dbObj.visitBed="visit_bed";
        dbObj.sort1="sort1";
        dbObj.pk_field="sticker_id";
        dbObj.table = "r_sticker";
    }
    public void insert(Statement st,RSticker p){
        StringBuilder sql = new StringBuilder();
        p.generateOID(idtable);
        sql.append("Insert Into ").append(dbObj.table).append("(").append(dbObj.pk_field).append(",").append(dbObj.stickerNo).append(",")
            .append(dbObj.stickerName).append(",").append(dbObj.sort1).append(",")
            .append(dbObj.visitAge).append(",").append(dbObj.visitHn).append(",")
            .append(dbObj.visitVn).append(",").append(dbObj.visitWardName).append(",")
            .append(dbObj.contractPlansDescription).append(",").append(dbObj.visitBed).append(")")
            .append("Values ('").append(p.getObjectId()).append("','").append(p.stickerNo).append("','")
            .append(p.stickerName).append("',").append(p.sort1).append(",'")
            .append(p.visitAge).append("','").append(p.visitHn).append("','")
            .append(p.visitVn).append("','").append(p.visitWardName).append("','")
            .append(p.contractPlansDescription).append("','").append(p.visitBed).append("')");
//        Connection conn;
        try {
//            conn = config1.getConnectionBangna();
//            Statement st = conn.createStatement();
            st.executeUpdate(sql.toString());
        } catch (Exception ex) {
            Logger.getLogger(RStickerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insert(RSticker p){
        StringBuilder sql = new StringBuilder();
        p.generateOID(idtable);
        sql.append("Insert Into ").append(dbObj.table).append("(").append(dbObj.pk_field).append(",").append(dbObj.stickerNo).append(",")
            .append(dbObj.stickerName).append(",").append(dbObj.sort1).append(",")
            .append(dbObj.visitAge).append(",").append(dbObj.visitHn).append(",")
            .append(dbObj.visitVn).append(",").append(dbObj.visitWardName).append(",")
            .append(dbObj.contractPlansDescription).append(",").append(dbObj.visitBed).append(")")
            .append("Values ('").append(p.getObjectId()).append("','").append(p.stickerNo).append("','")
            .append(p.stickerName).append("',").append(p.sort1).append(",'")
            .append(p.visitAge).append("','").append(p.visitHn).append("','")
            .append(p.visitVn).append("','").append(p.visitWardName).append("','")
            .append(p.contractPlansDescription).append("','").append(p.visitBed).append("')");
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            st.executeUpdate(sql.toString());
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(RStickerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(){
        StringBuilder sql = new StringBuilder();
        sql.append("Delete From ").append(dbObj.table);
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            st.executeUpdate(sql.toString());
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(RStickerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
