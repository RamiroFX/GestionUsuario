/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
public class RoleQueryHandler extends AbstractQuery {

    public boolean existRole(String descripcion) {
        open();
        TypedQuery typedQuery = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("rol.getRolByDescripcion", Rol.class);
        typedQuery.setParameter("descripcion", descripcion.trim().toUpperCase());
        return typedQuery.getResultList().size() > 0;
    }

    public void updateRole(int idRole, String descripcion) {
        open();
        Rol rol = EntityManagerHandler.INSTANCE.getEntityManager().find(Rol.class, idRole);
        rol.setDescripcion(descripcion.toUpperCase());
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void insertRol(Rol rol) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(rol);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public List<MenuItem> getAllMenuItem() {
        open();
        TypedQuery<MenuItem> typedQuery = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("menuItem.getAllMenuItem", MenuItem.class);
        return typedQuery.getResultList();
    }

    public MenuItem getMenuItemById(Long idMenuItem) {
        open();
        TypedQuery<MenuItem> empleadoEstado = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("menuItem.getMenuItemById", MenuItem.class);
        empleadoEstado.setParameter("idMenuItem", idMenuItem);
        return empleadoEstado.getSingleResult();
    }

    public void addAccesToRole(int idRole, Long idMenuItem) {
        open();
        Rol rol = EntityManagerHandler.INSTANCE.getEntityManager().find(Rol.class, idRole);
        MenuItem menuItem = EntityManagerHandler.INSTANCE.getEntityManager().find(MenuItem.class, idMenuItem);
        rol.addMenuItem(menuItem);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void removeAccesToRole(int idRole, Long idMenuItem) {
        open();
        Rol rol = EntityManagerHandler.INSTANCE.getEntityManager().find(Rol.class, idRole);
        MenuItem menuItem = EntityManagerHandler.INSTANCE.getEntityManager().find(MenuItem.class, idMenuItem);
        rol.removeMenuItem(menuItem);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }
}
