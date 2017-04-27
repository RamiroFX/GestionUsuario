/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.ui.empleado;

import com.ramiro.gestionusuario.model.Empleado;
import com.ramiro.gestionusuario.model.EmpleadoEstado;
import com.ramiro.gestionusuario.service.ChangeEmployStatusService;
import com.ramiro.gestionusuario.serviceImpl.ChangeStatusImpl;
import com.ramiro.gestionusuario.util.ChangeEmployStatusConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Ramiro
 */
public class ChangeEmployStatus extends JDialog implements ActionListener {

    private JButton removeButton;
    private JButton cancelButton;
    private JLabel employName;
    private JComboBox<EmpleadoEstado> employStatusComboBox;
    private ChangeEmployStatusService changeStatusService;
    private Empleado employ;

    public ChangeEmployStatus(JFrame parent, Empleado employ) {
        super(parent, ChangeEmployStatusConstants.TITLE, false);
        initializeVariables(employ);
        loadData();
        constructLayout();
        setWindows(parent);
    }

    public void loadData() {
        this.employStatusComboBox.removeAllItems();
        List<EmpleadoEstado> employStatusList = this.changeStatusService.getAllEmployStatus();

        for (EmpleadoEstado employStatus : employStatusList) {
            this.employStatusComboBox.addItem(employStatus);
        }
    }

    private void setWindows(JFrame parent) {
        this.setSize(ChangeEmployStatusConstants.WINDOWS_SIZE_WIDTH, ChangeEmployStatusConstants.WINDOWS_SIZE_HEIGHT);
        this.setLocationRelativeTo(parent);
    }

    private void initializeVariables(Empleado employ) {
        this.employ = employ;
        this.changeStatusService = new ChangeStatusImpl();
        this.employStatusComboBox = new JComboBox<EmpleadoEstado>();
        this.removeButton = new JButton(ChangeEmployStatusConstants.ACEPT);
        this.cancelButton = new JButton(ChangeEmployStatusConstants.CANCEL);
        this.employName = new JLabel(employ.getNombre());

        this.removeButton.addActionListener(this);
        this.cancelButton.addActionListener(this);
    }

    private void constructLayout() {
        JPanel studentInfoPanel = new JPanel();
        JPanel studentButtonPanel = new JPanel();

        int space = 15;
        Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);
        Border titleBorder = BorderFactory.createTitledBorder(ChangeEmployStatusConstants.SUBTITLE);

        studentInfoPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));

        studentInfoPanel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;

        Insets rightPadding = new Insets(0, 0, 0, 15);
        Insets noPadding = new Insets(0, 0, 0, 0);

        ///// FIRST ROW /////
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx++;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        studentInfoPanel.add(employName, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        studentInfoPanel.add(employStatusComboBox, gc);

        //// BUTTON PANEL /////
        studentButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        studentButtonPanel.add(removeButton);
        studentButtonPanel.add(cancelButton);

//        Dimension cancelButtonSize = this.cancelButton.getPreferredSize();
//        this.removeButton.setPreferredSize(cancelButtonSize);
        ///// SET LAYOUT /////
        setLayout(new BorderLayout());
        add(studentInfoPanel, BorderLayout.CENTER);
        add(studentButtonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();

        if (src.equals(cancelButton)) {
            this.dispose();
        } else if (src.equals(removeButton)) {
            EmpleadoEstado employStatus = (EmpleadoEstado) this.employStatusComboBox.getSelectedItem();
            //this.changeStatusService.changeEmployStatus(this.employ, employStatus);
            this.changeStatusService.changeEmployStatus2(this.employ.getIdPersona(), employStatus.getIdEmpleadoEstado());
            this.dispose();
        }
    }
}
