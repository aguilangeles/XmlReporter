/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
public class Idc {
    private String nombre;
    private int validos;
    private int invalidos;
    private CamposSedes campoSede;

    public Idc(String nombre, int validos, int invalidos, CamposSedes campoSede) {
        this.nombre = nombre;
        this.validos = validos;
        this.invalidos = invalidos;
        this.campoSede = campoSede;
    }

    public Idc() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValidos() {
        return validos;
    }

    public void setValidos(int validos) {
        this.validos = validos;
    }

    public int getInvalidos() {
        return invalidos;
    }

    public void setInvalidos(int invalidos) {
        this.invalidos = invalidos;
    }

    public CamposSedes getCampoSede() {
        return campoSede;
    }
    public void setCampoSede(CamposSedes campoSede) {
        this.campoSede = campoSede;
    }

    @Override
    public String toString() {
        return  nombre
                + ", " + validos
                + ", " + invalidos
                + ", " + campoSede
                + "\n";
    }

}
