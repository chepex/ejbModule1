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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mmixco
 */
@Entity
@Table(name = "GAS_PREPAGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GasPrepago.findAll", query = "SELECT g FROM GasPrepago g"),
    
    @NamedQuery(name = "GasPrepago.findByPendiente", query = "SELECT g FROM GasPrepago g WHERE g.estado = 'A' and g.autorizacion = null "),    
    @NamedQuery(name = "GasPrepago.findByCodigoEmpresa", query = "SELECT g FROM GasPrepago g WHERE g.gasPrepagoPK.codigoEmpresa = :codigoEmpresa"),
    @NamedQuery(name = "GasPrepago.findByCodigoEstacion", query = "SELECT g FROM GasPrepago g WHERE g.gasPrepagoPK.codigoEstacion = :codigoEstacion"),
    @NamedQuery(name = "GasPrepago.findByCliente", query = "SELECT g FROM GasPrepago g WHERE g.cliente = :cliente order by g.gasPrepagoPK.codigoPrepago desc "),
    @NamedQuery(name = "GasPrepago.findByCodigoPrepago", query = "SELECT g FROM GasPrepago g WHERE g.gasPrepagoPK.codigoPrepago = :codigoPrepago"),
    @NamedQuery(name = "GasPrepago.findByNoRegistro", query = "SELECT g FROM GasPrepago g WHERE g.noRegistro = :noRegistro"),
    @NamedQuery(name = "GasPrepago.findByDescripcion", query = "SELECT g FROM GasPrepago g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "GasPrepago.findByFechaSolicitud", query = "SELECT g FROM GasPrepago g WHERE g.fechaSolicitud = :fechaSolicitud"),
    @NamedQuery(name = "GasPrepago.findByFechaCreacion", query = "SELECT g FROM GasPrepago g WHERE g.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "GasPrepago.findByVigencia", query = "SELECT g FROM GasPrepago g WHERE :ahora between g.fechaInicio and g.fechaFin and g.gasPrepagoPK.codigoPrepago = :codigo"),
    @NamedQuery(name = "GasPrepago.findByHoraCreacion", query = "SELECT g FROM GasPrepago g WHERE g.horaCreacion = :horaCreacion"),
    @NamedQuery(name = "GasPrepago.findByMontoPrepagoUsd", query = "SELECT g FROM GasPrepago g WHERE g.montoPrepagoUsd = :montoPrepagoUsd"),
    @NamedQuery(name = "GasPrepago.findBySaldoPrepagoUsd", query = "SELECT g FROM GasPrepago g WHERE g.saldoPrepagoUsd = :saldoPrepagoUsd"),
    @NamedQuery(name = "GasPrepago.findByTotalPrepagos", query = "SELECT g FROM GasPrepago g WHERE g.totalPrepagos = :totalPrepagos"),
    @NamedQuery(name = "GasPrepago.findByValorDePrepago", query = "SELECT g FROM GasPrepago g WHERE g.valorDePrepago = :valorDePrepago"),
    @NamedQuery(name = "GasPrepago.findByNumeroInicial", query = "SELECT g FROM GasPrepago g WHERE g.numeroInicial = :numeroInicial"),
    @NamedQuery(name = "GasPrepago.findByNumero", query = "SELECT g FROM GasPrepago g WHERE :numero between g.numeroInicial and g.numeroFinal "),    
    @NamedQuery(name = "GasPrepago.findByNumeroFinal", query = "SELECT g FROM GasPrepago g WHERE g.numeroFinal = :numeroFinal"),
    @NamedQuery(name = "GasPrepago.findByUsernameCreado", query = "SELECT g FROM GasPrepago g WHERE g.usernameCreado = :usernameCreado"),
    @NamedQuery(name = "GasPrepago.findByUsernameAutorizado", query = "SELECT g FROM GasPrepago g WHERE g.usernameAutorizado = :usernameAutorizado"),
    @NamedQuery(name = "GasPrepago.findByFechaAutorizado", query = "SELECT g FROM GasPrepago g WHERE g.fechaAutorizado = :fechaAutorizado"),
    @NamedQuery(name = "GasPrepago.findByHoraAutorizado", query = "SELECT g FROM GasPrepago g WHERE g.horaAutorizado = :horaAutorizado"),
    @NamedQuery(name = "GasPrepago.findByEstado", query = "SELECT g FROM GasPrepago g WHERE g.estado = :estado")})
public class GasPrepago implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GasPrepagoPK gasPrepagoPK;
    @Column(name = "NO_REGISTRO")
    private String noRegistro;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "FECHA_SOLICITUD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "HORA_CREACION")
    private String horaCreacion;
    @Column(name = "MONTO_PREPAGO_USD")
    private BigInteger montoPrepagoUsd;
    @Column(name = "SALDO_PREPAGO_USD")
    private BigInteger saldoPrepagoUsd;
    @Column(name = "TOTAL_PREPAGOS")
    private BigInteger totalPrepagos;
    @Column(name = "VALOR_DE_PREPAGO")
    private BigInteger valorDePrepago;
    @Column(name = "NUMERO_INICIAL")
    private BigInteger numeroInicial;
    @Column(name = "NUMERO_FINAL")
    private BigInteger numeroFinal;
    @Column(name = "USERNAME_CREADO")
    private String usernameCreado;
    @Column(name = "USERNAME_AUTORIZADO")
    private String usernameAutorizado;
    @Column(name = "FECHA_AUTORIZADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAutorizado;
    @Column(name = "HORA_AUTORIZADO")
    private String horaAutorizado;
    @Column(name = "TODAS")
    private boolean todas;
    @Column(name = "ESTADO")    
    private String estado;
    @Column(name = "AUTORIZACION")    
    private String autorizacion;   
    @Column(name = "IMPRESO")    
    private String impreso;        
    @Column(name = "NUM_FACTURA")    
    private String numFactura;       
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;    
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;  
    @Column(name = "NUM_REMESA")    
    private String numRemesa;     
    @Column(name = "VALOR")    
    private BigInteger valor;      
    @Column(name = "CODIGO_CLIENTE")
    private BigInteger codigoCliente;   
    @Column(name = "CODIGO_BANCO")
    private String codigoBanco;       
    @Column(name = "CODIGO_CUENTA")
    private String codigoCuenta;           
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;       
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gasPrepago")
    private List<GasPrepagoDetalle> gasPrepagoDetalleList;
    @JoinColumns({
        @JoinColumn(name = "CODIGO_EMPRESA", referencedColumnName = "CODIGO_EMPRESA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGO_ESTACION", referencedColumnName = "CODIGO_ESTACION", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private GasEstacion gasEstacion;
    @JoinColumns({
        @JoinColumn(name = "CODIGO_EMPRESA", referencedColumnName = "CODIGO_EMPRESA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGO_ESTACION", referencedColumnName = "CODIGO_ESTACION", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGO_CLIENTE", referencedColumnName = "CODIGO_CLIENTE", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private GasCliente gasCliente;    
    @JoinColumns({
        @JoinColumn(name = "CODIGO_EMPRESA", referencedColumnName = "CODIGO_EMPRESA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGO_ESTACION", referencedColumnName = "CODIGO_ESTACION", insertable = false, updatable = false),
        @JoinColumn(name = "USERNAME_CREADO", referencedColumnName = "USERNAME", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private GascatUsuario gascatUsuario;   
    @JoinColumns({
        @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE", insertable = false, updatable = false) })
    @ManyToOne(optional = false)
    private Cliente cliente;       
    @JoinColumns({
        @JoinColumn(name = "CODIGO_BANCO", referencedColumnName = "CODIGO_BANCO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private GascatBanco gascatBanco;    
    @JoinColumns({
        @JoinColumn(name = "CODIGO_BANCO", referencedColumnName = "CODIGO_BANCO", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGO_CUENTA", referencedColumnName = "NO_CUENTA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private GascatCuentaBanco gascatCuentaBanco;    
    

    public GasPrepago() {
    }

    public GascatUsuario getGascatUsuario() {
        return gascatUsuario;
    }

    public void setGascatUsuario(GascatUsuario gascatUsuario) {
        this.gascatUsuario = gascatUsuario;
    }

    
    
    public String getImpreso() {
        return impreso;
    }

    public void setImpreso(String impreso) {
        this.impreso = impreso;
    }

    
    
    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }
    
    
    
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNumRemesa() {
        return numRemesa;
    }

    public void setNumRemesa(String numRemesa) {
        this.numRemesa = numRemesa;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }


    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

   
    
    
    public BigInteger getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(BigInteger codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
    
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    
    
    public boolean isTodas() {
        return todas;
    }

    public void setTodas(boolean todas) {
        this.todas = todas;
    }
    
    

    public GasPrepago(GasPrepagoPK gasPrepagoPK) {
        this.gasPrepagoPK = gasPrepagoPK;
    }

    public GasPrepago(String codigoEmpresa, String codigoEstacion, BigInteger codigoPrepago) {
        this.gasPrepagoPK = new GasPrepagoPK(codigoEmpresa, codigoEstacion, codigoPrepago);
    }

    public GasPrepagoPK getGasPrepagoPK() {
        return gasPrepagoPK;
    }

    public void setGasPrepagoPK(GasPrepagoPK gasPrepagoPK) {
        this.gasPrepagoPK = gasPrepagoPK;
    }

    public String getNoRegistro() {
        return noRegistro;
    }

    public void setNoRegistro(String noRegistro) {
        this.noRegistro = noRegistro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(String horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    public BigInteger getMontoPrepagoUsd() {
        return montoPrepagoUsd;
    }

    public void setMontoPrepagoUsd(BigInteger montoPrepagoUsd) {
        this.montoPrepagoUsd = montoPrepagoUsd;
    }

    public BigInteger getSaldoPrepagoUsd() {
        return saldoPrepagoUsd;
    }

    public void setSaldoPrepagoUsd(BigInteger saldoPrepagoUsd) {
        this.saldoPrepagoUsd = saldoPrepagoUsd;
    }

    public BigInteger getTotalPrepagos() {
        return totalPrepagos;
    }

    public void setTotalPrepagos(BigInteger totalPrepagos) {
        this.totalPrepagos = totalPrepagos;
    }

    public BigInteger getValorDePrepago() {
        return valorDePrepago;
    }

    public void setValorDePrepago(BigInteger valorDePrepago) {
        this.valorDePrepago = valorDePrepago;
    }

    public BigInteger getNumeroInicial() {
        return numeroInicial;
    }

    public void setNumeroInicial(BigInteger numeroInicial) {
        this.numeroInicial = numeroInicial;
    }

    public BigInteger getNumeroFinal() {
        return numeroFinal;
    }

    public void setNumeroFinal(BigInteger numeroFinal) {
        this.numeroFinal = numeroFinal;
    }

    public String getUsernameCreado() {
        return usernameCreado;
    }

    public void setUsernameCreado(String usernameCreado) {
        this.usernameCreado = usernameCreado;
    }

    public String getUsernameAutorizado() {
        return usernameAutorizado;
    }

    public void setUsernameAutorizado(String usernameAutorizado) {
        this.usernameAutorizado = usernameAutorizado;
    }

    public Date getFechaAutorizado() {
        return fechaAutorizado;
    }

    public void setFechaAutorizado(Date fechaAutorizado) {
        this.fechaAutorizado = fechaAutorizado;
    }

    public String getHoraAutorizado() {
        return horaAutorizado;
    }

    public void setHoraAutorizado(String horaAutorizado) {
        this.horaAutorizado = horaAutorizado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public GasCliente getGasCliente() {
        return gasCliente;
    }

    public void setGasCliente(GasCliente gasCliente) {
        this.gasCliente = gasCliente;
    }

    public GascatBanco getGascatBanco() {
        return gascatBanco;
    }

    public void setGascatBanco(GascatBanco gascatBanco) {
        this.gascatBanco = gascatBanco;
    }

    public GascatCuentaBanco getGascatCuentaBanco() {
        return gascatCuentaBanco;
    }

    public void setGascatCuentaBanco(GascatCuentaBanco gascatCuentaBanco) {
        this.gascatCuentaBanco = gascatCuentaBanco;
    }
    
    

    @XmlTransient
    public List<GasPrepagoDetalle> getGasPrepagoDetalleList() {
        return gasPrepagoDetalleList;
    }

    public void setGasPrepagoDetalleList(List<GasPrepagoDetalle> gasPrepagoDetalleList) {
        this.gasPrepagoDetalleList = gasPrepagoDetalleList;
    }

    public GasEstacion getGasEstacion() {
        return gasEstacion;
    }

    public void setGasEstacion(GasEstacion gasEstacion) {
        this.gasEstacion = gasEstacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gasPrepagoPK != null ? gasPrepagoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GasPrepago)) {
            return false;
        }
        GasPrepago other = (GasPrepago) object;
        if ((this.gasPrepagoPK == null && other.gasPrepagoPK != null) || (this.gasPrepagoPK != null && !this.gasPrepagoPK.equals(other.gasPrepagoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.GasPrepago[ gasPrepagoPK=" + gasPrepagoPK + " ]";
    }
    
}
