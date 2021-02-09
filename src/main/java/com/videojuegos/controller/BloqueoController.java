/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videojuegos.controller;

import com.videojuegos.jbn.UsuarioFacadeLocal;
import com.videojuegos.model.Usuario;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Arturo
 */
@Named
@RequestScoped
public class BloqueoController {
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    
    private Usuario usuario;
    
    private String correo;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
 

    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
    
    
    public void bloquearUsuario(){
        try{
            usuario = usuarioEJB.buscarUsuarioXcorreo(correo);
            
            if(usuario!=null){
                //si el tipo es 1, es administrador, se bloque con 3
                //si el tipo es 2, es cliente, se bloquea con 4
                if(usuario.getTipo()==1){
                    usuario.setTipo(3);
                }else if(usuario.getTipo()==2){
                    usuario.setTipo(4);
                }
                usuarioEJB.edit(usuario);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha bloqueado el usuario."));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "No existe el usuario"));
            }
            
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error, intentelo otra vez"));
        }
    }
    
    
    public void desbloquearUsuario(){
        try{
            usuario = usuarioEJB.buscarUsuarioXcorreo(correo);
            
            if(usuario!=null){
                //si el tipo es 3, es administrador, se desbloquea con 1
                //si el tipo es 4, es cliente, se desbloquea con 2
                if(usuario.getTipo()==3){
                    usuario.setTipo(1);
                }else if(usuario.getTipo()==4){
                    usuario.setTipo(2);
                }
                usuarioEJB.edit(usuario);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha desbloqueado el usuario."));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "No existe el usuario"));
            }
            
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error, intentelo otra vez"));
        }
    }
    
    
}
