package bangnaLibrary;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BackTInjuryDB{
    private Config1 config1;
    private BBranch branch;
    private BackTInjury t_injury;
    String idtable="188";

    public BackTInjuryDB(){
        config1 = new Config1();
        initConfig(config1);
    }
    public BackTInjuryDB(Config1 cf){
        config1 = cf;
        initConfig(cf);
    }
    public void initConfig(Config1 cf){
        branch = new BBranch();
        t_injury = new BackTInjury();
    }
    public String getMaxRowBackTInjury(Connection conn) {
        String sql = ""; String max = "";
        try {
            Statement st = conn.createStatement();
            sql = "Select max(" + t_injury.getFInjuryId() + ") as cnt From " + t_injury.getBackTInjury();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))
                max = String.valueOf(Integer.parseInt(max) + 1);
            else
                max = "1880000001";
        } catch (Exception ex) {
            Logger.getLogger(BackTInjuryDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public BackTInjury getBackTInjuryByPK(Statement stbangna, String visit_hn, String injury_id, String flag) {
        String sql = "";
        try {
//            t_injury.initial();
            if (flag.equals("injury_number")) {
                sql = "Select * From " + t_injury.getBackTInjury() + " "
                    + "Where " + t_injury.getFInjuryNumber() + "='" + injury_id + "'";
            }else if(flag.equals("visit_hn")){
                sql = "Select * From " + t_injury.getBackTInjury() + " "
                    + "Where " + t_injury.getFInjuryNumber() + "='" + injury_id + "' and "+t_injury.getFVisitHn()+"='"+visit_hn+"'";
            } else{
                sql = "Select * From " + t_injury.getBackTInjury() + " "
                    + "Where " + t_injury.getFInjuryId() + "='" + injury_id + "'";
            }
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                t_injury = new BackTInjury();
                t_injury.setInjuryActive(config1.StringNull(rs.getString(t_injury.getFInjuryActive())));
                t_injury.setInjuryId(config1.StringNull(rs.getString(t_injury.getFInjuryId())));
                t_injury.setInjuryNumber(config1.StringNull(rs.getString(t_injury.getFInjuryNumber())));
                t_injury.setInjuryRemark(config1.StringNull(rs.getString(t_injury.getFInjuryRemark())));
                t_injury.setVisitDate(config1.StringNull(rs.getString(t_injury.getFVisitDate())));

                t_injury.setVisitHn(config1.StringNull(rs.getString(t_injury.getFVisitHn())));
                t_injury.setBranchId(config1.StringNull(rs.getString(t_injury.getFBranchId())));
            }
            rs.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTInjuryDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t_injury;
    }
  public Vector getBackTInjury(String branch_id, String where, String where1, String flag) {
    String sql = "";
    Vector v_t_injury = new Vector();
    try {
      Connection conn = config1.getConnectionBangna();
      Statement st = conn.createStatement();
      if (flag.equals("hn")) {
        sql = "Select * From " + t_injury.getBackTInjury() + " " 
                + "Where " + t_injury.getFVisitHn() + "='" + where + "' and " + t_injury.getFInjuryActive() + "='1' and " + t_injury.getFBranchId() + "='" + branch_id + "'";
      }else{
          sql = "Select * From " + t_injury.getBackTInjury() + " " 
                  + "Where " + t_injury.getFInjuryId() + "='" + flag + "'";
      }
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        t_injury = new BackTInjury();
        t_injury.setInjuryActive(config1.StringNull(rs.getString(t_injury.getFInjuryActive())));
        t_injury.setInjuryId(config1.StringNull(rs.getString(t_injury.getFInjuryId())));
        t_injury.setInjuryNumber(config1.StringNull(rs.getString(t_injury.getFInjuryNumber())));
        t_injury.setInjuryRemark(config1.StringNull(rs.getString(t_injury.getFInjuryRemark())));
        t_injury.setVisitDate(config1.StringNull(rs.getString(t_injury.getFVisitDate())));

        t_injury.setVisitHn(config1.StringNull(rs.getString(t_injury.getFVisitHn())));
        t_injury.setBranchId(config1.StringNull(rs.getString(t_injury.getFBranchId())));
        v_t_injury.add(t_injury);
      }
      rs.close();
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(BackTInjuryDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return v_t_injury;
  }
  public String setSaveBackTInjury(BackTInjury item) throws Exception {
    int chk = 0;
    String sql = ""; String max = "";
    try {
      Connection conn = config1.getConnectionBangna();
      Statement st = conn.createStatement();
      t_injury = getBackTInjuryByPK(st,"", item.getInjuryId(), "injury_id");
      item.setInjuryRemark(config1.StringNull(item.getInjuryRemark()).replace("'", "''"));
      if (t_injury.getInjuryId().equals("")) {
        item.generateOID(idtable);
        max = item.getObjectId();
//        max = getMaxRowBackTInjury(conn);
        sql = "Insert Into " + t_injury.getBackTInjury() 
                + "(" + t_injury.getFInjuryId() + ", " + t_injury.getFInjuryActive() + ", "
                + t_injury.getFInjuryNumber() + "," + t_injury.getFInjuryRemark() + ","
                + t_injury.getFVisitDate() + "," + t_injury.getFVisitHn() + ","
                + t_injury.getFBranchId() + ") "
                + "Values('" + max + "','" + item.getInjuryActive() + "','"
                + item.getInjuryNumber() + "','" + item.getInjuryRemark() + "','"
                + item.getVisitDate() + "','" + item.getVisitHn() + "','"
                + item.getBranchId() + "')";
      } else{
        sql = "Update " + t_injury.getBackTInjury()
                + " set " + t_injury.getFInjuryActive() + " = '" + item.getInjuryActive() + "', "
                + t_injury.getFInjuryNumber() + " = '" + item.getInjuryNumber() + "', "
                + t_injury.getFInjuryRemark() + " = '" + item.getInjuryRemark() + "', "
                + t_injury.getFVisitDate() + " = '" + item.getVisitDate() + "', "
                + t_injury.getFVisitHn() + " = '" + item.getVisitHn() + "', "
                + t_injury.getFBranchId() + " = '" + item.getBranchId() + "' "
                + "Where " + t_injury.getFInjuryId() + " = '" + item.getInjuryId() + "'";
        max = item.getInjuryId();
      }
      chk = st.executeUpdate(sql);
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(BackTInjuryDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return max;
  }
  public String getComboInjury(String branch_id, String visit_hn, String selected) {
    String txt = ""; String sql = "";
    Vector v_injury = new Vector();
    v_injury = getBackTInjury(branch_id, visit_hn, "", "hn");
    txt = "<option value='' selected></option>";
    try {
      for (int i = 0; i <= v_injury.size() - 1; i++) {
        t_injury = ((BackTInjury)v_injury.get(i));
        if (t_injury.getInjuryNumber().equals(selected)) {
          txt = txt + "<option value='" + t_injury.getInjuryNumber() + "' selected>" + config1.DateFormatDB2ShowHospital(t_injury.getVisitDate(), "ddMMyyyy") + " " + t_injury.getInjuryNumber() + "</option>";
        }else {
          txt = txt + "<option value='" + t_injury.getInjuryNumber() + "' >" + config1.DateFormatDB2ShowHospital(t_injury.getVisitDate(), "ddMMyyyy") + " " + t_injury.getInjuryNumber() + "</option>";
        }
        if (i == 4)
          sql = "";
      }
    }catch (Exception ex) {
      Logger.getLogger(BackTInjuryDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return txt;
  }
  public void setInjuryNumber(String branch_id, String visit_hn, String visit_date, String injury_number){
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            setInjuryNumber(st,branch_id, visit_hn, visit_date, injury_number);
            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(BackTInjuryDB.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  public void setInjuryNumber(Statement st,String branch_id, String visit_hn, String visit_date, String injury_number){
    try {
//      Connection conn = config1.getConnectionBangna();
//      Statement st = conn.createStatement();
      t_injury = new BackTInjury();
      t_injury = getBackTInjuryByPK(st,visit_hn, injury_number, "visit_hn");
      if (t_injury.getInjuryNumber().equals("")) {
        t_injury.setBranchId(branch_id);
        t_injury.setInjuryActive("1");
        t_injury.setInjuryId("");
        t_injury.setInjuryNumber(injury_number);
        t_injury.setInjuryRemark("");
        t_injury.setVisitDate(visit_date);
        t_injury.setVisitHn(visit_hn);
        setSaveBackTInjury(t_injury);
      }
    } catch (Exception ex) {
      Logger.getLogger(BackTInjuryDB.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}