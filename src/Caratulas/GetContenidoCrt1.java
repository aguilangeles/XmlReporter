/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Caratulas;

import Entidades.ContenidoGND;
import Entidades.ContenidoOSN;
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

  public GetContenidoCrt1(GetValuesFromCrtToMapeo getvaluesCrt, ReporteXMlCaratula reporteCaratula, int idSede) {
    this.getValuesCrt = getvaluesCrt;
    this.reporteCaratula = reporteCaratula;
    setContenidoForSede(idSede, reporteCaratula);
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
//        System.out.println(split[5]);

        String unidad = split[5];
        contenidoGnd = new ContenidoGND(id, caja, anio, mes, liquidacion, unidad);
        }
      }
    return contenidoGnd;
  }

  private void setContenidoForSede(int idSede, ReporteXMlCaratula reporteCaratula) {
    if (idSede == 2)
      {
      object = new ContenidoOSN(reporteCaratula.getCantidadSumarias());
      } else if (idSede == 1)
      {
      object = getContenidoGND();
      }
  }

  public Object getObject() {
    return object;
  }
}
