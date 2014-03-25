/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    private String ipDestino = "127.0.0.1";//IP de localhost, maquina e red local, o maquina en internet.
    private int puerto = 3350;
    private String nombreArchivoOrigen = "C:\\compost.pdf";

    public Cliente() {
        
            Socket socket = null;
            FileInputStream inStream = null;
            FileOutputStream outStream = null;
        try {
            socket = new Socket(ipDestino, puerto);
            outStream = (FileOutputStream) socket.getOutputStream();
            inStream = new FileInputStream(new File(nombreArchivoOrigen));
        } catch (UnknownHostException ex) {
            System.out.println("Excepcion, error de conexion: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Excepcion: " + ex.getMessage());
        }
        //Enviando la informacion
        try{
            socket.sendUrgentData(100);
            byte[] buffer = new byte[1024];
            int longitud;
            while((longitud = inStream.read(buffer)) != 0){
                outStream.write(buffer, 0, longitud);
            }
            outStream.close();
            inStream.close();
        } catch(IOException ex){
            System.out.println("Excepcion: " + ex.getMessage());
        }
    }
    
    
    
    
    
}
