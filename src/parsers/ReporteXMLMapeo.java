/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers;

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
public class ReporteXMLMapeo {

  private static List<String> mapeoGetC1List = new ArrayList<>();
  private static List<String> mapeoGetC2List = new ArrayList<>();
  private static List<String> mapeoGetC3List = new ArrayList<>();
  private static List<String> mapeoGetC4List = new ArrayList<>();
  private List<MapeoList> listaMapeoLists = new ArrayList<>();
  private List<String> nombresFaces;

  public ReporteXMLMapeo(NamedNodeMap mapeoLists) {
    for (int i = 0; i < mapeoLists.getLength(); i++)
      {
      Node mapeoListNode = mapeoLists.item(i);
      NodeList mapeoChildren = mapeoListNode.getChildNodes();
      MapeoList mapeoList = new MapeoList(mapeoChildren);
      listaMapeoLists.add(mapeoList);
      }
    getValoresContenidosEnCrt1234(listaMapeoLists);
  }

  private void getValoresContenidosEnCrt1234(List<MapeoList> listaMapeoLists) {
    Iterator<MapeoList> it = listaMapeoLists.iterator();
    while (it.hasNext())
      {
      MapeoList mapeoList = it.next();
      boolean isCaratula = mapeoList.getCarat();
      if (isCaratula)
        {
        String c1 = mapeoList.getC1();
        String c2 = mapeoList.getC2();
        String c3 = mapeoList.getC3();
        String c4 = mapeoList.getC4();
        setcontenidos(c1, mapeoGetC1List);
        setcontenidos(c2, mapeoGetC2List);
        setcontenidos(c3, mapeoGetC3List);
        setcontenidos(c4, mapeoGetC4List);
        }
      }
  }

  public int getCantidadPorFace(String face) {
    int ret = 0;
    Iterator<MapeoList> it = this.listaMapeoLists.iterator();
    while (it.hasNext())
      {
      MapeoList mapeoList = it.next();
      ret += mapeoList.getCantidadPorFace(face);
      }
    return ret;
  }

  private void setcontenidos(String aString, List<String> lista) {
    if (!aString.equals(""))
      {
      lista.add(aString);
      }
  }

  public static List<String> getMapeoGetC1List() {
    return mapeoGetC1List;
  }

  public static List<String> getMapeoGetC2List() {
    return mapeoGetC2List;
  }

  public static List<String> getMapeoGetC3List() {
    return mapeoGetC3List;
  }

  public static List<String> getMapeoGetC4List() {
    return mapeoGetC4List;
  }
}
