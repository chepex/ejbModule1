/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "GASCAT_TIPO_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GascatTipoRol.findAll", query = "SELECT g FROM GascatTipoRol g"),
    @NamedQuery(name = "GascatTipoRol.findByCodigoTiporol", query = "SELECT g FROM GascatTipoRol g WHERE g.codigoTiporol = :codigoTiporol"),
    @NamedQuery(name = "GascatTipoRol.findByDescripcion", query = "SELECT g FROM GascatTipoRol g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "GascatTipoRol.findByValidoPista", query = "SELECT g FROM GascatTipoRol g WHERE g.validoPista = :validoPista"),
    @NamedQuery(name = "GascatTipoRol.findByValidoTienda", query = "SELECT g FROM GascatTipoRol g WHERE g.validoTienda = :validoTienda"),
    @NamedQuery(name = "GascatTipoRol.findByEstado", query = "SELECT g FROM GascatTipoRol g WHERE g.estado = :estado")})
public class GascatTipoRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_TIPOROL")
    private String codigoTiporol;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "VALIDO_PISTA")
    private String validoPista;
    @Basic(optional = false)
    @Column(name = "VALIDO_TIENDA")
    private String validoTienda;
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "codigoTiporol")
    private List<GascatUsuario> gascatUsuarioList;

    public GascatTipoRol() {
    }

    public GascatTipoRol(String codigoTiporol) {
        this.codigoTiporol = codigoTiporol;
    }

    public GascatTipoRol(String codigoTiporol, String descripcion, String validoPista, String validoTienda) {
        this.codigoTiporol = codigoTiporol;
        this.descripcion = descripcion;
        this.validoPista = validoPista;
        this.validoTienda = validoTienda;
    }

    public String getCodigoTiporol() {
        return codigoTiporol;
    }

    public void setCodigoTiporol(String codigoTiporol) {
        this.codigoTiporol = codigoTiporol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValidoPista() {
        return validoPista;
    }

    public void setValidoPista(String validoPista) {
        this.validoPista = validoPista;
    }

    public String getValidoTienda() {
        return validoTienda;
    }

    public void setValidoTienda(String validoTienda) {
        this.validoTienda = validoTienda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<GascatUsuario> getGascatUsuarioList() {
        return gascatUsuarioList;
    }

    public void setGascatUsuarioList(List<GascatUsuario> gascatUsuarioList) {
        this.gascatUsuarioList = gascatUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTiporol != null ? codigoTiporol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GascatTipoRol)) {
            return false;
        }
        GascatTipoRol other = (GascatTipoRol) object;
        if ((this.codigoTiporol == null && other.codigoTiporol != null) || (this.codigoTiporol != null && !this.codigoTiporol.equals(other.codigoTiporol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.GascatTipoRol[ codigoTiporol=" + codigoTiporol + " ]";
    }
    
}
