/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Local;
import persistence.BcmsSession;
import persistence.BcmsSessionFireTruck;
import persistence.Event;
import persistence.Route;

/**
 *
 * @author cfollet
 */
@Local
public interface FSCManagerLocal {

    public List<BcmsSessionFireTruck> getSessionFireTrucks(final BcmsSession session);

    public List<Route> getRoutes();

    public List<Event> getEvents(BcmsSession session);
}
