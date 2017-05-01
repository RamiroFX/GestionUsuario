package com.ramiro.gestionusuario;

import com.ramiro.gestionusuario.model.Ciudad;
import com.ramiro.gestionusuario.model.Empleado;
import com.ramiro.gestionusuario.model.EmpleadoEstado;
import com.ramiro.gestionusuario.model.EntityHandler.EmployParamQueryHandler;
import com.ramiro.gestionusuario.model.EntityHandler.RoleManagmentQueryHandler;
import com.ramiro.gestionusuario.model.EntityHandler.RoleQueryHandler;
import com.ramiro.gestionusuario.model.EstadoCivil;
import com.ramiro.gestionusuario.model.Genero;
import com.ramiro.gestionusuario.model.Menu;
import com.ramiro.gestionusuario.model.MenuItem;
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
        EmployParamQueryHandler addPersonQuery = new EmployParamQueryHandler();
        List<Ciudad> ciudadList = addPersonQuery.getAllCities();
        for (Ciudad ciudad : ciudadList) {
            System.out.println(ciudad.toString());
        }
    }

    public static void cargarBD() {
        EmployParamQueryHandler employParamQuery = new EmployParamQueryHandler();

        Ciudad ciudad1 = new Ciudad("SIN ASIGNAR");
        Ciudad ciudad2 = new Ciudad("ASUNCION");
        Ciudad ciudad3 = new Ciudad("LAMBARE");
        Ciudad ciudad4 = new Ciudad("SAN LORENZO");
        employParamQuery.insertCity(ciudad1);
        employParamQuery.insertCity(ciudad2);
        employParamQuery.insertCity(ciudad3);
        employParamQuery.insertCity(ciudad4);

        Pais paisSinAsignar = new Pais("SIN ASIGNAR");
        Pais paisArgentina = new Pais("ARGENTINA");
        Pais paisParaguay = new Pais("PARAGUAY");
        employParamQuery.insertCountry(paisSinAsignar);
        employParamQuery.insertCountry(paisArgentina);
        employParamQuery.insertCountry(paisParaguay);

        EstadoCivil estadoCivil1 = new EstadoCivil("SIN ASIGNAR");
        EstadoCivil estadoCivil2 = new EstadoCivil("SOLTERO/A");
        EstadoCivil estadoCivil3 = new EstadoCivil("CASADO/A");
        employParamQuery.insertEstadoCivil(estadoCivil1);
        employParamQuery.insertEstadoCivil(estadoCivil2);
        employParamQuery.insertEstadoCivil(estadoCivil3);

        Genero genero1 = new Genero("SIN ASIGNAR");
        Genero genero2 = new Genero("MASCULINO");
        Genero genero3 = new Genero("FEMENINO");
        employParamQuery.insertSexo(genero1);
        employParamQuery.insertSexo(genero2);
        employParamQuery.insertSexo(genero3);

        Rol rolAdministrador = new Rol("ADMINISTRADOR");
        Rol rolVentas = new Rol("VENTAS");
        Rol rolCompras = new Rol("COMPRAS");
        RoleQueryHandler queryHandler = new RoleQueryHandler();
        queryHandler.insertRol(rolAdministrador);
        queryHandler.insertRol(rolVentas);
        queryHandler.insertRol(rolCompras);
        ArrayList<Rol> roles = new ArrayList<>();
        roles.add(rolAdministrador);
        roles.add(rolVentas);
        roles.add(rolCompras);

        EmpleadoEstado empleadoEstadoActivo = new EmpleadoEstado("ACTIVO");
        EmpleadoEstado empleadoEstadoInactivo = new EmpleadoEstado("INACTIVO");
        employParamQuery.insertEmployStatus(empleadoEstadoActivo);
        employParamQuery.insertEmployStatus(empleadoEstadoInactivo);

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
        employ.setPassword("rnfc");
        employ.setNroCelular("0984 330261");
        employ.setNroTelefono("021 420377");
        employ.setApodo("rnfc");
        employ.setEmail("mr.ramiro@hotmail.com");
        employ.setDireccion("Tte. Prieto 1011 c/ Testanova");
        employ.setEmpleadoEstado(empleadoEstadoActivo);
        employ.setObservacion("Sin observaciones");

        employParamQuery.insertEmpleado(employ);

        RoleManagmentQueryHandler roleQueryHandler = new RoleManagmentQueryHandler();
        Menu gestionEmpleadoMenu = new Menu("Gestion Empleado");
        MenuItem crearEmpleado = new MenuItem("Crear empleado", gestionEmpleadoMenu);
        MenuItem modificarEmpleado = new MenuItem("Modificar empleado", gestionEmpleadoMenu);
        MenuItem eliminarEmpleado = new MenuItem("Cambiar estado empleado", gestionEmpleadoMenu);
        MenuItem buscarEmpleado = new MenuItem("Buscar empleado", gestionEmpleadoMenu);
        MenuItem cambiarPasswordEmpleado = new MenuItem("Cambiar password empleado", gestionEmpleadoMenu);
        MenuItem gestionRol = new MenuItem("Gestion rol", gestionEmpleadoMenu);

        roleQueryHandler.insertMenu(gestionEmpleadoMenu);
        roleQueryHandler.insertMenuItem(crearEmpleado);
        roleQueryHandler.insertMenuItem(modificarEmpleado);
        roleQueryHandler.insertMenuItem(eliminarEmpleado);
        roleQueryHandler.insertMenuItem(buscarEmpleado);
        roleQueryHandler.insertMenuItem(cambiarPasswordEmpleado);
        roleQueryHandler.insertMenuItem(gestionRol);

        roleQueryHandler.addMenuItemIntoRole(rolCompras, crearEmpleado);
    }

}
