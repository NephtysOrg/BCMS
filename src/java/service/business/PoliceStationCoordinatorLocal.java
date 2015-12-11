package service.business;

import com.pauware.pauware_engine._Exception.Statechart_exception;
import javax.ejb.Local;
import persistence.BcmsSession;
/**
 *
 * @author cfollet
 */
@Local
public interface PoliceStationCoordinatorLocal {

    public void PSC_connection_request() throws Statechart_exception;

    public void state_police_vehicle_number(int number_of_police_vehicle_required) throws Statechart_exception;

    public void route_for_police_vehicles(String route_name) throws Statechart_exception;

    public void no_more_route_left() throws Statechart_exception;

    public void enough_police_vehicles_dispatched() throws Statechart_exception;

    public void police_vehicle_dispatched(String police_vehicle) throws Statechart_exception;

    public void enough_police_vehicles_arrived() throws Statechart_exception;

    public void police_vehicle_arrived(String police_vehicle) throws Statechart_exception;

    public void police_vehicle_breakdown(String police_vehicle,/* may be 'null' */ String replacement_police_vehicle) throws Statechart_exception;

    public void police_vehicle_blocked(String police_vehicle) throws Statechart_exception;

    public void crisis_is_more_severe() throws Statechart_exception;

    public void crisis_is_less_severe() throws Statechart_exception;

    public BcmsSession getCurrentSession();
    
}
