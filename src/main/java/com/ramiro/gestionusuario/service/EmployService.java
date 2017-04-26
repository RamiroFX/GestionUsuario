/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.service;

import com.ramiro.gestionusuario.model.Ciudad;
import com.ramiro.gestionusuario.model.Empleado;
import com.ramiro.gestionusuario.model.EstadoCivil;
import com.ramiro.gestionusuario.model.Genero;
import com.ramiro.gestionusuario.model.Pais;
import com.ramiro.gestionusuario.model.Rol;
import java.util.List;

/**
 *
 * @author Ramiro Ferreira
 */
public interface EmployService {

    public List<Rol> getAllRoles();

    public List<Rol> getAllRolByIds(List<Integer> roles);

    public List<Pais> getAllCountries();

    public List<Ciudad> getAllCities();

    public List<EstadoCivil> getAllCivilStates();

    public List<Genero> getAllGenders();

    public boolean isPINinUse(int PIN);

    public boolean isApodoInUse(String apodo);

    public boolean isEmailInUse(String email);

    public void createEmploy(Empleado employ);

    public void updateEmploy(Long idEmploy, Empleado employ);

    public void deleteEmploy(int idEmploy);
}
