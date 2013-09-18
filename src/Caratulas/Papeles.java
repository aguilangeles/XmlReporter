/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Caratulas;

import Entidades.PapelIdc;
import clases.XmlMapeo;
import java.io.IOException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parsers.MapeoList;
import parsers.ReporteXMLMapeo;
import parsers.XmlMapeoParser;

/**
 * ttrae los valore del idc
 *
 * @author Administrador
 */
public class Papeles {

    private PapelIdc papel_idc;
    private String rutaProcesada;
    private boolean isEjercicio;

    public Papeles(String ruta) {
        this.rutaProcesada = ruta;
        setValores();
    }

    public Papeles(String rutaProcesada, boolean isEjercicio) {
        this.rutaProcesada = rutaProcesada;
        this.isEjercicio = isEjercicio;
        setValores();
    }

    private PapelIdc setValores() {
        ReporteXMLMapeo reporteMapeo = null;
        try {
            String remplazoMapeoxCaratula = rutaProcesada.replace("Carat.xml", "Mapeo.xml");
            XmlMapeoParser mapeoParser = new XmlMapeoParser(remplazoMapeoxCaratula);
            NodeList xmlMapeoNodeChildren = mapeoParser.getXmlMapeoNode().getChildNodes();
            XmlMapeo xmlMapeo = new XmlMapeo(mapeoParser.getXmlMapeoNode().getChildNodes());
            xmlMapeo.setMapeoLists(mapeoParser.getMapeoLists());
            for (int e = 0; e < mapeoParser.getMapeoLists().getLength(); e++) {
                Node mapeoListNode = mapeoParser.getMapeoLists().item(e);
                NodeList mapeoChildren = mapeoListNode.getChildNodes();
                MapeoList mapeoList = new MapeoList(mapeoChildren);
                reporteMapeo = mapeoParser.getReporte();
                // idc = xmlMapeo.getIdIDC();
                int img = xmlMapeo.getCantidadImagenes();
                int anverso = reporteMapeo.getCantidadPorFace("Anverso");
                int reverso = reporteMapeo.getCantidadPorFace("Reverso");
                int cant_crt = xmlMapeo.isCarat();
                String status = xmlMapeo.getStatus();
                int papeles = (!isEjercicio) ? xmlMapeo.cantidadPapeles() : 0;
                papel_idc = new PapelIdc(papeles, cant_crt, img, anverso, reverso, status);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(IDCXCaratula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            System.out.println(ex.getMessage());
            // Logger.getLogger(IDCXCaratula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return papel_idc;
    }

    public PapelIdc getPapel_idc() {
        return papel_idc;
    }
}
