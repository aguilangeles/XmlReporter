/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import Entidades.Volumen;

/**
 *
 * @author MUTNPROD003
 */
public class Inserciones {

  private Volumen volumen;
  private int idVolumen;
  private int idSede;
  private int idIdc;
  private int contador;

  public Inserciones(Volumen volumen, int idVolumen, int idIdc, int contador) {
    this.volumen = volumen;
    this.idVolumen = idVolumen;
    this.idSede = volumen.getIdSede();
    this.idIdc = idIdc;
    this.contador = contador;
  }

  public String setCampos() {
    return new InsertarCampos().campos(idIdc, contador, volumen, idSede);
  }

  public String setCaratulasForGnd() {
    return new  InsertarCaratulasParaGND().gnd_crt(idIdc, contador, volumen, idSede);
  }

  public String setCaratulasforOSN() {
    return new InsertarCaratulasParaOSN().setcrtforosn(idIdc, contador, volumen, idSede);
  }

  public String gnd_metadatos() {
    return new InsertaraMetadatosEnGND().setmetadatos(idIdc, contador, idSede, volumen);
  }

  public String osn_metadatos() {
    return new InsertarMetadatosEnOSN().setmetadatos(idIdc, contador, idSede, volumen);
  }

  public String caratulas() {
    return new InsertarCaratulas().setcaratulas(idIdc, contador, idVolumen, volumen, idSede);
  }

  public String setIDC() {
    int idvol =idVolumen+1;
    return new InsertarIDC().insertarEnIDc(idvol, volumen, idSede);
  }
}
