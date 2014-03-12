/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.test;

import com.zazil.dwh.app.bussiness.EstadoCuentaService;
import com.zazil.dwh.app.model.EstadoCuentaBean;
import java.util.ArrayList;
import javax.swing.JTable;

public class TestTable {
    
    public static void main(String[] args) {
        EstadoCuentaService service = new EstadoCuentaService("GBE121114RY8");
        ArrayList<EstadoCuentaBean> sublista = service.sublista("20130930", "20131120");
        System.out.println("Primer for");
        for (EstadoCuentaBean estadoCuentaBean : sublista) {
            System.out.println("" + estadoCuentaBean.getPeriodo());
        }
        System.out.println("Segundo for");
        ArrayList<EstadoCuentaBean> actividades = service.actividades(service.sublista("20130930", "20131120"));
        
        for (EstadoCuentaBean estadoCuentaBean : actividades) {
            System.out.println("" + estadoCuentaBean.getPeriodo());
        }
        System.out.println("Tercer for");
        Object[][] datos = service.obtenerArray(service.actividades(service.sublista("20130930", "20131120")));
        
        for (Object[] objects : datos) {
            for (int i = 0; i < objects.length; i++) {
                System.out.print("\t" + objects[i] + "\t");
            }
            System.out.println("");
        }
        
        String[] header = {"Periodo","Saldo Inicial", "Entradas", "Salidas", "Saldo Final"};
        JTable tabla = new JTable(datos, header);
        
        Ventana marco = new Ventana(tabla, "Ventana prueba");
        
        
        /**
        for (String string : service.obtieneAños()) {
            System.out.println("Año: " + string);
        }
        for (String string : service.obtieneMeses("2013")) {
            System.out.println("Mes: " + string);
        }
        for (String string : service.obtieneDias("2013", "10")) {
            System.out.println("Dias: " + string);
        }
        */
        
        
        
    }
}
