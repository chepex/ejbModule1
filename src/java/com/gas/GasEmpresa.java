package com.gas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "GAS_EMPRESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GasEmpresa.findAll", query = "SELECT g FROM GasEmpresa g"),
    @NamedQuery(name = "GasEmpresa.findByCodigoEmpresa", query = "SELECT g FROM GasEmpresa g WHERE g.codigoEmpresa = :codigoEmpresa"),
    @NamedQuery(name = "GasEmpresa.findByNombreSociedad", query = "SELECT g FROM GasEmpresa g WHERE g.nombreSociedad = :nombreSociedad"),
    @NamedQuery(name = "GasEmpresa.findByEstado", query = "SELECT g FROM GasEmpresa g WHERE g.estado = :estado"),
    @NamedQuery(name = "GasEmpresa.findByNoRegistro", query = "SELECT g FROM GasEmpresa g WHERE g.noRegistro = :noRegistro"),
    @NamedQuery(name = "GasEmpresa.findByNit", query = "SELECT g FROM GasEmpresa g WHERE g.nit = :nit")})
public class GasEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_EMPRESA")
    private String codigoEmpresa;
    @Basic(optional = false)
    @Column(name = "NOMBRE_SOCIEDAD")
    private String nombreSociedad;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "NO_REGISTRO")
    private String noRegistro;
    @Column(name = "NIT")
    private String nit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gasEmpresa")
    private List<GasEstacion> gasEstacionList;

    public GasEmpresa() {
    }

    public GasEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public GasEmpresa(String codigoEmpresa, String nombreSociedad) {
        this.codigoEmpresa = codigoEmpresa;
        this.nombreSociedad = nombreSociedad;
    }

    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getNombreSociedad() {
        return nombreSociedad;
    }

    public void setNombreSociedad(String nombreSociedad) {
        this.nombreSociedad = nombreSociedad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNoRegistro() {
        return noRegistro;
    }

    public void setNoRegistro(String noRegistro) {
        this.noRegistro = noRegistro;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @XmlTransient
    public List<GasEstacion> getGasEstacionList() {
        return gasEstacionList;
    }

    public void setGasEstacionList(List<GasEstacion> gasEstacionList) {
        this.gasEstacionList = gasEstacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEmpresa != null ? codigoEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GasEmpresa)) {
            return false;
        }
        GasEmpresa other = (GasEmpresa) object;
        if ((this.codigoEmpresa == null && other.codigoEmpresa != null) || (this.codigoEmpresa != null && !this.codigoEmpresa.equals(other.codigoEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.GasEmpresa[ codigoEmpresa=" + codigoEmpresa + " ]";
    }
    
}
