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
public class GasEstacionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODIGO_EMPRESA")
    private String codigoEmpresa;
    @Basic(optional = false)
    @Column(name = "CODIGO_ESTACION")
    private String codigoEstacion;

    public GasEstacionPK() {
    }

    public GasEstacionPK(String codigoEmpresa, String codigoEstacion) {
        this.codigoEmpresa = codigoEmpresa;
        this.codigoEstacion = codigoEstacion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEmpresa != null ? codigoEmpresa.hashCode() : 0);
        hash += (codigoEstacion != null ? codigoEstacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GasEstacionPK)) {
            return false;
        }
        GasEstacionPK other = (GasEstacionPK) object;
        if ((this.codigoEmpresa == null && other.codigoEmpresa != null) || (this.codigoEmpresa != null && !this.codigoEmpresa.equals(other.codigoEmpresa))) {
            return false;
        }
        if ((this.codigoEstacion == null && other.codigoEstacion != null) || (this.codigoEstacion != null && !this.codigoEstacion.equals(other.codigoEstacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.GasEstacionPK[ codigoEmpresa=" + codigoEmpresa + ", codigoEstacion=" + codigoEstacion + " ]";
    }
    
}
