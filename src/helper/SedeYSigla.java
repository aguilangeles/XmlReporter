/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class SedeYSigla {

  private static int idSede;
  private static String sigla;

  public SedeYSigla(String sedeName) {
    SedeYSigla.idSede = numerodesede(sedeName);

  }

  private int numerodesede(String sedename) {
    int ret = 0;
    if (sedename.contains("GND"))
      {
      ret = 1;
      SedeYSigla.sigla = "GNA";
      } else if (sedename.contains("OSN"))
      {
      ret = 2;
      SedeYSigla.sigla = "OSN";
      }
    return ret;
  }

  public static int getIdSede() {
    return idSede;
  }

  public static String getSigla() {
    return sigla;
  }
}
