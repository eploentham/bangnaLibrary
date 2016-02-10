/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author root
 */
@Entity
@Table(name = "t_visit_vital_sign", catalog = "front_bangna5", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"t_visit_vital_sign_id"})})
@NamedQueries({
    @NamedQuery(name = "TVisitVitalSign.findAll", query = "SELECT t FROM TVisitVitalSign t")})
public class TVisitVitalSign implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "t_visit_vital_sign_id", nullable = false, length = 255)
    private String tVisitVitalSignId="";
    @Column(name = "t_visit_id", length = 255)
    private String tVisitId="";
    @Column(name = "record_time", length = 255)
    private String recordTime="";
    @Column(name = "record_date", length = 255)
    private String recordDate="";
    @Column(name = "visit_vital_sign_height", length = 255)
    private String visitVitalSignHeight="";
    @Column(name = "visit_vital_sign_weight", length = 255)
    private String visitVitalSignWeight="";
    @Column(name = "visit_vital_sign_blood_presure", length = 255)
    private String visitVitalSignBloodPresure="";
    @Column(name = "visit_vital_sign_temperature", length = 255)
    private String visitVitalSignTemperature="";
    @Column(name = "visit_vital_sign_heart_rate", length = 255)
    private String visitVitalSignHeartRate="";
    @Column(name = "visit_vital_sign_respiratory_rate", length = 255)
    private String visitVitalSignRespiratoryRate="";
    @Column(name = "visit_vital_sign_general_symptom", length = 255)
    private String visitVitalSignGeneralSymptom="";
    @Column(name = "f_visit_nutrition_level_id", length = 255)
    private String fVisitNutritionLevelId="";
    @Column(name = "visit_vital_sign_staff_record", length = 255)
    private String visitVitalSignStaffRecord="";
    @Column(name = "visit_vital_sign_current_illness_symptom", length = 255)
    private String visitVitalSignCurrentIllnessSymptom="";
    @Column(name = "t_patient_id", length = 255)
    private String tPatientId="";
    @Column(name = "visit_vital_sign_bmi", length = 255)
    private String visitVitalSignBmi="";
    @Column(name = "visit_vital_sign_note", length = 4000)
    private String visitVitalSignNote="";
    @Column(name = "visit_vital_sign_check_date", length = 255)
    private String visitVitalSignCheckDate="";
    @Column(name = "visit_vital_sign_check_time", length = 255)
    private String visitVitalSignCheckTime="";
    @Column(name = "visit_vital_sign_staff_modify", length = 255)
    private String visitVitalSignStaffModify="";
    @Column(name = "visit_vital_sign_modify_date_time", length = 255)
    private String visitVitalSignModifyDateTime="";
    @Column(name = "visit_vital_sign_active", length = 255)
    private String visitVitalSignActive="";
    @Column(name = "visit_waistline", length = 255)
    private String visitWaistline="";
    @Column(name = "visit_dtx", length = 255)
    private String visitDtx="";

    public TVisitVitalSign() {
    }
    public void initial(){
        tVisitVitalSignId="";
        tVisitId="";
        recordTime="";
        recordDate="";
        visitVitalSignHeight="";
        visitVitalSignWeight="";
        visitVitalSignBloodPresure="";
        visitVitalSignTemperature="";
        visitVitalSignHeartRate="";
        visitVitalSignRespiratoryRate="";
        visitVitalSignGeneralSymptom="";
        fVisitNutritionLevelId="";
        visitVitalSignStaffRecord="";
        visitVitalSignCurrentIllnessSymptom="";
        tPatientId="";
        visitVitalSignBmi="";
        visitVitalSignNote="";
        visitVitalSignCheckDate="";
        visitVitalSignCheckTime="";
        visitVitalSignStaffModify="";
        visitVitalSignModifyDateTime="";
        visitVitalSignActive="";
        visitWaistline="";
        visitDtx="";
    }
    public String getTVisitVitalSign() {
        return "t_visit_vital_sign";
    }
      public String getFTVisitVitalSignId() {
        return "t_visit_vital_sign_id";
      }
      public String getFTVisitId() {
        return "t_visit_id";
      }
      public String getFRecordTime() {
        return "record_time";
      }
      public String getFRecordDate() {
        return "record_date";
      }
      public String getFVisitVitalSignHeight() {
        return "visit_vital_sign_height";
      }
      public String getFVisitVitalSignWeight() {
        return "visit_vital_sign_weight";
      }
      public String getFVisitVitalSignBloodPresure() {
        return "visit_vital_sign_blood_presure";
      }
      public String getFVisitVitalSignTemperature() {
        return "visit_vital_sign_temperature";
      }
      public String getFVisitVitalSignHeartRate() {
        return "visit_vital_sign_heart_rate";
      }
      public String getFVisitVitalSignRespiratoryRate() {
        return "visit_vital_sign_respiratory_rate";
      }
      public String getFVisitVitalSignGeneralSymptom() {
        return "visit_vital_sign_general_symptom";
      }
      public String getFFVisitNutritionLevelId() {
        return "f_visit_nutrition_level_id";
      }
      public String getFVisitVitalSignStaffRecord() {
        return "visit_vital_sign_staff_record";
      }
      public String getFVisitVitalSignCurrentIllnessSymptom() {
        return "visit_vital_sign_current_illness_symptom";
      }
      public String getFTPatientId() {
        return "t_patient_id";
      }
      public String getFVisitVitalSignBmi() {
        return "visit_vital_sign_bmi";
      }
      public String getFVisitVitalSignNote() {
        return "visit_vital_sign_note";
      }
      public String getFVisitVitalSignCheckDate() {
        return "visit_vital_sign_check_date";
      }
      public String getFVisitVitalSignCheckTime() {
        return "visit_vital_sign_check_time";
      }
      public String getFVisitVitalSignStaffModify() {
        return "visit_vital_sign_staff_modify";
      }
      public String getFVisitVitalSignModifyDateTime() {
        return "visit_vital_sign_modify_date_time";
      }
      public String getFVisitVitalSignActive() {
        return "visit_vital_sign_active";
      }
      public String getFVisitWaistline() {
        return "visit_waistline";
      }
      public String getFVisitDtx() {
        return "visit_dtx";
      }

    public TVisitVitalSign(String tVisitVitalSignId) {
        this.tVisitVitalSignId = tVisitVitalSignId;
    }

    public String getTVisitVitalSignId() {
        return tVisitVitalSignId;
    }

    public void setTVisitVitalSignId(String tVisitVitalSignId) {
        this.tVisitVitalSignId = tVisitVitalSignId;
    }

    public String getTVisitId() {
        return tVisitId;
    }

    public void setTVisitId(String tVisitId) {
        this.tVisitId = tVisitId;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getVisitVitalSignHeight() {
        return visitVitalSignHeight;
    }

    public void setVisitVitalSignHeight(String visitVitalSignHeight) {
        this.visitVitalSignHeight = visitVitalSignHeight;
    }

    public String getVisitVitalSignWeight() {
        return visitVitalSignWeight;
    }

    public void setVisitVitalSignWeight(String visitVitalSignWeight) {
        this.visitVitalSignWeight = visitVitalSignWeight;
    }

    public String getVisitVitalSignBloodPresure() {
        return visitVitalSignBloodPresure;
    }

    public void setVisitVitalSignBloodPresure(String visitVitalSignBloodPresure) {
        this.visitVitalSignBloodPresure = visitVitalSignBloodPresure;
    }

    public String getVisitVitalSignTemperature() {
        return visitVitalSignTemperature;
    }

    public void setVisitVitalSignTemperature(String visitVitalSignTemperature) {
        this.visitVitalSignTemperature = visitVitalSignTemperature;
    }

    public String getVisitVitalSignHeartRate() {
        return visitVitalSignHeartRate;
    }

    public void setVisitVitalSignHeartRate(String visitVitalSignHeartRate) {
        this.visitVitalSignHeartRate = visitVitalSignHeartRate;
    }

    public String getVisitVitalSignRespiratoryRate() {
        return visitVitalSignRespiratoryRate;
    }

    public void setVisitVitalSignRespiratoryRate(String visitVitalSignRespiratoryRate) {
        this.visitVitalSignRespiratoryRate = visitVitalSignRespiratoryRate;
    }

    public String getVisitVitalSignGeneralSymptom() {
        return visitVitalSignGeneralSymptom;
    }

    public void setVisitVitalSignGeneralSymptom(String visitVitalSignGeneralSymptom) {
        this.visitVitalSignGeneralSymptom = visitVitalSignGeneralSymptom;
    }

    public String getFVisitNutritionLevelId() {
        return fVisitNutritionLevelId;
    }

    public void setFVisitNutritionLevelId(String fVisitNutritionLevelId) {
        this.fVisitNutritionLevelId = fVisitNutritionLevelId;
    }

    public String getVisitVitalSignStaffRecord() {
        return visitVitalSignStaffRecord;
    }

    public void setVisitVitalSignStaffRecord(String visitVitalSignStaffRecord) {
        this.visitVitalSignStaffRecord = visitVitalSignStaffRecord;
    }

    public String getVisitVitalSignCurrentIllnessSymptom() {
        return visitVitalSignCurrentIllnessSymptom;
    }

    public void setVisitVitalSignCurrentIllnessSymptom(String visitVitalSignCurrentIllnessSymptom) {
        this.visitVitalSignCurrentIllnessSymptom = visitVitalSignCurrentIllnessSymptom;
    }

    public String getTPatientId() {
        return tPatientId;
    }

    public void setTPatientId(String tPatientId) {
        this.tPatientId = tPatientId;
    }

    public String getVisitVitalSignBmi() {
        return visitVitalSignBmi;
    }

    public void setVisitVitalSignBmi(String visitVitalSignBmi) {
        this.visitVitalSignBmi = visitVitalSignBmi;
    }

    public String getVisitVitalSignNote() {
        return visitVitalSignNote;
    }

    public void setVisitVitalSignNote(String visitVitalSignNote) {
        this.visitVitalSignNote = visitVitalSignNote;
    }

    public String getVisitVitalSignCheckDate() {
        return visitVitalSignCheckDate;
    }

    public void setVisitVitalSignCheckDate(String visitVitalSignCheckDate) {
        this.visitVitalSignCheckDate = visitVitalSignCheckDate;
    }

    public String getVisitVitalSignCheckTime() {
        return visitVitalSignCheckTime;
    }

    public void setVisitVitalSignCheckTime(String visitVitalSignCheckTime) {
        this.visitVitalSignCheckTime = visitVitalSignCheckTime;
    }

    public String getVisitVitalSignStaffModify() {
        return visitVitalSignStaffModify;
    }

    public void setVisitVitalSignStaffModify(String visitVitalSignStaffModify) {
        this.visitVitalSignStaffModify = visitVitalSignStaffModify;
    }

    public String getVisitVitalSignModifyDateTime() {
        return visitVitalSignModifyDateTime;
    }

    public void setVisitVitalSignModifyDateTime(String visitVitalSignModifyDateTime) {
        this.visitVitalSignModifyDateTime = visitVitalSignModifyDateTime;
    }

    public String getVisitVitalSignActive() {
        return visitVitalSignActive;
    }

    public void setVisitVitalSignActive(String visitVitalSignActive) {
        this.visitVitalSignActive = visitVitalSignActive;
    }

    public String getVisitWaistline() {
        return visitWaistline;
    }

    public void setVisitWaistline(String visitWaistline) {
        this.visitWaistline = visitWaistline;
    }

    public String getVisitDtx() {
        return visitDtx;
    }

    public void setVisitDtx(String visitDtx) {
        this.visitDtx = visitDtx;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tVisitVitalSignId != null ? tVisitVitalSignId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TVisitVitalSign)) {
            return false;
        }
        TVisitVitalSign other = (TVisitVitalSign) object;
        if ((this.tVisitVitalSignId == null && other.tVisitVitalSignId != null) || (this.tVisitVitalSignId != null && !this.tVisitVitalSignId.equals(other.tVisitVitalSignId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.TVisitVitalSign[tVisitVitalSignId=" + tVisitVitalSignId + "]";
    }

}
