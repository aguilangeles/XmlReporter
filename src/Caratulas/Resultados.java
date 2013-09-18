/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Caratulas;

import Campos.PapelesyCampos;
import Entidades.CamposSedes;
import Entidades.CaratulasSedes;
import Entidades.Idc;
import Entidades.PapelIdc;
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
  private String idcs;
  private int contador;
  private String nombreVolumen;
  private String siglaSede;
  private int cantidadIDC;

  public Resultados(String rutaProcesada, String idcs, int contador, String nombreVolumen, String siglaSede, int cantidadIDC) throws IOException {
    this.rutaProcesada = rutaProcesada;
    this.idcs = idcs;
    this.contador = contador;
    this.nombreVolumen = nombreVolumen;
    this.siglaSede = siglaSede;
    this.cantidadIDC = cantidadIDC;
    volumenResultado();
  }

  public Volumen getVolumen() {
    return volumen;
  }

  private Volumen volumenResultado() throws IOException {
    CaratulasMetadata caratulaMeta = new CaratulasMetadata(rutaProcesada);
    CaratulasSedes caratulasSedes = caratulaMeta.getSedesCrt();
    PapelesyCampos papelesCampos = new PapelesyCampos(rutaProcesada, idcs, caratulaMeta.isIsEjercicio(), contador);
    Idc idc = papelesCampos.getIdece();
    Papeles papeles = new Papeles(rutaProcesada, caratulaMeta.isIsEjercicio());
    PapelIdc papelIDC = papeles.getPapel_idc();
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
