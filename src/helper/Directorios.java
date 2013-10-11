/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import clases.GetSede;
import java.io.File;
import java.io.FileFilter;
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
  private FileFilter filefilter;
  private File folder;
  private String pathname;

  public Directorios(String pathname, File[] listOfFiles, FileFilter filefilter, File folder) {
    this.pathname = pathname;
    this.filefilter = filefilter;
    findFiles(folder);
  }

  private void findFiles(File file) {
    int contador, idsede = 0;
    String sigla = null;
    String name = null;
    File[] files = file.listFiles(filefilter);
    for (int i = 0; i < files.length; i++)
      {
        System.out.println(files[i]);
      boolean isNotImg = files[i].getAbsolutePath().endsWith("Borradas") ? true : false;
      boolean isNotBorrada = files[i].getAbsolutePath().endsWith("Imagenes") ? true : false;
      if (files[i].isDirectory() && !isNotImg && !isNotBorrada)
        {
        findFiles(files[i]);
        name = files[i].getName();
        }
      if (name != null)
        {
        quantIDC++;
        String[] spl = name.split("#");
        for (int m = 0; m < spl.length; m++)
          {
          boolean isGND = (spl[m].contains("GND")) ? true : false;
          boolean isOSN = (spl[m].contains("OSN")) ? true : false;
          if (isGND)
            {
            sigla = "GND";
            idsede = 1;
            } else if (isOSN)
            {
            sigla = "osn";
            idsede = 2;
            }
          }
        identificarSede = new GetSede(name, sigla, spl[1], pathname, spl[3], idsede);
        int id = GetSede.getOrden();
        pathsMap.put(id, identificarSede.getPath());
        idcMaps.put(id, identificarSede.getNombreCompleto());
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
