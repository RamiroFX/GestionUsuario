/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionusuario.model;

import java.util.Date;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Ramiro Ferreira
 */
@MappedSuperclass
public class Persona {

    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private int cedula;
    private Genero sexo;
    private Ciudad ciudad;
    private Pais pais;
    private EstadoCivil estadoCivil;
}
