/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isPushed;
    
    private ArrayList<String> urlFiles = new ArrayList<>();
    private JTable tablaPrincipal;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    public ButtonEditor(JCheckBox checkBox, JTable tablaP) {
        super(checkBox);
        this.tablaPrincipal = tablaP;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }
    private void limpiarLista(){
        urlFiles = null;
    }
    
    private void addLista(String dir){
        urlFiles.add(dir);
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column){
        if(isSelected){
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        }else{
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }
    
    @Override
    public Object getCellEditorValue(){
        if(isPushed){
            JFileChooser fileC = new JFileChooser();
            fileC.addChoosableFileFilter(new FileFilterPDF());
            fileC.setFileFilter(fileC.getChoosableFileFilters()[0]);
            fileC.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fileC.showOpenDialog(null);
            String nombreArchivo = null;
            if(nombreArchivo != null){
                JOptionPane.showMessageDialog(null, "mensaje: " + fileC.getSelectedFile().toString());
                nombreArchivo = fileC.getSelectedFile().toString();
                addLista(nombreArchivo);
            }
//            fileC.getSelectedFile().toString();
//            fileC.getName(fileC.getSelectedFile());
//            fileC.getTypeDescription(fileC.getSelectedFile());
        }
        isPushed = false;
        return new String(label);
    }
    
    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }
    
    @Override
    protected void fireEditingStopped(){
        super.fireEditingStopped();
    }
}
