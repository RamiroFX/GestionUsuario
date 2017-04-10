/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionusuario.model.EntityHandler;

import com.mycompany.gestionusuario.model.Ciudad;
import com.mycompany.gestionusuario.model.EstadoCivil;
import com.mycompany.gestionusuario.model.Genero;
import com.mycompany.gestionusuario.model.Pais;
import com.mycompany.gestionusuario.model.Rol;

/**
 *
 * @author Ramiro
 */
public class AddPersonQuery extends AbstractQuery {

    public AddPersonQuery() {
    }

    public void insertCiudad(Ciudad ciudad) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(ciudad);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void insertSexo(Genero genero) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(genero);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void insertPais(Pais pais) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(pais);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void insertRol(Rol rol) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(rol);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

    public void insertEstadoCivil(EstadoCivil estadoCivil) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(estadoCivil);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

}
