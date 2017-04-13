package com.mycompany.gestionusuario;

import com.mycompany.gestionusuario.model.Ciudad;
import com.mycompany.gestionusuario.model.EntityHandler.AddPersonQuery;
import com.mycompany.gestionusuario.model.EntityHandler.EntityManagerHandler;
import com.mycompany.gestionusuario.model.EstadoCivil;
import com.mycompany.gestionusuario.model.Genero;
import com.mycompany.gestionusuario.model.Pais;
import com.mycompany.gestionusuario.model.Persona;
import com.mycompany.gestionusuario.model.Rol;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        cargarBD();
        AddPersonQuery addPersonQuery = new AddPersonQuery();

        List<Ciudad> ciudadList = addPersonQuery.getAllCiudad();
        ciudadList.stream().forEach((ciudadList1) -> {
            System.out.println(ciudadList1.toString());
        });
    }

    public static void cargarBD() {
        AddPersonQuery addPersonQuery = new AddPersonQuery();

        Ciudad ciudad1 = new Ciudad("SIN ASIGNAR");
        Ciudad ciudad2 = new Ciudad("ASUNCION");
        Ciudad ciudad3 = new Ciudad("LAMBARE");
        Ciudad ciudad4 = new Ciudad("SAN LORENZO");
        addPersonQuery.insertCiudad(ciudad1);
        addPersonQuery.insertCiudad(ciudad2);
        addPersonQuery.insertCiudad(ciudad3);
        addPersonQuery.insertCiudad(ciudad4);

        Pais pais1 = new Pais("SIN ASIGNAR");
        Pais pais2 = new Pais("ARGENTINA");
        Pais pais3 = new Pais("PARAGUAY");
        addPersonQuery.insertPais(pais1);
        addPersonQuery.insertPais(pais2);
        addPersonQuery.insertPais(pais3);

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

        Persona persona = new Persona();
        persona.setNombre("Ramiro");
        persona.setApellido("Ferreira");
        persona.setCedula(6344586);
        persona.setCiudad(ciudad1);
        persona.setPais(pais1);
        persona.setEstadoCivil(estadoCivil1);
        persona.setSexo(genero2);

        addPersonQuery.insertPersona(persona);
    }
}
