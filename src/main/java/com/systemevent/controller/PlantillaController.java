
package com.systemevent.controller;


import com.systemevent.entity.Persona;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PlantillaController implements Serializable {
    
    public void verificarSesion(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Persona us = (Persona) context.getExternalContext().getSessionMap().get("persona");
            
            if (us == null) {
                
                context.getExternalContext().redirect("permisos.xhtml");
                
            }
            
        } catch (Exception e) {
        }
    }
    
}
