/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author Ramiro Ferreira
 */
@Entity(name = "Rol")
@Table(name = "rol")
@NamedQueries({
    @NamedQuery(name = "rol.getAllRolByIds", query = "SELECT r FROM Rol r WHERE r.idRol IN :id"),
    @NamedQuery(name = "rol.getAllRoles", query = "SELECT r FROM Rol r")})
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idRol;
    @Column(name = "descripcion")
    String descripcion;
    @Version
    @Column(name = "LAST_UPDATED_TIME")
    private Date updatedTime;
    @ManyToMany(mappedBy = "roles")
    private List<Empleado> empleados;

    public Rol() {
    }

    public Rol(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int id) {
        this.idRol = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return getDescripcion();
    }
}
