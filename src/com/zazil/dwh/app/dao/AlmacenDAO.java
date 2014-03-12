/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.dao;

import com.zazil.dwh.app.model.AlmacenBean;
import com.zazil.dwh.app.util.AppException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlmacenDAO extends BaseDAO{
    private ResultSet resultados;
    private ArrayList<AlmacenBean> listaDeclaraciones;
    
    public ArrayList<AlmacenBean> obtenerEstados(String rfcEmpresa){
        this.listaDeclaraciones = new ArrayList<>();
        try(Connection cnx = this.obtenerConexion();
                Statement consulta = cnx.createStatement()){
            StringBuilder query = new StringBuilder();
            query.append("select * from almacenSAT where rfcEmpresa = '");
            query.append(rfcEmpresa).append("';");
            resultados = consulta.executeQuery(query.toString());
            while(resultados.next()){
                boolean estado = false;
                String bandera = resultados.getString("estado");
                if(bandera.equalsIgnoreCase("D")){
                    estado = true;
                }
                AlmacenBean bean = new AlmacenBean(resultados.getString("rfcEmpresa"), 
                        resultados.getString("periodo"), 
                        estado, 
                        resultados.getString("ruta"));
                
                this.listaDeclaraciones.add(bean);
            }
            
        }catch(Exception ex){
            System.out.println("Excepcion: " + ex.getMessage());
        }
        return this.listaDeclaraciones;
    }
    
    public ArrayList<AlmacenBean> obtenerEmpresas(String periodo){
        this.listaDeclaraciones = new ArrayList<>();
        if(periodo.length() == 6){
            //System.out.println("DAO");
            try(Connection cnx = this.obtenerConexion();
                    Statement consulta = cnx.createStatement()){
                StringBuilder query = new StringBuilder("select * from almacenSAT where periodo = '");
                query.append(periodo).append("';");
                
                this.resultados = consulta.executeQuery(query.toString());
                
                while(this.resultados.next()){
                    //Creamos objeto con datos
                    AlmacenBean bean = new AlmacenBean(resultados.getString("rfcEmpresa"), 
                            resultados.getString("periodo"), 
                            resultados.getBoolean("estado"), 
                            resultados.getString("archivo"));
                    //Añadimos objeto a la lista
                    listaDeclaraciones.add(bean);
                }
            }catch(SQLException | AppException ex){
                System.out.println("Excepcion: " + ex.getMessage());
            }
            
            
        }
        return this.listaDeclaraciones;
    }
    
    
}
