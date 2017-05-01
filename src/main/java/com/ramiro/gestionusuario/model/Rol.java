/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.model;

import com.ramiro.gestionusuario.util.ParamValidationConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ramiro Ferreira
 */
@Entity(name = "Rol")
@Table(name = "rol")
@NamedQueries({
    @NamedQuery(name = "rol.getAllRolByIds", query = "SELECT r FROM Rol r WHERE r.idRol IN :id"),
    @NamedQuery(name = "rol.getAllRoles", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "rol.getRolByDescripcion", query = "SELECT r FROM Rol r WHERE r.descripcion = :descripcion")})
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idRol;
    @Column(name = "descripcion", unique = true, length = 50, nullable = false)
    @NotNull(message = ParamValidationConstants.NOT_NULL)
    @Size(max = 50, message = ParamValidationConstants.SIZE)
    String descripcion;
    @Version
    @Column(name = "LAST_UPDATED_TIME")
    private Date updatedTime;
    @ManyToMany(mappedBy = "roles")
    private List<Empleado> empleados;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ROL_MENUITEM",
            joinColumns
            = @JoinColumn(name = "id_rol"),
            inverseJoinColumns
            = @JoinColumn(name = "id_menu_item"))
    private List<MenuItem> menuItems;

    public Rol() {
        this.empleados = new ArrayList<>();
        this.menuItems = new ArrayList<>();
    }

    public Rol(String descripcion) {
        this();
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

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    public void removeMenuItem(MenuItem menuItem) {
        this.menuItems.remove(menuItem);
    }

    @Override
    public String toString() {
        return getDescripcion();
    }
}
