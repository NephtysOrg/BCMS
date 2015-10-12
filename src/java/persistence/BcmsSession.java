/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cfollet
 */
@Entity
@Table(name = "BCMS_SESSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BcmsSession.findAll", query = "SELECT b FROM BcmsSession b"),
    @NamedQuery(name = "BcmsSession.findBySessionId", query = "SELECT b FROM BcmsSession b WHERE b.sessionId = :sessionId"),
    @NamedQuery(name = "BcmsSession.findByFireTruckNumber", query = "SELECT b FROM BcmsSession b WHERE b.fireTruckNumber = :fireTruckNumber"),
    @NamedQuery(name = "BcmsSession.findByPoliceTruckNumber", query = "SELECT b FROM BcmsSession b WHERE b.policeTruckNumber = :policeTruckNumber")})
public class BcmsSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SESSION_ID")
    private String sessionId;
    @Column(name = "FIRE_TRUCK_NUMBER")
    private Integer fireTruckNumber;
    @Column(name = "POLICE_TRUCK_NUMBER")
    private Integer policeTruckNumber;
    @OneToMany(mappedBy = "sessionId")
    private Collection<BcmsSessionPoliceVehicle> bcmsSessionPoliceVehicleCollection;
    @OneToMany(mappedBy = "sessionId")
    private Collection<BcmsSessionFireTruck> bcmsSessionFireTruckCollection;
    @OneToMany(mappedBy = "sessionId")
    private Collection<Event> eventCollection;

    public BcmsSession() {
    }

    /**
     * Before persist, we create a PK based on the class name and the current
     * datetime if there is no PK sets
     */
    @PrePersist
    public void onCreate() {
        if (this.getSessionId()== null) {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date today = Calendar.getInstance().getTime();
            String date = df.format(today);

            this.setSessionId(this.getClass().getSimpleName() + date);
        }
    }

    public BcmsSession(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getFireTruckNumber() {
        return fireTruckNumber;
    }

    public void setFireTruckNumber(Integer fireTruckNumber) {
        this.fireTruckNumber = fireTruckNumber;
    }

    public Integer getPoliceTruckNumber() {
        return policeTruckNumber;
    }

    public void setPoliceTruckNumber(Integer policeTruckNumber) {
        this.policeTruckNumber = policeTruckNumber;
    }

    @XmlTransient
    public Collection<BcmsSessionPoliceVehicle> getBcmsSessionPoliceVehicleCollection() {
        return bcmsSessionPoliceVehicleCollection;
    }

    public void setBcmsSessionPoliceVehicleCollection(Collection<BcmsSessionPoliceVehicle> bcmsSessionPoliceVehicleCollection) {
        this.bcmsSessionPoliceVehicleCollection = bcmsSessionPoliceVehicleCollection;
    }

    @XmlTransient
    public Collection<BcmsSessionFireTruck> getBcmsSessionFireTruckCollection() {
        return bcmsSessionFireTruckCollection;
    }

    public void setBcmsSessionFireTruckCollection(Collection<BcmsSessionFireTruck> bcmsSessionFireTruckCollection) {
        this.bcmsSessionFireTruckCollection = bcmsSessionFireTruckCollection;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sessionId != null ? sessionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BcmsSession)) {
            return false;
        }
        BcmsSession other = (BcmsSession) object;
        if ((this.sessionId == null && other.sessionId != null) || (this.sessionId != null && !this.sessionId.equals(other.sessionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fb.beans.entity.BcmsSession[ sessionId=" + sessionId + " ]";
    }

}