/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systemevent.dao;

import com.systemevent.entity.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jose_Gascon
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {
    @PersistenceContext(unitName = "com_SystemEvent_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
//    public void buscarCliente()
//
//    {
//
//       EntityManagerFactory emf = Persistence
//        .createEntityManagerFactory("Cliente");
//        EntityManager em = emf.createEntityManager();
//        Cliente yo = em.find(Cliente.class, "1");
//        System.out.println(yo.getNombre());
//        System.out.println(yo.getEmail());
//
//    }
    
}
