/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import Entidades.GND_sede;
import Entidades.Volumen;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InsertaraMetadatosEnGND {

  public InsertaraMetadatosEnGND() {
  }
    public   String setmetadatos(int idIdc, int contador, int idSede, Volumen v) {
    //sin verificar hasta que ingrese datos GDN
    int id = idIdc + contador;
    GND_sede g = (GND_sede) v.getIdc().getCampoSede().getObject();
    String ret = "INSERT INTO `reporteocr_1`.`gnd_metadatos`"
            + "(`idSede`"
            + ",`idIdc`"
            + ",`grado_valid`"
            + ",`grado_invalid`"
            + ",`grado_invalidDB`"
            + ",`codEst_valid`"
            + ",`codEst_invalid`"
            + ",`codEst_invalidDB`)"
            + "VALUES("
            + idSede
            + ", "+ id
            + ", "+ g.getGrado_valid()
            + ", "+ g.getGrado_invalid()
            + ", "+ g.getGrado_invalidDB()
            + ", "+ g.getCodEst_valid()
            + ", "+ g.getCodEst_invalid()
            + ", "+ g.getCodEst_invalidDB()
            + ");\n ";
    return ret;
  }
}
