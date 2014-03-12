/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.model;

public class EstadoCuentaBean extends BaseBean{
    private String rfcEmpresa;
    private int bancoSISCAM;
    private String cuenta;
    private String periodo;
    private double saldoInicial;
    private double entradas;
    private double salidas;
    private double saldoFinal;
    /**
     * Constructor de la clase Parametros de entrada:
     * @param rfcEmpresa
     * @param bancoSISCAM
     * @param cuenta
     * @param periodo
     * @param saldoInicial
     * @param saldoFinal
     * @param entradas
     * @param salidas 
     * 
     * Este constructor evita que se obtenga un objeto de esta 
     * clase sin sus valores debidamente inicializados.
     */
    public EstadoCuentaBean(String rfcEmpresa, int bancoSISCAM, String cuenta, String periodo, long saldoInicial, long saldoFinal, long entradas, long salidas) {
        this.setRfcEmpresa(rfcEmpresa);
        this.setBancoSISCAM(bancoSISCAM);
        this.setCuenta(cuenta);
        this.setPeriodo(periodo);
        this.setSaldoInicial(saldoInicial);
        this.setSaldoFinal(saldoFinal);
        this.setEntradas(entradas);
        this.setSalidas(salidas);
    }
    

    public String getRfcEmpresa() {
        return rfcEmpresa;
    }

    private void setRfcEmpresa(String rfcEmpresa) {
        this.rfcEmpresa = rfcEmpresa;
    }

    public int getBancoSISCAM() {
        return bancoSISCAM;
    }

    private void setBancoSISCAM(int bancoSISCAM) {
        this.bancoSISCAM = bancoSISCAM;
    }

    public String getCuenta() {
        return cuenta;
    }

    private void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getPeriodo() {
        return periodo;
    }

    private void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    private void setSaldoInicial(long saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getSaldoFinal() {
        return saldoFinal;
    }

    private void setSaldoFinal(long saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public double getEntradas() {
        return entradas;
    }

    private void setEntradas(long entradas) {
        this.entradas = entradas;
    }

    public double getSalidas() {
        return salidas;
    }

    private void setSalidas(long salidas) {
        this.salidas = salidas;
    }
}
