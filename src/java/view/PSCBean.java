/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import service.PoliceStationCoordinatorLocal;

/**
 *
 * @author cfollet
 */
@ManagedBean(name = "PSCBean")
@RequestScoped
public class PSCBean {

     @EJB
    private PoliceStationCoordinatorLocal _psc;
    /**
     * Creates a new instance of PSCBean
     */
    public PSCBean() {
         
    }
    
    @PostConstruct
    public void onCreate(){
        assert (_psc != null);
    }
    
}
