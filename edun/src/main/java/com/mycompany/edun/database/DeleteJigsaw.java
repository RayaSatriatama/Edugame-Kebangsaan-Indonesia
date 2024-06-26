/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.edun.database;

import com.mycompany.edun.HomeAdmin;
import java.awt.HeadlessException;
import java.io.File;
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
public class DeleteJigsaw extends javax.swing.JFrame {

    private File selectedFile;

    /**
     * Creates new form DeletePuzzle
     */
    public DeleteJigsaw() {
        initComponents();
        read();
    }

    private void refreshForm() {
        // Menyegarkan JFrame
        selectedFile = null;
        puzzle_name.setText("");
        file_path.setText("");
        jLabel9.setText("");
    }

    private void read() {
        DefaultTableModel jigsawData = new DefaultTableModel();
        jigsawData.addColumn("No");
        jigsawData.addColumn("ID");
        jigsawData.addColumn("Name");
        jigsawData.addColumn("Path");
        jigsawData.addColumn("Upload Time");

        try {
            String query = "SELECT * FROM jigsaw_puzzle";

            Connection connection = (Connection) DBConnection.konfigurasi_koneksiDB();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        puzzle_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        file_path = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header1.setBackground(new java.awt.Color(255, 255, 255));

        title1.setFont(new java.awt.Font("SF Pro Text", 1, 18)); // NOI18N
        title1.setForeground(new java.awt.Color(15, 23, 42));
        title1.setText("Hapus Puzzle");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 450, Short.MAX_VALUE)
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

        jLabel4.setFont(new java.awt.Font("SF Pro Text", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(15, 23, 42));
        jLabel4.setText("<html> Nama Puzzle  <span style=\"color: #F73B3B;\">*</span> </html>");
        background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));

        jLabel8.setFont(new java.awt.Font("SF Pro Text", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(15, 23, 42));
        jLabel8.setText("Modul ID:");
        background.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel9.setFont(new java.awt.Font("SF Pro Text", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(67, 56, 202));
        jLabel9.setText("00");
        background.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));
        background.add(puzzle_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 600, 40));

        jLabel5.setFont(new java.awt.Font("SF Pro Text", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(15, 23, 42));
        jLabel5.setText("<html> File Path </html>");
        background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, -1, -1));

        file_path.setEnabled(false);
        background.add(file_path, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 600, 40));

        jLabel10.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Klik puzzle yang akan dihapus");
        background.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 30));

        jLabel11.setFont(new java.awt.Font("SF Pro Text", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(15, 23, 42));
        jLabel11.setText("<html>Pilih Puzzle <span style=\"color: #F73B3B;\">*</span> </html>");
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

        background.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 600, 250));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 780));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        HomeAdmin.open = 0;
        this.dispose();
    }//GEN-LAST:event_closeMouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int row = jTable2.rowAtPoint(evt.getPoint());

        String id = jTable2.getValueAt(row, 1).toString();
        jLabel9.setText(id);

        String name = jTable2.getValueAt(row, 2).toString();
        puzzle_name.setText(name);

        String path = jTable2.getValueAt(row, 3).toString();
        file_path.setText(path);
    }//GEN-LAST:event_jTable2MouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        String id = jLabel9.getText();
        try {
            Connection con = (Connection) DBConnection.konfigurasi_koneksiDB();
            PreparedStatement ps = con.prepareStatement("DELETE FROM jigsaw_puzzle WHERE id=?");
            ps.setString(1, id);
            ps.executeUpdate();
            deleteFile();
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Image Succesfully Deleted");
        } catch (HeadlessException | SecurityException | SQLException e) {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        } finally {
            read();
            refreshForm();
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void deleteFile() {
        String selectedFileName = puzzle_name.getText();
        if (selectedFileName != null) {
            File fileToDelete = new File("src/main/resources/assets/JigsawPuzzleImages/", selectedFileName);

            if (fileToDelete.exists()) {
                fileToDelete.delete();
            }

            refreshForm();
            JOptionPane.showMessageDialog(this, "File deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "No file selected to delete.");
        }
    }

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        refreshForm();
    }//GEN-LAST:event_clearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private rojerusan.RSMaterialButtonRectangle clear;
    private rojerusan.RSPanelImage close;
    private javax.swing.JPanel cta;
    private rojerusan.RSMaterialButtonRectangle delete;
    private javax.swing.JTextField file_path;
    private javax.swing.JPanel header1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JSeparator line_cta1;
    private javax.swing.JSeparator line_header1;
    private javax.swing.JTextField puzzle_name;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel txt_save;
    private javax.swing.JLabel txt_save1;
    // End of variables declaration//GEN-END:variables
}
