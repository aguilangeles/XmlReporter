/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import Entidades.Volumen;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InsertarVolumen {

  private Conexion conexion = new Conexion();

  public InsertarVolumen(Volumen volumen, int idSede) {
    setVolumen(volumen, idSede);
  }

  private void setVolumen(Volumen volumen, int idSede) {
    try
      {
      if (conexion.isConexion())
        {
        String insertar = "INSERT INTO `reporteocr_1`.`volumen`"
                + "(`idSede`"
                + ",`volumen`"
                + ",`cantidad_idcs`"
                + ",`fecha_reporte`)"
                + "VALUES('"
                + idSede + "', '"
                + volumen.getVol_nombre() + "', '"
                + volumen.getCantidad_idc() + "', '"
                + volumen.getFecha_reporte() + "');";
        conexion.executeUpdate(insertar);
        conexion.desconectar();
        }
      } catch (SQLException ex)
      {
      Logger.getLogger(InsertarVolumen.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
}
