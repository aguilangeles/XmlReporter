/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/*import Campos.PorcentajePapeles;*/
import Caratulas.GetResultadosDelVolumen;
import Entidades.Total;
import Entidades.Volumen;
import Inserciones.Conexion;
import Inserciones.GetLastID;
import Inserciones.InsertarIDC;
import Inserciones.InsertarStrings;
import Inserciones.InsertarTotales;
import Inserciones.InsertarVolumen;
import clases.GetSede;
import helper.Directorios;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.SortedMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 *
 * @author MUTNPROD003
 */
public class MyWorker extends SwingWorker<Void, Integer> {

  private JButton iniciar;
  private JButton finalizar;
  private JTextArea progreso;
  private String pathname;
  private JLabel conectadoA;
  //
  private File[] listOfFiles;
  private Conexion conexion;
//  private Total t;
  private Directorios directorio;
  int papelTotal = 0, validos = 0, invalidos = 0, imagenes = 0, anversos = 0,
          reversos = 0, campos = 0, cvalidos = 0, cinvalidos = 0, cinvalidDb = 0;
  private SortedMap getNombre;
  private SortedMap getRuta;
  private GetSede gsede;
  private Volumen vol;

  public MyWorker(JButton iniciar, JButton finalizar, JTextArea progreso,
          String pathname, JLabel conectadoA, File[] listOfFiles) {
    this.iniciar = iniciar;
    this.finalizar = finalizar;
    this.progreso = progreso;
    this.pathname = pathname;
    this.conectadoA = conectadoA;
    this.listOfFiles = listOfFiles;
    // traera una lista de los idc ordenados ascendentemente

    this.directorio = new Directorios(pathname, listOfFiles);
    this.getNombre = directorio.getIdcMaps();
    this.getRuta = directorio.getPathsMaps();
    this.gsede = directorio.getIdentificarSede();
    this.conexion = new Conexion(conectadoA, progreso);
  }

  public MyWorker() {
  }

  @Override
  protected Void doInBackground() throws UnsupportedEncodingException, IOException, SQLException {
    conexion.isConexion();
    //todo refactor conexion;
    GetLastID lastId = new GetLastID(conexion);

    int contador = 0;

    int idVolumen = lastId.getLastIdFromTable("volumen");
    int idIdc = lastId.getLastIdFromTable("idc");

    InsertarStrings insertResultados = null;
    Iterator it = getNombre.keySet().iterator();

    while (it.hasNext())
      {
      contador++;
      Object key = it.next();

      String rutaProcesada = (String) getRuta.get(key);
      String idcName = (String) getNombre.get(key);
      //
      GetResultadosDelVolumen resultados = new GetResultadosDelVolumen(rutaProcesada,
              idcName, contador, gsede.getVolumen(), gsede.getSigla(),
              directorio.getQuatyIDC(), gsede.getIdsede());
      //

      vol = resultados.getVolumen();

      //
      insertResultados = new InsertarStrings(vol, idVolumen, vol.getIdSede(), idIdc, contador);

      papelTotal += resultados.getPapelTotal();
      validos += resultados.getValidos();
      invalidos += resultados.getInvalidos();
      imagenes += resultados.getImagenes();
      anversos += resultados.getAnversos();
      reversos += resultados.getReversos();
      campos += resultados.getCampos();
      cvalidos += resultados.getCvalidos();
      cinvalidos += resultados.getCinvalidos();
      cinvalidDb += resultados.getCinvalidDb();
      //
      progreso.setText("\n\t" + "Analizando el idc:\n" + idcName);
      //
      InsertarIDC insertarIDC = new InsertarIDC(idVolumen, vol, gsede.getIdsede());
      conexion.executeUpdate(insertResultados.caratulas());
      if (vol.getIdSede() == 1)
        {
        conexion.executeUpdate(insertResultados.gnd_crt());
        conexion.executeUpdate(insertResultados.gnd_metadatos());
        } else if (vol.getIdSede() == 2)
        {
        conexion.executeUpdate(insertResultados.osn_crt());

        conexion.executeUpdate(insertResultados.osn_metadatos());
        }
      conexion.executeUpdate(insertResultados.campos());
      }

    InsertarVolumen volumen = new InsertarVolumen(vol, gsede.getIdsede());

    Total totales = new Total(papelTotal, validos, invalidos, imagenes,
            anversos, reversos, campos, cvalidos, cinvalidos, cinvalidDb);

    InsertarTotales insertarTotales = new InsertarTotales(idVolumen, gsede.getIdsede(), idIdc, totales);
    //
    conexion.desconectar();
    return null;
  }

  @Override
  protected void done() {
    String resultado = "";
    String finalizado = "\nReporte Finalizado. "
            + "\nDatos ingresados en:\n" //            + conexion.getInfo() + ""
            ;
  }
}