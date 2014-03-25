/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.util;

import javax.swing.table.DefaultTableModel;

public class TableModelSAT extends DefaultTableModel{
    Class[] tipoColumna = { java.lang.String.class,     //Nombre empresa
                            java.lang.String.class,     //Periodo Empresa
                            java.lang.String.class,     //Estado Empresa
                            java.lang.String.class,     //Boton carga de archivo
                            java.lang.String.class};    //Archivo pdf
    
    boolean[] columnasEditables = {false,false,true,true,true};
    
    public TableModelSAT(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }
    
    @Override
    public Class getColumnClass(int indColumna){
        return tipoColumna[indColumna];
    }
    
    @Override
    public boolean isCellEditable(int fila, int columna){
        return columnasEditables[columna];
    }
    
}
