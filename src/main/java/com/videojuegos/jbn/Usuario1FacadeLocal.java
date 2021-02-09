/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videojuegos.jbn;

import com.videojuegos.model.Usuario1;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Arturo
 */
@Local
public interface Usuario1FacadeLocal {

    void create(Usuario1 usuario1);

    void edit(Usuario1 usuario1);

    void remove(Usuario1 usuario1);

    Usuario1 find(Object id);

    List<Usuario1> findAll();

    List<Usuario1> findRange(int[] range);

    int count();
    
}
