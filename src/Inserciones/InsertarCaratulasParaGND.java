/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import Entidades.ContenidoGND;
import Entidades.Volumen;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InsertarCaratulasParaGND {

  public InsertarCaratulasParaGND() {
  }

  public String gnd_crt(int idIdc, int contador, Volumen v, int idSede) {
    int id = idIdc + contador;
    ContenidoGND g = (ContenidoGND) v.getCrt_sedes().getC1().getObject();
    String ret = "INSERT INTO `reporteocr_1`.`gnd_crt`"
            + "(`idSede`,"
            + "`idIdc`"
            + ",`id_c1`"
            + ",`caja`"
            + ",`anio`"
            + ",`mes`"
            + ",`liquidacion`"
            + ",`unidad`"
            + ",`id_c2`"
            + ",`id_c3`"
            + ",`id_c4`)VALUES("
            + idSede
            + ", " + id
            + ", '" + g.getId()
            + "', '" + g.getCaja()
            + "', '" + g.getAnio()
            + "', '" + g.getMes()
            + "', '" + g.getLiquidacion()
            + "', '" + g.getUnidad()
            + "', '" + v.getCrt_sedes().getC2()
            + "', '" + v.getCrt_sedes().getC3()
            + "', '" + v.getCrt_sedes().getC4()
            + "');\n";
//    System.out.println(ret);
    return ret;
  }
}
