/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edun;

/**
 *
 * @author rayas
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class TimeOutFrame extends JFrame {
    
    public TimeOutFrame() {
        setTitle("Time Out");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel label = new JLabel("Time is up! Please try again.");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setHorizontalAlignment(JLabel.CENTER);
        
        add(label);
    }
}
