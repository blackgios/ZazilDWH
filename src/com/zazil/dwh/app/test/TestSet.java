/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.test;

import java.util.Set;
import java.util.TreeSet;

public class TestSet {
    public static void main(String[] args) {
        Set<String> listaUnica = new TreeSet<>();
        
        listaUnica.add("hola ");
        listaUnica.add("amigo ");
        listaUnica.add("espero ");
        listaUnica.add("estes ");
        listaUnica.add("bien ");
        for (String string : listaUnica) {
            System.out.print(string);
        }
        
    }
}
