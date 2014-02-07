/**
 *
 * @author hector
 */
package com.zazil.dwh.app.test;
//Test EstadoCuenta Service

import com.zazil.dwh.app.bussiness.EmpresaService;
import com.zazil.dwh.app.bussiness.EstadoCuentaService;
import com.zazil.dwh.app.model.EmpresaBean;
import javax.swing.JOptionPane;

public class TestECService {
    public static void main(String[] args) {
        TestECService principal = new TestECService();
        EmpresaBean empresa = principal.obtenerEmpresa();
        
        EstadoCuentaService servicio = new EstadoCuentaService(empresa.getRfcEmpresa());
        servicio.crearMapa();
        
//        System.out.println("Activo: " + servicio.estadoOptimo());
//        System.out.println("Mayor: " + servicio.getPeriodoMayor());
//        System.out.println("Menor: " + servicio.getPeriodoMenor());
    }

    public EmpresaBean obtenerEmpresa(){
        EmpresaService servicioEmpresa = new EmpresaService();
        
        Object obj = JOptionPane.showInputDialog(null, "Valores", "Titulo", JOptionPane.QUESTION_MESSAGE, null, servicioEmpresa.obtenerNombresEmpresas().toArray(), 1);
        System.out.println("Nombre empresa: " + obj.toString() + " RFC: " + servicioEmpresa.obtenerEmpresa(obj.toString()).getRfcEmpresa());
        return servicioEmpresa.obtenerEmpresa(obj.toString());
        
    }
}