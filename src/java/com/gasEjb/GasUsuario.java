/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gasEjb;

import com.gas.GasEstacion;
import com.gas.GascatUsuario;
import com.gas.GascatUsuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mmixco
 */
@Stateless
@LocalBean
public class GasUsuario {
    @EJB
    private GascatUsuarioFacade gascatUsuarioFacade;
   
    
    public String actualizarPass( String  pass, String pass1 , String pass2 ){
        
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);         
        GasEstacion ge =  (GasEstacion) session.getAttribute("SSESTACION" );
        String usuario = String.valueOf(session.getAttribute("SSUSUARIO" ));
        if(!pass1.equals(pass2)){
            return "El password nuevo no pudo ser confirmado";
        }
        
        List<GascatUsuario> lusuario = gascatUsuarioFacade.findByLoginEstacion(usuario , pass, ge );
        
        if(lusuario.isEmpty()){
                return "Password actual no valido ";
        }
        
        GascatUsuario gusu = lusuario.get(0);
        gusu.setPwd(pass1);
        gascatUsuarioFacade.edit(gusu);;
        
        
    
        return "Password actualizado correctamente";
    }
}
