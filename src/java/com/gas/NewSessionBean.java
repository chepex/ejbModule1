/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author mmixco
 */
@Stateless
@LocalBean
public class NewSessionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public String mas (){
        System.out.println("----->");
        System.out.println("----->");
        System.out.println("----->");
        System.out.println("----->");
        return "mas";
    }
}
