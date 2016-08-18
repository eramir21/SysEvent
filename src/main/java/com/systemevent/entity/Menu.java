/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systemevent.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jose_Gascon
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")})
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_menu")
    private int codigoMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
   
    @Column(name = "url")
    private String url;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipoUsuario")
    private String tipoUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado = true;
    @OneToMany(mappedBy = "codigoSubmenu")
    private Collection<Menu> menuCollection;
    @JoinColumn(name = "codigo_submenu", referencedColumnName = "codigo_menu")
    @ManyToOne
    private Menu codigoSubmenu;

    public Menu() {
    }

    public Menu(int codigoMenu) {
        this.codigoMenu = codigoMenu;
    }

    public Menu(int codigoMenu, String nombre, String tipo, String tipoUsuario, boolean estado) {
        this.codigoMenu = codigoMenu;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tipoUsuario = tipoUsuario;
        this.estado = estado;
    }

    public int getCodigoMenu() {
        return codigoMenu;
    }

    public void setCodigoMenu(int codigoMenu) {
        this.codigoMenu = codigoMenu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    public Menu getCodigoSubmenu() {
        return codigoSubmenu;
    }

    public void setCodigoSubmenu(Menu codigoSubmenu) {
        this.codigoSubmenu = codigoSubmenu;
    }

  

    @Override
    public String toString() {
        return "com.systemevent.entity.Menu[ codigoMenu=" + codigoMenu + " ]";
    }
    
}
