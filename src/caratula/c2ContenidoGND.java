/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caratula;

/**
 *
 * @author MUTNPROD003
 */
public class c2ContenidoGND {
    private String gnd;

    public c2ContenidoGND(String gnd) {
        this.gnd = gnd;
    }

    public String getGnd() {
        return gnd;
    }

    public void setGnd(String gnd) {
        this.gnd = gnd;
    }

    @Override
    public String toString() {
        return  gnd ;
    }


}
