/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author mmixco
 */
@Entity
@Table(name = "GAS_CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GasCliente.findAll", query = "SELECT g FROM GasCliente g"),
    @NamedQuery(name = "GasCliente.findByCodigoEmpresa", query = "SELECT g FROM GasCliente g WHERE g.gasClientePK.codigoEmpresa = :codigoEmpresa"),
    @NamedQuery(name = "GasCliente.findByCodigoEstacion", query = "SELECT g FROM GasCliente g WHERE g.gasClientePK.codigoEstacion = :codigoEstacion"),
    @NamedQuery(name = "GasCliente.findByCodigoCliente", query = "SELECT g FROM GasCliente g WHERE g.gasClientePK.codigoCliente = :codigoCliente"),
    @NamedQuery(name = "GasCliente.findByNombres", query = "SELECT g FROM GasCliente g WHERE g.nombres = :nombres"),
    @NamedQuery(name = "GasCliente.findByApellidos", query = "SELECT g FROM GasCliente g WHERE g.apellidos = :apellidos"),
    @NamedQuery(name = "GasCliente.findByNoRegistro", query = "SELECT g FROM GasCliente g WHERE g.noRegistro = :noRegistro"),
    @NamedQuery(name = "GasCliente.findByGiro", query = "SELECT g FROM GasCliente g WHERE g.giro = :giro"),
    @NamedQuery(name = "GasCliente.findByTipoCliente", query = "SELECT g FROM GasCliente g WHERE g.tipoCliente = :tipoCliente"),
    @NamedQuery(name = "GasCliente.findByTelefono1", query = "SELECT g FROM GasCliente g WHERE g.telefono1 = :telefono1"),
    @NamedQuery(name = "GasCliente.findByTelefono2", query = "SELECT g FROM GasCliente g WHERE g.telefono2 = :telefono2"),
    @NamedQuery(name = "GasCliente.findByFax", query = "SELECT g FROM GasCliente g WHERE g.fax = :fax"),
    @NamedQuery(name = "GasCliente.findByGrancontribuyente", query = "SELECT g FROM GasCliente g WHERE g.grancontribuyente = :grancontribuyente"),
    @NamedQuery(name = "GasCliente.findByLimiteCredito", query = "SELECT g FROM GasCliente g WHERE g.limiteCredito = :limiteCredito"),
    @NamedQuery(name = "GasCliente.findBySaldo", query = "SELECT g FROM GasCliente g WHERE g.saldo = :saldo"),
    @NamedQuery(name = "GasCliente.findByCreditoDisponible", query = "SELECT g FROM GasCliente g WHERE g.creditoDisponible = :creditoDisponible"),
    @NamedQuery(name = "GasCliente.findByEstado", query = "SELECT g FROM GasCliente g WHERE g.estado = :estado"),
    @NamedQuery(name = "GasCliente.findByActivo", query = "SELECT g FROM GasCliente g WHERE g.estado = 'A' and  (g.nombres like :text or g.noRegistro like :text)  "),
    @NamedQuery(name = "GasCliente.findByNit", query = "SELECT g FROM GasCliente g WHERE g.nit = :nit"),
    @NamedQuery(name = "GasCliente.findByDireccion", query = "SELECT g FROM GasCliente g WHERE g.direccion = :direccion"),
    @NamedQuery(name = "GasCliente.findByCodigoDepartamento", query = "SELECT g FROM GasCliente g WHERE g.codigoDepartamento = :codigoDepartamento"),
    @NamedQuery(name = "GasCliente.findByCodigoMunicipio", query = "SELECT g FROM GasCliente g WHERE g.codigoMunicipio = :codigoMunicipio"),
    @NamedQuery(name = "GasCliente.findByPorcentajeDescuentoPista", query = "SELECT g FROM GasCliente g WHERE g.porcentajeDescuentoPista = :porcentajeDescuentoPista"),
    @NamedQuery(name = "GasCliente.findByPorcentajeDescuentoTienda", query = "SELECT g FROM GasCliente g WHERE g.porcentajeDescuentoTienda = :porcentajeDescuentoTienda"),
    @NamedQuery(name = "GasCliente.findByCodigoIslero", query = "SELECT g FROM GasCliente g WHERE g.codigoIslero = :codigoIslero"),
    @NamedQuery(name = "GasCliente.findByFechaModificacion", query = "SELECT g FROM GasCliente g WHERE g.fechaModificacion = :fechaModificacion")})
public class GasCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GasClientePK gasClientePK;
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
    @Column(name = "CODIGO_ISLERO")
    private BigInteger codigoIslero;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gasCliente")
    private List<GasPrepago> gasPrepagoList;
    
    
    public GasCliente() {
    }

    public GasCliente(GasClientePK gasClientePK) {
        this.gasClientePK = gasClientePK;
    }

    public GasCliente(GasClientePK gasClientePK, String nombres, String apellidos, String noRegistro, String tipoCliente) {
        this.gasClientePK = gasClientePK;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.noRegistro = noRegistro;
        this.tipoCliente = tipoCliente;
    }

    public GasCliente(String codigoEmpresa, String codigoEstacion, BigInteger codigoCliente) {
        this.gasClientePK = new GasClientePK(codigoEmpresa, codigoEstacion, codigoCliente);
    }

    public GasClientePK getGasClientePK() {
        return gasClientePK;
    }

    public void setGasClientePK(GasClientePK gasClientePK) {
        this.gasClientePK = gasClientePK;
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

    public List<GasPrepago> getGasPrepagoList() {
        return gasPrepagoList;
    }

    public void setGasPrepagoList(List<GasPrepago> gasPrepagoList) {
        this.gasPrepagoList = gasPrepagoList;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gasClientePK != null ? gasClientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GasCliente)) {
            return false;
        }
        GasCliente other = (GasCliente) object;
        if ((this.gasClientePK == null && other.gasClientePK != null) || (this.gasClientePK != null && !this.gasClientePK.equals(other.gasClientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.GasCliente[ gasClientePK=" + gasClientePK + " ]";
    }
    
}
