/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Campos;

import Entidades.GND_sede;
import clases.Campo;
import clases.Meta;
import java.util.List;
import parsers.MetaParser;
import parsers.ReporteXMLMetas;

/**
 *
 * @author MUTNPROD003
 */
public class Campos_GND {
/*NO ESTA ENTRANDO A ESTE LUGAR*/
    private static String v = "Valid";
    private static String i = "Invalid";
    private static String idb = "InvalidDB";
    private ReporteXMLMetas reporteMeta;
    private final MetaParser metaParser;
    private final Meta meta;
    private GND_sede gnd;

    public Campos_GND(MetaParser metaParser, ReporteXMLMetas reporte, Meta meta){
        this.metaParser = metaParser;
        this.reporteMeta= reporte;
        this.meta=meta;
        setResultados();
    }

    private GND_sede setResultados() {
        int gradoValid = 0;
        int gradoInvalid = 0;
        int gradoInvalidDB = 0;
        int codEstValid = 0;
        int codEstInvalid = 0;
        int codEstInvalidDB = 0;
        int digitoValid = 0;
        int digitoInvalid = 0;
        int anioValid = 0;
        int anioInvalid = 0;
        int bimestreValid = 0;
        int bimestreInvalid = 0;
        List<String> nombreCampoList = reporteMeta.getNombresCampos();
        List<String> nombreList = reporteMeta.getListaCampos();
        for (int x = 0; x < nombreCampoList.size(); x++) {
            String nombreOriginal = nombreCampoList.get(x);
            for (int l = 0; l < nombreList.size(); l++) {

                String nombreHarC = nombreList.get(l);
                if (nombreOriginal.equals(nombreHarC)) {
                  System.out.println(nombreOriginal.equals(nombreHarC));
                    if (!nombreOriginal.equalsIgnoreCase("Id Imagen")) {
                      System.out.println(!nombreOriginal.equalsIgnoreCase("Id Imagen"));
                        List<Campo> campos = reporteMeta.getCamposByName(nombreOriginal);
                        gradoValid += cantidadPorEstadoYNombre(nombreOriginal, "Grado", v);
                        gradoInvalid += cantidadPorEstadoYNombre(nombreOriginal, "Grado", i);
                        gradoInvalidDB += cantidadPorEstadoYNombre(nombreOriginal, "Grado", idb);
                        codEstValid += cantidadPorEstadoYNombre(nombreOriginal, "CodEst", i);
                        codEstInvalid += cantidadPorEstadoYNombre(nombreOriginal, "CodEst", v);
                        codEstInvalidDB += cantidadPorEstadoYNombre(nombreOriginal, "CodEst", idb);
                    }
                }
            }
            gnd = new GND_sede(gradoValid, gradoInvalid, gradoInvalidDB,
                    codEstValid, codEstInvalid, codEstInvalidDB);
        }
        return gnd;
    }

    private int cantidadPorEstadoYNombre(String nombreOriginal, String nombre, String valor) {
        int ret = 0;
        if (nombreOriginal.equalsIgnoreCase(nombre)) {
            List<String> getStatuses = reporteMeta.getStatuses();
            for (int y = 0; y < reporteMeta.getStatuses().size(); y++) {
                String getStatus = reporteMeta.getStatuses().get(y);
                if (getStatus.equalsIgnoreCase(valor)) {
                    List<Campo> camposPorEstado = reporteMeta.getCamposByNameAndStatus(nombreOriginal, getStatus);
                    if (!getStatus.equalsIgnoreCase("")) {
                        ret = camposPorEstado.size();
                    }
                }
            }
        }
        return ret;
    }
    public GND_sede getGnd() {
        return gnd;
    }
}


