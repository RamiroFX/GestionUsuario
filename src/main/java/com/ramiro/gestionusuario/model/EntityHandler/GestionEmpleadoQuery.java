/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.model.EntityHandler;

import com.ramiro.gestionusuario.model.Empleado;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ramiro Ferreira
 */
public class GestionEmpleadoQuery extends AbstractQuery {

    public List<Empleado> getAllEmpleados() {
        open();
        String jpql = "SELECT p FROM Empleado p";
        Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(jpql);
        List<Empleado> countryList = query.getResultList();
        return countryList;
    }

    public boolean existEmpleado(String cedula) {
        open();
        TypedQuery typedQuery = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("empleado.getEmpleadoByCi", Empleado.class);
        typedQuery.setParameter("cedula", cedula.trim().toUpperCase());
        return typedQuery.getResultList().size() > 0;
    }

}
