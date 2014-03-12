/**
 *
 * @author Hector Rodriguez
 */
package com.zazil.dwh.app.model;

public class AlmacenBean extends BaseBean{
    private String rfcEmpresa;
    private String periodo;
    private boolean estado;
    private String ruta;

    public AlmacenBean(String rfcEmpresa, String periodo, boolean estado, String ruta) {
        this.setRfcEmpresa(rfcEmpresa);
        this.setPeriodo(periodo);
        this.setEstado(estado);
        this.setRuta(ruta);
    }
    
    public String getRfcEmpresa() {
        return rfcEmpresa;
    }

    private void setRfcEmpresa(String rfcEmpresa) {
        this.rfcEmpresa = rfcEmpresa;
    }

    public String getPeriodo() {
        return periodo;
    }

    private void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public boolean isEstado() {
        return estado;
    }

    private void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getRuta() {
        return ruta;
    }

    private void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
