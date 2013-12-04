/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InformationDone {

  public InformationDone(JLabel infoJLabel, JTextField jtRuta) {
     String resultado = "";
      String finalizado = "\nReporte Finalizado. "
              + "\nDatos ingresados en:\n Reporteocr_1";
      infoJLabel.setText(finalizado);
      int selection = JOptionPane.showOptionDialog(null, "Seleccione opcion",
              "Reporte Finalizado\n", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
              null, new Object[]
        {
        "Nuevo Reporte", "Salir"
        }, "Nuevo Reporte");
      if (selection != -1)
        {
        int getoption = selection + 1;
        switch (getoption)
          {
          case 1:
            jtRuta.setText("");
            break;
          case 2:
            System.exit(0);
            break;
          }
        }
  }

}
