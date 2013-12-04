/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package campo;

import parsers.Campo;
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
          List<Campo> camposPorEstado =
                  reporteMeta.
                  getCamposByNameAndStatus(nombreOriginal, valor);
            ret = camposPorEstado.size();
      }
    return ret;
  }
}
