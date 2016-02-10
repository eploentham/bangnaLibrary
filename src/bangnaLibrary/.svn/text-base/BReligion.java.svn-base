package bangnaLibrary;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



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
@Table(name = "b_religion", catalog = "bangna", schema = "public")
@NamedQueries({@NamedQuery(name = "BReligion.findAll", query = "SELECT b FROM BReligion b")})
public class BReligion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "religion_id", nullable = false, length = 255)
    private String religionId="";
    @Column(name = "religion_namet", length = 255)
    private String religionNamet="";
    @Column(name = "religion_active", length = 255)
    private String religionActive="";

    public BReligion() {
    }
    public void initial(){
        religionId="";
        religionNamet="";
        religionActive="";
    }

    public String getBReligion(){
        return "b_religion";
    }

    public String getFReligionId(){
        return "religion_id";
    }
    public String getFReligionNamet(){
        return "religion_namet";
    }

    public BReligion(String religionId) {
        this.religionId = religionId;
    }

    public String getReligionId() {
        return religionId;
    }

    public void setReligionId(String religionId) {
        this.religionId = religionId;
    }

    public String getReligionNamet() {
        return religionNamet;
    }

    public void setReligionNamet(String religionNamet) {
        this.religionNamet = religionNamet;
    }

    public String getReligionActive() {
        return religionActive;
    }

    public void setReligionActive(String religionActive) {
        this.religionActive = religionActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (religionId != null ? religionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BReligion)) {
            return false;
        }
        BReligion other = (BReligion) object;
        if ((this.religionId == null && other.religionId != null) || (this.religionId != null && !this.religionId.equals(other.religionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaintranet.BReligion[religionId=" + religionId + "]";
    }

}
