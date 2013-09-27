/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Campos;

import clases.Campo;
import java.util.List;
import parsers.ReporteXMLMetas;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetCantidadCamposPorEstadoYNombre {

  public GetCantidadCamposPorEstadoYNombre() {
  }

  public static int getcantidad(ReporteXMLMetas reporteMeta, String nombreOriginal, String nombre, String valor) {
    int ret = 0;
    if (nombreOriginal.equalsIgnoreCase(nombre))
      {
      List<String> getStatuses = reporteMeta.getStatuses();
      for (int y = 0; y < reporteMeta.getStatuses().size(); y++)
        {
        String getStatus = reporteMeta.getStatuses().get(y);
        if (getStatus.equalsIgnoreCase(valor))
          {
          List<Campo> camposPorEstado =
                  reporteMeta.getCamposByNameAndStatus(nombreOriginal, getStatus);
          if (!getStatus.equalsIgnoreCase(""))
            {
            ret = camposPorEstado.size();
            }
          }
        }
      }
    return ret;
  }
}
