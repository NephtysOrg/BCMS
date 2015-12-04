/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import persistence.BcmsSession;
import persistence.BcmsSessionFireTruck;
import persistence.BcmsSessionPoliceVehicle;
import persistence.Event;
import persistence.Route;

/**
 *
 * @author cfollet
 */
@Stateless
public class PSCManager implements PSCManagerLocal {

    @javax.persistence.PersistenceContext(name = "CrisisPU")
    private javax.persistence.EntityManager _entity_manager;


    @Override
    public List<Route> getRoutes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> getEvents(BcmsSession session) {
        Query q = _entity_manager.createNamedQuery("Event.findBySessionId").setParameter("sessionId", session);
        return (List<Event>) q.getResultList();
    }

    @Override
    public List<BcmsSessionPoliceVehicle> getSessionPoliceVehicle(BcmsSession session) {
        Query q = _entity_manager.createNamedQuery("BcmsSessionPoliceVehicle.findByBcmsSessionId").setParameter("bcmsSessionId", session);
        return (List<BcmsSessionPoliceVehicle>) q.getResultList();
    }
    
    
}
