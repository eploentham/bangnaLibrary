/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bangna.objdb;

import com.bangna.object.SLog;
import com.bangna.usecase.connection.ConnectionInf;
import com.bangna.utility.Gutil;
import java.util.*;
import java.sql.*;

public class SLogDB
{
    public ConnectionInf theConnectionInf;
    public SLog dbObj;
    final public String idtable = "";

    /**
     * @param ConnectionInf db
     * @roseuid 3F65897F0326
     */
    public SLogDB(ConnectionInf db)
    {
        theConnectionInf = db;
        dbObj = new SLog();
        initConfig();
    }
    public boolean initConfig()
    {
        dbObj.table = "s_log";
        dbObj.pk_field = "s_log_id";
        dbObj.log_data = "log_data";
        dbObj.log_header = "log_header";
        dbObj.log_number = "log_number";
        dbObj.log_record_date_time = "log_record_date_time";
        dbObj.log_staff_recoed = "log_staff_recoed";
        dbObj.log_ip = "log_ip";
        dbObj.log_mac = "log_mac";
        dbObj.desscription = "description";
        return true;
    }

    public int insert(SLog p) throws Exception
    {
        String sql="";
        p.generateOID(this.idtable);
        sql="insert into " + dbObj.table + " ("
        + dbObj.pk_field
        + " ,"	+ dbObj.log_data
        + " ,"  + dbObj.log_header
        + " ,"  + dbObj.log_number
        + " ,"  + dbObj.log_record_date_time
        + " ,"  + dbObj.log_staff_recoed
        + " ,"  + dbObj.log_ip
        + " ,"  + dbObj.log_mac
        + " ,"  + dbObj.desscription
        + " ) values ('"
        + p.getObjectId()
        + "','" + p.log_data
        + "','" + p.log_header
        + "','" + p.log_number
        + "','" + p.log_record_date_time
        + "','" + p.log_staff_recoed
        + "','" + p.log_ip
        + "','" + p.log_mac
        + "','" + p.desscription
        + "')";
        sql = Gutil.convertSQLToMySQL(sql,theConnectionInf.gettypeDatabase());
        System.err.println("theConnectionInf.getURL() "+theConnectionInf.getURL());
        return theConnectionInf.eUpdate(sql);
    }
    public int update(SLog o) throws Exception
    {
        String sql="update " + dbObj.table + " set ";
        String field =""
        + "', "	+ dbObj.log_data  + "='" + o.log_data
        + "', "	+ dbObj.log_header  + "='" + o.log_header
        + "', "	+ dbObj.log_number  + "='" + o.log_number
        + "', "	+ dbObj.log_record_date_time  + "='" + o.log_record_date_time
        + "', "	+ dbObj.log_staff_recoed  + "='" + o.log_staff_recoed
        + "', "	+ dbObj.log_ip  + "='" + o.log_ip
        + "', "	+ dbObj.log_mac  + "='" + o.log_mac
        + "', "	+ dbObj.desscription  + "='" + o.desscription
        + "' where " + dbObj.pk_field + "='" + o.getObjectId() +"'";
        sql = Gutil.convertSQLToMySQL(sql+field.substring(2),theConnectionInf.gettypeDatabase());
        return theConnectionInf.eUpdate(sql);
    }
    public int delete(SLog of) throws Exception
    {
        String sql ="delete from " + dbObj.table
        + " where " + dbObj.pk_field
        + " = '" + of.getObjectId() + "'";
        return theConnectionInf.eUpdate(sql);
    }
    public Vector selectAll() throws Exception
    {
    	String sql ="select * from " + dbObj.table;
        return eQuery(sql);
    }

    public SLog selectByID(String id) throws Exception
    {
    	String sql ="select * from " + dbObj.table
        + " where " + dbObj.pk_field + " = '" + id + "'";
        Vector v = eQuery(sql);
        if(v.isEmpty()) return null;
        else return (SLog)v.get(0);
    }

    public Vector eQuery(String sql) throws Exception
    {
        SLog p;
        Vector list = new Vector();
        ResultSet rs = theConnectionInf.eQuery(sql);
        while(rs.next())
        {
            p = new SLog();
            p.setObjectId(rs.getString(dbObj.pk_field));
            p.log_data = rs.getString(dbObj.log_data);
            p.log_header = rs.getString(dbObj.log_header);
            p.log_number = rs.getString(dbObj.log_number);
            p.log_record_date_time = rs.getString(dbObj.log_record_date_time);
            p.log_staff_recoed = rs.getString(dbObj.log_staff_recoed);
            p.log_ip = rs.getString(dbObj.log_ip);
            p.log_mac = rs.getString(dbObj.log_mac);
            p.desscription = rs.getString(dbObj.desscription);
            list.add(p);
        }
        rs.close();
        return list;
    }
}