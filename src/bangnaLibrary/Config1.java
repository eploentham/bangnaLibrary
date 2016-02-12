package bangnaLibrary;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pop
 */
//import bangnacashier.CashierTCloseDay;
import com.bangna.object.OrderItem;
import com.bangna.object.OrderItemDrug;
import com.bangna.usecase.connection.ConnectionDBMgr;
import com.bangna.usecase.connection.ConnectionInf;
import com.bangna.usecase.connection.Persistent;
import com.bangna.utility.XPersistent;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.GraphicsDevice;
import java.awt.DisplayMode;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.*;
import java.text.*;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Config1 {

    public BContactType ct = new BContactType();
    private FAddress address = new FAddress();
    private Contract contract = new Contract();
    private Doctor doctor = new Doctor();
    private BItem b_item = new BItem();
    private BackBTransfer b_transfer = new BackBTransfer();
    DomParser parser = new DomParser();
    BangnaIni bangnaIni = parser.getBangnaIni();
//    private readIni ini = new readIni();
//    private String host = ini.doit("hostname");
//    private String passDB = ini.doit("passDB");
//    private String database = ini.doit("database");
    private String panelorderpanel4width ="";
//    private String panelorderpanel4width = ini.doit("panelorderpanel4width");
    
//    private String userDB = ini.doit("userDB");

    public String userDB = "postgres";//ini.doit("userDB");
    public String userDBFront = "postgres";//ini.doit("userDB");
////    bangna5
//    public String host = "127.0.0.1";//ini.doit("hostname");
//    public String passDB = "postgres";//ini.doit("passDB");
//    public String database = "bangna5";//ini.doit("database");
    
//    public String host = "172.25.10.4";//ini.doit("hostname");
//    public String passDB = "bng5front";//ini.doit("passDB");
//    public String database = "bangna5";//ini.doit("database");
////    
    public String host = bangnaIni.hostname;
    public String passDB = bangnaIni.passDBbangna;//ini.doit("passDB");
    public String database = bangnaIni.databasebangna;//ini.doit("database");
    
//    public String host = "172.25.10.2";//ini.doit("hostname");
//    public String passDB = "bng5front";//ini.doit("passDB");
//    public String database = "bangna5_test";//ini.doit("database");
    
//    public String host = "localhost";//ini.doit("hostname");
//    public String passDB = "oleyoil1*";//ini.doit("passDB");
//    public String database = "bangna5";//ini.doit("database");
    
    public String hostFront = "172.25.10.4";
    public String passDBFront = "bng5front";
    public String databaseFront = "front_bangna5";
    
//    public String hostFront = bangnaIni.hostname;
//    public String passDBFront = bangnaIni.passDB;
//    public String databaseFront = bangnaIni.database;
    
//    public String host = "172.25.4.148";//ini.doit("hostname");
//    public String passDB = "7784";//ini.doit("passDB");
//    public String database = "bangna5_550314";//ini.doit("database");

//    public String host = "172.1.3.3";//ini.doit("hostname");
//    public String host = "localhost";//ini.doit("hostname");
//    public String passDB = "bng3linux";//ini.doit("passDB");
//    public String passDB = "bodin";//ini.doit("passDB");
//    public String database = "bangna3";//ini.doit("database");

//    public String host = "172.1.2.3";//ini.doit("hostname");
//    public String passDB = "bng2front";//ini.doit("passDB");
//    public String database = "bangna2";//ini.doit("database");
//    muangsamut

//        private String host = "125.25.168.247";//ini.doit("hostname");
//        private String passDB = "bng2front";//ini.doit("passDB");
//        private String database = "bangna2";//ini.doit("database");

//    private String host = "192.168.1.100";//ini.doit("hostname");
//    private String passDB = "msmfront";//ini.doit("passDB");
//    private String host = "localhost";//ini.doit("hostname");
//    private String passDB = "bng5front";//ini.doit("passDB");
//    private String database = "bangst";//ini.doit("hostname");
//    private String passDB = "oleyoil1*";//ini.doit("passDB");
//    private String database = "muangsamut_poo";//ini.doit("database");
//    localhost
//    private String host = "localhost";//ini.doit("hostname");
//    private String passDB = "oleyoil1*";//ini.doit("passDB");
//    private String database = "bangna5";//ini.doit("database");
//    private String passDB = "postgres";//ini.doit("passDB");
    //    private String host = "172.1.1.127";//ini.doit("hostname");
//    private String database = "bangna2";//ini.doit("database");

//    private String database = "muangsamut_poo";//ini.doit("database");

//    private String host = "172.1.1.3";//ini.doit("hostname");
//    private String passDB = "bng1front";//ini.doit("passDB");
//    private String database = "bangna1";//ini.doit("database");
//    private String host = "172.1.3.3";//ini.doit("hostname");

//    private String passDB = "bng3linux";//ini.doit("passDB");
//    private String passDB = "postgres";//ini.doit("passDB");
//    private String database = "bangna3";//ini.doit("database");
    private String driverName = "org.postgresql.Driver"; // Postgresql JDBC driver
    private DecimalFormat df = new DecimalFormat("#,##0.00");
    private DecimalFormat df1 = new DecimalFormat("#,##0.0");
    private DecimalFormat df2 = new DecimalFormat("#,##0.00");
    private DecimalFormat df3 = new DecimalFormat("#,##0.000");
    private DecimalFormat intf = new DecimalFormat("#,###");

    private Double num=0.0;
//    private Month month = new Month();
//    private Vector v_month = new Vector();
    public BBranch branch = new BBranch();

//    private ComboBox combobox = new ComboBox();
    private PatientVisitPaid patientvisitpaid = new PatientVisitPaid();
    private StringBuilder txt = new StringBuilder();
    private StringBuilder sql = new StringBuilder();
    private String date_return="";
    public String compName="", IPAddress="", appName="";
    private FItemGroup fItemGroup = new FItemGroup();//ini.doit("passDB");
    public ConnectionInf theConnectionInf;
//    public Connection conn = new Connection();

    public Config1(String appName){
        this.appName = appName;
        initConfig();
    }
    public Config1(){
        initConfig();
    }
    public void initConfig(){
        try {
            compName = getComputerName();
//            IPAddress = getIpAddress();
//            if(compName.toLowerCase().indexOf("bangna5") >=0){
//////                host = "172.25.10.2";
            if(compName.toLowerCase().indexOf("bangna5") >=0){
//                host = "172.25.10.2";
//                passDB = "bng5front";
//                database = "bangna5_test";
////              
                host = "172.25.10.4";
                passDB = "bng5front";
                database = "bangna5";
                
                hostFront = "172.25.10.4";
                passDBFront = "bng5front";
                databaseFront = "front_bangna5";
            }else if(compName.toLowerCase().indexOf("bangna2")>=0){
                host = "localhost";
                passDB = "bng2front";
                database = "bangna2";
                
//                hostFront = "172.1.1.1";
//                passDBFront = "";
//                databaseFront = "front_bangna3";
            }else if(compName.toLowerCase().indexOf("bangna3")>=0){
                host = "172.1.3.3";
                passDB = "bng3linux";
                database = "bangna3";
                
                hostFront = "172.1.3.3";
                passDBFront = "bng3linux";
                databaseFront = "front_bangna3";
            }else if(compName.toLowerCase().indexOf("bng1")>=0){
//                host = "172.1.1.3";
                host = "localhost";
                passDB = "bng1front";
                database = "bangna1";
                hostFront = "localhost";
                passDBFront = "bng1front";
                databaseFront = "front_bangna1";
            }else if(compName.toLowerCase().indexOf("localhost.localdomain")>=0){
                host = "192.168.1.100";
                passDB = "msmfront";
                database = "muangsamut_poo";
            }else if(compName.equals("kero")){
////                host = "localhost";
////                passDB = "123456";
////                database = "bangna5";
            }else if(compName.toLowerCase().indexOf("bng5-it01")>=0){
                
                host = "172.25.10.4";
                passDB = "bng5front";
                database = "bangna5";
                
//                host = "localhost";
//                passDB = "tavon";
//                database = "tavon";
                
            }else if(compName.indexOf("BA5-PC")>=0){
                host = "localhost";
                passDB = "7784";
                database = "tavon";
            }else if(compName.equals("ekapop-ThinkPad-X220")){
//                host = "localhost";
//                passDB = "oleyoil1*";
////                passDB = "bodin";
//                database = "bangna5";
//                database = "bangna1";
////                database = "hcu";
////                host = "192.168.1.100";
////                passDB = "msmfront";
//                database = "muangsamut_poo";
////                if(appName.indexOf("test")>0){
//                    host = "172.25.10.2";
//                    passDB = "bng5front";
//                    database = "bangna5_test";
////                }else{
//                    host = "172.25.10.4";
//                    passDB = "bng5front";
//                    database = "bangna5";
//                    hostFront = "172.25.10.4";
//                    passDBFront = "bng5front";
//                    databaseFront = "front_bangna5";
//                hostFront = "localhost";
//                passDBFront = "oleyoil1*";
//                databaseFront = "bangna5";
//                databaseFront = "tavon";
////                }
//                host = "172.25.10.2";
//                passDB = "bng5front";
//                database = "bangna5_test";
//                host = "172.1.1.3";
//                passDB = "bng1front";
//                database = "bangna1";
                
                host = "172.1.3.3";
                passDB = "bng3linux";
                database = "bangna3";
                
//                host = "localhost";
//                passDB = "oleyoil1*";
//                database = "tavon";
//////                
//                hostFront = "172.1.1.3";
//                passDBFront = "bng1front";
//                databaseFront = "front_bangna1";
////                
//                hostFront = "172.1.3.3";
//                passDBFront = "bng3linux";
//                databaseFront = "front_bangna3";
////                hostFront = "localhost";
////                passDB = "bng1front";
////                database = "bangna1";
////                passDBFront = "oleyoil1*";
////                databaseFront = "front_bangna5";
////                database = "bangna5_test";
////                
//                host = "10.0.10.200";
//                passDB = "7784";
//                database = "bangna5";
            }else{
//                hostFront = bangnaIni.hostname;
//                passDBFront = bangnaIni.passDB;
//                databaseFront = bangnaIni.database;
            }
//            host = "localhost";
//            database = "bangna2";
//            passDB = "bng2front";
////            passDB = "postgres";
////            passDB = "bng1front";
////            passDB = "oleyoil1*";
//            host = "172.1.3.3";
//            passDB = "bng3linux";
//            database = "bangna3";
            if(branch.logDatabaseUser.equals("")) {
                branch = getBranchActive();
            }
            Persistent x = new Persistent();
            theConnectionInf = new ConnectionDBMgr(host,database, userDB,passDB);
//            XPersistent x = new XPersistent();
            x.setHospitalSiteId(branch.getCipnId());
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConnectionBangna() throws Exception {
        String url = "";
        String jdbcname = "jdbc/unleashed";
        try {
            Class.forName(driverName);
            url = "jdbc:postgresql://" + host + "/" + database;
            Connection con = DriverManager.getConnection(url, userDB, passDB);
            //con = ds.getConnection();
            System.out.println(" Database connection established to " + url+ ".");
            return con;
        } catch (java.sql.SQLException e) {
            //JOptionPane.showMessageDialog(null, e.toString());
            System.out.println(" Connection couldn't be established to "+ url);
            throw (e);
        }
    }
    public Connection getConnectionBangna(Connection con) throws Exception {
        String url = "";
        String jdbcname = "jdbc/unleashed";
        try {
            Class.forName(driverName);
            url = "jdbc:postgresql://" + host + "/" + database;
            con = DriverManager.getConnection(url, userDB, passDB);
            System.out.println(" Database connection established to " + url+ ".");
            return con;
        } catch (java.sql.SQLException e) {
            //JOptionPane.showMessageDialog(null, e.toString());
            System.out.println(" Connection couldn't be established to "+ url);
            throw (e);
        }
    }
    public Connection getConnectionHost() throws Exception {
        String url = "", host1="172.25.10.4", database1="front_bangna5_old", user="postgres", password="bng5front";
        String jdbcname = "jdbc/unleashed";
//        String curDir = System.getProperty("user.dir");
        //System.out.print(curDir);
//        readIni ini = new readIni();
        //Context ctx = new InitialContext();
        //Context envCtx = (Context)ctx.lookup("java:comp/env");
        //DataSource ds= (DataSource)envCtx.lookup(jdbcname);

//        host = "localhost";
//        host = "172.1.3.3";
//        userDB = "postgres";
//        passDB = "oleyoil1*";
//        passDB = "postgres";
//        passDB = "bng3linux";
//        database = "bangna";
//        driverName = ini.doit("driverName");
        try {
            Class.forName(driverName);
            url = "jdbc:postgresql://" + host1 + "/"+database1;
            Connection con = DriverManager.getConnection(url,user, password);
            //con = ds.getConnection();
            System.out.println(" Database connection established to " + url+ ".");
//            JOptionPane.showMessageDialog(null, url+"\n"+userDB+" "+passDB);
            return con;
        } catch (java.sql.SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            System.out.println(" Connection couldn't be established to "+ url);
            throw (e);
        }
    }
    public enum ScreenCenter{
        Center(2,"Center"),Manual(1,"Manaul");
        private ScreenCenter(int p, String m){
            point = p;
        }
        public final int point;
    }
    public void setLocationCenter(JFrame aFrame, ScreenCenter aFlag) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        DisplayMode dm = gs[0].getDisplayMode();
        ScreenCenter sc =aFlag;
        int screenWidth = dm.getWidth();
        int screenHeight = dm.getHeight();
        // Determine the new location of the window
        int w = aFrame.getSize().width;
        int h = aFrame.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        // Move the window
        if (aFlag==sc.Manual) {
            aFrame.setLocation(x, y);
            //aFrame.setSize(screenWidth, screenHeight);
        }
        else if (aFlag==sc.Center) {
            aFrame.setLocation(0, 0);
            aFrame.setSize(screenWidth, screenHeight);
        }
    }
    public Connection getConnectionHospital(String branch_id) throws Exception {
        String url = "", host_address="", user_db="", pass_db="", datebase="", sql="";
        String jdbcname = "jdbc/unleashed";
        Connection conn;
        conn = getConnectionBangna();
        Statement st;
        ResultSet rs;
        st = conn.createStatement();
        sql = "Select * from b_branch_database Where branch_id = '"+branch_id+"' and host_name = 'hospital'";
        rs = st.executeQuery(sql);
        while (rs.next()){
            host_address=rs.getString("host_address");
            user_db=rs.getString("host_user_name");
            pass_db=rs.getString("host_password");
            datebase=rs.getString("host_database_name");
        }
        rs.close();
        conn.close();
        try {
            Class.forName(driverName);
            url = "jdbc:postgresql://" + host_address + "/" + datebase;
            Connection con = DriverManager.getConnection(url, user_db, pass_db);
            //con = ds.getConnection();
            System.out.println(" Database connection established to " + url+ ".");

            return con;
        } catch (java.sql.SQLException e) {
            System.out.println(" Connection couldn't be established to "+ url);
            throw (e);
        }
    }
    public Connection getConnectionBillLab(String mdbfilename) throws Exception {
        String url = "";
//        String curDir = System.getProperty("user.dir");
        //System.out.print(curDir);jdbc:sqlserver://172.1.1.1:1433;databaseName=bng1_dbms_front
//        readIni ini = new readIni();
        host = "172.1.1.3";
        userDB = "";
        passDB = "";
        database = "bng1_dbms_front";
        driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
            //url = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)};DBQ='"+mdbfilename+"';uid=;pwd=;";
            url = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)};DBQ="+mdbfilename+";uid=;pwd=;";
            Connection con = DriverManager.getConnection(url);
            System.out.println(" Database connection established to " + url+ ".");

            return con;
        } catch (java.sql.SQLException e) {
            System.out.println(" Connection couldn't be established to "+ url);
            throw (e);
        }
    }
    public Connection getConnectionMainHIS() throws Exception {
        String url = "";
//        String curDir = System.getProperty("user.dir");
        //System.out.print(curDir);jdbc:sqlserver://172.1.1.1:1433;databaseName=bng1_dbms_front
//        readIni ini = new readIni();
        String host = "172.1.1.1";
        String userDB = "sa";
        String passDB = "";
        String database = "bng1_dbms_front";
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(driverName).newInstance();
            url = "jdbc:sqlserver://" + host + ":1433;databaseName=" + database;
            Connection con = DriverManager.getConnection(url, userDB, passDB);
            System.out.println(" Database connection established to " + url+ ".");

            return con;
        } catch (java.sql.SQLException e) {
            System.out.println(" Connection couldn't be established to "+ url);
            throw (e);
        }
    }
    public Connection getConnectionMainHIS(String branch_id) throws Exception {
        String url = "", sql="", host_address="", user_db="", pass_db="", datebase="";
//        String curDir = System.getProperty("user.dir");
        //System.out.print(curDir);jdbc:sqlserver://172.1.1.1:1433;databaseName=bng1_dbms_front
//        readIni ini = new readIni();
//        String host = "172.1.1.1";
//        String userDB = "sa";
//        String passDB = "";
//        String database = "bng1_dbms_front";
        Connection conn;
        conn = getConnectionBangna();
        Statement st;
        ResultSet rs;
        st = conn.createStatement();
        sql = "Select * from b_branch_database Where branch_id = '"+branch_id+"' and host_name = 'mainhis'";
        rs = st.executeQuery(sql);
        while (rs.next()){
            host_address=rs.getString("host_address");
            user_db=rs.getString("host_user_name");
            pass_db=rs.getString("host_password");
            datebase=rs.getString("host_database_name");
        }
        rs.close();
        conn.close();
        if(pass_db==null) pass_db="";

        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(driverName).newInstance();
            url = "jdbc:sqlserver://" + host_address + ":1433;databaseName=" + datebase;
            Connection con = DriverManager.getConnection(url, user_db, pass_db);
            System.out.println(" Database connection established to " + url+ ".");

            return con;
        } catch (java.sql.SQLException e) {
            System.out.println(" Connection couldn't be established to "+ url);
            throw (e);
        }
    }
    public Connection getConnectionMainHIS(Connection conn,Statement st, String branch_id) throws Exception {
        String url = "", sql="", host_address="", user_db="", pass_db="", datebase="";
//        String curDir = System.getProperty("user.dir");
        //System.out.print(curDir);jdbc:sqlserver://172.1.1.1:1433;databaseName=bng1_dbms_front
//        readIni ini = new readIni();
        String host = "172.1.1.1";
        String userDB = "sa";
        String passDB = "";
        String database = "bng1_dbms_front";
//        Connection conn;
//        conn = getConnectionBangna();
//        Statement st;
        ResultSet rs;
        st = conn.createStatement();
        sql = "Select * from b_branch_database Where branch_id = '"+branch_id+"' and host_name = 'mainhis'";
        rs = st.executeQuery(sql);
        while (rs.next()){
            host_address=rs.getString("host_address");
            user_db=rs.getString("host_user_name");
            pass_db=rs.getString("host_password");
            datebase=rs.getString("host_database_name");
        }
        rs.close();
//        conn.close();
        
        driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(driverName).newInstance();
            url = "jdbc:sqlserver://" + host_address + ":1433;databaseName=" + datebase;
            Connection con = DriverManager.getConnection(url, user_db, pass_db);
            System.out.println(" Database connection established to " + url+ ".");

            return con;
        } catch (java.sql.SQLException e) {
            System.out.println(" Connection couldn't be established to "+ url);
            throw (e);
        }
    }
    public static String Stringfilter(String txt){
        StringBuffer temp = new StringBuffer(txt.length());
        char c;
        for(int i=0;i<txt.length();i++){
            c=txt.charAt(i);
            if(c=='<') temp.append("&lt;");
            else if(c=='>') temp.append("&gt;");
            else if(c=='\'') temp.append("&#039;");
            else if(c=='"') temp.append("&quot;");
            else if(c=='&') temp.append("&amp;");
            else if(c=='\\') temp.append("&#92;");
            else if(c=='\'') temp.append("&#039;");
            //else if(c=="'") temp.append("''");
            else temp.append(c);
        }
        return temp.toString();
    }
    
    public String StringNull(String txt){
//        String aa="";
        if(txt==null){
            return "";
        } else{
            return txt;
        }
//        return aa;
    }
    public String DateFormatShortYear(String txt){
        return txt.substring(0, 6)+txt.substring(8, 10);
    }
    public String DateFormatDB2ShowHospital(String txt, String format) throws Exception  {
//        String aa="", year="", month="", day="", date="";
        if(txt.length()>=10){
//            date = txt.substring(0, 10);
//            year = txt.substring(0, 10).substring(0, 4);
//            month = txt.substring(0, 10).substring(5, 7);
//            day = txt.substring(0, 10).substring(txt.substring(0, 10).length()-2, txt.substring(0, 10).length());
            if(format.equals("ddMMyyyy")){
//                year = String.valueOf(Integer.parseInt(date.substring(0, 4))+543);
                return txt.substring(0, 10).substring(txt.substring(0, 10).length()-2, txt.substring(0, 10).length())+"-"+txt.substring(0, 10).substring(5, 7)+"-"+String.valueOf(Integer.parseInt(txt.substring(0, 10).substring(0, 4))+543);
            }else if(format.equals("ddMMyy")){
//                year = txt.substring(0, 10).substring(0, 4).substring(2, 4);
                return txt.substring(0, 10).substring(txt.substring(0, 10).length()-2, txt.substring(0, 10).length())+"-"+txt.substring(0, 10).substring(5, 7)+"-"+txt.substring(0, 10).substring(0, 4).substring(2, 4);
            }else{
                return txt;
            }
        }else{
            return txt;
        }
//        return aa;
    }
    public String DateFormatDB2Show(String txt, String format) throws Exception  {
//        String aa="", year="", month="", day="", date="";
        if(txt == null) return txt;
        if(txt.length()>=10){
//            date = txt.substring(0, 10);
//            year = date.substring(0, 4);
//            month = date.substring(5, 7);
//            day = date.substring(date.length()-2, date.length());
            if(format.equals("ddMMyyyy")){
                return txt.substring(0, 10).substring(txt.substring(0, 10).length()-2, txt.substring(0, 10).length())+"-"+txt.substring(0, 10).substring(5, 7)+"-"+txt.substring(0, 10).substring(0, 4);
            }else if(format.equals("ddMMyy")){
                //year = String.valueOf(Integer.parseInt(year)+543).substring(2, 4);
//                year = date.substring(0, 4).substring(2, 4);
                return txt.substring(0, 10).substring(txt.substring(0, 10).length()-2, txt.substring(0, 10).length())+"-"+txt.substring(0, 10).substring(5, 7)+"-"+txt.substring(0, 10).substring(0, 4).substring(2, 4);
            }else{
                return txt;
            }
        }else{
            return txt;
        }
//        return aa;
    }
    public String DateFormatShow2DB(String txt, String format) throws Exception{
//        String aa="", year="", month="", day="";
        if(txt.length()>=10){
            if(format.equals("ddMMyyyy")){
//                day = txt.substring(0, 2);
//                month = txt.substring(3, 5);
//                year = txt.substring(txt.length()-4, txt.length());
                return txt.substring(txt.length()-4, txt.length())+"-"+txt.substring(3, 5)+"-"+txt.substring(0, 2);
            }else if(format.equals("dd")){
                return txt.substring(0, 2);
            }else{
                return txt;
            }
        }else{
            return txt;
        }
//        return aa;
    }
    public String DateFormatShow2Show(String txt, String format) throws Exception{
        String aa="", year="", month="", day="";
        if(txt.length()>=10){
            if(format.equals("ddMMyyyy")){
                day = txt.substring(0, 2);
                month = txt.substring(3, 5);
                year = txt.substring(txt.length()-4, txt.length());
                aa = year+"-"+month+"-"+day;
            }else if(format.equals("dd MMMM yyyy")){
                day = txt.substring(0, 2);
                month = txt.substring(3, 5);
                year = txt.substring(txt.length()-4, txt.length());
                aa = day+"-"+getMonthNamet(month,"id_namet")+"-"+year;
            }
        }else{
            aa=txt;
        }
        return aa;
    }
    public String DateFormatShow2ShowHospital(String txt, String format) throws Exception{
//        String aa="", year="", month="", day="";
        if(txt.length()>=10){
            if(format.equals("ddMMyyyy")){
//                day = txt.substring(0, 2);
//                month = txt.substring(3, 5);
//                year = String.valueOf(Integer.parseInt(txt.substring(txt.length()-4, txt.length()))+543);
                date_return = txt.substring(0, 2)+"-"+txt.substring(3, 5)+"-"+String.valueOf(Integer.parseInt(txt.substring(txt.length()-4, txt.length()))+543);
            }else if(format.equals("dd MMMM yyyy")) {
//                day = txt.substring(0, 2);
//                month = txt.substring(3, 5);
//                year = String.valueOf(Integer.parseInt(txt.substring(txt.length()-4, txt.length()))+543);
                date_return = txt.substring(0, 2)+" "+getMonthNamet(txt.substring(3, 5),"id_namet")+" "+String.valueOf(Integer.parseInt(txt.substring(txt.length()-4, txt.length()))+543);
            }
        }else {
            date_return=txt;
        }
        return date_return;
    }
    public String DateFormatShow2DBHospital(String txt, String format) throws Exception {
//        String year="", month="";
        if(txt.length()>=10){
            if(format.equals("ddMMyyyy")) {
//                day = txt.substring(0, 2);
//                month = txt.substring(3, 5);
//                year = String.valueOf(Integer.parseInt(txt.substring(txt.length()-4, txt.length()))+543);
            }
            if(Integer.parseInt(txt.substring(txt.length()-4, txt.length()))<2500){
                return String.valueOf(Integer.parseInt(txt.substring(txt.length()-4, txt.length()))+543)+"-"+txt.substring(3, 5)+"-"+txt.substring(0, 2);
            }else{
                return String.valueOf(Integer.parseInt(txt.substring(txt.length()-4, txt.length())))+"-"+txt.substring(3, 5)+"-"+txt.substring(0, 2);
            }
        }else {
            return txt;
        }
//        return aa;
    }
    public String DateFormatShowHospital2DB(String txt, String format) throws Exception {
//        String year="", month="";
        if(txt.length()>=10){
            if(format.equals("ddMMyyyy")) {
//                day = txt.substring(0, 2);
//                month = txt.substring(3, 5);
//                year = String.valueOf(Integer.parseInt(txt.substring(txt.length()-4, txt.length()))+543);
            }
            return String.valueOf(Integer.parseInt(txt.substring(txt.length()-4, txt.length()))-543)+"-"+txt.substring(3, 5)+"-"+txt.substring(0, 2);
        }else {
            return txt;
        }
//        return aa;
    }
    public String TimeFormat(String txt, String format){
        if(txt.length()>=16){
            if(format.equals("hhmm")){
                return txt.substring(11, 16).replaceAll(":", "");
            }else{
                return txt;
            }
        }else {
            return txt;
        }
    }
    
    public Vector getBranch() throws Exception {
        String sql="", txt="", select="";
        Connection conn = getConnectionBangna();
        Vector v_branch = new Vector();
//        BBranch branch = new BBranch();
        Statement st;
        ResultSet rs;
        sql="Select * From "+branch.getBBranch();
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            branch = new BBranch();
            branch.setBranchId(rs.getString(branch.getFBranchId()));
            branch.setBranchNamet(rs.getString(branch.getFBranchNamet()));
            branch.setBranchActive(rs.getString(branch.getFBranchActive()));
            branch.setBranchStatus(rs.getString(branch.getFBranchStatus()));
            branch.setTaxId(rs.getString(branch.getFTaxId()));

            branch.setBranchProgram(rs.getString(branch.getFBranchProgram()));
            branch.setCashInDrawer(rs.getDouble(branch.getFCashInDrawer()));
            branch.setPrintInvoice(rs.getString(branch.getFPrintInvoice()));
            branch.setPrintReceive(StringNull(rs.getString(branch.getFPrintReceive())));
            branch.setInvoiceNamet(StringNull(rs.getString(branch.getFInvoiveNamet())));

            branch.setReceiveNamet(StringNull(rs.getString(branch.getFReceiveNamet())));
            branch.setReceivePrivilege(StringNull(rs.getString(branch.getFReceivePrivilege())));
            branch.setPrintInvoicePreview(StringNull(rs.getString(branch.getFPrintInvoicePreview())));
            branch.setPrintReceivePreview(StringNull(rs.getString(branch.getFPrintReceivePreview())));
            branch.setPrintInvoicePreviewIpd(StringNull(rs.getString(branch.getFPrintInvoicePreviewIpd())));

            branch.setPrintReceivePreviewIpd(StringNull(rs.getString(branch.getFPrintReceivePreviewIpd())));
            branch.setBranchAddressEnglish(StringNull(rs.getString(branch.getFBranchAddressEnglish())));
            branch.setSurveillacePrivilege(StringNull(rs.getString(branch.getFSurveillancePrivilege())));
            branch.setMdNamet(StringNull(rs.getString(branch.getFMdNamet())));
            branch.setBranchNametTax(StringNull(rs.getString(branch.getFBranchNametTax())));

            branch.setBranchAddressThai(StringNull(rs.getString(branch.getFBranchAddressThai())));
            branch.setEmployerId(StringNull(rs.getString(branch.getFEmployerId())));
            branch.setCipnId(StringNull(rs.getString(branch.getFCipnId())));
            branch.setPathfileCipn(StringNull(rs.getString(branch.getFPathfileCipn())));
            branch.setFitemgroupDressing(StringNull(rs.getString(branch.getFFitemgroupDressing())));

            branch.setCipnFeeschedule01(StringNull(rs.getString(branch.getFCipnFeeschedule01())));
            branch.setCipnFeeschedule02(StringNull(rs.getString(branch.getFCipnFeeschedule02())));
            branch.setServerImageName(StringNull(rs.getString(branch.getFServerImageName())));
            branch.setServerWebName(StringNull(rs.getString(branch.getFServerWebName())));
            branch.setTaxDoctor(rs.getDouble(branch.getFTaxDoctor()));
            
            branch.setLocalFolderimageName(StringNull(rs.getString(branch.getFLocalFolderimageName())));
            branch.setLocalFolderxrayName(StringNull(rs.getString(branch.getFLocalFolderxrayName())));
            branch.setLocalFolderrecordName(StringNull(rs.getString(branch.getFLocalFolderrecordName())));
            branch.setLocalFolderlabName(StringNull(rs.getString(branch.getFLocalFolderlabName())));
            
            branch.setLogDatabaseUrl(StringNull(rs.getString(branch.getFLogDatabaseUrl())));
            branch.setLogDatabaseUser(StringNull(rs.getString(branch.getFLogDatabaseUser())));
            branch.setLogDatabasePassword(StringNull(rs.getString(branch.getFLogDatabasePassword())));
            branch.googleMapLat= StringNull(rs.getString(branch.getFGoogleMapLat()));
            branch.googleMapLon= StringNull(rs.getString(branch.getFGoogleMapLon()));
            branch.googleMapZoom= StringNull(rs.getString(branch.getFGoogleMapZoom()));
            branch.setServerImageReserveName(StringNull(rs.getString(branch.getFServerImageReserveName())));
            branch.statusFormulaDf = StringNull(rs.getString(branch.getFStatusFormulaDf()));
            v_branch.add(branch);
        }
        rs.close();
        conn.close();
        return v_branch;
    }
    
    public Vector getComboBranchHospital() throws Exception {
        String sql="", txt="", select="";
        Connection conn = getConnectionBangna();
        Vector v_branch = new Vector();
//        BBranch branch = new BBranch();
        Statement st;
        ResultSet rs;
        sql="Select * From "+branch.getBBranch()+" Order By "+branch.getFBranchId();
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            branch = new BBranch();
            branch.setObjectId(rs.getString(branch.getFBranchId()));
            branch.setBranchId(rs.getString(branch.getFBranchId()));
            branch.setBranchNamet(rs.getString(branch.getFBranchNamet()));
//            branch.desc = branch.getBranchNamet();
//            branch.setBranchActive(rs.getString(branch.getFBranchActive()));
//            branch.setBranchStatus(rs.getString(branch.getFBranchStatus()));
//            branch.setTaxId(rs.getString(branch.getFTaxId()));
//
//            branch.setBranchProgram(rs.getString(branch.getFBranchProgram()));
//            branch.setCashInDrawer(Double.parseDouble(rs.getString(branch.getFCashInDrawer())));
//            branch.setPrintInvoice(rs.getString(branch.getFPrintInvoice()));
//            branch.setPrintReceive(StringNull(rs.getString(branch.getFPrintReceive())));
//            branch.setInvoiceNamet(StringNull(rs.getString(branch.getFInvoiveNamet())));
//
//            branch.setReceiveNamet(StringNull(rs.getString(branch.getFReceiveNamet())));
//            branch.setReceivePrivilege(StringNull(rs.getString(branch.getFReceivePrivilege())));
//            branch.setPrintInvoicePreview(StringNull(rs.getString(branch.getFPrintInvoicePreview())));
//            branch.setPrintReceivePreview(StringNull(rs.getString(branch.getFPrintReceivePreview())));
            v_branch.add(branch);
        }
        rs.close();
        conn.close();
        return v_branch;
    }
    public final BBranch getBranchActive() throws Exception{
        String sql="", txt="", select="";
        Connection conn = getConnectionBangna();
        Statement st;
        ResultSet rs;
        try{
            sql="Select * From "+branch.getBBranch()+" Where "+branch.getFBranchActive()+"='1'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                branch = new BBranch();
                branch.setBranchId(rs.getString(branch.getFBranchId()));
                branch.setBranchNamet(rs.getString(branch.getFBranchNamet()));
                branch.setCashInDrawer(Double.parseDouble(rs.getString(branch.getFCashInDrawer())));
                branch.setBranchProgram(rs.getString(branch.getFBranchProgram()));
                branch.setTaxId(rs.getString(branch.getFTaxId()));

                branch.setBranchStatus(rs.getString(branch.getFBranchStatus()));
                branch.setPrintInvoice(rs.getString(branch.getFPrintInvoice()));
                branch.setPrintReceive(rs.getString(branch.getFPrintReceive()));
                branch.setBranchActive(rs.getString(branch.getFBranchActive()));
                branch.setInvoiceNamet(StringNull(rs.getString(branch.getFInvoiveNamet())));

                branch.setReceiveNamet(StringNull(rs.getString(branch.getFReceiveNamet())));
                branch.setReceivePrivilege(StringNull(rs.getString(branch.getFReceivePrivilege())));
                branch.setPrintInvoicePreview(StringNull(rs.getString(branch.getFPrintInvoicePreview())));
                branch.setPrintReceivePreview(StringNull(rs.getString(branch.getFPrintReceivePreview())));
                branch.setPrintInvoicePreviewIpd(StringNull(rs.getString(branch.getFPrintInvoicePreviewIpd())));

                branch.setPrintReceivePreviewIpd(StringNull(rs.getString(branch.getFPrintReceivePreviewIpd())));
                branch.setBranchAddressEnglish(StringNull(rs.getString(branch.getFBranchAddressEnglish())));
                branch.setSurveillacePrivilege(StringNull(rs.getString(branch.getFSurveillancePrivilege())));
                branch.setMdNamet(StringNull(rs.getString(branch.getFMdNamet())));
                branch.setBranchNametTax(StringNull(rs.getString(branch.getFBranchNametTax())));

                branch.setBranchAddressThai(StringNull(rs.getString(branch.getFBranchAddressThai())));
                branch.setEmployerId(StringNull(rs.getString(branch.getFEmployerId())));
                branch.setCipnId(StringNull(rs.getString(branch.getFCipnId())));
                branch.setPathfileCipn(StringNull(rs.getString(branch.getFPathfileCipn())));
                branch.setFitemgroupDressing(StringNull(rs.getString(branch.getFFitemgroupDressing())));

                branch.setCipnFeeschedule01(StringNull(rs.getString(branch.getFCipnFeeschedule01())));
                branch.setCipnFeeschedule02(StringNull(rs.getString(branch.getFCipnFeeschedule02())));
                branch.setServerImageName(StringNull(rs.getString(branch.getFServerImageName())));
                branch.setServerWebName(StringNull(rs.getString(branch.getFServerWebName())));
                branch.setTaxDoctor(rs.getDouble(branch.getFTaxDoctor()));

                branch.setLocalFolderimageName(StringNull(rs.getString(branch.getFLocalFolderimageName())));
                branch.setLocalFolderxrayName(StringNull(rs.getString(branch.getFLocalFolderxrayName())));
                branch.setLocalFolderrecordName(StringNull(rs.getString(branch.getFLocalFolderrecordName())));
                branch.setLocalFolderlabName(StringNull(rs.getString(branch.getFLocalFolderlabName())));

                branch.setLogDatabaseUrl(StringNull(rs.getString(branch.getFLogDatabaseUrl())));
                branch.setLogDatabaseUser(StringNull(rs.getString(branch.getFLogDatabaseUser())));
                branch.setLogDatabasePassword(StringNull(rs.getString(branch.getFLogDatabasePassword())));
                branch.googleMapLat= StringNull(rs.getString(branch.getFGoogleMapLat()));
                branch.googleMapLon= StringNull(rs.getString(branch.getFGoogleMapLon()));

                branch.googleMapZoom= StringNull(rs.getString(branch.getFGoogleMapZoom()));
                branch.setServerImageReserveName(StringNull(rs.getString(branch.getFServerImageReserveName())));
                branch.statusFormulaDf = StringNull(rs.getString(branch.getFStatusFormulaDf()));
            }
            rs.close();
        }catch(Exception ex){
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();
        return branch;
    }
    public BBranch getBranch(String branch_id) throws Exception{
        String sql="", txt="", select="";
        Connection conn = getConnectionBangna();
        Statement st;
        ResultSet rs;
        sql="Select * From "+branch.getBBranch()+" Where "+branch.getFBranchId()+"='"+branch_id+"'";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            branch = new BBranch();
            branch.setBranchId(rs.getString(branch.getFBranchId()));
            branch.setBranchNamet(rs.getString(branch.getFBranchNamet()));
            branch.setCashInDrawer(Double.parseDouble(rs.getString(branch.getFCashInDrawer())));
            branch.setBranchProgram(rs.getString(branch.getFBranchProgram()));
            branch.setPrintInvoice(rs.getString(branch.getFPrintInvoice()));
            
            branch.setPrintReceive(rs.getString(branch.getFPrintReceive()));
            branch.setInvoiceNamet(StringNull(rs.getString(branch.getFInvoiveNamet())));
            branch.setReceiveNamet(StringNull(rs.getString(branch.getFReceiveNamet())));
            branch.setBranchActive(rs.getString(branch.getFBranchActive()));
            branch.setBranchStatus(rs.getString(branch.getFBranchStatus()));

            branch.setTaxId(rs.getString(branch.getFTaxId()));
            branch.setReceivePrivilege(StringNull(rs.getString(branch.getFReceivePrivilege())));
            branch.setPrintInvoicePreview(StringNull(rs.getString(branch.getFPrintInvoicePreview())));
            branch.setPrintReceivePreview(StringNull(rs.getString(branch.getFPrintReceivePreview())));
            branch.setPrintInvoicePreviewIpd(StringNull(rs.getString(branch.getFPrintInvoicePreviewIpd())));

            branch.setPrintReceivePreviewIpd(StringNull(rs.getString(branch.getFPrintReceivePreviewIpd())));
            branch.setBranchAddressEnglish(StringNull(rs.getString(branch.getFBranchAddressEnglish())));
            branch.setSurveillacePrivilege(StringNull(rs.getString(branch.getFSurveillancePrivilege())));
            branch.setMdNamet(StringNull(rs.getString(branch.getFMdNamet())));
            branch.setBranchNametTax(StringNull(rs.getString(branch.getFBranchNametTax())));
            
            branch.setBranchAddressThai(StringNull(rs.getString(branch.getFBranchAddressThai())));
            branch.setEmployerId(StringNull(rs.getString(branch.getFEmployerId())));
            branch.setCipnId(StringNull(rs.getString(branch.getFCipnId())));
            branch.setPathfileCipn(StringNull(rs.getString(branch.getFPathfileCipn())));
            branch.setFitemgroupDressing(StringNull(rs.getString(branch.getFFitemgroupDressing())));

            branch.setCipnFeeschedule01(StringNull(rs.getString(branch.getFCipnFeeschedule01())));
            branch.setCipnFeeschedule02(StringNull(rs.getString(branch.getFCipnFeeschedule02())));
            branch.setServerImageName(StringNull(rs.getString(branch.getFServerImageName())));
            branch.setServerWebName(StringNull(rs.getString(branch.getFServerWebName())));
            branch.setTaxDoctor(rs.getDouble(branch.getFTaxDoctor()));

            branch.setLocalFolderimageName(StringNull(rs.getString(branch.getFLocalFolderimageName())));
            branch.setLocalFolderxrayName(StringNull(rs.getString(branch.getFLocalFolderxrayName())));
            branch.setLocalFolderrecordName(StringNull(rs.getString(branch.getFLocalFolderrecordName())));
            branch.setLocalFolderlabName(StringNull(rs.getString(branch.getFLocalFolderlabName())));
            
            branch.setLogDatabaseUrl(StringNull(rs.getString(branch.getFLogDatabaseUrl())));
            branch.setLogDatabaseUser(StringNull(rs.getString(branch.getFLogDatabaseUser())));
            branch.setLogDatabasePassword(StringNull(rs.getString(branch.getFLogDatabasePassword())));
            branch.googleMapLat= StringNull(rs.getString(branch.getFGoogleMapLat()));
            branch.googleMapLon= StringNull(rs.getString(branch.getFGoogleMapLon()));
            branch.googleMapZoom= StringNull(rs.getString(branch.getFGoogleMapZoom()));
            branch.setServerImageReserveName(StringNull(rs.getString(branch.getFServerImageReserveName())));
            branch.statusFormulaDf = StringNull(rs.getString(branch.getFStatusFormulaDf()));
        }
        rs.close();
        conn.close();
        return branch;
    }
    public String getSiteNamet(String branch_id) throws Exception{
        String sql="", txt="", select="";
        Connection conn = getConnectionHospital(branch_id);
        Vector v_branch = new Vector();
        BBranch branch = new BBranch();
        Statement st;
        ResultSet rs;
        sql="Select site_full_name ||' เลขที่' || ' ' ||site_house || '  ' || 'หมู่.' ||" +
                "site_moo  || '  ' || 'ต.' || f5.address_description || '  ' || 'อ.' ||  " +
                "f6.address_description || '  ' || 'จ.' ||   f7.address_description || '' || " +
                "site_postcode ||' โทรศัพท์ ' || site_phone_number  as sitenamet " +
                "From b_site left join f_address as f5 on b_site.site_tambon = f5.f_address_id " +
                "left join f_address as f6 on b_site.site_amphur = f6.f_address_id " +
                "left join f_address as f7 on b_site.site_changwat = f7.f_address_id ";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            txt=rs.getString("sitenamet").trim();
        }
        rs.close();
        conn.close();
        return txt;
    }
    public String getSiteNametBangkok(String branch_id) throws Exception{
        String sql="", txt="", select="";
        Connection conn = getConnectionHospital(branch_id);
        Vector v_branch = new Vector();
        BBranch branch = new BBranch();
        Statement st;
        ResultSet rs;
        sql="Select site_full_name ||' เลขที่' || ' ' ||site_house || '  ' || ' ' ||" +
                " 'แขวง ' || f5.address_description || '  ' || 'เขต.' ||  " +
                "f6.address_description || '  ' || 'จ.' ||   f7.address_description || '' || " +
                "site_postcode ||' โทรศัพท์ ' || site_phone_number  as sitenamet " +
                "From b_site left join f_address as f5 on b_site.site_tambon = f5.f_address_id " +
                "left join f_address as f6 on b_site.site_amphur = f6.f_address_id " +
                "left join f_address as f7 on b_site.site_changwat = f7.f_address_id ";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            txt=rs.getString("sitenamet").trim();
        }
        rs.close();
        conn.close();
        return txt;
    }
    public String getSiteNamet1(String branch_id) throws Exception{
        String sql="", txt="", select="";
        Connection conn = getConnectionHospital(branch_id);
        Vector v_branch = new Vector();
        BBranch branch = new BBranch();
        Statement st;
        ResultSet rs;
        sql="Select site_full_name " +
                "From b_site ";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            txt=rs.getString("site_full_name").trim();
        }
        rs.close();
        conn.close();
        return txt;
    }
    public String getSiteNamee(String branch_id) throws Exception{
        String sql="", txt="", select="";
        Connection conn = getConnectionHospital(branch_id);
        Vector v_branch = new Vector();
        BBranch branch = new BBranch();
        Statement st;
        ResultSet rs;
        sql="Select site_full_namee " +
                "From b_site ";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            txt=rs.getString("site_full_namee").trim();
        }
        rs.close();
        conn.close();
        return txt;
    }
    public String getSiteAddressNamet(String branch_id) throws Exception{
        String sql="", txt="", select="";
        Connection conn = getConnectionHospital(branch_id);
//        Vector v_branch = new Vector();
//        BBranch branch = new BBranch();
        Statement st;
        ResultSet rs;
        sql="Select 'เลขที่' || ' ' ||site_house || '  ' || 'หมู่.' ||" +
                "site_moo  || '  ' || 'ต.' || f5.address_description || '  ' || 'อ.' ||  " +
                "f6.address_description || '  ' || 'จ.' ||   f7.address_description || '' || " +
                "site_postcode ||' โทรศัพท์ ' || site_phone_number  as sitenamet " +
                "From b_site left join f_address as f5 on b_site.site_tambon = f5.f_address_id " +
                "left join f_address as f6 on b_site.site_amphur = f6.f_address_id " +
                "left join f_address as f7 on b_site.site_changwat = f7.f_address_id ";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            txt=rs.getString("sitenamet").trim();
        }
        rs.close();
        conn.close();
        return txt;
    }
    public String getSiteAddressNamee(String branch_id) throws Exception{
        String sql="", txt="", select="";
        Connection conn = getConnectionHospital(branch_id);
        Statement st;
        ResultSet rs;
        sql="Select address_english " +
                "From b_site ";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            txt=rs.getString("address_english").trim();
        }
        rs.close();
        conn.close();
        return txt;
    }

    public String getDate(String format){
        java.util.Date date1 = new java.util.Date();
        Format formatter = new SimpleDateFormat(format);
        String s = formatter.format(date1);
        String date_current="",year="";
        if(format.equals("yyyyMMdd")){
            year = s.substring(0, 4);
//            s = String.valueOf(Integer.parseInt(year)-543)+"-"+s.substring(4, 6)+"-"+s.substring(s.length()-2, s.length());
            s = String.valueOf(year)+"-"+s.substring(4, 6)+"-"+s.substring(s.length()-2, s.length());
        }else if(format.equals("ddMMyyyy")){
            year = s.substring(s.length()-4, s.length());
//            s = s.substring(0, 2)+"-"+s.substring(2, 4)+"-"+String.valueOf(Integer.parseInt(year)-543);
            s = s.substring(0, 2)+"-"+s.substring(2, 4)+"-"+String.valueOf(year);
        }else if(format.equals("hh:mm")){
            s = s;
        }else if(format.equals("dd MMMMM yyyy")){
            s = s;
        }
        return s;
    }
    public String getDateDB(String format) {
//        Format formatter = new SimpleDateFormat(format);
//        java.util.Date date1 = new java.util.Date();
        String s ="";
        String sql="Select current_date as current_date ";
        try {
            Connection conn = getConnectionBangna();
            Statement st = conn.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);
            while(rs.next()) {
                s=rs.getString("current_date");
            }
            rs.close();
            conn.close();
            if(format.equals("yyyy")){
                s=s.substring(0, 4);
            }else if(format.equals("MM")){
                s=s.substring(5, 7);
            }else if(format.equals("dd")){
                s=s.substring(9);
            }else if(format.equals("MMddyyyy")){
                s=s.substring(5,7)+"-"+s.substring(8)+"-"+s.substring(0, 4);
            }else if(format.equals("ddMMyyyy")){
                s=s.substring(8)+"-"+s.substring(5,7)+"-"+s.substring(0, 4);
            }else if(format.equals("yyyyMMdd")){
//                s=s.substring(5,7)+"-"+s.substring(8)+"-"+s.substring(0, 4);
                s=s;
            }
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    public String getTimeDB(String format) {
//        Format formatter = new SimpleDateFormat(format);
//        java.util.Date date1 = new java.util.Date();
        String s ="";
        String date_current="",year="", sql="Select current_time as current_time ";
        try {
            Connection conn = getConnectionBangna();
            Statement st = conn.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);
            while(rs.next()) {
                s=rs.getString("current_time");
            }
            rs.close();
            conn.close();
            s=s.substring(0, 8);
            if(format.equals("hh")){
                s = s.substring(0,2);
            }else if(format.equals("mm")){
                s = s.substring(3, 4);
            }else if(format.equals("ss")){
                s = s.substring(6, 7);
            }else if(format.equals("hhmmss")){
                s = s.replaceAll(":", "");
            }
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    public String getDateDBHospital(String format) {
//        Format formatter = new SimpleDateFormat(format);
//        java.util.Date date1 = new java.util.Date();
        String s ="",year="", month="", day="", time="";
        String date_current="", sql="Select current_date as current_date, current_time as current_time ";
        try {
            Connection conn = getConnectionBangna();
            Statement st = conn.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);
            while(rs.next()) {
                s=rs.getString("current_date");
                time=rs.getString("current_time");
            }
            rs.close();
            conn.close();
            year = s.substring(0, 4);
            year = String.valueOf(Integer.parseInt(year)+543);
            month = s.substring(5, 7);
            day = s.substring(8);
            s = year+s.substring(4);
            if(format.equals("yyyy")) {
                s=year;
            }else if(format.equals("MM")) {
                s=s.substring(5, 7);
            }else if(format.equals("dd")) {
                s=s.substring(9);
            }else if(format.equals("dd MMMM yyyy")) {
                s=day+" "+getMonthNamet(month,"id_namet")+" "+year;
            }else if(format.equals("ddMMyyyy")) {
                s=day+"-"+month+"-"+year;
            }else if(format.equals("yyyyMMdd")) {
                s=year+"-"+month+"-"+day;
            }else if(format.equals("yyyyMMdd hh:mm:ss")) {
                if(time.length()>=8) time = time.substring(0, 8);
                s=year+"-"+month+"-"+day+","+time;
            }

        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    public String getDateDBTavon(String format) {
//        Format formatter = new SimpleDateFormat(format);
//        java.util.Date date1 = new java.util.Date();
        String s ="",year="", month="", day="", time="";
        String date_current="", sql="Select current_date as current_date, current_time as current_time ";
        try {
            Connection conn = getConnectionBangna();
            Statement st = conn.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);
            while(rs.next()) {
                s=rs.getString("current_date");
                time=rs.getString("current_time");
            }
            rs.close();
            conn.close();
            year = s.substring(0, 4);
            year = String.valueOf(Integer.parseInt(year)-543);
            month = s.substring(5, 7);
            day = s.substring(8);
            s = year+s.substring(4);
            if(format.equals("yyyy")) {
                s=year;
            }else if(format.equals("MM")) {
                s=s.substring(5, 7);
            }else if(format.equals("dd")) {
                s=s.substring(9);
            }else if(format.equals("dd MMMM yyyy")) {
                s=day+" "+getMonthNamet(month,"id_namet")+" "+year;
            }else if(format.equals("ddMMyyyy")) {
                s=day+"-"+month+"-"+year;
            }else if(format.equals("yyyyMMdd")) {
                s=year+"-"+month+"-"+day;
            }else if(format.equals("yyyyMMdd hh:mm:ss")) {
                if(time.length()>=8) time = time.substring(0, 8);
                s=year+"-"+month+"-"+day+","+time;
            }

        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    public String getDateDiffDB(String diff,String format) {
//        Format formatter = new SimpleDateFormat(format);
//        java.util.Date date1 = new java.util.Date();
        String s ="",year="", month="", day="";
        String date_current="", sql="";
        try {
            if((diff.indexOf("-")>=0) && (!format.equals("minus"))){
                sql="Select current_date "+diff+" as current_date ";
            }else if(format.equals("minus")){
                sql="Select current_date - "+diff+" as current_date ";
            }else{
                sql="Select current_date +"+diff+" as current_date ";
            }
            Connection conn = getConnectionBangna();
            Statement st = conn.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);
            while(rs.next()) {
                s=rs.getString("current_date");
            }
            rs.close();
            conn.close();
            year = s.substring(0, 4);
//            year = String.valueOf(Integer.parseInt(year)+543);
            month = s.substring(5, 7);
            day = s.substring(8);
            s = year+s.substring(4);
            if(format.equals("yyyy")) {
                s=year;
            }else if(format.equals("MM")) {
                s=s.substring(6, 8);
            }else if(format.equals("dd")) {
                s=s.substring(9);
            }else if(format.equals("dd MMMM yyyy")) {
                s=day+" "+getMonthNamet(month,"id_namet")+" "+year;
            }else if(format.equals("ddMMyyyy")) {
                s=day+"-"+month+"-"+year;
            }else if(format.equals("ddMMyy")) {
                year = String.valueOf(Integer.parseInt(year)+543);
                year = year.substring(2);
                s=day+"."+month+"."+year;
            }else if(format.equals("ddMM")) {
                s=day+"."+month;
            }
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    public String getMonthEndDay(String year, String month){
        String daymonth="";
        if(month.equals("01")){
            daymonth="31";
        }
        else if(month.equals("02")){
            daymonth = getDateDiffN(year+"-03-01","-1");
            if(daymonth.length()>=10) daymonth = daymonth.substring(0, 10);
        }
        else if(month.equals("03")){
            daymonth="31";
        }
        else if(month.equals("04")){
            daymonth="30";
        }
        else if(month.equals("05")){
            daymonth="31";
        }
        else if(month.equals("06")){
            daymonth="30";
        }
        else if(month.equals("07")){
            daymonth="31";
        }
        else if(month.equals("08")){
            daymonth="31";
        }
        else if(month.equals("09")){
            daymonth="30";
        }
        else if(month.equals("10")){
            daymonth="31";
        }
        else if(month.equals("11")){
            daymonth="30";
        }
        else if(month.equals("12")){
            daymonth="31";
        }
        return  daymonth;
    }
    public String getPeriodNamet(String period, String flag) {
        String txt="";
        if(flag.equals("name_id")){
            if(period.equals("งวดต้นเดือน")){
                txt = "1";
            }else{
                txt = "2";
            }
        }
        else{
            if(period.equals("1")){
                txt = "งวดต้นเดือน";
            }else{
                txt = "งวดกลางเดือน";
            }
        }
        return txt;
    }
    public String getMonthNamet(String monthName, String aFlag){
        String month="";
        if(aFlag.equals("name_id")){
            if(monthName.equals("มกราคม")){
                month="01";
            }else if(monthName.equals("กุมภาพันธ์")){
                month="02";
            }else if(monthName.equals("มีนาคม")){
                month="03";
            }else if(monthName.equals("เมษายน")){
                month="04";
            }else if(monthName.equals("พฤษภาคม")){
                month="05";
            }else if(monthName.equals("มิถุนายน")){
                month="06";
            }else if(monthName.equals("กรกฏาคม")){
                month="07";
            }else if(monthName.equals("สิงหาคม")){
                month="08";
            }else if(monthName.equals("กันยายน")){
                month="09";
            }else if(monthName.equals("ตุลาคม")){
                month="10";
            }
            else if(monthName.equals("พฤศจิกายน")){
                month="11";
            }
            else if(monthName.equals("ธันวาคม")){
                month="12";
            }
            else{
                month="01";
            }
        }else {
            if(monthName.equals("01")){
                month="มกราคม";
            }
            else if(monthName.equals("02")){
                month="กุมภาพันธ์";
            }
            else if(monthName.equals("03")){
                month="มีนาคม";
            }
            else if(monthName.equals("04")){
                month="เมษายน";
            }
            else if(monthName.equals("05")){
                month="พฤษภาคม";
            }
            else if(monthName.equals("06")){
                month="มิถุนายน";
            }
            else if(monthName.equals("07")){
                month="กรกฏาคม";
            }
            else if(monthName.equals("08")){
                month="สิงหาคม";
            }
            else if(monthName.equals("09")){
                month="กันยายน";
            }
            else if(monthName.equals("10")){
                month="ตุลาคม";
            }
            else if(monthName.equals("11")){
                month="พฤศจิกายน";
            }
            else if(monthName.equals("12")){
                month="ธันวาคม";
            }
            else{
                month="01";
            }
        }

        return month;
    }
    public Patient getPatientFullNamet(String branch_id, String patient_hn_no, String flag){
        String sql="", patient_full_namet="";
        Connection conn;
        Patient patient = new Patient();
        try {
            //conn = getConnectionBangna();
            
            Statement st;
            ResultSet rs;
            //sql="Select branch_namet as col1, branch_id as id From b_branch ";
            if(flag.equals("hospital_osv3")){
                conn = getConnectionHospital(branch_id);
                sql="Select fpp.patient_prefix_description, " +
                        "tp.patient_firstname, tp.patient_lastname , visit_patient_age,tp.f_sex_id,tp.patient_phone_number, "
                        + "sex_description, patient_hn " +
                        "From t_patient tp " +
                        "left join f_patient_prefix fpp on tp.f_patient_prefix_id = fpp.f_patient_prefix_id "
                        + "left join t_visit on tp.patient_hn = t_visit.visit_hn "
                        + "left join f_sex on f_sex.f_sex_id = tp.f_sex_id " +
                        "Where t_visit.visit_vn = '"+patient_hn_no+"' ";
            }else{
                conn = getConnectionMainHIS(branch_id);
                sql="Select pm02.mnc_pfix_dsc, pm01.mnc_fname_t,pm01.mnc_lname_t, "
                +"pm01.mnc_id_no, pm01.mnc_sex, pm01.mnc_bday,datediff(year,pm01.mnc_bday,getdate()) as age, "
                +"isnull(pm01.mnc_nat_cd,'') as mnc_nat_cd, isnull(pm01.mnc_blo_grp,'') as mnc_blo_grp, "
                +"isnull(pm01.mnc_blo_grp,'') as mnc_blo_grp, isnull(pm01.mnc_dom_chw,'') as mnc_dom_chw, "
                +"pm01.mnc_cur_add, pm01.mnc_cur_tel, pm01.mnc_cur_poc, "
                +"pm08.MNC_AMP_DSC, pm07.MNC_TUM_DSC, pm09.MNC_CHW_DSC "
                +"From patient_m01 pm01 inner join patient_m02 pm02 on pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd "
                +"left join patient_m08 pm08 on pm01.MNC_CUR_AMP = pm08.MNC_AMP_CD "
                +"left join patient_m07 pm07 on pm01.MNC_CUR_TUM = pm07.MNC_TUM_CD "
                +"left join patient_m09 pm09 on pm01.MNC_CUR_CHW = pm09.MNC_CHW_CD "
                +"Where pm01.mnc_hn_no = '"+patient_hn_no+"'";
            }
            
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                //acombo.addItem(rs.getString("col1"));
                patient = new Patient();
                if(flag.equals("hospital_osv3")){

                    patient.setPatientPrefix(rs.getString("patient_prefix_description"));
                    patient.setPatientNamet(rs.getString("patient_firstname"));
                    patient.setPatientLastNamet(rs.getString("patient_lastname"));
                    patient.setPatientSex(rs.getString("sex_description"));
                    patient.setPatientAge(rs.getString("visit_patient_age"));
                    patient.setPatientChangwat(rs.getString("patient_phone_number"));
                    patient.setPatientHn(rs.getString("patient_hn"));
                }else{
                    patient.setPatientNamet(rs.getString("mnc_fname_t"));
                    patient.setPatientLastNamet(rs.getString("mnc_lname_t"));
                    if(rs.getString("mnc_pfix_dsc").equals("���")){
                        patient.setPatientPrefix("003");
                    }
                    else if(rs.getString("mnc_pfix_dsc").equals("�ҧ")){
                        patient.setPatientPrefix("005");
                    }else if(rs.getString("mnc_pfix_dsc").equals("�ҧ���")){
                        patient.setPatientPrefix("004");
                    }else{
                        patient.setPatientPrefix("000");
                    }

                    patient.setPatientId(rs.getString("mnc_id_no"));
                    if(rs.getString("mnc_sex").equals("M")){
                        patient.setPatientSex("1");
                    }else{
                        patient.setPatientSex("2");
                    }
                    patient.setPatientBirthday(DateFormatDB2Show(rs.getString("mnc_bday"),"ddMMyyyy"));
                    patient.setPatientAge(rs.getString("age"));
                    if(rs.getString("mnc_nat_cd").equals("10")){
                        patient.setPatientNationId("99");
                    }else{
                        patient.setPatientNationId("99");
                    }
                    patient.setPatientChangwat(rs.getString("mnc_dom_chw"));
                }
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patient;
    }
    public String getPaidName(String branch_id,String paid_id){
        String paid_name="", sql="";
        Connection conn;
        try {
            conn = getConnectionHospital(branch_id);
            sql="Select contract_plans_description " +
                    "From b_contract_plans " +
                    "Where b_contract_plans_id = '"+paid_id+"' ";
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                paid_name = rs.getString("contract_plans_description");
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
            paid_id = ex.getMessage();
        }
        return paid_name;
    }
    public String getPatientFullNamet(String branch_id, String patient_hn_no) {
        String sql="", patient_full_namet="";
        Connection conn;
        try {
            //conn = getConnectionBangna();
            branch = getBranch(branch_id);
            if(branch.branchProgram.equals("hospital_osv3")){
                conn = getConnectionHospital(branch_id);
                sql="Select fpp.patient_prefix_description || ' ' || " +
                        "tp.patient_firstname || ' ' || tp.patient_lastname as fullnamet " +
                        "From t_patient tp " +
                        "left join f_patient_prefix fpp on tp.f_patient_prefix_id = fpp.f_patient_prefix_id " +
                        "Where tp.patient_hn = '"+patient_hn_no+"' ";
            }else{
                conn = getConnectionMainHIS(branch_id);
                sql="Select pm02.mnc_pfix_dsc + ' ' + pm01.mnc_fname_t + ' ' + pm01.mnc_lname_t as fullnamet "
                +"From patient_m01 pm01 inner join patient_m02 pm02 on pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd "
                +"Where pm01.mnc_hn_no = '"+patient_hn_no+"'";
            }
            
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                //acombo.addItem(rs.getString("col1"));
                patient_full_namet = rs.getString("fullnamet");
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
            patient_full_namet = ex.getMessage();
        }
        return patient_full_namet;
    }
    public String getEmployeeFullNamet(String branch_id, String employee_hn_no) {
        String sql="", employee_full_namet="";
        Connection conn;
        try {
            //conn = getConnectionBangna();
            branch = getBranch(branch_id);
            if(branch.getBranchProgram().equals("hospital_osv3")) {
                conn = getConnectionHospital(branch_id);
                sql="Select b_employee.employee_login as mnc_hr_no, b_employee.employee_firstname || ' ' || b_employee.employee_lastname as fullname " +
                "From b_employee " +
                "Where b_employee.employee_login = '"+employee_hn_no+"'";
            }else {
                conn = getConnectionMainHIS(branch_id);
                sql="Select mnc_hr_no, mnc_hr_fname_t + ' ' + mnc_hr_lname_t as fullname "
                +"From human_m01 "
                +"Where mnc_hr_no = '"+employee_hn_no+"' "
                +"Order by mnc_hr_fname_t, mnc_hr_lname_t";
            }
            Statement st;
            ResultSet rs;
            //sql="Select branch_namet as col1, branch_id as id From b_branch ";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                //acombo.addItem(rs.getString("col1"));
                employee_full_namet = rs.getString("fullname");
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee_full_namet;
    }
    public Doctor getDoctorFullNamet(String branch_id,String doctor_id) {
        String sql="", patient_full_namet="";
        Connection conn;
        Vector v_doctor = new Vector();
        Doctor doctor = new Doctor();
        try {
            //conn = getConnectionBangna();
            branch = getBranch(branch_id);
            if(branch.getBranchProgram().equals("hospital_osv3")) {
                sql="Select b_employee.employee_number as mnc_dot_cd, b_employee.employee_firstname as mnc_dot_fname," +
                "b_employee.employee_lastname as mnc_dot_lname, employee_firstnamee as mnc_dot_fname_e, employee_lastnamee as mnc_dot_lname_e"
                + ", '' as mnc_pfix_dsc, doctor_lying "
                +"From b_employee " +
                "Where f_employee_authentication_id = '3' and b_employee.employee_number = '"+doctor_id+"'";
                conn = getConnectionHospital(branch_id);
            }else{
                sql="Select mnc_dot_cd,pm02.mnc_pfix_dsc, pm26.mnc_dot_fname, pm26.mnc_dot_lname, "
                +"pm26.mnc_dot_fname_e,pm26.mnc_dot_lname_e, '' as doctor_lying"
                +"From patient_m26 pm26 inner join patient_m02 pm02 on pm26.mnc_dot_pfix = pm02.mnc_pfix_cd "
                +"Where pm26.mnc_dot_cd = '"+doctor_id+"'";
                conn = getConnectionMainHIS(branch_id);
            }
            Statement st;
            ResultSet rs;
            //sql="Select branch_namet as col1, branch_id as id From b_branch ";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                doctor = new Doctor();
                doctor.setDoctorId(rs.getString("mnc_dot_cd"));
                doctor.setDoctorNamet(rs.getString("mnc_dot_fname"));
                doctor.setDoctorLastNamet(rs.getString("mnc_dot_lname"));
                doctor.setDoctorNamee(rs.getString("mnc_dot_fname_e"));
                doctor.setDoctorLastNamee(rs.getString("mnc_dot_lname_e"));
                doctor.setDoctorPrefix(rs.getString("mnc_pfix_dsc"));
                doctor.doctorLying = rs.getString("doctor_lying");
//                v_doctor.add(doctor);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doctor;
    }
    
    public Doctor getDoctorFullNametXray(String branch_id,String doctor_id) {
        String sql="", patient_full_namet="";
        Connection conn;
        Vector v_doctor = new Vector();
        Doctor doctor = new Doctor();
        try {
            //conn = getConnectionBangna();
            branch = getBranch(branch_id);
            if(branch.getBranchProgram().equals("hospital_osv3")) {
                sql="Select b_employee.employee_number as mnc_dot_cd, b_employee.employee_firstname as mnc_dot_fname," +
                "b_employee.employee_lastname as mnc_dot_lname, '' as  mnc_dot_fname_e, '' as mnc_dot_lname_e, '' as mnc_pfix_dsc "
                +"From b_employee " +
                "Where b_employee.employee_number = '"+doctor_id+"'";
                conn = getConnectionHospital(branch_id);
            }else{
                sql="Select mnc_dot_cd,pm02.mnc_pfix_dsc, pm26.mnc_dot_fname, pm26.mnc_dot_lname, "
                +"pm26.mnc_dot_fname_e,pm26.mnc_dot_lname_e"
                +"From patient_m26 pm26 inner join patient_m02 pm02 on pm26.mnc_dot_pfix = pm02.mnc_pfix_cd "
                +"Where pm26.mnc_dot_cd = '"+doctor_id+"'";
                conn = getConnectionMainHIS(branch_id);
            }
            Statement st;
            ResultSet rs;
            //sql="Select branch_namet as col1, branch_id as id From b_branch ";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                doctor = new Doctor();
                doctor.setDoctorId(rs.getString("mnc_dot_cd"));
                doctor.setDoctorNamet(rs.getString("mnc_dot_fname"));
                doctor.setDoctorLastNamet(rs.getString("mnc_dot_lname"));
                doctor.setDoctorNamee(rs.getString("mnc_dot_fname_e"));
                doctor.setDoctorLastNamee(rs.getString("mnc_dot_lname_e"));
                doctor.setDoctorPrefix(rs.getString("mnc_pfix_dsc"));
//                v_doctor.add(doctor);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doctor;
    }
    public Vector getDoctorFullNamet(String branch_id) {
        String sql="", patient_full_namet="";
        Connection conn;
        Vector v_doctor = new Vector();
        Doctor doctor = new Doctor();
        try {
            //conn = getConnectionBangna();
            branch = getBranch(branch_id);
            if(branch.getBranchProgram().equals("hospital_osv3")) {
                sql="Select b_employee.employee_number as mnc_dot_cd, b_employee.employee_firstname || '  ' || b_employee.employee_lastname as fullnamet "
                +"From b_employee " +
                "Where f_employee_authentication_id = '3' "
                + "Order By fullnamet";
                conn = getConnectionHospital(branch_id);
            }else{
                sql="Select mnc_dot_cd,pm02.mnc_pfix_dsc + ' ' + pm26.mnc_dot_fname + ' ' + pm26.mnc_dot_lname as fullnamet "
                +"From patient_m26 pm26 inner join patient_m02 pm02 on pm26.mnc_dot_pfix = pm02.mnc_pfix_cd";
                conn = getConnectionMainHIS(branch_id);
            }
            Statement st;
            ResultSet rs;
            //sql="Select branch_namet as col1, branch_id as id From b_branch ";
            
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                doctor = new Doctor();
                doctor.setDoctorId(rs.getString("mnc_dot_cd"));
                doctor.setDoctorNamet(rs.getString("fullnamet"));
                v_doctor.add(doctor);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_doctor;
    }
    public Vector getDoctorFullNametFront(String branch_id) {
        String sql="", patient_full_namet="";
        Connection conn;
        Vector v_doctor = new Vector();
        Doctor doctor = new Doctor();
        try {
            //conn = getConnectionBangna();
            branch = getBranch(branch_id);
            if(branch.getBranchProgram().equals("hospital_osv3")) {
                sql="Select b_employee.employee_number as mnc_dot_cd, b_employee.employee_firstname || '  ' || b_employee.employee_lastname as fullnamet "
                +"From b_employee " +
                "Where f_employee_authentication_id = '3' and status_employee = '1' "
                + "Order By fullnamet";// ดึงมาแต่แพทย์ ไม่เอาคณะบุคคล
                conn = getConnectionHospital(branch_id);
            }else{
                sql="Select mnc_dot_cd,pm02.mnc_pfix_dsc + ' ' + pm26.mnc_dot_fname + ' ' + pm26.mnc_dot_lname as fullnamet "
                +"From patient_m26 pm26 inner join patient_m02 pm02 on pm26.mnc_dot_pfix = pm02.mnc_pfix_cd";
                conn = getConnectionMainHIS(branch_id);
            }
            Statement st;
            ResultSet rs;
            //sql="Select branch_namet as col1, branch_id as id From b_branch ";
            
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                doctor = new Doctor();
                doctor.setDoctorId(rs.getString("mnc_dot_cd"));
                doctor.setDoctorNamet(rs.getString("fullnamet"));
                v_doctor.add(doctor);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_doctor;
    }
    public String getTRDoctorFullNamet(String branch_id, String selected){
        String sql="", txt="", select="";
        Vector v_doctor;
        v_doctor = getDoctorFullNamet(branch_id);
        txt += "<option value='' ></option>";
        for(int i=0;i<=v_doctor.size()-1;i++){
            doctor = new Doctor();
            doctor = (Doctor)v_doctor.get(i);
            select="";
            if(select.equals(doctor.getDoctorId())){
                select="selected";
            }
            txt += "<option value='"+doctor.getDoctorId()+"' "+select+">"+doctor.getDoctorNamet()+"</option>";
        }
        return txt;
    }
    public String getComboDoctorFullNamet(String branch_id, String selected){
        String sql="", txt="", select="";
        Vector v_doctor;
        v_doctor = getDoctorFullNamet(branch_id);
        txt += "<option value='' ></option>";
        for(int i=0;i<=v_doctor.size()-1;i++){
            doctor = new Doctor();
            doctor = (Doctor)v_doctor.get(i);
            select="";
            if(doctor.getDoctorId().equals(selected)){
                txt += "<option value='"+doctor.getDoctorId()+"' selected>"+doctor.getDoctorNamet()+"</option>";
            }else{
                txt += "<option value='"+doctor.getDoctorId()+"'>"+doctor.getDoctorNamet()+"</option>";
            }
        }
        return txt;
    }
    public String getComboDoctorFullNametFront(String branch_id, String selected){
        String sql="", txt="", select="";
        Vector v_doctor;
        v_doctor = getDoctorFullNametFront(branch_id);
        txt += "<option value='' ></option>";
        for(int i=0;i<=v_doctor.size()-1;i++){
            doctor = new Doctor();
            doctor = (Doctor)v_doctor.get(i);
            select="";
            if(doctor.getDoctorId().equals(selected)){
                txt += "<option value='"+doctor.getDoctorId()+"' selected>"+doctor.getDoctorNamet()+"</option>";
            }else{
                txt += "<option value='"+doctor.getDoctorId()+"'>"+doctor.getDoctorNamet()+"</option>";
            }
        }
        return txt;
    }
    public BItem getBItem1(String branch_id, String b_item_id) {
        String sql="";
        Connection conn;
//        Vector v_doctor = new Vector();
        try {
            //conn = getConnectionBangna();
            branch = getBranch(branch_id);
            sql="Select bi.*,bip.item_price "+
            "From "+b_item.getBItem()+" as bi " +
            "left join b_item_price bip on bi."+b_item.getFBItemId()+" = bip.b_item_id "+
            "Where bi."+b_item.getFItemNumber()+" = '"+b_item_id+"' " +
            "Order By bi."+b_item.getFItemCommonName();
            conn = getConnectionHospital(branch_id);
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                b_item = new BItem();
                b_item.setBItemId(rs.getString(b_item.getFBItemId()));
                b_item.setItemNumber(rs.getString(b_item.getFItemNumber()));
                b_item.setItemCommonName(rs.getString(b_item.getFItemCommonName()));
                b_item.setItemActive(rs.getString(b_item.getFItemActive()));
                b_item.setItemDescriptione(rs.getString(b_item.getFItemDescriptione()));

                b_item.setItemPriceCost(0.0);
                b_item.setItemPriceSale(Double.parseDouble(rs.getString("item_price")));
                b_item.setItemStatusDoctor(rs.getString(b_item.getFItemStatusDoctor()));
                b_item.setItemTradeName(rs.getString(b_item.getFItemTradName()));
                b_item.itemSpecified = StringNull(rs.getString(""));

            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b_item;
    }
    public BItem getBItemByBItemId(String branch_id, String b_item_id) {
        String sql="";
        Connection conn;
//        Vector v_doctor = new Vector();
        try {
            //conn = getConnectionBangna();
            branch = getBranch(branch_id);
            sql="Select bi.*,bip.item_price "+
            "From "+b_item.getBItem()+" as bi " +
            "left join b_item_price bip on bi."+b_item.getFBItemId()+" = bip.b_item_id "+
            "Where bi."+b_item.getFBItemId()+" = '"+b_item_id+"' " +
            "Order By bi."+b_item.getFItemCommonName();
            conn = getConnectionHospital(branch_id);
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                b_item = new BItem();
                b_item.setBItemId(rs.getString(b_item.getFBItemId()));
                b_item.setItemNumber(rs.getString(b_item.getFItemNumber()));
                b_item.setItemCommonName(rs.getString(b_item.getFItemCommonName()));
                b_item.setItemActive(rs.getString(b_item.getFItemActive()));
                b_item.setItemDescriptione(rs.getString(b_item.getFItemDescriptione()));

                b_item.setItemPriceCost(0.0);
                b_item.setItemPriceSale(Double.parseDouble(rs.getString("item_price")));
                b_item.setItemStatusDoctor(rs.getString(b_item.getFItemStatusDoctor()));
                b_item.setItemTradeName(rs.getString(b_item.getFItemTradName()));
                b_item.itemSpecified = StringNull(rs.getString(""));

            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b_item;
    }
    public String getAddressEnglish(String branch_id) {
        String sql="", txt="";
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = getConnectionBangna();
            st = conn.createStatement();
            sql = "Select "+branch.getFBranchAddressEnglish()+" "
                    +"From "+branch.getBBranch()+" "
                    +"Where "+branch.getFBranchId()+"='"+branch_id+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                txt = rs.getString(branch.getFBranchAddressEnglish());
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return txt;
    }    
    public Vector getContactType(String branch_id) {
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
//        Ward ward = new Ward();
        try {
            conn = getConnectionBangna();
//            conn = getConnectionBangna();
            st = conn.createStatement();
            sql = "Select "+ct.getFContactTypeId()+", "+ct.getFContactTypeNamet()+" "
                    +"From "+ct.getBContactType()+" "
                    +"Where "+ct.getFContactActive()+" = '1' ";
            rs = st.executeQuery(sql);
            while(rs.next()){
                ct = new BContactType();
                ct.setContactTypeId(rs.getString(ct.getFContactTypeId()));
                ct.setContactTypeNamet(rs.getString(ct.getFContactTypeNamet()));
                v_result.add(ct);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getComboContactType(String branch_id, String selected){
        String txt="",sql="";
        Vector v_contact_type = new Vector();
//        Ward ward = new Ward();
        v_contact_type = getContactType(branch_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_contact_type.size()-1;i++) {
            ct = (BContactType) v_contact_type.get(i);
            if(ct.getContactTypeId().equals(selected)) {
                txt += "<option value='"+ct.getContactTypeId()+"' selected>"+ct.getContactTypeNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else {
                txt += "<option value='"+ct.getContactTypeId()+"' >"+ct.getContactTypeNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4) {
                sql="";
            }
        }
        return txt;
    }
    public Vector getBItem(String branch_id, String where){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        //TypeFoods typefoods = new TypeFoods();
        BItem b_item = new BItem();
        try {
//            conn = getConnectionMainHIS(branch_id);
            conn = getConnectionHospital(branch_id);
            st = conn.createStatement();
            if(where.equals("")) {
                sql = "Select bi.*, bip.item_price, bip.item_price_cost " +
                    "From "+b_item.getBItem()+" as bi " +
                    "left join b_item_price bip on bi."+b_item.getFBItemId()+" = bip.b_item_id "+
                    " Where bi."+b_item.getFItemActive()+"='1' "+
                    "Order By bi."+b_item.getFItemCommonName();
            }else {
                sql = "Select bi.*, bip.item_price, bip.item_price_cost " +
                    "From "+b_item.getBItem()+" as bi " +
                    "left join b_item_price bip on bi."+b_item.getFBItemId()+" = bip.b_item_id "+
                    " Where bi."+b_item.getFItemActive()+"='1' and bi."+b_item.getFItemCommonName()+" like '%"+where+"%'"+
                    "Order By bi."+b_item.getFItemCommonName();
            }
            
            rs = st.executeQuery(sql);
            while(rs.next()){
                b_item = new BItem();
                b_item.setBItemId(rs.getString(b_item.getFBItemId()));
                b_item.setItemNumber(rs.getString(b_item.getFItemNumber()));
                if(rs.getString("item_price")!=null){
                    b_item.setItemPriceSale(Double.parseDouble(rs.getString("item_price")));
                }
                if(rs.getString("item_price_cost")!=null){
                    b_item.setItemPriceCost(Double.parseDouble(rs.getString("item_price_cost")));
                }
                b_item.setItemTradeName(rs.getString(b_item.getFItemTradName()));
                b_item.setItemCommonName(rs.getString(b_item.getFItemCommonName()));
                v_result.add(b_item);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getCloseDayId(String close_day_date){
        String sql="", txt="", date="";
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            date =  String.valueOf(Integer.parseInt(close_day_date.substring(0, 4))-543)+ close_day_date.substring(4);
            conn = getConnectionBangna();
            st = conn.createStatement();
            sql = "Select close_day_id "
                    +"From cashier_t_close_day "
                    +"Where close_day_date = '"+date+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                txt+="'"+rs.getString("close_day_id")+"',";
            }
            txt = txt.substring(0, txt.length()-1);
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return txt;
    }
    public Vector getPatientVisit(String branch_id, String visit_date, String dep_id, String patient_hn) {
    Vector v_patient_visit = new Vector();
    String time = "";
    String sql = " ", visitDate="";
    PatientVisit patient_visit = new PatientVisit();
    try {
      this.branch = getBranch(branch_id);
      Connection connmainhis;
      visitDate = visit_date;
      if(visitDate.length()>=10){
          if(Integer.parseInt(visit_date.substring(0,4))<=2500){
              visitDate = DateFormatDB2ShowHospital(visit_date,"ddMMyyyy");
              visitDate = DateFormatShow2DB(visitDate,"ddMMyyyy");
          }
      }
      if (this.branch.getBranchProgram().equals("hospital_osv3")) {
        connmainhis = getConnectionHospital(branch_id);
        sql = "Select tp.patient_firstname, tp.patient_lastname, tp.patient_hn, tv.visit_vn, "
                + "tv.t_visit_id,substring(tv.visit_begin_visit_time,1,10) as visit_begin_visit_time "
                + "From t_patient tp left join t_visit tv on tv.t_patient_id = tp.t_patient_id "
                + "Where tp.patient_hn = '" + patient_hn + "' and substring(tv.visit_begin_visit_time,1,10) = '" + visitDate + "' ";
      }else{
        sql = "Select pt01.*, pm02.mnc_pfix_dsc,pm01.mnc_fname_t,pm01.mnc_lname_t, pmm02.mnc_pfix_dsc, "
                + "pm26.mnc_dot_fname,pm26.mnc_dot_lname, fm02.mnc_fn_typ_dsc "
                + "From patient_t01 pt01 "
                + "inner join patient_m01 pm01 on pt01.mnc_hn_no = pm01.mnc_hn_no and pt01.mnc_hn_yr = pm01.mnc_hn_yr "
                + "inner join patient_m02 pm02 on pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd "
                + "inner join patient_m26 pm26 on pt01.mnc_dot_cd = pm26.mnc_dot_cd "
                + "inner join patient_m02 pmm02 on pm26.mnc_dot_pfix = pmm02.mnc_pfix_cd "
                + "inner join finance_m02 fm02 on pt01.mnc_fn_typ_cd = fm02.mnc_fn_typ_cd "
                + "Where pt01.mnc_date = '" + visit_date + "' and pt01.mnc_hn_no = '" + patient_hn + "' and pt01.mnc_sts <> 'C' "
                + "Order By pt01.mnc_date, pt01.mnc_time ";
        connmainhis = getConnectionMainHIS(branch_id);
      }
      Statement stmainhis = connmainhis.createStatement();
      ResultSet rsmainhis = stmainhis.executeQuery(sql);
      while (rsmainhis.next()) {
        patient_visit = new PatientVisit();
        if (this.branch.getBranchProgram().equals("hospital_osv3")) {
          patient_visit.setPatientId(rsmainhis.getString("patient_hn"));
          patient_visit.setPatientNamet(rsmainhis.getString("patient_firstname"));
          patient_visit.setPatientLastNamet(rsmainhis.getString("patient_lastname"));
          patient_visit.setVisitDate(rsmainhis.getString("visit_begin_visit_time"));
          patient_visit.setVisitVn(rsmainhis.getString("visit_vn"));
          patient_visit.setTVisitId(rsmainhis.getString("t_visit_id"));
        } else {
          patient_visit.setPatientId(rsmainhis.getString("mnc_hn_no"));
          patient_visit.setPatientNamet(rsmainhis.getString("mnc_fname_t"));
          patient_visit.setPatientLastNamet(rsmainhis.getString("mnc_lname_t"));
          patient_visit.setVisitDate(rsmainhis.getString("mnc_date"));
          patient_visit.setVisitTime(time);
          patient_visit.setVisitVn(rsmainhis.getString("mnc_vn_no") + "." + rsmainhis.getString("mnc_vn_seq"));
          patient_visit.setVisitDoctorId(rsmainhis.getString("mnc_dot_cd"));
          patient_visit.setVisitDoctorNamet(rsmainhis.getString("mnc_dot_fname"));
          patient_visit.setVisitPaidId(rsmainhis.getString("mnc_fn_typ_cd"));
          patient_visit.setVisitPaidNamet(rsmainhis.getString("mnc_fn_typ_dsc"));
        }
        v_patient_visit.add(patient_visit);
      }
      rsmainhis.close();
      connmainhis.close();
    }
    catch (Exception ex) {
      Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
    }
    return v_patient_visit;
  }
    public Vector getPatientVisit(String branch_id, String visti_date, String dep_id){
        Vector v_patient_visit = new Vector();
        String time="", visit_date="";
        String sql="Select pt01.*, pm02.mnc_pfix_dsc+' '+pm01.mnc_fname_t +' '+ pm01.mnc_lname_t as patient_fullnamet, "
            +"pmm02.mnc_pfix_dsc+' ' +pm26.mnc_dot_fname +' '+pm26.mnc_dot_lname as doctor_fullnamet, "
            +"fm02.mnc_fn_typ_dsc "
            +"From patient_t01 pt01 inner join patient_m01 pm01 on pt01.mnc_hn_no = pm01.mnc_hn_no and "
            +"pt01.mnc_hn_yr = pm01.mnc_hn_yr inner join patient_m02 pm02 on "
            +"pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd inner join patient_m26 pm26 on "
            +"pt01.mnc_dot_cd = pm26.mnc_dot_cd inner join patient_m02 pmm02 on "
            +"pm26.mnc_dot_pfix = pmm02.mnc_pfix_cd inner join "
            +"finance_m02 fm02 on pt01.mnc_fn_typ_cd = fm02.mnc_fn_typ_cd "
            +"Where pt01.mnc_date = '"+visti_date+"' and pt01.MNC_DEP_NO = '"
            +dep_id+"' and pt01.mnc_sts <> 'C' "
            +"Order By pt01.mnc_date, pt01.mnc_time ";
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        PatientVisit patient_visit = new PatientVisit();
        try {
            connmainhis = getConnectionMainHIS(branch_id);
            stmainhis = connmainhis.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()) {
                time = "0000"+rsmainhis.getString("mnc_time");
                time = time.substring(time.length()-4, time.length());
                if(rsmainhis.getString("mnc_date").length()>=10){
                    visit_date = rsmainhis.getString("mnc_date").substring(0, 10);
                }else{
                    visit_date = rsmainhis.getString("mnc_date");
                }
                patient_visit = new PatientVisit();
                patient_visit.setPatientId(rsmainhis.getString("mnc_hn_no"));
                patient_visit.setPatientNamet(rsmainhis.getString("patient_fullnamet"));
                patient_visit.setVisitDate(visit_date);
                patient_visit.setVisitTime(time);
                patient_visit.setVisitVn(rsmainhis.getString("mnc_vn_no")+"."+rsmainhis.getString("mnc_vn_seq"));
                patient_visit.setVisitDoctorId(rsmainhis.getString("mnc_dot_cd"));
                patient_visit.setVisitDoctorNamet(rsmainhis.getString("doctor_fullnamet"));
                patient_visit.setVisitPaidId(rsmainhis.getString("mnc_fn_typ_cd"));
                patient_visit.setVisitPaidNamet(rsmainhis.getString("mnc_fn_typ_dsc"));
                patient_visit.setPatientHn(rsmainhis.getString("mnc_hn_no"));
                v_patient_visit.add(patient_visit);
            }
            rsmainhis.close();

            connmainhis.close();
        }
        catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_patient_visit;
    }
    public Vector getPatientVisit(BBranch branch, String visti_date_start, String visit_date_end, String dep_id, String flag) {
        Vector vPatientVisit = new Vector();
        Vector v_visit_paid = new Vector();
        String time="", visit_date="",sql="", discharge_date="",txt="", error="", pttype_search="", depSearch="";
        TVisit t_visit = new TVisit();
        Integer i=0;

        Connection connmainhis, conn_paid, connmainhis2;
        Statement stmainhis, st_paid, stMainHis2;
        ResultSet rsmainhis, rs_paid;
        PatientVisit pv = new PatientVisit();
        try {
//            branch = getBranch(branch_id);
            conn_paid = getConnectionBangna();
            st_paid = conn_paid.createStatement();
            if(branch.getBranchProgram().equals("hospital_osv3")) {
                connmainhis = getConnectionHospital(branch.getBranchId());
                connmainhis2 = getConnectionHospital(branch.getBranchId());
                if(flag.equals("period_date")) {
                    if(!dep_id.equals("")){
                        depSearch = " and bcp.contract_plans_number  = '"+dep_id+"' ";
                    }
            sql="Select fpp.patient_prefix_description || ' ' || tp.patient_firstname || ' ' || tp.patient_lastname as patient_fullnamet, " +
            "tv.visit_hn as mnc_hn_no, tv.visit_vn as mnc_vn_no, " +
            "substring(tv."+t_visit.getFVisitBeginVisitTime()+",0,11) as visit_date, substring(tv."+t_visit.getFVisitBeginVisitTime()+",12) as visit_time, " +
            "tv."+t_visit.getFVisitStaffDoctorDischarge()+" as mnc_dot_cd, visit_patient_age, " +
            "tv."+t_visit.getFVisitNotice()+", '' as doctor_fullnamet, " +
            "bcp.contract_plans_number, " +
            "contract_plans_description, case when tb.billing_patient_share is null then 0 else tb.billing_patient_share end, case when tb.billing_total is null then 0 else tb.billing_total end, case when tb.billing_deduct is null then 0 else tb.billing_deduct end, " +
            "tv.visit_financial_discharge_time,tv.b_service_point_id,tp.t_patient_id, tv.visit_hospital_service,tv.visit_diagnosis_notice, " +
            "tv.contact_id as MNC_COM_CD, tv.contact_namet as MNC_COM_DSC, tv.contact_join_id as visit_contact_join_id, tv.contact_join_namet as visit_contact_join_namet, " +
            "tv.surveillance_case_id,tp.contact_id,tp.contact_namet, tv.t_visit_id, tvp.t_visit_payment_id, " +
            "tb.billing_payer_share,tb.billing_patient_share, tv.f_visit_type_id,tbi.billing_invoice_payer_share," +
            "tbi.billing_invoice_patient_share,bcp.contract_plans_pttype,tv.t_visit_id, " +
            "case when bcp.contract_plans_pttype is null then '' else bcp.contract_plans_pttype end,tbi.close_day_id,tv.f_visit_type_id, tp.contact_join_id, tp.contact_join_namet, contract_payer_number, tv.visit_an "+
            "From t_billing_invoice tbi " +
            "left join "+t_visit.getTVisit() +" tv on tv.t_visit_id = tbi.t_visit_id AND tv.f_visit_status_id <> '4' and tbi.billing_invoice_active = '1'  " +
            "left join t_patient tp on tv.t_patient_id = tp.t_patient_id "+
            "left join f_patient_prefix fpp on tp.f_patient_prefix_id = fpp.f_patient_prefix_id " +
//            "LEFT JOIN t_diag_icd10 ON tv.t_visit_id::text = t_diag_icd10.diag_icd10_vn::text  and t_diag_icd10.diag_icd10_active = '1' and t_diag_icd10.f_diag_icd10_type_id = '1' " +
//            "left join b_employee be on t_diag_icd10.diag_icd10_staff_doctor  = be.b_employee_id " +
//            "left join b_visit_clinic bvc on t_diag_icd10.b_visit_clinic_id = bvc.b_visit_clinic_id " +
            "left join t_visit_payment tvp on tvp.t_visit_payment_id = tbi.t_payment_id  and tvp.visit_payment_active ='1' " +
            "left join b_contract_plans bcp on tvp.b_contract_plans_id = bcp.b_contract_plans_id " +
                    "left join b_contract_payer bcper on bcp.b_contract_payer_id = bcper.b_contract_payer_id " +
            "left join t_billing tb on tbi.t_billing_id = tb.t_billing_id  and tb.billing_active = '1' "+
            "Where substring(tv."+t_visit.getFVisitFinancialDischargeTime()+",0,11) >= '"+
            visti_date_start+"' and substring(tv."+t_visit.getFVisitFinancialDischargeTime()+",0,11) <= '"+visit_date_end+"' "+depSearch
                    + "Order By tv.visit_vn";
                }else if(flag.equals("period_date_muangsamut")){
                    if(!dep_id.equals("")){
                        pttype_search = " and bcp.contract_plans_pttype = '"+dep_id+"' ";
                    }
            sql="Select fpp.patient_prefix_description || ' ' || tp.patient_firstname || ' ' || tp.patient_lastname as patient_fullnamet, " +
    "tv.visit_hn as mnc_hn_no, tv.visit_vn as mnc_vn_no, " +
    "substring(tv."+t_visit.getFVisitBeginVisitTime()+",0,11) as visit_date, substring(tv."+t_visit.getFVisitBeginVisitTime()+",12) as visit_time, " +
    "tv."+t_visit.getFVisitStaffDoctorDischarge()+" as mnc_dot_cd, visit_patient_age, " +
    "tv."+t_visit.getFVisitNotice()+", '' as doctor_fullnamet, " +
    "bcp.contract_plans_number, " +
    "contract_plans_description, case when tb.billing_patient_share is null then 0 else tb.billing_patient_share end, case when tb.billing_total is null then 0 else tb.billing_total end, case when tb.billing_deduct is null then 0 else tb.billing_deduct end, " +
    "tv.visit_financial_discharge_time,tv.b_service_point_id,tp.t_patient_id, tv.visit_hospital_service,tv.visit_diagnosis_notice, " +
    "tv.contact_id as MNC_COM_CD, tv.contact_namet as MNC_COM_DSC, "
    + "case tv.contact_join_id when null then '' else tv.contact_join_id end as visit_contact_join_id, "
    + "case tv.contact_join_namet when null then '' else tv.contact_join_namet end as visit_contact_join_namet, " +
    "tv.surveillance_case_id,tp.contact_id,tp.contact_namet, tv.t_visit_id, tvp.t_visit_payment_id, " +
    "tb.billing_payer_share,tb.billing_patient_share, tv.f_visit_type_id,tbi.billing_invoice_payer_share," +
    "tbi.billing_invoice_patient_share,bcp.contract_plans_pttype,tv.t_visit_id, " +
    "tbi.close_day_id,"
    + "tv.f_visit_type_id, tp.contact_join_id, tp.contact_join_namet, contract_payer_number, "
    + "case bcp.contract_plans_pttype "
    + "when 'A1' then 'A1' "        + "when 'A2' then 'A2' "        + "when 'A3' then 'A3' "
    + "when 'A4' then 'A4' "        + "when 'A5' then 'A5' "        + "when 'A6' then 'A6' "
    + "when 'A7' then 'ปกส.ปู่เจ้า' "   + "when 'A8' then 'ปกส.ปากน้ำ' " + "when 'A9' then 'A9' "
    + "when 'AA' then 'AA' "        + "when 'AB' then 'AB' "        + "when 'AC' then 'AC' "
    + "when 'AD' then 'AD' "        + "when 'AE' then 'AE' "        + "when 'AF' then 'AF' "
    + "when 'AG' then 'AG' "        + "when 'AH' then 'AH' "        + "when 'AI' then 'AI' "
    + "when 'AJ' then 'AJ' "        + "when 'AK' then 'AK' "        + "when 'AL' then 'AL' "
    + "when 'AM' then 'AM' "        + "when 'AN' then 'ผู้ป่วยทั่วไป' "  + "when 'AO' then 'AO' "
    + "when 'AP' then 'AP' "        + "when 'AQ' then 'AQ' "        + "when 'AR' then 'AR' "
    + "when 'AS' then 'AS' "        + "when 'AT' then 'AT' "        + "when 'AU' then 'AU' "
    + "when 'AV' then 'AV' "        + "when 'AW' then 'AW' "        + "when 'AX' then 'AX' "
    + "when 'AY' then 'AY' "        + "when 'AZ' then 'AZ' "        + "when 'UC' then 'UC' "
    + "when '99' then 'อื่นๆ' "       + "when 'FN' then 'กรม(กองทุน)' "+ "when 'CO' then 'สัญญาบริษัท' "
    + "when 'CR' then 'ประกันชีวิต' "  + "when 'PP' then 'ประกันภัย' "        + "when 'UC1' then 'มิตรไมตรีคลีนิกเวชกรรม' "
    + "when 'UC2' then 'พงค์แพทย์โพลีคลีนิกเวชกรรม1' "        + "when 'UC3' then 'โพลีคลีนิกมหาชนพระประแดง' "        + "when 'UC4' then 'พงค์แพทย์โพลีคลีนิกเวชกรรม2' "
    + "when 'UC5' then 'สถานพยาบาลเมืองสมุทรบางปู' "        + "when 'UC6' then 'UC6' "        + "when 'UC7' then 'มิตรไมตรีคลีนิกเวชกรรม(แบริ่ง)' "
    + "when 'UC8' then 'UC8' "        + "when 'UC91' then 'วัคซีนโครงการ UC' "        + "when 'UC92' then 'UC งานอนามัยโรงเรียน' "
    + "else bcp.contract_plans_pttype end as contract_plans_pttype, tv.visit_an "+
    "From t_billing_invoice tbi " +
    "left join "+t_visit.getTVisit() +" tv on tv.t_visit_id = tbi.t_visit_id AND tv.f_visit_status_id <> '4' and tbi.billing_invoice_active = '1'  " +
    "left join t_patient tp on tv.t_patient_id = tp.t_patient_id "+
    "left join f_patient_prefix fpp on tp.f_patient_prefix_id = fpp.f_patient_prefix_id " +
//            "LEFT JOIN t_diag_icd10 ON tv.t_visit_id::text = t_diag_icd10.diag_icd10_vn::text  and t_diag_icd10.diag_icd10_active = '1' and t_diag_icd10.f_diag_icd10_type_id = '1' " +
//            "left join b_employee be on t_diag_icd10.diag_icd10_staff_doctor  = be.b_employee_id " +
//            "left join b_visit_clinic bvc on t_diag_icd10.b_visit_clinic_id = bvc.b_visit_clinic_id " +
    "left join t_visit_payment tvp on tvp.t_visit_payment_id = tbi.t_payment_id  and tvp.visit_payment_active ='1' " +
    "left join b_contract_plans bcp on tvp.b_contract_plans_id = bcp.b_contract_plans_id " +
            "left join b_contract_payer bcper on bcp.b_contract_payer_id = bcper.b_contract_payer_id " +
    "left join t_billing tb on tbi.t_billing_id = tb.t_billing_id  and tb.billing_active = '1' "+
    "Where substring(tv."+t_visit.getFVisitBeginVisitTime()+",0,11) >= '"+
    visti_date_start+"' and substring(tv."+t_visit.getFVisitBeginVisitTime()+",0,11) <= '"+visit_date_end+"' "+pttype_search
            + "Order By tv.visit_vn";
                }else if(flag.equals("close_day")){
                    txt = getCloseDayId(visti_date_start);
                    sql="Select fpp.patient_prefix_description || ' ' || tp.patient_firstname || ' ' || tp.patient_lastname as patient_fullnamet, " +
            "tv.visit_hn as mnc_hn_no, tv.visit_vn as mnc_vn_no, " +
            "substring(tv."+t_visit.getFVisitBeginVisitTime()+",0,11) as visit_date, substring(tv."+t_visit.getFVisitBeginVisitTime()+",12) as visit_time, " +
            "tv."+t_visit.getFVisitStaffDoctorDischarge()+" as mnc_dot_cd, visit_patient_age, " +
            "tv."+t_visit.getFVisitNotice()+", " +
            "bcp.contract_plans_number, " +
            "contract_plans_description, case when tb.billing_patient_share is null then 0 else tb.billing_patient_share end , " +
            "case when tb.billing_total is null then 0 else tb.billing_total end, case when tb.billing_deduct is null then 0 else tb.billing_deduct end, " +
            "tv.visit_financial_discharge_time,tv.b_service_point_id,tp.t_patient_id, tv.visit_hospital_service,tv.visit_diagnosis_notice, " +
            "tv.contact_id as MNC_COM_CD, tv.contact_namet as MNC_COM_DSC, tv.contact_join_id as visit_contact_join_id, tv.contact_join_namet as visit_contact_join_namet, " +
            "tv.surveillance_case_id,tp.contact_id,tp.contact_namet, tv.t_visit_id, case when tvp.t_visit_payment_id is null then '' else tvp.t_visit_payment_id end, " +
            "tb.billing_payer_share,tb.billing_patient_share, tv.f_visit_type_id,tbi.billing_invoice_payer_share," +
            "tbi.billing_invoice_patient_share,bcp.contract_plans_pttype,tv.t_visit_id, case when contract_payer_number is null then '' else contract_payer_number end," +
            "case when bcp.contract_plans_pttype is null then '' else bcp.contract_plans_pttype end,tbi.close_day_id,tv.f_visit_type_id, tp.contact_join_id, tp.contact_join_namet, tv.visit_an "+
            "From t_billing_invoice tbi " +
            "left join "+t_visit.getTVisit() +" tv on tv.t_visit_id = tbi.t_visit_id AND tv.f_visit_status_id <> '4' and tbi.billing_invoice_active = '1'  " +
            "inner join t_patient tp on tv.t_patient_id = tp.t_patient_id "+
            "left join f_patient_prefix fpp on tp.f_patient_prefix_id = fpp.f_patient_prefix_id " +
//            "LEFT JOIN t_diag_icd10 ON tv.t_visit_id::text = t_diag_icd10.diag_icd10_vn::text  and t_diag_icd10.diag_icd10_active = '1' and t_diag_icd10.f_diag_icd10_type_id = '1' " +
//            "left join b_employee be on t_diag_icd10.diag_icd10_staff_doctor  = be.b_employee_id " +
//            "left join b_visit_clinic bvc on t_diag_icd10.b_visit_clinic_id = bvc.b_visit_clinic_id " +
            "left join t_visit_payment tvp on tvp.t_visit_payment_id = tbi.t_payment_id  and tvp.visit_payment_active ='1' " +
            "left join b_contract_plans bcp on tvp.b_contract_plans_id = bcp.b_contract_plans_id " +
            "left join b_contract_payer bcper on bcp.b_contract_payer_id = bcper.b_contract_payer_id " +
            "left join t_billing tb on tbi.t_billing_id = tb.t_billing_id  and tb.billing_active = '1' "+
            "Where tbi.close_day_id in ("+txt+") and tv.visit_vn is not null Order By tv.visit_vn ";
                }else if(flag.equals("close_day_unbilling")){
                    txt = getCloseDayId(visti_date_start);
            sql="Select fpp.patient_prefix_description || ' ' || tp.patient_firstname || ' ' || tp.patient_lastname as patient_fullnamet, " +
            "tv.visit_hn as mnc_hn_no, tv.visit_vn as mnc_vn_no, " +
            "substring(tv."+t_visit.getFVisitBeginVisitTime()+",0,11) as visit_date, substring(tv."+t_visit.getFVisitBeginVisitTime()+",12) as visit_time, " +
            "tv."+t_visit.getFVisitStaffDoctorDischarge()+" as mnc_dot_cd, visit_patient_age, " +
            "tv."+t_visit.getFVisitNotice()+", " +
            "bcp.contract_plans_number, " +
            "contract_plans_description, "
//                    + "case when tb.billing_patient_share is null then 0 else tb.billing_patient_share end , " +
//            "case when tb.billing_total is null then 0 else tb.billing_total end, case when tb.billing_deduct is null then 0 else tb.billing_deduct end, " +
            +" 0 as billing_total,0 as billing_deduct, " +
            "tv.visit_financial_discharge_time,tv.b_service_point_id,tp.t_patient_id, tv.visit_hospital_service,tv.visit_diagnosis_notice, " +
            "tv.contact_id as MNC_COM_CD, tv.contact_namet as MNC_COM_DSC, tv.contact_join_id as visit_contact_join_id, tv.contact_join_namet as visit_contact_join_namet, " +
            "tv.surveillance_case_id,tp.contact_id,tp.contact_namet, tv.t_visit_id, "
            + " case when tvp.t_visit_payment_id is null then '' else tvp.t_visit_payment_id end, " 
//            +",tb.billing_payer_share,tb.billing_patient_share, tv.f_visit_type_id,tbi.billing_invoice_payer_share," +
            +" 0 as billing_payer_share, 0 as billing_patient_share, tv.f_visit_type_id, 0 as billing_invoice_payer_share, 0 as billing_invoice_patient_share, "
//            +"tbi.billing_invoice_patient_share"
            + "bcp.contract_plans_pttype,tv.t_visit_id, case when contract_payer_number is null then '' else contract_payer_number end," 
//            "case when bcp.contract_plans_pttype is null then '' else bcp.contract_plans_pttype end"
//            + "tbi.close_day_id,tv.f_visit_type_id, tp.contact_join_id, tp.contact_join_namet, tv.visit_an "+
            +"'' as close_day_id,tv.f_visit_type_id, tp.contact_join_id, tp.contact_join_namet, tv.visit_an "
//            +"From t_billing_invoice tbi " +
            +"From t_visit_payment tvp "
            +"left join "+t_visit.getTVisit() +" tv on tv.t_visit_id = tvp.t_visit_id " +
            "inner join t_patient tp on tv.t_patient_id = tp.t_patient_id "+
            "left join f_patient_prefix fpp on tp.f_patient_prefix_id = fpp.f_patient_prefix_id " +
//            "LEFT JOIN t_diag_icd10 ON tv.t_visit_id::text = t_diag_icd10.diag_icd10_vn::text  and t_diag_icd10.diag_icd10_active = '1' and t_diag_icd10.f_diag_icd10_type_id = '1' " +
//            "left join b_employee be on t_diag_icd10.diag_icd10_staff_doctor  = be.b_employee_id " +
//            "left join b_visit_clinic bvc on t_diag_icd10.b_visit_clinic_id = bvc.b_visit_clinic_id " +
//            "left join t_visit_payment tvp on tvp.t_visit_payment_id = tbi.t_payment_id  and tvp.visit_payment_active ='1' " +
            "left join b_contract_plans bcp on tvp.b_contract_plans_id = bcp.b_contract_plans_id " +
            "left join b_contract_payer bcper on bcp.b_contract_payer_id = bcper.b_contract_payer_id " +
//            "left join t_billing tb on tbi.t_billing_id = tb.t_billing_id  and tb.billing_active = '1' "+
//            "Where tbi.close_day_id in ("+txt+") and tv.visit_vn is not null "
            "Where tv.visit_vn is not null "//ยังไม่ถูกปิดเวร แต่ต้องการดึงมาแสดง
            + "and tvp.status_payment = '0' "
            + "AND tv.f_visit_status_id <> '4' and tvp.visit_payment_active = '1' "
            + " and tv.b_contract_plans_id = tvp.b_contract_plans_id "
//            + "and tvp.t_visit_payment_id in (select tbi.t_payment_id From t_billing_invoice tbi where tvp.t_visit_id = tbi.t_visit_id) "
            + "Order By tv.visit_vn ";
            
                }else if(flag.equals("t_visit_payment_id")){
                    sql="Select fpp.patient_prefix_description || ' ' || tp.patient_firstname || ' ' || tp.patient_lastname as patient_fullnamet, " +
            "tv.visit_hn as mnc_hn_no, tv.visit_vn as mnc_vn_no, " +
            "substring(tv."+t_visit.getFVisitBeginVisitTime()+",0,11) as visit_date, substring(tv."+t_visit.getFVisitBeginVisitTime()+",12) as visit_time, " +
            "tv."+t_visit.getFVisitStaffDoctorDischarge()+" as mnc_dot_cd, visit_patient_age, " +
            "tv."+t_visit.getFVisitNotice()+", " +
            "case when bcp.contract_plans_number is null then '-' else bcp.contract_plans_number end , " +
            "contract_plans_description, case when tb.billing_patient_share is null then 0 else tb.billing_patient_share end , " +
            "case when tb.billing_total is null then 0 else tb.billing_total end, case when tb.billing_deduct is null then 0 else tb.billing_deduct end, " +
            "tv.visit_financial_discharge_time,tv.b_service_point_id,tp.t_patient_id, tv.visit_hospital_service,tv.visit_diagnosis_notice, " +
            "tv.contact_id as MNC_COM_CD, tv.contact_namet as MNC_COM_DSC, tv.contact_join_id as visit_contact_join_id, tv.contact_join_namet as visit_contact_join_namet, " +
            "tv.surveillance_case_id,tp.contact_id,tp.contact_namet, tv.t_visit_id, tvp.t_visit_payment_id, " +
            "tb.billing_payer_share,tb.billing_patient_share, tv.f_visit_type_id,tbi.billing_invoice_payer_share," +
            "tbi.billing_invoice_patient_share,tv.t_visit_id, contract_payer_number," +
            "case when bcp.contract_plans_pttype is null then '-' else bcp.contract_plans_pttype end ,tbi.close_day_id,tv.f_visit_type_id, tp.contact_join_id, tp.contact_join_namet, tv.visit_an "+
            "From t_billing_invoice tbi " +
            "left join "+t_visit.getTVisit() +" tv on tv.t_visit_id = tbi.t_visit_id  and tbi.billing_invoice_active = '1'  " +
            "inner join t_patient tp on tv.t_patient_id = tp.t_patient_id "+
            "left join f_patient_prefix fpp on tp.f_patient_prefix_id = fpp.f_patient_prefix_id " +
//            "LEFT JOIN t_diag_icd10 ON tv.t_visit_id::text = t_diag_icd10.diag_icd10_vn::text  and t_diag_icd10.diag_icd10_active = '1' and t_diag_icd10.f_diag_icd10_type_id = '1' " +
//            "left join b_employee be on t_diag_icd10.diag_icd10_staff_doctor  = be.b_employee_id " +
//            "left join b_visit_clinic bvc on t_diag_icd10.b_visit_clinic_id = bvc.b_visit_clinic_id " +
            "left join t_visit_payment tvp on tvp.t_visit_payment_id = tbi.t_payment_id  and tvp.visit_payment_active ='1' " +
            "left join b_contract_plans bcp on tvp.b_contract_plans_id = bcp.b_contract_plans_id " +
            "left join b_contract_payer bcper on bcp.b_contract_payer_id = bcper.b_contract_payer_id " +
            "left join t_billing tb on tbi.t_billing_id = tb.t_billing_id  and tb.billing_active = '1' "+
            "Where tbi.t_payment_id = '"+visti_date_start+"' and tv.visit_vn is not null "
                + "Order By tv.visit_vn ";
                    
                }
            } else {
                connmainhis = getConnectionMainHIS(branch.getBranchId());
                connmainhis2 = getConnectionMainHIS(branch.getBranchId());
                if(flag.equals("period_date")){
                    sql="Select pt01.mnc_hn_no, pt01.mnc_date, pt01.mnc_time, pt01.mnc_vn_no, pt01.mnc_vn_seq, pt01.mnc_dot_cd, " +
                    "pt01.mnc_fn_typ_cd,pt01.mnc_shif_memo, pt01.MNC_SEC_NO, pm02.mnc_pfix_dsc+' '+pm01.mnc_fname_t +' '+ pm01.mnc_lname_t as patient_fullnamet, "
                    +"pmm02.mnc_pfix_dsc+' ' +pm26.mnc_dot_fname +' '+pm26.mnc_dot_lname as doctor_fullnamet, "
                    +"fm02.mnc_fn_typ_dsc, pt01.mnc_shif_memo,datediff(year,pm01.mnc_bday,getdate()) as age, "+
                    "pt01.MNC_SEC_NO, pm32.MNC_MD_DEP_DSC, pt01.MNC_COM_CD, pm24.MNC_COM_DSC,pt01.mnc_adm_flg "+
                    "From patient_t01 pt01 left join patient_m01 pm01 on pt01.mnc_hn_no = pm01.mnc_hn_no and pt01.mnc_hn_yr = pm01.mnc_hn_yr " +
                    "left join patient_m02 pm02 on pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd " +
                    "left join patient_m26 pm26 on pt01.mnc_dot_cd = pm26.mnc_dot_cd " +
                    "left join patient_m02 pmm02 on pm26.mnc_dot_pfix = pmm02.mnc_pfix_cd left join "
                    +"finance_m02 fm02 on pt01.mnc_fn_typ_cd = fm02.mnc_fn_typ_cd "+
                    " left join patient_m32 pm32 on pt01.MNC_SEC_NO = pm32.MNC_SEC_NO " +
                    "left join patient_m24 pm24 on pt01.MNC_COM_CD = pm24.MNC_COM_CD "+
                    "Where pt01.mnc_date >= '"+visti_date_start+"' and pt01.mnc_date <= '"+visit_date_end+"' and pt01.mnc_sts <> 'C' "
                    +"Order By pt01.mnc_date, pt01.mnc_time ";
                }else if(flag.equals("close_day")) {
//                    sql="Select pt01.mnc_hn_no, pt01.mnc_date, pt01.mnc_time, pt01.mnc_vn_no, pt01.mnc_vn_seq, pt01.mnc_dot_cd, " +
//                    "pt01.mnc_fn_typ_cd,pt01.mnc_shif_memo, pt01.MNC_SEC_NO, pm02.mnc_pfix_dsc+' '+pm01.mnc_fname_t +' '+ pm01.mnc_lname_t as patient_fullnamet, "
//                    +"pmm02.mnc_pfix_dsc+' ' +pm26.mnc_dot_fname +' '+pm26.mnc_dot_lname as doctor_fullnamet, "
//                    +"fm02.mnc_fn_typ_dsc, pt01.mnc_shif_memo,datediff(year,pm01.mnc_bday,getdate()) as age, "+
//                    "pt01.MNC_SEC_NO, pm32.MNC_MD_DEP_DSC, pt01.MNC_COM_CD, pm24.MNC_COM_DSC,pt01.mnc_adm_flg "+
//                    "From patient_t01 pt01 left join patient_m01 pm01 on pt01.mnc_hn_no = pm01.mnc_hn_no and pt01.mnc_hn_yr = pm01.mnc_hn_yr " +
//                    "left join patient_m02 pm02 on pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd " +
//                    "left join patient_m26 pm26 on pt01.mnc_dot_cd = pm26.mnc_dot_cd " +
//                    "left join patient_m02 pmm02 on pm26.mnc_dot_pfix = pmm02.mnc_pfix_cd left join "
//                    +"finance_m02 fm02 on pt01.mnc_fn_typ_cd = fm02.mnc_fn_typ_cd "+
//                    "left join patient_m32 pm32 on pt01.MNC_SEC_NO = pm32.MNC_SEC_NO " +
//                    "left join patient_m24 pm24 on pt01.MNC_COM_CD = pm24.MNC_COM_CD "+
//                    "Where pt01.mnc_date >= '"+visti_date_start+"' and pt01.mnc_date <= '"+visit_date_end+"' and pt01.mnc_sts <> 'C' "
//                    +"Order By pt01.mnc_date, pt01.mnc_time ";
                    
                    sql="Select ft01.*,fm02.mnc_fn_typ_dsc "+
                    "From finance_t01 ft01 "
                    +"left join finance_m02 fm02 on ft01.mnc_fn_typ_cd = fm02.mnc_fn_typ_cd "+
                    "Where ft01.mnc_doc_dat >= '"+visti_date_start+"' and ft01.mnc_doc_dat <= '"+visit_date_end+"'  "
                    +"Order By mnc_doc_cd ";
                    
                } else{
                    sql="Select pt01.mnc_hn_no, pt01.mnc_date, pt01.mnc_time, pt01.mnc_vn_no, pt01.mnc_vn_seq, pt01.mnc_dot_cd, " +
                    "pt01.mnc_fn_typ_cd,pt01.mnc_shif_memo, pt01.MNC_SEC_NO, pmm02.mnc_pfix_dsc+' ' +pm26.mnc_dot_fname +' '+pm26.mnc_dot_lname as doctor_fullnamet, "+
                    "fm02.mnc_fn_typ_dsc, pt01.mnc_shif_memo,datediff(year,pm01.mnc_bday,getdate()) as age, "+
                    "pt01.MNC_SEC_NO, pm32.MNC_MD_DEP_DSC, pt01.MNC_COM_CD, pm24.MNC_COM_DSC,pt01.mnc_adm_flg "+
                    "From patient_t01 pt01 left join patient_m01 pm01 on pt01.mnc_hn_no = pm01.mnc_hn_no and "
                    +"pt01.mnc_hn_yr = pm01.mnc_hn_yr left join patient_m02 pm02 on "
                    +"pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd left join patient_m26 pm26 on "
                    +"pt01.mnc_dot_cd = pm26.mnc_dot_cd left join patient_m02 pmm02 on "
                    +"pm26.mnc_dot_pfix = pmm02.mnc_pfix_cd left join "
                    +"finance_m02 fm02 on pt01.mnc_fn_typ_cd = fm02.mnc_fn_typ_cd "+
                    "left join patient_m32 pm32 on pt01.MNC_SEC_NO = pm32.MNC_SEC_NO "+
                    "left join patient_m24 pm24 on pt01.MNC_COM_CD = pm24.MNC_COM_CD "+
                    "Where pt01.mnc_date = '"+visti_date_start+"' "
                    +dep_id+"' and pt01.mnc_sts <> 'C' "
                    +"Order By pt01.mnc_date, pt01.mnc_time ";
                }
            }
            stmainhis = connmainhis.createStatement();
            stMainHis2 = connmainhis2.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()) {
                try{
                    i++;
                    if(rsmainhis.getString("mnc_hn_no").equals("535000017")){
                        error="";
                    }
                    if(i==292){
                        error="";
                    }
                    pv = new PatientVisit();
                    if(branch.getBranchProgram().equals("hospital_osv3")) {
                        if(rsmainhis.getString("contract_plans_number").equals("002") && rsmainhis.getString("billing_invoice_patient_share").equals("0")){
                            continue;
                        }
                        time = rsmainhis.getString("visit_time");
                        time = time.substring(0,5);
                        if(rsmainhis.getString("visit_date").length()>=10){
                            visit_date = rsmainhis.getString("visit_date").substring(0, 10);
                        }else{
                            visit_date = rsmainhis.getString("visit_date");
                        }
//                        if(visit_date.length()>=10){
//                            visit_date = String.valueOf(Integer.parseInt(visit_date.substring(0, 4))-543)+visit_date.substring(4);
//                        }
                        if(rsmainhis.getString("visit_financial_discharge_time").length()>=10){
                            discharge_date = rsmainhis.getString("visit_financial_discharge_time").substring(0, 10);
                        }else{
                            discharge_date = rsmainhis.getString("visit_financial_discharge_time");
                        }
                        error="01";
                        pv.setPatientId(rsmainhis.getString("t_patient_id"));
                        pv.setPatientNamet(rsmainhis.getString("patient_fullnamet"));
                        pv.setVisitDate(visit_date);
                        pv.setVisitTime(time);
                        pv.setVisitVn(rsmainhis.getString("mnc_vn_no"));//+"."+rsmainhis.getString("mnc_vn_seq"));
                        pv.setVisitDoctorId(rsmainhis.getString("mnc_dot_cd"));
                        pv.setContractPayerNumber(rsmainhis.getString("contract_payer_number"));
                        if((rsmainhis.getString("contract_plans_number") != null) && (!rsmainhis.getString("contract_plans_number").equals(""))) {
                            pv.setVisitPaidId(rsmainhis.getString("contract_plans_number"));
    //                        patient_visit.setVisitPaidId(rsmainhis.getString("contract_payer_number"));ยกเลิก เปลี่ยนเป็น payer
                            pv.setVisitPaidNamet(rsmainhis.getString("contract_plans_description"));
    //                        patient_visit.setVisitPaidNamet(rsmainhis.getString("contract_payer_description"));ยกเลิก เปลี่ยนเป็น payer
                        }else {
                            contract = getContractPlansByVisit(branch.getBranchId(),rsmainhis.getString("t_visit_id"),rsmainhis.getString("t_visit_payment_id"));
    //                        contract = getContractPayerByVisit(branch.getBranchId(),rsmainhis.getString("t_visit_id"),rsmainhis.getString("t_visit_payment_id"));
                            pv.setVisitPaidId(contract.contract_id);
                            pv.setVisitPaidNamet(contract.description);
                        }
                        pv.setPatientHn(rsmainhis.getString("mnc_hn_no"));
                        if(rsmainhis.getString("mnc_hn_no").equals("535000142")){
                            error="0111";
                        }
                        pv.setVisitNotice(rsmainhis.getString(t_visit.getFVisitNotice()));
                        pv.setPatientAge(rsmainhis.getString("visit_patient_age"));

                        doctor = new Doctor();
                        doctor = getClinicDoctorByVisit(branch.getBranchId(),rsmainhis.getString("t_visit_id"));
                        pv.setVisitDoctorNamet(doctor.getDoctorNamet());
                        pv.setVisitClinicId(doctor.getBVisitClinicId());
                        pv.setVisitClinicNamet(doctor.getVisitClicinDescription());
    //                    patient_visit.setVisitDoctorNamet(rsmainhis.getString("doctor_fullnamet"));

                        if(rsmainhis.getString("MNC_COM_CD").equals("0")) {
                            pv.setVisitContactId(StringNull(rsmainhis.getString("contact_id")));
                            pv.setVisitContactNamet(StringNull(rsmainhis.getString("contact_namet")));
                        }else {
                            pv.setVisitContactId(StringNull(rsmainhis.getString("MNC_COM_CD")));
                            pv.setVisitContactNamet(StringNull(rsmainhis.getString("MNC_COM_DSC")));
                        }
                        pv.setBServerPointId(rsmainhis.getString("b_service_point_id"));
                        pv.setVisitHospitalService(rsmainhis.getString("visit_hospital_service"));
                        pv.setVisitDiagnosisNotice(rsmainhis.getString("visit_diagnosis_notice"));
                        pv.setVisitFinancialDischargeTime(discharge_date);

                        error="02";
                        if(rsmainhis.getString("billing_patient_share") != null){
                            pv.setPaid(Double.parseDouble(rsmainhis.getString("billing_patient_share")));
                        }else{
                            pv.setPaid(0.0);
                        }
                        if(rsmainhis.getString("billing_total") != null){
                            pv.setAmount(Double.parseDouble(rsmainhis.getString("billing_total")));
                        }else{
                            pv.setAmount(0.0);
                        }
                        if(rsmainhis.getString("billing_deduct") != null){
                            pv.setDiscount(Double.parseDouble(rsmainhis.getString("billing_deduct")));
                        }else{
                            pv.setDiscount(0.0);
                        }

                        if(rsmainhis.getString("contract_plans_pttype").equals("A1")){//เงินสด cash
                            if(rsmainhis.getString("billing_invoice_payer_share").equals("0")) {
                                pv.setAmount(Double.parseDouble(rsmainhis.getString("billing_invoice_patient_share")));
                                pv.setPaid(Double.parseDouble(rsmainhis.getString("billing_invoice_patient_share")));
                            }else {
                                pv.setAmount(Double.parseDouble(rsmainhis.getString("billing_invoice_payer_share")));
                                pv.setPaid(0.0);
                            }

                        }else{//credit
                            if(Double.parseDouble(rsmainhis.getString("billing_invoice_payer_share"))>0){
                                pv.setAmount(Double.parseDouble(rsmainhis.getString("billing_invoice_payer_share")));
                                pv.setPaid(0.0);
                            }else{
                                pv.setAmount(Double.parseDouble(rsmainhis.getString("billing_invoice_patient_share")));
                                pv.setPaid(0.0);
                            }
                        }
                        error="03";
                        if(rsmainhis.getString("billing_payer_share") != null){
                            pv.setBillingPayerShare(Double.parseDouble(rsmainhis.getString("billing_payer_share")));
                        }else{
                            pv.setBillingPayerShare(0.0);
                        }
                        if(rsmainhis.getString("billing_patient_share") != null){
                            pv.setBillingPatientShare(Double.parseDouble(rsmainhis.getString("billing_patient_share")));
                        }else{
                            pv.setBillingPatientShare(0.0);
                        }
                        error="04";
                        pv.setTVisitId(rsmainhis.getString("t_visit_id"));
                        if(flag.equals("t_visit_payment_id")){
                            pv.setTVisitPayment(visti_date_start);
                        }else{
                            pv.setTVisitPayment(rsmainhis.getString("t_visit_payment_id"));
                        }
                        
                        pv.setFVisitTypeId(rsmainhis.getString("f_visit_type_id"));
                        error="041";
                        pv.setContractPlansPttype(rsmainhis.getString("contract_plans_pttype"));
                        pv.setReceiptNumber(getReceiptNumberByVN(st_paid, branch.getBranchId(),rsmainhis.getString("mnc_vn_no")));
                        error="042";
                        pv.setInvoiceNumber(getInvoiceNumberByVN(st_paid,branch.getBranchId(),rsmainhis.getString("mnc_vn_no")));
                        pv.setCloseDayId(rsmainhis.getString("close_day_id"));
                        error="043";
                        if(!rsmainhis.getString("visit_contact_join_id").equals("")){
                            pv.setVisitContactJoinId(rsmainhis.getString("visit_contact_join_id"));
                        }else{
                            pv.setVisitContactJoinId(rsmainhis.getString("visit_contact_join_id"));
                        }
                        if(!rsmainhis.getString("visit_contact_join_namet").equals("")){
                            pv.setVisitContactJoinNamet(rsmainhis.getString("visit_contact_join_namet"));
                        }else{
                            pv.setVisitContactJoinNamet(rsmainhis.getString("visit_contact_join_id"));
                        }
                        pv.setVisitAn(rsmainhis.getString("visit_an"));
                    }else{
                        
                        sql="Select pt01.mnc_hn_no, pt01.mnc_date, pt01.mnc_time, pt01.mnc_vn_no, pt01.mnc_vn_seq, pt01.mnc_dot_cd, " +
                    "pt01.mnc_fn_typ_cd,pt01.mnc_shif_memo, pt01.MNC_SEC_NO, pm02.mnc_pfix_dsc+' '+pm01.mnc_fname_t +' '+ pm01.mnc_lname_t as patient_fullnamet, "
                    +"pmm02.mnc_pfix_dsc+' ' +pm26.mnc_dot_fname +' '+pm26.mnc_dot_lname as doctor_fullnamet, "
                    +"fm02.mnc_fn_typ_dsc, pt01.mnc_shif_memo,datediff(year,pm01.mnc_bday,getdate()) as age, "+
                    "pt01.MNC_SEC_NO, pm32.MNC_MD_DEP_DSC, pt01.MNC_COM_CD, pm24.MNC_COM_DSC,pt01.mnc_adm_flg "+
                    "From patient_t01 pt01 left join patient_m01 pm01 on pt01.mnc_hn_no = pm01.mnc_hn_no and pt01.mnc_hn_yr = pm01.mnc_hn_yr " +
                    "left join patient_m02 pm02 on pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd " +
                    "left join patient_m26 pm26 on pt01.mnc_dot_cd = pm26.mnc_dot_cd " +
                    "left join patient_m02 pmm02 on pm26.mnc_dot_pfix = pmm02.mnc_pfix_cd left join "
                    +"finance_m02 fm02 on pt01.mnc_fn_typ_cd = fm02.mnc_fn_typ_cd "+
                    "left join patient_m32 pm32 on pt01.MNC_SEC_NO = pm32.MNC_SEC_NO " +
                    "left join patient_m24 pm24 on pt01.MNC_COM_CD = pm24.MNC_COM_CD "+
                    "Where pt01.mnc_date = '"+rsmainhis.getString("mnc_date")+"' and pt01.mnc_sts <> 'C' "
                    + "and pt01.mnc_hn_no = '"+rsmainhis.getString("mnc_hn_no")+"' "
                    +"Order By pt01.mnc_date, pt01.mnc_time ";
                    
                    ResultSet rsMainHis2 = stMainHis2.executeQuery(sql);
                    while(rsMainHis2.next()) {
                        if(rsmainhis.getString("mnc_hn_no").equals("1442291")){
                            sql="";
                        }
                        time = "0000"+rsmainhis.getString("mnc_doc_tim");
                        time = time.substring(time.length()-4, time.length());
                        if(rsMainHis2.getString("mnc_date").length()>=10){
                            visit_date = rsmainhis.getString("mnc_doc_dat").substring(0, 10);
                        }else{
                            visit_date = rsmainhis.getString("mnc_doc_dat");
                        }
    //                    patient_visit.setPatientId(rsmainhis.getString("mnc_hn_no"));
                        pv.setPatientNamet(rsMainHis2.getString("patient_fullnamet"));
                        pv.setVisitDate(visit_date);
                        pv.setVisitTime(time);
                        pv.setVisitVn(rsMainHis2.getString("mnc_vn_no")+"."+rsMainHis2.getString("mnc_vn_seq"));
                        pv.setVisitDoctorId(rsMainHis2.getString("mnc_dot_cd"));
                        pv.setVisitDoctorNamet(rsMainHis2.getString("doctor_fullnamet"));
                        pv.setVisitPaidId(rsmainhis.getString("mnc_fn_typ_cd"));
                        pv.setContractPayerNumber(rsmainhis.getString("mnc_fn_typ_cd"));
                        pv.setVisitPaidNamet(rsmainhis.getString("mnc_fn_typ_dsc"));
                        pv.setPatientHn(rsmainhis.getString("mnc_hn_no"));
                        pv.setVisitNotice(rsMainHis2.getString("mnc_shif_memo"));
                        pv.setPatientAge(rsMainHis2.getString("age"));
                        pv.setVisitDoctorNamet(rsMainHis2.getString("doctor_fullnamet"));
                        pv.setVisitClinicId(rsMainHis2.getString("MNC_SEC_NO"));
                        pv.setVisitClinicNamet(rsMainHis2.getString("MNC_MD_DEP_DSC"));
                        pv.setVisitContactId(rsMainHis2.getString("MNC_COM_CD"));
                        pv.setVisitContactNamet(rsMainHis2.getString("MNC_COM_DSC"));
                        pv.docCD = rsmainhis.getString("mnc_doc_cd");
                        
//                        pv.setDiscount(rsmainhis.getDouble("mnc_dis_tot"));
                        
                        pv.setPaid(Double.parseDouble(rsmainhis.getString("mnc_pay_cash")));
                        pv.setAmount(Double.parseDouble(rsmainhis.getString("mnc_sum_pri")));
                        pv.setDiscount(Double.parseDouble("-"+rsmainhis.getString("mnc_dis_tot")));
                        pv.setInvoiceNumber(rsmainhis.getString("mnc_doc_no"));
                        
//                        v_visit_paid = getPatientVisitPaid(branch.getBranchId(),visit_date,rsMainHis2.getString("mnc_hn_no"), 
//                                rsMainHis2.getString("mnc_vn_no")+"."+rsMainHis2.getString("mnc_vn_seq"));
//                        if(v_visit_paid.size()>0){
//                            patientvisitpaid = new PatientVisitPaid();
//                            patientvisitpaid = (PatientVisitPaid)v_visit_paid.get(0);
//                            pv.setPaid(patientvisitpaid.getPaid());
//                            pv.setAmount(patientvisitpaid.getAmount());
//                            pv.setDiscount(patientvisitpaid.discount);
//                        }
                        
                        if(rsMainHis2.getString("mnc_adm_flg").equals("A")){
                            pv.setFVisitTypeId("1");
                        }else{
                            pv.setFVisitTypeId("0");
                        }
                    }
                    rsMainHis2.close();
                        
                        //patient_visit.setVisitClinicNamet(rsmainhis.getString("MNC_MD_DEP_DSC"));
                    }
                    error="05";
                    vPatientVisit.add(pv);
    //                string[] aaa = rsmainhis.getString("MNC_COM_DSC").split("\\,");
    //                aaa[1]
                }catch(Exception ex){
                    Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            rsmainhis.close();
            connmainhis.close();
            connmainhis2.close();
            conn_paid.close();
        }catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vPatientVisit;
    }
    public Contract getContractPlansByVisit(String branch_id,String t_visit_id, String t_payment_id) throws Exception {
        String sql="", txt="", select="";
        Connection conn = getConnectionHospital(branch_id);
        Vector v_address = new Vector();
//        BBranch branch = new BBranch();
        Statement st;
        ResultSet rs;
        sql="select bcp.contract_plans_number, bcp.contract_plans_description " +
            "From t_visit as tv  "+
            "left join t_visit_payment as tvp on tv.t_visit_id = tvp.t_visit_id "+
            "left join b_contract_plans as bcp on tvp.b_contract_plans_id = bcp.b_contract_plans_id "+
            "where tv.t_visit_id = '"+t_visit_id+"' and tvp.t_visit_payment_id = '"+t_payment_id+"' ";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            contract = new Contract();
            contract.contract_id = rs.getString("contract_plans_number");
            contract.description = rs.getString("contract_plans_description");
        }
        rs.close();
        conn.close();
        return contract;
    }
    public Contract getContractPayerByVisit(String branch_id,String t_visit_id, String t_payment_id) throws Exception {
        String sql="", txt="", select="";
        Connection conn = getConnectionHospital(branch_id);
        Vector v_address = new Vector();
//        BBranch branch = new BBranch();
        Statement st;
        ResultSet rs;
        sql="select bcper.contract_payer_number, bcper.contract_payer_description " +
            "From t_visit as tv  "+
            "left join t_visit_payment as tvp on tv.t_visit_id = tvp.t_visit_id "+
            "left join b_contract_plans as bcp on tvp.b_contract_plans_id = bcp.b_contract_plans_id " +
            "left join b_contract_payer bcper on bcp.b_contract_payer_id = bcper.b_contract_payer_id " +
            "where tv.t_visit_id = '"+t_visit_id+"' and tvp.t_visit_payment_id = '"+t_payment_id+"' ";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            contract = new Contract();
            contract.contract_id = rs.getString("contract_plans_number");
            contract.description = rs.getString("contract_plans_description");
        }
        rs.close();
        conn.close();
        return contract;
    }
    public Doctor getClinicDoctorByVisit(String branch_id,String t_visit_id) throws Exception {
        String sql="", txt="", select="";
        Connection conn = getConnectionHospital(branch_id);
//        Vector v_address = new Vector();
//        BBranch branch = new BBranch();
        Statement st;
        ResultSet rs;
        sql="select bvc.visit_clinic_description, bvc.b_visit_clinic_id, be.employee_firstname || ' ' || be.employee_lastname as doctor_fullnamet " +
            "From t_visit as tv  "+
            "LEFT JOIN t_diag_icd10 ON tv.t_visit_id::text = t_diag_icd10.diag_icd10_vn::text  and t_diag_icd10.diag_icd10_active = '1' and t_diag_icd10.f_diag_icd10_type_id = '1' " +
            "left join b_employee be on t_diag_icd10.diag_icd10_staff_doctor  = be.b_employee_id " +
            "left join b_visit_clinic bvc on t_diag_icd10.b_visit_clinic_id = bvc.b_visit_clinic_id " +
            "where tv.t_visit_id = '"+t_visit_id+"' ";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            doctor = new Doctor();
            doctor.setDoctorNamet(rs.getString("doctor_fullnamet"));
            doctor.setBVisitClinicId(rs.getString("b_visit_clinic_id"));
            doctor.setVisitClicinDescription(rs.getString("visit_clinic_description"));
        }
        rs.close();
        conn.close();
        return doctor;
    }
    public String getReceiptNumberByVN(String branch_id,String visit_vn) throws Exception {
        String sql="", txt="", select="";
        Connection conn = getConnectionBangna();
        Statement st;
//        ResultSet rs;
//        sql="select receive_number " +
//            "From cashier_t_billing_receive_print as ctbrp  "+
//            "where ctbrp.t_visit_vn = '"+visit_vn+"' ";
        st = conn.createStatement();
        txt = getReceiptNumberByVN(st,branch_id, visit_vn);
//        rs = st.executeQuery(sql);
//        while (rs.next()) {
//            txt = rs.getString("receive_number");
//        }
//        rs.close();
        conn.close();
        return txt;
    }
    public String getReceiptNumberByVN(Statement st,String branch_id,String visit_vn) throws Exception {
        String sql="", txt="", select="";
//        Connection conn = getConnectionBangna();
//        Statement st;
        ResultSet rs;
        sql="select receive_number " +
            "From cashier_t_billing_receive_print as ctbrp  "+
            "where ctbrp.t_visit_vn = '"+visit_vn+"' ";
//        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            txt = rs.getString("receive_number");
        }
        rs.close();
//        conn.close();
        return txt;
    }
    public String getInvoiceNumberByVN(String branch_id,String visit_vn) throws Exception {
        String sql="", txt="", select="";
        Connection conn = getConnectionBangna();
        Statement st;
//        ResultSet rs;
//        sql="select invoice_number " +
//            "From cashier_t_billing_invoice_print as ctbip  "+
//            "where ctbip.t_visit_vn = '"+visit_vn+"' ";
        st = conn.createStatement();
        txt = getInvoiceNumberByVN(st, branch_id, visit_vn);
//        rs = st.executeQuery(sql);
//        while (rs.next()) {
//            txt = rs.getString("invoice_number");
//        }
//        rs.close();
        conn.close();
        return txt;
    }
    public String getInvoiceNumberByVN(Statement st,String branch_id,String visit_vn) throws Exception {
        String sql="", txt="", select="";
//        Connection conn = getConnectionBangna();
//        Statement st;
        ResultSet rs;
        sql="select invoice_number " +
            "From cashier_t_billing_invoice_print as ctbip  "+
            "where ctbip.t_visit_vn = '"+visit_vn+"' ";
//        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            txt = rs.getString("invoice_number");
        }
        rs.close();
//        conn.close();
        return txt;
    }
    public String CboChangwat(String selected, String where){
        String txt="",sql="";
        Vector v_address = new Vector();
//        FAddress address = new FAddress();
        v_address = getChangwat(where);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_address.size()-1;i++) {
            address = (FAddress) v_address.get(i);
            if(address.getAddressChangwatId().equals(selected)){
                txt += "<option value='"+address.getAddressChangwatId()+"' selected>"+address.getAddressDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+address.getAddressChangwatId()+"' >"+address.getAddressDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getChangwat(String where) {
        Vector v_address = new Vector();
        String time="";
        String sql="";
        if(where.equals("")){
            sql="Select * "+
            "From "+address.getFAddress()+" " +
            "Where "+address.getFAddressTambonType()+"='1' Order By "+address.getFAddressDescription();
        }else{
            sql="Select * "+
            "From "+address.getFAddress()+" " +
            "Where "+address.getFAddressTambonType()+"='1' and " +
            address.getFAddressDescription() +" like '"+where+"%' Order By "+address.getFAddressDescription();
        }
        Connection connbangna;
        Statement stmainhis;
        ResultSet rsmainhis;
        try {
            connbangna = getConnectionBangna();
            stmainhis = connbangna.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                address = new FAddress();
                address.setAddressChangwatId(rsmainhis.getString(address.getFAddressChangwatId()));
                address.setAddressDescription(rsmainhis.getString(address.getFAddressDescription()));
                v_address.add(address);
            }
            rsmainhis.close();
            connbangna.close();
        }catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_address;
    }
    public String CboAmphur(String changwat_id,String selected){
        String txt="",sql="";
        Vector v_address = new Vector();
//        FAddress address = new FAddress();
        v_address = getAmphur(changwat_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_address.size()-1;i++) {
            address = (FAddress) v_address.get(i);
            if(address.getFAddressId().equals(selected)){
                txt += "<option value='"+address.getFAddressId()+"' selected>"+address.getAddressDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+address.getFAddressId()+"' >"+address.getAddressDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getAmphur(String changwat_id){
        Vector v_address = new Vector();

        String time="", where="";
        if(!changwat_id.equals("")) {
            where = " and "+address.getFAddressChangwatId()+" = '"+changwat_id+"' ";
        }
        String sql="Select distinct "+address.getFFAddressId()+", "+address.getFAddressDescription()+" "
            +"From "+address.getFAddress()+" Where "+address.getFAddressTambonType()+"='2' " +where+
            " Order By "+address.getFAddressDescription();
        Connection connbangna;
        Statement stmainhis;
        ResultSet rsmainhis;
        try {
            connbangna = getConnectionBangna();
            stmainhis = connbangna.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                address = new FAddress();
                address.setFAddressId(rsmainhis.getString(address.getFFAddressId()));
                address.setAddressDescription(rsmainhis.getString(address.getFAddressDescription()));
                v_address.add(address);
            }
            rsmainhis.close();
            connbangna.close();
        }
        catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_address;
    }
    public String CboTambom(String amphur_id, String tambon_search,String selected){
        String txt="",sql="";
        Vector v_address = new Vector();
//        FAddress address = new FAddress();
        v_address = getTambom(amphur_id,tambon_search);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_address.size()-1;i++) {
            address = (FAddress) v_address.get(i);
            if(address.getFAddressId().equals(selected)){
                txt += "<option value='"+address.getFAddressId()+"' selected>"+address.getAddressDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+address.getFAddressId()+"' >"+address.getAddressDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getTambom(String amphur_id, String tambon_search) {
        Vector v_address = new Vector();

        String time="", where="";
        if(!amphur_id.equals("")) {
            where = " and "+address.getFAddressAmphurId()+" = '"+amphur_id+"' ";
        }
        if(!tambon_search.equals("")) {
            where = " and "+address.getFAddressDescription()+" like '"+tambon_search+"%' ";
        }
        String sql="Select distinct "+address.getFFAddressId()+", "+address.getFAddressDescription()+" "
            +"From "+address.getFAddress()+" Where "+address.getFAddressTambonType()+"='3' " +where+
            " Order By "+address.getFAddressDescription();
        Connection connbangna;
        Statement stmainhis;
        ResultSet rsmainhis;

        try {
            connbangna = getConnectionBangna();
            stmainhis = connbangna.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                address = new FAddress();
                address.setFAddressId(rsmainhis.getString(address.getFFAddressId()));
                address.setAddressDescription(rsmainhis.getString(address.getFAddressDescription()));
                v_address.add(address);
            }
            rsmainhis.close();

            connbangna.close();
        }catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_address;
    }
    public Vector getTambonAmphurChangwat(String branch_id,String where) throws Exception {
        String sql="", txt="", select="";
        Connection conn = getConnectionHospital(branch_id);
        Vector v_address = new Vector();
//        BBranch branch = new BBranch();
        Statement st;
        ResultSet rs;
        sql="select f_tambon.f_address_id,f_tambon.address_description as tambon_namet," +
                "f_amphur.address_description as amphur_namet,f_amphur.f_address_id as amphur_id, "+
                "f_changwat.address_description as changwat_namet,f_changwat.f_address_id as changwat_id " +
                "From f_address as f_tambon  "+
        "left join f_address as f_amphur on substring(f_tambon.f_address_id,1,4) = substring(f_amphur.f_address_id,1,4) and f_amphur.address_tambon_type = '2' "+
        "left join f_address as f_changwat on substring(f_tambon.f_address_id,1,2) = substring(f_changwat.f_address_id,1,2) and f_changwat.address_tambon_type = '1' "+
        "where f_tambon.address_description like '"+where+"%' and f_tambon.address_tambon_type = '3'";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            address = new FAddress();
            address.setFAddressId(rs.getString(address.getFFAddressId()));
            address.setAddressDescription(rs.getString("tambon_namet"));
            address.setAddressAmphurId(rs.getString("amphur_id"));
            address.setAddressRegion(rs.getString("amphur_namet"));
            address.setAddressChangwatId(rs.getString("changwat_id"));
            address.setAddressDescriptione(rs.getString("changwat_namet"));
            v_address.add(address);
        }
        rs.close();
        conn.close();
        return v_address;
    }
    public Integer getDateDiff(String date_cal, String branch_id){
        //Vector v_claim = new Vector();
        Integer cur=0;
        String sql="Select datediff(day,'"+date_cal+"',getdate()) as cur From default_m01 Where mnc_ip_dsc = 'INFO11' ";
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        try {
            connmainhis = getConnectionMainHIS(branch_id);
            stmainhis = connmainhis.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                cur = Integer.parseInt(rsmainhis.getString("cur"));
            }
            rsmainhis.close();
            connmainhis.close();
        }catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cur;
    }
    public Vector getDoctorOrderLabByPatientHnNo(String branch_id, String visti_date, String doctor_id, String patient_hn_no){
        Vector v_doctor_order_lab = new Vector();
        String sql="SELECT lt02.mnc_lb_cd, lm01.mnc_lb_dsc, lt01.MNC_ORD_DOT, fm02.MNC_FN_STS, LAB_M02.MNC_LB_PRI, lt01.mnc_hn_no, lt02.mnc_lb_cos "
            +"FROM LAB_T01 lt01 INNER JOIN "
            +  "LAB_T02 lt02 ON lt01.MNC_REQ_YR = lt02.MNC_REQ_YR AND lt01.MNC_REQ_NO = lt02.MNC_REQ_NO AND "
            +  "lt01.MNC_REQ_DAT = lt02.MNC_REQ_DAT INNER JOIN "
            +  "LAB_M02 ON lt02.MNC_LB_CD = LAB_M02.MNC_LB_CD INNER JOIN "
            +  "FINANCE_M02 fm02 ON lt01.MNC_FN_TYP_CD = fm02.MNC_FN_TYP_CD inner join lab_m01 lm01 on "
            +  "lm01.mnc_lb_cd = lt02.mnc_lb_cd "
            + "WHERE (lt01.MNC_REQ_STS <> 'C') AND (lt01.MNC_REQ_DAT BETWEEN '"+visti_date+"' AND '"+visti_date+"') and "
            +"lt01.mnc_hn_no = '"+patient_hn_no+"' and lt01.mnc_dot_cd = '"+doctor_id+"' ";
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        DoctorOrderLab doctororderlab = new DoctorOrderLab();
        try {
            connmainhis = getConnectionMainHIS(branch_id);
            stmainhis = connmainhis.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                doctororderlab = new DoctorOrderLab();
                doctororderlab.setDoctorId(rsmainhis.getString("mnc_dot_cd"));
                doctororderlab.setLabId(rsmainhis.getString("mnc_lb_cd"));
                doctororderlab.setLabNamet(rsmainhis.getString("mnc_lb_dsc"));
                doctororderlab.setPatientId(rsmainhis.getString("mnc_hn_no"));
                doctororderlab.setPriceCost(Double.parseDouble(rsmainhis.getString("mnc_lb_cos")));
                doctororderlab.setPriceSale(Double.parseDouble(rsmainhis.getString("MNC_LB_PRI")));
                doctororderlab.setOrderDate(visti_date);
                v_doctor_order_lab.add(doctororderlab);
            }
            rsmainhis.close();

            connmainhis.close();
        }catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_doctor_order_lab;
    }
    public PatientVisitPaid getPatientVisitPaidHospitalOS(String branch_id, ResultSet rs, Statement st, String billing_invoice_in){
        String sql="";
        try {
            patientvisitpaid = new PatientVisitPaid();
            sql = "Select ";
            rs = st.executeQuery(sql);
        }catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patientvisitpaid;
    }
    public Vector getPatientVisitPaid(String branch_id, String visit_date, String patient_hn_no, String vn_id){
        Vector v_patient_paid = new Vector();
        String vn_no="", vn_seq="", sql="";
        Integer i = vn_id.indexOf(".", 0);
        if(i>0){
            vn_no = vn_id.substring(0, i);
            vn_seq = vn_id.substring(i+1, vn_id.length());
            sql="Select pt01.mnc_hn_no,ft03.mnc_fn_typ_cd, sum(mnc_fn_pad) as paid, "
                +"fm02.mnc_fn_typ_dsc, sum(ft03.mnc_fn_amt) as mnc_fn_amt "
                +"From finance_t03 ft03 left join patient_t01 pt01 on ft03.mnc_hn_no = pt01.mnc_hn_no "
                +"and ft03.mnc_hn_yr = pt01.mnc_hn_yr and ft03.mnc_pre_no = pt01.mnc_pre_no "
                +"left join finance_m02 fm02 on ft03.mnc_fn_typ_cd = fm02.mnc_fn_typ_cd "
                +"Where ft03.mnc_hn_no = '"+patient_hn_no+"' and ft03.mnc_date = '"+visit_date+"' and "
                +"pt01.mnc_vn_no = '"+vn_no+"' and pt01.mnc_vn_seq='"+vn_seq+"' "
                +"Group by pt01.mnc_hn_no,ft03.mnc_fn_typ_cd, fm02.mnc_fn_typ_dsc ";
        }else{
            sql="Select pt01.mnc_hn_no,ft03.mnc_fn_typ_cd, sum(mnc_fn_pad) as paid, "
                +"fm02.mnc_fn_typ_dsc, sum(ft03.mnc_fn_amt) as mnc_fn_amt "
                +"From finance_t03 ft03 left join patient_t01 pt01 on ft03.mnc_hn_no = pt01.mnc_hn_no "
                +"and ft03.mnc_hn_yr = pt01.mnc_hn_yr and ft03.mnc_pre_no = pt01.mnc_pre_no "
                +"left join finance_m02 fm02 on ft03.mnc_fn_typ_cd = fm02.mnc_fn_typ_cd "
                +"Where ft03.mnc_hn_no = '"+patient_hn_no+"' and ft03.mnc_date = '"+visit_date+"' "
                +"Group by pt01.mnc_hn_no,ft03.mnc_fn_typ_cd, fm02.mnc_fn_typ_dsc ";
        }
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        PatientVisitPaid patientvisitpaid = new PatientVisitPaid();
        try {
            connmainhis = getConnectionMainHIS(branch_id);
            stmainhis = connmainhis.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                patientvisitpaid = new PatientVisitPaid();
                patientvisitpaid.setPatientId(rsmainhis.getString("MNC_HN_NO"));
                patientvisitpaid.setPaidId(rsmainhis.getString("mnc_fn_typ_cd"));
                patientvisitpaid.setPaidNamet(rsmainhis.getString("mnc_fn_typ_dsc"));
//                patientvisitpaid.setPatientId(rsmainhis.getString("mnc_hn_no"));
                patientvisitpaid.setAmount(Double.parseDouble(rsmainhis.getString("mnc_fn_amt")));
                patientvisitpaid.setPaid(Double.parseDouble(rsmainhis.getString("paid")));                
                patientvisitpaid.setPaidDate(visit_date);
                v_patient_paid.add(patientvisitpaid);
            }
            rsmainhis.close();

            if(patient_hn_no.equals("1768725")){
                sql="";
            }
            sql = "Select mnc_dis_tot From finance_t01 Where mnc_hn_no = '"+patient_hn_no+"' and mnc_date = '"+visit_date+"' ";
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                patientvisitpaid.discount = Double.parseDouble(rsmainhis.getString("mnc_dis_tot"));
            }
            rsmainhis.close();
            connmainhis.close();
        }
        catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_patient_paid;
    }
    public Vector getPatientVisitPaidByItem(String branch_id, String visit_date, String patient_hn_no, String vn_id){
        Vector v_patient_paid = new Vector();
        String vn_no="", vn_seq="";
        Integer i = vn_id.indexOf(".", 0);
        if(i>0){
            vn_no = vn_id.substring(0, i);
            vn_seq = vn_id.substring(i+1, vn_id.length());
        }
        String sql="Select pt01.mnc_hn_no,ft03.mnc_fn_cd, mnc_fn_pad as paid, "
                +"fm01.mnc_fn_dsct, ft03.mnc_fn_amt "
                +"From finance_t03 ft03 left join patient_t01 pt01 on ft03.mnc_hn_no = pt01.mnc_hn_no "
                +"and ft03.mnc_hn_yr = pt01.mnc_hn_yr and ft03.mnc_pre_no = pt01.mnc_pre_no "
                +"left join finance_m01 fm01 on ft03.mnc_fn_cd = fm01.mnc_fn_cd "
                +"Where ft03.mnc_hn_no = '"+patient_hn_no+"' and ft03.mnc_date = '"+visit_date+"' and "
                +"pt01.mnc_vn_no = '"+vn_no+"' and pt01.mnc_vn_seq='"+vn_seq+"' ";
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        PatientVisitPaid patientvisitpaid = new PatientVisitPaid();
        try {
            connmainhis = getConnectionMainHIS(branch_id);
            stmainhis = connmainhis.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()) {
                patientvisitpaid = new PatientVisitPaid();
                patientvisitpaid.setPatientId(rsmainhis.getString("MNC_HN_NO"));
                patientvisitpaid.setItemId(rsmainhis.getString("mnc_fn_cd"));
                patientvisitpaid.setItemNamet(rsmainhis.getString("mnc_fn_dsct"));
//                patientvisitpaid.setPatientId(rsmainhis.getString("mnc_hn_no"));
                patientvisitpaid.setAmount(Double.parseDouble(rsmainhis.getString("mnc_fn_amt")));
                patientvisitpaid.setPaid(Double.parseDouble(rsmainhis.getString("paid")));                
                patientvisitpaid.setPaidDate(visit_date);
                v_patient_paid.add(patientvisitpaid);
            }
            rsmainhis.close();

            connmainhis.close();
        }
        catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_patient_paid;
    }
    public PatientVisitPaid getPatientVisitPaidByVn(String branch_id, String visit_date, String patient_hn_no, String vn_id) {
        Vector v_patient_paid = new Vector();
        String vn_no="", vn_seq="";
        Integer i = vn_id.indexOf(".", 0);
        if(i>0){
            vn_no = vn_id.substring(0, i);
            vn_seq = vn_id.substring(i+1, vn_id.length());
        }
        String sql="Select pt01.mnc_hn_no,ft03.mnc_fn_cd, sum(ft03.mnc_fn_pad) as paid, "
                +"fm01.mnc_fn_dsct, sum(ft03.mnc_fn_amt) as mnc_fn_amt "
                +"From finance_t03 ft03 left join patient_t01 pt01 on ft03.mnc_hn_no = pt01.mnc_hn_no "
                +"and ft03.mnc_hn_yr = pt01.mnc_hn_yr and ft03.mnc_pre_no = pt01.mnc_pre_no "
                +"left join finance_m01 fm01 on ft03.mnc_fn_cd = fm01.mnc_fn_cd "
                +"Where ft03.mnc_hn_no = '"+patient_hn_no+"' and ft03.mnc_date = '"+visit_date+"' and "
                +"pt01.mnc_vn_no = '"+vn_no+"' and pt01.mnc_vn_seq='"+vn_seq+"' " +
                "Group By pt01.mnc_hn_no,ft03.mnc_fn_cd, fm01.mnc_fn_dsct";
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        PatientVisitPaid patientvisitpaid = new PatientVisitPaid();
        try {
            connmainhis = getConnectionMainHIS(branch_id);
            stmainhis = connmainhis.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()) {
                patientvisitpaid = new PatientVisitPaid();
                patientvisitpaid.setPatientId(rsmainhis.getString("MNC_HN_NO"));
                patientvisitpaid.setItemId(rsmainhis.getString("mnc_fn_cd"));
                patientvisitpaid.setItemNamet(rsmainhis.getString("mnc_fn_dsct"));
//                patientvisitpaid.setPatientId(rsmainhis.getString("mnc_hn_no"));
                patientvisitpaid.setAmount(Double.parseDouble(rsmainhis.getString("mnc_fn_amt")));
                patientvisitpaid.setPaid(Double.parseDouble(rsmainhis.getString("paid")));
                patientvisitpaid.setPaidDate(visit_date);
//                v_patient_paid.add(patientvisitpaid);
            }
            rsmainhis.close();
            connmainhis.close();
        }
        catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patientvisitpaid;
    }
    public PatientVisitPaid getPatientVisitPaidByVn(Connection conn, Statement st, String branch_id, String visit_date, String patient_hn_no, String vn_id) {
        Vector v_patient_paid = new Vector();
        String vn_no="", vn_seq="";
        Integer i = vn_id.indexOf(".", 0);
        if(i>0){
            vn_no = vn_id.substring(0, i);
            vn_seq = vn_id.substring(i+1, vn_id.length());
        }
        String sql="Select pt01.mnc_hn_no,ft03.mnc_fn_cd, sum(ft03.mnc_fn_pad) as paid, "
                +"fm01.mnc_fn_dsct, sum(ft03.mnc_fn_amt) as mnc_fn_amt "
                +"From finance_t03 ft03 left join patient_t01 pt01 on ft03.mnc_hn_no = pt01.mnc_hn_no "
                +"and ft03.mnc_hn_yr = pt01.mnc_hn_yr and ft03.mnc_pre_no = pt01.mnc_pre_no "
                +"left join finance_m01 fm01 on ft03.mnc_fn_cd = fm01.mnc_fn_cd "
                +"Where ft03.mnc_hn_no = '"+patient_hn_no+"' and ft03.mnc_date = '"+visit_date+"' and "
                +"pt01.mnc_vn_no = '"+vn_no+"' and pt01.mnc_vn_seq='"+vn_seq+"' " +
                "Group By pt01.mnc_hn_no,ft03.mnc_fn_cd, fm01.mnc_fn_dsct";
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        PatientVisitPaid patientvisitpaid = new PatientVisitPaid();
        try {
//            connmainhis = getConnectionMainHIS(conn, st, branch_id);
            connmainhis = conn;
            stmainhis = connmainhis.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()) {
                patientvisitpaid = new PatientVisitPaid();
                patientvisitpaid.setPatientId(rsmainhis.getString("MNC_HN_NO"));
                patientvisitpaid.setItemId(rsmainhis.getString("mnc_fn_cd"));
                patientvisitpaid.setItemNamet(rsmainhis.getString("mnc_fn_dsct"));
//                patientvisitpaid.setPatientId(rsmainhis.getString("mnc_hn_no"));
                patientvisitpaid.setAmount(Double.parseDouble(rsmainhis.getString("mnc_fn_amt")));
                patientvisitpaid.setPaid(Double.parseDouble(rsmainhis.getString("paid")));
                patientvisitpaid.setPaidDate(visit_date);
//                v_patient_paid.add(patientvisitpaid);
            }
            rsmainhis.close();
            sql = "Select mnc_dis_tot From finance_t01 Where mnc_hn_no = '"+patient_hn_no+"' and mnc_date = '"+visit_date+"' ";
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                patientvisitpaid.discount = Double.parseDouble("-"+rsmainhis.getString("mnc_dis_tot"));
            }
//            connmainhis.close();
        }catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patientvisitpaid;
    }
    public Vector SearchPaitentinWard(String branch_id,String date_start, String ward1, String flag, String ward_no, String room_id, String bed_id){
        String sql="", txt="", searchWard="", searchRoom="", searchBed="", searchHnno="";
        String where="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
//        Ward ward = new Ward();
        PatientVisit patientvisit = new PatientVisit();
        try {
//            if(branch.getBranchProgram().equals("hospital_osv3")){
//                conn = getConnectionHospital(branch_id);
//                if(!ward_no.equals("")) searchWard = " and tv.b_visit_ward_id = '"+ward_no+"'";
//                if(!room_id.equals("")) searchRoom = " and tv.visit_bed = '"+room_id+"'";
//                if(!bed_id.equals("")) searchBed = " and tv.visit_bed = '"+bed_id+"'";
//                if (flag.equals("hnno_bed")) searchHnno = " and tv.visit_hn = '"+ward1+"' ";
//                sql = "Select tv.visit_hn as no, fpp.patient_prefix_description || tp.patient_firstname || ' ' || tp.patient_lastname as name, "
//                        + "tv.b_contract_plans_id as mnc_fn_typ_cd, bcp.contract_plans_description as mnc_fn_typ_dsc, "
//                        + "tv.b_visit_ward_id as mnc_wd_no, bvw.visit_ward_description as mnc_md_dep_dsc,visit_bed "
//                        + "From t_visit tv "
//                        + "Left Join t_patient tp on tv.t_patient_id = tp.t_patient_id "
//                        + "Left Join f_patient_prefix fpp on fpp.f_patient_prefix_id = tp.f_patient_prefix_id "
//                        + "Left Join b_contract_plans bcp on bcp.b_contract_plans_id = tv.b_contract_plans_id "
//                        + "Left Join b_visit_ward bvw on bvw.b_visit_ward_id = tv.b_visit_ward_id "
//                        + "Where tv.f_visit_status_id = '1' and tv.f_visit_type_id = '1' "+searchWard+searchRoom+searchBed+searchHnno;
//                st = conn.createStatement();
//            }else{
                conn = getConnectionMainHIS(branch_id);
                //conn = config1.getConnectionBangna();
                st = conn.createStatement();
                if(flag.equals("ward")){
                    sql = "Select mnc_wd_no as no, pm32.mnc_md_dep_dsc as name "
                            +"From patient_t08 pt08  inner join patient_m01  pm01 on pt08.mnc_hn_no = pm01.mnc_hn_no "
                            +"left join patient_m02  pm02 on pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd "
                            +"left join patient_m32  pm32 on pt08.mnc_wd_no = pm32.mnc_md_dep_no "
                            +"Where mnc_ds_date is null "
                            +"Group by mnc_wd_no, pm32.mnc_md_dep_dsc ";
                }else if(flag.equals("ward_name")) {
                    sql = "Select mnc_wd_no as no, pm32.mnc_md_dep_dsc as name "
                            +"From patient_t08 pt08  inner join patient_m01  pm01 on pt08.mnc_hn_no = pm01.mnc_hn_no "
                            +"left join patient_m02  pm02 on pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd "
                            +"left join patient_m32  pm32 on pt08.mnc_wd_no = pm32.mnc_md_dep_no "
                            +"Where mnc_ds_date is null "
                            +"Group by mnc_wd_no, pm32.mnc_md_dep_dsc ";
//                }else if (flag.equals("hnno")) {
                }else if (flag.equals("hnno") || (flag.equals("hnno_bed"))) {
                    if(ward_no.equals("")) {
                        sql = "Select pt08.mnc_hn_no as no, mnc_ds_date, mnc_ds_lev, mnc_wd_no, "
                            +"pm02.mnc_pfix_dsc + ' ' + pm01.mnc_fname_t + ' '+ pm01.mnc_lname_t as name, "
                            +"pm32.mnc_md_dep_dsc, pt08.mnc_fn_typ_cd, fm02.mnc_fn_typ_dsc, '' as visit_bed "
                            +"From patient_t08  pt08 inner join patient_m01  pm01 on pt08.mnc_hn_no = pm01.mnc_hn_no "
                            +"left join patient_m02 pm02 on pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd "
                            +"left join patient_m32 pm32 on pt08.mnc_wd_no = pm32.mnc_md_dep_no "
                            +"left join finance_m02 fm02 on pt08.mnc_fn_typ_cd = fm02.mnc_fn_typ_cd "
                            +"Where mnc_ds_date  is null ";
                    }else {
                        if(!room_id.equals("")) {
                            where = " and mnc_rm_nam = '"+room_id+"' ";
                        }
                        if(!bed_id.equals("")) {
                            where += " and mnc_bd_no = '"+bed_id+"' ";
                        }
                        if(!ward1.equals("")) {//hnno
                            where += " and pt08.mnc_hn_no = '"+ward1+"' ";
                        }
                        if(!ward_no.equals("")) {//ward
                            where += " and pt08.mnc_wd_no = '"+ward_no+"' ";
                        }
//                        sql = "Select pt08.mnc_hn_no as no, mnc_ds_date, mnc_ds_lev, mnc_wd_no, "
//                            +"pm02.mnc_pfix_dsc + ' ' + pm01.mnc_fname_t + ' '+ pm01.mnc_lname_t as name, "
//                            +"pm32.mnc_md_dep_dsc, pt08.mnc_fn_typ_cd, fm02.mnc_fn_typ_dsc, '' as visit_bed "
//                            +"From patient_t08 pt08 inner join patient_m01  pm01 on pt08.mnc_hn_no = pm01.mnc_hn_no "
//                            +"left join patient_m02 pm02 on pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd "
//                            +"left join patient_m32 pm32 on pt08.mnc_wd_no = pm32.mnc_md_dep_no "
//                            +"left join finance_m02 fm02 on pt08.mnc_fn_typ_cd = fm02.mnc_fn_typ_cd "
//                            +"Where mnc_ds_date is null and mnc_wd_no = '"+ward_no+"' "+where;
                        sql = "Select pt08.mnc_hn_no as no, mnc_ds_date, mnc_ds_lev, mnc_wd_no, "
                            +"pm02.mnc_pfix_dsc + ' ' + pm01.mnc_fname_t + ' '+ pm01.mnc_lname_t as name, "
                            +"pm32.mnc_md_dep_dsc, pt08.mnc_fn_typ_cd, fm02.mnc_fn_typ_dsc, '' as visit_bed, pt08.mnc_rm_nam, pt08.mnc_bd_no "
                            +"From patient_t08 pt08 inner join patient_m01  pm01 on pt08.mnc_hn_no = pm01.mnc_hn_no "
                            +"left join patient_m02 pm02 on pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd "
                            +"left join patient_m32 pm32 on pt08.mnc_wd_no = pm32.mnc_md_dep_no "
                            +"left join finance_m02 fm02 on pt08.mnc_fn_typ_cd = fm02.mnc_fn_typ_cd "
                            +"Where mnc_ds_date is null  "+where;
                    }
                } else if(flag.equals("case_in_ward")){
                    sql = "Select pt08.mnc_hn_no as no, mnc_ds_date, mnc_ds_lev, mnc_wd_no, "
                            +"pm02.mnc_pfix_dsc + ' ' + pm01.mnc_fname_t + ' '+ pm01.mnc_lname_t as name, "
                            +"pm32.mnc_md_dep_dsc, pt08.mnc_fn_typ_cd, fm02.mnc_fn_typ_dsc, '' as visit_bed "
                            +"From patient_t08  pt08 inner join patient_m01  pm01 on pt08.mnc_hn_no = pm01.mnc_hn_no "
                            +"left join patient_m02 pm02 on pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd "
                            +"left join patient_m32 pm32 on pt08.mnc_wd_no = pm32.mnc_md_dep_no "
                            +"left join finance_m02 fm02 on pt08.mnc_fn_typ_cd = fm02.mnc_fn_typ_cd "
                            +"Where pt08.mnc_ds_date is null ";
                } else if(flag.equals("case_old")){
                    sql = "Select pt08.mnc_hn_no as no, mnc_ds_date, mnc_ds_lev, mnc_wd_no, "
                            +"pm02.mnc_pfix_dsc + ' ' + pm01.mnc_fname_t + ' '+ pm01.mnc_lname_t as name, "
                            +"pm32.mnc_md_dep_dsc, pt08.mnc_fn_typ_cd, fm02.mnc_fn_typ_dsc, '' as visit_bed "
                            +"From patient_t08  pt08 inner join patient_m01  pm01 on pt08.mnc_hn_no = pm01.mnc_hn_no "
                            +"left join patient_m02 pm02 on pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd "
                            +"left join patient_m32 pm32 on pt08.mnc_wd_no = pm32.mnc_md_dep_no "
                            +"left join finance_m02 fm02 on pt08.mnc_fn_typ_cd = fm02.mnc_fn_typ_cd "
                            +"Where pt08.mnc_ad_date >= '"+date_start+"' and '"+date_start+"' <= pt08.mnc_ds_date or pt08.mnc_ds_date is null ";
                }
//            }
            rs = st.executeQuery(sql);
            while(rs.next()){
                patientvisit = new PatientVisit();
                patientvisit.setPatientId(rs.getString("no"));
                patientvisit.setPatientHn(rs.getString("no"));
                patientvisit.setPatientNamet(rs.getString("name"));
                patientvisit.setVisitPaidId(rs.getString("mnc_fn_typ_cd"));
                patientvisit.setVisitPaidNamet(rs.getString("mnc_fn_typ_dsc"));
                patientvisit.setVisitClinicId(rs.getString("mnc_wd_no"));
                patientvisit.setVisitClinicNamet(rs.getString("mnc_md_dep_dsc"));
                patientvisit.wardName = rs.getString("mnc_wd_no");
//                if(branch.getBranchProgram().equals("hospital_osv3")){
//                    if(rs.getString("visit_bed").indexOf("-")>0){
//                        String[] text = rs.getString("visit_bed").split("-");
//                        patientvisit.bed = text[1];
//                        patientvisit.room = text[0];
//                    }else{
//                        patientvisit.bed = "-";
//                        patientvisit.room=rs.getString("visit_bed");
//                    }
//                }else{
                    patientvisit.bed = rs.getString("visit_bed");
                    patientvisit.room=rs.getString("mnc_md_dep_dsc");
//                }
                
                v_result.add(patientvisit);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public Vector SearchPaitentinRoom(String branch_id,String date_start, String ward1, String flag, String ward_no, String room_id, String bed_id){
        String sql="", txt="", searchWard="", searchRoom="", searchBed="", searchHnno="";
        String where="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
//        Ward ward = new Ward();
        PatientVisit patientvisit = new PatientVisit();
        try {
//            if(branch.getBranchProgram().equals("hospital_osv3")){
//                conn = getConnectionHospital(branch_id);
//                if(!ward_no.equals("")) searchWard = " and tv.b_visit_ward_id = '"+ward_no+"'";
//                if(!room_id.equals("")) searchRoom = " and tv.visit_bed = '"+room_id+"'";
//                if(!bed_id.equals("")) searchBed = " and tv.visit_bed = '"+bed_id+"'";
//                if (flag.equals("hnno_bed")) searchHnno = " and tv.visit_hn = '"+ward1+"' ";
//                sql = "Select tv.visit_hn as no, fpp.patient_prefix_description || tp.patient_firstname || ' ' || tp.patient_lastname as name, "
//                        + "tv.b_contract_plans_id as mnc_fn_typ_cd, bcp.contract_plans_description as mnc_fn_typ_dsc, "
//                        + "tv.b_visit_ward_id as mnc_wd_no, bvw.visit_ward_description as mnc_md_dep_dsc,visit_bed "
//                        + "From t_visit tv "
//                        + "Left Join t_patient tp on tv.t_patient_id = tp.t_patient_id "
//                        + "Left Join f_patient_prefix fpp on fpp.f_patient_prefix_id = tp.f_patient_prefix_id "
//                        + "Left Join b_contract_plans bcp on bcp.b_contract_plans_id = tv.b_contract_plans_id "
//                        + "Left Join b_visit_ward bvw on bvw.b_visit_ward_id = tv.b_visit_ward_id "
//                        + "Where tv.f_visit_status_id = '1' and tv.f_visit_type_id = '1' "+searchWard+searchRoom+searchBed+searchHnno;
//                st = conn.createStatement();
//            }else{
                conn = getConnectionMainHIS(branch_id);
                //conn = config1.getConnectionBangna();
                st = conn.createStatement();
                
//                        if(!ward1.equals("")) {//hnno
                where += " and pt08.mnc_hn_no = '"+ward1+"' ";
//                        }
//                        sql = "Select pt08.mnc_hn_no as no, mnc_ds_date, mnc_ds_lev, mnc_wd_no, "
//                            +"pm02.mnc_pfix_dsc + ' ' + pm01.mnc_fname_t + ' '+ pm01.mnc_lname_t as name, "
//                            +"pm32.mnc_md_dep_dsc, pt08.mnc_fn_typ_cd, fm02.mnc_fn_typ_dsc, '' as visit_bed "
//                            +"From patient_t08 pt08 inner join patient_m01  pm01 on pt08.mnc_hn_no = pm01.mnc_hn_no "
//                            +"left join patient_m02 pm02 on pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd "
//                            +"left join patient_m32 pm32 on pt08.mnc_wd_no = pm32.mnc_md_dep_no "
//                            +"left join finance_m02 fm02 on pt08.mnc_fn_typ_cd = fm02.mnc_fn_typ_cd "
//                            +"Where mnc_ds_date is null and mnc_wd_no = '"+ward_no+"' "+where;
                sql = "Select pt08.mnc_hn_no as no, mnc_ds_date, mnc_ds_lev, mnc_wd_no, "
                    +"pm02.mnc_pfix_dsc + ' ' + pm01.mnc_fname_t + ' '+ pm01.mnc_lname_t as name, "
                    +"pm32.mnc_md_dep_dsc, pt08.mnc_fn_typ_cd, fm02.mnc_fn_typ_dsc, '' as visit_bed, pt08.mnc_rm_nam, pt08.mnc_bd_no "
                    +"From patient_t08 pt08 inner join patient_m01  pm01 on pt08.mnc_hn_no = pm01.mnc_hn_no "
                    +"left join patient_m02 pm02 on pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd "
                    +"left join patient_m32 pm32 on pt08.mnc_wd_no = pm32.mnc_md_dep_no "
                    +"left join finance_m02 fm02 on pt08.mnc_fn_typ_cd = fm02.mnc_fn_typ_cd "
                    +"Where mnc_ds_date is null  "+where;
                    
//            }
            rs = st.executeQuery(sql);
            while(rs.next()){
                patientvisit = new PatientVisit();
                patientvisit.setPatientId(rs.getString("no"));
                patientvisit.setPatientHn(rs.getString("no"));
                patientvisit.setPatientNamet(rs.getString("name"));
                patientvisit.setVisitPaidId(rs.getString("mnc_fn_typ_cd"));
                patientvisit.setVisitPaidNamet(rs.getString("mnc_fn_typ_dsc"));
                patientvisit.setVisitClinicId(rs.getString("mnc_wd_no"));
                patientvisit.setVisitClinicNamet(rs.getString("mnc_md_dep_dsc"));
                patientvisit.wardName = rs.getString("mnc_wd_no");
//                if(branch.getBranchProgram().equals("hospital_osv3")){
//                    if(rs.getString("visit_bed").indexOf("-")>0){
//                        String[] text = rs.getString("visit_bed").split("-");
//                        patientvisit.bed = text[1];
//                        patientvisit.room = text[0];
//                    }else{
//                        patientvisit.bed = "-";
//                        patientvisit.room=rs.getString("visit_bed");
//                    }
//                }else{
                    patientvisit.bed = rs.getString("mnc_bd_no");
                    patientvisit.room=rs.getString("mnc_rm_nam");
//                }
                
                v_result.add(patientvisit);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String CboPatientinWard(String branch_id, String date_start, String flag, String selected, String ward_no, String room_id, String bed_id) throws Exception{
        String txt="",sql="";
        Vector v_paitent = new Vector();
        PatientVisit patientvisit = new PatientVisit();
        //Ward ward = new Ward();
        branch = getBranch(branch_id);
        v_paitent = SearchPaitentinWard(branch_id,date_start,"",flag, ward_no, room_id, bed_id);
        txt += "<option value='' ></option>";
        for(int i=0;i<=v_paitent.size()-1;i++) {
            patientvisit = (PatientVisit) v_paitent.get(i);
            if(patientvisit.getPatientId().equals(selected)){
                txt += "<option value='"+patientvisit.getPatientId()+"' selected>"+patientvisit.getPatientNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+patientvisit.getPatientId()+"' >"+patientvisit.getPatientNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public String NumberFormatRemove(String txt){
        String text="";
        if(txt.equals("")){
            txt = "0.0";
        }
        text = txt.replace(",", "");
        return text;
    }
    public String NumberFormat(Object txt){
//        String text=txt.toString();
//        Double num=0.0;
        try{
            if(txt.toString().equals("")){
                num = 0.0;
            }else if(txt == null){
                num=0.0;
            }else if(txt.toString().equals("-")){
                return "-";
            }else{
                num = Double.parseDouble(txt.toString());
            }
            return df.format(num);
        }catch(Exception ex){
            return txt.toString();
        }
        
    }
    public String NumberFormatN(Object txt,String flag){
//        String text=txt.toString();
//        Double num=0.0;
        try{
            if(txt.toString().equals("")){
    //            num = 0.0;
                return "";
            }else if(txt == null){
    //            num=0.0;
                return "";
            }else if(txt.toString().equals("-")){
    //            num=0.0;
                return "-";
            }else{
                num = Double.parseDouble(txt.toString());
            }
            if(flag.equals(".x")) return df1.format(num);
            else if(flag.equals(".xx")) return df2.format(num);
            else if(flag.equals(".xxx")) return df3.format(num);
            else return df.format(num);
        }catch(Exception ex){
            return txt.toString();
        }
    }
    public String IntegerFormat(Object txt){
        Double num=0.0;
        String text=txt.toString();
        try{
            if(text.equals("")){
                num = 0.0;
            }else if(txt == null){
                num=0.0;
            }else if(txt.toString().equals("-")){
                return "-";
            }else{
                num = Double.parseDouble(text);
            }
            return intf.format(num);
        }catch(Exception ex){
            return txt.toString();
        }
    }
    public String StringFormat(String text,String formater) {
        String format="";
        try{
            format = text;
            if(formater.equals("number")) {
//                NumberFormat formatter = new DecimalFormat("#,###,###.##");
                format = df.format((Object) text);
            }else if(formater.equals("integer")) {
                NumberFormat formatter = new DecimalFormat("#,###,###");
                format = formatter.format(text);
            }
        }
        catch(Exception ex){
            format = text;
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return format;
    }
    public String setSaveFAddress(Vector item, String flagpage) throws Exception {
        int chk=0;
        String sql="", max="", dental_date="";
        FAddress address = new FAddress();
        Connection conn;
        Statement st;
        try {
            conn = getConnectionBangna();
            st = conn.createStatement();
//            address = getDentalDailyByPK(item.getDentalDailyId());
            for(int i=0;i<=item.size()-1;i++){
                address = new FAddress();
                address = (FAddress)item.get(i);
                address.setAddressDescription(address.getAddressDescription().replace("'", "''"));
                address.setAddressDescriptione(address.getAddressDescriptione().replace("'", "''"));
    //            dental_date=config1.DateFormatShow2DB(item.getDentalDate(), "ddMMyyyy");

                if(!address.getFAddressId().equals("")){
    //                max = getMaxRowDentalDaily(conn);
                    sql="Insert Into "+address.getFAddress()+"("
                            +address.getFAddressAmphurId()+", "+address.getFAddressChangwatId()+", "
                            +address.getFAddressDescription()+","+ address.getFAddressDescriptione()+","
                            +address.getFFAddressId()+","+ address.getFAddressRegion()+","
                            +address.getFAddressTambonType()+") "
                            +"Values('"+address.getAddressAmphurId()+"','"+address.getAddressChangwatId() + "','"
                            +address.getAddressDescription()+"','"+address.getAddressDescriptione() + "','"
                            +address.getFAddressId()+"','"+address.getAddressRegion() + "','"
                            +address.getAddressTambonType()+"') ";
                }
                chk = st.executeUpdate(sql);
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public static String Ascii2Unicode(String ascii) throws Exception{
        StringBuffer unicode = new StringBuffer(ascii);
        int code;
        for(int i = 0; i < ascii.length(); i++){
            code = (int)ascii.charAt(i);
            if ((0xA1 <= code) && (code <= 0xFB))
            unicode.setCharAt( i, (char)(code + 0xD60));
        }
        return unicode.toString();
    }
    public static String Unicode2Ascii(String unicode)throws Exception{
        StringBuffer ascii = new StringBuffer(unicode);
        int code;
        for(int i = 0; i < unicode.length(); i++) {
            code = (int)unicode.charAt(i);
            if ((0xA1 <= code) && (code <= 0xFB))
            ascii.setCharAt( i, (char)(code + 0xD60));
        }
        return ascii.toString();
    }
    public Boolean setFileDelete(String filename) {
        boolean exists = (new File(filename)).exists();
        boolean success = false;
        if (exists) success = (new File(filename)).delete();
        else success = true;
        return success;
    }
    public boolean fileExist(String filename) {
      try {
         File file = new File(filename);
         return (!file.isDirectory() && file.exists());
      } catch (Exception ex){
         return false;
      }
    }
    public boolean fileCreate(String filename, String data){
        if(fileExist(filename)){
            setFileDelete(filename);
        }
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(filename);
            fos.write(data.getBytes());
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public String getPaidShortName(String paid_namet){
//        String aaa="";
        if(paid_namet == null) return "";
        if(paid_namet.equals("ประกันสังคมบางนา 2")){
            return "ปกส2";
        }else if(paid_namet.equals("ประกันสังคมบางนา 1")){
            return "ปกส1";
        }else if(paid_namet.equals("ประกันสังคมบางนา 5")){
            return "ปกส5";
        }else if(paid_namet.equals("อเมริกันอินเตอร์แนชชั่นแนลแอลชัวรัน")){
            return "AIA";
        }else if(paid_namet.equals("ไทยพาณิชย์นิวยอร์คไลฟ์ประกันชีวิต")){
            return "ไทยพาณิชย์น";
        }else if(paid_namet.equals("ประกันตนอิสระบางนา 2")){//โตเกียวมารีนศรีเมืองประกันภัย
            return "ปกต2";
        }else if(paid_namet.equals("ประกันตนอิสระบางนา 5")){//โตเกียวมารีนศรีเมืองประกันภัย
            return "ปกต5";
        }else if(paid_namet.equals("มิตซุย ซัมมิทโตโม้ ประกันภัย")){//มิตซุย ซัมมิทโตโม้ ประกันภัย
            return "มิตซุย";
        }else if(paid_namet.equals("โตเกียวมารีนศรีเมืองประกันภัย")){//มิตซุย ซัมมิทโตโม้ ประกันภัย
            return "โตเกียว";
        }else if(paid_namet.equals("โตเกียวมารีนประกันชีวิต")){//มิตซุย ซัมมิทโตโม้ ประกันภัย
            return "โตเกียว1";
        }else if(paid_namet.equals("ซัมมิทโตโม้ ประกันภัย")){//มิตซุย ซัมมิทโตโม้ ประกันภัย
            return "โตเกียว";
        }else if(paid_namet.equals("ตรวจสุขภาพ (เงินสด)")){//มิตซุย ซัมมิทโตโม้ ประกันภัย
            return "ตส งส";
        }else if(paid_namet.equals("พรบ.กลางคุ้มครองผู้ประสบภัยจากรถ")){//มิตซุย ซัมมิทโตโม้ ประกันภัย
            return "พรบ";
        }else if(paid_namet.equals("บูพา ประกันสุขภาพ")){//มิตซุย ซัมมิทโตโม้ ประกันภัย
            return "บูพา";
        }else if(paid_namet.equals("ลูกหนี้ UC บางนา 3")){//มิตซุย ซัมมิทโตโม้ ประกันภัย
            return "ลนUCบน3";
        }else if(paid_namet.equals("สยามประกันชีวิต")){//มิตซุย ซัมมิทโตโม้ ประกันภัย
            return "สยาม";
        }else if(paid_namet.equals("ตรวจสุขภาพ(Package)")){//มิตซุย ซัมมิทโตโม้ ประกันภัย
            return "ตส PK";
        }else if (paid_namet.equals("กรุงเทพประกันชีวิต")) {//มิตซุย ซัมมิทโตโม้ ประกันภัย
            return "กรุงเทพ";
        }else if (paid_namet.equals("ประกันตนอิสระบางนา 1")) {//มิตซุย ซัมมิทโตโม้ ประกันภัย
            return "ปกต1";
        }else if (paid_namet.equals("UC ฉุกเฉินมาตรา 7")) {//มิตซุย ซัมมิทโตโม้ ประกันภัย
            return "UCฉ7.";
        }else if (paid_namet.equals("วิริยะประกันภัย")) {//มิตซุย ซัมมิทโตโม้ ประกันภัย
            return "วิริยะ";
        }else if (paid_namet.equals("เมืองไทยประกันชีวิต")) {//อยุธยาอลิอันซ์ ซี.พี. ประกันชีวิต
            return "เมืองไทย";
        }else if (paid_namet.equals("อยุธยาอลิอันซ์ ซี.พี. ประกันชีวิต")) {//ไทยรี เซอร์วิส จำกัด
            return "อยุธยา";
        }else if (paid_namet.equals("ไทยรี เซอร์วิส จำกัด")) {//ลิเบอร์ตี้ประกันภัย
            return "ไทยรี";
        }else if (paid_namet.equals("ลิเบอร์ตี้ประกันภัย")) {//ไทยพาณิชย์สามัคคีประกันภัย
            return "ลิเบอร์ตี้";
        }else if (paid_namet.equals("ไทยพาณิชย์สามัคคีประกันภัย")) {//สัญญาบริษัท
            return "ไทยพาณิชย์ส";
        }else if (paid_namet.equals("สัญญาบริษัท")) {//ลูกหนี้บางนา 1
            return "สบ";
        }else if (paid_namet.equals("ลูกหนี้บางนา 1")) {//เอ.พี.เอฟ. อินเตอร์แนชั่นแนลประกันภัย
            return "ลห บน1";
        }else if (paid_namet.equals("ลูกหนี้บางนา 2")) {//เอ.พี.เอฟ. อินเตอร์แนชั่นแนลประกันภัย
            return "ลห บน2";
        }else if (paid_namet.equals("เอ.พี.เอฟ. อินเตอร์แนชั่นแนลประกันภัย")) {//ไทยประกันชีวิต
            return "APF";
        }else if (paid_namet.equals("ไทยประกันชีวิต")) {//พรบ.เทเวศประกันภัย
            return "ไทยประกัน";
        }else if (paid_namet.equals("พรบ.เทเวศประกันภัย")) {//พินันซ่าประกันชีวิต
            return "พรบ.เทเวศ";
        }else if (paid_namet.equals("พินันซ่าประกันชีวิต")) {//พินันซ่าประกันชีวิต
            return "พินันซ่า";
        }else if (paid_namet.equals("พนักงาน (เงินสด)")) {//พินันซ่าประกันชีวิต
            return "พนก งส";
        }else if(paid_namet.equals("บริษัทประกัน")){//ปกส.เมืองสมุทรปากน้ำ
            return "บ.ประกัน";
        }else if(paid_namet.equals("ปกส.เมืองสมุทรปากน้ำ")){//ตรวจสุขภาพ(บริษัท)
            return "ปกส.ปากน้ำ";
        }else if(paid_namet.equals("ปกส.เมืองสมุทรปู่เจ้า")){//ตรวจสุขภาพ(บริษัท)
            return "ปกส.ปู่เจ้า";
        }else if(paid_namet.equals("ตรวจสุขภาพ(บริษัท)")){//ตรวจสุขภาพโปรแกรม
            return "ตส บริษัท";
        }else if(paid_namet.equals("ตรวจสุขภาพโปรแกรม")){//ตรวจสุขภาพโปรแกรม
            return "ตส โปรแกรม";
        }else{
            return paid_namet;
        }
    }
    public Vector getFAddress(String branch_id, String flag){
        String sql="", txt="";
        Vector v_address = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        FAddress address = new FAddress();
        try {
//            conn = getConnectionHospital("103004");
            conn = getConnectionBangna();
            st = conn.createStatement();
            sql = "Select * "
                    +"From "+address.getFAddress()+" "
                    +"Where "+address.getFAddressTambonType()+"='"+flag+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                address = new FAddress();
                address.setFAddressId(rs.getString(address.getFFAddressId()));
                address.setAddressAmphurId(rs.getString(address.getFAddressAmphurId()));
                address.setAddressChangwatId(rs.getString(address.getFAddressChangwatId()));
                address.setAddressDescription(rs.getString(address.getFAddressDescription()));
                address.setAddressDescriptione(rs.getString(address.getFAddressDescriptione()));

                address.setAddressRegion(rs.getString(address.getFAddressRegion()));
                address.setAddressTambonType(rs.getString(address.getFAddressTambonType()));
                v_address.add(address);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_address;
    }
    public Vector getBServicePoint(String branch_id){
        String sql="";
        Vector v_b_service_point = new Vector();
        BServicePoint b_service_point = new BServicePoint();
        sql = "Select * From "+b_service_point.getBServicePoint()
                +" Where "+b_service_point.getFServicePointActive()+"='1' "
                + "Order By "+b_service_point.getFServicePointDescription();
        Connection conn = null;
        Statement st;
        ResultSet rs;
//        Vector v_patient_visit_department = new Vector();
        try {
            branch = getBranch(branch_id);
            if(branch.getBranchProgram().equals("hospital_osv3")) {
                conn = getConnectionHospital(branch_id);
            }else {
                
            }
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                b_service_point = new BServicePoint();
                b_service_point.setBServicePointId(rs.getString(b_service_point.getFBServicePointId()));
                b_service_point.setFServiceGroupId(rs.getString(b_service_point.getFFServerGroupId()));
                b_service_point.setFServiceSubgroupId(rs.getString(b_service_point.getFFServiceSubgroupId()));
                b_service_point.setServicePointActive(rs.getString(b_service_point.getFServicePointActive()));
                b_service_point.setServicePointDescription(rs.getString(b_service_point.getFServicePointDescription()));
                b_service_point.setServicePointNumber(rs.getString(b_service_point.getFSrevicePointNumber()));
                v_b_service_point.add(b_service_point);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_b_service_point;
    }
    public static void setNextFocus(KeyEvent evt,JComponent jc,JComponent jc_up,JComponent jc_left
            ,JComponent jc_down,JComponent jc_right){
        boolean is_up = true;
        boolean is_down = true;
        boolean is_left = true;
        boolean is_right = true;
        boolean is_enter = true;
        //???????????????? dropdown ???
        if(jc instanceof JComboBox) {
            JComboBox jcbox = (JComboBox)jc;
            is_enter = !jcbox.isPopupVisible();
            is_up = !jcbox.isPopupVisible();
            is_down = false;
        } else if(jc instanceof JTextField) {
            int curr = ((JTextField)jc).getCaretPosition();
            int length = ((JTextField)jc).getText().length();
            is_left = (curr==0);
            is_right = (curr==length);
        }
        if(evt.getKeyCode()==evt.VK_UP && jc_up!=null && is_up)
            jc_up.requestFocus();
        if(evt.getKeyCode()==evt.VK_LEFT && jc_left!=null && is_left)
            jc_left.requestFocus();
        if(evt.getKeyCode()==evt.VK_DOWN && jc_down!=null && is_down)
            jc_down.requestFocus();
        if(evt.getKeyCode()==evt.VK_RIGHT && jc_right!=null && is_right)
            jc_right.requestFocus();
        if(evt.getKeyCode()==evt.VK_ENTER && jc_down!=null && is_enter)
            jc_down.requestFocus();
    }
    public static String readCurrencyInThai(double num, String toun, String satang) {
        try {
            java.text.NumberFormat nf = java.text.NumberFormat.getNumberInstance();
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);
            nf.setGroupingUsed(false);
            String tmp = nf.format(num);
            StringBuffer buff = new StringBuffer();
            String front;
            String back;
            String number[] = {"", "หนึ่ง", "สอง", "สาม", "สี่", "ห้า", "หก", "เจ็ด", "แปด", "เก้า"};
            String unit[] = {"", "สิบ", "ร้อย", "พัน", "หมื่น", "แสน", "ล้าน"};
            String yi = "ยี่";
            String ed = "เอ็ด";
            String point = "จุด";

            // ?????????????
            int dot = tmp.indexOf(".");
            if(dot!=-1) {
                front = tmp.substring(0, dot);
                back = tmp.substring(dot+1);
            } else {
                front = tmp;
                back = "";
            }

            // ????????
            char[] f = front.toCharArray();
            for(int i=0; i<f.length; i++) {
                // ????????????
                int a = Integer.parseInt(String.valueOf(f[i]));

                // ??????? ?? ??????? 2
                if(a==2 && f.length-i==2)                buff.append(yi);
                // ??????? ??? ??????? 1 ???????
                else if(a==1 && f.length-i==1 && f.length==1)           buff.append(number[1]);
                // ??????? ??? ??????? 2
                else if(a==1 && f.length-i==2)           buff.append("");
                // ??????? ??? ??????? 1
                else if(a==1 && f.length-i==1)           buff.append(ed);

                else                                     buff.append(number[a]);

                // ??????????????????????????????????
                if(f.length<=7) {
                    if(a!=0) {
                        buff.append(unit[f.length-i-1]);
                    }
                } else {
                    //buff.append(number[a]);
                }
            }

            // ????????
            int b = Integer.parseInt(back);
            if(b==0) {
                buff.append(toun);
            } else {
                buff.append(point);
                String bb = nf.format(b);
                char[] bbb = bb.toCharArray();
                for(int i=0; i < bbb.length; i++) {
                    // ????????????
                    // Constant.println("?????? ojika : " + String.valueOf(bbb[i]) + "???????" + bbb.length);
                    if(!String.valueOf(bbb[i]).equals(".")) {
                        int c = Integer.parseInt(String.valueOf(bbb[i]));

                        // ??????? ?? ??????? 2
                        if(c==2 && i==0)
                            buff.append(yi);
                        // ??????? ??? ??????? 2
                        else if(c==1 && i==0)
                            buff.append("");
                        // ??????? ??? ??????? 1
                        else if(c==1 && i==1)
                            buff.append(ed);
                        else
                            buff.append(number[c]);
                        // ??????????????????????????????????
                        if(i == 0) {
                            if(c!=0) {
                                buff.append(unit[1]);
                            }
                        }
                    }
                }
                buff.append(satang);
            }
            return buff.toString();
        } catch(Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    public Integer convertTime(String time){
        Integer timei=0;
        try{
            time = time.replace(":", "");
            if(time.substring(0, 1).equals("0")){
                time = time.substring(1);
            }
            timei = Integer.parseInt(time);
        } catch(Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return timei;
    }
    public String getDateDiffN(String dateCal,String dateDiff){
        String sql="Select cast('"+dateCal+"' as date) + cast('"+dateDiff+" day' as interval) as cur; ", date="";
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        try {
            connmainhis = getConnectionBangna();
            stmainhis = connmainhis.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                date = rsmainhis.getString("cur");
            }
            rsmainhis.close();
            connmainhis.close();
        }
        catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    public String getDateDiffN1(String dateStart,String dateEnd){
        String sql="Select cast('"+dateEnd+"' as date) - cast('"+dateStart+"' as date) as cur; ", date="";
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        try {
            connmainhis = getConnectionBangna();
            stmainhis = connmainhis.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                date = rsmainhis.getString("cur");
            }
            rsmainhis.close();
            connmainhis.close();
        }
        catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    public String getDateAdd(String date_cal){
        //Vector v_claim = new Vector();
        String sql="Select current_date + cast('"+date_cal+" day' as interval) as cur; ", date="";
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        try {
            connmainhis = getConnectionBangna();
            stmainhis = connmainhis.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                date = rsmainhis.getString("cur");
            }
            rsmainhis.close();
            connmainhis.close();
        }
        catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    public String getDateAdd(Statement st,String date_cal){
        //Vector v_claim = new Vector();
        String sql="Select current_date + cast('"+date_cal+" day' as interval) as cur; ", date="";
//        Connection conn;
//        Statement stmainhis;
        ResultSet rsmainhis;
        try {
//            conn = getConnectionBangna();
//            stmainhis = conn.createStatement();
            rsmainhis = st.executeQuery(sql);
            while(rsmainhis.next()){
                date = rsmainhis.getString("cur");
            }
            rsmainhis.close();
//            conn.close();
        }
        catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    public String getDateAdd(String date1,String date_cal){
        //Vector v_claim = new Vector();
        String sql="Select date '"+date1+"' + cast('"+date_cal+" day' as interval) as cur; ", date="";
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        try {
            connmainhis = getConnectionBangna();
            stmainhis = connmainhis.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                date = rsmainhis.getString("cur");
            }
            rsmainhis.close();
            connmainhis.close();
        }
        catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    public String getDayofWeek(String date1){
        //Vector v_claim = new Vector();  SELECT to_char(cast('2012-04-10' as date), 'D');
        String sql="Select to_char(cast('"+date1+"' as date), 'D') as cur; ", date="";
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        try {
            connmainhis = getConnectionBangna();
            stmainhis = connmainhis.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                date = rsmainhis.getString("cur");
            }
            rsmainhis.close();
            connmainhis.close();
        }
        catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    public String getRowColorofWeek(String date1){
        String rowColor="", dayofweek="";
        dayofweek = getDayofWeek(date1);
        if(dayofweek.equals("1")) rowColor = "bgcolor='#F04900'";//sunday
        else if(dayofweek.equals("2")) rowColor = "bgcolor='#E9EE29'";//monday
        else if(dayofweek.equals("3")) rowColor = "bgcolor='#D091BE'";//tuesday
        else if(dayofweek.equals("4")) rowColor = "bgcolor='#49AB44'";//wedesday
        else if(dayofweek.equals("5")) rowColor = "bgcolor='#FF4300'";//thurday
        else if(dayofweek.equals("6")) rowColor = "bgcolor='#53BDED'";//friday
        else if(dayofweek.equals("7")) rowColor = "bgcolor='#7D2A82'";//satuaday
        return rowColor;
    }
    public String getRowColorofSundaySatuday(String date1){
        String rowColor="", dayofweek="";
        dayofweek = getDayofWeek(date1);
        if(dayofweek.equals("1")) rowColor = "bgcolor='#F16256'";//sunday
//        else if(dayofweek.equals("2")) rowColor = "bgcolor='#E9EE29'";//monday
//        else if(dayofweek.equals("3")) rowColor = "bgcolor='#D091BE'";//tuesday
//        else if(dayofweek.equals("4")) rowColor = "bgcolor='#49AB44'";//wedesday
//        else if(dayofweek.equals("5")) rowColor = "bgcolor='#FF4300'";//thurday
//        else if(dayofweek.equals("6")) rowColor = "bgcolor='#53BDED'";//friday
        else if(dayofweek.equals("7")) rowColor = "bgcolor='#D076FF'";//satuaday
        return rowColor;
    }
    public Integer getPatientAge(String datestart, String dateend){
        //Vector v_claim = new Vector();
        String cur="";
        String sql="Select age(timestamp '"+datestart+"', timestamp '"+dateend+"') as cur From b_branch Where branch_id = '103001' ";
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        try {
            connmainhis = getConnectionBangna();
            stmainhis = connmainhis.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                cur = rsmainhis.getString("cur");
            }
            int i = cur.indexOf("year");
            if(i>0){
                cur = cur.substring(0, i).trim();
            }else{
                cur = "0";
            }
            rsmainhis.close();
            connmainhis.close();
        }
        catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Integer.parseInt(cur);
    }
    public String getPrefixSurname(String surname){
        String line1="กขฃคฆงจฉ";
        String line2="ชซฌญฎฏฐฒ";
        String line3="ณดตถทฑธนบป";
        String line4="ผฝพฟภมยรลฤ";
        String line5="วศษสหฬอฮ";
        String prefix="";
        for(int i=0;i<=surname.length()-1;i++){
            if(line1.indexOf(surname.substring(i, i+1))>=0) prefix += "1";
            if(line2.indexOf(surname.substring(i, i+1))>=0) prefix += "2";
            if(line3.indexOf(surname.substring(i, i+1))>=0) prefix += "3";
            if(line4.indexOf(surname.substring(i, i+1))>=0) prefix += "4";
            if(line5.indexOf(surname.substring(i, i+1))>=0) prefix += "5";
        }
        return prefix;
    }
    public String getDrugAllergy(String branch_id,String t_visit_id) throws Exception {
        String sql="select pda.patient_drug_allergy_common_name || ' ' || pda.patient_drug_allergy_symptom " +
                "from t_patient_drug_allergy pda "
                + "left join t_patient tp on tp.t_patient_id = pda.t_patient_id "
                + "left join t_visit tv on tv.t_patient_id = tp.t_patient_id " +
                "where tv.t_visit_id = '"+t_visit_id+"' ";

        String drug_allergy="";
        Connection conn;
        conn = getConnectionHospital(branch_id);
        Statement st;
        st = conn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        while(rs.next()){
            drug_allergy += rs.getString("billing_deduct");
        }
        rs.close();
        conn.close();
        //sql = "";
        return drug_allergy;
    }
    public Vector getFItemGroup(String branch_id) throws Exception {
        String sql="select * " +
                "from "+fItemGroup.getFItemGroup();
        String drug_allergy="";
        Vector v_fItemGroup = new Vector();
        Connection conn;
        conn = getConnectionHospital(branch_id);
        Statement st;
        st = conn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        while(rs.next()){
            fItemGroup = new FItemGroup();
            fItemGroup.setFItemGroupId(rs.getString(fItemGroup.getFFItemGroupId()));
            fItemGroup.setItemGroupDescription(rs.getString(fItemGroup.getFItemGroupDescription()));
            v_fItemGroup.add(fItemGroup);
        }
        rs.close();
        conn.close();
        //sql = "";
        return v_fItemGroup;
    }
    public final String getComputerName(){
        String computerName="";
        try {
            computerName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return computerName;
    }
    public final String getIpAddress(){
        String IPAddress="";
        try {
            IPAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return IPAddress;
    }
    public String getInputComputerName(String input, String com_name){
        String text="";
//        text = "<input type='text' id='"+input+"' value='"+getComputerName()+"' readonly>";
        text = "<input type='text' id='"+input+"' value='"+getComputerName()+" " + com_name+"' readonly>";
        return text;
    }
    public Boolean setDeleteFile(String filename) {
        boolean exists = (new File(filename)).exists();
        boolean success = false;
        if (exists) success = (new File(filename)).delete();
        else success = true;
        return success;
    }
    public static boolean setDeleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = setDeleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // The directory is now empty so delete it
        return dir.delete();
    }
    public void setDeleteFileinFolder(String folderPath){
        File file = new File(folderPath);
        if (file.isDirectory()) {
            String[] children = file.list();
            for (int i=0; i<children.length; i++) {
                boolean success = setDeleteDir(new File(file, children[i]));
                if (!success) {
                    JOptionPane.showMessageDialog(null, "Error Delete file");
//                    return false;
                }
            }
        }
//        setDeleteDir(file);
    }
    public String getBranchSearch(Statement st, String branch_id, String field){
        String sql="", bitem_dressing="",bitem_dressing1="";
        sql = "Select "+field+" From b_branch Where branch_id = '"+branch_id+"'";
        ResultSet rsdressing;
        try {
            rsdressing = st.executeQuery(sql);
            while (rsdressing.next()){
                bitem_dressing = rsdressing.getString(field);
            }
            String[] dressing1 = bitem_dressing.split(",");
            rsdressing.close();
            bitem_dressing="";
            for(int ii=0;ii<=dressing1.length-1;ii++){
                bitem_dressing1 = dressing1[ii];
                if (bitem_dressing1.length() <= 0) {
                    continue;
                }
                bitem_dressing += "'"+bitem_dressing1+"',";
            }
            if(bitem_dressing.substring(bitem_dressing.length()-1).equals(",")){
                bitem_dressing = bitem_dressing.substring(0, bitem_dressing.length()-1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MuangsamutDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bitem_dressing;
    }
    public String getReadFile(String filename){
        int ch;
        StringBuilder strContent = new StringBuilder();
        File file = new File(filename);
        InputStream inputStream;
        Reader reader = null;
        try {
            inputStream = new FileInputStream(file);
            reader = new InputStreamReader(inputStream, "TIS-620");
            while( (ch = reader.read()) != -1){
                strContent.append((char)ch);
            }
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return strContent.toString();
    }
    public boolean chkString(char[] chrArray){
        for (int i = 0; i < chrArray.length; i++) {
            if ((chrArray[i] >= 'A' && chrArray[i] <= 'Z') || (chrArray[i] >= 'a' && chrArray[i] <= 'z') || chrArray[i] == '-') {
                return true;
            }
        }
        return false;
    }
    public String getIni(String apara) {
      String ini="",path="/data";//path fix path ดีกว่า เพราะจะได้ใช้ทั้ง windows และ Linux
        try{
            Properties p = new Properties();
            String curDir =new File(".").getAbsolutePath();
            curDir = System.getProperty("user.dir");
            //curDir = curDir.replace(".", "") + "/bangna.ini";
            curDir = curDir+"/bangna.ini";
//              curDir = "/bangna.ini";
            File f = new File(curDir);
            if (f.exists())
                p.load(new FileInputStream(f));
            ini = p.getProperty(apara, "");
            ini = new String(ini.getBytes("ISO8859_1"),"utf-8");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return ini;
    }
    public int getPanelorderpanel4width(){
        if(panelorderpanel4width.equals("")){
            return 0;
        }else{
            return Integer.parseInt(panelorderpanel4width);
        }
    }
    public Vector getBTransfer(String branch_id, String subsystem){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = getConnectionBangna();
            st = conn.createStatement();
            sql = "Select "+b_transfer.getFPaidId()+", "+b_transfer.getFBDepartmentNamet()+" "
                    +"From "+b_transfer.getBackBTransfer()+" "+
                    "Where "+b_transfer.getFBranchId()+"='"+branch_id+"' and "+b_transfer.getFBDepartmentId()+"='"+subsystem+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                b_transfer = new BackBTransfer();
                b_transfer.setPaidId(rs.getString(b_transfer.getFPaidId()));
                b_transfer.setBDepartmentNamet(rs.getString(b_transfer.getFBDepartmentNamet()));
                v_result.add(b_transfer);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getBTransferPaidNamet(String branch_id, String subsystem){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = getConnectionBangna();
            st = conn.createStatement();
            sql = "Select "+b_transfer.getFPaidId()+", "+b_transfer.getFClaimNamet()+" "
                    +"From "+b_transfer.getBackBTransfer()+" "+
                    "Where "+b_transfer.getFBranchId()+"='"+branch_id+"' and "+b_transfer.getFPaidId()+"='"+subsystem+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                txt = rs.getString(b_transfer.getFClaimNamet());
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return txt;
    }
    public String getAppName() {
	// Assume we are in the same jar as the main class.
	// We are likely to be as these utils should be packaged in the jar.
        String anmae = System.getProperty("program.name");
	return anmae;
    }
    public String getUomByOrderId(String orderId) {
        String sql="", uom="";
        Connection conn;
        try {
            sql="Select bidu.item_drug_uom_description "+
                "From b_item_drug_uom bidu "+
                "left join b_item_drug biu on biu.item_drug_use_uom = bidu.b_item_drug_uom_id "
                + "Left Join b_item bi on bi.b_item_id = biu.b_item_id "
                + "Left Join t_order tor on tor.b_item_id = bi.b_item_id "+
                "Where tor.b_item_id = '"+orderId+"' ";
            conn = getConnectionHospital(branch.branchId);
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                uom = rs.getString("item_drug_uom_description");

            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uom;
    }
    public String getUomByItemId(String orderId) {
        String sql="", uom="";
        Connection conn;
        try {
            sql="Select bidu.item_drug_uom_description "+
                "From b_item_drug_uom bidu "+
                "left join b_item_drug biu on biu.item_drug_use_uom = bidu.b_item_drug_uom_id "
                + "Left Join b_item bi on bi.b_item_id = biu.b_item_id "
//                + "Left Join t_order tor on tor.b_item_id = bi.b_item_id "+
                +"Where bi.b_item_id = '"+orderId+"' ";
            conn = getConnectionHospital(branch.branchId);
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                uom = rs.getString("item_drug_uom_description");

            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uom;
    }
    public Vector getOrderItemByVisitId(String visitId, String type) {
        String sql="", uom="", whereType="";
        Connection conn;
        Vector list = new Vector();
        OrderItem p;
        OrderItem dbObj = new OrderItem();
        if(!type.equals(""))
            whereType = " and f_item_group_id = '" + type + "'";
        dbObj.table="t_order";
        dbObj.pk_field="t_order_id";
        dbObj.visit_id   ="t_visit_id";
        dbObj.item_code   ="b_item_id";
        dbObj.vertifier   ="order_staff_verify";
        dbObj.vertify_time   ="order_verify_date_time";
        dbObj.executer   ="order_staff_execute";
        dbObj.executed_time   ="order_executed_date_time";
        dbObj.discontinue   ="order_staff_discontinue";
        dbObj.discontinue_time   ="order_discontinue_date_time";
        dbObj.dispense   ="order_staff_dispense";
        dbObj.dispense_time   ="order_dispense_date_time";
        dbObj.clinic_code   ="order_service_point";
        dbObj.item_group_code_category   ="b_item_subgroup_id";
        dbObj.charge_complete   ="order_charge_complete";
        dbObj.status   ="f_order_status_id";
        dbObj.secret   ="order_secret";
        dbObj.continue_order   ="order_continue";
        dbObj.price   ="order_price";
        dbObj.qty   ="order_qty";
        dbObj.item_group_code_billing   ="b_item_billing_subgroup_id";
        dbObj.hn   ="t_patient_id";
        dbObj.category_group   ="f_item_group_id";
        dbObj.common_name   ="order_common_name";
        dbObj.refer_out   ="order_refer_out";
        dbObj.request   ="order_request";
        dbObj.order_user   ="order_staff_order";
        dbObj.order_time   ="order_date_time";
        dbObj.order_complete ="order_complete";
        dbObj.order_cost = "order_cost";
        dbObj.note = "order_notice";

        dbObj.reporter = "order_staff_report";
        dbObj.reported_time = "order_report_date_time";

        //เก็บสาเหตุการยกเลิกผลแลป --sumo-- 13/3/2549
        dbObj.cause_cancel_resultlab = "order_cause_cancel_resultlab";

        //amp:30/03/2549 เก็บข้อมูลการสั่งยาที่แพ้ และสั่งยาที่มีปฏิกิริยาด้วย
        dbObj.drug_allergy = "order_drug_allergy";
        //tong:01/06/49 รายการกลับบ้าน
        dbObj.order_home = "order_home";
        dbObj.item_16_group = "b_item_16_group_id";
        dbObj.specified = "order_specified";
        dbObj.specified_data = "order_specified_data";
        dbObj.doctor_id = "doctor_id";
        dbObj.status_doctor = "order_status_doctor";
        dbObj.result_lab_approve_staff = "result_lab_approve_staff";
        dbObj.alert = "order_alert";
        dbObj.order_approve_staff = "order_approve_staff";
        dbObj.order_approve_date_time = "order_approve_date_time";
        dbObj.order_start_time = "order_start_time";
        dbObj.order_end_time = "order_end_time";
        dbObj.statusPrintReportItem = "status_print_report_item";
        dbObj.order_operation_no = "order_operation_no";
        dbObj.order_operation_status = "order_operation_status";
        try {
            sql="Select tor.* "+
                "From t_order tor "+
                "Where tor.t_visit_id = '"+visitId+"' "+whereType;
            conn = getConnectionHospital(branch.branchId);
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                p = new OrderItem();
                p.setObjectId(rs.getString(dbObj.pk_field));
                p.visit_id = rs.getString(dbObj.visit_id);
                p.item_code = rs.getString(dbObj.item_code);
                p.vertifier = rs.getString(dbObj.vertifier);
                p.vertify_time = rs.getString(dbObj.vertify_time);
                p.executer = rs.getString(dbObj.executer);
                p.executed_time = rs.getString(dbObj.executed_time);
                p.discontinue = rs.getString(dbObj.discontinue);
                p.discontinue_time = rs.getString(dbObj.discontinue_time);
                p.dispense = rs.getString(dbObj.dispense);
                p.dispense_time = rs.getString(dbObj.dispense_time);
                p.clinic_code = rs.getString(dbObj.clinic_code);
                p.category_group = rs.getString(dbObj.category_group);
                p.charge_complete = rs.getString(dbObj.charge_complete);
                p.status = rs.getString(dbObj.status);
                p.secret = rs.getString(dbObj.secret);
                p.continue_order = rs.getString(dbObj.continue_order);
                p.price = rs.getString(dbObj.price);
                p.qty = rs.getString(dbObj.qty);
                p.item_group_code_billing = rs.getString(dbObj.item_group_code_billing);
                p.common_name = rs.getString(dbObj.common_name);
                p.refer_out = rs.getString(dbObj.refer_out);
                p.hn = rs.getString(dbObj.hn);
                p.request = rs.getString(dbObj.request);
                p.order_user = rs.getString(dbObj.order_user);
                p.order_time = rs.getString(dbObj.order_time);
                p.order_complete = rs.getString(dbObj.order_complete);
                p.order_cost = rs.getString(dbObj.order_cost);
                p.note = rs.getString(dbObj.note);
                p.reporter = rs.getString(dbObj.reporter);
                p.reported_time = rs.getString(dbObj.reported_time);
                p.cause_cancel_resultlab = rs.getString(dbObj.cause_cancel_resultlab);
                p.drug_allergy = rs.getString(dbObj.drug_allergy);
                p.order_home = rs.getString(dbObj.order_home);
                p.item_16_group = rs.getString(dbObj.item_16_group);
                p.item_group_code_category = rs.getString(dbObj.item_group_code_category);
                p.specified = rs.getString(dbObj.specified);
                p.specified_data = rs.getString(dbObj.specified_data);
                p.status_doctor = rs.getString(dbObj.status_doctor);
                p.doctor_id = rs.getString(dbObj.doctor_id);
                p.result_lab_approve_staff = rs.getString(dbObj.result_lab_approve_staff);
                p.alert = rs.getString(dbObj.alert);
                p.order_approve_staff = rs.getString(dbObj.order_approve_staff);
                p.order_approve_date_time = rs.getString(dbObj.order_approve_date_time);
                p.order_start_time = rs.getString(dbObj.order_start_time);
                p.order_end_time = rs.getString(dbObj.order_end_time);
                p.statusPrintReportItem = rs.getString(dbObj.statusPrintReportItem);
                p.order_operation_no = rs.getString(dbObj.order_operation_no);
                p.order_operation_status = rs.getString(dbObj.order_operation_status);
                list.add(p);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(Config1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
