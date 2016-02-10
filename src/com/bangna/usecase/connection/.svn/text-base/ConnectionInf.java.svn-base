/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangna.usecase.connection;

/**
 *
 * @author root
 */
public interface ConnectionInf {
    public String typeDatabase = "0";
    public String gettypeDatabase();
    public boolean begin();
    public boolean nbegin();
    public boolean open();
    public boolean commit();
    public boolean rollback();
    public int eUpdate(String sql) throws Exception;        
    public java.sql.Connection getConnection();
    public java.sql.ResultSet eQuery(String sql) throws Exception; 
    public java.sql.PreparedStatement ePQuery(String sql);
    public boolean connect(String driver,String url);
    public boolean close();    
    
    public String getURL();
    public String getUsername();
    /*HENBE_APR*/
    public boolean exit();
    /** true is MultiConnection
     *  false is One Connection
     */
    public void MultiConnection(boolean choose);
    /**รับ true is not close*/
    public boolean open(boolean isclose);
    /**false is close*/
    public boolean close(boolean isclose);
    public java.util.Properties getProperties();
    public ConnectionInf getClone();
}
