/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fecha {
    private String FORMATO_FECHA_SISTEMA = "YYYYMMdd";
    
    /**
     *  Obtiene periodo de la fecha actual.
     * @return 
     */
    public String obtenerPeriodo(){
        Date fechaActual = Calendar.getInstance().getTime();
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA_SISTEMA);
        
        String periodo = formateador.format(fechaActual);
        return periodo;
    }
    
    /**
     *  Obtiene periodo de una fecha pasada como parametro.
     * @param fecha
     * @return 
     */
    public String obtenerPeriodo(Date fecha){
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA_SISTEMA);
        
        String periodo = formateador.format(fecha);
        return periodo;
    }
    
    
    public static void main(String[] args) {
        Fecha obj = new Fecha();
        System.out.println("Metodo: ");
        System.out.println("" + obj.obtenerPeriodo());;
        
        Calendar objCalendar = Calendar.getInstance();
        objCalendar.set(2013, Calendar.NOVEMBER, 20);
        System.out.println("" + Calendar.YEAR);
        
        Date fechaCualquiera = objCalendar.getTime();
        System.out.println("" + obj.obtenerPeriodo(fechaCualquiera));;
        //fechaCualquiera;
    }
}
