/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author informatica
 */
@Entity
@Table(name = "GAS_MODULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GasModulo.findAll", query = "SELECT g FROM GasModulo g"),
    @NamedQuery(name = "GasModulo.findByCodModulo", query = "SELECT g FROM GasModulo g WHERE g.codModulo = :codModulo"),
    @NamedQuery(name = "GasModulo.findByNobre", query = "SELECT g FROM GasModulo g WHERE g.nobre = :nobre"),
    @NamedQuery(name = "GasModulo.findByEstado", query = "SELECT g FROM GasModulo g WHERE g.estado = :estado")})
public class GasModulo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_MODULO")
    private BigDecimal codModulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "NOBRE")
    private String nobre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;

    public GasModulo() {
    }

    public GasModulo(BigDecimal codModulo) {
        this.codModulo = codModulo;
    }

    public GasModulo(BigDecimal codModulo, String nobre, String estado) {
        this.codModulo = codModulo;
        this.nobre = nobre;
        this.estado = estado;
    }

    public BigDecimal getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(BigDecimal codModulo) {
        this.codModulo = codModulo;
    }

    public String getNobre() {
        return nobre;
    }

    public void setNobre(String nobre) {
        this.nobre = nobre;
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
        hash += (codModulo != null ? codModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GasModulo)) {
            return false;
        }
        GasModulo other = (GasModulo) object;
        if ((this.codModulo == null && other.codModulo != null) || (this.codModulo != null && !this.codModulo.equals(other.codModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.GasModulo[ codModulo=" + codModulo + " ]";
    }
    
}
