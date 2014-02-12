/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import helper.ExceptionMessage;
import testDatabase.ReadProperties;
import testDatabase.UserDataBase;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Conexion {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String PATH = "Archivos\\db.properties";
    //
    private static Connection conexion;
    public Statement declaracion;
    public ResultSet resultado;
    public PreparedStatement prepareStatement;
    private JLabel infoJLabel;
    private ReadProperties us = new ReadProperties();

    public Conexion(JLabel infoJLabel) {
        this.infoJLabel = infoJLabel;
    }

    public Conexion() {
    }

    public boolean isConexion() throws SQLException {
        try {
            UserDataBase useDb = us.getUser();
            String urlShort = useDb.getUrl();
            String database = useDb.getBase();
            String url = "jdbc:mysql://" + urlShort + "/" + database;
            String user = useDb.getUsuario();
            String passw = useDb.getPassword();
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(url, user, passw);
            return true;
        } catch (ClassNotFoundException ex) {
            ExceptionMessage.message(ex.getMessage(), Conexion.class.getName() + " ClassNotFound ex");
            return false;
        }
    }

    public void Execute(String sql) {
        try {
            declaracion = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultado = declaracion.executeQuery(sql);
        } catch (SQLException sqle) {
            do {
                JOptionPane.showMessageDialog(null, "SQL ESTADO: " + sqle.getSQLState()
                        + "CODIGO DE ERROR: " + sqle.getErrorCode() + "MENSAJE: " + sqle.getMessage());
                sqle = sqle.getNextException();
            } while (sqle != null);
        }
    }

    public boolean executeUpdate(String sql) {
        boolean exec = false;
        try {
            prepareStatement = conexion.prepareStatement(sql);
            int filasAfectadas = prepareStatement.executeUpdate();
            exec = true;

        } catch (SQLException ex) {
            ExceptionMessage.message(ex.getMessage() + "\nEntrada duplicada o falla en las restricciones de la base"
                    + "\nEl programa se cerrará ", Conexion.class.getName() + " execute update");
            desconectar();
            System.exit(0);
            exec = false;
        }
        return exec;
    }

    public boolean desconectar() {
        try {
            conexion.close();
            return true;
        } catch (SQLException ex) {
            ExceptionMessage.message(ex.getMessage(), Conexion.class.getName() + " desconectar");
            return false;
        }
    }
}
