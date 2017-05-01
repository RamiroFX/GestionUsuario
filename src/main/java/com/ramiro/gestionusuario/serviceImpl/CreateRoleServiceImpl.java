/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.serviceImpl;

import com.ramiro.gestionusuario.model.EntityHandler.RoleQueryHandler;
import com.ramiro.gestionusuario.model.MenuItem;
import com.ramiro.gestionusuario.model.Rol;
import com.ramiro.gestionusuario.service.CreateRoleService;
import java.util.List;

/**
 *
 * @author Ramiro Ferreira
 */
public class CreateRoleServiceImpl implements CreateRoleService {

    RoleQueryHandler roleQueryHandler;

    public CreateRoleServiceImpl() {
        this.roleQueryHandler = new RoleQueryHandler();
    }

    @Override
    public boolean existRole(String role) {
        return this.roleQueryHandler.existRole(role);
    }

    @Override
    public void createRole(Rol role) {
        this.roleQueryHandler.insertRol(role);
    }

    @Override
    public List<MenuItem> getAllMenuItem() {
        return this.roleQueryHandler.getAllMenuItem();
    }

    @Override
    public MenuItem getMenuItemById(Long idMenuItem) {
        return this.roleQueryHandler.getMenuItemById(idMenuItem);
    }

}
