/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class BDocNumberDB {
    BDocNumber doc_number = new BDocNumber();
    Config1 config1 ;
    public BDocNumberDB(){
        config1 = new Config1();
    }
    public BDocNumberDB(Config1 cf){
        config1 = cf;
    }
    public String getMaxRowCashierTBillingInvoicePrint(Connection conn) {
        String sql="", max="";
        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select max("+doc_number.getFDocNumberId()+") as cnt From "+doc_number.getBDocNumber();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if(max!=null && !max.equals("")) {
                max =  String.valueOf(Integer.parseInt(max)+1);
            }
            else{
                max = "17500001";
            }
        } catch (Exception ex) {
            Logger.getLogger(BDocNumberDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public BDocNumber getDocNumberByPk(String branchId,Connection conn, String f_visit_type_id, String flag) {
//        Connection conn;
        String sql="",f_visit_type="";
        try {
//            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            if(flag.equals("invoice")) {
            }else{
                sql="Select * "
                +"From "+doc_number.getBDocNumber()+" "
                +"Where "+doc_number.getFFVisitTypeId()+"='"+f_visit_type+"'";
            }
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()) {
//                doc_number = new BDocNumber();
                doc_number.setDocNumber(config1.StringNull(rs.getString(doc_number.getFDocNumber())));
                doc_number.setDocNumberId(config1.StringNull(rs.getString(doc_number.getFDocNumberId())));
                doc_number.setPrefix(config1.StringNull(rs.getString(doc_number.getFPrefix())));
                doc_number.setRemark(config1.StringNull(rs.getString(doc_number.getFRemark())));
                doc_number.setStatusReset(config1.StringNull(rs.getString(doc_number.getFStatusReset())));

                doc_number.setSymbol(config1.StringNull(rs.getString(doc_number.getFSymbol())));
                doc_number.setTableId(config1.StringNull(rs.getString(doc_number.getFTableId())));
                doc_number.setYear1(config1.StringNull(rs.getString(doc_number.getFYear1())));
                doc_number.setLenMask(config1.StringNull(rs.getString(doc_number.getFLenMask())));
                doc_number.setFVisitTypeId(config1.StringNull(rs.getString(doc_number.getFFVisitTypeId())));

                }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BDocNumberDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doc_number;
    }
    public BDocNumber getDocNumber(String brach_id,Connection conn, String f_visit_type_id, String flag) {
//        Connection conn;
        String sql="",f_visit_type="";
        try {
//            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            if(flag.equals("invoice")) {
                sql="Select * "
                +"From "+doc_number.getBDocNumber()+" "
                +"Where "+doc_number.getFTableId()+"='169' and "+doc_number.getFFVisitTypeId()+"='"+f_visit_type_id+"'";
            }else if(flag.equals("receive")) {
                sql="Select * "
                +"From "+doc_number.getBDocNumber()+" "
                +"Where "+doc_number.getFTableId()+"='173' and "+doc_number.getFFVisitTypeId()+"='"+f_visit_type_id+"'";
            }else if(flag.equals("back_office")) {
                if(f_visit_type_id.equals("175")){
                    f_visit_type = "011";
                }else{
                    f_visit_type = f_visit_type_id;
                }
                sql="Select * "
                +"From "+doc_number.getBDocNumber()+" "
                +"Where "+doc_number.getFFVisitTypeId()+"='"+f_visit_type+"'";
            }else if(flag.equals("back_office_contact")) {
                sql="Select * "
                +"From "+doc_number.getBDocNumber()+" "
                +"Where "+doc_number.getFFVisitTypeId()+" like '%"+f_visit_type_id+"%'";
            }else{
                sql="Select * "
                +"From "+doc_number.getBDocNumber()+" "
                +"Where "+doc_number.getFFVisitTypeId()+"='"+f_visit_type_id+"'";
            }

                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()) {
//                doc_number = new BDocNumber();
                doc_number.setDocNumber(config1.StringNull(rs.getString(doc_number.getFDocNumber())));
                doc_number.setDocNumberId(config1.StringNull(rs.getString(doc_number.getFDocNumberId())));
                doc_number.setPrefix(config1.StringNull(rs.getString(doc_number.getFPrefix())));
                doc_number.setRemark(config1.StringNull(rs.getString(doc_number.getFRemark())));
                doc_number.setStatusReset(config1.StringNull(rs.getString(doc_number.getFStatusReset())));

                doc_number.setSymbol(config1.StringNull(rs.getString(doc_number.getFSymbol())));
                doc_number.setTableId(config1.StringNull(rs.getString(doc_number.getFTableId())));
                doc_number.setYear1(config1.StringNull(rs.getString(doc_number.getFYear1())));
                doc_number.setLenMask(config1.StringNull(rs.getString(doc_number.getFLenMask())));
                doc_number.setFVisitTypeId(config1.StringNull(rs.getString(doc_number.getFFVisitTypeId())));

                }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BDocNumberDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doc_number;
    }
    private String setUpdateDocNumber(Connection conn, String doc_number1, String doc_number_id){
        String sql="";
        Statement st;
        Integer chk=0;
        try {
            st = conn.createStatement();
            sql="Update b_doc_number Set doc_number = '"+doc_number1+"' Where "+doc_number.getFDocNumberId()+" = '"+doc_number_id+"'";
            chk = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BDocNumberDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    private void setUpdateYear(Connection conn, String year1, String doc_number_id){
        String sql="";
        Statement st;
        try {
            st = conn.createStatement();
            sql="Update b_doc_number Set year1 = '"+year1+"' Where "+doc_number.getFDocNumberId()+" = '"+doc_number_id+"'";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BDocNumberDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getRunningDocNumber(String branch_id,String f_visit_type_id,String flag) {
        return getRunningDocNumber(branch_id, null,f_visit_type_id,flag);
    }
    public String getRunningDocNumber(String branch_id,Connection conn, String f_visit_type_id,String flag) {
        String doc_number1="", sql="", len="", year="", max="";
//        Connection conn;
        try {
//            doc_number = new BDocNumber();
//            conn = config1.getConnectionBangna();
            doc_number = getDocNumber(branch_id, conn,f_visit_type_id,flag);
//            year = config1.getDate("yyyy");
            year = config1.getDateDBHospital("yyyy");//pop debug year ไม่เปลี่ยน เพราะไม่ได้ปิดเครื่อง
            if(Integer.parseInt(year)<2500) {
                year = String.valueOf(Integer.parseInt(year)+543);
            }
//            year = year.substring(2);// debug
            if(Integer.parseInt(year)>Integer.parseInt(doc_number.getYear1())) {
                doc_number.setYear1(year);
                setUpdateYear(conn, doc_number.getYear1(), doc_number.getDocNumberId());
            }
            max=String.valueOf(Integer.parseInt(doc_number.getDocNumber())+1);
            len = doc_number.getLenMask()+max;
            len = len.substring(doc_number.getDocNumber().length());
            doc_number1 = doc_number.getPrefix()+len+doc_number.getSymbol()+doc_number.getYear1();
            setUpdateDocNumber(conn, max, doc_number.getDocNumberId());
//            conn.close();
        }catch(Exception ex){
            Logger.getLogger(BDocNumberDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doc_number1;
    }
}
