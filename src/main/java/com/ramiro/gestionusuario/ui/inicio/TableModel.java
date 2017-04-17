/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.ui.inicio;

import com.ramiro.gestionusuario.model.Pais;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ramiro
 */
public class TableModel extends AbstractTableModel {

    List<Pais> countryList;
    private String[] colNames = {"Id", "Descripcion"};

    public TableModel() {
        countryList = new ArrayList<Pais>();
    }

    @Override
    public String getColumnName(int i) {
        return this.colNames[i];
    }

    @Override
    public int getRowCount() {
        return this.countryList.size();
    }

    @Override
    public int getColumnCount() {
        return this.colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Pais pais = this.countryList.get(rowIndex);
        switch (colIndex) {
            case 0: {
                return pais.getId();
            }
            case 1: {
                return pais.getDescripcion();
            }
            default: {
                return null;
            }
        }
    }

    public void setCountryList(List<Pais> countryList) {
        this.countryList = countryList;
    }

    public void updateTable() {
        fireTableDataChanged();
    }
}
