/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmixco
 */
@Entity
@Table(name = "GASCAT_CUENTA_BANCO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GascatCuentaBanco.findAll", query = "SELECT g FROM GascatCuentaBanco g"),
    @NamedQuery(name = "GascatCuentaBanco.findByCodigoBanco", query = "SELECT g FROM GascatCuentaBanco g WHERE g.gascatCuentaBancoPK.codigoBanco = :codigoBanco"),
    @NamedQuery(name = "GascatCuentaBanco.findByNoCuenta", query = "SELECT g FROM GascatCuentaBanco g WHERE g.gascatCuentaBancoPK.noCuenta = :noCuenta"),
    @NamedQuery(name = "GascatCuentaBanco.findByTipoCuenta", query = "SELECT g FROM GascatCuentaBanco g WHERE g.tipoCuenta = :tipoCuenta"),
    @NamedQuery(name = "GascatCuentaBanco.findBySaldo", query = "SELECT g FROM GascatCuentaBanco g WHERE g.saldo = :saldo"),
    @NamedQuery(name = "GascatCuentaBanco.findByEstado", query = "SELECT g FROM GascatCuentaBanco g WHERE g.estado = :estado")})
public class GascatCuentaBanco implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GascatCuentaBancoPK gascatCuentaBancoPK;
    @Size(max = 4)
    @Column(name = "TIPO_CUENTA")
    private String tipoCuenta;
    @Column(name = "SALDO")
    private BigInteger saldo;
    @Size(max = 4)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "CODIGO_BANCO", referencedColumnName = "CODIGO_BANCO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GascatBanco gascatBanco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gascatCuentaBanco")
    private List<GasPrepago> gasPrepagoList;        

    public GascatCuentaBanco() {
    }

    public GascatCuentaBanco(GascatCuentaBancoPK gascatCuentaBancoPK) {
        this.gascatCuentaBancoPK = gascatCuentaBancoPK;
    }

    public GascatCuentaBanco(String codigoBanco, String noCuenta) {
        this.gascatCuentaBancoPK = new GascatCuentaBancoPK(codigoBanco, noCuenta);
    }

    public GascatCuentaBancoPK getGascatCuentaBancoPK() {
        return gascatCuentaBancoPK;
    }

    public void setGascatCuentaBancoPK(GascatCuentaBancoPK gascatCuentaBancoPK) {
        this.gascatCuentaBancoPK = gascatCuentaBancoPK;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public BigInteger getSaldo() {
        return saldo;
    }

    public void setSaldo(BigInteger saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public GascatBanco getGascatBanco() {
        return gascatBanco;
    }

    public void setGascatBanco(GascatBanco gascatBanco) {
        this.gascatBanco = gascatBanco;
    }

    public List<GasPrepago> getGasPrepagoList() {
        return gasPrepagoList;
    }

    public void setGasPrepagoList(List<GasPrepago> gasPrepagoList) {
        this.gasPrepagoList = gasPrepagoList;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gascatCuentaBancoPK != null ? gascatCuentaBancoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GascatCuentaBanco)) {
            return false;
        }
        GascatCuentaBanco other = (GascatCuentaBanco) object;
        if ((this.gascatCuentaBancoPK == null && other.gascatCuentaBancoPK != null) || (this.gascatCuentaBancoPK != null && !this.gascatCuentaBancoPK.equals(other.gascatCuentaBancoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.GascatCuentaBanco[ gascatCuentaBancoPK=" + gascatCuentaBancoPK + " ]";
    }
    
}
