/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videojuegos.jbn;

import com.videojuegos.model.Usuario1;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Arturo
 */
@Stateless
public class Usuario1Facade extends AbstractFacade<Usuario1> implements Usuario1FacadeLocal {

    @PersistenceContext(unitName = "com.videojuegos_videojuegos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Usuario1Facade() {
        super(Usuario1.class);
    }
    
}
