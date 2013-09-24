/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import java.io.FileInputStream;
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

  private static final String DRIVER = "com.mysql.jdbc.Driver";
  private static final String PATH = "Archivos\\db.properties";
  //
  private static Connection conexion;
  public Statement declaracion;
  public ResultSet resultado;
  public PreparedStatement prepareStatement;
  private JTextArea progreso;
  private JLabel mensaje;
  private String url, user, passw, info, server;

  public Conexion(JLabel mensaje, JTextArea progreso) {
    this.mensaje = mensaje;
    this.progreso = progreso;
  }

  public Conexion() {
  }

  public boolean isConexion() throws SQLException {
    try
      {
      Properties properties = new Properties();
      properties.load(new FileInputStream(PATH));
      String urlShort = properties.getProperty("db.url");
      String database = properties.getProperty("db.database");
      url = "jdbc:mysql://" + urlShort + "/" + database;
      user = properties.getProperty("db.user");
      passw = properties.getProperty("db.passW");
      Class.forName(DRIVER);
      conexion = DriverManager.getConnection(url, user, passw);
      return true;
      } catch (ClassNotFoundException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              "Class not found ex", JOptionPane.ERROR_MESSAGE);
      return false;
      } catch (IOException ex)
      {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
      return false;
      }
  }

  public void Execute(String sql) {
    try
      {
      declaracion = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      resultado = declaracion.executeQuery(sql);
      } catch (SQLException sqle)
      {
      do
        {
        JOptionPane.showMessageDialog(null, "SQL ESTADO: " + sqle.getSQLState()
                + "CODIGO DE ERROR: " + sqle.getErrorCode() + "MENSAJE: " + sqle.getMessage());
        sqle = sqle.getNextException();
        } while (sqle != null);
      }
  }

  public void executeUpdate(String sql) {
    try
      {
      prepareStatement = conexion.prepareStatement(sql);
      int filasAfectadas = prepareStatement.executeUpdate();
      } catch (SQLException ex)
      {
      if (ex.getMessage().contains("Duplicate entry"))
        {
        String msj = ex.getMessage();

        String sep = msj.substring(17);
        progreso.setText("\nEntrada duplicada:\n" + sep + "\n");
        } else if (ex.getMessage().contains("Update Cannot add or "
              + "update a child row: a foreign key constraint fails"))
        {
        JOptionPane.showMessageDialog(null, ex.getMessage());
        progreso.setText("\n" + ex.getMessage() + "\n");
        String error = "error en resultados/executeUpdate" + ex.getMessage();
        }
      }
  }

  public boolean desconectar() {
    try
      {
      conexion.close();
      return true;
      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage());
      return false;
      }
  }
}
