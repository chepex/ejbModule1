/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author informatica
 */
@Stateless
public class GasMenuRolFacade extends AbstractFacade<GasMenuRol> {

    @PersistenceContext(unitName = "sicgasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GasMenuRolFacade() {
        super(GasMenuRol.class);
    }
    
   public List<GasMenuRol> findByCodRol(  String rol) {
            TypedQuery<GasMenuRol> q = null;
            q = em.createNamedQuery("GasMenuRol.findByCodRol",GasMenuRol.class) 
            .setParameter("rol",rol);            
          
        return q.getResultList();
    }       
    
}
