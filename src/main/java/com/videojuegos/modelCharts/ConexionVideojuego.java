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
import org.postgresql.Driver;

import java.sql.*;
public class ConexionVideojuego
{
	private Statement St; 
	private String driver;
	private String user;
	private String pwd;
	private String cadena;
	private Connection con;

	String getDriver()
	{
		return this.driver;
	}
	String getUser()
	{
		return this.user;
	}
	String getPwd()
	{
		return this.pwd;
	}
	String getCadena()
	{
		return this.cadena;
	}
	public Connection getConexion()
	{ 
		return this.con; 
	}
	
	public ConexionVideojuego() {
		
		this.driver ="org.postgresql.Driver";
		this.user="postgres";
		this.pwd="administrador";
		this.cadena="jdbc:postgresql://localhost:5432/videojuegos_prueba";
		this.con=this.crearConexion();
		
	}
	
	Connection crearConexion()
	{
		try {
			Class.forName("org.postgresql.Driver");
			
			
		
		
			Class.forName(getDriver()).newInstance();
			//Connection con=DriverManager.getConnection(getCadena(),getUser(),getPwd());
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyecto_videojuegos_dimencional_personas","postgres", "administrador");
                        return con;
			
		}
	catch(Exception ee)
	{
		System.out.println("Error: " + ee.getMessage());
		return null;
		
	}
		
	}


	public String Ejecutar(String sql)
	{
	String error="";
	try
	{
	St=getConexion().createStatement();
	St.execute(sql);
	error="Datos insertados";
	}
	catch(Exception ex)
	{
	error = ex.getMessage();
	}
	return(error);
	}



	public ResultSet Consulta(String sql)
	{
	String error="";
	ResultSet reg=null;
	
	try
	{
	St=getConexion().createStatement();
	reg=St.executeQuery(sql);
	

	}
	catch(Exception ee)
	{
	error = ee.getMessage();
	}
	return(reg);
	}
}

