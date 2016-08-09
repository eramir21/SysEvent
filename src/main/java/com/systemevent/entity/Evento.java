/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systemevent.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jose_Gascon
 */
@Entity
@Table(name = "evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findByCodigoEvento", query = "SELECT e FROM Evento e WHERE e.codigoEvento = :codigoEvento"),
    @NamedQuery(name = "Evento.findByDescripcion", query = "SELECT e FROM Evento e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Evento.findByCantidadPersonas", query = "SELECT e FROM Evento e WHERE e.cantidadPersonas = :cantidadPersonas"),
    @NamedQuery(name = "Evento.findByUbicacion", query = "SELECT e FROM Evento e WHERE e.ubicacion = :ubicacion"),
    @NamedQuery(name = "Evento.findByFecha", query = "SELECT e FROM Evento e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Evento.findByEstado", query = "SELECT e FROM Evento e WHERE e.estado = :estado")})
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_evento")
    private Integer codigoEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_personas")
    private int cantidadPersonas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Character estado;
    @JoinColumn(name = "codigo_tipo_evento", referencedColumnName = "codigo_tipo_evento")
    @ManyToOne(optional = false)
    private TipoEvento codigoTipoEvento;
    @JoinColumn(name = "codigo_municipio", referencedColumnName = "codigo_municipio")
    @ManyToOne(optional = false)
    private Municipio codigoMunicipio;
    @JoinColumn(name = "codigo_estado", referencedColumnName = "codigo_estado")
    @ManyToOne(optional = false)
    private Estado codigoEstado;
    @JoinColumn(name = "codigo_pais", referencedColumnName = "codigo_pais")
    @ManyToOne(optional = false)
    private Pais codigoPais;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
    private Collection<ProductoEvento> productoEventoCollection;

    public Evento() {
    }

    public Evento(Integer codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public Evento(Integer codigoEvento, String descripcion, int cantidadPersonas, String ubicacion, Date fecha, Character estado) {
        this.codigoEvento = codigoEvento;
        this.descripcion = descripcion;
        this.cantidadPersonas = cantidadPersonas;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(Integer codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public TipoEvento getCodigoTipoEvento() {
        return codigoTipoEvento;
    }

    public void setCodigoTipoEvento(TipoEvento codigoTipoEvento) {
        this.codigoTipoEvento = codigoTipoEvento;
    }

    public Municipio getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(Municipio codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public Pais getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(Pais codigoPais) {
        this.codigoPais = codigoPais;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @XmlTransient
    public Collection<ProductoEvento> getProductoEventoCollection() {
        return productoEventoCollection;
    }

    public void setProductoEventoCollection(Collection<ProductoEvento> productoEventoCollection) {
        this.productoEventoCollection = productoEventoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEvento != null ? codigoEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.codigoEvento == null && other.codigoEvento != null) || (this.codigoEvento != null && !this.codigoEvento.equals(other.codigoEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.systemevent.entity.Evento[ codigoEvento=" + codigoEvento + " ]";
    }
    
}
