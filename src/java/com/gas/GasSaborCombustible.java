/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mmixco
 */
@Entity
@Table(name = "GAS_SABOR_COMBUSTIBLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GasSaborCombustible.findAll", query = "SELECT g FROM GasSaborCombustible g"),
    @NamedQuery(name = "GasSaborCombustible.findByIdSabor", query = "SELECT g FROM GasSaborCombustible g WHERE g.idSabor = :idSabor"),
    @NamedQuery(name = "GasSaborCombustible.findByDescripcion", query = "SELECT g FROM GasSaborCombustible g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "GasSaborCombustible.findByEstado", query = "SELECT g FROM GasSaborCombustible g WHERE g.estado = :estado")})
public class GasSaborCombustible implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SABOR")
    private BigDecimal idSabor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 4)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "idSabor")
    private List<GasPrepagoDetalle> gasPrepagoDetalleList;

    public GasSaborCombustible() {
    }

    public GasSaborCombustible(BigDecimal idSabor) {
        this.idSabor = idSabor;
    }

    public GasSaborCombustible(BigDecimal idSabor, String descripcion) {
        this.idSabor = idSabor;
        this.descripcion = descripcion;
    }

    public BigDecimal getIdSabor() {
        return idSabor;
    }

    public void setIdSabor(BigDecimal idSabor) {
        this.idSabor = idSabor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<GasPrepagoDetalle> getGasPrepagoDetalleList() {
        return gasPrepagoDetalleList;
    }

    public void setGasPrepagoDetalleList(List<GasPrepagoDetalle> gasPrepagoDetalleList) {
        this.gasPrepagoDetalleList = gasPrepagoDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSabor != null ? idSabor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GasSaborCombustible)) {
            return false;
        }
        GasSaborCombustible other = (GasSaborCombustible) object;
        if ((this.idSabor == null && other.idSabor != null) || (this.idSabor != null && !this.idSabor.equals(other.idSabor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.GasSaborCombustible[ idSabor=" + idSabor + " ]";
    }
    
}
