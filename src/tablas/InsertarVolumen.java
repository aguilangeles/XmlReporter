/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import entidad.Volumen;
import helper.SedeYSigla;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import helper.Alerta;
import helper.ExceptionMessage;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InsertarVolumen {

  public InsertarVolumen() {
  }

  public void getVolumen(Volumen volumen) {
    Conexion conexion = new Conexion();
    int idSede = SedeYSigla.getIdSede();
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
        boolean vol = conexion.executeUpdate(insertar);
        Alerta.alerta("Volumen", vol);
        conexion.desconectar();
        }
      } catch (SQLException ex)
      {
      ExceptionMessage.message(ex.getMessage(), InsertarVolumen.class.getName() + " SQL ex");
      }
  }
}
