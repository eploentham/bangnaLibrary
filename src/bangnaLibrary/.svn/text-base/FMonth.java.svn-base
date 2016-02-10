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
@Table(name = "f_month", catalog = "bangna5", schema = "public")
@NamedQueries({
    @NamedQuery(name = "FMonth.findAll", query = "SELECT f FROM FMonth f"),
    @NamedQuery(name = "FMonth.findByMonthId", query = "SELECT f FROM FMonth f WHERE f.monthId = :monthId"),
    @NamedQuery(name = "FMonth.findByMonthNamet", query = "SELECT f FROM FMonth f WHERE f.monthNamet = :monthNamet"),
    @NamedQuery(name = "FMonth.findByMonthNamee", query = "SELECT f FROM FMonth f WHERE f.monthNamee = :monthNamee")})
public class FMonth implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "month_id", nullable = false, length = 255)
    private String monthId="";
    @Column(name = "month_namet", length = 255)
    private String monthNamet="";
    @Column(name = "month_namee", length = 255)
    private String monthNamee="";

    public FMonth() {
    }
    public void initial(){
        monthId="";
        monthNamet="";
        monthNamee="";
    }

    public FMonth(String monthId) {
        this.monthId = monthId;
    }

    public String getMonthId() {
        return monthId;
    }

    public void setMonthId(String monthId) {
        this.monthId = monthId;
    }

    public String getMonthNamet() {
        return monthNamet;
    }

    public void setMonthNamet(String monthNamet) {
        this.monthNamet = monthNamet;
    }

    public String getMonthNamee() {
        return monthNamee;
    }

    public void setMonthNamee(String monthNamee) {
        this.monthNamee = monthNamee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (monthId != null ? monthId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FMonth)) {
            return false;
        }
        FMonth other = (FMonth) object;
        if ((this.monthId == null && other.monthId != null) || (this.monthId != null && !this.monthId.equals(other.monthId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.FMonth[monthId=" + monthId + "]";
    }

}
