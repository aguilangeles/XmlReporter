package parsers;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author MUTNPROD003
 */
public class Metadato {

  private NamedNodeMap campos;

  public NamedNodeMap getCampos() {
    return campos;
  }

  public Metadato(NamedNodeMap campos) {
    this.campos = campos;
    for (int i = 0; i < campos.getLength(); i++)
      {
      Campo campo = new Campo(campos.item(i));
      }
  }

  public Campo getCampoByName(String name) {
    int size = campos.getLength();
    if (size != 0)
      {
      for (int i = 0; i < campos.getLength(); i++)
        {
        Campo campo = new Campo(campos.item(i));
        if (campo.getName().equalsIgnoreCase(name))
          {
          return campo;
          }
        }
      } else
      {
      System.out.println("ESTE CAMPO ESTA VACIO");
      }
    return null;
  }

  @Override
  public String toString() {
    String ret = "";
    for (int i = 0; i < campos.getLength(); i++)
      {
      Campo campo = new Campo(campos.item(i));
      ret += (campo);
      }
    return ret;
  }
}
