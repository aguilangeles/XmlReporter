/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
public class OSN_sede {
    private int distrito_valid;
    private int distrito_invalid;
    //
    private int partida_valid;
    private int partida_invalid;
    //
    private int subcuenta_valid;
    private int subcuenta_invalid;
    //
    private int digito_valid;
    private int digito_invalid;
    //
    private int anio_valid;
    private int anio_invalid;
    //
    private int bimestre_valid;
    private int bimestre_invalid;
    //

    public OSN_sede(int distrito_valid, int distrito_invalid, int partida_valid, int partida_invalid, int subcuenta_valid, int subcuenta_invalid, int digito_valid, int digito_invalid, int anio_valid, int anio_invalid, int bimestre_valid, int bimestre_invalid) {
        this.distrito_valid = distrito_valid;
        this.distrito_invalid = distrito_invalid;
        this.partida_valid = partida_valid;
        this.partida_invalid = partida_invalid;
        this.subcuenta_valid = subcuenta_valid;
        this.subcuenta_invalid = subcuenta_invalid;
        this.digito_valid = digito_valid;
        this.digito_invalid = digito_invalid;
        this.anio_valid = anio_valid;
        this.anio_invalid = anio_invalid;
        this.bimestre_valid = bimestre_valid;
        this.bimestre_invalid = bimestre_invalid;
    }

    public OSN_sede() {
    }

    public int getDistrito_valid() {
        return distrito_valid;
    }

    public void setDistrito_valid(int distrito_valid) {
        this.distrito_valid = distrito_valid;
    }

    public int getDistrito_invalid() {
        return distrito_invalid;
    }

    public void setDistrito_invalid(int distrito_invalid) {
        this.distrito_invalid = distrito_invalid;
    }

    public int getPartida_valid() {
        return partida_valid;
    }

    public void setPartida_valid(int partida_valid) {
        this.partida_valid = partida_valid;
    }

    public int getPartida_invalid() {
        return partida_invalid;
    }

    public void setPartida_invalid(int partida_invalid) {
        this.partida_invalid = partida_invalid;
    }

    public int getSubcuenta_valid() {
        return subcuenta_valid;
    }

    public void setSubcuenta_valid(int subcuenta_valid) {
        this.subcuenta_valid = subcuenta_valid;
    }

    public int getSubcuenta_invalid() {
        return subcuenta_invalid;
    }

    public void setSubcuenta_invalid(int subcuenta_invalid) {
        this.subcuenta_invalid = subcuenta_invalid;
    }

    public int getDigito_valid() {
        return digito_valid;
    }

    public void setDigito_valid(int digito_valid) {
        this.digito_valid = digito_valid;
    }

    public int getDigito_invalid() {
        return digito_invalid;
    }

    public void setDigito_invalid(int digito_invalid) {
        this.digito_invalid = digito_invalid;
    }

    public int getAnio_valid() {
        return anio_valid;
    }

    public void setAnio_valid(int anio_valid) {
        this.anio_valid = anio_valid;
    }

    public int getAnio_invalid() {
        return anio_invalid;
    }

    public void setAnio_invalid(int anio_invalid) {
        this.anio_invalid = anio_invalid;
    }

    public int getBimestre_valid() {
        return bimestre_valid;
    }

    public void setBimestre_valid(int bimestre_valid) {
        this.bimestre_valid = bimestre_valid;
    }

    public int getBimestre_invalid() {
        return bimestre_invalid;
    }

    public void setBimestre_invalid(int bimestre_invalid) {
        this.bimestre_invalid = bimestre_invalid;
    }

    @Override
    public String toString() {
        return "OSN_sede{" + "distrito_valid=" + distrito_valid + ", distrito_invalid=" + distrito_invalid + ", partida_valid=" + partida_valid + ", partida_invalid=" + partida_invalid + ", subcuenta_valid=" + subcuenta_valid + ", subcuenta_invalid=" + subcuenta_invalid + ", digito_valid=" + digito_valid + ", digito_invalid=" + digito_invalid + ", anio_valid=" + anio_valid + ", anio_invalid=" + anio_invalid + ", bimestre_valid=" + bimestre_valid + ", bimestre_invalid=" + bimestre_invalid + '}';
    }


}
