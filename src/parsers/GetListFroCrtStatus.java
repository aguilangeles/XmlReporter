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

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetListFroCrtStatus {

  private List<Caratula> caratulaList;

  public GetListFroCrtStatus(List<Caratula> caratulaList) {
    this.caratulaList = caratulaList;
  }

  public List<String> getStatusFromCrt(List<String> listaC1) {
    List<String> listaValorC1 = new ArrayList();
    String ret = "";
    Iterator<Caratula> it = caratulaList.iterator();
    while (it.hasNext())
      {
      Caratula caratula = it.next();
      Metadato metadato = caratula.getMetadato();
      Campo campo = metadato.getCampoByName("Id");
      for (String c1 : listaC1)
        {
        if (campo.getValue().equalsIgnoreCase(c1) && campo != null)
          {
          ret = metadato.toString();
          //System.out.println("\t" + ret+" c \t "+ caratula.getIdIDC());
          listaValorC1.add(ret);
          }
        }
      }
    return listaValorC1;

  }
}
