/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import Entidades.ContenidoGND;
import Entidades.GetCrtForSede;
import Entidades.Volumen;
import Entidades.c2ContenidoGND;
import Entidades.c2ContenidoOSN;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InsertarCaratulas {

  private Conexion conexion = new Conexion();
  private int ididc = 1;
//  private int idVolumen ;

  public InsertarCaratulas(int idc, int idvol, Volumen v, int idSede) {
  }

  public void caratulas(int idc, int idvol, Volumen v, int idSede) {
    try
      {
      if (conexion.isConexion())
        {
        ididc += idc;
        GetCrtForSede c = v.getCrt_sedes();
        c.getC1().getObject();
        String ce = "";
        String ce2 = "";
        switch (idSede)
          {
          case 1:
            ContenidoGND c1g = (ContenidoGND) c.getC1().getObject();
            ce = c1g.getId();
            c2ContenidoGND cgnd = (c2ContenidoGND) c.getC2().getObject();
            ce2 = cgnd.toString();
            break;
          case 2:
            c2ContenidoOSN c2osn = (c2ContenidoOSN) c.getC2().getObject();
            ce = "null";//c1o.getSumaria();
            ce2 = c2osn.getId();
            break;
          }
        String insertar = "INSERT INTO `reporteocr_1`.`caratulas`"
                + "(`idIdc`"
                + ",`idVolumen`"
                + ",`idSede`"
                + ",`estado`"
                + ",`tipo_doc`"
                + ",`subtipo_doc`"
                + ",`id_c1`"
                + ",`id_c2`"
                + ",`id_c3`"
                + ",`id_c4`)"
                + "VALUES("
                + ididc
                + ", " + idvol
                + ", " + idSede
                + ", '" + c.getEstado()
                + "', '" + c.getTipo_doc()
                + "', '" + c.getSubtipo_doc()
                + "', '" + ce
                + "', '" + ce2
                + "', '" + c.getC3()
                + "', '" + c.getC4()
                + "');\n ";
        System.out.println(insertar);
        conexion.executeUpdate(insertar);
        conexion.desconectar();
        }
      } catch (SQLException ex)
      {
      Logger.getLogger(InsertarCaratulas.class.getName()).log(Level.SEVERE, null, ex);
      }

  }
}
