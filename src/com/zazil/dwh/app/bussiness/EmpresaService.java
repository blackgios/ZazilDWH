/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.bussiness;

import com.zazil.dwh.app.dao.EmpresaDAO;
import com.zazil.dwh.app.model.EmpresaBean;
import com.zazil.dwh.app.util.AppException;
import com.zazil.dwh.app.util.ServiceLocator;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class EmpresaService {
    
    /**
     * Metodo para obtener lista de empresas en 
     * la tabla Empresas de la base de datos ZazilDataWareHouse
     * @return 
     */
    public static ArrayList obtenerEmpresas(){
        ArrayList<EmpresaBean> listaEmpresas = null;
        
        try(Connection con = ServiceLocator.getInstance().getConnection()){
            EmpresaDAO dao = new EmpresaDAO(con);
            listaEmpresas = dao.obtenerEmpresas();
        }catch(AppException | SQLException ex){
            System.out.println("Excepcion: " + ex.getMessage());
        }
        
        return listaEmpresas;
    }
    
    public static String[] obtenerNombresEmpresas(ArrayList<EmpresaBean> listaEmpresas){
        System.out.println("Numero de Empresas: " + listaEmpresas.size());
//        System.out.println("Primer Empresa: " + listaEmpresas.get(0).getNombreEmpresa());
//        System.out.println("Ultima Empresa: " + listaEmpresas.get(listaEmpresas.size() - 1).getNombreEmpresa());
        String[] listaNombres = new String[listaEmpresas.size() - 1];
        System.out.println("Tamaño del array: " + listaNombres.length);
            //listaEmpresas.toArray(listaNombres);
            for (int i = 0; i < listaEmpresas.size() - 1; i++) {
                listaNombres[i] = listaEmpresas.get(i).getNombreEmpresa();
                System.out.println("Empresa "+ i +": " + listaNombres[i]);
            }
            
        return listaNombres;
    }
    
}
