/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.ui.empleado.gestionrol;

import com.ramiro.gestionusuario.util.GestionRolConstants;
import com.ramiro.gestionusuario.util.PackColumn;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ramiro Ferreira
 */
public class GestionRol extends JDialog implements ActionListener, MouseListener {

    private JPanel jpRoles, jpPermisos;
    private JScrollPane jspRoles, jspPermisos;
    public JTable jtRoles, jtPermisos;
    public JButton jbCrearRol, jbModificarRol, jbEliminarRol;

    public GestionRol(JFrame frame) {
        super(frame);
        constructWindow(frame);
        iniciarlizarVista();
    }

    public GestionRol(JDialog dialog) {
        super(dialog);
        constructWindow(dialog);
        iniciarlizarVista();
    }

    private void constructWindow(Component frameOwner) {
        setTitle(GestionRolConstants.TITLE);
        setName(GestionRolConstants.NAME);
        setSize(600, 400);
        setLocationRelativeTo(frameOwner);
    }

    private void iniciarlizarVista() {
        this.jbCrearRol = new JButton(GestionRolConstants.CREATE_ROL);
        this.jbModificarRol = new JButton(GestionRolConstants.UPDATE_ROL);
        this.jbEliminarRol = new JButton(GestionRolConstants.DELETE_ROL);

        this.jtRoles = new JTable();
        this.jtRoles.getTableHeader().setReorderingAllowed(false);
        this.jtPermisos = new JTable();
        this.jtPermisos.getTableHeader().setReorderingAllowed(false);
        this.jspRoles = new JScrollPane(jtRoles);
        this.jspPermisos = new JScrollPane(jtPermisos);

        this.jpRoles = new JPanel(new BorderLayout());
        this.jpRoles.setBorder(new TitledBorder(GestionRolConstants.SUB_TITLE));
        this.jpPermisos = new JPanel(new BorderLayout());
        this.jpPermisos.setBorder(new TitledBorder(GestionRolConstants.SUB_TITLE2));

        this.jpRoles.add(jspRoles);
        this.jpPermisos.add(jspPermisos);

        JPanel jpBotones = new JPanel();
        jpBotones.add(this.jbCrearRol);
        jpBotones.add(this.jbModificarRol);
        jpBotones.add(this.jbEliminarRol);

        JPanel jpTablas = new JPanel(new GridLayout(1, 2));
        jpTablas.add(this.jpRoles);
        jpTablas.add(this.jpPermisos);
        getContentPane().add(jpTablas, BorderLayout.CENTER);
        getContentPane().add(jpBotones, BorderLayout.SOUTH);
    }

    private void agregarListeners() {
        this.jbCrearRol.addActionListener(this);
        this.jbModificarRol.addActionListener(this);
        this.jbEliminarRol.addActionListener(this);
        this.jtRoles.addMouseListener(this);
    }

    private void inicializarVista() {
        this.jbModificarRol.setEnabled(false);
        this.jbEliminarRol.setEnabled(false);
        //this.jtRoles.setModel(this.modelo.consultarRoles(""));
    }

    public void mostrarVista() {
        this.setVisible(true);
    }

    private void mostrarPermisos(int idRol) {
        //this.jtPermisos.setModel(this.modelo.consultarPermisos(idRol));
        PackColumn.packColumns(this.jtPermisos, 1);
    }

    private void eliminarRol() {
        int idRol = Integer.valueOf(String.valueOf(this.jtRoles.getValueAt(this.jtRoles.getSelectedRow(), 0)));
        //this.modelo.eliminarRol(idRol);
        inicializarVista();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object e = ae.getSource();
        if (e.equals(this.jbCrearRol)) {
            /*Crear_rol crear_rol = new Crear_rol(this.);
             crear_rol.mostrarVista();
             inicializarVista();*/
        } else if (e.equals(
                this.jbModificarRol)) {
            int idRol = (Integer.valueOf((String) this.jtRoles.getValueAt(this.jtRoles.getSelectedRow(), 0)));
            if (idRol == 1) {
                JOptionPane.showMessageDialog(this, "El rol administrador no puede ser modificado.", "Atención", JOptionPane.INFORMATION_MESSAGE);
            } else {
                /*Modificar_rol modificar_rol = new Modificar_rol(this, idRol);
                 modificar_rol.mostrarVista();
                 inicializarVista();*/
            }
        } else if (e.equals(this.jbEliminarRol)) {
            int idRol = (Integer.valueOf((String) this.jtRoles.getValueAt(this.jtRoles.getSelectedRow(), 0)));
            if (idRol == 1) {
                JOptionPane.showMessageDialog(this, "El rol administrador no puede ser eliminado.", "Atención", JOptionPane.INFORMATION_MESSAGE);
            } else {
                eliminarRol();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int fila = this.jtRoles.rowAtPoint(me.getPoint());
        int columna = this.jtRoles.columnAtPoint(me.getPoint());
        int idRol = (Integer.valueOf((String) this.jtRoles.getValueAt(fila, 0)));
        mostrarPermisos(idRol);
        if ((fila > -1) && (columna > -1)) {
            this.jbModificarRol.setEnabled(true);
            this.jbEliminarRol.setEnabled(true);
        } else {
            this.jbModificarRol.setEnabled(false);
            this.jbEliminarRol.setEnabled(false);
        }
        if (me.getClickCount() == 2) {
            if (idRol == 1) {
                JOptionPane.showMessageDialog(this, "El rol administrador no puede ser modificado.", "Atención", JOptionPane.INFORMATION_MESSAGE);
            } else {
                /*Modificar_rol modificar_rol = new Modificar_rol(this, idRol);
                 modificar_rol.mostrarVista();
                 inicializarVista();*/
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
