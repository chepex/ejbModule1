/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmixco
 */
@Entity
@Table(name = "GAS_PREPAGO_ERRORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GasPrepagoErrores.findAll", query = "SELECT g FROM GasPrepagoErrores g"),
    @NamedQuery(name = "GasPrepagoErrores.findByIdError", query = "SELECT g FROM GasPrepagoErrores g WHERE g.idError = :idError"),
    @NamedQuery(name = "GasPrepagoErrores.findByCodigoEmpresa", query = "SELECT g FROM GasPrepagoErrores g WHERE g.codigoEmpresa = :codigoEmpresa"),
    @NamedQuery(name = "GasPrepagoErrores.findByCodigoEstacion", query = "SELECT g FROM GasPrepagoErrores g WHERE g.codigoEstacion = :codigoEstacion"),
    
    @NamedQuery(name = "GasPrepagoErrores.findByCodigoPrepago", query = "SELECT g FROM GasPrepagoErrores g WHERE g.codigoPrepago = :codigoPrepago"),
    @NamedQuery(name = "GasPrepagoErrores.findByNoPrepago", query = "SELECT g FROM GasPrepagoErrores g WHERE g.noPrepago = :noPrepago"),
    @NamedQuery(name = "GasPrepagoErrores.findByDescripcion", query = "SELECT g FROM GasPrepagoErrores g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "GasPrepagoErrores.findByFecha", query = "SELECT g FROM GasPrepagoErrores g WHERE g.fecha = :fecha")})
public class GasPrepagoErrores implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ERROR")
    private BigDecimal idError;
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
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PREPAGO")
    private BigInteger codigoPrepago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_PREPAGO")
    private BigInteger noPrepago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public GasPrepagoErrores() {
    }

    public GasPrepagoErrores(BigDecimal idError) {
        this.idError = idError;
    }

    public GasPrepagoErrores(BigDecimal idError, String codigoEmpresa, String codigoEstacion, String usuario, BigInteger codigoPrepago, BigInteger noPrepago, String descripcion) {
        this.idError = idError;
        this.codigoEmpresa = codigoEmpresa;
        this.codigoEstacion = codigoEstacion;
        this.usuario = usuario;
        this.codigoPrepago = codigoPrepago;
        this.noPrepago = noPrepago;
        this.descripcion = descripcion;
    }

    public BigDecimal getIdError() {
        return idError;
    }

    public void setIdError(BigDecimal idError) {
        this.idError = idError;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idError != null ? idError.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GasPrepagoErrores)) {
            return false;
        }
        GasPrepagoErrores other = (GasPrepagoErrores) object;
        if ((this.idError == null && other.idError != null) || (this.idError != null && !this.idError.equals(other.idError))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.GasPrepagoErrores[ idError=" + idError + " ]";
    }
    
}
