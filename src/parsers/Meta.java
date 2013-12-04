package parsers;

import helper.ExceptionMessage;
import parsers.Image;
import helper.XmlHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * Date: 10/14/12 Time: 8:58 PM
 */
public class Meta {

  private String idIDC;
  private Date creationDate;
  private String status;
  private NamedNodeMap campos;
  private Image image;
  List<String> vacios;
  private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

  public String getIdIDC() {
    return idIDC;
  }

  public NamedNodeMap getCampos() {
    return campos;
  }

  public void setCampos(NamedNodeMap campos) {
    this.campos = campos;
  }

  public void setIdIDC(String idIDC) {
    this.idIDC = idIDC;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  public Meta() {
  }

  public boolean isStatusMeta(String aString) {
    return this.status.equalsIgnoreCase(aString);
  }

  public Meta(String idIDC, Date creationDate, String status, Image image) {
    this.idIDC = idIDC;
    this.creationDate = creationDate;
    this.status = status;
    this.image = image;
  }

  public Meta(NodeList nodes) {
    //
    vacios = new ArrayList<>();
    String idIDC = XmlHelper.getNodeValue("IdIDC", nodes);
    String creationDate = XmlHelper.getNodeValue("CreationDate", nodes);
    Date date = null;
    try
      {
      date = dateFormat.parse(creationDate);
      } catch (ParseException e)
      {
      ExceptionMessage.message(e.getMessage(), Meta.class.getName());
      }
    String status1 = XmlHelper.getNodeValue("Status", nodes);
    Node imageNode = XmlHelper.getNode("Image", nodes);
    Image image1 = null;
    if (imageNode != null)
      {
      this.campos = XmlHelper.getNodesByName("Campo", imageNode.getChildNodes());
      image1 = new Image(campos);
      } else
      {
      image1 = null;
      }

    this.idIDC = idIDC;
    this.creationDate = date;
    this.status = status1;
    this.image = image1;
  }

  @Override
  public String toString() {
    return "idIDC=" + idIDC
            + "\n creationDate=" + creationDate
            + "\n status=" + status
            + "\n image=" + image;
  }
}
