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

    public EmpresaBean obtenerEmpresa(String nombreEmpresa){
        EmpresaBean empresaEncontrada = null;
        ArrayList<EmpresaBean> listaEmpresas = EmpresaService.obtenerEmpresas();
        for (EmpresaBean empresaBean : listaEmpresas) {
            if(empresaBean.getNombreEmpresa().equals(nombreEmpresa)){ 
                empresaEncontrada = empresaBean;
            }
        }
        return empresaEncontrada;
    }
    
    public ArrayList obtenerNombresEmpresas(){
        ArrayList<String> listaNombres = new ArrayList<>();
        ArrayList<EmpresaBean> listaEmpresas = new ArrayList<>();
        
        try(Connection cnx = ServiceLocator.getInstance().getConnection()){
            EmpresaDAO dao = new EmpresaDAO(cnx);
            listaEmpresas = dao.obtenerEmpresas();
            
        }catch(AppException | SQLException ex){
            System.out.println("Excepcion: " + ex.getMessage());
        }
        
        for (EmpresaBean empresaBean : listaEmpresas) {
            listaNombres.add(empresaBean.getNombreEmpresa());
        }
        return listaNombres;
    }
}
