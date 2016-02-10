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
@Table(name = "b_service_point", catalog = "front_bangna3", schema = "public")
@NamedQueries({
    @NamedQuery(name = "BServicePoint.findAll", query = "SELECT b FROM BServicePoint b"),
    @NamedQuery(name = "BServicePoint.findByBServicePointId", query = "SELECT b FROM BServicePoint b WHERE b.bServicePointId = :bServicePointId"),
    @NamedQuery(name = "BServicePoint.findByServicePointNumber", query = "SELECT b FROM BServicePoint b WHERE b.servicePointNumber = :servicePointNumber"),
    @NamedQuery(name = "BServicePoint.findByServicePointDescription", query = "SELECT b FROM BServicePoint b WHERE b.servicePointDescription = :servicePointDescription"),
    @NamedQuery(name = "BServicePoint.findByFServiceGroupId", query = "SELECT b FROM BServicePoint b WHERE b.fServiceGroupId = :fServiceGroupId"),
    @NamedQuery(name = "BServicePoint.findByFServiceSubgroupId", query = "SELECT b FROM BServicePoint b WHERE b.fServiceSubgroupId = :fServiceSubgroupId"),
    @NamedQuery(name = "BServicePoint.findByServicePointActive", query = "SELECT b FROM BServicePoint b WHERE b.servicePointActive = :servicePointActive")})
public class BServicePoint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "b_service_point_id", nullable = false, length = 255)
    private String bServicePointId="";
    @Column(name = "service_point_number", length = 255)
    private String servicePointNumber="";
    @Column(name = "service_point_description", length = 255)
    private String servicePointDescription="";
    @Column(name = "f_service_group_id", length = 255)
    private String fServiceGroupId="";
    @Column(name = "f_service_subgroup_id", length = 255)
    private String fServiceSubgroupId="";
    @Column(name = "service_point_active", length = 255)
    private String servicePointActive="";

    public BServicePoint() {
    }
    public void initial(){
        bServicePointId="";
        servicePointNumber="";
        servicePointDescription="";
        fServiceGroupId="";
        fServiceSubgroupId="";
        servicePointActive="";
    }

    public String getBServicePoint() {
        return "b_service_point";
    }
    public String getFBServicePointId() {
        return "b_service_point_id";
    }
    public String getFSrevicePointNumber() {
        return "service_point_number";
    }
    public String getFServicePointDescription() {
        return "service_point_description";
    }
    public String getFFServerGroupId() {
        return "f_service_group_id";
    }
    public String getFFServiceSubgroupId() {
        return "f_service_subgroup_id";
    }
    public String getFServicePointActive() {
        return "service_point_active";
    }

    public BServicePoint(String bServicePointId) {
        this.bServicePointId = bServicePointId;
    }

    public String getBServicePointId() {
        return bServicePointId;
    }

    public void setBServicePointId(String bServicePointId) {
        this.bServicePointId = bServicePointId;
    }

    public String getServicePointNumber() {
        return servicePointNumber;
    }

    public void setServicePointNumber(String servicePointNumber) {
        this.servicePointNumber = servicePointNumber;
    }

    public String getServicePointDescription() {
        return servicePointDescription;
    }

    public void setServicePointDescription(String servicePointDescription) {
        this.servicePointDescription = servicePointDescription;
    }

    public String getFServiceGroupId() {
        return fServiceGroupId;
    }

    public void setFServiceGroupId(String fServiceGroupId) {
        this.fServiceGroupId = fServiceGroupId;
    }

    public String getFServiceSubgroupId() {
        return fServiceSubgroupId;
    }

    public void setFServiceSubgroupId(String fServiceSubgroupId) {
        this.fServiceSubgroupId = fServiceSubgroupId;
    }

    public String getServicePointActive() {
        return servicePointActive;
    }

    public void setServicePointActive(String servicePointActive) {
        this.servicePointActive = servicePointActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bServicePointId != null ? bServicePointId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BServicePoint)) {
            return false;
        }
        BServicePoint other = (BServicePoint) object;
        if ((this.bServicePointId == null && other.bServicePointId != null) || (this.bServicePointId != null && !this.bServicePointId.equals(other.bServicePointId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaLibrary.BServicePoint[bServicePointId=" + bServicePointId + "]";
    }

}
