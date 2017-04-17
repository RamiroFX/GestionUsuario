/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Ramiro Ferreira
 */
@Entity(name = "Persona")
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona implements Serializable {

    private static long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String nombre;
    private String apellido;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "cedula", unique = true, nullable = false, length = 15)
    private int cedula;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_sexo", nullable = false, updatable = false)
    private Genero sexo;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_ciudad", nullable = false, updatable = false)
    private Ciudad ciudad;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pais", nullable = false, updatable = false)
    private Pais pais;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_estadoCivil", nullable = false, updatable = false)
    private EstadoCivil estadoCivil;

    public Persona() {
    }

    public Persona(String nombre, String apellido, Date fechaNacimiento, int cedula, Genero sexo, Ciudad ciudad, Pais pais, EstadoCivil estadoCivil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.pais = pais;
        this.estadoCivil = estadoCivil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public Genero getSexo() {
        return sexo;
    }

    public void setSexo(Genero sexo) {
        this.sexo = sexo;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public static void setSerialVersionUID(long SerialVersionUID) {
        Persona.SerialVersionUID = SerialVersionUID;
    }

}
