/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import Entidades.Total;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InsertarTotales {

  private Conexion conexion = new Conexion();
  private int idVolumen;
  private static int id = 1;
  private int idSede;
  private int idIdc;

  public InsertarTotales(int idVolumen, int idSede, int idIdc, Total total) {
    this.idVolumen = idVolumen;
    this.idSede = idSede;
    this.idIdc = idIdc;
    insertarTotales(total);
  }

  private void insertarTotales(Total total) {
    try
      {
      if (conexion.isConexion())
        {
        id += idVolumen;
        String insertar = "INSERT INTO `reporteocr_1`.`totales`"
                + "(`idVolumen`"
                + ",`idSede`"
                + ",`papeles`"
                + ",`pap_validos`"
                + ",`pap_invalidos`"
                + ",`imagenes`"
                + ",`anversos`"
                + ",`reversos`"
                + ",`campos`"
                + ",`campos_valid`"
                + ",`campos_invalid`"
                + ",`campos_invalidDb`"
                + ",`estado_validacion`)"
                + "VALUES("
                + id + ", "
                + idSede + ", "
                + total.getPapeles() + ", "
                + total.getValidos() + ", "
                + total.getInvalidos() + ", "
                + total.getImagenes() + ", "
                + total.getAnversos() + ", "
                + total.getReversos() + ", "
                + total.getCampos() + ", "
                + total.getcValidos() + ", "
                + total.getcInvalidos() + ", "
                + total.getcInvalidDB() + ", '"
                + "no - Validado'"
                + ");\n";
        conexion.executeUpdate(insertar);
          System.out.println(insertar);
        conexion.desconectar();
        }
      } catch (SQLException ex)
      {
      System.out.println(ex.getMessage());
      Logger.getLogger(InsertarTotales.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
}
