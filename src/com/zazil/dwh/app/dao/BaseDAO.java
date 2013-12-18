/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.dao;

import com.zazil.dwh.app.util.AppException;
import com.zazil.dwh.app.util.ServiceLocator;
import java.sql.Connection;
import java.sql.SQLException;

public class BaseDAO {
    Connection conexion;
    private boolean conexionCompartida;

    /**
     * Al utilizar este constuctor estamos usando una conexion ya creada,
     * por lo cual esta conexion es compartida.
     * @param conexion 
     */
    public BaseDAO(Connection conexion) {
        this.conexion = conexion;
        this.conexionCompartida = true;
    }
    /**
     * Al utilizar este constructor la conexion es creada desde aqui
     */
    public BaseDAO() {
    }
    /**
     * Si nuestra conexion no esta inicializada entonces
     * creamos una invocando a Service Locator.
     * @return
     * @throws AppException 
     */
    public Connection obtenerConexion() throws AppException{
        if(this.conexion == null){
            this.conexion = ServiceLocator.getInstance().getConnection();
        }
        return this.conexion;
    }
    
    public void cerrarConexion(){
        try{
            if(this.conexion != null){
                if(this.esCompartida()){
                    //La conexion se creo en otro lugar por eso no se cierra o provocaremos una SQLException.
                    
                }else{
                    //La conexion se creo aqui y podemos cerrarla sin problemas.
                    this.conexion.close();
                    this.conexion = null;
                }
            }
        }catch(SQLException ex){
            
        }
    }
    
    public boolean esCompartida(){
        return this.conexionCompartida;
    }
}
