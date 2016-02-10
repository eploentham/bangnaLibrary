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
@Table(name = "f_day", catalog = "bangna5", schema = "public")
@NamedQueries({
    @NamedQuery(name = "FDay.findAll", query = "SELECT f FROM FDay f"),
    @NamedQuery(name = "FDay.findByDayId", query = "SELECT f FROM FDay f WHERE f.dayId = :dayId"),
    @NamedQuery(name = "FDay.findByDayNamet", query = "SELECT f FROM FDay f WHERE f.dayNamet = :dayNamet"),
    @NamedQuery(name = "FDay.findByDayNamee", query = "SELECT f FROM FDay f WHERE f.dayNamee = :dayNamee")})
public class FDay implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "day_id", nullable = false, length = 255)
    private String dayId="";
    @Column(name = "day_namet", length = 255)
    private String dayNamet="";
    @Column(name = "day_namee", length = 255)
    private String dayNamee="";

    public FDay() {
    }
    public void initial(){
        dayId="";
        dayNamet="";
        dayNamee="";
    }
    public String getFDay(){
        return "f_day";
    }
    public String getFDayId(){
        return "day_id";
    }
    public String getFDayNamet(){
        return "day_namet";
    }
    public String getFDayNamee(){
        return "day_namee";
    }

    public FDay(String dayId) {
        this.dayId = dayId;
    }

    public String getDayId() {
        return dayId;
    }

    public void setDayId(String dayId) {
        this.dayId = dayId;
    }

    public String getDayNamet() {
        return dayNamet;
    }

    public void setDayNamet(String dayNamet) {
        this.dayNamet = dayNamet;
    }

    public String getDayNamee() {
        return dayNamee;
    }

    public void setDayNamee(String dayNamee) {
        this.dayNamee = dayNamee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dayId != null ? dayId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FDay)) {
            return false;
        }
        FDay other = (FDay) object;
        if ((this.dayId == null && other.dayId != null) || (this.dayId != null && !this.dayId.equals(other.dayId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.FDay[dayId=" + dayId + "]";
    }

}
