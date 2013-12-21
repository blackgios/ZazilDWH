/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zazil.dwh.app.test;

import java.awt.HeadlessException;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author Hector Rodriguez
 */
public class TestJComboBox extends JFrame{
    private JComboBox comboPrueba;
    public TestJComboBox() throws HeadlessException {
        this.setTitle("Prueba de JComboBox");
        
    }
    
    public static void main(String[] args) {
        
    }
    
    public void iniciarComponentes(){
        //Inicializacion numero 1
        comboPrueba = new JComboBox();
        
        comboPrueba.addItem("Hola");
    }
}
