/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edun.crosswordpuzzle;

/**
 *
 * @author rayas
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GridPanel extends JPanel {

    private static final int gridSize = 12;
    private static final int cellSize = 30;
    private static JLabel[][] gridLabels = new JLabel[gridSize][gridSize];
    private static CrosswordPuzzle bestGrid;
    private static Set<String> correctWords = new HashSet<>();

    public GridPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(new Color(0, 0, 0, 0));

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
                gbc.fill = GridBagConstraints.BOTH;
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
            int[][] numberGrid = bestGrid.getNumberGrid();
            for (int row = 0; row < gridSize; ++row) {
                for (int column = 0; column < gridSize; ++column) {
                    if (grid[row][column] != '_') {
                        gridLabels[row][column].setOpaque(true);
                        gridLabels[row][column].setBackground(Color.WHITE);
                        gridLabels[row][column].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    } else {
                        gridLabels[row][column].setOpaque(false);
                        gridLabels[row][column].setBackground(null);
                        gridLabels[row][column].setBorder(null);
                    }
                    if (numberGrid[row][column] != 0) {
                        gridLabels[row][column].setText("<html><font size='2'>" + numberGrid[row][column] + "</font></html>");
                    } else {
                        gridLabels[row][column].setText("");
                    }
                }
            }
            bestGrid.printGrid();
            bestGrid.printPlacedWords();
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
        bestGrid.printGrid();
        bestGrid.printPlacedWords();
        for (Word word : bestGrid.getPlacedWords()) {
            if (word.getText().equals(inputWord) && !correctWords.contains(inputWord)) {
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
        return correctWords.size() == bestGrid.getPlacedWords().size();
    }

    public List<Word> getPlacedWords() {
        if (bestGrid == null) {
            return new ArrayList<>();
        }
        return bestGrid.getPlacedWords();
    }

    public CrosswordPuzzle getBestGrid() {
        return bestGrid;
    }

    public int getCorrectAnswers() {
        return correctWords.size();
    }

}
