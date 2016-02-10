/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangna.usecase.connection;

import java.sql.ResultSet;

/**
 *
 * @author root
 */
public class Test {
    public static void main(String[] args)
    {
        ConnectionInf theConnectionInf = new ConnectionDBMgr("org.postgresql.Driver"
                ,"jdbc:postgresql://localhost:5432/front_bangna5"
                , "postgres","postgres","0");
        try
        {
            theConnectionInf.open();
            ResultSet rs = theConnectionInf.eQuery("select count(*) from t_patient;");
//            Connection con = DriverManager.getConnection("", "", "");
            while(rs.next())
            {
                String res = rs.getString("count");
                System.err.println(res);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            theConnectionInf.close();
        }
    }
}
