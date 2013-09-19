/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers;

import clases.Campo;
import clases.Caratula;
import clases.Metadato;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Administrador
 */
public class ReporteXMlCaratula {
//
//  private List<String> listaValorC1;
//  private List<String> listaValorC2;
//  private List<String> listaValorC3;
//  private List<String> listaValorC4;
  private List<Caratula> caratulaList = new ArrayList<>();
  private GetListFroCrtStatus getStatusFrom;

  public ReporteXMlCaratula() {
  }

  public ReporteXMlCaratula(NamedNodeMap caratulasNodeMap) {
    for (int i = 0; i < caratulasNodeMap.getLength(); i++)
      {
      Node caratulaNode = caratulasNodeMap.item(i);
      NodeList caratulaChildren = caratulaNode.getChildNodes();
      Caratula caratula = new Caratula(caratulaChildren);
      caratulaList.add(caratula);
      }
    this.getStatusFrom = new GetListFroCrtStatus(caratulaList);

  }

  public Metadato metadatoByCampoValue(String value) {
    Metadato ret = null;
    Iterator<Caratula> it = caratulaList.iterator();
    while (it.hasNext())
      {
      Caratula caratula = it.next();
      Metadato metadato = caratula.getMetadato();
      Campo campo = metadato.getCampoByValue(value);
      if (campo.getValue().equals(value))
        {
        ret = metadato;
        }
      }
    return ret;
  }

  public int getCantidadSumarias() {
    int ret = 0;
    Iterator<Caratula> it = caratulaList.iterator();
    while (it.hasNext())
      {
      Caratula caratula = it.next();
      if (caratula.getDocType().equalsIgnoreCase("Sumaria"))
        {
        ret++;
        }
      }
    return ret;
  }

  public boolean isEjercicios() {
    int ret = 0;
    Iterator<Caratula> it = caratulaList.iterator();
    while (it.hasNext())
      {
      Caratula caratula = it.next();
      if (caratula.getDocType().equalsIgnoreCase("EJER"))
        {
        return true;
        }
      }
    return false;
  }

  public List<String> getEstadoDeC1(List<String> listaC1) {
    List<String> listaValorC1 = getStatusFrom.getStatusFromCrt(listaC1);
    return listaValorC1;

  }

  public List<String> getEstadoDeC2(List<String> listaC2) {
    List<String> listaValorC2 = getStatusFrom.getStatusFromCrt(listaC2);
    return listaValorC2;
  }

  public List<String> getEstadoDeC3(List<String> listaC3) {
    List<String> listaValorC3 = getStatusFrom.getStatusFromCrt(listaC3);
    return listaValorC3;
  }

  public List<String> getEstadoDeC4(List<String> listaC4) {
    List<String> listaValorC4 = getStatusFrom.getStatusFromCrt(listaC4);
    return listaValorC4;
  }

  public String getTipo() {
    String ret = "";
    Iterator<Caratula> it = caratulaList.iterator();
    while (it.hasNext())
      {
      Caratula caratula = it.next();
      if (caratula.getDocType().equalsIgnoreCase("Boletas"))
        {
        ret = caratula.getDocType();
        }
      }
    return ret;
  }

  public int getSubTipo() {
    int ret = 0;
    Iterator<Caratula> it = caratulaList.iterator();
    while (it.hasNext())
      {
      Caratula caratula = it.next();
      if (caratula.getDocType().equalsIgnoreCase("Boletas"))
        {
        ret = caratula.getSubTypeCode();
        }
      }
    return ret;
  }

//  public List<String> getListaValorC1() {
//    return listaValorC1;
//  }
//
//  public List<String> getListaValorC2() {
//    return listaValorC2;
//  }
//
//  public List<String> getListaValorC3() {
//    return listaValorC3;
//  }
//
//  public List<String> getListaValorC4() {
//    return listaValorC4;
//  }
}
