/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Campos;

import clases.Meta;
import parsers.MetaParser;
import parsers.ReporteXMLMetas;

/**
 *
 * @author aguilangeles@gmail.com
 */
class SetCamposBySede {

  private Object object;

  public SetCamposBySede(MetaParser metaParser, ReporteXMLMetas reporteMeta, Meta meta, int idsede) {
    this.object = setCamposBySede(metaParser, reporteMeta, meta, idsede);
  }

  private Object setCamposBySede(MetaParser metaParser, ReporteXMLMetas reporteMeta, Meta meta, int idsede) {
    Object retObject = null;
    if (idsede == 2)
      {
      Campos_OSN osn = new Campos_OSN(metaParser, reporteMeta);
      retObject = osn.getOsn();
      } else if (idsede == 1)
      {
      Campos_GND gnd = new Campos_GND(metaParser, reporteMeta, meta);
      retObject = gnd.getGnd();
      }
    return retObject;
  }

  public Object getObject() {
    return object;
  }
  
}
