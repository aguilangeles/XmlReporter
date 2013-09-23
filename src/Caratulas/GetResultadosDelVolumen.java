/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Caratulas;

import Campos.GetPapelesYCamporForSede;
import Entidades.GetCrtForSede;
import Entidades.Idc;
import Entidades.PapelesPorIDC;
import Entidades.Volumen;

/**
 *
 * @author MUTNPROD003
 */
public class GetResultadosDelVolumen {

  private Volumen volumen;
  private Idc idc;
  private PapelesPorIDC papelIDC;
  private GetPapelesYCamporForSede papelesCampos;

  public GetResultadosDelVolumen(String pathname, String idcName, int contador,
          String nombreVolumen, String siglaSede, int cantidadIDC, int idSede) {

    this.volumen = setValuesFromVolumen(pathname, idcName, contador, nombreVolumen,
            siglaSede, cantidadIDC, idSede);
  }

  private Volumen setValuesFromVolumen(String pathname, String idcName,
          int contador, String nombreVolumen, String siglaSede, int cantidadIDC, int idSede) {

    Volumen setvolumen;

    CaratulasMetadata caratulaMeta = new CaratulasMetadata(pathname, idSede);

    GetCrtForSede caratulasSedes = caratulaMeta.getSedesCrt();

    papelesCampos = new GetPapelesYCamporForSede(pathname, idcName, caratulaMeta.isIsEjercicio(), contador, idSede);
    //
    idc = papelesCampos.getIdece();

    GetPapeles papeles = new GetPapeles(pathname, caratulaMeta.isIsEjercicio());

    papelIDC = papeles.getPapelesPorIdc();

    setvolumen = new Volumen(contador, nombreVolumen, cantidadIDC, idc, papelIDC, caratulasSedes, idSede);

    return setvolumen;
  }

  public Volumen getVolumen() {
    return volumen;
  }

  public int getPapelTotal() {
    return papelIDC.getPapeles();
  }

  public int getValidos() {
    return idc.getValidos();
  }

  public int getInvalidos() {
    return idc.getInvalidos();
  }

  public int getImagenes() {
    return papelIDC.getImagenes();
  }

  public int getAnversos() {
    return papelIDC.getAnversos();
  }

  public int getReversos() {
    return papelIDC.getReversos();
  }

  public int getCampos() {
    return papelesCampos.getSize();
  }

  public int getCvalidos() {
    return papelesCampos.getValid();
  }

  public int getCinvalidos() {
    return papelesCampos.getInvalid();
  }

  public int getCinvalidDb() {
    return papelesCampos.getInvalidDB();
  }
}
