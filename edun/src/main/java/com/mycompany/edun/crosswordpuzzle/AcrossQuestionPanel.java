/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edun.crosswordpuzzle;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 *
 * @author rayas
 */

public class AcrossQuestionPanel extends JPanel {

    private JTextArea acrossQuestions;

    public AcrossQuestionPanel() {
        setLayout(new BorderLayout());
        acrossQuestions = new JTextArea();
        acrossQuestions.setEditable(false);

        JPanel acrossPanel = new JPanel(new BorderLayout());
        acrossPanel.add(new JLabel("Pertanyaan Mendatar"), BorderLayout.CENTER);
        acrossPanel.add(new JScrollPane(acrossQuestions), BorderLayout.CENTER);
        add(acrossPanel, BorderLayout.CENTER);
        setBackground(new Color(0, 0, 0, 0));
    }

    public void setAcrossQuestions(List<String> questions) {
        acrossQuestions.setText(String.join("\n", questions));
    }
}
