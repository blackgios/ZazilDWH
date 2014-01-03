/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zazil.dwh.app.util;

/**
 *
 * @author Hector Rodriguez
 */
public class Saldos {
    private String periodo;
    private double saldoIni;
    private double entradas;
    private double salidas;
    private double saldoFin;

    public Saldos(double saldoIni, double entradas, double salidas, double saldoFin, String periodo) {
        this.setSaldoIni(saldoIni);
        this.setEntradas(entradas);
        this.setSalidas(salidas);
        this.setSaldoFin(saldoFin);
        this.setPeriodo(periodo);
    }
    
    public double getSaldoIni() {
        return saldoIni;
    }

    private void setSaldoIni(double saldoIni) {
        this.saldoIni = saldoIni;
    }

    public double getEntradas() {
        return entradas;
    }

    private void setEntradas(double entradas) {
        this.entradas = entradas;
    }

    public double getSalidas() {
        return salidas;
    }

    private void setSalidas(double salidas) {
        this.salidas = salidas;
    }

    public double getSaldoFin() {
        return saldoFin;
    }

    private void setSaldoFin(double saldoFin) {
        this.saldoFin = saldoFin;
    }

    public String getPeriodo() {
        return periodo;
    }

    private void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
}
