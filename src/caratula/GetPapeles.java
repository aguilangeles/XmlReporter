/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caratula;

import entidad.PapelesPorIDC;
import helper.ExceptionMessage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import parsers.XmlMapeo;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parsers.MapeoList;
import parsers.ReporteXMLMapeo;
import parsers.XmlMapeoParser;

/**
 * traera los valores del idc
 *
 * @author Administrador
 */
public class GetPapeles {

  private PapelesPorIDC papelesPorIdc;
  private String pathname;
  private boolean isEjercicio;

  public GetPapeles(String pathname, boolean isEjercicio) {
    this.pathname = pathname.replace("Carat.xml", "Mapeo.xml");
    this.isEjercicio = isEjercicio;
    this.papelesPorIdc = setValores();
  }

  private PapelesPorIDC setValores() {
    PapelesPorIDC retPapelIdc = null;
    try
      {
      ReporteXMLMapeo reporteMapeo = null;
      XmlMapeoParser mapeoParser = new XmlMapeoParser(pathname);
      XmlMapeo xmlMapeo = new XmlMapeo(mapeoParser.getXmlMapeoNode().getChildNodes());
      xmlMapeo.setMapeoLists(mapeoParser.getMapeoLists());
      for (int e = 0; e < mapeoParser.getMapeoLists().getLength(); e++)
        {
        Node mapeoListNode = mapeoParser.getMapeoLists().item(e);
        NodeList mapeoChildren = mapeoListNode.getChildNodes();
        MapeoList mapeoList = new MapeoList(mapeoChildren);
        reporteMapeo = mapeoParser.getReporte();
        int cantidadImgs = xmlMapeo.getCantidadImagenes();
        int anversos = reporteMapeo.getCantidadPorFace("Anverso");
        int reversos = reporteMapeo.getCantidadPorFace("Reverso");
        int caratulas = xmlMapeo.isCarat();
        String status = xmlMapeo.getStatus();
        int papeles = (!isEjercicio) ? xmlMapeo.cantidadPapeles() : 0;
        retPapelIdc = new PapelesPorIDC(papeles, caratulas, cantidadImgs,
                anversos, reversos, status);
        }
      } catch (SAXException ex)
      {
      ExceptionMessage.message(ex.getMessage(), GetPapeles.class.getName() + " SAX ex");
      } catch (IOException ex)
      {
      ExceptionMessage.message(ex.getMessage(), GetPapeles.class.getName() + " IO ex");
      }
    return retPapelIdc;
  }

  public PapelesPorIDC getPapelesPorIdc() {
    return papelesPorIdc;
  }
}
