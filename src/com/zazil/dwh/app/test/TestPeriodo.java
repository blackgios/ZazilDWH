/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.test;

public class TestPeriodo {
    
    public static void main(String[] args) {
//        String periodoIni = "20131002";
//        String periodoFin = "20131203";
        String periodos[] = {"20131102","20131003","20131004","20131005","20131006","20131010","20131101","20131002","20131203"};
        TestPeriodo obj = new TestPeriodo();
        obj.rangos(periodos);
    }

    private void rangos(String lista[]){
        int menor = Integer.parseInt(lista[0]);
        int buffer = 0;
        int mayor = 0 ;
        //Integer numero = 512698;
        
        int numero[] = {0,0,0,0,0,0,0,0};
        
        for (String string : lista) {
            mayor = Integer.parseInt(string);
            if(menor > mayor){
                System.out.println("Cambiando Mayor: " + menor + " por Menor: " + mayor);
                buffer = mayor;
                mayor = menor;
                menor = buffer;
                
            }else{
                
            }
            System.out.println("Info: " + string);
        }
        System.out.println("\nMenor: " + menor + " Mayor: " + mayor);
        //Obtener de una cantidad las siguientes cantidades: unidades, decenas, centenas, uMillar, dMillar, cMillar, uMillon, dMillon
        boolean banderaA;
        for (int i = 0; i < menor; i++) {
            numero[7]++;
        }
        System.out.println();
    }
    //Hay que detectar cuantos meses hay en toda la lista
    
    
}
