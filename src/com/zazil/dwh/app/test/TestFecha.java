/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zazil.dwh.app.test;

import com.zazil.dwh.app.dao.EstadoCuentaDAO;
import com.zazil.dwh.app.model.EstadoCuentaBean;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Hector Rodriguez
 */
public class TestFecha {
    public static void main(String[] args) throws ParseException {
        Calendar diaN = Calendar.getInstance();
        //diaN.set(Calendar.YEAR, Calendar.MONTH, Calendar.DATE);
//        diaN.get(Calendar.DAY_OF_WEEK);
        //System.out.println("Dia de la semana: " + diaN.getTime());
        System.out.println("Año: " + Calendar.YEAR + " Año: " + diaN.get(Calendar.YEAR));
        System.out.println("Fecha: " + diaN.getTime());
        diaN.set(Calendar.YEAR, 2012);
        System.out.println("Año: " + Calendar.YEAR + " Año: " + diaN.get(Calendar.YEAR));
        System.out.println("Fecha: " + diaN.getTime());
//        System.out.println("Mes: " + Calendar.MONTH);
//        System.out.println("Dia: " + Calendar.DATE);
        
//        ArrayList<EstadoCuentaBean> listaEstadosCuenta;
//        EstadoCuentaDAO dao = new EstadoCuentaDAO();
//        listaEstadosCuenta = dao.obtenerEstadoCuenta("GPV120928NB5", "20131010");
        
        
        //TestFecha obj = new TestFecha();
//        Calendar fecha = Calendar.getInstance();
//        fecha.set(Integer.parseInt(obj.getFecha().substring(0, 3)), Integer.parseInt(obj.getFecha().substring(4,5)), Integer.parseInt(obj.getFecha().substring(6)));
//        System.out.println("Fecha: " + fecha.getTime());
        
        //String patron = "yyyyMMdd";
        //SimpleDateFormat df = new SimpleDateFormat(patron);
        //System.out.println("Dia: " + df.parse(obj.getFecha()));
        
//        Date diaActual = fecha.getTime();
//        Calendar fecha2 = Calendar.getInstance();
//        fecha2.set(year, month, date);
        //diaMod = fecha2.getTime();
        
//        System.out.println("Dia del mes: " + fecha.get(Calendar.DAY_OF_MONTH));
//        System.out.println("Mes del año: " + fecha.get(Calendar.MONTH));//los meses van desde 0 hasta 11
//        System.out.println("Año: " + fecha.get(Calendar.YEAR));
        
    }
    
}
