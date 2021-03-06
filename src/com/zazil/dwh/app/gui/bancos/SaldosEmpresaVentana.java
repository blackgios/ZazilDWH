/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.gui.bancos;

import com.zazil.dwh.app.bussiness.EmpresaService;
import com.zazil.dwh.app.bussiness.EstadoCuentaService;
import com.zazil.dwh.app.model.EmpresaBean;
import com.zazil.dwh.app.model.EstadoCuentaBean;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
//018001234242
public class SaldosEmpresaVentana extends javax.swing.JFrame {
    private JFrame padre;
    private EmpresaService serviciosEmpresa;
    private EstadoCuentaService serviciosCuenta;
    private boolean estadoActivo = false;
    
    
    public SaldosEmpresaVentana(JFrame owner) {
        this.padre = owner;
        this.serviciosEmpresa = new EmpresaService();
        //Hasta el final se hace la llamada al JDialog
        this.initComponents();
        this.verComponentes(false);
    }
    
    private void actualizaCombos2(){
        //Vaciamos combos
        this.borrarCombos();
        //Rellenamos combo de años
        for (String año : serviciosCuenta.obtieneAños()) {
            this.jcbSeleccionAñoIni.addItem(año);
        }
        Object añosSelec = this.jcbSeleccionAñoIni.getSelectedItem();
        for (String mes : serviciosCuenta.obtieneMeses(añosSelec.toString())) {
            this.jcbSeleccionMesIni.addItem(mes);
        }
        Object mesSelec = this.jcbSeleccionMesFin.getSelectedItem();
        for (String diaSelec : serviciosCuenta.obtieneDias(añosSelec.toString(), mesSelec.toString())) {
            this.jcbSeleccionInicio.addItem(diaSelec);
        }
        
        
        
    }
    
    private void actualizarCombos(){
        //System.out.println("Entrando: private void actualizarCombos()");
        Set<String> listaAños = serviciosCuenta.obtieneAños();
        for (String año : listaAños) {
            this.jcbSeleccionAñoIni.addItem(año);
            this.jcbSeleccionAñoFin.addItem(año);
        }
        
        String AñoIni = this.jcbSeleccionAñoIni.getSelectedItem().toString();
        String AñoFin = this.jcbSeleccionAñoFin.getSelectedItem().toString();
        
        this.jcbSeleccionMesIni.removeAllItems();
        this.jcbSeleccionInicio.removeAllItems();
        Set<String> listaMesesIni = serviciosCuenta.obtieneMeses(AñoIni);
        Set<String> listaMesesFin = serviciosCuenta.obtieneMeses(AñoFin);
        for (String mes : listaMesesIni) {
            this.jcbSeleccionMesIni.addItem(mes);
        }
        for (String mes : listaMesesFin) {
            this.jcbSeleccionMesFin.addItem(mes);
        }
        
        String MesIni = this.jcbSeleccionMesIni.getSelectedItem().toString();
        String MesFin = this.jcbSeleccionMesFin.getSelectedItem().toString();
        ArrayList<String> listaDiasIni = serviciosCuenta.obtieneDias(AñoIni, MesIni);
        ArrayList<String> listaDiasFin = serviciosCuenta.obtieneDias(AñoFin, MesFin);
        
        for (String dia : listaDiasIni) {
            this.jcbSeleccionInicio.addItem(dia);
        }
        for (String dia : listaDiasFin) {
            this.jcbSeleccionFin.addItem(dia);
        }
        this.jcbSeleccionFin.setSelectedIndex(this.jcbSeleccionFin.getItemCount() - 1);
        //System.out.println("Saliendo: private void actualizarCombos()");
    }
    
    private void borrarCombos(){
        // TODO Borra los items de los combos, lo llamamos cada que seleccionamos una nueva empresa
        this.jcbSeleccionAñoIni.removeAllItems();
        this.jcbSeleccionAñoFin.removeAllItems();
        this.jcbSeleccionMesIni.removeAllItems();
        this.jcbSeleccionMesFin.removeAllItems();
        this.jcbSeleccionInicio.removeAllItems();
        this.jcbSeleccionFin.removeAllItems();
    }

    private void verComponentes(boolean estado){
        this.jcbSeleccionAñoIni.setVisible(estado);
        this.jcbSeleccionAñoFin.setVisible(estado);
        this.jcbSeleccionMesIni.setVisible(estado);
        this.jcbSeleccionMesFin.setVisible(estado);
        this.jcbSeleccionInicio.setVisible(estado);
        this.jcbSeleccionFin.setVisible(estado);
        
        this.jlbSeleccionAño.setVisible(estado);
        this.jlbSeleccionMes.setVisible(estado);
        this.jlbSeleccionDia.setVisible(estado);
        this.jlbSeleccionInicio.setVisible(estado);
        this.jlbSeleccionFin.setVisible(estado);
        
        this.jbtConsultarEmpresa.setEnabled(estado);
        this.jbtSaldos.setEnabled(estado);
        this.jbtHistorial.setEnabled(estado);
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
        jLabel1 = new javax.swing.JLabel();
        jtfEmpresaRFC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbtEmpresas = new javax.swing.JButton();
        jtfNombreEmpresa = new javax.swing.JTextField();
        jbtHistorial = new javax.swing.JButton();
        jbtSaldos = new javax.swing.JButton();
        jbtConsultarEmpresa = new javax.swing.JButton();
        jlbSeleccionAño = new javax.swing.JLabel();
        jcbSeleccionAñoIni = new javax.swing.JComboBox();
        jcbSeleccionMesIni = new javax.swing.JComboBox();
        jcbSeleccionInicio = new javax.swing.JComboBox();
        jcbSeleccionFin = new javax.swing.JComboBox();
        jlbSeleccionMes = new javax.swing.JLabel();
        jlbSeleccionInicio = new javax.swing.JLabel();
        jlbSeleccionFin = new javax.swing.JLabel();
        jlbSeleccionDia = new javax.swing.JLabel();
        jcbSeleccionAñoFin = new javax.swing.JComboBox();
        jcbSeleccionMesFin = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Saldos");
        setPreferredSize(new java.awt.Dimension(600, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione Empresa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), java.awt.Color.blue)); // NOI18N

        jLabel1.setText("Empresa:");

        jtfEmpresaRFC.setEditable(false);
        jtfEmpresaRFC.setBackground(new java.awt.Color(255, 204, 51));
        jtfEmpresaRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEmpresaRFCActionPerformed(evt);
            }
        });

        jLabel2.setText("R.F.C.");

        jbtEmpresas.setText("Empresas");
        jbtEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEmpresasActionPerformed(evt);
            }
        });

        jtfNombreEmpresa.setEditable(false);

        jbtHistorial.setText("Ver Historial");
        jbtHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtHistorialActionPerformed(evt);
            }
        });

        jbtSaldos.setText("Saldos en Bancos");
        jbtSaldos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSaldosActionPerformed(evt);
            }
        });

        jbtConsultarEmpresa.setText("Consultar");
        jbtConsultarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConsultarEmpresaActionPerformed(evt);
            }
        });

        jlbSeleccionAño.setText("Año:");

        jlbSeleccionMes.setText("Mes:");

        jlbSeleccionInicio.setText("Inicio:");

        jlbSeleccionFin.setText("Fin:");

        jlbSeleccionDia.setText("Dia:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jlbSeleccionInicio)
                            .addComponent(jlbSeleccionFin)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfEmpresaRFC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtEmpresas))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jcbSeleccionAñoFin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jlbSeleccionAño)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jcbSeleccionAñoIni, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlbSeleccionMes)
                                    .addComponent(jcbSeleccionMesIni, 0, 126, Short.MAX_VALUE)
                                    .addComponent(jcbSeleccionMesFin, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jlbSeleccionDia)
                                        .addGap(26, 26, 26))
                                    .addComponent(jcbSeleccionInicio, javax.swing.GroupLayout.Alignment.TRAILING, 0, 64, Short.MAX_VALUE)
                                    .addComponent(jcbSeleccionFin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(14, 14, 14)
                                .addComponent(jbtConsultarEmpresa))
                            .addComponent(jtfNombreEmpresa)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addComponent(jbtSaldos, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEmpresaRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jbtEmpresas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbSeleccionAño)
                    .addComponent(jlbSeleccionMes)
                    .addComponent(jlbSeleccionDia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSeleccionAñoIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSeleccionMesIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSeleccionInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbSeleccionInicio)
                    .addComponent(jbtConsultarEmpresa))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSeleccionMesFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSeleccionAñoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbSeleccionFin)
                    .addComponent(jcbSeleccionFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtSaldos)
                    .addComponent(jbtHistorial))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtHistorialActionPerformed
        // TODO add your handling code here:
        HistorialEmpresaVentana historialEmpresa = new HistorialEmpresaVentana(this, true);
        historialEmpresa.setVisible(true);
    }//GEN-LAST:event_jbtHistorialActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.padre.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jbtEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEmpresasActionPerformed
        // TODO En proceso - Hector Giovanni Rodriguez Ramos 02/01/2014
        //Hay que obtener un String de la llamada a la ventana
        Object obj = JOptionPane.showInputDialog(null, "Valores", "Titulo", JOptionPane.QUESTION_MESSAGE, null, this.serviciosEmpresa.obtenerNombresEmpresas().toArray(), 1);
        //System.out.println("Empresa: " + obj.toString());
        if(obj != null){
            
            EmpresaBean bean = serviciosEmpresa.obtenerEmpresa(obj.toString());
            //Rellenamos los campos de la forma con los valores del bean
            this.jtfEmpresaRFC.setText(bean.getRfcEmpresa());
            this.jtfNombreEmpresa.setText(bean.getNombreEmpresa());
            //System.out.println("Empresa: " + bean.getNombreEmpresa() + " RFC: " + bean.getRfcEmpresa());
            this.serviciosCuenta = new EstadoCuentaService(bean.getRfcEmpresa());
            //Podemos consultar los datos de los estados de cuenta y desde este punto advertir si hay o no saldos o siquiera cuenta en banco
            boolean existenSaldos = serviciosCuenta.estadoOptimo();//serviciosCuenta.existenciaSaldos(bean.getRfcEmpresa());
            //System.out.println("Hay Saldos: " + existenSaldos);
            if(existenSaldos){
                //Activamos los componentes necesarios: JComboBox
                this.verComponentes(existenSaldos);
                //Si los combos tienen elementos los borramos
                this.borrarCombos();
                //Se actualizan combos
                this.actualizaCombos2();
                //Con esta bandera ya podemos usar el combo de meses
                this.estadoActivo = true;
                //this.actualizarComponentes(serviciosCuenta.getPeriodoMayor(),serviciosCuenta.getPeriodoMenor());
                this.jbtConsultarEmpresa.grabFocus();
            }else{
                this.verComponentes(existenSaldos);
                JOptionPane.showMessageDialog(this, "No hay Saldos para esta empresa", "Saldos de empresa: " + bean.getNombreEmpresa(), JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbtEmpresasActionPerformed

    private void jbtSaldosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSaldosActionPerformed
        // TODO add your handling code here:
        SaldosBanco saldosEmpresa = new SaldosBanco(this, true);
        saldosEmpresa.setVisible(true);
    }//GEN-LAST:event_jbtSaldosActionPerformed

    private void jbtConsultarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConsultarEmpresaActionPerformed
        // TODO Obtener RFC y ejecutar consulta
        if(this.jtfEmpresaRFC.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Se necesita proporcionar RFC");
        }else{
            StringBuilder periodoInicial = new StringBuilder();
            StringBuilder periodoFinal = new StringBuilder();
            //Obtenemos periodo Inicial
            periodoInicial.append(this.jcbSeleccionAñoIni.getSelectedItem().toString());
            periodoInicial.append(this.jcbSeleccionMesIni.getSelectedItem().toString());
            periodoInicial.append(this.jcbSeleccionInicio.getSelectedItem().toString());
            //Obtenemos periodo Final
            periodoFinal.append(this.jcbSeleccionAñoFin.getSelectedItem().toString());
            periodoFinal.append(this.jcbSeleccionMesFin.getSelectedItem().toString());
            periodoFinal.append(this.jcbSeleccionFin.getSelectedItem().toString());
            //Obtenemos sublista objetivo
            ArrayList<EstadoCuentaBean> sublista = serviciosCuenta.sublista(periodoInicial.toString(), periodoFinal.toString());
            //Filtramos solo los estados relevantes
            ArrayList<EstadoCuentaBean> actividades = serviciosCuenta.actividades(sublista);
            //Obtenemos array de datos
            Object[][] datos = serviciosCuenta.obtenerArray(actividades);
            //Creamos cabecera de Informacion
            String[] cabecera = {"Periodo","Saldo Inicial","Entradas","Salidas","Saldo Final"};
            //Creamos JTable
            JTable tabla = new JTable(datos, cabecera);
            
            
            /**
             * Creamos instancia de TablaSaldosVentana 
             * y le enviamos referencia del service que usamos.
             */
            TablaSaldosVentana tablaVentana = new TablaSaldosVentana(this, true, tabla);
        }
    }//GEN-LAST:event_jbtConsultarEmpresaActionPerformed

    private void jtfEmpresaRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEmpresaRFCActionPerformed
        // TODO Mismo comportamiento que pulsar el boton de consulta
        this.jbtConsultarEmpresaActionPerformed(evt);
    }//GEN-LAST:event_jtfEmpresaRFCActionPerformed
/**/
    /***/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtConsultarEmpresa;
    private javax.swing.JButton jbtEmpresas;
    private javax.swing.JButton jbtHistorial;
    private javax.swing.JButton jbtSaldos;
    private javax.swing.JComboBox jcbSeleccionAñoFin;
    private javax.swing.JComboBox jcbSeleccionAñoIni;
    private javax.swing.JComboBox jcbSeleccionFin;
    private javax.swing.JComboBox jcbSeleccionInicio;
    private javax.swing.JComboBox jcbSeleccionMesFin;
    private javax.swing.JComboBox jcbSeleccionMesIni;
    private javax.swing.JLabel jlbSeleccionAño;
    private javax.swing.JLabel jlbSeleccionDia;
    private javax.swing.JLabel jlbSeleccionFin;
    private javax.swing.JLabel jlbSeleccionInicio;
    private javax.swing.JLabel jlbSeleccionMes;
    private javax.swing.JTextField jtfEmpresaRFC;
    private javax.swing.JTextField jtfNombreEmpresa;
    // End of variables declaration//GEN-END:variables
}
