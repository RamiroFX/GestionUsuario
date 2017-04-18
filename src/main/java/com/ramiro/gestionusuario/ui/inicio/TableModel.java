/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.ui.inicio;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ramiro
 */
public class TableModel extends AbstractTableModel {

    ArrayList data;
    private String[] colNames;

    public TableModel() {

    }

    public TableModel(ArrayList data, String[] colNames) {
        this.data = data;
        this.colNames = colNames;
    }

    @Override
    public String getColumnName(int i) {
        return this.colNames[i];
    }

    @Override
    public int getRowCount() {
        return this.data.size();
    }

    @Override
    public int getColumnCount() {
        return this.colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ArrayList rowArray = (ArrayList) data.get(rowIndex);
        return rowArray.get(columnIndex);
    }

    public void setList(ArrayList list) {
        this.data = list;
    }

    public void updateTable() {
        fireTableDataChanged();
    }
}
