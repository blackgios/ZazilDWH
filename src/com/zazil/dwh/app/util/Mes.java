/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.util;

public enum Mes {
    ENERO(1), FEBRERO(2), MARZO(3), ABRIL(4),
    MAYO(5), JUNIO(6), JULIO(7), AGOSTO(8),
    SEPTIEMBRE(9), OCTUBRE(10), NOVIEMBRE(11), DICIEMBRE(12);
    /************************************************************************/
    private int numeroMes;
    
    private Mes(int numeroMes) {
        this.numeroMes = numeroMes;
    }
    
    public int numeroMes(){
        return this.numeroMes;
    }
}
