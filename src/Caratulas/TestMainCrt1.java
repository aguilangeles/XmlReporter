///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package Caratulas;
//
////import Campos.PapelesyCampos;
//import Entidades.Total;
//import Entidades.Volumen;
//import Inserciones.InsertarStrings;
//import Inserciones.Conexion;
//import helper.Directorios;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.Iterator;
//import java.util.SortedMap;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author MUTNPROD003
// */
//public class TestMainCrt1 {
//    private static Volumen vol;
//    private static Conexion conexion;
//    static int papelTotal;
//    static int validos;
//    static int invalidos;
//    static int imagenes;
//    static int anversos;
//    static int reversos;
//    static int campos;
//    static int cvalidos;
//    static int cinvalidos;
//    static int cinvalidDb;
//    private static Total t;
//    /**
//     * @param args the command line arguments
//     * @throws IOException
//     * @throws SQLException
//     */
//    public static void main(String[] args) throws IOException, SQLException {
//
//        conexion = new Conexion(null, null);
//        conexion.conectar();
//        int contador = 0;
//        int idVolumen = conexion.volumen();
//        int idIdc = conexion.idc();
//        InsertarStrings insert = null;
//        // String ruta = "C:\\Angeles\\201111L06V02";
//        // String ruta = "C:\\Angeles\\TestInsert";
//        //String ruta = "C:\\Angeles\\volreducido";
//        String ruta = "C:\\Angeles\\V201106V24001";
//        // InsertarStrings v = new InsertarStrings(conexion);
//        Directorios directorio = new Directorios(ruta);
//        SortedMap getNombre = directorio.getNombreSorted();
//        SortedMap getRuta = directorio.getMapaS();
//        Iterator it = getNombre.keySet().iterator();
//        String nombreVolumen = directorio.getNombreVolumen();
//        String siglaSede = directorio.getSedes();
//        int cantidadIDC = directorio.getContador();
//        while (it.hasNext()) {
//            contador++;
//            Object key = it.next();
//            String rutaProcesada = (String) getRuta.get(key);
//            String idcs = (String) getNombre.get(key);
//            Resultados resultados = new Resultados(rutaProcesada, idcs, contador, nombreVolumen, siglaSede, cantidadIDC);
//            Volumen v = resultados.getVolumen();
//            insert = new InsertarStrings(v, idVolumen, v.getIdSede(), idIdc, contador);
//            papelTotal += resultados.getPapelTotal();
//            validos += resultados.getValidos();
//            invalidos += resultados.getInvalidos();
//            imagenes += resultados.getImagenes();
//            anversos += resultados.getAnversos();
//            reversos += resultados.getReversos();
//            campos += resultados.getCampos();
//            cvalidos += resultados.getCvalidos();
//            cinvalidos += resultados.getCinvalidos();
//            cinvalidDb += resultados.getCinvalidDb();
//            t = new Total(papelTotal, validos, invalidos, imagenes,
//                    anversos, reversos, campos, cvalidos, cinvalidos, cinvalidDb);
//            conexion.executeUpdate(insert.idc());
//            conexion.executeUpdate(insert.caratulas());
//            if (v.getIdSede() == 1) {
//                conexion.executeUpdate(insert.gnd_crt());
//                conexion.executeUpdate(insert.gnd_metadatos());
//            } else if (v.getIdSede() == 2) {
//                conexion.executeUpdate(insert.osn_crt());
//                conexion.executeUpdate(insert.osn_metadatos());
//            }
//            conexion.executeUpdate(insert.campos());
//        }
//        conexion.executeUpdate(insert.volumen());
//        conexion.executeUpdate(insert.totales(t));
//        conexion.desconectar();
//    }
//}
//
