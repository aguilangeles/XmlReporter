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
public class C4Contenido {

    private String retC4;
    private MapeosC MapeoC1;
    private ReporteXMlCaratula reporteCaratula;

    public C4Contenido(MapeosC MapeoC1, ReporteXMlCaratula reporteCaratula) {
        this.MapeoC1 = MapeoC1;
        this.reporteCaratula = reporteCaratula;
        getC4();

    }

    private String getC4() {
        List<String> lista = MapeoC1.getListaValorC4();
        reporteCaratula.getEstadoDeC4(lista);
        List<String> caratulasC4 = reporteCaratula.getListaValorC4();
        for (int i = 0; i < caratulasC4.size(); i++) {
            retC4 = caratulasC4.get(i);
        }
        return retC4;
    }

    public String getRetC4() {
        return retC4;
    }
}
