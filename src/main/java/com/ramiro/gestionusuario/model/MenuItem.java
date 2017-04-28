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
import javax.persistence.JoinColumn;
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
    @NamedQuery(name = "menuItem.getAllMenuItemByIdRole", query = "SELECT m FROM MenuItem m WHERE")})
public class MenuItem implements Serializable {

    private static long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMenuItem;
    @Column(name = "descripcion", unique = true, nullable = false, length = 50)
    String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_menu")
    private Menu menu;

    public MenuItem() {
    }

    public Long getIdMenuItem() {
        return idMenuItem;
    }

    public void setIdMenuItem(Long idMenuItem) {
        this.idMenuItem = idMenuItem;
    }
}
