/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systemevent.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lobru1104
 */
@Embeddable
public class ProductoEventoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_producto")
    private int codigoProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_evento")
    private int codigoEvento;

    public ProductoEventoPK() {
    }

    public ProductoEventoPK(int codigoProducto, int codigoEvento) {
        this.codigoProducto = codigoProducto;
        this.codigoEvento = codigoEvento;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(int codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoProducto;
        hash += (int) codigoEvento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoEventoPK)) {
            return false;
        }
        ProductoEventoPK other = (ProductoEventoPK) object;
        if (this.codigoProducto != other.codigoProducto) {
            return false;
        }
        if (this.codigoEvento != other.codigoEvento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.systemevent.entity.ProductoEventoPK[ codigoProducto=" + codigoProducto + ", codigoEvento=" + codigoEvento + " ]";
    }
    
}
