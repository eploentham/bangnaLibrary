package bangnaLibrary;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TVisitVitalSignDB{
  Config1 config1 = new Config1();
  public TVisitVitalSign tvvs = new TVisitVitalSign();

  public TVisitVitalSign getTVisitVitalSignByPK(String brach_id, String where, String t_visit_id, String flag) {
    String sql = "";
    try {
      Connection conn = config1.getConnectionHospital(brach_id);
      Statement stbangna = conn.createStatement();

      if (flag.equals("visit_vn")) {
        sql = "Select * From " + tvvs.getTVisitVitalSign() + " " + "Where " + tvvs.getFTVisitId() + "='" + t_visit_id + "'";
      }else{
        sql = "Select * From " + tvvs.getTVisitVitalSign() + " " + "Where " + tvvs.getFTVisitVitalSignId() + "='" + t_visit_id + "'";
      }

      ResultSet rs = stbangna.executeQuery(sql);
      while (rs.next()) {
        tvvs = new TVisitVitalSign();
        tvvs.setFVisitNutritionLevelId(config1.StringNull(rs.getString(tvvs.getFFVisitNutritionLevelId())));
        tvvs.setRecordDate(config1.StringNull(rs.getString(tvvs.getFRecordDate())));
        tvvs.setRecordTime(config1.StringNull(rs.getString(tvvs.getFRecordTime())));
        tvvs.setTPatientId(config1.StringNull(rs.getString(tvvs.getFTPatientId())));
        tvvs.setTVisitId(config1.StringNull(rs.getString(tvvs.getFTVisitId())));

        tvvs.setTVisitVitalSignId(config1.StringNull(rs.getString(tvvs.getFTVisitVitalSignId())));
        tvvs.setVisitDtx(config1.StringNull(rs.getString(tvvs.getFVisitDtx())));
        tvvs.setVisitVitalSignActive(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignActive())));
        tvvs.setVisitVitalSignBloodPresure(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignBloodPresure())));
        tvvs.setVisitVitalSignBmi(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignBmi())));

        tvvs.setVisitVitalSignCheckDate(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignCheckDate())));
        tvvs.setVisitVitalSignCheckTime(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignCheckTime())));
        tvvs.setVisitVitalSignCurrentIllnessSymptom(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignCurrentIllnessSymptom())));
        tvvs.setVisitVitalSignGeneralSymptom(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignGeneralSymptom())));
        tvvs.setVisitVitalSignHeartRate(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignHeartRate())));

        tvvs.setVisitVitalSignHeight(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignHeight())));
        tvvs.setVisitVitalSignModifyDateTime(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignModifyDateTime())));
        tvvs.setVisitVitalSignNote(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignNote())));
        tvvs.setVisitVitalSignRespiratoryRate(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignRespiratoryRate())));
        tvvs.setVisitVitalSignStaffModify(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignStaffModify())));

        tvvs.setVisitVitalSignStaffRecord(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignStaffRecord())));
        tvvs.setVisitVitalSignTemperature(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignTemperature())));
        tvvs.setVisitVitalSignWeight(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignWeight())));
        tvvs.setVisitWaistline(config1.StringNull(rs.getString(tvvs.getFVisitWaistline())));
      }

      rs.close();
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(TVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return tvvs;
  }

  public Vector getTVisitVitalSign(String branchId, String where, String t_visit_id, String flag) {
    String sql = "";
    Vector v_vital_sign = new Vector();
    try {
      Connection conn = config1.getConnectionHospital(branchId);
      Statement stbangna = conn.createStatement();

      if (flag.equals("visit_id")) {
        sql = "Select * From " + tvvs.getTVisitVitalSign() + " "
                + "Where " + tvvs.getFTVisitId() + "='" + t_visit_id + "' and " + tvvs.getFVisitVitalSignActive() + "='1' "
                + "Order By " + tvvs.getFRecordDate() + "," + tvvs.getFRecordTime() + " asc";
      }else if(flag.equals("visit_vn")){
          sql = "Select t_visit_vital_sign.* From " + tvvs.getTVisitVitalSign() + " "
                  + "left join t_visit on t_visit.t_visit_id = t_visit_vital_sign.t_visit_id "
                + "Where t_visit.visit_vn ='" + t_visit_id + "' and " + tvvs.getFVisitVitalSignActive() + "='1' "
                + "Order By " + tvvs.getFRecordDate() + "," + tvvs.getFRecordTime() + " asc";
      }else{
        sql = "Select * From " + tvvs.getTVisitVitalSign() + " "
                + "Where " + tvvs.getFTVisitVitalSignId() + "='" + t_visit_id + "'";
      }

      ResultSet rs = stbangna.executeQuery(sql);
      while (rs.next()) {
        tvvs = new TVisitVitalSign();
        tvvs.setFVisitNutritionLevelId(config1.StringNull(rs.getString(tvvs.getFFVisitNutritionLevelId())));
        tvvs.setRecordDate(config1.StringNull(rs.getString(tvvs.getFRecordDate())));
        tvvs.setRecordTime(config1.StringNull(rs.getString(tvvs.getFRecordTime())));
        tvvs.setTPatientId(config1.StringNull(rs.getString(tvvs.getFTPatientId())));
        tvvs.setTVisitId(config1.StringNull(rs.getString(tvvs.getFTVisitId())));

        tvvs.setTVisitVitalSignId(config1.StringNull(rs.getString(tvvs.getFTVisitVitalSignId())));
        tvvs.setVisitDtx(config1.StringNull(rs.getString(tvvs.getFVisitDtx())));
        tvvs.setVisitVitalSignActive(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignActive())));
        tvvs.setVisitVitalSignBloodPresure(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignBloodPresure())));
        tvvs.setVisitVitalSignBmi(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignBmi())));

        tvvs.setVisitVitalSignCheckDate(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignCheckDate())));
        tvvs.setVisitVitalSignCheckTime(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignCheckTime())));
        tvvs.setVisitVitalSignCurrentIllnessSymptom(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignCurrentIllnessSymptom())));
        tvvs.setVisitVitalSignGeneralSymptom(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignGeneralSymptom())));
        tvvs.setVisitVitalSignHeartRate(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignHeartRate())));

        tvvs.setVisitVitalSignHeight(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignHeight())));
        tvvs.setVisitVitalSignModifyDateTime(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignModifyDateTime())));
        tvvs.setVisitVitalSignNote(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignNote())));
        tvvs.setVisitVitalSignRespiratoryRate(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignRespiratoryRate())));
        tvvs.setVisitVitalSignStaffModify(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignStaffModify())));

        tvvs.setVisitVitalSignStaffRecord(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignStaffRecord())));
        tvvs.setVisitVitalSignTemperature(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignTemperature())));
        tvvs.setVisitVitalSignWeight(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignWeight())));
        tvvs.setVisitWaistline(config1.StringNull(rs.getString(tvvs.getFVisitWaistline())));

        v_vital_sign.add(tvvs);
      }
      rs.close();
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(TVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return v_vital_sign;
    }
  public String getPatientVisitVitalSign(String branch_id, String visit_id){
        String text="";
        Vector v_vital_sign = new Vector();
        v_vital_sign = getTVisitVitalSign(branch_id,"", visit_id, "visit");
        for(int i=0;i<=v_vital_sign.size()-1;i++){
            tvvs = (TVisitVitalSign)v_vital_sign.get(i);
            text+="H.Rate="+tvvs.getVisitVitalSignHeartRate()+"ครั้ง/min"+
                    "; R.Rate="+tvvs.getVisitVitalSignRespiratoryRate()+"ครั้ง/min"+
                    ";BP="+tvvs.getVisitVitalSignBloodPresure()+"mmHg";
        }
        return text;
    }
    public String getPatientVisitWidthHeight(String branch_id, String visit_id){
        String text="";
        Vector v_vital_sign = new Vector();
        v_vital_sign = getTVisitVitalSign(branch_id,"", visit_id, "visit");
        for(int i=0;i<=v_vital_sign.size()-1;i++){
            tvvs = (TVisitVitalSign)v_vital_sign.get(i);
//            text+="Weight="+t_visit_vital_sign.getVisitVitalSignWeight()+"Kgs"+
//                    "; Height="+t_visit_vital_sign.getVisitVitalSignHeight()+"Cms";
            text+= "Height="+tvvs.getVisitVitalSignHeight()+"Cms"+
                    "; Weight="+tvvs.getVisitVitalSignWeight()+"Kgs";
        }
        return text;
    }
}