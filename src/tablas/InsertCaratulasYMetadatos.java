/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import helper.SedeYSigla;
import helper.Alerta;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InsertCaratulasYMetadatos {

  public InsertCaratulasYMetadatos(Conexion conexion, StringInsert insertResultados) {
    int sede = SedeYSigla.getIdSede();
    switch (sede)
      {
      case 1:
        boolean crtgnd = conexion.executeUpdate(insertResultados.getCaratulasForGnd());
        Alerta.alerta("Crt Gna ", crtgnd);
        boolean gnd_meta = conexion.executeUpdate(insertResultados.getGnd_metadatos());
        Alerta.alerta("Gna Meta ", gnd_meta);
        break;
      case 2:
        boolean crtosn = conexion.executeUpdate(insertResultados.getCaratulasforOSN());
        Alerta.alerta("Crt Osn ", crtosn);
        boolean osn_meta = conexion.executeUpdate(insertResultados.getOsn_metadatos());
        Alerta.alerta("Osn Meta ", osn_meta);
        break;
      }
  }
}
