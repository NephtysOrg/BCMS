/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.managers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import persistence.BcmsSession;
import persistence.BcmsSessionFireTruck;
import persistence.BcmsSessionPoliceVehicle;
import persistence.Event;
import persistence.Route;

/**
 *
 * @author cfollet
 */
@Stateless
public class PSCManager implements PSCManagerLocal {

    @javax.persistence.PersistenceContext(name = "CrisisPU")
    private javax.persistence.EntityManager _entity_manager;

    @Override
    public List<BcmsSessionPoliceVehicle> getSessionPoliceVehicles(BcmsSession session) {
        Query q = _entity_manager.createNamedQuery("BcmsSessionPoliceVehicle.findByBcmsSessionId").setParameter("bcmsSessionId", session);
        return (List<BcmsSessionPoliceVehicle>) q.getResultList();
    }
    
    
}
