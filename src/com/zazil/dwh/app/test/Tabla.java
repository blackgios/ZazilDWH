/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zazil.dwh.app.test;

import javax.swing.JTable;

/**
 *
 * @author Hector Rodriguez
 */
public class Tabla extends JTable{
    
    public Tabla(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
        this.setSize(0, 0);
    }
    
}
