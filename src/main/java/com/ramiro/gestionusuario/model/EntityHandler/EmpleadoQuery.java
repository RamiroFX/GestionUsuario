/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.model.EntityHandler;

import com.ramiro.gestionusuario.model.Ciudad;
import com.ramiro.gestionusuario.model.Empleado;
import com.ramiro.gestionusuario.model.EstadoCivil;
import com.ramiro.gestionusuario.model.Genero;
import com.ramiro.gestionusuario.model.Pais;
import com.ramiro.gestionusuario.model.Persona;
import com.ramiro.gestionusuario.model.Rol;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Ramiro
 */
public class EmpleadoQuery extends AbstractQuery {

    public EmpleadoQuery() {
    }

    public void insertCiudad(Ciudad ciudad) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(ciudad);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public List<Ciudad> getAllCiudad() {
        open();
        String jpql = "SELECT s FROM Ciudad s";
        Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(jpql);
        List<Ciudad> ciudadList = query.getResultList();
        return ciudadList;
    }

    public void removeCiudad(Ciudad ciudad) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().remove(ciudad);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void insertSexo(Genero genero) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(genero);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void insertPais(Pais pais) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(pais);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void insertRol(Rol rol) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(rol);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void insertEstadoCivil(EstadoCivil estadoCivil) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(estadoCivil);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void insertPersona(Persona persona) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(persona);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void insertEmpleado(Empleado employ) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(employ);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

}
