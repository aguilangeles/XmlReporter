/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import helper.ExceptionMessage;
import helper.SedeYSigla;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.swing.JOptionPane;

/**
 * Obtener el nombre del volumen el nombre del meta el nombre del idc y el orden
 * ascendente del idc
 *
 * @author aguilangeles@gmail.com
 */
public class GetCarateristicasDelVolumen {

  private static String volumenName;
  private String nombreCompleto;
  private String pathWithXML;
  private int idsede;
  private String sigla;
  private static int orden;

  public GetCarateristicasDelVolumen(String volumen, String nombreCompleto, String pathname, String endStrin) {
    volumenName = volumen;
    this.nombreCompleto = nombreCompleto;
    this.pathWithXML = pathForXml(pathname, nombreCompleto);
    SedeYSigla sedeYSigla = new SedeYSigla(nombreCompleto);
    this.sigla = SedeYSigla.getSigla();
    this.idsede = SedeYSigla.getIdSede();
    orden = ignoreLetters(endStrin);
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

  private String pathForXml(String apath, String filegetname) {
    String ret = "";
    try
      {
      ret = apath + "/" + URLEncoder.encode(filegetname, "UTF-8") + "/" + "Carat.xml";
      } catch (UnsupportedEncodingException ex)
      {
        ExceptionMessage.message(ex.getMessage(), GetCarateristicasDelVolumen.class.getName()+"Unsupport Enconding");
//      JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de Encode", JOptionPane.ERROR_MESSAGE);
      }
    return ret;
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

  public static String getVolumenName() {
    return volumenName;
  }

  public String getPathWithXML() {
    return pathWithXML;
  }

  @Override
  public String toString() {
    return "Sede{" + "nombreCompleto=" + nombreCompleto
            + ", idsede=" + idsede
            + ", sigla=" + sigla
            + ", path=" + pathWithXML
            + ", orden=" + orden
            + ", volumen=" + volumenName + '}';
  }
}
