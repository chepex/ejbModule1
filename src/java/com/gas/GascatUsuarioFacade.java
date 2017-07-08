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
public class GascatUsuarioFacade extends AbstractFacade<GascatUsuario> {

    @PersistenceContext(unitName = "sicgasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GascatUsuarioFacade() {
        super(GascatUsuario.class);
    }
    
    
    public List<GascatUsuario> findByCodigoEmpresa(GasEstacion gasEstacion ) {
        TypedQuery<GascatUsuario> q = null;
     
             q = em.createNamedQuery("GascatUsuario.findByCodigoEstacion",GascatUsuario.class)                        
                .setParameter("codigoEmpresa",gasEstacion.getGasEstacionPK().getCodigoEmpresa())
                .setParameter("codigoEstacion",gasEstacion.getGasEstacionPK().getCodigoEstacion());
              
        return q.getResultList();
    }  
    
    public List<GascatUsuario> findByLogin(String usuario, String pass ) {
        TypedQuery<GascatUsuario> q = null;     
        q = em.createNamedQuery("GascatUsuario.findByLogin",GascatUsuario.class)                        
           .setParameter("username",usuario)
           .setParameter("pass",pass);
              
        return q.getResultList();
    }   
    
    public List<GascatUsuario> findByLoginEstacion(String usuario, String pass , GasEstacion gasEstacion) {
        TypedQuery<GascatUsuario> q = null;     
        q = em.createNamedQuery("GascatUsuario.findByLoginEstacion",GascatUsuario.class)                        
           .setParameter("username",usuario)
           .setParameter("pass",pass)
        .setParameter("gasEstacion",gasEstacion);
              
        return q.getResultList();
    }    
    
    public List<GascatUsuario> findByUsuarioEstacion(String usuario, GasEstacion gasEstacion) {
        TypedQuery<GascatUsuario> q = null;     
        q = em.createNamedQuery("GascatUsuario.findByUsuarioEstacion",GascatUsuario.class)                        
           .setParameter("username",usuario)          
        .setParameter("gasEstacion",gasEstacion);
              
        return q.getResultList();
    }      
    
    public List<GascatUsuario> findByLoginEstacionIslero(BigInteger usuario, String pass , GasEstacion gasEstacion) {
        TypedQuery<GascatUsuario> q = null;     
        q = em.createNamedQuery("GascatUsuario.findByLoginEstacionIslero",GascatUsuario.class)                        
           .setParameter("usuario",usuario)
           .setParameter("pass",pass)
        .setParameter("gasEstacion",gasEstacion);
              
        return q.getResultList();
    }         
    
    public List<GascatUsuario> findByToken(String token) {
        TypedQuery<GascatUsuario> q = null;     
        q = em.createNamedQuery("GascatUsuario.findByToken",GascatUsuario.class)                        
           .setParameter("token",token);
          
              
        return q.getResultList();
    }    
    
    public List<GascatUsuario> findByUsername(String usuario) {
        TypedQuery<GascatUsuario> q = null;
     
        q = em.createNamedQuery("GascatUsuario.findByUsername",GascatUsuario.class)                        
           .setParameter("username",usuario);
           
              
        return q.getResultList();
    }     
    
    
   
    
}
