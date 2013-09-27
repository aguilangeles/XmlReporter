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

  private List<String> mapeoGetC1List = new ArrayList<>();
  private List<String> mapeoGetC2List = new ArrayList<>();
  private List<String> mapeoGetC3List = new ArrayList<>();
  private List<String> mapeoGetC4List = new ArrayList<>();
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
        setContenidoCrt1(c1);
        setContenidoCrt2(c2);
        setContenidoCrt3(c3);
        setContenidoCrt4(c4);
        }
      }
  }

  public  int getCantidadPorFace(String face) {
    int ret = 0;
    Iterator<MapeoList> it = this.listaMapeoLists.iterator();
    while (it.hasNext())
      {
      MapeoList mapeoList = it.next();
      ret += mapeoList.getCantidadPorFace(face);
      }
    return ret;
  }

  public List<String> getMapeoGetC1List() {
    return mapeoGetC1List;
  }

  public List<String> getMapeoGetC2List() {
    return mapeoGetC2List;
  }

  public List<String> getMapeoGetC3List() {
    return mapeoGetC3List;
  }

  public List<String> getMapeoGetC4List() {
    return mapeoGetC4List;
  }

  private void setContenidoCrt1(String c1) {
    if (!c1.equals(""))
      {
      if (!mapeoGetC1List.contains(c1))
        {
        mapeoGetC1List.add(c1);
        }
      }
  }

  private void setContenidoCrt2(String c2) {
    if (!c2.equals(""))
      {
      if (!mapeoGetC2List.contains(c2))
        {
        mapeoGetC2List.add(c2);
        }
      }
  }

  private void setContenidoCrt3(String c3) {
    if (!c3.equals(""))
      {
      mapeoGetC3List.add(c3);
      }
  }

  private void setContenidoCrt4(String c4) {
    if (!c4.equals(""))
      {
      mapeoGetC4List.add(c4);
      }
  }
}
