/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.test;

import java.awt.HeadlessException;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class TestJComboBox extends JFrame{
    private JComboBox comboPrueba;
    public TestJComboBox() throws HeadlessException {
        this.setTitle("Prueba de JComboBox");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.iniciarComponentes();
        
    }
    
    public static void main(String[] args) {
        TestJComboBox obj = new TestJComboBox();
        obj.setVisible(true);
    }
    
    private void iniciarComponentes(){
        this.getContentPane().setLayout(null);
        //Inicializacion numero 1
        comboPrueba = new JComboBox();
        
        comboPrueba.addItem("Hola");
        comboPrueba.addItem("Amigo");
        comboPrueba.addItem("Juan");
        comboPrueba.setSize(20, 50);
        this.getContentPane().add(comboPrueba);
        
        comboPrueba.setBounds(0, 0, 200, 20);
    }
}
