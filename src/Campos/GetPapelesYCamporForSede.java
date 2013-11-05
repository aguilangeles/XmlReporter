/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Campos;

import Entidades.CamposPorSedes;
import Entidades.Idc;
import clases.Meta;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parsers.MetaParser;
import parsers.ReporteXMLMetas;
import txt.Escritor;

/**
 *
 * @author MUTNPROD003
 */
public class GetPapelesYCamporForSede {

  private boolean ejercicio;
  private String ruta;
  private Object object;
  private int idSede;
  //
  private String idcName;
  private static int pvv;
  private static int piv;
  private static int size;
  private static int valid;
  private static int invalid;
  private static int invalidDB;
  private static Idc idece;
  private static Escritor error = new Escritor("Detalle_errores.txt");

  public GetPapelesYCamporForSede(String ruta, String idcName, boolean ejercicio, int contador, int idSede) {
    this.ruta = ruta;
    this.idcName = idcName;
    this.ejercicio = ejercicio;
    this.idSede = idSede;
    idece = setIdc();
  }

  private Idc setIdc() {
    Idc setidc = null;
    try
      {
      MetaParser metaParser = new MetaParser(ruta);
      if (metaParser != null)
        {
        NamedNodeMap met = metaParser.getMetas();
        for (int i = 0; i < met.getLength(); i++)
          {
          Node metaNode = metaParser.getMetas().item(i);
          NodeList metaChildren = metaNode.getChildNodes();
          Meta meta = new Meta(metaChildren);
          ReporteXMLMetas reporteMeta = metaParser.getReporte();
          if (meta != null)
            {
            pvv = reporteMeta.getCantidadValidMeta();
            piv = reporteMeta.getCantidadInvalidMeta();
            //
            object = setCamposBySede(metaParser, reporteMeta, meta);
            //
            size = reporteMeta.getCantidadCampos();
            valid = reporteMeta.getCampoStatus("valid");
            invalid = reporteMeta.getCampoStatus("invalid");
            invalidDB = reporteMeta.getCampoStatus("invalidDB");
            }

          setMetaImageNull(meta, error, ejercicio, idSede);
          CamposPorSedes camposForSedes = new CamposPorSedes(idcName, object, size, valid, invalid, invalidDB);
          setidc = new Idc(idcName, pvv, piv, camposForSedes);
          }
        }

      } catch (SAXException ex)
      {
      Logger.getLogger(GetPapelesYCamporForSede.class.getName()).log(Level.SEVERE, null, ex);
      }
    return setidc;
  }

  public static int getSize() {
    return size;
  }

  public static int getValid() {
    return valid;
  }

  public static int getInvalid() {
    return invalid;
  }

  public static int getInvalidDB() {
    return invalidDB;
  }

  public static Idc getIdece() {
    return idece;
  }

  private Object setCamposBySede(MetaParser metaParser, ReporteXMLMetas reporteMeta, Meta meta) {
    GetCampoBySede setCamposBySede = new GetCampoBySede(metaParser, reporteMeta, meta, idSede);
    return setCamposBySede.getObject();
  }

  private void setMetaImageNull(Meta meta, Escritor error, boolean ejercicio, int idSede) {
    if (meta.getImage() == null)
      {
      GetImageNull imageNull = new GetImageNull(meta, error, ejercicio, idSede);
      object = imageNull.getObject();
      }//fin if
  }
}
