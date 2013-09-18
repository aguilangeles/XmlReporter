/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetLastID {

  private Conexion conexion;
  private String nombreTabla;
  private static int id;

  public GetLastID(Conexion conexion, String nombreTabla) {
    this.conexion = conexion;
    this.nombreTabla = nombreTabla;

  }

  private void getLastIdFromTable() {
    try
      {
      conexion.Execute("Select max(id) from " + nombreTabla);
      while (conexion.resultado.next())
        {
        id = conexion.resultado.getInt(1);
        }
      } catch (SQLException ex)
      {
      System.out.println("ex get last id" + ex.getMessage());
      }

  }
}
