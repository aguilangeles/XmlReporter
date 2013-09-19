/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Caratulas;

import java.util.List;
import parsers.ReporteXMlCaratula;



/**
 *
 * @author MUTNPROD003
 */
public class C3Contenido {
    private String retC3;
    private MapeosC MapeoC1;
    private ReporteXMlCaratula reporteCaratula;
    public C3Contenido(MapeosC MapeoC1, ReporteXMlCaratula reporteCaratula) {
        this.MapeoC1 = MapeoC1;
        this.reporteCaratula = reporteCaratula;
        getC3();
    }
    private String getC3() {
        List<String> lista = MapeoC1.getListaValorC3();

        List<String> caratulasC3 = reporteCaratula.getEstadoDeC3(lista);;
        for (int i = 0; i < caratulasC3.size(); i++) {
            retC3 = caratulasC3.get(i);
        }
        return retC3;
    }
    public String getRetC3() {
        return retC3;
    }

}
