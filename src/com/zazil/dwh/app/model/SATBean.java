/**
 *
 * @author Ana Martinez
 */

package com.zazil.dwh.app.model;

public class SATBean extends BaseBean{
    private String rfcEmpresa;
    private String accesoSAT;
    private String periodoUltaDecl;
    private String periodoUltDiot;
    
    public SATBean (String rfcEmpresa, String accesoSAT, String periodoUltaDecl, String periodoUltDiot){
        this.setRfcEmpresa(rfcEmpresa);
        this.setAccesoSAT(accesoSAT);
        this.setPeriodoUltDiot(periodoUltDiot);
        this.setPeriodoUltaDecl(periodoUltaDecl);
 }

    public String getRfcEmpresa() {
        return rfcEmpresa;
    }

    private void setRfcEmpresa(String rfcEmpresa) {
        this.rfcEmpresa = rfcEmpresa;
    }

    public String getAccesoSAT() {
        return accesoSAT;
    }

    private void setAccesoSAT(String accesoSAT) {
        this.accesoSAT = accesoSAT;
    }

    public String getPeriodoUltaDecl() {
        return periodoUltaDecl;
    }

    private void setPeriodoUltaDecl(String periodoUltaDecl) {
        this.periodoUltaDecl = periodoUltaDecl;
    }

    public String getPeriodoUltDiot() {
        return periodoUltDiot;
    }

    private void setPeriodoUltDiot(String periodoUltDiot) {
        this.periodoUltDiot = periodoUltDiot;
    }
    
    
}
