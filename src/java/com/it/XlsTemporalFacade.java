/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it;


 
import com.gas.AbstractFacade;
import java.math.BigDecimal;
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
public class XlsTemporalFacade extends AbstractFacade<XlsTemporal> {
    @PersistenceContext(unitName = "sicgasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public XlsTemporalFacade() {
        super(XlsTemporal.class);
    }
    
    
    public BigDecimal findID(){
		Query q =  em.createNativeQuery("Select nvl( max(id),0)+1 from Xls_Temporal" );		                        
                BigDecimal val = (BigDecimal)q.getSingleResult();
        return val;
    }
    public BigDecimal findCarga(){
		Query q =  em.createNativeQuery("Select nvl( max(carga),0)+1 from Xls_Temporal" );		                        
                BigDecimal val = (BigDecimal)q.getSingleResult();
        return val;
    }   
    public List <XlsTemporal> findByCarga(BigDecimal carga){
             
                 TypedQuery<XlsTemporal> q;     

                        q = em.createNamedQuery("XlsTemporal.findByCarga", XlsTemporal.class )		                            
                        .setParameter("carga",  carga);
                
             return q.getResultList();
      
      
    }       
    
}
