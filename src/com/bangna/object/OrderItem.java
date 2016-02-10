/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangna.object;

import com.bangna.usecase.connection.Persistent;
import java.util.Vector;

/**
 *
 * @author root
 */
public class OrderItem extends Persistent{
    public String visit_id = "";
    public String item_code = "";
    public String vertifier = "";
    public String vertify_time = "";
    public String executer = "";
    public String executed_time = "";
    public String discontinue = "";
    public String discontinue_time = "";
    public String dispense = "";
    public String dispense_time = "";
    public String reporter = "";
    public String reported_time = "";
    public String clinic_code = "";
    /**ประกอบด้วย 1. ยา 2. Lab 3.XRay 4.เวชภัณฑ์ 5. 8ค่าบริการ*/
    public String category_group = "";
    public String charge_complete = "";
    public String status = "";
    public String secret = "";
    public String continue_order = "";
    public String price = "0";
    public String qty = "0";
    public String item_group_code_billing = "";
    public String hn = "";
    public String common_name = "";
    public String refer_out = "0";
    public String request = "0";
    public String order_user = "";
    public String order_time = "";
    public String order_complete = "0";
    public String order_cost = "0";
    public String note = "";
    public String specified = "";
    public String specified_data = "";
    public String order_start_time = "";
    public String order_end_time = "";
    public String doctor_id = "";
    /**
     *???a??????????ก??????? sumo
     **/
    public String cause_cancel_resultlab = "";
    /**ของเดิมเป็น category_group_code
    เก็บรหัสของ กลุ่ม category
     */
    public String item_group_code_category = "";
    public String drug_allergy = "0";//amp:30/03/2549 ??????????????????????????
    /**??ก?แ?????*/
    public String order_home = "0";
    public String item_16_group = "";//sumo:06/06/2549 ?????????? 16 ??ก????๐?
    public OrderItemDrug theOrderItemDrug;
    public String sDrugInteraction = "";
    public Vector vOrderDrugInteraction;
    //0=ในเวลา 1=นอกเวลา
    public String status_doctor = "0";
    /**
     * ผู้ยืนยันผลแลป
     */
    public String result_lab_approve_staff = "";
    public String alert = "";//1=แจ้งเตือน 2=แจ้งเตือนและต้องการ user/pass
    public String order_approve_staff = "";
    public String order_approve_date_time = "";
    public String item_billing_subgroup_number = "";
    
    public String statusPrintReportItem = "";
    public String order_operation_no = "";
    public String order_operation_status = "";
    public String new_order_operation = "";
    
    /**
     * @roseuid 3F658BBB036E
     */
    public OrderItem() {
    }

    public String toString() {
        return common_name;
    }

    public boolean isChargeComplete() {
        return charge_complete.equals("1");
    }

    public boolean isDrug() {
        return this.category_group.equals(CategoryGroup.isDrug());
    }

    public boolean isLab() {
        return this.category_group.equals(CategoryGroup.isLab());
    }

    public boolean isXray() {
        return this.category_group.equals(CategoryGroup.isXray());
    }

    public boolean isSupply() {
        return this.category_group.equals(CategoryGroup.isSupply());
    }

    public boolean isService() {
        return this.category_group.equals(CategoryGroup.isService());
    }

    public boolean isDental() {
        return this.category_group.equals(CategoryGroup.isDental());
    }
}
