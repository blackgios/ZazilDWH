/*
 * Clase para acceder y operar en la Tabla SAT
 * de la base de datos ZazilDataWareHouse.
 * @author Ana Martinez
 */
package com.zazil.dwh.app.dao;

import com.zazil.dwh.app.model.SATBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SATDAO extends BaseDAO{
    //Resultset de la base de datos
    private ResultSet resultados = null;
    
    //Lista de los datos del SAT
    /**
     * Nota: Declare la lista como un atributo de la clase 
     * asi se ahorra memoria al no crear una lista nueva 
     * cada vez que se llame a un metodo.
     */
    private ArrayList<SATBean> listaSAT = new ArrayList<>();

         public ArrayList<SATBean> obtenerSAT () {
            //1. Creamos query con parametro de entrada RFC
            StringBuilder query = new StringBuilder ("select * from SAT");
            //2.- Creamos conexion y ejecutamos consulta
            try(Connection cnx = this.obtenerConexion();
                Statement consulta = cnx.createStatement()){
                resultados = consulta.executeQuery(query.toString());
            //cambio de if por while
             while(resultados.next()){
                SATBean satBean = new SATBean (resultados.getString("rfcEmpresa"),
                        resultados.getString("accesoSAT"),
                        resultados.getString("periodoUltaDecl"), 
                        resultados.getString("periodoUltaDiot"));
                listaSAT.add(satBean);
            }
            
        }catch(Exception ex){
            System.out.println("Excepcion: " + ex.getMessage());
        }         
         return listaSAT;
     }

    
     /**
      * Metodo: public ArrayList obtenerSATRFC (String rfc)
      * Obtiene TODOS los registros de TODOS los periodos de las declaraciones
      * de una empresa dada mediante el parametro rfc.
      * @param rfc
      * @return 
      */
     public SATBean obtenerSATRFC (String rfc) {
         SATBean empresa = null;
         //1. Creamos query con parametro de entrada RFC
         StringBuilder query = new StringBuilder ("select * from SAT where rfcEmpresa = '");
         query.append(rfc).append("'");
         //2.- Creamos conexion y ejecutamos consulta
         try(Connection cnx = this.obtenerConexion();
                 Statement consulta = cnx.createStatement()){
            resultados = consulta.executeQuery(query.toString());
            
             if(resultados.next()){
                empresa = new SATBean (resultados.getString("rfcEmpresa"),
                        resultados.getString("accesoSAT"),
                        resultados.getString("periodoUltDecl"), 
                        resultados.getString("periodoUltDiot"));
            }
            
        }catch(Exception ex){
            System.out.println("Excepcion: " + ex.getMessage());
        }         
        //Regresa el BEAN
         return empresa;
     }

     /**
      * Metodo: public ArrayList obtenerSATSC ()
      * Obtiene TODOS los registros que no tienen declaraciones.
      * @return 
      */
          public ArrayList obtenerSATSC () {
         //1. Creamos query con parametro de entrada RFC
         StringBuilder query = new StringBuilder ("select * from SAT where periodoUltDecl IS NULL");
         //2.- Creamos conexion y ejecutamos consulta
         try(Connection cnx = this.obtenerConexion();
                 Statement consulta = cnx.createStatement()){
            resultados = consulta.executeQuery(query.toString());
            
            while(resultados.next()){
                SATBean sat = new SATBean (resultados.getString("rfcEmpresa"),
                        resultados.getString("accesoSAT"),
                        resultados.getString("periodoUltDecl"), 
                        resultados.getString("periodoUltDiot"));
                //Añadimos el estado de cuenta a la lista
                this.listaSAT.add(sat);
            }
            
        }catch(Exception ex){
            System.out.println("Excepcion: " + ex.getMessage());
        }
        
         return this.listaSAT;
     }

          
          
     /**
      * Metodo: public ArrayList obtenerSATMES (MES)
      * Obtiene TODOS los registros del ultimo MES declarado
      * de una MES dado mediante el parametro MES.
      * @param mes
      * @return 
      */
     public ArrayList obtenerSATMes (String mes) {
         //1. Creamos query con parametro de entrada RFC
         StringBuilder query = new StringBuilder ("select * from SAT where peridoUltDecl = '");
         query.append(mes).append("'");
         //2.- Creamos conexion y ejecutamos consulta
         try(Connection cnx = this.obtenerConexion();
                 Statement consulta = cnx.createStatement()){
            resultados = consulta.executeQuery(query.toString());
            
            while(resultados.next()){
                SATBean sat = new SATBean (resultados.getString("rfcEmpresa"),
                        resultados.getString("accesoSAT"),
                        resultados.getString("periodoUltDecl"), 
                        resultados.getString("periodoUltDiot"));
                //Añadimos el estado de cuenta a la lista
                this.listaSAT.add(sat);
            }
            
        }catch(Exception ex){
            System.out.println("Excepcion: " + ex.getMessage());
        }
        
         return this.listaSAT;
     }

}
