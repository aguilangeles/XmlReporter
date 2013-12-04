/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 * Escribe un mensaje general si el meta no tiene contenido.
 *
 * @author MUTNPROD003
 */
public class WriteMessage {
  private String ruta;
  private String mensaje;
  private String ubicacion;


  public WriteMessage(String ruta, String mensaje) {
    this.ruta = ruta;
    this.mensaje = mensaje;
    Logger informe = new Logger("Describe_errores.txt");
    write(informe);
  }

  public WriteMessage() {
  }


  private void write(Logger informe) {
    MensajeTxt msg = new MensajeTxt(ruta, mensaje);
    informe.salida(msg);
    ubicacion = informe.getUbicacion();
  }

  public void writeNewLog(String pathFile,String ruta, String mensaje) {
    Logger escritor = new Logger(pathFile);
    MensajeTxt msg = new MensajeTxt(ruta, mensaje);
    escritor.salida(msg);
    ubicacion = escritor.getUbicacion();

  }

  public String getUbicacion() {
    return ubicacion;
  }
}
