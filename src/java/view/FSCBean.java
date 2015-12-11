package view;

import com.pauware.pauware_engine._Exception.Statechart_exception;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import persistence.BcmsSessionFireTruck;
import service.managers.FSCManagerLocal;
import service.business.FireStationCoordinatorLocal;

/**
 * Managed bean used by the Firemen.
 *
 * @author cfollet
 */
@RequestScoped
@ManagedBean(name = "FSCBean")
public class FSCBean implements Serializable {

    @EJB
    private FireStationCoordinatorLocal _fsc;
    @EJB
    private FSCManagerLocal _fscManager;

    @PostConstruct
    public void onCreate() {
        assert (_fsc != null);
    }

    /**
     * see BCMS.FSC_connection_request
     */
    public void FSC_connection_request() {
        try {
            _fsc.FSC_connection_request();
        } catch (Statechart_exception ex) {
            Logger.getLogger(FSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * See BCMS.fire_truck_dispatched
     *
     * @param name
     */
    public void fire_truck_dispatched(String name) {
        try {
            if (_fsc.getCurrentSession() != null) {
                _fsc.fire_truck_dispatched(name);
            }
        } catch (Statechart_exception ex) {
            Logger.getLogger(FSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * See BCMS.fire_truck_dispatched
     *
     * @param name
     */
    public void fire_truck_arrived(String name) {
        try {
            if (_fsc.getCurrentSession() != null) {
                _fsc.fire_truck_arrived(name);
            }
        } catch (Statechart_exception ex) {
            Logger.getLogger(FSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * See BCMS.fire_truck_dispatched
     *
     * @param broken_name
     * @param replacement_name
     */
    public void fire_truck_breakdown(String broken_name, String replacement_name) {
        try {
            if (_fsc.getCurrentSession() != null) {
                _fsc.fire_truck_breakdown(broken_name, replacement_name);
            }
        } catch (Statechart_exception ex) {
            Logger.getLogger(FSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This function take a fire truck and try to find an other one in order to
     * replace it due to a breakdown
     *
     * @param broken_ft
     * @return new ft name
     */
    public String getReplacementTruck(BcmsSessionFireTruck broken_ft) {
        List<BcmsSessionFireTruck> candidates = getSessionFireTrucks();
        for (BcmsSessionFireTruck candidate : candidates) {
            if (!broken_ft.equals(candidate) && candidate.getFireTruckStatus().equals("Idle")) {
                return candidate.getFireTruckName().getFireTruckName();
            }
        }
        return null;
    }

    /**
     * See BCMS.fire_truck_blocked
     *
     * @param name
     */
    public void fire_truck_blocked(String name) {
        try {
            if (_fsc.getCurrentSession() != null) {
                _fsc.fire_truck_blocked(name);
            }
        } catch (Statechart_exception ex) {
            Logger.getLogger(FSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * See BCMS.route_for_fire_trucks
     *
     * @param name
     */
    public void route_for_fire_trucks(String name) {
        try {
            if (_fsc.getCurrentSession() != null) {
                _fsc.route_for_fire_trucks(name);
            }
        } catch (Statechart_exception ex) {
            Logger.getLogger(FSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * See BCMS.FSC_agrees_about_fire_truck_route
     */
    public void FSC_agrees_about_fire_truck_route() {
        try {
            if (_fsc.getCurrentSession() != null) {
                _fsc.FSC_agrees_about_fire_truck_route();
            }
        } catch (Statechart_exception ex) {
            Logger.getLogger(FSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * See BCMS.FSC_agrees_about_police_vehicle_route
     */
    public void FSC_agrees_about_police_vehicle_route() {
        try {
            if (_fsc.getCurrentSession() != null) {
                _fsc.FSC_agrees_about_police_vehicle_route();
            }
        } catch (Statechart_exception ex) {
            Logger.getLogger(FSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * See BCMS.FSC_disagrees_about_fire_truck_route
     */
    public void FSC_disagrees_about_fire_truck_route() {
        try {
            if (_fsc.getCurrentSession() != null) {
                _fsc.FSC_disagrees_about_fire_truck_route();
            }
        } catch (Statechart_exception ex) {
            Logger.getLogger(FSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * See BCMS.FSC_disagrees_about_police_vehicle_route
     */
    public void FSC_disagrees_about_police_vehicle_route() {
        try {
            if (_fsc.getCurrentSession() != null) {
                _fsc.FSC_disagrees_about_police_vehicle_route();
            }
        } catch (Statechart_exception ex) {
            Logger.getLogger(FSCBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Used to display all fire trucks in the UI.
     *
     * @return
     */
    public List<BcmsSessionFireTruck> getSessionFireTrucks() {
        return _fscManager.getSessionFireTrucks(_fsc.getCurrentSession());
    }

}
