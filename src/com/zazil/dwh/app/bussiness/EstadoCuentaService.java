/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.bussiness;

import com.zazil.dwh.app.model.EstadoCuentaBean;
import com.zazil.dwh.app.util.Rango;
import com.zazil.dwh.app.util.Saldos;
import java.util.ArrayList;

public class EstadoCuentaService {
    
    public Rango detectarRangos(ArrayList<EstadoCuentaBean> listaEstadosCuenta){
        Rango rangoFechas = new Rango(0, 0);
        rangoFechas.setRangoInicial(Integer.parseInt(listaEstadosCuenta.get(0).getPeriodo()));
        
        int buffer = 0;

        //System.out.println("menor: " + rangoFechas.getRangoInicial());
        for (EstadoCuentaBean estadoCuentaBean : listaEstadosCuenta) {

            rangoFechas.setRangoFinal(Integer.parseInt(estadoCuentaBean.getPeriodo()));
            if(rangoFechas.getRangoInicial() > rangoFechas.getRangoFinal()){
                buffer = rangoFechas.getRangoFinal();
                rangoFechas.setRangoFinal(rangoFechas.getRangoInicial());
                rangoFechas.setRangoInicial(buffer);
            }
            System.out.println("Mayor: " + rangoFechas.getRangoFinal() + " menor: " + rangoFechas.getRangoInicial());
        }
        return rangoFechas;
    }
    
    public void calcularEstadosCuenta(ArrayList<EstadoCuentaBean> listaEstadosCuenta){
        Saldos saldoMonitor;
        /**
         * creamos un array en el que se van a detectar cambios en los estados de cuenta
         * 
         */
        for (EstadoCuentaBean estadoCuentaBean : listaEstadosCuenta) {
            /**
             * buscamos los estados de cuenta primero por dia y despues por banco
             */
            saldoMonitor = new Saldos(estadoCuentaBean.getSaldoInicial(),
                    estadoCuentaBean.getEntradas(),
                    estadoCuentaBean.getSalidas(),
                    estadoCuentaBean.getSaldoFinal(),
                    estadoCuentaBean.getPeriodo());
            //Obtenemos SdoIni, Entradas, Salidas, SdoFin
//            estadoCuentaBean.getSaldoInicial();
//            estadoCuentaBean.getEntradas();
//            estadoCuentaBean.getSalidas();
//            estadoCuentaBean.getSalidas();
        }
        
        
    }
    
    
    
    
}
