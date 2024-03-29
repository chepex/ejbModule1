/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;

import java.math.BigInteger;
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
public class PrepagoControlConsumoFacade extends AbstractFacade<PrepagoControlConsumo> {

    @PersistenceContext(unitName = "sicgasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrepagoControlConsumoFacade() {
        super(PrepagoControlConsumo.class);
    }
    
        
    public List<PrepagoControlConsumo> findByPK( GasPrepagoDetalle gpd) {
            TypedQuery<PrepagoControlConsumo> q = null;
            q = em.createNamedQuery("PrepagoControlConsumo.findByPK",PrepagoControlConsumo.class) 
            .setParameter("codigoEmpresa",gpd.getGasPrepagoDetallePK().getCodigoEmpresa())
            .setParameter("codigoEstacion",gpd.getGasPrepagoDetallePK().getCodigoEstacion())            
            .setParameter("codigoPrepago",gpd.getGasPrepagoDetallePK().getCodigoPrepago())            
            .setParameter("noPrepago",gpd.getGasPrepagoDetallePK().getNoPrepago());            
            
          
        return q.getResultList();
    } 
    
    
 
    
    
    
    
}
