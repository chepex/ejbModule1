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
@Table(name = "GAS_MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GasMenu.findAll", query = "SELECT g FROM GasMenu g"),
    @NamedQuery(name = "GasMenu.findByCodMenu", query = "SELECT g FROM GasMenu g WHERE g.codMenu = :codMenu"),
    @NamedQuery(name = "GasMenu.findByCodModulo", query = "SELECT g FROM GasMenu g WHERE g.codModulo = :codModulo"),
    @NamedQuery(name = "GasMenu.findByNobre", query = "SELECT g FROM GasMenu g WHERE g.nobre = :nobre"),
    @NamedQuery(name = "GasMenu.findByUrl", query = "SELECT g FROM GasMenu g WHERE g.url = :url"),
    @NamedQuery(name = "GasMenu.findByPrincipal", query = "SELECT g FROM GasMenu g WHERE g.principal = :principal"),
    @NamedQuery(name = "GasMenu.findByEstado", query = "SELECT g FROM GasMenu g WHERE g.estado = :estado")})
public class GasMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_MENU")
    private BigDecimal codMenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_MODULO")
    private BigInteger codModulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "NOBRE")
    private String nobre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "URL")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRINCIPAL")
    private BigInteger principal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "ICON")
    private String icon; 
    @Column(name = "INDICE")
    private BigInteger indice;     

    public GasMenu() {
    }

    public GasMenu(BigDecimal codMenu) {
        this.codMenu = codMenu;
    }

    public GasMenu(BigDecimal codMenu, BigInteger codModulo, String nobre, String url, BigInteger principal, String estado) {
        this.codMenu = codMenu;
        this.codModulo = codModulo;
        this.nobre = nobre;
        this.url = url;
        this.principal = principal;
        this.estado = estado;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public BigInteger getIndice() {
        return indice;
    }

    public void setIndice(BigInteger indice) {
        this.indice = indice;
    }

    
    public BigDecimal getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(BigDecimal codMenu) {
        this.codMenu = codMenu;
    }

    public BigInteger getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(BigInteger codModulo) {
        this.codModulo = codModulo;
    }

    public String getNobre() {
        return nobre;
    }

    public void setNobre(String nobre) {
        this.nobre = nobre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigInteger getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigInteger principal) {
        this.principal = principal;
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
        hash += (codMenu != null ? codMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GasMenu)) {
            return false;
        }
        GasMenu other = (GasMenu) object;
        if ((this.codMenu == null && other.codMenu != null) || (this.codMenu != null && !this.codMenu.equals(other.codMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.GasMenu[ codMenu=" + codMenu + " ]";
    }
    
}
