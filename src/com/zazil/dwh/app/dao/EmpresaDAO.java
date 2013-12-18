/**
 *  Clase para acceder y operar en la Tabla Empresa 
 *  de la base de datos ZazilDataWareHouse.
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.dao;

import com.zazil.dwh.app.model.EmpresaBean;
import com.zazil.dwh.app.util.AppException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpresaDAO extends BaseDAO{
    private ResultSet resultados = null;

    public EmpresaDAO(Connection cnx) {
        super(cnx);
    }
    
    /**
     * 
     * @return ArrayList<Empresas>
     */
    public ArrayList obtenerEmpresas(){
        ArrayList<EmpresaBean> listaEmpresas = new ArrayList<>();
        String query = "select * from Empresa";
        try(Connection cnx = this.obtenerConexion();
                Statement consulta = cnx.createStatement()){
            resultados = consulta.executeQuery(query);
            while(resultados.next()){
                EmpresaBean empresa = new EmpresaBean(resultados.getString("rfcEmpresa"), 
                        resultados.getString("nombreEmpresa"), 
                        resultados.getInt("empresaSISCAM"));
                listaEmpresas.add(empresa);
            }
            
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
        }
        return listaEmpresas;
    }
    
    /**
     * Metodo que nos devuelve una empresa en base al rfc que le hemos pasado como parametro
     * Nota: el metodo no verifica si el rfc es o no valido, debemos implementar esto en una capa superior
     * esto por si alguien desea usar el metodo a mano y no mediante la clase Service asociada
     * Nota: Este metodo es sensible a inyeccion SQL... se necesitan propuestas para hacerlo mas seguro.
     * 
     * @param rfc
     * @return EmpresaBean
     */
    public EmpresaBean obtenerEmpresaRFC(String rfc){
        //TODO Terminado Hector Giovanni Rodriguez Ramos
        EmpresaBean empresa = null;
        //Creamos la consulta
        StringBuilder query = new StringBuilder("select * from Empresa where rfcEmpresa = '");
        query.append(rfc).append("'");
        //Conectamos a la base de datos
        try(Connection cnx = this.obtenerConexion();
                Statement consulta = cnx.createStatement()){
        //Ejecutamos la consulta y obtenemos resultados
            resultados = consulta.executeQuery(query.toString());
        //Si tenemos resultados los guardamos en un Bean si no es asi devolvemos Bean vacio.
            if(resultados.next()){
                empresa = new EmpresaBean(resultados.getString("rfcEmpresa"), 
                        resultados.getString("nombreEmpresa"), 
                        resultados.getInt("empresaSISCAM"));
            }
            
        }catch(SQLException | AppException ex){
            System.out.println("Excepcion: " + ex.getMessage());
        }
        //Regresamos el Bean
        return empresa;
        
    }
    
    /**
     * Metodo que obtiene una empresa en base al numero del sistema SISCAM que
     * tiene asignado.
     * @param siscam
     * @return 
     */
    public EmpresaBean obtenerEmpresaSISCAM(int siscam){
        EmpresaBean empresa = null;
        
        StringBuilder query = new StringBuilder("select * from Empresa where empresaSISCAM = ");
        query.append(query);
        try(Connection cnx = this.obtenerConexion();
                Statement consulta = cnx.createStatement()){
            resultados = consulta.executeQuery(query.toString());
            if(resultados.next()){
                empresa = new EmpresaBean(resultados.getString("rfcEmpresa"), 
                        resultados.getString("nombreEmpresa"), 
                        resultados.getInt("empresaSISCAM"));
            }
        }catch(Exception ex){
            System.out.println("Excepcion: " + ex.getMessage());
        }
        
        return empresa;
    }
    
}
