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
public class GasEstacionFacade extends AbstractFacade<GasEstacion> {

    @PersistenceContext(unitName = "sicgasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GasEstacionFacade() {
        super(GasEstacion.class);
    }
    
    public List<GasEstacion> findByCodigoEmpresa(GasEmpresa gasEmpresa ) {
        TypedQuery<GasEstacion> q = null;
     
             q = em.createNamedQuery("GasEstacion.findByCodigoEmpresa",GasEstacion.class)               
                .setParameter("codigoEmpresa",gasEmpresa.getCodigoEmpresa());
              
        return q.getResultList();
    }        
    
}
