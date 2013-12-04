/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package campo;

import parsers.Meta;
import helper.SedeYSigla;
import parsers.MetaParser;
import parsers.ReporteXMLMetas;

/**
 *
 * @author aguilangeles@gmail.com
 */
class GetCampoBySede {

  private Object object;

  public GetCampoBySede(MetaParser metaParser, ReporteXMLMetas reporteMeta, Meta meta) {
    this.object = setCamposBySede(metaParser, reporteMeta, meta);
  }

  private Object setCamposBySede(MetaParser metaParser, ReporteXMLMetas reporteMeta, Meta meta) {
    Object retObject = null;
    if (SedeYSigla.getIdSede() == 2)
      {
      GetCamposOSN osn = new GetCamposOSN(metaParser, reporteMeta);
      retObject = osn.getOsn();
      } else if (SedeYSigla.getIdSede() == 1)
      {
      GetCamposGNA gnd = new GetCamposGNA(metaParser, reporteMeta, meta);
      retObject = gnd.getGna();
      }
    return retObject;
  }

  public Object getObject() {
    return object;
  }
}
