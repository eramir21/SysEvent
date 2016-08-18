
package com.systemevent.controller;

import com.systemevent.dao.UsuarioFacade;
import com.systemevent.entity.Persona;
import com.systemevent.entity.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import javax.inject.Named;

@Named
@ViewScoped
public class UsuarioController implements Serializable{
    
    
    @EJB
    private UsuarioFacade usuarioEjb;
    
    private Usuario usuario;
    private Persona persona;
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        persona = new Persona();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void registrar(){
        try {
            this.usuario.setPersona(persona);
            usuarioEjb.create(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se Registro Corretamente"));
        } catch (Exception e) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }
    
    
    }
    
    
    
}
