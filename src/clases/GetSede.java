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
  private static int idsede;
  private static int orden;

  public GetSede(String nombreCompleto, String sigla, String volumen, String pathname, String endStrin) {
    this.nombreCompleto = nombreCompleto;
    this.sigla = sigla;
    this.volumen = volumen;
    this.endString = endStrin;
    path = newPathname(pathname, nombreCompleto);
    setIdSede();
    numeroOrden();
  }

  private void setIdSede() {
    if (this.sigla.equals("GND"))
      {
      GetSede.idsede = 1;
      } else
      {
      GetSede.idsede = 2;
      }
  }

  private void numeroOrden() {
    switch (getIdsede())
      {
      case 2:
        orden = Integer.parseInt(endString);
        break;
      case 1:
        String sinSl = endString.substring(2);
        orden = Integer.parseInt(sinSl);
        break;
      }
  }

  public String getNombreCompleto() {
    return nombreCompleto;
  }

  public int getIdsede() {
    return idsede;
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
