/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.ui.empleado;

import com.ramiro.gestionusuario.util.CreateEmployUIConstants;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Ramiro Ferreira
 */
public class CreateUpdateEmploy extends javax.swing.JDialog {

    private javax.swing.JPanel jpNorth;
    private javax.swing.JScrollPane jspObservacion;
    public javax.swing.JButton jbAceptar, jbAgregarRol, jbCancelar, jbQuitarRol;
    public javax.swing.JComboBox jcbCiudad, jcbEstadoCivil, jcbGenero, jcbNacionalidad;
    public javax.swing.JLabel jlAlias, jlApellido, jlCedulaIdentidad, jlCiudad, jlEstadoCivil,
            jlFechaNacimiento, jlGenero, jlNacionalidad, jlNombre,
            jlNroCelular, jlNroTelefono, jlPassword, jlRepetirPassword, jlFechaIngreso, jlCorreoElectronico, jlDireccion;
    public javax.swing.JPanel jpDatosEmpresariales, jpSouth, jpDatosPersonales1, jpRol, jpDatosPersonales2;
    public javax.swing.JPasswordField jpassword1, jpassword2;
    public javax.swing.JTextArea jtaObservacion;
    public javax.swing.JFormattedTextField jftCedulaIdentidad;
    public javax.swing.JTextField jtfAlias, jtfApellido, jtfCorreoElectronico,
            jtfDireccion, jtfNombre, jtfNroCelular, jtfNroTelefono;
    public JDateChooser dccFechaNacimiento, dccFechaIngreso;
    public javax.swing.JTabbedPane jtpCenter;
    public JTable jtRolesSeleccionados, jtRolesDisponibles;

    public CreateUpdateEmploy(JFrame frame) {
        super(frame, true);
        constructWindow(frame);
        initializeUIComponents();
        constructLayout(frame);
    }

    private void constructWindow(JFrame frame) {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(CreateEmployUIConstants.TITLE);
        setAlwaysOnTop(false);
        setName(CreateEmployUIConstants.NAME);
        setPreferredSize(new java.awt.Dimension(CreateEmployUIConstants.WIDTH, CreateEmployUIConstants.HEIGHT));
        setResizable(false);
    }

    private void initializeUIComponents() {
        initPanelDatosPersonales1();
        initPanelDatosPersonales2();
        initPanelDatosEmpresariales();
        initPaneRol();
        initPaneNorth();
        initPanelSouth();
        jtpCenter = new JTabbedPane();
        jtpCenter.add(CreateEmployUIConstants.GENERAL_DATA, jpDatosPersonales1);
        jtpCenter.add(CreateEmployUIConstants.PERSONAL_DATA, jpDatosPersonales2);
        jtpCenter.add(CreateEmployUIConstants.CORP_DATA, jpDatosEmpresariales);
        jtpCenter.add(CreateEmployUIConstants.ROL_DATA, jpRol);
    }

    private void initPanelDatosPersonales1() {
        //Panel
        jpDatosPersonales1 = new javax.swing.JPanel(new java.awt.GridLayout(7, 4));
        int swingConstant = javax.swing.SwingConstants.CENTER;
        //Labels, textfields, combobox
        jlNombre = new javax.swing.JLabel(CreateEmployUIConstants.NAME_FIELD);
        jlNombre.setHorizontalAlignment(swingConstant);
        jtfNombre = new javax.swing.JTextField();
        jlApellido = new javax.swing.JLabel(CreateEmployUIConstants.LAST_NAME_FIELD);
        jtfApellido = new javax.swing.JTextField();
        jlApellido.setHorizontalAlignment(swingConstant);
        jlFechaNacimiento = new javax.swing.JLabel(CreateEmployUIConstants.BIRTH_DATE_FIELD);
        jlFechaNacimiento.setHorizontalAlignment(swingConstant);
        dccFechaNacimiento = new JDateChooser();
        dccFechaNacimiento.setDateFormatString("dd/MM/yyyy");
        jlCedulaIdentidad = new javax.swing.JLabel(CreateEmployUIConstants.PIN_FIELD);
        jlCedulaIdentidad.setHorizontalAlignment(swingConstant);
        jftCedulaIdentidad = new javax.swing.JFormattedTextField();
        jlNacionalidad = new javax.swing.JLabel(CreateEmployUIConstants.NATIONALITY_FIELD);
        jlNacionalidad.setHorizontalAlignment(swingConstant);
        jcbNacionalidad = new javax.swing.JComboBox();
        jlCiudad = new javax.swing.JLabel(CreateEmployUIConstants.CITY_FIELD);
        jlCiudad.setHorizontalAlignment(swingConstant);
        jcbCiudad = new javax.swing.JComboBox();
        jlGenero = new javax.swing.JLabel(CreateEmployUIConstants.GENDER_FIELD);
        jlGenero.setHorizontalAlignment(swingConstant);
        jcbGenero = new javax.swing.JComboBox();
        jlEstadoCivil = new javax.swing.JLabel(CreateEmployUIConstants.CIVIL_STATE_FIELD);
        jlEstadoCivil.setHorizontalAlignment(swingConstant);
        jcbEstadoCivil = new javax.swing.JComboBox();

        jpDatosPersonales1.add(jlNombre);
        jpDatosPersonales1.add(jtfNombre);
        jpDatosPersonales1.add(jlApellido);
        jpDatosPersonales1.add(jtfApellido);
        jpDatosPersonales1.add(new Component() {
        });
        jpDatosPersonales1.add(new Component() {
        });
        jpDatosPersonales1.add(new Component() {
        });
        jpDatosPersonales1.add(new Component() {
        });
        jpDatosPersonales1.add(jlFechaNacimiento);
        jpDatosPersonales1.add(dccFechaNacimiento);
        jpDatosPersonales1.add(jlCedulaIdentidad);
        jpDatosPersonales1.add(jftCedulaIdentidad);
        jpDatosPersonales1.add(new Component() {
        });
        jpDatosPersonales1.add(new Component() {
        });
        jpDatosPersonales1.add(new Component() {
        });
        jpDatosPersonales1.add(new Component() {
        });
        jpDatosPersonales1.add(jlNacionalidad);
        jpDatosPersonales1.add(jcbNacionalidad);
        jpDatosPersonales1.add(jlCiudad);
        jpDatosPersonales1.add(jcbCiudad);
        jpDatosPersonales1.add(new Component() {
        });
        jpDatosPersonales1.add(new Component() {
        });
        jpDatosPersonales1.add(new Component() {
        });
        jpDatosPersonales1.add(new Component() {
        });
        jpDatosPersonales1.add(jlGenero);
        jpDatosPersonales1.add(jcbGenero);
        jpDatosPersonales1.add(jlEstadoCivil);
        jpDatosPersonales1.add(jcbEstadoCivil);
    }

    private void initPanelDatosPersonales2() {
        //Panel
        //Labels, Textfields & textarea
        jlNroTelefono = new javax.swing.JLabel(CreateEmployUIConstants.PHONE_FIELD);
        jtfNroTelefono = new javax.swing.JTextField();
        jlNroCelular = new javax.swing.JLabel(CreateEmployUIConstants.CELLPHONE_FIELD);
        jtfNroCelular = new javax.swing.JTextField();
        jtaObservacion = new javax.swing.JTextArea();
        jspObservacion = new javax.swing.JScrollPane(jtaObservacion);
        jspObservacion.setBorder(javax.swing.BorderFactory.createTitledBorder(CreateEmployUIConstants.OBSERVATION_FIELD));
        jlDireccion = new javax.swing.JLabel(CreateEmployUIConstants.ADRESS_FIELD);
        jtfDireccion = new javax.swing.JTextField();
        //Adding components into panel
        jpDatosPersonales2 = new javax.swing.JPanel(new GridLayout(2, 1));
        JPanel aux1 = new JPanel(new MigLayout("insets 5 5 0 5", "[100.00][grow]", "[][][]"));
        aux1.add(jlDireccion, "cell 0 0, alignx center");
        aux1.add(jtfDireccion, "cell 1 0, growx");
        aux1.add(jlNroTelefono, "cell 0 1, alignx center");
        aux1.add(jtfNroTelefono, "cell 1 1, growx");
        aux1.add(jlNroCelular, "cell 0 2, alignx center");
        aux1.add(jtfNroCelular, "cell 1 2, growx, wrap");
        jpDatosPersonales2.add(aux1);
        jpDatosPersonales2.add(jspObservacion);
    }

    private void initPanelDatosEmpresariales() {
        //Panel
        jpDatosEmpresariales = new javax.swing.JPanel(new java.awt.GridLayout(8, 4));
        int swingConstant = javax.swing.SwingConstants.CENTER;
        //Labels, textfields, buttons, combobox, list & passwordfields
        jlAlias = new javax.swing.JLabel();
        jlAlias.setHorizontalAlignment(swingConstant);
        jlAlias.setText(CreateEmployUIConstants.ALIAS_FIELD);
        jtfAlias = new javax.swing.JTextField();
        jlFechaIngreso = new javax.swing.JLabel();
        jlFechaIngreso.setHorizontalAlignment(swingConstant);
        jlFechaIngreso.setText(CreateEmployUIConstants.ENTER_DATE_FIELD);
        dccFechaIngreso = new JDateChooser();
        dccFechaIngreso.setDateFormatString("dd/MM/yyyy");
        jlPassword = new javax.swing.JLabel();
        jlPassword.setHorizontalAlignment(swingConstant);
        jlPassword.setText(CreateEmployUIConstants.PASSWORD_FIELD);
        jpassword1 = new javax.swing.JPasswordField();
        jlRepetirPassword = new javax.swing.JLabel();
        jlRepetirPassword.setHorizontalAlignment(swingConstant);
        jlRepetirPassword.setText(CreateEmployUIConstants.REPEAT_PASSWORD_FIELD);
        jpassword2 = new javax.swing.JPasswordField();
        jlCorreoElectronico = new javax.swing.JLabel();
        jlCorreoElectronico.setHorizontalAlignment(swingConstant);
        jlCorreoElectronico.setText(CreateEmployUIConstants.EMAIL_FIELD);
        jtfCorreoElectronico = new javax.swing.JTextField();
        jpDatosEmpresariales.add(jlAlias);
        jpDatosEmpresariales.add(jtfAlias);
        jpDatosEmpresariales.add(new Component() {
        });
        jpDatosEmpresariales.add(new Component() {
        });
        jpDatosEmpresariales.add(new Component() {
        });
        jpDatosEmpresariales.add(new Component() {
        });

        jpDatosEmpresariales.add(jlFechaIngreso);
        jpDatosEmpresariales.add(dccFechaIngreso);
        jpDatosEmpresariales.add(jlPassword);
        jpDatosEmpresariales.add(jpassword1);
        jpDatosEmpresariales.add(new Component() {
        });
        jpDatosEmpresariales.add(new Component() {
        });
        jpDatosEmpresariales.add(new Component() {
        });
        jpDatosEmpresariales.add(new Component() {
        });

        jpDatosEmpresariales.add(jlCorreoElectronico);
        jpDatosEmpresariales.add(jtfCorreoElectronico);
        jpDatosEmpresariales.add(jlRepetirPassword);
        jpDatosEmpresariales.add(jpassword2);
        jpDatosEmpresariales.add(new Component() {
        });
        jpDatosEmpresariales.add(new Component() {
        });
        jpDatosEmpresariales.add(new Component() {
        });
        jpDatosEmpresariales.add(new Component() {
        });

        jpDatosEmpresariales.add(new Component() {
        });
        jpDatosEmpresariales.add(new Component() {
        });
        jpDatosEmpresariales.add(new Component() {
        });
        jpDatosEmpresariales.add(new Component() {
        });
        jpDatosEmpresariales.add(new Component() {
        });
        jpDatosEmpresariales.add(new Component() {
        });

    }

    private void initPaneNorth() {
        jpNorth = new javax.swing.JPanel(new MigLayout("center"));
        jpNorth.add(new JLabel(CreateEmployUIConstants.INFO1), "wrap");
        jpNorth.add(new JLabel(CreateEmployUIConstants.INFO2));
    }

    private void initPaneRol() {
        //Panel
        jpRol = new javax.swing.JPanel(new java.awt.GridLayout(1, 2));
        jbAgregarRol = new javax.swing.JButton(CreateEmployUIConstants.ADD_BTN);
        jbQuitarRol = new javax.swing.JButton(CreateEmployUIConstants.REMOVE_BTN);

        jtRolesSeleccionados = new JTable();
        jtRolesSeleccionados.getTableHeader().setReorderingAllowed(false);
        jtRolesDisponibles = new JTable();
        jtRolesDisponibles.getTableHeader().setReorderingAllowed(false);
        JScrollPane jspRolesSeleccionados = new JScrollPane(jtRolesSeleccionados);
        jspRolesSeleccionados.setBorder(javax.swing.BorderFactory.createTitledBorder(CreateEmployUIConstants.SELECTED_ROL_SUBTITLE));
        JScrollPane jspRolesDisponibles = new JScrollPane(jtRolesDisponibles);
        jspRolesDisponibles.setBorder(javax.swing.BorderFactory.createTitledBorder(CreateEmployUIConstants.AVAILVABLE_ROL_SUBTITLE));

        javax.swing.JPanel left = new javax.swing.JPanel(new java.awt.BorderLayout());
        javax.swing.JPanel right = new javax.swing.JPanel(new java.awt.BorderLayout());
        left.add(jspRolesDisponibles, BorderLayout.CENTER);
        left.add(jbAgregarRol, BorderLayout.SOUTH);
        right.add(jspRolesSeleccionados, BorderLayout.CENTER);
        right.add(jbQuitarRol, BorderLayout.SOUTH);

        jpRol.add(left);
        jpRol.add(right);
    }

    private void initPanelSouth() {
        jpSouth = new javax.swing.JPanel();
        jpSouth.setBorder(new javax.swing.border.EtchedBorder());
        jbAceptar = new javax.swing.JButton(CreateEmployUIConstants.ACEPT_BTN);
        jbCancelar = new javax.swing.JButton(CreateEmployUIConstants.CANCEL_BTN);
        jpSouth.add(jbAceptar);
        jpSouth.add(jbCancelar);
    }

    private void constructLayout(JFrame frame) {
        getContentPane().add(jpNorth, java.awt.BorderLayout.NORTH);
        getContentPane().add(jtpCenter, java.awt.BorderLayout.CENTER);
        getContentPane().add(jpSouth, java.awt.BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(frame);
    }
}
