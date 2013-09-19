/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Caratulas;

import java.util.List;
import parsers.ReporteXMlCaratula;

/**
 *
 * @author MUTNPROD003
 */
public class GetContenidoCrt4 {

  private String retC4;
  private GetValuesFromCrtToMapeo getValuesFromCrt;
  private ReporteXMlCaratula reporteCaratula;

  public GetContenidoCrt4(GetValuesFromCrtToMapeo MapeoC1, ReporteXMlCaratula reporteCaratula) {
    this.getValuesFromCrt = MapeoC1;
    this.reporteCaratula = reporteCaratula;
    getC4();

  }

  private String getC4() {
    List<String> caratulasC4 = reporteCaratula.getEstadoDeC3(getValuesFromCrt.getValuesFromCrt4());
    for (int i = 0; i < caratulasC4.size(); i++)
      {
      retC4 = caratulasC4.get(i);
      }
    return retC4;
  }

  public String getRetC4() {
    return retC4;
  }
}
