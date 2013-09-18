/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
public class C1 {
    private Object object;

    public C1(Object object) {
        this.object = object;
    }
    public C1() {
    }

    public Object getObject() {
        return object;
    }
    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return object.toString() ;
    }

}
