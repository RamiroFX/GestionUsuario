/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.tableModel;

import com.ramiro.gestionusuario.model.Ciudad;
import com.ramiro.gestionusuario.model.Rol;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ramiro Ferreira
 */
public class RolTableModel extends AbstractTableModel {

    List<Rol> rolList;
    private String[] colNames = {"Id", "Descripcion"};

    public RolTableModel() {
        rolList = new ArrayList<>();
    }

    @Override
    public String getColumnName(int i) {
        return this.colNames[i];
    }

    @Override
    public int getRowCount() {
        return this.rolList.size();
    }

    @Override
    public int getColumnCount() {
        return this.colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Rol rol = this.rolList.get(rowIndex);
        switch (colIndex) {
            case 0: {
                return rol.getIdRol();
            }
            case 1: {
                return rol.getDescripcion();
            }
            default: {
                return null;
            }
        }
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    public void updateTable() {
        fireTableDataChanged();
    }
}
