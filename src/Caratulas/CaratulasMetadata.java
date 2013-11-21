/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Caratulas;

import Entidades.Contenido;
import Entidades.NoContenido;
import Entidades.GetCrtForSede;
import clases.Caratula;
import clases.Metadato;
import java.io.IOException;
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
  private Contenido nuevoContenidoParaC1;
  private Contenido nuevoContenidoParaC2;
  private NoContenido nuevoC3;
  private NoContenido nuevoC4;
  private int idsede;

  public CaratulasMetadata(String pathname, int idsede) {
    this.pathname = pathname;
    this.idsede = idsede;
    setCaratulas();
  }

  private GetCrtForSede setCaratulas() {
    String status = "";
    try
      {
      CaratulaParser caratulaParser = new CaratulaParser(pathname);
      //todo
      getValuesFromCrtS = new GetValuesFromCrtToMapeo(pathname);
      //parser
      ReporteXMlCaratula reporteCaratula = caratulaParser.getReporte();
      NamedNodeMap caratulaNodeMap = caratulaParser.getCaratulas();
      for (int a = 0; a < caratulaNodeMap.getLength(); a++)
        {
        Node caratulaNode = caratulaNodeMap.item(a);
        NodeList caratulaChildren = caratulaNode.getChildNodes();
        Caratula caratula = new Caratula(caratulaChildren);
        //traesr metadato//
        Metadato metadato = caratula.getMetadato();

        rootIDC = caratula.getIdIDC();

        status = caratula.getStatus();

        isEjercicio = reporteCaratula.isEjercicios();
        getTipoYSubtipoDocumento(reporteCaratula, caratula);
        }
      //
      GetContenidoCrt1 c1 = new GetContenidoCrt1(getValuesFromCrtS, reporteCaratula, idsede);
      nuevoContenidoParaC1 = new Contenido(c1.getObject());
      //
      GetContenidoCrt2 c2 = new GetContenidoCrt2(getValuesFromCrtS, reporteCaratula, idsede);
      nuevoContenidoParaC2 = new Contenido(c2.getObjetoC2());
      //
      GetContenidoCrt3 c3 = new GetContenidoCrt3(getValuesFromCrtS, reporteCaratula);
      nuevoC3 = new NoContenido(c3.getRetC3());

      GetContenidoCrt4 c4 = new GetContenidoCrt4(getValuesFromCrtS, reporteCaratula);
      nuevoC4 = new NoContenido(c4.getRetC4());
      sedesCrt = new GetCrtForSede(status, tipo, subtipo, nuevoContenidoParaC1, nuevoContenidoParaC2, nuevoC3, nuevoC4);

      } catch (SAXException ex)
      {
      System.out.println(ex.getMessage());
      } catch (IOException ex)
      {
      System.out.println(ex.getMessage());
      }
    System.out.println("subtipo " + subtipo);
    return sedesCrt;
  }

  private void getTipoYSubtipoDocumento(ReporteXMlCaratula reporteCaratula, Caratula caratula) {
    if (idsede == 2)
      {
      tipo = reporteCaratula.getTipo();
      subtipo = reporteCaratula.getSubtipo();
      } else if (idsede == 1)
      {
      subtipo = caratula.getSubTypeCode();
      tipo = caratula.getDocType();
      }
  }

  public boolean isIsEjercicio() {
    return isEjercicio;
  }

  public GetCrtForSede getSedesCrt() {
    return sedesCrt;
  }
}
