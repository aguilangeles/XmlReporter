/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author MUTNPROD003
 */
public class Conexion {
    private JTextArea progreso;
    public Statement declaracion;
    public ResultSet resultado;
    public PreparedStatement prepareStatement;
    private static Connection conexion;
    private FileInputStream fileInputStream = null;
    private JLabel mensaje;
    private String  url, user, passw, info, server;
    private String driver;

    public Conexion(JLabel mensaje, JTextArea progreso) {
        this.mensaje = mensaje;
        this.progreso=progreso;
    }
    public boolean conectar() throws SQLException, FileNotFoundException {
       Properties properties = new Properties();
        fileInputStream = new FileInputStream("Archivos\\db.properties");
        try {
            properties.load(fileInputStream);
            driver = properties.getProperty("db.driver");
            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            passw = properties.getProperty("db.passW");
            Class.forName(driver);
            try {
                conexion = DriverManager.getConnection(url, user, passw);
                String data = ("Conectado a: " + getInfo() + "\n");
                mensaje.setText(data);
                return true;
            } catch (SQLException e) {
                    String mensaje ="Unknown database";
                    if(e.getMessage().contains(mensaje)){
                    JOptionPane.showMessageDialog(null,e.getMessage()+"\n(La base de datos no existe).\nVerifique la escritura en\n"
                            + "\n 'Archivos\\db.properties'\n");

                    }else if (e.getMessage().contains("Communications link failure")){
                    JOptionPane.showMessageDialog(null,"\nError en la escritura de la URL en\n"
                            + "'Archivos\\db.properties'\n");

                    }else if(e.getMessage().contains("Access denied for user")){
                    JOptionPane.showMessageDialog(null, "El nombre de usuario/password es incorrecto en"
                            + "\n'Archivos\\db.properties'\n");

                    }else{
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ClassNotFoundEx : conectar nueva db" + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, " io ex : conectar nueva db" + ex.getMessage());

        }
        System.exit(0);
        desconectar();
        return false;
    }

    public void Execute(String sql) {
        try {
            declaracion = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultado = declaracion.executeQuery(sql);
        } catch (SQLException sqle) {
            do {
                JOptionPane.showMessageDialog(null, "SQL ESTADO: " + sqle.getSQLState() + "CODIGO DE ERROR: " + sqle.getErrorCode() + "MENSAJE: " + sqle.getMessage());
                sqle = sqle.getNextException();
            } while (sqle != null);
        }
    }
    public int volumen() {
        int ret = 0;
        try {
            declaracion = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultado = declaracion.executeQuery("select max(id) from volumen");
            while (resultado.next()) {
                ret = resultado.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    public int idc() {
        int ret = 0;
        try {
            declaracion = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultado = declaracion.executeQuery("select max(id) from idc");
            while (resultado.next()) {
                ret = resultado.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    public void executeUpdate(String sql) {
        try {
            prepareStatement = conexion.prepareStatement(sql);
          int   filasAfectadas = prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            if(ex.getMessage().contains("Duplicate entry")){
                String msj = ex.getMessage();

                String sep =msj.substring(17);
                progreso.setText("\nEntrada duplicada:\n"+sep+"\n");
            } else if (ex.getMessage().contains("Update Cannot add or update a child row: a foreign key constraint fails")) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                progreso.setText("\n" + ex.getMessage() + "\n");
                String error = "error en resultados/executeUpdate" + ex.getMessage();
                System.out.println(error);

            }
        }
    }

    public boolean desconectar() {
        try {
            conexion.close();
            String data = "Desconectado de: " + getInfo();
            mensaje.setText(data);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    public String getInfo() {
        String ret = "";
        String nombre = url;
        String[] split = nombre.split(":");
        for (int i = 0; i < split.length; i++) {
            ret = split[i];
        }
        info = ret.substring(2).replace("/", ",  ");
        return info;
    }
}






