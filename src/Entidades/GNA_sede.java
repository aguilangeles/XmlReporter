/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
public class GNA_sede {
    private int grado_valid;
    private int grado_invalid;
    private int grado_invalidDB;
    private int codEst_valid;
    private int codEst_invalid;
    private int codEst_invalidDB;

    public GNA_sede(int grado_valid, int grado_invalid, int grado_invalidDB, int codEst_valid, int codEst_invalid, int codEst_invalidDB) {
        this.grado_valid = grado_valid;
        this.grado_invalid = grado_invalid;
        this.grado_invalidDB = grado_invalidDB;
        this.codEst_valid = codEst_valid;
        this.codEst_invalid = codEst_invalid;
        this.codEst_invalidDB = codEst_invalidDB;
    }

    public GNA_sede() {
    }

    public int getGrado_valid() {
        return grado_valid;
    }

    public void setGrado_valid(int grado_valid) {
        this.grado_valid = grado_valid;
    }

    public int getGrado_invalid() {
        return grado_invalid;
    }

    public void setGrado_invalid(int grado_invalid) {
        this.grado_invalid = grado_invalid;
    }

    public int getGrado_invalidDB() {
        return grado_invalidDB;
    }

    public void setGrado_invalidDB(int grado_invalidDB) {
        this.grado_invalidDB = grado_invalidDB;
    }

    public int getCodEst_valid() {
        return codEst_valid;
    }

    public void setCodEst_valid(int codEst_valid) {
        this.codEst_valid = codEst_valid;
    }

    public int getCodEst_invalid() {
        return codEst_invalid;
    }

    public void setCodEst_invalid(int codEst_invalid) {
        this.codEst_invalid = codEst_invalid;
    }

    public int getCodEst_invalidDB() {
        return codEst_invalidDB;
    }

    public void setCodEst_invalidDB(int codEst_invalidDB) {
        this.codEst_invalidDB = codEst_invalidDB;
    }

    @Override
    public String toString() {
        return  grado_valid
                + ", "+ grado_invalid
                + ", "+ grado_invalidDB
                + ", "+ codEst_valid
                + ", "+ codEst_invalid
                + ", "+ codEst_invalidDB
                + "\n";
    }


}
