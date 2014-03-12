/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    final String HOST = "localhost";
    final int PUERTO = 3350;
    Socket socket;
    DataOutputStream mensaje;
    DataInputStream entrada;
    
    public void initClient(){
        try {
            socket = new Socket(HOST, PUERTO);
            mensaje = new DataOutputStream(socket.getOutputStream());
            mensaje.writeUTF("Hola servidor, soy el cliente Gio");
            //mensaje.close();
            socket.close();
        } catch (UnknownHostException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
