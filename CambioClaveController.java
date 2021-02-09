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
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Arturo
 */
@Named
@RequestScoped
public class CambioClaveController implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    
    private Usuario usuario;   
    FacesContext context = FacesContext.getCurrentInstance();
   
    private String clavenueva;
    private String clavenueva1;
    private String claveantigua;

    public String getClavenueva1() {
        return clavenueva1;
    }

    public void setClavenueva1(String clavenueva1) {
        this.clavenueva1 = clavenueva1;
    }

    
    
    public String getClaveantigua() {
        return claveantigua;
    }

    public void setClaveantigua(String claveantigua) {
        this.claveantigua = claveantigua;
    }
    
    
    

    public String getClavenueva() {
        return clavenueva;
    }

    public void setClavenueva(String clavenueva) {
        this.clavenueva = clavenueva;
    }
    
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    @PostConstruct
    public void init(){
        usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
        
    }
    
    
    public void cambiarClave(){
        try{
            
            String claveActual = usuario.getClave();
            
            if(claveActual.equals(claveantigua)){
            
                if(clavenueva.equals(clavenueva1)){
                   usuario.setClave(clavenueva);
                   usuarioEJB.edit(usuario);
            
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Su clave se ha actualizado correctamente."));
                }else{
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "La clave nueva con su repetición no coincide. Vuelva a intentarlo"));
                }
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Su clave actual es incorrecta. "));
            }
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
    }
}
