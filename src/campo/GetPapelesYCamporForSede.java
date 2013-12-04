/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package campo;

import entidad.Idc;
import parsers.Meta;
import javax.swing.JOptionPane;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parsers.MetaParser;
import parsers.ReporteXMLMetas;
import helper.Logger;
import helper.ExceptionMessage;
import java.io.IOException;
import java.util.logging.Level;

/**
 *
 * @author MUTNPROD003
 */
public class GetPapelesYCamporForSede {

  private final String valid = "Valid";
  private final String invalid = "Invalid";
  private final String invaliddb = "InvalidDB";
  private boolean ejercicio;
  private String ruta;
  private Object object;
  private String idcName;
  private static int pValidos;
  private static int pInvalidos;
  private static int campos;
  private static int cValid;
  private static int cInvalid;
  private static int cInvalidDB;
  private static Idc idece;
  private static Logger error = new Logger("Detalle_errores.txt");

  public GetPapelesYCamporForSede(String ruta, String idcName, boolean ejercicio) {
    this.ruta = ruta.replace("Carat.xml", "Meta.xml");
    this.idcName = idcName;
    this.ejercicio = ejercicio;
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
            pValidos = reporteMeta.getCantidadMetaByStatus(valid);
            pInvalidos = reporteMeta.getCantidadMetaByStatus(invalid);
            //
            object = setCamposBySede(metaParser, reporteMeta, meta);
            //
            campos = reporteMeta.getCantidadCampos();
            cValid = reporteMeta.getCampoStatus(valid);
            cInvalid = reporteMeta.getCampoStatus(invalid);
            cInvalidDB = reporteMeta.getCampoStatus(invaliddb);
            }
          setMetaImageNull(meta, error, ejercicio);
          CamposPorSedes camposForSedes = new CamposPorSedes(idcName, object, campos, cValid, cInvalid, cInvalidDB);
          setidc = new Idc(idcName, pValidos, pInvalidos, camposForSedes);
          }
        }
      } catch (SAXException ex)
      {
      ExceptionMessage.message(ex.getMessage(), GetPapelesYCamporForSede.class.getName() + " SAX ex");
//      JOptionPane.showMessageDialog(null, ex.getMessage(), "Papeles y Campos por Sede SAX", JOptionPane.ERROR_MESSAGE);
      } catch (IOException ex)
      {
      ExceptionMessage.message(ex.getMessage(), GetPapelesYCamporForSede.class.getName() + " IO ex");
      }
    return setidc;
  }

  public static int getSize() {
    return campos;
  }

  public static int getValid() {
    return cValid;
  }

  public static int getInvalid() {
    return cInvalid;
  }

  public static int getInvalidDB() {
    return cInvalidDB;
  }

  public static Idc getIdece() {
    return idece;
  }

  private Object setCamposBySede(MetaParser metaParser, ReporteXMLMetas reporteMeta, Meta meta) {
    GetCampoBySede setCamposBySede = new GetCampoBySede(metaParser, reporteMeta, meta);
    return setCamposBySede.getObject();
  }

  private void setMetaImageNull(Meta meta, Logger error, boolean ejercicio) {
    if (meta.getImage() == null)
      {
      GetImageNull imageNull = new GetImageNull(meta, error, ejercicio);
      object = imageNull.getObject();
      }//fin if
  }
}
