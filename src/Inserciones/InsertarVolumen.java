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

//  public InsertarVolumen(Volumen volumen, int idSede) {
//    setVolumen(volumen, idSede);
//  }
  public InsertarVolumen() {
    //   setVolumen(volumen, idSede);
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
        conexion.executeUpdate(insertar);
        System.out.println("=====================");
        System.out.println(insertar);
        System.out.println("=====================");
        conexion.desconectar();
        }
      } catch (SQLException ex)
      {
      System.out.println(ex.getMessage());
      Logger.getLogger(InsertarVolumen.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
}
