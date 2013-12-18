/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.log;

import java.util.ArrayList;

public class Log {
    private ArrayList<String> propiedades;
    
    //TODO grabar informacion
    public void grabarLog(){
        
        this.propiedades = new ArrayList<>();
        
        this.propiedades.add(System.getProperty("user.dir"));
        this.propiedades.add(System.getProperty("user.home"));
        this.propiedades.add(System.getProperty("user.name"));
        this.propiedades.add(System.getProperty("os.arch"));
        this.propiedades.add(System.getProperty("os.name"));
        this.propiedades.add(System.getProperty("os.version"));
        
        for (String string : propiedades) {
            System.out.println("propiedades: " + string);
        }
        
    }
    
    public static void main(String[] args) {
        Log prueba = new Log();
        prueba.grabarLog();
    }
    
    
}
