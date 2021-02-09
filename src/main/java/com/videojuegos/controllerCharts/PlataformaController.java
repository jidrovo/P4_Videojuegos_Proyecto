/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videojuegos.controllerCharts;


import com.videojuegos.jbnCharts.PlataformaDao;
import com.videojuegos.modelCharts.Plataforma;
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
public class PlataformaController implements Serializable{
    @Inject
    private PlataformaDao plataformaDao;
    
    private List<Plataforma> lista;
    
    private String anio="1980";

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
    

    public List<Plataforma> getLista() {
        return lista;
    }

    public void setLista(List<Plataforma> lista) {
        this.lista = lista;
    }
    
    public void cargarListaPlataformasXAnio(){
        lista = plataformaDao.PlataformasTop5XAnio(anio);
    }
}
