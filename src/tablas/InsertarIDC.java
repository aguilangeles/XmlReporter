/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import entidad.Idc;
import entidad.PapelesPorIDC;
import entidad.Volumen;

/**
 *
 * @author aguilangeles@gmail.com
 */
public final class InsertarIDC {

  private static int id = 1;

  public  String insertarEnIDc(int idVolumen, Volumen v, int idSede) {
     //sumarle uno al ultimovolumen
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
            + idVolumen
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
    return insertar;

  }
}
