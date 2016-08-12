/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systemevent.dao;

import com.systemevent.entity.Estado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jose_Gascon
 */
@Stateless
public class EstadoFacade extends AbstractFacade<Estado> {
    @PersistenceContext(unitName = "com_SystemEvent_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoFacade() {
        super(Estado.class);
    }
    
    
     public List<Estado> DamelosEstados(int idPais) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * estado WHERE codigo_pais =: codepais");
        Query query = getEntityManager().createQuery(sql.toString());
        query.setParameter("codepais", idPais);
        List<Estado> estadoList = query.getResultList();
        
       return estadoList;
    }
    
}
