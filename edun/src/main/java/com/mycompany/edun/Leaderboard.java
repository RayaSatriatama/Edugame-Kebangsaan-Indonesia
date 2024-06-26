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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Lusi Alifatul Laila
 */
public class Leaderboard extends javax.swing.JFrame {

    int newId;
    String newName;
    int newMarks;
    String newGameType;
    int newRank;

    /**
     * Creates new form leaderboard
     */
    public Leaderboard() {
        initComponents();
        try {
            File fontBlack = new File("src/main/resources/fonts/Nunito-Black.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontBlack).deriveFont(24f);
            button_back.setFont(font);
            button_try.setFont(font);
            username1.setFont(font);
            username2.setFont(font);
            username3.setFont(font);
            username4.setFont(font);
            username5.setFont(font);
            score1.setFont(font);
            score2.setFont(font);
            score3.setFont(font);
            score4.setFont(font);
            score5.setFont(font);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Leaderboard(String inputName, int inputMarks, String inputGameType, int inputId) throws SQLException {
        initComponents();
        newId = inputId;
        newName = inputName;
        newMarks = inputMarks;
        newGameType = inputGameType.toUpperCase();
        newRank = -1;
        Connection connection = (Connection) DBConnection.konfigurasi_koneksiDB();
        newRank = getRank(connection, newId, newGameType);
        System.out.println("Rank of " + newName + ": " + newRank);
        updateLeaderboard(connection, 4, newGameType);
    }

    public Leaderboard(String inputName, int inputMarks, String inputGameType) {
        initComponents();
        newId = -1;
        newName = inputName;
        newMarks = inputMarks;
        newGameType = inputGameType.toUpperCase();
        newRank = -1;
        try {
            String query = "INSERT INTO score (name, marks, game_type) VALUES (?, ?, ?)";

            Connection connection = (Connection) DBConnection.konfigurasi_koneksiDB();

            try (PreparedStatement pst = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
                pst.setString(1, newName);
                pst.setInt(2, newMarks);
                pst.setString(3, newGameType);
                pst.executeUpdate();
                try (ResultSet rs = pst.getGeneratedKeys()) {
                    if (rs.next()) {
                        newId = rs.getInt(1);
                    }
                }
            } catch (SQLException e) {
                JFrame jf = new JFrame();
                jf.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(jf, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            newRank = getRank(connection, newId, newGameType);
            System.out.println("Rank of " + newName + ": " + newRank);

            updateLeaderboard(connection, 4, newGameType);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int getRank(Connection conn, int id, String gameType) throws SQLException {
        String rankSQL
                = "WITH ranked_scores AS ("
                + "    SELECT id, name, marks, RANK() OVER (ORDER BY marks DESC) as rank"
                + "    FROM score WHERE game_type = ?"
                + ")"
                + "SELECT rank FROM ranked_scores WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(rankSQL)) {
            pstmt.setString(1, gameType);
            pstmt.setInt(2, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("rank");
                }
            }
        }
        return -1;
    }

    private void updateLeaderboard(Connection conn, int limit, String gameType) throws SQLException {
        String topScoresSQL
                = "SELECT name, marks, RANK() OVER (ORDER BY marks DESC) as rank"
                + " FROM score WHERE game_type = ?"
                + " ORDER BY marks DESC"
                + " LIMIT ?";

        try (PreparedStatement pstmt = conn.prepareStatement(topScoresSQL)) {
            pstmt.setString(1, gameType);
            pstmt.setInt(2, limit);
            try (ResultSet rs = pstmt.executeQuery()) {
                int index = 1;
                while (rs.next() && index <= limit) {
                    String name = rs.getString("name");
                    int marks = rs.getInt("marks");
                    int rank = rs.getInt("rank");

                    switch (index) {
                        case 1:
                            username1.setText(name);
                            score1.setText(String.valueOf(marks));
                            break;
                        case 2:
                            username2.setText(name);
                            score2.setText(String.valueOf(marks));
                            break;
                        case 3:
                            username3.setText(name);
                            score3.setText(String.valueOf(marks));
                            break;
                        case 4:
                            username4.setText(name);
                            score4.setText(String.valueOf(marks));
                            break;
                        default:
                            break;
                    }
                    index++;
                }
                String newRankString = String.valueOf(newRank);
                String newMarksString = String.valueOf(newMarks);
                jLabel2.setText(newRankString);
                username5.setText(newName);
                score5.setText(newMarksString);
            }
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

        jPanel2 = new javax.swing.JPanel();
        rSPanelImage2 = new rojerusan.RSPanelImage();
        jPanel1 = new javax.swing.JPanel();
        title_peringkat = new javax.swing.JLabel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        button_home = new rojerusan.RSMaterialButtonRectangle();
        icon_restart = new javax.swing.JLabel();
        button_try = new rojerusan.RSMaterialButtonRectangle();
        icon_back = new javax.swing.JLabel();
        button_back = new rojerusan.RSMaterialButtonRectangle();
        icon_peringkat1 = new javax.swing.JLabel();
        username1 = new javax.swing.JLabel();
        score1 = new javax.swing.JLabel();
        bg1 = new javax.swing.JLabel();
        icon_peringkat2 = new javax.swing.JLabel();
        username2 = new javax.swing.JLabel();
        score2 = new javax.swing.JLabel();
        bg2 = new javax.swing.JLabel();
        icon_peringkat3 = new javax.swing.JLabel();
        username3 = new javax.swing.JLabel();
        score3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bg3 = new javax.swing.JLabel();
        icon_peringkat4 = new javax.swing.JLabel();
        username4 = new javax.swing.JLabel();
        score4 = new javax.swing.JLabel();
        bg4 = new javax.swing.JLabel();
        icon_peringkat = new javax.swing.JLabel();
        username5 = new javax.swing.JLabel();
        score5 = new javax.swing.JLabel();
        bg5 = new javax.swing.JLabel();
        bg_leaderboard = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1440, 1024));
        setMinimumSize(new java.awt.Dimension(0, 0));

        jPanel2.setMinimumSize(new java.awt.Dimension(1440, 1024));

        rSPanelImage2.setImagen(new javax.swing.ImageIcon(getClass().getResource("/assets/BG2.png"))); // NOI18N
        rSPanelImage2.setMinimumSize(new java.awt.Dimension(1440, 1024));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title_peringkat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Text-Peringkat.png"))); // NOI18N
        jPanel1.add(title_peringkat, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, -1, -1));

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/assets/Icon-Home.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(rSPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 30, 30));

        button_home.setBackground(new java.awt.Color(2, 132, 199));
        button_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_homeActionPerformed(evt);
            }
        });
        jPanel1.add(button_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 70, -1));

        icon_restart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon restart.png"))); // NOI18N
        jPanel1.add(icon_restart, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 700, -1, -1));

        button_try.setBackground(new java.awt.Color(255, 204, 51));
        button_try.setText("MAIN LAGI");
        button_try.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tryActionPerformed(evt);
            }
        });
        jPanel1.add(button_try, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 680, 249, -1));

        icon_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Back-Arrow.png"))); // NOI18N
        jPanel1.add(icon_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 700, -1, -1));

        button_back.setBackground(new java.awt.Color(244, 63, 94));
        button_back.setText("KEMBALI");
        button_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_backActionPerformed(evt);
            }
        });
        jPanel1.add(button_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 680, 219, -1));

        icon_peringkat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/peringkat1.png"))); // NOI18N
        jPanel1.add(icon_peringkat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        username1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        username1.setText("[USERNAME]");
        jPanel1.add(username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        score1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        score1.setText("[SCORE]");
        jPanel1.add(score1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, -1, -1));

        bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bg_Rectangle1.png"))); // NOI18N
        jPanel1.add(bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        icon_peringkat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/peringkat2.png"))); // NOI18N
        jPanel1.add(icon_peringkat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        username2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        username2.setText("[USERNAME]");
        jPanel1.add(username2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        score2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        score2.setText("[SCORE]");
        jPanel1.add(score2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, -1, -1));

        bg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bg_Rectangle1.png"))); // NOI18N
        jPanel1.add(bg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        icon_peringkat3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/peringkat3.png"))); // NOI18N
        jPanel1.add(icon_peringkat3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        username3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        username3.setText("[USERNAME]");
        jPanel1.add(username3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, -1, -1));

        score3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        score3.setText("[SCORE]");
        jPanel1.add(score3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("0");
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 70, -1));

        bg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bg_Rectangle1.png"))); // NOI18N
        jPanel1.add(bg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        icon_peringkat4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/peringkat4.png"))); // NOI18N
        jPanel1.add(icon_peringkat4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, -1, -1));

        username4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        username4.setText("[USERNAME]");
        jPanel1.add(username4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, -1, -1));

        score4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        score4.setText("[SCORE]");
        jPanel1.add(score4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, -1, -1));

        bg4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bg_Rectangle1.png"))); // NOI18N
        jPanel1.add(bg4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, -1, -1));

        icon_peringkat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/peringkat.png"))); // NOI18N
        jPanel1.add(icon_peringkat, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, -1, -1));

        username5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        username5.setText("[USERNAME]");
        jPanel1.add(username5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 570, -1, -1));

        score5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        score5.setText("[SCORE]");
        jPanel1.add(score5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 570, -1, -1));

        bg5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bg_Rectangle2.png"))); // NOI18N
        jPanel1.add(bg5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, -1, -1));

        bg_leaderboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/BG-Pop Up-leaderboard.png"))); // NOI18N
        jPanel1.add(bg_leaderboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 631, 686));

        javax.swing.GroupLayout rSPanelImage2Layout = new javax.swing.GroupLayout(rSPanelImage2);
        rSPanelImage2.setLayout(rSPanelImage2Layout);
        rSPanelImage2Layout.setHorizontalGroup(
            rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelImage2Layout.createSequentialGroup()
                .addContainerGap(432, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );
        rSPanelImage2Layout.setVerticalGroup(
            rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelImage2Layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(rSPanelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_homeActionPerformed
        // TODO add your handling code here:
        LoginMenu menu = new LoginMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button_homeActionPerformed

    private void button_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_backActionPerformed
        // TODO add your handling code here:
        SucceedGameFrame s = new SucceedGameFrame(newName, newMarks, newGameType, newId);
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button_backActionPerformed

    private void button_tryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tryActionPerformed
        // TODO add your handling code here:
        new ChooseGame(newName).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button_tryActionPerformed

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
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Leaderboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg1;
    private javax.swing.JLabel bg2;
    private javax.swing.JLabel bg3;
    private javax.swing.JLabel bg4;
    private javax.swing.JLabel bg5;
    private javax.swing.JLabel bg_leaderboard;
    private rojerusan.RSMaterialButtonRectangle button_back;
    private rojerusan.RSMaterialButtonRectangle button_home;
    private rojerusan.RSMaterialButtonRectangle button_try;
    private javax.swing.JLabel icon_back;
    private javax.swing.JLabel icon_peringkat;
    private javax.swing.JLabel icon_peringkat1;
    private javax.swing.JLabel icon_peringkat2;
    private javax.swing.JLabel icon_peringkat3;
    private javax.swing.JLabel icon_peringkat4;
    private javax.swing.JLabel icon_restart;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojerusan.RSPanelImage rSPanelImage2;
    private javax.swing.JLabel score1;
    private javax.swing.JLabel score2;
    private javax.swing.JLabel score3;
    private javax.swing.JLabel score4;
    private javax.swing.JLabel score5;
    private javax.swing.JLabel title_peringkat;
    private javax.swing.JLabel username1;
    private javax.swing.JLabel username2;
    private javax.swing.JLabel username3;
    private javax.swing.JLabel username4;
    private javax.swing.JLabel username5;
    // End of variables declaration//GEN-END:variables

}
