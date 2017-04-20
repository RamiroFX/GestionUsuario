/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramirogestionusuario.validator;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author Ramiro Ferreira
 */
public enum ValidatorFactoryHandler {

    INSTANCE;
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public ValidatorFactory getFactory() {
        return factory;
    }

    public Validator getValidator() {
        return validator;
    }
}
