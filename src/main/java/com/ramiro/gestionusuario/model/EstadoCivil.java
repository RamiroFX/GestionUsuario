/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ramiro Ferreira
 */
@Entity(name = "EstadoCivil")
@Table(name = "estado_civil")
public class EstadoCivil implements Serializable {

    @Id
    @GeneratedValue
    int idEstadoCivil;
    @Column(name = "descripcion", unique = true, nullable = false, length = 50)
    String descripcion;

    public EstadoCivil() {
    }

    public EstadoCivil(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(int idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
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
