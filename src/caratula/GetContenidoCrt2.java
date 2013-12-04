/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caratula;

import helper.SedeYSigla;
import java.util.List;
import parsers.ReporteXMlCaratula;

/**
 *
 * @author MUTNPROD003
 */
public class GetContenidoCrt2 {

  private Object objetoC2;
  private c2ContenidoGND gndC2;
  private c2ContenidoOSN osnC2;
  private GetValuesFromCrtToMapeo getValuesFromCrt;
  private ReporteXMlCaratula reporteCaratula;

  public GetContenidoCrt2(GetValuesFromCrtToMapeo mapeoC2, ReporteXMlCaratula reporteCaratula) {
    this.getValuesFromCrt = mapeoC2;
    this.reporteCaratula = reporteCaratula;
    setContenidoFromSede();
  }

  private c2ContenidoOSN osnC2() {

    List<String> caratulasC2 = reporteCaratula.getEstadoDeC2(getValuesFromCrt.getValuesFromCrt2());

    for (int i = 0; i < caratulasC2.size(); i++)
      {
      String meta = caratulasC2.get(i);
      String[] split = meta.split(", ");
      for (int s = 0; s < split.length; s++)
        {
        String id = split[0];
        String caja = split[1];
        String banco = split[2];
        String sucursal = split[3];
        String fecha = split[4];
        osnC2 = new c2ContenidoOSN(id, caja, banco, sucursal, fecha);
        }
      }
    return osnC2;
  }

  private void setContenidoFromSede() {
    if (SedeYSigla.getIdSede() == 1)
      {
      this.objetoC2 = gndC2();
      } else if (SedeYSigla.getIdSede() == 2)
      {
      this.objetoC2 = osnC2();
      }
  }
  private c2ContenidoGND gndC2() {
    List<String> lista = getValuesFromCrt.getValuesFromCrt2();
    for (int in = 0; in < lista.size(); in++)
      {
      String idImagen = lista.get(in);
      gndC2 = new c2ContenidoGND(idImagen);
      }
    return gndC2;
  }
  public Object getObjetoC2() {
    return objetoC2;
  }

}
