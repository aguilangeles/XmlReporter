/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Campos;

import Entidades.CamposPorSedes;
import Entidades.Idc;
import clases.Campo;
import clases.Meta;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class GetPapelesYCamporForSede {

//  private static String v = "valid";
//  private static String iv = "invalid";
//  private static String idb = "invalidDB";
//  private static String grado = "Grado";
//  private static String codEst = "CodEst";
//  private static String nombre = "Nombre";
//  private static int gradov;
//  private static int gradoi;
//  private static int gradoibd;
//  private static int codv;
//  private static int codi;
//  private static int codibd;
//  private static int n;
//  private static int namev;
//  private static int nameid;
//  private static int namei;
//  private static int campcant;
  private boolean ejercicio;
  private String ruta;
  private Object object;
  private int idSede;
  //
  private String idcName;
  private static int pvv;
  private static int piv;
  private static int size;
  private static int valid;
  private static int invalid;
  private static int invalidDB;
  private static Idc idece;
  private static Escritor error = new Escritor("Detalle_errores.txt");

  public GetPapelesYCamporForSede(String ruta, String idcName, boolean ejercicio, int contador, int idSede) {
    this.ruta = ruta;
    this.idcName = idcName;
    this.ejercicio = ejercicio;
    this.idSede = idSede;
    idece = setIdc();
//    imprimir();
  }

  private Idc setIdc() {
    Idc setidc = null;
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
            //
            object = setCamposBySede(metaParser, reporteMeta, meta);
            //
            size = reporteMeta.getCantidadCampos();
            valid = reporteMeta.getCampoStatus("valid");
            invalid = reporteMeta.getCampoStatus("invalid");
            invalidDB = reporteMeta.getCampoStatus("invalidDB");
//            setMetaImageContents(meta, idSede);//servia para controlar
            }

          setMetaImageNull(meta, error, ejercicio, idSede);
          CamposPorSedes camposForSedes = new CamposPorSedes(idcName, object, size, valid, invalid, invalidDB);
          setidc = new Idc(idcName, pvv, piv, camposForSedes);
          }
        }
      } catch (SAXException ex)
      {
      Logger.getLogger(GetPapelesYCamporForSede.class.getName()).log(Level.SEVERE, null, ex);
      }
//    imprimir();
    return setidc;
  }

  public static int getSize() {
    return size;
  }

  public static int getValid() {
    return valid;
  }

  public static int getInvalid() {
    return invalid;
  }

  public static int getInvalidDB() {
    return invalidDB;
  }

  public static Idc getIdece() {
    return idece;
  }

  private Object setCamposBySede(MetaParser metaParser, ReporteXMLMetas reporteMeta, Meta meta) {
    GetCampoBySede setCamposBySede = new GetCampoBySede(metaParser, reporteMeta, meta, idSede);
    return setCamposBySede.getObject();
  }

  private void setMetaImageNull(Meta meta, Escritor error, boolean ejercicio, int idSede) {
    if (meta.getImage() == null)
      {
      GetImageNull imageNull = new GetImageNull(meta, error, ejercicio, idSede);
      object = imageNull.getObject();
      }//fin if
  }

//  private void setMetaImageContents(Meta meta, int idsede) {
//    if (meta.getImage() != null)
//      {
//      gradov = setCampoByNameAndStatus(meta, gradov, grado, v);
//      gradoi = setCampoByNameAndStatus(meta, gradoi, grado, iv);
//      gradoibd = setCampoByNameAndStatus(meta, gradoibd, grado, idb);
//      codv = setCampoByNameAndStatus(meta, codv, codEst, v);
//      codi = setCampoByNameAndStatus(meta, codi, codEst, iv);
//      codibd = setCampoByNameAndStatus(meta, codibd, codEst, idb);
//      namev = setCampoByNameAndStatus(meta, namev, nombre, v);
//      namei = setCampoByNameAndStatus(meta, namei, nombre, iv);
//      nameid = setCampoByNameAndStatus(meta, nameid, nombre, idb);
//      campcant += (meta.getImage().getCantidadDeCampos());
//      }
//
//  }
//
//  private void imprimir() {
//    System.out.println("ruta\t" + ruta);
//    System.out.println("grado v \t" + gradov);
//    System.out.println("grado i \t" + gradoi);
//    System.out.println("grado id \t" + gradoibd);
//    System.out.println("cod est v \t" + codv);
//    System.out.println("cod est i \t" + codi);
//    System.out.println("cod est idb \t" + codibd);
//    System.out.println("nombre v \t" + namev);
//    System.out.println("nombre i \t" + namei);
//    System.out.println("nombre idb \t" + nameid);
//    System.out.println("cantidad de campos \t" + campcant);
//  }

//  private static int setCampoByNameAndStatus(Meta meta, int contadorCampos, String nombre, String estado) {
//    Campo campo = (meta.getImage().getCampoByNameandStatus(nombre, estado));
//    if (campo != null)
//      {
//      contadorCampos += meta.getImage().getCantidadCamposByNameandStatus(nombre, estado);
//      }
//    return contadorCampos;
//  }
}
