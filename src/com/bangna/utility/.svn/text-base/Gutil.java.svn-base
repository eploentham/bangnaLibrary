/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangna.utility;

import com.bangna.usecase.connection.Constant;
import com.bangna.usecase.connection.IOStream;

/**
 *
 * @author LionHeart
 */
public class Gutil {
    public Gutil()
    {
        
    }
    public static String convertSQLToMySQL(String sql,String typeDatabase) {
        if(typeDatabase.equalsIgnoreCase("2")) {
            Constant.println("Pass ConvertSQL To MySQL");
            return IOStream.Unicode2ASCII(sql);
            
        } else
            return sql;
    }
}
