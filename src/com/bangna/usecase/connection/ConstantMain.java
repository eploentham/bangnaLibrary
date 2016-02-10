/*Source file: C:\\HospitalOS\\src\\com.hospital_os.object\\Constant.java
*/

package com.bangna.usecase.connection;

import java.awt.*;
import java.util.*;
import java.awt.Color;

/**
 * <b>Title:</b>        Constant<br>
 * <b>Description:</b><blockquote>
 * Contain constant in program
 * </blockquote>
 * <b>Copyright:</b>    Copyright (c) 2002<br>
 * <b>Company:</b>      4th Tier<br>
 * @author Surachai Thowong
 * @version 1.0 2002-01-17
 */
public class ConstantMain
{  
    protected static Properties data = null;
    public final static String EnglishLanguage = "com/hospital_os/property/english";
    public final static String ThaiLanguage = "com/hosv3/property/thai";
    public static String LANGUAGE = ThaiLanguage; //default langauge
    
    public static String getTextBundle(String str)
    {   
//        if(data==null)
//            data = Language.getProperties("hospital_os");//,filename,filepath);
        if(str==null)
            return "";
//        
//        str = str.trim();
//        if(str.equals("")) return "";
//        try{
//            String ret = data.getProperty(str);
//            if(ret!=null)
//                return ret;
//            else{
//                String pro = java.util.ResourceBundle.getBundle(LANGUAGE).getString(str);
//                //Constant.println("aBundle from property:" + str);
//                return pro;
//            }
////            return getStaticText(str);
//        }catch(Exception e){ 
//            Constant.println("exception:" + str);
//            //e.printStackTrace();
//        }
        //Constant.println("aBundle not found:" + str);
        return str;
    }
    public static void main(String[] argc) throws Exception {
//        Runtime rt = Runtime.getRuntime();
//        long time = System.currentTimeMillis();
//        Constant.println(ConstantMain.getTextBundle("Fname"));
//        Constant.println(System.currentTimeMillis() - time);
//Constant.println("Total JVM memory: " + rt.totalMemory());
//Constant.println("Before Memory = " + rt.freeMemory());
//        time = System.currentTimeMillis();
//        Constant.println(ConstantMain.getTextBundle("�غѵ��˵�"));
//        Constant.println(System.currentTimeMillis() - time);
//        time = System.currentTimeMillis();
//Constant.println("Total JVM memory: " + rt.totalMemory());
//Constant.println("Before Memory = " + rt.freeMemory());
    }
}
