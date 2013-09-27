/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import Entidades.c2ContenidoGND;
import Entidades.c2ContenidoOSN;
import Entidades.CamposPorSedes;
import Entidades.GetCrtForSede;
import Entidades.ContenidoGND;
import Entidades.ContenidoOSN;
import Entidades.GND_sede;
import Entidades.Idc;
import Entidades.OSN_sede;
import Entidades.PapelesPorIDC;
import Entidades.Volumen;

/**
 *
 * @author MUTNPROD003
 */
public class InsertarStrings {

  private Volumen v;
  private int idVolumen;
  private int idSede;
  private int idIdc;
  private int contador;

  public InsertarStrings(Volumen v, int idVolumen, int idSede, int idIdc, int contador) {
    this.v = v;
    this.idVolumen = idVolumen;
    this.idSede = idSede;
    this.idIdc = idIdc;
    this.contador = contador;
  }

  public String campos() {
    int id = idIdc + contador;// generar la constante de id, para sumarle los acontecimientos
    System.out.println("id de campos " + id);
    CamposPorSedes s = v.getIdc().getCampoSede();
    String ret = "INSERT INTO `reporteocr_1`.`campos`(`idSede`,`idIdc`"
            + ",`campos`,`campos_valid`,`campos_invalid`,`campos_invalidDB`)"
            + "VALUES("
            + idSede + ", "
            + id + ", "
            + s.getSize() + ", "
            + s.getCampos_valid() + ", "
            + s.getCampos_invalid() + ", "
            + s.getCampos_invalidDB()
            + ");\n";
    return ret;
  }

  public String gnd_crt() {
    int id = idIdc + contador;
    ContenidoGND g = (ContenidoGND) v.getCrt_sedes().getC1().getObject();
    String ret = "INSERT INTO `reporteocr_1`.`gnd_crt`(`idSede`,"
            + "`idIdc`,`id_c1`,`caja`,`anio`,`mes`,`liquidacion`,`unidad`"
            + ",`id_c2`,`id_c3`,`id_c4`)VALUES("
            + idSede + ", "
            + id + ", '"
            + g.getId() + "', '"
            + g.getCaja() + "', '"
            + g.getAnio() + "', '"
            + g.getMes() + "', '"
            + g.getLiquidacion() + "', '"
            + g.getUnidad() + "', '"
            + v.getCrt_sedes().getC2() + "', '"
            + v.getCrt_sedes().getC3() + "', '"
            + v.getCrt_sedes().getC4() + "'"
            + ");\n";
    return ret;
  }

  public String osn_crt() {
    int id = idIdc + contador;
    ContenidoOSN o = (ContenidoOSN) v.getCrt_sedes().getC1().getObject();
    c2ContenidoOSN c2 = (c2ContenidoOSN) v.getCrt_sedes().getC2().getObject();
    String ret = "INSERT INTO `reporteocr_1`.`osn_crt`"
            + "(`idSede`,`idIdc`,`sumarias`,`id_c2`,`caja`"
            + ",`banco`,`sucursal`,`fecha_presentacion`,`id_c3`,`id_c4`)VALUES("
            + idSede + ", "
            + id + ", "
            + o.getSumaria() + ", '"
            + c2.getId() + "', '"
            + c2.getCaja() + "', '"
            + c2.getBanco() + "', '"
            + c2.getSucursal() + "', '"
            + c2.getFecha_pres() + "', '"
            + v.getCrt_sedes().getC3() + "', '"
            + v.getCrt_sedes().getC4()
            + "');";
    return ret;
  }

  public String gnd_metadatos() {
    //sin verificar hasta que ingrese datos GDN
    int id = idIdc + contador;
    GND_sede g = (GND_sede) v.getIdc().getCampoSede().getObject();
    String ret = "INSERT INTO `reporteocr_1`.`gnd_metadatos`(`idSede`,`idIdc`"
            + ",`grado_valid`,`grado_invalid`,`grado_invalidDB`,`codEst_valid`"
            + ",`codEst_invalid`,`codEst_invalidDB`)VALUES("
            + idSede + ", "
            + id + ", "
            + g.getGrado_valid() + ", "
            + g.getGrado_invalid() + ", "
            + g.getGrado_invalidDB() + ", "
            + g.getCodEst_valid() + ", "
            + g.getCodEst_invalid() + ", "
            + g.getCodEst_invalidDB() + ");\n ";
    return ret;
  }

  public String osn_metadatos() {
    int id = idIdc + contador;
    OSN_sede s = (OSN_sede) v.getIdc().getCampoSede().getObject();
    String ret = "INSERT INTO `reporteocr_1`.`osn_metadatos`(`idSede`"
            + ",`idIdc`,`distrito_valid`,`distrito_invalid`"
            + ",`partida_valid`,`partida_invalid`,`subcuenta_valid`"
            + ",`subcuenta_invalid`,`digito_valid`,`digito_invalid`"
            + ",`anio_valid`,`anio_invalid`,`bimestre_valid`,`bimestre_invalid`)VALUES("
            + idSede + ", "
            + id + ", "
            + s.getDistrito_valid() + ", "
            + s.getDistrito_invalid() + ", "
            + s.getPartida_valid() + ", "
            + s.getPartida_invalid() + ", "
            + s.getSubcuenta_valid() + ", "
            + s.getSubcuenta_invalid() + ", "
            + s.getDigito_valid() + ", "
            + s.getDigito_invalid() + ", "
            + s.getAnio_valid() + ", "
            + s.getAnio_invalid() + ", "
            + s.getBimestre_valid() + ", "
            + s.getBimestre_invalid() + ");\n ";
    return ret;
  }

  public String caratulas() {
    int id = idIdc + contador;
    int idvol = idVolumen + 1;
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
        // System.out.println(cgnd);
        ce2 = cgnd.toString();
        break;
      case 2:
        c2ContenidoOSN c2osn = (c2ContenidoOSN) c.getC2().getObject();
        ce = "null";//c1o.getSumaria();
        ce2 = c2osn.getId();
        break;
      }
    // es el id setVolumen que ya se inserto, no colocar +1
    String ret = "INSERT INTO `reporteocr_1`.`caratulas`(`idIdc`,`idVolumen`"
            + ",`idSede`,`estado`,`tipo_doc`,`subtipo_doc`,`id_c1`,`id_c2`,`id_c3`,`id_c4`)VALUES("
            + id + ", "
            + idvol + ", "
            + idSede + ", '"
            + c.getEstado() + "', '"
            + c.getTipo_doc() + "', '"
            + c.getSubtipo_doc() + "', '"
            + ce + "', '"
            + ce2 + "', '"
            + c.getC3() + "', '"
            + c.getC4() + "');\n ";
    return ret;

  }

  public String volumen() {
    String insertar = "INSERT INTO `reporteocr_1`.`volumen`"
            + "(`idSede`,`volumen`,`cantidad_idcs`,`fecha_reporte`)VALUES('"
            + idSede + "', '"
            + v.getVol_nombre() + "', '"
            + v.getCantidad_idc() + "', '"
            + v.getFecha_reporte() + "');\n";
    return insertar;
  }

  public String setIDC() {
    return new InsertarIDC().insertarEnIDc(idVolumen, v, idSede);
  }
}
