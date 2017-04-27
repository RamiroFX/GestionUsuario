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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ramiro Ferreira
 */
@Entity(name = "EmpleadoEstado")
@Table(name = "empleado_estado")
@NamedQueries({
    @NamedQuery(name = "empleadoEstado.getEmpleadoEstadoACTIVO", query = "SELECT ee FROM EmpleadoEstado ee WHERE ee.descripcion = :activo"),
    @NamedQuery(name = "empleadoEstado.getAllEmpleadoEstados", query = "SELECT ee FROM EmpleadoEstado ee")})
public class EmpleadoEstado implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_empleado_estado")
    int idEmpleadoEstado;
    @Column(name = "descripcion", unique = true, nullable = false, length = 50)
    String descripcion;

    public EmpleadoEstado() {
    }

    public EmpleadoEstado(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdEmpleadoEstado() {
        return idEmpleadoEstado;
    }

    public void setIdEmpleadoEstado(int idEmpleadoEstado) {
        this.idEmpleadoEstado = idEmpleadoEstado;
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
