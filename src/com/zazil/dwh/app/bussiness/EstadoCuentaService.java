/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.bussiness;

import com.zazil.dwh.app.dao.EstadoCuentaDAO;
import com.zazil.dwh.app.model.EstadoCuentaBean;
import com.zazil.dwh.app.model.SaldoBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class EstadoCuentaService {
    //****************************************************** Propiedades
    private ArrayList<EstadoCuentaBean> listaEstadosCuenta;
    private int periodoMayor;
    private int periodoMenor;
    private SortedMap<String,SortedMap<String,ArrayList<String>>> mapaGeneral = new TreeMap<>();
    //****************************************************** Constructor
    public EstadoCuentaService(String rfcEmpresa){
        this.obtenerEstadosCuenta(rfcEmpresa);
        if(estadoOptimo()){
            this.obtenerMayor();
            this.obtenerMenor();
            this.crearMapa();
        }
    }
    //****************************************************** Getters & Setters
    public int getPeriodoMayor() {
        return periodoMayor;
    }

    private void setPeriodoMayor(int periodoMayor) {
        this.periodoMayor = periodoMayor;
    }

    public int getPeriodoMenor() {
        return periodoMenor;
    }

    private void setPeriodoMenor(int periodoMenor) {
        this.periodoMenor = periodoMenor;
    }
    //****************************************************** Metodos Adicionales
    private void obtenerEstadosCuenta(String rfcEmpresa){
        EstadoCuentaDAO dao = new EstadoCuentaDAO();
        this.listaEstadosCuenta = dao.obtenerEstadosCuentaRFC(rfcEmpresa);
    }
    /**
     * Metodo que ve si la lista esta iniciada y contiene elementos
     * @return 
     */
    public final boolean estadoOptimo(){
        boolean estado;
        if(this.listaEstadosCuenta == null || this.listaEstadosCuenta.isEmpty()){
            estado = false;
        } else {
            estado = true;
        }
        return estado;
    }
    
    //Obtener estado cuenta mayor
    private void obtenerMayor(){
        this.setPeriodoMayor(0);
        //Si la lista no es nula y la lista no esta vacia
        if(this.estadoOptimo()){
            this.periodoMayor = Integer.parseInt(listaEstadosCuenta.get(0).getPeriodo());
            int auxiliar;

            for (EstadoCuentaBean estadoCuentaBean : this.listaEstadosCuenta) {
                auxiliar = Integer.parseInt(estadoCuentaBean.getPeriodo());
                if(auxiliar > this.periodoMayor){
                    this.setPeriodoMayor(auxiliar);
                }
            }
            //System.out.println("Periodo Mayor: " + this.getPeriodoMayor());
        }
    }
    //Obtener estado cuenta menor
    private void obtenerMenor(){
        this.setPeriodoMenor(0);
        //Si la lista no es nula y la lista no esta vacia
        if(this.estadoOptimo()){
            this.periodoMenor = Integer.parseInt(listaEstadosCuenta.get(0).getPeriodo());
            //System.out.println("periodoMenor: " + listaEstadosCuenta.get(0).getPeriodo());
            int auxiliar;

            for (EstadoCuentaBean estadoCuentaBean : this.listaEstadosCuenta) {
                auxiliar = Integer.parseInt(estadoCuentaBean.getPeriodo());
                if(auxiliar < this.periodoMenor){
                    this.setPeriodoMenor(auxiliar);
                }
            }
            //System.out.println("Periodo Menor: " + this.getPeriodoMenor());
        }
    }
    private void crearMapa(){
        for(Iterator<EstadoCuentaBean> it = this.listaEstadosCuenta.iterator(); it.hasNext();) {
            //Con Iterator Obtenemos un objeto de la listaGeneral de estados de cuenta
            EstadoCuentaBean estadoCuentaBean = it.next();
            //Del Bean obtenemos su año, periodo es AAAAMMDD, nos interesa AAAA, es decir substring desde 0 hasta N = 4
            String año = estadoCuentaBean.getPeriodo().substring(0, 4);
            //Del Bean obtenemos su mes, periodo es AAAAMMDD, nos interesa MM, es decir substring desde 4 hasta N = 6
            String mes = estadoCuentaBean.getPeriodo().substring(4, 6);
            //Del Bean obtenemos su dia, periodo es AAAAMMDD, nos interesa DD, es decir substring desde 6 hasta periodo.length
            String dia = estadoCuentaBean.getPeriodo().substring(6);
            //Verificamos si contiene la llave
            if(this.mapaGeneral.containsKey(año)){
                //si contiene el mes
                if(this.mapaGeneral.get(año).containsKey(mes)){
                    //Si ya contiene el mes obtenemos lista y verificamos si contiene dia
                    if(this.mapaGeneral.get(año).get(mes).contains(dia)){
                        //Ya contiene el dia por lo que no hacemos nada
                    }else{
                        this.mapaGeneral.get(año).get(mes).add(dia);
                        //System.out.println("Añadido Dia:"+ dia);
                    }
                }else{//Tiene año y mapa de meses pero no contiene mes y por ende tampoco lista dias
                    ArrayList<String> listaDias = new ArrayList<>();
                    listaDias.add(dia);
                    this.mapaGeneral.get(año).put(mes, listaDias);
                    //System.out.println("Añadido Mes:"+ mes + " Dia:"+ dia);
                }
            }else{//si no contiene el año, entonces no tiene mapa asociado
                SortedMap<String,ArrayList<String>> mapaMeses = new TreeMap<>();
                ArrayList<String> listaDias = new ArrayList<>();
                listaDias.add(dia);
                mapaMeses.put(mes, listaDias);
                this.mapaGeneral.put(año, mapaMeses);
                //System.out.println("Primero: " + "Año: " + año + " Mes:"+ mes + " Dia:"+ dia);
            }
            
        //System.out.println("Numero de meses: " + mapaGeneral.get(año).keySet().size());
        //**************************************************** for para recorrer la super estructura antes creada
        
        }//Del for principal
        //System.out.println("\n");
//        System.out.println("\nNumero de años: " + this.mapaGeneral.keySet().size());
        /*
        for (Map.Entry<String, SortedMap<String, ArrayList<String>>> listaAños : mapaGeneral.entrySet()) {
            String año = listaAños.getKey();
            SortedMap<String, ArrayList<String>> MapaAños = listaAños.getValue();
            System.out.println("Año: " + año);
            for (Map.Entry<String, ArrayList<String>> MapaMeses : MapaAños.entrySet()) {
                String mes = MapaMeses.getKey();
                ArrayList<String> listaDias = MapaMeses.getValue();
                System.out.println("Mes: " + mes);
                for (Iterator<String> it = listaDias.iterator(); it.hasNext();) {
                    String dia = it.next();
                    System.out.print("" + dia + "\t");
                }
                System.out.println("");
            }
        }
        */
    }
    /**
     * Problema: se rellenan los combos de la forma en manera de cascada, 
     * primero año inicial, despues mes inicial, despues dia inicial,
     * despues año final, despues mes final, despues dia final.
     * 
     * El service ya tiene el mapa asociado, puede devolver todas las keys que contiene
     * asi como la lista de dias del mes seleccionado.
     * @return 
     */
    public Set<String> obtieneAños(){
        Set<String> keySet = this.mapaGeneral.keySet();
        //System.out.println("Tamaño: " + keySet.size());
        return keySet;
    }
    
    public Set<String> obtieneMeses(String año){
        Set<String> listaMeses = this.mapaGeneral.get(año).keySet();
        return listaMeses;
    }
    
    public ArrayList<String> obtieneDias(String año, String mes){
        ArrayList<String> listaDias = this.mapaGeneral.get(año).get(mes);
        return listaDias;
    }
    /**
     * Recibimos 2 periodos y obtenemos sublista de la lista general
     * @param pI
     * @param pF
     * @return 
     */
    public ArrayList<EstadoCuentaBean> sublista(String pI, String pF){
        //En periodos debemos siempre recibir un entero de 8 digitos
        int periodoIni = Integer.parseInt(pI);
        int periodoFin = Integer.parseInt(pF);
        ArrayList<EstadoCuentaBean> subLista = new ArrayList<>();
        for (EstadoCuentaBean estadoCuentaBean : this.listaEstadosCuenta) {
            int periodo = Integer.parseInt(estadoCuentaBean.getPeriodo());
            //Si el periodo es mayor o igual al periodo inicial o es menor o igual al periodo final entonces lo agregamos a la lista
            if( (periodo >= periodoIni) | (periodo <= periodoFin) ){
                subLista.add(estadoCuentaBean);
            }
        }
        return subLista;
    }
    
    /**
     * Dada una subLista obtenemos lista de los estados de cuenta relevantes
     */
    public ArrayList<EstadoCuentaBean> actividades(ArrayList<EstadoCuentaBean> estadoC){
        ArrayList<EstadoCuentaBean> listaCambios = new ArrayList<>();
        //Se agrega como referencia el primer elemento
        listaCambios.add(estadoC.get(0));
        SaldoBean saldoInicial = new SaldoBean(estadoC.get(0));
        for (EstadoCuentaBean estadoCuentaBean : estadoC) {
            SaldoBean saldoMonitor = new SaldoBean(estadoCuentaBean);
            //Agregamos los estados de cuenta mientras estos hayan cambiado
            if(!( saldoInicial.equals(saldoMonitor) )){
                listaCambios.add(estadoCuentaBean);
                saldoInicial = saldoMonitor;
            }
        }
        
        return listaCambios;
    }
    /**
     * Con el parametro lista obtenemos informacion para llenar 
     * la tabla de estados de cuenta que se desplegara en ventana
     * @param lista
     * @return 
     */
    public Object[][] obtenerArray(ArrayList<EstadoCuentaBean> lista){
        int tamañoLista = lista.size();
        int numeroDatos = 5;
        //Tamaño lista = numero de items, 5 = periodo, SdoIni, Entradas, Salidas, SdoFin
        Object datosTabla[][] = new Object[tamañoLista][numeroDatos];
        for (int i = 0; i < tamañoLista; i++) {
            String periodo = lista.get(i).getPeriodo();
            StringBuilder periodoFormateado = new StringBuilder();
            periodoFormateado.append(periodo.substring(6)).append("-");
            periodoFormateado.append(periodo.substring(4, 6)).append("-");
            periodoFormateado.append(periodo.substring(0, 4));
            
            datosTabla[i][0] = periodoFormateado.toString();
            datosTabla[i][1] = lista.get(i).getSaldoInicial();
            datosTabla[i][2] = lista.get(i).getEntradas();
            datosTabla[i][3] = lista.get(i).getSalidas();
            datosTabla[i][4] = lista.get(i).getSaldoFinal();
        }
        return datosTabla;
    }
}
