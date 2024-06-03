/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crosswordpuzzlegenerator;

/**
 *
 * @author rayas
 */

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class GridPanel extends JPanel {
    private static final int gridSize = 20;
    private static final int cellSize = 30; // Configurable grid cell size
    private static JLabel[][] gridLabels = new JLabel[gridSize][gridSize];
    private static CrosswordPuzzle bestGrid;
    private static Set<String> correctWords = new HashSet<>();

    public GridPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(new Color(0, 0, 0, 0)); // Make the background transparent

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                JLabel label = new JLabel("", SwingConstants.CENTER);
                label.setPreferredSize(new Dimension(cellSize, cellSize));
                label.setOpaque(true);
                label.setBackground(null);
                label.setBorder(null);
                gridLabels[row][col] = label;
                gbc.gridx = col;
                gbc.gridy = row;
                gbc.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                add(label, gbc);
            }
        }
    }

    public void generateCrosswordPuzzle() {
        try {
            CrosswordPuzzleGenerator generator = new CrosswordPuzzleGenerator();
            bestGrid = generator.createCrossWordPuzzle();
            correctWords.clear();

            char[][] grid = bestGrid.getGrid();
            for (int row = 0; row < gridSize; ++row) {
                for (int column = 0; column < gridSize; ++column) {
                    if (grid[row][column] != '_') {
                        gridLabels[row][column].setOpaque(true);
                        gridLabels[row][column].setBackground(Color.WHITE); // Indicate cells to be filled
                        gridLabels[row][column].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    } else {
                        gridLabels[row][column].setOpaque(false);
                        gridLabels[row][column].setBackground(null);
                        gridLabels[row][column].setBorder(null);
                    }
                    gridLabels[row][column].setText("");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred while generating the puzzle.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void clearGrid() {
        for (int row = 0; row < gridSize; ++row) {
            for (int column = 0; column < gridSize; ++column) {
                gridLabels[row][column].setOpaque(false);
                gridLabels[row][column].setText("");
                gridLabels[row][column].setBackground(null);
                gridLabels[row][column].setBorder(null);
            }
        }
        correctWords.clear();
    }

    public boolean checkWord(String inputWord) {
        boolean found = false;
        for (Word word : bestGrid.getWords()) {
            if (word.getText().equalsIgnoreCase(inputWord) && !correctWords.contains(inputWord)) {
                correctWords.add(inputWord);
                revealWord(word);
                found = true;
            }
        }
        return found;
    }

    private void revealWord(Word word) {
        int row = word.getRow();
        int column = word.getColumn();

        for (int i = 0; i < word.getText().length(); i++) {
            if (word.isVertical()) {
                gridLabels[row + i][column].setText(String.valueOf(word.getText().charAt(i)));
                gridLabels[row + i][column].setBackground(Color.WHITE);
            } else {
                gridLabels[row][column + i].setText(String.valueOf(word.getText().charAt(i)));
                gridLabels[row][column + i].setBackground(Color.WHITE);
            }
        }
    }

    public boolean isPuzzleCompleted() {
        return correctWords.size() == bestGrid.getWords().size();
    }
}

