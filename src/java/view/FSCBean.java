/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.pauware.pauware_engine._Exception.Statechart_exception;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import persistence.BcmsSession;
import persistence.Event;
import service.FireStationCoordinatorLocal;

/**
 *
 * @author cfollet
 */
@ManagedBean
@ViewScoped
public class FSCBean implements Serializable {

    @EJB
    private FireStationCoordinatorLocal _fsc;

    private BcmsSession _currentSession;

    @javax.persistence.PersistenceContext(name = "CrisisPU")
    private javax.persistence.EntityManager _entity_manager;

    /**
     * Creates a new instance of BCMS
     */
    public FSCBean() {
    }

    @PostConstruct
    public void onCreate() {
        assert (_fsc != null);
    }



    public BcmsSession getCurrentCrysis() {
        return _fsc.getCurrentSession();
    }

    @Asynchronous
    public void startScenario() {
        try {
            System.out.println("->Managed Bean.StartScenario()");
            _currentSession = _fsc.createSession();
            _fsc.create_scenario();
            System.out.println("<-Managed Bean.StartScenario()");
        } catch (Statechart_exception ex) {
            Logger.getLogger(FSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Event> getEventList() {
        System.out.println("->getEventList()");

        List<Event> eventList = new ArrayList<>();
        eventList = _entity_manager.createNamedQuery("Event.findBySessionId").setParameter("sessionId", _currentSession).getResultList();

        System.out.println("Size :" + eventList.size());
        System.out.println("<-getEventList()");
        return eventList;
    }

}
