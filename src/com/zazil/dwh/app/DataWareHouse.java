/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app;

import com.zazil.dwh.app.gui.MenuPrincipalVentana;
import com.zazil.dwh.app.util.Cliente;
import com.zazil.dwh.app.util.Servidor;
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
        //Iniciamos el servidor.
        //Servidor server = new Servidor();//192.168.1.180
        //new Thread(server).run();
        //Iniciamos el cliente
        //Cliente cliente = new Cliente();
        //Iniciamos la aplicacion.
        DataWareHouse App = new DataWareHouse();
    }
}
