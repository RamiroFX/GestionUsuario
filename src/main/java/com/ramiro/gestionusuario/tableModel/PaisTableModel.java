/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.tableModel;

import com.ramiro.gestionusuario.model.Pais;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ramiro
 */
public class PaisTableModel extends AbstractTableModel {

    List<Pais> paisList;
    private String[] colNames = {"Id", "Descripcion"};

    public PaisTableModel() {
        paisList = new ArrayList<>();
    }

    @Override
    public String getColumnName(int i) {
        return this.colNames[i];
    }

    @Override
    public int getRowCount() {
        return this.paisList.size();
    }

    @Override
    public int getColumnCount() {
        return this.colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Pais pais = this.paisList.get(rowIndex);
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

    public void setPaisList(List<Pais> paisList) {
        this.paisList = paisList;
    }

    public void updateTable() {
        fireTableDataChanged();
    }
}
