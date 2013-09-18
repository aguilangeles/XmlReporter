/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import clases.GetSede;
import java.io.File;
import java.io.FileFilter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 *
 * @author MUTNPROD003
 */
public class Directorios {

  private File[] listOfFiles;
  private String pathname;
  private JTextArea mensaje;
  private static Map<Integer, String> mapa;
  private static SortedMap mapaS = new TreeMap();
  private static SortedMap nombresS = new TreeMap();
  private String nombreSede;
  private String nombreVolumen;
  private String sedes;
  private int contador = 0;
  private SwingWorker integrador;
  private static FileFilter fileFilter;
  private GetSede sg;

  public Directorios(String ruta, JTextArea mensaje, File[] listOfFiles) {
    this.pathname = ruta;
    this.mensaje = mensaje;
    this.listOfFiles = listOfFiles;
    directorio();
  }

  private SortedMap directorio() {
    int id = 0;
    for (File f : listOfFiles)
      {
      contador++;
      nombreSede = f.getName();
      String[] spl = f.getName().split("#");
      sedes = spl[0];
      nombreVolumen = spl[1];
      String finCadena = spl[3];

      sg = new GetSede(nombreSede, spl[0], spl[1], pathname, spl[3]);

      switch (sedes)
        {
        case "OSN":
          id = Integer.parseInt(finCadena);
          break;
        case "GND":
          String sinSl = finCadena.substring(2);
          id = Integer.parseInt(sinSl);
          break;
        }
      mapaS.put(id, sg.getPath());
      nombresS.put(id, nombreSede);
      System.out.println(sg);
      }
    return (SortedMap) mapa;
  }



  public SortedMap getNombreSorted() {
    return nombresS;
  }

  public void setNombreSorted(SortedMap nombreSorted) {
    this.nombresS = nombreSorted;
  }

  public String getNombreVolumen() {
    return nombreVolumen;
  }

  public String getSedes() {
    return sedes;
  }

  public SortedMap getMapaS() {
    return mapaS;
  }

  public int getContador() {
    return contador;
  }

  @Override
  public String toString() {
    return "Directorios{" + "mapa=" + mapa + ", mapaS=" + mapaS
            + ", nombresS=" + nombresS + ", ruta=" + pathname
            + ", fileFilter=" + fileFilter + ", nombreSede=" + nombreSede
            + ", nombreVolumen=" + nombreVolumen + ", sedes=" + sedes
            + ", contador=" + contador + ", mensaje=" + mensaje
            + ", integrador=" + integrador + '}';
  }
}
