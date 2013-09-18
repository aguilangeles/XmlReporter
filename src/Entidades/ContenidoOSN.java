/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
public class ContenidoOSN {
    private int sumaria;
    public ContenidoOSN() {
    }

    public ContenidoOSN(int sumaria) {
        this.sumaria = sumaria;
    }

    public int getSumaria() {
        return sumaria;
    }

    public void setSumaria(int sumaria) {
        this.sumaria = sumaria;
    }

    @Override
    public String toString() {
        return  sumaria+"";
    }



}
