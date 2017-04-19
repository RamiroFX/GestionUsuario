/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.service;

import com.ramiro.gestionusuario.model.Ciudad;
import com.ramiro.gestionusuario.model.Pais;
import java.util.List;

/**
 *
 * @author Ramiro Ferreira
 */
public interface EmployParamService {

    public List<Pais> getAllCountries();

    public List<Ciudad> getAllCities();

    public boolean existCity(String descripcion);

    public void insertCity(Ciudad ciudad);

    public void updateCity(Ciudad ciudad, String descripcion);

    public void deleteCity(Ciudad ciudad);

    public boolean existCountry(String descripcion);

    public void insertCountry(Pais pais);

    public void updateCountry(Pais pais, String descripcion);

    public void deleteCountry(Pais pais);
}
