/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zazil.dwh.app.test;

import com.zazil.dwh.app.dao.EstadoCuentaDAO;
import com.zazil.dwh.app.model.EstadoCuentaBean;
import com.zazil.dwh.app.util.AppException;
import com.zazil.dwh.app.util.Mes;
import com.zazil.dwh.app.util.ServiceLocator;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Hector Rodriguez
 */
public class TestEstadoCuenta {
    public static void main(String[] args) throws AppException {
        Connection cnx = ServiceLocator.getInstance().getConnection();
        
        //Ejemplo de funcionamiento del metodo obtenerEstadoCuentaRFC()
        ArrayList<EstadoCuentaBean> listaEstadosCuenta;
        EstadoCuentaDAO dao = new EstadoCuentaDAO();
        //Usaremos un RFC de la base de datos: GPV120928NB5
        listaEstadosCuenta = dao.obtenerEstadoCuentaRFC("GPV120928NB5");
        /*
        for (int i = 0; i < listaEstadosCuenta.size(); i++) {
            System.out.println("rfcEmpresa: " + listaEstadosCuenta.get(i).getRfcEmpresa());
            System.out.println("bancoSISCAM: " + listaEstadosCuenta.get(i).getBancoSISCAM());
            System.out.println("cuenta: " + listaEstadosCuenta.get(i).getCuenta());
            System.out.println("perido: " + listaEstadosCuenta.get(i).getPerido());
            System.out.println("saldo inicial: " + listaEstadosCuenta.get(i).getSaldoInicial());
            System.out.println("saldo final: " + listaEstadosCuenta.get(i).getSaldoFinal());
            System.out.println("entradas: " + listaEstadosCuenta.get(i).getEntradas());
            System.out.println("salidas: " + listaEstadosCuenta.get(i).getSalidas());
            System.out.println("");
        }
        */
        dao.obtenerEstadosCuenta("GPV120928NB5", Mes.ENERO);
    }
}
