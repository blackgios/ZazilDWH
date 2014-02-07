/**
 *
 * @author hector
 */
package com.zazil.dwh.app.test;

import com.zazil.dwh.app.bussiness.EmpresaService;
import com.zazil.dwh.app.bussiness.EstadoCuentaService;
import com.zazil.dwh.app.model.EmpresaBean;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JOptionPane;

public class TestECSMapas {
    public static void main(String[] args) {
        EmpresaService serviciosEmpresa = new EmpresaService();
        Object obj = JOptionPane.showInputDialog(null, "Valores", "Titulo", JOptionPane.QUESTION_MESSAGE, null, serviciosEmpresa.obtenerNombresEmpresas().toArray(), 1);
        EmpresaBean bean = serviciosEmpresa.obtenerEmpresa(obj.toString());
        EstadoCuentaService servicioEstadoCuenta= new EstadoCuentaService(bean.getRfcEmpresa());
        
        //servicioEstadoCuenta.obtenerMapas();
        servicioEstadoCuenta.crearMapa();
//        Set<String> set;
//        set = servicioEstadoCuenta.obtieneAños();
//        for (String string : set) {
//            System.out.println("Años: " + string);
//        }
//        
//        set = servicioEstadoCuenta.obtieneMeses("2011");
//        for (String string : set) {
//            System.out.println("Mes de año 2011: " + string);
//        }
//        ArrayList<String> lista;
//        lista = servicioEstadoCuenta.obtieneDias("2011", "02");
//        for (String dia : lista) {
//            System.out.println("Dia: " + dia + " Mes 02 Año 2011");
//        }
        
    }
}
