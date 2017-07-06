/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmixco
 */
@Entity
@Table(name = "GASCAT_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GascatUsuario.findAll", query = "SELECT g FROM GascatUsuario g"),
    @NamedQuery(name = "GascatUsuario.findByCodigoEmpresa", query = "SELECT g FROM GascatUsuario g WHERE g.gascatUsuarioPK.codigoEmpresa = :codigoEmpresa"),
    @NamedQuery(name = "GascatUsuario.findByCodigoEstacion", query = "SELECT g FROM GascatUsuario g WHERE g.gascatUsuarioPK.codigoEstacion = :codigoEstacion and g.gascatUsuarioPK.codigoEmpresa = :codigoEmpresa "),
    @NamedQuery(name = "GascatUsuario.findByUsername", query = "SELECT g FROM GascatUsuario g WHERE g.gascatUsuarioPK.username = :username"),
    @NamedQuery(name = "GascatUsuario.findByLogin", query = "SELECT g FROM GascatUsuario g WHERE g.gascatUsuarioPK.username = :username and g.pwd = :pass"),
    @NamedQuery(name = "GascatUsuario.findByLoginEstacion", query = "SELECT g FROM GascatUsuario g WHERE g.gascatUsuarioPK.username = :username and g.pwd = :pass and g.gasEstacion = :gasEstacion and g.estado = 'A' "),
    @NamedQuery(name = "GascatUsuario.findByLoginEstacionIslero", query = "SELECT g FROM GascatUsuario g WHERE g.codigoIslero = :usuario and g.pwd = :pass and g.gasEstacion = :gasEstacion and g.estado = 'A' "),    
    @NamedQuery(name = "GascatUsuario.findByToken", query = "SELECT g FROM GascatUsuario g WHERE g.token = :token"),    
    @NamedQuery(name = "GascatUsuario.findByNombre", query = "SELECT g FROM GascatUsuario g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "GascatUsuario.findByApellido", query = "SELECT g FROM GascatUsuario g WHERE g.apellido = :apellido"),
    @NamedQuery(name = "GascatUsuario.findByFechaActivacion", query = "SELECT g FROM GascatUsuario g WHERE g.fechaActivacion = :fechaActivacion"),
    @NamedQuery(name = "GascatUsuario.findByFechaCancelacion", query = "SELECT g FROM GascatUsuario g WHERE g.fechaCancelacion = :fechaCancelacion"),
    @NamedQuery(name = "GascatUsuario.findByMotivoCancelacion", query = "SELECT g FROM GascatUsuario g WHERE g.motivoCancelacion = :motivoCancelacion"),
    @NamedQuery(name = "GascatUsuario.findByEstado", query = "SELECT g FROM GascatUsuario g WHERE g.estado = :estado"),
    @NamedQuery(name = "GascatUsuario.findByCodigoIslero", query = "SELECT g FROM GascatUsuario g WHERE g.codigoIslero = :codigoIslero"),
    @NamedQuery(name = "GascatUsuario.findByPwd", query = "SELECT g FROM GascatUsuario g WHERE g.pwd = :pwd")})
public class GascatUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GascatUsuarioPK gascatUsuarioPK;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "FECHA_ACTIVACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActivacion;
    @Column(name = "FECHA_CANCELACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCancelacion;
    @Column(name = "ULTIMO_ACCESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoAcceso;    
    @Column(name = "MOTIVO_CANCELACION")
    private String motivoCancelacion;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "TOKEN")
    private String token;    
    @Column(name = "CODIGO_ISLERO")
    private BigInteger codigoIslero;
    @Column(name = "CONECTADO")
    private boolean conectado;    
    @Column(name = "PWD")
    private String pwd;
    @JoinColumns({
        @JoinColumn(name = "CODIGO_EMPRESA", referencedColumnName = "CODIGO_EMPRESA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGO_ESTACION", referencedColumnName = "CODIGO_ESTACION", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private GasEstacion gasEstacion;
    @JoinColumn(name = "CODIGO_TIPOROL", referencedColumnName = "CODIGO_TIPOROL")
    @ManyToOne
    private GascatTipoRol codigoTiporol;

    public GascatUsuario() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
 
    
    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    
    
    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    
    
    public GascatUsuario(GascatUsuarioPK gascatUsuarioPK) {
        this.gascatUsuarioPK = gascatUsuarioPK;
    }

    public GascatUsuario(GascatUsuarioPK gascatUsuarioPK, String nombre, String apellido, Date fechaActivacion) {
        this.gascatUsuarioPK = gascatUsuarioPK;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaActivacion = fechaActivacion;
    }

    public GascatUsuario(String codigoEmpresa, String codigoEstacion, String username) {
        this.gascatUsuarioPK = new GascatUsuarioPK(codigoEmpresa, codigoEstacion, username);
    }

    public GascatUsuarioPK getGascatUsuarioPK() {
        return gascatUsuarioPK;
    }

    public void setGascatUsuarioPK(GascatUsuarioPK gascatUsuarioPK) {
        this.gascatUsuarioPK = gascatUsuarioPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(Date fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public String getMotivoCancelacion() {
        return motivoCancelacion;
    }

    public void setMotivoCancelacion(String motivoCancelacion) {
        this.motivoCancelacion = motivoCancelacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigInteger getCodigoIslero() {
        return codigoIslero;
    }

    public void setCodigoIslero(BigInteger codigoIslero) {
        this.codigoIslero = codigoIslero;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public GasEstacion getGasEstacion() {
        return gasEstacion;
    }

    public void setGasEstacion(GasEstacion gasEstacion) {
        this.gasEstacion = gasEstacion;
    }

    public GascatTipoRol getCodigoTiporol() {
        return codigoTiporol;
    }

    public void setCodigoTiporol(GascatTipoRol codigoTiporol) {
        this.codigoTiporol = codigoTiporol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gascatUsuarioPK != null ? gascatUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GascatUsuario)) {
            return false;
        }
        GascatUsuario other = (GascatUsuario) object;
        if ((this.gascatUsuarioPK == null && other.gascatUsuarioPK != null) || (this.gascatUsuarioPK != null && !this.gascatUsuarioPK.equals(other.gascatUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.GascatUsuario[ gascatUsuarioPK=" + gascatUsuarioPK + " ]";
    }
    
}
