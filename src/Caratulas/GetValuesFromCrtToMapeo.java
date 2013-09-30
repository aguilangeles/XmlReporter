/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Caratulas;

import clases.XmlMapeo;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parsers.MapeoList;
import parsers.ReporteXMLMapeo;
import parsers.XmlMapeoParser;

/**
 *
 * @author Administrador
 */
public class GetValuesFromCrtToMapeo {

  private List<String> valuesFromCrt1;
  private List<String> valuesFromCrt2;
  private List<String> valuesFromCrt3;
  private List<String> valuesFromCrt4;
  private String pathname;

  public GetValuesFromCrtToMapeo(String ruta) {
    this.pathname = ruta.replace("Carat.xml", "Mapeo.xml");
    getValuesCrtFromMapeo();
  }

  private void getValuesCrtFromMapeo() {

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
        //lista de  contenido de c1 y
        valuesFromCrt1 = reporteMapeo.getMapeoGetC1List();
        valuesFromCrt2 = reporteMapeo.getMapeoGetC2List();
        valuesFromCrt3 = reporteMapeo.getMapeoGetC3List();
        valuesFromCrt4 = reporteMapeo.getMapeoGetC4List();
        }
      //Logger.getLogger(IDCXCaratula.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SAXException ex)
      {
      System.out.println(ex.getMessage());
      // Logger.getLogger(IDCXCaratula.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  public List<String> getValuesFromCrt1() {
    return valuesFromCrt1;
  }

  public List<String> getValuesFromCrt2() {
    return valuesFromCrt2;
  }

  public List<String> getValuesFromCrt3() {
    return valuesFromCrt3;
  }

  public List<String> getValuesFromCrt4() {
    return valuesFromCrt4;
  }


}
