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
public class ListadoController implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private List<Usuario> lista;
    
    @PostConstruct
    public void init(){
        this.listarUsuarios();
        
    }
    
    public void listarUsuarios(){
        try{
            lista = usuarioEJB.findAll();
        }catch(Exception e){
            
        }
    }
    
    public void getAdministradores() {
        for (Usuario u : lista){
            if(u.getTipo() == 1){
                
            }
        }
    }
}
