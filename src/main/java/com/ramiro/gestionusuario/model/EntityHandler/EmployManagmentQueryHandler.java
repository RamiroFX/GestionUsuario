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
public class EmployManagmentQueryHandler extends AbstractQuery {

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

    public Empleado obtenerEmpleado(Long id) {
        open();
        Empleado empleado = EntityManagerHandler.INSTANCE.getEntityManager().find(Empleado.class, id);
        return empleado;
    }

    public List<Empleado> consultarFuncionario(String criteria, boolean isExclusivo, boolean buscarPorNombreApellido, boolean buscarPorPIN) {
        open();
        TypedQuery typedQuery = null;
        if (buscarPorNombreApellido) {
            typedQuery = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("empleado.getEmpleadoByNombreApellido", Empleado.class);
            if (isExclusivo) {
                typedQuery.setParameter("criteria", criteria.trim() + "%");
            } else {
                typedQuery.setParameter("criteria", "%" + criteria.trim() + "%");
            }
            return typedQuery.getResultList();
        } else if (buscarPorPIN) {
            typedQuery = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("empleado.getEmpleadoByCedula", Empleado.class);
            int cedula = 0;
            try {
                cedula = Integer.parseInt(criteria.trim());
            } catch (Exception e) {
                typedQuery.setParameter("cedula", 0);
            }
            typedQuery.setParameter("cedula", cedula);
            return typedQuery.getResultList();
        }
        return typedQuery.getResultList();
    }

}
