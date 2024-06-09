/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.edun.database;

import com.mycompany.edun.HomeAdmin;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nadiaag
 */
public class DeleteCrossword extends javax.swing.JFrame {
    /**
     * Creates new form DeletePuzzle
     */
    public DeleteCrossword() {
        initComponents();
        read();
        refreshForm();
    }
    
    private void refreshForm() {
        // Menyegarkan JFrame
        textArea_question.setText("");
        field_answer.setText("");
        try {
            String perintah_SQL = "SELECT COUNT(id) FROM crossword_puzzle;";
            Connection penghubung = (Connection) DBConnection.konfigurasi_koneksiDB();
            Statement pernyataanSQL = penghubung.createStatement();
            ResultSet hasil_SQL = pernyataanSQL.executeQuery(perintah_SQL);
            if (hasil_SQL.next()) {
                int id = hasil_SQL.getInt(1);
                id = id + 1;
                String str = String.valueOf(id);
                jLabel9.setText(str);
            } else {
                jLabel9.setText("1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void read(){
        DefaultTableModel jigsawData = new DefaultTableModel();
        jigsawData.addColumn("No");
        jigsawData.addColumn("ID");
        jigsawData.addColumn("Question");
        jigsawData.addColumn("Answer");
        jigsawData.addColumn("Upload Time");
        
        try {
            String query = "SELECT * FROM crossword_puzzle";

            Connection connection = (Connection)DBConnection.konfigurasi_koneksiDB();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            int i = 1;
            while (resultSet.next()) {
                jigsawData.addRow(new Object[]{
                    i++,
                    resultSet.getString(1) != null ? resultSet.getString(1) : "",
                    resultSet.getString(2) != null ? resultSet.getString(2) : "",
                    resultSet.getString(3) != null ? resultSet.getString(3) : "",
                    resultSet.getString(4) != null ? resultSet.getString(4) : ""
                });
                jTable2.setModel(jigsawData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        header1 = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        close = new rojerusan.RSPanelImage();
        line_header1 = new javax.swing.JSeparator();
        cta = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txt_save = new javax.swing.JLabel();
        delete = new rojerusan.RSMaterialButtonRectangle();
        jPanel3 = new javax.swing.JPanel();
        txt_save1 = new javax.swing.JLabel();
        clear = new rojerusan.RSMaterialButtonRectangle();
        line_cta1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea_question = new javax.swing.JTextArea();
        text_question = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        field_answer = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header1.setBackground(new java.awt.Color(255, 255, 255));

        title1.setFont(new java.awt.Font("SF Pro Text", 1, 18)); // NOI18N
        title1.setForeground(new java.awt.Color(15, 23, 42));
        title1.setText("Hapus TTS");

        close.setImagen(new javax.swing.ImageIcon(getClass().getResource("/assets/Icon-Close.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout header1Layout = new javax.swing.GroupLayout(header1);
        header1.setLayout(header1Layout);
        header1Layout.setHorizontalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(title1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 473, Short.MAX_VALUE)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        header1Layout.setVerticalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title1))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        background.add(header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 70));

        line_header1.setForeground(new java.awt.Color(226, 232, 240));
        background.add(line_header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 670, 10));

        cta.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_save.setFont(new java.awt.Font("SF Pro Text", 1, 18)); // NOI18N
        txt_save.setForeground(new java.awt.Color(255, 255, 255));
        txt_save.setText("Hapus");
        jPanel2.add(txt_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 80, -1));

        delete.setBackground(new java.awt.Color(225, 29, 72));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 5, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_save1.setFont(new java.awt.Font("SF Pro Text", 1, 18)); // NOI18N
        txt_save1.setForeground(new java.awt.Color(51, 65, 85));
        txt_save1.setText("Bersihkan");
        jPanel3.add(txt_save1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        clear.setBackground(new java.awt.Color(241, 245, 249));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel3.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));

        javax.swing.GroupLayout ctaLayout = new javax.swing.GroupLayout(cta);
        cta.setLayout(ctaLayout);
        ctaLayout.setHorizontalGroup(
            ctaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(467, 467, 467))
        );
        ctaLayout.setVerticalGroup(
            ctaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctaLayout.createSequentialGroup()
                .addGroup(ctaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        background.add(cta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 670, 100));

        line_cta1.setForeground(new java.awt.Color(226, 232, 240));
        background.add(line_cta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 670, -1));

        jLabel8.setFont(new java.awt.Font("SF Pro Text", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(15, 23, 42));
        jLabel8.setText("Modul ID:");
        background.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel9.setFont(new java.awt.Font("SF Pro Text", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(67, 56, 202));
        jLabel9.setText("00");
        background.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        jLabel10.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Klik TTS yang akan diperbarui");
        background.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 30));

        jLabel11.setFont(new java.awt.Font("SF Pro Text", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(15, 23, 42));
        jLabel11.setText("<html>Pilih TTS <span style=\"color: #F73B3B;\">*</span> </html>");
        background.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "ID", "Name", "Path", "Upload Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        background.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 600, 210));

        textArea_question.setColumns(20);
        textArea_question.setLineWrap(true);
        textArea_question.setRows(5);
        jScrollPane1.setViewportView(textArea_question);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 600, 90));

        text_question.setFont(new java.awt.Font("SF Pro Text", 1, 16)); // NOI18N
        text_question.setForeground(new java.awt.Color(15, 23, 42));
        text_question.setText("<html> Pertanyaan  <span style=\"color: #F73B3B;\">*</span> </html>");
        background.add(text_question, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        jLabel5.setFont(new java.awt.Font("SF Pro Text", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(15, 23, 42));
        jLabel5.setText("<html> Jawaban  <span style=\"color: #F73B3B;\">*</span> </html>");
        background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, -1, -1));
        background.add(field_answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, 600, 40));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 780));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        HomeAdmin.open=0;
        setVisible(false);
    }//GEN-LAST:event_closeMouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int row = jTable2.rowAtPoint(evt.getPoint());

        String id = jTable2.getValueAt(row, 1).toString();
        jLabel9.setText(id);

        String name = jTable2.getValueAt(row, 2).toString();
        textArea_question.setText(name);

        String path = jTable2.getValueAt(row, 3).toString();
        field_answer.setText(path);
    }//GEN-LAST:event_jTable2MouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        String id = jLabel9.getText();
        try {
            Connection con = (Connection)DBConnection.konfigurasi_koneksiDB();
            PreparedStatement ps = con.prepareStatement( "DELETE FROM crossword_puzzle WHERE id=?");
            ps.setString(1, id);
            ps.executeUpdate();
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Succesfully Deleted");
        }
        catch (HeadlessException | SecurityException | SQLException e) {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        } finally {
            read();
            refreshForm();
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        refreshForm();
    }//GEN-LAST:event_clearActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DeleteCrossword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteCrossword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteCrossword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteCrossword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteCrossword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private rojerusan.RSMaterialButtonRectangle clear;
    private rojerusan.RSPanelImage close;
    private javax.swing.JPanel cta;
    private rojerusan.RSMaterialButtonRectangle delete;
    private javax.swing.JTextField field_answer;
    private javax.swing.JPanel header1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JSeparator line_cta1;
    private javax.swing.JSeparator line_header1;
    private javax.swing.JTextArea textArea_question;
    private javax.swing.JLabel text_question;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel txt_save;
    private javax.swing.JLabel txt_save1;
    // End of variables declaration//GEN-END:variables
}