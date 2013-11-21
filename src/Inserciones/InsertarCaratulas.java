/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import Entidades.ContenidoGND;
import Entidades.GetCrtForSede;
import Entidades.Volumen;
import Entidades.c2ContenidoGND;
import Entidades.c2ContenidoOSN;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InsertarCaratulas {

  public InsertarCaratulas() {
  }

  public  String setcaratulas(int idIdc, int contador, int idVolumen, Volumen v, int idSede) {
    int id = idIdc + contador;
    int idvol = idVolumen + 1;
    GetCrtForSede c = v.getCrt_sedes();
    c.getC1().getObject();
    String ce = "";
    String ce2 = "";
    switch (idSede)
      {
      case 1:
        ContenidoGND c1g = (ContenidoGND) c.getC1().getObject();
        ce = c1g.getId();
        c2ContenidoGND cgnd = (c2ContenidoGND) c.getC2().getObject();
        // System.out.println(cgnd);
        ce2 = cgnd.toString();
        break;
      case 2:
        c2ContenidoOSN c2osn = (c2ContenidoOSN) c.getC2().getObject();
        ce = "null";//c1o.getSumaria();
        ce2 = c2osn.getId();
        break;
      }
    // es el id setVolumen que ya se inserto, no colocar +1
    String ret = "INSERT INTO `reporteocr_1`.`caratulas`"
            + "(`idIdc`"
            + ",`idVolumen`"
            + ",`idSede`"
            + ",`estado`"
            + ",`tipo_doc`"
            + ",`subtipo_doc`"
            + ",`id_c1`"
            + ",`id_c2`"
            + ",`id_c3`"
            + ",`id_c4`)"
            + "VALUES("
            + id
            + ", " + idvol
            + ", " + idSede
            + ", '" + c.getEstado()
            + "', '" + c.getTipo_doc()
            + "', '" + c.getSubtipo_doc()
            + "', '" + ce
            + "', '" + ce2
            + "', '" + c.getC3()
            + "', '" + c.getC4()
            + "');\n ";
    System.out.println("\t"+ret);
    return ret;
  }
}
