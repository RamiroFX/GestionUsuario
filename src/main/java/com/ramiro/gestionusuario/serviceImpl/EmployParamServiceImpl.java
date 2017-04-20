/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.serviceImpl;

import com.ramiro.gestionusuario.model.Ciudad;
import com.ramiro.gestionusuario.model.EntityHandler.EmpleadoQuery;
import com.ramiro.gestionusuario.model.Pais;
import com.ramiro.gestionusuario.service.EmployParamService;
import java.util.List;

/**
 *
 * @author Ramiro Ferreira
 */
public class EmployParamServiceImpl implements EmployParamService {

    private EmpleadoQuery employQuery;

    public EmployParamServiceImpl() {
        this.employQuery = new EmpleadoQuery();
    }

    @Override
    public List<Pais> getAllCountries() {
        return this.employQuery.getAllCountries();
    }

    @Override
    public List<Ciudad> getAllCities() {
        return this.employQuery.getAllCities();
    }

    @Override
    public boolean existCity(String descripcion) {
        return this.employQuery.existCity(descripcion);
    }

    @Override
    public void insertCity(Ciudad ciudad) {
        this.employQuery.insertCity(ciudad);
    }

    @Override
    public void updateCity(int idCiudad, String descripcion) {
        this.employQuery.updateCity(idCiudad, descripcion);
    }

    @Override
    public void deleteCity(Ciudad ciudad) {
        this.employQuery.removeCity(ciudad);
    }

    @Override
    public boolean existCountry(String descripcion) {
        return this.employQuery.existCountry(descripcion);
    }

    @Override
    public void insertCountry(Pais pais) {
        this.employQuery.insertCountry(pais);
    }

    @Override
    public void updateCountry(int idCountry, String description) {
        this.employQuery.updateCountry(idCountry, description);
    }

    @Override
    public void deleteCountry(Pais pais) {
        this.employQuery.removeCountry(pais);
    }
}
