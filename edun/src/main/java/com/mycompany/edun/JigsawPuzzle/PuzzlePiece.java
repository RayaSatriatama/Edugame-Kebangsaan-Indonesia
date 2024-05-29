/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edun.JigsawPuzzle;

/**
 *
 * @author rayas
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class PuzzlePiece extends JButton {
    private BufferedImage image; // Image of the puzzle piece
    private int originalX; // Original x-coordinate of the piece
    private int originalY; // Original y-coordinate of the piece
    private int pieceWidth; // Width of the piece
    private int pieceHeight; // Height of the piece
    private Point anchorPoint; // Point where the mouse is anchored during dragging
    private int currentX; // Current x-coordinate in the grid
    private int currentY; // Current y-coordinate in the grid
    private boolean locked; // Whether the piece is locked in place
    private JigsawPuzzle puzzle; // Reference to the main puzzle

    public PuzzlePiece(BufferedImage image, int originalX, int originalY, int pieceWidth, int pieceHeight, JigsawPuzzle puzzle) {
        this.image = image;
        this.originalX = originalX;
        this.originalY = originalY;
        this.pieceWidth = pieceWidth;
        this.pieceHeight = pieceHeight;
        this.puzzle = puzzle;
        this.currentX = originalX;
        this.currentY = originalY;
        this.locked = false;

        setIcon(new ImageIcon(image)); // Set the icon of the button to the piece image

        // Add drag listeners for the piece
        addDragListeners();
    }

    private void addDragListeners() {
        final PuzzlePiece handle = this;
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (!locked) {
                    anchorPoint = e.getPoint();
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (!locked) {
                    int anchorX = anchorPoint.x;
                    int anchorY = anchorPoint.y;

                    Point parentOnScreen = getParent().getLocationOnScreen();
                    Point mouseOnScreen = e.getLocationOnScreen();
                    Point position = new Point(mouseOnScreen.x - parentOnScreen.x - anchorX, mouseOnScreen.y - parentOnScreen.y - anchorY);
                    setLocation(position);

                    // Change Z-Buffer if it is "overbearing"
                    getParent().setComponentZOrder(handle, 0);
                    repaint();
                }
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (!locked) {
                    snapToGrid();
                }
            }
        });
    }

    // Snap the piece to the nearest grid position within the puzzle area
    private void snapToGrid() {
        // Calculate relative position to the entire JFrame
        int x = getX();
        int y = getY();

        // Check if the piece is within the bounds of the puzzlePanel
        if (x >= puzzle.puzzlePanel.getX() && x < puzzle.puzzlePanel.getX() + puzzle.puzzlePanel.getWidth() &&
            y >= puzzle.puzzlePanel.getY() && y < puzzle.puzzlePanel.getY() + puzzle.puzzlePanel.getHeight()) {

            // Snap to grid within the puzzlePanel
            int snappedX = (x - puzzle.puzzlePanel.getX() + pieceWidth / 2) / pieceWidth * pieceWidth;
            int snappedY = (y - puzzle.puzzlePanel.getY() + pieceHeight / 2) / pieceHeight * pieceHeight;

            int gridX = snappedX / pieceWidth;
            int gridY = snappedY / pieceHeight;

            // Additional checks here as needed

            setLocation(snappedX + puzzle.puzzlePanel.getX(), snappedY + puzzle.puzzlePanel.getY());
        } else {
            // If outside, place it back or allow free placement
            setLocation(x, y); // Allows the piece to be placed freely outside the puzzlePanel
        }
    }

    // Check and lock the piece if it is in the correct position
    public void checkAndLock() {
        if (currentX == originalX && currentY == originalY) {
            locked = true;
        }
    }

    // Check if the piece is correctly placed
    public boolean isCorrectlyPlaced() {
        return locked;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentPosition(int x, int y) {
        this.currentX = x;
        this.currentY = y;
    }

    public boolean isLocked() {
        return locked;
    }
}
