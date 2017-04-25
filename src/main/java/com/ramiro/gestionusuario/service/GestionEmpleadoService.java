/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.service;

import com.ramiro.gestionusuario.model.Empleado;
import java.util.List;

/**
 *
 * @author Ramiro Ferreira
 */
public interface GestionEmpleadoService {

    public List<Empleado> getAllEmpleados();

    public boolean existEmpleado(String cedula);

    public Empleado obtenerEmpleado(Long id);

    public List<Empleado> consultarFuncionario(String criteria, boolean isExclusivo, boolean buscarPorNombreApellido, boolean buscarPorPIN);
}
