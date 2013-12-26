/**
 *  Clase para acceder y operar en la Tabla EstadoCuenta 
 *  de la base de datos ZazilDataWareHouse
 * 
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.dao;

import com.zazil.dwh.app.model.EstadoCuentaBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class EstadoCuentaDAO extends BaseDAO{
    //Resultados de la base de datos
    private ResultSet resultados;
    //Lista de los estados de cuenta de la empresa
    private ArrayList<EstadoCuentaBean> listaEstadosCuenta = new ArrayList<>();
    
    /**
     * Metodo que obtiene TODOS los estados de cuenta de una empresa
     * Atencion: Los estados de cuenta se generan al dia, por lo que 
     * esta consulta es muy pero muy pesada, se recomienda ejecutar 
     * las consultas especificas que se encuentran mas abajo!!
     * 
     * @param rfc
     * @return 
     */
    public ArrayList obtenerEstadoCuentaRFC(String rfc){
        //1.- Creamos el query para la base de datos con el parametro a usar
        StringBuilder query = new StringBuilder("select * from EstadoCuenta where rfcEmpresa = '");
        query.append(rfc).append("'");
        //2.- Creamo conexion y ejecutamos consulta
        try(Connection cnx = this.obtenerConexion();
                Statement consulta = cnx.createStatement()){
            resultados = consulta.executeQuery(query.toString());
            
            while(resultados.next()){
                EstadoCuentaBean estadoCuenta = new EstadoCuentaBean(resultados.getString("rfcEmpresa"), 
                        resultados.getInt("bancoSISCAM"), 
                        resultados.getString("cuenta"), 
                        resultados.getString("periodo"), 
                        resultados.getLong("saldoInicial"), 
                        resultados.getLong("saldoFinal"), 
                        resultados.getLong("entradas"), 
                        resultados.getLong("salidas"));
                //Añadimos el estado de cuenta a la lista
                this.listaEstadosCuenta.add(estadoCuenta);
            }
            
        }catch(Exception ex){
            System.out.println("Excepcion: " + ex.getMessage());
        }
        
        return listaEstadosCuenta;
    }
    
    /**
     *  Este metodo nos devuelve el estado de cuenta de una empresa en un
     *  dia especifico, este se especifica con el parametro periodo.
     *  
     *  por ejemplo si periodo es 20131102, se consulta el estado de cuenta
     *  de la empresa en el dia 2 de noviembre de 2013.
     * 
     * @param rfc
     * @param periodo
     * @return 
     */
    public ArrayList obtenerEstadoCuenta(String rfc, String periodo){
        //En el metodo rfc es un String de 12 caracteres y periodo es un String de 8 caracteres
        StringBuilder query = new StringBuilder("select * from EstadoCuenta where rfcEmpresa = '");
        query.append(rfc).append("' and periodo = '").append(periodo).append("'");
        try(Connection cnx = this.obtenerConexion();
                Statement consulta = cnx.createStatement()){
            resultados = consulta.executeQuery(query.toString());
            
            while(resultados.next()){
                EstadoCuentaBean estadoCuenta = new EstadoCuentaBean(resultados.getString("rfcEmpresa"), 
                        resultados.getInt("bancoSISCAM"), 
                        resultados.getString("cuenta"), 
                        resultados.getString("periodo"), 
                        resultados.getLong("saldoInicial"), 
                        resultados.getLong("saldoFinal"), 
                        resultados.getLong("entradas"), 
                        resultados.getLong("salidas"));
                //Añadimos el estado de cuenta a la lista
                this.listaEstadosCuenta.add(estadoCuenta);
            }
        }catch(Exception ex){
            System.out.println("Excepcion: " + ex.getMessage());
        }
        
        return listaEstadosCuenta;
    }

    public ArrayList obtenerEstadoCuenta(String rfc, String periodoInicial, String periodoFinal){
        //En el metodo rfc es un String de 12 caracteres y los periodos son String de 8 caracteres
        StringBuilder query = new StringBuilder("select * from EstadoCuenta where rfcEmpresa = '");
        query.append(rfc).append("' and periodo between '").append(periodoInicial).append("' and '");
        query.append(periodoFinal).append("'");
        
        try(Connection cnx = this.obtenerConexion();
                Statement consulta = cnx.createStatement()){
            resultados = consulta.executeQuery(query.toString());
            
            while(resultados.next()){
                EstadoCuentaBean estadoCuenta = new EstadoCuentaBean(resultados.getString("rfcEmpresa"), 
                        resultados.getInt("bancoSISCAM"), 
                        resultados.getString("cuenta"), 
                        resultados.getString("periodo"), 
                        resultados.getLong("saldoInicial"), 
                        resultados.getLong("saldoFinal"), 
                        resultados.getLong("entradas"), 
                        resultados.getLong("salidas"));
                //Añadimos el estado de cuenta a la lista
                this.listaEstadosCuenta.add(estadoCuenta);
            }
        }catch(Exception ex){
            System.out.println("Excepcion: " + ex.getMessage());
        }
        
        return this.listaEstadosCuenta;
    }

}
