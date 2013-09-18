/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
public class c2ContenidoOSN {
    private String id;
    private String caja;
    private String banco;
    private String sucursal;
    private String fecha_pres;

    public c2ContenidoOSN(String id, String caja, String banco, String sucursal, String fecha_pres) {
        this.id = id;
        this.caja = caja;
        this.banco = banco;
        this.sucursal = sucursal;
        this.fecha_pres = fecha_pres;
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

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getFecha_pres() {
        return fecha_pres;
    }

    public void setFecha_pres(String fecha_pres) {
        this.fecha_pres = fecha_pres;
    }

    @Override
    public String toString() {
        return  id
                + ", " + caja
                + ", " + banco
                + ", " + sucursal
                + ", " + fecha_pres
                ;
    }



}
