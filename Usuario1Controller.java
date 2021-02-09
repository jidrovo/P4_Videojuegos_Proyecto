/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videojuegos.controller;

import com.videojuegos.jbn.Usuario1Facade;
import com.videojuegos.jbn.Usuario1FacadeLocal;
import com.videojuegos.model.Usuario1;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Arturo
 */
@Named
@ViewScoped
public class Usuario1Controller implements Serializable{
    
    @EJB
    private Usuario1FacadeLocal usuarioEJB;
    
    private Usuario1 usuario;

    public Usuario1 getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario1 usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        usuario = new Usuario1();
    }
    
    public void registrar(){
        try{
            usuarioEJB.create(usuario);
        }catch(Exception e){
            //mensaje prime growl

        }
    }
    
}
