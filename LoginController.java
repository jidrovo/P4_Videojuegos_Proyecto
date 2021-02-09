/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videojuegos.controller;

import com.videojuegos.jbn.UsuarioFacadeLocal;
import com.videojuegos.model.Usuario;
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
public class LoginController implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private Usuario usuario;
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public String iniciarSesion(){
        String redireccion = null;
        Usuario us;
        try{
            us = usuarioEJB.iniciarSesion(usuario);
            if(us!=null){
                
                //almacenar en la sesion JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                
                int tipo = us.getTipo();
                if(tipo == 1){
                    redireccion = "menuAdministrador";
                }
                if(tipo == 2){
                    redireccion = "menuUsuario";
                }
                if((tipo == 3) || (tipo == 4)){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Usuario Bloqueado"));
                }
                
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
            }
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error, intentelo otra vez"));

        }
        return redireccion;
    }
    
    
    
}
