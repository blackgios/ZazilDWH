/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app;

import com.zazil.dwh.app.gui.MenuPrincipalVentana;

public class DataWareHouse {

    public DataWareHouse(){
        MenuPrincipalVentana interfazGrafica = new MenuPrincipalVentana();
        interfazGrafica.setVisible(true);
    }
    
    public static void main(String[] args) {
        DataWareHouse App = new DataWareHouse();
        //System.out.println("Clase: " + App.toString());
    }
}
