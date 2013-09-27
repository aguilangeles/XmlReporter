/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import Entidades.OSN_sede;
import Entidades.Volumen;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InsertarMetadatosEnOSN {

  public InsertarMetadatosEnOSN() {
  }

  public static String setmetadatos(int idIdc, int contador, int idSede, Volumen v) {
    int id = idIdc + contador;
    OSN_sede s = (OSN_sede) v.getIdc().getCampoSede().getObject();
    String ret = "INSERT INTO `reporteocr_1`.`osn_metadatos`"
            + "(`idSede`"
            + ",`idIdc`"
            + ",`distrito_valid`"
            + ",`distrito_invalid`"
            + ",`partida_valid`"
            + ",`partida_invalid`"
            + ",`subcuenta_valid`"
            + ",`subcuenta_invalid`"
            + ",`digito_valid`"
            + ",`digito_invalid`"
            + ",`anio_valid`"
            + ",`anio_invalid`"
            + ",`bimestre_valid`"
            + ",`bimestre_invalid`)"
            + "VALUES("
            + idSede
            + ", " + id
            + ", " + s.getDistrito_valid()
            + ", " + s.getDistrito_invalid()
            + ", " + s.getPartida_valid()
            + ", " + s.getPartida_invalid()
            + ", " + s.getSubcuenta_valid()
            + ", " + s.getSubcuenta_invalid()
            + ", " + s.getDigito_valid()
            + ", " + s.getDigito_invalid()
            + ", " + s.getAnio_valid()
            + ", " + s.getAnio_invalid()
            + ", " + s.getBimestre_valid()
            + ", " + s.getBimestre_invalid()
            + ");\n ";
    return ret;
  }
}
