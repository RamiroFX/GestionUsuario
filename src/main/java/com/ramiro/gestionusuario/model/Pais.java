/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.model;

import com.ramiro.gestionusuario.util.PaisValidationConstants;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ramiro Ferreira
 */
@Entity(name = "Pais")
@Table(name = "pais")
@NamedQueries({
    @NamedQuery(name = "pais.getAll", query = "SELECT p FROM Pais p"),
    @NamedQuery(name = "pais.getPaisById", query = "SELECT p FROM Pais p WHERE p.id = :id"),
    @NamedQuery(name = "pais.getPaisByDescripcion", query = "SELECT p FROM Pais p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "pais.getAllPerson", query = "SELECT p.personas FROM Pais p WHERE p.descripcion = :descripcion")})
public class Pais implements Serializable {

    @Id
    @GeneratedValue
    int id;
    @Column(name = "descripcion", unique = true, nullable = false, length = 50)
    @NotNull(message = PaisValidationConstants.NOT_NULL)
    @Size(max = 50, message = PaisValidationConstants.SIZE)
    String descripcion;
    @OneToMany(mappedBy = "pais")
    List<Persona> personas;

    public Pais() {
    }

    public Pais(String descripcion) {
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

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    @Override
    public String toString() {
        return getDescripcion();
    }
}
