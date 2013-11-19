/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Campos;

import Entidades.GNA_sede;
import clases.Campo;
import clases.Meta;
import java.util.List;
import parsers.MetaParser;
import parsers.ReporteXMLMetas;

/**
 *
 * @author MUTNPROD003
 */
public class Campos_GNA {
  /*NO ESTA ENTRANDO A ESTE LUGAR*/

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

  public Campos_GNA(MetaParser metaParser, ReporteXMLMetas reporte, Meta meta) {
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
    List<String> nombreList = reporteMeta.getListaCampos();
    for (int x = 0; x < nombreCampoList.size(); x++)
      {
      String nombreOriginal = nombreCampoList.get(x);
      for (int l = 0; l < nombreList.size(); l++)
        {
        String nombreHarC = nombreList.get(l);
        if (nombreOriginal.equals(nombreHarC))
          {
          if (!nombreOriginal.equalsIgnoreCase("Id Imagen"))
            {
            List<Campo> campos = reporteMeta.getCamposByName(nombreOriginal);
            gradoValid += porEstadoyNombre(nombreOriginal, grado, valid);
            gradoInvalid += porEstadoyNombre(nombreOriginal, grado, invalid);
            gradoInvalidDB += porEstadoyNombre(nombreOriginal, grado, invaliddb);
            codEstValid += porEstadoyNombre(nombreOriginal, codEst, valid);
            codEstInvalid += porEstadoyNombre(nombreOriginal, codEst, invalid);
            codEstInvalidDB += porEstadoyNombre(nombreOriginal, codEst, invaliddb);
//            nombreValid += porEstadoyNombre(nombreOriginal, nombre, invalid);
//            codEstInvalid += porEstadoyNombre(nombreOriginal, codEst, valid);
//            codEstInvalidDB += porEstadoyNombre(nombreOriginal, codEst, invaliddb);
            }
          }
        }
      gna = new GNA_sede(gradoValid, gradoInvalid, gradoInvalidDB,
              codEstValid, codEstInvalid, codEstInvalidDB);
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
