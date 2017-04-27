/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.serviceImpl;

import com.ramiro.gestionusuario.model.Empleado;
import com.ramiro.gestionusuario.model.EmpleadoEstado;
import com.ramiro.gestionusuario.model.EntityHandler.ChangeEmployStatusQueryHandler;
import com.ramiro.gestionusuario.service.ChangeEmployStatusService;
import java.util.List;

/**
 *
 * @author Ramiro Ferreira
 */
public class ChangeStatusImpl implements ChangeEmployStatusService {

    private ChangeEmployStatusQueryHandler changeEmployStatusQueryHandler;

    public ChangeStatusImpl() {
        this.changeEmployStatusQueryHandler = new ChangeEmployStatusQueryHandler();
    }

    @Override
    public List<EmpleadoEstado> getAllEmployStatus() {
        return this.changeEmployStatusQueryHandler.getAllEmployStatus();
    }

    @Override
    public void changeEmployStatus(Empleado employ, EmpleadoEstado employStatus) {
        this.changeEmployStatusQueryHandler.changeEmployStatus(employ, employStatus);
    }

    @Override
    public void changeEmployStatus2(Long idPersona, int idEmpleadoEstado) {
        this.changeEmployStatusQueryHandler.changeEmployStatus2(idPersona, idEmpleadoEstado);
    }

}
