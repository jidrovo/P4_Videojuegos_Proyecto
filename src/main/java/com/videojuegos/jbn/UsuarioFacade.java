/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videojuegos.jbn;

import com.videojuegos.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Arturo
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "com.videojuegos_videojuegos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario iniciarSesion(Usuario us){
        Usuario usuario=null;
        String consulta;
        try{
            consulta = "FROM Usuario u WHERE u.correo = ?1 and u.clave = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, us.getCorreo());
            query.setParameter(2, us.getClave());
                    
            List<Usuario> lista = query.getResultList();
            if(!lista.isEmpty()){
                usuario = lista.get(0);
            }
        }catch(Exception e){
            throw e;
        }
        return usuario;
    }
    
    @Override
    public Usuario buscarUsuarioXcorreo(String correoUsuario){
        Usuario usuario=null;
        String consulta;
        try{
            consulta = "FROM Usuario u WHERE u.correo = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, correoUsuario);
                    
            List<Usuario> lista = query.getResultList();
            if(!lista.isEmpty()){
                usuario = lista.get(0);
            }
        }catch(Exception e){
            throw e;
        }
        return usuario;
    }
    
    
    @Override
    public List<Usuario> listarAdministradores(){
        String consulta;
        List<Usuario> lista = new ArrayList();
        try{
            consulta = "FROM Usuario u WHERE u.tipo = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, 1);
            
            lista = query.getResultList();
        }catch(Exception e){
            throw e;
        }
        return lista;
    }
    
    @Override
    public List<Usuario> listarUsuarios(){
        String consulta;
        List<Usuario> lista;
        try{
            consulta = "FROM Usuario u WHERE u.tipo=2";
            Query query = em.createQuery(consulta);
            
            lista = query.getResultList();
        }catch(Exception e){
            throw e;
        }
        return lista;
    }
}
