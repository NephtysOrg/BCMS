/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cfollet
 */
@Entity
@Table(name = "EVENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByEventId", query = "SELECT e FROM Event e WHERE e.eventId = :eventId"),
    @NamedQuery(name = "Event.findByEventOccurrenceTime", query = "SELECT e FROM Event e WHERE e.eventOccurrenceTime = :eventOccurrenceTime"),
    @NamedQuery(name = "Event.findByEventName", query = "SELECT e FROM Event e WHERE e.eventName = :eventName"),
    @NamedQuery(name = "Event.findBySessionId", query = "SELECT e FROM Event e WHERE e.sessionId = :sessionId ORDER BY E.eventId, E.eventOccurrenceTime ASC"),
    @NamedQuery(name = "Event.findByExecutionTrace", query = "SELECT e FROM Event e WHERE e.executionTrace = :executionTrace")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EVENT_ID")
    private Integer eventId;
    @Column(name = "EVENT_OCCURRENCE_TIME")
    @Temporal(TemporalType.TIME)
    private Date eventOccurrenceTime;
    @Size(max = 50)
    @Column(name = "EVENT_NAME")
    private String eventName;
    @Size(max = 500)
    @Column(name = "EXECUTION_TRACE")
    private String executionTrace;
    @JoinColumn(name = "SESSION_ID", referencedColumnName = "SESSION_ID")
    @ManyToOne
    private BcmsSession sessionId;

    public Event() {
    }

    public Event(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Date getEventOccurrenceTime() {
        return eventOccurrenceTime;
    }

    public void setEventOccurrenceTime(Date eventOccurrenceTime) {
        this.eventOccurrenceTime = eventOccurrenceTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getExecutionTrace() {
        return executionTrace;
    }

    public void setExecutionTrace(String executionTrace) {
        this.executionTrace = executionTrace;
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
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        System.out.println("Comparing "+ this.eventName +" and "+ other.getEventName());
        if (this.eventId == null && other.eventId != null) {
            System.out.println("False");
            return false;
        }
        if ((this.eventId.equals(other.eventId) ) || ((this.eventName.equals(other.eventName)) && (this.sessionId.equals(other.sessionId)) )) {
            System.out.println("True");
            return true;
        }
        System.out.println("False");
        return false;
    }

    @Override
    public String toString() {
        return "persistence.Event[ eventId=" + eventId + " ]";
    }
    
}
