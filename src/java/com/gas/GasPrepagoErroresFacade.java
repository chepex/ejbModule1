/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mmixco
 */
@Stateless
public class GasPrepagoErroresFacade extends AbstractFacade<GasPrepagoErrores> {

    @PersistenceContext(unitName = "sicgasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GasPrepagoErroresFacade() {
        super(GasPrepagoErrores.class);
    }
    
      public BigDecimal findByMaxID(  ) {
          BigDecimal val  = new BigDecimal("0");
        try{
        Query q =  em.createNativeQuery("SELECT  nvl( Max(ID_ERROR),0)+1 FROM  GAS_PREPAGO_ERRORES " );		                        
             val  = (BigDecimal)q.getSingleResult();
                
       }catch(Exception ex){
            System.out.println("error ");
            val = new BigDecimal ("1");
        }
        
        return val;
    }     
        
    
}
