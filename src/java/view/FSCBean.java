/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.pauware.pauware_engine._Exception.Statechart_exception;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import persistence.BcmsSession;
import persistence.BcmsSessionFireTruck;
import persistence.Event;
import service.FSCManagerLocal;
import service.FireStationCoordinatorLocal;

/**
 *
 * @author cfollet
 */
@SessionScoped
@ManagedBean(name = "FSCBean")
public class FSCBean implements Serializable {

    @EJB
    private FireStationCoordinatorLocal _fsc;
    @EJB
    private FSCManagerLocal _fscManager;

    private BcmsSession _currentSession;

    @javax.persistence.PersistenceContext(name = "CrisisPU")
    private javax.persistence.EntityManager _entity_manager;

    public FSCBean() {
    }

    @PostConstruct
    public void onCreate() {
        assert (_fsc != null);
    }
    
    public void connect(){
        System.out.println("connect");
        try {
            _fsc.FSC_connection_request();
            _currentSession = _fsc.getCurrentSession();
        } catch (Statechart_exception ex) {
            Logger.getLogger(FSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<BcmsSessionFireTruck> getSessionFireTrucks() {
        return _fscManager.getSessionFireTrucks(_currentSession);
    }

    public List<Event> getEventList() {
        return _fscManager.getEvents(_currentSession);
    }

}
