/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package campo;

/**
 *
 * @author MUTNPROD003
 */
public class CamposPorSedes {

    private String nombreSede;
    private int size;
    private int campos_valid;
    private int campos_invalid;
    private int campos_invalidDB;
    private Object object;


    public CamposPorSedes(String nombreSede, Object object,int size,int campos_valid,
            int campos_invalid, int campos_invalidDB) {
        this.nombreSede=nombreSede;
        this.size=size;
        this.campos_valid = campos_valid;
        this.campos_invalid = campos_invalid;
        this.campos_invalidDB = campos_invalidDB;
        this.object=object;
    }


    public int getCampos_valid() {
        return campos_valid;
    }

    public void setCampos_valid(int campos_valid) {
        this.campos_valid = campos_valid;
    }

    public int getCampos_invalid() {
        return campos_invalid;
    }

    public void setCampos_invalid(int campos_invalid) {
        this.campos_invalid = campos_invalid;
    }

    public int getCampos_invalidDB() {
        return campos_invalidDB;
    }

    public void setCampos_invalidDB(int campos_invalidDB) {
        this.campos_invalidDB = campos_invalidDB;
    }

    public Object getObject() {
        return object;
    }

    public int getSize() {
        return size;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "CamposSedes{" + "nombreSede=" + nombreSede + ", size=" + size + ", campos_valid=" + campos_valid + ", campos_invalid=" + campos_invalid
                + ", campos_invalidDB=" + campos_invalidDB + ", object=" + object + '}';
    }








}
