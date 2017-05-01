/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.tableModel;

import com.ramiro.gestionusuario.model.MenuItem;
import com.ramiro.gestionusuario.model.Rol;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ramiro Ferreira
 */
public class RoleAccessTableModel extends AbstractTableModel {

    List<MenuItem> menuItemList;
    private String[] colNames = {"Id", "Descripcion", "Menu"};

    public RoleAccessTableModel() {
        menuItemList = new ArrayList<>();
    }

    @Override
    public String getColumnName(int i) {
        return this.colNames[i];
    }

    @Override
    public int getRowCount() {
        return this.menuItemList.size();
    }

    @Override
    public int getColumnCount() {
        return this.colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        MenuItem menuItem = this.menuItemList.get(rowIndex);
        switch (colIndex) {
            case 0: {
                return menuItem.getIdMenuItem();
            }
            case 1: {
                return menuItem.getDescripcion();
            }
            case 2: {
                return menuItem.getMenu().getDescripcion();
            }
            default: {
                return null;
            }
        }
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public void updateTable() {
        fireTableDataChanged();
    }
}
