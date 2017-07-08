/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "XLS_TEMPORAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XlsTemporal.findAll", query = "SELECT x FROM XlsTemporal x"),
    @NamedQuery(name = "XlsTemporal.findById", query = "SELECT x FROM XlsTemporal x WHERE x.id = :id"),
    @NamedQuery(name = "XlsTemporal.findByCarga", query = "SELECT x FROM XlsTemporal x WHERE x.carga = :carga"),    
    @NamedQuery(name = "XlsTemporal.findByCampo1", query = "SELECT x FROM XlsTemporal x WHERE x.campo1 = :campo1"),
    @NamedQuery(name = "XlsTemporal.findByCampo2", query = "SELECT x FROM XlsTemporal x WHERE x.campo2 = :campo2"),
    @NamedQuery(name = "XlsTemporal.findByCampo3", query = "SELECT x FROM XlsTemporal x WHERE x.campo3 = :campo3"),
    @NamedQuery(name = "XlsTemporal.findByCampo4", query = "SELECT x FROM XlsTemporal x WHERE x.campo4 = :campo4"),
    @NamedQuery(name = "XlsTemporal.findByCampo5", query = "SELECT x FROM XlsTemporal x WHERE x.campo5 = :campo5"),
    @NamedQuery(name = "XlsTemporal.findByCampo6", query = "SELECT x FROM XlsTemporal x WHERE x.campo6 = :campo6"),
    @NamedQuery(name = "XlsTemporal.findByCampo7", query = "SELECT x FROM XlsTemporal x WHERE x.campo7 = :campo7"),
    @NamedQuery(name = "XlsTemporal.findByCampo8", query = "SELECT x FROM XlsTemporal x WHERE x.campo8 = :campo8"),
    @NamedQuery(name = "XlsTemporal.findByCampo9", query = "SELECT x FROM XlsTemporal x WHERE x.campo9 = :campo9"),
    @NamedQuery(name = "XlsTemporal.findByCampo10", query = "SELECT x FROM XlsTemporal x WHERE x.campo10 = :campo10"),
    @NamedQuery(name = "XlsTemporal.findByFechaReg", query = "SELECT x FROM XlsTemporal x WHERE x.fechaReg = :fechaReg"),
    @NamedQuery(name = "XlsTemporal.findByUsuario", query = "SELECT x FROM XlsTemporal x WHERE x.usuario = :usuario")})
public class XlsTemporal implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;    
    @Column(name = "CARGA")
    private BigDecimal carga;    
    @Size(max = 100)
    @Column(name = "CAMPO1")
    private String campo1;
    @Size(max = 100)
    @Column(name = "CAMPO2")
    private String campo2;
    @Size(max = 100)
    @Column(name = "CAMPO3")
    private String campo3;
    @Size(max = 100)
    @Column(name = "CAMPO4")
    private String campo4;
    @Size(max = 100)
    @Column(name = "CAMPO5")
    private String campo5;
    @Size(max = 100)
    @Column(name = "CAMPO6")
    private String campo6;
    @Size(max = 100)
    @Column(name = "CAMPO7")
    private String campo7;
    @Size(max = 100)
    @Column(name = "CAMPO8")
    private String campo8;
    @Size(max = 100)
    @Column(name = "CAMPO9")
    private String campo9;
    @Size(max = 100)
    @Column(name = "CAMPO10")
    private String campo10;
    @Column(name = "FECHA_REG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;
    @Size(max = 100)
    @Column(name = "USUARIO")
    private String usuario;
    
           

    public XlsTemporal() {
    }

    public XlsTemporal(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getCarga() {
        return carga;
    }

    public void setCarga(BigDecimal carga) {
        this.carga = carga;
    }
 
    public String getCampo1() {
        return campo1;
    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }

    public String getCampo3() {
        return campo3;
    }

    public void setCampo3(String campo3) {
        this.campo3 = campo3;
    }

    public String getCampo4() {
        return campo4;
    }

    public void setCampo4(String campo4) {
        this.campo4 = campo4;
    }

    public String getCampo5() {
        return campo5;
    }

    public void setCampo5(String campo5) {
        this.campo5 = campo5;
    }

    public String getCampo6() {
        return campo6;
    }

    public void setCampo6(String campo6) {
        this.campo6 = campo6;
    }

    public String getCampo7() {
        return campo7;
    }

    public void setCampo7(String campo7) {
        this.campo7 = campo7;
    }

    public String getCampo8() {
        return campo8;
    }

    public void setCampo8(String campo8) {
        this.campo8 = campo8;
    }

    public String getCampo9() {
        return campo9;
    }

    public void setCampo9(String campo9) {
        this.campo9 = campo9;
    }

    public String getCampo10() {
        return campo10;
    }

    public void setCampo10(String campo10) {
        this.campo10 = campo10;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XlsTemporal)) {
            return false;
        }
        XlsTemporal other = (XlsTemporal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.XlsTemporal[ id=" + id + " ]";
    }
    
}
