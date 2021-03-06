/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.test;

import com.zazil.dwh.app.bussiness.EmpresaService;
import com.zazil.dwh.app.bussiness.EstadoCuentaService;
import com.zazil.dwh.app.model.EmpresaBean;
import com.zazil.dwh.app.model.EstadoCuentaBean;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

public class SeleccionEmpresasVista extends javax.swing.JFrame {
    private ArrayList<EstadoCuentaBean> listaEstadosCuenta;
    private EmpresaService servicioEmpresa;
    private EstadoCuentaService servicioEstadoCuenta;
    /**
     * Creates new form SeleccionEmpresasVista
     */
    public SeleccionEmpresasVista() {
        this.iniciarServicios();
        this.verCombos(false);//provoca NullPointerException al intentar usar los combos antes de iniciarlos
        initComponents();
        
    }
    private void iniciarServicios(){
        this.apariencia();
        this.servicioEmpresa = new EmpresaService();
    }
    
    private void apariencia(){
        try{
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex){
            System.out.println("Excepcion: " + ex.getMessage());
        }
    }
    
    private void verCombos(boolean estado){
        if(this.jcbSeleccionAñoIni != null){
            this.jcbSeleccionAñoIni.setVisible(estado);
            this.jcbSeleccionAñoFin.setVisible(estado);
            this.jcbSeleccionMesIni.setVisible(estado);
            this.jcbSeleccionMesFin.setVisible(estado);
            this.jcbSeleccionDiaIni.setVisible(estado);
            this.jcbSeleccionDiaFin.setVisible(estado);
        }else{
            System.out.println("Combos no instanciados");
        }
    }
    
    private void vaciarCombos(){
        this.jcbSeleccionAñoIni.removeAllItems();
        this.jcbSeleccionAñoFin.removeAllItems();
        this.jcbSeleccionMesIni.removeAllItems();
        this.jcbSeleccionMesFin.removeAllItems();
        this.jcbSeleccionDiaIni.removeAllItems();
        this.jcbSeleccionDiaFin.removeAllItems();
    }

    private void actualizarCombos(ArrayList<EstadoCuentaBean> listaEstadoCuentas){
        ArrayList<EstadoCuentaBean> listaNueva = new ArrayList<>();
        ArrayList<Integer> listaAños = new ArrayList<>();
        ArrayList<Integer> listaMeses = new ArrayList<>();
        ArrayList<Integer> listaDias = new ArrayList<>();
        for (EstadoCuentaBean estadoCuentaBean : listaEstadoCuentas) {
            //Al recorrer el array 
            listaAños.add(Integer.parseInt(estadoCuentaBean.getPeriodo().substring(0, 4)));
            listaMeses.add(Integer.parseInt(estadoCuentaBean.getPeriodo().substring(4, 6)));
            listaDias.add(Integer.parseInt(estadoCuentaBean.getPeriodo().substring(6)));
            
        }
        for (int i = 0; i < listaEstadoCuentas.size(); i++) {
            System.out.println("Año: " + listaAños.get(i) + " Mes: " + listaMeses.get(i) + " Dias: " + listaDias.get(i));
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbSeleccionAñoIni = new javax.swing.JComboBox();
        jcbSeleccionMesIni = new javax.swing.JComboBox();
        jcbSeleccionDiaIni = new javax.swing.JComboBox();
        jcbSeleccionAñoFin = new javax.swing.JComboBox();
        jcbSeleccionMesFin = new javax.swing.JComboBox();
        jcbSeleccionDiaFin = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfEmpresaNombre = new javax.swing.JTextField();
        jtfEmpresaRFC = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jbtConsultarEmpresas = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jbtSaldosBancos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selección de empresas", 0, 0, null, new java.awt.Color(0, 0, 255)));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccion periodo", 0, 0, null, new java.awt.Color(0, 153, 0)));

        jLabel1.setText("Periodo Inicio:");

        jLabel2.setText("Periodo Fin:");

        jLabel3.setText("Año");

        jLabel4.setText("Mes");

        jLabel5.setText("Dia");

        jcbSeleccionAñoIni.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbSeleccionMesIni.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbSeleccionDiaIni.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbSeleccionAñoFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbSeleccionMesFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbSeleccionDiaFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jcbSeleccionAñoFin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbSeleccionMesFin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jcbSeleccionAñoIni, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(57, 57, 57)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jcbSeleccionMesIni, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jcbSeleccionDiaIni, 0, 70, Short.MAX_VALUE)
                        .addComponent(jcbSeleccionDiaFin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSeleccionAñoIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSeleccionMesIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSeleccionDiaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbSeleccionAñoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSeleccionMesFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSeleccionDiaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        jLabel6.setText("RFC");

        jLabel7.setText("Empresa");

        jtfEmpresaNombre.setEditable(false);

        jtfEmpresaRFC.setEditable(false);

        jButton1.setText("Empresas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jbtConsultarEmpresas.setText("Consultar");
        jbtConsultarEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConsultarEmpresasActionPerformed(evt);
            }
        });

        jButton3.setText("Historial");

        jbtSaldosBancos.setText("Saldos en Bancos");
        jbtSaldosBancos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSaldosBancosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31)
                        .addComponent(jtfEmpresaRFC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfEmpresaNombre))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtConsultarEmpresas)
                        .addGap(41, 41, 41)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(jbtSaldosBancos)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfEmpresaRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfEmpresaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtConsultarEmpresas)
                    .addComponent(jButton3)
                    .addComponent(jbtSaldosBancos))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Object obj = JOptionPane.showInputDialog(null, "Valores", "Titulo", JOptionPane.QUESTION_MESSAGE, null, this.servicioEmpresa.obtenerNombresEmpresas().toArray(), 1);
        
        if(obj != null){
        //Si el usuario no presiono cancelar
        }else{
        // Conserva estado anterior: no hace nada
            System.out.println("No selecciono nada");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void obtenerCombos(){
        StringBuilder periodoInicial = new StringBuilder();
        StringBuilder periodoFinal = new StringBuilder();
        //Rellenamos periodo inicial
        periodoInicial.append(jcbSeleccionAñoIni.getSelectedItem());
        periodoInicial.append(jcbSeleccionMesIni.getSelectedItem());
        periodoInicial.append(jcbSeleccionDiaIni.getSelectedItem());
        //Rellenamos periodo final
        periodoFinal.append(jcbSeleccionAñoFin.getSelectedItem());
        periodoFinal.append(jcbSeleccionMesFin.getSelectedItem());
        periodoFinal.append(jcbSeleccionDiaFin.getSelectedItem());
        //Rango rangos = new Rango(WIDTH, ICONIFIED);
        System.out.println("Combos: \n Inicial: " + periodoInicial + " Final: " + periodoFinal);
    }
    
    private void jbtConsultarEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConsultarEmpresasActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jbtConsultarEmpresasActionPerformed

    private void jbtSaldosBancosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSaldosBancosActionPerformed
        // TODO add your handling code here:
        this.obtenerCombos();
    }//GEN-LAST:event_jbtSaldosBancosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SeleccionEmpresasVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionEmpresasVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionEmpresasVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionEmpresasVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SeleccionEmpresasVista().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbtConsultarEmpresas;
    private javax.swing.JButton jbtSaldosBancos;
    private javax.swing.JComboBox jcbSeleccionAñoFin;
    private javax.swing.JComboBox jcbSeleccionAñoIni;
    private javax.swing.JComboBox jcbSeleccionDiaFin;
    private javax.swing.JComboBox jcbSeleccionDiaIni;
    private javax.swing.JComboBox jcbSeleccionMesFin;
    private javax.swing.JComboBox jcbSeleccionMesIni;
    private javax.swing.JTextField jtfEmpresaNombre;
    private javax.swing.JTextField jtfEmpresaRFC;
    // End of variables declaration//GEN-END:variables
}
