/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videojuegos.controller;

/**
 *
 * @author Arturo
 */
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

/**
 *
 * @author Juan Eduardo
 */
@Named ("barChart")
@ViewScoped
public class BarModel implements Serializable{
    
    private BarChartModel barModel;
    private BarChartModel barModel2;
    private HorizontalBarChartModel horizontalBarModel;
    
    @PostConstruct
    public void init(){
        createBarModels();
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
    
    public BarChartModel getBarModel2() {
        return barModel2;
    }

    public void setBarModel2(BarChartModel barModel2) {
        this.barModel2 = barModel2;
    }

    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }

    public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
        this.horizontalBarModel = horizontalBarModel;
    }
    
    private void createBarModels(){
        
        createBarModel();
        createBarModel2();
        createHorizontalBarModel();
    }
    
    private void createBarModel(){
        
        barModel = initBarModel();
        
        barModel.setTitle("Los videojuegos más vendidos de toda la historia");
        barModel.setLegendPosition("ne");
        
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Videojuegos");
        
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Ventas x millon");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
    
     private void createBarModel2(){
        
        barModel2 = initBarModel2();
        
        barModel2.setTitle("Las plataformas más vendidas");
        barModel2.setLegendPosition("ne");
        
        Axis xAxis = barModel2.getAxis(AxisType.X);
        xAxis.setLabel("Plataforma");
        
        Axis yAxis = barModel2.getAxis(AxisType.Y);
        yAxis.setLabel("Ventas x millon");
        yAxis.setMin(0);
        yAxis.setMax(1400);
    }
    
    private void createHorizontalBarModel(){
        
        horizontalBarModel = new HorizontalBarChartModel();
        
        ChartSeries java = new ChartSeries();
        java.setLabel("Java");
        java.set("2004", 50);
        java.set("2005", 96);
        java.set("2006", 44);
        java.set("2007", 55);
        java.set("2008", 25);
        
        ChartSeries python= new ChartSeries();
        python.setLabel("Python");
        python.set("2004", 52);
        python.set("2005", 60);
        python.set("2006", 82);
        python.set("2007", 32);
        python.set("2008", 120);
        
        horizontalBarModel.addSeries(java);
        horizontalBarModel.addSeries(python);
        
        horizontalBarModel.setTitle("Horizontal and Stacked");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
        
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Jobs");
        xAxis.setMin(0);
        xAxis.setMax(200);
        
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Lenguaje");
        
    }
    
    private BarChartModel initBarModel(){
        BarChartModel model = new BarChartModel();
        
        ChartSeries java = new ChartSeries();
        java.setLabel("Nombre Videojuego");
        java.set("WII SPORTS \n \n", 82.74);
        java.set("GRAND THEFT AUTO V \n \n \n \n", 55.92);
        java.set("SUPER MARIO BROS \n \n", 45.31);
        java.set("TETRIS \n \n \n \n", 35.84);
        java.set("MARIO KART WII \n \n \n ", 35.82);
        java.set("WII SPORTS RESORT \n \n", 33.00);
        java.set("POKEMON RED/BLUE", 31.37);
        java.set("CALL OF DUTY: MDW3", 30.83);         
        
        
        model.addSeries(java);
       
        
        return model;
    }
    
    private BarChartModel initBarModel2(){
        BarChartModel model = new BarChartModel();
        
        ChartSeries java = new ChartSeries();
        java.setLabel("Nombre Plataforma");
        java.set("PS2", 1233.38);
        java.set("X360", 969.61);
        java.set("PS3", 949.35);
        java.set("WII", 909.81);
        java.set("DS ", 818.96);
                 
        
        
        model.addSeries(java);
       
        
        return model;
    }
    
    
}