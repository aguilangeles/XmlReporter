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
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    private String nombre;
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
    private int excepcion;

    public PapelesyCampos(String ruta, String nombre, boolean ejercicio, int contador) throws IOException {
        this.ruta = ruta.replace("Carat.xml", "Meta.xml");
        this.nombre = nombre;
        this.ejercicio = ejercicio;
        setIdc();
    }

    private Idc setIdc() {
        Escritor error = new Escritor(rutaError);
        try {
            MetaParser metaParser = new MetaParser(ruta);
            if (metaParser != null) {
                int sizeMetas = metaParser.getMetas().getLength();
                for (int i = 0; i < sizeMetas; i++) {
                    Node metaNode = metaParser.getMetas().item(i);
                    NodeList metaChildren = metaNode.getChildNodes();
                    Meta meta = new Meta(metaChildren);
                    ReporteXMLMetas reporteMeta = metaParser.getReporte();

                    if (meta != null) {
                        pvv = reporteMeta.getCantidadValidMeta();
                        piv = reporteMeta.getCantidadInvalidMeta();
                        if (nombre.startsWith("OSN")) {
                            excepcion = 1;
                            Campos_OSN osn = new Campos_OSN(metaParser, reporteMeta);
                            object = osn.getOsn();
                        } else if (nombre.startsWith("GND")) {
                            excepcion = 2;
                            Campos_GND gnd = new Campos_GND(metaParser, reporteMeta, meta);
                            object = gnd.getGnd();
                        }
                        size = reporteMeta.getCantidadCampos();
                        valid = reporteMeta.getCampoStatus("valid");
                        invalid = reporteMeta.getCampoStatus("invalid");
                        invalidDB = reporteMeta.getCampoStatus("invalidDB");
                    }
                    if (meta.getImage() == null) {
                          SimpleDateFormat formateador = new SimpleDateFormat("yyyy'-'MM'-'dd", Locale.ENGLISH);
                        Date fecha = new java.util.Date();
                        String date = formateador.format(fecha);

                        String ejer = (ejercicio) ? "Es ejercicio" : "no posee meta";
                        switch (excepcion) {
                            case 1:
                                OSN_sede o = new OSN_sede(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
                                object = o;
                                break;
                            case 2:
                                GND_sede g = new GND_sede(0, 0, 0, 0, 0, 0);
                                object = g;
                                break;

                        }
                        error.salida(meta.getIdIDC() + "\t" + ejer + "\t"+date +"\n");
                    }
                    cmpSdes = new CamposSedes(nombre, object, size, valid, invalid, invalidDB);
                    idece = new Idc(nombre, pvv, piv, cmpSdes);
                }
            }
        } catch (SAXException ex) {
            Logger.getLogger(PapelesyCampos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            String mensaje = ex.getMessage().toString();
            if (mensaje.contains("El sistema no puede encontrar el archivo especificado")) {
                String proc = mensaje.substring(40, mensaje.length() - 1).replace("(", "\t");
                try {
                    error.salida(proc + "\n");
                } catch (IOException ex1) {
                    System.out.println("no se pudo escribir el informe");
                    Logger.getLogger(PapelesyCampos.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } else {
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

}
