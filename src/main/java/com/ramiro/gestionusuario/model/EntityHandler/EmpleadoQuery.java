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
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Ramiro
 */
public class EmpleadoQuery extends AbstractQuery {

    public EmpleadoQuery() {
    }

    public void getCityColumns() {
        Field[] cols = Ciudad.class.getFields();
        ArrayList columns = new ArrayList();
        for (Field field : cols) {
            columns.add(field.getName());
        }
    }

    public ResultSet readAllCities() {
        return null;
    }

    public List<Ciudad> getAllCities() {
        open();
        String jpql = "SELECT s FROM Ciudad s";
        Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(jpql);
        List<Ciudad> ciudadList = query.getResultList();
        return ciudadList;
    }

    public void insertCity(Ciudad ciudad) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(ciudad);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void updateCity(Ciudad ciudad, String descripcion) {
        open();
        ciudad.setDescripcion(descripcion);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void removeCity(Ciudad ciudad) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().remove(ciudad);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public List<Pais> getAllCountries() {
        open();
        String jpql = "SELECT p FROM Pais P";
        Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(jpql);
        List<Pais> countryList = query.getResultList();
        return countryList;
    }

    public void insertCountry(Pais pais) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(pais);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void updateCountry(Pais pais, String descripcion) {
        open();
        pais.setDescripcion(descripcion);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void removeCountry(Pais pais) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().remove(pais);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void insertSexo(Genero genero) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(genero);
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
