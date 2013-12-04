/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package campo;

import entidad.GNA_sede;
import entidad.OSN_sede;
import parsers.Meta;
import helper.MensajeTxt;
import helper.SedeYSigla;
import helper.Logger;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetImageNull {

  private Object object;

  public GetImageNull(Meta meta, Logger getError, boolean ejercicio) {
    setMetaImageNull(meta, getError, ejercicio);
  }

  private void setMetaImageNull(Meta meta, Logger getError, boolean ejercicio) {
    String descripcion = (ejercicio) ? "Es ejercicio" : "No posee Meta";
    int idSede = SedeYSigla.getIdSede();
    switch (idSede)
      {
      case 2:
        OSN_sede o = new OSN_sede(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        object = o;
        break;
      case 1:
        GNA_sede g = new GNA_sede(0, 0, 0, 0, 0, 0, 0, 0, 0);
        object = g;
        break;
      }
    MensajeTxt message = new MensajeTxt(meta.getIdIDC(), descripcion);
    getError.salida(message);
  }

  public Object getObject() {
    return object;
  }
}
