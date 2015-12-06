/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.business;

import com.pauware.pauware_engine._Exception.Statechart_exception;
import java.util.ArrayList;
import javax.ejb.Asynchronous;
import javax.ejb.Local;
import persistence.BcmsSession;
import persistence.Route;

/**
 *
 * @author cfollet
 */
@Local
public interface FireStationCoordinatorLocal {

    public void FSC_connection_request() throws Statechart_exception;

    public void state_fire_truck_number(int number_of_fire_truck_required) throws Statechart_exception;

    public void route_for_fire_trucks(String route_name) throws Statechart_exception;

    public void FSC_agrees_about_fire_truck_route() throws Statechart_exception;

    public void FSC_agrees_about_police_vehicle_route() throws Statechart_exception;

    public void FSC_disagrees_about_fire_truck_route() throws Statechart_exception;

    public void FSC_disagrees_about_police_vehicle_route() throws Statechart_exception;

    public void enough_fire_trucks_dispatched() throws Statechart_exception;

    public void fire_truck_dispatched(String fire_truck) throws Statechart_exception;

    public void enough_fire_trucks_arrived() throws Statechart_exception;

    public void fire_truck_arrived(String fire_truck) throws Statechart_exception;

    public void fire_truck_breakdown(String fire_truck,/* may be 'null' */ String replacement_fire_truck) throws Statechart_exception;

    public void fire_truck_blocked(String fire_truck) throws Statechart_exception;

    public void crisis_is_more_severe() throws Statechart_exception;

    public void crisis_is_less_severe() throws Statechart_exception;

    @Asynchronous
    public void create_scenario() throws Statechart_exception;

    public BcmsSession getCurrentSession();

    public int getNumber_of_fire_truck_required();

    public ArrayList<String> getFire_trucks_dispatched();

    public ArrayList<String> getFire_trucks_arrived();

    public Route getLast_fire_truck_route();

    public BcmsSession createSession();

    public boolean isIsPSCConnected();

}
