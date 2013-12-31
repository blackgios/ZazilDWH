/**
 * En esta Clase se guardan 2 valores enteros que indican la fecha inicial y 
 * final de una lista de datos
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.util;

public class Rango {
    private int rangoInicial;
    private int rangoFinal;

    public Rango(int rangoInicial, int rangoFinal) {
        this.setRangoInicial(rangoInicial);
        this.setRangoFinal(rangoFinal);
    }
    
    public int getRangoInicial() {
        return rangoInicial;
    }

    public void setRangoInicial(int rangoInicial) {
        this.rangoInicial = rangoInicial;
    }

    public int getRangoFinal() {
        return rangoFinal;
    }

    public void setRangoFinal(int rangoFinal) {
        this.rangoFinal = rangoFinal;
    }
    
    @Override
    public String toString(){
        //System.out.println("Rango inicial: " + this.getRangoInicial() + " Rango final: " + this.getRangoFinal());
        return "Rango inicial: " + this.getRangoInicial() + " Rango final: " + this.getRangoFinal();
    }
}
