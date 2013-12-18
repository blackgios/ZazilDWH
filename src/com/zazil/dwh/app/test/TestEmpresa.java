/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zazil.dwh.app.test;

import com.zazil.dwh.app.bussiness.EmpresaService;
import com.zazil.dwh.app.dao.EmpresaDAO;
import com.zazil.dwh.app.model.EmpresaBean;
import com.zazil.dwh.app.util.AppException;
import com.zazil.dwh.app.util.ServiceLocator;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Hector Rodriguez
 */
public class TestEmpresa {
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        System.out.println("Realizando pruebas:");
        EmpresaService servicio = new EmpresaService();
        try{
            //System.out.println("Entra al try");
//            for (String string : servicio.obtenerEmpresas()) {
//                System.out.println("EmpresaBean: " + string);
//            }
            Connection cnx = ServiceLocator.getInstance().getConnection();         
            EmpresaDAO obj = new EmpresaDAO(cnx);
            
            ArrayList<EmpresaBean> listaEmpresas;
            EmpresaBean empresaActual;
            
            listaEmpresas = obj.obtenerEmpresas();
            
            for (int i = 0; i < listaEmpresas.size(); i++) {
                empresaActual = listaEmpresas.get(i);
                
                System.out.println("rfc: "+ empresaActual.getRfcEmpresa());
                System.out.println("nombre: "+ empresaActual.getNombreEmpresa());
                System.out.println("siscam: "+ empresaActual.getEmpresaSISCAM());
                System.out.println("");
            }
            //while(listaEmpresas.get(index))
            
            
            //Test metodo con rfc
//            EmpresaBean emp = obj.obtenerEmpresaRFC("CDD130603N40");
//            
//            System.out.println("EmpresaBean: " + emp.getNombreEmpresa());
//            System.out.println("RFC: " + emp.getRfcEmpresa());
//            System.out.println("SISCAM: " + emp.getEmpresaSISCAM());
            
            
//            
//            int contador = 0;
//            while(contador < servicio.obtenerEmpresas().size()){
//                System.out.println(servicio.obtenerEmpresas().get(contador));
//                contador++;
//            }

        }catch(AppException ex){
            System.out.println("Se lanza Excepcion: " + ex.getMessage());
        }
    }
}
