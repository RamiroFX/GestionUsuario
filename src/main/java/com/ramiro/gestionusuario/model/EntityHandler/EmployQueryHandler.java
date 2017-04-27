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
public class EmployQueryHandler extends AbstractQuery {

    public EmployQueryHandler() {
    }

    public List<EstadoCivil> getAllCivilStates() {
        open();
        String jpql = "SELECT ec FROM EstadoCivil ec";
        Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(jpql);
        List<EstadoCivil> estadoCivilList = query.getResultList();
        return estadoCivilList;
    }

    public List<Genero> getAllGenders() {
        open();
        String jpql = "SELECT g FROM Genero g";
        Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(jpql);
        List<Genero> generoList = query.getResultList();
        return generoList;
    }

    public List<Ciudad> getAllCities() {
        open();
        String jpql = "SELECT c FROM Ciudad c";
        Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(jpql);
        List<Ciudad> ciudadList = query.getResultList();
        return ciudadList;
    }

    public List<Pais> getAllCountries() {
        open();
        String jpql = "SELECT p FROM Pais p";
        Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(jpql);
        List<Pais> paisList = query.getResultList();
        return paisList;
    }

    public List<Rol> getAllRols() {
        open();
        String jpql = "SELECT r FROM Rol r";
        Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(jpql);
        List<Rol> rolList = query.getResultList();
        return rolList;
    }

    public List<Rol> getSelectedRols(List<Integer> roles) {
        open();
        String jpql = "SELECT r FROM Rol r";
        Query query = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("rol.getAllRolByIds", Rol.class);
        query.setParameter("id", roles);
        List<Rol> rolList = query.getResultList();
        return rolList;
    }

    public boolean isPINinUse(int cedula) {
        open();
        TypedQuery<Persona> typedQuery = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("persona.getPersonaByCedula", Persona.class);
        typedQuery.setParameter("cedula", cedula);
        return !typedQuery.getResultList().isEmpty();
    }

    public boolean isApodoInUse(String apodo) {
        open();
        TypedQuery<Empleado> typedQuery = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("empleado.getEmpleadoByApodo", Empleado.class);
        typedQuery.setParameter("apodo", apodo);
        return !typedQuery.getResultList().isEmpty();
    }

    public boolean isEmailInUse(String email) {
        open();
        TypedQuery<Empleado> typedQuery = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("empleado.getEmpleadoByEmail", Empleado.class);
        typedQuery.setParameter("email", email);
        return !typedQuery.getResultList().isEmpty();
    }

    public void insertEmploy(Empleado empleado) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(empleado);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void updateEmploy(Long idEmploy, Empleado empleado) {
        open();
        Empleado employ = EntityManagerHandler.INSTANCE.getEntityManager().find(Empleado.class, idEmploy);
        employ.setApellido(empleado.getApellido());
        employ.setApodo(empleado.getApodo());
        employ.setCedula(empleado.getCedula());
        employ.setCiudad(empleado.getCiudad());
        employ.setDireccion(empleado.getDireccion());
        employ.setEmail(empleado.getEmail());
        employ.setEstadoCivil(empleado.getEstadoCivil());
        employ.setFechaIngreso(empleado.getFechaIngreso());
        employ.setFechaNacimiento(empleado.getFechaNacimiento());
        employ.setNombre(empleado.getNombre());
        employ.setNroCelular(empleado.getNroCelular());
        employ.setNroTelefono(empleado.getNroTelefono());
        employ.setObservacion(empleado.getObservacion());
        employ.setPais(empleado.getPais());
        employ.setPassword(empleado.getPassword());
        employ.setRoles(empleado.getRoles());
        employ.setSexo(empleado.getSexo());
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void removeEmploy(int idEmploy) {
        open();
        Empleado employ = EntityManagerHandler.INSTANCE.getEntityManager().find(Empleado.class, idEmploy);
        EntityManagerHandler.INSTANCE.getEntityManager().remove(employ);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void removeRol(Empleado employ, int idRol) {
        open();
        Rol rol = EntityManagerHandler.INSTANCE.getEntityManager().find(Rol.class, idRol);
        employ.quitarRol(rol);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void addRol(Empleado employ, int idRol) {
        open();
        Rol rol = EntityManagerHandler.INSTANCE.getEntityManager().find(Rol.class, idRol);
        employ.agregarRol(rol);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public EmpleadoEstado getEstadoActivo() {
        open();
        TypedQuery<EmpleadoEstado> empleadoEstado = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("empleadoEstado.getEmpleadoEstadoACTIVO", EmpleadoEstado.class);
        empleadoEstado.setParameter("activo", "ACTIVO");
        return empleadoEstado.getSingleResult();
    }
}
