/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import Entidades.Idc;
import Entidades.PapelesPorIDC;
import Entidades.Volumen;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aguilangeles@gmail.com
 */
public final class InsertarIDC {

  private Conexion conexion = new Conexion();
  private int id = 1;

  public InsertarIDC(int idVolumen, Volumen v, int idSede) {
    insertarEnIDc(idVolumen, v, idSede);
  }

  private void insertarEnIDc(int idVolumen, Volumen v, int idSede) {
    try
      {
      if (conexion.isConexion())
        {
        id += idVolumen;//sumarle uno al ultimovolumen
        Idc getIdc = v.getIdc();
        PapelesPorIDC papelesporIdc = v.getPapeles();
        String insertar = "INSERT INTO `reporteocr_1`.`idc`("
                + "`idVolumen`"
                + ",`idSede`"
                + ",`nombre_idc`"
                + ",`papeles`"
                + ",`pap_validos`"
                + ",`pap_invalidos`"
                + ",`cant_caratulas`"
                + ",`imagenes`"
                + ",`anversos`"
                + ",`reversos`"
                + ",`estado`)"
                + "VALUES("
                + id
                + ", " + idSede
                + ", '" + getIdc.getNombre()
                + "', '" + papelesporIdc.getPapeles()
                + "', '" + getIdc.getValidos()
                + "', '" + getIdc.getInvalidos()
                + "', '" + papelesporIdc.getCaratulas()
                + "', '" + papelesporIdc.getImagenes()
                + "', '" + papelesporIdc.getAnversos()
                + "', '" + papelesporIdc.getReversos()
                + "', '" + papelesporIdc.getEstado()
                + "');\n";
        conexion.executeUpdate(insertar);
        conexion.desconectar();
        }
      } catch (SQLException ex)
      {
        System.out.println(ex.getMessage());
      Logger.getLogger(InsertarIDC.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
}
