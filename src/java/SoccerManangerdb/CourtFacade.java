/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SoccerManangerdb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alberto
 */
@Stateless
public class CourtFacade extends AbstractFacade<Court> {

    @PersistenceContext(unitName = "Soccer_ManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CourtFacade() {
        super(Court.class);
    }
    
}
