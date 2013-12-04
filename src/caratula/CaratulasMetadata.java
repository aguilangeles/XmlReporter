/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caratula;

import helper.ExceptionMessage;
import parsers.Caratula;
import parsers.Metadato;
import helper.SedeYSigla;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parsers.CaratulaParser;
import parsers.ReporteXMlCaratula;

/**
 *
 * @author Administrador
 */
public class CaratulasMetadata {

  private String tipo;
  private int subtipo;
  private String pathname;
  private String rootIDC;
  private GetValuesFromCrtToMapeo getValuesFromCrtS;
  private boolean isEjercicio;
  private GetCrtForSede sedesCrt;

  public CaratulasMetadata(String pathname) {
    this.pathname = pathname;
    setCaratulas();
  }

  private GetCrtForSede setCaratulas() {
    String status = "";
    try
      {
      getValuesFromCrtS = new GetValuesFromCrtToMapeo(pathname);
      CaratulaParser caratulaParser = new CaratulaParser(pathname);
      ReporteXMlCaratula reporteCaratula = caratulaParser.getReporte();
      NamedNodeMap caratulaNodeMap = caratulaParser.getCaratulas();
      for (int a = 0; a < caratulaNodeMap.getLength(); a++)
        {
        Node caratulaNode = caratulaNodeMap.item(a);
        NodeList caratulaChildren = caratulaNode.getChildNodes();
        Caratula caratula = new Caratula(caratulaChildren);
        Metadato metadato = caratula.getMetadato();
        rootIDC = caratula.getIdIDC();
        status = caratula.getStatus();
        isEjercicio = reporteCaratula.isEjercicios();
        getTipoYSubtipoDocumento(reporteCaratula, caratula);
        }
      Contenido nuevoContenidoParaC1 = C1GetContenido(reporteCaratula);
      Contenido nuevoContenidoParaC2 = C2GetContenido(reporteCaratula);
      NoContenido nuevoC3 = C3GetContenido(reporteCaratula);
      NoContenido nuevoC4 = C4GetContenido(reporteCaratula);

      sedesCrt = new GetCrtForSede(status, tipo, subtipo, nuevoContenidoParaC1, nuevoContenidoParaC2, nuevoC3, nuevoC4);

      } catch (SAXException ex)
      {
      ExceptionMessage.message(ex.getMessage(), CaratulasMetadata.class.getName() + " SAX ex");
      } catch (IOException ex)
      {
      String mensaje = ex.getMessage() + "\nEl programa se cerrará";
      ExceptionMessage.message(mensaje, CaratulasMetadata.class.getName() + " IO ex");
      System.exit(0);
      }
    return sedesCrt;
  }

  private void getTipoYSubtipoDocumento(ReporteXMlCaratula reporteCaratula, Caratula caratula) {
    if (SedeYSigla.getIdSede() == 2)
      {
      tipo = reporteCaratula.getTipo();
      subtipo = reporteCaratula.getSubtipo();
      } else if (SedeYSigla.getIdSede() == 1)
      {
      subtipo = caratula.getSubTypeCode();
      tipo = caratula.getDocType();
      }
  }

  private Contenido C1GetContenido(ReporteXMlCaratula reporteCaratula) {
    //
    GetContenidoCrt1 c1 = new GetContenidoCrt1(getValuesFromCrtS, reporteCaratula);
    Contenido nuevoContenidoParaC1 = new Contenido(c1.getObject());
    return nuevoContenidoParaC1;
  }

  private Contenido C2GetContenido(ReporteXMlCaratula reporteCaratula) {
    //
    GetContenidoCrt2 c2 = new GetContenidoCrt2(getValuesFromCrtS, reporteCaratula);
    Contenido nuevoContenidoParaC2 = new Contenido(c2.getObjetoC2());
    return nuevoContenidoParaC2;
  }

  public boolean isEjercicio() {
    return isEjercicio;
  }

  public GetCrtForSede getSedesCrt() {
    return sedesCrt;
  }

  private NoContenido C3GetContenido(ReporteXMlCaratula reporteCaratula) {
    //
    GetContenidoCrt3 c3 = new GetContenidoCrt3(getValuesFromCrtS, reporteCaratula);
    NoContenido nuevoC3 = new NoContenido(c3.getRetC3());
    return nuevoC3;
  }

  private NoContenido C4GetContenido(ReporteXMlCaratula reporteCaratula) {
    //
    GetContenidoCrt4 c4 = new GetContenidoCrt4(getValuesFromCrtS, reporteCaratula);
    NoContenido nuevoC4 = new NoContenido(c4.getRetC4());
    return nuevoC4;
  }
}
