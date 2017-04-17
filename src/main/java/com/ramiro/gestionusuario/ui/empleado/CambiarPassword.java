/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.ui.empleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Ramiro
 */
public class CambiarPassword extends JDialog implements ActionListener {

    JLabel jlPasswordActual, jlPasswordNuevo1, jlPasswordNuevo2;
    JPasswordField jpfPasswordActual, jpfPasswordNuevo1, jpfPasswordNuevo2;
    JButton jbAceptar, jbCancelar;

    public CambiarPassword(JFrame frame, int idFuncionario) {
        super(frame, "Cambiar contraseña", DEFAULT_MODALITY_TYPE);
        setName("Cambiar contraseña");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 200);
        inicializarComponentes();
        setLocationRelativeTo(frame);
        agregarListeners();
    }

    /**
     * Elimina la vista.
     */
    private void cerrar() {
        this.dispose();
        System.runFinalization();
    }

    /**
     * Agrega ActionListeners los controles.
     */
    private void agregarListeners() {
        this.jbAceptar.addActionListener(this);
        this.jbCancelar.addActionListener(this);
    }

    /**
     * Agrega valores a los componentes.
     */
    private void inicializarComponentes() {
        this.jlPasswordActual = new JLabel("Contraseña actual");
        this.jlPasswordNuevo1 = new JLabel("Nueva contraseña");
        this.jlPasswordNuevo2 = new JLabel("Repetir nueva contraseña");
        this.jpfPasswordActual = new JPasswordField();
        this.jpfPasswordActual.setEchoChar('*');
        this.jpfPasswordNuevo1 = new JPasswordField();
        this.jpfPasswordNuevo1.setEchoChar('*');
        this.jpfPasswordNuevo2 = new JPasswordField();
        this.jpfPasswordNuevo2.setEchoChar('*');
        this.jbAceptar = new JButton("Aceptar");
        this.jbCancelar = new JButton("Cancelar");
        JPanel jpBotones = new JPanel();
        jpBotones.add(jbAceptar);
        jpBotones.add(jbCancelar);
        getContentPane().setLayout(new MigLayout());
        getContentPane().add(jlPasswordActual);
        getContentPane().add(jpfPasswordActual, "pushx, grow, wrap");
        getContentPane().add(jlPasswordNuevo1);
        getContentPane().add(jpfPasswordNuevo1, "pushx, grow,  wrap");
        getContentPane().add(jlPasswordNuevo2);
        getContentPane().add(jpfPasswordNuevo2, "pushx, grow");
        getContentPane().add(jpBotones, "dock south");
    }

    public boolean isPasswordCorrect(char[] charPasswordTemp, char[] charPasswordTemp2) {
        if (charPasswordTemp.length == 0 || charPasswordTemp2.length == 0) {
            return false;
        }
        return Arrays.equals(charPasswordTemp, charPasswordTemp2);
    }

    private void cambiarContraseña() {
        char[] passwordActual = jpfPasswordActual.getPassword();
        String pass = String.copyValueOf(passwordActual);
        //IMPLEMENTAR
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(this.jbAceptar)) {
            cambiarContraseña();
        } else if (source.equals(this.jbCancelar)) {
            cerrar();
        }
    }
}
