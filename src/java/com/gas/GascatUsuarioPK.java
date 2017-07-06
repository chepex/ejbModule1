/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author mmixco
 */
@Embeddable
public class GascatUsuarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODIGO_EMPRESA")
    private String codigoEmpresa;
    @Basic(optional = false)
    @Column(name = "CODIGO_ESTACION")
    private String codigoEstacion;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;

    public GascatUsuarioPK() {
    }

    public GascatUsuarioPK(String codigoEmpresa, String codigoEstacion, String username) {
        this.codigoEmpresa = codigoEmpresa;
        this.codigoEstacion = codigoEstacion;
        this.username = username;
    }

    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getCodigoEstacion() {
        return codigoEstacion;
    }

    public void setCodigoEstacion(String codigoEstacion) {
        this.codigoEstacion = codigoEstacion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEmpresa != null ? codigoEmpresa.hashCode() : 0);
        hash += (codigoEstacion != null ? codigoEstacion.hashCode() : 0);
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GascatUsuarioPK)) {
            return false;
        }
        GascatUsuarioPK other = (GascatUsuarioPK) object;
        if ((this.codigoEmpresa == null && other.codigoEmpresa != null) || (this.codigoEmpresa != null && !this.codigoEmpresa.equals(other.codigoEmpresa))) {
            return false;
        }
        if ((this.codigoEstacion == null && other.codigoEstacion != null) || (this.codigoEstacion != null && !this.codigoEstacion.equals(other.codigoEstacion))) {
            return false;
        }
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.GascatUsuarioPK[ codigoEmpresa=" + codigoEmpresa + ", codigoEstacion=" + codigoEstacion + ", username=" + username + " ]";
    }
    
}
