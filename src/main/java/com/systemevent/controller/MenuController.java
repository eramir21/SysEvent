package com.systemevent.controller;

import com.systemevent.dao.MenuFacade;
import com.systemevent.entity.Menu;
import com.systemevent.entity.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@Named
@SessionScoped
public class MenuController implements Serializable {

    @EJB
    private MenuFacade EJBmenu;
    private List<Menu> lista;
    private MenuModel model;

    @PostConstruct
    public void init() {
        this.listarmenu();
        model = new DefaultMenuModel();
        this.establecerPermisos();
    }

    public void listarmenu() {
        try {
            lista = EJBmenu.findAll();
        } catch (Exception e) {

        }
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public void establecerPermisos() {
      Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

        for (Menu m : lista) {
            if (m.getTipo().equals("S") && m.getTipoUsuario().equals(us.getTipo())) {
                DefaultSubMenu firstSubMenu = new DefaultSubMenu(m.getNombre());
                for (Menu i : lista) {
                    Menu submenu = i.getCodigoSubmenu();
                    if (submenu != null) {
                        if (submenu.getCodigoMenu() == m.getCodigoMenu()) {
                            DefaultMenuItem item = new DefaultMenuItem(i.getNombre());
                            item.setUrl(i.getUrl());
                            firstSubMenu.addElement(item);
                        }
                    }
                }

                model.addElement(firstSubMenu);
            } else {
                if (m.getCodigoSubmenu() == null && m.getTipoUsuario().equals(us.getTipo())) {
                    DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
                    item.setUrl(m.getUrl());
                    model.addElement(item);
                }
                
            }

        }

    }
    
    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    public String mostrarUsuarioLogeado(){
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return us.getPersona().getNombres()+" "+us.getPersona().getApellidos();
    }

}
