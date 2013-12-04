/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class ExceptionMessage {

  private static String classname;
  private static String mensaje;
  private static String titulo;

  public ExceptionMessage() {
  }

  public static void message(String mensaje, String titulo) {
    JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
  }
}
