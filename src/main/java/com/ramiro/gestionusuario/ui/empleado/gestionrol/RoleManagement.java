/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.ui.empleado.gestionrol;

import com.ramiro.gestionusuario.callback.CreateRoleCallback;
import com.ramiro.gestionusuario.model.Rol;
import com.ramiro.gestionusuario.service.RoleMagamentService;
import com.ramiro.gestionusuario.serviceImpl.RoleManagmentServiceImpl;
import com.ramiro.gestionusuario.tableModel.RolTableModel;
import com.ramiro.gestionusuario.tableModel.RoleAccessTableModel;
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
public class RoleManagement extends JDialog implements ActionListener, MouseListener, CreateRoleCallback {

    private JPanel jpRoles, jpPermisos;
    private JScrollPane jspRoles, jspPermisos;
    public JTable jtRoles, jtPermisos;
    public JButton jbCrearRol, jbModificarRol, jbEliminarRol;
    private RoleMagamentService service;
    private RolTableModel roleTableModel;
    private RoleAccessTableModel roleAccessTableModel;

    public RoleManagement(JFrame frame) {
        super(frame);
        constructWindow(frame);
        iniciarlizarVista();
        agregarListeners();
        initializeLogic();
        loadData();

    }

    public RoleManagement(JDialog dialog) {
        super(dialog);
        constructWindow(dialog);
        iniciarlizarVista();
        agregarListeners();
        initializeLogic();
        loadData();
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
        this.jbModificarRol.setEnabled(false);
        this.jbEliminarRol.setEnabled(false);

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
    }

    public void mostrarVista() {
        this.setVisible(true);
    }

    private void mostrarPermisos() {
        int idRol = (int) this.jtRoles.getValueAt(jtRoles.getSelectedRow(), 0);
        this.roleAccessTableModel.setMenuItemList(service.getAllMenuItemByIdRole(idRol));
        this.jtPermisos.setModel(roleAccessTableModel);
        this.roleAccessTableModel.updateTable();
        PackColumn.packColumns(this.jtPermisos, 1);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object e = ae.getSource();
        if (e.equals(this.jbCrearRol)) {
            createRoleForm();
        } else if (e.equals(this.jbModificarRol)) {
            updateRoleForm();
        } else if (e.equals(this.jbEliminarRol)) {
            deleteRol();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int fila = this.jtRoles.rowAtPoint(me.getPoint());
        int columna = this.jtRoles.columnAtPoint(me.getPoint());
        mostrarPermisos();
        if ((fila > -1) && (columna > -1)) {
            this.jbModificarRol.setEnabled(true);
            this.jbEliminarRol.setEnabled(true);
        } else {
            this.jbModificarRol.setEnabled(false);
            this.jbEliminarRol.setEnabled(false);
        }
        if (me.getClickCount() == 2) {
            /*if (idRol == 1) {
             JOptionPane.showMessageDialog(this, "El rol administrador no puede ser modificado.", "Atención", JOptionPane.INFORMATION_MESSAGE);
             } else {
             Modificar_rol modificar_rol = new Modificar_rol(this, idRol);
             modificar_rol.mostrarVista();
             inicializarVista();
             }*/
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

    private void initializeLogic() {
        this.service = new RoleManagmentServiceImpl();
        this.roleTableModel = new RolTableModel();
        this.roleAccessTableModel = new RoleAccessTableModel();
    }

    private void loadData() {
        this.roleTableModel.setRolList(this.service.getAllRoles());
        this.jtRoles.setModel(roleTableModel);
        this.roleTableModel.updateTable();
    }

    private void createRoleForm() {
        CreateRole createRole = new CreateRole(this);
        createRole.setCreateRoleCallback(this);
        createRole.mostrarVista();
    }

    private void updateRoleForm() {
        int row = this.jtRoles.getSelectedRow();
        if (row > -1) {
            int idRol = (int) this.jtRoles.getValueAt(row, 0);
            Rol rol = service.getRoleById(idRol);
            UpdateRole updateRole = new UpdateRole(this, rol);
            updateRole.setCreateRoleCallback(this);
            updateRole.mostrarVista();
        }
    }

    @Override
    public void roleCreated() {
        loadData();
    }

    private void deleteRol() {
        int idRol = (Integer) this.jtRoles.getValueAt(this.jtRoles.getSelectedRow(), 0);
        if (service.isInUseRole(idRol)) {
            JOptionPane.showMessageDialog(this, "Rol en uso", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            service.deleteRole(idRol);
            loadData();
        }
    }
}
