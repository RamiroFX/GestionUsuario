/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.ui.empleado.gestionrol;

import com.ramiro.gestionusuario.callback.CreateRoleCallback;
import com.ramiro.gestionusuario.model.MenuItem;
import com.ramiro.gestionusuario.model.Rol;
import com.ramiro.gestionusuario.service.CreateRoleService;
import com.ramiro.gestionusuario.serviceImpl.CreateRoleServiceImpl;
import com.ramiro.gestionusuario.tableModel.RoleAccessTableModel;
import com.ramiro.gestionusuario.util.CreateRoleConstants;
import com.ramiro.gestionusuario.util.PackColumn;
import com.ramirogestionusuario.validator.Validator;
import java.awt.BorderLayout;
import static java.awt.Dialog.DEFAULT_MODALITY_TYPE;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ramiro Ferreira
 */
public class CreateUpdateRole extends JDialog {

    private JLabel jlNombreRol;
    public JTextField jtfNombreRol;
    private JPanel jpPermisosSeleccionados, jpPermisosDisponibles;
    private JScrollPane jspPermisosSeleccionados, jspPermisosDisponibles;
    public JTable jtPermisosSeleccionados, jtPermisosDisponibles;
    public JButton jbQuitar, jbAgregar, jbAceptar, jbCancelar;
    //LOGIC
    private CreateRoleService service;
    private RoleAccessTableModel roleAccessTableModel, selectedRoleAccessTableModel;
    private List<MenuItem> menuItemList;
    private CreateRoleCallback createRoleCallback;

    public CreateUpdateRole(JDialog dialog) {
        super(dialog, CreateRoleConstants.TITLE, DEFAULT_MODALITY_TYPE);
        setName(CreateRoleConstants.NAME);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(CreateRoleConstants.WINDOW_WIDTH, CreateRoleConstants.WINDOW_HEIGHT);
        setLocationRelativeTo(dialog);
        inicializarComponentes();
    }

    public CreateRoleService getService() {
        return service;
    }

    public void setService(CreateRoleService service) {
        this.service = service;
    }

    public RoleAccessTableModel getRoleAccessTableModel() {
        return roleAccessTableModel;
    }

    public void setRoleAccessTableModel(RoleAccessTableModel roleAccessTableModel) {
        this.roleAccessTableModel = roleAccessTableModel;
    }

    public RoleAccessTableModel getSelectedRoleAccessTableModel() {
        return selectedRoleAccessTableModel;
    }

    public void setSelectedRoleAccessTableModel(RoleAccessTableModel selectedRoleAccessTableModel) {
        this.selectedRoleAccessTableModel = selectedRoleAccessTableModel;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public CreateRoleCallback getCreateRoleCallback() {
        return createRoleCallback;
    }

    public void setCreateRoleCallback(CreateRoleCallback createRoleCallback) {
        this.createRoleCallback = createRoleCallback;
    }

    private void inicializarComponentes() {
        jlNombreRol = new JLabel(CreateRoleConstants.JL_ROLE_NAME);
        jtfNombreRol = new JTextField();
        jpPermisosSeleccionados = new JPanel(new BorderLayout());
        jpPermisosSeleccionados.setBorder(new TitledBorder(CreateRoleConstants.SUBTITLE1));
        jpPermisosDisponibles = new JPanel(new BorderLayout());
        jpPermisosDisponibles.setBorder(new TitledBorder(CreateRoleConstants.SUBTITLE2));
        jtPermisosSeleccionados = new JTable();
        jtPermisosSeleccionados.getTableHeader().setReorderingAllowed(false);
        jtPermisosDisponibles = new JTable();
        jtPermisosDisponibles.getTableHeader().setReorderingAllowed(false);
        jspPermisosSeleccionados = new JScrollPane(jtPermisosSeleccionados);
        jspPermisosDisponibles = new JScrollPane(jtPermisosDisponibles);
        jbQuitar = new JButton(CreateRoleConstants.JB_REMOVE);
        jbAgregar = new JButton(CreateRoleConstants.JB_ADD);
        jbAceptar = new JButton(CreateRoleConstants.JB_ACCEPT);
        jbCancelar = new JButton(CreateRoleConstants.JB_CANCEL);
        this.jbAgregar.setEnabled(false);
        this.jbQuitar.setEnabled(false);

        JPanel jpSouth = new JPanel();
        jpSouth.add(jbAceptar);
        jpSouth.add(jbCancelar);

        jpPermisosDisponibles.add(jspPermisosDisponibles, BorderLayout.CENTER);
        jpPermisosDisponibles.add(jbAgregar, BorderLayout.SOUTH);
        jpPermisosSeleccionados.add(jspPermisosSeleccionados, BorderLayout.CENTER);
        jpPermisosSeleccionados.add(jbQuitar, BorderLayout.SOUTH);

        JPanel jpCenter = new JPanel(new GridLayout(1, 2));
        jpCenter.add(jpPermisosSeleccionados);
        jpCenter.add(jpPermisosDisponibles);

        JPanel jpNorth = new JPanel(new BorderLayout());
        jpNorth.add(jlNombreRol, BorderLayout.WEST);
        jpNorth.add(jtfNombreRol, BorderLayout.CENTER);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jpNorth, BorderLayout.NORTH);
        getContentPane().add(jpCenter, BorderLayout.CENTER);
        getContentPane().add(jpSouth, BorderLayout.SOUTH);
    }

}
