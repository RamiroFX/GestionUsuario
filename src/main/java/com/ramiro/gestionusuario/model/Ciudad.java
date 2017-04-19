/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ramiro Ferreira
 */
@Entity(name = "Ciudad")
@Table(name = "ciudad")
@NamedQueries({
    @NamedQuery(name = "ciudad.getAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "ciudad.getCiudadById", query = "SELECT c FROM Ciudad c WHERE c.id = :id"),
    @NamedQuery(name = "ciudad.getCiudadByDescripcion", query = "SELECT c FROM Ciudad c WHERE c.descripcion = :descripcion")})
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "descripcion", unique = true, nullable = false, length = 50)
    String descripcion;

    public Ciudad() {
    }

    public Ciudad(String descripcion) {
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
