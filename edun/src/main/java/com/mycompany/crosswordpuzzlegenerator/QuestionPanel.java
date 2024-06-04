/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crosswordpuzzlegenerator;

/**
 *
 * @author rayas
 */
// File: QuestionPanel.java
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class QuestionPanel extends JPanel {
//    private JTextArea acrossQuestions;
    private JTextArea downQuestions;

    public QuestionPanel() {
        setLayout(new BorderLayout());

//        acrossQuestions = new JTextArea();
        downQuestions = new JTextArea();

//        acrossQuestions.setEditable(false);
        downQuestions.setEditable(false);

//        JPanel acrossPanel = new JPanel(new BorderLayout());
//        acrossPanel.add(new JLabel("Across"), BorderLayout.NORTH);
//        acrossPanel.add(new JScrollPane(acrossQuestions), BorderLayout.CENTER);

        JPanel downPanel = new JPanel(new BorderLayout());
        downPanel.add(new JLabel("Down"), BorderLayout.NORTH);
        downPanel.add(new JScrollPane(downQuestions), BorderLayout.CENTER);

//        add(acrossPanel, BorderLayout.NORTH);
        add(downPanel, BorderLayout.NORTH);
    }

//    public void setAcrossQuestions(List<String> questions) {
//        acrossQuestions.setText(String.join("\n", questions));
//    }

    public void setDownQuestions(List<String> questions) {
        downQuestions.setText(String.join("\n", questions));
    }
}

