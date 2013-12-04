/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.File;
import java.io.FileFilter;

/**
 * chequea que la ruta ingresada coincida con un archivo. prepara la ruta para
 * que no tenga separacione prepara adapta con fileseparator
 *
 * @author aguilangeles@gmail.com
 */
public class AcondicionarFiles {

  public static final String FILENOTFOUND = "La ruta especificada no existe.";
  private boolean file;
  private String pathname;
  private File folder;
  private FileFilter filefilter;

  public AcondicionarFiles(String name) {
    String path = pathameTrim(name);
    pathname = fileSeparator(path);
    file = listarFiles(pathname);
  }

  private String pathameTrim(String pathname) {
    return pathname.trim();
  }

  private String fileSeparator(String pathname) {
    String fileseparator = "";
    if (pathname.contains("\\"))
      {
      fileseparator = pathname.replace("\\", File.separator);
      } else if (pathname.contains("/"))
      {
      fileseparator = pathname.replace("/", File.separator);
      }
    return fileseparator;
  }

  private boolean listarFiles(String name) {
    folder = new File(name);
    filefilter = new java.io.FileFilter() {
      @Override
      public boolean accept(File file) {
        return file.isDirectory();
      }
    };
    if (folder.exists())
      {
      return true;
      }
    return false;
  }

  public boolean isFile() {
    return file;
  }

  public String getPathname() {
    return pathname;
  }

  public File getFolder() {
    return folder;
  }

  public FileFilter getFilefilter() {
    return filefilter;
  }
}
