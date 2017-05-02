/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.service;

import com.ramiro.gestionusuario.model.MenuItem;
import com.ramiro.gestionusuario.model.Rol;
import java.util.List;

/**
 *
 * @author Ramiro Ferreira
 */
public interface RoleMagamentService {

    public List<Rol> getAllRoles();

    public List<MenuItem> getAllMenuItemByIdRole(int idRole);

    public void deleteRole(int idRole);

    public Rol getRoleById(int idRol);

    public boolean isInUseRole(int idRol);
}
