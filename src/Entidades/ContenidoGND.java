/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
public class ContenidoGND {

  private String id;
  private String caja;
  private String anio;
  private String mes;
  private String liquidacion;
  private String unidad;

  public ContenidoGND() {
  }

  public ContenidoGND(String id, String caja, String anio, String mes,
          String liquidacion, String unidad) {
    this.id = id;
    this.caja = caja;
    this.anio = anio;
    this.mes = mes;
    this.liquidacion = liquidacion;
    this.unidad = unidad;
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

  public String getAnio() {
    return anio;
  }

  public void setAnio(String anio) {
    this.anio = anio;
  }

  public String getMes() {
    return mes;
  }

  public void setMes(String mes) {
    this.mes = mes;
  }

  public String getLiquidacion() {
    return liquidacion;
  }

  public void setLiquidacion(String liquidacion) {
    this.liquidacion = liquidacion;
  }

  public String getUnidad() {
    return unidad;
  }

  public void setUnidad(String unidad) {
    this.unidad = unidad;
  }

  @Override
  public String toString() {
    return id
            + ", " + caja
            + ", " + anio
            + ", " + mes
            + ", " + liquidacion
            + ", " + unidad;
  }
}
