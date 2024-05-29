/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.edun.JigsawPuzzle;

/**
 *
 * @author rayas
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JigsawPuzzle extends JFrame {
    Random r = new Random();
    int low = 4;
    int high = 5;
    int randomResult = r.nextInt(high - low) + low;
    private BufferedImage image;
    private int rows = randomResult;
    private int cols = randomResult;
    private int pieceWidth;
    private int pieceHeight;
    private ArrayList<PuzzlePiece> pieces;
    PuzzlePiece[][] grid;
    JPanel puzzlePanel;
    private int borderSize = 10;

    public JigsawPuzzle() {
        image = ImageLoader.loadImage("src/main/resources/assets/JigsawPuzzleImages/puzzle.jpg");
        if (image != null) {
            pieceWidth = image.getWidth() / cols;
            pieceHeight = image.getHeight() / rows;
            pieces = new ArrayList<>();
            grid = new PuzzlePiece[rows][cols];

            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {
                    BufferedImage subImage = image.getSubimage(x * pieceWidth, y * pieceHeight, pieceWidth, pieceHeight);
                    PuzzlePiece piece = new PuzzlePiece(subImage, x, y, pieceWidth, pieceHeight, this);
                    pieces.add(piece);
                    grid[y][x] = piece;
                }
            }

            Collections.shuffle(pieces);

            setTitle("Jigsaw Puzzle");
            setSize(image.getWidth() * 2 + borderSize * 2 + 16, image.getHeight() + borderSize * 2 + 39);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);

            puzzlePanel = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.BLACK);
                    g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
                }
            };
            puzzlePanel.setBounds(borderSize, borderSize, image.getWidth(), image.getHeight());
            add(puzzlePanel);

            for (PuzzlePiece piece : pieces) {
                int randomX = (int) (Math.random() * (getWidth() - puzzlePanel.getWidth() - pieceWidth - borderSize * 2) + puzzlePanel.getWidth() + borderSize);
                int randomY = (int) (Math.random() * (getHeight() - pieceHeight - borderSize * 2) + borderSize);
                piece.setBounds(randomX, randomY, pieceWidth, pieceHeight);
                piece.setCurrentPosition(-1, -1); // Reset current position to ensure correct snapping
                add(piece);
            }

            setVisible(true);
        } else {
            System.err.println("Failed to load the image.");
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void checkCompletion() {
        int correctlyPlacedCount = 0;
        for (PuzzlePiece[] row : grid) {
            for (PuzzlePiece piece : row) {
                if (piece.isCorrectlyPlaced()) {
                    correctlyPlacedCount++;
                }
            }
        }

        if (correctlyPlacedCount == rows * cols) {
            JOptionPane.showMessageDialog(this, "Puzzle Completed! All pieces are correctly placed.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JigsawPuzzle());
    }
}
