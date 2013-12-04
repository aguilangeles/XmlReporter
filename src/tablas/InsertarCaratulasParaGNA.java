/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import caratula.ContenidoGND;
import entidad.Volumen;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InsertarCaratulasParaGNA {

  public InsertarCaratulasParaGNA() {
  }

  public String gna_crt(int idIdc, int contador, Volumen v, int idSede) {
    int id = idIdc + contador;
    ContenidoGND g = (ContenidoGND) v.getCrt_sedes().getC1().getObject();
    String ret = "INSERT INTO `reporteocr_1`.`gna_crt`"
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
