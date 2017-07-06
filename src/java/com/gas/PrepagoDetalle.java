/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmixco
 */
@Entity
@Table(name = "PREPAGO_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrepagoDetalle.findAll", query = "SELECT p FROM PrepagoDetalle p"),
    @NamedQuery(name = "PrepagoDetalle.findByIdDetalle", query = "SELECT p FROM PrepagoDetalle p WHERE p.idDetalle = :idDetalle"),
    @NamedQuery(name = "PrepagoDetalle.findByCodigoPrepago", query = "SELECT p FROM PrepagoDetalle p WHERE p.codigoPrepago = :codigoPrepago"),
    @NamedQuery(name = "PrepagoDetalle.findByValor", query = "SELECT p FROM PrepagoDetalle p WHERE p.valor = :valor"),
    @NamedQuery(name = "PrepagoDetalle.findByCantidad", query = "SELECT p FROM PrepagoDetalle p WHERE p.cantidad = :cantidad")})
public class PrepagoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DETALLE")
    private BigDecimal idDetalle;
    @Column(name = "CODIGO_PREPAGO")
    private BigInteger codigoPrepago;
    @Column(name = "VALOR")
    private BigInteger valor;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @JoinColumn(name = "ID_SABOR", referencedColumnName = "ID_SABOR")
    @ManyToOne
    private GasSaborCombustible idSabor;     

    public PrepagoDetalle() {
    }

    public GasSaborCombustible getIdSabor() {
        return idSabor;
    }

    public void setIdSabor(GasSaborCombustible idSabor) {
        this.idSabor = idSabor;
    }
    
    

    public PrepagoDetalle(BigDecimal idDetalle) {
        this.idDetalle = idDetalle;
    }

    public BigDecimal getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(BigDecimal idDetalle) {
        this.idDetalle = idDetalle;
    }

    public BigInteger getCodigoPrepago() {
        return codigoPrepago;
    }

    public void setCodigoPrepago(BigInteger codigoPrepago) {
        this.codigoPrepago = codigoPrepago;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrepagoDetalle)) {
            return false;
        }
        PrepagoDetalle other = (PrepagoDetalle) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.PrepagoDetalle[ idDetalle=" + idDetalle + " ]";
    }
    
}
