/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrosswordPuzzle;

/**
 *
 * @author rayas
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TTSGame extends JFrame {
    private JTextField inputField;
    private JPanel gridPanel;
    private TTSGenerator ttsGenerator;
    private List<Crossword> crosswords;
    private char[][] currentGrid;
    private JLabel[][] gridLabels;

    public TTSGame() {
        CrosswordDAO dao = new CrosswordDAO();
        crosswords = dao.getCrosswords();
        ttsGenerator = new TTSGenerator(crosswords, 10);

        setTitle("TTS Game");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        currentGrid = ttsGenerator.getGrid();
        gridPanel = new JPanel(new GridLayout(currentGrid.length, currentGrid.length));
        gridLabels = new JLabel[currentGrid.length][currentGrid.length];
        updateGrid();

        inputField = new JTextField(20);
        JButton checkButton = new JButton("Check");
        checkButton.addActionListener(new CheckAnswerListener());

        JPanel inputPanel = new JPanel();
        inputPanel.add(inputField);
        inputPanel.add(checkButton);

        add(gridPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }

    private void updateGrid() {
        gridPanel.removeAll();
        for (int i = 0; i < currentGrid.length; i++) {
            for (int j = 0; j < currentGrid[i].length; j++) {
                JLabel label = new JLabel(String.valueOf(currentGrid[i][j]));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setFont(new Font("Monospaced", Font.PLAIN, 18));
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                gridPanel.add(label);
                gridLabels[i][j] = label;
            }
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    private void highlightWord(String word, int row, int col, boolean horizontal) {
        if (horizontal) {
            for (int i = 0; i < word.length(); i++) {
                gridLabels[row][col + i].setOpaque(true);
                gridLabels[row][col + i].setBackground(Color.YELLOW);
            }
        } else {
            for (int i = 0; i < word.length(); i++) {
                gridLabels[row + i][col].setOpaque(true);
                gridLabels[row + i][col].setBackground(Color.YELLOW);
            }
        }
    }

    private boolean findAndHighlightWord(String word) {
        word = word.toUpperCase();
        for (int i = 0; i < currentGrid.length; i++) {
            for (int j = 0; j < currentGrid[i].length; j++) {
                if (canPlaceWord(word, i, j, true)) {
                    highlightWord(word, i, j, true);
                    return true;
                }
                if (canPlaceWord(word, i, j, false)) {
                    highlightWord(word, i, j, false);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canPlaceWord(String word, int row, int col, boolean horizontal) {
        if (horizontal) {
            if (col + word.length() > currentGrid.length) return false;
            for (int i = 0; i < word.length(); i++) {
                if (currentGrid[row][col + i] != word.charAt(i)) return false;
            }
        } else {
            if (row + word.length() > currentGrid.length) return false;
            for (int i = 0; i < word.length(); i++) {
                if (currentGrid[row + i][col] != word.charAt(i)) return false;
            }
        }
        return true;
    }

    private class CheckAnswerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputField.getText().toUpperCase();
            boolean found = false;

            for (Crossword crossword : crosswords) {
                if (crossword.getAnswer().equalsIgnoreCase(input)) {
                    found = true;
                    break;
                }
            }

            if (found && findAndHighlightWord(input)) {
                JOptionPane.showMessageDialog(TTSGame.this, "Correct!");
            } else {
                JOptionPane.showMessageDialog(TTSGame.this, "Incorrect, try again.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TTSGame game = new TTSGame();
            game.setVisible(true);
        });
    }
}