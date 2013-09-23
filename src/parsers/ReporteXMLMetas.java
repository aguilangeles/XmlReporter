/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers;

import clases.Campo;
import clases.Image;
import clases.Meta;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



/**
 *puedo eliminar get campo by name
 * @author Administrador
 */
public class ReporteXMLMetas {
private List<Meta> metas = new ArrayList<>();
private List <String> nombresCampos;
private List <String> listaCampos;
private List<String> statuses;


    public ReporteXMLMetas() {
    }

    public ReporteXMLMetas(NamedNodeMap metaNodes)  {
        Meta meta =null;
        for (int i = 0; i < metaNodes.getLength(); i++) {
            Node metaNode = metaNodes.item(i);
            NodeList metaChildren = metaNode.getChildNodes();
            meta = new Meta(metaChildren);
            metas.add(meta);
        }
        setDistinctCampos();
        setDistinctStatuses();
        setNombresCampos();
    }

//este no tiene uso
    public List<String> getStatuses() {
        List<String > ret =null;
        String separacion ="";
        int size = statuses.size();
        switch(size){
            case 0:
                ret = new ArrayList<>();
                separacion="null";
                statuses.add(separacion);
                ret = statuses;
                break;
            case 2:
                ret = new ArrayList<>();
                separacion="null";
                statuses.add(separacion);
                ret = statuses;
                break;
            case 3 :
                ret = new ArrayList<>();
                separacion="null";
                statuses.add(separacion);
                ret = statuses;
                break;
            default:
                ret = new ArrayList<>();
                ret =statuses;
        }
        return ret;
    }


    public int getCantidadCampos()  {
        //Escritor vacio = new Escritor("IDCvacio_01.txt");
        int ret = 0;
        Iterator<Meta> i = metas.iterator();
        while(i.hasNext()){
            Meta meta = i.next();
            Image image = meta.getImage();
            if(image !=null) {
                ret += image.getCantidadDeCampos();
            }
            }
        return ret;
    }


    public List<String> getNombresCampos() {
        return nombresCampos;
    }

    private void setDistinctCampos()  {
      this.nombresCampos = new ArrayList();
        Image image;
        Iterator<Meta> it = metas.iterator();
        while (it.hasNext()) {
            Meta meta = it.next();
            image = meta.getImage();
            if (image != null) {
                for (int i = 0; i < image.getCampos().getLength(); i++) {
                    Campo campo = (Campo) image.getCampoByIndex(i);
                    String nombreCampo = campo.getName();
                    if (!this.nombresCampos.contains(nombreCampo)) {
                        this.nombresCampos.add(nombreCampo);
                    }
                }
            }else{
                //   String vacio = ",,,,,";
                String vacio = "\t\t\t\t\t";
                this.nombresCampos.add(vacio);

        }
    }
    }

    public void setNombresCampos() {
        this.listaCampos = new ArrayList<>();
        this.listaCampos.add("Id Imagen");
        this.listaCampos.add("Grado");
        this.listaCampos.add("CodEst");
        this.listaCampos.add("Distrito");
        this.listaCampos.add("Partida");
        this.listaCampos.add("SubCuenta");
        this.listaCampos.add("Digito");
        this.listaCampos.add("Anio");
        this.listaCampos.add("Bimestre");
    }

    public List<String> getListaCampos() {
        return listaCampos;
    }

       public void setStatuses() {
        this.statuses = new ArrayList<>();
        String v="Valid";
        String i="Invalid";
        String idb="InvalidDB";
        this.statuses.add(v);
        this.statuses.add(i);
        this.statuses.add(idb);
    }

    public List<Campo> getCamposByName(String nombre) {
        List <Campo> campos = new ArrayList();
        Image image;
        Iterator<Meta> it = metas.iterator();
        while (it.hasNext()) {
            Meta meta = it.next();
            image = meta.getImage();
            if (image != null) {
                Campo campo = image.getCampoByName(nombre);
                if(campo!=null)campos.add(campo);
            }
        }
        return campos;
    }


    public int getCantidadValidMeta() {
        int ret = 0;
        Iterator<Meta> it = metas.iterator();
        while (it.hasNext()) {
            Meta meta = it.next();
            if(meta!=null){
            boolean valido = meta.isMetaValid();
            if (valido) {
                ret++;
            }
            }
        }
        return ret;
    }

    public ReporteXMLMetas(List<Meta> metas) {
        this.metas = metas;
    }
    public int getCantidadInvalidMeta() {
        int ret = 0;
        Iterator<Meta> it = metas.iterator();
        while (it.hasNext()) {
            Meta meta = it.next();
            if(meta!=null){
                boolean invalido = meta.isMetaInvalid();
            if (invalido) {
                ret++;
            }
            }
        }
        return ret;
    }
    public List<Campo> getCamposByNameAndStatus(String nombre,String status){

        List <Campo> campos = new ArrayList();
        Image image;
        Iterator<Meta> it = metas.iterator();
        while (it.hasNext()) {
            Meta meta = it.next();
            image = meta.getImage();
            if (image != null) {
                Campo campo = image.getCampoByName(nombre);
                if(campo!=null&& campo.getStatus().equalsIgnoreCase(status))campos.add(campo);
            }
        }
        return campos;
    }

    public int getCampoStatus(String estado)  {
        int ret = 0;
        Image image;
        Iterator<Meta> it = metas.iterator();
        while (it.hasNext()) {
            Meta meta = it.next();
            image = meta.getImage();
            if (image != null) {
                for (int i = 0; i < image.getCampos().getLength(); i++) {
                    Campo campo = (Campo) image.getCampoByIndex(i);
                    String nombreStatus = campo.getStatus();
                    if (nombreStatus.equalsIgnoreCase(estado)) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }

    private void setDistinctStatuses()  {
        this.statuses = new ArrayList();
        String nombreStatus="";
        Image image;
        Iterator<Meta> it = metas.iterator();
        while (it.hasNext()) {
            Meta meta = it.next();
            image = meta.getImage();
            if (image != null) {
                for (int i = 0; i < image.getCampos().getLength(); i++) {
                    Campo campo = (Campo) image.getCampoByIndex(i);
                     nombreStatus = campo.getStatus();
                    if (!this.statuses.contains(nombreStatus)) {
                        this.statuses.add(nombreStatus);
                    }
                }
            }
        }
    }

    public float porcentaje(int numero, int total) {
        float ret = 0;
        float evaluar = (float) numero * 100/ (float) total;
        boolean fv = Float.isNaN(evaluar);
        ret = (fv) ? 0 : evaluar;
        return ret;
    }

    public List<Meta> getMetas() {
        return metas;
    }

    public void setMetas(List<Meta> metas) {
        this.metas = metas;
    }
}
