/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import caratula.GetCrtForSede;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author MUTNPROD003
 */
public class Volumen {

  private int idVolumen;
  private int idSede;
  private String nombreVolumen;
  private int cantidadIDC;
  private Idc idc;
  private GetCrtForSede getCrtForSede;
  private PapelesPorIDC papeles;
  private static String fecha_reporte;

  public Volumen(int idVolumen, int cantidadIDC, Idc idc, PapelesPorIDC papelesPorIdc, GetCrtForSede getCrtForSede) {
    this.idVolumen = idVolumen;
    this.nombreVolumen = GetCarateristicasDelVolumen.getVolumenName();
    this.cantidadIDC = cantidadIDC;
    this.idc = idc;
    this.papeles = papelesPorIdc;
    this.getCrtForSede = getCrtForSede;
  }

  public int getId() {
    return idVolumen;
  }

  public String getVol_nombre() {
    return nombreVolumen;
  }

  public int getCantidad_idc() {
    int ret = 0;
    ret += cantidadIDC;
    return ret;
  }

  public String getFecha_reporte() {
    SimpleDateFormat formateador = new SimpleDateFormat("yyyy'-'MM'-'dd", Locale.ENGLISH);
    Date fecha = new java.util.Date();
    return formateador.format(fecha);
  }

  public Idc getIdc() {
    return idc;
  }

  public PapelesPorIDC getPapeles() {
    return papeles;
  }

  public GetCrtForSede getCrt_sedes() {
    return getCrtForSede;
  }

  @Override
  public String toString() {
    return "Volumen{" + "idVolumen=" + idVolumen
            + ", idSede=" + idSede
            + ", nombreVolumen=" + nombreVolumen
            + ", cantidadIDC=" + cantidadIDC
            + ", idc=" + idc
            + ", getCrtForSede=" + getCrtForSede
            + ", papeles=" + papeles + '}';
  }
}
