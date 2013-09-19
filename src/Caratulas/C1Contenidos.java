/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Caratulas;

import Entidades.C1;
import Entidades.ContenidoGND;
import Entidades.ContenidoOSN;
import java.util.List;
import parsers.ReporteXMlCaratula;

/**
 * trae el valor ce C1 y su correspondiente metadado
 *
 * @author MUTNPROD003
 */
public class C1Contenidos {

  private C1 cUno;
  private Object object;
  private ContenidoGND contenidoGnd;
  private ContenidoOSN contenidoOSN;
  private String nombre;
  private GetValuesFromCrtToMapeo getValuesCrt;
  private ReporteXMlCaratula reporteCaratula;

  public C1Contenidos(String nombre, GetValuesFromCrtToMapeo mapeoC1, ReporteXMlCaratula reporteCaratula) {
    this.nombre = nombre;
    this.getValuesCrt = mapeoC1;
    this.reporteCaratula = reporteCaratula;
    if (nombre.startsWith("OSN"))
      {
      contenidoOSN = new ContenidoOSN(reporteCaratula.getCantidadSumarias());
      object = contenidoOSN;
      } else if (nombre.startsWith("GND"))
      {
      object = gndC1();
      }
  }

  private ContenidoGND gndC1() {
    List<String> caratulasC1 = reporteCaratula.getEstadoDeC1(getValuesCrt.getValuesFromCrt1());
    for (int i = 0; i < caratulasC1.size(); i++)
      {
      String metadato = caratulasC1.get(i);
      String[] split = metadato.split(", ");
      for (int m = 0; m < split.length; m++)
        {
        String id = split[0];
        String caja = split[1];
        String anio = split[2];
        String mes = split[3];
        String liquidacion = split[4];
        String unidad = split[5];
        contenidoGnd = new ContenidoGND(id, caja, anio, mes, liquidacion, unidad);
        }
      }
    return contenidoGnd;
  }

  public Object getObject() {
    return object;
  }
}
