/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;

/**
 *
 * @author root
 */
public class BPrintJobDB {
    public Config1 config1 = new Config1();
    public BPrintDoc pdoc = new BPrintDoc();
    public BPrintJob pjob = new BPrintJob();
    public String getMaxRowBPrintDoc(Statement st) {
        String sql = "", max = "";
        try {
//            Statement st = conn.createStatement();
            sql = "Select max(" + pdoc.getFDocId() + ") as cnt From " + pdoc.getBPrintDoc();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))
                max = String.valueOf(Integer.parseInt(max) + 1);
            else
                max = "1940000001";
        } catch (Exception ex) {
            Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowBPrintJob(Statement st) {
        String sql = "", max = "";
        try {
//            Statement st = conn.createStatement();
            sql = "Select max(" + pjob.getFPrintJobId() + ") as cnt From " + pjob.getBPrintJob();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))
                max = String.valueOf(Integer.parseInt(max) + 1);
            else
                max = "1970000001";
        } catch (Exception ex) {
            Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public BPrintDoc getBPrintDocByPK(String branch_id, String doc_id,  String flag){
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            pdoc = getBPrintDocByPK(stbangna, branch_id, doc_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pdoc;
    }
    public BPrintDoc getBPrintDocByPK(Statement stbangna, String branch_id, String doc_id,  String flag) {
        String sql = "";
        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();
            sql = "Select * "
            +"From "+pdoc.getBPrintDoc() + " "
            +"Where "+pdoc.getFDocId() + "='" + doc_id + "' ";
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                pdoc = new BPrintDoc();
                pdoc.setDescription(config1.StringNull(rs.getString(pdoc.getFDescription())));
                pdoc.setDocActive(config1.StringNull(rs.getString(pdoc.getFDocActive())));
                pdoc.setDocId(config1.StringNull(rs.getString(pdoc.getFDocId())));
                pdoc.setDocName(config1.StringNull(rs.getString(pdoc.getFDocName())));
            }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pdoc;
    }
    public Vector getBPrintDoc(String branch_id, String doc_id,  String flag){
        Vector v_pdoc = new Vector();
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            v_pdoc = getBPrintDoc(stbangna, branch_id, doc_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_pdoc;
    }
    public Vector getBPrintDoc(Statement stbangna, String branch_id, String doc_id,  String flag) {
        Vector v_pdoc = new Vector();
        String sql = "";
        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();
            sql = "Select * "
            +"From "+pdoc.getBPrintDoc() + " "
            +"Where "+pdoc.getFDocActive() + "='1' "
                    + "Order By "+pdoc.getFDocId();
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                pdoc = new BPrintDoc();
                pdoc.setDescription(config1.StringNull(rs.getString(pdoc.getFDescription())));
                pdoc.setDocActive(config1.StringNull(rs.getString(pdoc.getFDocActive())));
                pdoc.setDocId(config1.StringNull(rs.getString(pdoc.getFDocId())));
                pdoc.setDocName(config1.StringNull(rs.getString(pdoc.getFDocName())));
                v_pdoc.add(pdoc);
            }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_pdoc;
    }
    public BPrintJob getBPrintJobByPK(String branch_id, String doc_id, String job_id,  String flag){
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            pjob = getBPrintJobByPK(stbangna, branch_id,doc_id, job_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pjob;
    }
    public BPrintJob getBPrintJobByPK(Statement stbangna, String branch_id, String doc_id, String job_id,  String flag) {
        String sql = "";
        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();
            if(flag.equals("com_id")){
                sql = "Select * "
            +"From "+pjob.getBPrintJob() + " "
            +"Where "+pjob.getFDocId() + "='" + doc_id + "' and "+pjob.getFCompId()+"='"+job_id+"' ";
            }else if(flag.equals("com_id_by_doc_name")){
                sql = "Select pjob.* "
            +"From "+pjob.getBPrintJob() + " pjob "
            + "left join "+pdoc.getBPrintDoc()+" pdoc on pjob."+pjob.getFDocId()+"="+pdoc.getFDocId()+" "
            +"Where pjob."+pdoc.getFDocName() + "='" + doc_id + "' and pjob."+pjob.getFCompId()+"='"+job_id+"' ";
            }else{
                sql = "Select * "
            +"From "+pjob.getBPrintJob() + " "
            +"Where "+pjob.getFPrintJobId() + "='" + job_id + "' ";
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                pjob = new BPrintJob();
                pjob.setCompId(config1.StringNull(rs.getString(pjob.getFCompId())));
                pjob.setDocId(config1.StringNull(rs.getString(pjob.getFDocId())));
                pjob.setPrintJobId(config1.StringNull(rs.getString(pjob.getFPrintJobId())));
                pjob.setPrinterName(config1.StringNull(rs.getString(pjob.getFPrintName())));
                pjob.setStatusDialog(config1.StringNull(rs.getString(pjob.getFStatusDialog())));
            }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pjob;
    }
    public Vector getBPrintJob(String branch_id, String job_id,  String flag){
        Vector v_pjob = new Vector();
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            v_pjob = getBPrintJob(stbangna, branch_id, job_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_pjob;
    }
    public Vector getBPrintJob(Statement stbangna, String branch_id, String job_id,  String flag) {
        Vector v_pjob = new Vector();
        String sql = "";
        try {
//            Connection conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();
            if(flag.equals("select_job")){
                sql = "Select * "
            +"From "+pjob.getBPrintJob() + " "
            +"Where "+pjob.getFDocId() + "='" + job_id + "' "
                        + "Order By "+pjob.getFPrintJobId();
            }else{
                sql = "Select * "
            +"From "+pjob.getBPrintJob() + " "
            +"Where "+pjob.getFPrintJobId() + "='" + job_id + "' "
             + "Order By "+pjob.getFPrintJobId();
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while (rs.next()) {
                pjob = new BPrintJob();
                pjob.setCompId(config1.StringNull(rs.getString(pjob.getFCompId())));
                pjob.setDocId(config1.StringNull(rs.getString(pjob.getFDocId())));
                pjob.setPrintJobId(config1.StringNull(rs.getString(pjob.getFPrintJobId())));
                pjob.setPrinterName(config1.StringNull(rs.getString(pjob.getFPrintName())));
                pjob.setStatusDialog(config1.StringNull(rs.getString(pjob.getFStatusDialog())));
                v_pjob.add(pjob);
            }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
          Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_pjob;
    }
    public String setSaveBPrintDoc(String branch_id,BPrintDoc item) throws Exception {
        int chk = 0;
        String sql = "", max = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            pdoc = getBPrintDocByPK(branch_id, item.getDocId(),"");
            item.setDescription(config1.StringNull(item.getDescription()).replace("'", "''"));
            item.setDocName(config1.StringNull(item.getDocName()).replace("'", "''"));
//            item.setVisitDiagnosisNotice(config1.StringNull(item.getVisitDiagnosisNotice()).replace("'", "''"));
            if (pdoc.getDocId().equals("")) {
                max = getMaxRowBPrintDoc(st);
                sql = "Insert Into " + pdoc.getBPrintDoc()
                    + "(" + pdoc.getFDocId() + ", " + pdoc.getFDescription() + ", "
                    + pdoc.getFDocActive() + "," + pdoc.getFDocName() + ")"
                    + "Values('" + max + "','" + item.getDescription() + "','"
                    + item.getDocActive() + "','" + item.getDocName() + "')";
            }else{
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String setSaveBPrintJob(String branch_id,BPrintJob item) throws Exception {
        int chk = 0;
        String sql = "", max = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            pjob = getBPrintJobByPK(branch_id,"", item.getFPrintJobId(),"");
            item.setPrinterName(config1.StringNull(item.getPrinterName()).replace("'", "''"));
//            item.setDocName(config1.StringNull(item.getDocName()).replace("'", "''"));
//            item.setVisitDiagnosisNotice(config1.StringNull(item.getVisitDiagnosisNotice()).replace("'", "''"));
            if (pjob.getPrintJobId().equals("")) {
                max = getMaxRowBPrintJob(st);
                sql = "Insert Into " + pjob.getBPrintJob()
                    + "(" + pjob.getFPrintJobId() + ", " + pjob.getFCompId() + ", "
                    + pjob.getFDocId() + "," + pjob.getFPrintName() + ","
                    + pjob.getFStatusDialog()+")"
                    + "Values('" + max + "','" + item.getCompId() + "','"
                    + item.getDocId() + "','" + item.getPrinterName() + "','"
                    + item.getStatusDialog()+"')";
            }else{
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public void setUpdateBPrintDoc(String branch_id, String doc_id, String doc_name, String description, String doc_active){
        int chk = 0;
        String sql = "", max = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + pdoc.getBPrintDoc()
                + " Set " + pdoc.getFDescription() + " = '" + description + "', "
                + pdoc.getFDocName() + "='" + doc_name + "', "+pdoc.getFDocActive()+"='"+doc_active+"' "
                + "Where " + pdoc.getFDocId() + " = '" + doc_id + "' ";
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
    }
    public void setUpdateBPrintJob(String branch_id, String print_job_id, String printer_name, String com_id, String status_dialog){
        int chk = 0;
        String sql = "", max = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Update " + pjob.getBPrintJob()
                + " Set " + pjob.getFCompId() + " = '" + com_id + "', "
                + pjob.getFPrintName() + "='" + printer_name + "', "+pjob.getFStatusDialog()+"='"+status_dialog+"' "
                + "Where " + pjob.getFPrintJobId() + " = '" + print_job_id + "' ";
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
    }
    public void setUpdateBPrintJobVoid(String branch_id, String print_job_id){
        int chk = 0;
        String sql = "", max = "";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            sql = "Delete From " + pjob.getBPrintJob()
                + " Where " + pjob.getFPrintJobId() + " = '" + print_job_id + "' ";
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
    }
    public String getTrPrintDoc(String branch_id, String doc_id, String flag){
        StringBuilder txt = new StringBuilder();
        String t_head="", script="", t_footer="", link="", link_add="", link_old="";
        Vector v_pdoc = new Vector();
        v_pdoc = getBPrintDoc(branch_id, doc_id,flag);
        for(int i=0;i<=v_pdoc.size()-1;i++){
            pdoc = (BPrintDoc)v_pdoc.get(i);
            if(!pdoc.getDocName().equals("")){
                link = "<a href='javascript:showDialogBDoc("+pdoc.getDocId()+","+i+")'>"+pdoc.getDocName()+"</a>";
            }else{
                link = "<a href='javascript:showDialogBDoc("+pdoc.getDocId()+","+i+")'>-</a>";
            }
            link_add = "<a href='javascript:showDialogAddPrinter("+pdoc.getDocId()+","+i+")'>เพิ่มเครื่องพิมพ์</a>";
            link_old = "<a href='javascript:showDialogPrinter("+pdoc.getDocId()+","+i+")'>ดูเครื่องพิมพ์</a>";
//            if(!pdoc.getDocName().equals("")){
//                link += pdoc.getDocName();
//            }
            txt.append("<tr><td>").append(i+1).append("</td><td>").append(link).append("</td><td>").append(pdoc.getDescription())
                    .append("<input type = 'hidden' id = 'txt_doc_name"+i+"' value='"+pdoc.getDocName()+"'>")
                    .append("<input type = 'hidden' id = 'txt_description"+i+"' value='"+pdoc.getDescription()+"'>")
                    .append("<input type = 'hidden' id = 'txt_doc_active"+i+"' value='"+pdoc.getDocActive()+"'>")
                    .append("</td><td>").append(link_add)
                    .append("</td><td>").append(link_old).append("</td></tr>");
        }
        //script = "<script> $('#txt_chi_gov_id').val("+cgov_id+"); </script>";
        t_head = "<table><tr><th>ลำดับ</th><th>ชื่อเอกสาร</th><th>รายละเอียด</th><th colspan='2'>เครื่องพิมพ์</th></tr>";
        t_footer = "</table>";
        return t_head+txt.toString()+t_footer+script;
    }
    public String getTrPrintJob(String branch_id, String doc_id, String flag){
        StringBuilder txt = new StringBuilder();
        String t_head="", script="", t_footer="", link="", dialogPrint="";
        Vector v_pjob = new Vector();
        v_pjob = getBPrintJob(branch_id, doc_id,flag);
        for(int i=0;i<=v_pjob.size()-1;i++){
            pjob = (BPrintJob)v_pjob.get(i);
            if(!pjob.getCompId().equals("")){
                link = "<a href='javascript:showBJob("+pjob.getCompId()+")'>"+pjob.getPrinterName()+"</a>";
            }else{
                link = "<a href='javascript:showBJob("+pjob.getCompId()+")'>-</a>";
            }
            if(pjob.getStatusDialog().equals("1")){
                dialogPrint = "แสดง";
            }else{
                dialogPrint = "ไม่แสดง";
            }
//            if(!pjob.getPrinterName().equals("")){
//                link += pjob.getPrinterName();
//            }
            txt.append("<tr><td>").append(i+1).append("</td><td>").append(link).append("</td><td>")
                    .append(pjob.getPrinterName()).append("</td><td>").append(dialogPrint).append("</tr>");
        }
        //script = "<script> $('#txt_chi_gov_id').val("+cgov_id+"); </script>";
        t_head = "<table><tr><th>ลำดับ</th><th>ชื่อเอกสาร</th><th>ชื่อเครื่องพิมพ์</th><th>Dialog พิมพ์</th></tr>";
        t_footer = "</table>";
        return t_head+txt.toString()+t_footer+script;
    }
    public String getTrPrintJobEdit(String branch_id, String doc_id, String flag){
        StringBuilder txt = new StringBuilder();
        String t_head="", script="", t_footer="", link="", doc_name="", dialog="";
        Vector v_pjob = new Vector();
        v_pjob = getBPrintJob(branch_id, doc_id,"select_job");
        pdoc = getBPrintDocByPK(branch_id,doc_id,"");
        for(int i=0;i<=v_pjob.size()-1;i++){
            pjob = (BPrintJob)v_pjob.get(i);
            if(!pjob.getCompId().equals("")){
                link = "<a href='javascript:showBJob("+pjob.getCompId()+")'>"+pjob.getPrinterName()+"</a>";
            }else{
                link = "<a href='javascript:showBJob("+pjob.getCompId()+")'>-</a>";
            }
            if(pjob.getStatusDialog().equals("1")){
                dialog = "<label><input type = 'radio' id='chk_status_dialog"+i+"' name='chk_dialog"+i+"' checked>แสดง dialog</label>"
                        + "<label><input type = 'radio' id='chk_status_undialog"+i+"' name='chk_dialog"+i+"' >ไม่แสดง dialog</label>";
            }else{
                dialog = "<label><input type = 'radio' id='chk_status_dialog"+i+"' name='chk_dialog"+i+"' >แสดง dialog</label>"
                        + "<label><input type = 'radio' id='chk_status_undialog"+i+"' name='chk_dialog"+i+"' checked>ไม่แสดง dialog</label>";
            }
            txt.append("<tr><td>").append(i+1).append("</td><td>")
                    .append("<input type = 'text' id = 'txt_com_id_print_job").append(i).append("' value='").append(pjob.getCompId()).append("'>").append("</td><td>")
                    .append("<input type = 'text' id = 'txt_printer_name_print_job").append(i).append("' value='").append(pjob.getPrinterName()).append("'>")
                    .append("<input type = 'hidden' id = 'print_job_id_print_job").append(i).append("' value='").append(pjob.getPrintJobId()).append("'>&nbsp;&nbsp;").append("</td><td>")
                    .append(dialog)
                    .append("&nbsp;&nbsp;&nbsp;<img id='img").append(i).append("' src='images/savedrafticon.gif' alt='' align='top' border='0' title='save' onclick='showDialogSavePrintJob(").append(pjob.getPrintJobId()).append(",").append(i).append(")'>&nbsp;&nbsp;")
                    .append("<img id='img").append(i).append("' src='images/trash1.gif' alt='' align='top' border='0' title='void' onclick='showDialogVoidPrintJob(").append(pjob.getPrintJobId()).append(")'>")
                    .append("</td></tr>");
        }
        //script = "<script> $('#txt_chi_gov_id').val("+cgov_id+"); </script>";
        t_head = "<table>"
                + "<tr><th>ลำดับ</th><th>ชื่อเครื่องคอม</th><th>ชื่อเครื่องพิมพ์</th><th>Dialog พิมพ์</th></tr>";
        t_footer = "</table>";
        return t_head+txt.toString()+t_footer+script;
    }
    public void setPrint(String branch_id, String doc_number){
        setPrint(branch_id, doc_number, config1.compName);
    }
    public void setPrint(String branch_id, String doc_number, String com_id){
        pjob = getBPrintJobByPK(branch_id, doc_number, com_id,"com_id_by_doc_name");
        PrintService[] printServices = PrinterJob.lookupPrintServices();
        PrintService ps = null;
        //
        // Iterates the print services and print out its name.
        //
        for (PrintService printService : printServices) {
            String name = printService.getName();
            if(name.equals(pjob.getPrinterName())){
                ps = printService;
                System.out.println("Name = " + name);
            }
        }
        PrinterJob pJob = PrinterJob.getPrinterJob();
        PageFormat pf = pJob.defaultPage();
        try {
            pJob.setPrintService(ps);
        } catch (PrinterException ex) {
            Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
        }
//        if (pJob.printDialog()) {
//            try {
//                pJob.print();
//            } catch (PrinterException ex) {
//                Logger.getLogger(BPrintJobDB.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }
    public Vector getLocalPrint(){
        Vector v_print = new Vector();
        PrintService[] printServices = PrinterJob.lookupPrintServices();
        PrintService ps = null;
        //
        // Iterates the print services and print out its name.
        //
        for (PrintService printService : printServices) {
//            String name = printService.getName();
            v_print.add(printService.getName());
//            if(name.equals(pjob.getPrinterName())){
//                ps = printService;
//                System.out.println("Name = " + name);
//            }
        }
        return v_print;
    }
    
}
