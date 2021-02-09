/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videojuegos.controller;

import com.videojuegos.jbn.AuditoriaFacadeLocal;
import com.videojuegos.model.Auditoria;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Arturo
 */

@Named
@ViewScoped
public class ListarAuditoriaController implements Serializable{
    
    @EJB
    private AuditoriaFacadeLocal auditoriaEJB;
    
    private List<Auditoria> lista;

    public List<Auditoria> getLista() {
        return lista;
    }

    public void setLista(List<Auditoria> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void init(){
        lista = auditoriaEJB.findAll();
    }
    
}
