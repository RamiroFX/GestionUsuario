/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.serviceImpl;

import com.ramiro.gestionusuario.model.Empleado;
import com.ramiro.gestionusuario.model.EntityHandler.GestionEmpleadoQuery;
import com.ramiro.gestionusuario.service.GestionEmpleadoService;
import java.util.List;

/**
 *
 * @author Ramiro Ferreira
 */
public class GestionEmpleadoServiceImpl implements GestionEmpleadoService {

    private GestionEmpleadoQuery gestionEmpleadoQuery;

    public GestionEmpleadoServiceImpl() {
        this.gestionEmpleadoQuery = new GestionEmpleadoQuery();
    }

    @Override
    public List<Empleado> getAllEmpleados() {
        return this.gestionEmpleadoQuery.getAllEmpleados();
    }

    @Override
    public Empleado obtenerEmpleado(Long id) {
        return this.gestionEmpleadoQuery.obtenerEmpleado(id);
    }

    @Override
    public List<Empleado> consultarFuncionario(String busqueda, boolean exclusivo, boolean entidad, boolean ruc) {
        return this.gestionEmpleadoQuery.consultarFuncionario(busqueda, exclusivo, entidad, ruc);
    }

}
