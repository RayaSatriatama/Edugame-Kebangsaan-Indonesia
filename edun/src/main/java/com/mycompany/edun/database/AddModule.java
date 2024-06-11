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
public class AddModule extends javax.swing.JFrame {

    public static int open = 0;

    /**
     * Creates new form AddModule
     */
    public AddModule() {
        initComponents();
        try {
            String perintah_SQL = "SELECT COUNT(id) FROM modul;";
            Connection penghubung = (Connection) DBConnection.konfigurasi_koneksiDB();
            Statement pernyataanSQL = penghubung.createStatement();
            ResultSet hasil_SQL = pernyataanSQL.executeQuery(perintah_SQL);
            if (hasil_SQL.next()) {
                int id = hasil_SQL.getInt(1);
                id = id + 1;
                String str = String.valueOf(id);
                jLabel7.setText(str);
            } else {
                jLabel7.setText("1");
            }
        } catch (Exception e) {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        close = new rojerusan.RSPanelImage();
        line_header = new javax.swing.JSeparator();
        cta = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txt_save = new javax.swing.JLabel();
        save = new rojerusan.RSMaterialButtonRectangle();
        jPanel2 = new javax.swing.JPanel();
        txt_save1 = new javax.swing.JLabel();
        clear = new rojerusan.RSMaterialButtonRectangle();
        line_cta = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("SF Pro Text", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(15, 23, 42));
        title.setText("Tambah Modul");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 438, Short.MAX_VALUE)
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_save.setFont(new java.awt.Font("SF Pro Text", 1, 18)); // NOI18N
        txt_save.setForeground(new java.awt.Color(255, 255, 255));
        txt_save.setText("Simpan");
        jPanel1.add(txt_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 80, -1));

        save.setBackground(new java.awt.Color(67, 56, 202));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 5, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_save1.setFont(new java.awt.Font("SF Pro Text", 1, 18)); // NOI18N
        txt_save1.setForeground(new java.awt.Color(51, 65, 85));
        txt_save1.setText("Bersihkan");
        jPanel2.add(txt_save1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        clear.setBackground(new java.awt.Color(241, 245, 249));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel2.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));

        javax.swing.GroupLayout ctaLayout = new javax.swing.GroupLayout(cta);
        cta.setLayout(ctaLayout);
        ctaLayout.setHorizontalGroup(
            ctaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(467, 467, 467))
        );
        ctaLayout.setVerticalGroup(
            ctaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctaLayout.createSequentialGroup()
                .addGroup(ctaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        background.add(cta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 670, 100));

        line_cta.setForeground(new java.awt.Color(226, 232, 240));
        background.add(line_cta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 670, -1));

        jLabel1.setFont(new java.awt.Font("SF Pro Text", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 23, 42));
        jLabel1.setText("<html>\nPilih Tema \n<span style=\"color: #F73B3B;\">*</span>\n</html>");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("SF Pro Text", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(15, 23, 42));
        jLabel2.setText("<html>\nIsi Modul \n<span style=\"color: #F73B3B;\">*</span>\n</html>");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 600, 290));

        jComboBox1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Tema", "Pancasila", "HAM", "Hukum" }));
        jComboBox1.setMinimumSize(new java.awt.Dimension(107, 32));
        jComboBox1.setPreferredSize(new java.awt.Dimension(107, 32));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        background.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 600, 40));

        jLabel6.setFont(new java.awt.Font("SF Pro Text", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(15, 23, 42));
        jLabel6.setText("Modul ID:");
        background.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel7.setFont(new java.awt.Font("SF Pro Text", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(67, 56, 202));
        jLabel7.setText("00");
        background.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        HomeAdmin.open = 0;
        this.dispose();
    }//GEN-LAST:event_closeMouseClicked

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        String id = jLabel7.getText();
        String tema = (String) jComboBox1.getSelectedItem();
        String materi = jTextArea1.getText();
        try {
            Connection con = (Connection) DBConnection.konfigurasi_koneksiDB();
            PreparedStatement ps = con.prepareStatement("INSERT INTO modul VALUES (?,?,?);");
            ps.setString(1, id);
            ps.setString(2, tema);
            ps.setString(3, materi);
            ps.executeUpdate();
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Succesfully Updated!");
            this.dispose();
        } catch (Exception e) {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        jTextArea1.setText("");
    }//GEN-LAST:event_clearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private rojerusan.RSMaterialButtonRectangle clear;
    private rojerusan.RSPanelImage close;
    private javax.swing.JPanel cta;
    private javax.swing.JPanel header;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JSeparator line_cta;
    private javax.swing.JSeparator line_header;
    private rojerusan.RSMaterialButtonRectangle save;
    private javax.swing.JLabel title;
    private javax.swing.JLabel txt_save;
    private javax.swing.JLabel txt_save1;
    // End of variables declaration//GEN-END:variables
}
