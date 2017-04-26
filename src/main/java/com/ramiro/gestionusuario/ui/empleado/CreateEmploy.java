/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.ui.empleado;

import com.ramiro.gestionusuario.model.Ciudad;
import com.ramiro.gestionusuario.model.Empleado;
import com.ramiro.gestionusuario.model.EmpleadoEstado;
import com.ramiro.gestionusuario.model.EstadoCivil;
import com.ramiro.gestionusuario.model.Genero;
import com.ramiro.gestionusuario.model.Pais;
import com.ramiro.gestionusuario.model.Rol;
import com.ramiro.gestionusuario.service.EmployService;
import com.ramiro.gestionusuario.serviceImpl.EmployServiceImpl;
import com.ramiro.gestionusuario.tableModel.RolTableModel;
import com.ramirogestionusuario.validator.Validator;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramiro Ferreira
 */
public class CreateEmploy extends CreateUpdateEmploy implements ActionListener, KeyListener, MouseListener {

    private EmployService servicio;
    private RolTableModel availableRol, selectedRol;
    private List<Rol> selectedRolsList;

    public CreateEmploy(JFrame frame) {
        super(frame);
        initializeLogic();
        initializeData();
        addListeners();
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
        this.jbAgregarRol.setEnabled(false);
        this.jbQuitarRol.setEnabled(false);
    }

    private void initializeLogic() {
        servicio = new EmployServiceImpl();
        availableRol = new RolTableModel();
        selectedRolsList = new ArrayList<>();
        selectedRol = new RolTableModel();
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
        funcionario.setEmpleadoEstado(servicio.getEstadoActivo());
        if (Validator.validar(funcionario, this)) {
            servicio.createEmploy(funcionario);
            JOptionPane.showMessageDialog(this, "Empleado creado", "Exito", JOptionPane.INFORMATION_MESSAGE);
            cerrar();
        }
    }

    private List<Rol> validateRol() {
        List<Integer> idRoles = new ArrayList<>();
        for (Rol rol : selectedRolsList) {
            idRoles.add(rol.getIdRol());
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
        if (fila > -1) {

            int idRol = (int) this.jtRolesDisponibles.getValueAt(fila, 0);
            for (int i = 0; i < selectedRolsList.size(); i++) {
                if (selectedRolsList.get(i).getIdRol() == idRol) {
                    JOptionPane.showMessageDialog(null, "El Rol seleccionado ya se ha encuentra", "Atención", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            String descripcionRol = (String) this.jtRolesDisponibles.getValueAt(fila, 1);
            Rol rol = new Rol(descripcionRol);
            rol.setIdRol(idRol);
            selectedRolsList.add(rol);
            selectedRol.setRolList(selectedRolsList);
            this.jtRolesSeleccionados.setModel(selectedRol);
            selectedRol.updateTable();
            this.jbAgregarRol.setEnabled(false);
            this.jbQuitarRol.setEnabled(false);
        }
    }

    private void quitarRol() {
        int fila = this.jtRolesSeleccionados.getSelectedRow();
        if (fila > -1) {
            int idRol = (int) this.jtRolesSeleccionados.getValueAt(fila, 0);
            for (int i = 0; i < selectedRolsList.size(); i++) {
                if (selectedRolsList.get(i).getIdRol() == idRol) {
                    selectedRolsList.remove(i);
                }
            }
            selectedRol.setRolList(selectedRolsList);
            this.jtRolesSeleccionados.setModel(selectedRol);
            selectedRol.updateTable();
            this.jbAgregarRol.setEnabled(false);
            this.jbQuitarRol.setEnabled(false);

        }
    }

    private void cerrar() {
        this.dispose();
        System.runFinalization();
    }

    private void addListeners() {
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
