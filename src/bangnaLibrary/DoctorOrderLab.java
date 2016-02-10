package bangnaLibrary;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author pop
 */
public class DoctorOrderLab extends Lab{
    private String doctorId="", patientId="", orderDate="";
    public void initial(){
        doctorId=""; patientId=""; orderDate="";
    }
    public String getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String visitDate) {
        this.orderDate = visitDate;
    }

}
