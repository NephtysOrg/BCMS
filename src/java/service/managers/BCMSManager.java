/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.managers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import persistence.BcmsSession;
import persistence.Event;
import persistence.Route;

/**
 *
 * @author cfollet
 */
@Stateless
public class BCMSManager implements BCMSManagerLocal {

    @javax.persistence.PersistenceContext(name = "CrisisPU")
    private javax.persistence.EntityManager _entity_manager;

    @Override
    public List<Event> getEvents(BcmsSession session) {
        Query q = _entity_manager.createNamedQuery("Event.findBySessionId").setParameter("sessionId", session);
        return (List<Event>) q.getResultList();

    }

    @Override
    public List<Event> getEvents() {
        Query q = _entity_manager.createNamedQuery("Event.findAll");
        return (List<Event>) q.getResultList();

    }

    @Override
    public List<Route> getRoutes() {
         Query q = _entity_manager.createNamedQuery("Route.findAll");
        return (List<Route>) q.getResultList();}

    @Override
    public List<BcmsSession> getSessions() {
        Query q = _entity_manager.createNamedQuery("BcmsSession.findAll");
        return (List<BcmsSession>) q.getResultList();
    }

}
