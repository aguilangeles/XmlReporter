/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetSede {

  private String nombreCompleto;
  private String sigla;
  private String volumen;
  private String endString;
  private static String path;
  private int idsede;
  private static int orden;

  public GetSede(String nombreCompleto, String sigla, String volumen, String pathname, String endStrin, int idsede) {
    this.nombreCompleto = nombreCompleto;
    this.sigla = sigla;
    this.volumen = volumen;
    this.endString = endStrin;
    path = newPathname(pathname, nombreCompleto);
    this.idsede = idsede;
    numeroOrden();
  }

  private void numeroOrden() {
    orden = ignoreLetters(endString);
  }

  private int ignoreLetters(String astring) {
    String rt = "";
    for (int i = 0; i < astring.length(); i++)
      {
      if (!Character.isLetter(astring.charAt(i)))
        {
        rt += astring.charAt(i);
        }
      }
    return Integer.parseInt(rt);

  }

  public String getNombreCompleto() {
    return nombreCompleto;
  }

  public int getIdsede() {
    return idsede;
  }

  public static int getOrden() {
    return orden;
  }

  public String getSigla() {
    return sigla;
  }

  public String getVolumen() {
    return volumen;
  }

  public String getPath() {
    return path;
  }

  private static String newPathname(String apath, String filegetname) {
    String ret = "";
    try
      {
      ret = apath + "/" + URLEncoder.encode(filegetname, "UTF-8") + "/" + "Carat.xml";
      } catch (UnsupportedEncodingException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de Encode", JOptionPane.ERROR_MESSAGE);
      }
    return ret;
  }

  @Override
  public String toString() {
    return "Sede{" + "nombreCompleto=" + nombreCompleto
            + ", idsede=" + idsede
            + ", sigla=" + sigla
            + ", path=" + path
            + ", orden=" + orden
            + ", volumen=" + volumen + '}';
  }
}
