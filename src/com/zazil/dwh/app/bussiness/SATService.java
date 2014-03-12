/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zazil.dwh.app.bussiness;

import com.zazil.dwh.app.dao.SATDAO;
import com.zazil.dwh.app.model.SATBean;
import java.util.ArrayList;

/**
 *  Esta clase Service consulta 2 tablas: Tabla "SAT" y tabla "almacenSAT"
 * @author Ana Carolina
 */
public class SATService {
    //Busca la ultima declaracion de acuerdo al rfc de la empresa
    
    public ArrayList obtenerDeclaraciones (){
        ArrayList <SATBean> listaDeclara = null;
        SATDAO dao = new SATDAO();
        //Que sucede si ArrayList obtenido del dao esta vacio?, es decir no tiene informacion?
        listaDeclara = dao.obtenerSAT();
        
        return listaDeclara;
    }
    
    public SATBean obtenerDec(String rfcEmpresa){
        SATBean declaraEncontrada = null;
        ArrayList<SATBean> listaEmpresas = this.obtenerDeclaraciones();
        for (SATBean satBean: listaEmpresas){
            if (satBean.getRfcEmpresa().equals(rfcEmpresa)) {
                declaraEncontrada=satBean;
                //System.out.println("Empresa: " + declaraEncontrada.getRfcEmpresa());
            }
        }
        return declaraEncontrada;
    }
    
}
