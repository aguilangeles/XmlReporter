/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Campos;

import Entidades.OSN_sede;
import clases.Campo;
import clases.Meta;
import java.util.List;
import parsers.MetaParser;
import parsers.ReporteXMLMetas;

/**
 *
 * @author MUTNPROD003
 */
public class Campos_OSN {
    private MetaParser metaParser;
    private ReporteXMLMetas reporteMeta;
    //
    private String ruta;
    private static String v = "Valid";
    private static String i = "Invalid";
    private OSN_sede osn;


    public Campos_OSN(MetaParser metaParser, ReporteXMLMetas reporteMeta) {
        this.metaParser = metaParser;
        this.reporteMeta = reporteMeta;
        setResultados();
    }
    private OSN_sede setResultados() {
        int distritoValid = 0;
        int distritoInvalid = 0;
        int partidaValid = 0;
        int partidaInvalid = 0;
        int subCuentaValid = 0;
        int subCuentaInvalid = 0;
        int digitoValid = 0;
        int digitoInvalid = 0;
        int anioValid = 0;
        int anioInvalid = 0;
        int bimestreValid = 0;
        int bimestreInvalid = 0;
        List<String> nombreCampoList = reporteMeta.getNombresCampos();
        // es una lista harcodeada, con los nombres de las sedes
        List<String> nombreList = reporteMeta.getListaCampos();
        for (int x = 0; x < nombreCampoList.size(); x++) {
            String nombreOriginal = nombreCampoList.get(x);
            for (int l = 0; l < nombreList.size(); l++) {
                String nombreHarC = nombreList.get(l);
                if (nombreOriginal.equals(nombreHarC)) {
                    if (!nombreOriginal.equalsIgnoreCase("Id Imagen")) {
                        List<Campo> campos = reporteMeta.getCamposByName(nombreOriginal);
                        distritoValid += cantidadPorEstadoYNombre(nombreOriginal, "Distrito", v);
                        distritoInvalid += cantidadPorEstadoYNombre(nombreOriginal, "Distrito", i);
                        partidaValid += cantidadPorEstadoYNombre(nombreOriginal, "partida", v);
                        partidaInvalid += cantidadPorEstadoYNombre(nombreOriginal, "partida", i);
                        subCuentaValid += cantidadPorEstadoYNombre(nombreOriginal, "subcuenta", v);
                        subCuentaInvalid += cantidadPorEstadoYNombre(nombreOriginal, "subcuenta", i);
                        digitoValid += cantidadPorEstadoYNombre(nombreOriginal, "digito", v);
                        digitoInvalid += cantidadPorEstadoYNombre(nombreOriginal, "digito", i);
                        anioValid += cantidadPorEstadoYNombre(nombreOriginal, "anio", v);
                        anioInvalid += cantidadPorEstadoYNombre(nombreOriginal, "anio", i);
                        bimestreValid += cantidadPorEstadoYNombre(nombreOriginal, "bimestre", v);
                        bimestreInvalid += cantidadPorEstadoYNombre(nombreOriginal, "bimestre", i);
                        osn = new OSN_sede(distritoValid, distritoInvalid, partidaValid,
                                partidaInvalid, subCuentaValid, subCuentaInvalid,
                                digitoValid, digitoInvalid, anioValid, anioInvalid,
                                bimestreValid, bimestreInvalid);
                    }
                }
            }
        }
        return osn;
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

    public OSN_sede getOsn() {
        return osn;
    }
}
