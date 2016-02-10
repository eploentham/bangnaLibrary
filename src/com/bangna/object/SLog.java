/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangna.object;

import com.bangna.usecase.connection.Persistent;

/**
 *
 * @author LionHeart
 */
public class SLog extends Persistent{
    String init = "";
    public static String INSERT = "INSERT";
    public static String UPDATE = "UPDATE";
    public static String DELETE = "DELETE";
    /**
     * log สำหรับตาราง b_drub_set_group
     */
    public static String DRUG_SET_GROUP = "log01";
    /**
     * log สำหรับตาราง b_drub_set
     */
    public static String DRUG_SET = "log02";
    /**
     * log สำหรับตาราง t_visit_primary_symptom
     */
    public static String VISIT_PRIMARY_SYMPTOM = "log03";
    public static String VISIT_Billing = "log04";
    public String log_number = init;
    public String log_staff_recoed = init;
    public String log_header = init;
    public String log_data = init;
    public String log_record_date_time = init;
    public String log_ip = init;
    public String log_mac = init;
    public String desscription = init;
    public SLog()
    {
        
    }
    public SLog(String logNumber,String logStaffRecoed,String logHeader
            ,String logData,String logRecordDateTime,String ip,String mac,String des)
    {
        log_number = logNumber;
        log_staff_recoed = logStaffRecoed;
        log_header = logHeader;
        log_data = logData;
        log_record_date_time = logRecordDateTime;
        log_ip = ip;
        log_mac = mac;
        desscription = des;
    }
}
