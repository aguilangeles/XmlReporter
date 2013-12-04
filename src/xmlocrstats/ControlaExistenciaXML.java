/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlocrstats;

import helper.ExceptionMessage;
import helper.GetDirectorios;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import testDatabase.ReadProperties;

/**
 * Controlar La existencia de los archivos requeridos.
 *
 * @author aguilangeles@gmail.com
 */
public class ControlaExistenciaXML {

  private List<String> lista = new ArrayList<>();

  public ControlaExistenciaXML(GetDirectorios dirs) {
    verificarExistencia(dirs);
  }

  private void verificarExistencia(GetDirectorios dirs) {
    Iterator it = dirs.getPathsMaps().keySet().iterator();
    while (it.hasNext())
      {
      try
        {
        Object key = it.next();
        String rutaProcesada = (String) dirs.getPathsMaps().get(key);
        String decc = URLDecoder.decode(rutaProcesada, "UTF-8");
        existeCaratula(decc);
        } catch (UnsupportedEncodingException ex)
        {
        ExceptionMessage.message(ex.getMessage(), ControlaExistenciaXML.class.getName() + " UnsupportedEncoding");
        }
      }
  }

  private void existeCaratula(String decc) {
    File file = new File(decc);
    if (!file.exists())
      {
      lista.add(file.getAbsolutePath());
      }
    existenOtros(decc, "Carat.xml", "Mapeo.xml");
    existenOtros(decc, "Carat.xml", "Meta.xml");
  }

  private void existenOtros(String decc, String oldpath, String replace) {
    String newpath = decc.replace(oldpath, replace);
    File file = new File(newpath);
    if (!file.exists())
      {
      lista.add(file.getAbsolutePath());
      }
  }

  public List<String> getLista() {
    return lista;
  }
}
