/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package campo;

import entidad.GNA_sede;
import parsers.Campo;
import parsers.Meta;
import java.util.List;
import parsers.MetaParser;
import parsers.ReporteXMLMetas;

/**
 *obtiene los valores de los campos especificos de gna
 * @author MUTNPROD003
 */
public class GetCamposGNA {

  private final String valid = "Valid";
  private final String invalid = "Invalid";
  private final String invaliddb = "InvalidDB";
  private final String grado = "Grado";
  private final String codEst = "CodEst";
  private final String nombre = "Nombre";
  private ReporteXMLMetas reporteMeta;
  private final MetaParser metaParser;
  private final Meta meta;
  private GNA_sede gna;

  public GetCamposGNA(MetaParser metaParser, ReporteXMLMetas reporte, Meta meta) {
    this.metaParser = metaParser;
    this.reporteMeta = reporte;
    this.meta = meta;
    setResultados();
  }

  private GNA_sede setResultados() {
    int gradoValid = 0;
    int gradoInvalid = 0;
    int gradoInvalidDB = 0;
    int codEstValid = 0;
    int codEstInvalid = 0;
    int codEstInvalidDB = 0;
    int nombreValid = 0;
    int nombreInvalid = 0;
    int nombreInvalidDB = 0;
    List<String> nombreCampoList = reporteMeta.getNombresCampos();
    for (int x = 0; x < nombreCampoList.size(); x++)
      {
      String nombreOriginal = nombreCampoList.get(x);
      if (!nombreOriginal.equalsIgnoreCase("Id Imagen"))
        {
        List<Campo> campos = reporteMeta.getCamposByName(nombreOriginal);
        gradoValid += porEstadoyNombre(nombreOriginal, grado, valid);
        gradoInvalid += porEstadoyNombre(nombreOriginal, grado, invalid);
        gradoInvalidDB += porEstadoyNombre(nombreOriginal, grado, invaliddb);
        codEstValid += porEstadoyNombre(nombreOriginal, codEst, valid);
        codEstInvalid += porEstadoyNombre(nombreOriginal, codEst, invalid);
        codEstInvalidDB += porEstadoyNombre(nombreOriginal, codEst, invaliddb);
        nombreValid += porEstadoyNombre(nombreOriginal, nombre, valid);
        nombreInvalid += porEstadoyNombre(nombreOriginal, nombre, invalid);
        nombreInvalidDB += porEstadoyNombre(nombreOriginal, nombre, invaliddb);
        }
      gna = new GNA_sede(gradoValid, gradoInvalid, gradoInvalidDB,
              codEstValid, codEstInvalid, codEstInvalidDB, nombreValid, nombreInvalid, nombreInvalidDB);
      }
    return gna;
  }

  private int porEstadoyNombre(String nombreOriginal, String nombre, String valor) {
    return GetCantidadCamposPorEstadoYNombre.
            getcantidad(reporteMeta, nombreOriginal, nombre, valor);
  }

  public GNA_sede getGna() {
    return gna;
  }
}
