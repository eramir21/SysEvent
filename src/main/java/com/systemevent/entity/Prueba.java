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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jose_Gascon
 */
@Entity
@Table(name = "prueba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prueba.findAll", query = "SELECT p FROM Prueba p"),
    @NamedQuery(name = "Prueba.findByCedu", query = "SELECT p FROM Prueba p WHERE p.cedu = :cedu"),
    @NamedQuery(name = "Prueba.findByNombre", query = "SELECT p FROM Prueba p WHERE p.nombre = :nombre")})
public class Prueba implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cedu")
    private Integer cedu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;

    public Prueba() {
    }

    public Prueba(Integer cedu) {
        this.cedu = cedu;
    }

    public Prueba(Integer cedu, String nombre) {
        this.cedu = cedu;
        this.nombre = nombre;
    }

    public Integer getCedu() {
        return cedu;
    }

    public void setCedu(Integer cedu) {
        this.cedu = cedu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedu != null ? cedu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prueba)) {
            return false;
        }
        Prueba other = (Prueba) object;
        if ((this.cedu == null && other.cedu != null) || (this.cedu != null && !this.cedu.equals(other.cedu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.systemevent.entity.Prueba[ cedu=" + cedu + " ]";
    }
    
}
