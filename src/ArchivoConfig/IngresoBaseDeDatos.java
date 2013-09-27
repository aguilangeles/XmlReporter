/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ArchivoConfig;

import helper.VersionEImageIcon;

/**
 *
 * @author MUTNPROD003
 */
public class IngresoBaseDeDatos extends javax.swing.JFrame {

//  private Conexion validar = new Conexion();
  /**
   * Creates new form IngresoBaseDeDatos
   *

   */
  public IngresoBaseDeDatos() {
    initComponents();
    jLabel5.setText("<html>Para editar el la configuración visite: Archivos\\db.properties</html>");
    VersionEImageIcon versionEImageIcon = new VersionEImageIcon();
    principal.setBackground(versionEImageIcon.newColor());
    setResizable(false);
    usuarioNoEditable();

  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    principal = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    usuario = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    password = new javax.swing.JTextField();
    salir = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    database = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    url = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Conexion");

    jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("USUARIO");

    usuario.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N

    jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("PASSWORD");

    password.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N

    salir.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    salir.setMnemonic('t');
    salir.setText("Cerrar");
    salir.setToolTipText("alt+t");
    salir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        salirActionPerformed(evt);
      }
    });
    salir.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        salirKeyPressed(evt);
      }
    });

    jLabel3.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel3.setText("DATABASE");

    database.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N

    jLabel4.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel4.setText("URL");

    url.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N

    javax.swing.GroupLayout principalLayout = new javax.swing.GroupLayout(principal);
    principal.setLayout(principalLayout);
    principalLayout.setHorizontalGroup(
      principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalLayout.createSequentialGroup()
        .addContainerGap(65, Short.MAX_VALUE)
        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(63, 63, 63))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalLayout.createSequentialGroup()
        .addGap(29, 29, 29)
        .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(usuario, javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(database, javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(url, javax.swing.GroupLayout.Alignment.LEADING))
        .addGap(28, 28, 28))
    );
    principalLayout.setVerticalGroup(
      principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(principalLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(database, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(19, 19, 19)
        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(principal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
      salir();
    }//GEN-LAST:event_salirActionPerformed

  private void salirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salirKeyPressed
    salir();
  }//GEN-LAST:event_salirKeyPressed
  private void salir() {
    dispose();
  }

  private void usuarioNoEditable() {
    UserDataBase us = new ReadProperties().getUser();
    url.setText(us.getUrl());
    database.setText(us.getBase());
    usuario.setText(us.getUsuario());
    password.setText(us.getPassword());
    url.setEditable(false);
    database.setEditable(false);
    usuario.setEditable(false);
    password.setEditable(false);
  }
//  private UserDataBase usuarioEditable() {
//    UserDataBase usuarioEdit = new ReadProperties().getUser();
//    url.setText(usuarioEdit.getUrl());
//    database.setText(usuarioEdit.getBase());
//    usuario.setText(usuarioEdit.getUsuario());
//    password.setText(usuarioEdit.getPassword());
//    return usuarioEdit;
//  }
//  private void setInputVerifier() {
//    url.setInputVerifier(new InputVerifier().inputVerifierT());
//    database.setInputVerifier(new InputVerifier().inputVerifierT());
//    usuario.setInputVerifier(new InputVerifier().inputVerifierT());
//    password.setInputVerifier(new InputVerifier().inputVerifierT());
//  }
  /**
   * @param args the command line arguments
   */
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField database;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JTextField password;
  private javax.swing.JPanel principal;
  private javax.swing.JButton salir;
  private javax.swing.JTextField url;
  private javax.swing.JTextField usuario;
  // End of variables declaration//GEN-END:variables
}
