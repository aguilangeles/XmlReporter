/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caratula;

import helper.SedeYSigla;
import java.util.List;
import parsers.ReporteXMlCaratula;

/**
 * trae el valor ce C1 y su correspondiente metadado
 *
 * @author MUTNPROD003
 */
public class GetContenidoCrt1 {

  private Object object;
  private GetValuesFromCrtToMapeo getValuesCrt;
  private ReporteXMlCaratula reporteCaratula;

  public GetContenidoCrt1(GetValuesFromCrtToMapeo getvaluesCrt, ReporteXMlCaratula reporteCaratula) {
    this.getValuesCrt = getvaluesCrt;
    this.reporteCaratula = reporteCaratula;
    setContenidoForSede(reporteCaratula);
  }

  private void setContenidoForSede(ReporteXMlCaratula reporteCaratula) {
    if (SedeYSigla.getIdSede() == 2)
      {
      object = new ContenidoOSN(reporteCaratula.getCantidadSumarias());
      } else if (SedeYSigla.getIdSede() == 1)
      {
      object = getContenidoGND();
      }
  }

  private ContenidoGND getContenidoGND() {
    ContenidoGND contenidoGnd = null;
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
