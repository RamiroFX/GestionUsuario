/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.ui.empleado.gestionrol;

import com.ramiro.gestionusuario.model.MenuItem;
import com.ramiro.gestionusuario.model.Rol;
import com.ramiro.gestionusuario.serviceImpl.CreateRoleServiceImpl;
import com.ramiro.gestionusuario.tableModel.RoleAccessTableModel;
import com.ramiro.gestionusuario.util.PackColumn;
import com.ramirogestionusuario.validator.Validator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramiro Ferreira
 */
public class CreateRole extends CreateUpdateRole implements ActionListener, MouseListener {

    public CreateRole(JDialog dialog) {
        super(dialog);
        initializeLogic();
        addListeners();
    }

    /**
     * Establece el tamaño, posicion y visibilidad de la
     */
    public void mostrarVista() {
        this.setVisible(true);
    }

    /**
     * Agrega valores a los componentes.
     */
    private void initializeLogic() {
        this.setService(new CreateRoleServiceImpl());
        this.setSelectedRoleAccessTableModel(new RoleAccessTableModel());
        this.setMenuItemList(new ArrayList<MenuItem>());
        this.getSelectedRoleAccessTableModel().setMenuItemList(getMenuItemList());
        this.getSelectedRoleAccessTableModel().updateTable();
        this.setRoleAccessTableModel(new RoleAccessTableModel());
        this.getRoleAccessTableModel().setMenuItemList(this.getService().getAllMenuItem());
        this.jtPermisosDisponibles.setModel(this.getRoleAccessTableModel());
        this.getRoleAccessTableModel().updateTable();
        PackColumn.packColumns(this.jtPermisosDisponibles, 1);
    }

    private void crearRol() {
        String nombreRol = this.jtfNombreRol.getText().toUpperCase().trim();
        if (nombreRol.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Inserte un nombre de Rol", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (this.getService().existRole(nombreRol)) {
            JOptionPane.showMessageDialog(this, "Rol existente", "Atención", JOptionPane.WARNING_MESSAGE);
        } else {
            Rol rol = new Rol(nombreRol);
            if (Validator.validar(rol, this)) {
                rol.setMenuItems(getMenuItemList());
                if (rol.getMenuItems().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Seleccione al menos un Acceso", "Atención", JOptionPane.WARNING_MESSAGE);
                } else {
                    getService().createRole(rol);
                    JOptionPane.showMessageDialog(this, "Rol creado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    getCreateRoleCallback().roleCreated();
                    this.cerrar();
                }
            }
        }
    }

    private void agregarAcceso() {
        int fila = this.jtPermisosDisponibles.getSelectedRow();
        if (fila > -1) {
            Long idMenuItem = (Long) this.jtPermisosDisponibles.getValueAt(fila, 0);
            for (MenuItem menuItemList1 : getMenuItemList()) {
                if (Objects.equals(menuItemList1.getIdMenuItem(), idMenuItem)) {
                    JOptionPane.showMessageDialog(this, "Acceso ya seleccionado", "Atención", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            MenuItem menuItem = getService().getMenuItemById(idMenuItem);
            this.getMenuItemList().add(menuItem);
            this.jtPermisosSeleccionados.setModel(getSelectedRoleAccessTableModel());
            this.getSelectedRoleAccessTableModel().updateTable();
            PackColumn.packColumns(this.jtPermisosSeleccionados, 1);
        }
        this.jbAgregar.setEnabled(false);
        this.jbQuitar.setEnabled(false);
    }

    private void quitarAcceso() {
        int fila = this.jtPermisosSeleccionados.getSelectedRow();
        if (fila > -1) {
            this.getMenuItemList().remove(fila);
            this.jtPermisosSeleccionados.setModel(getSelectedRoleAccessTableModel());
            this.getSelectedRoleAccessTableModel().updateTable();
            PackColumn.packColumns(this.jtPermisosSeleccionados, 1);
        }
        this.jbAgregar.setEnabled(false);
        this.jbQuitar.setEnabled(false);
    }

    /**
     * Elimina la
     */
    private void cerrar() {
        this.dispose();
        System.runFinalization();
    }

    /**
     * Agrega ActionListeners los controles.
     */
    private void addListeners() {
        this.jbAceptar.addActionListener(this);
        this.jbAgregar.addActionListener(this);
        this.jbCancelar.addActionListener(this);
        this.jbQuitar.addActionListener(this);
        this.jtPermisosDisponibles.addMouseListener(this);
        this.jtPermisosSeleccionados.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.jbCancelar)) {
            cerrar();
        }
        if (e.getSource().equals(this.jbAceptar)) {
            crearRol();
        }
        if (e.getSource().equals(this.jbAgregar)) {
            agregarAcceso();
        }
        if (e.getSource().equals(this.jbQuitar)) {
            quitarAcceso();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(this.jtPermisosDisponibles)) {
            int fila = this.jtPermisosDisponibles.rowAtPoint(e.getPoint());
            int columna = this.jtPermisosDisponibles.columnAtPoint(e.getPoint());
            if ((fila > -1) && (columna > -1)) {
                this.jbAgregar.setEnabled(true);
            } else {
                this.jbAgregar.setEnabled(false);
            }
            if (e.getClickCount() == 2) {
                agregarAcceso();
                this.jbAgregar.setEnabled(false);
                this.jbQuitar.setEnabled(false);
            }
        }
        if (e.getSource().equals(this.jtPermisosSeleccionados)) {
            int fila = this.jtPermisosSeleccionados.rowAtPoint(e.getPoint());
            int columna = this.jtPermisosSeleccionados.columnAtPoint(e.getPoint());
            if ((fila > -1) && (columna > -1)) {
                this.jbQuitar.setEnabled(true);
            } else {
                this.jbQuitar.setEnabled(false);
            }
            if (e.getClickCount() == 2) {
                quitarAcceso();
                this.jbAgregar.setEnabled(false);
                this.jbQuitar.setEnabled(false);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
