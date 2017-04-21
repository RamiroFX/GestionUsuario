/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.ui.empleado;

import com.ramiro.gestionusuario.model.Ciudad;
import com.ramiro.gestionusuario.model.Pais;
import com.ramiro.gestionusuario.service.EmployParamService;
import com.ramiro.gestionusuario.serviceImpl.EmployParamServiceImpl;
import com.ramiro.gestionusuario.tableModel.CiudadTableModel;
import com.ramiro.gestionusuario.tableModel.PaisTableModel;
import com.ramiro.gestionusuario.ui.Callbacks.EmpleadoParametrosCallback;
import com.ramiro.gestionusuario.ui.inicio.App;
import com.ramiro.gestionusuario.util.ParamEmployUIConstants;
import com.ramirogestionusuario.validator.Validator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Usuario
 */
public class EmpleadoParametros extends javax.swing.JDialog implements ActionListener, MouseListener, EmpleadoParametrosCallback {

    private javax.swing.JButton jbCrear, jbModificar, jbEliminar;
    private JTabbedPane jtpCenter;
    private JPanel jpSouth;
    JScrollPane jspPais, jspCiudad;
    JTable jtPais, jtCiudad;
    PaisTableModel paisTableModel;
    CiudadTableModel ciudadTableModel;
    EmployParamService service;

    public EmpleadoParametros(App app) {
        super(app, true);
        constructWindows(app);
        initializeVariables();
        loadData();
        addListener();
    }

    private void constructWindows(App app) {
        setTitle(ParamEmployUIConstants.TITLE);
        setSize(new java.awt.Dimension(400, 300));
        setLocationRelativeTo(app);
    }

    private void loadData() {
        List<Pais> countryList = this.service.getAllCountries();
        List<Ciudad> ciudadList = this.service.getAllCities();
        paisTableModel.setPaisList(countryList);
        ciudadTableModel.setCiudadList(ciudadList);
        jtPais.setModel(paisTableModel);
        jtCiudad.setModel(ciudadTableModel);
        paisTableModel.fireTableDataChanged();
        ciudadTableModel.fireTableDataChanged();
    }

    private void initMarcas() {
        jtPais = new JTable();
        jtPais.getTableHeader().setReorderingAllowed(false);
        jspPais = new JScrollPane(jtPais);

    }

    private void initCategorias() {
        jtCiudad = new JTable();
        jtCiudad.getTableHeader().setReorderingAllowed(false);
        jspCiudad = new JScrollPane(jtCiudad);
    }

    private void initializeVariables() {
        service = new EmployParamServiceImpl();
        paisTableModel = new PaisTableModel();
        ciudadTableModel = new CiudadTableModel();
        initMarcas();
        initCategorias();
        jtpCenter = new JTabbedPane();
        jtpCenter.add(ParamEmployUIConstants.COUNTRY_TITLE, jspPais);
        jtpCenter.add(ParamEmployUIConstants.CITY_TITLE, jspCiudad);
        jpSouth = new JPanel();
        jbCrear = new javax.swing.JButton(ParamEmployUIConstants.ADD_BTN);
        jbModificar = new javax.swing.JButton(ParamEmployUIConstants.UPDATE_BTN);
        jbEliminar = new javax.swing.JButton(ParamEmployUIConstants.DELETE_BTN);
        jpSouth.add(jbCrear);
        jpSouth.add(jbModificar);
        jpSouth.add(jbEliminar);
        getContentPane().setLayout(new MigLayout());
        getContentPane().add(jtpCenter, "dock center");
        getContentPane().add(jpSouth, "dock south");
        this.jbModificar.setEnabled(false);
        this.jbEliminar.setEnabled(false);
    }

    private void addListener() {
        jtpCenter.addMouseListener(this);
        jtCiudad.addMouseListener(this);
        jtPais.addMouseListener(this);
        jbCrear.addActionListener(this);
        jbModificar.addActionListener(this);
        jbEliminar.addActionListener(this);
    }

    private void agregarPais(Pais pais) {
        if (!service.existCountry(pais.getDescripcion())) {
            if (Validator.validar(pais, this)) {
                service.insertCountry(pais);
            }
        } else {
            JOptionPane.showMessageDialog(this, "País existente", "Titulo", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarPais(int idCountry, String pais) {
        if (!service.existCountry(pais)) {
            if (Validator.validar(pais, this)) {
                service.updateCity(idCountry, pais);
            }
        } else {
            JOptionPane.showMessageDialog(this, "País existente", "Titulo", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarPais() {
        service.deleteCountry(null);
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
    }

    private void agregarCiudad(Ciudad ciudad) {
        if (!service.existCity(ciudad.getDescripcion())) {
            if (Validator.validar(ciudad, this)) {
                service.insertCity(ciudad);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ciudad existente", "Titulo", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarCiudad(int idCiudad, String descripcion) {
        if (!service.existCity(descripcion)) {
            if (Validator.validar(descripcion, this)) {
                service.updateCity(idCiudad, descripcion);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ciudad existente", "Titulo", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarCiudad() {
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
    }

    private void createButtonHandler() {
        if (this.jtpCenter.getSelectedComponent().equals(this.jspPais)) {
            String pais = JOptionPane.showInputDialog(this, ParamEmployUIConstants.COUNTRY_CREATE_MESSAGE, "Insertar país", JOptionPane.PLAIN_MESSAGE).trim();
            if (pais != null) {
                if (!pais.isEmpty()) {
                    Pais p = new Pais(pais);
                    agregarPais(p);
                } else {
                    JOptionPane.showMessageDialog(this, "Inserte un valor", "Atención", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else if (this.jtpCenter.getSelectedComponent().equals(this.jspCiudad)) {
            String city = JOptionPane.showInputDialog(this, ParamEmployUIConstants.CITY_CREATE_MESSAGE, "Insertar ciudad", JOptionPane.PLAIN_MESSAGE).trim();
            if (city != null) {
                if (!city.isEmpty()) {
                    Ciudad c = new Ciudad(city);
                    agregarCiudad(c);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Inserte un valor", "Atención", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void updateButtonHandler() {
        if (this.jtpCenter.getSelectedComponent().equals(this.jspPais)) {
            String pais = JOptionPane.showInputDialog(this, ParamEmployUIConstants.COUNTRY_UPDATE_MESSAGE, ParamEmployUIConstants.COUNTRY_UPDATE_MESSAGE_TITLE, JOptionPane.PLAIN_MESSAGE).trim();
            int idPais = (int) jtPais.getValueAt(jtPais.getSelectedRow(), 0);
            if (pais != null) {
                if (!pais.isEmpty()) {
                    modificarPais(idPais, pais);
                    jbModificar.setEnabled(false);
                    jbEliminar.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Inserte un valor", "Atención", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else if (this.jtpCenter.getSelectedComponent().equals(this.jspCiudad)) {
            String ciudad = JOptionPane.showInputDialog(this, ParamEmployUIConstants.CITY_UPDATE_MESSAGE, ParamEmployUIConstants.CITY_UPDATE_MESSAGE_TITLE, JOptionPane.PLAIN_MESSAGE).trim();
            int idCiudad = (int) jtCiudad.getValueAt(jtCiudad.getSelectedRow(), 0);
            if (ciudad != null) {
                if (!ciudad.isEmpty()) {
                    modificarCiudad(idCiudad, ciudad);
                    jbModificar.setEnabled(false);
                    jbEliminar.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Inserte un valor", "Atención", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    private void deleteButtonHandler() {
        if (this.jtpCenter.getSelectedComponent().equals(this.jspPais)) {
            eliminarPais();
        } else if (this.jtpCenter.getSelectedComponent().equals(this.jspCiudad)) {
            eliminarCiudad();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jbCrear)) {
            createButtonHandler();
        }
        if (e.getSource().equals(jbModificar)) {
            updateButtonHandler();
        }
        if (e.getSource().equals(jbEliminar)) {
            deleteButtonHandler();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(this.jtpCenter)) {
            this.jbModificar.setEnabled(false);
            this.jbEliminar.setEnabled(false);
        }
        if (e.getSource().equals(this.jtPais)) {
            int fila = this.jtPais.rowAtPoint(e.getPoint());
            int columna = this.jtPais.columnAtPoint(e.getPoint());
            if ((fila > -1) && (columna > -1)) {
                this.jbModificar.setEnabled(true);
                this.jbEliminar.setEnabled(true);
            } else {
                this.jbModificar.setEnabled(false);
                this.jbEliminar.setEnabled(false);
            }
        }
        if (e.getSource().equals(this.jtCiudad)) {
            int fila = this.jtCiudad.rowAtPoint(e.getPoint());
            int columna = this.jtCiudad.columnAtPoint(e.getPoint());
            if ((fila > -1) && (columna > -1)) {
                this.jbModificar.setEnabled(true);
                this.jbEliminar.setEnabled(true);
            } else {
                this.jbModificar.setEnabled(false);
                this.jbEliminar.setEnabled(false);
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
    public void insertCity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeCity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertCountry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCountry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeCountry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
