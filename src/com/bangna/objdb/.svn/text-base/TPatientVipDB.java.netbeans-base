/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangna.objdb;

import bangnaLibrary.Config1;
import com.bangna.object.TPatientVip;
import com.bangna.usecase.connection.ConnectionInf;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author root
 */
public class TPatientVipDB {
    Config1 config1;
    //TPatientVip pVip ;
    public TPatientVip dbObj = new TPatientVip();
    public ConnectionInf theConnectionInf;
    final private String idtable = "210";
    public TPatientVipDB(){
        config1 = new Config1();
    }
    public TPatientVipDB(Config1 cf){
        config1 = cf;
    }
    public void initConfig(Config1 cf){
        dbObj = new TPatientVip();
    }
    public TPatientVip getConfig(){
        dbObj.pateintVipId="patient_vip_id";
        dbObj.patientVipActive="patient_vip_active";
        dbObj.patientVipFirstName="patient_vip_first_name";
        dbObj.patientVipHn="patietn_vip_hn";
        dbObj.patientVipLastName="patient_vip_last_name";
        dbObj.patientVipMessage="patient_vip_message";
        dbObj.remark="remark";
        dbObj.table="marketing_t_patient_vip";
        dbObj.pk_field="patient_vip_id";
        return dbObj;
    }
    public int insert(TPatientVip p) throws Exception{
        StringBuilder sql = new StringBuilder();
        p.generateOID(idtable);
        sql.append("Insert Into (").append(dbObj.pk_field).append(",").append(dbObj.patientVipFirstName).append(",").append(dbObj.patientVipLastName).append(",")
                .append(dbObj.patientVipHn).append(",").append(dbObj.patientVipMessage).append(",").append(dbObj.remark).append(",")
                .append(dbObj.patientVipActive).append(") ")
                .append("Values ('").append(p.pateintVipId).append("','").append(p.patientVipFirstName).append("','").append(p.patientVipLastName).append("','")
                .append(p.patientVipHn).append("','").append(p.patientVipMessage).append("','").append(p.remark).append("','")
                .append(p.patientVipActive).append(")");
        return theConnectionInf.eUpdate(sql.toString());
    }
    public Vector selectByPk(String pk)throws Exception{
        Vector v = new Vector();
        StringBuilder sql = new StringBuilder();
        sql.append("Select * From ").append(dbObj.table).append(" Where ").append(dbObj.pk_field).append(" = '").append(pk).append("'");
        v = eQuery(sql.toString());
        return v;
    }
    public Vector eQuery(String sql)throws Exception{
        Vector list = new Vector();
        TPatientVip p = new TPatientVip();
        ResultSet rs = theConnectionInf.eQuery(sql);
        while(rs.next()){
            p = new TPatientVip();
            p.patientVipActive = rs.getString(dbObj.patientVipActive);
            p.setObjectId(rs.getString(dbObj.pk_field));
            p.pateintVipId = rs.getString(dbObj.pateintVipId);
            p.patientVipFirstName  = rs.getString(dbObj.patientVipFirstName);
            p.patientVipHn = rs.getString(dbObj.patientVipHn);
            p.patientVipLastName = rs.getString(dbObj.patientVipLastName);
            p.patientVipMessage = rs.getString(dbObj.patientVipMessage);
            p.remark = rs.getString(dbObj.remark);
            list.add(p);
        }
        rs.close();
        return list;
    }
    
}
