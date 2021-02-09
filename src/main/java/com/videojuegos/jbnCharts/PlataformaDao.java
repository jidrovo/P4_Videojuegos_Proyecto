/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videojuegos.jbnCharts;

import com.videojuegos.modelCharts.ConexionVideojuego;
import com.videojuegos.modelCharts.Plataforma;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Arturo
 */
@Named
@ApplicationScoped
public class PlataformaDao {
    
    public List<Plataforma> PlataformasTop5XAnio(String anio) {
        List<Plataforma> lista = new ArrayList();
        Plataforma plataforma;

        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionVideojuego bd = new ConexionVideojuego();
        try {
            ps = bd.getConexion().prepareStatement("SELECT dp.nombre_plataforma,\n" +
"sum(fv.total_venta) as ventas\n" +
"from dim_plataforma as dp, fact_venta as fv, dim_fecha as df\n" +
"where dp.sk_plataforma = fv.sk_plataforma\n" +
"and df.sk_fecha = fv.sk_fecha\n" +
"and df.anio ="+anio+" \n" +
"group by dp.nombre_plataforma,\n" +
"df.anio\n" +
"order by ventas desc\n" +
"limit 5;");

            rs = ps.executeQuery();
            while (rs.next()) {
                plataforma = new Plataforma();
                plataforma.setNombre(rs.getString(1));
                plataforma.setVenta(rs.getDouble(2));

                lista.add(plataforma);
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();

            } catch (Exception ex) {

            }
        }

        return lista;
    }
}
