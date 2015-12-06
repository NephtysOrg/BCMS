/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.pauware.pauware_engine._Exception.Statechart_exception;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import persistence.BcmsSession;
import persistence.BcmsSessionPoliceVehicle;
import persistence.Event;
import service.managers.PSCManagerLocal;
import service.business.PoliceStationCoordinatorLocal;

/**
 *
 * @author cfollet
 */
@ManagedBean(name = "PSCBean")
@RequestScoped
public class PSCBean {

    @EJB
    private PoliceStationCoordinatorLocal _psc;

    @EJB
    private PSCManagerLocal _pscManager;

    private BcmsSession _currentSession;

    /**
     * Creates a new instance of PSCBean
     */
    public PSCBean() {

    }

    @PostConstruct
    public void onCreate() {
        assert (_psc != null);
        _currentSession = _psc.getCurrentSession();
    }

    public void connect() {
        try {
            _psc.PSC_connection_request();
            _currentSession = _psc.getCurrentSession();
        } catch (Statechart_exception ex) {
            Logger.getLogger(FSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<BcmsSessionPoliceVehicle> getSessionPoliceVehicles() {
        return _pscManager.getSessionPoliceVehicles(_currentSession);
    }

}
