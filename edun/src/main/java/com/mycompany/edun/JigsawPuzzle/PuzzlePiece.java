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
    private int originalX;
    private int originalY;
    private int pieceWidth;
    private int pieceHeight;
    private Point anchorPoint;
    private int currentX;
    private int currentY;
    private JigsawPuzzle puzzle;

    public PuzzlePiece(BufferedImage image, int originalX, int originalY, int pieceWidth, int pieceHeight, JigsawPuzzle puzzle) {
        this.originalX = originalX;
        this.originalY = originalY;
        this.pieceWidth = pieceWidth;
        this.pieceHeight = pieceHeight;
        this.puzzle = puzzle;
        this.currentX = -1;
        this.currentY = -1;

        setIcon(new ImageIcon(image));
        addDragListeners();
    }

    private void addDragListeners() {
        final PuzzlePiece handle = this;
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                anchorPoint = e.getPoint();
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int anchorX = anchorPoint.x;
                int anchorY = anchorPoint.y;

                Point parentOnScreen = getParent().getLocationOnScreen();
                Point mouseOnScreen = e.getLocationOnScreen();
                Point position = new Point(mouseOnScreen.x - parentOnScreen.x - anchorX, mouseOnScreen.y - parentOnScreen.y - anchorY);
                setLocation(position);

                getParent().setComponentZOrder(handle, 0);
                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                snapToGrid();
            }
        });
    }

    private void snapToGrid() {
        int x = getX();
        int y = getY();

        if (x >= puzzle.puzzlePanel.getX() && x < puzzle.puzzlePanel.getX() + puzzle.puzzlePanel.getWidth() &&
            y >= puzzle.puzzlePanel.getY() && y < puzzle.puzzlePanel.getY() + puzzle.puzzlePanel.getHeight()) {

            int snappedX = Math.max(0, Math.min((x - puzzle.puzzlePanel.getX() + pieceWidth / 2) / pieceWidth, puzzle.getCols() - 1)) * pieceWidth;
            int snappedY = Math.max(0, Math.min((y - puzzle.puzzlePanel.getY() + pieceHeight / 2) / pieceHeight, puzzle.getRows() - 1)) * pieceHeight;

            setLocation(snappedX + puzzle.puzzlePanel.getX(), snappedY + puzzle.puzzlePanel.getY());

            currentX = snappedX / pieceWidth;
            currentY = snappedY / pieceHeight;

            puzzle.checkCompletion();
        } else {
            setLocation(x, y);
        }
    }

    public boolean isCorrectlyPlaced() {
        return currentX == originalX && currentY == originalY;
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
}
