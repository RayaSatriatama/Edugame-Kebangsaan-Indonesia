/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crosswordpuzzlegenerator;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 *
 * @author rayas
 */
public class DownQuestionPanel extends JPanel {

    private JTextArea downQuestions;

    public DownQuestionPanel() {
        setLayout(new BorderLayout());
        downQuestions = new JTextArea();
        downQuestions.setEditable(false);

        JPanel downPanel = new JPanel(new BorderLayout());
        downPanel.add(new JLabel("Pertanyaan Menurun"), BorderLayout.NORTH);
        downPanel.add(new JScrollPane(downQuestions), BorderLayout.CENTER);
        add(downPanel, BorderLayout.NORTH);
        setBackground(new Color(0, 0, 0, 0));
    }

    public void setDownQuestions(List<String> questions) {
        downQuestions.setText(String.join("\n", questions));
    }
}
