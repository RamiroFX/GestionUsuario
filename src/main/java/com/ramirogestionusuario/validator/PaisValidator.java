/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramirogestionusuario.validator;

import com.ramiro.gestionusuario.model.Pais;
import static java.lang.System.out;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import java.util.Set;

/**
 * Demonstrate use of Hibernate Validator.
 */
/**
 *
 * @author Ramiro
 */
public class PaisValidator {

    private final Validator validator;

    public PaisValidator() {
        final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public void demonstrateValidator() {
        Pais pais = new Pais("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Set<ConstraintViolation<Pais>> nullMfgViolations = validator.validate(pais);
        printConstraintViolationsToStandardOutput("Maximo permitido", nullMfgViolations);

        Pais pais2 = new Pais();
        Set<ConstraintViolation<Pais>> nullMfgViolations2 = validator.validate(pais2);
        printConstraintViolationsToStandardOutput("Campo vacío", nullMfgViolations2);
    }

    private <T> void printConstraintViolationsToStandardOutput(
            final String title,
            final Set<ConstraintViolation<T>> violations) {
        out.println(title);
        for (final ConstraintViolation<T> violation : violations) {
            out.println("\t" + violation.getPropertyPath() + " " + violation.getMessage());
        }
    }

    public static void main(final String[] arguments) {
        final PaisValidator instance = new PaisValidator();
        instance.demonstrateValidator();
    }
}
