/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crosswordpuzzlegenerator;

import java.awt.BorderLayout;
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
        statusLabel = new JLabel("Status: ");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(gridPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.NORTH);
    }

    public void generateCrosswordPuzzle() {
        gridPanel.generateCrosswordPuzzle();
        statusLabel.setText("Status: Puzzle generated. Start guessing!");
    }

    public void clearGrid() {
        gridPanel.clearGrid();
        statusLabel.setText("Status: Grid cleared.");
    }

    public boolean checkWord(String word) {
        boolean correct = gridPanel.checkWord(word);
        if (correct) {
            statusLabel.setText("Status: Correct! Keep going.");
            if (gridPanel.isPuzzleCompleted()) {
                statusLabel.setText("Status: Congratulations! You completed the puzzle.");
            }
        } else {
            statusLabel.setText("Status: Incorrect. Try again.");
        }
        return correct;
    }

    public List<Word> getPlacedWords() {
        return gridPanel.getPlacedWords();
    }

    public List<String> getAcrossQuestions() {
        return gridPanel.getBestGrid().getAcrossQuestions();
    }

    public List<String> getDownQuestions() {
        return gridPanel.getBestGrid().getDownQuestions();
    }

    public int getCorrectAnswers() {
        return gridPanel.getCorrectAnswers();
    }

}
