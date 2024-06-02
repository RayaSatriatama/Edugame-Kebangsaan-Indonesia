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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static final int gridSize = 20;
    private static final int cellSize = 30; // Configurable grid cell size
    private static JButton[][] gridButtons = new JButton[gridSize][gridSize];
    private static CrosswordPuzzle bestGrid;
    private static Set<String> correctWords = new HashSet<>();
    private static JTextField inputField;
    private static JLabel statusLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Crossword Puzzle Generator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 750);
            frame.setLayout(new BorderLayout());

            JPanel gridPanel = new JPanel();
            gridPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            for (int row = 0; row < gridSize; row++) {
                for (int col = 0; col < gridSize; col++) {
                    JButton button = new JButton();
                    button.setPreferredSize(new Dimension(cellSize, cellSize));
                    button.setEnabled(false);
                    button.setBackground(Color.LIGHT_GRAY);
                    button.setBorder(null);
                    gridButtons[row][col] = button;
                    gbc.gridx = col;
                    gbc.gridy = row;
                    gridPanel.add(button, gbc);
                }
            }

            inputField = new JTextField(20);
            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkWord();
                }
            });

            JButton generateButton = new JButton("Generate Crossword Puzzle");
            generateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    generateCrosswordPuzzle();
                }
            });

            JButton clearButton = new JButton("Clear");
            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clearGrid();
                }
            });

            JPanel controlPanel = new JPanel();
            controlPanel.add(new JLabel("Enter a word:"));
            controlPanel.add(inputField);
            controlPanel.add(submitButton);
            controlPanel.add(generateButton);
            controlPanel.add(clearButton);

            statusLabel = new JLabel("Status: ");
            frame.add(gridPanel, BorderLayout.CENTER);
            frame.add(controlPanel, BorderLayout.SOUTH);
            frame.add(statusLabel, BorderLayout.NORTH);
            frame.setVisible(true);
        });
    }

    private static void generateCrosswordPuzzle() {
        try {
            CrosswordPuzzleGenerator generator = new CrosswordPuzzleGenerator();
            bestGrid = generator.createCrossWordPuzzle();
            correctWords.clear();

            char[][] grid = bestGrid.getGrid();
            for (int row = 0; row < gridSize; ++row) {
                for (int column = 0; column < gridSize; ++column) {
                    if (grid[row][column] != '_') {
                        gridButtons[row][column].setBackground(Color.WHITE);
                        gridButtons[row][column].setEnabled(true);
                        gridButtons[row][column].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    } else {
                        gridButtons[row][column].setOpaque(false);
                        gridButtons[row][column].setEnabled(false);
                        gridButtons[row][column].setBorder(null);
                    }
                    gridButtons[row][column].setText("");
                }
            }

            statusLabel.setText("Status: Puzzle generated. Start guessing!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred while generating the puzzle.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void clearGrid() {
        for (int row = 0; row < gridSize; ++row) {
            for (int column = 0; column < gridSize; ++column) {
                gridButtons[row][column].setText("");
                gridButtons[row][column].setBackground(Color.LIGHT_GRAY);
                gridButtons[row][column].setEnabled(false);
                gridButtons[row][column].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Make border invisible
            }
        }
        correctWords.clear();
        statusLabel.setText("Status: Grid cleared.");
    }

    private static void checkWord() {
        String inputWord = inputField.getText().trim().toLowerCase();
        if (inputWord.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a word.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean found = false;
        for (Word word : bestGrid.getWords()) {
            if (word.getText().equalsIgnoreCase(inputWord) && !correctWords.contains(inputWord)) {
                correctWords.add(inputWord);
                revealWord(word);
                found = true;
            }
        }

        if (found) {
            statusLabel.setText("Status: Correct! Keep going.");
            if (correctWords.size() == bestGrid.getWords().size()) {
                statusLabel.setText("Status: Congratulations! You completed the puzzle.");
            }
        } else {
            statusLabel.setText("Status: Incorrect. Try again.");
        }

        inputField.setText("");
    }

    private static void revealWord(Word word) {
        int row = word.getRow();
        int column = word.getColumn();

        for (int i = 0; i < word.getText().length(); i++) {
            if (word.isVertical()) {
                gridButtons[row + i][column].setText(String.valueOf(word.getText().charAt(i)));
                gridButtons[row + i][column].setBackground(Color.WHITE);
            } else {
                gridButtons[row][column + i].setText(String.valueOf(word.getText().charAt(i)));
                gridButtons[row][column + i].setBackground(Color.WHITE);
            }
        }
    }
}
