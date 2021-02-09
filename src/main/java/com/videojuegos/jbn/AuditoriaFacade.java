/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videojuegos.jbn;

import com.videojuegos.model.Auditoria;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Arturo
 */
@Stateless
public class AuditoriaFacade extends AbstractFacade<Auditoria> implements AuditoriaFacadeLocal {

    @PersistenceContext(unitName = "com.videojuegos_videojuegos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuditoriaFacade() {
        super(Auditoria.class);
    }
    
    
    
    
    
    


}