/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramiro.gestionusuario.tableModel;

import com.ramiro.gestionusuario.model.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ramiro Ferreira
 */
public class EmpleadoTableModel extends AbstractTableModel {

    List<Empleado> empleadoList;
    private String[] colNames = {"Id", "CI", "Alias", "Nombre", "Apellido"};

    public EmpleadoTableModel() {
        empleadoList = new ArrayList<>();
    }

    @Override
    public String getColumnName(int i) {
        return this.colNames[i];
    }

    @Override
    public int getRowCount() {
        return this.empleadoList.size();
    }

    @Override
    public int getColumnCount() {
        return this.colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Empleado empleado = this.empleadoList.get(rowIndex);
        switch (colIndex) {
            case 0: {
                return empleado.getId();
            }
            case 1: {
                return empleado.getCedula();
            }
            case 2: {
                return empleado.getApodo();
            }
            case 3: {
                return empleado.getNombre();
            }
            case 4: {
                return empleado.getApellido();
            }
            default: {
                return null;
            }
        }
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public void updateTable() {
        fireTableDataChanged();
    }
}
