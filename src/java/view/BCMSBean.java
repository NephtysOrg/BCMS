package view;

import com.pauware.pauware_engine._Exception.Statechart_exception;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * This Managed bean is used by both firemen and cops.
 * @author cfollet
 */
@ManagedBean(name = "BCMSBean")
@RequestScoped
public class BCMSBean {

    @EJB
    private BCMSManagerLocal _bcmsManager;

    @EJB
    private AllCoordinatorLocal _bcms;

    @PostConstruct
    public void onCreate() {
        assert (_bcms != null);
    }

    /**
     * 
     * @return all events
     */
    public List<Event> getEvents() {
        //System.out.println("getEvents()");
        return _bcmsManager.getEvents(_bcms.getCurrentSession());
    }
    
    /**
     * 
     * @return all sessions
     */
    public List<BcmsSession> getSessions(){
        //System.out.println("getEvents(s)");
        return _bcmsManager.getSessions();
    }
    
    /**
     * 
     * @param session
     * @return all events from the given session
     */
    public List<Event> getEvents(BcmsSession session){
        return _bcmsManager.getEvents(session);
    }
    
    /**
     * 
     * @return all route
     */
    public List<Route> getRoutes(){
        return _bcmsManager.getRoutes();
    }
    
    public void reset_database(){
        _bcms.reset_database();
    }
    
    /**
     * Stop the current crisis and clear the singleton
     */
     public void stop_and_clear(){
        try {
            _bcms.stop_and_clear();
        } catch (Statechart_exception ex) {
            Logger.getLogger(FSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
