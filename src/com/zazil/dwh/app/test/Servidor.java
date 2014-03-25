/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    private ServerSocket serverSocket;
    private Socket socket;
    final int PUERTO = 3350;
    DataOutputStream streamSalida;
    String mensaje;
    public void initServer(){
        try {
            BufferedReader entradaDatos;
            
            serverSocket = new ServerSocket(PUERTO);
            socket = new Socket();
            System.out.println("Servidor: Esperando conexion...");
            socket = serverSocket.accept();
            System.out.println("Servidor: Un cliente se ha conectado!");
            entradaDatos = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            streamSalida = new DataOutputStream(socket.getOutputStream());
            System.out.println("Servidor: Confirmando conexion con cliente");
            streamSalida.writeUTF("Servidor: Conexion exitosa");
            //System.out.println("Antes");
            mensaje = entradaDatos.readLine();
            System.out.println("Mensaje: " + mensaje);
            mensaje = entradaDatos.readLine();
            //System.out.println("Despues");
            System.out.println("Mensaje recibido: " + mensaje);
            streamSalida.writeUTF("Server: Mensaje recibido!!");
            //streamSalida.writeUTF("Terminando conexion");
            System.out.println("Terminando Conexion");
            serverSocket.close();
        } catch (IOException ex) {
            System.out.println("Excepcion Server: " + ex.getMessage());
        }
        
        
    }
    
}
