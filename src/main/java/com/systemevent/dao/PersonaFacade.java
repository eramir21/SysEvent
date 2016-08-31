/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systemevent.dao;

import com.systemevent.entity.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author lobru1104
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {
    @PersistenceContext(unitName = "com_SystemEvent_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
    public Persona iniciarSesion(Persona Per){
        Persona persona = null;
        String consulta;
        try {
            consulta = "FROM Persona u WHERE u.email = ?1 and u.clave=?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, Per.getEmail());
            query.setParameter(2, Per.getClave());
            
            List<Persona> lista = query.getResultList();
            if (!lista.isEmpty()) {
                persona = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
    
        return persona;
    }
    
}
