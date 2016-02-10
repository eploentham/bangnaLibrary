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
@Table(name = "f_item_group", catalog = "front_bangna5", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"f_item_group_id"})})
@NamedQueries({
    @NamedQuery(name = "FItemGroup.findAll", query = "SELECT f FROM FItemGroup f"),
    @NamedQuery(name = "FItemGroup.findByFItemGroupId", query = "SELECT f FROM FItemGroup f WHERE f.fItemGroupId = :fItemGroupId"),
    @NamedQuery(name = "FItemGroup.findByItemGroupDescription", query = "SELECT f FROM FItemGroup f WHERE f.itemGroupDescription = :itemGroupDescription")})
public class FItemGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "f_item_group_id", nullable = false, length = 255)
    private String fItemGroupId="";
    @Column(name = "item_group_description", length = 255)
    private String itemGroupDescription="";

    public FItemGroup() {
    }
    public void initial(){
        fItemGroupId="";
        itemGroupDescription="";
    }

    public String getFItemGroup(){
        return "f_item_group";
    }
    public String getFFItemGroupId(){
        return "f_item_group_id";
    }
    public String getFItemGroupDescription(){
        return "item_group_description";
    }


    public FItemGroup(String fItemGroupId) {
        this.fItemGroupId = fItemGroupId;
    }

    public String getFItemGroupId() {
        return fItemGroupId;
    }

    public void setFItemGroupId(String fItemGroupId) {
        this.fItemGroupId = fItemGroupId;
    }

    public String getItemGroupDescription() {
        return itemGroupDescription;
    }

    public void setItemGroupDescription(String itemGroupDescription) {
        this.itemGroupDescription = itemGroupDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fItemGroupId != null ? fItemGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FItemGroup)) {
            return false;
        }
        FItemGroup other = (FItemGroup) object;
        if ((this.fItemGroupId == null && other.fItemGroupId != null) || (this.fItemGroupId != null && !this.fItemGroupId.equals(other.fItemGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.FItemGroup[fItemGroupId=" + fItemGroupId + "]";
    }

}
