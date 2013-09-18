/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author Administrador
 */
public class ReporteXMLMapeo {

    private List<String> mapeoGetC1List ;
    private List<String> mapeoGetC2List ;
    private List<String> mapeoGetC3List ;
    private List<String> mapeoGetC4List ;
    private List<String> imagenC1 ;
    private List<String> imagenC2 ;
    private List<String> imagenC3 ;
    private List<String> imagenC4 ;

    private List<MapeoList> listaMapeoLists= new ArrayList<>();
    private List<String> nombresFaces ;

    public ReporteXMLMapeo(NamedNodeMap mapeoLists) {
        for (int i = 0; i < mapeoLists.getLength(); i++) {
            Node mapeoListNode = mapeoLists.item(i);
            NodeList mapeoChildren = mapeoListNode.getChildNodes();
            MapeoList mapeoList = new MapeoList(mapeoChildren);
            listaMapeoLists.add(mapeoList);
        }
        setDistinctFace();
        setValoresC();
    }

    private void setValoresC() {
        mapeoGetC1List = new ArrayList<>();
        mapeoGetC2List = new ArrayList<>();
        mapeoGetC3List = new ArrayList<>();
        mapeoGetC4List = new ArrayList<>();
        Iterator<MapeoList> it = listaMapeoLists.iterator();
        while (it.hasNext()) {
            MapeoList mapeoList = it.next();
            boolean isCaratula = mapeoList.getCarat();
            if (isCaratula) {
                String c1 = mapeoList.getC1();
                String c2 = mapeoList.getC2();
                String c3 = mapeoList.getC3();
                String c4 = mapeoList.getC4();
                if (!c1.equals("")) {
                    if(!mapeoGetC1List.contains(c1)){
                    mapeoGetC1List.add(c1);
                    }
                    //no esta entrando en la condicion
                } if (!c2.equals("")) {
                    if(!mapeoGetC2List.contains(c2)){
                    mapeoGetC2List.add(c2);
                    }
                } else if (!c3.equals("")) {
                    mapeoGetC3List.add(c3);
                } else if (!c4.equals("")) {
                    mapeoGetC4List.add(c4);
                }
            }
        }
    }

//    public int isCaratula() {
//        int ret = 0;
//        Iterator<MapeoList> it = listaMapeoLists.iterator();
//        while (it.hasNext()) {
//            MapeoList mapeoList = it.next();
//            boolean isCaratula = mapeoList.getCarat();
//            if (isCaratula) {
//                ret++;
//            }
//        }
//        return ret;
//    }
       public int getCantidadPorFace(String face) {
        int ret = 0;
        Iterator<MapeoList> it = this.listaMapeoLists.iterator();
        while (it.hasNext()) {
            MapeoList mapeoList = it.next();
            ret += mapeoList.getCantidadPorFace(face);
        }
        return ret;
    }

    private void setDistinctFace() {
        this.nombresFaces = new ArrayList<>();
        Iterator<MapeoList> it = this.listaMapeoLists.iterator();
        while (it.hasNext()) {
            MapeoList mapeoList = it.next();
            String nombreFace = mapeoList.getFace();
            if (!this.nombresFaces.contains(nombreFace)) {
                this.nombresFaces.add(nombreFace);
            }
        }
    }
    public List<String> getMapeoGetC1List() {
        return mapeoGetC1List;
    }

    public List<String> getMapeoGetC2List() {
        return mapeoGetC2List;
    }

    public List<String> getMapeoGetC3List() {
        return mapeoGetC3List;
    }

    public List<String> getMapeoGetC4List() {
        return mapeoGetC4List;
    }
}
