/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.managers;

import java.util.List;
import javax.ejb.Local;
import persistence.BcmsSession;
import persistence.Event;
import persistence.Route;

/**
 *
 * @author cfollet
 */
@Local
public interface BCMSManagerLocal {
    
    public void createEvent(Event e);
    public List<Event> getEvents(final BcmsSession session);
    public List<BcmsSession> getSessions();
    public List<Event> getEvents();
    public List<Route> getRoutes();
}
