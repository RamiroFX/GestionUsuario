/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramirogestionusuario.validator;

import com.ramiro.gestionusuario.model.Pais;
import java.awt.Component;
import javax.validation.ConstraintViolation;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramiro
 */
public class Validator {

    public static final String ATENTION_TITLE = "Atención";

    public Validator() {
    }

    public static boolean validar(Object entity, Component parent) {
        Set<ConstraintViolation<Object>> constraintViolation3 = ValidatorFactoryHandler.INSTANCE.getValidator().validate(entity);
        if (!constraintViolation3.isEmpty()) {
            String mensaje = "";
            for (final ConstraintViolation<Object> violation : constraintViolation3) {
                mensaje = mensaje + "\t" + violation.getPropertyPath() + ": " + violation.getMessage();
            }
            JOptionPane.showMessageDialog(parent, mensaje, ATENTION_TITLE, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}
