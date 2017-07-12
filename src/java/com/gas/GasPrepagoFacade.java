/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
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
public class GasPrepagoFacade extends AbstractFacade<GasPrepago> {

    @PersistenceContext(unitName = "sicgasPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public GasPrepagoFacade() {
        super(GasPrepago.class);
    }
    

    public List<GasPrepago> findByCodigoCliente( Cliente vcliente) {
         TypedQuery<GasPrepago> q = null;
        try{        
            q = em.createNamedQuery("GasPrepago.findByCliente",GasPrepago.class)                    
            .setParameter("cliente",vcliente);            
            q.getResultList();            
        }catch(Exception ex){
            System.out.println("erorr--->"+ex);
        }
        return q.getResultList();
    } 
    
      
    
    public List<GasPrepago> findByNumero( BigInteger numero) {
        TypedQuery<GasPrepago> q = null;
        List<GasPrepago> lp = new ArrayList<GasPrepago>();
        try{        
            q = em.createNamedQuery("GasPrepago.findByNumero",GasPrepago.class)                    
            .setParameter("numero",numero);            
            q.getResultList();            
        }catch(Exception ex){
            System.out.println("erorr--->"+ex);
            return lp;
        }
        return q.getResultList();
    } 

    public List<GasPrepago> findByVigencia( BigInteger numero) {
        TypedQuery<GasPrepago> q = null;
        List<GasPrepago> lp = new ArrayList<GasPrepago>();
        try{        
            q = em.createNamedQuery("GasPrepago.findByVigencia",GasPrepago.class)                    
            .setParameter("codigo",numero)
            .setParameter("ahora",new Date());
              
            q.getResultList();            
        }catch(Exception ex){
            System.out.println("erorr--->"+ex);
            return lp;
        }
        return q.getResultList();
    }  
    
    public BigDecimal findByMaxRango(  ) {
          BigDecimal val  = new BigDecimal("0");
        try{
        Query q =  em.createNativeQuery("SELECT  nvl( Max(NUMERO_FINAL),0)+1 FROM  GAS_PREPAGO " );		                        
             val  = (BigDecimal)q.getSingleResult();
                
        }catch(Exception ex){
            System.out.println("error ");
            val = new BigDecimal ("1");
        }
        
        return val;
    } 
    
    public BigDecimal findByMaxID(  ) {
          BigDecimal val  = new BigDecimal("0");
        try{
        Query q =  em.createNativeQuery("SELECT  nvl( Max(CODIGO_PREPAGO),0)+1 FROM  GAS_PREPAGO " );		                        
             val  = (BigDecimal)q.getSingleResult();
                
       }catch(Exception ex){
            System.out.println("error ");
            val = new BigDecimal ("1");
        }
        
        return val;
    }        
    
    
    public List<GascatCuentaBanco> findByBanco( GascatBanco banco) {
         TypedQuery<GascatCuentaBanco> q = null;
        try{        
            q = em.createNamedQuery("GascatCuentaBanco.findByCodigoBanco",GascatCuentaBanco.class)                    
            .setParameter("codigoBanco",banco.getCodigoBanco());            
            q.getResultList();            
        }catch(Exception ex){
            System.out.println("erorr--->"+ex);
        }
        return q.getResultList();
    }      


    public List<GasPrepago> findByPendiente(  ) {
         TypedQuery<GasPrepago> q = null;
        try{        
            q = em.createNamedQuery("GasPrepago.findByPendiente",GasPrepago.class)   ;                 
             
            q.getResultList();            
        }catch(Exception ex){
            System.out.println("erorr--->"+ex);
        }
        return q.getResultList();
    }      
    
}
