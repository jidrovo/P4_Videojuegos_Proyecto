/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videojuegos.jbnCharts;

/**
 *
 * @author Arturo
 */
import com.videojuegos.modelCharts.ConexionVideojuego;
import com.videojuegos.modelCharts.Videojuego;
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
public class VideojuegoDao {

    public List<Videojuego> Videojuegos(String anio) {
        List<Videojuego> lista = new ArrayList();
        Videojuego juego;

        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionVideojuego bd = new ConexionVideojuego();
        try {
            ps = bd.getConexion().prepareStatement("SELECT dv.nombre_videojuego, sum(fv.total_venta) as ventas\n"
                    + "from dim_videojuego as dv, dim_fecha as df, fact_venta as fv\n"
                    + "where dv.sk_videojuego = fv.sk_videojuego\n"
                    + "and df.sk_fecha = fv.sk_fecha\n"
                    + "and df.anio =" + anio + "  \n"
                    + "group by dv.nombre_videojuego,\n"
                    + "df.anio\n"
                    + "order by ventas desc\n"
                    + "limit 5;");

            rs = ps.executeQuery();
            while (rs.next()) {
                juego = new Videojuego();
                juego.setNombre(rs.getString(1));
                juego.setVenta(rs.getDouble(2));

                lista.add(juego);
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

    public List<Videojuego> PlataformasTop5XAnio(String anio) {
        List<Videojuego> lista = new ArrayList();
        Videojuego juego;

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
                juego = new Videojuego();
                juego.setNombre(rs.getString(1));
                juego.setVenta(rs.getDouble(2));

                lista.add(juego);
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
