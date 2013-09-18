/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
public class Total {
     private  int papeles;
    private  int validos;
    private  int invalidos;
    private  int imagenes;
    private  int anversos;
    private  int reversos;
    private  int campos;
    private  int cValidos;
    private  int cInvalidos;
    private  int cInvalidDB;

    public Total() {
    }

    public Total(int papeles, int validos, int invalidos, int imagenes, int anversos, int reversos, int campos, int cValidos, int cInvalidos, int cInvalidDB) {
        this.papeles = papeles;
        this.validos = validos;
        this.invalidos = invalidos;
        this.imagenes = imagenes;
        this.anversos = anversos;
        this.reversos = reversos;
        this.campos = campos;
        this.cValidos = cValidos;
        this.cInvalidos = cInvalidos;
        this.cInvalidDB = cInvalidDB;
    }

    public int getPapeles() {
        return papeles;
    }

    public void setPapeles(int papeles) {
        this.papeles = papeles;
    }

    public int getValidos() {
        return validos;
    }

    public void setValidos(int validos) {
        this.validos = validos;
    }

    public int getInvalidos() {
        return invalidos;
    }

    public void setInvalidos(int invalidos) {
        this.invalidos = invalidos;
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

    public int getCampos() {
        return campos;
    }

    public void setCampos(int campos) {
        this.campos = campos;
    }

    public int getcValidos() {
        return cValidos;
    }

    public void setcValidos(int cValidos) {
        this.cValidos = cValidos;
    }

    public int getcInvalidos() {
        return cInvalidos;
    }

    public void setcInvalidos(int cInvalidos) {
        this.cInvalidos = cInvalidos;
    }

    public int getcInvalidDB() {
        return cInvalidDB;
    }

    public void setcInvalidDB(int cInvalidDB) {
        this.cInvalidDB = cInvalidDB;
    }

    @Override
    public String toString() {
        return "Total{" + "papeles=" + papeles + ", validos=" + validos + ", invalidos=" + invalidos + ", imagenes=" + imagenes + ", anversos=" + anversos + ", reversos=" + reversos + ", campos=" + campos + ", cValidos=" + cValidos + ", cInvalidos=" + cInvalidos + ", cInvalidDB=" + cInvalidDB + '}';
    }



}
