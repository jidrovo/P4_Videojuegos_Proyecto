/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videojuegos.controller;

import com.videojuegos.jbn.UsuarioFacadeLocal;
import com.videojuegos.model.Usuario;
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
public class listarUsuariosController implements Serializable{
    
    @EJB
    UsuarioFacadeLocal usuarioEJB;
    private List<Usuario> usuarios;
    
    private List<Usuario> administradores;
    private List<Usuario> usuariosClientes;

    public List<Usuario> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<Usuario> administradores) {
        this.administradores = administradores;
    }

    public List<Usuario> getUsuariosClientes() {
        return usuariosClientes;
    }

    public void setUsuariosClientes(List<Usuario> usuariosClientes) {
        this.usuariosClientes = usuariosClientes;
    }
    
    

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
    @PostConstruct
    public void init(){
        usuarios = usuarioEJB.findAll();
        administradores = usuarioEJB.listarAdministradores();
        usuariosClientes = usuarioEJB.listarUsuarios();
    }
    
    
    
}
