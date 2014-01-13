/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zazil.dwh.app.bussiness;

import com.zazil.dwh.app.dao.SATDAO;
import com.zazil.dwh.app.model.SATBean;
import java.util.ArrayList;

/**
 *
 * @author Ana Carolina
 */
public class SATService {
    //Busca la ultima declaracion de acuerdo al rfc de la empresa
    
    public static ArrayList obtenerDeclaraciones (){
        ArrayList <SATBean> listaDeclara = null;
        SATDAO dao = new SATDAO();
        listaDeclara = dao.obtenerSAT();
        
        return listaDeclara;
    }
    
    public SATBean obtenerDec(String rfcEmpresa){
        SATBean declaraEncontrada = null;
        ArrayList<SATBean> listaEmpresas = SATService.obtenerDeclaraciones();
        for (SATBean satBean: listaEmpresas){
            if (satBean.getRfcEmpresa().equals(rfcEmpresa)) {
                declaraEncontrada=satBean;
            }
        }
        return declaraEncontrada;
    }
    
}
