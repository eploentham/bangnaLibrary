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

/**
 *
 * @author root
 */
@Entity
@Table(name = "b_print_job")
@NamedQueries({
    @NamedQuery(name = "BPrintJob.findAll", query = "SELECT b FROM BPrintJob b")})
public class BPrintJob implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "print_job_id")
    private String printJobId="";
    @Column(name = "doc_id")
    private String docId="";
    @Column(name = "comp_id")
    private String compId="";
    @Column(name = "printer_name")
    private String printerName="";
    @Column(name = "status_dialog")
    private String statusDialog="";

    public BPrintJob() {
    }
    public String getBPrintJob(){
        return "b_print_job";
    }
    public String getFPrintJobId(){
        return "print_job_id";
    }
    public String getFDocId(){
        return "doc_id";
    }
    public String getFCompId(){
        return "comp_id";
    }
    public String getFPrintName(){
        return "printer_name";
    }
    public String getFStatusDialog(){
        return "status_dialog";
    }

    public BPrintJob(String printJobId) {
        this.printJobId = printJobId;
    }

    public String getPrintJobId() {
        return printJobId;
    }

    public void setPrintJobId(String printJobId) {
        this.printJobId = printJobId;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getPrinterName() {
        return printerName;
    }
    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public String getStatusDialog() {
        return statusDialog;
    }
    public void setStatusDialog(String statusDialog) {
        this.statusDialog = statusDialog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (printJobId != null ? printJobId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BPrintJob)) {
            return false;
        }
        BPrintJob other = (BPrintJob) object;
        if ((this.printJobId == null && other.printJobId != null) || (this.printJobId != null && !this.printJobId.equals(other.printJobId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.BPrintJob[printJobId=" + printJobId + "]";
    }

}
