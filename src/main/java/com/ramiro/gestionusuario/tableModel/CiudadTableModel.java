/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.tableModel;

import com.ramiro.gestionusuario.model.Ciudad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ramiro
 */
public class CiudadTableModel extends AbstractTableModel {

    List<Ciudad> ciudadList;
    private String[] colNames = {"Id", "Descripcion"};

    public CiudadTableModel() {
        ciudadList = new ArrayList<>();
    }

    @Override
    public String getColumnName(int i) {
        return this.colNames[i];
    }

    @Override
    public int getRowCount() {
        return this.ciudadList.size();
    }

    @Override
    public int getColumnCount() {
        return this.colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Ciudad pais = this.ciudadList.get(rowIndex);
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

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    public void updateTable() {
        fireTableDataChanged();
    }
}
