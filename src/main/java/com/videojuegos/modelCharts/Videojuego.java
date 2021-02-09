/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videojuegos.modelCharts;

/**
 *
 * @author Arturo
 */
public class Videojuego {
    
    String nombre;
    
    double venta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVenta() {
        return venta;
    }

    public void setVenta(double venta) {
        this.venta = venta;
    }

    public Videojuego() {
    }

    public Videojuego(String nombre, double venta) {
        this.nombre = nombre;
        this.venta = venta;
    }
    
    
    
}