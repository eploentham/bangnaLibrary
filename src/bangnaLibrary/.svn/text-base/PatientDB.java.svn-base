/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class PatientDB {
    Config1 config1;
    BBranch branch ;
    TVisit visit ;
    VVisit vvisit ;
    public VPatient vpatient ;
    public PatientDB(){
        config1 = new Config1();
        initConfig(config1);
    }
    public PatientDB(Config1 cf){
        config1 = cf;
        initConfig(cf);
    }
    public void initConfig(Config1 cf){
        branch = new BBranch();
        visit = new TVisit();
        vvisit = new VVisit();
        vpatient = new VPatient();
    }
    public VPatient getPatientV(String branch_id, String visit_hn, String flag) {
        String sql="", text="";
        Connection conn;
        Statement st;
        ResultSet rs;
        Vector v_patient = new Vector();
        try {
            branch = config1.getBranch(branch_id);
            if(branch.getBranchProgram().equals("hospital_osv3")){
                conn = config1.getConnectionHospital(branch_id);
                sql="Select * From "+vpatient.getVPatient()+" " +
                    "Where patient_hn = '"+visit_hn+"' ";
            }else{
                conn = config1.getConnectionMainHIS(branch_id);
            }
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                vpatient = new VPatient();
                vpatient.setAge1(config1.StringNull(rs.getString(vpatient.getFAge1())));
                vpatient.setContactJoinNamet(config1.StringNull(rs.getString(vpatient.getFContactJoinNamet())));
                vpatient.setContactNamet(config1.StringNull(rs.getString(vpatient.getFContactNamet())));
//                vpatient.setFPatientRelationId(config1.StringNull(rs.getString(vpatient.getFPatientRelationId())));
                vpatient.setPatientAmphur(config1.StringNull(rs.getString(vpatient.getFPatientAmphur())));

                vpatient.setPatientBirthday(config1.StringNull(rs.getString(vpatient.getFPatientBirthday())));
                vpatient.setPatientBloodGroupDescription(config1.StringNull(rs.getString(vpatient.getFPatientBloodGroupDescription())));
                vpatient.setPatientChangwat(config1.StringNull(rs.getString(vpatient.getFPatientChangwat())));
                vpatient.setPatientContactMobilePhone(config1.StringNull(rs.getString(vpatient.getFPatientContactMobilePhone())));
                vpatient.setPatientContactPhoneNumber(config1.StringNull(rs.getString(vpatient.getFPatientContactPhoneNumber())));

                vpatient.setPatientFirstname(config1.StringNull(rs.getString(vpatient.getFPatientFirstname())));
                vpatient.setPatientHn(config1.StringNull(rs.getString(vpatient.getFPatientHn())));
                vpatient.setPatientLastname(config1.StringNull(rs.getString(vpatient.getFPatientLastname())));
                vpatient.setPatientMarriageStatusDescription(config1.StringNull(rs.getString(vpatient.getFPatientMarriageStatusDescription())));
                vpatient.setPatientNationDescription(config1.StringNull(rs.getString(vpatient.getFPatientNationDescription())));

                vpatient.setPatientOccupationDescription(config1.StringNull(rs.getString(vpatient.getFPatientOccupationDescription())));
                vpatient.setPatientPatientMobilePhone(config1.StringNull(rs.getString(vpatient.getFPatientPatientMobilePhone())));
                vpatient.setPatientPhoneNumber(config1.StringNull(rs.getString(vpatient.getFPatientPhoneNumber())));
                vpatient.setPatientPid(config1.StringNull(rs.getString(vpatient.getFPatientPid())));
                vpatient.setPatientPrefixDescription(config1.StringNull(rs.getString(vpatient.getFPatientPrefixDescription())));

                vpatient.setPatientTambon(config1.StringNull(rs.getString(vpatient.getFPatientTambon())));
                vpatient.setRemark1(config1.StringNull(rs.getString(vpatient.getFRemark1())));
                vpatient.setRemark2(config1.StringNull(rs.getString(vpatient.getFRemark2())));
                vpatient.setSexDescription(config1.StringNull(rs.getString(vpatient.getFSexDescription())));
                vpatient.setTPatientId(config1.StringNull(rs.getString(vpatient.getFTPatientId())));

            }
            rs.close();
            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(PatientDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vpatient;
    }
    public Vector getVPatientV(String branch_id, String visit_hn, String flag) {
        String sql="", text="";
        Connection conn;
        Statement st;
        ResultSet rs;
        Vector v_patient = new Vector();
        try {
            branch = config1.getBranch(branch_id);
            if(flag.equals("auto_search_hn")){
                conn = config1.getConnectionHospital(branch_id);
                sql="Select * From "+vpatient.getVPatient()+" " +
                    "Where patient_hn like '"+visit_hn+"%' "
                    + "Order By "+vpatient.getFPatientHn()+" limit 20";
            }else{
                if(branch.getBranchProgram().equals("hospital_osv3")){
                    conn = config1.getConnectionHospital(branch_id);
                    sql="Select * From "+vpatient.getVPatient()+" " +
                        "Where patient_hn = '"+visit_hn+"' ";
                }else{
                    conn = config1.getConnectionMainHIS(branch_id);
                }
            }
            
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                vpatient = new VPatient();
                vpatient.setAge1(config1.StringNull(rs.getString(vpatient.getFAge1())));
                vpatient.setContactJoinNamet(config1.StringNull(rs.getString(vpatient.getFContactJoinNamet())));
                vpatient.setContactNamet(config1.StringNull(rs.getString(vpatient.getFContactNamet())));
//                vpatient.setFPatientRelationId(config1.StringNull(rs.getString(vpatient.getFPatientRelationId())));
                vpatient.setPatientAmphur(config1.StringNull(rs.getString(vpatient.getFPatientAmphur())));

                vpatient.setPatientBirthday(config1.StringNull(rs.getString(vpatient.getFPatientBirthday())));
                vpatient.setPatientBloodGroupDescription(config1.StringNull(rs.getString(vpatient.getFPatientBloodGroupDescription())));
                vpatient.setPatientChangwat(config1.StringNull(rs.getString(vpatient.getFPatientChangwat())));
                vpatient.setPatientContactMobilePhone(config1.StringNull(rs.getString(vpatient.getFPatientContactMobilePhone())));
                vpatient.setPatientContactPhoneNumber(config1.StringNull(rs.getString(vpatient.getFPatientContactPhoneNumber())));

                vpatient.setPatientFirstname(config1.StringNull(rs.getString(vpatient.getFPatientFirstname())));
                vpatient.setPatientHn(config1.StringNull(rs.getString(vpatient.getFPatientHn())));
                vpatient.setPatientLastname(config1.StringNull(rs.getString(vpatient.getFPatientLastname())));
                vpatient.setPatientMarriageStatusDescription(config1.StringNull(rs.getString(vpatient.getFPatientMarriageStatusDescription())));
                vpatient.setPatientNationDescription(config1.StringNull(rs.getString(vpatient.getFPatientNationDescription())));

                vpatient.setPatientOccupationDescription(config1.StringNull(rs.getString(vpatient.getFPatientOccupationDescription())));
                vpatient.setPatientPatientMobilePhone(config1.StringNull(rs.getString(vpatient.getFPatientPatientMobilePhone())));
                vpatient.setPatientPhoneNumber(config1.StringNull(rs.getString(vpatient.getFPatientPhoneNumber())));
                vpatient.setPatientPid(config1.StringNull(rs.getString(vpatient.getFPatientPid())));
                vpatient.setPatientPrefixDescription(config1.StringNull(rs.getString(vpatient.getFPatientPrefixDescription())));

                vpatient.setPatientTambon(config1.StringNull(rs.getString(vpatient.getFPatientTambon())));
                vpatient.setRemark1(config1.StringNull(rs.getString(vpatient.getFRemark1())));
                vpatient.setRemark2(config1.StringNull(rs.getString(vpatient.getFRemark2())));
                vpatient.setSexDescription(config1.StringNull(rs.getString(vpatient.getFSexDescription())));
                vpatient.setTPatientId(config1.StringNull(rs.getString(vpatient.getFTPatientId())));
                v_patient.add(vpatient);

            }
            rs.close();
            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(PatientDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_patient;
    }
    public String getAutoSearch(String branchId,String searchHn, String flag){
        StringBuilder text = new StringBuilder();
        String patientFullName="";
        Vector v = new Vector();
        v = getVPatientV(branchId,searchHn,flag);
        for(int i=0;i<v.size();i++){
            vpatient = (VPatient)v.get(i);
            patientFullName = vpatient.getPatientPrefixDescription()+" "+vpatient.getPatientFirstname()+" "+vpatient.getPatientLastname();
            text.append(vpatient.getPatientHn()).append(" ").append(patientFullName).append("@");
        }
        return text.toString();
    }

}
