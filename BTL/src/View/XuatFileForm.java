package View;

import Control.XuatFileController;
import Model.DanhGia;
import Model.Lop;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class XuatFileForm extends javax.swing.JFrame {

  XuatFileController xuatFileController = new XuatFileController();
  HSSFWorkbook workbook = new HSSFWorkbook();
  ArrayList<Lop> dsLop = new ArrayList<>();
  ArrayList<DanhGia> dsDanhGia = new ArrayList<>();
  
  public XuatFileForm() {
    initComponents();
    xuatFileController.init(this, jComboBoxDSLop, dsLop);
  }
  
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonQuayLai = new javax.swing.JButton();
        jComboBoxDSLop = new javax.swing.JComboBox<>();
        jButtonXuatFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-google-classroom-96.png"))); // NOI18N
        jLabel1.setText("DANH SÁCH LỚP");

        jButtonQuayLai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonQuayLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/arrow-81-24.png"))); // NOI18N
        jButtonQuayLai.setText("Quay lại");
        jButtonQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuayLaiActionPerformed(evt);
            }
        });

        jComboBoxDSLop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxDSLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonXuatFile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonXuatFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-export-excel-24.png"))); // NOI18N
        jButtonXuatFile.setText("Xuất File");
        jButtonXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXuatFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonQuayLai)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxDSLop, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonXuatFile)
                .addGap(294, 294, 294))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jComboBoxDSLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(jButtonXuatFile)
                .addGap(93, 93, 93)
                .addComponent(jButtonQuayLai)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void jButtonQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuayLaiActionPerformed
    new DangNhapGiaoVien().setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_jButtonQuayLaiActionPerformed

  private void jButtonXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXuatFileActionPerformed
    // TODO add your handling code here:
    int dialogBtn = JOptionPane.showConfirmDialog(null, "Bạn có muốn xuất file không?", "Alert", JOptionPane.YES_NO_OPTION);
    if(dialogBtn == JOptionPane.YES_OPTION) {
      for(int i = 0; i < jComboBoxDSLop.getItemCount(); i ++) {
        if(i == jComboBoxDSLop.getSelectedIndex()) {
          xuatFileController.xuatFileAction(workbook, dsDanhGia, jComboBoxDSLop.getSelectedItem().toString());
          this.dispose();
        }
      }
    }
  }//GEN-LAST:event_jButtonXuatFileActionPerformed

  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(XuatFileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(XuatFileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(XuatFileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(XuatFileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new XuatFileForm().setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonQuayLai;
    private javax.swing.JButton jButtonXuatFile;
    private javax.swing.JComboBox<String> jComboBoxDSLop;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
