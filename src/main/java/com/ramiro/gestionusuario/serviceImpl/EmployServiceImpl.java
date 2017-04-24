/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.serviceImpl;

import com.ramiro.gestionusuario.model.Ciudad;
import com.ramiro.gestionusuario.model.Empleado;
import com.ramiro.gestionusuario.model.EntityHandler.EmployQueryHandler;
import com.ramiro.gestionusuario.model.EstadoCivil;
import com.ramiro.gestionusuario.model.Genero;
import com.ramiro.gestionusuario.model.Pais;
import com.ramiro.gestionusuario.model.Rol;
import com.ramiro.gestionusuario.service.EmployService;
import java.util.List;

/**
 *
 * @author Ramiro Ferreira
 */
public class EmployServiceImpl implements EmployService {

    EmployQueryHandler employQueryHandler;

    public EmployServiceImpl() {
        this.employQueryHandler = new EmployQueryHandler();
    }

    @Override
    public List<Rol> getAllRoles() {
        return this.employQueryHandler.getAllRols();
    }

    @Override
    public List<Pais> getAllCountries() {
        return this.employQueryHandler.getAllCountries();
    }

    @Override
    public List<Ciudad> getAllCities() {
        return this.employQueryHandler.getAllCities();
    }

    @Override
    public List<EstadoCivil> getAllCivilStates() {
        return this.employQueryHandler.getAllCivilStates();
    }

    @Override
    public List<Genero> getAllGenders() {
        return this.employQueryHandler.getAllGenders();
    }

    @Override
    public boolean isPINinUse(int PIN) {
        return this.employQueryHandler.isPINinUse(PIN);
    }

    @Override
    public boolean isApodoInUse(String apodo) {
        return this.employQueryHandler.isApodoInUse(apodo);
    }

    @Override
    public boolean isEmailInUse(String email) {
        return this.employQueryHandler.isEmailInUse(email);
    }

    @Override
    public void createEmploy(Empleado employ) {
        this.employQueryHandler.insertEmploy(employ);
    }

    @Override
    public void updateEmploy(int idEmploy, Empleado employ) {
        this.employQueryHandler.updateEmploy(idEmploy, employ);
    }

    @Override
    public void deleteEmploy(int idEmploy) {
        this.employQueryHandler.removeEmploy(idEmploy);
    }
}
