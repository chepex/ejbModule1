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

/**
 *
 * @author mmixco
 */
@Embeddable
public class GasPrepagoDetallePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODIGO_EMPRESA")
    private String codigoEmpresa;
    @Basic(optional = false)
    @Column(name = "CODIGO_ESTACION")
    private String codigoEstacion;
    @Basic(optional = false)
    @Column(name = "CODIGO_PREPAGO")
    private BigInteger codigoPrepago;
    @Basic(optional = false)
    @Column(name = "NO_PREPAGO")
    private BigInteger noPrepago;

    public GasPrepagoDetallePK() {
    }

    public GasPrepagoDetallePK(String codigoEmpresa, String codigoEstacion, BigInteger codigoPrepago, BigInteger noPrepago) {
        this.codigoEmpresa = codigoEmpresa;
        this.codigoEstacion = codigoEstacion;
        this.codigoPrepago = codigoPrepago;
        this.noPrepago = noPrepago;
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

    public BigInteger getCodigoPrepago() {
        return codigoPrepago;
    }

    public void setCodigoPrepago(BigInteger codigoPrepago) {
        this.codigoPrepago = codigoPrepago;
    }

    public BigInteger getNoPrepago() {
        return noPrepago;
    }

    public void setNoPrepago(BigInteger noPrepago) {
        this.noPrepago = noPrepago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEmpresa != null ? codigoEmpresa.hashCode() : 0);
        hash += (codigoEstacion != null ? codigoEstacion.hashCode() : 0);
        hash += (codigoPrepago != null ? codigoPrepago.hashCode() : 0);
        hash += (noPrepago != null ? noPrepago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GasPrepagoDetallePK)) {
            return false;
        }
        GasPrepagoDetallePK other = (GasPrepagoDetallePK) object;
        if ((this.codigoEmpresa == null && other.codigoEmpresa != null) || (this.codigoEmpresa != null && !this.codigoEmpresa.equals(other.codigoEmpresa))) {
            return false;
        }
        if ((this.codigoEstacion == null && other.codigoEstacion != null) || (this.codigoEstacion != null && !this.codigoEstacion.equals(other.codigoEstacion))) {
            return false;
        }
        if ((this.codigoPrepago == null && other.codigoPrepago != null) || (this.codigoPrepago != null && !this.codigoPrepago.equals(other.codigoPrepago))) {
            return false;
        }
        if ((this.noPrepago == null && other.noPrepago != null) || (this.noPrepago != null && !this.noPrepago.equals(other.noPrepago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.GasPrepagoDetallePK[ codigoEmpresa=" + codigoEmpresa + ", codigoEstacion=" + codigoEstacion + ", codigoPrepago=" + codigoPrepago + ", noPrepago=" + noPrepago + " ]";
    }
    
}
