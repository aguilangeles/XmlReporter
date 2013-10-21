/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/*import Campos.PorcentajePapeles;*/
import Campos.GetPapelesYCamporForSede;
import Caratulas.GetResultadosDelVolumen;
import Entidades.Total;
import Entidades.Volumen;
import Inserciones.Conexion;
import Inserciones.GetLastID;
import Inserciones.Inserciones;
import Inserciones.InsertarTotales;
import Inserciones.InsertarVolumen;
import clases.GetSede;
import helper.Directorios;
import java.io.File;
import java.io.FileFilter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import xmlocrstatsparaosn.Main;

/**
 *
 * @author MUTNPROD003
 */
public class MyWorker extends SwingWorker<Void, Integer> {

  private String pathname;
  private JLabel conectadoA;
  private JLabel infoJLabel;
  private File[] listOfFiles;
  private File folder;
  private Conexion conexion;
  private JTextField jtRuta;
  private JFrame frame;
  private Directorios directorio;
  int papelTotal = 0, validos = 0, invalidos = 0, imagenes = 0, anversos = 0,
          reversos = 0, campos = 0, cvalidos = 0, cinvalidos = 0, cinvalidDb = 0;
  private SortedMap getNombre;
  private SortedMap getRuta;
  private GetSede gsede;
  private Volumen vol;
  private FileFilter filefilter;

  public MyWorker(String pathname, File[] listOfFiles, File folder, FileFilter filefilter, JLabel infoJLabel, JTextField jtRuta, JFrame frame) {
    this.pathname = pathname;
    this.listOfFiles = listOfFiles;
    this.folder = folder;
    this.filefilter = filefilter;
    this.infoJLabel = infoJLabel;
    this.jtRuta = jtRuta;
    this.frame = frame;

    this.directorio = new Directorios(this.pathname, this.listOfFiles, this.filefilter, this.folder);

    this.getNombre = directorio.getIdcMaps();
    this.getRuta = directorio.getPathsMaps();
    this.gsede = directorio.getIdentificarSede();
    conexion = new Conexion(infoJLabel);
  }

  @Override
  protected Void doInBackground() {
    try
      {
      if (conexion.isConexion())
        {
        GetLastID lastId = new GetLastID(conexion);
        int contador = 0;

        int idVolumen = lastId.getLastIdFromTable("volumen");
        int idIdc = lastId.getLastIdFromTable("idc");

        Inserciones insertResultados = null;

        Iterator it = getNombre.keySet().iterator();
        while (it.hasNext())
          {
          contador++;
          Object key = it.next();
          String rutaProcesada = (String) getRuta.get(key);
          String idcName = (String) getNombre.get(key);

          GetResultadosDelVolumen resultados = new GetResultadosDelVolumen(rutaProcesada,
                  idcName, contador, gsede.getVolumen(), gsede.getSigla(),
                  directorio.getQuatyIDC(), gsede.getIdsede());
          vol = resultados.getVolumen();

          insertResultados = new Inserciones(vol, idVolumen, idIdc, contador);

          papelTotal += resultados.getPapelTotal();
          validos += resultados.getValidos();
          invalidos += resultados.getInvalidos();
          imagenes += resultados.getImagenes();
          anversos += resultados.getAnversos();
          reversos += resultados.getReversos();
          campos += GetPapelesYCamporForSede.getSize();
          cvalidos += GetPapelesYCamporForSede.getValid();
          cinvalidos += GetPapelesYCamporForSede.getInvalid();
          cinvalidDb += GetPapelesYCamporForSede.getInvalidDB();

          infoJLabel.setText("\n\t" + "Analizando el idc:\n" + idcName);

          conexion.executeUpdate(insertResultados.setIDC());
          conexion.executeUpdate(insertResultados.caratulas());
          if (vol.getIdSede() == 1)
            {
            conexion.executeUpdate(insertResultados.setCaratulasForGnd());
            conexion.executeUpdate(insertResultados.gnd_metadatos());
            } else if (vol.getIdSede() == 2)
            {
            conexion.executeUpdate(insertResultados.setCaratulasforOSN());

            conexion.executeUpdate(insertResultados.osn_metadatos());
            }
          conexion.executeUpdate(insertResultados.setCampos());
          }

        InsertarVolumen volumen = new InsertarVolumen(vol, gsede.getIdsede());
        Total totales = new Total(papelTotal, validos, invalidos, imagenes,
                anversos, reversos, campos, cvalidos, cinvalidos, cinvalidDb);
        InsertarTotales insertarTotales = new InsertarTotales(idVolumen, gsede.getIdsede(), idIdc, totales);
        }
      conexion.desconectar();
      } catch (SQLException ex)
      {
      Logger.getLogger(MyWorker.class.getName()).log(Level.SEVERE, null, ex);
      }
    return null;
  }

  @Override
  protected void done() {
    if (!isCancelled())
      {
      String resultado = "";
      String finalizado = "\nReporte Finalizado. "
              + "\nDatos ingresados en:\n Reporteocr_1";
      infoJLabel.setText(finalizado);
//      int selection = JOptionPane.showOptionDialog(null, "Seleccione opcion",
      //"Reporte Finalizado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
//              null, new Object[]
//        {
//        "Nuevo Reporte", "Cerrar"
//        }, "Nuevo Reporte");
//      if (selection != -1)
//        {
//        int getoption = selection + 1;
//        switch (getoption)
//          {
//          case 1:
//            System.exit(0);
//            SwingUtilities.invokeLater(new Runnable() {
//              @Override
//              public void run() {
//                new InformeReporte().setVisible(true);
//              }
//            });
//            break;
//          case 2:
//            System.exit(0);
//            break;
//          }
//        }
      }
  }
}