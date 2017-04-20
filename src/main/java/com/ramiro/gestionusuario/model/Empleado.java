/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author Ramiro Ferreira
 */
@Entity(name = "Empleado")
@Table(name = "empleado")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Empleado extends Persona implements Serializable {

    @Column(name = "APODO", length = 15)
    private String apodo;
    @Column(name = "EMAIL", length = 50)
    private String email;
    @Column(name = "NRO_CELULAR", length = 50)
    private String nroCelular;
    @Column(name = "NRO_TELEFONO", length = 50)
    private String nroTelefono;
    @Column(name = "DIRECCION", length = 150)
    private String direccion;
    @Transient
    private String password;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "FECHA_INGRESO")
    private Date fechaIngreso;
    @Transient
    private Rol rol;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rol> roles;
    @Column(name = "OBSERVACION", length = 150)
    private String observacion;

    public Empleado() {
        this.roles = new ArrayList<>();
    }

    public Empleado(String apodo, String email, String nroCelular, String nroTelefono, String direccion, String password, Date fechaIngreso, Rol rol, List<Rol> roles, String observacion, String nombre, String apellido, Date fechaNacimiento, int cedula, Genero sexo, Ciudad ciudad, Pais pais, EstadoCivil estadoCivil) {
        super(nombre, apellido, fechaNacimiento, cedula, sexo, ciudad, pais, estadoCivil);
        this.apodo = apodo;
        this.email = email;
        this.nroCelular = nroCelular;
        this.nroTelefono = nroTelefono;
        this.direccion = direccion;
        this.password = password;
        this.fechaIngreso = fechaIngreso;
        this.rol = rol;
        this.roles = roles;
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNroCelular() {
        return nroCelular;
    }

    public void setNroCelular(String nroCelular) {
        this.nroCelular = nroCelular;
    }

    public String getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(String nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public void agregarRol(Rol rol) {
        this.roles.add(rol);
    }

    public void quitarRol(Rol rol) {
        this.roles.remove(rol);
    }
}
