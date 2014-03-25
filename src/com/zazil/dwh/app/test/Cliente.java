/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    final String HOST = "localhost";
    final int PUERTO = 3350;
    Socket socket;
    DataOutputStream mensaje;
    BufferedReader entrada;
    String respuesta;
    public void initClient(){
        try {
            System.out.println("Cliente iniciado");
            socket = new Socket(HOST, PUERTO);
            mensaje = new DataOutputStream(socket.getOutputStream());
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //respuesta = entrada.readLine();
            mensaje.writeUTF("Hola Servidor, acabo de conectarme.\n");
            //System.out.println("Nos conectamos: " + respuesta);
            mensaje.writeUTF("Hola Servidor, soy el Cliente Gio");
            //respuesta = entrada.readLine();
            //System.out.println("Cliente: Respuesta del servidor: " + respuesta);
            //mensaje.close();
            socket.close();
        } catch (UnknownHostException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
