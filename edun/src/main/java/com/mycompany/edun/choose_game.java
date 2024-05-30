/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.edun;

import com.mycompany.edun.database.koneksi_db;
import java.awt.Font;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author nadiaag
 */
public class choose_game extends javax.swing.JFrame {

    /**
     * Creates new form choose_game
     */
    public choose_game(String username) {
        initComponents();
        try{
           // Add Customize Font Button
           File fontBlack = new File("src/main/resources/fonts/Nunito-Black.ttf");
           Font font_button = Font.createFont(Font.TRUETYPE_FONT, fontBlack).deriveFont(24f);
           button_Back.setFont(font_button);
           
           // Add Customize Font 20 Bold
           File fontButton = new File("src/main/resources/fonts/Nunito-Bold.ttf");
           Font font_20 = Font.createFont(Font.TRUETYPE_FONT, fontButton).deriveFont(20f);
           question.setFont(font_20);
           
           // Add Customize Font 26 Black
           Font font_24 = Font.createFont(Font.TRUETYPE_FONT, fontButton).deriveFont(26f);
           text_name.setFont(font_24);
           
           // Menampilkan username
           showUsername(username);
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
        icon_home = new rojerusan.RSPanelImage();
        button_Home = new rojerusan.RSMaterialButtonRectangle();
        icon_back = new rojerusan.RSPanelImage();
        button_Back = new rojerusan.RSMaterialButtonRectangle();
        txt_puzzle1 = new javax.swing.JLabel();
        tts = new javax.swing.JLabel();
        button_TTS = new rojerusan.RSMaterialButtonRectangle();
        txt_puzzle = new javax.swing.JLabel();
        puzzle = new javax.swing.JLabel();
        button_Puzzle = new rojerusan.RSMaterialButtonRectangle();
        question = new javax.swing.JLabel();
        text_name = new javax.swing.JLabel();
        book = new javax.swing.JLabel();
        bg_choose = new javax.swing.JLabel();
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        txt_puzzle1.setFont(new java.awt.Font("Nunito", 1, 22)); // NOI18N
        txt_puzzle1.setForeground(new java.awt.Color(255, 255, 255));
        txt_puzzle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_puzzle1.setText("Teka Teki Silang");
        jPanel1.add(txt_puzzle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 630, 200, -1));

        tts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Crossword.png"))); // NOI18N
        jPanel1.add(tts, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 510, 100, 100));

        button_TTS.setBackground(new java.awt.Color(132, 204, 22));
        button_TTS.setHideActionText(true);
        button_TTS.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        button_TTS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(button_TTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 480, 220, 210));

        txt_puzzle.setFont(new java.awt.Font("Nunito", 1, 24)); // NOI18N
        txt_puzzle.setForeground(new java.awt.Color(255, 255, 255));
        txt_puzzle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_puzzle.setText("Susun Puzzle");
        jPanel1.add(txt_puzzle, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 630, 160, -1));

        puzzle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Puzzle.png"))); // NOI18N
        jPanel1.add(puzzle, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, 110, 110));

        button_Puzzle.setBackground(new java.awt.Color(29, 78, 216));
        button_Puzzle.setHideActionText(true);
        button_Puzzle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        button_Puzzle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        button_Puzzle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_PuzzleActionPerformed(evt);
            }
        });
        jPanel1.add(button_Puzzle, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, 220, 210));

        question.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        question.setForeground(new java.awt.Color(100, 116, 139));
        question.setText("Mau main apa hari ini?");
        jPanel1.add(question, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, -1, -1));

        text_name.setFont(new java.awt.Font("Nunito", 1, 24)); // NOI18N
        text_name.setForeground(new java.awt.Color(51, 65, 85));
        text_name.setText("text_name");
        jPanel1.add(text_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, -1, -1));

        book.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Illust - Book.png"))); // NOI18N
        jPanel1.add(book, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 230, 220));

        bg_choose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/BG-Choose.png"))); // NOI18N
        jPanel1.add(bg_choose, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, -1, 470));

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

    // Menampilkan tulisan Nama Pengguna
    private void showUsername(String username){
        // Membuat objek
        try{
            // 02. Query SQL
            String name = "SELECT CONCAT('Halo, ', username, '!') AS concatUsername FROM users WHERE username = '" + username + "'";
            
            // 03. Menghubungkan JAVA & SQL
            Connection penghubung = (Connection)koneksi_db.konfigurasi_koneksiDB();
            
            // 04. Statement SQL dengan akses database langsung
            Statement showUsername = penghubung.createStatement();
            
            // 05. Eksekusi perintah SQL
            ResultSet hasilSQL = showUsername.executeQuery(name);
            
            // 06. Tampilkan data
            if(hasilSQL.next()){
                String nameDB = hasilSQL.getString("concatUsername");
                text_name.setText(nameDB);
            } else {
                text_name.setText("User not found");
            }
        } catch (Exception e){
            // 07. Salah system
            e.printStackTrace();
        }
    }
    
    private void button_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_BackActionPerformed
        // TODO add your handling code here:
        login_user user = new login_user();
        user.setVisible(true);
    }//GEN-LAST:event_button_BackActionPerformed

    private void button_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_HomeActionPerformed
        // TODO add your handling code here:
        login_menu menu = new login_menu();
        menu.setVisible(true);
    }//GEN-LAST:event_button_HomeActionPerformed

    private void creditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creditsActionPerformed

    private void loginAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginAdminActionPerformed
        // TODO add your handling code here:
        login_admin admin = new login_admin();
        admin.setVisible(true);
    }//GEN-LAST:event_loginAdminActionPerformed

    private void logoutAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutAdminActionPerformed

    private void button_PuzzleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_PuzzleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_PuzzleActionPerformed

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
            java.util.logging.Logger.getLogger(choose_game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(choose_game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(choose_game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(choose_game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String username = "username";
                new choose_game(username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JLabel bg_choose;
    private javax.swing.JLabel bg_pattern;
    private javax.swing.JLabel book;
    private rojerusan.RSMaterialButtonRectangle button_Back;
    private rojerusan.RSMaterialButtonRectangle button_Home;
    private rojerusan.RSMaterialButtonRectangle button_Puzzle;
    private rojerusan.RSMaterialButtonRectangle button_TTS;
    private javax.swing.JMenuItem credits;
    private javax.swing.JMenu eduN;
    private rojerusan.RSPanelImage icon_back;
    private rojerusan.RSPanelImage icon_home;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem loginAdmin;
    private javax.swing.JMenuItem logoutAdmin;
    private javax.swing.JLabel puzzle;
    private javax.swing.JLabel question;
    private javax.swing.JMenuItem quit;
    private javax.swing.JLabel text_name;
    private javax.swing.JMenu tools;
    private javax.swing.JLabel tts;
    private javax.swing.JLabel txt_puzzle;
    private javax.swing.JLabel txt_puzzle1;
    // End of variables declaration//GEN-END:variables
}
