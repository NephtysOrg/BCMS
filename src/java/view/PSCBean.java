package view;

import com.pauware.pauware_engine._Exception.Statechart_exception;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import persistence.BcmsSessionPoliceVehicle;
import service.managers.PSCManagerLocal;
import service.business.PoliceStationCoordinatorLocal;

/**
 * Managed bean used by the cops.
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

    @PostConstruct
    public void onCreate() {
        assert (_psc != null);
    }

    /**
     * See BCMS.PSC_connection_request
     */
    public void PSC_connection_request() {
        try {
            _psc.PSC_connection_request();
        } catch (Statechart_exception ex) {
            Logger.getLogger(FSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void route_for_police_vehicles(String route_name) {
        try {
            if (_psc.getCurrentSession() != null) {
                _psc.route_for_police_vehicles(route_name);
            }
        } catch (Statechart_exception ex) {
            Logger.getLogger(PSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void police_vehicle_dispatched(String police_vehicle) {
        try {
            if (_psc.getCurrentSession() != null) {
                _psc.police_vehicle_dispatched(police_vehicle);
            }
        } catch (Statechart_exception ex) {
            Logger.getLogger(PSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void police_vehicle_arrived(String police_vehicle) {
        try {
            if (_psc.getCurrentSession() != null) {
                _psc.police_vehicle_arrived(police_vehicle);
            }
        } catch (Statechart_exception ex) {
            Logger.getLogger(PSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void police_vehicle_breakdown(String police_vehicle,/* may be 'null' */ String replacement_police_vehicle) {
        try {
            if (_psc.getCurrentSession() != null) {
                _psc.police_vehicle_breakdown(police_vehicle, replacement_police_vehicle);
            }
        } catch (Statechart_exception ex) {
            Logger.getLogger(PSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void police_vehicle_blocked(String police_vehicle) {
        try {
            if (_psc.getCurrentSession() != null) {
                _psc.police_vehicle_blocked(police_vehicle);
            }
        } catch (Statechart_exception ex) {
            Logger.getLogger(PSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This function take a police vehicle and try to find an other one in order
     * to replace it due to a breakdown
     *
     * @param broken_pv
     * @return new pv name
     */
    public String getReplacementVehicle(BcmsSessionPoliceVehicle broken_pv) {
        List<BcmsSessionPoliceVehicle> candidates = getSessionPoliceVehicles();
        for (BcmsSessionPoliceVehicle candidate : candidates) {
            if (!broken_pv.equals(candidate) && candidate.getPoliceVehicleStatus().equals("Idle")) {
                return candidate.getPoliceVehicleName().getPoliceVehicleName();
            }
        }
        return null;
    }

    /**
     * Used to display all police vehicles in the UI.
     *
     * @return
     */
    public List<BcmsSessionPoliceVehicle> getSessionPoliceVehicles() {
        return _pscManager.getSessionPoliceVehicles(_psc.getCurrentSession());
    }

}
