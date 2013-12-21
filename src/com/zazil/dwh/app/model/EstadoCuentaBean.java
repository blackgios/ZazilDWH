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
    private long saldoInicial;
    private long saldoFinal;
    private long entradas;
    private long salidas;
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
        this.setPerido(periodo);
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

    public String getPerido() {
        return periodo;
    }

    private void setPerido(String periodo) {
        this.periodo = periodo;
    }

    public long getSaldoInicial() {
        return saldoInicial;
    }

    private void setSaldoInicial(long saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public long getSaldoFinal() {
        return saldoFinal;
    }

    private void setSaldoFinal(long saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public long getEntradas() {
        return entradas;
    }

    private void setEntradas(long entradas) {
        this.entradas = entradas;
    }

    public long getSalidas() {
        return salidas;
    }

    private void setSalidas(long salidas) {
        this.salidas = salidas;
    }
}
