/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import persistence.BcmsSession;
import persistence.Event;
import persistence.Route;
import service.business.AllCoordinatorLocal;
import service.managers.BCMSManagerLocal;

/**
 *
 * @author cfollet
 */
@ManagedBean(name = "BCMSBean")
@RequestScoped
public class BCMSBean {

    @EJB
    private BCMSManagerLocal _bcmsManager;

    @EJB
    private AllCoordinatorLocal _bcms;

    private BcmsSession _currentSession;

    public BCMSBean() {
    }

    @PostConstruct
    public void onCreate() {
        assert (_bcms != null);
        _currentSession = _bcms.getCurrentSession();
    }

    public List<Event> getEvents() {
        System.out.println("getEvents()");
        return _bcmsManager.getEvents(_currentSession);
    }
    
    public List<BcmsSession> getSessions(){
        System.out.println("getEvents(s)");
        return _bcmsManager.getSessions();
    }
    
    public List<Event> getEvents(BcmsSession session){
        return _bcmsManager.getEvents(session);
    }
    
    public List<Route> getRoutes(){
        return _bcmsManager.getRoutes();
    }

}
