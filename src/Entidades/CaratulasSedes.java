/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
public class CaratulasSedes {
    private String estado;
    private String tipo_doc;
    private int subtipo_doc;
    private C1 c1;
    private C2 c2;
    private C3 c3;
    private C4 c4;

    public CaratulasSedes(String estado, String tipo_doc, int subtipo_doc, C1 c1, C2 c2, C3 c3, C4 c4) {
        this.estado = estado;
        this.tipo_doc = tipo_doc;
        this.subtipo_doc = subtipo_doc;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
    }

    public CaratulasSedes(String estado, String tipo_doc, int subtipo_doc) {
        this.estado = estado;
        this.tipo_doc = tipo_doc;
        this.subtipo_doc = subtipo_doc;
    }


    public CaratulasSedes() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public int getSubtipo_doc() {
        return subtipo_doc;
    }

    public void setSubtipo_doc(int subtipo_doc) {
        this.subtipo_doc = subtipo_doc;
    }

    public C1 getC1() {
        return c1;
    }

    public void setC1(C1 c1) {
        this.c1 = c1;
    }

    public C2 getC2() {
        return c2;
    }

    public void setC2(C2 c2) {
        this.c2 = c2;
    }

    public C3 getC3() {
        return c3;
    }

    public void setC3(C3 c3) {
        this.c3 = c3;
    }

    public C4 getC4() {
        return c4;
    }

    public void setC4(C4 c4) {
        this.c4 = c4;
    }

    @Override
    public String toString() {
        return estado
                + ", "+ tipo_doc
                + ", " + subtipo_doc
                + ", " + c1
                + ", " + c2
                + ", " + c3
                + ", " + c4 ;
    }



}
