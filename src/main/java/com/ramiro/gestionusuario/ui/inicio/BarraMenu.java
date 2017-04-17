package com.ramiro.gestionusuario.ui.inicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Ramiro Ferreira
 */
public class BarraMenu extends JMenuBar implements ActionListener {

    public JMenu jmInicio, jmAyuda, jmHerramientas;
    public JMenuItem jmiCerrar, jmiAcerca, jmiPersonalizar;
    private App frame;

    public BarraMenu(App frame) {
        this.frame = frame;
        initializeVariables();
        this.add(jmInicio);
        this.add(jmHerramientas);
        //this.add(jmAyuda);
    }

    private void initializeVariables() {
        initializeJmInicio();
        initializeJmHerramientas();
        initializeJmAyuda();
    }

    private void initializeJmInicio() {
        jmInicio = new JMenu("Inicio");
        /*jmiMenuPrincipal = new JMenuItem("Menu principal");
         jmiMenuPrincipal.setEnabled(false);
         jmiLogIn = new JMenuItem("LogIn");
         jmiLogIn.setEnabled(false);
         jmiLogOut= new JMenuItem("LogOut");
         jmiLogOut.setEnabled(false);*/
        jmiCerrar = new JMenuItem("Cerrar");
        jmiCerrar.addActionListener(this);
        /*jmInicio.add(jmiMenuPrincipal);
         jmInicio.add(jmiLogOut);
         jmInicio.add(jmiLogIn);*/
        jmInicio.add(jmiCerrar);

    }

    private void initializeJmHerramientas() {
        jmHerramientas = new JMenu("Herramientas");
        jmiPersonalizar = new JMenuItem("Personalizar");
        jmiPersonalizar.addActionListener(this);
        jmHerramientas.add(jmiPersonalizar);
    }

    private void initializeJmAyuda() {
        jmAyuda = new JMenu("Ayuda");
        jmiAcerca = new JMenuItem("Acerca de..");
        jmAyuda.add(jmiAcerca);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(jmiCerrar)) {
            System.exit(0);
        } else if (src.equals(jmiPersonalizar)) {
            new PreferenceForm(frame).setVisible(true);
        }
    }
}
