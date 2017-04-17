/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.ui.inicio;

import com.ramiro.gestionusuario.model.Pais;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ramiro
 */
public class TablePanel extends JPanel {

    private JTable studentTable;
    private TableModel studentModel;

    public TablePanel() {
        initializeVariables();
        initializeLayout();
        initializeHeaderAlignment();
        initializeTableAlignment();
    }

    private void initializeLayout() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 30, 10, 30));
        add(new JScrollPane(this.studentTable), BorderLayout.CENTER);
    }

    private void initializeVariables() {
        this.studentModel = new TableModel();
        this.studentTable = new JTable(this.studentModel);
    }

    private void initializeHeaderAlignment() {
        DefaultTableCellRenderer headerCellRenderer = new DefaultTableCellRenderer();
        headerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        this.studentTable.getTableHeader().setDefaultRenderer(headerCellRenderer);
    }

    private void initializeTableAlignment() {
        DefaultTableCellRenderer columnCellRenderer = new DefaultTableCellRenderer();
        columnCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        this.studentTable.getColumnModel().getColumn(0).setCellRenderer(columnCellRenderer);
        this.studentTable.getColumnModel().getColumn(1).setCellRenderer(columnCellRenderer);
    }

    public void setTableModel(List<Pais> countryList) {
        this.studentModel.setCountryList(countryList);
    }

    public void updateTable() {
        this.studentModel.updateTable();
    }
}
