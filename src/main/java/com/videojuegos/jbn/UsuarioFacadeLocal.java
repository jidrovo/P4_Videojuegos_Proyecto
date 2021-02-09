/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videojuegos.jbn;

import com.videojuegos.model.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Arturo
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
    
    Usuario iniciarSesion(Usuario us);
    
    List<Usuario> listarAdministradores();
    
    List<Usuario> listarUsuarios();
    
    Usuario buscarUsuarioXcorreo(String correoUsuario);
}
