/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.edun.quiz;

import com.mycompany.edun.database.koneksi_db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ivanbesti
 */
public class SoalQuiz extends javax.swing.JFrame {
    public String username;
    public String questionID="1";
    public String answer;
    public int marks=0;
    
    public void answerCheck() {
        String studentAnswer = "";
        if (jRadioButton1.isSelected()) {
            studentAnswer = jRadioButton1.getText();
        } else if (jRadioButton2.isSelected()) {
            studentAnswer = jRadioButton2.getText();
        } else if (jRadioButton3.isSelected()) {
            studentAnswer = jRadioButton3.getText();
        } else if (jRadioButton4.isSelected()) {
            studentAnswer = jRadioButton4.getText();
        }

        if (studentAnswer.equals(answer)) {
            marks = marks + 1;
            String marks1 = String.valueOf(marks);
            jLabel7.setText(marks1);
        }

        // Change question number
        int questionID1 = Integer.parseInt(questionID);
        questionID1 = questionID1 + 1;
        questionID = String.valueOf(questionID1);
        
        // Clear jRadioButton
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);

        // Hide next button on last question
        if (questionID.equals("5")) {
            jButton2.setVisible(false);
        }

        // Load next question
        question();
    }
    public void question() {
            try {
           Connection con = (Connection)koneksi_db.konfigurasi_koneksiDB();
           Statement st = con.createStatement();
           ResultSet rs1 = st.executeQuery("SELECT * FROM questions WHERE id = " + questionID + ";");
           while (rs1.next()) {
               jLabel2.setText(rs1.getString(1));
               jLabel8.setText(rs1.getString(2));
               jRadioButton1.setText(rs1.getString(3));
               jRadioButton2.setText(rs1.getString(4));
               jRadioButton3.setText(rs1.getString(5));
               jRadioButton4.setText(rs1.getString(6));
               answer = rs1.getString(7);
           }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
    }
    }
    public void submit() {
        String username = jLabel5.getText();
        answerCheck();
        try {
            Connection con = (Connection)koneksi_db.konfigurasi_koneksiDB();

            String query = "UPDATE users SET marks = ? WHERE name = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, marks);
            pst.setString(2, username);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                String marks1 = String.valueOf(marks);
                setVisible(false);
                new SuccesfullySubmited(marks1).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error: Username not found.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Creates new form SoalQuiz
     */
    public SoalQuiz() throws SQLException {
        initComponents();
    }
    
    public SoalQuiz(String username) {
        initComponents();
        //First Question and username
        try {
            Connection con = (Connection)koneksi_db.konfigurasi_koneksiDB();
            String queryUser = "SELECT * FROM users WHERE name = ?";
            PreparedStatement pstUser = con.prepareStatement(queryUser);
            pstUser.setString(1, username);
            ResultSet rs = pstUser.executeQuery();
            while (rs.next()) {
            jLabel5.setText(rs.getString(2));
        }
            // Misalkan questionID sudah didefinisikan sebelumnya
        int questionID = 1; // atau ambil dari parameter atau sumber lain

        // Query untuk mendapatkan pertanyaan
        String queryQuestion = "SELECT * FROM questions WHERE id = ?";
        PreparedStatement pstQuestion = con.prepareStatement(queryQuestion);
        pstQuestion.setInt(1, questionID);
        ResultSet rs1 = pstQuestion.executeQuery();
        while (rs1.next()) {
            jLabel2.setText(rs1.getString(1));
            jLabel8.setText(rs1.getString(2));
            jRadioButton1.setText(rs1.getString(3));
            jRadioButton2.setText(rs1.getString(4));
            jRadioButton3.setText(rs1.getString(5));
            jRadioButton4.setText(rs1.getString(6));
            answer = rs1.getString(7);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 30)); // NOI18N
        jLabel1.setText("Soal Nomor:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 30)); // NOI18N
        jLabel2.setText("0");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        jRadioButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        jRadioButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, -1, -1));

        jRadioButton3.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jRadioButton3.setText("jRadioButton3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, -1, -1));

        jRadioButton4.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jRadioButton4.setText("jRadioButton4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, -1, -1));

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/save.png"))); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 570, -1, 40));

        jButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/next.png"))); // NOI18N
        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 570, -1, 40));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jLabel4.setText("Hi!");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jLabel5.setText("Ivan");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jLabel6.setText("Nilai Anda:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, -1, -1));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jLabel7.setText("00");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 100, -1, -1));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 3, 25)); // NOI18N
        jLabel8.setText("Pertanyaan");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/BG.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        answerCheck();
        question();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton1.isSelected()) {
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton4.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton2.isSelected()) {
            jRadioButton1.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton4.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
         if (jRadioButton3.isSelected()) {
            jRadioButton1.setSelected(false);
            jRadioButton2.setSelected(false);
            jRadioButton4.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton4.isSelected()) {
            jRadioButton1.setSelected(false);
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin untuk mengumpulkan jawaban?", "Pilih", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            answerCheck();
            submit();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SoalQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SoalQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SoalQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SoalQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SoalQuiz().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SoalQuiz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables
}
