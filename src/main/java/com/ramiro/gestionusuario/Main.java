package com.ramiro.gestionusuario;

import com.ramiro.gestionusuario.model.Ciudad;
import com.ramiro.gestionusuario.model.Empleado;
import com.ramiro.gestionusuario.model.EntityHandler.EmpleadoQuery;
import com.ramiro.gestionusuario.model.EstadoCivil;
import com.ramiro.gestionusuario.model.Genero;
import com.ramiro.gestionusuario.model.Pais;
import com.ramiro.gestionusuario.model.Rol;
import com.ramiro.gestionusuario.ui.empleado.GestionEmpleado;
import com.ramiro.gestionusuario.ui.inicio.App;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Hello world!
 *
 */
public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        test();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                App app = new App();
                GestionEmpleado ges = new GestionEmpleado(app);
                app.agregarVentana(ges);

            }
        });
    }

    public static void test() {
        cargarBD();
        EmpleadoQuery addPersonQuery = new EmpleadoQuery();
        List<Ciudad> ciudadList = addPersonQuery.getAllCities();
        for (Ciudad ciudad : ciudadList) {
            System.out.println(ciudad.toString());
        }
    }

    public static void cargarBD() {
        EmpleadoQuery addPersonQuery = new EmpleadoQuery();

        Ciudad ciudad1 = new Ciudad("SIN ASIGNAR");
        Ciudad ciudad2 = new Ciudad("ASUNCION");
        Ciudad ciudad3 = new Ciudad("LAMBARE");
        Ciudad ciudad4 = new Ciudad("SAN LORENZO");
        addPersonQuery.insertCity(ciudad1);
        addPersonQuery.insertCity(ciudad2);
        addPersonQuery.insertCity(ciudad3);
        addPersonQuery.insertCity(ciudad4);

        Pais paisSinAsignar = new Pais("SIN ASIGNAR");
        Pais paisArgentina = new Pais("ARGENTINA");
        Pais paisParaguay = new Pais("PARAGUAY");
        addPersonQuery.insertCountry(paisSinAsignar);
        addPersonQuery.insertCountry(paisArgentina);
        addPersonQuery.insertCountry(paisParaguay);

        EstadoCivil estadoCivil1 = new EstadoCivil("SIN ASIGNAR");
        EstadoCivil estadoCivil2 = new EstadoCivil("SOLTERO/A");
        EstadoCivil estadoCivil3 = new EstadoCivil("CASADO/A");
        addPersonQuery.insertEstadoCivil(estadoCivil1);
        addPersonQuery.insertEstadoCivil(estadoCivil2);
        addPersonQuery.insertEstadoCivil(estadoCivil3);

        Genero genero1 = new Genero("SIN ASIGNAR");
        Genero genero2 = new Genero("MASCULINO");
        Genero genero3 = new Genero("FEMENINO");
        addPersonQuery.insertSexo(genero1);
        addPersonQuery.insertSexo(genero2);
        addPersonQuery.insertSexo(genero3);

        Rol rol1 = new Rol("ADMINISTRADOR");
        Rol rol2 = new Rol("VENTAS");
        Rol rol3 = new Rol("COMPRAS");
        addPersonQuery.insertRol(rol1);
        addPersonQuery.insertRol(rol2);
        addPersonQuery.insertRol(rol3);
        ArrayList<Rol> roles = new ArrayList<>();
        roles.add(rol1);
        roles.add(rol2);
        roles.add(rol3);

        /*Persona persona = new Persona();
         persona.setNombre("Ramiro");
         persona.setApellido("Ferreira");
         persona.setCedula(6344586);
         persona.setCiudad(ciudad1);
         persona.setPais(pais1);
         persona.setEstadoCivil(estadoCivil1);
         persona.setSexo(genero2);

         addPersonQuery.insertPersona(persona);*/
        Empleado employ = new Empleado();
        employ.setNombre("Ramiro");
        employ.setApellido("Ferreira");
        employ.setCedula(6344586);
        employ.setCiudad(ciudad1);
        employ.setPais(paisArgentina);
        employ.setEstadoCivil(estadoCivil1);
        employ.setSexo(genero2);
        employ.setFechaNacimiento(new GregorianCalendar.Builder().setDate(1991, 02, 29).build().getTime());
        employ.setFechaIngreso(Date.from(Instant.now()));
        employ.setRoles(roles);
        employ.setNroCelular("0984 330261");
        employ.setNroTelefono("021 420377");
        employ.setApodo("rnfc");
        employ.setEmail("mr.ramiro@hotmail.com");
        employ.setDireccion("Tte. Prieto 1011 c/ Testanova");
        employ.setObservacion("Sin observaciones");

        addPersonQuery.insertEmpleado(employ);
    }
}
