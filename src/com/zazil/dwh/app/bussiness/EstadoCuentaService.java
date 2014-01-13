/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.bussiness;

import com.zazil.dwh.app.dao.EstadoCuentaDAO;
import com.zazil.dwh.app.model.EstadoCuentaBean;
import com.zazil.dwh.app.util.Rango;
import com.zazil.dwh.app.util.Saldos;
import java.util.ArrayList;

public class EstadoCuentaService {
    /**
     * Dado el RFC de una empresa verificamos si tiene estados de cuenta.
     * @param rfcEmpresa
     * @return 
     */
    public boolean existenciaSaldos(ArrayList<EstadoCuentaBean> listaEstadosCuenta){
        boolean hayEstados = false;
        //EstadoCuentaDAO dao = new EstadoCuentaDAO();
        //ArrayList<EstadoCuentaBean> listaEstadosCuenta = dao.obtenerEstadosCuentaRFC(rfcEmpresa);
        //System.out.println("registros: " + listaEstadosCuenta.size());
        if(listaEstadosCuenta.size() > 0){
            hayEstados = true;
        }
        return hayEstados;
    }
    /**
     * Obtenemos una sublista de estados de cuenta
     * @param listaEstadosCuenta
     * @param rango
     * @return 
     */
    private ArrayList obtenerEstadosCuenta(ArrayList<EstadoCuentaBean> listaEstadosCuenta, Rango rango){
        
        ArrayList<EstadoCuentaBean> nuevaListaEstadosCuenta = new ArrayList<>();
        for (EstadoCuentaBean estadoCuentaBean : listaEstadosCuenta) {
            if(Integer.parseInt(estadoCuentaBean.getPeriodo()) >= rango.getRangoInicial()){
                nuevaListaEstadosCuenta.add(estadoCuentaBean);
                System.out.println("Añadido: " + estadoCuentaBean.getPeriodo());
            }
        }
        return listaEstadosCuenta;
    }
    
    
    public Rango obtenerRango(ArrayList<EstadoCuentaBean> listaEstadosCuenta){
        Rango rangoFechas = new Rango(0, 0);
        rangoFechas.setRangoInicial(Integer.parseInt(listaEstadosCuenta.get(0).getPeriodo()));
        int buffer;

        //System.out.println("menor: " + rangoFechas.getRangoInicial());
        for (EstadoCuentaBean estadoCuentaBean : listaEstadosCuenta) {

            rangoFechas.setRangoFinal(Integer.parseInt(estadoCuentaBean.getPeriodo()));
            if(rangoFechas.getRangoInicial() > rangoFechas.getRangoFinal()){
                buffer = rangoFechas.getRangoFinal();
                rangoFechas.setRangoFinal(rangoFechas.getRangoInicial());
                rangoFechas.setRangoInicial(buffer);
            }
            //System.out.println("Mayor: " + rangoFechas.getRangoFinal() + " menor: " + rangoFechas.getRangoInicial());
        }
        return rangoFechas;
    }
    
    public ArrayList obtenerEstadosCuenta(String rfcEmpresa, Rango rango){
        //En base al rango dado obtendremos una sub-lista de la lista total de estados de cuenta.
        ArrayList<EstadoCuentaBean> listaResultados;
        EstadoCuentaDAO dao = new EstadoCuentaDAO();
        String periodoInicial = "" + rango.getRangoInicial();
        String periodoFinal = "" + rango.getRangoFinal();
        
        //System.out.println("RangosInicial: " + periodoInicial + " RangosFinal: " + periodoFinal);
        listaResultados = dao.obtenerEstadosCuenta(rfcEmpresa, periodoInicial, periodoFinal);
        
        return listaResultados;
    }
    
    public ArrayList obtenerEstadosCuenta(String rfcEmpresa){
        EstadoCuentaDAO dao = new EstadoCuentaDAO();
        ArrayList<EstadoCuentaBean> listaEstadosCuenta = dao.obtenerEstadosCuentaRFC(rfcEmpresa);
        return listaEstadosCuenta;
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
