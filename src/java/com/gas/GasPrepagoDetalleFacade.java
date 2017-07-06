/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author mmixco
 */
@Stateless
public class GasPrepagoDetalleFacade extends AbstractFacade<GasPrepagoDetalle> {

    @PersistenceContext(unitName = "sicgasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GasPrepagoDetalleFacade() {
        super(GasPrepagoDetalle.class);
    }
    
    public List<GasPrepagoDetalle> findByCodigoPrepago(  GasPrepago gasPrepago) {
            TypedQuery<GasPrepagoDetalle> q = null;
            q = em.createNamedQuery("GasPrepagoDetalle.findByCodigoPrepago",GasPrepagoDetalle.class) 
            .setParameter("codigoPrepago",gasPrepago.getGasPrepagoPK().getCodigoPrepago());            
          
        return q.getResultList();
    }  
    
    public List<GasPrepagoDetalle> findByCodigoPrepagoUtilizado(  GasPrepago gasPrepago) {
            TypedQuery<GasPrepagoDetalle> q = null;
            q = em.createNamedQuery("GasPrepagoDetalle.findByCodigoPrepagoUtilizado",GasPrepagoDetalle.class) 
            .setParameter("codigoPrepago",gasPrepago.getGasPrepagoPK().getCodigoPrepago());            
          
        return q.getResultList();
    }      
    
    public List<GasPrepagoDetalle> findByNumero(  BigInteger numero) {
            TypedQuery<GasPrepagoDetalle> q = null;
            q = em.createNamedQuery("GasPrepagoDetalle.findByNoPrepago",GasPrepagoDetalle.class) 
            .setParameter("noPrepago",numero);            
          
        return q.getResultList();
    }      
    
         
    
    public List<GasPrepagoDetalle> findByFechaEstacion( Date finicio, Date ffin, GasEstacion ge) {
            TypedQuery<GasPrepagoDetalle> q = null;
            q = em.createNamedQuery("GasPrepagoDetalle.findByFechaEstacion",GasPrepagoDetalle.class) 
            .setParameter("finicio",finicio)    
            .setParameter("ffin",ffin)
            .setParameter("ge",ge);  
          
        return q.getResultList();
    }     
    
    public List<GasPrepagoDetalle> findByFecha( Date finicio, Date ffin) {
            TypedQuery<GasPrepagoDetalle> q = null;
            q = em.createNamedQuery("GasPrepagoDetalle.findByFecha",GasPrepagoDetalle.class) 
            .setParameter("finicio",finicio)    
            .setParameter("ffin",ffin);
        
          
        return q.getResultList();
    }       
    
    
    public List<GasPrepagoDetalle> findByNumeroBloqueados(  BigInteger numero, String estado) {
            TypedQuery<GasPrepagoDetalle> q = null;
            q = em.createNamedQuery("GasPrepagoDetalle.findByNoPrepagoEstado",GasPrepagoDetalle.class) 
                    .setParameter("noPrepago",numero)
                    .setParameter("estado",estado);            
             
        return q.getResultList();
    }     
    
    
      public BigDecimal findByMaxID(  ) {
          BigDecimal val  = new BigDecimal("0");
        try{
        Query q =  em.createNativeQuery("SELECT  nvl( Max(NO_PREPAGO),0)+1 FROM  GAS_PREPAGO_DETALLE " );		                        
             val  = (BigDecimal)q.getSingleResult();
                
       }catch(Exception ex){
            System.out.println("error ");
            val = new BigDecimal ("1");
        }
        
        return val;
    }     
    
  
   
    
}
