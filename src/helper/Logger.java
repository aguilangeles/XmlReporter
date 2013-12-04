/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Logger {

  private File file;
  private String output;

  public Logger(String output) {
    this.output = output;
  }

  public void salida(MensajeTxt message)  {
    file = new File(output);

    FileWriter out = null;
    PrintWriter pw = null;
    try
      {
      out = new FileWriter(file,true);
      pw = new PrintWriter(out);
      pw.println("Fecha: " + message.getFecha());
      pw.println("Ruta: " + message.getRuta());
      pw.println("Descripcion: " + message.getDescripcion());
      pw.println("\n");
      pw.flush();
      } catch (IOException ex)
      {
      ExceptionMessage.message(ex.getMessage(), Logger.class.getName()+" IO ex");
//      JOptionPane.showMessageDialog(null, ex.getMessage());
      } finally
      {
      if (null != out)
        {
        try
          {
          out.close();
          pw.close();
          } catch (IOException e)
          {
      ExceptionMessage.message(e.getMessage(), Logger.class.getName()+" IO ex close");
//          JOptionPane.showMessageDialog(null, e.getMessage(), "Error al cerrar archivo txt", JOptionPane.ERROR_MESSAGE);
          }
        }
      }
  }

  public String getUbicacion() {
    return file.getAbsolutePath();
  }
}
