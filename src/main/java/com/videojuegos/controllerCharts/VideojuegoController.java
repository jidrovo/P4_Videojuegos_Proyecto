/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videojuegos.controllerCharts;

/**
 *
 * @author Arturo
 */
import com.videojuegos.jbnCharts.VideojuegoDao;
import com.videojuegos.modelCharts.Videojuego;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Arturo
 */
@Named
@ViewScoped
public class VideojuegoController implements Serializable{
    
    @Inject
    private VideojuegoDao videojuegoDao;
    
    private List<Videojuego> lista;
    
    private String anio="";

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
    
    @PostConstruct
    public void init(){
        lista = new ArrayList();
    }
    

    public List<Videojuego> getLista() {
        return lista;
    }

    public void setLista(List<Videojuego> lista) {
        this.lista = lista;
    }
    
    public void cargarListaVideoJuegosXAnio(){
        lista = videojuegoDao.Videojuegos(anio);
    }
   
   
}
