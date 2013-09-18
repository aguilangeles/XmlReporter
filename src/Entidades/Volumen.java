/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author MUTNPROD003
 */
public class Volumen {
    private int id;
    private int idSede;
    private String vol_nombre;
    private String sede;
    private int cantidad_idc;
    private String fecha_reporte;
    private Idc idc;
    private CaratulasSedes crt_sedes;
    private PapelIdc papeles;

    public Volumen(int id, String vol_nombre, String sede,
            int cantidad_idc,
            Idc idc, PapelIdc papeles, CaratulasSedes crt_sedes) {
        this.id = id;
        this.vol_nombre = vol_nombre;
        this.sede = sede;
        this.cantidad_idc = cantidad_idc;

        this.idc = idc;
        this.papeles = papeles;
        this.crt_sedes = crt_sedes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVol_nombre() {
        return vol_nombre;
    }

    public void setVol_nombre(String vol_nombre) {
        this.vol_nombre = vol_nombre;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getCantidad_idc() {
        int ret =0;
        ret+=cantidad_idc;
        return ret;
    }

    public void setCantidad_idc(int cantidad_idc) {
        this.cantidad_idc = cantidad_idc;
    }

    public int getIdSede() {
        switch (this.sede) {
            case "GND":
                idSede = 1;
                break;
            case "OSN":
                idSede = 2;
                break;
        }
        return idSede;
    }

    public String getFecha_reporte() {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy'-'MM'-'dd", Locale.ENGLISH);
        Date fecha = new java.util.Date();
        return formateador.format(fecha);
    }

    public void setFecha_reporte(String fecha_reporte) {
        this.fecha_reporte = fecha_reporte;
    }

    public Idc getIdc() {
        return idc;
    }

    public PapelIdc getPapeles() {
        return papeles;
    }


    public void setIdc(Idc idc) {
        this.idc = idc;
    }

    public CaratulasSedes getCrt_sedes() {
        return crt_sedes;
    }

    public void setCrt_sedes(CaratulasSedes crt_sedes) {
        this.crt_sedes = crt_sedes;
    }


    @Override
    public String toString() {

        return "Volumen{" + "id=" + id
                + ", vol_nombre=" + vol_nombre
                + ", sede=" + sede
                + ", cantidad_idc=" + cantidad_idc
                + ", fecha_reporte=" + fecha_reporte
                + "\n idc=" + idc
                + "\n papelidc=" + papeles
                + "\n crt_sedes=" + crt_sedes
                + '}';
    }





}
