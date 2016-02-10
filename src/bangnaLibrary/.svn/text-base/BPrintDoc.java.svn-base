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
@Table(name = "b_print_doc")
@NamedQueries({
    @NamedQuery(name = "BPrintDoc.findAll", query = "SELECT b FROM BPrintDoc b")})
public class BPrintDoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "doc_id")
    private String docId="";
    @Column(name = "doc_name")
    private String docName="";
    @Column(name = "doc_active")
    private String docActive="";
    @Column(name = "description")
    private String description="";

    public BPrintDoc() {
    }
    public String getBPrintDoc(){
        return "b_print_doc";
    }
    public String getFDocId(){
        return "doc_id";
    }
    public String getFDocName(){
        return "doc_name";
    }
    public String getFDocActive(){
        return "doc_active";
    }
    public String getFDescription(){
        return "description";
    }

    public BPrintDoc(String docId) {
        this.docId = docId;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocActive() {
        return docActive;
    }

    public void setDocActive(String docActive) {
        this.docActive = docActive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docId != null ? docId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BPrintDoc)) {
            return false;
        }
        BPrintDoc other = (BPrintDoc) object;
        if ((this.docId == null && other.docId != null) || (this.docId != null && !this.docId.equals(other.docId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.BPrintDoc[docId=" + docId + "]";
    }

}
