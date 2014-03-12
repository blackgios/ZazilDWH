/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zazil.dwh.app.util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Hector Rodriguez
 */
public class CellEditor extends DefaultCellEditor{
    private String label;
    private JTextField jtfTexto;
    public CellEditor(JTextField textField) {
        super(textField);
        this.jtfTexto = new JTextField();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        if(!label.equals("")){
            jtfTexto.setForeground(Color.RED);
        }
        this.jtfTexto.setText(label);
        return jtfTexto;
    }
    
    
    
}
