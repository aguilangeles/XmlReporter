/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlocrstats;

import campo.GetPapelesYCamporForSede;
import caratula.InformaciondelVolumen;
import entidad.Total;
import entidad.Volumen;
import tablas.Conexion;
import tablas.GetLastID;
import tablas.StringInsert;
import tablas.InsertarTotales;
import tablas.InsertarVolumen;
import entidad.GetCarateristicasDelVolumen;
import helper.GetDirectorios;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.SortedMap;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import helper.Alerta;
import helper.ExceptionMessage;
import helper.InformationDone;
import tablas.InsertCaratulasYMetadatos;

/**
 *
 * @author MUTNPROD003
 */
public class MyWorker extends SwingWorker<Void, Integer> {

    private JLabel infoJLabel;
    private Conexion conexion;
    private JTextField jtRuta;
    private GetDirectorios directorio;
    int papelTotal = 0, validos = 0, invalidos = 0, imagenes = 0, anversos = 0,
            reversos = 0, campos = 0, cvalidos = 0, cinvalidos = 0, cinvalidDb = 0;
    private SortedMap getNombre;
    private SortedMap getRuta;
    private GetCarateristicasDelVolumen gsede;
    private Volumen volumen;
    private Alerta alerta = new Alerta();
    private int cantidadIdcs;

    public MyWorker(JLabel infoJLabel, JTextField jtRuta, GetDirectorios directorios) {
        this.directorio = directorios;
        this.infoJLabel = infoJLabel;
        this.jtRuta = jtRuta;
        this.getNombre = directorio.getIdcMaps();
        this.getRuta = directorio.getPathsMaps();
        this.gsede = directorio.getIdentificarSede();
        this.cantidadIdcs = directorios.getQuatyIDC();
        conexion = new Conexion(infoJLabel);
    }

    @Override
    protected Void doInBackground() {
        System.out.println("hola worker ");
        StringInsert stringInsert;
        int contador = 0;
        try {
            if (conexion.isConexion()) {
                System.out.println("entro en conexion");
                GetLastID lastId = new GetLastID(conexion);

                int idVolumen = lastId.getLastIdFromTable("volumen");
                int idIdc = lastId.getLastIdFromTable("idc");
                System.out.println(idIdc);

                Iterator it = getNombre.keySet().iterator();
                while (it.hasNext()) {
                    contador++;
                    Object key = it.next();
                    String rutaProcesada = (String) getRuta.get(key);
                    String idcName = (String) getNombre.get(key);
                    volumen = new InformaciondelVolumen(rutaProcesada,
                            idcName, contador,
                            cantidadIdcs).getVolumen();

                    stringInsert = new StringInsert(volumen, idVolumen, idIdc, contador);
                    getTotalesDelVolumen();
                    infoJLabel.setText("\n\t" + "Analizando el idc: \n" + idcName);
                    insertarEnIdc(stringInsert);
                    insertarEnCaratulas(stringInsert);
                    insertarCaratulasYMetadatos(stringInsert);
                    insertarCampos(stringInsert);
                }

                new InsertarVolumen().getVolumen(volumen);

                Total totales = new Total(papelTotal, validos, invalidos, imagenes,
                        anversos, reversos, campos, cvalidos, cinvalidos, cinvalidDb);

                InsertarTotales insertarTotales = new InsertarTotales(idVolumen, idIdc, totales);
            }//fin conexion
        } catch (SQLException ex) {
            ExceptionMessage.message(ex.getMessage(), MyWorker.class.getName() + " UnsupportedEncoding");
        }
        conexion.desconectar();
        return null;
    }

    @Override
    protected void done() {
        if (!isCancelled()) {
            InformationDone informationDone = new InformationDone(infoJLabel, jtRuta);
        }
    }

    private void getTotalesDelVolumen() {
        papelTotal += volumen.getPapeles().getPapeles();
        validos += volumen.getIdc().getValidos();
        invalidos += volumen.getIdc().getInvalidos();
        imagenes += volumen.getPapeles().getImagenes();
        anversos += volumen.getPapeles().getAnversos();
        reversos += volumen.getPapeles().getReversos();
        campos += GetPapelesYCamporForSede.getSize();
        cvalidos += GetPapelesYCamporForSede.getValid();
        cinvalidos += GetPapelesYCamporForSede.getInvalid();
        cinvalidDb += GetPapelesYCamporForSede.getInvalidDB();
    }

    private void insertarCaratulasYMetadatos(StringInsert insertResultados) {
        InsertCaratulasYMetadatos insertCaratulasYMetadatos
                = new InsertCaratulasYMetadatos(conexion, insertResultados);
    }

    private void insertarEnIdc(StringInsert stringInsert) {
        
        boolean setidc = conexion.executeUpdate(stringInsert.getIDC());
        Alerta.alerta("Idc ", setidc);
    }

    private void insertarEnCaratulas(StringInsert stringInsert) {
        boolean carat = conexion.executeUpdate(stringInsert.getCaratulas());
        Alerta.alerta("Caratulas ", carat);
    }

    private void insertarCampos(StringInsert stringInsert) {
        boolean camposs = conexion.executeUpdate(stringInsert.getCampos());
        Alerta.alerta("Campos ", camposs);
    }
}
