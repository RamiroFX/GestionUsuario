/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.ui.empleado;

import com.ramiro.gestionusuario.model.Empleado;
import com.ramiro.gestionusuario.service.GestionEmpleadoService;
import com.ramiro.gestionusuario.serviceImpl.GestionEmpleadoServiceImpl;
import com.ramiro.gestionusuario.tableModel.EmpleadoTableModel;
import com.ramiro.gestionusuario.ui.inicio.App;
import com.ramiro.gestionusuario.util.CommonFormat;
import com.ramiro.gestionusuario.util.EmpleadoUIConstants;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Ramiro Ferreira
 */
public class GestionEmpleado extends JInternalFrame implements ActionListener {

    private javax.swing.JPanel jpDatosPersonalesVarios2;
    private javax.swing.JPanel jpDatosPersonalesVarios1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jspObservacion;
    private javax.swing.JTabbedPane jTabbedPane;
    public javax.swing.JButton jbModificarUsuario;
    public javax.swing.JButton jbEliminarUsuario;
    public javax.swing.JButton jbCambiarPassword;
    public javax.swing.JButton jbUsuarioParametros;
    public javax.swing.JButton jbCrearUsuario;
    public javax.swing.JButton jbGestionRol;
    private javax.swing.JLabel jlAlias;
    private javax.swing.JLabel jlApellido;
    private javax.swing.JLabel jlCedulaIdentidad;
    private javax.swing.JLabel jlCiudad;
    private javax.swing.JLabel jlCorreoElectronico;
    private javax.swing.JLabel jlDireccion;
    private javax.swing.JLabel jlEstadoCivil;
    private javax.swing.JLabel jlFechaIngreso;
    private javax.swing.JLabel jlFechaNacimiento;
    private javax.swing.JLabel jlGenero;
    private javax.swing.JLabel jlNacionalidad;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlNroCelular;
    private javax.swing.JLabel jlRol;
    private javax.swing.JLabel jlTelefono;
    private javax.swing.JPanel jpCenter;
    private javax.swing.JPanel jpDatos;
    private javax.swing.JPanel jpDatosEmpresariales;
    private javax.swing.JPanel jpDatosPersonales1;
    private javax.swing.JPanel jpDatosPersonales2;
    private javax.swing.JPanel jpSouth;
    public javax.swing.JTable jtUsuario;
    public javax.swing.JTextArea jtaObservacion;
    public javax.swing.JTextField jtfAlias;
    public javax.swing.JTextField jtfApellido;
    public javax.swing.JFormattedTextField jftCedulaIdentidad;
    public javax.swing.JTextField jtfCiudad;
    public javax.swing.JTextField jtfCorreoElectronico;
    public javax.swing.JTextField jtfDireccion;
    public javax.swing.JTextField jtfEstadoCivil;
    public javax.swing.JTextField jtfFechaIngreso;
    public javax.swing.JTextField jtfFechaNacimiento;
    public javax.swing.JTextField jtfGenero;
    public javax.swing.JTextField jtfNacionalidad;
    public javax.swing.JTextField jtfNombre;
    public javax.swing.JTextField jtfNroCelular;
    public javax.swing.JTextField jtfNroTelefono;
    public javax.swing.JComboBox jcbRol;
    JPanel jpNorth;
    public JTextField jtfBuscar;
    public JCheckBox jckbNombreApellido, jckbCedula;
    public JRadioButton jrbExclusivo, jrbInclusivo;
    App app;
    GestionEmpleadoService service;
    EmpleadoTableModel empleadoTableModel;

    public GestionEmpleado(App app) {
        this.app = app;
        constructWindow();
        initComponents();
        addListeners();
        loadData();
    }

    private void constructWindow() {
        setClosable(true);
        setForeground(java.awt.Color.white);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle(EmpleadoUIConstants.USER_MANAGMENT_TITLE);
        setName(EmpleadoUIConstants.USER_MANAGMENT_TITLE);
        setSize(new java.awt.Dimension(EmpleadoUIConstants.WINDOWS_SIZE_WIDTH, EmpleadoUIConstants.WINDOWS_SIZE_HEIGHT));
    }

    private void initComponents() {
        service = new GestionEmpleadoServiceImpl();
        empleadoTableModel = new EmpleadoTableModel();
        initFilter();
        jpCenter = new javax.swing.JPanel();
        jpCenter.setLayout(new java.awt.GridLayout(1, 0));
        jtUsuario = new javax.swing.JTable();
        jtUsuario.getTableHeader().setReorderingAllowed(false);
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setViewportView(jtUsuario);
        jTabbedPane = new javax.swing.JTabbedPane();
        //DATOS PERSONALES 1
        jlNombre = new javax.swing.JLabel(EmpleadoUIConstants.USER_MANAGMENT_NAME_PERSONAL);
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtfNombre = new javax.swing.JTextField();
        jtfNombre.setEditable(false);
        jlApellido = new javax.swing.JLabel(EmpleadoUIConstants.USER_MANAGMENT_LASTNAME_PERSONAL);
        jtfApellido = new javax.swing.JTextField();
        jlApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtfApellido.setEditable(false);
        jlFechaNacimiento = new javax.swing.JLabel(EmpleadoUIConstants.USER_MANAGMENT_BIRTHDATE_PERSONAL);
        jlFechaNacimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtfFechaNacimiento = new javax.swing.JTextField();
        jtfFechaNacimiento.setEditable(false);
        jlCedulaIdentidad = new javax.swing.JLabel(EmpleadoUIConstants.USER_MANAGMENT_PIN_PERSONAL);
        jlCedulaIdentidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jftCedulaIdentidad = new javax.swing.JFormattedTextField();
        jftCedulaIdentidad.setEditable(false);
        jlNacionalidad = new javax.swing.JLabel(EmpleadoUIConstants.USER_MANAGMENT_NATIONALITY_PERSONAL);
        jlNacionalidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtfNacionalidad = new javax.swing.JTextField();
        jtfNacionalidad.setEditable(false);
        jlCiudad = new javax.swing.JLabel(EmpleadoUIConstants.USER_MANAGMENT_CITY_PERSONAL);
        jlCiudad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtfCiudad = new javax.swing.JTextField();
        jtfCiudad.setEditable(false);
        jlEstadoCivil = new javax.swing.JLabel(EmpleadoUIConstants.USER_MANAGMENT_CIVIL_STATE_PERSONAL);
        jlEstadoCivil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtfEstadoCivil = new javax.swing.JTextField();
        jtfEstadoCivil.setEditable(false);
        jlGenero = new javax.swing.JLabel(EmpleadoUIConstants.USER_MANAGMENT_GENDER_PERSONAL);
        jlGenero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtfGenero = new javax.swing.JTextField();
        jtfGenero.setEditable(false);
        //DATOS PERSONALES 2        
        jlDireccion = new javax.swing.JLabel(EmpleadoUIConstants.USER_MANAGMENT_ADRESS_PERSONAL);
        jlDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtfDireccion = new javax.swing.JTextField();
        jtfDireccion.setEditable(false);
        jlTelefono = new javax.swing.JLabel(EmpleadoUIConstants.USER_MANAGMENT_TELEPHONE_PERSONAL);
        jlTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtfNroTelefono = new javax.swing.JTextField();
        jtfNroTelefono.setEditable(false);
        jlNroCelular = new javax.swing.JLabel(EmpleadoUIConstants.USER_MANAGMENT_CELLPHONE_PERSONAL);
        jlNroCelular.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtfNroCelular = new javax.swing.JTextField();
        jtfNroCelular.setEditable(false);
        jtaObservacion = new javax.swing.JTextArea();
        jspObservacion = new javax.swing.JScrollPane(jtaObservacion);
        //DATOS EMPRESARIALES
        jlAlias = new javax.swing.JLabel(EmpleadoUIConstants.USER_MANAGMENT_ALIAS_CORP);
        jlAlias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtfAlias = new javax.swing.JTextField();
        jtfAlias.setEditable(false);
        jlFechaIngreso = new javax.swing.JLabel(EmpleadoUIConstants.USER_MANAGMENT_ENTER_DATE_CORP);
        jlFechaIngreso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtfFechaIngreso = new javax.swing.JTextField();
        jtfFechaIngreso.setEditable(false);
        jlCorreoElectronico = new javax.swing.JLabel(EmpleadoUIConstants.USER_MANAGMENT_EMAIL_CORP);
        jlCorreoElectronico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtfCorreoElectronico = new javax.swing.JTextField();
        jtfCorreoElectronico.setEditable(false);
        jlRol = new javax.swing.JLabel(EmpleadoUIConstants.USER_MANAGMENT_ROL_CORP);
        jlRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jcbRol = new javax.swing.JComboBox();
        //BOTONES
        jbCrearUsuario = new javax.swing.JButton(EmpleadoUIConstants.USER_MANAGMENT_CREATE_BTN);
        jbModificarUsuario = new javax.swing.JButton(EmpleadoUIConstants.USER_MANAGMENT_UPDATE_BTN);
        jbEliminarUsuario = new javax.swing.JButton(EmpleadoUIConstants.USER_MANAGMENT_DELETE_BTN);
        jbCambiarPassword = new javax.swing.JButton(EmpleadoUIConstants.USER_MANAGMENT_CHANGE_PASS_BTN);
        jbCambiarPassword.setName(EmpleadoUIConstants.USER_MANAGMENT_CHANGE_PASS_BTN);
        jbUsuarioParametros = new javax.swing.JButton(EmpleadoUIConstants.USER_MANAGMENT_PARAM_BTN);
        jbUsuarioParametros.setName(EmpleadoUIConstants.USER_MANAGMENT_PARAM_BTN);
        jbCrearUsuario.setName(EmpleadoUIConstants.USER_MANAGMENT_CREATE_BTN);
        jbModificarUsuario.setName(EmpleadoUIConstants.USER_MANAGMENT_UPDATE_BTN);
        jbEliminarUsuario.setName(EmpleadoUIConstants.USER_MANAGMENT_DELETE_BTN);
        jbGestionRol = new JButton(EmpleadoUIConstants.USER_MANAGMENT_ROL_MANAGMENT);
        jbGestionRol.setName(EmpleadoUIConstants.USER_MANAGMENT_ROL_BTN);
        Insets insets = new Insets(10, 10, 10, 10);
        jbCrearUsuario.setMargin(insets);
        jbModificarUsuario.setMargin(insets);
        jbEliminarUsuario.setMargin(insets);
        jbCambiarPassword.setMargin(insets);
        jbUsuarioParametros.setMargin(insets);
        jbGestionRol.setMargin(insets);

        jbCrearUsuario.setFont(CommonFormat.fuente);
        jbModificarUsuario.setFont(CommonFormat.fuente);
        jbEliminarUsuario.setFont(CommonFormat.fuente);
        jbCambiarPassword.setFont(CommonFormat.fuente);
        jbUsuarioParametros.setFont(CommonFormat.fuente);
        jbGestionRol.setFont(CommonFormat.fuente);

        jpDatos = new javax.swing.JPanel(new java.awt.GridLayout(8, 2));
        jpDatos.add(jlNombre);
        jpDatos.add(jtfNombre);
        jpDatos.add(jlApellido);
        jpDatos.add(jtfApellido);
        jpDatos.add(jlFechaNacimiento);
        jpDatos.add(jtfFechaNacimiento);
        jpDatos.add(jlCedulaIdentidad);
        jpDatos.add(jftCedulaIdentidad);
        jpDatos.add(jlNacionalidad);
        jpDatos.add(jtfNacionalidad);
        jpDatos.add(jlCiudad);
        jpDatos.add(jtfCiudad);
        jpDatos.add(jlEstadoCivil);
        jpDatos.add(jtfEstadoCivil);
        jpDatos.add(jlGenero);
        jpDatos.add(jtfGenero);

        jpDatosPersonales1 = new javax.swing.JPanel(new java.awt.BorderLayout());
        jpDatosPersonales1.add(jpDatos, java.awt.BorderLayout.CENTER);

        jpDatosPersonalesVarios1 = new javax.swing.JPanel(new java.awt.GridLayout(3, 2));
        jpDatosPersonalesVarios1.add(jlDireccion);
        jpDatosPersonalesVarios1.add(jtfDireccion);
        jpDatosPersonalesVarios1.add(jlTelefono);
        jpDatosPersonalesVarios1.add(jtfNroTelefono);
        jpDatosPersonalesVarios1.add(jlNroCelular);
        jpDatosPersonalesVarios1.add(jtfNroCelular);

        jpDatosPersonales2 = new javax.swing.JPanel(new java.awt.BorderLayout());
        jpDatosPersonales2.add(jpDatosPersonalesVarios1, java.awt.BorderLayout.PAGE_START);

        jpDatosPersonalesVarios2 = new javax.swing.JPanel(new java.awt.BorderLayout());
        jpDatosPersonalesVarios2.setBorder(javax.swing.BorderFactory.createTitledBorder(EmpleadoUIConstants.USER_MANAGMENT_OPTIONS_SUBTITLE));
        jpDatosPersonalesVarios2.add(jspObservacion, java.awt.BorderLayout.CENTER);

        jpDatosPersonales2.add(jpDatosPersonalesVarios2, java.awt.BorderLayout.CENTER);

        jpDatosEmpresariales = new javax.swing.JPanel(new java.awt.GridLayout(12, 2));
        jpDatosEmpresariales.add(jlAlias);
        jpDatosEmpresariales.add(jtfAlias);
        jpDatosEmpresariales.add(jlFechaIngreso);
        jpDatosEmpresariales.add(jtfFechaIngreso);
        jpDatosEmpresariales.add(jlCorreoElectronico);
        jpDatosEmpresariales.add(jtfCorreoElectronico);
        jpDatosEmpresariales.add(jlRol);
        jpDatosEmpresariales.add(jcbRol);
        jpDatosEmpresariales.add(new JLabel());
        jpDatosEmpresariales.add(new JLabel());
        jpDatosEmpresariales.add(new JLabel());
        jpDatosEmpresariales.add(new JLabel());
        jpDatosEmpresariales.add(new JLabel());
        jpDatosEmpresariales.add(new JLabel());
        jTabbedPane.addTab(EmpleadoUIConstants.USER_MANAGMENT_PERSONAL_DATA_TITLE1, jpDatosPersonales1);
        jTabbedPane.addTab(EmpleadoUIConstants.USER_MANAGMENT_PERSONAL_DATA_TITLE2, jpDatosPersonales2);
        jTabbedPane.addTab(EmpleadoUIConstants.USER_MANAGMENT_CORP_DATA_TITLE, jpDatosEmpresariales);

        JPanel jpaux = new JPanel(new BorderLayout());
        jpaux.add(jpNorth, BorderLayout.NORTH);
        jpaux.add(jScrollPane1, BorderLayout.CENTER);

        jpCenter.add(jpaux);
        jpCenter.add(jTabbedPane);

        //JP SOUTH
        jpSouth = new javax.swing.JPanel();
        jpSouth.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), EmpleadoUIConstants.USER_MANAGMENT_OPTIONS_SUBTITLE));
        jpSouth.add(jbCrearUsuario);
        jpSouth.add(jbModificarUsuario);
        jpSouth.add(jbEliminarUsuario);
        jpSouth.add(jbCambiarPassword);
        jpSouth.add(jbUsuarioParametros);
        jpSouth.add(jbGestionRol);

        //ADDING INTO CONTAINER
        getContentPane().add(jpCenter, java.awt.BorderLayout.CENTER);
        getContentPane().add(jpSouth, java.awt.BorderLayout.SOUTH);
    }

    private void addListeners() {
        jbCrearUsuario.addActionListener(this);
        jbModificarUsuario.addActionListener(this);
        jbEliminarUsuario.addActionListener(this);
        jbCambiarPassword.addActionListener(this);
        jbUsuarioParametros.addActionListener(this);
        jbGestionRol.addActionListener(this);
    }

    private void initFilter() {
        jtfBuscar = new JTextField();
        jtfBuscar.setName(EmpleadoUIConstants.USER_MANAGMENT_SEARCH_FIELD_NAME);
        jckbNombreApellido = new JCheckBox(EmpleadoUIConstants.USER_MANAGMENT_NAME_LASTNAME_FIELD);
        jckbNombreApellido.setSelected(true);
        jckbCedula = new JCheckBox(EmpleadoUIConstants.USER_MANAGMENT_PIN_SEARCH);
        jckbCedula.setSelected(true);
        jrbExclusivo = new javax.swing.JRadioButton(EmpleadoUIConstants.USER_MANAGMENT_EXCLUSIVE_SEARCH, true);
        jrbInclusivo = new javax.swing.JRadioButton(EmpleadoUIConstants.USER_MANAGMENT_INCLUSIVE_SEARCH);
        javax.swing.ButtonGroup bg1 = new javax.swing.ButtonGroup();
        bg1.add(jrbExclusivo);
        bg1.add(jrbInclusivo);
        jpNorth = new JPanel(new MigLayout("align center"));
        String width = "width :100:";
        //C F
        jpNorth.add(jtfBuscar, "width :300:, cell 0 0");
        jpNorth.add(jckbNombreApellido, width + ", cell 1 0");
        jpNorth.add(jckbCedula, width + ", cell 1 1");
        jpNorth.add(jrbExclusivo, width + ", cell 0 1, span");
        jpNorth.add(jrbInclusivo, width + ", cell 0 1");
        jpNorth.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), EmpleadoUIConstants.USER_MANAGMENT_SEARCH_SUBTITLE));
    }

    private void loadData() {
        List<Empleado> empleadoList = this.service.getAllEmpleados();
        empleadoTableModel.setEmpleadoList(empleadoList);
        jtUsuario.setModel(empleadoTableModel);
        empleadoTableModel.fireTableDataChanged();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(jbCrearUsuario)) {
            CrearEmpleado empParam = new CrearEmpleado(app);
            empParam.setVisible(true);
        } else if (src.equals(jbUsuarioParametros)) {
            EmpleadoParametros empParam = new EmpleadoParametros(app);
            empParam.setVisible(true);
        } else if (src.equals(jbModificarUsuario)) {
        } else if (src.equals(jbEliminarUsuario)) {
        } else if (src.equals(jbCambiarPassword)) {
        } else if (src.equals(jbGestionRol)) {
        }
    }
}
