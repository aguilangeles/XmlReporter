/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import Entidades.CamposPorSedes;
import Entidades.Volumen;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InsertarCampos {

  public InsertarCampos() {
  }

  public String campos(int idIdc, int contador, Volumen v, int idSede) {
    int id = idIdc + contador;// generar la constante de id, para sumarle los acontecimientos
    CamposPorSedes s = v.getIdc().getCampoSede();
    String ret = "INSERT INTO `reporteocr_1`.`campos`"
            + "(`idSede`"
            + ",`idIdc`"
            + ",`campos`"
            + ",`campos_valid`"
            + ",`campos_invalid`"
            + ",`campos_invalidDB`)"
            + "VALUES("
            + idSede
            + ", "+ id
            + ", " + s.getSize()
            + ", " + s.getCampos_valid()
            + ", " + s.getCampos_invalid()
            + ", " + s.getCampos_invalidDB()
            + ");\n";
    return ret;
  }
}
