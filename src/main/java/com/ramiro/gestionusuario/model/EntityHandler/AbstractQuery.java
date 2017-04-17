/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.model.EntityHandler;

/**
 *
 * @author Ramiro
 */
public class AbstractQuery {

    public void open() {
        EntityManagerHandler.INSTANCE.open();
    }

    public void shutdown() {
        EntityManagerHandler.INSTANCE.shutdown();
    }
}
