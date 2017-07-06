 
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmixco
 */
@Entity
@Table(name = "GAS_PREPAGO_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GasPrepagoDetalle.findAll", query = "SELECT g FROM GasPrepagoDetalle g"),
    @NamedQuery(name = "GasPrepagoDetalle.findByCodigoEmpresa", query = "SELECT g FROM GasPrepagoDetalle g WHERE g.gasPrepagoDetallePK.codigoEmpresa = :codigoEmpresa"),
    @NamedQuery(name = "GasPrepagoDetalle.findByCodigoEstacion", query = "SELECT g FROM GasPrepagoDetalle g WHERE g.gasPrepagoDetallePK.codigoEstacion = :codigoEstacion"),
    @NamedQuery(name = "GasPrepagoDetalle.findByCodigoPrepago", query = "SELECT g FROM GasPrepagoDetalle g WHERE g.gasPrepagoDetallePK.codigoPrepago = :codigoPrepago"),
    @NamedQuery(name = "GasPrepagoDetalle.findByCodigoPrepagoUtilizado", query = "SELECT g FROM GasPrepagoDetalle g WHERE g.gasPrepagoDetallePK.codigoPrepago = :codigoPrepago and g.estado= 'C'"),    
    @NamedQuery(name = "GasPrepagoDetalle.findByNoPrepago", query = "SELECT g FROM GasPrepagoDetalle g WHERE g.gasPrepagoDetallePK.noPrepago = :noPrepago   "),
    @NamedQuery(name = "GasPrepagoDetalle.findByNoPrepagoEstado", query = "SELECT g FROM GasPrepagoDetalle g WHERE g.gasPrepagoDetallePK.noPrepago = :noPrepago and g.estado = :estado "),
    @NamedQuery(name = "GasPrepagoDetalle.findByValorPrepago", query = "SELECT g FROM GasPrepagoDetalle g WHERE g.valorPrepago = :valorPrepago"),
    @NamedQuery(name = "GasPrepagoDetalle.findByFecha", query = "SELECT g FROM GasPrepagoDetalle g WHERE g.fechaUso between :finicio and :ffin"),    
    @NamedQuery(name = "GasPrepagoDetalle.findByFechaEstacion", query = "SELECT g FROM GasPrepagoDetalle g WHERE g.fechaUso between :finicio and :ffin and g.gasPrepago.gasEstacion = :ge  "),        
    @NamedQuery(name = "GasPrepagoDetalle.findByEstado", query = "SELECT g FROM GasPrepagoDetalle g WHERE g.estado = :estado")})
public class GasPrepagoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GasPrepagoDetallePK gasPrepagoDetallePK;
    @Basic(optional = false)
    @Column(name = "VALOR_PREPAGO")
    private BigInteger valorPrepago;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "IMPRESO")
    private String impreso;    
    @Basic(optional = false)
    @Column(name = "NO_UNICO")
    private BigInteger noUnico;    
    @Column(name = "AUTORIZACION")
    private String autorizacion; 
    @Column(name = "FECHA_USO")
    private Date fechaUso; 
    @JoinColumns({
        @JoinColumn(name = "CODIGO_EMPRESA", referencedColumnName = "CODIGO_EMPRESA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGO_ESTACION", referencedColumnName = "CODIGO_ESTACION", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGO_PREPAGO", referencedColumnName = "CODIGO_PREPAGO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private GasPrepago gasPrepago;
    @JoinColumn(name = "ID_SABOR", referencedColumnName = "ID_SABOR")
    @ManyToOne
    private GasSaborCombustible idSabor;    

    public GasPrepagoDetalle() {
    }

    public String getImpreso() {
        return impreso;
    }

    public void setImpreso(String impreso) {
        this.impreso = impreso;
    }

    public GasSaborCombustible getIdSabor() {
        return idSabor;
    }

    public void setIdSabor(GasSaborCombustible idSabor) {
        this.idSabor = idSabor;
    }

    
    
    public Date getFechaUso() {
        return fechaUso;
    }

    public void setFechaUso(Date fechaUso) {
        this.fechaUso = fechaUso;
    }
    
    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    
    
    public BigInteger getNoUnico() {
        return noUnico;
    }

    public void setNoUnico(BigInteger noUnico) {
        this.noUnico = noUnico;
    }
    
    

    public GasPrepagoDetalle(GasPrepagoDetallePK gasPrepagoDetallePK) {
        this.gasPrepagoDetallePK = gasPrepagoDetallePK;
    }

    public GasPrepagoDetalle(GasPrepagoDetallePK gasPrepagoDetallePK, BigInteger valorPrepago) {
        this.gasPrepagoDetallePK = gasPrepagoDetallePK;
        this.valorPrepago = valorPrepago;
    }

    public GasPrepagoDetalle(String codigoEmpresa, String codigoEstacion, BigInteger codigoPrepago, BigInteger noPrepago) {
        this.gasPrepagoDetallePK = new GasPrepagoDetallePK(codigoEmpresa, codigoEstacion, codigoPrepago, noPrepago);
    }

    public GasPrepagoDetallePK getGasPrepagoDetallePK() {
        return gasPrepagoDetallePK;
    }

    public void setGasPrepagoDetallePK(GasPrepagoDetallePK gasPrepagoDetallePK) {
        this.gasPrepagoDetallePK = gasPrepagoDetallePK;
    }

    public BigInteger getValorPrepago() {
        return valorPrepago;
    }

    public void setValorPrepago(BigInteger valorPrepago) {
        this.valorPrepago = valorPrepago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public GasPrepago getGasPrepago() {
        return gasPrepago;
    }

    public void setGasPrepago(GasPrepago gasPrepago) {
        this.gasPrepago = gasPrepago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gasPrepagoDetallePK != null ? gasPrepagoDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GasPrepagoDetalle)) {
            return false;
        }
        GasPrepagoDetalle other = (GasPrepagoDetalle) object;
        if ((this.gasPrepagoDetallePK == null && other.gasPrepagoDetallePK != null) || (this.gasPrepagoDetallePK != null && !this.gasPrepagoDetallePK.equals(other.gasPrepagoDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gas.GasPrepagoDetalle[ gasPrepagoDetallePK=" + gasPrepagoDetallePK + " ]";
    }
    
}
