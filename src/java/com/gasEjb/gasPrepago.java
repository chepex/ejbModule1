/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gasEjb;

 
import com.gas.GasEstacion;
import com.gas.GasPrepago;
import com.gas.GasPrepagoDetalle;
import com.gas.GasPrepagoDetallePK;
import com.gas.GasSaborCombustible;
import com.gas.PrepagoControlConsumo;
import com.gas.PrepagoControlConsumoFacade;
import com.gas.PrepagoDetalle;
import static com.sun.faces.facelets.tag.jstl.fn.JstlFunction.trim;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
 

/**
 *
 * @author mmixco
 */
@Stateless 
public class gasPrepago {
    @EJB
    private com.gas.GasPrepagoFacade gasPrepagoFacade;
    @EJB
    private com.gas.GasPrepagoDetalleFacade gasPrepagoDetalleFacade;   
    @EJB
    private PrepagoControlConsumoFacade prepagoControlConsumoFacade;   
    
 
    
    

    public String  generarAutorizacion(BigInteger numero){
        String estado ="";
        /*1consultar autorizacion*/
        /*buscar si esta utilizada*/
        List<GasPrepago>  lgp = gasPrepagoFacade.findByNumero(numero);
        GasPrepago gp = lgp.get(0);
        
        if(gp.getAutorizacion()!=null){
                List<GasPrepagoDetalle> lpd = gasPrepagoDetalleFacade.findByNumero(numero);
                if(lpd.size()>0){
                    String vestado = lpd.get(0).getEstado();
                    if(vestado.equals("P")  ){
                        estado = "Libre";
                    }
                    if(vestado.equals("B")) {
                        estado = "Bloqueado";
                    }
                            
                    if(vestado.equals("C")) {
                        estado = "Utilizado";
                    }
                    
                    if(vestado.equals("A")) {
                        estado = "Anulado";
                    }
                    
                }else{
                    estado = "Sin Registros";
                }
        }else{
            estado = "No autorizado";
        }
        
        
        
        return estado;
        
    }
    
    public String conteoAutorizacion(GasPrepagoDetalle gpd, String usuario, String digitado){
        
        String msg = "OK";
        PrepagoControlConsumo pcc = new PrepagoControlConsumo();
        
        int vid = prepagoControlConsumoFacade.count();
        pcc.setIdControl(new BigDecimal(vid+1));
        pcc.setCodigoEmpresa(gpd.getGasPrepagoDetallePK().getCodigoEmpresa());
        pcc.setCodigoEstacion(gpd.getGasPrepagoDetallePK().getCodigoEstacion());
        pcc.setCodigoPrepago(gpd.getGasPrepagoDetallePK().getCodigoPrepago());
        pcc.setNoPrepago(gpd.getGasPrepagoDetallePK().getNoPrepago());
        pcc.setUsuario(usuario);
        pcc.setDigitado(digitado);    
        pcc.setFecha(new Date());
        prepagoControlConsumoFacade.edit(pcc);
        
        List <PrepagoControlConsumo> lpc = prepagoControlConsumoFacade.findByPK(gpd);
        
        if(lpc.size()>3){
            gpd.setEstado("B");
            gasPrepagoDetalleFacade.edit(gpd);
            msg = "Demasiados intentos llame al administrador, prepago bloqueado ";
        }
        
        
        return msg;
        
    }
    
    
    public String generarPrepagoEspecial(GasPrepago gasPrepago, List<PrepagoDetalle> ld ){
        String msg ="";
      
        List<GasPrepagoDetalle> gasPrepagoDetalleList = new ArrayList<GasPrepagoDetalle>();
      BigInteger vtotal = new BigInteger("0") ;
      BigInteger vcantidad = new BigInteger("0") ;
          BigInteger numero = BigInteger.valueOf(gasPrepagoDetalleFacade.findByMaxID().intValue());
          gasPrepago.setNumeroInicial(numero);
          
        for(PrepagoDetalle p : ld)    {
                System.out.println("---->"+p);  
                vtotal = vtotal.add(p.getCantidad().multiply(p.getValor()));
                vcantidad = vcantidad.add(p.getCantidad());
              
            for(int i =0; i<  p.getCantidad().intValue(); i++){
              
                
                GasPrepagoDetalle gpd = new GasPrepagoDetalle();
                GasPrepagoDetallePK pgdPk = new GasPrepagoDetallePK();
                pgdPk.setCodigoEmpresa(gasPrepago.getGasPrepagoPK().getCodigoEmpresa());
                pgdPk.setCodigoEstacion(gasPrepago.getGasPrepagoPK().getCodigoEstacion());
                pgdPk.setCodigoPrepago(gasPrepago.getGasPrepagoPK().getCodigoPrepago());
                pgdPk.setNoPrepago(numero);        
                gpd.setGasPrepagoDetallePK(pgdPk);
                gpd.setGasPrepago(gasPrepago);
                gpd.setValorPrepago(p.getValor());
                gpd.setEstado("P");
                gpd.setImpreso("N");
                gpd.setIdSabor(p.getIdSabor());
                
                gasPrepagoDetalleList.add(gpd);
                // gasPrepagoDetalleFacade.edit(gpd);
                //gasPrepagoDetalleList.add(gpd);
                //gasPrepagoDetalleFacade.edit(gpd);
                msg = "OK";
                numero = numero.add(BigInteger.ONE);
            }
            
        }
        
         gasPrepago.setNumeroFinal(numero.subtract(BigInteger.ONE));
        gasPrepago.setMontoPrepagoUsd(vtotal);
        gasPrepago.setTotalPrepagos(vcantidad);
           gasPrepago.setValorDePrepago(BigInteger.ZERO);
           gasPrepago.setSaldoPrepagoUsd(vtotal);
             
       gasPrepago.setGasPrepagoDetalleList(gasPrepagoDetalleList); 
        gasPrepagoFacade.edit(gasPrepago);
               
        return msg;
        
    }
    
  
  
    public String generarPrepago(GasPrepago gasPrepago ,GasSaborCombustible gc ){
        String msg ="";
        System.out.println("QUI1");
        List<GasPrepagoDetalle> gasPrepagoDetalleList = new ArrayList<GasPrepagoDetalle>();
      
            for(int i =gasPrepago.getNumeroInicial().intValue(); i<gasPrepago.getNumeroFinal().intValue(); i++){
                
                
                    BigInteger numero = BigInteger.valueOf(i );
                    
                    GasPrepagoDetalle gpd = new GasPrepagoDetalle();
                    GasPrepagoDetallePK pgdPk = new GasPrepagoDetallePK();
                    pgdPk.setCodigoEmpresa(gasPrepago.getGasPrepagoPK().getCodigoEmpresa());
                    pgdPk.setCodigoEstacion(gasPrepago.getGasPrepagoPK().getCodigoEstacion());
                    pgdPk.setCodigoPrepago(gasPrepago.getGasPrepagoPK().getCodigoPrepago());
                    pgdPk.setNoPrepago(numero);        
                    gpd.setGasPrepagoDetallePK(pgdPk);
                    gpd.setGasPrepago(gasPrepago);
                    gpd.setValorPrepago(gasPrepago.getValorDePrepago());
                    gpd.setEstado("P");
                    gpd.setImpreso("N");
                    gpd.setIdSabor(gc);
                   // gasPrepago.getGasPrepagoDetalleList().add(gpd);
                    gasPrepagoDetalleList.add(gpd);
                    //gasPrepagoDetalleFacade.edit(gpd);
                    msg = "OK";
            }
             
                    gasPrepago.setGasPrepagoDetalleList(gasPrepagoDetalleList);
                    gasPrepagoFacade.edit(gasPrepago);
               
        return msg;
        
    }
    
    public String generarAutorizacion(GasPrepago gasPrepago){
        
        String msg = "";
        List<GasPrepagoDetalle> lpd = gasPrepago.getGasPrepagoDetalleList();
      
        if(!lpd.isEmpty()){
                for (GasPrepagoDetalle pd : lpd) {
                   msg =  generarCodigo (pd ); 
                   if(msg.equals("error")){
                   return msg;
                   }
                }
                
                
                for (GasPrepagoDetalle pd : lpd) {
                     gasPrepagoDetalleFacade.edit(pd);                    
                }
               msg ="OK";               
        }
        
        return msg;
        
    }
    
    
    public String anular(GasPrepago gasPrepago){
        
        String msg = "";
        List<GasPrepagoDetalle> lpd = gasPrepago.getGasPrepagoDetalleList();
        System.out.println("lpd:"+lpd.size());
        if(!lpd.isEmpty()){
                for (GasPrepagoDetalle pd : lpd) {
                   if(pd.getEstado().equals("P")){
                       pd.setEstado("A");
                   }                  
                }
                 
                for (GasPrepagoDetalle pd : lpd) {
                     gasPrepagoDetalleFacade.edit(pd);                    
                }
               msg ="OK";               
        }
        
        return msg;
        
    }    
    
    public String generarCodigo (GasPrepagoDetalle gpd ){
        String msg = "";
           try {
            Random rn = new Random();
            int range = 9999 - 1 + 1;
            int randomNum =  rn.nextInt(range) + 1;
            gpd.setAutorizacion(String.valueOf(randomNum));
            String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            //gpd.setFechaAutorizado(new Date(fecha) );
            String hora = new SimpleDateFormat(" hh:mm:ss").format(new Date());
            System.out.println("hora-->"+trim(hora));
           // gpd.setHoraAutorizado(trim(hora));
            
          
            msg = "OK";
            }
            catch(Exception ex){  
                msg ="error";
                
            }
           
           return msg;
    
    }
    
   
    
    public String enviarEncabezado(GasPrepago  gp){
        String msg ="";
        System.out.println("enviado Autorizacion");
        String tt = "0";
        if (gp.isTodas()){
            tt = "1";
        }
        
        System.out.println("empresa-->" + gp.getGasPrepagoPK().getCodigoEmpresa());        
        System.out.println("empresa-->" + gp.getGasPrepagoPK().getCodigoEstacion());        
        StoredProcedureQuery storedProcedure  = gasPrepagoFacade.getEntityManager().createStoredProcedureQuery("ENCABEZADO_PREPAGO");
        storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        //storedProcedure.registerStoredProcedureParameter("VNUMERO", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(5, String.class, ParameterMode.OUT);
        storedProcedure.setParameter(1, gp.getGasPrepagoPK().getCodigoEmpresa());
        storedProcedure.setParameter(2, gp.getGasPrepagoPK().getCodigoEstacion());
        storedProcedure.setParameter(3, gp.getGasPrepagoPK().getCodigoPrepago().toString());
        storedProcedure.setParameter(4,tt );
        
        storedProcedure.execute();
        msg = (String) storedProcedure.getOutputParameterValue(5);
        
        System.out.println("Fin del envio---->"+msg);
        return msg;
    
    }
    
    public String enviarAutorizacion(GasPrepagoDetalle gpd, GasEstacion gd){
        String msg ="";
        System.out.println("enviado Autorizacion");
                
        StoredProcedureQuery storedProcedure  = gasPrepagoFacade.getEntityManager().createStoredProcedureQuery("DETALLE_PREPAGO");
        storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        //storedProcedure.registerStoredProcedureParameter("VNUMERO", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(5, String.class, ParameterMode.OUT);
        storedProcedure.setParameter(1, gd.getGasEstacionPK().getCodigoEmpresa());
        storedProcedure.setParameter(2, gd.getGasEstacionPK().getCodigoEstacion());
        storedProcedure.setParameter(3, gpd.getGasPrepagoDetallePK().getCodigoPrepago().toString());
        storedProcedure.setParameter(4, gpd.getGasPrepagoDetallePK().getNoPrepago().toString());       
        storedProcedure.execute();
        msg = (String) storedProcedure.getOutputParameterValue(5);
        
        System.out.println("Fin del envio---->"+msg);
        return msg;
    
    }
    
    
}
