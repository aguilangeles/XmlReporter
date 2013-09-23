/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Caratulas;

import Entidades.PapelesPorIDC;
import clases.XmlMapeo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
      NodeList xmlMapeoNodeChildren = mapeoParser.getXmlMapeoNode().getChildNodes();
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
        retPapelIdc = new PapelesPorIDC(papeles, caratulas, cantidadImgs, anversos, reversos, status);
        }
      } catch (SAXException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "SAXException in GetPapeles", JOptionPane.ERROR_MESSAGE);
      }
    return retPapelIdc;
  }

  public PapelesPorIDC getPapelesPorIdc() {
    return papelesPorIdc;
  }
}
