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
public interface CreateRoleService {

    public List<MenuItem> getAllMenuItem();

    public boolean existRole(String role);

    public void createRole(Rol rol);

    public MenuItem getMenuItemById(Long idMenuItem);

    public void updateRole(int idRole, String descripcion);

    public void addAccesToRole(int idRole, Long idMenuItem);

    public void removeAccesToRole(int idRole, Long idMenuItem);
}
