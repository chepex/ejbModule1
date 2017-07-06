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
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByCodigoEmpresa", query = "SELECT c FROM Cliente c WHERE c.codigoEmpresa = :codigoEmpresa"),
    @NamedQuery(name = "Cliente.findByCodigoEstacion", query = "SELECT c FROM Cliente c WHERE c.codigoEstacion = :codigoEstacion"),
    @NamedQuery(name = "Cliente.findByCodigoCliente", query = "SELECT c FROM Cliente c WHERE c.codigoCliente = :codigoCliente"),
    @NamedQuery(name = "Cliente.findByNombres", query = "SELECT c FROM Cliente c WHERE c.nombres = :nombres"),
    @NamedQuery(name = "Cliente.findByActivos", query = "SELECT c FROM Cliente c WHERE c.estado = 'A' and  (c.nombres like :text or c.noRegistro like :text)"),
    @NamedQuery(name = "Cliente.findByApellidos", query = "SELECT c FROM Cliente c WHERE c.apellidos = :apellidos"),
    @NamedQuery(name = "Cliente.findByNoRegistro", query = "SELECT c FROM Cliente c WHERE c.noRegistro = :noRegistro"),
    @NamedQuery(name = "Cliente.findByGiro", query = "SELECT c FROM Cliente c WHERE c.giro = :giro"),
    @NamedQuery(name = "Cliente.findByTipoCliente", query = "SELECT c FROM Cliente c WHERE c.tipoCliente = :tipoCliente"),
    @NamedQuery(name = "Cliente.findByTelefono1", query = "SELECT c FROM Cliente c WHERE c.telefono1 = :telefono1"),
    @NamedQuery(name = "Cliente.findByTelefono2", query = "SELECT c FROM Cliente c WHERE c.telefono2 = :telefono2"),
    @NamedQuery(name = "Cliente.findByFax", query = "SELECT c FROM Cliente c WHERE c.fax = :fax"),
    @NamedQuery(name = "Cliente.findByGrancontribuyente", query = "SELECT c FROM Cliente c WHERE c.grancontribuyente = :grancontribuyente"),
    @NamedQuery(name = "Cliente.findByLimiteCredito", query = "SELECT c FROM Cliente c WHERE c.limiteCredito = :limiteCredito"),
    @NamedQuery(name = "Cliente.findBySaldo", query = "SELECT c FROM Cliente c WHERE c.saldo = :saldo"),
    @NamedQuery(name = "Cliente.findByCreditoDisponible", query = "SELECT c FROM Cliente c WHERE c.creditoDisponible = :creditoDisponible"),
    @NamedQuery(name = "Cliente.findByEstado", query = "SELECT c FROM Cliente c WHERE c.estado = :estado"),
    @NamedQuery(name = "Cliente.findByNit", query = "SELECT c FROM Cliente c WHERE c.nit = :nit"),
    @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Cliente.findByCodigoDepartamento", query = "SELECT c FROM Cliente c WHERE c.codigoDepartamento = :codigoDepartamento"),
    @NamedQuery(name = "Cliente.findByCodigoMunicipio", query = "SELECT c FROM Cliente c WHERE c.codigoMunicipio = :codigoMunicipio"),
    @NamedQuery(name = "Cliente.findByPorcentajeDescuentoPista", query = "SELECT c FROM Cliente c WHERE c.porcentajeDescuentoPista = :porcentajeDescuentoPista"),
    @NamedQuery(name = "Cliente.findByPorcentajeDescuentoTienda", query = "SELECT c FROM Cliente c WHERE c.porcentajeDescuentoTienda = :porcentajeDescuentoTienda"),
    @NamedQuery(name = "Cliente.findByUsername", query = "SELECT c FROM Cliente c WHERE c.username = :username"),
    @NamedQuery(name = "Cliente.findByCodigoIslero", query = "SELECT c FROM Cliente c WHERE c.codigoIslero = :codigoIslero"),
    @NamedQuery(name = "Cliente.findByFechaModificacion", query = "SELECT c FROM Cliente c WHERE c.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Cliente.findByEstadoSincro", query = "SELECT c FROM Cliente c WHERE c.estadoSincro = :estadoSincro")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;
    @Size(max = 4)
    @Column(name = "CODIGO_EMPRESA")
    private String codigoEmpresa;
    @Size(max = 4)
    @Column(name = "CODIGO_ESTACION")
    private String codigoEstacion;
    @Column(name = "CODIGO_CLIENTE")
    private BigInteger codigoCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NO_REGISTRO")
    private String noRegistro;
    @Size(max = 60)
    @Column(name = "GIRO")
    private String giro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "TIPO_CLIENTE")
    private String tipoCliente;
    @Size(max = 10)
    @Column(name = "TELEFONO1")
    private String telefono1;
    @Size(max = 10)
    @Column(name = "TELEFONO2")
    private String telefono2;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 10)
    @Column(name = "FAX")
    private String fax;
    @Size(max = 4)
    @Column(name = "GRANCONTRIBUYENTE")
    private String grancontribuyente;
    @Column(name = "LIMITE_CREDITO")
    private BigInteger limiteCredito;
    @Column(name = "SALDO")
    private BigInteger saldo;
    @Column(name = "CREDITO_DISPONIBLE")
    private BigInteger creditoDisponible;
    @Size(max = 4)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 40)
    @Column(name = "NIT")
    private String nit;
    @Size(max = 250)
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "CODIGO_DEPARTAMENTO")
    private BigInteger codigoDepartamento;
    @Column(name = "CODIGO_MUNICIPIO")
    private BigInteger codigoMunicipio;
    @Column(name = "PORCENTAJE_DESCUENTO_PISTA")
    private BigInteger porcentajeDescuentoPista;
    @Column(name = "PORCENTAJE_DESCUENTO_TIENDA")
    private BigInteger porcentajeDescuentoTienda;
    @Size(max = 20)
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "CODIGO_ISLERO")
    private BigInteger codigoIslero;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "ESTADO_SINCRO")
    private BigInteger estadoSincro;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String nombres, String apellidos, String noRegistro, String tipoCliente) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.noRegistro = noRegistro;
        this.tipoCliente = tipoCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public BigInteger getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(BigInteger codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNoRegistro() {
        return noRegistro;
    }

    public void setNoRegistro(String noRegistro) {
        this.noRegistro = noRegistro;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getGrancontribuyente() {
        return grancontribuyente;
    }

    public void setGrancontribuyente(String grancontribuyente) {
        this.grancontribuyente = grancontribuyente;
    }

    public BigInteger getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigInteger limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public BigInteger getSaldo() {
        return saldo;
    }

    public void setSaldo(BigInteger saldo) {
        this.saldo = saldo;
    }

    public BigInteger getCreditoDisponible() {
        return creditoDisponible;
    }

    public void setCreditoDisponible(BigInteger creditoDisponible) {
        this.creditoDisponible = creditoDisponible;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigInteger getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(BigInteger codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public BigInteger getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(BigInteger codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public BigInteger getPorcentajeDescuentoPista() {
        return porcentajeDescuentoPista;
    }

    public void setPorcentajeDescuentoPista(BigInteger porcentajeDescuentoPista) {
        this.porcentajeDescuentoPista = porcentajeDescuentoPista;
    }

    public BigInteger getPorcentajeDescuentoTienda() {
        return porcentajeDescuentoTienda;
    }

    public void setPorcentajeDescuentoTienda(BigInteger porcentajeDescuentoTienda) {
        this.porcentajeDescuentoTienda = porcentajeDescuentoTienda;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigInteger getCodigoIslero() {
        return codigoIslero;
    }

    public void setCodigoIslero(BigInteger codigoIslero) {
        this.codigoIslero = codigoIslero;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public BigInteger getEstadoSincro() {
        return estadoSincro;
    }

    public void setEstadoSincro(BigInteger estadoSincro) {
        this.estadoSincro = estadoSincro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
