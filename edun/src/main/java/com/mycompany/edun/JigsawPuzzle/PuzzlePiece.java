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
        int x = getX();
        int y = getY();
        int snappedX = (x + pieceWidth / 2) / pieceWidth * pieceWidth;
        int snappedY = (y + pieceHeight / 2) / pieceHeight * pieceHeight;

        int gridX = snappedX / pieceWidth;
        int gridY = snappedY / pieceHeight;

        // Check if the grid position is within bounds
        if (gridX >= 0 && gridX < puzzle.grid[0].length && gridY >= 0 && gridY < puzzle.grid.length) {
            PuzzlePiece otherPiece = puzzle.grid[gridY][gridX];
            // Only swap if the other piece is not locked
            if (!otherPiece.isLocked()) {
                puzzle.swapPieces(this, otherPiece);
            } else {
                // Move back to current position if the other piece is locked
                setLocation(currentX * pieceWidth, currentY * pieceHeight);
            }
        } else {
            // Move back to current position if out of bounds
            setLocation(currentX * pieceWidth, currentY * pieceHeight);
        }

        // Lock the piece if it is in its correct position
        checkAndLock();
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
