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
import javax.swing.JOptionPane;

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
//    System.out.println(idcName);
    this.volumen = setValuesFromVolumen(pathname, idcName, contador, nombreVolumen,
            siglaSede, cantidadIDC, idSede);
  }

  private Volumen setValuesFromVolumen(String pathname, String idcName,
          int contador, String nombreVolumen, String siglaSede, int cantidadIDC, int idSede) {

    Volumen setvolumen;

    CaratulasMetadata caratulaMeta = new CaratulasMetadata(pathname, idSede);

    GetCrtForSede caratulasSedes = caratulaMeta.getSedesCrt();
    // System.out.println("Carat\t"+caratulasSedes);
    String path = pathname.replace("Carat.xml", "Meta.xml");
    papelesCampos = new GetPapelesYCamporForSede(path, idcName, caratulaMeta.isIsEjercicio(), contador, idSede);
    //
    idc = GetPapelesYCamporForSede.getIdece();
    if (idc == null)
      {
      JOptionPane.showMessageDialog(null, "Error en archivo Meta.xml correspondiente a \n" + idcName
              + "\nNo se pueden cargar los datos correspondientes al idc."
              + "\nControle el xml."
              + "\nEl programa deberá cerrarse", "Error en la lectura del xml", JOptionPane.ERROR_MESSAGE);
      }
    GetPapeles papeles = new GetPapeles(pathname, caratulaMeta.isIsEjercicio());

    papelIDC = papeles.getPapelesPorIdc();

    setvolumen = new Volumen(contador, nombreVolumen, cantidadIDC, idc, papelIDC, caratulasSedes, idSede);
    // System.out.println(setvolumen);
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

  @Override
  public String toString() {
    return "GetResultadosDelVolumen{" + "volumen=" + volumen + ", idc=" + idc + ", papelIDC=" + papelIDC + ", papelesCampos=" + papelesCampos + '}';
  }
}
