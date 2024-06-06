/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crosswordpuzzlegenerator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author rayas
 */

public class CrosswordPuzzlePanel extends JPanel {
    private GridPanel gridPanel;
    private JLabel statusLabel;

    public CrosswordPuzzlePanel() {
        setLayout(new BorderLayout());

        gridPanel = new GridPanel();
        statusLabel = new JLabel("");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);

        add(gridPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.NORTH);
        setBackground(new Color(0, 0, 0, 0));
        statusLabel.setBackground(new Color(0, 0, 0, 0));
    }

    public void generateCrosswordPuzzle() {
        gridPanel.generateCrosswordPuzzle();
        statusLabel.setText("Mulai Mengisi!");
    }

    public void clearGrid() {
        gridPanel.clearGrid();
        statusLabel.setText("Grid cleared.");
    }

    public boolean checkWord(String word) {
        boolean correct = gridPanel.checkWord(word);
        if (correct) {
            statusLabel.setText("Jawaban Kamu benar, Lanjutkan !");
            if (gridPanel.isPuzzleCompleted()) {
                statusLabel.setText("Selamat! Kamu Berhasil Menyelesaikan TTS!");
            }
        } else {
            statusLabel.setText("Salah Coba Lagi");
        }
        return correct;
    }

    public List<Word> getPlacedWords() {
        return gridPanel.getPlacedWords();
    }
}
