/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.model;

public class EstadoCuentaBean extends BaseBean{
    private String rfcEmpresa;
    private int bancoSISCAM;
    private String cuenta;
    private String perido;
    private long saldoInicial;
    private long saldoFinal;
    private long entradas;
    private long salidas;

    public EstadoCuentaBean(String rfcEmpresa, int bancoSISCAM, String cuenta, String perido, long saldoInicial, long saldoFinal, long entradas, long salidas) {
        this.rfcEmpresa = rfcEmpresa;
        this.bancoSISCAM = bancoSISCAM;
        this.cuenta = cuenta;
        this.perido = perido;
        this.saldoInicial = saldoInicial;
        this.saldoFinal = saldoFinal;
        this.entradas = entradas;
        this.salidas = salidas;
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

    public void setBancoSISCAM(int bancoSISCAM) {
        this.bancoSISCAM = bancoSISCAM;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getPerido() {
        return perido;
    }

    public void setPerido(String perido) {
        this.perido = perido;
    }

    public long getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(long saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public long getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(long saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public long getEntradas() {
        return entradas;
    }

    public void setEntradas(long entradas) {
        this.entradas = entradas;
    }

    public long getSalidas() {
        return salidas;
    }

    public void setSalidas(long salidas) {
        this.salidas = salidas;
    }
}
