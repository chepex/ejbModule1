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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mmixco
 */
@Embeddable
public class GascatCuentaBancoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CODIGO_BANCO")
    private String codigoBanco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NO_CUENTA")
    private String noCuenta;

    public GascatCuentaBancoPK() {
    }

    public GascatCuentaBancoPK(String codigoBanco, String noCuenta) {
        this.codigoBanco = codigoBanco;
        this.noCuenta = noCuenta;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoBanco != null ? codigoBanco.hashCode() : 0);
        hash += (noCuenta != null ? noCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GascatCuentaBancoPK)) {
            return false;
        }
        GascatCuentaBancoPK other = (GascatCuentaBancoPK) object;
        if ((this.codigoBanco == null && other.codigoBanco != null) || (this.codigoBanco != null && !this.codigoBanco.equals(other.codigoBanco))) {
            return false;
        }
        if ((this.noCuenta == null && other.noCuenta != null) || (this.noCuenta != null && !this.noCuenta.equals(other.noCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.GascatCuentaBancoPK[ codigoBanco=" + codigoBanco + ", noCuenta=" + noCuenta + " ]";
    }
    
}
