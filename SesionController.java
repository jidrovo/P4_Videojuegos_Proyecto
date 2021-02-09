/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videojuegos.controller;

import com.videojuegos.model.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Arturo
 */
@Named
@ViewScoped
public class SesionController implements Serializable{
    
    public void verificarSesion(){
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
            
            if(us == null){
                context.getExternalContext().redirect("permisos.xhtml");
            }
            
        }catch(Exception e){
            //log para guardar el registro de un error
        }
    }
    
    public void cerrarSesion(){
        
            
              FacesContext context = FacesContext.getCurrentInstance();

              ExternalContext externalContext = context.getExternalContext();

              Object session = externalContext.getSession(false);

               HttpSession httpSession = (HttpSession) session;

              httpSession.invalidate();
    }
    
    //Método para cerrar sesión
public String logout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate(); //Cierre de sesion
        }
        return "index";// indicas a donde quieres direccionar después de cerrar sesión 
    }
}
