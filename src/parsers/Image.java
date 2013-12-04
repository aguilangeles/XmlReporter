package parsers;

import parsers.Campo;
import org.w3c.dom.NamedNodeMap;

/**
 *
 */
public class Image {
  private NamedNodeMap campos;

  public NamedNodeMap getCampos() {
    return campos;
  }

  public void setCampos(NamedNodeMap campos) {
    this.campos = campos;
  }

  public Image() {
  }

  public Image(NamedNodeMap campos) {
    this.campos = campos;
     for(int i = 0; i<campos.getLength();i++){
      Campo campo = new Campo(campos.item(i));
      }
  }

       public Campo getCampoByName(String name){
        for(int i=0;i<campos.getLength();i++){
      Campo campo = new Campo(campos.item(i));
            if(campo.getName().equalsIgnoreCase(name)){return campo;}
        }
    return null;
  }

    public Campo getCampoByValue(String value){
        for(int i=0;i<campos.getLength();i++){
      Campo campo = new Campo(campos.item(i));
            if(campo.getValue().equalsIgnoreCase(value)){return campo;}
        }
    return null;
  }
  public int getCantidadDeCampos() {
        int ret =0;
        ret = campos.getLength()-1;
    return ret;
  }

  public Campo getCampoByIndex(Integer index) {
    Campo ret = new Campo(campos.item(index));
    return ret;
  }
  public Campo getCampoByNameandStatus(String name, String status) {
    for (int i = 0; i < campos.getLength(); i++)
      {
      Campo campo = new Campo(campos.item(i));
      if ((campo.getName().equalsIgnoreCase(name)) && (campo.getStatus().equalsIgnoreCase(status)))
        {
        return campo;
        }
      }
    return null;
  }

  public int getCantidadCamposByNameandStatus(String name, String status) {
    int cantidad = 1;
    for (int i = 0; i < campos.getLength(); i++)
      {
      Campo campo = new Campo(campos.item(i));
      if ((campo.getName().equalsIgnoreCase(name))
              && (campo.getStatus().equalsIgnoreCase(status)))
        {
        }
      }
    return cantidad;
  }
  @Override
  public String toString() {
    String ret = "";
        for(int i = 0;i<campos.getLength();i++){
      Campo campo = new Campo(campos.item(i));
            ret += ("\n"+campo);
      }
    return ret;
  }
}
