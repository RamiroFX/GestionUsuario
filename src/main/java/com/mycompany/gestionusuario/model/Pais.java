/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionusuario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ramiro Ferreira
 */
@Entity(name = "Pais")
@Table(name = "PAIS")
public class Pais {

    @Id
    @GeneratedValue
    int id;
    @Column(name = "descripcion")
    String descripcion;

    public Pais() {
    }

    public Pais(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return getDescripcion();
    }
}
