/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.serviceImpl;

import com.ramiro.gestionusuario.model.EntityHandler.RoleManagmentQueryHandler;
import com.ramiro.gestionusuario.model.MenuItem;
import com.ramiro.gestionusuario.model.Rol;
import com.ramiro.gestionusuario.service.RoleMagamentService;
import java.util.List;

/**
 *
 * @author Ramiro Ferreira
 */
public class RoleManagmentServiceImpl implements RoleMagamentService {

    RoleManagmentQueryHandler handler;

    public RoleManagmentServiceImpl() {
        this.handler = new RoleManagmentQueryHandler();
    }

    @Override
    public List<Rol> getAllRoles() {
        return this.handler.getAllRoles();
    }

    @Override
    public List<MenuItem> getAllMenuItemByIdRole(int idRole) {
        return this.handler.getAllMenuItemByIdRole(idRole);
    }

    @Override
    public void deleteRole(int idRole) {
        this.handler.deleteRole(idRole);
    }

    @Override
    public Rol getRoleById(int idRol) {
        return this.handler.getRoleById(idRol);
    }

    @Override
    public boolean isInUseRole(int idRol) {
        return this.handler.isInUseRole(idRol);
    }

}
