/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mmixco
 */
@Embeddable
public class GasClientePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CODIGO_EMPRESA")
    private String codigoEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CODIGO_ESTACION")
    private String codigoEstacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_CLIENTE")
    private BigInteger codigoCliente;

    public GasClientePK() {
    }

    public GasClientePK(String codigoEmpresa, String codigoEstacion, BigInteger codigoCliente) {
        this.codigoEmpresa = codigoEmpresa;
        this.codigoEstacion = codigoEstacion;
        this.codigoCliente = codigoCliente;
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

    public BigInteger getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(BigInteger codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEmpresa != null ? codigoEmpresa.hashCode() : 0);
        hash += (codigoEstacion != null ? codigoEstacion.hashCode() : 0);
        hash += (codigoCliente != null ? codigoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GasClientePK)) {
            return false;
        }
        GasClientePK other = (GasClientePK) object;
        if ((this.codigoEmpresa == null && other.codigoEmpresa != null) || (this.codigoEmpresa != null && !this.codigoEmpresa.equals(other.codigoEmpresa))) {
            return false;
        }
        if ((this.codigoEstacion == null && other.codigoEstacion != null) || (this.codigoEstacion != null && !this.codigoEstacion.equals(other.codigoEstacion))) {
            return false;
        }
        if ((this.codigoCliente == null && other.codigoCliente != null) || (this.codigoCliente != null && !this.codigoCliente.equals(other.codigoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.GasClientePK[ codigoEmpresa=" + codigoEmpresa + ", codigoEstacion=" + codigoEstacion + ", codigoCliente=" + codigoCliente + " ]";
    }
    
}
