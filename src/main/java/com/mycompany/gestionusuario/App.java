package com.mycompany.gestionusuario;

import com.mycompany.gestionusuario.model.Ciudad;
import com.mycompany.gestionusuario.model.EntityHandler.AddPersonQuery;
import com.mycompany.gestionusuario.model.EntityHandler.EntityManagerHandler;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        AddPersonQuery addPersonQuery = new AddPersonQuery();

        Ciudad ciudad = new Ciudad();
        ciudad.setDescripcion("Sin asignar");

        addPersonQuery.insertCiudad(ciudad);
    }
}
