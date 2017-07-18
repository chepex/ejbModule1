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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author informatica
 */
@Entity
@Table(name = "GAS_MENU_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GasMenuRol.findAll", query = "SELECT g FROM GasMenuRol g"),
    @NamedQuery(name = "GasMenuRol.findByIdGasMenuRol", query = "SELECT g FROM GasMenuRol g WHERE g.idGasMenuRol = :idGasMenuRol"),
    @NamedQuery(name = "GasMenuRol.findByCodMenu", query = "SELECT g FROM GasMenuRol g WHERE g.codMenu = :codMenu"),
    @NamedQuery(name = "GasMenuRol.findByCodRol", query = "SELECT g FROM GasMenuRol g WHERE g.codTipoRol = :rol  order by g.gasMenu.indice  "),
 
    @NamedQuery(name = "GasMenuRol.findByEstado", query = "SELECT g FROM GasMenuRol g WHERE g.estado = :estado")})
public class GasMenuRol implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_GAS_MENU_ROL")
    private BigDecimal idGasMenuRol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_MENU")
    private BigInteger codMenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIPO_ROL")
    private String codTipoRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "COD_TIPO_ROL ", referencedColumnName = "CODIGO_TIPOROL",insertable = false, updatable = false)
    @ManyToOne
    private GascatTipoRol codigoTiporol;
    @JoinColumn(name = "COD_MENU", referencedColumnName = "COD_MENU", insertable = false, updatable = false)
    @ManyToOne
    private GasMenu gasMenu;    
    
    public GasMenuRol() {
    }

    public GasMenuRol(BigDecimal idGasMenuRol) {
        this.idGasMenuRol = idGasMenuRol;
    }

    public GasMenuRol(BigDecimal idGasMenuRol, BigInteger codMenu, String codRol, String estado) {
        this.idGasMenuRol = idGasMenuRol;
        this.codMenu = codMenu;
        this.codTipoRol = codRol;
        this.estado = estado;
    }

    public BigDecimal getIdGasMenuRol() {
        return idGasMenuRol;
    }

    public void setIdGasMenuRol(BigDecimal idGasMenuRol) {
        this.idGasMenuRol = idGasMenuRol;
    }

    public BigInteger getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(BigInteger codMenu) {
        this.codMenu = codMenu;
    }

    public String getCodTipoRol() {
        return codTipoRol;
    }

    public void setCodTipoRol(String codTipoRol) {
        this.codTipoRol = codTipoRol;
    }

    public GascatTipoRol getCodigoTiporol() {
        return codigoTiporol;
    }

    public void setCodigoTiporol(GascatTipoRol codigoTiporol) {
        this.codigoTiporol = codigoTiporol;
    }

    public GasMenu getGasMenu() {
        return gasMenu;
    }

    public void setGasMenu(GasMenu gasMenu) {
        this.gasMenu = gasMenu;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGasMenuRol != null ? idGasMenuRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GasMenuRol)) {
            return false;
        }
        GasMenuRol other = (GasMenuRol) object;
        if ((this.idGasMenuRol == null && other.idGasMenuRol != null) || (this.idGasMenuRol != null && !this.idGasMenuRol.equals(other.idGasMenuRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.GasMenuRol[ idGasMenuRol=" + idGasMenuRol + " ]";
    }
    
}
