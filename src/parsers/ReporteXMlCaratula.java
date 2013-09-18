/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers;

import clases.Campo;
import clases.Caratula;
import clases.Metadato;
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
public class ReporteXMlCaratula {

    private List<String> listaValorC1;
    private List<String> listaValorC2;
    private List<String> listaValorC3;
    private List<String> listaValorC4;
    private List<Caratula> caratulaList = new ArrayList<>();
    private List<String> tipoDocList;

    public ReporteXMlCaratula() {
    }

    public ReporteXMlCaratula(NamedNodeMap caratulasNodeMap) {
        for (int i = 0; i < caratulasNodeMap.getLength(); i++) {
            Node caratulaNode = caratulasNodeMap.item(i);
            NodeList caratulaChildren = caratulaNode.getChildNodes();
            Caratula caratula = new Caratula(caratulaChildren);
            caratulaList.add(caratula);
        }

    }

    public Metadato metadatoByCampoValue(String value) {
        Metadato ret = null;
        Iterator<Caratula> it = caratulaList.iterator();
        while (it.hasNext()) {
            Caratula caratula = it.next();
            Metadato metadato = caratula.getMetadato();
            Campo campo = metadato.getCampoByValue(value);
            if (campo.getValue().equals(value)) {
                ret = metadato;
            }
        }
        return ret;
    }

    public int getCantidadSumarias() {
        int ret = 0;
        Iterator<Caratula> it = caratulaList.iterator();
        while (it.hasNext()) {
            Caratula caratula = it.next();
            if (caratula.getDocType().equalsIgnoreCase("Sumaria")) {
                ret++;
            }
        }
        return ret;
    }
    
    public boolean isEjercicios() {
        int ret = 0;
        Iterator<Caratula> it = caratulaList.iterator();
        while (it.hasNext()) {
            Caratula caratula = it.next();
            if (caratula.getDocType().equalsIgnoreCase("EJER")) {
                return true;
            }
        }
        return false;
    }

    public List<String> getEstadoDeC1(List<String> listaC1) {
        listaValorC1 = new ArrayList();
        String ret = "";
        Iterator<Caratula> it = caratulaList.iterator();
        while (it.hasNext()) {
            Caratula caratula = it.next();
            Metadato metadato = caratula.getMetadato();
            Campo campo = metadato.getCampoByName("Id");
            Iterator iteratorC1 = listaC1.iterator();
            while (iteratorC1.hasNext()) {
                String c1 = (String) iteratorC1.next();
                if (campo.getValue().equalsIgnoreCase(c1) && campo != null) {
                    ret = metadato.toString();
                    listaValorC1.add(ret);
                }
            }
        }
        return listaValorC1;

    }

    public List<String> getEstadoDeC2(List<String> listaC2) {
        listaValorC2 = new ArrayList();
        String ret = "";
        Iterator<Caratula> it = caratulaList.iterator();
        while (it.hasNext()) {
            Caratula caratula = it.next();
            Metadato metadato = caratula.getMetadato();
            Campo campo = metadato.getCampoByName("Id");
            Iterator it2 = listaC2.iterator();
            while (it2.hasNext()) {
                String c2 = (String) it2.next();
                if (campo.getValue().equalsIgnoreCase(c2) && campo != null) {
                    ret = metadato.toString();
                    listaValorC2.add(ret);
                }
            }
        }
        return listaValorC2;
    }

    public List<String> getEstadoDeC3(List<String> listaC3) {
        listaValorC3 = new ArrayList();
        String ret = "";
        Iterator<Caratula> it = caratulaList.iterator();
        while (it.hasNext()) {
            Caratula caratula = it.next();
            Metadato metadato = caratula.getMetadato();
            Campo campo = metadato.getCampoByName("Id");
            Iterator it2 = listaC3.iterator();
            while (it2.hasNext()) {
                String c3 = (String) it2.next();
                if (campo.getValue().equalsIgnoreCase(c3) && campo != null) {
                    ret = metadato.toString();
                    listaValorC3.add(ret);
                }
            }
        }
        return listaValorC3;
    }

    public List<String> getEstadoDeC4(List<String> listaC4) {
        listaValorC4 = new ArrayList();
        String ret = "";
        Iterator<Caratula> it = caratulaList.iterator();
        while (it.hasNext()) {
            Caratula caratula = it.next();
            Metadato metadato = caratula.getMetadato();
            Campo campo = metadato.getCampoByName("Id");
            Iterator it2 = listaC4.iterator();
            while (it2.hasNext()) {
                String c4 = (String) it2.next();
                if (campo.getValue().equalsIgnoreCase(c4) && campo != null) {
                    ret = metadato.toString();
                    listaValorC4.add(ret);
                }
            }
        }
        return listaValorC4;
    }

    public String getTipo() {
        String ret = "";
        Iterator<Caratula> it = caratulaList.iterator();
        while (it.hasNext()) {
            Caratula caratula = it.next();
            if (caratula.getDocType().equalsIgnoreCase("Boletas")) {
                ret = caratula.getDocType();
            }
        }
        return ret;
    }

    public int getSubTipo() {
        int ret = 0;
        Iterator<Caratula> it = caratulaList.iterator();
        while (it.hasNext()) {
            Caratula caratula = it.next();
            if (caratula.getDocType().equalsIgnoreCase("Boletas")) {
                ret = caratula.getSubTypeCode();
            }
        }
        return ret;
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
