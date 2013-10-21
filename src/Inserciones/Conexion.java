/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import ArchivoConfig.ReadProperties;
import ArchivoConfig.UserDataBase;
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
    try
      {
      UserDataBase useDb = us.getUser();
      String urlShort = useDb.getUrl();
      String database = useDb.getBase();
      String url = "jdbc:mysql://" + urlShort + "/" + database;
      String user = useDb.getUsuario();
      String passw = useDb.getPassword();
      Class.forName(DRIVER);
      conexion = DriverManager.getConnection(url, user, passw);
      return true;
      } catch (ClassNotFoundException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              "Class not found ex", JOptionPane.ERROR_MESSAGE);
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
          System.out.println(ex.getMessage());
        String msj = ex.getMessage();
        String sep = msj.substring(17);
        infoJLabel.setText("\nEntrada duplicada:\n" + sep + "\n");
        } else if (ex.getMessage().contains("Update Cannot add or "
              + "update a child row: a foreign key constraint fails"))
        {
        JOptionPane.showMessageDialog(null, ex.getMessage());
        infoJLabel.setText("\n" + ex.getMessage() + "\n");
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
