/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systemevent.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lobru1104
 */
@Entity
@Table(name = "producto_imagen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoImagen.findAll", query = "SELECT p FROM ProductoImagen p"),
    @NamedQuery(name = "ProductoImagen.findByCodigoImagen", query = "SELECT p FROM ProductoImagen p WHERE p.codigoImagen = :codigoImagen"),
    @NamedQuery(name = "ProductoImagen.findByCodigoProducto", query = "SELECT p FROM ProductoImagen p WHERE p.codigoProducto = :codigoProducto")})
public class ProductoImagen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_imagen")
    private Integer codigoImagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_producto")
    private int codigoProducto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;

    public ProductoImagen() {
    }

    public ProductoImagen(Integer codigoImagen) {
        this.codigoImagen = codigoImagen;
    }

    public ProductoImagen(Integer codigoImagen, int codigoProducto, byte[] imagen) {
        this.codigoImagen = codigoImagen;
        this.codigoProducto = codigoProducto;
        this.imagen = imagen;
    }

    public Integer getCodigoImagen() {
        return codigoImagen;
    }

    public void setCodigoImagen(Integer codigoImagen) {
        this.codigoImagen = codigoImagen;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoImagen != null ? codigoImagen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoImagen)) {
            return false;
        }
        ProductoImagen other = (ProductoImagen) object;
        if ((this.codigoImagen == null && other.codigoImagen != null) || (this.codigoImagen != null && !this.codigoImagen.equals(other.codigoImagen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.systemevent.entity.ProductoImagen[ codigoImagen=" + codigoImagen + " ]";
    }
    
}
