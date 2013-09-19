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
public class GetContenidoCrt3 {

  private String retC3;
  private GetValuesFromCrtToMapeo getValuesFromCrt;
  private ReporteXMlCaratula reporteCaratula;

  public GetContenidoCrt3(GetValuesFromCrtToMapeo MapeoC1, ReporteXMlCaratula reporteCaratula) {
    this.getValuesFromCrt = MapeoC1;
    this.reporteCaratula = reporteCaratula;
    getC3();
  }

  private String getC3() {
    List<String> caratulasC3 = reporteCaratula.getEstadoDeC3(getValuesFromCrt.getValuesFromCrt3());
    for (int i = 0; i < caratulasC3.size(); i++)
      {
      retC3 = caratulasC3.get(i);
      }
    return retC3;
  }

  public String getRetC3() {
    return retC3;
  }
}
