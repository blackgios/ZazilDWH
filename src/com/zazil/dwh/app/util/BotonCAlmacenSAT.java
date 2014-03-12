/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.util;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

public class BotonCAlmacenSAT extends JButton implements TableCellRenderer{
    
    public BotonCAlmacenSAT() {
        setOpaque(true);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //throw new UnsupportedOperationException("Not supported yet.");
        if(isSelected){
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        }else{
            setForeground(table.getSelectionForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText( (value == null) ? "" : value.toString() );
        return this;
    }
}
