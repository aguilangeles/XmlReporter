/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import entidad.Volumen;
import helper.SedeYSigla;

/**
 *
 * @author MUTNPROD003
 */
public class StringInsert {

  private Volumen volumen;
  private int idVolumen;
  private int idSede;
  private int idIdc;
  private int contador;

  public StringInsert(Volumen volumen, int idVolumen, int idIdc, int contador) {
    this.volumen = volumen;
    this.idVolumen = idVolumen;
    this.idSede = SedeYSigla.getIdSede();
    this.idIdc = idIdc;
    this.contador = contador;
  }

  public String getCampos() {
    return new InsertarCampos().campos(idIdc, contador, volumen, idSede);
  }

  public String getCaratulasForGnd() {
    return new InsertarCaratulasParaGNA().gna_crt(idIdc, contador, volumen, idSede);
  }

  public String getCaratulasforOSN() {
    return new InsertarCaratulasParaOSN().setcrtforosn(idIdc, contador, volumen, idSede);
  }

  public String getGnd_metadatos() {
    return new InsertaraMetadatosEnGNA().setmetadatos(idIdc, contador, idSede, volumen);
  }

  public String getOsn_metadatos() {
    return new InsertarMetadatosEnOSN().setmetadatos(idIdc, contador, idSede, volumen);
  }

  public String getCaratulas() {
    return new InsertarCaratulas().setcaratulas(idIdc, contador, idVolumen, volumen, idSede);
  }

  public String getIDC() {
    int idvol = idVolumen + 1;
    return new InsertarIDC().insertarEnIDc(idvol, volumen, idSede);
  }
}
