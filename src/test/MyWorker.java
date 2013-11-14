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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

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

          infoJLabel.setText("\n\t" + "Analizando el idc: \n" + idcName);
//
          boolean setidc = conexion.executeUpdate(insertResultados.setIDC());

          alerta("Idc ", setidc);
          //
          boolean carat = conexion.executeUpdate(insertResultados.caratulas());
          alerta("Caratulas ", carat);
//          /*no son las caratulas*/
          if (vol.getIdSede() == 1)
            {
            boolean crtgnd = conexion.executeUpdate(insertResultados.setCaratulasForGnd());
            alerta("Crt Gna ", crtgnd);
            boolean gnd_meta = conexion.executeUpdate(insertResultados.gnd_metadatos());
            alerta("Gna Meta ", gnd_meta);
            } else if (vol.getIdSede() == 2)
            {
            boolean crtosn = conexion.executeUpdate(insertResultados.setCaratulasforOSN());
            alerta("Crt Osn ", crtosn);

            boolean osn_meta = conexion.executeUpdate(insertResultados.osn_metadatos());
            alerta("Osn Meta ", osn_meta);

            }
          boolean campos = conexion.executeUpdate(insertResultados.setCampos());
          alerta("Campos ", campos);
          }

        new InsertarVolumen().setVolumen(vol, gsede.getIdsede());


        Total totales = new Total(papelTotal, validos, invalidos, imagenes,
                anversos, reversos, campos, cvalidos, cinvalidos, cinvalidDb);
       // System.out.println(totales);
        InsertarTotales insertarTotales = new InsertarTotales(idVolumen, gsede.getIdsede(), idIdc, totales);
        }//fin conexion
     // System.out.println("se acabo");
      } catch (SQLException ex)
      {
      Logger.getLogger(MyWorker.class.getName()).log(Level.SEVERE, null, ex);
      }
    //System.out.println("desconecto");
    conexion.desconectar();
    return null;
  }

  private void alerta(String string, boolean bool) {
    if (!bool)
      {
      JOptionPane.showMessageDialog(null, "Tabla " + string + bool, "No se realizo la insercion en la base de datos", JOptionPane.ERROR_MESSAGE);
      }
  }

  @Override
  protected void done() {
    if (!isCancelled())
      {
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
}