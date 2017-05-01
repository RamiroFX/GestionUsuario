/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.model.EntityHandler;

import com.ramiro.gestionusuario.model.Ciudad;
import com.ramiro.gestionusuario.model.Empleado;
import com.ramiro.gestionusuario.model.EmpleadoEstado;
import com.ramiro.gestionusuario.model.EstadoCivil;
import com.ramiro.gestionusuario.model.Genero;
import com.ramiro.gestionusuario.model.Pais;
import com.ramiro.gestionusuario.model.Persona;
import com.ramiro.gestionusuario.model.Rol;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ramiro Ferreira
 */
public class EmployParamQueryHandler extends AbstractQuery {

    public EmployParamQueryHandler() {
    }

    public List<Ciudad> getAllCities() {
        open();
        String jpql = "SELECT s FROM Ciudad s";
        Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(jpql);
        List<Ciudad> ciudadList = query.getResultList();
        return ciudadList;
    }

    public boolean existCountry(String descripcion) {
        open();
        TypedQuery typedQuery = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("pais.getPaisByDescripcion", Pais.class);
        typedQuery.setParameter("descripcion", descripcion.trim().toUpperCase());
        return typedQuery.getResultList().size() > 0;
    }

    public boolean isInUseCountry(int idCountry) {
        open();
        TypedQuery<Persona> query = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("persona.getPersonasByCountryId", Persona.class);
        query.setParameter("id", idCountry);
        return !query.getResultList().isEmpty();
    }

    public boolean existCity(String descripcion) {
        open();
        TypedQuery typedQuery = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("ciudad.getCiudadByDescripcion", Ciudad.class);
        typedQuery.setParameter("descripcion", descripcion.trim().toUpperCase());
        return typedQuery.getResultList().size() > 0;
    }

    public boolean isInUseCity(int idCity) {
        open();
        TypedQuery<Persona> query = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("persona.getPersonasByCityId", Persona.class);
        query.setParameter("id", idCity);
        return !query.getResultList().isEmpty();
    }

    public void insertCity(Ciudad ciudad) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(ciudad);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void updateCity(int idCiudad, String descripcion) {
        open();
        Ciudad ciudad = EntityManagerHandler.INSTANCE.getEntityManager().find(Ciudad.class, idCiudad);
        ciudad.setDescripcion(descripcion.toUpperCase());
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void removeCity(int idCity) {
        open();
        Ciudad ciudad = EntityManagerHandler.INSTANCE.getEntityManager().find(Ciudad.class, idCity);
        EntityManagerHandler.INSTANCE.getEntityManager().remove(ciudad);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public List<Pais> getAllCountries() {
        open();
        String jpql = "SELECT p FROM Pais p";
        Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(jpql);
        List<Pais> countryList = query.getResultList();
        return countryList;
    }

    public void insertCountry(Pais pais) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(pais);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void updateCountry(int idCountry, String descripcion) {
        open();
        Pais pais = EntityManagerHandler.INSTANCE.getEntityManager().find(Pais.class, idCountry);
        pais.setDescripcion(descripcion.toUpperCase());
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void removeCountry(int idPais) {
        open();
        Pais pais = EntityManagerHandler.INSTANCE.getEntityManager().find(Pais.class, idPais);
        EntityManagerHandler.INSTANCE.getEntityManager().remove(pais);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void insertSexo(Genero genero) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(genero);
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

    public void insertEmployStatus(EmpleadoEstado empleadoEstado) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(empleadoEstado);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }
}
