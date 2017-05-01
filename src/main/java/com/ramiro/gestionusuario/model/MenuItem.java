/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.model;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ramiro Ferreira
 */
@Entity(name = "MenuItem")
@Table(name = "menu_item")
@NamedQueries({
    @NamedQuery(name = "menuItem.getMenuItemById", query = "SELECT m FROM MenuItem m WHERE m.idMenuItem = :idMenuItem"),
    @NamedQuery(name = "menuItem.getAllMenuItemByIdRole", query = "SELECT m FROM MenuItem m JOIN m.roles mr WHERE mr.idRol = :idRol"),
    @NamedQuery(name = "menuItem.getAllMenuItem", query = "SELECT m FROM MenuItem m")})
public class MenuItem implements Serializable {

    private static long SerialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public static void setSerialVersionUID(long aSerialVersionUID) {
        SerialVersionUID = aSerialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_menu_item")
    private Long idMenuItem;
    @Column(name = "descripcion", unique = true, nullable = false, length = 50)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_menu")
    private Menu menu;

    @ManyToMany(mappedBy = "menuItems")
    private List<Rol> roles;

    public MenuItem() {
    }

    public MenuItem(String descripcion) {
        this.descripcion = descripcion;
    }

    public MenuItem(String descripcion, Menu menu) {
        this.descripcion = descripcion;
        this.menu = menu;
    }

    public Long getIdMenuItem() {
        return idMenuItem;
    }

    public void setIdMenuItem(Long idMenuItem) {
        this.idMenuItem = idMenuItem;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public void addRole(Rol role) {
        this.roles.add(role);
    }

    public void removeRole(Rol role) {
        this.roles.remove(role);
    }

}
