/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Caratulas;



import clases.XmlMapeo;
import java.io.IOException;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parsers.MapeoList;
import parsers.ReporteXMLMapeo;
import parsers.XmlMapeoParser;

/**
 *
 * @author Administrador
 */
public class MapeosC {

    private List<String> listaValorC1;
    private List<String> listaValorC2;
    private List<String> listaValorC3;
    private List<String> listaValorC4;

    private String rutaProcesada;
    private int papeles;
    public MapeosC(String ruta) {
        this.rutaProcesada = ruta;
        setValorC1();
    }
        private void setValorC1() {

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
                //lista de  contenido de c1 y
                listaValorC1 = reporteMapeo.getMapeoGetC1List();
                listaValorC2 = reporteMapeo.getMapeoGetC2List();
                listaValorC3 = reporteMapeo.getMapeoGetC3List();
                listaValorC4 = reporteMapeo.getMapeoGetC4List();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(IDCXCaratula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            System.out.println(ex.getMessage());
           // Logger.getLogger(IDCXCaratula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> getListaValorC1() {
        return listaValorC1;
    }

    public List<String> getListaValorC2() {
        return listaValorC2;
    }

    public List<String> getListaValorC3() {
        return listaValorC3;
    }

    public List<String> getListaValorC4() {
        return listaValorC4;
    }

}
