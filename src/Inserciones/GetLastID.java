/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import java.sql.SQLException;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetLastID {

  private Conexion conexion;
  private static int id;

  public GetLastID(Conexion conexion) {
    this.conexion = conexion;
  }

  public int getLastIdFromTable(String nombreTabla) {
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
    return id;
  }
}
