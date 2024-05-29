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
    int randomResult = r.nextInt(high-low) + low;
    private BufferedImage image; // The puzzle image
    private int rows = randomResult; // Number of rows in the puzzle
    private int cols = randomResult; // Number of columns in the puzzle
    private int pieceWidth; // Width of each puzzle piece
    private int pieceHeight; // Height of each puzzle piece
    private ArrayList<PuzzlePiece> pieces; // List of puzzle pieces
    PuzzlePiece[][] grid; // Grid to track piece positions
    JPanel puzzlePanel; // Panel to hold the puzzle pieces
    private int borderSize = 10; // Border size for the puzzle area

    public JigsawPuzzle() {
        // Load the puzzle image
        image = ImageLoader.loadImage("src/main/resources/assets/JigsawPuzzleImages/puzzle.jpg");
           if (image != null) {
            // Calculate the width and height of each piece
            pieceWidth = image.getWidth() / cols;
            pieceHeight = image.getHeight() / rows;
            pieces = new ArrayList<>();
            grid = new PuzzlePiece[rows][cols];

            // Split the image into pieces and add to the pieces list
            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {
                    BufferedImage subImage = image.getSubimage(x * pieceWidth, y * pieceHeight, pieceWidth, pieceHeight);
                    PuzzlePiece piece = new PuzzlePiece(subImage, x, y, pieceWidth, pieceHeight, this);
                    pieces.add(piece);
                    grid[y][x] = piece; // Initially place pieces in their correct positions
                }
            }

            // Shuffle pieces to randomize their positions
            Collections.shuffle(pieces);

            // Set up the JFrame
            setTitle("Jigsaw Puzzle");
            setSize(image.getWidth() * 2 + borderSize * 2 + 16, image.getHeight() + borderSize * 2 + 39);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);

            // Create a panel for the puzzle area
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

            // Place pieces at random locations within the new frame, but outside the puzzle area
            for (PuzzlePiece piece : pieces) {
                int randomX = (int) (Math.random() * (getWidth() - puzzlePanel.getWidth() - pieceWidth - borderSize * 2) + puzzlePanel.getWidth() + borderSize);
                int randomY = (int) (Math.random() * (getHeight() - pieceHeight - borderSize * 2) + borderSize);
                piece.setBounds(randomX, randomY, pieceWidth, pieceHeight);
                add(piece); // Add pieces to the JFrame, not the puzzlePanel
            }

            setVisible(true);
        } else {
            System.err.println("Failed to load the image.");
        }
    }

    // Swap the positions of two puzzle pieces
    public void swapPieces(PuzzlePiece piece1, PuzzlePiece piece2) {
        // Only swap if neither piece is locked
        if (!piece1.isLocked() && !piece2.isLocked()) {
            int tempX = piece1.getCurrentX();
            int tempY = piece1.getCurrentY();

            piece1.setCurrentPosition(piece2.getCurrentX(), piece2.getCurrentY());
            piece2.setCurrentPosition(tempX, tempY);

            grid[piece1.getCurrentY()][piece1.getCurrentX()] = piece1;
            grid[piece2.getCurrentY()][piece2.getCurrentX()] = piece2;

            piece1.setBounds(piece1.getCurrentX() * pieceWidth, piece1.getCurrentY() * pieceHeight, pieceWidth, pieceHeight);
            piece2.setBounds(piece2.getCurrentX() * pieceWidth, piece2.getCurrentY() * pieceHeight, pieceWidth, pieceHeight);

            // Lock pieces if they are in the correct place after swap
            piece1.checkAndLock();
            piece2.checkAndLock();

            // Check if the puzzle is completed
            checkCompletion();
        }
    }

    // Check if all pieces are correctly placed
    public void checkCompletion() {
        boolean completed = true;
        for (PuzzlePiece[] row : grid) {
            for (PuzzlePiece piece : row) {
                if (!piece.isCorrectlyPlaced()) {
                    completed = false;
                    break;
                }
            }
        }

        if (completed) {
            JOptionPane.showMessageDialog(this, "Puzzle Completed!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JigsawPuzzle());
    }
}