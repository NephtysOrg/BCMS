/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cfollet
 */
@Entity
@Table(name = "BCMS_SESSION_POLICE_VEHICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BcmsSessionPoliceVehicle.findAll", query = "SELECT b FROM BcmsSessionPoliceVehicle b"),
    @NamedQuery(name = "BcmsSessionPoliceVehicle.findByBcmsSessionPoliceVehicleId", query = "SELECT b FROM BcmsSessionPoliceVehicle b WHERE b.bcmsSessionPoliceVehicleId = :bcmsSessionPoliceVehicleId"),
    @NamedQuery(name = "BcmsSessionPoliceVehicle.findByPoliceVehicleStatus", query = "SELECT b FROM BcmsSessionPoliceVehicle b WHERE b.policeVehicleStatus = :policeVehicleStatus")})
public class BcmsSessionPoliceVehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "BCMS_SESSION_POLICE_VEHICLE_ID")
    private String bcmsSessionPoliceVehicleId;
    @Size(max = 10)
    @Column(name = "POLICE_VEHICLE_STATUS")
    private String policeVehicleStatus;
    @JoinColumn(name = "POLICE_VEHICLE_NAME", referencedColumnName = "POLICE_VEHICLE_NAME")
    @ManyToOne
    private PoliceVehicle policeVehicleName;
    @JoinColumn(name = "SESSION_ID", referencedColumnName = "SESSION_ID")
    @ManyToOne
    private BcmsSession sessionId;

    public BcmsSessionPoliceVehicle() {
    }

    public BcmsSessionPoliceVehicle(String bcmsSessionPoliceVehicleId) {
        this.bcmsSessionPoliceVehicleId = bcmsSessionPoliceVehicleId;
    }

    public String getBcmsSessionPoliceVehicleId() {
        return bcmsSessionPoliceVehicleId;
    }

    public void setBcmsSessionPoliceVehicleId(String bcmsSessionPoliceVehicleId) {
        this.bcmsSessionPoliceVehicleId = bcmsSessionPoliceVehicleId;
    }

    public String getPoliceVehicleStatus() {
        return policeVehicleStatus;
    }

    public void setPoliceVehicleStatus(String policeVehicleStatus) {
        this.policeVehicleStatus = policeVehicleStatus;
    }

    public PoliceVehicle getPoliceVehicleName() {
        return policeVehicleName;
    }

    public void setPoliceVehicleName(PoliceVehicle policeVehicleName) {
        this.policeVehicleName = policeVehicleName;
    }

    public BcmsSession getSessionId() {
        return sessionId;
    }

    public void setSessionId(BcmsSession sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bcmsSessionPoliceVehicleId != null ? bcmsSessionPoliceVehicleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BcmsSessionPoliceVehicle)) {
            return false;
        }
        BcmsSessionPoliceVehicle other = (BcmsSessionPoliceVehicle) object;
        if ((this.bcmsSessionPoliceVehicleId == null && other.bcmsSessionPoliceVehicleId != null) || (this.bcmsSessionPoliceVehicleId != null && !this.bcmsSessionPoliceVehicleId.equals(other.bcmsSessionPoliceVehicleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fb.beans.entity.BcmsSessionPoliceVehicle[ bcmsSessionPoliceVehicleId=" + bcmsSessionPoliceVehicleId + " ]";
    }
    
}
