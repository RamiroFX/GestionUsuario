/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.model.EntityHandler;

import com.ramiro.gestionusuario.model.MenuItem;
import com.ramiro.gestionusuario.model.Rol;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ramiro Ferreira
 */
public class RoleManagmentQueryHandler extends AbstractQuery {

    public RoleManagmentQueryHandler() {
    }

    public List<Rol> getAllRoles() {
        open();
        TypedQuery<Rol> typedQuery = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("rol.getAllRoles", Rol.class);
        return typedQuery.getResultList();
    }

    public List<MenuItem> getAllMenuItemByIdRole(int idRol) {
        open();
        TypedQuery<MenuItem> typedQuery = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("", MenuItem.class);
        return null;
    }

    public void deleteRole(int idRol) {
    }
}
