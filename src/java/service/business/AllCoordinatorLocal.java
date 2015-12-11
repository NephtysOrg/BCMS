/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.business;

import com.pauware.pauware_engine._Exception.Statechart_exception;
import javax.ejb.Local;
import persistence.BcmsSession;

/**
 *
 * @author cfollet
 */
@Local
public interface AllCoordinatorLocal {

    public BcmsSession getCurrentSession();
    
    public void stop_and_clear() throws Statechart_exception;
    
    public void reset_database();
}
