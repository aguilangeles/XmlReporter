/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Caratulas;

import Entidades.C1;
import Entidades.C2;
import Entidades.C3;
import Entidades.C4;
import Entidades.CaratulasSedes;
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
  private MapeosC mapeoC1;
  private boolean isEjercicio;
  private CaratulasSedes sedesCrt;
  private C1 nuevoC1;
  private C2 nuevoC2;
  private C3 nuevoC3;
  private C4 nuevoC4;
  private int idsede;

  public CaratulasMetadata(String pathname, int idsede) {
    this.pathname = pathname;
    this.idsede = idsede;
    setCaratulas();
  }

  private CaratulasSedes setCaratulas() {
    String status = "";
    try
      {
      CaratulaParser caratulaParser = new CaratulaParser(pathname);
      //todo
      mapeoC1 = new MapeosC(pathname);
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
      C1Contenidos c1 = new C1Contenidos(rootIDC, mapeoC1, reporteCaratula);
      nuevoC1 = new C1(c1.getObject());
      //
      C2_Contenidos c2 = new C2_Contenidos(rootIDC, mapeoC1, reporteCaratula);
      nuevoC2 = new C2(c2.getObjetoC2());
      //
      C3Contenido c3 = new C3Contenido(mapeoC1, reporteCaratula);
      nuevoC3 = new C3(c3.getRetC3());

      C4Contenido c4 = new C4Contenido(mapeoC1, reporteCaratula);
      nuevoC4 = new C4(c4.getRetC4());
      sedesCrt = new CaratulasSedes(status, tipo, subtipo, nuevoC1, nuevoC2, nuevoC3, nuevoC4);

      } catch (SAXException ex)
      {
      System.out.println(ex.getMessage());
      } catch (IOException ex)
      {
      System.out.println(ex.getMessage());
      }
    return sedesCrt;
  }

  private void getTipoYSubtipoDocumento(ReporteXMlCaratula reporteCaratula, Caratula caratula) {
    if (idsede == 2)
      {
      tipo = reporteCaratula.getTipo();
      subtipo = reporteCaratula.getSubTipo();
      } else if (idsede == 1)
      {
      subtipo = caratula.getSubTypeCode();
      tipo = caratula.getDocType();
      }
  }

  public boolean isIsEjercicio() {
    return isEjercicio;
  }

  public CaratulasSedes getSedesCrt() {
    return sedesCrt;
  }
}
