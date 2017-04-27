/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.model.EntityHandler;

import com.ramiro.gestionusuario.model.Empleado;
import com.ramiro.gestionusuario.model.EmpleadoEstado;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Ramiro Ferreira
 */
public class ChangeEmployStatusQueryHandler extends AbstractQuery {

    public ChangeEmployStatusQueryHandler() {
    }

    public List<EmpleadoEstado> getAllEmployStatus() {
        open();
        Query query = EntityManagerHandler.INSTANCE.getEntityManager().createNamedQuery("empleadoEstado.getAllEmpleadoEstados", EmpleadoEstado.class);
        return query.getResultList();
    }

    public void changeEmployStatus(Empleado employ, EmpleadoEstado employStatus) {
        open();
        employ.setEmpleadoEstado(employStatus);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void changeEmployStatus2(Long idEmploy, int idStatus) {
        open();
        Empleado employ = EntityManagerHandler.INSTANCE.getEntityManager().find(Empleado.class, idEmploy);
        EmpleadoEstado employStatus = EntityManagerHandler.INSTANCE.getEntityManager().find(EmpleadoEstado.class, idStatus);
        employ.setEmpleadoEstado(employStatus);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }
}
