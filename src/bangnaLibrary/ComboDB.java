package bangnaLibrary;

import com.bangna.objdb.BDepartmentDB;
import com.bangna.objdb.MarketingTCheckupPatientDB;
import com.bangna.object.BDepartment;
import com.bangna.object.MarketingReport;
import com.bangna.object.MarketingTCheckupPatient;
import java.sql.*;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class ComboDB {
    public Config1 config1;
    private Doctor doctor ;
    private BBranch branch ;
    private CashierTCloseDay closeday;
    private BContact contact ;
    private BPeriod period ;
    private BItem b_item ;
    private BackBDepartment back_department ;
    private FItemGroup f_item_group ;
    private BIcd10 icd10 ;
    private BIcd10GroupType icd10_grouptype ;
    private BackBTransfer b_transfer ;
    private FVisitType f_visit_type;
    private BContractPayer contract_payer;
    private FDay f_day = new FDay();
    private DoctorBFormula pay_formula;
    private BContractPlans bcp;
    private ChiBBillgroup cbg ;
    private ChiFBillgroup cfbg ;
    private ChiBSurcharge cbs ;
    private BPrintDoc pdoc ;
    private BVisitClinic bVisitClinic ;
    private DoctorBTypeDoctor typeDoctor ;
    private DoctorBSpecialist specialist ;
    private MarketingReportDB mReportdb ;
    private MarketingReport mReport ;
    private MarketingTCheckupPatient mktcp ;
    private MarketingTCheckupPatientDB mktcpdb ;
    private Fstatus fstatus = new Fstatus();
    private FSex fSex = new FSex();
    private BDepartmentDB departdb;
    private BDepartment depart;

    public ComboDB(Config1 cf){
        config1 = cf;
        initConfig(config1);
    }
    public ComboDB(){
        config1 = new Config1();
        initConfig(config1);
    }
    public void initConfig(Config1 cf){
        depart = new BDepartment();
        if(config1.branch != null) branch = config1.branch;
        else branch = new bangnaLibrary.BBranch();
        departdb = new BDepartmentDB(cf);
        mktcpdb = new MarketingTCheckupPatientDB();
        mktcp = new MarketingTCheckupPatient();
        mReport = new MarketingReport();
        mReportdb = new MarketingReportDB();
        specialist = new DoctorBSpecialist();
        typeDoctor = new DoctorBTypeDoctor();
        bVisitClinic = new BVisitClinic();
        cbs = new ChiBSurcharge();
        pdoc = new BPrintDoc();
        cfbg = new ChiFBillgroup();
        cbg = new ChiBBillgroup();
        bcp = new BContractPlans();
        pay_formula = new DoctorBFormula();
        f_day = new FDay();
        contract_payer = new BContractPayer();
        f_visit_type = new FVisitType();
        b_transfer = new BackBTransfer();
        icd10_grouptype = new BIcd10GroupType();
        icd10 = new BIcd10();
        f_item_group = new FItemGroup();
        back_department = new BackBDepartment();
        b_item = new BItem();
        period = new BPeriod();
        contact = new BContact();
        closeday = new CashierTCloseDay();
        doctor = new Doctor();
    }
    public String CboFSex(String branch_id, String selected){
        String txt="",sql="";
        Vector v_sex = new Vector();
        FSex sex = new FSex();
        v_sex = getFSex(branch_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_sex.size()-1;i++) {
            sex = (FSex) v_sex.get(i);
            if(sex.getFSexId().equals(selected)){
                txt += "<option value='"+sex.getFSexId()+"' selected>"+sex.getSexDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+sex.getFSexId()+"' >"+sex.getSexDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getFSex(String branch_id){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        FSex sex = new FSex();
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select "+sex.getFFSexId()+", "+sex.getFSexDescription()+" "
                    +"From "+sex.getFSex();
            rs = st.executeQuery(sql);
            while(rs.next()){
                sex = new FSex();
                sex.setFSexId(rs.getString(sex.getFFSexId()));
                sex.setSexDescription(rs.getString(sex.getFSexDescription()));
                v_result.add(sex);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public Vector getFoodsPeriod(String branch_id){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        FoodsPeriod foodsperiod = new FoodsPeriod();
        try {
            conn = config1.getConnectionBangna();
//            conn = getConnectionBangna();
            st = conn.createStatement();
            sql = "Select foods_period_id, foods_period_namet "
                    +"From b_foods_period "
                    +"Where foods_period_active = '1'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                foodsperiod = new FoodsPeriod();
                foodsperiod.setFoodsPeriodId(rs.getString("foods_period_id"));
                foodsperiod.setFoodsPeriodNamet(rs.getString("foods_period_namet"));
                v_result.add(foodsperiod);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String CboFoodsPeriod(String branch_id, String selected){
        String txt="",sql="";
        Vector v_foodsperiod = new Vector();
        FoodsPeriod foodsperiod = new FoodsPeriod();
        v_foodsperiod = getFoodsPeriod(branch_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_foodsperiod.size()-1;i++) {
            foodsperiod = (FoodsPeriod) v_foodsperiod.get(i);
            if(foodsperiod.getFoodsPeriodId().equals(selected)){
                txt += "<option value='"+foodsperiod.getFoodsPeriodId()+"' selected>"+foodsperiod.getFoodsPeriodNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+foodsperiod.getFoodsPeriodId()+"' >"+foodsperiod.getFoodsPeriodNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public String CboFPatientNation(String branch_id, String selected){
        String txt="",sql="";
        Vector v_nation = new Vector();
        FPatientNation nation = new FPatientNation();
        v_nation = getFPatientNation(branch_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_nation.size()-1;i++) {
            nation = (FPatientNation) v_nation.get(i);
            if(nation.getFPatientNationId().equals(selected)){
                txt += "<option value='"+nation.getFPatientNationId()+"' selected>"+nation.getPatientNationDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+nation.getFPatientNationId()+"' >"+nation.getPatientNationDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getFPatientNation(String branch_id){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        FPatientNation nation = new FPatientNation();
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select "+nation.getFFPatientNationId()+", "+nation.getFPatientNationDescription()+" "
                    +"From "+nation.getFPatientNation();
            rs = st.executeQuery(sql);
            while(rs.next()){
                nation = new FPatientNation();
                nation.setFPatientNationId(rs.getString(nation.getFFPatientNationId()));
                nation.setPatientNationDescription(rs.getString(nation.getFPatientNationDescription()));
                v_result.add(nation);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String CboFPatientMarriageStatus(String branch_id, String selected){
        String txt="",sql="";
        Vector v_marriage = new Vector();
        FPatientMarriageStatus marriage = new FPatientMarriageStatus();
        v_marriage = getFPatientMarriageStatus(branch_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_marriage.size()-1;i++) {
            marriage = (FPatientMarriageStatus) v_marriage.get(i);
            if(marriage.getFPatientMarriageStatusId().equals(selected)){
                txt += "<option value='"+marriage.getFPatientMarriageStatusId()+"' selected>"+marriage.getPatientMarriageStatusDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+marriage.getFPatientMarriageStatusId()+"' >"+marriage.getPatientMarriageStatusDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getFPatientMarriageStatus(String branch_id){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        FPatientMarriageStatus marriage = new FPatientMarriageStatus();
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select "+marriage.getFFPatientMarriageStatusId()+", "+marriage.getFPatientMarriageStatusDescription()+" "
                    +"From "+marriage.getFPatientMarriageStatus();
            rs = st.executeQuery(sql);
            while(rs.next()){
                marriage = new FPatientMarriageStatus();
                marriage.setFPatientMarriageStatusId(rs.getString(marriage.getFFPatientMarriageStatusId()));
                marriage.setPatientMarriageStatusDescription(rs.getString(marriage.getFPatientMarriageStatusDescription()));
                v_result.add(marriage);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String CboFPatienBloodGroup(String branch_id, String selected) {
        String txt="",sql="";
        Vector v_bloodgroup = new Vector();
        FPatientBloodGroup bloodgroup = new FPatientBloodGroup();
        v_bloodgroup = getFPatienBloodGroup(branch_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_bloodgroup.size()-1;i++) {
            bloodgroup = (FPatientBloodGroup) v_bloodgroup.get(i);
            if(bloodgroup.getFPatientBloodGroupId().equals(selected)){
                txt += "<option value='"+bloodgroup.getFPatientBloodGroupId()+"' selected>"+bloodgroup.getPatientBloodGroupDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            } else{
                txt += "<option value='"+bloodgroup.getFPatientBloodGroupId()+"' >"+bloodgroup.getPatientBloodGroupDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getFPatienBloodGroup(String branch_id){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        FPatientBloodGroup bloodgroup = new FPatientBloodGroup();
        try {
            conn = config1.getConnectionHospital(branch_id);
            st = conn.createStatement();
            sql = "Select "+bloodgroup.getFFPatientBloodGroupId()+", "+bloodgroup.getFPatientBloodGroupDescription()+" "
                    +"From "+bloodgroup.getFPatientBloodGroup();
            rs = st.executeQuery(sql);
            while(rs.next()){
                bloodgroup = new FPatientBloodGroup();
                bloodgroup.setFPatientBloodGroupId(rs.getString(bloodgroup.getFFPatientBloodGroupId()));
                bloodgroup.setPatientBloodGroupDescription(rs.getString(bloodgroup.getFPatientBloodGroupDescription()));
                v_result.add(bloodgroup);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String CboFAddress(String branch_id, String flag, String selected){
        String txt="",sql="";
        Vector v_address = new Vector();
        FAddress address = new FAddress();
        v_address = config1.getFAddress(branch_id,flag);
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
    public Vector getCloseDayImport(String branch_id, String flag) {
        Vector v_closeday_import = new Vector();

        String sql="";
        sql = "Select distinct "+ closeday.getFCloseDayDate() +" "+
                "From "+closeday.getCashierTCloseDay()+" "+
                "Where "+closeday.getFStatusImport()+"='0' "+
                "Order By "+closeday.getFCloseDayDate();
        Connection conn = null;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                closeday = new CashierTCloseDay();
//                closeday.setCloseDayId(rs.getString(closeday.getFCloseDayId()));
                closeday.setCloseDayDate(rs.getString(closeday.getFCloseDayDate()));
                v_closeday_import.add(closeday);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_closeday_import;
    }
    public String getComboCloseDayImport(String branch_id, String selected){
        Vector v_closeday_import = new Vector();
        CashierTCloseDay closeday = new CashierTCloseDay();
        String txt="", date="";
        v_closeday_import = getCloseDayImport(branch_id, selected);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_closeday_import.size()-1;i++){
            closeday = (CashierTCloseDay)v_closeday_import.get(i);
            try {
                date = config1.DateFormatDB2Show(closeday.getCloseDayDate(), "ddMMyyyy");
                if(date.equals(selected)){
                    txt += "<option value='"+date+"' selected>"+date+"</option>";
                    //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
                } else{
                    txt += "<option value='"+date+"' >"+date+"</option>";
                    //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
                }
            } catch (Exception ex) {
                Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     return txt;
    }
    public String getComboBServicePoint(String branch_id, String selected)throws Exception{
        String txt="", sql="";
        BServicePoint b_service_point = new BServicePoint();
        Vector v_b_service_point = new Vector();
        v_b_service_point = config1.getBServicePoint(branch_id);
        txt="<option value='' selected></option>";
        try {
            for(int i=0;i<=v_b_service_point.size()-1;i++){
                b_service_point = (BServicePoint)v_b_service_point.get(i);
                if(b_service_point.getBServicePointId().equals(selected)){
                    txt += "<option value='"+b_service_point.getBServicePointId()+"' selected>"+b_service_point.getServicePointDescription()+"</option>";
                }else{
                    txt += "<option value='"+b_service_point.getBServicePointId()+"' >"+b_service_point.getServicePointDescription()+"</option>";
                }
            }

        } catch (Exception ex) {
            txt = ex.getMessage();
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return txt;
    }
    public String CboTime() {
        String txt="";
        for(Integer i=0;i<=2359;i++) {
            txt += "<option value='"+i.toString()+"' >"+i.toString()+"</option>";
        }
        return txt;
    }
    public String getComboStringency() {
        String txt="";
        txt += "<option value='1' >ปกติ ตามคิว</option>";
        txt += "<option value='2' >ด่วน</option>";
        txt += "<option value='3' >ด่วนมาก</option>";
        txt += "<option value='4' >ด่วนที่สุด</option>";
        txt += "<option value='5' >ทันที</option>";
        return txt;
    }
    public String getComboPeriod(String selected){
        String txt="", select="";
        if(selected.equals("1")){
            select="selected";
        }
        txt += "<option value='1' "+select+">งวดต้นเดือน</option>";
        select="";
        if(selected.equals("2")){
            select="selected";
        }
        txt += "<option value='2' "+select+">งวดกลางเดือน</option>";
        select="";
        return txt;
    }
    public String getComboMonth(String selected){
        String aa="", select="";
        if(selected.equals("01")){
            select="selected";
        }
        aa += "<option value='01' "+select+">มกราคม</option>";
        select="";
        if(selected.equals("02")){
            select="selected";
        }
        aa += "<option value='02' "+select+">กุมภาพันธ์</option>";
        select="";
        if(selected.equals("03")){
            select="selected";
        }
        aa += "<option value='03' "+select+">มีนาคม</option>";
        select="";
        if(selected.equals("04")){
            select="selected";
        }
        aa += "<option value='04' "+select+">เมษายน</option>";
        select="";
        if(selected.equals("05")){
            select="selected";
        }
        aa += "<option value='05' "+select+">พฤษภาคม</option>";
        select="";
        if(selected.equals("06")){
            select="selected";
        }
        aa += "<option value='06' "+select+">มิถุนายน</option>";
        select="";
        if(selected.equals("07")){
            select="selected";
        }
        aa += "<option value='07' "+select+">กรกฏาคม</option>";
        select="";
        if(selected.equals("08")){
            select="selected";
        }
        aa += "<option value='08' "+select+">สิงหาคม</option>";
        select="";
        if(selected.equals("09")){
            select="selected";
        }
        aa += "<option value='09' "+select+">กันยายน</option>";
        select="";
        if(selected.equals("10")){
            select="selected";
        }
        aa += "<option value='10' "+select+">ตุลาคม</option>";
        select="";
        if(selected.equals("11")){
            select="selected";
        }
        aa += "<option value='11' "+select+">พฤศจิกายน</option>";
        select="";
        if(selected.equals("12")){
            select="selected";
        }
        aa += "<option value='12' "+select+">ธันวาคม</option>";
        return aa;
    }
    public String getComboYear(String selected) {
        String aa="", select="";
        Integer year = Integer.parseInt(config1.getDateDB("yyyy"));

        for(Integer i=year;i>=year-4;i--) {
            select="";
            if(selected.equals(i.toString())) {
                select="selected";
            }
            aa += "<option value='"+i.toString()+"' "+select+">"+i.toString()+"</option>";
        }
        return aa;
    }
    public String getComboYearHospital(String selected) {
        String aa="", select="";
        Integer year = Integer.parseInt(config1.getDateDB("yyyy"))+543;

        for(Integer i=year;i>=year-4;i--) {
            select="";
            if(selected.equals(i.toString())) {
                select="selected";
            }
            aa += "<option value='"+i.toString()+"' "+select+">"+i.toString()+"</option>";
        }
        return aa;
    }
    public String getComboBranch(String selected) throws Exception {
        String sql="", txt="", select="";
        Vector v_branch = new Vector();
        v_branch = config1.getBranch();
//        BBranch branch = new BBranch();
        for(int i=0;i<=v_branch.size()-1;i++){
            branch = (BBranch)v_branch.get(i);
            if(branch.getBranchId().equals(selected)){
                txt += "<option value='"+branch.getBranchId()+"' selected>"+branch.getBranchNamet()+"</option>";
            } else{
                if(branch.getBranchActive().equals("1") && selected.equals("")){
                    txt += "<option value='"+branch.getBranchId()+"' selected>"+branch.getBranchNamet()+"</option>";
                } else{
                    txt += "<option value='"+branch.getBranchId()+"' >"+branch.getBranchNamet()+"</option>";
                }
            }
        }
        return txt;
    }
    public String CboLab(String branch_id, String selected){
        String txt="",sql="";
        Vector v_lab = new Vector();
        Lab lab = new Lab();
        v_lab = getLab(branch_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_lab.size()-1;i++) {
            lab = (Lab) v_lab.get(i);
            if(lab.getLabId().equals(selected)) {
                txt += "<option value='"+lab.getLabId()+"' selected>"+lab.getLabNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else {
                txt += "<option value='"+lab.getLabId()+"' >"+lab.getLabNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4) {
                sql="";
            }
        }
        return txt;
    }
    public Vector getLab(String branch_id){
        Vector v_claim = new Vector();
        String time="";
        String sql="Select * "
            +"From lab_m01 lb02 "
            +"Order By mnc_lb_dsc ";
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        Lab lab = new Lab();
        try {
            connmainhis = config1.getConnectionMainHIS(branch_id);
            stmainhis = connmainhis.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                lab = new Lab();
                lab.setLabId(rsmainhis.getString("mnc_lb_cd"));
                lab.setLabNamet(rsmainhis.getString("mnc_lb_dsc"));
                v_claim.add(lab);
            }
            rsmainhis.close();

            connmainhis.close();
        }
        catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_claim;
    }
    public Vector getClaimNamet(String branch_id){
        Vector v_claim = new Vector();
        String time="";
        String sql="";
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        Claim claim = new Claim();
        try {
//            if(branch_id.equals(branch.getBranchId())) 
//                branch = config1.getBranch(branch_id);
            if(config1.branch.getBranchProgram().equals("hospital_osv3")){
                sql="Select bcp.contract_plans_number as mnc_fn_typ_cd, bcp.contract_plans_description as mnc_fn_typ_dsc "
                +"From b_contract_plans bcp Where contract_plans_active = '1' ";
                connmainhis = config1.getConnectionHospital(branch_id);
                stmainhis = connmainhis.createStatement();
            }else{
                sql="Select * "
                +"From finance_m02 fm02 ";
                connmainhis = config1.getConnectionMainHIS(branch_id);
                stmainhis = connmainhis.createStatement();
            }

            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                claim = new Claim();
                claim.setClaimId(rsmainhis.getString("mnc_fn_typ_cd"));
                claim.setClaimNamet(rsmainhis.getString("mnc_fn_typ_dsc"));
                v_claim.add(claim);
            }
            rsmainhis.close();
            connmainhis.close();
        }catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_claim;
    }
    public Vector getClaimNametId(String branch_id){
        Vector v_claim = new Vector();
        String time="";
        String sql="";
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        Claim claim = new Claim();
        try {
            branch = config1.getBranch(branch_id);
            if(branch.getBranchProgram().equals("hospital_osv3")){
                sql="Select bcp.b_contract_plans_id as mnc_fn_typ_cd, bcp.contract_plans_description as mnc_fn_typ_dsc "
                +"From b_contract_plans bcp Where contract_plans_active = '1' ";
                connmainhis = config1.getConnectionHospital(branch_id);
                stmainhis = connmainhis.createStatement();
            }else{
                sql="Select * "
                +"From finance_m02 fm02 ";
                connmainhis = config1.getConnectionMainHIS(branch_id);
                stmainhis = connmainhis.createStatement();
            }

            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                claim = new Claim();
                claim.setClaimId(rsmainhis.getString("mnc_fn_typ_cd"));
                claim.setClaimNamet(rsmainhis.getString("mnc_fn_typ_dsc"));
                v_claim.add(claim);
            }
            rsmainhis.close();
            connmainhis.close();
        }catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_claim;
    }
    public String CboClaimNamet(String branch_id, String selected){
        String txt="",sql="", txt1="";
        Vector v_claim = new Vector();
        Claim claim = new Claim();
        v_claim = getClaimNamet(branch_id);
        txt1="<option value='' selected></option>";
        for(int i=0;i<=v_claim.size()-1;i++) {
            claim = (Claim) v_claim.get(i);
            if(claim.getClaimId().equals(selected)){
                txt += "<option value='"+claim.getClaimId()+"' selected>"+claim.getClaimNamet()+"</option>";
                txt1="";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+claim.getClaimId()+"' >"+claim.getClaimNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt1+txt;
    }
    public String CboClaimNametId(String branch_id, String selected){
        String txt="",sql="", txt1="";
        Vector v_claim = new Vector();
        Claim claim = new Claim();
        v_claim = getClaimNametId(branch_id);
        txt1="<option value='' selected></option>";
        for(int i=0;i<=v_claim.size()-1;i++) {
            claim = (Claim) v_claim.get(i);
            if(claim.getClaimId().equals(selected)){
                txt += "<option value='"+claim.getClaimId()+"' selected>"+claim.getClaimNamet()+"</option>";
                txt1="";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+claim.getClaimId()+"' >"+claim.getClaimNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt1+txt;
    }
    public String CboReligionNamet(String selected) {
        String txt="",sql="";
        Vector v_religion = new Vector();
        BReligion religion = new BReligion();
        v_religion = getReligionNamet();
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_religion.size()-1;i++) {
            religion = (BReligion) v_religion.get(i);
            if(religion.getReligionId().equals(selected)){
                txt += "<option value='"+religion.getReligionId()+"' selected>"+religion.getReligionNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+religion.getReligionId()+"' >"+religion.getReligionNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getReligionNamet(){
        Vector v_religion = new Vector();
        String time="";
        String sql="Select * "
            +"From b_religion ";
        Connection connbangna;
        Statement stmainhis;
        ResultSet rsmainhis;
        BReligion religion = new BReligion();
        try {
            connbangna = config1.getConnectionBangna();
            stmainhis = connbangna.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                religion = new BReligion();
                religion.setReligionId(rsmainhis.getString(religion.getFReligionId()));
                religion.setReligionNamet(rsmainhis.getString(religion.getFReligionNamet()));
                v_religion.add(religion);
            }
            rsmainhis.close();
            connbangna.close();
        }
        catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_religion;
    }
    public Vector getTypeFoods(String branch_id){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        TypeFoods typefoods = new TypeFoods();
        BItem b_item = new BItem();
        try {
//            conn = getConnectionMainHIS(branch_id);
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select * From "+b_item.getBItem()+
                    " Where "+b_item.getFItemActive()+"='1' "+
                    "Order By "+b_item.getFItemNamet();
            rs = st.executeQuery(sql);
            while(rs.next()){
                typefoods = new TypeFoods();
                typefoods.setTypeFoodsId(rs.getString(b_item.getFBItemId()));
                typefoods.setTypeFoodsNamet(rs.getString(b_item.getFItemNamet()));
                typefoods.setFoodsPrice(rs.getString(b_item.getFItemPriceCost()));
                v_result.add(typefoods);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String CboTypeFoods(String branch_id, String selected){
        String txt="",sql="";
        Vector v_typefoods = new Vector();
        TypeFoods typefoods = new TypeFoods();
        v_typefoods = getTypeFoods(branch_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_typefoods.size()-1;i++) {
            typefoods = (TypeFoods) v_typefoods.get(i);
            if(typefoods.getTypeFoodsId().equals(selected)) {
                txt += "<option value='"+typefoods.getTypeFoodsId()+"' selected>"+typefoods.getTypeFoodsNamet()+"["+typefoods.getFoodsPrice()+"]"+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else {
                txt += "<option value='"+typefoods.getTypeFoodsId()+"' >"+typefoods.getTypeFoodsNamet()+"["+typefoods.getFoodsPrice()+"]"+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4) {
                sql="";
            }
        }
        return txt;
    }
    public String CboFPatientPrefix(String branch_id, String selected){
        String txt="",sql="";
        Vector v_prefix = new Vector();
        FPatientPrefix prefix = new FPatientPrefix();
        v_prefix = getFPatientPrefix(branch_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_prefix.size()-1;i++) {
            prefix = (FPatientPrefix) v_prefix.get(i);
            if(prefix.getFPatientPrefixId().equals(selected)){
                txt += "<option value='"+prefix.getFPatientPrefixId()+"' selected>"+prefix.getPatientPrefixDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+prefix.getFPatientPrefixId()+"' >"+prefix.getPatientPrefixDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getFPatientPrefix(String branch_id){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        FPatientPrefix prefix = new FPatientPrefix();
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select "+prefix.getFFPatientPrefixId()+", "+prefix.getFPatientPrefixDescription()+", "+prefix.getFPatientPrefixDescriptione()+" "
                    +"From "+prefix.getFPatientPrefix()+" "
                    +"Where "+prefix.getFActive()+" = '1' and "+prefix.getFFTlockId()+" = '1'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                prefix = new FPatientPrefix();
                prefix.setFPatientPrefixId(rs.getString(prefix.getFFPatientPrefixId()));
                prefix.setPatientPrefixDescription(rs.getString(prefix.getFPatientPrefixDescription()));
                prefix.setPatientPrefixDescriptione(rs.getString(prefix.getFPatientPrefixDescriptione()));
                v_result.add(prefix);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public Vector getEmployee(String branch_id){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        Employee employee = new Employee();
        try {
            branch = config1.getBranch(branch_id);
            if(branch.getBranchProgram().equals("hospital_osv3")) {
                conn = config1.getConnectionHospital(branch_id);
                sql="Select b_employee.employee_login as mnc_hr_no, b_employee.employee_firstname || ' ' || b_employee.employee_lastname as fullname " +
                "From b_employee " +
                "Order By b_employee.employee_firstname ";
            }else{
                conn = config1.getConnectionMainHIS(branch_id);
                sql = "Select mnc_hr_no, mnc_hr_fname_t + ' ' + mnc_hr_lname_t as fullname "
                    +"From human_m01 "
                    +"Order by mnc_hr_fname_t, mnc_hr_lname_t ";
            }
//            conn = getConnectionBangna();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                employee = new Employee();
                employee.setEmployeeId(rs.getString("mnc_hr_no"));
                employee.setEmployeeNamet(rs.getString("fullname"));
                v_result.add(employee);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public Vector getEmployee(String branch_id, String flag){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        Employee employee = new Employee();
        try {
            branch = config1.getBranch(branch_id);
            if(branch.getBranchProgram().equals("hospital_osv3")) {
                conn = config1.getConnectionHospital(branch_id);
                if(flag.equals("funds")){
                    sql="Select b_employee.employee_login as mnc_hr_no, b_employee.employee_firstname || ' ' || b_employee.employee_lastname as fullname " +
                "From b_employee "
                            + "Where status_funds = '1' " +
                "Order By b_employee.employee_firstname ";
                }else if(flag.equals("contact")){
                    sql="Select b_employee.employee_login as mnc_hr_no, b_employee.employee_firstname || ' ' || b_employee.employee_lastname as fullname " +
                "From b_employee "
                            + "Where status_contact = '1' " +
                "Order By b_employee.employee_firstname ";
                }else{
                    sql="Select b_employee.employee_login as mnc_hr_no, b_employee.employee_firstname || ' ' || b_employee.employee_lastname as fullname " +
                "From b_employee " +
                "Order By b_employee.employee_firstname ";
                }
                
            }else{
                conn = config1.getConnectionMainHIS(branch_id);
                sql = "Select mnc_hr_no, mnc_hr_fname_t + ' ' + mnc_hr_lname_t as fullname "
                    +"From human_m01 "
                    +"Order by mnc_hr_fname_t, mnc_hr_lname_t ";
            }
//            conn = getConnectionBangna();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                employee = new Employee();
                employee.setEmployeeId(rs.getString("mnc_hr_no"));
                employee.setEmployeeNamet(rs.getString("fullname"));
                v_result.add(employee);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String CboEmployee(String branch_id, String selected){
        String txt="",sql="";
        Vector v_employee = new Vector();
        Employee employee = new Employee();
        v_employee = getEmployee(branch_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_employee.size()-1;i++) {
            employee = (Employee) v_employee.get(i);
            if(employee.getEmployeeId().equals(selected)){
                txt += "<option value='"+employee.getEmployeeId()+"' selected>"+employee.getEmployeeNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+employee.getEmployeeId()+"' >"+employee.getEmployeeNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public String CboEmployeeContact(String branch_id, String selected){
        String txt="",sql="";
        Vector v_employee = new Vector();
        Employee employee = new Employee();
        v_employee = getEmployee(branch_id, "contact");
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_employee.size()-1;i++) {
            employee = (Employee) v_employee.get(i);
            if(employee.getEmployeeId().equals(selected)){
                txt += "<option value='"+employee.getEmployeeId()+"' selected>"+employee.getEmployeeNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+employee.getEmployeeId()+"' >"+employee.getEmployeeNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public String CboEmployeeFunds(String branch_id, String selected){
        String txt="",sql="";
        Vector v_employee = new Vector();
        Employee employee = new Employee();
        v_employee = getEmployee(branch_id,"funds");
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_employee.size()-1;i++) {
            employee = (Employee) v_employee.get(i);
            if(employee.getEmployeeId().equals(selected)){
                txt += "<option value='"+employee.getEmployeeId()+"' selected>"+employee.getEmployeeNamet()+"</option>";
            }else{
                txt += "<option value='"+employee.getEmployeeId()+"' >"+employee.getEmployeeNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getPharmacy(String branch_id){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        Item item = new Item();
        try {
            conn = config1.getConnectionMainHIS(branch_id);
//            conn = getConnectionBangna();
            st = conn.createStatement();
            sql = "Select mnc_ph_cd, mnc_ph_tn "
                    +"From pharmacy_m01 "
                    +"Where mnc_ph_sts = 'Y' "
                    +"Order by mnc_ph_tn ";
            rs = st.executeQuery(sql);
            while(rs.next()){
                item = new Item();
                item.setItemId(rs.getString("mnc_ph_cd"));
                item.setCommonName(rs.getString("mnc_ph_tn"));
                v_result.add(item);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String CboPharmacy(String branch_id, String selected){
        String txt="",sql="";
        Vector v_item = new Vector();
        Item item = new Item();
        v_item = getPharmacy(branch_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_item.size()-1;i++) {
            item = (Item) v_item.get(i);
            if(item.getItemId().equals(selected)){
                txt += "<option value='"+item.getItemId()+"' selected>"+item.getCommonName()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+item.getItemId()+"' >"+item.getCommonName()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getPeriod(String branch_id) {
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
//        Ward ward = new Ward();
        try {
            conn = config1.getConnectionBangna();
//            conn = getConnectionBangna();
            st = conn.createStatement();
//            sql = "Select department_id as no, department_namet as name "
//                    +"From b_department ";
            sql = "Select "+period.getFBPeriodId()+", "+period.getFBPeriodNamet()+" "
                    +"From "+period.getBPeriod()+" "
                    +"Where "+period.getFPeriodActive()+" = '1' and "+period.getFBranchId()+"='"+branch_id+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                period = new BPeriod();
                period.setPeriodId(rs.getString(period.getFBPeriodId()));
                period.setPeriodNamet(rs.getString(period.getFBPeriodNamet()));
                v_result.add(period);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getComboPeriod(String branch_id, String selected){
        String txt="",sql="";
        Vector v_period = new Vector();
//        Ward ward = new Ward();
        v_period = getPeriod(branch_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_period.size()-1;i++) {
            period = (BPeriod) v_period.get(i);
            if(period.getPeriodId().equals(selected)) {
                txt += "<option value='"+period.getPeriodId()+"' selected>"+period.getPeriodNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else {
                txt += "<option value='"+period.getPeriodId()+"' >"+period.getPeriodNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getContact(String branch_id, String search) {
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            if(branch_id.equals("")){
                if(search.equals("")){
                    sql = "Select "+contact.getFContactId()+", "+contact.getFContactNamet()+" "
                    +"From "+contact.getBContact()+" "
                    +"Where "+contact.getFContactActive()+" = '1' " +
                    "Order By "+contact.getFContactNamet();
                }else{
                    sql = "Select "+contact.getFContactId()+", "+contact.getFContactNamet()+" "
                    +"From "+contact.getBContact()+" "
                    +"Where "+contact.getFContactActive()+" = '1' and "+contact.getFContactNamet()+" like '"+search+"%'" +
                    "Order By "+contact.getFContactNamet();
                }
            }else{
                if(search.equals("")){
                    sql = "Select "+contact.getFContactId()+", "+contact.getFContactNamet()+" "
                    +"From "+contact.getBContact()+" "
                    +"Where "+contact.getFContactActive()+" = '1' and "+contact.getFBranchId()+"='"+branch_id+"'" +
                    "Order By "+contact.getFContactNamet();
                }else{
                    sql = "Select "+contact.getFContactId()+", "+contact.getFContactNamet()+" "
                    +"From "+contact.getBContact()+" "
                    +"Where "+contact.getFContactActive()+" = '1' and "+contact.getFBranchId()+"='"+branch_id+"' and "+contact.getFContactNamet()+" like '"+search+"%'" +
                    "Order By "+contact.getFContactNamet();
                }
            }

            rs = st.executeQuery(sql);
            while(rs.next()){
                contact = new BContact();
                contact.setContactId(rs.getString(contact.getFContactId()));
                contact.setContactNamet(rs.getString(contact.getFContactNamet()));
                v_result.add(contact);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public Vector getContactCheckUp(String branch_id, String yearId) {
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select mkcu.marketing_checkup_id as contact_id, mkcu.contact_namet || ' ' || mkcu.year_id || ' ' || mkcu.description as contact_namet "
                    +"From marketing_t_checkup mkcu "
                    + "Left join marketing_t_checkup_patient mkcup on mkcu.marketing_checkup_id = mkcup.marketing_checkup_id "
                    + "Where mkcu.marketing_checkup_active = '1' and mkcu.year_id = '"+yearId+"' "
                    + "Group By mkcu.marketing_checkup_id, contact_namet, mkcu.year_id, mkcu.description "
                    + "Having count(mkcup.marketing_checkup_patient_id) > 0 "
                    ;
            rs = st.executeQuery(sql);
            while(rs.next()){
                contact = new BContact();
                contact.setContactId(rs.getString(contact.getFContactId()));
                contact.setContactNamet(rs.getString(contact.getFContactNamet()));
                v_result.add(contact);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getCboContactCheckUp(String branch_id, String yearId, String selected){
        String txt="";
        Vector v_contact = new Vector();
        v_contact = getContactCheckUp(branch_id,yearId);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_contact.size()-1;i++) {
            contact = (BContact) v_contact.get(i);
            if(contact.getContactId().equals(selected)) {
                txt += "<option value='"+contact.getContactId()+"' selected>"+contact.getContactNamet()+"</option>";
            }else {
                txt += "<option value='"+contact.getContactId()+"' >"+contact.getContactNamet()+"</option>";
            }
            if(i==4) {
            }
        }
        return txt;
    }
    public String getCboContact(String branch_id, String selected){
        String txt="";
        Vector v_contact = new Vector();
        v_contact = getContact(branch_id,selected);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_contact.size()-1;i++) {
            contact = (BContact) v_contact.get(i);
            if(contact.getContactId().equals(selected)) {
                txt += "<option value='"+contact.getContactId()+"' selected>"+contact.getContactNamet()+"</option>";
            }else {
                txt += "<option value='"+contact.getContactId()+"' >"+contact.getContactNamet()+"</option>";
            }
            if(i==4) {
            }
        }
        return txt;
    }
    public Vector getBItem(String branch_id, String f_item_group_id, String flag) {
        String sql="";
        Connection conn;
        Vector v_doctor = new Vector();
        try {
            //conn = getConnectionBangna();
            branch = config1.getBranch(branch_id);
            if(flag.equals("combo")){
                sql="Select * "+
            "From "+b_item.getBItem()+" " +
            "left join b_item_subgroup on b_item.b_item_subgroup_id = b_item_subgroup.b_item_subgroup_id " +
            "Where b_item_subgroup.f_item_group_id = '"+f_item_group_id+"' and item_active = '1' " +
            "Order By "+b_item.getFItemCommonName();
            }else if(flag.equals("combo_doctor")){
                sql="Select * "+
            "From "+b_item.getBItem()+" " +
            "left join b_item_subgroup on b_item.b_item_subgroup_id = b_item_subgroup.b_item_subgroup_id " +
            "Where item_active = '1' and "+b_item.getBItem()+".item_status_doctor = '1' " +
            "Order By "+b_item.getFItemCommonName();
            }else{
                sql="Select * "+
            "From "+b_item.getBItem()+" " +
            "left join b_item_subgroup on b_item.b_item_subgroup_id = b_item_subgroup.b_item_subgroup_id " +
            "Where b_item_subgroup.f_item_group_id = '"+f_item_group_id+"' and item_active = '1' " +
            "Order By "+b_item.getFItemCommonName();
            }
            
            conn = config1.getConnectionHospital(branch_id);
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                b_item = new BItem();
                b_item.setItemNumber(rs.getString(b_item.getFItemNumber()));
                b_item.setItemCommonName(rs.getString(b_item.getFItemCommonName()));
                v_doctor.add(b_item);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_doctor;
    }
    public String getCboBItem(String branch_id, String f_item_group_id, String selected){
        String sql="", txt="", select="";
        Vector v_b_item;
        v_b_item = getBItem(branch_id, f_item_group_id,"combo");
        txt += "<option value='' ></option>";
        for(int i=0;i<=v_b_item.size()-1;i++){
            b_item = new BItem();
            b_item = (BItem)v_b_item.get(i);
            select="";
            if(b_item.getItemNumber().equals(selected)){
                txt += "<option value='"+b_item.getItemNumber()+"' selected>"+b_item.getItemCommonName()+"</option>";
            }else{
                txt += "<option value='"+b_item.getItemNumber()+"'>"+b_item.getItemCommonName()+"</option>";
            }
        }
        return txt;
    }
    public String getCboBItemDoctor(String branch_id, String f_item_group_id, String selected){
        String sql="", txt="", select="";
        Vector v_b_item;
        v_b_item = getBItem(branch_id, f_item_group_id,"combo_doctor");
        txt += "<option value='' ></option>";
        for(int i=0;i<=v_b_item.size()-1;i++){
            b_item = new BItem();
            b_item = (BItem)v_b_item.get(i);
            select="";
            if(b_item.getItemNumber().equals(selected)){
                txt += "<option value='"+b_item.getItemNumber()+"' selected>"+b_item.getItemCommonName()+"</option>";
            }else{
                txt += "<option value='"+b_item.getItemNumber()+"'>"+b_item.getItemCommonName()+"</option>";
            }
        }
        return txt;
    }
    public String CboWard(String branch_id, String selected) throws Exception{
        String txt="",sql="";
        Vector v_ward = new Vector();
        Ward ward = new Ward();
//        CboDepartment
        branch = config1.getBranch(branch_id);
        if(branch.getBranchProgram().equals("hospital_osv3")){
            v_ward = departdb.SelectDepartment(branch_id);
        }else{
            v_ward = getWard(branch_id);
        }
        
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_ward.size()-1;i++) {
            if(branch.getBranchProgram().equals("hospital_osv3")){
                depart = (BDepartment) v_ward.get(i);
                if(depart.getDepartmentId().equals(selected)){
                    txt += "<option value='"+depart.getDepartmentId()+"' selected>"+depart.getDepartmentNamet()+"</option>";
                    //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
                }
                else{
                    txt += "<option value='"+depart.getDepartmentId()+"' >"+depart.getDepartmentNamet()+"</option>";
                    //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
                }
            }else{
                ward = (Ward) v_ward.get(i);
                if(ward.getWardId().equals(selected)){
                    txt += "<option value='"+ward.getWardId()+"' selected>"+ward.getWardNamet()+"</option>";
                    //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
                }else{
                    txt += "<option value='"+ward.getWardId()+"' >"+ward.getWardNamet()+"</option>";
                    //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
                }
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public String CboWardN(String branch_id, String selected) throws Exception{
        String txt="",sql="";
        Vector v_ward = new Vector();
        Ward ward = new Ward();
//        CboDepartment
        v_ward = getWard(branch_id);
        
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_ward.size()-1;i++) {
            ward = (Ward) v_ward.get(i);
            if(ward.getWardId().equals(selected)){
                txt += "<option value='"+ward.getWardId()+"' selected>"+ward.getWardNamet()+"</option>";
            }else{
                txt += "<option value='"+ward.getWardId()+"' >"+ward.getWardNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getWard(String branch_id){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        Ward ward = new Ward();
        try {
            branch = config1.getBranch(branch_id);
            if(branch.getBranchProgram().equals("hospital_osv3")){
                conn = config1.getConnectionHospital(branch_id);
                st = conn.createStatement();
                sql="Select b_visit_ward_id as mnc_md_dep_no, visit_ward_description as mnc_md_dep_dsc "
                        + "From b_visit_ward "
                        + "Where visit_ward_active = '1' ";
            }else{
                conn = config1.getConnectionMainHIS(branch_id);
                st = conn.createStatement();
                sql = "Select pm32.mnc_md_dep_no, pm32.mnc_md_dep_dsc "
                    +"From patient_m32  pm32 "
                    +"Where mnc_typ_pt = 'I' ";
            }
            rs = st.executeQuery(sql);
            while(rs.next()){
                ward = new Ward();
                ward.setWardId(rs.getString("mnc_md_dep_no"));
                ward.setWardNamet(rs.getString("mnc_md_dep_dsc"));
                v_result.add(ward);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public Vector getFItemGroup(String branch_id) {
        String sql="";
        Connection conn;
        Vector v_doctor = new Vector();
        try {
            //conn = getConnectionBangna();
            branch = config1.getBranch(branch_id);
            sql="Select * "+
            "From "+f_item_group.getFItemGroup();
            conn = config1.getConnectionHospital(branch_id);
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                f_item_group = new FItemGroup();
                f_item_group.setFItemGroupId(rs.getString(f_item_group.getFFItemGroupId()));
                f_item_group.setItemGroupDescription(rs.getString(f_item_group.getFItemGroupDescription()));
                v_doctor.add(f_item_group);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_doctor;
    }
    public String getCboFItemGroup(String branch_id, String selected){
        String sql="", txt="", select="";
        Vector v_f_item_group;
        v_f_item_group = getFItemGroup(branch_id);
        txt += "<option value='' ></option>";
//        select="selected";
        for(int i=0;i<=v_f_item_group.size()-1;i++){
            f_item_group = new FItemGroup();
            f_item_group = (FItemGroup)v_f_item_group.get(i);
            select="";
            if(f_item_group.getFItemGroupId().equals(selected)){
                txt += "<option value='"+f_item_group.getFItemGroupId()+"' selected>"+f_item_group.getItemGroupDescription()+"</option>";
            }else{
                txt += "<option value='"+f_item_group.getFItemGroupId()+"'>"+f_item_group.getItemGroupDescription()+"</option>";
            }
            //acombo.addItem(rs.getString("col1"));
        }
        return txt;
    }
    public Vector getBank(String branch_id) throws Exception{
        String sql="", txt="", select="";
        Connection conn = config1.getConnectionBangna();
        Vector v_bank = new Vector();
        BBank bank = new BBank();
        Statement st;
        ResultSet rs;
        sql="Select "+bank.getFBBankNamet()+", "+bank.getFBBankId()+" From "+bank.getBBank()+" "+
                "Where "+bank.getFBBankActive()+"='1'";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            bank = new BBank();
            bank.setBBankId(rs.getString(bank.getFBBankId()));
            bank.setBBankNamet(rs.getString(bank.getFBBankNamet()));
            v_bank.add(bank);
        }
        rs.close();
        conn.close();
        return v_bank;
    }
    public String getComboBank(String branch_id,String selected) throws Exception{
        String sql="", txt="", select="";
        Vector v_bank = new Vector();
        v_bank = getBank(branch_id);
        BBank bank = new BBank();
        for(int i=0;i<=v_bank.size()-1;i++){
            bank = (BBank)v_bank.get(i);
            if(bank.getBBankId().equals(selected)){
                txt += "<option value='"+bank.getBBankId()+"' selected>"+bank.getBBankNamet()+"</option>";
            }else{
                txt += "<option value='"+bank.getBBankId()+"' >"+bank.getBBankNamet()+"</option>";
            }
        }
        return txt;
    }
    public String getCboBackOffice(String selected) throws Exception {
        String sql="", txt="", select="";
        Vector v_back_department = new Vector();
        v_back_department = getBackOffice();
//        BBranch branch = new BBranch();
        for(int i=0;i<=v_back_department.size()-1;i++) {
            back_department = (BackBDepartment)v_back_department.get(i);
            if(back_department.getBDepartmentId().equals(selected)){
                txt += "<option value='"+back_department.getBDepartmentId()+"' selected>"+back_department.getBDepartmentNamet()+"</option>";
            } else{
                if(back_department.getBDepartmentActive().equals("1") && selected.equals("")){
                    txt += "<option value='"+back_department.getBDepartmentId()+"' selected>"+back_department.getBDepartmentNamet()+"</option>";
                } else{
                    txt += "<option value='"+back_department.getBDepartmentId()+"' >"+back_department.getBDepartmentNamet()+"</option>";
                }
            }
        }
        return txt;
    }
    public Vector getBackOffice() throws Exception {
        String sql="", txt="", select="";
        Connection conn = config1.getConnectionBangna();
        Vector v_branch = new Vector();
        Statement st;
        ResultSet rs;
        sql="Select * From "+back_department.getBackBDepartment();
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            back_department = new BackBDepartment();
            back_department.setBDepartmentActive(rs.getString(back_department.getFBDepartmentActive()));
            back_department.setBDepartmentId(rs.getString(back_department.getFBDepartmentId()));
            back_department.setBDepartmentNamet(rs.getString(back_department.getFBDepartmentNamet()));

            v_branch.add(back_department);
        }
        rs.close();
        conn.close();
        return v_branch;
    }
    public Vector getPatientVisit(String branch_id, String visti_date, String dep_id) {
        Vector v_patient_visit = new Vector();
        String time="", visit_date="";
        String sql="Select pt01.*, pm02.mnc_pfix_dsc+' '+pm01.mnc_fname_t +' '+ pm01.mnc_lname_t as patient_fullnamet, "
            +"pmm02.mnc_pfix_dsc+' ' +pm26.mnc_dot_fname +' '+pm26.mnc_dot_lname as doctor_fullnamet, "
            +"fm02.mnc_fn_typ_dsc "
            +"From patient_t01 pt01 left join patient_m01 pm01 on pt01.mnc_hn_no = pm01.mnc_hn_no and "
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
            connmainhis = config1.getConnectionMainHIS(branch_id);
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
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_patient_visit;
    }
    public String CboPatientVisit(String branch_id, String visti_date, String dep_id, String patient_hn, String selected) {
        String txt="",sql="";
        Vector v_vn = new Vector();
        PatientVisit patient_visit = new PatientVisit();
        v_vn = getPatientVisit(branch_id, visti_date, dep_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_vn.size()-1;i++) {
            patient_visit = (PatientVisit) v_vn.get(i);
            if(patient_visit.getPatientHn().equals(selected)) {
                txt += "<option value='"+patient_visit.getPatientHn()+"' selected>"+patient_visit.getPatientNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+patient_visit.getPatientHn()+"' >"+patient_visit.getPatientNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public String CboPatientVisitShowVN(String branch_id, String visti_date, String dep_id, String patient_hn, String selected){
        String txt="",sql="";
        Vector v_vn = new Vector();
        PatientVisit patient_visit = new PatientVisit();
        v_vn = getPatientVisit(branch_id, visti_date, dep_id, patient_hn);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_vn.size()-1;i++) {
            patient_visit = (PatientVisit) v_vn.get(i);
            if(patient_visit.getVisitVn().equals(selected)||(v_vn.size()==1)){
                txt += "<option value='"+patient_visit.getTVisitId()+"' selected>"+patient_visit.getVisitVn()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }
            else{
                txt += "<option value='"+patient_visit.getTVisitId()+"' >"+patient_visit.getVisitVn()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getPatientVisit(String branch_id, String visit_date, String dep_id, String patient_hn){
        Vector v_patient_visit = new Vector();
        String time="";

        String sql=" ";
        Connection connmainhis;
        Statement stmainhis;
        ResultSet rsmainhis;
        PatientVisit patient_visit = new PatientVisit();
        try {
            branch = config1.getBranch(branch_id);
            if(branch.getBranchProgram().equals("hospital_osv3")){
                connmainhis = config1.getConnectionHospital(branch_id);
                sql="Select tp.patient_firstname, tp.patient_lastname, tp.patient_hn, tv.visit_vn, tv.t_visit_id,substring(tv.visit_begin_visit_time,1,10) as visit_begin_visit_time " +
                        "From t_patient tp left join t_visit tv on tv.t_patient_id = tp.t_patient_id " +
                        "Where tp.patient_hn = '"+patient_hn+"' and substring(tv.visit_begin_visit_time,1,10) = '"+visit_date+"' ";
            }else{
                sql="Select pt01.*, pm02.mnc_pfix_dsc,pm01.mnc_fname_t,pm01.mnc_lname_t, "
                    +"pmm02.mnc_pfix_dsc,pm26.mnc_dot_fname,pm26.mnc_dot_lname, "
                    +"fm02.mnc_fn_typ_dsc "
                    +"From patient_t01 pt01 inner join patient_m01 pm01 on pt01.mnc_hn_no = pm01.mnc_hn_no and "
                    +"pt01.mnc_hn_yr = pm01.mnc_hn_yr inner join patient_m02 pm02 on "
                    +"pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd inner join patient_m26 pm26 on "
                    +"pt01.mnc_dot_cd = pm26.mnc_dot_cd inner join patient_m02 pmm02 on "
                    +"pm26.mnc_dot_pfix = pmm02.mnc_pfix_cd inner join "
                    +"finance_m02 fm02 on pt01.mnc_fn_typ_cd = fm02.mnc_fn_typ_cd "
                    +"Where pt01.mnc_date = '"+visit_date+"' and pt01.mnc_hn_no = '"
                    +patient_hn+"' and pt01.mnc_sts <> 'C' "
                    +"Order By pt01.mnc_date, pt01.mnc_time ";
                connmainhis = config1.getConnectionMainHIS(branch_id);

            }

            stmainhis = connmainhis.createStatement();
            rsmainhis = stmainhis.executeQuery(sql);
            while(rsmainhis.next()){
                patient_visit = new PatientVisit();
                if(branch.getBranchProgram().equals("hospital_osv3")){
                    patient_visit.setPatientId(rsmainhis.getString("patient_hn"));
                    patient_visit.setPatientNamet(rsmainhis.getString("patient_firstname"));
                    patient_visit.setPatientLastNamet(rsmainhis.getString("patient_lastname"));
                    patient_visit.setVisitDate(rsmainhis.getString("visit_begin_visit_time"));
                    patient_visit.setVisitVn(rsmainhis.getString("visit_vn"));
                    patient_visit.setTVisitId(rsmainhis.getString("t_visit_id"));
                }else{
                    patient_visit.setPatientId(rsmainhis.getString("mnc_hn_no"));
                    patient_visit.setPatientNamet(rsmainhis.getString("mnc_fname_t"));
                    patient_visit.setPatientLastNamet(rsmainhis.getString("mnc_lname_t"));
                    patient_visit.setVisitDate(rsmainhis.getString("mnc_date"));
                    patient_visit.setVisitTime(time);
                    patient_visit.setVisitVn(rsmainhis.getString("mnc_vn_no")+"."+rsmainhis.getString("mnc_vn_seq"));
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
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_patient_visit;
    }
    public String CboPatientVisitShowVNVisitId(String branch_id, String visti_date, String dep_id, String patient_hn, String selected){
        String txt="",sql="";
        Vector v_vn = new Vector();
        PatientVisit patient_visit = new PatientVisit();
        v_vn = getPatientVisit(branch_id, visti_date, dep_id, patient_hn);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_vn.size()-1;i++) {
            patient_visit = (PatientVisit) v_vn.get(i);
            if(patient_visit.getTVisitId().equals(selected)||(v_vn.size()==1)){
                txt += "<option value='"+patient_visit.getTVisitId()+"' selected>"+patient_visit.getVisitVn()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }
            else{
                txt += "<option value='"+patient_visit.getTVisitId()+"' >"+patient_visit.getVisitVn()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public String getComboICD10(String branch_id, String selected){
        String txt="";
        Vector v_icd10 = new Vector();
        v_icd10 = getICD10(branch_id, selected);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_icd10.size()-1;i++) {
            icd10 = (BIcd10) v_icd10.get(i);
            if(icd10.getIcd10Number().equals(selected)){
                txt += "<option value='"+icd10.getIcd10Number()+"' selected>"+icd10.getIcd10Number()+" "+icd10.getIcd10Description()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+icd10.getIcd10Number()+"' >"+icd10.getIcd10Number()+" "+icd10.getIcd10Description()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
            }
        }
        return txt;
    }
    public Vector getICD10(String branch_id, String selected){
        String sql="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionHospital(branch_id);
            st = conn.createStatement();
            if(selected.equals("")){
                sql = "Select "+icd10.getFIcd10Number()+", "+icd10.getFIcd10Description()+" "
                    +"From "+icd10.getBIcd10();
            }else{
                sql = "Select "+icd10.getFIcd10Number()+", "+icd10.getFIcd10Description()+" "
                    +"From "+icd10.getBIcd10()+" " +
                    "Where "+icd10.getFIcd10Number()+" like '"+selected+"%'" +
                    "Order By "+icd10.getFIcd10Number();
            }
            rs = st.executeQuery(sql);
            while(rs.next()){
                icd10 = new BIcd10();
                icd10.setIcd10Number(rs.getString(icd10.getFIcd10Number()));
                icd10.setIcd10Description(rs.getString(icd10.getFIcd10Description()));
                v_result.add(icd10);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String CboBTransfer(String branch_id, String subsystem, String selected){
        String txt="",sql="";
        Vector v_b_transfer = new Vector();
        v_b_transfer = getBTransfer(branch_id,subsystem);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_b_transfer.size()-1;i++) {
            b_transfer = (BackBTransfer) v_b_transfer.get(i);
            if(b_transfer.paidId.equals(selected)){
                txt += "<option value='"+b_transfer.paidId+"' selected>"+b_transfer.bDepartmentNamet+"</option>";
            }else{
                txt += "<option value='"+b_transfer.paidId+"' >"+b_transfer.bDepartmentNamet+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getBTransfer(String branch_id, String subsystem){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionBangna();
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
    public Vector getDoctorFullNamet(String branch_id) {
        String sql="", patient_full_namet="", where="";
        Connection conn;
        Vector v_doctor = new Vector();
        Doctor doctor = new Doctor();
        try {
            //conn = getConnectionBangna();
//            branch = getBranch(branch_id);
            if(!branch_id.equals("")) {
                where = " and branch_id = '"+branch_id+"' ";
            }else{
            }
            sql="Select b_employee.employee_number as mnc_dot_cd, b_employee.employee_firstname || '  ' || b_employee.employee_lastname as fullnamet "
                +"From b_employee " +
                "Where f_employee_authentication_id = '3' "+where+" and employee_active = '1' "
                + "Order By status_employee, b_employee.employee_firstname, b_employee.employee_lastname";
            conn = config1.getConnectionBangna();
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
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_doctor;
    }
    public Vector getDoctorFullNametmarketing(String branch_id, String startDate,String endDate) {
        String sql="", patient_full_namet="", where="";
        Connection conn;
        Vector v_doctor = new Vector();
        Doctor doctor = new Doctor();
        try {
            //conn = getConnectionBangna();
//            branch = getBranch(branch_id);
            if(!branch_id.equals("")) {
                where = " and branch_id = '"+branch_id+"' ";
            }else{
            }
            sql="Select Distinct b_employee.employee_number as mnc_dot_cd, b_employee.employee_firstname || '  ' || b_employee.employee_lastname as fullnamet "
                +"From b_employee "
                + "Left Join survey_t_doctor sud on sud.doctor_id = b_employee.employee_number " +
                "Where f_employee_authentication_id = '3' "+where+" and employee_active = '1' "
                + "and substring(sud.survey_date_time,1,11) >= '"+startDate+"' and substring(sud.survey_date_time,1,11) <= '"+endDate+"' "
                + "Order By fullnamet";
            conn = config1.getConnectionBangna();
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
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_doctor;
    }
    public Vector getDoctorFullNamet(String branch_id, String doctorSearch, String flag) {
        String sql="", searchDoctor="", where="", searchFlag="";
        Connection conn;
        Vector v_doctor = new Vector();
        Doctor doctor = new Doctor();
        try {
            //conn = getConnectionBangna();
//            branch = getBranch(branch_id);
            if(!branch_id.equals("")) {
                where = " and branch_id = '"+branch_id+"' ";
            }else{
            }
            if(!doctorSearch.equals("")) searchDoctor = " and b_employee.employee_number like '%"+doctorSearch+"%'";
            if(!flag.equals("")) searchFlag = " and status_employee = '1'";
            sql="Select b_employee.employee_number as mnc_dot_cd, b_employee.employee_firstname || '  ' || b_employee.employee_lastname as fullnamet "
                +"From b_employee " +
                "Where f_employee_authentication_id = '3' "+where+" and employee_active = '1' "+searchFlag+searchDoctor
                + "Order By status_employee, b_employee.employee_firstname, b_employee.employee_lastname";
            conn = config1.getConnectionBangna();
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
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_doctor;
    }
    public String getComboDoctorFullNametMarketing(String branch_id, String selected, String startDate, String endDate){
        String sql="", txt="", select="";
        Vector v_doctor;
        v_doctor = getDoctorFullNametmarketing(branch_id, startDate, endDate);
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
    public Vector getMarketingFullNamet(String branch_id, String flag) {
        String sql="", patient_full_namet="", where="", searchFlag="";
        Connection conn;
        Vector v_doctor = new Vector();
        Doctor doctor = new Doctor();
        try {
            //conn = getConnectionBangna();
//            branch = getBranch(branch_id);
            if(!branch_id.equals("")) {
                where = " and branch_id = '"+branch_id+"' ";
            }else{
            }
            if(!flag.equals("")) searchFlag = " and status_employee = '1'";
            sql="Select b_employee.b_employee_id as mnc_dot_cd, b_employee.employee_firstname || '  ' || b_employee.employee_lastname as fullnamet "
                +"From b_employee " +
                "Where f_employee_authentication_id = '102' "+where+" and employee_active = '1' "+searchFlag
                + "Order By status_employee, b_employee.employee_firstname, b_employee.employee_lastname";
            conn = config1.getConnectionBangna();
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
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_doctor;
    }
    public String getComboMarketingFullNamet(String branch_id, String selected){
        String sql="", txt="", select="";
        Vector v_doctor;
        v_doctor = getMarketingFullNamet(branch_id,"");
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
    public String getTrDoctorFullNamet(String branch_id, String doctor1, String doctorSearch){
        String sql="", txt="", select="", tHead="";
        Vector v_doctor;
        v_doctor = getDoctorFullNamet(branch_id,doctor1,"doctor");
        tHead = "<table class='tablecolors' width='100%' align='center' id='trDoctor'>";
        for(int i=0;i<=v_doctor.size()-1;i++){
            doctor = new Doctor();
            doctor = (Doctor)v_doctor.get(i);
            txt+="<tr><td>&nbsp;</td><td><a href='surveyDoctorForm.jsp?doctor_id="+doctor.getDoctorId()+"'> "+doctor.getDoctorId()+" "+doctor.getDoctorNamet()+"</a></td><td><input type='hidden' id='txtdoctorId"+i+"' value='"+doctor.getDoctorId()+"' /></td></tr>";
        }
        return tHead+txt+"</table>";
    }
    public String getComboFVisitType(String branch_id, String selected){
        String txt="",sql="";
        Vector v_f_visit_type = new Vector();
        v_f_visit_type = getFVisitType(branch_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_f_visit_type.size()-1;i++) {
            f_visit_type = (FVisitType) v_f_visit_type.get(i);
            if(f_visit_type.getFVisitTypeId().equals(selected)){
                txt += "<option value='"+f_visit_type.getFVisitTypeId()+"' selected>"+f_visit_type.getVisitTypeDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+f_visit_type.getFVisitTypeId()+"' >"+f_visit_type.getVisitTypeDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getFVisitType(String branch_id){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select "+f_visit_type.getFFVisitTypeId()+", "+f_visit_type.getFVisitTypeDescription()+" "
                    +"From "+f_visit_type.getFVisitType()+" ";
            rs = st.executeQuery(sql);
            while(rs.next()){
                f_visit_type = new FVisitType();
                f_visit_type.setFVisitTypeId(rs.getString(f_visit_type.getFFVisitTypeId()));
                f_visit_type.setVisitTypeDescription(rs.getString(f_visit_type.getFVisitTypeDescription()));
                v_result.add(f_visit_type);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getComboContractPayer(String branch_id, String selected){
        String txt="",sql="";
        Vector v_contract_payer = new Vector();
        v_contract_payer = getContractPayer(branch_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_contract_payer.size()-1;i++) {
            contract_payer = (BContractPayer) v_contract_payer.get(i);
            if(contract_payer.getContractPayerNumber().equals(selected)){
                txt += "<option value='"+contract_payer.getContractPayerNumber()+"' selected>"+contract_payer.getContractPayerDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+contract_payer.getContractPayerNumber()+"' >"+contract_payer.getContractPayerDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getContractPayer(String branch_id){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionHospital(branch_id);
            st = conn.createStatement();
            sql = "Select "+contract_payer.getFContractPayerNumber()+", "+contract_payer.getFContractPayerDescription()+" "
                    +"From "+contract_payer.getBContractPayer()+" Where "+contract_payer.getFContractPayerActive()+"='1'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                contract_payer = new BContractPayer();
                contract_payer.setContractPayerNumber(rs.getString(contract_payer.getFContractPayerNumber()));
                contract_payer.setContractPayerDescription(rs.getString(contract_payer.getFContractPayerDescription()));
                v_result.add(contract_payer);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getComboDayNamet(String selected){
        String txt="",sql="";
        Vector v_day = new Vector();
        v_day = getDayNamet();
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_day.size()-1;i++) {
            f_day = (FDay) v_day.get(i);
            if(f_day.getDayId().equals(selected)){
                txt += "<option value='"+f_day.getDayId()+"' selected>"+f_day.getDayNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+f_day.getDayId()+"' >"+f_day.getDayNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getDayNamet(){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select * "+" "
                    +"From "+f_day.getFDay()+" ";
            rs = st.executeQuery(sql);
            while(rs.next()){
                f_day = new FDay();
                f_day.setDayId(rs.getString(f_day.getFDayId()));
                f_day.setDayNamet(rs.getString(f_day.getFDayNamet()));
                v_result.add(f_day);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getComboFormula(String selected){
        String txt="",sql="";
        Vector v_day = new Vector();
        v_day = getFormula();
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_day.size()-1;i++) {
            pay_formula = (DoctorBFormula) v_day.get(i);
            if(pay_formula.getFormulaId().equals(selected)){
                txt += "<option value='"+pay_formula.getFormulaId()+"' selected>"+pay_formula.getFormulaNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+pay_formula.getFormulaId()+"' >"+pay_formula.getFormulaNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getFormula(){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select * "+" "
                    +"From "+pay_formula.getDoctorBFormula()
                    +" Where "+pay_formula.getFFormulaActive()+"='1' and "+pay_formula.getFStatusFormula()+"='1'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                pay_formula = new DoctorBFormula();
                pay_formula.setFormulaId(rs.getString(pay_formula.getFFormulaId()));
                pay_formula.setFormulaNamet(rs.getString(pay_formula.getFFormulaNamet())+""+rs.getString(pay_formula.getFRemark()));
                v_result.add(pay_formula);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public Vector getPtTypeMuangsamut(String branch_id) {
        String sql="select distinct "
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
    + "else bcp.contract_plans_pttype end as contract_plans,bcp.contract_plans_pttype "+
                "from b_contract_plans bcp "
                +"where bcp.contract_plans_active = '1' ";

        String txt="";
        Connection conn;
        Statement st;
        Vector v_day = new Vector();
        try {
            conn = config1.getConnectionHospital(branch_id);
            st = conn.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);
            while(rs.next()){
                bcp = new BContractPlans();
                bcp.setContractPlansPttype(rs.getString("contract_plans_pttype"));
                bcp.setContractPlansDescription(rs.getString("contract_plans"));
                v_day.add(bcp);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        //sql = "";
        return v_day;
    }
    public String getComboPtTypeMuangsamut(String branch_id,String selected){
        String txt="",sql="";
        Vector v_day = new Vector();
        v_day = getPtTypeMuangsamut(branch_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_day.size()-1;i++) {
            bcp = (BContractPlans) v_day.get(i);
            if(bcp.getContractPlansPttype().equals(selected)){
                txt += "<option value='"+bcp.getContractPlansPttype()+"' selected>"+bcp.getContractPlansDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+bcp.getContractPlansPttype()+"' >"+bcp.getContractPlansDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public String getPtTypeMuangsamut(String branch_id,String selected){
        String txt="",sql="";
        Vector v_day = new Vector();
        v_day = getPtTypeMuangsamut(branch_id);
        for(int i=0;i<=v_day.size()-1;i++) {
            bcp = (BContractPlans) v_day.get(i);
            if(bcp.getContractPlansPttype().equals(selected)){
                txt = bcp.getContractPlansDescription();
            }
        }
        return txt;
    }
    public String getComboChiFBillgroup(String selected){
        String txt="",sql="";
        Vector v_cfbg = new Vector();
        v_cfbg = getChiFBillgroup();
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_cfbg.size()-1;i++) {
            cfbg = (ChiFBillgroup) v_cfbg.get(i);
            if(cfbg.getBillgroupId().equals(selected)){
                txt += "<option value='"+cfbg.getBillgroupId()+"' selected>"+cfbg.getBillgroupNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+cfbg.getBillgroupId()+"' >"+cfbg.getBillgroupNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getChiFBillgroup(){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select * "+" "
                    +"From "+cfbg.getChiFBillgroup()+" ";
            rs = st.executeQuery(sql);
            while(rs.next()){
                cfbg = new ChiFBillgroup();
                cfbg.setBillgroupId(rs.getString(cfbg.getFBillgroupId()));
                cfbg.setBillgroupNamet(rs.getString(cfbg.getFBillgroupId())+" "+rs.getString(cfbg.getFBillgroupNamet()));
                v_result.add(cfbg);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getComboChiBSurcharge(String selected){
        String txt="",sql="", name="";
        Vector v_cfbg = new Vector();
        v_cfbg = getChiBSurcharge();
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_cfbg.size()-1;i++) {
            cbs = (ChiBSurcharge) v_cfbg.get(i);
            if(cbs.getDefinition().indexOf("(")>0){
                name = cbs.getDefinition().substring(0, cbs.getDefinition().indexOf("("));
            }else{
                name = cbs.getDefinition();
            }
            if(cbs.getSurchargeId().equals(selected)){
                txt += "<option value='"+cbs.getSurchargeId()+"' selected>"+name+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+cbs.getSurchargeId()+"' >"+name+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getChiBSurcharge(){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select * "+" "
                    +"From "+cbs.getChiBSurcharge()+" ";
            rs = st.executeQuery(sql);
            while(rs.next()){
                cbs = new ChiBSurcharge();
                cbs.setSurchargeId(rs.getString(cbs.getFSurchargeId()));
                cbs.setDefinition(rs.getString(cbs.getFDefinition()));
                v_result.add(cbs);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getComboUserCloseDay(String branch_id,String selected){
        String txt="",sql="";
        Vector v_day = new Vector();
        v_day = getUserCloseDay(branch_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_day.size()-1;i++) {
            f_day = (FDay) v_day.get(i);
            if(f_day.getDayId().equals(selected)){
                txt += "<option value='"+f_day.getDayId()+"' selected>"+f_day.getDayNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+f_day.getDayId()+"' >"+f_day.getDayNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getUserCloseDay(String branch_id){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionHospital(branch_id);
            st = conn.createStatement();
            sql = "select distinct billing_invoice_staff_record, employee_firstname || ' ' || employee_lastname as name "
                +"From t_billing_invoice tbi "
                +"left join b_employee be on tbi.billing_invoice_staff_record = be.b_employee_id "
                +"where tbi.billing_invoice_active = '1' and close_day_id = '0'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                f_day = new FDay();
                f_day.setDayId(rs.getString("billing_invoice_staff_record"));
                f_day.setDayNamet(rs.getString("name"));
                v_result.add(f_day);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getComboPrintDoc(String selected){
        String txt="",sql="";
        Vector v_cfbg = new Vector();
        v_cfbg = getPrintDoc();
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_cfbg.size()-1;i++) {
            pdoc = (BPrintDoc) v_cfbg.get(i);
            if(pdoc.getDocId().equals(selected)){
                txt += "<option value='"+pdoc.getDocId()+"' selected>"+pdoc.getDocName()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+pdoc.getDocId()+"' >"+pdoc.getDocName()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getPrintDoc(){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select * "+" "
                    +"From "+pdoc.getBPrintDoc()+" ";
            rs = st.executeQuery(sql);
            while(rs.next()){
                pdoc = new BPrintDoc();
                pdoc.setDocId(rs.getString(pdoc.getFDocId()));
                pdoc.setDocName(rs.getString(pdoc.getFDocName()));
                v_result.add(pdoc);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getComboBVisitClinic(String branch_id, String selected){
        String txt="",sql="";
        Vector v_contract_payer = new Vector();
        v_contract_payer = getBVisitClinic(branch_id);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_contract_payer.size()-1;i++) {
            bVisitClinic = (BVisitClinic) v_contract_payer.get(i);
            if(bVisitClinic.getBVisitClinicId().equals(selected)){
                txt += "<option value='"+bVisitClinic.getBVisitClinicId()+"' selected>"+bVisitClinic.getVisitClinicDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+bVisitClinic.getBVisitClinicId()+"' >"+bVisitClinic.getVisitClinicDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getBVisitClinic(String branch_id){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionHospital(branch_id);
            st = conn.createStatement();
            sql = "Select "+bVisitClinic.getFBVisitClinicId()+", "+bVisitClinic.getFVisitClinicDescription()+" "
                    +"From "+bVisitClinic.getBVisitClinic()+" Where "+bVisitClinic.getFVisitClinicActive()+"='1' "
                    + "Order By "+bVisitClinic.getFVisitClinicDescription();
            rs = st.executeQuery(sql);
            while(rs.next()){
                bVisitClinic = new BVisitClinic();
                bVisitClinic.setBVisitClinicId(rs.getString(bVisitClinic.getFBVisitClinicId()));
                bVisitClinic.setVisitClinicDescription(rs.getString(bVisitClinic.getFVisitClinicDescription()));
                v_result.add(bVisitClinic);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getComboTypeDoctor(String branchId, String selected){
        String txt="",sql="";
        Vector v_cfbg = new Vector();
        v_cfbg = getTypeDoctor(branchId);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_cfbg.size()-1;i++) {
            typeDoctor = (DoctorBTypeDoctor) v_cfbg.get(i);
            if(typeDoctor.getTypeDoctorId().equals(selected)){
                txt += "<option value='"+typeDoctor.getTypeDoctorId()+"' selected>"+typeDoctor.getTypeDoctorNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+typeDoctor.getTypeDoctorId()+"' >"+typeDoctor.getTypeDoctorNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getTypeDoctor(String branchId){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select * "+" "
                    +"From "+typeDoctor.getDoctorBTypeDoctor()+" "
                    + "Where "+typeDoctor.getFTypeDoctorActive()+"='1' and "
                    +typeDoctor.getFBranchId()+"='"+branchId+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                typeDoctor = new DoctorBTypeDoctor();
                typeDoctor.setTypeDoctorId(rs.getString(typeDoctor.getFTypeDoctorId()));
                typeDoctor.setTypeDoctorNamet(rs.getString(typeDoctor.getFTypeDoctorNamet()));
                v_result.add(typeDoctor);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getComboSpecialist(String branchId, String selected){
        String txt="",sql="";
        Vector v_cfbg = new Vector();
        v_cfbg = getSpecialist(branchId);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_cfbg.size()-1;i++) {
            specialist = (DoctorBSpecialist) v_cfbg.get(i);
            if(specialist.getSpecialistId().equals(selected)){
                txt += "<option value='"+specialist.getSpecialistId()+"' selected>"+specialist.getSpecialistNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+specialist.getSpecialistId()+"' >"+specialist.getSpecialistNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getSpecialist(String branchId){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select * "+" "
                    +"From "+specialist.getDoctorBSpecialist()+" "
                    + "Where "+specialist.getFSpecialistActive()+"='1' and "
                    +specialist.getFBranchId()+"='"+branchId+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                specialist = new DoctorBSpecialist();
                specialist.setSpecialistId(rs.getString(specialist.getFSpecialistId()));
                specialist.setSpecialistNamet(rs.getString(specialist.getFSpecialistNamet()));
                v_result.add(specialist);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getComboMarketingReport(String selected){
        String txt="",sql="";
        Vector v_cfbg = new Vector();
        v_cfbg = getmarketingReport();
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_cfbg.size()-1;i++) {
            mReport = (MarketingReport) v_cfbg.get(i);
            if(mReport.marketingReportId.equals(selected)){
                txt += "<option value='"+mReport.marketingReportId+"' selected>"+mReport.marketingreportName+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+mReport.marketingReportId+"' >"+mReport.marketingreportName+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getmarketingReport(){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select * "+" "
                    +"From "+mReportdb.table+" Order By "+mReportdb.sort1;
            rs = st.executeQuery(sql);
            while(rs.next()){
                mReport = new MarketingReport();
                mReport.marketingReportId = config1.StringNull(rs.getString(mReportdb.marketingReportId));
                mReport.marketingreportName = config1.StringNull(rs.getString(mReportdb.marketingreportName));
                v_result.add(mReport);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getComboMarketingPatient(String mktcId,String selected){
        String txt="",sql="";
        Vector v_cfbg = new Vector();
        v_cfbg = getmarketingPatient(mktcId);
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_cfbg.size()-1;i++) {
            mktcp = (MarketingTCheckupPatient) v_cfbg.get(i);
            if(mktcp.marketingCheckupPatientId.equals(selected)){
                txt += "<option value='"+mktcp.rowNumber+"' selected>"+mktcp.rowNumber+" "+mktcp.pateintFullname+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+mktcp.rowNumber+"' >"+mktcp.rowNumber+" "+mktcp.pateintFullname+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getmarketingPatient(String mktcId){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select * "+" "
                    +"From "+mktcpdb.table+" "
                    + "Where "+mktcpdb.marketingCheckupId+"='"+mktcId+"' "
                    + "Order By "+mktcpdb.rowNumber+","+mktcpdb.pateintFullname;
            rs = st.executeQuery(sql);
            while(rs.next()){
                mktcp = new MarketingTCheckupPatient();
                mktcp.marketingCheckupPatientId = config1.StringNull(rs.getString(mktcpdb.marketingCheckupPatientId));
                mktcp.pateintFullname = config1.StringNull(rs.getString(mktcpdb.pateintFullname));
                mktcp.rowNumber = config1.StringNull(rs.getString(mktcpdb.rowNumber));
                v_result.add(mktcp);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getComboFStatus(String selected){
        String txt="",sql="";
        Vector v_cfbg = new Vector();
        v_cfbg = getFStatus();
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_cfbg.size()-1;i++) {
            fstatus = (Fstatus) v_cfbg.get(i);
            if(fstatus.fStatusId.equals(selected)){
                txt += "<option value='"+fstatus.fStatusId+"' selected>"+fstatus.fStatusName+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+fstatus.fStatusId+"' >"+fstatus.fStatusName+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getFStatus(){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select * "+" "
                    +"From f_status ";
            rs = st.executeQuery(sql);
            while(rs.next()){
                fstatus = new Fstatus();
                fstatus.fStatusId = config1.StringNull(rs.getString("f_status_id"));
                fstatus.fStatusName = config1.StringNull(rs.getString("f_status_name"));
                v_result.add(fstatus);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getComboFSex(String selected){
        String txt="",sql="";
        Vector v_cfbg = new Vector();
        v_cfbg = getFSex();
        txt="<option value='' selected></option>";
        for(int i=0;i<=v_cfbg.size()-1;i++) {
            fSex = (FSex) v_cfbg.get(i);
            if(fSex.getFSexId().equals(selected)){
                txt += "<option value='"+fSex.getFSexId()+"' selected>"+fSex.getSexDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }else{
                txt += "<option value='"+fSex.getFSexId()+"' >"+fSex.getSexDescription()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
    public Vector getFSex(){
        String sql="", txt="";
        Vector v_result = new Vector();
        Connection conn;
        Statement st;
        ResultSet rs;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select * "+" "
                    +"From f_sex ";
            rs = st.executeQuery(sql);
            while(rs.next()){
                fSex = new FSex();
                fSex.setFSexId(config1.StringNull(rs.getString(fSex.getFFSexId())));
                fSex.setSexDescription(config1.StringNull(rs.getString(fSex.getFSexDescription())));
                v_result.add(fSex);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ComboDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_result;
    }
    public String getComboStatusVisit(String selected){
        String txt="",sql="";
        Vector v_cfbg = new Vector();
        if(selected.equals("1")) txt += "<option value='' ></option><option value='1' selected>มาตรวจ</option><option value='2'>ไม่มาตรวจ</option>";
        else if(selected.equals("2")) txt += "<option value='' ></option><option value='1'>มาตรวจ</option><option value='2' selected>ไม่มาตรวจ</option>";
        else txt += "<option value='0' selected></option><option value='1'>มาตรวจ</option><option value='2' >ไม่มาตรวจ</option>";
        return txt;
    }
    public String CboDepartment(String branch_id,String selected){
        String txt="",sql="";
        Vector v_b_department = new Vector();
        BDepartment b_department = new BDepartment();
        v_b_department = departdb.SelectDepartment(branch_id);
        for(int i=0;i<=v_b_department.size()-1;i++) {
            b_department = (BDepartment) v_b_department.get(i);
            if(b_department.getDepartmentId().equals(selected)){
                txt += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"' selected>"+b_department.getDepartmentNamet()+"</option>";
            }
            else{
                txt += "<option value='"+b_department.getDepartmentId()+"' >"+b_department.getDepartmentNamet()+"</option>";
                //ma_department_cbo += "<option value='"+b_department.getDepartmentId()+"'>"+b_department.getDepartmentNamet()+"</option>";
            }
            if(i==4){
                sql="";
            }
        }
        return txt;
    }
}
