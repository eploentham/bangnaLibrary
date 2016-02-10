/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;
import java.util.*;
import java.io.*;
/**
 *
 * @author Administrator
 */
public class readIni {

  public String doit(String apara) {
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
}
