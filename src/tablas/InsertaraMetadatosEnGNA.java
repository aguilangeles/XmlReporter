/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import entidad.GNA_sede;
import entidad.Volumen;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InsertaraMetadatosEnGNA {

  public InsertaraMetadatosEnGNA() {
  }

  public String setmetadatos(int idIdc, int contador, int idSede, Volumen v) {
    //sin verificar hasta que ingrese datos GDN
    int id = idIdc + contador;
    GNA_sede g = (GNA_sede) v.getIdc().getCampoSede().getObject();
    String ret = "INSERT INTO `reporteocr_1`.`gna_metadatos`"
            + "(`idSede`"
            + ",`idIdc`"
            + ",`grado_valid`"
            + ",`grado_invalid`"
            + ",`grado_invalidDB`"
            + ",`codEst_valid`"
            + ",`codEst_invalid`"
            + ",`codEst_invalidDB`"
            + ",`nombre_valid`"
            + ",`nombre_invalid`"
            + ",`nombre_invalidDB`"
            + ")"
            + "VALUES("
            + idSede
            + ", " + id
            + ", " + g.getGrado_valid()
            + ", " + g.getGrado_invalid()
            + ", " + g.getGrado_invalidDB()
            + ", " + g.getCodEst_valid()
            + ", " + g.getCodEst_invalid()
            + ", " + g.getCodEst_invalidDB()
            + ", " + g.getNombre_valid()
            + ", " + g.getNombre_invalid()
            + ", " + g.getNombre_invalidDB()
            + ");\n ";
    return ret;
  }
}
