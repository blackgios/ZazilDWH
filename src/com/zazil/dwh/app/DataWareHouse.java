/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app;

import com.zazil.dwh.app.gui.MenuPrincipalVentana;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

public class DataWareHouse {

    public DataWareHouse(){
        MenuPrincipalVentana interfazGrafica = new MenuPrincipalVentana();
        interfazGrafica.setVisible(true);
    }
    
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DataWareHouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DataWareHouse App = new DataWareHouse();
    }
}
