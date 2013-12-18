/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zazil.dwh.app.util;

import config.AppDWHProperties;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hector Rodriguez
 */
public class ServiceLocator {
    private static ServiceLocator instance = new ServiceLocator();
    //Inicializador de instancia
    {
        try{
            String driver = null;
            
            driver = AppDWHProperties.getProperty("dwh.bd.driver");
            Class.forName(driver);
        }catch(ClassNotFoundException ex){
            System.err.println("Error cargando driver: " + ex.getMessage());
        }
    }
    
    public static ServiceLocator getInstance(){
        return instance;
    }
    
    public Connection getConnection() throws AppException{
        String url = AppDWHProperties.getProperty("dwh.bd.url");
        String user = AppDWHProperties.getProperty("dwh.bd.usuario");
        String password = AppDWHProperties.getProperty("dwh.bd.password");
        
        Connection conexion = null;
        //System.out.println("Intentando conexion");
        try{
            conexion = DriverManager.getConnection(url, user, password);
            /** Metadatos de la base de datos */
            DatabaseMetaData dbMetaData = conexion.getMetaData();
            String productName = dbMetaData.getDatabaseProductName();
            String productVersion = dbMetaData.getDatabaseProductVersion();
            //System.out.println("Conexion Realizada!");
            
//            System.out.println("Metadatos:");
//            System.out.println("Base de datos: " + productName);
//            System.out.println("Version base: " + productVersion);
        }catch(SQLException ex){
            throw new AppException("Error al obtener la conexion",ex);
        }
        return conexion;
    }
    
}
