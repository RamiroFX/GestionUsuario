/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.model.EntityHandler;

import com.ramiro.gestionusuario.model.Menu;
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
        TypedQuery<MenuItem> typedQuery = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("menuItem.getAllMenuItemByIdRole", MenuItem.class);
        typedQuery.setParameter("idRol", idRol);
        return typedQuery.getResultList();
    }

    public boolean isInUseRole(int idRol) {
        open();
        TypedQuery<Rol> query = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("rol.getAllRolByIds", Rol.class);
        query.setParameter("id", idRol);
        return !query.getResultList().isEmpty();
    }

    public void deleteRole(int idRol) {
    }

    public void insertMenu(Menu menu) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(menu);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void insertMenuItem(MenuItem menuItem) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(menuItem);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void addMenuItemIntoRole(Rol role, MenuItem menuItem) {
        open();
        role.addMenuItem(menuItem);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public Rol getRoleById(int idRol) {
        open();
        return EntityManagerHandler.INSTANCE.getEntityManager().find(Rol.class, idRol);
    }
}
