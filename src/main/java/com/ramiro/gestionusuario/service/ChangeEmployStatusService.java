/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.service;

import com.ramiro.gestionusuario.model.Empleado;
import com.ramiro.gestionusuario.model.EmpleadoEstado;
import java.util.List;

/**
 *
 * @author Ramiro Ferreira
 */
public interface ChangeEmployStatusService {

    public List<EmpleadoEstado> getAllEmployStatus();

    public void changeEmployStatus(Empleado employ, EmpleadoEstado employStatus);
}
