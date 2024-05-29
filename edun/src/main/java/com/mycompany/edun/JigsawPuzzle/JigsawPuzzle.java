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
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JigsawPuzzle extends JPanel {
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
    private JButton resetButton;
    private boolean puzzleCompleted = false;

    public JigsawPuzzle() {
        image = loadRandomImage("src/main/resources/assets/JigsawPuzzleImages/");
        if (image != null) {
            image = resizeAndPadImage(image, 600, 600);
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

            setLayout(null);
            setSize(image.getWidth() * 2 + borderSize * 2 + 16, image.getHeight() + borderSize * 2 + 39);

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

            resetButton = new JButton("Shuffle");
            resetButton.setBounds(10, getHeight() - 50, 100, 30);
            resetButton.addActionListener(e -> shufflePieces());
            add(resetButton);
        } else {
            System.err.println("Failed to load the image.");
        }
    }

    private BufferedImage loadRandomImage(String directoryPath) {
        File dir = new File(directoryPath);
        File[] files = dir.listFiles((d, name) -> name.endsWith(".jpg") || name.endsWith(".png"));
        if (files != null && files.length > 0) {
            int randomIndex = new Random().nextInt(files.length);
            try {
                return ImageIO.read(files[randomIndex]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private BufferedImage resizeAndPadImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();
        double scale = Math.min((double) targetWidth / originalWidth, (double) targetHeight / originalHeight);
        int newWidth = (int) (originalWidth * scale);
        int newHeight = (int) (originalHeight * scale);

        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        BufferedImage paddedImage = new BufferedImage(targetWidth, targetHeight, originalImage.getType());
        g2d = paddedImage.createGraphics();
        int x = (targetWidth - newWidth) / 2;
        int y = (targetHeight - newHeight) / 2;
        g2d.setColor(Color.WHITE);  // You can choose any color for padding
        g2d.fillRect(0, 0, targetWidth, targetHeight);
        g2d.drawImage(resizedImage, x, y, null);
        g2d.dispose();

        return paddedImage;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    private void shufflePieces() {
        Collections.shuffle(pieces);
        for (PuzzlePiece piece : pieces) {
            int randomX = (int) (Math.random() * (getWidth() - puzzlePanel.getWidth() - pieceWidth - borderSize * 2) + puzzlePanel.getWidth() + borderSize);
            int randomY = (int) (Math.random() * (getHeight() - pieceHeight - borderSize * 2) + borderSize);
            piece.setBounds(randomX, randomY, pieceWidth, pieceHeight);
            piece.setCurrentPosition(-1, -1); // Reset current position to ensure correct snapping
        }
        puzzlePanel.repaint();
        repaint();
    }

    public boolean isPuzzleCompleted() {
        return puzzleCompleted;
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
            puzzleCompleted = true;
        }
    }
}
