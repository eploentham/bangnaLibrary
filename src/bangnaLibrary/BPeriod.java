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
public class BPeriod extends Persistent{
    public String periodId="";
    public String periodNamet="";
    public String branchId="";
    public String fVisitTypeId="";
    public String periodStartTime="";
    public String periodEndTime="";
    public String periodActive="";
    public Double cashInDrawer=0.0;

    public BPeriod() {
    }
    public void initial(){
        periodId="";
        periodNamet="";
        branchId="";
        fVisitTypeId="";
        periodStartTime="";
        periodEndTime="";
        periodActive="";
        cashInDrawer=0.0;
    }

    public String getBPeriod() {
        return "b_period";
    }
    public String getFBPeriodId() {
        return "period_id";
    }
    public String getFBPeriodNamet() {
        return "period_namet";
    }
    public String getFBranchId() {
        return "branch_id";
    }
    public String getFFVisitTypeId() {
        return "f_visit_type_id";
    }
    public String getFPeriodStartTime() {
        return "period_start_time";
    }
    public String getFPeriodEndTime() {
        return "period_end_time";
    }
    public String getFPeriodActive() {
        return "period_active";
    }
    public String getFCashInDrawer() {
        return "cash_in_drawer";
    }


    public BPeriod(String periodId) {
        this.periodId = periodId;
    }

    public String getPeriodId() {
        return periodId;
    }

    public void setPeriodId(String periodId) {
        this.periodId = periodId;
    }

    public String getPeriodNamet() {
        return periodNamet;
    }

    public void setPeriodNamet(String periodNamet) {
        this.periodNamet = periodNamet;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getFVisitTypeId() {
        return fVisitTypeId;
    }

    public void setFVisitTypeId(String fVisitTypeId) {
        this.fVisitTypeId = fVisitTypeId;
    }
    public String getPeriodStartTime() {
        return periodStartTime;
    }

    public void setPeriodStartTime(String periodStartTime) {
        this.periodStartTime = periodStartTime;
    }
    public String getPeriodEndTime() {
        return periodEndTime;
    }

    public void setPeriodEndTime(String periodEndTime) {
        this.periodEndTime = periodEndTime;
    }
    public String getPeriodActive() {
        return periodActive;
    }
    public void setPeriodActive(String periodActive) {
        this.periodActive = periodActive;
    }

    public Double getCashIndrawer() {
        return cashInDrawer;
    }
    public void setCashIndrawer(Double cashInDrawer) {
        this.cashInDrawer = cashInDrawer;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.BPeriod[periodId=" + periodId + "]";
    }

}
