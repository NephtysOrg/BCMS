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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cfollet
 */
@Entity
@Table(name = "BCMS_SESSION_FIRE_TRUCK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BcmsSessionFireTruck.findAll", query = "SELECT b FROM BcmsSessionFireTruck b"),
    @NamedQuery(name = "BcmsSessionFireTruck.findByBcmsSessionId", query = "SELECT b FROM BcmsSessionFireTruck b WHERE b.sessionId = :bcmsSessionId ORDER BY b.fireTruckName.fireTruckName ASC"),
    @NamedQuery(name = "BcmsSessionFireTruck.findByBcmsSessionFireTruckId", query = "SELECT b FROM BcmsSessionFireTruck b WHERE b.bcmsSessionFireTruckId = :bcmsSessionFireTruckId"),
    @NamedQuery(name = "BcmsSessionFireTruck.findByFireTruckNameAndSessionName", query = "SELECT b FROM BcmsSessionFireTruck b WHERE b.fireTruckName = :fireTruckName and b.sessionId = :sessionId"),
    @NamedQuery(name = "BcmsSessionFireTruck.findByFireTruckStatus", query = "SELECT b FROM BcmsSessionFireTruck b WHERE b.fireTruckStatus = :fireTruckStatus")})
public class BcmsSessionFireTruck implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BCMS_SESSION_FIRE_TRUCK_ID")
    private Integer bcmsSessionFireTruckId;
    @Size(max = 10)
    @Column(name = "FIRE_TRUCK_STATUS")
    private String fireTruckStatus;
    @JoinColumn(name = "FIRE_TRUCK_NAME", referencedColumnName = "FIRE_TRUCK_NAME")
    @ManyToOne
    private FireTruck fireTruckName;
    @JoinColumn(name = "SESSION_ID", referencedColumnName = "SESSION_ID")
    @ManyToOne
    private BcmsSession sessionId;

    public BcmsSessionFireTruck() {
    }

    public BcmsSessionFireTruck(Integer bcmsSessionFireTruckId) {
        this.bcmsSessionFireTruckId = bcmsSessionFireTruckId;
    }

    public Integer getBcmsSessionFireTruckId() {
        return bcmsSessionFireTruckId;
    }

    public void setBcmsSessionFireTruckId(Integer bcmsSessionFireTruckId) {
        this.bcmsSessionFireTruckId = bcmsSessionFireTruckId;
    }

    public String getFireTruckStatus() {
        return fireTruckStatus;
    }

    public void setFireTruckStatus(String fireTruckStatus) {
        this.fireTruckStatus = fireTruckStatus;
    }

    public FireTruck getFireTruckName() {
        return fireTruckName;
    }

    public void setFireTruckName(FireTruck fireTruckName) {
        this.fireTruckName = fireTruckName;
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
        hash += (bcmsSessionFireTruckId != null ? bcmsSessionFireTruckId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BcmsSessionFireTruck)) {
            return false;
        }
        BcmsSessionFireTruck other = (BcmsSessionFireTruck) object;
        if ((this.bcmsSessionFireTruckId == null && other.bcmsSessionFireTruckId != null) || (this.bcmsSessionFireTruckId != null && !this.bcmsSessionFireTruckId.equals(other.bcmsSessionFireTruckId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.BcmsSessionFireTruck[ bcmsSessionFireTruckId=" + bcmsSessionFireTruckId + " ]";
    }
    
}
