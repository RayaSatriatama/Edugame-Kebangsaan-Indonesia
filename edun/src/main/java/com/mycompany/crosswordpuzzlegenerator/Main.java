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

public class Main {
    private static final int gridSize = 20;
    private static JButton[][] gridButtons = new JButton[gridSize][gridSize];
    private static char[][] solutionGrid = new char[gridSize][gridSize];
    private static JTextField answerField = new JTextField(20);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Crossword Puzzle Generator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 700);
            frame.setLayout(new BorderLayout());

            JPanel gridPanel = new JPanel();
            gridPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            // Add column labels
            for (int col = 0; col < gridSize; col++) {
                JLabel colLabel = new JLabel(String.valueOf(col + 1));
                gbc.gridx = col + 1;
                gbc.gridy = 0;
                gridPanel.add(colLabel, gbc);
            }

            // Add row labels and buttons
            for (int row = 0; row < gridSize; row++) {
                JLabel rowLabel = new JLabel(String.valueOf(row + 1));
                gbc.gridx = 0;
                gbc.gridy = row + 1;
                gridPanel.add(rowLabel, gbc);
                for (int col = 0; col < gridSize; col++) {
                    JButton button = new JButton();
                    button.setEnabled(false);
                    button.setBackground(Color.LIGHT_GRAY);
                    gridButtons[row][col] = button;
                    gbc.gridx = col + 1;
                    gbc.gridy = row + 1;
                    gridPanel.add(button, gbc);
                }
            }

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

            JButton submitButton = new JButton("Submit Answer");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkAnswer();
                }
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(generateButton);
            buttonPanel.add(clearButton);

            JPanel answerPanel = new JPanel();
            answerPanel.add(new JLabel("Enter Answer:"));
            answerPanel.add(answerField);
            answerPanel.add(submitButton);

            frame.add(gridPanel, BorderLayout.CENTER);
            frame.add(buttonPanel, BorderLayout.NORTH);
            frame.add(answerPanel, BorderLayout.SOUTH);
            frame.setVisible(true);
        });
    }

    private static void generateCrosswordPuzzle() {
        try {
            CrosswordPuzzleGenerator generator = new CrosswordPuzzleGenerator();
            CrosswordPuzzle bestGrid = generator.createCrossWordPuzzle();

            solutionGrid = bestGrid.getGrid();
            for (int row = 0; row < gridSize; ++row) {
                for (int column = 0; column < gridSize; ++column) {
                    gridButtons[row][column].setText("");
                    if (bestGrid.isLetter(row, column)) {
                        gridButtons[row][column].setBackground(Color.WHITE);
                    } else {
                        gridButtons[row][column].setBackground(Color.LIGHT_GRAY);
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred while generating the puzzle.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void clearGrid() {
        for (int row = 0; row < gridSize; ++row) {
            for (int column = 0; column < gridSize; ++column) {
                gridButtons[row][column].setText("");
                gridButtons[row][column].setBackground(Color.LIGHT_GRAY);
            }
        }
        answerField.setText("");
    }

    private static void checkAnswer() {
        String answer = answerField.getText().trim().toLowerCase();
        boolean correct = true;

        for (int row = 0; row < gridSize; ++row) {
            for (int column = 0; column < gridSize; ++column) {
                if (solutionGrid[row][column] != '_' && answer.indexOf(solutionGrid[row][column]) >= 0) {
                    gridButtons[row][column].setText(String.valueOf(solutionGrid[row][column]));
                } else if (solutionGrid[row][column] != '_') {
                    correct = false;
                }
            }
        }

        if (correct) {
            JOptionPane.showMessageDialog(null, "Congratulations! Your answer is correct.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect answer. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}