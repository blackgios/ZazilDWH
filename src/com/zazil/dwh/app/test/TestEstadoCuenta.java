/**
 *  Clase para probar los metodos del DAO Estado de Cuenta
 *  
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.test;

import com.zazil.dwh.app.bussiness.EmpresaService;
import com.zazil.dwh.app.bussiness.EstadoCuentaService;
import com.zazil.dwh.app.dao.EstadoCuentaDAO;
import com.zazil.dwh.app.model.EstadoCuentaBean;
import com.zazil.dwh.app.util.AppException;
import com.zazil.dwh.app.util.ServiceLocator;
import java.sql.Connection;
import java.util.ArrayList;

public class TestEstadoCuenta {
    
    public static void main(String[] args) throws AppException {
        //Creamos una lista donde guardaremos los resultados de la base de datos
        ArrayList<EstadoCuentaBean> listaEstadosCuenta;
        ArrayList<EstadoCuentaBean> listaEstadosCuenta2;
        //Creamos el dao para obtener datos desde la Base de Datos
        EstadoCuentaDAO dao = new EstadoCuentaDAO();
        //Usaremos un RFC de la base de datos: GPV120928NB5
        //listaEstadosCuenta = dao.obtenerEstadosCuentaRFC("GPV120928NB5");
        EstadoCuentaService servicio = new EstadoCuentaService("GPV120928NB5");
        //rango = servicio.obtenerRango(listaEstadosCuenta);//Obtiene todos los registros
        //listaEstadosCuenta2 = servicio.obtenerEstadosCuenta("GPV120928NB5",rango);
//        System.out.println("Lista2: " + listaEstadosCuenta2.size());
//        for (EstadoCuentaBean estadoCuentaBean : listaEstadosCuenta2) {
//            System.out.println("Cuenta: " + estadoCuentaBean.getCuenta() + " Periodo: " + estadoCuentaBean.getPeriodo() + " SaldoF: " + estadoCuentaBean.getSaldoFinal());
//        }
        /*
         * El dao no tiene metodos para saber si los parametros cumplen 
         * con la norma especificada por lo que podemos llamar al dao
         * con valores invalidos: 
         * 
         * listaEstadosCuenta = dao.obtenerEstadoCuenta("", "", "");
         * 
         * Esto lo debemos hacer mas robusto en la 
         * capa de servicios, ahi recibimos los valores y los validamos 
         * antes de enviarlos al dao
        */
        
        //Hacemos una llamada a la funcion con valores validos
//        listaEstadosCuenta = dao.obtenerEstadosCuenta("GPV120928NB5", "20131010", "20131020");
//        
//        for (int i = 0; i < listaEstadosCuenta.size(); i++) {
//            System.out.println("rfcEmpresa: " + listaEstadosCuenta.get(i).getRfcEmpresa());
//            System.out.println("bancoSISCAM: " + listaEstadosCuenta.get(i).getBancoSISCAM());
//            System.out.println("cuenta: " + listaEstadosCuenta.get(i).getCuenta());
//            System.out.println("periodo: " + listaEstadosCuenta.get(i).getPeriodo());
//            System.out.println("saldo inicial: " + listaEstadosCuenta.get(i).getSaldoInicial());
//            System.out.println("saldo final: " + listaEstadosCuenta.get(i).getSaldoFinal());
//            System.out.println("entradas: " + listaEstadosCuenta.get(i).getEntradas());
//            System.out.println("salidas: " + listaEstadosCuenta.get(i).getSalidas());
//            System.out.println("");
//        }
        
    }
}
