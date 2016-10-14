package com.systemevent.controller;

import com.systemevent.dao.MenuFacade;
import com.systemevent.entity.Menu;
import com.systemevent.entity.Persona;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuModel;
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
       // this.establecerPermisos();
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

//    public void establecerPermisos() {
//      Persona us = (Persona) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("persona");
//
//        for (Menu m : lista) {
//            if (m.getTipo().equals("S") && m.getTipoUsuario().equals(us.getTipoUsuario())) {
//                DefaultSubMenu firstSubMenu = new DefaultSubMenu(m.getNombre());
//                for (Menu i : lista) {
//                    Menu submenu = i.getCodigoSubmenu();
//                    if (submenu != null) {
//                        if (submenu.getCodigoMenu() == m.getCodigoMenu()) {
//                            DefaultMenuItem item = new DefaultMenuItem(i.getNombre());
//                            item.setUrl(i.getUrl());
//                            firstSubMenu.addElement(item);
//                        }
//                    }
//                }
//
//                model.addElement(firstSubMenu);
//            } else {
//                if (m.getCodigoSubmenu() == null && m.getTipoUsuario().equals(us.getTipoUsuario())) {
//                    DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
//                    item.setUrl(m.getUrl());
//                    model.addElement(item);
//                }
//                
//            }
//
//        }
//
//    }
    
    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//        String retorno = "index?faces-redirect=true";
//        return retorno;
    }
    
    public String mostrarUsuarioLogeado(){
        Persona us = (Persona) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return us.getNombre();
    }
    //cambios..
    public String obtenerIdPersona(){
        Persona us = (Persona) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        String rsp = Integer.toString(us.getIdPersona());
        return rsp;

    }

}
