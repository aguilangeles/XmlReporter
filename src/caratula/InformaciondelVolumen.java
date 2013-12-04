/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caratula;

import campo.GetPapelesYCamporForSede;
import entidad.Idc;
import entidad.PapelesPorIDC;
import entidad.Volumen;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class InformaciondelVolumen {

  private Volumen volumen;
  private Idc idc;
  private PapelesPorIDC papelIDC;
  private GetPapelesYCamporForSede papelesCampos;
  private CaratulasMetadata caratulaMetadata;
  private boolean isEjercicio;
  private GetCrtForSede caratulasSedes;

  public InformaciondelVolumen(String pathname, String idcName, int contador, int cantidadIDC) {
    this.caratulaMetadata = new CaratulasMetadata(pathname);
    this.isEjercicio = caratulaMetadata.isEjercicio();
    this.caratulasSedes = caratulaMetadata.getSedesCrt();
    this.papelesCampos = new GetPapelesYCamporForSede(pathname, idcName, isEjercicio);
    this.volumen = setValuesFromVolumen(pathname, idcName, contador, cantidadIDC);
  }

  private Volumen setValuesFromVolumen(String pathname, String idcName, int contador, int cantidadIDC) {
    Volumen setvolumen;
    idc = GetPapelesYCamporForSede.getIdece();
    advertenciaIDCnull(idcName);
    GetPapeles papeles = new GetPapeles(pathname, isEjercicio);
    papelIDC = papeles.getPapelesPorIdc();
    setvolumen = new Volumen(contador, cantidadIDC, idc, papelIDC, caratulasSedes);
    return setvolumen;
  }

  public Volumen getVolumen() {
    return volumen;
  }

  @Override
  public String toString() {
    return "GetResultadosDelVolumen{" + "volumen=" + volumen + ", idc="
            + idc + ", papelIDC=" + papelIDC + ", papelesCampos=" + papelesCampos + '}';
  }

  private void advertenciaIDCnull(String idcName) throws HeadlessException {
    if (idc == null)
      {
      JOptionPane.showMessageDialog(null, "Error en archivo Meta.xml correspondiente a \n" + idcName
              + "\nNo se pueden cargar los datos correspondientes al idc."
              + "\nControle el xml."
              + "\nEl programa deberá cerrarse", "Error en la lectura del xml", JOptionPane.ERROR_MESSAGE);
      }
  }
}
