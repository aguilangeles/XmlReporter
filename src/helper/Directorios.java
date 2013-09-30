/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import clases.GetSede;
import java.io.File;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author MUTNPROD003
 */
public class Directorios {

  private static SortedMap pathsMap = new TreeMap();
  private static SortedMap idcMaps = new TreeMap();
  private int quantIDC = 0;
  private GetSede identificarSede;

  public Directorios(String pathname, File[] listOfFiles) {
    directorioOrdenado(pathname,listOfFiles);
  }

  private void directorioOrdenado(String pathname, File[] listOfFiles) {
    for (File f : listOfFiles)
      {
      quantIDC++;
      String name = f.getName();
      String[] spl = f.getName().split("#");
      identificarSede = new GetSede(name, spl[0], spl[1], pathname, spl[3]);
      int id = GetSede.getOrden();
      pathsMap.put(id, identificarSede.getPath());
      idcMaps.put(id, identificarSede.getNombreCompleto());
      }
  }

  private void findFiles(File file) {
    int contador = 0;
    File[] files = file.listFiles();
    for (int i = 0; i < files.length; i++)
      {
      String name = files[i].getName();
      boolean isNotImg = files[i].getAbsolutePath().endsWith("Borradas") ? true : false;
      boolean isNotBorrada = files[i].getAbsolutePath().endsWith("Imagenes") ? true : false;
      if (files[i].isDirectory() && !isNotImg && !isNotBorrada)
        {
        findFiles(files[i]);
        contador++;
        //directorios = new Directorios(name, contador);
        }
      }
  }

  public SortedMap getIdcMaps() {
    return idcMaps;
  }

  public SortedMap getPathsMaps() {
    return pathsMap;
  }

  public int getQuatyIDC() {
    return quantIDC;
  }

  public GetSede getIdentificarSede() {
    return identificarSede;
  }
}
