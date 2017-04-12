package com.mycompany.gestionusuario;

import com.mycompany.gestionusuario.model.Ciudad;
import com.mycompany.gestionusuario.model.EntityHandler.AddPersonQuery;
import com.mycompany.gestionusuario.model.EntityHandler.EntityManagerHandler;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        AddPersonQuery addPersonQuery = new AddPersonQuery();

        Ciudad ciudad1 = new Ciudad("SIN ASIGNAR");
        Ciudad ciudad2 = new Ciudad("ASUNCION");
        Ciudad ciudad3 = new Ciudad("LAMBARE");
        Ciudad ciudad4 = new Ciudad("SAN LORENZO");

        addPersonQuery.insertCiudad(ciudad1);
        addPersonQuery.insertCiudad(ciudad2);
        addPersonQuery.insertCiudad(ciudad3);
        addPersonQuery.insertCiudad(ciudad4);

        List<Ciudad> ciudadList = addPersonQuery.getAllCiudad();
        for (Ciudad ciudadList1 : ciudadList) {
            System.out.println(ciudadList1.toString());
        }
    }
}
