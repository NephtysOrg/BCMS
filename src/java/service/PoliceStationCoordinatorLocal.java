/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.pauware.pauware_engine._Exception.Statechart_exception;
import java.util.ArrayList;
import javax.ejb.Local;
import persistence.BcmsSession;
import persistence.Route;

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

    public int getNumber_of_police_vehicle_required();

    public ArrayList<String> getPolice_vehicles_dispatched();

    public ArrayList<String> getPolice_vehicles_arrived();

    public Route getLast_police_vehicle_route();
    
}
