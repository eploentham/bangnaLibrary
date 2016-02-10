/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;
import bangnaLibrary.*;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author root
 */
public class BangnaTContactDB {
//    private Config1 config1 = new Config1();
    private Config1 config1;
    private BContact contact = new BContact();
    private BangnaTContact t_contact = new BangnaTContact();
    private BangnaTContactDetail t_contact_detail = new BangnaTContactDetail();
    public BangnaTContactDB(Config1 cf){
        config1 = cf;
    }
    public String getMaxRowBangnaTContact(Connection conn){
        String sql="", max="";
        try {
//            Connection conn = config1.getConnectionBangna();
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select max("+t_contact.getFTContactId()+") as cnt From "+t_contact.getBangnaTContact();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
//            conn.close();
            if(max!=null && !max.equals("")) {
                max =  String.valueOf(Integer.parseInt(max)+1);
            }
            else {
                max = "13500001";
            }
        } catch (Exception ex) {
            Logger.getLogger(BangnaTContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowBangnaTContactDetail(Connection conn){
        String sql="", max="";
        try {
//            Connection conn = config1.getConnectionBangna();
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select max("+t_contact_detail.getFTContactDetailId()+") as cnt From "+t_contact_detail.getBangnaTContactDetail();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
//            conn.close();
            if(max!=null && !max.equals("")) {
                max =  String.valueOf(Integer.parseInt(max)+1);
            }
            else {
                max = "13600001";
            }
        } catch (Exception ex) {
            Logger.getLogger(BangnaTContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public BangnaTContact getTContactByPK(String branch_id, String t_contact_id, String flag) {
        Connection conn;
//        BContact contact = new BContact();
//        BDepartment department = new BDepartment();
        //FoodsPeriod foodsperiod = new FoodsPeriod();
        String sql="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();

            if(flag.equals("patient_hn")){
                sql="Select tc.*, c."+contact.getFContactNamet()+" "
                +"From "+t_contact.getBangnaTContact()+" as tc "+
                "left join "+contact.getBContact()+" as c on tc."+t_contact.getFContactId()+"=c."+t_contact_detail.getFContactId()+" "
                +"Where tc."+t_contact.getFPatientHn()+"='"+t_contact_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }else{
                sql="Select tc.*, c."+contact.getFContactNamet()+" "
                +"From "+t_contact.getBangnaTContact()+" as tc "+
                "left join "+contact.getBContact()+" as c on tc."+t_contact.getFContactId()+"=c."+t_contact_detail.getFContactId()+" "
                +"Where tc."+t_contact.getFContactId()+"='"+t_contact_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                t_contact = new BangnaTContact();
                t_contact.setAdjustDate(config1.StringNull(rs.getString(t_contact.getFAdjustDate())));
                t_contact.setAdjustUserId(config1.StringNull(rs.getString(t_contact.getFAdjustUserId())));
                t_contact.setContactId(config1.StringNull(rs.getString(t_contact.getFContactId())));
                t_contact.setDateCancel(config1.StringNull(rs.getString(t_contact.getFDateCancel())));
                t_contact.setDateCreate(config1.StringNull(rs.getString(t_contact.getFDateCreate())));

                t_contact.setDateModify(config1.StringNull(rs.getString(t_contact.getFDateModify())));
                t_contact.setPatientFullnamet(config1.StringNull(rs.getString(t_contact.getFPatientFullnamet())));
                t_contact.setPatientHn(config1.StringNull(rs.getString(t_contact.getFPatientHn())));
                t_contact.setRemark(config1.StringNull(rs.getString(t_contact.getFRemark())));
                t_contact.setTContactActive(config1.StringNull(rs.getString(t_contact.getFTContactActive())));

                t_contact.setTContactId(config1.StringNull(rs.getString(t_contact.getFTContactId())));
                t_contact.setTPatientId(config1.StringNull(rs.getString(t_contact.getFTPatientId())));
                t_contact.setUserCancel(config1.StringNull(rs.getString(t_contact.getFUserCancel())));
                t_contact.setUserCreate(config1.StringNull(rs.getString(t_contact.getFUserCreate())));
                t_contact.setUserModify(config1.StringNull(rs.getString(t_contact.getFUserModify())));

                t_contact.setContactNamet(config1.StringNull(rs.getString(t_contact.getFContactnamet())));
               
                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BangnaTContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t_contact;
    }
    public Vector getTContact(String branch_id, String t_contact_id, String flag) {
        Connection conn;
        BContact contact = new BContact();
        Vector v_t_contact = new Vector();
//        BDepartment department = new BDepartment();
        //FoodsPeriod foodsperiod = new FoodsPeriod();
        String sql="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();

            if(flag.equals("patient_hn")){
                sql="Select * "
                +"From "+t_contact.getBangnaTContact()+" "
                +"Where "+t_contact.getFPatientHn()+"='"+t_contact_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }else {
                sql="Select * "
                +"From "+t_contact.getBangnaTContact()+" "
                +"Where "+t_contact.getFTContactId()+"='"+t_contact_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                t_contact = new BangnaTContact();
                t_contact.setAdjustDate(config1.StringNull(rs.getString(t_contact.getFAdjustDate())));
                t_contact.setAdjustUserId(config1.StringNull(rs.getString(t_contact.getFAdjustUserId())));
                t_contact.setContactId(config1.StringNull(rs.getString(t_contact.getFContactId())));
                t_contact.setDateCancel(config1.StringNull(rs.getString(t_contact.getFDateCancel())));
                t_contact.setDateCreate(config1.StringNull(rs.getString(t_contact.getFDateCreate())));

                t_contact.setDateModify(config1.StringNull(rs.getString(t_contact.getFDateModify())));
                t_contact.setPatientFullnamet(config1.StringNull(rs.getString(t_contact.getFPatientFullnamet())));
                t_contact.setPatientHn(config1.StringNull(rs.getString(t_contact.getFPatientHn())));
                t_contact.setRemark(config1.StringNull(rs.getString(t_contact.getFRemark())));
                t_contact.setTContactActive(config1.StringNull(rs.getString(t_contact.getFTContactActive())));

                t_contact.setTContactId(config1.StringNull(rs.getString(t_contact.getFTContactId())));
                t_contact.setTPatientId(config1.StringNull(rs.getString(t_contact.getFTPatientId())));
                t_contact.setUserCancel(config1.StringNull(rs.getString(t_contact.getFUserCancel())));
                t_contact.setUserCreate(config1.StringNull(rs.getString(t_contact.getFUserCreate())));
                t_contact.setUserModify(config1.StringNull(rs.getString(t_contact.getFUserModify())));

                v_t_contact.add(t_contact);

                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BangnaTContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_t_contact;
    }
    public BangnaTContactDetail getTContactDetailByPK(String branch_id, String t_contact_detail_id) {
        Connection conn;
//        BContact contact = new BContact();
//        BDepartment department = new BDepartment();
        //FoodsPeriod foodsperiod = new FoodsPeriod();
        String sql="";
        t_contact_detail = new BangnaTContactDetail();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();

            sql="Select tcd.*, c."+contact.getFContactNamet()+" "
                +"From "+t_contact_detail.getBangnaTContactDetail()+" as tcd "+
                "left join "+contact.getBContact()+" as c on tcd."+t_contact_detail.getFContactId()+" = c."+contact.getFContactId()+" "
                +"Where tcd."+t_contact_detail.getFTContactDetailId()+"='"+t_contact_detail_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                t_contact_detail = new BangnaTContactDetail();
                t_contact_detail.setContactDetailDate(config1.StringNull(rs.getString(t_contact_detail.getFContactDetailDate())));
                t_contact_detail.setContactDetailTime(config1.StringNull(rs.getString(t_contact_detail.getFContactDetailTime())));
                t_contact_detail.setContactId(config1.StringNull(rs.getString(t_contact_detail.getFContactId())));
                t_contact_detail.setDateCancel(config1.StringNull(rs.getString(t_contact_detail.getFDateCancel())));
                t_contact_detail.setDateCreate(config1.StringNull(rs.getString(t_contact_detail.getFDateCreate())));

                t_contact_detail.setDateModify(config1.StringNull(rs.getString(t_contact_detail.getFDateModify())));
                t_contact_detail.setPatientFullnamet(config1.StringNull(rs.getString(t_contact_detail.getFPatientFullnamet())));
                t_contact_detail.setPatientHn(config1.StringNull(rs.getString(t_contact_detail.getFPatientHn())));
                t_contact_detail.setPatientId(config1.StringNull(rs.getString(t_contact_detail.getFPatientId())));
                t_contact_detail.setPtType(config1.StringNull(rs.getString(t_contact_detail.getFPtType())));

                t_contact_detail.setRemark(config1.StringNull(rs.getString(t_contact_detail.getFRemark())));
                t_contact_detail.setTContactDetailActive(config1.StringNull(rs.getString(t_contact_detail.getFTContactDetailActive())));
                t_contact_detail.setTContactDetailId(config1.StringNull(rs.getString(t_contact_detail.getFTContactDetailId())));
                t_contact_detail.setTContactId(config1.StringNull(rs.getString(t_contact_detail.getFTContactId())));
                t_contact_detail.setUserCancel(config1.StringNull(rs.getString(t_contact_detail.getFUserCancel())));

                t_contact_detail.setUserCreate(config1.StringNull(rs.getString(t_contact_detail.getFUserCreate())));
                t_contact_detail.setUserModify(config1.StringNull(rs.getString(t_contact_detail.getFUserModify())));
                t_contact_detail.setContactNamet(config1.StringNull(rs.getString(t_contact_detail.getFContactNamet())));

                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BangnaTContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t_contact_detail;
    }
    public Vector getTContactDetail(String branch_id, String where, String t_contact_detail_id, String flag) {
        Connection conn;
        BContact contact = new BContact();
        Vector v_t_contact_detail = new Vector();
//        BDepartment department = new BDepartment();
        //FoodsPeriod foodsperiod = new FoodsPeriod();
        String sql="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();

            if(flag.equals("search_contact_namet")){
                sql="Select tcd.*, c."+contact.getFContactNamet()+" "
                +"From "+t_contact_detail.getBangnaTContactDetail()+" as tcd "+
                "left join "+contact.getBContact()+" as c on tcd."+t_contact.getFContactId()+"=c."+t_contact_detail.getFContactId()+" "
                +"Where tcd."+t_contact_detail.getFTContactDetailId()+"='"+t_contact_detail_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            } else if(flag.equals("patient_hn")){
                sql="Select tcd.*, c."+contact.getFContactNamet()+" "
                +"From "+t_contact_detail.getBangnaTContactDetail()+" as tcd "+
                "left join "+contact.getBContact()+" as c on tcd."+t_contact.getFContactId()+"=c."+t_contact_detail.getFContactId()+" "
                +"Where tcd."+t_contact_detail.getFPatientHn()+"='"+t_contact_detail_id+"' "
                +"Order By "+t_contact_detail.getFContactDetailDate()+" desc";
            } else{
                sql="Select tcd.*, c."+contact.getFContactNamet()+" "
                +"From "+t_contact_detail.getBangnaTContactDetail()+" as tcd "+
                "left join "+contact.getBContact()+" as c on tcd."+t_contact.getFContactId()+"=c."+t_contact_detail.getFContactId()+" "
                +"Where tcd."+t_contact_detail.getFTContactDetailId()+"='"+t_contact_detail_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                t_contact_detail = new BangnaTContactDetail();
                t_contact_detail.setContactDetailDate(config1.StringNull(rs.getString(t_contact_detail.getFContactDetailDate())));
                t_contact_detail.setContactDetailTime(config1.StringNull(rs.getString(t_contact_detail.getFContactDetailTime())));
                t_contact_detail.setContactId(config1.StringNull(rs.getString(t_contact_detail.getFContactId())));
                t_contact_detail.setDateCancel(config1.StringNull(rs.getString(t_contact_detail.getFDateCancel())));
                t_contact_detail.setDateCreate(config1.StringNull(rs.getString(t_contact_detail.getFDateCreate())));

                t_contact_detail.setDateModify(config1.StringNull(rs.getString(t_contact_detail.getFDateModify())));
                t_contact_detail.setPatientFullnamet(config1.StringNull(rs.getString(t_contact_detail.getFPatientFullnamet())));
                t_contact_detail.setPatientHn(config1.StringNull(rs.getString(t_contact_detail.getFPatientHn())));
                t_contact_detail.setPatientId(config1.StringNull(rs.getString(t_contact_detail.getFPatientId())));
                t_contact_detail.setPtType(config1.StringNull(rs.getString(t_contact_detail.getFPtType())));

                t_contact_detail.setRemark(config1.StringNull(rs.getString(t_contact_detail.getFRemark())));
                t_contact_detail.setTContactDetailActive(config1.StringNull(rs.getString(t_contact_detail.getFTContactDetailActive())));
                t_contact_detail.setTContactDetailId(config1.StringNull(rs.getString(t_contact_detail.getFTContactDetailId())));
                t_contact_detail.setTContactId(config1.StringNull(rs.getString(t_contact_detail.getFTContactId())));
                t_contact_detail.setUserCancel(config1.StringNull(rs.getString(t_contact_detail.getFUserCancel())));

                t_contact_detail.setUserCreate(config1.StringNull(rs.getString(t_contact_detail.getFUserCreate())));
                t_contact_detail.setUserModify(config1.StringNull(rs.getString(t_contact_detail.getFUserModify())));
                t_contact_detail.setContactNamet(config1.StringNull(rs.getString(t_contact_detail.getFContactNamet())));
                
                v_t_contact_detail.add(t_contact_detail);
                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BangnaTContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_t_contact_detail;
    }
    public String setSaveTContact(String branch_id,BangnaTContact item, String flagpage) throws Exception {
        int chk=0;
        String sql="", ma_date="", attend_date="", max="";
//        BContact contact = new BContact();
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            t_contact = getTContactByPK(branch_id,item.getTContactId(),"patient_hn");
            item.setPatientFullnamet(item.getPatientFullnamet().replace("'", "''"));
            item.setRemark(item.getRemark().replace("'", "''"));
            if(item.getTContactId().equals("")){
                item.setTContactId(t_contact.getTContactId());
            }
//            item.setRemark(item.getRemark().replace("'", "''"));
//            item.setSerialNo(item.getSerialNo().replace("'", "''"));
//            item.setServiceTab(item.getServiceTab().replace("'", "''"));
//            item.setWarranty(item.getWarranty().replace("'", "''"));
            if(t_contact.getTContactId().equals("")){
                max = getMaxRowBangnaTContact(conn);
                sql="Insert Into "+t_contact.getBangnaTContact()+"("
                        +t_contact.getFTContactId()+", "+t_contact.getFAdjustDate()+", "
                        +t_contact.getFContactId()+","+ t_contact.getFDateCancel()+","
                        +t_contact.getFDateCreate()+","+ t_contact.getFDateModify()+","
                        +t_contact.getFPatientFullnamet()+","+ t_contact.getFPatientHn()+","
                        +t_contact.getFRemark()+","+ t_contact.getFTContactActive()+","
                        +t_contact.getFAdjustUserId()+","+ t_contact.getFTPatientId()+","
                        +t_contact.getFUserCancel()+","+ t_contact.getFUserCreate()+","
                        +t_contact.getFUserModify()+") "
                        +"Values('"+max+"','"+item.getAdjustDate()+"','"
                        +item.getContactId() + "','"+ item.getDateCancel()+"','"
                        +item.getDateCreate() + "','"+ item.getDateModify()+"','"
                        +item.getPatientFullnamet() + "','"+ item.getPatientHn()+"','"
                        +item.getRemark() + "','"+ item.getTContactActive()+"','"
                        +item.getAdjustUserId() + "','"+ item.getTPatientId()+"','"
                        +item.getUserCancel() + "','"+ item.getUserCreate()+"','"
                        +item.getUserModify() + "')";
            }else{
//                attend_date=config1.DateFormatShow2DB(itemdetail.getAttendDate(), "ddMMyyyy");
//                wound_care_date=config1.DateFormatShow2DB(itemdetail.getMaDate(), "ddMMyyyy");
                sql = "Update "+t_contact.getBangnaTContact()+" set "
                +t_contact.getFAdjustDate()+" = '"+item.getAdjustDate()+"', "
                +t_contact.getFContactId()+" = '"+item.getContactId()+"', "
                +t_contact.getFDateCancel()+" = '"+item.getDateCancel()+"', "
                +t_contact.getFDateCreate()+" = '"+item.getDateCreate()+"', "
                +t_contact.getFDateModify()+" = '"+item.getDateModify()+"', "
                +t_contact.getFPatientFullnamet()+" = '"+item.getPatientFullnamet()+"', "
                +t_contact.getFPatientHn()+" = '"+item.getPatientHn()+"', "
                +t_contact.getFRemark()+" = '"+item.getRemark()+"', "
                +t_contact.getFTContactActive()+" = '"+item.getTContactActive()+"', "
//                +t_contact.getFTContactId()+" = '"+item.getTContactId()+"', "
                +t_contact.getFTPatientId()+" = '"+item.getTPatientId()+"', "
                +t_contact.getFUserCancel()+" = '"+item.getUserCancel().trim()+"', "
                +t_contact.getFUserCreate()+" = '"+item.getUserCreate().trim()+"', "
                +t_contact.getFUserModify()+" = '"+item.getUserModify().trim()+"' "
                +"Where "+t_contact.getFTContactId()+" = '"+item.getTContactId()+"'";
                max = item.getTContactId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BangnaTContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String setSaveTContactDetail(String branch_id, BangnaTContactDetail item, String flagpage) throws Exception {
        int chk=0;
        String sql="", ma_date="", attend_date="", max="";
//        BContact contact = new BContact();
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            t_contact_detail = getTContactDetailByPK(branch_id,item.getTContactDetailId());
            item.setPatientFullnamet(item.getPatientFullnamet().replace("'", "''"));
            item.setRemark(item.getRemark().replace("'", "''"));
//            item.setRemark(item.getRemark().replace("'", "''"));
//            item.setSerialNo(item.getSerialNo().replace("'", "''"));
//            item.setServiceTab(item.getServiceTab().replace("'", "''"));
//            item.setWarranty(item.getWarranty().replace("'", "''"));
            if(t_contact_detail.getTContactDetailId().equals("")) {
                max = getMaxRowBangnaTContactDetail(conn);
                sql="Insert Into "+t_contact_detail.getBangnaTContactDetail()+"("+
                        t_contact_detail.getFTContactDetailId()+", "+t_contact_detail.getFContactDetailDate()+", "+
                        t_contact_detail.getFContactDetailTime()+","+ t_contact_detail.getFContactId()+","+
                        t_contact_detail.getFDateCancel()+","+ t_contact_detail.getFDateCreate()+","+
                        t_contact_detail.getFDateModify()+","+ t_contact_detail.getFPatientFullnamet()+","+
                        t_contact_detail.getFPatientHn()+","+ t_contact_detail.getFPatientId()+","+
                        t_contact_detail.getFPtType()+","+ t_contact_detail.getFRemark()+","+
                        t_contact_detail.getFTContactDetailActive()+","+ t_contact_detail.getFTContactId()+","+
                        t_contact_detail.getFUserCancel()+","+t_contact_detail.getFUserCreate()+"," +
                        t_contact_detail.getFUserModify()+") "+
                        "Values('"+max+"','"+item.getContactDetailDate()+"','"+
                        item.getContactDetailTime() + "','"+ item.getContactId()+"','"+
                        item.getDateCancel() + "','"+ item.getDateCreate()+"','"+
                        item.getDateModify() + "','"+ item.getPatientFullnamet()+"','"+
                        item.getPatientHn() + "','"+ item.getPatientId()+"','"+
                        item.getPtType() + "','"+ item.getRemark()+"','"+
                        item.getTContactDetailActive() + "','"+ item.getTContactId()+"','"+
                        item.getUserCancel() + "','"+item.getUserCreate()+"','" +
                        item.getUserModify()+"')";
            }
            else{
//                attend_date=config1.DateFormatShow2DB(itemdetail.getAttendDate(), "ddMMyyyy");
//                wound_care_date=config1.DateFormatShow2DB(itemdetail.getMaDate(), "ddMMyyyy");
                sql = "Update "+t_contact_detail.getBangnaTContactDetail()+" set "
                +t_contact_detail.getFContactDetailDate()+" = '"+item.getContactDetailDate()+"', "
                +t_contact_detail.getFContactDetailTime()+" = '"+item.getContactDetailTime()+"', "
                +t_contact_detail.getFContactId()+" = '"+item.getContactId()+"', "
                +t_contact_detail.getFDateCancel()+" = '"+item.getDateCancel()+"', "
                +t_contact_detail.getFDateCreate()+" = '"+item.getDateCreate()+"', "
                +t_contact_detail.getFDateModify()+" = '"+item.getDateModify()+"', "
                +t_contact_detail.getFPatientFullnamet()+" = '"+item.getPatientFullnamet()+"', "
                +t_contact_detail.getFPatientHn()+" = '"+item.getPatientHn()+"', "
                +t_contact_detail.getFPatientId()+" = '"+item.getPatientId()+"', "
                +t_contact_detail.getFPtType()+" = '"+item.getPtType()+"', "
                +t_contact_detail.getFRemark()+" = '"+item.getRemark()+"', "+
                t_contact_detail.getFTContactDetailActive()+" = '"+item.getTContactDetailActive()+"', "+
                t_contact_detail.getFTContactId()+" = '"+item.getTContactId()+"', "+
                t_contact_detail.getFUserCancel()+" = '"+item.getUserCancel()+"', "+
                t_contact_detail.getFUserCreate()+" = '"+item.getUserCreate()+"', "+
                t_contact_detail.getFUserModify()+" = '"+item.getUserModify()+"' "+
                "Where "+t_contact_detail.getFTContactDetailId()+" = '"+item.getTContactDetailId()+"'";
                max = item.getTContactDetailId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BangnaTContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }

}
