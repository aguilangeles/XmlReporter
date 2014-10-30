/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import entidad.GetCarateristicasDelVolumen;
import java.io.File;
import java.io.FileFilter;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class GetDirectorios {

  private SortedMap pathsMap = new TreeMap();
  private SortedMap idcMaps = new TreeMap();
  private int totalIdcs = 0;
  private GetCarateristicasDelVolumen volumen;
  private String pathname;

  public GetDirectorios(String pathname, FileFilter filefilter, File folder) {
    this.pathname = pathname;
    findFiles(folder, filefilter);
  }

  private void findFiles(File file, FileFilter filefilter) {
    int contador, idsede = 0;
    String sigla = null;
    String name = null;
    File[] files = file.listFiles(filefilter);
    for (int i = 0; i < files.length; i++)
      {
      String absolutePath = files[i].getAbsolutePath();
      boolean isNotImg = isIgnoreFile(absolutePath, "Imagenes");
      boolean isNotBorrada = isIgnoreFile(absolutePath, "Borradas");
      if (files[i].isDirectory() && !isNotImg && !isNotBorrada)
        {
        findFiles(files[i], filefilter);
        name = files[i].getName();
        }
      if (name != null)
        {
        llenarMapas(name);
        }
      }
  }

  private boolean isIgnoreFile(String file, String archivo) {
    boolean ret = file.endsWith(archivo) ? true : false;
    return ret;
  }

  private void llenarMapas(String name) {
    totalIdcs++;
    if (name.contains("#"))
      {

      String[] spl = name.split("#");
      volumen = new GetCarateristicasDelVolumen(spl[1], name, pathname, spl[3]);
      int id = GetCarateristicasDelVolumen.getOrden();
      pathsMap.put(id, volumen.getPathWithXML());
      idcMaps.put(id, volumen.getNombreCompleto());
      } else
      {
      JOptionPane.showMessageDialog(null, "Esta carpeta no tiene el formato "
              + "requerido\n para la ejecución del programa.", "Formato incorrecto"
              + " (#).", JOptionPane.ERROR_MESSAGE);
      System.exit(0);
      }
  }

  public GetCarateristicasDelVolumen getIdentificarSede() {
    return volumen;
  }

  public SortedMap getIdcMaps() {
    return idcMaps;
  }

  public SortedMap getPathsMaps() {
    return pathsMap;
  }

  public int getQuatyIDC() {
    return totalIdcs;
  }
}
