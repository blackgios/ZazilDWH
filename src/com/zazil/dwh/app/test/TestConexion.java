/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zazil.dwh.app.test;

/**
 *
 * @author Hector Rodriguez
 */
public class TestConexion {
    public static void main(String[] args) {
        ProcesoServidor servidor = new ProcesoServidor();
        Cliente cliente = new Cliente();
        servidor.start();
        System.out.println("Hola");
        cliente.initClient();
    }
}
