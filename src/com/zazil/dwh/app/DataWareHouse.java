/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zazil.dwh.app;

import com.zazil.dwh.app.bussiness.EmpresaService;
import com.zazil.dwh.app.dao.EmpresaDAO;
import com.zazil.dwh.app.gui.MenuPrincipalVentana;
import com.zazil.dwh.app.model.EmpresaBean;
import java.util.ArrayList;

/**
 *
 * @author Hector Rodriguez
 */
public class DataWareHouse {
public static final ArrayList<EmpresaBean> listaEmpresas = EmpresaService.obtenerEmpresas();

    public DataWareHouse() {
        MenuPrincipalVentana interfazGrafica = new MenuPrincipalVentana();
        interfazGrafica.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        DataWareHouse App = new DataWareHouse();
        //System.out.println("Clase: " + App.toString());
    }
    
    /**
     * Metodo que inicia los componentes de 
     */
    private void iniciarComponentes(){
        
        
    }
}
