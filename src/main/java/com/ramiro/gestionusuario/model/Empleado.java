/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.model;

import com.ramiro.gestionusuario.util.EmployValidationConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 *
 * @author Ramiro Ferreira
 */
@Entity(name = "Empleado")
@Table(name = "empleado")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@NamedQueries({
    @NamedQuery(name = "empleado.getEmpleadoByApodo", query = "SELECT e FROM Empleado e WHERE e.apodo = :apodo"),
    @NamedQuery(name = "empleado.getEmpleadoByEmail", query = "SELECT e FROM Empleado e WHERE e.email = :email"),
    @NamedQuery(name = "empleado.getEmpleadoByCedula", query = "SELECT e FROM Empleado e WHERE e.cedula = :cedula"),
    @NamedQuery(name = "empleado.getEmpleadoByIdRol", query = "SELECT e FROM Empleado e JOIN e.roles er  WHERE er.idRol = :idRol"),
    @NamedQuery(name = "empleado.getEmpleadoByNombreApellido", query = "SELECT e FROM Empleado e WHERE LOWER(e.nombre) LIKE :criteria OR LOWER(e.apellido) LIKE :criteria")
})
public class Empleado extends Persona implements Serializable {

    @Column(name = "APODO", unique = true, length = 15)
    @Size(max = 15, message = EmployValidationConstants.ALIAS_SIZE)
    private String apodo;
    @Column(name = "EMAIL", unique = true, length = 50)
    @Size(max = 50, message = EmployValidationConstants.SIZE_50)
    private String email;
    @Column(name = "NRO_CELULAR", length = 50)
    @Size(max = 50, message = EmployValidationConstants.SIZE_50)
    private String nroCelular;
    @Column(name = "NRO_TELEFONO", length = 50)
    @Size(max = 50, message = EmployValidationConstants.SIZE_50)
    private String nroTelefono;
    @Column(name = "DIRECCION", length = 150)
    @Size(max = 150, message = EmployValidationConstants.SIZE_150)
    private String direccion;
    @Column(name = "PASSWORD")
    private String password;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "FECHA_INGRESO")
    private Date fechaIngreso;
    @Transient
    private Rol rol;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "EMPLEADO_ROL",
            joinColumns =
            @JoinColumn(name = "id_persona"),
            inverseJoinColumns =
            @JoinColumn(name = "id_rol"))
    private List<Rol> roles;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_empleado_estado", nullable = false)
    private EmpleadoEstado empleadoEstado;
    @Column(name = "OBSERVACION", length = 150)
    @Size(max = 150, message = EmployValidationConstants.SIZE_50)
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

    public void setEmpleadoEstado(EmpleadoEstado empleadoEstado) {
        this.empleadoEstado = empleadoEstado;
    }

    public EmpleadoEstado getEmpleadoEstado() {
        return empleadoEstado;
    }

    @Override
    public String toString() {
        return getApodo() + " " + getNombre() + " " + getApellido();
    }
}
