/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.model;

public class SaldoBean extends BaseBean{
    private String periodo;
    private double SaldoInicial;
    private double SaldoFinal;
    private double Entradas;
    private double Salidas;
    
    public SaldoBean(EstadoCuentaBean eB) {
        this.setPeriodo(eB.getPeriodo());
        this.setSaldoInicial(eB.getSaldoInicial());
        this.setEntradas(eB.getEntradas());
        this.setSalidas(eB.getSalidas());
        this.setSaldoFinal(eB.getSaldoFinal());
    }

    public String getPeriodo() {
        return periodo;
    }

    private void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    public double getSaldoInicial() {
        return SaldoInicial;
    }

    private void setSaldoInicial(double SaldoInicial) {
        this.SaldoInicial = SaldoInicial;
    }

    public double getSaldoFinal() {
        return SaldoFinal;
    }

    private void setSaldoFinal(double SaldoFinal) {
        this.SaldoFinal = SaldoFinal;
    }

    public double getEntradas() {
        return Entradas;
    }

    private void setEntradas(double Entradas) {
        this.Entradas = Entradas;
    }

    public double getSalidas() {
        return Salidas;
    }

    private void setSalidas(double Salidas) {
        this.Salidas = Salidas;
    }
    public boolean equals(SaldoBean sB){
        boolean estado = false;
        if(this.SaldoInicial == sB.getSaldoInicial() &&
                this.Entradas == sB.getEntradas() &&
                this.Salidas == sB.Salidas &&
                this.SaldoFinal == sB.getSaldoFinal()){
            estado = true;
        }
        return estado;
    }
}
