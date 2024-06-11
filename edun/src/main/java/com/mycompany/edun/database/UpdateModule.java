/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.edun.database;

import com.mycompany.edun.HomeAdmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ivanbesti
 */
public class UpdateModule extends javax.swing.JFrame {

    public UpdateModule() {
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

        background = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        close = new rojerusan.RSPanelImage();
        line_header = new javax.swing.JSeparator();
        cta = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txt_save = new javax.swing.JLabel();
        save = new rojerusan.RSMaterialButtonRectangle();
        jPanel3 = new javax.swing.JPanel();
        txt_save1 = new javax.swing.JLabel();
        clear = new rojerusan.RSMaterialButtonRectangle();
        line_cta = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        search = new rojerusan.RSMaterialButtonRectangle();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("SF Pro Text", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(15, 23, 42));
        title.setText("Perbarui Modul");

        close.setImagen(new javax.swing.ImageIcon(getClass().getResource("/assets/Icon-Close.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 434, Short.MAX_VALUE)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        background.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 70));

        line_header.setForeground(new java.awt.Color(226, 232, 240));
        background.add(line_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 670, 10));

        cta.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_save.setFont(new java.awt.Font("SF Pro Text", 1, 18)); // NOI18N
        txt_save.setForeground(new java.awt.Color(255, 255, 255));
        txt_save.setText("Simpan");
        jPanel2.add(txt_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 80, -1));

        save.setBackground(new java.awt.Color(67, 56, 202));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel2.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 5, -1, -1));

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

        background.add(cta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 670, 100));

        line_cta.setForeground(new java.awt.Color(226, 232, 240));
        background.add(line_cta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 670, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 310, 610, 252));

        jLabel6.setFont(new java.awt.Font("SF Pro Text", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(15, 23, 42));
        jLabel6.setText("<html>\nCari Modul Berdasarkan ID \n<span style=\"color: #F73B3B;\">*</span>\n</html>");
        background.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("SF Pro Text", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(15, 23, 42));
        jLabel5.setText("<html>\nPilih Tema \n<span style=\"color: #F73B3B;\">*</span>\n</html>");
        background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("SF Pro Text", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(15, 23, 42));
        jLabel7.setText("<html>\nIsi Modul \n<span style=\"color: #F73B3B;\">*</span>\n</html>");
        background.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        background.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 520, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon-search.png"))); // NOI18N
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 50, 40));

        search.setBackground(new java.awt.Color(67, 56, 202));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        background.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 80, 60));

        jComboBox1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Tema", "Pancasila", "HAM", "Politik" }));
        background.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 610, 40));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        HomeAdmin.open = 0;
        this.dispose();
    }//GEN-LAST:event_closeMouseClicked

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        String id = jTextField1.getText();
        String tema = (String) jComboBox1.getSelectedItem();
        String materi = jTextArea1.getText();
        try {
            Connection con = (Connection) DBConnection.konfigurasi_koneksiDB();
            PreparedStatement ps = con.prepareStatement("UPDATE modul SET tema=?,materi=? WHERE id=?;");
            ps.setString(1, tema);
            ps.setString(2, materi);
            ps.setString(3, id);
            ps.executeUpdate();
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Module Succesfully Updated!");
        } catch (Exception e) {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jComboBox1.setSelectedItem("Pilih Tema");
        jTextArea1.setText("");
        jTextField1.setEditable(true);
    }//GEN-LAST:event_clearActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        String id = jTextField1.getText();
        try {
            Connection con = (Connection) DBConnection.konfigurasi_koneksiDB();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM modul WHERE id = '" + id + "'");
            if (rs.next()) {
                jComboBox1.setSelectedItem(rs.getString(2));
                jTextArea1.setText(rs.getString(3));
                jTextField1.setEditable(false);
            } else {
                JFrame jf = new JFrame();
                jf.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(jf, "Module ID does not Exist!");
            }
        } catch (Exception e) {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
    }//GEN-LAST:event_searchActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateModule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private rojerusan.RSMaterialButtonRectangle clear;
    private rojerusan.RSPanelImage close;
    private javax.swing.JPanel cta;
    private javax.swing.JPanel header;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JSeparator line_cta;
    private javax.swing.JSeparator line_header;
    private rojerusan.RSMaterialButtonRectangle save;
    private rojerusan.RSMaterialButtonRectangle search;
    private javax.swing.JLabel title;
    private javax.swing.JLabel txt_save;
    private javax.swing.JLabel txt_save1;
    // End of variables declaration//GEN-END:variables
}
