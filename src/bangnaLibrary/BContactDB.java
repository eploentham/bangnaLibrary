/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * Update By Ekapop 54-10-05 (m1)
 * m1 เรื่อง ไม่สามารถเพิ่มบริษัทใหม่ได้
 */

package bangnaLibrary;

/**
 *
 * @author root
 */
import com.bangna.control.BangnaLogControl;
import com.bangna.objdb.FAddressDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BContactDB {
    public Config1 config1;
    public BContact contact;
    private BangnaTContact t_contact;
    FAddressDB addressdb ;
    FAddress address ;
    String idtable="132";
    public BangnaLogControl blc;
    public BContactDB(){
        config1 = new Config1();
        initConfig(config1);
    }
    public BContactDB(Config1 cf){
        config1 = cf;
        initConfig(config1);
    }
    private void initConfig(Config1 cf) {
        contact = new BContact();
        address = new FAddress();
        addressdb = new FAddressDB(cf);
        blc = new BangnaLogControl(cf);
    }
    public String getMaxRowBContact(Connection conn){
        String sql="", max="";
        try {
//            Connection conn = config1.getConnectionBangna();
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select max("+contact.getFContactId()+") as cnt From "+contact.getBContact();
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
                max = "13200001";
            }
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
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
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public BContact getBContactByPK(String branch_id, String where,String contact_id, String flag) {
        Connection conn;
//        BContact contact = new BContact();
//        BDepartment department = new BDepartment();
        //FoodsPeriod foodsperiod = new FoodsPeriod();
        String sql="", fullname="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            contact = new BContact();

//            select fa.address_description,contact.* from b_contact contact
//left join f_address fa on contact.contact_changwat = fa.f_address_id --and fa.address_tambon_type ='1'
//left join f_address faa on contact.contact_amphur = faa.f_address_id --and faa.address_tambon_type ='2'
//left join f_address fat on contact.contact_tambon = fat.f_address_id --and fat.address_tambon_type ='3'

            if(flag.equals("contact")){
                sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon, "
                        + "contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet, contact_type_namet "
                +"From "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on "
                        + "contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                + "left join b_contact_type on contact.contact_type_id = b_contact_type.contact_type_id "
                +"Where contact."+contact.getFContactId()+"='"+contact_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }
            else if(flag.equals("contact_like"))
            {
                sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon, "
                        + "contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet, contact_type_namet "
                +"From "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on "
                        + "contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                + "left join b_contact_type on contact.contact_type_id = b_contact_type.contact_type_id "
                +"Where contact."+contact.getFContactId()+" like '%"+contact_id+"'";
            }
            else if(flag.equals("contact_number"))
            {
                sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon, "
                        + "contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet, contact_type_namet "
                +"From "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on "
                        + "contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                + "left join b_contact_type on contact.contact_type_id = b_contact_type.contact_type_id "
                +"Where contact."+contact.getFContactNumber()+"='"+contact_id+"'";
            }
            else if(flag.equals("patient_contact")){
                sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon,contact.* , contact_join."+contact.getFContactNamet()+" as contact_join_namet "
                +"From " +
                "left join "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                +"Where contact."+contact.getFContactId()+"='"+contact_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            } else {
                sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon,contact.* , contact_join."+contact.getFContactNamet()+" as contact_join_namet "
                +"From "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                +"Where contact."+contact.getFContactId()+"='"+contact_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
//                contact = new BContact();
                contact.setContactId(config1.StringNull(rs.getString(contact.getFContactId())));
                contact.setContactActive(config1.StringNull(rs.getString(contact.getFContactActive())));
                contact.setContactAddressOld(config1.StringNull(rs.getString(contact.getFContactAddressOld())));
                contact.setContactAmphur(config1.StringNull(rs.getString(contact.getFContactAmphur())));
                contact.setContactChangwat(config1.StringNull(rs.getString(contact.getFContactChangwat())));

                contact.setContactDate(config1.StringNull(rs.getString(contact.getFContactDate())));
                contact.setContactHouse(config1.StringNull(rs.getString(contact.getFContactHouse())));
                contact.setContactNumber(config1.StringNull(rs.getString(contact.getFContactNumber())));
                contact.setContactMoo(config1.StringNull(rs.getString(contact.getFContactMoo())));
                contact.setContactNamet(config1.StringNull(rs.getString(contact.getFContactNamet())));

                contact.setContactRoad(config1.StringNull(rs.getString(contact.getFContactRoad())));
                contact.setContactSaleMobile(config1.StringNull(rs.getString(contact.getFContactSaleMobile())));
                contact.setContactSaleNamet(config1.StringNull(rs.getString(contact.getFContactSaleNamet())));
                contact.setContactSaleTelephone(config1.StringNull(rs.getString(contact.getFContactSaleTelephone())));
                contact.setContactTambon(config1.StringNull(rs.getString(contact.getFContactTambon())));

                contact.setContactTypeId(config1.StringNull(rs.getString(contact.getFContactTypeId())));
                contact.setDateCancel(config1.StringNull(rs.getString(contact.getFDateCancel())));
                contact.setDateCreate(config1.StringNull(rs.getString(contact.getFDateCreate())));
                contact.setDateModify(config1.StringNull(rs.getString(contact.getFDateModify())));
                contact.setDescription(config1.StringNull(rs.getString(contact.getFDescription())));

                contact.setRemark(config1.StringNull(rs.getString(contact.getFRemark())));
                contact.setSort1(config1.StringNull(rs.getString(contact.getFSort1())));
                contact.setTaxId(config1.StringNull(rs.getString(contact.getFTaxId())));
                contact.setTelephone(config1.StringNull(rs.getString(contact.getFTelephone())));
                contact.setUserCancel(config1.StringNull(rs.getString(contact.getFUserCancel())));
                
                contact.setUserCreate(config1.StringNull(rs.getString(contact.getFUserCreate())));
                contact.setUserModify(config1.StringNull(rs.getString(contact.getFUserModify())));
                contact.setFax(config1.StringNull(rs.getString(contact.getFFax())));
                contact.setBranchId(config1.StringNull(rs.getString(contact.getFBranchId())));
                contact.setPostCode(config1.StringNull(rs.getString(contact.getFPostCode())));

                contact.setContactChangwatName(config1.StringNull(rs.getString("changwat")));
                contact.setContactAmphurName(config1.StringNull(rs.getString("amphur")));
                contact.setContactTambonName(config1.StringNull(rs.getString("tambon")));
                contact.setContactJoinId(config1.StringNull(rs.getString("contact_join_id")));
                contact.setContactJoinNamet(config1.StringNull(rs.getString("contact_join_namet")));

                contact.setStatusContact(config1.StringNull(rs.getString(contact.getFStatusContact())));
                contact.setEmail(config1.StringNull(rs.getString(contact.getFEmail())));
                contact.setEmployment(config1.StringNull(rs.getString(contact.getFEmployment())));
                if(config1.StringNull(rs.getString(contact.getFContactTypeId())).equals("12803")) {
                    fullname = "บริษัท "+contact.getContactNamet()+" "+config1.StringNull(rs.getString("contact_type_namet"));
                }else {
                    fullname = config1.StringNull(rs.getString("contact_type_namet"))+" "+contact.getContactNamet();
                }
                contact.setContactFullname(fullname);

                contact.setContractFilename1(config1.StringNull(rs.getString(contact.getFContractFilename1())));
                contact.setContractFilename2(config1.StringNull(rs.getString(contact.getFContractFilename2())));
                contact.setContractFilename3(config1.StringNull(rs.getString(contact.getFContractFilename3())));
                contact.setStatusMessage(config1.StringNull(rs.getString(contact.getFStatusMessage())));
                contact.setMessageContact(config1.StringNull(rs.getString(contact.getFMessageContact())));
                contact.setMessageMarketing(config1.StringNull(rs.getString(contact.getFMessageMarketing())));
                contact.setStatusInsurance(config1.StringNull(rs.getString(contact.getFstatusInsurance())));
                
                contact.googleMapLat = config1.StringNull(rs.getString(contact.getFGoogleMapLat()));
                contact.googleMapLon = config1.StringNull(rs.getString(contact.getFGoogleMapLon()));
                contact.googleMapZoom = config1.StringNull(rs.getString(contact.getFGoogleMapZoom()));
                contact.statusFunds = config1.StringNull(rs.getString(contact.getFStatusFunds()));
                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contact;
    }
    public BContact getBContactByName(String branch_id, String where,String name,String id, String flag) {
        Connection conn;
//        BContact contact = new BContact();
//        BDepartment department = new BDepartment();
        //FoodsPeriod foodsperiod = new FoodsPeriod();
        String sql="", fullname="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            contact = new BContact();

//            select fa.address_description,contact.* from b_contact contact
//left join f_address fa on contact.contact_changwat = fa.f_address_id --and fa.address_tambon_type ='1'
//left join f_address faa on contact.contact_amphur = faa.f_address_id --and faa.address_tambon_type ='2'
//left join f_address fat on contact.contact_tambon = fat.f_address_id --and fat.address_tambon_type ='3'

            if(flag.equals("contact")){
                sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon, "
                        + "contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet, contact_type_namet "
                +"From "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on "
                        + "contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                + "left join b_contact_type on contact.contact_type_id = b_contact_type.contact_type_id "
                +"Where contact."+contact.getFContactNamet()+"= '"+name+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }else if(flag.equals("contact_number")){
                sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon, "
                        + "contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet, contact_type_namet "
                +"From "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on "
                        + "contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                + "left join b_contact_type on contact.contact_type_id = b_contact_type.contact_type_id "
                +"Where contact."+contact.getFContactNamet()+"='"+name+"' and contact."+contact.getFContactNumber()+" like'%"+id+"'";;
            }else if(flag.equals("patient_contact")){
                sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon,contact.* , contact_join."+contact.getFContactNamet()+" as contact_join_namet "
                +"From " +
                "left join "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                +"Where contact."+contact.getFContactNamet()+"='"+name+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }else if(flag.equals("search_contact_name")){
                sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon, "
                        + "contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet, contact_type_namet "
                +"From "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on "
                        + "contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                + "left join b_contact_type on contact.contact_type_id = b_contact_type.contact_type_id "
                +"Where contact."+contact.getFContactNamet()+" like '"+name+"%'";
            }else{
                sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon,contact.* , contact_join."+contact.getFContactNamet()+" as contact_join_namet "
                +"From "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                +"Where contact."+contact.getFContactNamet()+"='"+name+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
//                contact = new BContact();
                contact.setContactId(config1.StringNull(rs.getString(contact.getFContactId())));
                contact.setContactActive(config1.StringNull(rs.getString(contact.getFContactActive())));
                contact.setContactAddressOld(config1.StringNull(rs.getString(contact.getFContactAddressOld())));
                contact.setContactAmphur(config1.StringNull(rs.getString(contact.getFContactAmphur())));
                contact.setContactChangwat(config1.StringNull(rs.getString(contact.getFContactChangwat())));

                contact.setContactDate(config1.StringNull(rs.getString(contact.getFContactDate())));
                contact.setContactHouse(config1.StringNull(rs.getString(contact.getFContactHouse())));
                contact.setContactNumber(config1.StringNull(rs.getString(contact.getFContactNumber())));
                contact.setContactMoo(config1.StringNull(rs.getString(contact.getFContactMoo())));
                contact.setContactNamet(config1.StringNull(rs.getString(contact.getFContactNamet())));

                contact.setContactRoad(config1.StringNull(rs.getString(contact.getFContactRoad())));
                contact.setContactSaleMobile(config1.StringNull(rs.getString(contact.getFContactSaleMobile())));
                contact.setContactSaleNamet(config1.StringNull(rs.getString(contact.getFContactSaleNamet())));
                contact.setContactSaleTelephone(config1.StringNull(rs.getString(contact.getFContactSaleTelephone())));
                contact.setContactTambon(config1.StringNull(rs.getString(contact.getFContactTambon())));

                contact.setContactTypeId(config1.StringNull(rs.getString(contact.getFContactTypeId())));
                contact.setDateCancel(config1.StringNull(rs.getString(contact.getFDateCancel())));
                contact.setDateCreate(config1.StringNull(rs.getString(contact.getFDateCreate())));
                contact.setDateModify(config1.StringNull(rs.getString(contact.getFDateModify())));
                contact.setDescription(config1.StringNull(rs.getString(contact.getFDescription())));

                contact.setRemark(config1.StringNull(rs.getString(contact.getFRemark())));
                contact.setSort1(config1.StringNull(rs.getString(contact.getFSort1())));
                contact.setTaxId(config1.StringNull(rs.getString(contact.getFTaxId())));
                contact.setTelephone(config1.StringNull(rs.getString(contact.getFTelephone())));
                contact.setUserCancel(config1.StringNull(rs.getString(contact.getFUserCancel())));

                contact.setUserCreate(config1.StringNull(rs.getString(contact.getFUserCreate())));
                contact.setUserModify(config1.StringNull(rs.getString(contact.getFUserModify())));
                contact.setFax(config1.StringNull(rs.getString(contact.getFFax())));
                contact.setBranchId(config1.StringNull(rs.getString(contact.getFBranchId())));
                contact.setPostCode(config1.StringNull(rs.getString(contact.getFPostCode())));

                contact.setContactChangwatName(config1.StringNull(rs.getString("changwat")));
                contact.setContactAmphurName(config1.StringNull(rs.getString("amphur")));
                contact.setContactTambonName(config1.StringNull(rs.getString("tambon")));
                contact.setContactJoinId(config1.StringNull(rs.getString("contact_join_id")));
                contact.setContactJoinNamet(config1.StringNull(rs.getString("contact_join_namet")));

                contact.setStatusContact(config1.StringNull(rs.getString(contact.getFStatusContact())));
                contact.setEmail(config1.StringNull(rs.getString(contact.getFEmail())));
                contact.setEmployment(config1.StringNull(rs.getString(contact.getFEmployment())));
                if(config1.StringNull(rs.getString(contact.getFContactTypeId())).equals("12803")) {
                    fullname = "บริษัท "+contact.getContactNamet()+" "+config1.StringNull(rs.getString("contact_type_namet"));
                }else {
                    fullname = config1.StringNull(rs.getString("contact_type_namet"))+" "+contact.getContactNamet();
                }
                contact.setContactFullname(fullname);

                contact.setContractFilename1(config1.StringNull(rs.getString(contact.getFContractFilename1())));
                contact.setContractFilename2(config1.StringNull(rs.getString(contact.getFContractFilename2())));
                contact.setContractFilename3(config1.StringNull(rs.getString(contact.getFContractFilename3())));
                contact.setStatusMessage(config1.StringNull(rs.getString(contact.getFStatusMessage())));
                contact.setMessageContact(config1.StringNull(rs.getString(contact.getFMessageContact())));
                contact.setMessageMarketing(config1.StringNull(rs.getString(contact.getFMessageMarketing())));
                contact.setStatusInsurance(config1.StringNull(rs.getString(contact.getFstatusInsurance())));
                contact.googleMapLat = config1.StringNull(rs.getString(contact.getFGoogleMapLat()));
                contact.googleMapLon = config1.StringNull(rs.getString(contact.getFGoogleMapLon()));
                contact.googleMapZoom = config1.StringNull(rs.getString(contact.getFGoogleMapZoom()));
                contact.statusFunds = config1.StringNull(rs.getString(contact.getFStatusFunds()));
                
                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contact;
    }
    public Vector getBContactJoin(String branch_id, String where, String flagpage) {
        Connection conn;
//        BContact contact = new BContact();
        Vector v_contact = new Vector();

        String sql="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();

            if(flagpage.equals("search_namet")){
                sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon,contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet "
            +"From "+contact.getBContact()+" as contact " +
            "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
            "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
            "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
            "left join "+contact.getBContact()+" as contact_join on contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
            +"Where contact."+contact.getFContactNamet()+" like '"+where+"%' and "+contact.getFContactActive()+"='1' " +
            "Order By "+contact.getFContactNamet()+" asc";
            }else if(flagpage.equals("contact_namet")){
                sql="Select * "+
                "From "+contact.getBContact()+" "+
                "Where "+contact.getFContactActive()+"='1' and "+contact.getFContactNamet()+" like '"+where+"%' "+
                "Order By "+contact.getFContactNamet()+" asc";
            }else{
                sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon,contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet "
            +"From "+contact.getBContact()+" as contact " +
            "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
            "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
            "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
            "left join "+contact.getBContact()+" as contact_join on contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
            +"Where "+contact.getFContactActive()+"='1' " +
            "Order By "+contact.getFContactNamet()+" asc";
            }
            
            if(!sql.equals("")){
                ResultSet rs = stbangna.executeQuery(sql);
                while(rs.next()){
                    if(rs.getString(contact.getFContactNamet()).length()>0){
                        contact = new BContact();
                        contact.setContactId(config1.StringNull(rs.getString(contact.getFContactId())));
                        contact.setContactActive(config1.StringNull(rs.getString(contact.getFContactActive())));
                        contact.setContactAddressOld(config1.StringNull(rs.getString(contact.getFContactAddressOld())));
                        contact.setContactAmphur(config1.StringNull(rs.getString(contact.getFContactAmphur())));
                        contact.setContactChangwat(config1.StringNull(rs.getString(contact.getFContactChangwat())));

                        contact.setContactDate(config1.StringNull(rs.getString(contact.getFContactDate())));
                        contact.setContactHouse(config1.StringNull(rs.getString(contact.getFContactHouse())));
                        contact.setContactNumber(config1.StringNull(rs.getString(contact.getFContactNumber())));
                        contact.setContactMoo(config1.StringNull(rs.getString(contact.getFContactMoo())));
                        contact.setContactNamet(config1.StringNull(rs.getString(contact.getFContactNamet()).trim()));

                        contact.setContactRoad(config1.StringNull(rs.getString(contact.getFContactRoad())));
                        contact.setContactSaleMobile(config1.StringNull(rs.getString(contact.getFContactSaleMobile())));
                        contact.setContactSaleNamet(config1.StringNull(rs.getString(contact.getFContactSaleNamet())));
                        contact.setContactSaleTelephone(config1.StringNull(rs.getString(contact.getFContactSaleTelephone())));
                        contact.setContactTambon(config1.StringNull(rs.getString(contact.getFContactTambon())));

                        contact.setContactTypeId(config1.StringNull(rs.getString(contact.getFContactTypeId())));
                        contact.setDateCancel(config1.StringNull(rs.getString(contact.getFDateCancel())));
                        contact.setDateCreate(config1.StringNull(rs.getString(contact.getFDateCreate())));
                        contact.setDateModify(config1.StringNull(rs.getString(contact.getFDateModify())));
                        contact.setDescription(config1.StringNull(rs.getString(contact.getFDescription())));

                        contact.setRemark(config1.StringNull(rs.getString(contact.getFRemark())));
                        contact.setSort1(config1.StringNull(rs.getString(contact.getFSort1())));
                        contact.setTaxId(config1.StringNull(rs.getString(contact.getFTaxId())));
                        contact.setTelephone(config1.StringNull(rs.getString(contact.getFTelephone())));
                        contact.setUserCancel(config1.StringNull(rs.getString(contact.getFUserCancel())));

                        contact.setUserCreate(config1.StringNull(rs.getString(contact.getFUserCreate())));
                        contact.setUserModify(config1.StringNull(rs.getString(contact.getFUserModify())));
                        contact.setFax(config1.StringNull(rs.getString(contact.getFFax())));
                        contact.setBranchId(config1.StringNull(rs.getString(contact.getFBranchId())));
                        contact.setPostCode(config1.StringNull(rs.getString(contact.getFPostCode())));

                        contact.setContactChangwatName(config1.StringNull(rs.getString("changwat")));
                        contact.setContactAmphurName(config1.StringNull(rs.getString("amphur")));
                        contact.setContactTambonName(config1.StringNull(rs.getString("tambon")));
                        contact.setContactJoinId(config1.StringNull(rs.getString("contact_join_id")));
                        contact.setContactJoinNamet(config1.StringNull(rs.getString("contact_join_namet")));
                        
                        contact.setStatusContact(config1.StringNull(rs.getString(contact.getFStatusContact())));
                        contact.setEmail(config1.StringNull(rs.getString(contact.getFEmail())));
                        contact.setEmployment(config1.StringNull(rs.getString(contact.getFEmployment())));
                        contact.googleMapLat = config1.StringNull(rs.getString(contact.getFGoogleMapLat()));
                        contact.googleMapLon = config1.StringNull(rs.getString(contact.getFGoogleMapLon()));
                        contact.googleMapZoom = config1.StringNull(rs.getString(contact.getFGoogleMapZoom()));
                        contact.statusFunds = config1.StringNull(rs.getString(contact.getFStatusFunds()));

                        v_contact.add(contact);
                    }
                    
                }
                rs.close();
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_contact;
    }
    public Vector getComboBContactJoin() {
        Connection conn;
//        BContact contact = new BContact();
        Vector v_contact = new Vector();

        String sql="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();

                sql="Select contact.* "+
            "From "+contact.getBContact()+" as contact " +
            "Where "+contact.getFContactActive()+"='1' " +
            "Order By "+contact.getFContactNamet()+" asc";

            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                if(rs.getString(contact.getFContactNamet()).length()>0){
                    contact = new BContact();
                    contact.setContactId(config1.StringNull(rs.getString(contact.getFContactId())));
//                    contact.setContactActive(config1.StringNull(rs.getString(contact.getFContactActive())));
//                    contact.setContactAddressOld(config1.StringNull(rs.getString(contact.getFContactAddressOld())));
//                    contact.setContactAmphur(config1.StringNull(rs.getString(contact.getFContactAmphur())));
//                    contact.setContactChangwat(config1.StringNull(rs.getString(contact.getFContactChangwat())));

//                    contact.setContactDate(config1.StringNull(rs.getString(contact.getFContactDate())));
//                    contact.setContactHouse(config1.StringNull(rs.getString(contact.getFContactHouse())));
//                    contact.setContactNumber(config1.StringNull(rs.getString(contact.getFContactNumber())));
//                    contact.setContactMoo(config1.StringNull(rs.getString(contact.getFContactMoo())));
                    contact.setContactNamet(config1.StringNull(rs.getString(contact.getFContactNamet()).trim()));

//                    contact.setContactRoad(config1.StringNull(rs.getString(contact.getFContactRoad())));
//                    contact.setContactSaleMobile(config1.StringNull(rs.getString(contact.getFContactSaleMobile())));
//                    contact.setContactSaleNamet(config1.StringNull(rs.getString(contact.getFContactSaleNamet())));
//                    contact.setContactSaleTelephone(config1.StringNull(rs.getString(contact.getFContactSaleTelephone())));
//                    contact.setContactTambon(config1.StringNull(rs.getString(contact.getFContactTambon())));
//
//                    contact.setContactTypeId(config1.StringNull(rs.getString(contact.getFContactTypeId())));
//                    contact.setDateCancel(config1.StringNull(rs.getString(contact.getFDateCancel())));
//                    contact.setDateCreate(config1.StringNull(rs.getString(contact.getFDateCreate())));
//                    contact.setDateModify(config1.StringNull(rs.getString(contact.getFDateModify())));
//                    contact.setDescription(config1.StringNull(rs.getString(contact.getFDescription())));
//
//                    contact.setRemark(config1.StringNull(rs.getString(contact.getFRemark())));
//                    contact.setSort1(config1.StringNull(rs.getString(contact.getFSort1())));
//                    contact.setTaxId(config1.StringNull(rs.getString(contact.getFTaxId())));
//                    contact.setTelephone(config1.StringNull(rs.getString(contact.getFTelephone())));
//                    contact.setUserCancel(config1.StringNull(rs.getString(contact.getFUserCancel())));
//
//                    contact.setUserCreate(config1.StringNull(rs.getString(contact.getFUserCreate())));
//                    contact.setUserModify(config1.StringNull(rs.getString(contact.getFUserModify())));
//                    contact.setFax(config1.StringNull(rs.getString(contact.getFFax())));
//                    contact.setBranchId(config1.StringNull(rs.getString(contact.getFBranchId())));
//                    contact.setPostCode(config1.StringNull(rs.getString(contact.getFPostCode())));

//                    contact.setContactChangwatName(config1.StringNull(rs.getString("changwat")));
//                    contact.setContactAmphurName(config1.StringNull(rs.getString("amphur")));
//                    contact.setContactTambonName(config1.StringNull(rs.getString("tambon")));

                    v_contact.add(contact);
                }
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_contact;
    }
    public Vector getBContact(String branch_id, String where, String flagpage) {
        Connection conn;
//        BContact contact = new BContact();
        Vector v_contact = new Vector();
        String sql="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            if(!where.equals("")) {
                if(flagpage.equals("search_namet")) {
//                    sql="Select * "+
//                    "From "+contact.getBContact()+" "+
//                    "Where "+contact.getFContactActive()+"='1' and "+contact.getFContactNamet()+" like '"+where+"%' "+
//                    "Order By "+contact.getFContactNamet()+" asc";
                    sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon,contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet "
                +"From "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                +"Where (contact."+contact.getFContactNamet()+" like '"+where+"%' and contact."+contact.getFContactActive()+"='1') or " +
                            "(contact."+contact.getFContactNumber() +" like '"+where+"%' and contact."+contact.getFContactActive()+"='1')" +
                "Order By contact."+contact.getFContactNamet()+" asc " +
                            "limit 200";
                }else if(flagpage.equals("search_all")){
                    sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon,contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet "
                +"From "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                +"Where (contact."+contact.getFContactNamet()+" like '"+where+"%' and contact."+contact.getFContactActive()+"='1') or " +
                "(contact."+contact.getFContactId() +" like '"+where+"%' and contact."+contact.getFContactActive()+"='1') or " +
                "(contact."+contact.getFContactHouse() +" like '"+where+"%') or " +
                "(contact."+contact.getFContactMoo() +" like '%"+where+"%') or " +
                "(contact."+contact.getFContactRoad() +" like '"+where+"%')  " +
                "Order By contact."+contact.getFContactNamet()+" asc " +
                            "limit 400";
                }else if(flagpage.equals("search_namet_unactive")){
                    sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon,contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet "
                +"From "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                +"Where contact."+contact.getFContactNamet()+" like '"+where+"%' and contact."+contact.getFContactActive()+"='3' " +
                "Order By contact."+contact.getFContactNamet()+" asc";
                }else if(flagpage.equals("contact_namet")){
                    sql="Select * "+
                    "From "+contact.getBContact()+" "+
                    "Where "+contact.getFContactActive()+"='1' and "+contact.getFContactNamet()+" like '"+where+"%' "+
                    "Order By "+contact.getFContactNamet()+" asc";
                }else if(flagpage.equals("contact_namet_unactive")){
                    sql="Select * "+
                    "From "+contact.getBContact()+" "+
                    "Where "+contact.getFContactActive()+"='3' and "+contact.getFContactNamet()+" like '"+where+"%' "+
                    "Order By "+contact.getFContactNamet()+" asc";
                }else if(flagpage.equals("search_namet_front")){
                    sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon,contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet "
                +"From "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on contact."+contact.getFContactJoinId()+" = contact_join."
                            +contact.getFContactId()+" "
                +"Where (contact."+contact.getFContactNamet()+" like '"+where+"%' and contact."+contact.getFContactActive()+"='1') or " +
                            "(contact."+contact.getFContactHouse() +" like '"+where+"%' and contact."+contact.getFContactActive()+"='1') and "
                + "contact.status_contact = '2' " +
                "Order By contact."+contact.getFContactNamet()+" asc " +
                            "limit 200";
                }else if(flagpage.equals("auto_search_contact_join")){
                    sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon,contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet "
                +"From "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                +"Where (contact."+contact.getFContactNamet()+" like '"+where+"%' and contact."+contact.getFContactActive()+"='1') " +
                "Order By contact."+contact.getFContactNamet()+" asc " +
                            "limit 40";
                }else if(flagpage.equals("auto_search_contact_joinN")){
                    sql="Select "+contact.getFContactNumber()+","+contact.getFContactNamet()
                        +" From "+contact.getBContact()
                        +" Where "+contact.getFContactActive()+" = '1' and "+contact.getFstatusInsurance()+"='1' and ("
                        + contact.getFContactNamet()+" like '"+where+"%' Or "+contact.getFContactNumber()+" like '"+where +"%') "
                        + "Order By "+contact.getFContactNamet()+" Limit 20 ";
                }else if(flagpage.equals("auto_search_contact")){
                    sql="Select "+contact.getFContactNumber()+","+contact.getFContactNamet()
                        +" From "+contact.getBContact()
                        +" Where "+contact.getFContactActive()+" = '1' and "+contact.getFstatusInsurance()+"<>'1' and ("
                        + contact.getFContactNamet()+" like '"+where+"%' Or "+contact.getFContactNumber()+" like '"+where +"%') "
                        + "Order By "+contact.getFContactNamet()+" Limit 20 ";
                }else{
                    sql="Select * "
                    +"From "+contact.getBContact()+" "
                    +"Where "+contact.getFContactActive()+"='1' "+
                    "Order By "+contact.getFContactNamet()+" asc";
                }
            }
            if(!sql.equals("")){
                ResultSet rs = stbangna.executeQuery(sql);
                while(rs.next()){
                    contact = new BContact();
                    if(flagpage.equals("auto_search_contact_joinN")){
                        contact.contactNumber = config1.StringNull(rs.getString(contact.getFContactNumber()));
                        contact.contactNamet = config1.StringNull(rs.getString(contact.getFContactNamet()));
                    }else if(flagpage.equals("auto_search_contact")){
                        contact.contactNumber = config1.StringNull(rs.getString(contact.getFContactNumber()));
                        contact.contactNamet = config1.StringNull(rs.getString(contact.getFContactNamet()));
                    }else{
                        contact.setContactId(config1.StringNull(rs.getString(contact.getFContactId())));
                        contact.setContactActive(config1.StringNull(rs.getString(contact.getFContactActive())));
                        contact.setContactAddressOld(config1.StringNull(rs.getString(contact.getFContactAddressOld())));
                        contact.setContactAmphur(config1.StringNull(rs.getString(contact.getFContactAmphur())));
                        contact.setContactChangwat(config1.StringNull(rs.getString(contact.getFContactChangwat())));

                        contact.setContactDate(config1.StringNull(rs.getString(contact.getFContactDate())));
                        contact.setContactHouse(config1.StringNull(rs.getString(contact.getFContactHouse())));
                        contact.setContactNumber(config1.StringNull(rs.getString(contact.getFContactNumber())));
                        contact.setContactMoo(config1.StringNull(rs.getString(contact.getFContactMoo())));
                        contact.setContactNamet(config1.StringNull(rs.getString(contact.getFContactNamet())));

                        contact.setContactRoad(config1.StringNull(rs.getString(contact.getFContactRoad())));
                        contact.setContactSaleMobile(config1.StringNull(rs.getString(contact.getFContactSaleMobile())));
                        contact.setContactSaleNamet(config1.StringNull(rs.getString(contact.getFContactSaleNamet())));
                        contact.setContactSaleTelephone(config1.StringNull(rs.getString(contact.getFContactSaleTelephone())));
                        contact.setContactTambon(config1.StringNull(rs.getString(contact.getFContactTambon())));

                        contact.setContactTypeId(config1.StringNull(rs.getString(contact.getFContactTypeId())));
                        contact.setDateCancel(config1.StringNull(rs.getString(contact.getFDateCancel())));
                        contact.setDateCreate(config1.StringNull(rs.getString(contact.getFDateCreate())));
                        contact.setDateModify(config1.StringNull(rs.getString(contact.getFDateModify())));
                        contact.setDescription(config1.StringNull(rs.getString(contact.getFDescription())));

                        contact.setRemark(config1.StringNull(rs.getString(contact.getFRemark())));
                        contact.setSort1(config1.StringNull(rs.getString(contact.getFSort1())));
                        contact.setTaxId(config1.StringNull(rs.getString(contact.getFTaxId())));
                        contact.setTelephone(config1.StringNull(rs.getString(contact.getFTelephone())));
                        contact.setUserCancel(config1.StringNull(rs.getString(contact.getFUserCancel())));

                        contact.setUserCreate(config1.StringNull(rs.getString(contact.getFUserCreate())));
                        contact.setUserModify(config1.StringNull(rs.getString(contact.getFUserModify())));
                        contact.setFax(config1.StringNull(rs.getString(contact.getFFax())));
                        contact.setBranchId(config1.StringNull(rs.getString(contact.getFBranchId())));
                        contact.setPostCode(config1.StringNull(rs.getString(contact.getFPostCode())));

                        contact.setContactChangwatName(config1.StringNull(rs.getString("changwat")));
                        contact.setContactAmphurName(config1.StringNull(rs.getString("amphur")));
                        contact.setContactTambonName(config1.StringNull(rs.getString("tambon")));
                        contact.setContactJoinId(config1.StringNull(rs.getString("contact_join_id")));
                        contact.setContactJoinNamet(config1.StringNull(rs.getString("contact_join_namet")));

                        contact.setContractFilename1(config1.StringNull(rs.getString(contact.getFContractFilename1())));
                        contact.setContractFilename2(config1.StringNull(rs.getString(contact.getFContractFilename2())));
                        contact.setContractFilename3(config1.StringNull(rs.getString(contact.getFContractFilename3())));
                        contact.setEmployment(config1.StringNull(rs.getString(contact.getFEmployment())));
                        contact.setStatusMessage(config1.StringNull(rs.getString(contact.getFStatusMessage())));

                        contact.setMessageContact(config1.StringNull(rs.getString(contact.getFMessageContact())));
                        contact.setMessageMarketing(config1.StringNull(rs.getString(contact.getFMessageMarketing())));
                        contact.setStatusInsurance(config1.StringNull(rs.getString(contact.getFstatusInsurance())));

                        contact.googleMapLat = config1.StringNull(rs.getString(contact.getFGoogleMapLat()));
                        contact.googleMapLon = config1.StringNull(rs.getString(contact.getFGoogleMapLon()));
                        contact.googleMapZoom = config1.StringNull(rs.getString(contact.getFGoogleMapZoom()));
                        contact.statusFunds = config1.StringNull(rs.getString(contact.getFStatusFunds()));
                    }
                    v_contact.add(contact);
                }
                rs.close();
            }

            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_contact;
    }
    public List getBContactL(String branch_id, String where, String limit, String flagpage) {
        Connection conn;
//        BContact contact = new BContact();
        List lContact = new ArrayList<BContact>();
        String sql="", searchLimit="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            if(!where.equals("")) {
                if(flagpage.equals("search_namet")) {
//                    sql="Select * "+
//                    "From "+contact.getBContact()+" "+
//                    "Where "+contact.getFContactActive()+"='1' and "+contact.getFContactNamet()+" like '"+where+"%' "+
//                    "Order By "+contact.getFContactNamet()+" asc";
                    sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon,contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet "
                +"From "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                +"Where (contact."+contact.getFContactNamet()+" like '"+where+"%' and contact."+contact.getFContactActive()+"='1') or " +
                            "(contact."+contact.getFContactNumber() +" like '"+where+"%' and contact."+contact.getFContactActive()+"='1')" +
                "Order By contact."+contact.getFContactNamet()+" asc " +
                            "limit 200";
                }else if(flagpage.equals("search_all")){
                    if(!limit.equals("")){
                        searchLimit = "limit "+limit;
                    }
                    sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon,contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet "
                    +"From "+contact.getBContact()+" as contact " +
                    "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                    "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                    "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                    "left join "+contact.getBContact()+" as contact_join on contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                    +"Where (contact."+contact.getFContactNamet()+" like '"+where+"%' and contact."+contact.getFContactActive()+"='1') or " +
                    "(contact."+contact.getFContactId() +" like '"+where+"%' and contact."+contact.getFContactActive()+"='1') or " +
                    "(contact."+contact.getFContactHouse() +" like '"+where+"%') or " +
                    "(contact."+contact.getFContactMoo() +" like '%"+where+"%') or " +
                    "(contact."+contact.getFContactRoad() +" like '"+where+"%')  " +
                    "Order By contact."+contact.getFContactNamet()+" asc " +searchLimit;
                }else if(flagpage.equals("search_namet_unactive")){
                    sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon,contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet "
                +"From "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                +"Where contact."+contact.getFContactNamet()+" like '"+where+"%' and contact."+contact.getFContactActive()+"='3' " +
                "Order By contact."+contact.getFContactNamet()+" asc";
                }else if(flagpage.equals("contact_namet")){
                    sql="Select * "+
                    "From "+contact.getBContact()+" "+
                    "Where "+contact.getFContactActive()+"='1' and "+contact.getFContactNamet()+" like '"+where+"%' "+
                    "Order By "+contact.getFContactNamet()+" asc";
                }else if(flagpage.equals("contact_namet_unactive")){
                    sql="Select * "+
                    "From "+contact.getBContact()+" "+
                    "Where "+contact.getFContactActive()+"='3' and "+contact.getFContactNamet()+" like '"+where+"%' "+
                    "Order By "+contact.getFContactNamet()+" asc";
                }else if(flagpage.equals("search_namet_front")){
                    sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon,contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet "
                +"From "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on contact."+contact.getFContactJoinId()+" = contact_join."
                            +contact.getFContactId()+" "
                +"Where (contact."+contact.getFContactNamet()+" like '"+where+"%' and contact."+contact.getFContactActive()+"='1') or " +
                            "(contact."+contact.getFContactHouse() +" like '"+where+"%' and contact."+contact.getFContactActive()+"='1') and "
                + "contact.status_contact = '2' " +
                "Order By contact."+contact.getFContactNamet()+" asc " +
                            "limit 200";
                }else if(flagpage.equals("auto_search_contact_join")){
                    sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon,contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet "
                +"From "+contact.getBContact()+" as contact " +
                "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                "left join "+contact.getBContact()+" as contact_join on contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                +"Where (contact."+contact.getFContactNamet()+" like '"+where+"%' and contact."+contact.getFContactActive()+"='1') " +
                "Order By contact."+contact.getFContactNamet()+" asc " +
                            "limit 40";
                }else if(flagpage.equals("auto_search_contact_joinN")){
                    sql="Select "+contact.getFContactNumber()+","+contact.getFContactNamet()
                        +" From "+contact.getBContact()
                        +" Where "+contact.getFContactActive()+" = '1' and "+contact.getFstatusInsurance()+"='1' and ("
                        + contact.getFContactNamet()+" like '"+where+"%' Or "+contact.getFContactNumber()+" like '"+where +"%') "
                        + "Order By "+contact.getFContactNamet()+" Limit 20 ";
                }else if(flagpage.equals("auto_search_contact")){
                    sql="Select "+contact.getFContactNumber()+","+contact.getFContactNamet()
                        +" From "+contact.getBContact()
                        +" Where "+contact.getFContactActive()+" = '1' and "+contact.getFstatusInsurance()+"<>'1' and ("
                        + contact.getFContactNamet()+" like '"+where+"%' Or "+contact.getFContactNumber()+" like '"+where +"%') "
                        + "Order By "+contact.getFContactNamet()+" Limit 20 ";
                }else if(flagpage.equals("auto_search_contact_tavon")){
                    if(!limit.equals("")){
                        searchLimit = "limit "+limit;
                    }
                    sql="Select fa.address_description as changwat,faa.address_description as amphur,fat.address_description as tambon,contact.*, contact_join."+contact.getFContactNamet()+" as contact_join_namet "
                    +"From "+contact.getBContact()+" as contact " +
                    "left join f_address fa on contact.contact_changwat = fa.f_address_id  " +
                    "left join f_address faa on contact.contact_amphur = faa.f_address_id  " +
                    "left join f_address fat on contact.contact_tambon = fat.f_address_id  " +
                    "left join "+contact.getBContact()+" as contact_join on contact."+contact.getFContactJoinId()+" = contact_join."+contact.getFContactId()+" "
                    +"Where (contact."+contact.getFContactNamet()+" like '"+where+"%' and contact."+contact.getFContactActive()+"='1')  " +
//                    "(contact."+contact.getFContactId() +" like '"+where+"%' and contact."+contact.getFContactActive()+"='1') or " +
//                    "(contact."+contact.getFContactHouse() +" like '"+where+"%') or " +
//                    "(contact."+contact.getFContactMoo() +" like '%"+where+"%') or " +
//                    "(contact."+contact.getFContactRoad() +" like '"+where+"%')  " +
                    "Order By contact."+contact.getFContactNamet()+" asc " +searchLimit;
                }else{
                    sql="Select * "
                    +"From "+contact.getBContact()+" "
                    +"Where "+contact.getFContactActive()+"='1' "+
                    "Order By "+contact.getFContactNamet()+" asc";
                }
            }
            if(!sql.equals("")){
                ResultSet rs = stbangna.executeQuery(sql);
                while(rs.next()){
                    contact = new BContact();
                    if(flagpage.equals("auto_search_contact_joinN")){
                        contact.contactNumber = config1.StringNull(rs.getString(contact.getFContactNumber()));
                        contact.contactNamet = config1.StringNull(rs.getString(contact.getFContactNamet()));
                    }else if(flagpage.equals("auto_search_contact")){
                        contact.contactNumber = config1.StringNull(rs.getString(contact.getFContactNumber()));
                        contact.contactNamet = config1.StringNull(rs.getString(contact.getFContactNamet()));
                    }else{
                        contact.setContactId(config1.StringNull(rs.getString(contact.getFContactId())));
                        contact.setContactActive(config1.StringNull(rs.getString(contact.getFContactActive())));
                        contact.setContactAddressOld(config1.StringNull(rs.getString(contact.getFContactAddressOld())));
                        contact.setContactAmphur(config1.StringNull(rs.getString(contact.getFContactAmphur())));
                        contact.setContactChangwat(config1.StringNull(rs.getString(contact.getFContactChangwat())));

                        contact.setContactDate(config1.StringNull(rs.getString(contact.getFContactDate())));
                        contact.setContactHouse(config1.StringNull(rs.getString(contact.getFContactHouse())));
                        contact.setContactNumber(config1.StringNull(rs.getString(contact.getFContactNumber())));
                        contact.setContactMoo(config1.StringNull(rs.getString(contact.getFContactMoo())));
                        contact.setContactNamet(config1.StringNull(rs.getString(contact.getFContactNamet())));

                        contact.setContactRoad(config1.StringNull(rs.getString(contact.getFContactRoad())));
                        contact.setContactSaleMobile(config1.StringNull(rs.getString(contact.getFContactSaleMobile())));
                        contact.setContactSaleNamet(config1.StringNull(rs.getString(contact.getFContactSaleNamet())));
                        contact.setContactSaleTelephone(config1.StringNull(rs.getString(contact.getFContactSaleTelephone())));
                        contact.setContactTambon(config1.StringNull(rs.getString(contact.getFContactTambon())));

                        contact.setContactTypeId(config1.StringNull(rs.getString(contact.getFContactTypeId())));
                        contact.setDateCancel(config1.StringNull(rs.getString(contact.getFDateCancel())));
                        contact.setDateCreate(config1.StringNull(rs.getString(contact.getFDateCreate())));
                        contact.setDateModify(config1.StringNull(rs.getString(contact.getFDateModify())));
                        contact.setDescription(config1.StringNull(rs.getString(contact.getFDescription())));

                        contact.setRemark(config1.StringNull(rs.getString(contact.getFRemark())));
                        contact.setSort1(config1.StringNull(rs.getString(contact.getFSort1())));
                        contact.setTaxId(config1.StringNull(rs.getString(contact.getFTaxId())));
                        contact.setTelephone(config1.StringNull(rs.getString(contact.getFTelephone())));
                        contact.setUserCancel(config1.StringNull(rs.getString(contact.getFUserCancel())));

                        contact.setUserCreate(config1.StringNull(rs.getString(contact.getFUserCreate())));
                        contact.setUserModify(config1.StringNull(rs.getString(contact.getFUserModify())));
                        contact.setFax(config1.StringNull(rs.getString(contact.getFFax())));
                        contact.setBranchId(config1.StringNull(rs.getString(contact.getFBranchId())));
                        contact.setPostCode(config1.StringNull(rs.getString(contact.getFPostCode())));

                        contact.setContactChangwatName(config1.StringNull(rs.getString("changwat")));
                        contact.setContactAmphurName(config1.StringNull(rs.getString("amphur")));
                        contact.setContactTambonName(config1.StringNull(rs.getString("tambon")));
                        contact.setContactJoinId(config1.StringNull(rs.getString("contact_join_id")));
                        contact.setContactJoinNamet(config1.StringNull(rs.getString("contact_join_namet")));

                        contact.setContractFilename1(config1.StringNull(rs.getString(contact.getFContractFilename1())));
                        contact.setContractFilename2(config1.StringNull(rs.getString(contact.getFContractFilename2())));
                        contact.setContractFilename3(config1.StringNull(rs.getString(contact.getFContractFilename3())));
                        contact.setEmployment(config1.StringNull(rs.getString(contact.getFEmployment())));
                        contact.setStatusMessage(config1.StringNull(rs.getString(contact.getFStatusMessage())));

                        contact.setMessageContact(config1.StringNull(rs.getString(contact.getFMessageContact())));
                        contact.setMessageMarketing(config1.StringNull(rs.getString(contact.getFMessageMarketing())));
                        contact.setStatusInsurance(config1.StringNull(rs.getString(contact.getFstatusInsurance())));

                        contact.googleMapLat = config1.StringNull(rs.getString(contact.getFGoogleMapLat()));
                        contact.googleMapLon = config1.StringNull(rs.getString(contact.getFGoogleMapLon()));
                        contact.googleMapZoom = config1.StringNull(rs.getString(contact.getFGoogleMapZoom()));
                        contact.statusFunds = config1.StringNull(rs.getString(contact.getFStatusFunds()));
                    }
                    lContact.add(contact);
                }
                rs.close();
            }

            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lContact;
    }
    public String setSaveBContact(String branch_id,BContact item, String flagpage) throws Exception {
        int chk=0;
        String sql="", ma_date="", attend_date="", max="";
//        BContact contact = new BContact();
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            String contact_id = item.getContactId();
            if(contact_id.length()==5)
                contact_id = "132"+contact_id;
            contact = getBContactByPK(branch_id,"",contact_id,"contact");
            if(contact.getContactNamet().equals("")) {
                contact = getBContactByPK(config1.branch.getBranchId(), ""
                        ,contact_id, "contact_number");
            }
            if(contact.getContactNamet().equals("")) {
//                contact = getBContactByPK(config1.branch.getBranchId(), "",contact_id.substring(3), "contact_number"); //m1-
                if(contact_id.length()>=3){//m1+
                    contact = getBContactByPK(config1.branch.getBranchId(), "",contact_id.substring(3), "contact_number"); //m1+
                }//m1+
            }
            item.setDescription(item.getDescription().replace("'", "''"));
            item.setRemark(item.getRemark().replace("'", "''"));
            item.setTelephone(item.getTelephone().replace("'", "''"));
            item.setContactSaleNamet(item.getContactSaleNamet().replace("'", "''"));
            item.setContactHouse(item.getContactHouse().replace("'", "''"));
            item.setContactMoo(item.getContactMoo().replace("'", "''"));
            item.setContactRoad(item.getContactRoad().replace("'", "''"));
            item.setContactNamet(item.getContactNamet().replace("'", "''"));
            item.setMessageContact(item.getMessageContact().replace("'", "''"));
            if(contact.getContactId().equals("")){
                max = getMaxRowBContact(conn);
                sql="Insert Into "+contact.getBContact()+"("
                +contact.getFContactId()+", "+contact.getFContactActive()+", "
                +contact.getFContactAddressOld()+","+ contact.getFContactAmphur()+","
                +contact.getFContactChangwat()+","+ contact.getFContactDate()+","
                +contact.getFContactHouse()+","+ contact.getFContactNumber()+","
                +contact.getFContactMoo()+","+ contact.getFContactNamet()+","
                +contact.getFContactRoad()+","+ contact.getFContactSaleMobile()+","
                +contact.getFContactSaleNamet()+","+ contact.getFContactSaleTelephone()+","
                +contact.getFContactTambon()+","+ contact.getFContactTypeId()+","
                +contact.getFDateCancel()+","+ contact.getFDateCreate()+","
                +contact.getFDateModify()+","+ contact.getFDescription()+","
                +contact.getFRemark()+","+ contact.getFSort1()+","
                +contact.getFTaxId()+","+ contact.getFTelephone()+","
                +contact.getFUserCancel()+","+ contact.getFUserCreate()+","
                +contact.getFUserModify()+","+contact.getFFax()+"," +
                contact.getFBranchId()+","+contact.getFPostCode()+"," +
                contact.getFContactJoinId()+","+contact.getFStatusContact()+","
                + contact.getFEmail()+","+contact.getFEmployment()+","
                + contact.getFContractFilename1()+","+contact.getFContractFilename2()+","
                + contact.getFContractFilename3()+","+contact.getFStatusMessage()+","
                + contact.getFMessageContact()+") "
                +"Values('"+max+"','"+item.getContactActive()+"','"
                +item.getContactAddressOld() + "','"+ item.getContactAmphur()+"','"
                +item.getContactChangwat() + "','"+ item.getContactDate()+"','"
                +item.getContactHouse() + "','" + max + "','"
                +item.getContactMoo() + "','"+ item.getContactNamet()+"','"
                +item.getContactRoad() + "','"+ item.getContactSaleMobile()+"','"
                +item.getContactSaleNamet() + "','"+ item.getContactSaleTelephone()+"','"
                +item.getContactTambon() + "','"+ item.getContactTypeId()+"','"
                +item.getDateCancel() + "','"+ item.getDateCreate()+"','"
                +item.getDateModify() + "','"+ item.getDescription()+"','"
                +item.getRemark() + "','"+ item.getSort1()+"','"
                +item.getTaxId() + "','"+ item.getTelephone()+"','"
                +item.getUserCancel() + "','"+ item.getUserCreate()+"','"
                +item.getUserModify() + "','"+item.getFax()+"','" +
                item.getBranchId()+"','"+item.getPostCode()+"','" +
                item.getContactJoinId()+"','"+item.getStatusContact()+"','"
                + item.getEmail()+"','"+item.getEmployment()+"','"
                + item.getContractFilename1()+"','"+item.getContractFilename2()+"','"
                + item.getContractFilename3()+"','"+item.getStatusMessage()+"','"
                + item.getMessageContact()+"')";
            }else {
//                attend_date=config1.DateFormatShow2DB(itemdetail.getAttendDate(), "ddMMyyyy");
//                wound_care_date=config1.DateFormatShow2DB(itemdetail.getMaDate(), "ddMMyyyy");
                sql = "Update "+contact.getBContact()+" set "
                +contact.getFContactId()+" = '"+item.getContactId()+"', "
                +contact.getFContactActive()+" = '"+item.getContactActive()+"', "
                +contact.getFContactAddressOld()+" = '"+item.getContactAddressOld()+"', "
                +contact.getFContactAmphur()+" = '"+item.getContactAmphur()+"', "
                +contact.getFContactChangwat()+" = '"+item.getContactChangwat()+"', "
                +contact.getFContactDate()+" = '"+item.getContactDate()+"', "
                +contact.getFContactHouse()+" = '"+item.getContactHouse()+"', "
                +contact.getFContactNumber()+" = '"+item.getContactId()+"', "
                +contact.getFContactMoo()+" = '"+item.getContactMoo()+"', "
                +contact.getFContactNamet()+" = '"+item.getContactNamet()+"', "
                +contact.getFContactRoad()+" = '"+item.getContactRoad()+"', "
                +contact.getFContactSaleMobile()+" = '"+item.getContactSaleMobile()+"', "
                +contact.getFContactSaleNamet()+" = '"+item.getContactSaleNamet()+"', "
                +contact.getFContactSaleTelephone()+" = '"+item.getContactSaleTelephone()+"', "
                +contact.getFContactTambon()+" = '"+item.getContactTambon()+"', "
                +contact.getFContactTypeId()+" = '"+item.getContactTypeId()+"', "
                +contact.getFDateCancel()+" = '"+item.getDateCancel()+"', "
                +contact.getFDateCreate()+" = '"+item.getDateCreate()+"', "
                +contact.getFDateModify()+" = '"+item.getDateModify()+"', "
                +contact.getFDescription()+" = '"+item.getDescription()+"', "
                +contact.getFRemark()+" = '"+item.getRemark()+"', "
                +contact.getFSort1()+" = '"+item.getSort1()+"', "
                +contact.getFTaxId()+" = '"+item.getTaxId()+"', "
                +contact.getFTelephone()+" = '"+item.getTelephone()+"', "
                +contact.getFUserCancel()+" = '"+item.getUserCancel()+"', "
                +contact.getFUserCreate()+" = '"+item.getUserCreate()+"', "
                +contact.getFUserModify()+" = '"+item.getUserModify()+"', "+
                contact.getFFax()+" = '"+item.getFax()+"', "+
                contact.getFBranchId()+" = '"+item.getBranchId()+"', "+
                contact.getFPostCode()+" = '"+item.getPostCode()+"', "+
                contact.getFContactJoinId()+" = '"+item.getContactJoinId()+"', "
                +contact.getFStatusContact()+" = '"+item.getStatusContact()+"', "
                +contact.getFEmail()+" = '"+item.getEmail()+"', "
                +contact.getFEmployment()+" = '"+item.getEmployment()+"', "
                +contact.getFContractFilename1()+" = '"+item.getContractFilename1()+"', "
                +contact.getFContractFilename2()+" = '"+item.getContractFilename2()+"', "
//                +contact.getFContactNumber()+" = '"+item.getContactNumber()+"', "
                +contact.getFContractFilename3()+" = '"+item.getContractFilename3()+"', "
                +contact.getFStatusMessage()+" = '"+item.getStatusMessage()+"', "
                +contact.getFMessageContact()+" = '"+item.getMessageContact()+"' "
                +"Where "+contact.getFContactId()+" = '"+item.getContactId()+"'";
                max = item.getContactId();
            }
            System.err.println(sql);
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String setSaveBContactWeb(String branch_id,BContact item, String flagpage) throws Exception {
        int chk=0;
        String sql="", ma_date="", attend_date="", max="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            String contact_id = item.getContactId();
            if(contact_id.length()==5)
                contact_id = "132"+contact_id;
            contact = getBContactByPK(branch_id,"",contact_id,"contact");
            if(contact.getContactNamet().equals("")) {
//                if(!flagpage.equals("save_web_new")) 
                    contact = getBContactByPK(config1.branch.getBranchId(), "",contact_id, "contact_number");
            }
            if(contact.getContactNamet().equals("")) {
//                contact = getBContactByPK(config1.branch.getBranchId(), "",contact_id.substring(3), "contact_number"); //m1-
                if(contact_id.length()>=3){//m1+
                    contact = getBContactByPK(config1.branch.getBranchId(), "",contact_id.substring(3), "contact_number"); //m1+
                }//m1+
            }
            item.setDescription(item.getDescription().replace("'", "''"));
            item.setRemark(item.getRemark().replace("'", "''"));
            item.setTelephone(item.getTelephone().replace("'", "''"));
            item.setContactSaleNamet(item.getContactSaleNamet().replace("'", "''"));
            item.setContactHouse(item.getContactHouse().replace("'", "''"));
            item.setContactMoo(item.getContactMoo().replace("'", "''"));
            item.setContactRoad(item.getContactRoad().replace("'", "''"));
            item.setContactNamet(item.getContactNamet().replace("'", "''"));
            item.setMessageContact(item.getMessageContact().replace("'", "''"));
            if(contact.getContactId().equals("")){
                item.generateOID(idtable);
                max = item.getObjectId();
//                max = getMaxRowBContact(conn);
                
                if((item.getContactNumber().equals("")) || (item.getContactNumber() == null)){
                    item.setContactNumber(getContactNumberMax());
                }
                sql="Insert Into "+contact.getBContact()+"("
                +contact.getFContactId()+", "+contact.getFContactActive()+", "
                +contact.getFContactNamet()+","
                +contact.getFContactTypeId()+","
                +contact.getFDescription()+","
                +contact.getFRemark()+","
                +contact.getFContactNumber()+","
                +contact.getFBranchId()+") "
                +"Values('"+max+"','"+item.getContactActive()+"','"
                + item.getContactNamet()+"','"
                + item.getContactTypeId()+"','"
                + item.getDescription()+"','"
                + item.getRemark() + "','"
                + item.getContactNumber() + "','"
                + item.getBranchId()+"')";
            }else {
                sql = "Update "+contact.getBContact()+" set "
                +contact.getFContactTypeId()+" = '"+item.getContactTypeId()+"', "
                +contact.getFDescription()+" = '"+item.getDescription()+"', "
                +contact.getFRemark()+" = '"+item.getRemark()+"', "
                +contact.getFBranchId()+" = '"+item.getBranchId()+"' "
                +"Where "+contact.getFContactId()+" = '"+item.getContactId()+"'";
                max = item.getContactId();
            }
            System.err.println(sql);
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
            blc.saveLog("bangnamarketing.setSaveBContactWeb", "", "", "ContactNamet="+item.getContactNamet(), config1.getDateDBHospital("yyyyMMdd hh:mm:ss"), "", "", "ex="+ex.getMessage());
        }
        return item.getContactNumber();
    }
    public String setUpdateBContactWeb(String branch_id,BContact item, String flagpage) throws Exception {
        Integer chk=0;
        String sql="", ma_date="", attend_date="", max="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            String contact_id = item.getContactId();
            if(contact_id.length()==5)
                contact_id = "132"+contact_id;
            item.setDescription(item.getDescription().replace("'", "''"));
            item.setRemark(item.getRemark().replace("'", "''"));
            sql = "Update "+contact.getBContact()+" set "
            +contact.getFContactTypeId()+" = '"+item.contactTypeId+"', "
            +contact.getFDescription()+" = '"+item.description+"', "
            +contact.getFRemark()+" = '"+item.remark+"', "
            +contact.getFBranchId()+" = '"+item.branchId+"' "
            +"Where "+contact.getFContactId()+" = '"+item.contactId+"'";
            max = item.contactId;
            System.err.println(sql);
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setSaveBContactN(String branch_id,BContact item, String flagpage) throws Exception {
        int chk=0;
        String sql="", ma_date="", attend_date="", max="";
//        BContact contact = new BContact();
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            String contact_id = item.getContactId();
            if(contact_id.length()==5)
                contact_id = "132"+contact_id;
            contact = getBContactByName(config1.branch.getBranchId(), ""
                        ,item.getContactNamet(),contact_id, "contact_number");
            if(contact.getContactNamet().equals(""))
            {
                contact = getBContactByName(config1.branch.getBranchId(), ""
                        ,item.getContactNamet(),contact_id, "contact_number");
            }
            if(contact.getContactNamet().equals(""))
            {
//                contact = getBContactByPK(config1.branch.getBranchId(), "",contact_id.substring(3), "contact_number"); //m1-
                if(contact_id.length()>=3){//m1+
                    contact = getBContactByName(config1.branch.getBranchId(), "",item.getContactNamet(),contact_id.substring(3), "contact_number"); //m1+
                }//m1+
            }
            item.setDescription(item.getDescription().replace("'", "''"));
            item.setRemark(item.getRemark().replace("'", "''"));
            item.setTelephone(item.getTelephone().replace("'", "''"));
            item.setContactSaleNamet(item.getContactSaleNamet().replace("'", "''"));
            item.setContactHouse(item.getContactHouse().replace("'", "''"));
            item.setContactMoo(item.getContactMoo().replace("'", "''"));
            item.setContactRoad(item.getContactRoad().replace("'", "''"));
            item.setContactNamet(item.getContactNamet().replace("'", "''"));
            item.setMessageContact(item.getMessageContact().replace("'", "''"));
            item.setContractFilename1(contact.getContractFilename1());
            item.setContractFilename2(contact.getContractFilename2());
            item.setContractFilename3(contact.getContractFilename3());
            item.setStatusMessage(contact.getStatusMessage());
            item.setMessageContact(contact.getMessageContact());
            item.setMessageMarketing(contact.getMessageMarketing());
            item.setStatusInsurance(contact.getStatusInsurance());
            if(contact.getContactId().equals("")){
                max = getMaxRowBContact(conn);
                sql="Insert Into "+contact.getBContact()+"("
                +contact.getFContactId()+", "+contact.getFContactActive()+", "
                +contact.getFContactAddressOld()+","+ contact.getFContactAmphur()+","
                +contact.getFContactChangwat()+","+ contact.getFContactDate()+","
                +contact.getFContactHouse()+","+ contact.getFContactNumber()+","
                +contact.getFContactMoo()+","+ contact.getFContactNamet()+","
                +contact.getFContactRoad()+","+ contact.getFContactSaleMobile()+","
                +contact.getFContactSaleNamet()+","+ contact.getFContactSaleTelephone()+","
                +contact.getFContactTambon()+","+ contact.getFContactTypeId()+","
                +contact.getFDateCancel()+","+ contact.getFDateCreate()+","
                +contact.getFDateModify()+","+ contact.getFDescription()+","
                +contact.getFRemark()+","+ contact.getFSort1()+","
                +contact.getFTaxId()+","+ contact.getFTelephone()+","
                +contact.getFUserCancel()+","+ contact.getFUserCreate()+","
                +contact.getFUserModify()+","+contact.getFFax()+"," +
                contact.getFBranchId()+","+contact.getFPostCode()+"," +
                contact.getFContactJoinId()+","+contact.getFStatusContact()+","
                + contact.getFEmail()+","+contact.getFEmployment()+","
                + contact.getFContractFilename1()+","+contact.getFContractFilename2()+","
                + contact.getFContractFilename3()+","+contact.getFStatusMessage()+","
                + contact.getFMessageContact()+") "
                +"Values('"+max+"','"+item.getContactActive()+"','"
                +item.getContactAddressOld() + "','"+ item.getContactAmphur()+"','"
                +item.getContactChangwat() + "','"+ item.getContactDate()+"','"
                +item.getContactHouse() + "','" + max + "','"
                +item.getContactMoo() + "','"+ item.getContactNamet()+"','"
                +item.getContactRoad() + "','"+ item.getContactSaleMobile()+"','"
                +item.getContactSaleNamet() + "','"+ item.getContactSaleTelephone()+"','"
                +item.getContactTambon() + "','"+ item.getContactTypeId()+"','"
                +item.getDateCancel() + "','"+ item.getDateCreate()+"','"
                +item.getDateModify() + "','"+ item.getDescription()+"','"
                +item.getRemark() + "','"+ item.getSort1()+"','"
                +item.getTaxId() + "','"+ item.getTelephone()+"','"
                +item.getUserCancel() + "','"+ item.getUserCreate()+"','"
                +item.getUserModify() + "','"+item.getFax()+"','" +
                item.getBranchId()+"','"+item.getPostCode()+"','" +
                item.getContactJoinId()+"','"+item.getStatusContact()+"','"
                + item.getEmail()+"','"+item.getEmployment()+"','"
                + item.getContractFilename1()+"','"+item.getContractFilename2()+"','"
                + item.getContractFilename3()+"','"+item.getStatusMessage()+"','"
                + item.getMessageContact()+"')";
            }else {
//                attend_date=config1.DateFormatShow2DB(itemdetail.getAttendDate(), "ddMMyyyy");
//                wound_care_date=config1.DateFormatShow2DB(itemdetail.getMaDate(), "ddMMyyyy");
                sql = "Update "+contact.getBContact()+" set "
//                +contact.getFContactId()+" = '"+item.getContactId()+"', "
                +contact.getFContactActive()+" = '"+item.getContactActive()+"', "
                +contact.getFContactAddressOld()+" = '"+item.getContactAddressOld()+"', "
                +contact.getFContactAmphur()+" = '"+item.getContactAmphur()+"', "
                +contact.getFContactChangwat()+" = '"+item.getContactChangwat()+"', "
                +contact.getFContactDate()+" = '"+item.getContactDate()+"', "
                +contact.getFContactHouse()+" = '"+item.getContactHouse()+"', "
//                +contact.getFContactNumber()+" = '"+contact.getContactNumber()+"', "
                +contact.getFContactMoo()+" = '"+item.getContactMoo()+"', "
                +contact.getFContactNamet()+" = '"+item.getContactNamet()+"', "
                +contact.getFContactRoad()+" = '"+item.getContactRoad()+"', "
                +contact.getFContactSaleMobile()+" = '"+item.getContactSaleMobile()+"', "
                +contact.getFContactSaleNamet()+" = '"+item.getContactSaleNamet()+"', "
                +contact.getFContactSaleTelephone()+" = '"+item.getContactSaleTelephone()+"', "
                +contact.getFContactTambon()+" = '"+item.getContactTambon()+"', "
                +contact.getFContactTypeId()+" = '"+item.getContactTypeId()+"', "
                +contact.getFDateCancel()+" = '"+item.getDateCancel()+"', "
                +contact.getFDateCreate()+" = '"+item.getDateCreate()+"', "
                +contact.getFDateModify()+" = '"+item.getDateModify()+"', "
                +contact.getFDescription()+" = '"+item.getDescription()+"', "
                +contact.getFRemark()+" = '"+item.getRemark()+"', "
                +contact.getFSort1()+" = '"+item.getSort1()+"', "
                +contact.getFTaxId()+" = '"+item.getTaxId()+"', "
                +contact.getFTelephone()+" = '"+item.getTelephone()+"', "
                +contact.getFUserCancel()+" = '"+item.getUserCancel()+"', "
                +contact.getFUserCreate()+" = '"+item.getUserCreate()+"', "
                +contact.getFUserModify()+" = '"+item.getUserModify()+"', "+
                contact.getFFax()+" = '"+item.getFax()+"', "+
                contact.getFBranchId()+" = '"+item.getBranchId()+"', "+
                contact.getFPostCode()+" = '"+item.getPostCode()+"', "+
                contact.getFContactJoinId()+" = '"+item.getContactJoinId()+"', "
                +contact.getFStatusContact()+" = '"+item.getStatusContact()+"', "
                +contact.getFEmail()+" = '"+item.getEmail()+"', "
                +contact.getFEmployment()+" = '"+item.getEmployment()+"', "
                +contact.getFContractFilename1()+" = '"+item.getContractFilename1()+"', "
                +contact.getFContractFilename2()+" = '"+item.getContractFilename2()+"', "
//                +contact.getFContactNumber()+" = '"+item.getContactNumber()+"', "
                +contact.getFContractFilename3()+" = '"+item.getContractFilename3()+"', "
                +contact.getFStatusMessage()+" = '"+item.getStatusMessage()+"', "
                +contact.getFMessageContact()+" = '"+item.getMessageContact()+"' "
                +"Where "+contact.getFContactNumber()+" = '"+contact.getContactNumber()
                        +"' and " + contact.getFContactNamet() +"='"+contact.getContactNamet()+"'";
                max = item.getContactId();
            }
            System.err.println(sql);
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public void setDeleteContactAll(){
        Connection conn;
        Statement st;
        String sql="";
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql="Delete From b_contact ";
//            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String setUpdateContactVoid(String contactId){
        Connection conn;
        Statement st;
        String sql="";
        Integer i =0;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql="Update "+contact.getBContact()+" Set "+contact.getFContactActive()+"='3' "
                    + "Where "+contact.getFContactId()+"='"+contactId+"'";
            i = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i.toString();
    }
    public void importContact(String branch_id){
        int chk=0;
        String sql="", ma_date="", attend_date="", max="", contact_id_old="", contact_namet="", contact_address="", contact_tambon="";
        String contact_amphur="", contact_changwat="", telephone="", contact_type_id="";
        BContact contact = new BContact();
        Connection conn_mainhis;
        Statement st_mainhis;
        try{
            conn_mainhis = config1.getConnectionMainHIS(branch_id);

            setDeleteContactAll();

            st_mainhis = conn_mainhis.createStatement();
            sql = "Select mnc_com_cd, mnc_com_dsc, mnc_com_add, mnc_com_tum_cd, mnc_com_amp_cd, mnc_com_chw_cd, mnc_com_tel, mnc_com_prf_cd "
                +"From patient_m24 "
                +"Order By mnc_com_cd";
            ResultSet rs;
            rs = st_mainhis.executeQuery(sql);
            while(rs.next()){
                contact_id_old = config1.StringNull(rs.getString("mnc_com_cd"));
                contact_namet = config1.StringNull(rs.getString("mnc_com_dsc"));
                contact_address = config1.StringNull(rs.getString("mnc_com_add"));
                contact_tambon = config1.StringNull(rs.getString("mnc_com_tum_cd"));
                contact_amphur = config1.StringNull(rs.getString("mnc_com_amp_cd"));
                contact_changwat = config1.StringNull(rs.getString("mnc_com_chw_cd"));
                telephone = config1.StringNull(rs.getString("mnc_com_tel"));
                contact_type_id = config1.StringNull(rs.getString("mnc_com_prf_cd"));

                contact_namet = contact_namet.replace("'", "''");
                contact_address = contact_address.replace("'", "''");

                contact.setContactActive("1");
                contact.setContactNumber(contact_id_old);
                contact.setContactAmphur(contact_amphur);
                contact.setContactChangwat(contact_changwat);
                contact.setContactNamet(contact_namet);
                contact.setContactHouse(contact_address);
                contact.setTelephone(telephone);
                contact.setRemark(contact_type_id);
                contact.setBranchId(branch_id);

                setSaveBContact(branch_id,contact,"");

            }
            rs.close();
            conn_mainhis.close();
        }
        catch(Exception ex){
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getComboContact(String branch_id, String where, String flagpage,String selected) throws Exception{
        String sql="", txt="", select="";
        Vector v_contact = new Vector();
        v_contact = getBContact(branch_id,where,flagpage);
        BContact contact = new BContact();
        for(int i=0;i<=v_contact.size()-1;i++){
            contact = (BContact)v_contact.get(i);
            if(contact.getContactId().equals(selected)){
                txt += "<option value='"+contact.getContactId()+"' selected>"+contact.getContactNamet()+"</option>";
            }
            else{
                txt += "<option value='"+contact.getContactId()+"' >"+contact.getContactNamet()+"</option>";
            }
        }
        return txt;
    }
    public void setUpdateContactContractFilename1(String branchId, String contactId, String filename1){
        String sql="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql="Update "+contact.getBContact()+" Set "+contact.getFContractFilename1()+"='"+filename1+"' "
                    +" Where "+contact.getFContactId()+" ='"+contactId+"' and "+contact.getFBranchId()+"='"+branchId+"' ";
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdateContactContractFilename2(String branchId, String contactId, String filename2){
        String sql="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql="Update "+contact.getBContact()+" Set "+contact.getFContractFilename2()+"='"+filename2+"' "
                    +" Where "+contact.getFContactId()+" ='"+contactId+"' and "+contact.getFBranchId()+"='"+branchId+"' ";
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdateContactContractFilename3(String branchId, String contactId, String filename3){
        String sql="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql="Update "+contact.getBContact()+" Set "+contact.getFContractFilename3()+"='"+filename3+"' "
                    +" Where "+contact.getFContactId()+" ='"+contactId+"' and "+contact.getFBranchId()+"='"+branchId+"' ";
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String setSaveBContactOther(String branchId, String contactId,BContact item) throws Exception {
        String sql="";
        Connection conn;
        Statement st;
        Integer chk=0;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql="Update "+contact.getBContact()+" Set "+contact.getFRemark()+"='"+item.getRemark().replace("'", "''") +"', "
                +contact.getFContactJoinId()+" = '"+item.getContactJoinId()+"', "+contact.getFTaxId()+" = '"+item.getTaxId()+"', "
                +contact.getFTelephone()+" = '"+item.getTelephone()+"', "+contact.getFEmail()+" = '"+item.getEmail()+"', "
                +contact.getFFax()+" = '"+item.getFax()+"', "+contact.getFEmployment()+" = '"+item.getEmployment()+"' "
                +" Where "+contact.getFContactId()+" ='"+contactId+"' and "+contact.getFBranchId()+"='"+branchId+"' ";
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setSaveBContactAddress(String branchId, String contactId,BContact item) throws Exception {
        String sql="";
        Connection conn;
        Statement st;
        Integer chk=0;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql="Update "+contact.getBContact()+" Set "
                +contact.getFContactHouse()+"='"+item.getContactHouse().replace("'", "''") +"', "
                +contact.getFStatusMessage()+" = '"+item.getStatusMessage().replace("'", "''")+"', "
                +contact.getFContactMoo()+" = '"+item.getContactMoo().replace("'", "''")+"', "
                +contact.getFMessageContact()+" = '"+item.getMessageContact().replace("'", "''") +"', "
                +contact.getFContactRoad()+" = '"+item.getContactRoad().replace("'", "''")+"', "
                +contact.getFContactChangwat()+" = '"+item.getContactChangwat().replace("'", "''") +"', "
                +contact.getFContactAmphur()+" = '"+item.getContactAmphur().replace("'", "''")+"', "
                +contact.getFContactTambon()+" = '"+item.getContactTambon().replace("'", "''") +"', "
                +contact.getFPostCode()+" = '"+item.getPostCode().replace("'", "''")+"' "
                +" Where "+contact.getFContactId()+" ='"+contactId+"' and "+contact.getFBranchId()+"='"+branchId+"' ";
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setSaveBContactAddress(String branchId, String contactId,BContact item, String changwat, String amphur, String tambon) throws Exception {
        String sql="", changwatId="", amphurId="", tambonId="";
        Connection conn;
        Statement st;
        Integer chk=0;
        Vector v = new Vector();
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            v = addressdb.getAddress(changwat,"","", "1");
            address = new FAddress();
            if(!v.isEmpty()) address = (FAddress)v.get(0);
            item.setContactChangwat(address.getAddressChangwatId());
            
            v = addressdb.getAddress(changwat,amphur,"", "2");
            address = new FAddress();
            if(!v.isEmpty()) address = (FAddress)v.get(0);
            item.setContactAmphur(address.getAddressChangwatId());
            
            v = addressdb.getAddress(changwat,amphur,tambon, "3");
            address = new FAddress();
            if(!v.isEmpty()) address = (FAddress)v.get(0);
            item.setContactTambon(address.getAddressChangwatId());
            
            sql="Update "+contact.getBContact()+" Set "
                +contact.getFContactHouse()+"='"+item.contactHouse.replace("'", "''") +"', "
                +contact.getFStatusMessage()+" = '"+item.statusMessage.replace("'", "''")+"', "
                +contact.getFContactMoo()+" = '"+item.contactMoo.replace("'", "''")+"', "
                +contact.getFMessageContact()+" = '"+item.messageContact.replace("'", "''") +"', "
                +contact.getFContactRoad()+" = '"+item.contactRoad.replace("'", "''")+"', "
                +contact.getFContactChangwat()+" = '"+item.contactChangwat.replace("'", "''") +"', "
                +contact.getFContactAmphur()+" = '"+item.contactAmphur.replace("'", "''")+"', "
                +contact.getFContactTambon()+" = '"+item.contactTambon.replace("'", "''") +"', "
                +contact.getFPostCode()+" = '"+item.postCode.replace("'", "''")+"' "
                +" Where "+contact.getFContactId()+" ='"+contactId+"' and "+contact.getFBranchId()+"='"+branchId+"' ";
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setSaveBContactVisitContact(String branchId, String contactId,BContact item) throws Exception {
        String sql="";
        Connection conn;
        Statement st;
        Integer chk=0;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql="Update "+contact.getBContact()+" Set "+contact.getFContactHouse()+"='"+item.getContactHouse().replace("'", "''") +"', "
                +contact.getFStatusMessage()+" = '"+item.getStatusMessage().replace("'", "''")+"', "+contact.getFContactMoo()+" = '"+item.getContactMoo().replace("'", "''")+"', "
                +contact.getFMessageContact()+" = '"+item.getMessageContact().replace("'", "''") +"', "+contact.getFContactRoad()+" = '"+item.getContactRoad().replace("'", "''")+"', "
                +contact.getFContactChangwat()+" = '"+item.getContactChangwat().replace("'", "''") +"', "+contact.getFContactAmphur()+" = '"+item.getContactAmphur().replace("'", "''")+"', "
                +contact.getFContactTambon()+" = '"+item.getContactTambon().replace("'", "''") +"', "+contact.getFPostCode()+" = '"+item.getPostCode().replace("'", "''")+"' "
                +" Where "+contact.getFContactId()+" ='"+contactId+"' and "+contact.getFBranchId()+"='"+branchId+"' ";
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setSaveBContactContacter(String branchId, String contactId,BContact item) throws Exception {
        String sql="";
        Connection conn;
        Statement st;
        Integer chk=0;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql="Update "+contact.getBContact()+" Set "
                +contact.getFContactSaleNamet()+"='"+item.contactSaleNamet.replace("'", "''") +"', "
                +contact.getFContactSaleTelephone()+" = '"+item.contactSaleTelephone.replace("'", "''")+"', "
                +contact.getFContactSaleMobile()+" = '"+item.contactSaleMobile.replace("'", "''")+"' "
                +" Where "+contact.getFContactId()+" ='"+contactId+"' and "+contact.getFBranchId()+"='"+branchId+"' ";
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setSaveBContactMap(String branchId, String contactId,BContact item) throws Exception {
        String sql="";
        Connection conn;
        Statement st;
        Integer chk=0;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql="Update "+contact.getBContact()+" Set "+contact.getFContactHouse()+"='"+item.getContactHouse().replace("'", "''") +"', "
                +contact.getFStatusMessage()+" = '"+item.getStatusMessage().replace("'", "''")+"', "+contact.getFContactMoo()+" = '"+item.getContactMoo().replace("'", "''")+"', "
                +contact.getFMessageContact()+" = '"+item.getMessageContact().replace("'", "''") +"', "+contact.getFContactRoad()+" = '"+item.getContactRoad().replace("'", "''")+"', "
                +contact.getFContactChangwat()+" = '"+item.getContactChangwat().replace("'", "''") +"', "+contact.getFContactAmphur()+" = '"+item.getContactAmphur().replace("'", "''")+"', "
                +contact.getFContactTambon()+" = '"+item.getContactTambon().replace("'", "''") +"', "+contact.getFPostCode()+" = '"+item.getPostCode().replace("'", "''")+"' "
                +" Where "+contact.getFContactId()+" ='"+contactId+"' and "+contact.getFBranchId()+"='"+branchId+"' ";
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String getMax() throws Exception {
        String max = "";
        String sql = "select max(contact_number) from b_contact";
        Connection conn;
        conn = config1.getConnectionBangna();
        Statement stbangna = conn.createStatement();
        ResultSet rs = stbangna.executeQuery(sql);
        if(rs.next()) max = rs.getString("max");
        conn.close();
        return max;
    }
    public String getContactNumberMax(){
        String max = "";
        try {
            max = getMax();
            String tmp = max;
            char c = tmp.charAt(0);
            int i = Integer.parseInt(tmp.substring(1));
            i=i+1;
            String running = String.valueOf(i);
            if(i>9999){
                char x = tmp.charAt(0);
                int cast = (int)x;
                int codePoint = String.valueOf(x).codePointAt(0)+1;
                char again = (char)codePoint;
                System.err.println(again);
                c = again;
                running = "0001";
            }
            for(int i2 = running.length();i2<4;i2++){
                running = "0"+running;
            }
            max = c + running;
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return max;
    }
    public String getTrContactSearch(String contactName){
        String text="";
        Vector v = new Vector();
        v = getBContact("", "", "search_all");
        for(int i=0;i<=v.size()-1;i++){
            contact = (BContact)v.get(i);
            text += contact.getContactNamet()+" ";
        }
        text = "<input type='hidden' id='txtSContact' value='"+text+"'>";
        return text;
    }
    public Vector getContactRoad(String branchId, String road) {
        Connection conn;
//        BContact contact = new BContact();
        Vector v_contact = new Vector();
        String sql="", searchRoad="";
        try {
            if(!road.equals("")) searchRoad = " and "+contact.getFContactRoad()+" like '"+road+"%' ";
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
                sql="Select Distinct contact."+contact.getFContactRoad()+" "+
            "From "+contact.getBContact()+" as contact " +
            "Where "+contact.getFContactActive()+"='1' "+searchRoad +
            "Order By "+contact.getFContactRoad()+" asc";

            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
//                if(rs.getString(contact.getFContactNamet()).length()>0){
                    contact = new BContact();
                    contact.setContactRoad(config1.StringNull(rs.getString(contact.getFContactRoad()).trim()));
                    v_contact.add(contact);
//                }
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_contact;
    }
    public List getContactRoadL(String branchId, String road) {
        Connection conn;
//        BContact contact = new BContact();
        List lContact = new ArrayList<BContact>();
        String sql="", searchRoad="";
        try {
            if(!road.equals("")) searchRoad = " and "+contact.getFContactRoad()+" like '"+road+"%' ";
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
                sql="Select Distinct contact."+contact.getFContactRoad()+" "+
            "From "+contact.getBContact()+" as contact " +
            "Where "+contact.getFContactActive()+"='1' "+searchRoad +
            "Order By "+contact.getFContactRoad()+" asc";

            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
//                if(rs.getString(contact.getFContactNamet()).length()>0){
                    contact = new BContact();
                    contact.setContactRoad(config1.StringNull(rs.getString(contact.getFContactRoad()).trim()));
                    lContact.add(contact);
//                }
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lContact;
    }
    public String setSaveContactUpdateGoogleMap(String branchId, String contactId, String googleMapLat, String googleMapLon, String googleMapZoom){
        Integer chk=0;
        String sql = "Update "+contact.getBContact()
                + " Set "+contact.getFGoogleMapLat()+"='"+googleMapLat+"', "
                + contact.getFGoogleMapLon()+"='"+googleMapLon+"', "
                + contact.getFGoogleMapZoom()+"='"+googleMapZoom+"' "
                + "Where "+contact.getFContactId()+"='"+contactId+"' ";
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            chk = stbangna.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BContactDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
}
