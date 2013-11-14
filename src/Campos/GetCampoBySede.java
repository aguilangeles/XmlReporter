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
class GetCampoBySede {

  private Object object;

  public GetCampoBySede(MetaParser metaParser, ReporteXMLMetas reporteMeta,
          Meta meta, int idsede) {
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
      Campos_GNA gnd = new Campos_GNA(metaParser, reporteMeta, meta);
      retObject = gnd.getGna();
      }
//    System.out.println(retObject);
    return retObject;
  }

  public Object getObject() {
    return object;
  }
}
