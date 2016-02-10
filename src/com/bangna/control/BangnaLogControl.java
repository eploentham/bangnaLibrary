/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangna.control;

import bangnaLibrary.Config1;
import com.bangna.objdb.SLogDB;
import com.bangna.object.SLog;
import com.bangna.usecase.connection.ConnectionDBMgr;
import com.bangna.usecase.connection.ConnectionInf;
import java.sql.ResultSet;

/**
 *
 * @author LionHeart
 */
public class BangnaLogControl {
    public ConnectionInf theInf;
    public Config1 theConfig;
    public SLogDB theSLogDB;
    public BangnaLogControl()
    {
        if(theConfig==null)
            theConfig = new Config1();
        if(theInf == null)
            theInf = new ConnectionDBMgr("org.postgresql.Driver",theConfig.branch.getLogDatabaseUrl()
                , theConfig.branch.getLogDatabaseUser(),theConfig.branch.logDatabasePassword,"0"); 
        if(theSLogDB == null)
            theSLogDB = new SLogDB(theInf);
    }
    public BangnaLogControl(Config1 cf){
        theConfig = cf;
//        theConfig.branch = cf.branch;
        
        String url = theConfig.branch.logDatabaseUrl;
        String  user = theConfig.branch.logDatabaseUser;
        String pass = theConfig.branch.logDatabasePassword;
        if(theInf == null)
            theInf = new ConnectionDBMgr("org.postgresql.Driver",url, user,pass,"0"); 
        try
        {
//            ResultSet rs = theInf.eQuery("select count(*) from s_log");
//            if(rs.next())
//                System.out.println(rs.getString("count"));
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        if(theSLogDB == null)
            theSLogDB = new SLogDB(theInf);
    }
    /**
     * ใช้สำหรับ Hos
     */
    public BangnaLogControl(String driver,String url,String user,String pass,String id)
    {
        if(theInf == null)
            theInf = new ConnectionDBMgr(driver,url
                ,user,pass,id); 
        if(theSLogDB == null)
            theSLogDB = new SLogDB(theInf);
    }
    /**
     * บันทึก log ข้อมูลไหนไม่ต้องการบันทึก ก็ให้ใส่ค่าว่างไป
     * log_number,
       log_staff_recoed,
       log_header,
       log_data,
       log_record_date_time,
       log_ip,
       log_mac,
       description
     */
    public void saveLog(String log_number,String staff_reccord,String header
            ,String data,String record_date_time,String ip,String mac,String des)
    {
        try
        {
            theInf.open();
            SLog log = new SLog(log_number,staff_reccord
                ,header,data,record_date_time
                ,ip,mac,des);
            theSLogDB.insert(log);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            theInf.close();
        }
    }
    public static void main(String[] args)
    {
        BangnaLogControl theBLC = new BangnaLogControl();
        theBLC.saveLog("", "", "", "", "", "", "", "this is test3");
    }
}
