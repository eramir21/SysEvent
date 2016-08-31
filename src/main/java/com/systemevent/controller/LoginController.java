
package com.systemevent.controller;


import com.systemevent.dao.PersonaFacade;
import com.systemevent.entity.Persona;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class LoginController implements Serializable{
    
    @EJB
    private PersonaFacade EJBpersona;
    private Persona persona;
    
    @PostConstruct
    public void init(){
        persona = new Persona();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

 
    
    public String iniciarSesion(){
        Persona per;
        String redireccion = null;
        try {
            per = EJBpersona.iniciarSesion(persona);
            if (per != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("persona",per);
                //redireccion = "CrearProducto?faces-redirect=true";
                
               Persona pera = (Persona) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("persona");
                switch (per.getTipoUsuario()) {
                    case "C":
                        redireccion = "PrincipalCliente?faces-redirect=true";
                        break;                
                    case "P":
                        redireccion = "PrincipalProveedor?faces-redirect=true";
                        break;
                }
                
                
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Credenciales Incorrectas","Credenciales Incorrectas"));
            }
            
            
        } catch (Exception e) {
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error","Error"));
        }
        
        return redireccion;
    }
    
    
}
