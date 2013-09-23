/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Campos;

import Entidades.GND_sede;
import Entidades.OSN_sede;
import clases.Meta;
import helper.MensajeTxt;
import txt.Escritor;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetImageNull {

  private Object object;

  public GetImageNull(Meta meta, Escritor getError, boolean ejercicio, int idSede) {
    setMetaImageNull(meta, getError, ejercicio, idSede);
  }

  private void setMetaImageNull(Meta meta, Escritor getError, boolean ejercicio, int idSede) {
    String descripcion = (ejercicio) ? "Es ejercicio" : "No posee Meta";
    switch (idSede)
      {
      case 2:
        OSN_sede o = new OSN_sede(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        object = o;
        break;
      case 1:
        GND_sede g = new GND_sede(0, 0, 0, 0, 0, 0);
        object = g;
        break;
      }
    MensajeTxt message = new MensajeTxt(meta.getIdIDC(), descripcion);
    getError.salida(message);
  }

  public GetImageNull(String path, String descripcion, Escritor getError, int idSede) {
    setMetaNotFound(path, descripcion, getError, idSede);
  }

  private void setMetaNotFound(String path, String descripcion, Escritor getError, int idSede) {
    switch (idSede)
      {
      case 2:
        OSN_sede o = new OSN_sede(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        object = o;
        break;
      case 1:
        GND_sede g = new GND_sede(0, 0, 0, 0, 0, 0);
        object = g;
        break;
      }
    MensajeTxt message = new MensajeTxt(path, descripcion);
    getError.salida(message);

  }

  public Object getObject() {
    return object;
  }
}
