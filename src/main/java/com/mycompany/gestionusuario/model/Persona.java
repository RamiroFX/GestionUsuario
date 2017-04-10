/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionusuario.model;

import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

/**
 *
 * @author Ramiro Ferreira
 */
@MappedSuperclass
public class Persona {

    private String nombre;
    private String apellido;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;
    private int cedula;
    @Embedded
    private Genero sexo;
    @Embedded
    private Ciudad ciudad;
    @Embedded
    private Pais pais;
    @Embedded
    private EstadoCivil estadoCivil;
}
