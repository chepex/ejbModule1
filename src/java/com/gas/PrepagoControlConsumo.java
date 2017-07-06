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
@Table(name = "PREPAGO_CONTROL_CONSUMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrepagoControlConsumo.findAll", query = "SELECT p FROM PrepagoControlConsumo p"),
    @NamedQuery(name = "PrepagoControlConsumo.findByIdControl", query = "SELECT p FROM PrepagoControlConsumo p WHERE p.idControl = :idControl"),
    @NamedQuery(name = "PrepagoControlConsumo.findByCodigoEmpresa", query = "SELECT p FROM PrepagoControlConsumo p WHERE p.codigoEmpresa = :codigoEmpresa"),
    @NamedQuery(name = "PrepagoControlConsumo.findByPK", query = "SELECT p FROM PrepagoControlConsumo p WHERE p.codigoEmpresa = :codigoEmpresa and p.codigoEstacion = :codigoEstacion and  p.codigoPrepago = :codigoPrepago and p.noPrepago = :noPrepago"),
    @NamedQuery(name = "PrepagoControlConsumo.findByCodigoEstacion", query = "SELECT p FROM PrepagoControlConsumo p WHERE p.codigoEstacion = :codigoEstacion"),
    @NamedQuery(name = "PrepagoControlConsumo.findByCodigoPrepago", query = "SELECT p FROM PrepagoControlConsumo p WHERE p.codigoPrepago = :codigoPrepago"),
    @NamedQuery(name = "PrepagoControlConsumo.findByNoPrepago", query = "SELECT p FROM PrepagoControlConsumo p WHERE p.noPrepago = :noPrepago"),
    @NamedQuery(name = "PrepagoControlConsumo.findByUsuario", query = "SELECT p FROM PrepagoControlConsumo p WHERE p.usuario = :usuario"),
    @NamedQuery(name = "PrepagoControlConsumo.findByFecha", query = "SELECT p FROM PrepagoControlConsumo p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "PrepagoControlConsumo.findByDigitado", query = "SELECT p FROM PrepagoControlConsumo p WHERE p.digitado = :digitado")})
public class PrepagoControlConsumo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CONTROL")
    private BigDecimal idControl;
    @Size(max = 4)
    @Column(name = "CODIGO_EMPRESA")
    private String codigoEmpresa;
    @Size(max = 4)
    @Column(name = "CODIGO_ESTACION")
    private String codigoEstacion;
    @Column(name = "CODIGO_PREPAGO")
    private BigInteger codigoPrepago;
    @Column(name = "NO_PREPAGO")
    private BigInteger noPrepago;
    @Size(max = 80)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 6)
    @Column(name = "DIGITADO")
    private String digitado;

    public PrepagoControlConsumo() {
    }

    public PrepagoControlConsumo(BigDecimal idControl) {
        this.idControl = idControl;
    }

    public BigDecimal getIdControl() {
        return idControl;
    }

    public void setIdControl(BigDecimal idControl) {
        this.idControl = idControl;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDigitado() {
        return digitado;
    }

    public void setDigitado(String digitado) {
        this.digitado = digitado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControl != null ? idControl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrepagoControlConsumo)) {
            return false;
        }
        PrepagoControlConsumo other = (PrepagoControlConsumo) object;
        if ((this.idControl == null && other.idControl != null) || (this.idControl != null && !this.idControl.equals(other.idControl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.PrepagoControlConsumo[ idControl=" + idControl + " ]";
    }
    
}
