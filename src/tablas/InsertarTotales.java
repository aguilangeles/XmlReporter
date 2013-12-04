/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import entidad.Total;
import helper.SedeYSigla;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import helper.Alerta;
import helper.ExceptionMessage;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InsertarTotales {

  private Conexion conexion = new Conexion();
  private int idVolumen;
  private int idSede;
  private int idIdc;

  public InsertarTotales(int idVolumen, int idIdc, Total total) {
    this.idVolumen = idVolumen;
    this.idSede = SedeYSigla.getIdSede();
    this.idIdc = idIdc;
    insertarTotales(total);
  }

  private void insertarTotales(Total total) {
    try
      {
      if (conexion.isConexion())
        {
        int ide = idVolumen + 1;
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
                + ide + ", "
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
                + "null'"
                + ");\n";
        boolean tot = conexion.executeUpdate(insertar);
        Alerta.alerta("Totales ", tot);
        conexion.desconectar();
        }
      } catch (SQLException ex)
      {
      ExceptionMessage.message(ex.getMessage(), InsertarTotales.class.getName() + " SQL ex");
      }
  }
}
