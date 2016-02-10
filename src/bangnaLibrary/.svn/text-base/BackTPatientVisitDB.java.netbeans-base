package bangnaLibrary;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BackTPatientVisitDB {
    public BackTPatientVisit bpv = new BackTPatientVisit();
    public BackTPatientVisitItem bpvi = new BackTPatientVisitItem();
    public BBranch branch = new BBranch();
    public Config1 config1;
    public BItem b_item = new BItem();

    public BackTPatientImport bpi = new BackTPatientImport();
    private BackTPatientVisitGroupPaidNamet bpv_gp = new BackTPatientVisitGroupPaidNamet();
    private BackBTransfer b_transfer = new BackBTransfer();
    private BServicePoint service_point = new BServicePoint();
    private StringBuilder txt = new StringBuilder();
    private StringBuilder sql = new StringBuilder();
    final private String idtableItem = "143";
    final private String idtable = "140";

    public BackTPatientVisitDB(){
        config1 = new Config1();
    }
    public BackTPatientVisitDB(Config1 cf){
        config1 = cf;
    }
    public String getMaxRowBackTPatientVisit(Connection conn) {
        String sql = ""; String max = "";
        try {
          Statement st = conn.createStatement();
          sql = "Select max(" + bpv.getFPatientVisitId() + ") as cnt From " + bpv.getBackTPatientVisit();
          ResultSet rs = st.executeQuery(sql);
          while (rs.next()) {
            max = rs.getString("cnt");
          }
          rs.close();
          if ((max != null) && (!max.equals("")))
            max = String.valueOf(Integer.parseInt(max) + 1);
          else
            max = "1400000001";
        }catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowBackTPatientVisitItem(Connection conn) {
        String sql = ""; String max = "";
        try {
            Statement st = conn.createStatement();
            sql = "Select max(" + bpvi.getFPatientVisitItemId() + ") as cnt " + "From " + bpvi.getBackTPatientVisitItem();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))
                max = String.valueOf(Integer.parseInt(max) + 1);
            else
                max = "1430000001";
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public BackTPatientVisit getBackTPatientVisitByPK(String patient_visit_id, String flag){
        try {
            Connection conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            bpv = getBackTPatientVisitByPK(null, stbangna, patient_visit_id, flag);
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpv;
    }
    public BackTPatientVisit getBackTPatientVisitByPK(Connection conn, Statement stbangna, String patient_visit_id, String flag) {
        String sql = "";
        try {
        //        bpv.initial();
            if (flag.equals("visit_vn")) {
                sql = "Select * From " + bpv.getBackTPatientVisit() + " "
                        + "Where " + bpv.getFVisitVn() + "='" + patient_visit_id + "' and " + bpv.getFPatientVisitActive() + "='1'";
            }else if(flag.equals("visit_id")){
                sql = "Select * From " + bpv.getBackTPatientVisit() + " "
                        + "Where " + bpv.getFTVisitId() + "='" + patient_visit_id + "' and " + bpv.getFPatientVisitActive() + "='1'";
            }else if(flag.equals("visit_payment_id")){
                sql = "Select * From " + bpv.getBackTPatientVisit() + " "
                        + "Where " + bpv.getFTVisitPaymentId() + "='" + patient_visit_id + "' and " + bpv.getFPatientVisitActive() + "='1'";
            }else{
                sql = "Select * From " + bpv.getBackTPatientVisit() + " "
                        + "Where " + bpv.getFPatientVisitId() + "='" + patient_visit_id + "'";
            }
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                bpv = new BackTPatientVisit();
                bpv.setBServicePointId(config1.StringNull(rs.getString(bpv.getFBServicePointId())));
                bpv.setBVisitClinicId(config1.StringNull(rs.getString(bpv.getFBVisitClinicId())));
                bpv.setVisitClaimId(config1.StringNull(rs.getString(bpv.getFVisitClaimId())));
                bpv.setVisitPaidId(config1.StringNull(rs.getString(bpv.getFVisitPaidId())));
                bpv.setPatientFullnamet(config1.StringNull(rs.getString(bpv.getFPatientFullnamet())));

                bpv.setPatientVisitId(config1.StringNull(rs.getString(bpv.getFPatientVisitId())));
                bpv.setTPatientId(config1.StringNull(rs.getString(bpv.getFTPatientId())));
                bpv.setVisitBeginVisitTime(config1.StringNull(rs.getString(bpv.getFVisitBeginVisitTime())));
                bpv.setVisitDate(config1.StringNull(rs.getString(bpv.getFVisitDate())));
                bpv.setVisitDiagnosisNotice(config1.StringNull(rs.getString(bpv.getFVisitDiagnosisNotice())));

                bpv.setVisitFinancialDischargeTime(config1.StringNull(rs.getString(bpv.getFVisitFinancialDischargeTime())));
                bpv.setVisitFirstVisit(config1.StringNull(rs.getString(bpv.getFVisitFirstVisit())));
                bpv.setVisitHn(config1.StringNull(rs.getString(bpv.getFVisitHn())));
                bpv.setVisitHospitalService(config1.StringNull(rs.getString(bpv.getFVisitHospitalService())));
                bpv.setVisitNotice(config1.StringNull(rs.getString(bpv.getFVisitNotice())));

                bpv.setVisitPatientAge(config1.StringNull(rs.getString(bpv.getFVisitPatientAge())));
                bpv.setVisitPatientSelfDoctor(config1.StringNull(rs.getString(bpv.getFVisitPatientSelfDoctor())));
                bpv.setVisitVn(config1.StringNull(rs.getString(bpv.getFVisitVn())));
                bpv.setVisitClaimNamet(config1.StringNull(rs.getString(bpv.getFVisitClaimNamet())));
                bpv.setVisitPaidNamet(config1.StringNull(rs.getString(bpv.getFVisitPaidNamet())));

                bpv.setDepartmentNamet(config1.StringNull(rs.getString(bpv.getFDepartmentNamet())));
                bpv.setDoctorNamet(config1.StringNull(rs.getString(bpv.getFDoctorNamet())));
                bpv.setPatientImportId(config1.StringNull(rs.getString(bpv.getFPatientImportId())));
                bpv.setBranchId(config1.StringNull(rs.getString(bpv.getFBranchId())));
                bpv.setSysStatus(config1.StringNull(rs.getString(bpv.getFSysStatus())));

                bpv.setVisitPaid(Double.parseDouble(rs.getString(bpv.getFVisitPaid())));
                bpv.setVisitTotal(Double.parseDouble(rs.getString(bpv.getFVisitTotal())));
                bpv.setVisitDiscount(Double.parseDouble(rs.getString(bpv.getFVisitDiscount())));
                bpv.setEditStatus(config1.StringNull(rs.getString(bpv.getFEditStatus())));
                bpv.setVisitContactId(config1.StringNull(rs.getString(bpv.getFVisitContactId())));

                bpv.setVisitContactNamet(config1.StringNull(rs.getString(bpv.getFVisitContactNamet())));
                bpv.setPatientVisitActive(config1.StringNull(rs.getString(bpv.getFPatientVisitActive())));
                bpv.setFVisitTypeId(config1.StringNull(rs.getString(bpv.getFFVisitTypeId())));
                bpv.setContractPlansPttype(config1.StringNull(rs.getString(bpv.getFContractPlansPttype())));
                bpv.setReceiveNumber(config1.StringNull(rs.getString(bpv.getFReceiveNumber())));

                bpv.setInvoiceNumber(config1.StringNull(rs.getString(bpv.getFInvoiceNumber())));
                bpv.setContractPayerNumber(config1.StringNull(rs.getString(bpv.getFContractPayerNumber())));
                bpv.setItemStatusDoctor(config1.StringNull(rs.getString(bpv.getFItemStatusDoctor())));
                bpv.setVisitContactJoinId(config1.StringNull(rs.getString(bpv.getFVisitContactJoinId())));
                bpv.setVisitContactJoinNamet(config1.StringNull(rs.getString(bpv.getFVisitContactJoinNamet())));

                bpv.setCloseDayDate(config1.StringNull(rs.getString(bpv.getFCloseDayDate())));
                bpv.setTVisitPaymentId(config1.StringNull(rs.getString(bpv.getFTVisitPaymentId())));
                bpv.setSysStatusDoctor(config1.StringNull(rs.getString(bpv.getFSysStatusDoctor())));
                bpv.setBillingPatientShare(Double.parseDouble(rs.getString(bpv.getFBillingPatientShare())));
                bpv.setBillingPayerShare(Double.parseDouble(rs.getString(bpv.getFBillingPayerShare())));
                
                
                bpv.statusUnbilling = config1.StringNull(rs.getString(bpv.getFStatusUnbilling()));
                bpv.tVisitId = config1.StringNull(rs.getString(bpv.getFTVisitId()));
            }
            rs.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpv;
    }
    public BackTPatientVisitItem getBackTPatientVisitItemByPK(Connection conn, Statement stbangna, String bpv_i_id) {
        String sql = "";
        try {
        //        bpvi.initial();
          sql = "Select * From " + bpvi.getBackTPatientVisitItem() + " " + "Where " + bpvi.getFPatientVisitItemId() + "='" + bpv_i_id + "'";
          ResultSet rs = stbangna.executeQuery(sql);
          while (rs.next()){
              bpvi = new BackTPatientVisitItem();
            bpvi.setBItemBillingSubgroupId(rs.getString(bpvi.getFBItemBillingSubgroupId()));
            bpvi.setBItemId(rs.getString(bpvi.getFBItemId()));
            bpvi.setBillingInvoiceItemActive(rs.getString(bpvi.getFBillingInvoiceItemActive()));
            bpvi.setBillingInvoiceItemTotal(Double.valueOf(Double.parseDouble(rs.getString(bpvi.getFBillingInvoiceItemTotal()))));
            bpvi.setBillingInvoiceNumber(rs.getString(bpvi.getFBillingInvoiceNumber()));

            bpvi.setClaimId(rs.getString(bpvi.getFClaimId()));
            bpvi.setClaimNamet(rs.getString(bpvi.getFClaimNamet()));
            bpvi.setDepartmentNamet(rs.getString(bpvi.getFDepartmentNamet()));
            bpvi.setPatientVisitBillingItemId(rs.getString(bpvi.getFPatientVisitItemId()));
            bpvi.setPatientVisitId(rs.getString(bpvi.getFPatientVisitId()));

            bpvi.setTBillingId(rs.getString(bpvi.getFTBillingId()));
            bpvi.setTBillingInvoiceDateTime(rs.getString(bpvi.getFTBillingInvoiceDateTime()));
            bpvi.setTBillingInvoiceItemId(rs.getString(bpvi.getFTBillingInvoiceItemId()));
            bpvi.setTBillingInvoiceItemNamet(rs.getString(bpvi.getFTBillingInvoiceItemNamet()));
            bpvi.setTBillingInvoiceTime(rs.getString(bpvi.getFTBillingInvoiceTime()));

            bpvi.setTOrderItemId(rs.getString(bpvi.getFTOrderItemId()));
            bpvi.setTPatientId(rs.getString(bpvi.getFTPatientId()));
            bpvi.setTPaymentId(rs.getString(bpvi.getFTPaymentId()));
            bpvi.setVisitId(rs.getString(bpvi.getFVisitId()));
            bpvi.setVisitPatientSelfDoctor(rs.getString(bpvi.getFVisitPatientSeftDoctor()));

            bpvi.setVisitVn(rs.getString(bpvi.getFVisitVn()));
            bpvi.setDepartmentId(rs.getString(bpvi.getFDepartmentId()));
            bpvi.setVisitHn(rs.getString(bpvi.getFVisitHn()));
            bpvi.setBranchId(config1.StringNull(rs.getString(bpvi.getFBranchId())));
            bpvi.setSysStatus(config1.StringNull(rs.getString(bpvi.getFSysStatus())));

            bpvi.setItemDiscount(Double.valueOf(Double.parseDouble(rs.getString(bpvi.getFItemDiscount()))));
            bpvi.setItemPaid(Double.valueOf(Double.parseDouble(rs.getString(bpvi.getFItemPaid()))));
            bpvi.setItemTotal(Double.valueOf(Double.parseDouble(rs.getString(bpvi.getFItemTotal()))));
            bpvi.setEditStatus(config1.StringNull(rs.getString(bpvi.getFEditStatus())));
            bpvi.setItemStatusDoctor(config1.StringNull(rs.getString(bpvi.getFItemStatusDoctor())));

            bpvi.setDoctorId(config1.StringNull(rs.getString(bpvi.getFDoctorId())));
            bpvi.setFItemGroupId(config1.StringNull(rs.getString(bpvi.getFFItemGroupId())));
            bpvi.orderOperationNo  = config1.StringNull(rs.getString(bpvi.getFOrderOperationNo()));
            bpvi.orderOperationStatus = config1.StringNull(rs.getString(bpvi.getFOrderOperationStatus()));
            bpvi.statusRate = config1.StringNull(rs.getString(bpvi.getFStatusRate()));

            bpvi.orderStartTime = config1.StringNull(rs.getString(bpvi.getFOrderStartTime()));
            bpvi.orderEndTime = config1.StringNull(rs.getString(bpvi.getFOrderEndTime()));
            bpvi.orderDateTime = config1.StringNull(rs.getString(bpvi.getFOrderDateTime()));
            bpvi.statusNoCloseDayImport = config1.StringNull(rs.getString(bpvi.getFStatusNoCloseDayImport()));
            bpvi.orderHome = config1.StringNull(rs.getString(bpvi.getFOrderHome()));
          }
          rs.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bpvi;
    }
  public Vector getBackTPatientVisit(String branch_id, String patient_visit_id, String where, String flag){
    String sql = ""; String whereSearch = "";
    Vector v_patient_visit = new Vector();
    try {
      Connection conn = config1.getConnectionBangna();
      Statement stbangna = conn.createStatement();
      if (flag.equals("patient_import")) {
        sql = "Select * From " + bpv.getBackTPatientVisit() + " " 
                + "Where " + bpv.getFPatientImportId() + "='" + patient_visit_id + "' "
                + "Order By " + bpv.getFVisitDate() + " ," + bpv.getFVisitBeginVisitTime();
      }else if (flag.equals("subsystem_import")) {
        sql = "Select bpv.* "
                + "From " + bpv.getBackTPatientVisit() + " as bpv "
                + "left join " + b_transfer.getBackBTransfer() + " as bt "
                + "on bpv." + bpv.getFContractPayerNumber() + "=bt." + b_transfer.getFPaidId() + " " + "and "
                + "bpv." + bpv.getFBranchId() + " = bt." + b_transfer.getFBranchId() + " "
                + "Where bpv." + bpv.getFPatientImportId() + "='" + patient_visit_id + "' and "
                + "bt." + b_transfer.getFBDepartmentId() + "='" + where + "' and "
                + "bpv." + bpv.getFBranchId() + " = '" + branch_id + "' and " + bpv.getFSysStatus() + "='D' "
                + "Order By bpv." + bpv.getFVisitDate() + " ,bpv." + bpv.getFVisitBeginVisitTime();
      }else if (flag.equals("reimport_item")) {
        sql = "Select bpv.* From " 
                + bpv.getBackTPatientVisit() + " as bpv left join " + b_transfer.getBackBTransfer() + " as bt on bpv."
                + bpv.getFContractPayerNumber() + "=bt." + b_transfer.getFPaidId() + " " + "and bpv."
                + bpv.getFBranchId() + " = bt." + b_transfer.getFBranchId() + " "
                + "Where bpv." + bpv.getFPatientVisitId() + "='" + patient_visit_id + "' and bpv."
                + bpv.getFBranchId() + " = '" + branch_id + "' "//and " + bpv.getFSysStatus() + "='D' "
                + "Order By bpv." + bpv.getFVisitDate() + " ,bpv." + bpv.getFVisitBeginVisitTime();
      }else if (flag.equals("subsystem_import_d")) {
        if (where.equals("14503")) {
          sql = "Select bpv.* "
                  + "From " + bpv.getBackTPatientVisit() + " as bpv "
                  + "left join " + b_transfer.getBackBTransfer() + " as bt "
                  + "on bpv." + bpv.getFVisitPaidId() + "=bt." + b_transfer.getFPaidId() + " " + "and "
                  + "bpv." + bpv.getFBranchId() + " = bt." + b_transfer.getFBranchId() + " "
                  + "Where bpv." + bpv.getFPatientImportId() + "='" + patient_visit_id + "' and "
                  + "bpv." + bpv.getFBranchId() + " = '" + branch_id + "' and " + bpv.getFSysStatus() + "='D' "
                  + "Order By bpv." + bpv.getFVisitDate() + " ,bpv." + bpv.getFVisitBeginVisitTime();
        }else{
          sql = "Select bpv.* "
                  + "From " + bpv.getBackTPatientVisit() + " as bpv "
                  + "left join " + b_transfer.getBackBTransfer() + " as bt on "
                  + "bpv." + bpv.getFContractPayerNumber() + "=bt." + b_transfer.getFPaidId() + " " + "and "
                  + "bpv." + bpv.getFBranchId() + " = bt." + b_transfer.getFBranchId() + " "
                  + "Where bpv." + bpv.getFPatientImportId() + "='" + patient_visit_id + "' and "
                  + "bt." + b_transfer.getFBDepartmentId() + "='" + where + "' and "
                  + "bpv." + bpv.getFBranchId() + " = '" + branch_id + "' and " + bpv.getFSysStatus() + "='D' "
                  + "Order By bpv." + bpv.getFVisitDate() + " ,bpv." + bpv.getFVisitBeginVisitTime();
        }
      }else if (flag.equals("subsystem_import_y")) {
        if (where.equals("14503")) {
          sql = "Select bpv.* "
                  + "From " + bpv.getBackTPatientVisit() + " as bpv "
                  + "left join " + b_transfer.getBackBTransfer() + " as bt on "
                  + "bpv." + bpv.getFVisitPaidId() + "=bt." + b_transfer.getFPaidId() + " " + "and "
                  + "bpv." + bpv.getFBranchId() + " = bt." + b_transfer.getFBranchId() + " "
                  + "Where bpv." + bpv.getFPatientImportId() + "='" + patient_visit_id + "' and "
                  + "bpv." + bpv.getFBranchId() + " = '" + branch_id + "' and " + bpv.getFSysStatus() + "='D' "
                  + "Order By bpv." + bpv.getFVisitDate() + " ,bpv." + bpv.getFVisitBeginVisitTime();
        }else{
          sql = "Select bpv.* "
                  + "From " + bpv.getBackTPatientVisit() + " as bpv "
                  + "left join " + b_transfer.getBackBTransfer() + " as bt "
                  + "on bpv." + bpv.getFContractPayerNumber() + "=bt." + b_transfer.getFPaidId() + " " + "and "
                  + "bpv." + bpv.getFBranchId() + " = bt." + b_transfer.getFBranchId() + " "
                  + "Where bpv." + bpv.getFPatientImportId() + "='" + patient_visit_id + "' and "
                  + "bt." + b_transfer.getFBDepartmentId() + "='" + where + "' and "
                  + "bpv." + bpv.getFBranchId() + " = '" + branch_id + "' and " + bpv.getFSysStatus() + "='Y' "
                  + "Order By bpv." + bpv.getFVisitDate() + " ,bpv." + bpv.getFVisitBeginVisitTime();
        }
      }else if (flag.equals("paid")){
        sql = "Select * From " + bpv.getBackTPatientVisit() + " "
                + "Where " + bpv.getFPatientImportId() + "='" + patient_visit_id + "' and "
                + bpv.getFVisitPaidId() + " = '" + where + "' and " + bpv.getFPatientVisitActive() + "='1' "
                + "Order By " + bpv.getFVisitDate() + " ," + bpv.getFVisitBeginVisitTime();
      }else if (flag.equals("check_contact")){
        sql = "Select * From " + bpv.getBackTPatientVisit() + " " 
                + "Where " + bpv.getFPatientImportId() + "='" + patient_visit_id + "' and " + bpv.getFVisitContactId() + " = '' "
                + "Order By " + bpv.getFVisitDate() + " ," + bpv.getFVisitBeginVisitTime();
      }else if (flag.equals("department")) {
        sql = "Select * From " + bpv.getBackTPatientVisit() + " "
                + "Where " + bpv.getFPatientImportId() + "='" + patient_visit_id + "' and "
                + bpv.getFBServicePointId() + " = '" + where + "' "
                + "Order By " + bpv.getFVisitDate() + " ," + bpv.getFVisitBeginVisitTime();
      }else if (flag.equals("clinic")) {
        sql = "Select * From " + bpv.getBackTPatientVisit() + " "
                + "Where " + bpv.getFPatientImportId() + "='" + patient_visit_id + "' and "
                + bpv.getFBVisitClinicId() + " = '" + where + "' "
                + "Order By " + bpv.getFVisitDate() + " ," + bpv.getFVisitBeginVisitTime();
      }else if (flag.equals("visit_vn")) {
        sql = "Select * From " + bpv.getBackTPatientVisit() + " "
                + "Where " + bpv.getFVisitVn() + "='" + patient_visit_id + "' ";
      }else if (flag.equals("visit_hn")) {
        sql = "Select * From " + bpv.getBackTPatientVisit() + " "
                + "Where " + bpv.getFVisitHn() + "='" + patient_visit_id + "' and "+bpv.getFPatientVisitActive()+"='1' "
                + "Order By "+bpv.getFCloseDayDate()+","+bpv.getFVisitVn();
      }else if (flag.equals("close_day")) {
          if(!where.equals("")){
              whereSearch = " and "+ bpv.getFSysStatus() + "='" + where + "' ";
          }
        sql = "Select * From " + bpv.getBackTPatientVisit() + " " 
                + "Where " + bpv.getFCloseDayDate() + "='" + patient_visit_id + "' "
                + whereSearch+" and " + bpv.getFBranchId() + "='" + branch_id + "' and "+bpv.getFPatientVisitActive()+"='1' "
                + "Order By "+bpv.getFVisitDate()+", "+bpv.getFVisitBeginVisitTime();
      }else if (flag.equals("close_day_paidid")) {
          String dateStart="", closedaySearch="", dateEnd="", fVisitTypeId="", paidId="", fVisitTypeSearch="";
          if(patient_visit_id.length()==21){
              String[] aaa = patient_visit_id.split("\\^");
              dateStart = aaa[0];
              dateEnd = aaa[1];
          }else{
              dateStart = patient_visit_id;
              dateEnd = patient_visit_id;
          }
          if(where.indexOf("^")>=0){
              String[] aaa = where.split("\\^");
              paidId = aaa[0];
              fVisitTypeId = aaa[1];
              if(fVisitTypeId.equals("2")){
                  fVisitTypeId = "'0','1'";
              }else{
                  fVisitTypeId = "'"+fVisitTypeId+"'";
              }
              fVisitTypeSearch = " and "+bpv.getFFVisitTypeId()+" in ("+fVisitTypeId+") ";
          }else{
              paidId = where;
          }
          closedaySearch = bpv.getFCloseDayDate()+" >= '"+dateStart+"' and "+bpv.getFCloseDayDate()+"<='"+dateEnd +"' ";
          if(!where.equals("")){
              whereSearch = " and "+ bpv.getFVisitPaidId() + "='" + paidId + "' ";
          }
        sql = "Select * From " + bpv.getBackTPatientVisit() + " " 
                + "Where " + closedaySearch + whereSearch+" and "
                + bpv.getFBranchId() + "='" + branch_id + "' and "+bpv.getFPatientVisitActive()+"='1' "+fVisitTypeSearch
                + "Order By "+bpv.getFVisitDate()+", "+bpv.getFVisitBeginVisitTime();
      }else{
        sql = "Select * From " + bpv.getBackTPatientVisit() + " "
                + "Where " + bpv.getFPatientVisitId() + "='" + patient_visit_id + "'";
      }
      ResultSet rs = stbangna.executeQuery(sql);
      while (rs.next()) {
        bpv = new BackTPatientVisit();
        bpv.setBServicePointId(config1.StringNull(rs.getString(bpv.getFBServicePointId())));
        bpv.setBVisitClinicId(config1.StringNull(rs.getString(bpv.getFBVisitClinicId())));
        bpv.setVisitClaimId(config1.StringNull(rs.getString(bpv.getFVisitClaimId())));
        bpv.setVisitPaidId(config1.StringNull(rs.getString(bpv.getFVisitPaidId())));
        bpv.setPatientFullnamet(config1.StringNull(rs.getString(bpv.getFPatientFullnamet())));

        bpv.setPatientVisitId(config1.StringNull(rs.getString(bpv.getFPatientVisitId())));
        bpv.setTPatientId(config1.StringNull(rs.getString(bpv.getFTPatientId())));
        bpv.setVisitBeginVisitTime(config1.StringNull(rs.getString(bpv.getFVisitBeginVisitTime())));
        bpv.setVisitDate(config1.StringNull(rs.getString(bpv.getFVisitDate())));
        bpv.setVisitDiagnosisNotice(config1.StringNull(rs.getString(bpv.getFVisitDiagnosisNotice())));

        bpv.setVisitFinancialDischargeTime(config1.StringNull(rs.getString(bpv.getFVisitFinancialDischargeTime())));
        bpv.setVisitFirstVisit(config1.StringNull(rs.getString(bpv.getFVisitFirstVisit())));
        bpv.setVisitHn(config1.StringNull(rs.getString(bpv.getFVisitHn())));
        bpv.setVisitHospitalService(config1.StringNull(rs.getString(bpv.getFVisitHospitalService())));
        bpv.setVisitNotice(config1.StringNull(rs.getString(bpv.getFVisitNotice())));

        bpv.setVisitPatientAge(config1.StringNull(rs.getString(bpv.getFVisitPatientAge())));
        bpv.setVisitPatientSelfDoctor(config1.StringNull(rs.getString(bpv.getFVisitPatientSelfDoctor())));
        bpv.setVisitVn(config1.StringNull(rs.getString(bpv.getFVisitVn())));
        bpv.setVisitClaimNamet(config1.StringNull(rs.getString(bpv.getFVisitClaimNamet())));
        bpv.setVisitPaidNamet(config1.StringNull(rs.getString(bpv.getFVisitPaidNamet())));

        bpv.setDepartmentNamet(config1.StringNull(rs.getString(bpv.getFDepartmentNamet())));
        bpv.setDoctorNamet(config1.StringNull(rs.getString(bpv.getFDoctorNamet())));
        bpv.setPatientImportId(config1.StringNull(rs.getString(bpv.getFPatientImportId())));
        bpv.setBranchId(config1.StringNull(rs.getString(bpv.getFBranchId())));
        bpv.setSysStatus(config1.StringNull(rs.getString(bpv.getFSysStatus())));

        bpv.setVisitPaid(Double.parseDouble(rs.getString(bpv.getFVisitPaid())));
        bpv.setVisitTotal(Double.parseDouble(rs.getString(bpv.getFVisitTotal())));
        bpv.setVisitDiscount(Double.parseDouble(rs.getString(bpv.getFVisitDiscount())));
        bpv.setEditStatus(config1.StringNull(rs.getString(bpv.getFEditStatus())));
        bpv.setVisitContactId(config1.StringNull(rs.getString(bpv.getFVisitContactId())));

        bpv.setVisitContactNamet(config1.StringNull(rs.getString(bpv.getFVisitContactNamet())));
        bpv.setPatientVisitActive(config1.StringNull(rs.getString(bpv.getFPatientVisitActive())));
        bpv.setFVisitTypeId(config1.StringNull(rs.getString(bpv.getFFVisitTypeId())));
        bpv.setContractPlansPttype(config1.StringNull(rs.getString(bpv.getFContractPlansPttype())));
        bpv.setReceiveNumber(config1.StringNull(rs.getString(bpv.getFReceiveNumber())));

        bpv.setInvoiceNumber(config1.StringNull(rs.getString(bpv.getFInvoiceNumber())));
        bpv.setContractPayerNumber(config1.StringNull(rs.getString(bpv.getFContractPayerNumber())));
        bpv.setItemStatusDoctor(config1.StringNull(rs.getString(bpv.getFItemStatusDoctor())));
        bpv.setVisitContactJoinId(config1.StringNull(rs.getString(bpv.getFVisitContactJoinId())));
        bpv.setVisitContactJoinNamet(config1.StringNull(rs.getString(bpv.getFVisitContactJoinNamet())));

        bpv.setCloseDayDate(config1.StringNull(rs.getString(bpv.getFCloseDayDate())));
        bpv.setTVisitPaymentId(config1.StringNull(rs.getString(bpv.getFTVisitPaymentId())));
        bpv.setSysStatusDoctor(config1.StringNull(rs.getString(bpv.getFSysStatusDoctor())));
        bpv.setBillingPatientShare(Double.parseDouble(rs.getString(bpv.getFBillingPatientShare())));
        bpv.setBillingPayerShare(Double.parseDouble(rs.getString(bpv.getFBillingPayerShare())));
        
        bpv.statusUnbilling = config1.StringNull(rs.getString(bpv.getFStatusUnbilling()));
        bpv.tVisitId = config1.StringNull(rs.getString(bpv.getFTVisitId()));

        v_patient_visit.add(bpv);
      }
      rs.close();
      conn.close();
    }catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return v_patient_visit;
  }

  public Vector getBackTPatientVisitItem(String bpv_i_id, String visit_date, String visit_hn,
          String visit_vn, String flagpage) {
    String sql = "";
    Vector v_billing_invoice = new Vector();
    try {
      Connection conn = config1.getConnectionBangna();
      Statement stbangna = conn.createStatement();
      if(flagpage.equals("")) {
        sql = "Select * From " + bpvi.getBackTPatientVisitItem() + " "
                + "Where " + bpvi.getFPatientVisitItemId() + "='" + bpv_i_id + "'";
      }else if (flagpage.equals("subsystem_import")) {
        sql = "Select * From " + bpvi.getBackTPatientVisitItem() + " "
                + "Where " + bpvi.getFPatientVisitId() + "='" + bpv_i_id + "'";
      }else if (flagpage.equals("visit_vn")) {//ต้อง group ด้วย
        sql = "Select '' as patient_visit_item_id, '' as patient_visit_id,"
                + "min("+bpvi.getFTPatientId()+") as "+bpvi.getFTPatientId()+", "
                + "min("+bpvi.getFVisitId()+") as "+bpvi.getFVisitId()+", "
                + "min("+bpvi.getFBillingInvoiceNumber()+") as "+bpvi.getFBillingInvoiceNumber()+", "
                + "min("+bpvi.getFTBillingInvoiceDateTime()+") as "+bpvi.getFTBillingInvoiceDateTime()+", "
                + "min("+bpvi.getFTBillingInvoiceTime()+") as "+bpvi.getFTBillingInvoiceTime()+", "
                + "0 as "+bpvi.getFBillingInvoiceItemTotal()+", "
                + "1 as "+bpvi.getFBillingInvoiceItemActive()+", "
                + "min("+bpvi.getFTBillingId()+") as "+bpvi.getFTBillingId()+", "
                + "min("+bpvi.getFTPaymentId()+") as "+bpvi.getFTPaymentId()+", "
                + "min("+bpvi.getFVisitVn()+") as "+bpvi.getFVisitVn()+", "
                + "'' as "+bpvi.getFTOrderItemId()+", "
                + "min("+bpvi.getFTBillingInvoiceItemId()+") as "+bpvi.getFTBillingInvoiceItemId()+", "
                + "min("+bpvi.getFBItemId()+") as "+bpvi.getFBItemId()+", "
                + "min("+bpvi.getFTBillingInvoiceItemNamet()+") as "+bpvi.getFTBillingInvoiceItemNamet()+", "
                + "min("+bpvi.getFBItemBillingSubgroupId()+") as "+bpvi.getFBItemBillingSubgroupId()+", "
                + "min("+bpvi.getFVisitPatientSeftDoctor()+") as "+bpvi.getFVisitPatientSeftDoctor()+", "

                + "min("+bpvi.getFDepartmentId()+") as "+bpvi.getFDepartmentId()+", "
                + "min("+bpvi.getFDepartmentNamet()+") as "+bpvi.getFDepartmentNamet()+", "
                + "min("+bpvi.getFClaimId()+") as "+bpvi.getFClaimId()+", "
                + "min("+bpvi.getFClaimNamet()+") as "+bpvi.getFClaimNamet()+", "
                + "min("+bpvi.getFVisitHn()+") as "+bpvi.getFVisitHn()+", "
                + "min("+bpvi.getFBranchId()+") as "+bpvi.getFBranchId()+", "
                + "min("+bpvi.getFSysStatus()+") as "+bpvi.getFSysStatus()+", "
                + "sum("+bpvi.getFItemTotal()+") as "+bpvi.getFItemTotal()+", "
                + "sum("+bpvi.getFItemDiscount()+") as "+bpvi.getFItemDiscount()+", "
                + "sum("+bpvi.getFItemPaid()+") as "+bpvi.getFItemPaid()+", "
                + "min("+bpvi.getFEditStatus()+") as "+bpvi.getFEditStatus()+", "
                + "min("+bpvi.getFItemStatusDoctor()+") as "+bpvi.getFItemStatusDoctor()+", "
                + "min("+bpvi.getFDoctorId()+") as "+bpvi.getFDoctorId()+", "
                + "min("+bpvi.getFFItemGroupId()+") as "+bpvi.getFFItemGroupId()+", "
                + "min("+bpvi.getFOrderDateTime()+") as "+bpvi.getFOrderDateTime()+", "
                + "min("+bpvi.getFOrderHome()+") as "+bpvi.getFOrderHome()+" "
                + "From " + bpvi.getBackTPatientVisitItem() + " "
                + "Where " + bpvi.getFVisitVn() + "='" + bpv_i_id + "' and "+bpvi.getFBillingInvoiceItemActive()+"='1' "
                + "Group By "+bpvi.getFVisitVn()+","+bpvi.getFBItemBillingSubgroupId();
      }else if (flagpage.equals("subsystem_import_doctor")) {
        sql = "Select * From " + bpvi.getBackTPatientVisitItem() + " " 
                + "Where " + bpvi.getFPatientVisitId() + "='" + bpv_i_id + "' and "
                + bpvi.getFItemStatusDoctor() + "='1'";
      }else if (flagpage.equals("billing_invoice")) {
        sql = "Select * From " + bpvi.getBackTPatientVisitItem() + " "
                + "Where " + bpvi.getFVisitVn() + "='" + visit_vn + "' and " + bpvi.getFBillingInvoiceItemActive() + "='1' and "
                + bpvi.getFPatientVisitId() + "='" + bpv_i_id + "' "
                + "Order By " + bpvi.getFFItemGroupId() + " asc";
      }else{
        sql = "Select * From " + bpvi.getBackTPatientVisitItem() + " "
                + "Where " + bpvi.getFVisitHn() + "='" + visit_hn + "' and " + bpvi.getFVisitVn() + "='" + visit_vn + "' and "
                + bpvi.getFTBillingInvoiceDateTime() + "='" + visit_date + "' "
                + "Order By " + bpvi.getFTBillingInvoiceTime() + " ";
      }
      ResultSet rs = stbangna.executeQuery(sql);
      while (rs.next()) {
        bpvi = new BackTPatientVisitItem();
        bpvi.setBItemBillingSubgroupId(rs.getString(bpvi.getFBItemBillingSubgroupId()));
        bpvi.setBItemId(rs.getString(bpvi.getFBItemId()));
        bpvi.setBillingInvoiceItemActive(rs.getString(bpvi.getFBillingInvoiceItemActive()));
        bpvi.setBillingInvoiceItemTotal(Double.parseDouble(rs.getString(bpvi.getFBillingInvoiceItemTotal())));
        bpvi.setBillingInvoiceNumber(rs.getString(bpvi.getFBillingInvoiceNumber()));

        bpvi.setClaimId(rs.getString(bpvi.getFClaimId()));
        bpvi.setClaimNamet(rs.getString(bpvi.getFClaimNamet()));
        bpvi.setDepartmentNamet(rs.getString(bpvi.getFDepartmentNamet()));
        bpvi.setPatientVisitBillingItemId(rs.getString(bpvi.getFPatientVisitItemId()));
        bpvi.setPatientVisitId(rs.getString(bpvi.getFPatientVisitId()));

        bpvi.setTBillingId(rs.getString(bpvi.getFTBillingId()));
        bpvi.setTBillingInvoiceDateTime(rs.getString(bpvi.getFTBillingInvoiceDateTime()));
        bpvi.setTBillingInvoiceItemId(rs.getString(bpvi.getFTBillingInvoiceItemId()));
        bpvi.setTBillingInvoiceItemNamet(rs.getString(bpvi.getFTBillingInvoiceItemNamet()));
        bpvi.setTBillingInvoiceTime(rs.getString(bpvi.getFTBillingInvoiceTime()));

        bpvi.setTOrderItemId(rs.getString(bpvi.getFTOrderItemId()));
        bpvi.setTPatientId(rs.getString(bpvi.getFTPatientId()));
        bpvi.setTPaymentId(rs.getString(bpvi.getFTPaymentId()));
        bpvi.setVisitId(rs.getString(bpvi.getFVisitId()));
        bpvi.setVisitPatientSelfDoctor(rs.getString(bpvi.getFVisitPatientSeftDoctor()));

        bpvi.setVisitVn(rs.getString(bpvi.getFVisitVn()));
        bpvi.setDepartmentId(rs.getString(bpvi.getFDepartmentId()));
        bpvi.setVisitHn(rs.getString(bpvi.getFVisitHn()));
        bpvi.setBranchId(config1.StringNull(rs.getString(bpvi.getFBranchId())));
        bpvi.setSysStatus(config1.StringNull(rs.getString(bpvi.getFSysStatus())));

        bpvi.setItemDiscount(Double.parseDouble(rs.getString(bpvi.getFItemDiscount())));
        bpvi.setItemPaid(Double.parseDouble(rs.getString(bpvi.getFItemPaid())));
        bpvi.setItemTotal(Double.parseDouble(rs.getString(bpvi.getFItemTotal())));
        bpvi.setEditStatus(config1.StringNull(rs.getString(bpvi.getFEditStatus())));
        bpvi.setItemStatusDoctor(config1.StringNull(rs.getString(bpvi.getFItemStatusDoctor())));

        bpvi.setDoctorId(config1.StringNull(rs.getString(bpvi.getFDoctorId())));
        bpvi.setFItemGroupId(config1.StringNull(rs.getString(bpvi.getFFItemGroupId())));
        if (!flagpage.equals("visit_vn")) {//ต้อง group ด้วย
            bpvi.orderOperationNo  = config1.StringNull(rs.getString(bpvi.getFOrderOperationNo()));
            bpvi.orderOperationStatus = config1.StringNull(rs.getString(bpvi.getFOrderOperationStatus()));
            bpvi.statusRate = config1.StringNull(rs.getString(bpvi.getFStatusRate()));

            bpvi.orderStartTime = config1.StringNull(rs.getString(bpvi.getFOrderStartTime()));
            bpvi.orderEndTime = config1.StringNull(rs.getString(bpvi.getFOrderEndTime()));
            bpvi.orderDateTime = config1.StringNull(rs.getString(bpvi.getFOrderDateTime()));
            bpvi.statusNoCloseDayImport = config1.StringNull(rs.getString(bpvi.getFStatusNoCloseDayImport()));
            bpvi.orderHome = config1.StringNull(rs.getString(bpvi.getFOrderHome()));
        }
        
        
        v_billing_invoice.add(bpvi);
      }
      rs.close();
      conn.close();
    }catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return v_billing_invoice;
  }
  public String setSaveBackTPatientVisit(Connection conn, Statement st, BackTPatientVisit item) throws Exception{
    int chk = 0;
    String max = "";
    try {
      bpv = getBackTPatientVisitByPK(conn, st, item.getPatientVisitId(), "");
      item.setPatientFullnamet(config1.StringNull(item.getPatientFullnamet()).replace("'", "''"));
      item.setVisitNotice(config1.StringNull(item.getVisitNotice()).replace("'", "''"));
      item.setVisitDiagnosisNotice(config1.StringNull(item.getVisitDiagnosisNotice()).replace("'", "''"));
      item.setVisitContactNamet(config1.StringNull(item.getVisitContactNamet()).replace("'", "''"));
      item.setVisitClinicDescription(config1.StringNull(item.getVisitClinicDescription()).replace("'", "''"));
      item.setDoctorNamet(config1.StringNull(item.getDoctorNamet()).replace("'", "''"));
      item.setDepartmentNamet(config1.StringNull(item.getDepartmentNamet()).replace("'", "''"));
      item.setVisitHospitalService(config1.StringNull(item.getVisitHospitalService()).replace("'", "''"));
      item.setVisitContactJoinNamet(config1.StringNull(item.getVisitContactJoinNamet()).replace("'", "''"));

      if (item.getPatientVisitActive().equals("")) {
        item.setPatientVisitActive("1");
      }
      sql.delete(0, sql.length());
      if (bpv.getPatientVisitId().equals("")) {
        item.generateOID(idtable);
        max = item.getObjectId();
        sql.append("Insert Into ").append(bpv.getBackTPatientVisit()).append("(").append(bpv.getFPatientVisitId()).append(", ")
                .append(bpv.getFBServicePointId()).append(", ").append(bpv.getFBVisitClinicId()).append(",")
                .append(bpv.getFVisitClaimId()).append(",").append(bpv.getFVisitPaidId()).append(",")
                .append(bpv.getFPatientFullnamet()).append(",").append(bpv.getFPatientImportId()).append(",")
                .append(bpv.getFTPatientId()).append(",").append(bpv.getFVisitBeginVisitTime()).append(",")
                .append(bpv.getFVisitDate()).append(",").append(bpv.getFVisitDiagnosisNotice()).append(",")
                .append(bpv.getFVisitFinancialDischargeTime()).append(",").append(bpv.getFVisitFirstVisit()).append(",")
                .append(bpv.getFVisitHn()).append(",").append(bpv.getFVisitHospitalService()).append(",")
                .append(bpv.getFVisitNotice()).append(", ").append(bpv.getFVisitPatientAge()).append(",")
                .append(bpv.getFVisitPatientSelfDoctor()).append(", ").append(bpv.getFVisitVn()).append(",")
                .append(bpv.getFVisitClaimNamet()).append(",").append(bpv.getFVisitPaidNamet()).append(",")
                .append(bpv.getFDepartmentNamet()).append(",").append(bpv.getFDoctorNamet()).append(",")
                .append(bpv.getFBranchId()).append(",").append(bpv.getFSysStatus()).append(",").append(bpv.getFVisitPaid()).append(",")
                .append(bpv.getFVisitTotal()).append(",").append(bpv.getFVisitDiscount()).append(",")
                .append(bpv.getFEditStatus()).append(",").append(bpv.getFVisitContactId()).append(",")
                .append(bpv.getFVisitContactNamet()).append(",").append(bpv.getFPatientVisitActive()).append(",")
                .append(bpv.getFTVisitId()).append(",").append(bpv.getFTVisitPaymentId()).append(",")
                .append(bpv.getFVisitClinicDescription()).append(",").append(bpv.getFBillingPatientShare()).append(",")
                .append(bpv.getFBillingPayerShare()).append(",").append(bpv.getFFVisitTypeId()).append(",")
                .append(bpv.getFContractPlansPttype()).append(",").append(bpv.getFReceiveNumber()).append(",")
                .append(bpv.getFInvoiceNumber()).append(",").append(bpv.getFContractPayerNumber()).append(",")
                .append(bpv.getFItemStatusDoctor()).append(",").append(bpv.getFCloseDayId()).append(",")
                .append(bpv.getFVisitContactJoinId()).append(",").append(bpv.getFVisitContactJoinNamet()).append(",")
                .append(bpv.getFCloseDayDate()).append(",").append(bpv.getFSysStatusDoctor()).append(",")
                .append(bpv.getFStatusUnbilling()).append(") ")
//                .append("Values('").append(max).append("','").append(item.getBServicePointId()).append("','")
                .append("Values('").append(item.getObjectId()).append("','").append(item.getBServicePointId()).append("','")
                .append(item.getBVisitClinicId()).append("','").append(item.getVisitClaimId()).append("','")
                .append(item.getVisitPaidId()).append("','").append(item.getPatientFullnamet()).append("','")
                .append(item.getPatientImportId()).append("','").append(item.getTPatientId()).append("','")
                .append(item.getVisitBeginVisitTime()).append("','").append(item.getVisitDate()).append("','")
                .append(item.getVisitDiagnosisNotice()).append("','").append(item.getVisitFinancialDischargeTime()).append("','")
                .append(item.getVisitFirstVisit()).append("','").append(item.getVisitHn()).append("','")
                .append(item.getVisitHospitalService()).append("','").append(item.getVisitNotice()).append("','").append(item.getVisitPatientAge())
                .append("','").append(item.getVisitPatientSelfDoctor()).append("','").append(item.getVisitVn()).append("','")
                .append(item.getVisitClaimNamet()).append("','").append(item.getVisitPaidNamet()).append("','")
                .append(item.getDepartmentNamet()).append("','").append(item.getDoctorNamet()).append("','")
                .append(item.getBranchId()).append("','").append(item.getSysStatus()).append("',").append(item.getVisitPaid())
                .append(",").append(item.getVisitTotal()).append(",").append(item.getVisitDiscount()).append(",'")
                .append(item.getEditStatus()).append("','").append(item.getVisitContactId()).append("','")
                .append(item.getVisitContactNamet()).append("','").append(item.getPatientVisitActive()).append("','")
                .append(item.getTVisitId()).append("','").append(item.getTVisitPaymentId()).append("','")
                .append(item.getVisitClinicDescription()).append("',").append(item.getBillingPatientShare()).append(",")
                .append(item.getBillingPayerShare()).append(",'").append(item.getFVisitTypeId()).append("','")
                .append(item.getContractPlansPttype()).append("','").append(item.getReceiveNumber()).append("','")
                .append(item.getInvoiceNumber()).append("','").append(item.getContractPayerNumber()).append("','")
                .append(item.getItemStatusDoctor()).append("','").append(item.getCloseDayId()).append("','")
                .append(item.getVisitContactJoinId()).append("','").append(item.getVisitContactJoinNamet()).append("','")
                .append(item.getCloseDayDate()).append("','").append(item.getSysStatusDoctor()).append("','")
                .append(item.getStatusUnbilling()).append("')");
      }else{
        sql.append("Update ").append(bpv.getBackTPatientVisit()).append(" set ").append(bpv.getFBServicePointId()).append(" = '")
                .append(item.getBServicePointId()).append("', ").append(bpv.getFBVisitClinicId()).append(" = '")
                .append(item.getBVisitClinicId()).append("', ").append(bpv.getFVisitClaimId()).append(" = '")
                .append(item.getVisitClaimId()).append("', ").append(bpv.getFVisitPaidId()).append(" = '")
                .append(item.getVisitPaidId()).append("', ").append(bpv.getFPatientFullnamet()).append(" = '")
                .append(item.getPatientFullnamet()).append("', ").append(bpv.getFPatientImportId()).append(" = '")
                .append(item.getPatientImportId()).append("', ").append(bpv.getFTPatientId()).append(" = '")
                .append(item.getTPatientId()).append("', ").append(bpv.getFVisitBeginVisitTime()).append(" = '")
                .append(item.getVisitBeginVisitTime()).append("', ").append(bpv.getFVisitDate()).append(" = '")
                .append(item.getVisitDate()).append("', ").append(bpv.getFVisitDiagnosisNotice()).append(" = '")
                .append(item.getVisitDiagnosisNotice()).append("',").append(bpv.getFVisitFinancialDischargeTime()).append(" = '")
                .append(item.getVisitFinancialDischargeTime()).append("',").append(bpv.getFVisitFirstVisit()).append(" = '")
                .append(item.getVisitFirstVisit()).append("', ").append(bpv.getFVisitHn()).append(" = '")
                .append(item.getVisitHn()).append("', ").append(bpv.getFVisitHospitalService()).append(" = '")
                .append(item.getVisitHospitalService()).append("', ").append(bpv.getFVisitNotice()).append(" = '")
                .append(item.getVisitNotice()).append("', ").append(bpv.getFVisitPatientAge()).append(" = '")
                .append(item.getVisitPatientAge()).append("', ")
                .append(bpv.getFVisitPatientSelfDoctor()).append(" = '").append(item.getVisitPatientSelfDoctor()).append("', ")
                .append(bpv.getFVisitVn()).append(" = '").append(item.getVisitVn()).append("', ")
                .append(bpv.getFVisitClaimNamet()).append(" = '").append(item.getVisitClaimNamet()).append("', ")
                .append(bpv.getFVisitPaidNamet()).append(" = '").append(item.getVisitPaidNamet()).append("', ")
                .append(bpv.getFDepartmentNamet()).append(" = '").append(item.getDepartmentNamet()).append("', ")
                .append(bpv.getFDoctorNamet()).append(" = '").append(item.getDoctorNamet()).append("', ")
                .append(bpv.getFBranchId()).append(" = '").append(item.getBranchId()).append("', ")
                .append(bpv.getFSysStatus()).append(" = '").append(item.getSysStatus()).append("', ")
                .append(bpv.getFVisitPaid()).append(" = ").append(item.getVisitPaid()).append(", ")
                .append(bpv.getFVisitTotal()).append(" = ").append(item.getVisitTotal()).append(", ")
                .append(bpv.getFVisitDiscount()).append(" = ").append(item.getVisitDiscount()).append(", ")
                .append(bpv.getFVisitContactId()).append(" = '").append(item.getVisitContactId()).append("', ")
                .append(bpv.getFVisitContactNamet()).append(" = '").append(item.getVisitContactNamet()).append("', ")
                .append(bpv.getFPatientVisitActive()).append(" = '").append(item.getPatientVisitActive()).append("', ")
                .append(bpv.getFTVisitId() + " = '" + item.getTVisitId() + "', "
                + bpv.getFTVisitPaymentId()).append(" = '").append(item.getTVisitPaymentId()).append("', ")
                .append(bpv.getFVisitClinicDescription()).append(" = '").append(item.getVisitClinicDescription()).append("', ")
                .append(bpv.getFBillingPatientShare() + " = " + item.getBillingPatientShare() + ", "
                + bpv.getBillingPayerShare() + " = " + item.getBillingPayerShare() + ", "
                + bpv.getFFVisitTypeId()).append(" = '").append(item.getFVisitTypeId()).append("', ")
                .append(bpv.getFContractPlansPttype()).append(" = '").append(item.getContractPlansPttype()).append("', ")
                .append(bpv.getFReceiveNumber()).append(" = '").append(item.getReceiveNumber()).append("', ")
                .append(bpv.getFInvoiceNumber()).append(" = '").append(item.getInvoiceNumber()).append("', ")
                .append(bpv.getFContractPayerNumber()).append(" = '").append(item.getContractPayerNumber()).append("', ")
                .append(bpv.getFItemStatusDoctor()).append(" = '").append(item.getItemStatusDoctor()).append("', ")
                .append(bpv.getFCloseDayId()).append(" = '").append(item.getCloseDayId()).append("', ")
                .append(bpv.getVisitContactJoinId()).append(" = '").append(item.getVisitContactJoinId()).append("', ")
                .append(bpv.getVisitContactJoinNamet()).append(" = '").append(item.getVisitContactJoinNamet()).append("', ")
                .append(bpv.getFCloseDayDate()).append(" = '").append(item.getCloseDayDate()).append("', ")
                .append(bpv.getFSysStatusDoctor()).append(" = '").append(item.getSysStatusDoctor()).append("' ")
                .append("Where " + bpv.getFPatientVisitId()).append(" = '").append(item.getPatientVisitId() + "'");

        max = item.getPatientVisitId();
      }
      chk = st.executeUpdate(sql.toString());
    }catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return max;
  }
    public String setSaveBackTPatientVisitItem(BackTPatientVisitItem item) throws Exception {
        int chk = 0;
        String max = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            max = setSaveBackTPatientVisitItem(conn, st, item);
            conn.close();
        }catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
  public String setSaveBackTPatientVisitItem(Connection conn, Statement st, BackTPatientVisitItem item) throws Exception {
    int chk = 0;
    String max = "";
    try {
      bpvi = getBackTPatientVisitItemByPK(conn, st, item.getPatientVisitBillingItemId());
      item.setClaimNamet(item.getClaimNamet().replace("'", "''"));
      item.setTBillingInvoiceItemNamet(item.getTBillingInvoiceItemNamet().replace("'", "''"));
      item.setDepartmentNamet(item.getDepartmentNamet().replace("'", "''"));
      sql.delete(0, sql.length());
      if (bpvi.getPatientVisitBillingItemId().equals("")) {
        item.generateOID(idtableItem);
        max = item.getObjectId();
        sql.append("Insert Into ").append(bpvi.getBackTPatientVisitItem()).append("(").append(bpvi.getFPatientVisitItemId()).append(", ")
                .append(bpvi.getFBItemBillingSubgroupId()).append(", ").append(bpvi.getFBItemId()).append(",")
                .append(bpvi.getFBillingInvoiceItemActive()).append(",").append(bpvi.getFBillingInvoiceItemTotal()).append(",")
                .append(bpvi.getFBillingInvoiceNumber()).append(",").append(bpvi.getFClaimId()).append(",")
                .append(bpvi.getFClaimNamet()).append(",").append(bpvi.getFDepartmentId()).append(",")
                .append(bpvi.getFDepartmentNamet()).append(",").append(bpvi.getFPatientVisitId()).append(",")
                .append(bpvi.getFTBillingId()).append(",").append(bpvi.getFTBillingInvoiceDateTime()).append(",")
                .append(bpvi.getFTBillingInvoiceItemId()).append(",").append(bpvi.getFTBillingInvoiceItemNamet()).append(", ")
                .append(bpvi.getFTBillingInvoiceTime()).append(",").append(bpvi.getFTOrderItemId()).append(", ")
                .append(bpvi.getFTPatientId()).append(",").append(bpvi.getFTPaymentId()).append(",")
                .append(bpvi.getFVisitHn()).append(",").append(bpvi.getFVisitId()).append(",")
                .append(bpvi.getFVisitPatientSeftDoctor()).append(",").append(bpvi.getFVisitVn()).append(",")
                .append(bpvi.getFBranchId()).append(",").append(bpvi.getFSysStatus()).append(",")
                .append(bpvi.getFItemDiscount()).append(",").append(bpvi.getFItemPaid()).append(",")
                .append(bpvi.getFItemTotal()).append(",").append(bpvi.getFEditStatus()).append(",")
                .append(bpvi.getFItemStatusDoctor()).append(",").append(bpvi.getFDoctorId()).append(",")
                .append(bpvi.getFFItemGroupId()).append(",").append(bpvi.getFOrderDateTime()).append(", ")
                .append(bpvi.getFOrderStartTime()).append(",").append(bpvi.getFOrderEndTime()).append(", ")
                .append(bpvi.getFStatusRate()).append(",").append(bpvi.getFOrderOperationNo()).append(",")
                .append(bpvi.getFOrderOperationStatus()).append(",").append(bpvi.getFStatusNoCloseDayImport()).append(",")
                .append(bpvi.getFOrderHome()).append(" ")
                .append(")")
                //                .append("Values('").append(max).append("','").append(item.getBItemBillingSubgroupId()).append("','")
                .append("Values('").append(item.getObjectId()).append("','").append(item.getBItemBillingSubgroupId()).append("','")
                .append(item.getBItemId()).append("','").append(item.getBillingInvoiceItemActive()).append("','")
                .append(item.getBillingInvoiceItemTotal()).append("','").append(item.getBillingInvoiceNumber()).append("','")
                .append(item.getClaimId()).append("','").append(item.getClaimNamet()).append("','").append(item.getDepartmentId())
                .append("','").append(item.getDepartmentNamet()).append("','").append(item.getPatientVisitId()).append("','")
                .append(item.getTBillingId()).append("','").append(item.getTBillingInvoiceDateTime()).append("','")
                .append(item.getTBillingInvoiceItemId()).append("','").append(item.getTBillingInvoiceItemNamet()).append("','")
                .append(item.getTBillingInvoiceTime()).append("','").append(item.getTOrderItemId()).append("','")
                .append(item.getTPatientId()).append("','").append(item.getTPaymentId()).append("','")
                .append(item.getVisitHn()).append("','").append(item.getVisitId()).append("','")
                .append(item.getVisitPatientSelfDoctor()).append("','").append(item.getVisitVn()).append("','")
                .append(item.getBranchId()).append("','").append(item.getSysStatus()).append("',")
                .append(item.getItemDiscount()).append(",").append(item.getItemPaid()).append(",")
                .append(item.getItemTotal()).append(",'").append(item.getEditStatus()).append("','")
                .append(item.getItemStatusDoctor()).append("','").append(item.getDoctorId()).append("','")
                .append(item.getFItemGroupId()).append("','").append(item.getOrderDateTime()).append("','")
                .append(item.orderStartTime).append("','").append(item.orderEndTime).append("','")
                .append(item.statusRate).append("','").append(item.orderOperationNo).append("','")
                .append(item.orderOperationStatus).append("','").append(item.statusNoCloseDayImport).append("','")
                .append(item.orderHome).append("'")
                
                .append(")");
      }else{
        sql.append("Update ").append(bpvi.getBackTPatientVisitItem())
                .append(" set ").append(bpvi.getFBItemBillingSubgroupId()).append(" = '").append(item.getBItemBillingSubgroupId()).append("', ")
                .append(bpvi.getFBItemId()).append(" = '").append(item.getBItemId()).append("', ")
                .append(bpvi.getFBillingInvoiceItemActive()).append(" = '").append(item.getBillingInvoiceItemActive()).append("', ")
                .append(bpvi.getFBillingInvoiceItemTotal()).append(" = '").append(item.getBillingInvoiceItemTotal()).append("', ")
                .append(bpvi.getFBillingInvoiceNumber()).append(" = '").append(item.getBillingInvoiceNumber()).append("', ")
                .append(bpvi.getFClaimId()).append(" = '").append(item.getClaimId()).append("', ")
                .append(bpvi.getFClaimNamet()).append(" = '").append(item.getClaimNamet()).append("', ")
                .append(bpvi.getFDepartmentId()).append(" = '").append(item.getDepartmentId()).append("', ")
                .append(bpvi.getFDepartmentNamet()).append(" = '").append(item.getDepartmentNamet()).append("', ")
                .append(bpvi.getFPatientVisitId()).append(" = '").append(item.getPatientVisitId()).append("',")
                .append(bpvi.getFTBillingId()).append(" = '").append(item.getTBillingId()).append("',")
                .append(bpvi.getFTBillingInvoiceDateTime()).append(" = '").append(item.getTBillingInvoiceDateTime()).append("', ")
                .append(bpvi.getFTBillingInvoiceItemId()).append(" = '").append(item.getTBillingInvoiceItemId()).append("', ")
                .append(bpvi.getFTBillingInvoiceItemNamet()).append(" = '").append(item.getTBillingInvoiceItemNamet()).append("', ")
                .append(bpvi.getFTBillingInvoiceTime()).append(" = '").append(item.getTBillingInvoiceTime()).append("', ")
                .append(bpvi.getFTOrderItemId()).append(" = '").append(item.getTOrderItemId()).append("', ")
                .append(bpvi.getFTPatientId()).append(" = '").append(item.getTPatientId()).append("', ")
                .append(bpvi.getFVisitId()).append(" = '").append(item.getVisitId()).append("', ")
                .append(bpvi.getFVisitHn()).append(" = '").append(item.getVisitHn()).append("', ")
                .append(bpvi.getFVisitPatientSeftDoctor()).append(" = '").append(item.getVisitPatientSelfDoctor()).append("', ")
                .append(bpvi.getFVisitVn()).append(" = '").append(item.getVisitVn()).append("', ")
                .append(bpvi.getFBranchId()).append(" = '").append(item.getBranchId()).append("', ")
                .append(bpvi.getFSysStatus()).append(" = '").append(item.getSysStatus()).append("', ")
                .append(bpvi.getFItemDiscount()).append(" = ").append(item.getItemDiscount()).append(", ")
                .append(bpvi.getFItemPaid()).append(" = ").append(item.getItemPaid()).append(", ")
                .append(bpvi.getFItemTotal()).append(" = ").append(item.getItemTotal()).append(", ")
                .append(bpvi.getFEditStatus()).append(" = '").append(item.getEditStatus()).append("', ")
                .append(bpvi.getFFItemGroupId()).append(" = '").append(item.getFItemGroupId()).append("', ")
                .append(bpvi.getFOrderDateTime()).append(" = '").append(item.getOrderDateTime()).append("' ")
                .append("Where ").append(bpvi.getFPatientVisitItemId()).append(" = '").append(item.getFPatientVisitItemId()).append("'");
        max = item.getPatientVisitId();
      }
      chk = st.executeUpdate(sql.toString());
    }catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return max;
  }
  public BServicePoint getPatientVisitServicePoint(Statement st, String visit_vn) {
    String sql = "SELECT tvs.t_visit_service_id, tvs.t_visit_id, tvs.t_patient_id, tvs.assign_date_time, "
            + "tvs.visit_service_staff_doctor, tvs.f_visit_service_status_id, tvs.b_service_point_id, "
            + "tvs.visit_service_treatment_date_time, tvs.visit_service_finish_date_time, tvs.b_visit_ward_id, "
            + "b_service_point.service_point_number, b_service_point.service_point_description, tv.visit_vn "
            + "FROM t_visit_service tvs LEFT JOIN t_visit tv ON tvs.t_visit_id::text = tv.t_visit_id::text "
            + "LEFT JOIN b_service_point ON tvs.b_service_point_id::text = b_service_point.b_service_point_id::text "
            + "WHERE tvs.b_service_point_id not in ('2064028169980','2062542114510','2402024154365','2408582519624','2409840463402') AND "
            + "tvs.f_visit_service_status_id::text <> '4'::text and visit_vn = '" + visit_vn + "' " + "LIMIT 1; ";
    try{
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        service_point = new BServicePoint();
        service_point.setBServicePointId(rs.getString("b_service_point_id"));
        service_point.setServicePointNumber(rs.getString("service_point_number"));
        service_point.setServicePointDescription(rs.getString("service_point_description"));
      }
      rs.close();
    }catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return service_point;
  }
  public void setSavePatientVisitImportId(String patient_import_id) {
    String sql = "";
    try{
      Connection conn = config1.getConnectionBangna();
      Statement st = conn.createStatement();
      sql = "Update " + bpv.getBackTPatientVisit() 
              + " Set " + bpv.getFPatientImportId() + "='" + patient_import_id + "' "
              + "Where " + bpv.getFPatientImportId() + "=''";
      st.executeUpdate(sql);
      conn.close();
    }catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void setPatientVisitSysStatusItem(String branch_id, String patient_import_id, String status, String contract_payer_number,
          String patient_visit_id) {
    String sql = ""; String sub_system = "";
    Integer chk = 0;
    try {
      Connection conn = config1.getConnectionBangna();
      Statement st = conn.createStatement();
      sql = "Select b_department_id From back_b_transfer Where paid_id  = '" + contract_payer_number + "' and "
              + "branch_id = '" + branch_id + "'";
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        sub_system = rs.getString("b_department_id");
      }
      rs.close();
      if (sub_system.equals("14502")){
        sql = "Update " + bpv.getBackTPatientVisit() 
                + " Set " + bpv.getFSysStatus() + "='" + status + "' "
                + "Where " + bpv.getFPatientImportId() + "='" + patient_import_id + "' and "
                + bpv.getFPatientVisitId() + "='" + patient_visit_id + "' and branch_id = '" + branch_id + "'";
        st.executeUpdate(sql);
        sql = "Update " + bpi.getBackTPatientImport() 
                + " Set " + bpi.getFSysStatusContact() + "='" + status + "' "
                + "Where " + bpi.getFPatientImportId() + "='" + patient_import_id + "'";
        chk = st.executeUpdate(sql);
      }else if (sub_system.equals("14501")){
        sql = "Update " + bpv.getBackTPatientVisit() 
                + " Set " + bpv.getFSysStatus() + "='" + status + "' "
                + "Where " + bpv.getFPatientImportId() + "='" + patient_import_id + "' and "
                + bpv.getFPatientVisitId() + "='" + patient_visit_id + "' and branch_id = '" + branch_id + "'";
        chk = st.executeUpdate(sql);
        sql = "Update " + bpi.getBackTPatientImport() 
                + " Set " + bpi.getFSysStatusFunds() + "='" + status + "' "
                + "Where " + bpi.getFPatientImportId() + "='" + patient_import_id + "'";
        chk = st.executeUpdate(sql);
      }
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  public String setPatientVisitSysStatusDoctorItem(String branch_id, String patient_import_id, String status,
          String contract_payer_number, String patient_visit_id) {
    String sql = ""; String sub_system = "";
    Integer chk=0;
    try {
      Connection conn = config1.getConnectionBangna();
      Statement st = conn.createStatement();
      sql = "Update " + bpv.getBackTPatientVisit()
              + " Set " + bpv.getFSysStatusDoctor() + "='" + status + "' "
              + "Where " + bpv.getFPatientImportId() + "='" + patient_import_id + "' and "
              + bpv.getFPatientVisitId() + "='" + patient_visit_id + "' and branch_id = '" + branch_id + "'";
      chk = st.executeUpdate(sql);
      sql = "Update " + bpi.getBackTPatientImport() 
              + " Set " + bpi.getFSysStatusDoctor() + "='" + status + "' "
              + "Where " + bpi.getFPatientImportId() + "='" + patient_import_id + "'";
      chk = st.executeUpdate(sql);
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return chk.toString();
  }
  public void setPatientVisitSysStatus(String branch_id, String patient_import_id, String status, String sub_system,
          String flag, Integer cnt) {
    String sql = "";
    try{
      Connection conn = config1.getConnectionBangna();
      Statement st = conn.createStatement();
      if (flag.equals("transfer")) {
        if (sub_system.equals("all")) {
          sql = "Update " + bpv.getBackTPatientVisit() 
                  + " Set " + bpv.getFSysStatus() + "='" + status + "', " + bpv.getFSysStatusDoctor() + "='" + status + "' "
                  + "Where " + bpv.getFPatientImportId() + "='" + patient_import_id + "' ";
          st.executeUpdate(sql);
          sql = "Update " + bpi.getBackTPatientImport()
                  + " Set " + bpi.getFSysStatusContact() + "='" + status + "', " + bpi.getFSysStatusFunds() + "='" + status + "', "
                  + bpi.getFSysStatusDoctor() + "='" + status + "' "
                  + "Where " + bpi.getFPatientImportId() + "='" + patient_import_id + "'";
          st.executeUpdate(sql);
        } else if (sub_system.equals("contact")) {
          sql = "Update " + bpv.getBackTPatientVisit()
                  + " Set " + bpv.getFSysStatus() + "='" + status + "' "
                  + "Where " + bpv.getFPatientImportId() + "='" + patient_import_id + "' and " + bpv.getFContractPayerNumber()
                  + " in (Select paid_id From back_b_transfer Where b_department_id = '14502' and branch_id = '" + branch_id + "')";
          st.executeUpdate(sql);
          sql = "Update " + bpi.getBackTPatientImport() 
                  + " Set " + bpi.getFSysStatusContact() + "='" + status + "' "
                  + "Where " + bpi.getFPatientImportId() + "='" + patient_import_id + "'";
          st.executeUpdate(sql);
        } else if (sub_system.equals("funds")) {
          sql = "Update " + bpv.getBackTPatientVisit() + " Set " + bpv.getFSysStatus() + "='" + status + "' " 
                  + "Where " + bpv.getFPatientImportId() + "='" + patient_import_id + "' and " + bpv.getFContractPayerNumber()
                  + " in (Select paid_id From back_b_transfer Where b_department_id = '14501' and branch_id = '" + branch_id + "')";
          st.executeUpdate(sql);
          sql = "Update " + bpi.getBackTPatientImport() + " Set " + bpi.getFSysStatusFunds() + "='" + status + "' "
                  + "Where " + bpi.getFPatientImportId() + "='" + patient_import_id + "'";
          st.executeUpdate(sql);
        } else if (sub_system.equals("doctor")) {
          sql = "Update " + bpv.getBackTPatientVisit()
                  + " Set " + bpv.getFSysStatus() + "='" + status + "', " + bpv.getFSysStatusDoctor() + "='" + status + "' "
                  + "Where " + bpv.getFPatientImportId() + "='" + patient_import_id + "' and " + bpv.getFContractPayerNumber()
                  + " in (Select paid_id From back_b_transfer Where b_department_id = '14503' and branch_id = '" + branch_id + "')";
          st.executeUpdate(sql);
          sql = "Update " + bpi.getBackTPatientImport() + " Set " + bpi.getFSysStatusDoctor() + "='" + status + "' "
                  + "Where " + bpi.getFPatientImportId() + "='" + patient_import_id + "'";
          st.executeUpdate(sql);
        }
      }else if (flag.equals("receive")) {
        if (sub_system.equals("contact")) {
          sql = "Update " + bpv.getBackTPatientVisit() + " Set " + bpv.getFSysStatus() + "='" + status + "' " 
                  + "Where " + bpv.getFPatientImportId() + "='" + patient_import_id + "' and " + bpv.getFContractPayerNumber()
                  + " in (Select paid_id From back_b_transfer Where b_department_id = '14502' and branch_id = '" + branch_id + "')";
        }else{
          sql = "Update " + bpv.getBackTPatientVisit() + " Set " + bpv.getFSysStatus() + "='" + status + "' " 
                  + "Where " + bpv.getFPatientImportId() + "='" + patient_import_id + "' and " + bpv.getFVisitPaidId()
                  + " in (Select paid_id From back_b_transfer Where b_department_id = '14501' and branch_id = '" + branch_id + "')";
        }
        st.executeUpdate(sql);
        if (sub_system.equals("contact")) {
          sql = "Update " + bpi.getBackTPatientImport() 
                  + " Set " + bpi.getFSysStatusContact() + "='" + status + "', " + bpi.getFCntContactReceive() + "=" + cnt + " "
                  + "Where " + bpi.getFPatientImportId() + "='" + patient_import_id + "'";
        }else if (sub_system.equals("funds")) {
          sql = "Update " + bpi.getBackTPatientImport() 
                  + " Set " + bpi.getFSysStatusFunds() + "='" + status + "', " + bpi.getFCntFundsReceive() + "=" + cnt + " "
                  + "Where " + bpi.getFPatientImportId() + "='" + patient_import_id + "'";
        }else if (sub_system.equals("doctor")) {
          sql = "Update " + bpi.getBackTPatientImport() 
                  + " Set " + bpi.getFSysStatusDoctor() + "='" + status + "', " + bpi.getFCntDoctorReceive() + "=" + cnt + " "
                  + "Where " + bpi.getFPatientImportId() + "='" + patient_import_id + "'";
        }
        st.executeUpdate(sql);
      }
      conn.close();
    }
    catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  public Integer setUpdatePatientVisitDiscount(Statement st, String branch_id, String patient_visit_id, Double discount) {
    String sql = "";
    int chk = 0;
    try {
      sql = "Update " + bpv.getBackTPatientVisit() 
              + " Set " + bpv.getFVisitDiscount() + "=" + discount + " "
              + "Where " + bpv.getFPatientVisitId() + "='" + patient_visit_id + "' and " + bpv.getFBranchId() + "='" + branch_id + "'";
      chk = st.executeUpdate(sql);
    } catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return Integer.valueOf(chk);
  }
  public Integer setUpdatePatientVisitDiscountCloseDay(Statement st, String branch_id, String close_day, Double discount) {
    String sql = "";
    Integer chk = 0;
    try {
      sql = "Update " + bpv.getBackTPatientVisit() 
              + " Set " + bpv.getFVisitDiscount() + "=" + discount + " "
              + "Where " + bpv.getFCloseDayDate() + "='" + close_day + "' and " + bpv.getFBranchId() + "='" + branch_id + "'";
      chk = st.executeUpdate(sql);
    } catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return chk;
  }
    public String setUpdatePatientVisitTotal(Statement st, String branch_id, String patient_visit_id, Double total) {
        String sql = "";
        Integer chk = 0;
        try {
          sql = "Update " + bpv.getBackTPatientVisit()
                  + " Set " + bpv.getFVisitTotal() + "=" + total + " "
                  + "Where " + bpv.getFPatientVisitId() + "='" + patient_visit_id + "' and "
                  + bpv.getFBranchId() + "='" + branch_id + "'";

          chk = st.executeUpdate(sql);
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setUpdatePatientVisitTotalN(Statement st, String branch_id, String patient_visit_id, Double total) {
        String sql = "";
        Integer chk = 0;
        try {
          sql = "Update " + bpv.getBackTPatientVisit()
                  + " Set " + bpv.getFVisitTotal() + "="+ total + " "
                  + "Where " + bpv.getFPatientVisitId() + "='" + patient_visit_id + "' and "
                  + bpv.getFBranchId() + "='" + branch_id + "'";

          chk = st.executeUpdate(sql);
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
  public String setUpdatePatientVisit(String branch_id, String patient_visit_id, String patient_fullnamet, String visit_vn, 
          String visit_hn, String visit_date, String claim_id, String paid_id, String visit_notice, String claim_name,
          String paid_name, String visit_contact_id, String visit_contact_namet, String contract_payer_number, String visitTotal){
    String sql = "";
    Integer chk=0;
    try{
      patient_fullnamet = patient_fullnamet.replace("'", "''");
      claim_name = claim_name.replace("'", "''");
      paid_name = paid_name.replace("'", "''");
      visit_contact_namet = visit_contact_namet.replace("'", "''");
      visit_notice = visit_notice.replace("'", "''");
      Connection conn = config1.getConnectionBangna();
      Statement st = conn.createStatement();
      if(visitTotal.equals("")) visitTotal = "0.0";
      sql = "Update " + bpv.getBackTPatientVisit() 
            + " Set " + bpv.getFPatientFullnamet() + "='" + patient_fullnamet + "',"
            + bpv.getFVisitHn() + "='" + visit_hn + "',"
            + bpv.getFVisitVn() + "='" + visit_vn + "',"
            + bpv.getFVisitDate() + "='" + visit_date + "',"
            + bpv.getFVisitClaimId() + "='" + claim_id + "',"
            + bpv.getFVisitPaidId() + "='" + paid_id + "', "
            + bpv.getFVisitNotice() + "='" + visit_notice + "', "
            + bpv.getFVisitClaimNamet() + "='" + claim_name + "', "
            + bpv.getFVisitPaidNamet() + "='" + paid_name + "', "
            + bpv.getFEditStatus() + "='1', " + bpv.getFSysStatus() + "='C', "
            + bpv.getFVisitContactId() + "='" + visit_contact_id + "', "
            + bpv.getFVisitContactNamet() + "='" + visit_contact_namet + "', "
            + bpv.getFContractPayerNumber() + "='" + contract_payer_number + "', "
            + bpv.getFVisitTotal() + "=" + visitTotal + " "
            + "Where " + bpv.getFPatientVisitId() + "='" + patient_visit_id + "'";
      chk = st.executeUpdate(sql);
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return chk.toString();
  }
  public void setVoidPatientVisitImport(String branch_id, String patient_import_id, String date_start) {
    String sql = "";
    Integer chk=0;
    try {
      CashierTCloseDay close_day = new CashierTCloseDay();
      Connection conn = config1.getConnectionBangna();
      Statement st = conn.createStatement();
      sql = "Update " + bpv.getBackTPatientVisit() 
              + " Set " + bpv.getFPatientVisitActive() + "='3' "
              + "Where " + bpv.getFPatientImportId() + "='" + patient_import_id + "' and " + bpv.getFBranchId() + "='" + branch_id + "' ";
      chk = st.executeUpdate(sql);
      sql = "Update " + bpvi.getBackTPatientVisitItem() 
              + " Set " + bpvi.getFBillingInvoiceItemActive() + "='3' "
              + "Where " + bpvi.getFPatientVisitId() + " = '" + patient_import_id + "' and " + bpv.getFBranchId() + "='" + branch_id + "' ";
      chk = st.executeUpdate(sql);
      sql = "Update " + bpi.getBackTPatientImport() 
              + " Set " + bpi.getFPatientImportActive() + "='3' "
              + "Where " + bpi.getFPatientImportId() + "='" + patient_import_id + "' and " + bpv.getFBranchId() + "='" + branch_id + "' ";
      chk = st.executeUpdate(sql);
      sql = "Update " + close_day.getCashierTCloseDay() 
              + " Set " + close_day.getFStatusImport() + "='0' "
              + "Where " + close_day.getFCloseDayDate() + "='" + date_start + "' and " + close_day.getFBranchId() + "='" + branch_id + "' ";
      chk = st.executeUpdate(sql);
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
    public void setDeletePatientVisit(String branch_id) {
        String sql = "";
        try    {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Delete From " + bpv.getBackTPatientVisit() + " "
              + "Where " + bpv.getFPatientImportId() + "= '' and " + bpv.getFBranchId() + "='" + branch_id + "' ";
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitImportSysStatus(String branch_id, String patient_import_id, String sub_system, String sys_status) {
        String sql = "";
        try    {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            if (sub_system.equals("contact")) {
                sql = "Update " + bpi.getBackTPatientImport()
                    + " Set " + bpi.getFSysStatusContact() + "='" + sys_status + "' "
                    + "Where " + bpi.getFPatientImportId() + "='" + patient_import_id + "' and "
                    + bpv.getFBranchId() + "='" + branch_id + "' ";
            } else if (sub_system.equals("funds")) {
                sql = "Update " + bpi.getBackTPatientImport()
                    + " Set " + bpi.getFSysStatusFunds() + "='" + sys_status + "' "
                    + "Where " + bpi.getFPatientImportId() + "='" + patient_import_id + "' and "
                    + bpv.getFBranchId() + "='" + branch_id + "' ";
            }
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitSysStatus(String branch_id, String patient_visit_id, String sys_status) {
        String sql = "";
        try {
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          sql = "Update " + bpv.getBackTPatientVisit()
                  + " Set " + bpv.getFSysStatus() + "='" + sys_status + "' "
                  + "Where " + bpv.getFPatientVisitId() + "='" + patient_visit_id + "' and "
                  + bpv.getFBranchId() + "='" + branch_id + "' ";

          st.executeUpdate(sql);
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitItemStatusDoctor(String branch_id, String patient_visit_id, String item_status_doctor) {
        String sql = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpv.getBackTPatientVisit()
                  + " Set " + bpv.getFItemStatusDoctor() + "='" + item_status_doctor + "' "
                  + "Where " + bpv.getFPatientVisitId() + "='" + patient_visit_id + "' and "
                  + bpv.getFBranchId() + "='" + branch_id + "' ";
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitPaid(String branch_id, String patient_visit_id, String paid_id, String paid_namet) {
        String sql = "";
        try {
            paid_namet = paid_namet.replace("'", "''");
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpv.getBackTPatientVisit()
                  + " Set " + bpv.getFVisitPaidId() + "='" + paid_id + "', "
                  + bpv.getFVisitPaidNamet() + "='" + paid_namet + "' "
                  + "Where " + bpv.getFPatientVisitId() + "='" + patient_visit_id + "' and "
                  + bpv.getFBranchId() + "='" + branch_id + "' ";
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    public Vector getBackPatientVisitGroupByPaid(String patient_import_id, String flag, String where) {
        Vector v_patient_visit = new Vector();
        BackTPatientVisitGroupPaidNamet back_patient_visit_group_namet = new BackTPatientVisitGroupPaidNamet();
        String sql = "";
        if (flag.equals("paidnamet")) {
          if (where.length() > 0) {
            sql = "select " + bpv.getFVisitPaidId() + ", " + bpv.getFVisitPaidNamet()
                    + ", count(1) as cnt, sum(" + bpv.getFVisitTotal() + ") as amt "
                    + "From back_t_patient_visit  left join " + b_transfer.getBackBTransfer()
                    + " on " + bpv.getFVisitPaidId() + " = " + b_transfer.getFPaidId() + " and "
                    + bpv.getFPatientVisitActive() + "='1' "
                    + "Where " + bpv.getFPatientImportId() + "='" + patient_import_id + "' and "
                    + b_transfer.getFBDepartmentId() + "='" + where + "' "
                    + "Group By " + bpv.getFVisitPaidId() + ", " + bpv.getFVisitPaidNamet() + " "
                    + "Order By " + bpv.getFVisitPaidNamet();
          }else{
            sql = "select " + bpv.getFVisitPaidId() + ", " + bpv.getFVisitPaidNamet()
                    + ", count(1) as cnt, sum(" + bpv.getFVisitTotal() + ") as amt "
                    + "From back_t_patient_visit  "
                    + "Where " + bpv.getFPatientImportId() + "='" + patient_import_id + "' and "
                    + bpv.getFPatientVisitActive() + "='1' "
                    + "Group By " + bpv.getFVisitPaidId() + ", " + bpv.getFVisitPaidNamet() + " "
                    + "Order By " + bpv.getFVisitPaidNamet();
          }
        }else if (where.length() > 0) {
          sql = "select " + bpv.getFBVisitClinicId() + ", " + bpv.getFVisitHospitalService()
                  + ", count(1) as cnt, sum(" + bpv.getFVisitTotal() + ") as amt "
                  + "From back_t_patient_visit  "
                  + "left join " + b_transfer.getBackBTransfer()
                  + " on " + bpv.getFVisitPaidId() + " = " + b_transfer.getFPaidId() + " and " + bpv.getFPatientVisitActive() + "='1' "
                  + "Where " + bpv.getFPatientImportId() + "='" + patient_import_id + "' and "
                  + b_transfer.getFBDepartmentId() + "='" + where + "' "
                  + "Group By " + bpv.getFBVisitClinicId() + ", " + bpv.getFVisitClinicDescription() + " "
                  + "Order By " + bpv.getFVisitClinicDescription();
        }else{
          sql = "select " + bpv.getFBVisitClinicId() + ", " + bpv.getFVisitClinicDescription()
                  + ", count(1) as cnt, sum(" + bpv.getFVisitTotal() + ") as amt "
                  + "From back_t_patient_visit  "
                  + "Where " + bpv.getFPatientImportId() + "='" + patient_import_id + "' and " + bpv.getFPatientVisitActive() + "='1' "
                  + "Group By " + bpv.getFBVisitClinicId() + ", " + bpv.getFVisitClinicDescription() + " "
                  + "Order By " + bpv.getFVisitClinicDescription();
        }
        try{
          Connection conn = config1.getConnectionBangna();
          Statement st = conn.createStatement();
          ResultSet rs = st.executeQuery(sql);
          while (rs.next()) {
            if (flag.equals("paidnamet")) {
              back_patient_visit_group_namet = new BackTPatientVisitGroupPaidNamet();
              back_patient_visit_group_namet.setPaidId(rs.getString(bpv.getFVisitPaidId()));
              back_patient_visit_group_namet.setPaidNamet(rs.getString(bpv.getFVisitPaidNamet()));
              back_patient_visit_group_namet.setCntPaidNamet(rs.getString("cnt"));
              back_patient_visit_group_namet.setAmtPaidNamet(rs.getString("amt"));
            } else {
              back_patient_visit_group_namet = new BackTPatientVisitGroupPaidNamet();
              back_patient_visit_group_namet.setPaidId(rs.getString(bpv.getFBVisitClinicId()));
              back_patient_visit_group_namet.setPaidNamet(rs.getString(bpv.getFVisitClinicDescription()));
              back_patient_visit_group_namet.setCntPaidNamet(rs.getString("cnt"));
              back_patient_visit_group_namet.setAmtPaidNamet(rs.getString("amt"));
            }
            v_patient_visit.add(back_patient_visit_group_namet);
          }
          rs.close();
          conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_patient_visit;
    }
  public String getTrPatientVisitGroupPaidNamet(String patient_import_id, String where) {
    String row_color = ""; String text_h = ""; String paid_id = "";
    Integer row = Integer.valueOf(0);
    Double total=0.0, sumTotal=0.0;
    Vector v_patient_visit_group_paid_namet = new Vector();
    text_h = "<thead> <tr align='center' class='style14r'><th width='10' align='center'>ลำดับ</th> "
            + "<th width='70' align='left'>รหัส</th> "
            + "<th width='300' align='left'>ประเภทการรับชำระ</th> <th width='70' align='left'>จน.bill</th> "
            + "<th width='70' align='left'>ยอด</th> </tr></thead>";

    txt.delete(0, txt.length());
    v_patient_visit_group_paid_namet = getBackPatientVisitGroupByPaid(patient_import_id, "paidnamet", where);
    for (int i = 0; i <= v_patient_visit_group_paid_namet.size() - 1; i++) {
      Integer localInteger1 = row; Integer localInteger2 = row = Integer.valueOf(row.intValue() + 1);
      bpv_gp = ((BackTPatientVisitGroupPaidNamet)v_patient_visit_group_paid_namet.get(i));
      if (bpv_gp.getPaidId().equals("-"))
        paid_id = "10";
      else {
        paid_id = "1" + bpv_gp.getPaidId();
      }
      total = Double.parseDouble(bpv_gp.getAmtPaidNamet());
      sumTotal+=total;
      txt.append("<tr class='style14' ").append(row_color).append("><td width='10' align='center'>").append(row.toString()).append("</td>")
              .append("<td align='center' width='20'>").append(bpv_gp.getPaidId()).append("</td>")
              .append("<td ><a href='javascript:detailshowpaid(").append(paid_id).append(")'>").append(bpv_gp.getPaidNamet()).append("</a></td>")
              .append("<td align='center'>").append(bpv_gp.getCntPaidNamet()).append("</td>")
              .append("<td align='right'>").append(config1.NumberFormat(total)).append("</td></tr>");
    }
    return "<table widht='100%'>" + text_h + txt.toString() + "<tr><td colspan='5' align='right'><font ><b> รวม &nbsp;&nbsp;&nbsp;"+config1.NumberFormat(sumTotal)+"</b></font></td></tr></table>";
  }
  public String getTrPatientVisitGroupClinic(String patient_import_id, String where) {
    String row_color = ""; String text_h = ""; String paid_id = "";
    Integer row = Integer.valueOf(0);
    Vector v_patient_visit_group_paid_namet = new Vector();
    text_h = "<thead> <tr align='center' class='style14r'><th width='55' align='center'>ลำดับ</th> <th width='300' align='left'>แผนก</th> "
            + "<th width='70' align='left'>visit</th> <th width='70' align='left'>ยอด</th> </tr></thead>";

    txt.delete(0, txt.length());
    v_patient_visit_group_paid_namet = getBackPatientVisitGroupByPaid(patient_import_id, "clinic", where);
    for (int i = 0; i <= v_patient_visit_group_paid_namet.size() - 1; i++) {
      Integer localInteger1 = row; Integer localInteger2 = row = Integer.valueOf(row.intValue() + 1);
      bpv_gp = ((BackTPatientVisitGroupPaidNamet)v_patient_visit_group_paid_namet.get(i));
      paid_id = bpv_gp.getPaidId().substring(3);
      txt.append("<tr class='style14' ").append(row_color).append("><td width='10' align='center'>").append(row.toString())
              .append("</td>").append("<td ><a href='javascript:detailshowclinic(").append(paid_id).append(")'>")
              .append(bpv_gp.getPaidNamet()).append("</a></td>").append("<td align='center'>").append(bpv_gp.getCntPaidNamet())
              .append("</td>").append("<td align='right'>").append(config1.NumberFormat(bpv_gp.getAmtPaidNamet())).append("</td></tr>");
    }
    return "<table widht='100%'>" + text_h + txt.toString() + "</table>";
  }
  public Vector getPatientVisitBillingInvoice(String branch_id, String visit_date_start, String visit_date_end, String visit_hn, String flag) {
    Vector v_patient_visit = new Vector();
    String time = ""; String visit_date = ""; String sql = ""; String description = "";
    if (flag.equals("period_date")) {
      sql = "Select pt01.mnc_vn_no, pt01.mnc_vn_seq, ft03.MNC_FN_NO, ft03.MNC_FN_DAT, ft03.MNC_HN_NO, ft03.MNC_PRE_NO, "
              + "ft03.MNC_FN_TYP_CD, ft03.MNC_FN_PAD, fm01.MNC_FN_DSCT, ft03.MNC_DOT_CD_DF, ft03.MNC_DEP_NO, ft03.MNC_FN_TIME, "
              + "ft03.MNC_FN_DAT , ft03.MNC_FN_AMT, ft03.MNC_FN_OUT, ft03.MNC_FN_DIS "
              + "From finance_t03 ft03 "
              + "left join patient_t01 pt01 on ft03.mnc_hn_no = pt01.mnc_hn_no and ft03.mnc_hn_yr = pt01.mnc_hn_yr and "
              + "ft03.mnc_pre_no = pt01.mnc_pre_no left join finance_m01 fm01 on ft03.MNC_FN_CD = fm01.MNC_FN_CD  "
              + "Where ft03.MNC_FN_DAT = '" + visit_date_start + "' and ft03.MNC_FN_DAT ='" + visit_date_end + "' and "
              + "ft03.MNC_FN_PAD is not null " + " and pt01.mnc_sts <> 'C' "
              + "Order By ft03.MNC_FN_DAT, ft03.MNC_FN_TIME ";
    }else if (flag.equals("hn")) {
      sql = "Select pt01.mnc_vn_no, pt01.mnc_vn_seq, ft03.MNC_FN_NO, ft03.MNC_FN_DAT, ft03.MNC_HN_NO, ft03.MNC_PRE_NO, "
              + "ft03.MNC_FN_TYP_CD, ft03.MNC_FN_PAD, fm01.MNC_FN_DSCT, ft03.MNC_DOT_CD_DF, ft03.MNC_DEP_NO, ft03.MNC_FN_TIME, "
              + "ft03.MNC_FN_DAT , ft03.MNC_FN_AMT, ft03.MNC_FN_OUT, ft03.MNC_FN_DIS "
              + "From finance_t03 ft03 "
              + "left join patient_t01 pt01 on ft03.mnc_hn_no = pt01.mnc_hn_no and ft03.mnc_hn_yr = pt01.mnc_hn_yr and "
              + "ft03.mnc_pre_no = pt01.mnc_pre_no left join finance_m01 fm01 on ft03.MNC_FN_CD = fm01.MNC_FN_CD  "
              + "Where ft03.MNC_FN_DAT = '" + visit_date_start + "' and ft03.MNC_FN_DAT ='" + visit_date_end + "' and "
              + "ft03.MNC_FN_PAD is not null " + " and pt01.mnc_sts <> 'C' and pt01.mnc_hn_no = '" + visit_hn + "' "
              + "Order By ft03.MNC_FN_DAT, ft03.MNC_FN_TIME ";
    }else {
      sql = "Select pt01.mnc_vn_no, pt01.mnc_vn_seq, ft03.MNC_FN_NO, ft03.MNC_FN_DAT, ft03.MNC_HN_NO, ft03.MNC_PRE_NO, "
              + "ft03.MNC_FN_TYP_CD, ft03.MNC_FN_PAD, fm01.MNC_FN_DSCT, ft03.MNC_DOT_CD_DF, ft03.MNC_DEP_NO, ft03.MNC_FN_TIME, "
              + "ft03.MNC_FN_DAT , ft03.MNC_FN_AMT, ft03.MNC_FN_OUT, ft03.MNC_FN_DIS "
              + "From finance_t03 ft03 "
              + "left join patient_t01 pt01 on ft03.mnc_hn_no = pt01.mnc_hn_no and ft03.mnc_hn_yr = pt01.mnc_hn_yr and "
              + "ft03.mnc_pre_no = pt01.mnc_pre_no left join finance_m01 fm01 on ft03.MNC_FN_CD = fm01.MNC_FN_CD  "
              + "Where ft03.MNC_FN_DAT = '" + visit_date_start + "' and ft03.MNC_FN_DAT ='" + visit_date_end + "' and "
              + "ft03.MNC_FN_PAD is not null " + " and pt01.mnc_sts <> 'C' "
              + "Order By ft03.MNC_FN_DAT, ft03.MNC_FN_TIME ";
    }
    try{
      Connection connmainhis = config1.getConnectionMainHIS(branch_id);
      Statement stmainhis = connmainhis.createStatement();
      ResultSet rsmainhis = stmainhis.executeQuery(sql);
      while (rsmainhis.next()) {
        if (rsmainhis.getString("MNC_FN_TIME") == null)
          time = "0000";
        else {
          time = "0000" + rsmainhis.getString("MNC_FN_TIME");
        }
        time = time.substring(time.length() - 4, time.length());
        if (rsmainhis.getString("MNC_FN_DAT").length() >= 10)
          visit_date = rsmainhis.getString("MNC_FN_DAT").substring(0, 10);
        else {
          visit_date = rsmainhis.getString("MNC_FN_DAT");
        }
        description = rsmainhis.getString("MNC_FN_DSCT");
        description = description.replace("'", "''");
        bpvi = new BackTPatientVisitItem();
        bpvi.setBItemBillingSubgroupId(rsmainhis.getString("mnc_hn_no"));
        bpvi.setBItemId(rsmainhis.getString("MNC_FN_NO"));
        bpvi.setBillingInvoiceItemActive("1");
        bpvi.setBillingInvoiceItemTotal(Double.valueOf(Double.parseDouble(rsmainhis.getString("MNC_FN_PAD"))));
        bpvi.setBillingInvoiceNumber("");

        bpvi.setClaimId(rsmainhis.getString("MNC_FN_TYP_CD"));
        bpvi.setClaimNamet(rsmainhis.getString("MNC_FN_TYP_CD"));
        bpvi.setDepartmentNamet(rsmainhis.getString("MNC_DEP_NO"));
        bpvi.setPatientVisitBillingItemId("");
        bpvi.setPatientVisitId("");

        bpvi.setTBillingId("");
        bpvi.setTBillingInvoiceDateTime(visit_date);
        bpvi.setTBillingInvoiceItemId(rsmainhis.getString("MNC_FN_NO"));
        bpvi.setTBillingInvoiceItemNamet(description);
        bpvi.setTBillingInvoiceTime(time);

        bpvi.setTOrderItemId("");
        bpvi.setTPatientId("");
        bpvi.setTPaymentId(rsmainhis.getString("MNC_PRE_NO"));
        bpvi.setVisitId("");
        bpvi.setBranchId(branch_id);

        if (rsmainhis.getString("MNC_DOT_CD_DF") == null)
          bpvi.setVisitPatientSelfDoctor("");
        else {
          bpvi.setVisitPatientSelfDoctor(rsmainhis.getString("MNC_DOT_CD_DF"));
        }

        bpvi.setVisitVn(rsmainhis.getString("mnc_vn_no") + "." + rsmainhis.getString("mnc_vn_seq"));
        bpvi.setVisitHn(rsmainhis.getString("mnc_hn_no"));
        bpvi.setDepartmentId(rsmainhis.getString("MNC_DEP_NO"));
        if (rsmainhis.getString("MNC_FN_DIS") == null)
          bpvi.setItemDiscount(0.0);
        else {
          bpvi.setItemDiscount(Double.valueOf(Double.parseDouble(rsmainhis.getString("MNC_FN_DIS"))));
        }
        if (rsmainhis.getString("MNC_FN_PAD") == null)
          bpvi.setItemPaid(0.0);
        else {
          bpvi.setItemPaid(Double.parseDouble(rsmainhis.getString("MNC_FN_PAD")));
        }
        if (rsmainhis.getString("MNC_FN_AMT") == null)
          bpvi.setItemTotal(0.0);
        else {
          bpvi.setItemTotal(Double.valueOf(Double.parseDouble(rsmainhis.getString("MNC_FN_AMT"))));
        }
        v_patient_visit.add(bpvi);
      }
      rsmainhis.close();
      connmainhis.close();
    }
    catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return v_patient_visit;
  }
  public String getContractPayerNumberFromContractPlan(String branch_id, String contract_plan_number)  {
    String sql = ""; String txt = "";
    try {
      Connection conn = config1.getConnectionHospital(branch_id);
      Statement st = conn.createStatement();
      sql = "select contract_payer_number from b_contract_payer  where b_contract_payer_id = (select b_contract_payer_id from b_contract_plans where contract_plans_number = '" + contract_plan_number + "') ";

      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        txt = rs.getString("contract_payer_number");
      }
      conn.close();
    } catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return txt;
  }
    public void setUpdatePatientVisitVoid(String branch_id, String patient_visit_id) {
        String sql = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpv.getBackTPatientVisit()
                + " Set " + bpv.getFPatientVisitActive() + "='3' "
                + "Where " + bpv.getFPatientVisitId() + "='" + patient_visit_id + "' and "
                + bpv.getFBranchId() + "='" + branch_id + "'";
            st.executeUpdate(sql);
            sql = "Update " + bpvi.getBackTPatientVisitItem()
                + " Set " + bpvi.getFBillingInvoiceItemActive() + "='3' "
                + "Where " + bpvi.getFPatientVisitId() + "='" + patient_visit_id + "' and "
                + bpvi.getFBranchId() + "='" + branch_id + "'";
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdatePatientVisitNoReceive(String branch_id, String patient_visit_id, String close_day, String subsystem) {
        String sql = "";
        Vector v_bpv = new Vector();
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpv.getBackTPatientVisit()
                  + " Set " + bpv.getFSysStatus() + "='X' "
                  + "Where " + bpv.getFPatientVisitId() + "='" + patient_visit_id + "' and "
                  + bpv.getFBranchId() + "='" + branch_id + "'";
            st.executeUpdate(sql);
            conn.close();
            v_bpv = getBackTPatientVisit(branch_id, patient_visit_id, "D", "close_day");
            if (v_bpv.size() <= 0) {
                if (subsystem.equals("funds")) {
                  sql = "Update " + bpi.getBackTPatientImport()
                          + " Set " + bpi.getFSysStatusFunds() + "='Y' "
                          + "Where " + bpi.getFDateStart() + "='" + close_day + "' and " + bpvi.getFBranchId() + "='" + branch_id + "'";
                }else{
                  sql = "Update " + bpi.getBackTPatientImport()
                          + " Set " + bpi.getFSysStatusContact() + "='Y' "
                          + "Where " + bpi.getFDateStart() + "='" + close_day + "' and " + bpvi.getFBranchId() + "='" + branch_id + "'";
                }
                st.executeUpdate(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getTrPatientVisitCloseDay(String branchId, String dateStart, String dateEnd, String fVisitTypeId, String flag){
        String sql="", txt="", txtH="",txtF="", fVisitTypeSearch="", dateEndSearch="", link="",nodeParent="",fVisitTypeId1="";
        String nodeChild="",txtChild="",font_blue="",font_green="", paidId="", dateStart1="", dateEnd1="";
        if(!fVisitTypeId.equals("")){
            if(fVisitTypeId.equals("2")){
                fVisitTypeId1 = "'0','1'";
            }else{
                fVisitTypeId1 = "'"+fVisitTypeId+"'";
            }
            fVisitTypeSearch = " and "+bpv.getFFVisitTypeId() +" in ("+fVisitTypeId1+") ";
        }
        if(!dateEnd.equals(""))
            dateEndSearch = " and "+bpv.getFCloseDayDate() +"<='"+dateEnd+"' ";
        Integer i=0, row=0;
        Double nettotal=0.0, total=0.0, discount=0.0;
        font_blue="<font color='blue'>";
        font_green="<font color='green'>";
        if(flag.equals("detail")){
            sql="Select distinct "+bpv.getFCloseDayDate()+" From "+bpv.getBackTPatientVisit()
                +" Where "+bpv.getFCloseDayDate()+" >= '"+dateStart+"' "+dateEndSearch+" and "
                +bpv.getFPatientVisitActive()+"='1' and "+bpv.getFBranchId()+" = '"+branchId+"' "+fVisitTypeSearch
                +" Order By "+bpv.getFCloseDayDate();
        }else{
            sql ="Select * From b_branch Where branch_id = '"+branchId+"'";
        }
        
        try {
            Connection conn, connPaid;
            conn = config1.getConnectionBangna();
            connPaid = config1.getConnectionBangna();
//            connItem = config1.getConnectionBangna();
            Statement st, stPaid;
            st = conn.createStatement();
            stPaid = conn.createStatement();
//            stItem = conn.createStatement();
            ResultSet rs, rsPaid, rsItem;
            rs = st.executeQuery(sql);
            while(rs.next()){
                row++;
                
                txtChild="";
                if(flag.equals("detail")){
                    dateStart1 = rs.getString(bpv.getFCloseDayDate());
                    dateEnd1 = rs.getString(bpv.getFCloseDayDate());
                    nodeParent="tr_"+rs.getString(bpv.getFCloseDayDate());
                    txt += "<tr id='"+nodeParent+"'><td>"+row+"</td><td>"
                            +config1.DateFormatDB2ShowHospital(rs.getString(bpv.getFCloseDayDate()),"ddMMyyyy")+"</td></tr>";
                }else{
                    dateStart1 = dateStart;
                    dateEnd1 = dateEnd;
                    nodeParent="tr_"+dateStart;
                    txt += "<tr id='"+nodeParent+"'><td>"+row+"</td><td>"
                            +config1.DateFormatDB2ShowHospital(dateStart,"ddMMyyyy")+" "+config1.DateFormatDB2ShowHospital(dateEnd,"ddMMyyyy")+"</td></tr>";
                }
                
                sql = "Select "+bpv.getFVisitPaidId()+","+bpv.getFVisitPaidNamet()+", count(1) as cnt, sum(visit_total) as visit_total, sum(visit_discount) as visit_discount "
                    +" From back_t_patient_visit  "
                    +" Where "+bpv.getFCloseDayDate()+" >= '"+dateStart1+"' and "+bpv.getFCloseDayDate()+"<='"+dateEnd1+"' and "
                    +bpv.getFPatientVisitActive()+"='1' and "+bpv.getFBranchId()+" = '"+branchId+"' "+fVisitTypeSearch
                    +" Group by "+bpv.getFVisitPaidId()+","+bpv.getFVisitPaidNamet()+" "
                    +" Order By "+bpv.getFVisitPaidId();
                rsPaid = stPaid.executeQuery(sql);
                while(rsPaid.next()){
                    i++;
                    nodeChild=dateStart1+"_"+rsPaid.getString(bpv.getFVisitPaidId())+"_"+i;
                    total = rsPaid.getDouble(bpv.getFVisitTotal());
                    discount = rsPaid.getDouble(bpv.getFVisitDiscount());
                    nettotal = total + discount;
                    paidId = "1"+rsPaid.getString(bpv.getFVisitPaidId());
                    link = "<a href='javascript:showCloseDay("+dateStart1.replaceAll("-", "")+dateEnd1.replaceAll("-", "")+","
                            +paidId+","+fVisitTypeId+")'>"
                            +rsPaid.getString(bpv.getFVisitPaidNamet())+" ["+rsPaid.getString(bpv.getFVisitPaidId())+"]</a>";
                    txtChild+="<tr id='"+nodeChild+"' class ='child-of-"+nodeParent+"'><td>&nbsp;&nbsp;&nbsp;</td>" +
                        "<td colspan='3' >"+font_green+link+"</font></td>" +
                        "<td colspan='2'>"+font_green+"จำนวนเงิน "+config1.NumberFormat(nettotal)+"</font></td>" +
                        "<td>"+font_green+" visit "+config1.IntegerFormat(rsPaid.getString("cnt"))+"</font></td>"
                        + "</tr>";
                }
                rsPaid.close();
                txt+=txtChild;
                
            }
            rs.close();
            conn.close();
            connPaid.close();
//            connItem.close();
            txtH = "<table width='500' align='center' id='example' class='display'><tr><th widht='50'>ลำดับ</th><th>วันที่</th>";
            txtF="</table>";
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return txtH+txt;
    }
    public String setUpdatePatientVisitItemVoid(String branch_id, String bpviId) {
        Integer chk=0;
        String sql = "";
        try {
        Connection conn = config1.getConnectionBangna();
        Statement st = conn.createStatement();
        sql = "Update " + bpvi.getBackTPatientVisitItem()
              + " Set " + bpvi.getFBillingInvoiceItemActive() + "='3' "
              + "Where " + bpvi.getFPatientVisitItemId() + "='" + bpviId + "' and "
              + bpvi.getFBranchId() + "='" + branch_id + "'";
        chk = st.executeUpdate(sql);
        conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setUpdatePatientVisitItemPrice(String branch_id, String bpviId, String itemPrice) {
        Integer chk=0;
        String sql = "";
        try {
        Connection conn = config1.getConnectionBangna();
        Statement st = conn.createStatement();
        sql = "Update " + bpvi.getBackTPatientVisitItem()
              + " Set " + bpvi.getFItemTotal() + "="+itemPrice+" "
              + "Where " + bpvi.getFPatientVisitItemId() + "='" + bpviId + "' and "
              + bpvi.getFBranchId() + "='" + branch_id + "'";
        chk = st.executeUpdate(sql);
        
        conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String setUpdatePatientVisitItemName(String branch_id, String bpviId,String itemName) {
        Integer chk=0;
        String sql = "";
        try {
            itemName.replaceAll("'", "''");
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + bpvi.getBackTPatientVisitItem()
                  + " Set " + bpvi.getFTBillingInvoiceItemNamet() + "='"+itemName+"' "
                  + "Where " + bpvi.getFPatientVisitItemId() + "='" + bpviId + "' and "
                  + bpvi.getFBranchId() + "='" + branch_id + "'";
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public Vector getPatientVisitAutoSearch(String branchId, String visitHn) {
    String sql = "", searchHn="";
    Vector v = new Vector();
    try{
        if(!visitHn.equals("")) searchHn = " and "+bpv.getFVisitHn()+" like '"+visitHn+"%' ";
        
        Connection conn = config1.getConnectionBangna();
        Statement st = conn.createStatement();
        sql = "Select Distinct "+bpv.getFVisitHn()+","+bpv.getFPatientFullnamet()+" "
            + "From " + bpv.getBackTPatientVisit() +" "
            + "Where " + bpv.getFPatientVisitActive() + "='1' "+searchHn
                +"Order By "+bpv.getFVisitHn()
                +" limit 40";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            bpv = new BackTPatientVisit();
            bpv.setVisitHn(rs.getString(bpv.getFVisitHn()));
            bpv.setPatientFullnamet(rs.getString(bpv.getFPatientFullnamet()));
            v.add(bpv);
        }
        rs.close();
        conn.close();
    }catch (Exception ex) {
      Logger.getLogger(BackTPatientVisitDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return v;
  }
}