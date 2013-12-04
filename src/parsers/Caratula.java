package parsers;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import helper.ExceptionMessage;
import helper.XmlHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author MUTNPROD003
 */
public class Caratula {
    private String idIDC;
    private Date creationDate;
    private String status;
    private String docType;
    private String crtType;
    private int secuencial;
    private int subTypeCode;
    private String level;
    private String user;
    private Metadato metadato;
    private NamedNodeMap campos;

    public NamedNodeMap getCampos() {
        return campos;
    }

    public void setCampos(NamedNodeMap campos) {
        this.campos = campos;
    }


    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public String getIdIDC() {
        return idIDC;
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

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getCrtType() {
        return crtType;
    }

    public void setCrtType(String crtType) {
        this.crtType = crtType;
    }

    public int getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(int secuencial) {
        this.secuencial = secuencial;
    }

    public int getSubTypeCode() {
        return subTypeCode;
    }

    public void setSubTypeCode(int subTypeCode) {
        this.subTypeCode = subTypeCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Metadato getMetadato() {
        return metadato;
    }

    public void setMetadato(Metadato metadato) {
        this.metadato = metadato;
    }

    public Caratula() {
    }


    public Caratula(NodeList nodes) {
       String idIDC1 = XmlHelper.getNodeValue("idIDC", nodes);
       String creationDate1 = XmlHelper.getNodeValue("CreationDate", nodes);
       Date date = null;
       try {
           date = dateFormat.parse(creationDate1);
       } catch (ParseException ex) {
         ExceptionMessage.message(ex.getMessage(), Caratula.class.getName()+" Parse ex");
       }
       String status1 = XmlHelper.getNodeValue("Status", nodes);
       String docType1 = XmlHelper.getNodeValue("DocType", nodes);
       String crtType1 = XmlHelper.getNodeValue("CrtType", nodes);
       int secuencial1 = Integer.parseInt(XmlHelper.getNodeValue("Secuencial", nodes));
       int subTypeCode1 = Integer.parseInt(XmlHelper.getNodeValue("SubTypeCode", nodes));
       String level1 = XmlHelper.getNodeValue("Level", nodes);
       String user1 = XmlHelper.getNodeValue("User", nodes);
       Node caratulaNode = XmlHelper.getNode("Metadato", nodes);
       this.campos = XmlHelper.getNodesByName("Campo", caratulaNode.getChildNodes());
       Metadato metadato1 = new Metadato(campos);
       this.idIDC = idIDC1;
       this.creationDate = date;
       this.status = status1;
       this.docType = docType1;
       this.crtType = crtType1;
       this.secuencial = secuencial1;
       this.subTypeCode = subTypeCode1;
       this.level = level1;
       this.user = user1;
       this.metadato = metadato1;
    }

    @Override
    public String toString() {
        return "Caratula "
                + "\nidIDC= " + idIDC
                + "\ncreationDate= " + creationDate
                + "\nstatus= " + status
                + "\ndocType= " + docType
                + "\ncrtType= " + crtType
                + "\nsecuencial= " + secuencial
                + "\nsubTypeCode= " + subTypeCode
                + "\nlevel= " + level
                + "\nuser= " + user
                + "\nmetadato= " + metadato;

    }
}
