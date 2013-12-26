/**
 *
 * @author Hector Rodriguez
 */

package com.zazil.dwh.app.model;

public class EmpresaBean extends BaseBean{
    private String rfcEmpresa;
    private String nombreEmpresa;
    private int empresaSISCAM;

    public EmpresaBean(String rfcEmpresa, String nombreEmpresa, int empresaSISCAM) {
        this.setRfcEmpresa(rfcEmpresa);
        this.setNombreEmpresa(nombreEmpresa);
        this.setEmpresaSISCAM(empresaSISCAM);
    }
    
    public String getRfcEmpresa() {
        return rfcEmpresa;
    }

    private void setRfcEmpresa(String rfcEmpresa) {
        this.rfcEmpresa = rfcEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    private void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getEmpresaSISCAM() {
        return empresaSISCAM;
    }

    private void setEmpresaSISCAM(int empresaSISCAM) {
        this.empresaSISCAM = empresaSISCAM;
    }
    
}
