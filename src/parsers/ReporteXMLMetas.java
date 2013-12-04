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
 *
 * @author Administrador
 */
public class ReporteXMLMetas {

  private List<Meta> metas = new ArrayList<>();
  private List<String> nombresCampos;
  private List<String> statuses;

  public ReporteXMLMetas(NamedNodeMap metaNodes) {
    Meta meta = null;
    for (int i = 0; i < metaNodes.getLength(); i++)
      {
      Node metaNode = metaNodes.item(i);
      NodeList metaChildren = metaNode.getChildNodes();
      meta = new Meta(metaChildren);
      metas.add(meta);
      }
    setDistinctCampos();
  }

  private void setDistinctCampos() {
    this.nombresCampos = new ArrayList();
    Image image;
    Iterator<Meta> it = metas.iterator();
    while (it.hasNext())
      {
      Meta meta = it.next();
      image = meta.getImage();
      if (image != null)
        {
        for (int i = 0; i < image.getCampos().getLength(); i++)
          {
          Campo campo = (Campo) image.getCampoByIndex(i);
          String nombreCampo = campo.getName();
          if (!this.nombresCampos.contains(nombreCampo))
            {
            this.nombresCampos.add(nombreCampo);
            }
          }
        }
      }
  }

  public int getCantidadCampos() {
    int ret = 0;
    Iterator<Meta> i = metas.iterator();
    while (i.hasNext())
      {
      Meta meta = i.next();
      Image image = meta.getImage();
      if (image != null)
        {
        ret += image.getCantidadDeCampos();
        }
      }
    return ret;
  }

  public List<Campo> getCamposByName(String nombre) {
    List<Campo> campos = new ArrayList();
    Image image;
    Iterator<Meta> it = metas.iterator();
    while (it.hasNext())
      {
      Meta meta = it.next();
      image = meta.getImage();
      if (image != null)
        {
        Campo campo = image.getCampoByName(nombre);
        if (campo != null)
          {
          campos.add(campo);
          }
        }
      }
    return campos;
  }

  public int getCantidadMetaByStatus(String aString) {
    int ret = 0;
    Iterator<Meta> it = metas.iterator();
    while (it.hasNext())
      {
      Meta meta = it.next();
      if (meta != null)
        {
        boolean invalido = meta.isStatusMeta(aString);
        if (invalido)
          {
          ret++;
          }
        }
      }
    return ret;
  }

  public List<Campo> getCamposByNameAndStatus(String nombre, String status) {

    List<Campo> campos = new ArrayList();
    Image image;
    Iterator<Meta> it = metas.iterator();
    while (it.hasNext())
      {
      Meta meta = it.next();
      image = meta.getImage();
      if (image != null)
        {
        Campo campo = image.getCampoByName(nombre);
        if (campo != null && campo.getStatus().equalsIgnoreCase(status))
          {
          campos.add(campo);
          }
        }
      }
    return campos;
  }

  public int getCampoStatus(String estado) {
    int ret = 0;
    Image image;
    Iterator<Meta> it = metas.iterator();
    while (it.hasNext())
      {
      Meta meta = it.next();
      image = meta.getImage();
      if (image != null)
        {
        for (int i = 0; i < image.getCampos().getLength(); i++)
          {
          Campo campo = (Campo) image.getCampoByIndex(i);
          String nombreStatus = campo.getStatus();
          if (nombreStatus.equalsIgnoreCase(estado))
            {
            ret++;
            }
          }
        }
      }
    return ret;
  }

  public List<Meta> getMetas() {
    return metas;
  }

  public void setMetas(List<Meta> metas) {
    this.metas = metas;
  }

  public List<String> getNombresCampos() {
    return nombresCampos;
  }
}
