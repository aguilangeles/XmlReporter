/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers;

import clases.Caratula;
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

  private List<Caratula> caratulaList = new ArrayList<>();
  private GetListFroCrtStatus getStatusFrom;
  private int subtipo;
  private String tipo;

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
    getTipoYSubTipo();
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

  private void getTipoYSubTipo() {
    int ret = 0;
    Iterator<Caratula> it = caratulaList.iterator();
    while (it.hasNext())
      {
      Caratula caratula = it.next();
      if (caratula.getDocType().equalsIgnoreCase("Boletas"))
        {
        tipo = caratula.getDocType();
        subtipo = caratula.getSubTypeCode();
        }
      }
  }

  public int getSubtipo() {
    return subtipo;
  }

  public String getTipo() {
    return tipo;
  }

  public List<String> getEstadoDeC1(List<String> listaC1) {
    return getStatusFrom.getStatusFromCrt(listaC1);
  }

  public List<String> getEstadoDeC2(List<String> listaC2) {
    return getStatusFrom.getStatusFromCrt(listaC2);
  }

  public List<String> getEstadoDeC3(List<String> listaC3) {
    return getStatusFrom.getStatusFromCrt(listaC3);
  }

  public List<String> getEstadoDeC4(List<String> listaC4) {
    return getStatusFrom.getStatusFromCrt(listaC4);
  }
}
