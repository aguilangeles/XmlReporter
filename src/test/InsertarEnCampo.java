/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Entidades.CamposPorSedes;
import Entidades.Volumen;
import Inserciones.Conexion;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InsertarEnCampo {

  private Conexion conexion;
  private int idIdc, contador, idSede;
  private Volumen v;
  private String insertCampo;

  public InsertarEnCampo(Conexion conexion, int idIdc, int contador, int idSede, Volumen v) {
    this.conexion = conexion;
    this.idIdc = idIdc;
    this.contador = contador;
    this.idSede = idSede;
    this.insertCampo = campos();
//    campos(idIdc, contador, idSede, v);
  }

  private String campos() {
    int id = idIdc + contador;// generar la constante de id, para sumarle los acontecimientos
    CamposPorSedes s = v.getIdc().getCampoSede();
    String ret = "INSERT INTO `reporteocr_1`.`campos`(`idSede`,`idIdc`"
            + ",`campos`,`campos_valid`,`campos_invalid`,`campos_invalidDB`)"
            + "VALUES("
            + idSede + ", "
            + id + ", "
            + s.getSize() + ", "
            + s.getCampos_valid() + ", "
            + s.getCampos_invalid() + ", "
            + s.getCampos_invalidDB()
            + ");\n";
//    conexion.executeUpdate(ret);
    // conexion.desconectar();
    return ret;
  }

  public String getInsertCampo() {
    return insertCampo;
  }
  
}
