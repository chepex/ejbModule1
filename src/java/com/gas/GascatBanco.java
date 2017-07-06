/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmixco
 */
@Entity
@Table(name = "GASCAT_BANCO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GascatBanco.findAll", query = "SELECT g FROM GascatBanco g"),
    @NamedQuery(name = "GascatBanco.findByCodigoBanco", query = "SELECT g FROM GascatBanco g WHERE g.codigoBanco = :codigoBanco"),
    @NamedQuery(name = "GascatBanco.findByBanco", query = "SELECT g FROM GascatBanco g WHERE g.banco = :banco"),
    @NamedQuery(name = "GascatBanco.findByEstado", query = "SELECT g FROM GascatBanco g WHERE g.estado = :estado")})
public class GascatBanco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CODIGO_BANCO")
    private String codigoBanco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "BANCO")
    private String banco;
    @Size(max = 4)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gascatBanco")
    private List<GasPrepago> gasPrepagoList;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gascatBanco")
    private List<GascatCuentaBanco> gascatCuentaBancoList;        

    public GascatBanco() {
    }

    public List<GascatCuentaBanco> getGascatCuentaBancoList() {
        return gascatCuentaBancoList;
    }

    public void setGascatCuentaBancoList(List<GascatCuentaBanco> gascatCuentaBancoList) {
        this.gascatCuentaBancoList = gascatCuentaBancoList;
    }

    public List<GasPrepago> getGasPrepagoList() {
        return gasPrepagoList;
    }

    public void setGasPrepagoList(List<GasPrepago> gasPrepagoList) {
        this.gasPrepagoList = gasPrepagoList;
    }
    
    

    public GascatBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public GascatBanco(String codigoBanco, String banco) {
        this.codigoBanco = codigoBanco;
        this.banco = banco;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoBanco != null ? codigoBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GascatBanco)) {
            return false;
        }
        GascatBanco other = (GascatBanco) object;
        if ((this.codigoBanco == null && other.codigoBanco != null) || (this.codigoBanco != null && !this.codigoBanco.equals(other.codigoBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.GascatBanco[ codigoBanco=" + codigoBanco + " ]";
    }
    
}
