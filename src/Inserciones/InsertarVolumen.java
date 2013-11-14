/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import Entidades.Volumen;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InsertarVolumen {

  public InsertarVolumen() {
  }

  public void setVolumen(Volumen volumen, int idSede) {
    Conexion conexion = new Conexion();
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
        alerta("Volumen", vol);
        conexion.desconectar();
        }
      } catch (SQLException ex)
      {
      System.out.println(ex.getMessage());
      Logger.getLogger(InsertarVolumen.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  private void alerta(String string, boolean bool) {
    if (!bool)
      {
      JOptionPane.showMessageDialog(null, "Tabla "
              + string + bool,
              "No se realizo la insercion en la base de datos",
              JOptionPane.ERROR_MESSAGE);
      }
  }
}
