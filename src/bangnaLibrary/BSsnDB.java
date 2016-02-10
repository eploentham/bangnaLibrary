/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

//import bangna.*;
//import bangna.hospital.CreateSSO;
import java.io.*;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author root
 */
public class BSsnDB {
    private Config1 config1 = new Config1();
    final private String idtableSSN = "101";
    private Vector ssnfile = new Vector();
    JProgressBar progressBar;
    private BSsnLog b_ssn_log = new BSsnLog();
    private BSsn b_ssn = new BSsn();
//    public BarThread(JProgressBar bar) {
//      progressBar = bar;
//    }
    public String getMaxRowBSsnLog(Connection conn){
        String sql="", max="";
        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select max("+b_ssn_log.getFBSsnLogId()+") as cnt From "+b_ssn_log.getBSsnLog();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if(max!=null && !max.equals("")) {
                max =  String.valueOf(Integer.parseInt(max)+1);
            }
            else{
                max = "1650000001";
            }
        } catch (Exception ex) {
            Logger.getLogger(BSsnDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public BSsnLog getBSsnLogByPK(String b_ssn_log_id) {
        Connection conn;
        String sql="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();

            sql="Select * "
                +"From "+b_ssn_log.getBSsnLog()+" "
                +"Where "+b_ssn_log.getFBSsnLogId()+"='"+b_ssn_log_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                b_ssn_log = new BSsnLog();
                b_ssn_log.setBSsnLogId(config1.StringNull(rs.getString(b_ssn_log.getFBSsnLogId())));
                b_ssn_log.setBranchId(config1.StringNull(rs.getString(b_ssn_log.getFBranchId())));
                b_ssn_log.setCnt1(Double.parseDouble(rs.getString(b_ssn_log.getFCnt1())));
                b_ssn_log.setFilename1(config1.StringNull(rs.getString(b_ssn_log.getFFilename1())));
                b_ssn_log.setMonthId(config1.StringNull(rs.getString(b_ssn_log.getFMonthId())));

                b_ssn_log.setPeriodId(config1.StringNull(rs.getString(b_ssn_log.getFPeriodId())));
                b_ssn_log.setSsnLogActive(config1.StringNull(rs.getString(b_ssn_log.getFSsnLogActive())));
                b_ssn_log.setYearId(config1.StringNull(rs.getString(b_ssn_log.getFYearId())));
                b_ssn_log.setDescription(config1.StringNull(rs.getString(b_ssn_log.getFDescription())));
                b_ssn_log.setCnt2(Double.parseDouble(rs.getString(b_ssn_log.getFCnt2())));

                b_ssn_log.setCnt5(Double.parseDouble(rs.getString(b_ssn_log.getFCnt5())));
                b_ssn_log.setFilename2(config1.StringNull(rs.getString(b_ssn_log.getFFilename2())));
                b_ssn_log.setFilename5(config1.StringNull(rs.getString(b_ssn_log.getFFilename5())));
                
                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BSsnDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b_ssn_log;
    }
    public Vector getBSsnLog(String branch_id, String b_ssn_log_id) {
        Connection conn;
        String sql="";
        Vector v_b_ssn_log = new Vector();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();

            sql="Select * "
                +"From "+b_ssn_log.getBSsnLog()+" "
                +"Where "+b_ssn_log.getFBranchId()+"='"+branch_id+"' and "+b_ssn_log.getFSsnLogActive()+"='1'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                b_ssn_log = new BSsnLog();
                b_ssn_log.setBSsnLogId(config1.StringNull(rs.getString(b_ssn_log.getFBSsnLogId())));
                b_ssn_log.setBranchId(config1.StringNull(rs.getString(b_ssn_log.getFBranchId())));
                b_ssn_log.setCnt1(Double.parseDouble(rs.getString(b_ssn_log.getFCnt1())));
                b_ssn_log.setFilename1(config1.StringNull(rs.getString(b_ssn_log.getFFilename1())));
                b_ssn_log.setMonthId(config1.StringNull(rs.getString(b_ssn_log.getFMonthId())));

                b_ssn_log.setPeriodId(config1.StringNull(rs.getString(b_ssn_log.getFPeriodId())));
                b_ssn_log.setSsnLogActive(config1.StringNull(rs.getString(b_ssn_log.getFSsnLogActive())));
                b_ssn_log.setYearId(config1.StringNull(rs.getString(b_ssn_log.getFYearId())));
                b_ssn_log.setDescription(config1.StringNull(rs.getString(b_ssn_log.getFDescription())));
                b_ssn_log.setCnt2(Double.parseDouble(rs.getString(b_ssn_log.getFCnt2())));

                b_ssn_log.setCnt5(Double.parseDouble(rs.getString(b_ssn_log.getFCnt5())));
                b_ssn_log.setFilename2(config1.StringNull(rs.getString(b_ssn_log.getFFilename2())));
                b_ssn_log.setFilename5(config1.StringNull(rs.getString(b_ssn_log.getFFilename5())));

                v_b_ssn_log.add(b_ssn_log);
                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BSsnDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_b_ssn_log;
    }
    public String setSaveBSsnLog(BSsnLog item) throws Exception {
        int chk=0;
        String sql="", ma_date="", attend_date="", max="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            b_ssn_log = getBSsnLogByPK(item.getBSsnLogId());
//            item.setPatientFullnamet(config1.StringNull(item.getPatientFullnamet()).replace("'", "''"));
//            item.setVisitNotice(config1.StringNull(item.getVisitNotice()).replace("'", "''"));
//            item.setVisitDiagnosisNotice(config1.StringNull(item.getVisitDiagnosisNotice()).replace("'", "''"));
//            item.setVisitContactNamet(config1.StringNull(item.getVisitContactNamet()).replace("'", "''"));
//            if (item.getVisitContactNamet()==null){
//                item.setVisitContactNamet("");
//            }
            if(item.getSsnLogActive().equals("")) {
                item.setSsnLogActive("1");
            }
            if(b_ssn_log.getBSsnLogId().equals("")) {
                max = getMaxRowBSsnLog(conn);
                sql="Insert Into "+b_ssn_log.getBSsnLog()+"("
                        +b_ssn_log.getFBSsnLogId()+", "+b_ssn_log.getFBranchId()+", "
                        +b_ssn_log.getFCnt1()+","+ b_ssn_log.getFFilename1()+","
                        +b_ssn_log.getFMonthId()+","+ b_ssn_log.getFPeriodId()+","
                        +b_ssn_log.getFSsnLogActive()+","+ b_ssn_log.getFYearId()+"," +
                        b_ssn_log.getFDescription()+","+b_ssn_log.getFCnt2()+","+
                        b_ssn_log.getFCnt5()+","+b_ssn_log.getFFilename2()+"," +
                        b_ssn_log.getFFilename5()+") "
                        +"Values('"+max+"','"+item.getBranchId()+"',"
                        +item.getCnt1() + ",'"+ item.getFilename1()+"','"
                        +item.getMonthId() + "','"+ item.getPeriodId()+"','"
                        +item.getSsnLogActive() + "','"+ item.getYearId()+"','" +
                        item.getDescription()+"',"+item.getCnt2()+"," +
                        item.getCnt5()+",'"+item.getFilename2()+"','" +
                        item.getFilename5()+"')";
            }else{
                sql = "Update "+b_ssn_log.getBSsnLog()+" set "+
                b_ssn_log.getFBranchId()+" = '"+item.getBranchId()+"', "+
                b_ssn_log.getFCnt1()+" = "+item.getCnt1()+", "+
                b_ssn_log.getFFilename1()+" = '"+item.getFilename1()+"', "+
                b_ssn_log.getFMonthId()+" = '"+item.getMonthId()+"', "+
                b_ssn_log.getFPeriodId()+" = '"+item.getPeriodId()+"', "+
                b_ssn_log.getFSsnLogActive()+" = '"+item.getSsnLogActive()+"', "+
                b_ssn_log.getFYearId()+" = '"+item.getYearId()+"', "+
                b_ssn_log.getFDescription()+" = '"+item.getDescription()+"', "+
                b_ssn_log.getFCnt2()+" = "+item.getCnt2()+", "+
                b_ssn_log.getFCnt5()+" = "+item.getCnt5()+", "+
                b_ssn_log.getFFilename2()+" = '"+item.getFilename2()+"', "+
                b_ssn_log.getFFilename5()+" = '"+item.getFilename5()+"' "+
                "Where "+b_ssn_log.getFBSsnLogId()+" = '"+item.getBSsnLogId()+"'";
                max = item.getBSsnLogId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BSsnDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public void UpdateBSsnLog(String branch_id, String b_ssn_log_id, String branch, String value){
        String sql = "";
        try{
            Connection conn;
            BSsnLog b_ssn_log = new BSsnLog();
            Statement st;
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            if(branch.equals("1")){
                sql="Update "+b_ssn_log.getBSsnLog()+" Set "+b_ssn_log.getFCnt1() +"="+value+
                    " Where "+b_ssn_log.getFBSsnLogId()+"='"+b_ssn_log_id+"'";
            }else if(branch.equals("2")){
                sql="Update "+b_ssn_log.getBSsnLog()+" Set "+b_ssn_log.getFCnt2() +"="+value+
                    " Where "+b_ssn_log.getFBSsnLogId()+"='"+b_ssn_log_id+"'";
            }else if(branch.equals("5")){
                sql="Update "+b_ssn_log.getBSsnLog()+" Set "+b_ssn_log.getFCnt5() +"="+value+
                    " Where "+b_ssn_log.getFBSsnLogId()+"='"+b_ssn_log_id+"'";
            }
            
            st.executeUpdate(sql);
            conn.close();
        }
        catch(Exception ex){
            //JOptionPane.showMessageDialog(null, ex.getMessage()+"\n" +sql, "DeleteCSSO Delete", 1);
            Logger.getLogger(BSsnDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void DeleteCSSN(){
        String sql = "";
        try{
            Connection conn;
            BSsn cssn = new BSsn();
            Statement st;
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql="Delete From "+cssn.SSN();
            st.executeUpdate(sql);
            conn.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage()+"\n" +sql, "DeleteCSSO Delete", 1);
            Logger.getLogger(BSsnDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int CreateSSN(Statement st, BSsn ssnfile) {
        int chk=0;
        String sql="";
        try{
//            Connection conn;
//            CSso csso = new CSso();
//            Statement st;
//            conn = config.getConnectionExtend();
//            st = conn.createStatement();
            
            try{
                sql="Insert Into "+ssnfile.SSN()+"("+ssnfile.CardID()+","+ssnfile.ID()+","+ssnfile.Prefix_NameT()+","
                    +ssnfile.First_Namet()+","+ssnfile.Last_Namet()+","+ssnfile.SSN_ID()+","
                    +ssnfile.Hos_ID()+","+ssnfile.Date_Start()+","+ssnfile.Date_End()+","
                    +ssnfile.Birth_Day()+") "
                    +"Values ('"+ssnfile.getCardID()+"','"+ssnfile.getID()+"','"+ssnfile.getPrefixNameT()+"','"
                    +ssnfile.getFirstNameT()+"','"+ssnfile.getLastNameT()+"','"+ssnfile.getSSNID()+"','"
                    +ssnfile.getHOSID()+"','"+ssnfile.getDateStart()+"','"+ssnfile.getDateEnd()+"','"
                    +ssnfile.getBirthDay()+"')";
                chk=st.executeUpdate(sql);
            }
            catch(Exception ex) {
                //JOptionPane.showMessageDialog(null, ex.getMessage()+"\n" +sql, "CreateSSO Insert", 1);
                Logger.getLogger(BSsnDB.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.close();
        }
        catch(Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage()+"\n" +sql, "CreateSSO ", 1);
            Logger.getLogger(BSsnDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    public Integer ReadNumRowFile(String filename) {
        Integer chk=0;
        File file = new File(filename);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
//        String curDir = System.getProperty("user.dir");
        StringBuilder data= new StringBuilder();
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            while (dis.available() != 0) {
                data.delete(0, data.length());
                data.append(dis.readLine());
                chk++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BSsnDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(BSsnDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    public String ImportSSN(String filename, JProgressBar pb) {
        File file = new File(filename);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        StringBuilder data= new StringBuilder();
        String sql="", text="";
//        String curDir = System.getProperty("user.dir");
//        curDir="/usr/local/bangna/sso/";
        Integer i=0;
        int DELAY = 500;
//        CreateSSO csso = new CreateSSO();

        try {
            if(file.exists()){
                
            }
            BSsn ssnFile = new BSsn();
            Connection conn;
            BSsn cssn = new BSsn();
            Statement st;
            conn = config1.getConnectionBangna();
            st = conn.createStatement();

            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);

            while (dis.available() != 0) {
                if(i==49669){
                    sql = "";
                }
//                if(dis.readLine() != null) {
//                data.delete(0, data.length());
//                data.append(dis.readLine());
                data.delete(0, data.length());
                data.append(new String(dis.readLine().getBytes("ISO8859_1"),"TIS-620"));
//                    data = Config.Ascii2Unicode(data);
//                    data = new String(data.getBytes("ISO8859_1"),"utf-8");
//                ssnFile.setCardID(data.substring(0, 13));
//                ssnFile.setID(data.substring(13, 26));
                ssnFile.setID(data.substring(0, 13));//แก้ไข เพราะใน text file field
                ssnFile.setCardID(data.substring(13, 26));
                
                ssnFile.setPrefixNameT(data.substring(26, 41).trim());
                ssnFile.setFirstNameT(data.substring(41, 70).trim());
                ssnFile.setLastNameT(data.substring(71, 99).trim());
                ssnFile.setSSNID(data.substring(99, 104));
                ssnFile.setHOSID(data.substring(104, 110));
                ssnFile.setDateStart(data.substring(110, 118));
                ssnFile.setDateEnd(data.substring(118, 126));
                ssnFile.setBirthDay(data.substring(126, data.length()));

                CreateSSN(st, ssnFile);
                i++;
            }
            conn.close();
            // dispose all the resources after using them.
            fis.close();
            bis.close();
            dis.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                text=ex.getMessage();
                //JOptionPane.showMessageDialog(null, ex.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
                text=ex.getMessage();
                //JOptionPane.showMessageDialog(null, ex.toString());
            } catch (Exception ex) {
                Logger.getLogger(BSsnDB.class.getName()).log(Level.SEVERE, null, ex);
                text=ex.getMessage();
                    //JOptionPane.showMessageDialog(null, ex.toString()+" "+i.toString()+" data "+data);
            }
            text+=i.toString();
            //JOptionPane.showMessageDialog(null, "Import Success");
        return text;
    }
    public Boolean setDeleteSSNFile(String filename) {
        boolean exists = (new File(filename)).exists();
        boolean success = false;
        if (exists) {
            // File or directory exists
            success = (new File(filename)).delete();
        } else {
            success = true;
        }
        return success;
    }
}
