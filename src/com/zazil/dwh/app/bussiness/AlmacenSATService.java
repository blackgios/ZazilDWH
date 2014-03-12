/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.bussiness;

import com.zazil.dwh.app.dao.AlmacenDAO;
import com.zazil.dwh.app.model.AlmacenBean;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AlmacenSATService {
    private ArrayList<AlmacenBean> listaDeclaraciones;
    private AlmacenDAO AlmacenDAO;
    
    private ArrayList<AlmacenBean> obtenerDeclaraciones(String rfcEmpresa){
        if(rfcEmpresa.length() == 12){
            this.AlmacenDAO = new AlmacenDAO();
            this.listaDeclaraciones = this.AlmacenDAO.obtenerEstados(rfcEmpresa);
        }else{
            JOptionPane.showMessageDialog(null, "RFC Incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return this.listaDeclaraciones;
    }
    
    public ArrayList<AlmacenBean> conseguirEmpresas(String periodo){
        this.AlmacenDAO = new AlmacenDAO();
        ArrayList<AlmacenBean> empresasNoDeclaradas = this.AlmacenDAO.obtenerEmpresas(periodo);
        return empresasNoDeclaradas;
    }
    
    public Object[][] obtenerArray(ArrayList<AlmacenBean> lista){
        //Obtenemos array de Empresa/Estado
        int tamañoLista = lista.size();
        int numeroDatos = 5;
        Object[][] datos = new Object[tamañoLista][numeroDatos];
        //Obtenemos solo array de empresas no declaradas, en este caso de la lista, son todos
        EmpresaService servicioEmpresa = new EmpresaService();
        
        for (int i = 0; i < tamañoLista; i++) {
            //Obtenemos nombreEmpresa
            String nombreEmpresa = servicioEmpresa.obtenerNombreEmpresa(lista.get(i).getRfcEmpresa());
            
            //System.out.println("" + lista.get(i).getRfcEmpresa());
            //System.out.println("" + nombreEmpresa);
            datos[i][0] = nombreEmpresa;
            //Obtenemos periodoFormateado
            StringBuilder periodo = new StringBuilder();
            periodo.append(lista.get(i).getPeriodo().substring(4, 6)).append("-");
            periodo.append(lista.get(i).getPeriodo().substring(0, 4));
            
            datos[i][1] = periodo.toString();
            datos[i][2] = "NO DECLARADO";
            datos[i][3] = "Cargar provision";
            datos[i][4] = "Archivo *.pdf no encontrado";
        }
        return datos;
    }
    
}
