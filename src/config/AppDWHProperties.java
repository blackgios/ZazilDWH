/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 *
 * @author Hector Rodriguez
 */
public class AppDWHProperties {
    public static String FILE_CONFIG = "/config/APPDWH.properties";
    private static Properties propertiesObject;
    
    static{
        init();
    }
    
    private static void init(){
        try{
            if(AppDWHProperties.propertiesObject == null){
                AppDWHProperties.propertiesObject = new Properties();
                InputStream streamEntrada = null;
                /** Cargamos datos desde el stream (fichero), y despues se los cargamos al objeto Properties */
                streamEntrada = AppDWHProperties.class.getResourceAsStream(FILE_CONFIG);
                /** Cargamos los datos de configuracion al propio objeto*/
                AppDWHProperties.propertiesObject.load(streamEntrada);
            }
        }catch(Exception ex){
            System.out.println("No se pudo encontrar fichero de configuracion" + ex.getMessage());
        }
    }
    
    public static String getProperty(String key){
        String value = AppDWHProperties.propertiesObject.getProperty(key);
        if(value == null){
            System.out.println("Valor de configuracion no encontrado" + key);
        }
        
        return value;
    }
    
    public static String getProperty(String key, String defaultKey){
        String value = AppDWHProperties.propertiesObject.getProperty(key, defaultKey);
        if(value == null){
            System.out.println("Valor de configuracion no encontrado" + key);
        }
        
        return value;
    }
    
    public static String asString(){
        Enumeration en = AppDWHProperties.propertiesObject.keys();
        StringBuilder sb= new StringBuilder();
        String key = null;
        while(en.hasMoreElements()){
            key = (String) en.nextElement();
            sb.append(key).append("=").append(AppDWHProperties.propertiesObject.getProperty(key)).append("\n");
        }
        return sb.toString();
    }
    
}
