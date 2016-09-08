package com.systemevent.controller;

import com.systemevent.entity.ProductoEvento;
import com.systemevent.jsfclass.util.JsfUtil;
import com.systemevent.jsfclass.util.JsfUtil.PersistAction;
import com.systemevent.dao.ProductoEventoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;

@Named("productoEventoController")
@ViewScoped
public class ProductoEventoController implements Serializable {

    @EJB
    private com.systemevent.dao.ProductoEventoFacade ejbFacade;
    private List<ProductoEvento> items = null;
    private ProductoEvento selected;

    public ProductoEventoController() {
    }

    public ProductoEvento getSelected() {
        return selected;
    }

    public void setSelected(ProductoEvento selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getProductoEventoPK().setCodigoProducto(selected.getProducto().getCodigoProducto());
        selected.getProductoEventoPK().setCodigoEvento(selected.getEvento().getCodigoEvento());
    }

    protected void initializeEmbeddableKey() {
        selected.setProductoEventoPK(new com.systemevent.entity.ProductoEventoPK());
    }

    private ProductoEventoFacade getFacade() {
        return ejbFacade;
    }

    public ProductoEvento prepareCreate() {
        selected = new ProductoEvento();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProductoEventoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProductoEventoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProductoEventoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ProductoEvento> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public ProductoEvento getProductoEvento(com.systemevent.entity.ProductoEventoPK id) {
        return getFacade().find(id);
    }

    public List<ProductoEvento> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ProductoEvento> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ProductoEvento.class)
    public static class ProductoEventoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProductoEventoController controller = (ProductoEventoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "productoEventoController");
            return controller.getProductoEvento(getKey(value));
        }

        com.systemevent.entity.ProductoEventoPK getKey(String value) {
            com.systemevent.entity.ProductoEventoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.systemevent.entity.ProductoEventoPK();
            key.setCodigoProducto(Integer.parseInt(values[0]));
            key.setCodigoEvento(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.systemevent.entity.ProductoEventoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCodigoProducto());
            sb.append(SEPARATOR);
            sb.append(value.getCodigoEvento());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ProductoEvento) {
                ProductoEvento o = (ProductoEvento) object;
                return getStringKey(o.getProductoEventoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProductoEvento.class.getName()});
                return null;
            }
        }

    }

}
