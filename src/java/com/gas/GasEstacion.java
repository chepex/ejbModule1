/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mmixco
 */
@Entity
@Table(name = "GAS_ESTACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GasEstacion.findAll", query = "SELECT g FROM GasEstacion g"),
    @NamedQuery(name = "GasEstacion.findByCodigoEmpresa", query = "SELECT g FROM GasEstacion g WHERE g.gasEstacionPK.codigoEmpresa = :codigoEmpresa"),
    @NamedQuery(name = "GasEstacion.findByCodigoEstacion", query = "SELECT g FROM GasEstacion g WHERE g.gasEstacionPK.codigoEstacion = :codigoEstacion"),
    @NamedQuery(name = "GasEstacion.findByNombreEstacion", query = "SELECT g FROM GasEstacion g WHERE g.nombreEstacion = :nombreEstacion"),
    @NamedQuery(name = "GasEstacion.findByTelefonoFijo", query = "SELECT g FROM GasEstacion g WHERE g.telefonoFijo = :telefonoFijo"),
    @NamedQuery(name = "GasEstacion.findByFax", query = "SELECT g FROM GasEstacion g WHERE g.fax = :fax"),
    @NamedQuery(name = "GasEstacion.findByResponsable", query = "SELECT g FROM GasEstacion g WHERE g.responsable = :responsable"),
    @NamedQuery(name = "GasEstacion.findByEstado", query = "SELECT g FROM GasEstacion g WHERE g.estado = :estado"),
    @NamedQuery(name = "GasEstacion.findByNombrePropietarioEstacion", query = "SELECT g FROM GasEstacion g WHERE g.nombrePropietarioEstacion = :nombrePropietarioEstacion"),
    @NamedQuery(name = "GasEstacion.findByDireccion", query = "SELECT g FROM GasEstacion g WHERE g.direccion = :direccion"),
    @NamedQuery(name = "GasEstacion.findByIvaDl", query = "SELECT g FROM GasEstacion g WHERE g.ivaDl = :ivaDl"),
    @NamedQuery(name = "GasEstacion.findByNombreTienda", query = "SELECT g FROM GasEstacion g WHERE g.nombreTienda = :nombreTienda")})
public class GasEstacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GasEstacionPK gasEstacionPK;
    @Basic(optional = false)
    @Column(name = "NOMBRE_ESTACION")
    private String nombreEstacion;
    @Column(name = "TELEFONO_FIJO")
    private String telefonoFijo;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "RESPONSABLE")
    private String responsable;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "NOMBRE_PROPIETARIO_ESTACION")
    private String nombrePropietarioEstacion;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "IVA_DL")
    private String ivaDl;
    @Column(name = "NOMBRE_TIENDA")
    private String nombreTienda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gasEstacion")
    private List<GascatUsuario> gascatUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gasEstacion")
    private List<GasPrepago> gasPrepagoList;
    @JoinColumn(name = "CODIGO_EMPRESA", referencedColumnName = "CODIGO_EMPRESA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GasEmpresa gasEmpresa;

    public GasEstacion() {
    }

    public GasEstacion(GasEstacionPK gasEstacionPK) {
        this.gasEstacionPK = gasEstacionPK;
    }

    public GasEstacion(GasEstacionPK gasEstacionPK, String nombreEstacion) {
        this.gasEstacionPK = gasEstacionPK;
        this.nombreEstacion = nombreEstacion;
    }

    public GasEstacion(String codigoEmpresa, String codigoEstacion) {
        this.gasEstacionPK = new GasEstacionPK(codigoEmpresa, codigoEstacion);
    }

    public GasEstacionPK getGasEstacionPK() {
        return gasEstacionPK;
    }

    public void setGasEstacionPK(GasEstacionPK gasEstacionPK) {
        this.gasEstacionPK = gasEstacionPK;
    }

    public String getNombreEstacion() {
        return nombreEstacion;
    }

    public void setNombreEstacion(String nombreEstacion) {
        this.nombreEstacion = nombreEstacion;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombrePropietarioEstacion() {
        return nombrePropietarioEstacion;
    }

    public void setNombrePropietarioEstacion(String nombrePropietarioEstacion) {
        this.nombrePropietarioEstacion = nombrePropietarioEstacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIvaDl() {
        return ivaDl;
    }

    public void setIvaDl(String ivaDl) {
        this.ivaDl = ivaDl;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    @XmlTransient
    public List<GascatUsuario> getGascatUsuarioList() {
        return gascatUsuarioList;
    }

    public void setGascatUsuarioList(List<GascatUsuario> gascatUsuarioList) {
        this.gascatUsuarioList = gascatUsuarioList;
    }

    @XmlTransient
    public List<GasPrepago> getGasPrepagoList() {
        return gasPrepagoList;
    }

    public void setGasPrepagoList(List<GasPrepago> gasPrepagoList) {
        this.gasPrepagoList = gasPrepagoList;
    }

    public GasEmpresa getGasEmpresa() {
        return gasEmpresa;
    }

    public void setGasEmpresa(GasEmpresa gasEmpresa) {
        this.gasEmpresa = gasEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gasEstacionPK != null ? gasEstacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GasEstacion)) {
            return false;
        }
        GasEstacion other = (GasEstacion) object;
        if ((this.gasEstacionPK == null && other.gasEstacionPK != null) || (this.gasEstacionPK != null && !this.gasEstacionPK.equals(other.gasEstacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.GasEstacion[ gasEstacionPK=" + gasEstacionPK + " ]";
    }
    
}
