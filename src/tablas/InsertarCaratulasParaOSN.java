/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import caratula.ContenidoOSN;
import entidad.Volumen;
import caratula.c2ContenidoOSN;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InsertarCaratulasParaOSN {

  public InsertarCaratulasParaOSN() {
  }

  public   String setcrtforosn(int idIdc, int contador, Volumen v, int idSede) {
    int id = idIdc + contador;
    ContenidoOSN o = (ContenidoOSN) v.getCrt_sedes().getC1().getObject();
    c2ContenidoOSN c2 = (c2ContenidoOSN) v.getCrt_sedes().getC2().getObject();
    String ret = "INSERT INTO `reporteocr_1`.`osn_crt`"
            + "(`idSede`"
            + ",`idIdc`"
            + ",`sumarias`"
            + ",`id_c2`"
            + ",`caja`"
            + ",`banco`"
            + ",`sucursal`"
            + ",`fecha_presentacion`"
            + ",`id_c3`"
            + ",`id_c4`)"
            + "VALUES("
            + idSede
            + ", " + id
            + ", " + o.getSumaria()
            + ", '" + c2.getId()
            + "', '" + c2.getCaja()
            + "', '" + c2.getBanco()
            + "', '" + c2.getSucursal()
            + "', '" + c2.getFecha_pres()
            + "', '" + v.getCrt_sedes().getC3()
            + "', '" + v.getCrt_sedes().getC4()
            + "');";
    return ret;
  }
}
