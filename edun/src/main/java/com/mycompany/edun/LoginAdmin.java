/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.edun;

import com.mycompany.edun.database.DBConnection;
import java.awt.Font;
import java.io.File;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nadiaag
 */
public class LoginAdmin extends javax.swing.JFrame {

    /**
     * Creates new form login_admin
     */
    public LoginAdmin() {
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

        rSPanelImage1 = new rojerusan.RSPanelImage();
        panel_login_admin = new javax.swing.JPanel();
        label_login_admin = new javax.swing.JLabel();
        label_sub = new javax.swing.JLabel();
        label_username = new javax.swing.JLabel();
        input_username = new javax.swing.JTextField();
        label_password = new javax.swing.JLabel();
        input_password = new javax.swing.JPasswordField();
        label_login = new javax.swing.JLabel();
        button_login = new rojerusan.RSMaterialButtonRectangle();
        button_back_game = new javax.swing.JButton();
        shw_password = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setName("frameAdmin"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/assets/Image-Admin.jpg"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );

        getContentPane().add(rSPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 1030));

        panel_login_admin.setBackground(new java.awt.Color(255, 255, 255));
        panel_login_admin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_login_admin.setFont(new java.awt.Font("SF Pro Text", 1, 48)); // NOI18N
        label_login_admin.setForeground(new java.awt.Color(15, 23, 42));
        label_login_admin.setText("Masuk Admin");
        panel_login_admin.add(label_login_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        label_sub.setFont(new java.awt.Font("SF Pro Text", 0, 18)); // NOI18N
        label_sub.setForeground(new java.awt.Color(100, 116, 139));
        label_sub.setText("Silakan isi nama pengguna dan kata sandi.");
        panel_login_admin.add(label_sub, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        label_username.setFont(new java.awt.Font("SF Pro Text", 0, 18)); // NOI18N
        label_username.setText("Username");
        panel_login_admin.add(label_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, -1));

        input_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_usernameActionPerformed(evt);
            }
        });
        panel_login_admin.add(input_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 410, 40));

        label_password.setFont(new java.awt.Font("SF Pro Text", 0, 18)); // NOI18N
        label_password.setText("Password");
        panel_login_admin.add(label_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, -1, -1));

        input_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_passwordActionPerformed(evt);
            }
        });
        panel_login_admin.add(input_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 410, 40));

        label_login.setFont(new java.awt.Font("SF Pro Text", 1, 18)); // NOI18N
        label_login.setForeground(new java.awt.Color(255, 255, 255));
        label_login.setText("Masuk");
        panel_login_admin.add(label_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 600, -1, 40));

        button_login.setBackground(new java.awt.Color(67, 56, 202));
        button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_loginActionPerformed(evt);
            }
        });
        panel_login_admin.add(button_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, 420, 60));

        button_back_game.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N
        button_back_game.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icon-Close.png"))); // NOI18N
        button_back_game.setText("Tutup");
        button_back_game.setIconTextGap(12);
        button_back_game.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_back_gameActionPerformed(evt);
            }
        });
        panel_login_admin.add(button_back_game, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, 40));

        shw_password.setFont(new java.awt.Font("SF Pro Text", 0, 16)); // NOI18N
        shw_password.setText("Show Password");
        shw_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shw_passwordActionPerformed(evt);
            }
        });
        panel_login_admin.add(shw_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, -1, -1));

        getContentPane().add(panel_login_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 660, 1024));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void input_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_usernameActionPerformed

    private void button_back_gameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_back_gameActionPerformed
        // TODO add your handling code here:
        LoginUser user = new LoginUser();
        user.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button_back_gameActionPerformed

    public void bersih_form_login() {
        input_username.setText("");
        input_password.setText("");
    }

    private void button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_loginActionPerformed
        // TODO add your handling code here:

        try {
            String inputUsername = input_username.getText();
            String inputPassword = new String(input_password.getPassword());
            String perintah_SQL = "SELECT * FROM admin WHERE username = '" + inputUsername + "' AND password = '" + inputPassword + "';";

            Connection penghubung = (Connection) DBConnection.konfigurasi_koneksiDB();

            Statement pernyataanSQL = penghubung.createStatement();

            ResultSet hasil_SQL = pernyataanSQL.executeQuery(perintah_SQL);

            if (hasil_SQL.next()) {

                JOptionPane.showMessageDialog(null, "Login Berhasil!");
                HomeAdmin home_admin = new HomeAdmin();
                home_admin.setVisible(true);
                this.setVisible(false);
                this.dispose();
            } else {

                JOptionPane.showMessageDialog(null, "Username/Password Invalid!");
                bersih_form_login();
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Gagal, Login! \n" + e.getMessage());
        }
    }//GEN-LAST:event_button_loginActionPerformed

    private void input_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_passwordActionPerformed


    private void shw_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shw_passwordActionPerformed
        // TODO add your handling code here:
        if (shw_password.isSelected()) {
            input_password.setEchoChar((char) 0);
        } else {
            input_password.setEchoChar('*');
        }
    }//GEN-LAST:event_shw_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_back_game;
    private rojerusan.RSMaterialButtonRectangle button_login;
    private javax.swing.JPasswordField input_password;
    private javax.swing.JTextField input_username;
    private javax.swing.JLabel label_login;
    private javax.swing.JLabel label_login_admin;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_sub;
    private javax.swing.JLabel label_username;
    private javax.swing.JPanel panel_login_admin;
    private rojerusan.RSPanelImage rSPanelImage1;
    private javax.swing.JCheckBox shw_password;
    // End of variables declaration//GEN-END:variables
}
