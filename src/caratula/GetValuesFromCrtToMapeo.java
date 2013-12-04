/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caratula;

import helper.ExceptionMessage;
import java.io.IOException;
import parsers.XmlMapeo;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parsers.MapeoList;
import parsers.ReporteXMLMapeo;
import parsers.XmlMapeoParser;

/**
 * parsear el mapeo para obtener los contenidos de caratulas
 *
 * @author Administrador
 */
public class GetValuesFromCrtToMapeo {

  private String pathname;

  public GetValuesFromCrtToMapeo(String ruta) {
    this.pathname = ruta.replace("Carat.xml", "Mapeo.xml");
    getValuesForCrtFromMapeo();
  }

  private void getValuesForCrtFromMapeo() {

    ReporteXMLMapeo reporteMapeo = null;
    try
      {
      XmlMapeoParser mapeoParser = new XmlMapeoParser(pathname);
      NodeList xmlMapeoNodeChildren = mapeoParser.getXmlMapeoNode().getChildNodes();
      XmlMapeo xmlMapeo = new XmlMapeo(mapeoParser.getXmlMapeoNode().getChildNodes());
      xmlMapeo.setMapeoLists(mapeoParser.getMapeoLists());
      for (int e = 0; e < mapeoParser.getMapeoLists().getLength(); e++)
        {
        Node mapeoListNode = mapeoParser.getMapeoLists().item(e);
        NodeList mapeoChildren = mapeoListNode.getChildNodes();
        MapeoList mapeoList = new MapeoList(mapeoChildren);
        reporteMapeo = mapeoParser.getReporte();
        }
      } catch (SAXException ex)
      {
      ExceptionMessage.message(ex.getMessage(), GetValuesFromCrtToMapeo.class.getName() + " SAX ex");
      } catch (IOException ex)
      {
      ExceptionMessage.message(ex.getMessage(), GetValuesFromCrtToMapeo.class.getName() + " IO ex");
      }
  }

  public List<String> getValuesFromCrt1() {
    return ReporteXMLMapeo.getMapeoGetC1List();
  }

  public List<String> getValuesFromCrt2() {
    return ReporteXMLMapeo.getMapeoGetC2List();
  }

  public List<String> getValuesFromCrt3() {
    return ReporteXMLMapeo.getMapeoGetC3List();
  }

  public List<String> getValuesFromCrt4() {
    return ReporteXMLMapeo.getMapeoGetC4List();
  }
}
