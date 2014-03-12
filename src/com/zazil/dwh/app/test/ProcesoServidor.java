/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.test;

public class ProcesoServidor extends Thread{
    Servidor server = new Servidor();
    @Override
    public void run() {
        server.initServer();
        //super.run();
    }
    
}
