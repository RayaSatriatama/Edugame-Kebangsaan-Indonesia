/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.edun;

import com.mycompany.edun.database.DBConnection;
import java.awt.Font;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nadiaag
 */
public class LoginUser extends javax.swing.JFrame {

    /**
     * Creates new form login_user
     */
    public LoginUser() {
        initComponents();

        try {
            // Add Customize Font Button
            File fontButton = new File("src/main/resources/fonts/Nunito-Black.ttf");
            Font font_button = Font.createFont(Font.TRUETYPE_FONT, fontButton).deriveFont(24f);
            button_Play.setFont(font_button);
            button_Back.setFont(font_button);

            // Add Customize Font 20 Black
            Font font_20 = Font.createFont(Font.TRUETYPE_FONT, fontButton).deriveFont(18f);
            text_name.setFont(font_20);

            // Add Customize Font 24 Black
            Font font_24 = Font.createFont(Font.TRUETYPE_FONT, fontButton).deriveFont(20f);
            input_name.setFont(font_24);

            // Set the frame visible
            setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        input_name = new javax.swing.JTextField();
        text_name = new javax.swing.JLabel();
        icon_play = new rojerusan.RSPanelImage();
        button_Play = new rojerusan.RSMaterialButtonRectangle();
        bg_name = new javax.swing.JLabel();
        character_kids = new javax.swing.JLabel();
        icon_back = new rojerusan.RSPanelImage();
        button_Back = new rojerusan.RSMaterialButtonRectangle();
        icon_home = new rojerusan.RSPanelImage();
        button_Home = new rojerusan.RSMaterialButtonRectangle();
        bg_pattern = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        eduN = new javax.swing.JMenu();
        credits = new javax.swing.JMenuItem();
        about = new javax.swing.JMenuItem();
        quit = new javax.swing.JMenuItem();
        tools = new javax.swing.JMenu();
        loginAdmin = new javax.swing.JMenuItem();
        logoutAdmin = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login User");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        input_name.setFont(new java.awt.Font("Nunito", 1, 24)); // NOI18N
        input_name.setForeground(new java.awt.Color(15, 23, 42));
        input_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        input_name.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(148, 163, 184)));
        input_name.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        input_name.setMargin(new java.awt.Insets(100, 6, 2, 6));
        input_name.setName(""); // NOI18N
        input_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_nameActionPerformed(evt);
            }
        });
        jPanel1.add(input_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 430, 60));

        text_name.setFont(new java.awt.Font("Nunito", 1, 18)); // NOI18N
        text_name.setForeground(new java.awt.Color(51, 65, 85));
        text_name.setText("SIAPA NAMA KAMU?");
        jPanel1.add(text_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, -1, -1));

        icon_play.setImagen(new javax.swing.ImageIcon(getClass().getResource("/assets/Icon-Play.png"))); // NOI18N
        jPanel1.add(icon_play, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 700, 30, 30));

        button_Play.setBackground(new java.awt.Color(124, 58, 237));
        button_Play.setText("MULAI PERMAINAN");
        button_Play.setFont(new java.awt.Font("Nunito", 1, 18)); // NOI18N
        button_Play.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        button_Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_PlayActionPerformed(evt);
            }
        });
        jPanel1.add(button_Play, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 680, 410, -1));

        bg_name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/BG-Name.png"))); // NOI18N
        jPanel1.add(bg_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 510, 330));

        character_kids.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Cartoon.png"))); // NOI18N
        jPanel1.add(character_kids, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 460, 340));

        icon_back.setImagen(new javax.swing.ImageIcon(getClass().getResource("/assets/Back-Arrow.png"))); // NOI18N
        jPanel1.add(icon_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 30, 30));

        button_Back.setBackground(new java.awt.Color(244, 63, 94));
        button_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Back-Arrow.png"))); // NOI18N
        button_Back.setText("KEMBALI");
        button_Back.setAlignmentX(0.5F);
        button_Back.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        button_Back.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        button_Back.setIconTextGap(50);
        button_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_BackActionPerformed(evt);
            }
        });
        jPanel1.add(button_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 230, -1));

        icon_home.setImagen(new javax.swing.ImageIcon(getClass().getResource("/assets/Icon-Home.png"))); // NOI18N
        jPanel1.add(icon_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 110, 30, 30));

        button_Home.setBackground(new java.awt.Color(2, 132, 199));
        button_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icon-Home.png"))); // NOI18N
        button_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_HomeActionPerformed(evt);
            }
        });
        jPanel1.add(button_Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 90, 90, -1));

        bg_pattern.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/BG.png"))); // NOI18N
        jPanel1.add(bg_pattern, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1440, 1060));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        eduN.setText("eduN");

        credits.setText("Credits");
        credits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditsActionPerformed(evt);
            }
        });
        eduN.add(credits);

        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        eduN.add(about);

        quit.setText("Keluar eduN");
        eduN.add(quit);

        jMenuBar1.add(eduN);

        tools.setText("Alat");
        tools.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        loginAdmin.setText("Masuk Admin");
        loginAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginAdminActionPerformed(evt);
            }
        });
        tools.add(loginAdmin);

        logoutAdmin.setText("Keluar Admin");
        logoutAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        logoutAdmin.setEnabled(false);
        logoutAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutAdminActionPerformed(evt);
            }
        });
        tools.add(logoutAdmin);

        jMenuBar1.add(tools);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void input_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_nameActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_input_nameActionPerformed

    private void button_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_HomeActionPerformed
        // TODO add your handling code here:
        LoginMenu menu = new LoginMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button_HomeActionPerformed

    private void button_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_BackActionPerformed
        // TODO add your handling code here:
        LoginMenu menu = new LoginMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button_BackActionPerformed

    private void button_PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_PlayActionPerformed
        // TODO add your handling code here:

        // 01. Tangkap variable inputan dari GUI
        String username = input_name.getText();

        try {
            // 02. Query SQL
            String addNewUser = "INSERT INTO users (name) VALUES (?)";

            // 03. Menghubungkan JAVA & SQL
            Connection penghubung = (Connection) DBConnection.konfigurasi_koneksiDB();

            // 04. Statement SQL dengan akses database langsung (memodifikasi data)
            PreparedStatement newUser = penghubung.prepareStatement(addNewUser);
            newUser.setString(1, username);

            // 05. Eksekusi perintah SQL
            int rowsInserted = newUser.executeUpdate();

            if (rowsInserted > 0) {
                // 06. Validasi SQL dan lanjut ke halaman berikutnya
                ChooseGame game = new ChooseGame(username);
                game.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Gagal");
            }

        } catch (Exception e) {
            // 07. Salah system
        }
    }//GEN-LAST:event_button_PlayActionPerformed

    private void creditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditsActionPerformed
        // TODO add your handling code here:
        Credits c = new Credits();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_creditsActionPerformed

    private void loginAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginAdminActionPerformed
        // TODO add your handling code here:
        LoginAdmin admin = new LoginAdmin();
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginAdminActionPerformed

    private void logoutAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutAdminActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        // TODO add your handling code here:
        About a = new About();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_aboutActionPerformed

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
            java.util.logging.Logger.getLogger(LoginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JLabel bg_name;
    private javax.swing.JLabel bg_pattern;
    private rojerusan.RSMaterialButtonRectangle button_Back;
    private rojerusan.RSMaterialButtonRectangle button_Home;
    private rojerusan.RSMaterialButtonRectangle button_Play;
    private javax.swing.JLabel character_kids;
    private javax.swing.JMenuItem credits;
    private javax.swing.JMenu eduN;
    private rojerusan.RSPanelImage icon_back;
    private rojerusan.RSPanelImage icon_home;
    private rojerusan.RSPanelImage icon_play;
    private javax.swing.JTextField input_name;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem loginAdmin;
    private javax.swing.JMenuItem logoutAdmin;
    private javax.swing.JMenuItem quit;
    private javax.swing.JLabel text_name;
    private javax.swing.JMenu tools;
    // End of variables declaration//GEN-END:variables

}
