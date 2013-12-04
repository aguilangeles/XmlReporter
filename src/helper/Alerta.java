/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Alerta {

  public Alerta() {
  }

  public static void alerta(String string, boolean bool) {
    if (!bool)
      {
      String mensaje = "No se realizó la inserción en la tabla '" + string + "' de la DB";
      ExceptionMessage.message(mensaje, Alerta.class.getName());
      }
  }
}
