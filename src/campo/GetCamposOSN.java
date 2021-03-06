/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package campo;

import entidad.OSN_sede;
import parsers.Campo;
import java.util.List;
import parsers.MetaParser;
import parsers.ReporteXMLMetas;

/**
 *obtiene los valores de los campos especificos de osn
 * @author MUTNPROD003
 */
public class GetCamposOSN {

  private MetaParser metaParser;
  private ReporteXMLMetas reporteMeta;
  //
  private String ruta;
  private static String v = "Valid";
  private static String i = "Invalid";
  private static String distrito = "Distrito";
  private static String partida = "partida";
  private static String subcuenta = "subcuenta";
  private static String digito = "digito";
  private static String anio = "anio";
  private static String bimestre = "bimestre";
  private OSN_sede osn;

  public GetCamposOSN(MetaParser metaParser, ReporteXMLMetas reporteMeta) {
    this.metaParser = metaParser;
    this.reporteMeta = reporteMeta;
    setResultados();
  }

  private OSN_sede setResultados() {
    int distritoValid = 0;
    int distritoInvalid = 0;
    int partidaValid = 0;
    int partidaInvalid = 0;
    int subCuentaValid = 0;
    int subCuentaInvalid = 0;
    int digitoValid = 0;
    int digitoInvalid = 0;
    int anioValid = 0;
    int anioInvalid = 0;
    int bimestreValid = 0;
    int bimestreInvalid = 0;
    List<String> nombreCampoList = reporteMeta.getNombresCampos();
    for (int x = 0; x < nombreCampoList.size(); x++)
      {
      String nombreOriginal = nombreCampoList.get(x);
          if (!nombreOriginal.equalsIgnoreCase("Id Imagen"))
            {
            List<Campo> campos = reporteMeta.getCamposByName(nombreOriginal);
            distritoValid += cantidadPorEstadoYNombre(nombreOriginal, distrito, v);
            distritoInvalid += cantidadPorEstadoYNombre(nombreOriginal, distrito, i);
            partidaValid += cantidadPorEstadoYNombre(nombreOriginal, partida, v);
            partidaInvalid += cantidadPorEstadoYNombre(nombreOriginal, partida, i);
            subCuentaValid += cantidadPorEstadoYNombre(nombreOriginal, subcuenta, v);
            subCuentaInvalid += cantidadPorEstadoYNombre(nombreOriginal, subcuenta, i);
            digitoValid += cantidadPorEstadoYNombre(nombreOriginal, digito, v);
            digitoInvalid += cantidadPorEstadoYNombre(nombreOriginal, digito, i);
            anioValid += cantidadPorEstadoYNombre(nombreOriginal, anio, v);
            anioInvalid += cantidadPorEstadoYNombre(nombreOriginal, anio, i);
            bimestreValid += cantidadPorEstadoYNombre(nombreOriginal, bimestre, v);
            bimestreInvalid += cantidadPorEstadoYNombre(nombreOriginal, bimestre, i);
            osn = new OSN_sede(distritoValid, distritoInvalid, partidaValid,
                    partidaInvalid, subCuentaValid, subCuentaInvalid,
                    digitoValid, digitoInvalid, anioValid, anioInvalid,
                    bimestreValid, bimestreInvalid);
            }
      }
    return osn;
  }

  private int cantidadPorEstadoYNombre(String nombreOriginal, String nombre, String valor) {
    return GetCantidadCamposPorEstadoYNombre
            .getcantidad(reporteMeta, nombreOriginal, nombre, valor);
  }

  public OSN_sede getOsn() {
    return osn;
  }
}
