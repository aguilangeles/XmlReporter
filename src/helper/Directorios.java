/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.File;
import java.io.FileFilter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author MUTNPROD003
 */
public class Directorios {

    private Map<Integer, String> mapa;
    private SortedMap mapaS;
    private SortedMap nombresS;
    private String ruta;
    private JTextField insertRuta;
    private File folder;
    private FileFilter fileFilter;
    private String nombreSede;
    private String nombreVolumen;
    private String sedes;
    private int contador=0;
    private JTextArea mensaje;
    private int entrada;
private SwingWorker integrador;
    public Directorios(String ruta, File folder, FileFilter fileFilter) throws UnsupportedEncodingException {
        this.ruta = ruta;
        this.folder=folder;
        this.fileFilter = fileFilter;
        directorio();
    }

    public Directorios(String ruta, JTextField insertRuta) throws UnsupportedEncodingException {
        this.ruta = ruta;
        this.insertRuta=insertRuta;
        directorio();
    }

    public Directorios(String ruta, JTextArea mensaje) throws UnsupportedEncodingException {
        this.ruta = ruta;
        this.mensaje=mensaje;
        directorio();
    }
    public Directorios(String ruta) throws UnsupportedEncodingException {
        this.ruta = ruta;
        directorio();
    }
    private SortedMap directorio() throws UnsupportedEncodingException {
        mapaS = new TreeMap();
        nombresS = new TreeMap();
        int id = 0;
        folder = new File(ruta);
        FileFilter filefilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };
        if (folder.exists()) {
            entrada=0;
            File[] listOfFiles = folder.listFiles(filefilter);
            for (File f : listOfFiles) {
                contador++;
                nombreSede = f.getName();
                String procesar = ruta + "/" + URLEncoder.encode(f.getName(), "UTF-8") + "/" + "Carat.xml";
                String[] spl = f.getName().split("#");
                sedes = spl[0];
                nombreVolumen = spl[1];
                String finCadena = spl[3];
                switch (sedes) {
                    case "OSN":
                        id = Integer.parseInt(finCadena);
                        break;
                    case "GND":
                        String sinSl = finCadena.substring(2);
                        id = Integer.parseInt(sinSl);
                        break;
                }
                mapaS.put(id, procesar);
                nombresS.put(id, nombreSede);
            }

        } else {
            JOptionPane.showMessageDialog(null, "La ruta ingresada es incorrecta.\n"
                    );
            entrada =1;
        }
        return (SortedMap) mapa;

    }

    public SortedMap getNombreSorted() {
        return nombresS;
    }

    public void setNombreSorted(SortedMap nombreSorted) {
        this.nombresS = nombreSorted;
    }

    public String getNombreVolumen() {
        return nombreVolumen;
    }

    public String getSedes() {
        return sedes;
    }

    public SortedMap getMapaS() {
        return mapaS;
    }

    public int getEntrada() {
        return entrada;
    }



    public int getContador() {
        return contador;
    }


}
