/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import com.bangna.usecase.connection.Persistent;

/**
 *
 * @author root
 */
public class BackTInjury extends Persistent{
    public String injuryId="";
    public String injuryNumber="";
    public String visitDate="";
    public String visitHn="";
    public String injuryActive="";
    public String injuryRemark="";
    public String branchId="";

    public BackTInjury() {
    }
    public void initial(){
        injuryId="";
        injuryNumber="";
        visitDate="";
        visitHn="";
        injuryActive="";
        injuryRemark="";
        branchId="";
    }
    public String getBackTInjury() {
        return "back_t_injury";
    }

      public String getFInjuryNumber() {
        return "injury_number";
      }
      public String getFInjuryId() {
        return "injury_id";
      }
      public String getFVisitDate() {
        return "visit_date";
      }
      public String getFVisitHn() {
        return "visit_hn";
      }
      public String getFInjuryActive() {
        return "injury_active";
      }
      public String getFInjuryRemark() {
        return "injury_remark";
      }
      public String getFBranchId() {
        return "branch_id";
      }

    public BackTInjury(String injuryId) {
        this.injuryId = injuryId;
    }

    public String getInjuryId() {
        return injuryId;
    }

    public void setInjuryId(String injuryId) {
        this.injuryId = injuryId;
    }

    public String getInjuryNumber() {
        return injuryNumber;
    }

    public void setInjuryNumber(String injuryNumber) {
        this.injuryNumber = injuryNumber;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitHn() {
        return visitHn;
    }

    public void setVisitHn(String visitHn) {
        this.visitHn = visitHn;
    }

    public String getInjuryActive() {
        return injuryActive;
    }

    public void setInjuryActive(String injuryActive) {
        this.injuryActive = injuryActive;
    }

    public String getInjuryRemark() {
        return injuryRemark;
    }

    public void setInjuryRemark(String injuryRemark) {
        this.injuryRemark = injuryRemark;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (injuryId != null ? injuryId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof BackTInjury)) {
//            return false;
//        }
//        BackTInjury other = (BackTInjury) object;
//        if ((this.injuryId == null && other.injuryId != null) || (this.injuryId != null && !this.injuryId.equals(other.injuryId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "bangnaLibrary.BackTInjury[injuryId=" + injuryId + "]";
//    }

}
