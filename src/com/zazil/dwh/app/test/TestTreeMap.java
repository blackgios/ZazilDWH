/**
 *
 * @author hector
 */
package com.zazil.dwh.app.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TestTreeMap {
    public static void main(String[] args) {
        //TreeMap mapa = new TreeMap();
        SortedMap<String,SortedMap<String,ArrayList<String>>> mapaGeneral = new TreeMap<>();
        
        SortedMap<String,ArrayList<String>> mapaMensual = new TreeMap<>();
        
        ArrayList<String> listaDias = new ArrayList<>();
        
        mapaGeneral.put("2013", mapaMensual);
        
        for (int i = 0; i < 10; i++) {
            listaDias.add(Integer.toString(i));
        }
        mapaMensual.put("01", listaDias);
        
        ArrayList<String> listaDias2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listaDias2.add(Integer.toString(i));
        }
        mapaMensual.put("02", listaDias2);
        
        ArrayList<String> listaDias3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listaDias3.add(Integer.toString(i));
        }
        mapaMensual.put("03", listaDias3);
        
        System.out.println("Leer mapa mensual");
        for (Map.Entry<String, ArrayList<String>> mapaMeses : mapaMensual.entrySet()) {
            String mes = mapaMeses.getKey();
            ArrayList<String> dias = mapaMeses.getValue();
            System.out.println("Mes: " + mes);
            for (Iterator<String> it = dias.iterator(); it.hasNext();) {
                String dia = it.next();
                System.out.print(" " + dia + "\t");
            }
            System.out.println("");
        }
        System.out.println("Leer mapa mensual desde mapa general");
        for (Map.Entry<String, SortedMap<String, ArrayList<String>>> listaAños : mapaGeneral.entrySet()) {
            String año = listaAños.getKey();
            SortedMap<String,ArrayList<String>> listaMeses = listaAños.getValue();
            System.out.println("Año: " + año);
            for (Map.Entry<String, ArrayList<String>> entry : listaMeses.entrySet()) {
                String mes = entry.getKey();
                ArrayList<String> listadias = entry.getValue();
                System.out.println("Mes: " + mes);
                for (Iterator<String> it = listadias.iterator(); it.hasNext();) {
                    String dia = it.next();
                    System.out.print("" + dia + "\t");
                }
                System.out.println("");
            }
        }
        System.out.println("Cantidad de meses en mapa: " + mapaGeneral.size());
        System.out.println("Numero de llaves: " + mapaGeneral.keySet().size());//Da 1 y es valido por que solo hay 1 año
        //mapaGeneral.firstKey();
        mapaGeneral.get(mapaGeneral.firstKey()).keySet().size();
        System.out.println("Numero de llaves: " + mapaGeneral.get(mapaGeneral.firstKey()).keySet().size());
    }
}
