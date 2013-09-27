/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Campos;

import helper.MensajeTxt;
import txt.Escritor;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class FileNotFound {

  private static final String NOTFOUND = "(El sistema no puede encontrar el archivo especificado)";

  public FileNotFound(String mensaje, Escritor error) {
  }

  private void fileNotFound(String mensaje,Escritor error) {
    String path = mensaje.substring(0, mensaje.length() - NOTFOUND.length());
    MensajeTxt message = new MensajeTxt(path, NOTFOUND);
    error.salida(message);
  }
}
