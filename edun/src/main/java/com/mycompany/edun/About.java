/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.edun;

import java.awt.Font;
import java.io.File;

/**
 *
 * @author nadiaag
 */
public class About extends javax.swing.JFrame {

    /**
     * Creates new form About
     */
    public About() {
        initComponents();
        try{
           // Add Customize Font 20 Black
           File fontButton = new File("src/main/resources/fonts/Nunito-Black.ttf");
           Font font_20 = Font.createFont(Font.TRUETYPE_FONT, fontButton).deriveFont(20f);
           txt_about.setFont(font_20);
           
           
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
        icon_close = new rojerusan.RSPanelImage();
        button_close = new rojerusan.RSMaterialButtonRectangle();
        icon_home = new rojerusan.RSPanelImage();
        button_Home = new rojerusan.RSMaterialButtonRectangle();
        txt_about = new javax.swing.JLabel();
        title_about = new javax.swing.JLabel();
        bg_about = new javax.swing.JLabel();
        rounded_line = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(12, 21, 47));
        setMaximumSize(new java.awt.Dimension(1440, 1024));
        setMinimumSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(12, 21, 47));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_close.setImagen(new javax.swing.ImageIcon(getClass().getResource("/assets/Icon-Close-White.png"))); // NOI18N
        jPanel1.add(icon_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 300, 30, 30));

        button_close.setBackground(new java.awt.Color(244, 63, 94));
        button_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icon-Home.png"))); // NOI18N
        button_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_closeActionPerformed(evt);
            }
        });
        jPanel1.add(button_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 280, 70, -1));

        icon_home.setImagen(new javax.swing.ImageIcon(getClass().getResource("/assets/Icon-Home.png"))); // NOI18N
        jPanel1.add(icon_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 30, 30));

        button_Home.setBackground(new java.awt.Color(2, 132, 199));
        button_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icon-Home.png"))); // NOI18N
        button_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_HomeActionPerformed(evt);
            }
        });
        jPanel1.add(button_Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 70, -1));

        txt_about.setFont(new java.awt.Font("Nunito", 1, 18)); // NOI18N
        txt_about.setForeground(new java.awt.Color(51, 65, 85));
        txt_about.setText("<html> eduN merupakan game edukasi <br>  dengan tampilan yang disesuaikan untuk anak-anak.<br><br> Game edukasi yang dimaksud antara lain,<br> seperti menyusun puzzle, memecahkan teka teki,<br> dan latihan soal dengan pilihan ganda. </html>");
        txt_about.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        txt_about.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        txt_about.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel1.add(txt_about, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, 430, 260));

        title_about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Title-About.png"))); // NOI18N
        jPanel1.add(title_about, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, -1, 100));

        bg_about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/BG-Pop-Up-About.png"))); // NOI18N
        jPanel1.add(bg_about, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 540, 390));

        rounded_line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/BG-Rounded-Line.png"))); // NOI18N
        jPanel1.add(rounded_line, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 900, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 2013, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_HomeActionPerformed
        // TODO add your handling code here:
        LoginMenu menu = new LoginMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button_HomeActionPerformed

    private void button_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_closeActionPerformed
        // TODO add your handling code here:
        LoginUser user = new LoginUser();
        user.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button_closeActionPerformed

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
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new About().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg_about;
    private rojerusan.RSMaterialButtonRectangle button_Home;
    private rojerusan.RSMaterialButtonRectangle button_close;
    private rojerusan.RSPanelImage icon_close;
    private rojerusan.RSPanelImage icon_home;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel rounded_line;
    private javax.swing.JLabel title_about;
    private javax.swing.JLabel txt_about;
    // End of variables declaration//GEN-END:variables
}
