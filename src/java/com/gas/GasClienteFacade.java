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
 * @author mmixco
 */
@Stateless
public class GasClienteFacade extends AbstractFacade<GasCliente> {

    @PersistenceContext(unitName = "sicgasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GasClienteFacade() {
        super(GasCliente.class);
    }
    
    public List<GasCliente> findByActivos( String vtext) {
            TypedQuery<GasCliente> q = null;
            q = em.createNamedQuery("GasCliente.findByActivo",GasCliente.class) 
            .setParameter("text","%"+vtext+"%");            
          
        return q.getResultList();
    }      
    
    
       
    
}
