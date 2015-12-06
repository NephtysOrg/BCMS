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
import persistence.Event;
import persistence.Route;

/**
 *
 * @author cfollet
 */
@Stateless
public class FSCManager implements FSCManagerLocal {

    @javax.persistence.PersistenceContext(name = "CrisisPU")
    private javax.persistence.EntityManager _entity_manager;

    @Override
    public List<BcmsSessionFireTruck> getSessionFireTrucks(BcmsSession session) {
        Query q = _entity_manager.createNamedQuery("BcmsSessionFireTruck.findByBcmsSessionId").setParameter("bcmsSessionId", session);
        return (List<BcmsSessionFireTruck>) q.getResultList();
    }
    
}
