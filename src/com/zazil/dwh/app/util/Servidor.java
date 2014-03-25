/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor implements Runnable{
    private ServerSocket servidor;
    private final int PUERTO = 3350;
    private String nombreFichero = "C:\\test.pdf";

    public Servidor() {
        try {
            this.servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor corriendo en puerto: " + PUERTO);
        } catch (IOException ex) {
            System.out.println("Excepcion: " + ex.getMessage());
        }
    }
    
//    public void guardarDocumento(String rutaArchivo){
//        this.setNombreFichero(rutaArchivo);
//    }
//    
//    private void setNombreFichero(String nombreFichero) {
//        this.nombreFichero = nombreFichero;
//    }
    
    
    @Override
    public void run() {
        Socket client = null;
        while(true){
            try {
                client = servidor.accept();
                System.out.println("Se conecto un cliente! ");
            } catch (IOException ex) {
                System.out.println("Excepcion: No se pudo conectar el cliente: " + ex.getMessage());
            }
            try{
                InputStream inStream = client.getInputStream();
                FileOutputStream outStream = new FileOutputStream(new File(this.nombreFichero));
                byte[] buffer = new byte[1024];
                int longitud;
                while((longitud = inStream.read(buffer))!= 0){
                    outStream.write(buffer, 0, longitud);
                }
                inStream.close();
                outStream.close();
            } catch(IOException ex){
                System.out.println("Excepcion: " + ex.getMessage());
            }
            
        }
    }
    
}
