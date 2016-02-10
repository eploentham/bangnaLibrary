package bangnaLibrary;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author pop
 */
public class Patient {
    private String patient_id="", patient_namet="", patient_age="", patient_prefix="", patient_hn="";
    private String patient_blood_id="", patient_nation_id="", patient_changwat="", patient_lastnamet="";
    private String patient_sex="", patient_birthday="";

    public void initial(){
        patient_id=""; patient_namet=""; patient_age=""; patient_prefix=""; patient_hn="";
        patient_blood_id=""; patient_nation_id=""; patient_changwat=""; patient_lastnamet="";
        patient_sex=""; patient_birthday="";
    }
    public String getPatientNamet(){
        return patient_namet;
    }
    public void setPatientNamet(String patient_namet){
        this.patient_namet = patient_namet;
    }

    public String getPatientLastNamet(){
        return patient_lastnamet;
    }
    public void setPatientLastNamet(String patient_lastnamet){
        this.patient_lastnamet = patient_lastnamet;
    }

    public String getPatientId(){
        return patient_id;
    }
    public void setPatientId(String patient_id){
        this.patient_id = patient_id;
    }

    public String getPatientAge(){
        return patient_age;
    }
    public void setPatientAge(String patient_age){
        this.patient_age = patient_age;
    }

    public String getPatientPrefix(){
        return patient_prefix;
    }
    public void setPatientPrefix(String patient_prefix){
        this.patient_prefix = patient_prefix;
    }

    public String getPatientHn(){
        return patient_hn;
    }
    public void setPatientHn(String patient_hn){
        this.patient_hn = patient_hn;
    }

    public String getPatientBloodId(){
        return patient_blood_id;
    }
    public void setPatientBloodId(String patient_blood_id){
        this.patient_blood_id = patient_blood_id;
    }

    public String getPatientNationId(){
        return patient_nation_id;
    }
    public void setPatientNationId(String patient_nation_id){
        this.patient_nation_id = patient_nation_id;
    }

    public String getPatientChangwat(){
        return patient_changwat;
    }
    public void setPatientChangwat(String patient_changwat){
        this.patient_changwat = patient_changwat;
    }

    public String getPatientSex(){
        return patient_sex;
    }
    public void setPatientSex(String patient_sex){
        this.patient_sex = patient_sex;
    }

    public String getPatientBirthday(){
        return patient_birthday;
    }
    public void setPatientBirthday(String patient_birthday){
        this.patient_birthday = patient_birthday;
    }

}
