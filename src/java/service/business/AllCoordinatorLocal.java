/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.business;

import javax.ejb.Local;
import persistence.BcmsSession;

/**
 *
 * @author cfollet
 */
@Local
public interface AllCoordinatorLocal {

    public BcmsSession getCurrentSession();
}
