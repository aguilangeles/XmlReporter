/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class InformeReporte extends javax.swing.JFrame {

  private MyWorker reporte;

  /**
   * Creates new form InformeReporte
   */
  public InformeReporte() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jTRuta = new javax.swing.JTextField();
    jbBuscar = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jtaMensaje = new javax.swing.JTextArea();
    conectadoA = new javax.swing.JLabel();
    jBCerrar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("XMLOcrStats_v_1.0.04");

    jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Ingrese la Ubicaci�n del Vol�men a reportar");

    jTRuta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
    jTRuta.setText("C:\\Angeles\\testeo\\osn");

    jbBuscar.setText("Informar");
    jbBuscar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbBuscarActionPerformed(evt);
      }
    });

    jtaMensaje.setColumns(20);
    jtaMensaje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jtaMensaje.setRows(5);
    jScrollPane1.setViewportView(jtaMensaje);

    conectadoA.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
    conectadoA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    conectadoA.setText("Conectado a:");

    jBCerrar.setText("Cerrar");
    jBCerrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jBCerrarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jTRuta)
          .addComponent(conectadoA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(28, 28, 28)
            .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
            .addComponent(jBCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(24, 24, 24))
          .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(7, 7, 7)
        .addComponent(jTRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(conectadoA, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jBCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(14, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
//      actionPerformed(evt);
      listarFiles();
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jBCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCerrarActionPerformed
      System.exit(0);
    }//GEN-LAST:event_jBCerrarActionPerformed

  private String getPathname() {
    return jTRuta.getText().trim();
  }

  private void listarFiles() {
    File folder = new File(getPathname());
    java.io.FileFilter filefilter = new java.io.FileFilter() {
      @Override
      public boolean accept(File file) {
        return file.isDirectory();
      }
    };
    if (folder.exists())
      {
      File[] listOfFiles = folder.listFiles(filefilter);
      reporte = new MyWorker(jBCerrar, jtaMensaje,
              getPathname(), conectadoA, listOfFiles);
      this.reporte.execute();

      } else
      {
      JOptionPane.showMessageDialog(jTRuta, "El archivo especificado no existe",
              "Archivo no encontrado", JOptionPane.ERROR_MESSAGE);
      jTRuta.setText("");
      }
  }

  /**
   * @param args the command line arguments
   */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(InformeReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(InformeReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(InformeReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(InformeReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new InformeReporte().setVisible(true);
//            }
//        });
//    }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel conectadoA;
  private javax.swing.JButton jBCerrar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextField jTRuta;
  private javax.swing.JButton jbBuscar;
  private javax.swing.JTextArea jtaMensaje;
  // End of variables declaration//GEN-END:variables
}
