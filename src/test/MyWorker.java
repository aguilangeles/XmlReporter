/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/*import Campos.PorcentajePapeles;*/
import Caratulas.Resultados;
import Entidades.Total;
import Entidades.Volumen;
import Inserciones.Conexion;
import Inserciones.InsertarStrings;
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
  private Total t;
  private Directorios directorio;
  int papelTotal = 0, validos = 0, invalidos = 0, imagenes = 0, anversos = 0, reversos = 0, campos = 0, cvalidos = 0, cinvalidos = 0, cinvalidDb = 0;

  public MyWorker(JButton iniciar, JButton finalizar, JTextArea progreso, String pathname, JLabel conectadoA, File[] listOfFiles) {
    this.iniciar = iniciar;
    this.finalizar = finalizar;
    this.progreso = progreso;
    this.pathname = pathname;
    this.conectadoA = conectadoA;
    this.listOfFiles = listOfFiles;

  }

  public MyWorker() {
  }

  @Override
  protected Void doInBackground() throws UnsupportedEncodingException, IOException, SQLException {
    conexion = new Conexion(conectadoA, progreso);
    conexion.conectar();
    int contador = 0;
    int idVolumen = conexion.volumen();
    int idIdc = conexion.idc();
    InsertarStrings insert = null;
    directorio = new Directorios(pathname, progreso, listOfFiles);
    //
    SortedMap getNombre = directorio.getNombreSorted();
    SortedMap getRuta = directorio.getMapaS();
    Iterator it = getNombre.keySet().iterator();
    String nombreVolumen = directorio.getNombreVolumen();
    String siglaSede = directorio.getSedes();
    int cantidadIDC = directorio.getContador();
    while (it.hasNext())
      {
      contador++;
      Object key = it.next();
      String rutaProcesada = (String) getRuta.get(key);
      String idcs = (String) getNombre.get(key);
      Resultados resultados = new Resultados(rutaProcesada, idcs, contador, nombreVolumen, siglaSede, cantidadIDC);
      Volumen v = resultados.getVolumen();
      insert = new InsertarStrings(v, idVolumen, v.getIdSede(), idIdc, contador);
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
      progreso.setText("\n\t" + "Analizando el idc:\n" + idcs);
      conexion.executeUpdate(insert.idc());
      conexion.executeUpdate(insert.caratulas());
      if (v.getIdSede() == 1)
        {
        conexion.executeUpdate(insert.gnd_crt());
        conexion.executeUpdate(insert.gnd_metadatos());
        } else if (v.getIdSede() == 2)
        {
        conexion.executeUpdate(insert.osn_crt());
        conexion.executeUpdate(insert.osn_metadatos());
        }
      conexion.executeUpdate(insert.campos());
      }
    conexion.executeUpdate(insert.volumen());
    t = new Total(papelTotal, validos, invalidos, imagenes,
            anversos, reversos, campos, cvalidos, cinvalidos, cinvalidDb);
    conexion.executeUpdate(insert.totales(t));
    conexion.desconectar();
    return null;
  }

  @Override
  protected void done() {
    String resultado = "";
    String finalizado = "\nReporte Finalizado. "
            + "\nDatos ingresados en:\n"
            + conexion.getInfo() + "";
  }
}