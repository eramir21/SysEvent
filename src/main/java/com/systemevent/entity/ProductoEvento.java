/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systemevent.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jose_Gascon
 */
@Entity
@Table(name = "producto_evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoEvento.findAll", query = "SELECT p FROM ProductoEvento p"),
    @NamedQuery(name = "ProductoEvento.findByCodigoProducto", query = "SELECT p FROM ProductoEvento p WHERE p.productoEventoPK.codigoProducto = :codigoProducto"),
    @NamedQuery(name = "ProductoEvento.findByCodigoEvento", query = "SELECT p FROM ProductoEvento p WHERE p.productoEventoPK.codigoEvento = :codigoEvento"),
    @NamedQuery(name = "ProductoEvento.findByCantidad", query = "SELECT p FROM ProductoEvento p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "ProductoEvento.findByMonto", query = "SELECT p FROM ProductoEvento p WHERE p.monto = :monto")})
public class ProductoEvento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductoEventoPK productoEventoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private BigDecimal monto;
    @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "codigo_evento", referencedColumnName = "codigo_evento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Evento evento;

    public ProductoEvento() {
    }

    public ProductoEvento(ProductoEventoPK productoEventoPK) {
        this.productoEventoPK = productoEventoPK;
    }

    public ProductoEvento(ProductoEventoPK productoEventoPK, int cantidad, BigDecimal monto) {
        this.productoEventoPK = productoEventoPK;
        this.cantidad = cantidad;
        this.monto = monto;
    }

    public ProductoEvento(int codigoProducto, int codigoEvento) {
        this.productoEventoPK = new ProductoEventoPK(codigoProducto, codigoEvento);
    }

    public ProductoEventoPK getProductoEventoPK() {
        return productoEventoPK;
    }

    public void setProductoEventoPK(ProductoEventoPK productoEventoPK) {
        this.productoEventoPK = productoEventoPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoEventoPK != null ? productoEventoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoEvento)) {
            return false;
        }
        ProductoEvento other = (ProductoEvento) object;
        if ((this.productoEventoPK == null && other.productoEventoPK != null) || (this.productoEventoPK != null && !this.productoEventoPK.equals(other.productoEventoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.systemevent.entity.ProductoEvento[ productoEventoPK=" + productoEventoPK + " ]";
    }
    
}
