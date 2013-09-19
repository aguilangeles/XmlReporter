/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
public class GetCrtForSede {

  private String estado;
  private String tipo_doc;
  private int subtipo_doc;
  private Contenido c1;
  private Contenido c2;
  private NoContenido c3;
  private NoContenido c4;

  public GetCrtForSede(String estado, String tipo_doc, int subtipo_doc,
          Contenido c1, Contenido c2, NoContenido c3, NoContenido c4) {
    this.estado = estado;
    this.tipo_doc = tipo_doc;
    this.subtipo_doc = subtipo_doc;
    this.c1 = c1;
    this.c2 = c2;
    this.c3 = c3;
    this.c4 = c4;
  }

  public GetCrtForSede() {
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

  public Contenido getC1() {
    return c1;
  }

  public Contenido getC2() {
    return c2;
  }

  public NoContenido getC3() {
    return c3;
  }

  public NoContenido getC4() {
    return c4;
  }

  @Override
  public String toString() {
    return estado
            + ", " + tipo_doc
            + ", " + subtipo_doc
            + ", " + c1
            + ", " + c2
            + ", " + c3
            + ", " + c4;
  }
}
