/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.test;

import com.zazil.dwh.app.bussiness.EmpresaService;
import com.zazil.dwh.app.dao.EstadoCuentaDAO;
import com.zazil.dwh.app.model.EmpresaBean;
import com.zazil.dwh.app.model.EstadoCuentaBean;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TestJOptionpane {
    public static void main(String[] args) {
        //probaremos la integracion entre las clases ya creadas y el uso de JOptionpane
        EmpresaService servicio = new EmpresaService();
        Object obj = JOptionPane.showInputDialog(null, "Valores", "Titulo", JOptionPane.QUESTION_MESSAGE, null, servicio.obtenerNombresEmpresas().toArray(), 1);
        System.out.println("Empresa seleccionada: " + obj);
        //SegundoPaso: Busqueda de la empresa
        EmpresaBean bean = servicio.obtenerEmpresa(obj.toString());
        System.out.println("Los datos de la empresa son: ");
        System.out.println("rfcEmpresa: " + bean.getRfcEmpresa());
        System.out.println("nombreEmpresa: " + bean.getNombreEmpresa());
        System.out.println("numeroSISCAM: " + bean.getEmpresaSISCAM());
        //TercerPaso: Busqueda de Estados de cuenta
        EstadoCuentaDAO dao = new EstadoCuentaDAO();
        ArrayList<EstadoCuentaBean> listaEstadosCuenta = dao.obtenerEstadosCuentaRFC(bean.getRfcEmpresa());
        for (EstadoCuentaBean estadoCuentaBean : listaEstadosCuenta) {
            System.out.println("rfc: " + estadoCuentaBean.getRfcEmpresa());
            System.out.println("banco: " + estadoCuentaBean.getBancoSISCAM());
            System.out.println("Periodo: " + estadoCuentaBean.getPeriodo());
            System.out.println("SaldoIni: " + estadoCuentaBean.getSaldoInicial());
            System.out.println("Entradas: " + estadoCuentaBean.getEntradas());
            System.out.println("Salidas: " + estadoCuentaBean.getSalidas());
            System.out.println("SaldoFin: " + estadoCuentaBean.getSaldoFinal());
        }
        
    }
}
