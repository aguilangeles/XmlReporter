/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
public class PapelesPorIDC {
    private int papeles;
    private int caratulas;
    private int imagenes;
    private int anversos;
    private int reversos;
    private String estado;

    public PapelesPorIDC(int papeles, int caratulas, int imagenes, int anversos, int reversos, String estado) {
        this.papeles = papeles;
        this.caratulas = caratulas;
        this.imagenes = imagenes;
        this.anversos = anversos;
        this.reversos = reversos;
        this.estado = estado;
    }

    public PapelesPorIDC() {
    }

    public int getPapeles() {
        return papeles;
    }

    public void setPapeles(int papeles) {
        this.papeles = papeles;
    }

    public int getCaratulas() {
        return caratulas;
    }

    public void setCaratulas(int caratulas) {
        this.caratulas = caratulas;
    }

    public int getImagenes() {
        return imagenes;
    }

    public void setImagenes(int imagenes) {
        this.imagenes = imagenes;
    }

    public int getAnversos() {
        return anversos;
    }

    public void setAnversos(int anversos) {
        this.anversos = anversos;
    }

    public int getReversos() {
        return reversos;
    }

    public void setReversos(int reversos) {
        this.reversos = reversos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "PapelIdc{" + "papeles=" + papeles + ", caratulas=" + caratulas
                + ", imagenes=" + imagenes + ", anversos=" + anversos
                + ", reversos=" + reversos + ", estado=" + estado + '}';
    }

}
