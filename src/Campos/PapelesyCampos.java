/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Campos;

import Entidades.CamposSedes;
import Entidades.GND_sede;
import Entidades.Idc;
import Entidades.OSN_sede;
import clases.Meta;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parsers.MetaParser;
import parsers.ReporteXMLMetas;
import txt.Escritor;

/**
 *
 * @author MUTNPROD003
 */
public class PapelesyCampos {

  private boolean ejercicio;
  private String ruta;
  private String idcName;
  private int pvv;
  private int piv;
  private String rutaError = "InformeErrores.txt";
  private int size;
  private int valid;
  private int invalid;
  private int invalidDB;
  private GND_sede nGnd;
  private OSN_sede nOsn;
  private CamposSedes cmpSdes;
  private Idc idece;
  private Object object;
  private int excepcion, idSede;

  public PapelesyCampos(String ruta, String idcName, boolean ejercicio, int contador, int idSede) throws IOException {

    this.ruta = ruta.replace("Carat.xml", "Meta.xml");
    this.idcName = idcName;
    this.ejercicio = ejercicio;
    this.idSede = idSede;
    setIdc();
  }

  private Idc setIdc() {
    Escritor error = new Escritor(rutaError);
    try
      {
      MetaParser metaParser = new MetaParser(ruta);
      if (metaParser != null)
        {
        NamedNodeMap met = metaParser.getMetas();
        for (int i = 0; i < met.getLength(); i++)
          {
          Node metaNode = metaParser.getMetas().item(i);
          NodeList metaChildren = metaNode.getChildNodes();
          Meta meta = new Meta(metaChildren);
          ReporteXMLMetas reporteMeta = metaParser.getReporte();

          if (meta != null)
            {
            pvv = reporteMeta.getCantidadValidMeta();
            piv = reporteMeta.getCantidadInvalidMeta();
            setCamposBySede(metaParser, reporteMeta, meta);
            size = reporteMeta.getCantidadCampos();
            valid = reporteMeta.getCampoStatus("valid");
            invalid = reporteMeta.getCampoStatus("invalid");
            invalidDB = reporteMeta.getCampoStatus("invalidDB");
            }
          if (meta.getImage() == null)
            {
            SimpleDateFormat formateador = new SimpleDateFormat("yyyy'-'MM'-'dd", Locale.ENGLISH);
            Date fecha = new java.util.Date();
            String date = formateador.format(fecha);

            String ejer = (ejercicio) ? "Es ejercicio" : "no posee meta";
            switch (excepcion)
              {
              case 1:
                OSN_sede o = new OSN_sede(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
                object = o;
                break;
              case 2:
                GND_sede g = new GND_sede(0, 0, 0, 0, 0, 0);
                object = g;
                break;

              }
            error.salida(meta.getIdIDC() + "\t" + ejer + "\t" + date + "\n");
            }
          cmpSdes = new CamposSedes(idcName, object, size, valid, invalid, invalidDB);
          idece = new Idc(idcName, pvv, piv, cmpSdes);
          }
        }
      } catch (SAXException ex)
      {
      Logger.getLogger(PapelesyCampos.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex)
      {
      String mensaje = ex.getMessage().toString();
      if (mensaje.contains("El sistema no puede encontrar el archivo especificado"))
        {
        String proc = mensaje.substring(40, mensaje.length() - 1).replace("(", "\t");
        try
          {
          error.salida(proc + "\n");
          } catch (IOException ex1)
          {
          System.out.println("no se pudo escribir el informe");
          Logger.getLogger(PapelesyCampos.class.getName()).log(Level.SEVERE, null, ex1);
          }
        } else
        {
        JOptionPane.showMessageDialog(null, ex);
        }

      }
    return idece;
  }

  public Idc getIdece() {
    return idece;
  }

  public CamposSedes getCmpSdes() {
    return cmpSdes;
  }

  public int getSize() {
    return size;
  }

  public int getValid() {
    return valid;
  }

  public int getInvalid() {
    return invalid;
  }

  public int getInvalidDB() {
    return invalidDB;
  }

  private void setCamposBySede(MetaParser metaParser, ReporteXMLMetas reporteMeta, Meta meta) {
    if (idSede == 2)
      {
      excepcion = 1;
      Campos_OSN osn = new Campos_OSN(metaParser, reporteMeta);
      object = osn.getOsn();
      } else if (idSede == 1)
      {
      excepcion = 2;
      Campos_GND gnd = new Campos_GND(metaParser, reporteMeta, meta);
      object = gnd.getGnd();
      }
  }
}
