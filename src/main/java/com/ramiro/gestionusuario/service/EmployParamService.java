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

    public boolean existCity(String description);

    public boolean isInUseCity(int idCity);

    public void insertCity(Ciudad ciudad);

    public void updateCity(int idCity, String description);

    public void deleteCity(int idCity);

    public boolean existCountry(String description);

    public boolean isInUseCountry(int idCountry);

    public void insertCountry(Pais pais);

    public void updateCountry(int idCountry, String description);

    public void deleteCountry(int idPais);
}
