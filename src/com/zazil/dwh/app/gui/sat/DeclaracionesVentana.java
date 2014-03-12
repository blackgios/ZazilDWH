/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.gui.sat;

import com.zazil.dwh.app.bussiness.AlmacenSATService;
import com.zazil.dwh.app.util.BotonCAlmacenSAT;
import com.zazil.dwh.app.util.ButtonEditor;
import com.zazil.dwh.app.util.CellEditor;
import com.zazil.dwh.app.util.TableModelSAT;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class DeclaracionesVentana extends javax.swing.JFrame {
    private JFrame ventanaPadre;
    private AlmacenSATService servicioSAT;
    private JPanel panelTabla;
    private JLabel jlbEtiqueta;
    private JTable tablaEmpresas;
    private JButton jbtCargaArchivos;
    /**
     * Creates new form DeclaracionesVentana
     */
    public DeclaracionesVentana(JFrame owner) {
        this.ventanaPadre = owner;
        this.setTitle("Empresas");
        this.iniciarComponentes();
        //initComponents();
    }
    
    private void iniciarComponentes(){
        this.setSize(1000, 500);
        this.setTitle("Empresas no declaradas");
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        this.getContentPane().setLayout(new BorderLayout());
        /****    Ingresando componentes        *******************************/
        //Iniciando Servicio
        this.servicioSAT = new AlmacenSATService();
        //Etiqueta
        this.jbtCargaArchivos = new JButton("Carga archivos");
        //this.jlbEtiqueta.setSize(300, 200);
        this.getContentPane().add(this.jbtCargaArchivos, BorderLayout.SOUTH);
        
        Object datos[][] = servicioSAT.obtenerArray(servicioSAT.conseguirEmpresas("201311"));//hardcoded
        String cabeceras[] = {"Nombre Empresa", "Periodo", "Estado", "Cargar archivo", "Ruta archivo"};
        
        this.tablaEmpresas = new JTable(new TableModelSAT(datos, cabeceras));
        //Controladores de columnas
        BotonCAlmacenSAT renderizadorColumnas = new BotonCAlmacenSAT();
        ButtonEditor editorBotones = new ButtonEditor(new JCheckBox());
        //tablaEmpresas.getColumnName(3);
        this.tablaEmpresas.getColumn(tablaEmpresas.getColumnName(3)).setCellRenderer(renderizadorColumnas);
        this.tablaEmpresas.getColumn(tablaEmpresas.getColumnName(3)).setCellEditor(editorBotones);
        //Agregamos otro manejador para modificar la columna de Ruta Archivo
        CellEditor editorCeldas = new CellEditor(new JTextField());
        this.tablaEmpresas.getColumn(tablaEmpresas.getColumnName(2)).setCellEditor(editorCeldas);
        //this.tablaEmpresas.setForeground(Color.RED);
        
        JScrollPane jsp = new JScrollPane();
        jsp.setViewportView(this.tablaEmpresas);
        
        this.getContentPane().add(jsp, BorderLayout.CENTER);
        //this.pack();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        //System.out.println("Cerrando Ventana");
        this.ventanaPadre.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
