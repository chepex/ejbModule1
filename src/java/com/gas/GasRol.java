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
@Table(name = "GAS_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GasRol.findAll", query = "SELECT g FROM GasRol g"),
    @NamedQuery(name = "GasRol.findByCodRol", query = "SELECT g FROM GasRol g WHERE g.codRol = :codRol"),
    @NamedQuery(name = "GasRol.findByNobre", query = "SELECT g FROM GasRol g WHERE g.nobre = :nobre"),
    @NamedQuery(name = "GasRol.findByEstado", query = "SELECT g FROM GasRol g WHERE g.estado = :estado")})
public class GasRol implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ROL")
    private BigDecimal codRol;
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

    public GasRol() {
    }

    public GasRol(BigDecimal codRol) {
        this.codRol = codRol;
    }

    public GasRol(BigDecimal codRol, String nobre, String estado) {
        this.codRol = codRol;
        this.nobre = nobre;
        this.estado = estado;
    }

    public BigDecimal getCodRol() {
        return codRol;
    }

    public void setCodRol(BigDecimal codRol) {
        this.codRol = codRol;
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
        hash += (codRol != null ? codRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GasRol)) {
            return false;
        }
        GasRol other = (GasRol) object;
        if ((this.codRol == null && other.codRol != null) || (this.codRol != null && !this.codRol.equals(other.codRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.GasRol[ codRol=" + codRol + " ]";
    }
    
}
