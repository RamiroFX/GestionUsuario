/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.ui.empleado;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.ramiro.gestionusuario.ui.inicio.App;
import com.ramiro.gestionusuario.util.CommonFormat;
import com.ramiro.gestionusuario.util.EmpleadoUIConstants;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 * @author Administrador
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

    public GestionEmpleado(App app) {
        this.app = app;
        setClosable(true);
        setForeground(java.awt.Color.white);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle(EmpleadoUIConstants.USER_MANAGMENT_TITLE);
        setName(EmpleadoUIConstants.USER_MANAGMENT_TITLE);
        setSize(new java.awt.Dimension(EmpleadoUIConstants.WINDOWS_SIZE_WIDTH, EmpleadoUIConstants.WINDOWS_SIZE_HEIGHT));
        initComponents();
    }

    private void initComponents() {
        initFilter();
        jpCenter = new javax.swing.JPanel();
        jpCenter.setLayout(new java.awt.GridLayout(1, 0));
        jtUsuario = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setViewportView(jtUsuario);
        jTabbedPane = new javax.swing.JTabbedPane();
        jlNombre = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jtfNombre.setEditable(false);
        jlApellido = new javax.swing.JLabel();
        jtfApellido = new javax.swing.JTextField();
        jtfApellido.setEditable(false);
        jlFechaNacimiento = new javax.swing.JLabel();
        jtfFechaNacimiento = new javax.swing.JTextField();
        jtfFechaNacimiento.setEditable(false);
        jlCedulaIdentidad = new javax.swing.JLabel();
        jftCedulaIdentidad = new javax.swing.JFormattedTextField();
        jftCedulaIdentidad.setEditable(false);
        jlNacionalidad = new javax.swing.JLabel();
        jtfNacionalidad = new javax.swing.JTextField();
        jtfNacionalidad.setEditable(false);
        jlCiudad = new javax.swing.JLabel();
        jtfCiudad = new javax.swing.JTextField();
        jtfCiudad.setEditable(false);
        jlEstadoCivil = new javax.swing.JLabel();
        jtfEstadoCivil = new javax.swing.JTextField();
        jtfEstadoCivil.setEditable(false);
        jlGenero = new javax.swing.JLabel();
        jtfGenero = new javax.swing.JTextField();
        jtfGenero.setEditable(false);
        jpDatosPersonales2 = new javax.swing.JPanel();
        jlDireccion = new javax.swing.JLabel();
        jtfDireccion = new javax.swing.JTextField();
        jtfDireccion.setEditable(false);
        jlTelefono = new javax.swing.JLabel();
        jtfNroTelefono = new javax.swing.JTextField();
        jtfNroTelefono.setEditable(false);
        jlNroCelular = new javax.swing.JLabel();
        jtfNroCelular = new javax.swing.JTextField();
        jtfNroCelular.setEditable(false);
        jpDatosPersonalesVarios2 = new javax.swing.JPanel();
        jspObservacion = new javax.swing.JScrollPane();
        jtaObservacion = new javax.swing.JTextArea();
        jlAlias = new javax.swing.JLabel();
        jtfAlias = new javax.swing.JTextField();
        jtfAlias.setEditable(false);
        jlFechaIngreso = new javax.swing.JLabel();
        jtfFechaIngreso = new javax.swing.JTextField();
        jtfFechaIngreso.setEditable(false);
        jlCorreoElectronico = new javax.swing.JLabel();
        jtfCorreoElectronico = new javax.swing.JTextField();
        jtfCorreoElectronico.setEditable(false);
        jlRol = new javax.swing.JLabel();
        jcbRol = new javax.swing.JComboBox();
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

        Insets insets = new Insets(10, 10, 10, 10);
        jbCrearUsuario.setMargin(insets);
        jbModificarUsuario.setMargin(insets);
        jbEliminarUsuario.setMargin(insets);
        jbCambiarPassword.setMargin(insets);
        jbUsuarioParametros.setMargin(insets);

        jbCrearUsuario.setFont(CommonFormat.fuente);
        jbModificarUsuario.setFont(CommonFormat.fuente);
        jbEliminarUsuario.setFont(CommonFormat.fuente);
        jbCambiarPassword.setFont(CommonFormat.fuente);
        jbUsuarioParametros.setFont(CommonFormat.fuente);

        jpDatosPersonales1 = new javax.swing.JPanel();
        jpDatosPersonales1.setLayout(new java.awt.BorderLayout());

        jpDatos = new javax.swing.JPanel();
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNombre.setText(EmpleadoUIConstants.USER_MANAGMENT_NAME_PERSONAL);
        jlApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlApellido.setText(EmpleadoUIConstants.USER_MANAGMENT_LASTNAME_PERSONAL);
        jlFechaNacimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFechaNacimiento.setText(EmpleadoUIConstants.USER_MANAGMENT_BIRTHDATE_PERSONAL);
        jlCedulaIdentidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCedulaIdentidad.setText(EmpleadoUIConstants.USER_MANAGMENT_PIN_PERSONAL);
        jlNacionalidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNacionalidad.setText(EmpleadoUIConstants.USER_MANAGMENT_NATIONALITY_PERSONAL);
        jlCiudad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCiudad.setText(EmpleadoUIConstants.USER_MANAGMENT_CITY_PERSONAL);
        jlEstadoCivil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlEstadoCivil.setText(EmpleadoUIConstants.USER_MANAGMENT_CIVIL_STATE_PERSONAL);
        jlGenero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlGenero.setText(EmpleadoUIConstants.USER_MANAGMENT_GENDER_PERSONAL);
        jpDatos.setLayout(new java.awt.GridLayout(8, 2));
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

        jpDatosPersonales1.add(jpDatos, java.awt.BorderLayout.CENTER);

        jpDatosPersonales2.setLayout(new java.awt.BorderLayout());

        jpDatosPersonalesVarios1 = new javax.swing.JPanel(new java.awt.GridLayout(3, 2));
        jlDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDireccion.setText(EmpleadoUIConstants.USER_MANAGMENT_ADRESS_PERSONAL);
        jlNroCelular.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNroCelular.setText(EmpleadoUIConstants.USER_MANAGMENT_CELLPHONE_PERSONAL);
        jlTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTelefono.setText(EmpleadoUIConstants.USER_MANAGMENT_TELEPHONE_PERSONAL);
        jpDatosPersonalesVarios1.add(jlDireccion);
        jpDatosPersonalesVarios1.add(jtfDireccion);
        jpDatosPersonalesVarios1.add(jlTelefono);
        jpDatosPersonalesVarios1.add(jtfNroTelefono);
        jpDatosPersonalesVarios1.add(jlNroCelular);
        jpDatosPersonalesVarios1.add(jtfNroCelular);

        jpDatosPersonales2.add(jpDatosPersonalesVarios1, java.awt.BorderLayout.PAGE_START);

        jpDatosPersonalesVarios2.setBorder(javax.swing.BorderFactory.createTitledBorder(EmpleadoUIConstants.USER_MANAGMENT_OPTIONS_SUBTITLE));
        jpDatosPersonalesVarios2.setLayout(new java.awt.BorderLayout());

        jtaObservacion.setColumns(20);
        jtaObservacion.setRows(5);
        jspObservacion.setViewportView(jtaObservacion);

        jpDatosPersonalesVarios2.add(jspObservacion, java.awt.BorderLayout.CENTER);

        jpDatosPersonales2.add(jpDatosPersonalesVarios2, java.awt.BorderLayout.CENTER);

        jpDatosEmpresariales = new javax.swing.JPanel();
        jpDatosEmpresariales.setLayout(new java.awt.GridLayout(12, 2));

        jlAlias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAlias.setText(EmpleadoUIConstants.USER_MANAGMENT_ALIAS_CORP);
        jlFechaIngreso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFechaIngreso.setText(EmpleadoUIConstants.USER_MANAGMENT_ENTER_DATE_CORP);
        jlCorreoElectronico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCorreoElectronico.setText(EmpleadoUIConstants.USER_MANAGMENT_EMAIL_CORP);
        jlRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlRol.setText(EmpleadoUIConstants.USER_MANAGMENT_ROL_CORP);
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
        jpSouth.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbGestionRol = new JButton(EmpleadoUIConstants.USER_MANAGMENT_ROL_MANAGMENT);
        jbGestionRol.setName(EmpleadoUIConstants.USER_MANAGMENT_ROL_BTN);
        jbGestionRol.setFont(CommonFormat.fuente);
        jbGestionRol.setMargin(insets);
        jpSouth.add(jbCrearUsuario);
        jpSouth.add(jbModificarUsuario);
        jpSouth.add(jbEliminarUsuario);
        jpSouth.add(jbCambiarPassword);
        jpSouth.add(jbUsuarioParametros);
        jpSouth.add(jbGestionRol);
        jpSouth.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), EmpleadoUIConstants.USER_MANAGMENT_OPTIONS_SUBTITLE));

        //ADDING INTO CONTAINER
        getContentPane().add(jpCenter, java.awt.BorderLayout.CENTER);
        getContentPane().add(jpSouth, java.awt.BorderLayout.SOUTH);

        jbUsuarioParametros.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(jbUsuarioParametros)) {
            EmpleadoParametros empParam = new EmpleadoParametros(app);
            empParam.setVisible(true);
        }
    }
}
