/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systemevent.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lobru1104
 */
@Entity
@Table(name = "tipo_evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEvento.findAll", query = "SELECT t FROM TipoEvento t"),
    @NamedQuery(name = "TipoEvento.findByCodigoTipoEvento", query = "SELECT t FROM TipoEvento t WHERE t.codigoTipoEvento = :codigoTipoEvento"),
    @NamedQuery(name = "TipoEvento.findByDescripcion", query = "SELECT t FROM TipoEvento t WHERE t.descripcion = :descripcion")})
public class TipoEvento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_tipo_evento")
    private Integer codigoTipoEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "producto_tipo_evento", joinColumns = {
        @JoinColumn(name = "codigo_tipo_evento", referencedColumnName = "codigo_tipo_evento")}, inverseJoinColumns = {
        @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo_producto")})
    @ManyToMany
    private Collection<Producto> productoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTipoEvento")
    private Collection<Evento> eventoCollection;

    public TipoEvento() {
    }

    public TipoEvento(Integer codigoTipoEvento) {
        this.codigoTipoEvento = codigoTipoEvento;
    }

    public TipoEvento(Integer codigoTipoEvento, String descripcion) {
        this.codigoTipoEvento = codigoTipoEvento;
        this.descripcion = descripcion;
    }

    public Integer getCodigoTipoEvento() {
        return codigoTipoEvento;
    }

    public void setCodigoTipoEvento(Integer codigoTipoEvento) {
        this.codigoTipoEvento = codigoTipoEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTipoEvento != null ? codigoTipoEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEvento)) {
            return false;
        }
        TipoEvento other = (TipoEvento) object;
        if ((this.codigoTipoEvento == null && other.codigoTipoEvento != null) || (this.codigoTipoEvento != null && !this.codigoTipoEvento.equals(other.codigoTipoEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
}
