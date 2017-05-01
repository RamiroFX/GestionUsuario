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
public class CreateRole extends JDialog implements ActionListener, MouseListener {

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

    public CreateRole(JDialog dialog) {
        super(dialog, CreateRoleConstants.TITLE, DEFAULT_MODALITY_TYPE);
        setName(CreateRoleConstants.NAME);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(CreateRoleConstants.WINDOW_WIDTH, CreateRoleConstants.WINDOW_HEIGHT);
        setLocationRelativeTo(dialog);
        inicializarComponentes();
        addListeners();
        initializeLogic();
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

    /**
     * Establece el tamaño, posicion y visibilidad de la
     */
    public void mostrarVista() {
        this.setVisible(true);
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

    /**
     * Agrega valores a los componentes.
     */
    private void initializeLogic() {
        this.service = new CreateRoleServiceImpl();
        this.selectedRoleAccessTableModel = new RoleAccessTableModel();
        this.menuItemList = new ArrayList<>();
        this.selectedRoleAccessTableModel.setMenuItemList(menuItemList);
        this.selectedRoleAccessTableModel.updateTable();
        this.roleAccessTableModel = new RoleAccessTableModel();
        this.roleAccessTableModel.setMenuItemList(this.service.getAllMenuItem());
        this.jtPermisosDisponibles.setModel(this.roleAccessTableModel);
        this.roleAccessTableModel.updateTable();
        PackColumn.packColumns(this.jtPermisosDisponibles, 1);
    }

    private void crearRol() {
        String nombreRol = this.jtfNombreRol.getText().toUpperCase();
        if (this.service.existRole(nombreRol)) {
            JOptionPane.showMessageDialog(this, "Rol existente", "Atención", JOptionPane.WARNING_MESSAGE);
        } else {
            Rol rol = new Rol(nombreRol);
            if (Validator.validar(rol, this)) {
                rol.setMenuItems(menuItemList);
                if (rol.getMenuItems().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Seleccione al menos un Acceso", "Atención", JOptionPane.WARNING_MESSAGE);
                } else {
                    service.createRole(rol);
                    JOptionPane.showMessageDialog(this, "Rol creado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    createRoleCallback.roleCreated();
                    cerrar();
                }
            }
        }
    }

    private void agregarAcceso() {
        int fila = this.jtPermisosDisponibles.getSelectedRow();
        if (fila > -1) {
            Long idMenuItem = (Long) this.jtPermisosDisponibles.getValueAt(fila, 0);
            for (MenuItem menuItemList1 : menuItemList) {
                if (Objects.equals(menuItemList1.getIdMenuItem(), idMenuItem)) {
                    JOptionPane.showMessageDialog(this, "Acceso ya seleccionado", "Atención", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            MenuItem menuItem = service.getMenuItemById(idMenuItem);
            this.menuItemList.add(menuItem);
            this.jtPermisosSeleccionados.setModel(selectedRoleAccessTableModel);
            this.selectedRoleAccessTableModel.updateTable();
            PackColumn.packColumns(this.jtPermisosSeleccionados, 1);
        }
        this.jbAgregar.setEnabled(false);
        this.jbQuitar.setEnabled(false);
    }

    private void quitarAcceso() {
        int fila = this.jtPermisosSeleccionados.getSelectedRow();
        if (fila > -1) {
            this.menuItemList.remove(fila);
            this.jtPermisosSeleccionados.setModel(selectedRoleAccessTableModel);
            this.selectedRoleAccessTableModel.updateTable();
            PackColumn.packColumns(this.jtPermisosSeleccionados, 1);
        }
        this.jbAgregar.setEnabled(false);
        this.jbQuitar.setEnabled(false);
    }

    public void setCreateRoleCallback(CreateRoleCallback createRoleCallback) {
        this.createRoleCallback = createRoleCallback;
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
