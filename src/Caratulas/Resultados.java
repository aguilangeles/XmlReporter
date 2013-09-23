/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Caratulas;

import Campos.GetPapelesYCamporForSede;
import Entidades.CamposSedes;
import Entidades.GetCrtForSede;
import Entidades.Idc;
import Entidades.PapelesPorIDC;
import Entidades.Volumen;
import java.io.IOException;

/**
 *
 * @author MUTNPROD003
 */
public class Resultados {

  private int papelTotal;
  private int validos;
  private int invalidos;
  private int imagenes;
  private int anversos;
  private int reversos;
  private int campos;
  private int cvalidos;
  private int cinvalidos;
  private int cinvalidDb;
  private Volumen volumen;
  private String rutaProcesada;
  private String idcName;
  private int contador;
  private String nombreVolumen;
  private String siglaSede;
  private int cantidadIDC;
  private int idsede;

  public Resultados(String rutaProcesada, String idcName, int contador, String nombreVolumen, String siglaSede, int cantidadIDC, int idSede) throws IOException {
    this.rutaProcesada = rutaProcesada;
    this.idcName = idcName;
    this.contador = contador;
    this.nombreVolumen = nombreVolumen;
    this.siglaSede = siglaSede;
    this.cantidadIDC = cantidadIDC;
    this.idsede=idSede;
    volumenResultado();
  }

  public Volumen getVolumen() {
    return volumen;
  }

  private Volumen volumenResultado() {

    CaratulasMetadata caratulaMeta = new CaratulasMetadata(rutaProcesada, idsede);

    GetCrtForSede caratulasSedes = caratulaMeta.getSedesCrt();

    GetPapelesYCamporForSede papelesCampos = new GetPapelesYCamporForSede(rutaProcesada, idcName, caratulaMeta.isIsEjercicio(), contador, idsede);
   //
    Idc idc = papelesCampos.getIdece();

    GetPapeles papeles = new GetPapeles(rutaProcesada, caratulaMeta.isIsEjercicio());

    PapelesPorIDC papelIDC = papeles.getPapelesPorIdc();
    CamposSedes camposSedes = idc.getCampoSede();

    papelTotal = papelIDC.getPapeles();
    validos = idc.getValidos();
    invalidos = idc.getInvalidos();
    imagenes = papelIDC.getImagenes();
    anversos = papelIDC.getAnversos();
    reversos = papelIDC.getReversos();
    campos = papelesCampos.getSize();
    cvalidos = papelesCampos.getValid();
    cinvalidos = papelesCampos.getInvalid();
    cinvalidDb = papelesCampos.getInvalidDB();
    volumen = new Volumen(contador, nombreVolumen, siglaSede, cantidadIDC, idc, papelIDC, caratulasSedes);
    return volumen;
  }

  public int getPapelTotal() {
    return papelTotal;
  }

  public int getValidos() {
    return validos;
  }

  public int getInvalidos() {
    return invalidos;
  }

  public int getImagenes() {
    return imagenes;
  }

  public int getAnversos() {
    return anversos;
  }

  public int getReversos() {
    return reversos;
  }

  public int getCampos() {
    return campos;
  }

  public int getCvalidos() {
    return cvalidos;
  }

  public int getCinvalidos() {
    return cinvalidos;
  }

  public int getCinvalidDb() {
    return cinvalidDb;
  }
}
