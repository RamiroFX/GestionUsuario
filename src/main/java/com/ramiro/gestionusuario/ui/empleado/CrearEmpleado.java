/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.ui.empleado;

import com.ramiro.gestionusuario.model.Ciudad;
import com.ramiro.gestionusuario.model.Empleado;
import com.ramiro.gestionusuario.model.EstadoCivil;
import com.ramiro.gestionusuario.model.Genero;
import com.ramiro.gestionusuario.model.Pais;
import com.ramiro.gestionusuario.model.Rol;
import com.ramiro.gestionusuario.service.EmployService;
import com.ramiro.gestionusuario.serviceImpl.EmployServiceImpl;
import com.ramiro.gestionusuario.tableModel.RolTableModel;
import com.ramiro.gestionusuario.util.CreateEmployUIConstants;
import com.ramirogestionusuario.validator.Validator;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Ramiro Ferreira
 */
public class CrearEmpleado extends javax.swing.JDialog implements ActionListener, KeyListener, MouseListener {

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
    private EmployService servicio;
    private RolTableModel availableRol, selectedRol;
    private List<Rol> selectedRolsList;

    public CrearEmpleado(JFrame frame) {
        super(frame, true);
        constructWindow(frame);
        initializeUIComponents();
        constructLayout(frame);
        initializeLogic();
        initializeData();
        agregarListeners();
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

    private void initializeData() {
        this.jcbNacionalidad.removeAllItems();
        this.jcbCiudad.removeAllItems();
        this.jcbGenero.removeAllItems();
        this.jcbEstadoCivil.removeAllItems();
        List<Pais> paises = servicio.getAllCountries();
        List<Ciudad> ciudades = servicio.getAllCities();
        List<Genero> generos = servicio.getAllGenders();
        List<EstadoCivil> estadosCiviles = servicio.getAllCivilStates();
        List<Rol> roles = servicio.getAllRoles();
        for (Pais pais : paises) {
            this.jcbNacionalidad.addItem(pais);
        }
        for (Ciudad ciudad : ciudades) {
            this.jcbCiudad.addItem(ciudad);
        }
        for (Genero genero : generos) {
            this.jcbGenero.addItem(genero);
        }
        for (EstadoCivil estadoCivil : estadosCiviles) {
            this.jcbEstadoCivil.addItem(estadoCivil);
        }
        this.availableRol.setRolList(roles);
        this.jtRolesDisponibles.setModel(availableRol);
        this.dccFechaIngreso.setDate(Calendar.getInstance().getTime());
        this.jftCedulaIdentidad.setFormatterFactory(
                new javax.swing.text.DefaultFormatterFactory(
                new javax.swing.text.NumberFormatter(
                new java.text.DecimalFormat("#,##0"))));
    }

    private void initializeLogic() {
        servicio = new EmployServiceImpl();
        availableRol = new RolTableModel();
        selectedRolsList = new ArrayList<>();
        selectedRol = new RolTableModel();
    }

    private void agregarListeners() {
        this.jbCancelar.addActionListener(this);
        this.jbAceptar.addActionListener(this);
        this.jbQuitarRol.addActionListener(this);
        this.jbAgregarRol.addActionListener(this);
        this.jftCedulaIdentidad.addKeyListener(this);
        this.jtfNombre.addMouseListener(this);
        this.jtfApellido.addMouseListener(this);
        this.jftCedulaIdentidad.addMouseListener(this);
        this.dccFechaNacimiento.addMouseListener(this);
        this.dccFechaIngreso.addMouseListener(this);
        this.jpassword1.addMouseListener(this);
        this.jpassword2.addMouseListener(this);
        this.jtfAlias.addMouseListener(this);
        this.jtRolesDisponibles.addMouseListener(this);
        this.jtRolesSeleccionados.addMouseListener(this);
    }

    private void CreateEmploy() {
        /*
         * VALIDAR NOMBRE
         */
        String nombre;
        if (this.jtfNombre.getText().isEmpty()) {
            this.jtfNombre.setBackground(Color.red);
            javax.swing.JOptionPane.showMessageDialog(this,
                    "El campo nombre esta vacio",
                    "Parametros incorrectos",
                    javax.swing.JOptionPane.OK_OPTION);
            this.jtpCenter.setSelectedComponent(jpDatosPersonales1);
            return;
        } else {
            if (this.jtfNombre.getText().length() > 30) {
                this.jtfNombre.setBackground(Color.red);
                javax.swing.JOptionPane.showMessageDialog(this,
                        "El campo nombre sobrepasa el limite permitido(30) de caracteres",
                        "Parametros incorrectos",
                        javax.swing.JOptionPane.OK_OPTION);
                this.jtpCenter.setSelectedComponent(jpDatosPersonales1);
                return;
            } else {
                nombre = this.jtfNombre.getText();
            }
        }
        /*
         * VALIDAR APELLIDO
         */
        String apellido;
        if (this.jtfApellido.getText().isEmpty()) {
            this.jtfApellido.setBackground(Color.red);
            javax.swing.JOptionPane.showMessageDialog(this,
                    "El campo apellido esta vacio",
                    "Parametros incorrectos",
                    javax.swing.JOptionPane.OK_OPTION);
            this.jtpCenter.setSelectedComponent(jpDatosPersonales1);
            return;
        } else {
            if (this.jtfApellido.getText().length() > 30) {
                this.jtfApellido.setBackground(Color.red);
                javax.swing.JOptionPane.showMessageDialog(this,
                        "El campo apellido sobrepasa el limite permitido(30) de caracteres",
                        "Parametros incorrectos",
                        javax.swing.JOptionPane.OK_OPTION);
                this.jtpCenter.setSelectedComponent(jpDatosPersonales1);
                return;
            } else {
                apellido = this.jtfApellido.getText();
            }
        }
        String email = this.jtfCorreoElectronico.getText();
        if (email.isEmpty()) {
            email = null;
        }
        String direccion = this.jtfDireccion.getText();
        if (direccion.isEmpty()) {
            direccion = null;
        }
        String observacion = this.jtaObservacion.getText();
        if (observacion.isEmpty()) {
            observacion = null;
        }
        String telefono = this.jtfNroTelefono.getText();
        if (telefono.isEmpty()) {
            telefono = null;
        }
        String celular = this.jtfNroCelular.getText();
        if (celular.isEmpty()) {
            celular = null;
        }
        Date fechaIngreso = this.dccFechaIngreso.getDate();
        /*
         * VALIDAR PIN
         */
        Integer cedula;
        try {
            String LongToString = String.valueOf(this.jftCedulaIdentidad.getValue());
            cedula = Integer.valueOf(LongToString.replace(".", ""));
        } catch (Exception e) {
            this.jftCedulaIdentidad.setBackground(Color.red);
            javax.swing.JOptionPane.showMessageDialog(this, "Coloque un Numero de CI valido",
                    "Parametros incorrectos",
                    javax.swing.JOptionPane.OK_OPTION);
            this.jtpCenter.setSelectedComponent(jpDatosPersonales1);
            return;
        }
        /*
         * VALIDAR FECHA NACIMIENTO
         */
        Date fechaNacimiento;
        try {
            fechaNacimiento = this.dccFechaNacimiento.getDate();
        } catch (Exception e) {
            this.dccFechaNacimiento.setBackground(Color.red);
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Ingrese una fecha valida en el campo Fecha nacimiento",
                    "Parametros incorrectos",
                    javax.swing.JOptionPane.OK_OPTION);
            this.jtpCenter.setSelectedComponent(jpDatosPersonales1);
            return;
        }
        /*
         * VALIDAR ALIAS
         */
        String alias;
        if (this.jtfAlias.getText().isEmpty()) {
            this.jtfAlias.setBackground(Color.red);
            javax.swing.JOptionPane.showMessageDialog(this,
                    "El campo alias esta vacio",
                    "Parametros incorrectos",
                    javax.swing.JOptionPane.OK_OPTION);
            this.jtpCenter.setSelectedComponent(jpDatosEmpresariales);
            return;
        } else {
            if (this.jtfAlias.getText().length() > 30) {
                this.jtfAlias.setBackground(Color.red);
                javax.swing.JOptionPane.showMessageDialog(this,
                        "El campo alias sobrepasa el limite permitido(30) de caracteres",
                        "Parametros incorrectos",
                        javax.swing.JOptionPane.OK_OPTION);
                this.jtpCenter.setSelectedComponent(jpDatosPersonales1);
                return;
            } else {
                alias = this.jtfAlias.getText().toLowerCase();
            }
        }
        /*
         VALIDAR CONTRASEÑA
         */
        if (this.jpassword1.getText().isEmpty()) {
            this.jpassword1.setBackground(Color.red);
            javax.swing.JOptionPane.showMessageDialog(this,
                    "El campo contraseña esta vacio",
                    "Parametros incorrectos",
                    javax.swing.JOptionPane.OK_OPTION);
            this.jtpCenter.setSelectedComponent(jpDatosEmpresariales);
            return;
        } else if (this.jpassword1.getText().length() > 15) {
            this.jpassword1.setBackground(Color.red);
            javax.swing.JOptionPane.showMessageDialog(this,
                    "El campo contraseña sobrepasa el limite permitido(15) de caracteres",
                    "Parametros incorrectos",
                    javax.swing.JOptionPane.OK_OPTION);
            this.jtpCenter.setSelectedComponent(jpDatosEmpresariales);
            return;
        }
        if (this.jpassword2.getText().isEmpty()) {
            this.jpassword2.setBackground(Color.red);
            javax.swing.JOptionPane.showMessageDialog(this,
                    "El campo repetir contraseña esta vacio",
                    "Parametros incorrectos",
                    javax.swing.JOptionPane.OK_OPTION);
            this.jtpCenter.setSelectedComponent(jpDatosEmpresariales);
            return;
        } else if (this.jpassword2.getText().length() > 15) {
            this.jpassword2.setBackground(Color.red);
            javax.swing.JOptionPane.showMessageDialog(this,
                    "El campo repetir contraseña sobrepasa el limite permitido(15) de caracteres",
                    "Parametros incorrectos",
                    javax.swing.JOptionPane.OK_OPTION);
            this.jtpCenter.setSelectedComponent(jpDatosEmpresariales);
            return;
        }
        char[] password1 = jpassword1.getPassword();
        char[] password2 = jpassword2.getPassword();
        if (!Arrays.equals(password1, password2)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        /*
         VALIDAR ROL
         */
        if (this.jtRolesSeleccionados.getRowCount() < 1) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Seleccione por lo menos un rol",
                    "Parametros incorrectos",
                    javax.swing.JOptionPane.OK_OPTION);
            this.jtpCenter.setSelectedComponent(jpRol);
            return;
        }
        boolean isPINInUse = servicio.isPINinUse(cedula);
        boolean isAliasInUse = servicio.isApodoInUse(alias);
        boolean isEmailInUse = servicio.isEmailInUse(email);
        if (isPINInUse) {
            JOptionPane.showMessageDialog(this, "La cedula de identidad seleccionada se encuentra ocupada", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (isEmailInUse) {
            JOptionPane.showMessageDialog(this, "El Correo Electronico seleccionado se encuentra ocupado", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (isAliasInUse) {
            JOptionPane.showMessageDialog(this, "El Alias selecciona se encuentra ocupado", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Empleado funcionario = new Empleado();
        funcionario.setNombre(nombre);
        funcionario.setApellido(apellido);
        funcionario.setCedula(cedula);
        funcionario.setFechaNacimiento(fechaNacimiento);
        funcionario.setApodo(alias);
        funcionario.setPassword(String.copyValueOf(password1));
        funcionario.setNroTelefono(telefono);
        funcionario.setNroCelular(celular);
        funcionario.setFechaIngreso(fechaIngreso);
        funcionario.setEstadoCivil((EstadoCivil) this.jcbEstadoCivil.getSelectedItem());
        funcionario.setObservacion(observacion);
        funcionario.setDireccion(direccion);
        funcionario.setEmail(email);
        funcionario.setCiudad((Ciudad) this.jcbCiudad.getSelectedItem());
        funcionario.setRoles(validateRol());//se establece en el modelo
        funcionario.setSexo((Genero) this.jcbGenero.getSelectedItem());
        funcionario.setPais((Pais) this.jcbNacionalidad.getSelectedItem());
        if (Validator.validar(funcionario, this)) {
            servicio.createEmploy(funcionario);
            JOptionPane.showMessageDialog(this, "Empleado creado", "Exito", JOptionPane.INFORMATION_MESSAGE);
            cerrar();
        }
    }

    private List<Rol> validateRol() {
        List<Integer> idRoles = new ArrayList<>();
        for (Rol rol : selectedRolsList) {
            idRoles.add(rol.getId());
        }
        List<Rol> roles = servicio.getAllRolByIds(idRoles);
        return roles;
    }

    private void validatePIN() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                String valorIngresado = jftCedulaIdentidad.getText().replace(".", "");
                valorIngresado = valorIngresado.replace(",", "");
                Long StringToLong = null;
                try {
                    StringToLong = Long.valueOf(valorIngresado);
                } catch (NumberFormatException numberFormatException) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Ingrese solo numeros",
                            "Parametros incorrectos",
                            javax.swing.JOptionPane.OK_OPTION);
                }
                jftCedulaIdentidad.setValue(StringToLong);
                String valorJFT = jftCedulaIdentidad.getText();
                jftCedulaIdentidad.select(valorJFT.length(), valorJFT.length());
            }
        });
    }

    private void agregarRol() {
        int fila = this.jtRolesDisponibles.getSelectedRow();
        int idRol = (int) this.jtRolesDisponibles.getValueAt(fila, 0);
        for (int i = 0; i < selectedRolsList.size(); i++) {
            if (selectedRolsList.get(i).getId() == idRol) {
                JOptionPane.showMessageDialog(null, "El Rol seleccionado ya se ha encuentra", "Atención", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        String descripcionRol = (String) this.jtRolesDisponibles.getValueAt(fila, 1);
        Rol rol = new Rol(descripcionRol);
        rol.setId(idRol);
        selectedRolsList.add(rol);
        selectedRol.setRolList(selectedRolsList);
        this.jtRolesSeleccionados.setModel(selectedRol);
        selectedRol.updateTable();
        this.jbAgregarRol.setEnabled(false);
        this.jbQuitarRol.setEnabled(false);
    }

    private void quitarRol() {
        int fila = this.jtRolesSeleccionados.getSelectedRow();
        int idRol = (int) this.jtRolesSeleccionados.getValueAt(fila, 0);
        for (int i = 0; i < selectedRolsList.size(); i++) {
            if (selectedRolsList.get(i).getId() == idRol) {
                selectedRolsList.remove(i);
            }
        }
        selectedRol.setRolList(selectedRolsList);
        this.jtRolesSeleccionados.setModel(selectedRol);
        selectedRol.updateTable();
        this.jbAgregarRol.setEnabled(false);
        this.jbQuitarRol.setEnabled(false);
    }

    private void cerrar() {
        this.dispose();
        System.runFinalization();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jbCancelar) {
            cerrar();
        } else if (e.getSource() == this.jbAceptar) {
            CreateEmploy();
        } else if (e.getSource() == this.jbAgregarRol) {
            agregarRol();
        } else if (e.getSource() == this.jbQuitarRol) {
            quitarRol();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.jftCedulaIdentidad.hasFocus()) {
            this.jftCedulaIdentidad.setBackground(Color.white);
        } else if (this.jtfNombre.hasFocus()) {
            this.jtfNombre.setBackground(Color.white);
        } else if (this.jtfApellido.hasFocus()) {
            this.jtfApellido.setBackground(Color.white);
        } else if (this.jtfAlias.hasFocus()) {
            this.jtfAlias.setBackground(Color.white);
        } else if (this.dccFechaIngreso.hasFocus()) {
            this.dccFechaIngreso.setBackground(Color.white);
        } else if (this.dccFechaNacimiento.hasFocus()) {
            this.dccFechaNacimiento.setBackground(Color.white);
        } else if (this.jpassword1.hasFocus()) {
            this.jpassword1.setBackground(Color.white);
        } else if (this.jpassword2.hasFocus()) {
            this.jpassword2.setBackground(Color.white);
        }
        if (e.getSource().equals(this.jtRolesDisponibles)) {
            int fila = this.jtRolesDisponibles.rowAtPoint(e.getPoint());
            int columna = this.jtRolesDisponibles.columnAtPoint(e.getPoint());
            int idRol = (int) this.jtRolesDisponibles.getValueAt(fila, 0);
            String descripcionRol = (String) this.jtRolesDisponibles.getValueAt(fila, 1);
            if ((fila > -1) && (columna > -1)) {
                this.jbAgregarRol.setEnabled(true);
            } else {
                this.jbAgregarRol.setEnabled(false);
            }
            if (e.getClickCount() == 2) {
                this.jbAgregarRol.setEnabled(false);
                this.jbQuitarRol.setEnabled(false);
            }
        }
        if (e.getSource().equals(this.jtRolesSeleccionados)) {
            int fila = this.jtRolesSeleccionados.rowAtPoint(e.getPoint());
            int columna = this.jtRolesSeleccionados.columnAtPoint(e.getPoint());
            int idRol = (int) this.jtRolesSeleccionados.getValueAt(fila, 0);
            if ((fila > -1) && (columna > -1)) {
                this.jbQuitarRol.setEnabled(true);
            } else {
                this.jbQuitarRol.setEnabled(false);
            }
            if (e.getClickCount() == 2) {

                this.jbAgregarRol.setEnabled(false);
                this.jbQuitarRol.setEnabled(false);
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

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == this.jftCedulaIdentidad) {
            validatePIN();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
