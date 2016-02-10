/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bangnaLibrary;

import java.io.*;

/**
 *
 * @author LionHeart
 */
public class BangnaIni implements Serializable {

    String init = "";
    public String hostname = init;
    public String userDB = init;
    public String passDB = init;
    public String database = init;
    public String driverName = init;
    public String panelorderpanel4width = init;
    public String hostnamebangna = init;
    public String userDBbangna = init;
    public String passDBbangna = init;
    public String databasebangna = init;
    public String databaseextend = init;
    public String driverNamebangna = init;
    public String type = init;
    public String txt = init;
    public String jasperReportType = init;
    public String reportResultLab = init;
    public String reportRequestDrug = init;
    public String reportInvoiceGroup = init;

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(hostname + " , ");
        return sb.toString();
    }

    public static BangnaIni getBangnaIni() {
        BangnaIni bangnaIni = new BangnaIni();
        bangnaIni.hostname = "127.0.0.1";
        bangnaIni.hostnamebangna = "127.0.0.1";
        bangnaIni.userDB = "postgres";
        bangnaIni.passDB = "postgres";
        bangnaIni.database = "front_bangna5";
        bangnaIni.driverName = "postgres";
        bangnaIni.userDBbangna = "postgres";
        bangnaIni.passDBbangna = "postgres";
        bangnaIni.databasebangna = "bangna5";
        bangnaIni.jasperReportType = ".xml";
        return bangnaIni;
    }

    public static void main(String[] args) throws Exception {
//        BangnaIni.testWriteObj();
        BangnaIni.testReadObj();
    }

    public static void testWriteObj() throws Exception {
        FileOutputStream fos = new FileOutputStream("/root/bangna.info");
        ObjectOutputStream outStream = new ObjectOutputStream(fos);
        outStream.writeObject(BangnaIni.getBangnaIni());
    }

    public static void testReadObj() throws Exception {
        FileInputStream fis = new FileInputStream("/root/bangna.info");
        ObjectInputStream inStream = new ObjectInputStream(fis);
        BangnaIni oo1 = (BangnaIni) inStream.readObject();
        System.err.println(oo1.toString());
    }
}
