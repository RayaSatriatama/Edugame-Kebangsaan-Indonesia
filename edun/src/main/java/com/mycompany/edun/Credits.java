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
public class Credits extends javax.swing.JFrame {

    /**
     * Creates new form Credits
     */
    public Credits() {
        initComponents();
        try {
            File fontButton = new File("src/main/resources/fonts/Nunito-Black.ttf");
            Font font_20 = Font.createFont(Font.TRUETYPE_FONT, fontButton).deriveFont(20f);
            txt_credits.setFont(font_20);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        icon_close = new rojerusan.RSPanelImage();
        button_close = new rojerusan.RSMaterialButtonRectangle();
        icon_home = new rojerusan.RSPanelImage();
        button_Home = new rojerusan.RSMaterialButtonRectangle();
        txt_credits = new javax.swing.JLabel();
        title_credits = new javax.swing.JLabel();
        bg_credits = new javax.swing.JLabel();
        rounded_line = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(12, 21, 47));
        jPanel2.setMinimumSize(new java.awt.Dimension(1440, 1024));
        jPanel2.setPreferredSize(new java.awt.Dimension(1440, 1024));

        jPanel1.setBackground(new java.awt.Color(12, 21, 47));
        jPanel1.setMinimumSize(new java.awt.Dimension(1440, 1024));
        jPanel1.setPreferredSize(new java.awt.Dimension(1440, 1024));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_close.setImagen(new javax.swing.ImageIcon(getClass().getResource("/assets/Icon-Close-White.png"))); // NOI18N
        jPanel1.add(icon_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 220, 30, 30));

        button_close.setBackground(new java.awt.Color(244, 63, 94));
        button_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icon-Home.png"))); // NOI18N
        button_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_closeActionPerformed(evt);
            }
        });
        jPanel1.add(button_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 200, 70, -1));

        icon_home.setImagen(new javax.swing.ImageIcon(getClass().getResource("/assets/Icon-Home.png"))); // NOI18N
        jPanel1.add(icon_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 30, 30));

        button_Home.setBackground(new java.awt.Color(2, 132, 199));
        button_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icon-Home.png"))); // NOI18N
        button_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_HomeActionPerformed(evt);
            }
        });
        jPanel1.add(button_Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 70, -1));

        txt_credits.setFont(new java.awt.Font("Nunito", 1, 18)); // NOI18N
        txt_credits.setForeground(new java.awt.Color(100, 116, 139));
        txt_credits.setText("<html> \neduN dirancang oleh:<br>\n<span style=\"color: #1E40AF;\">\nIvan Jaelani Besti<br>\nLusi Alifatul Laila<br>\nM. Raya Satriatama<br>\nNadia Aqmarina Ghaisany<br><br>\n</span>\n\nGame ini dirancang untuk memenuhi ujian pada mata kuliah PBO dengan dosen pengampu:<br><br>\n<span style=\"color: #1E40AF;\">Hendriyana, S. T., M. Kom.</span>\n</html>");
        txt_credits.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(txt_credits, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 430, 370));

        title_credits.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Title-Credit.png"))); // NOI18N
        jPanel1.add(title_credits, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, -1, 100));

        bg_credits.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/BG-Pop-Up-Credit.png"))); // NOI18N
        jPanel1.add(bg_credits, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 540, 520));

        rounded_line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/BG-Rounded-Line.png"))); // NOI18N
        jPanel1.add(rounded_line, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 900, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_closeActionPerformed
        // TODO add your handling code here:
        LoginUser user = new LoginUser();
        user.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button_closeActionPerformed

    private void button_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_HomeActionPerformed
        // TODO add your handling code here:
        LoginMenu menu = new LoginMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button_HomeActionPerformed

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
            java.util.logging.Logger.getLogger(Credits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Credits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Credits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Credits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Credits().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg_credits;
    private rojerusan.RSMaterialButtonRectangle button_Home;
    private rojerusan.RSMaterialButtonRectangle button_close;
    private rojerusan.RSPanelImage icon_close;
    private rojerusan.RSPanelImage icon_home;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel rounded_line;
    private javax.swing.JLabel title_credits;
    private javax.swing.JLabel txt_credits;
    // End of variables declaration//GEN-END:variables
}
