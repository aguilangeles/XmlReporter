/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
class C2_osn {
    private String id;
    private String caja;
    private String sucursal;
    private String subcuenta;
    private String digito;
    private String anio;
    private String bimestre;

    public C2_osn() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getSubcuenta() {
        return subcuenta;
    }

    public void setSubcuenta(String subcuenta) {
        this.subcuenta = subcuenta;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getBimestre() {
        return bimestre;
    }

    public void setBimestre(String bimestre) {
        this.bimestre = bimestre;
    }

    @Override
    public String toString() {
        return id
                + ", " + caja
                + ", " + sucursal
                + ", " + subcuenta
                + ", " + digito
                + ", " + anio
                + ", " + bimestre ;
    }


}
