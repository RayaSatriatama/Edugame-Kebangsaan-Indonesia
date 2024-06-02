/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crosswordpuzzlegenerator;

/**
 *
 * @author rayas
 */

import java.util.ArrayList;
import java.util.List;

public class CrosswordPuzzle {
    private static final int gridSize = 20;
    private char[][] grid;
    private static final char emptyCell = '_';

    public CrosswordPuzzle() {
        grid = new char[gridSize][gridSize];
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                grid[row][column] = emptyCell;
            }
        }
    }

    public boolean update(Word word) {
        if (canBePlaced(word)) {
            addWord(word);
            return true;
        }
        return false;
    }

    private boolean canBePlaced(Word word) {
        boolean canBePlaced = true;
        if (isValidPosition(word.getRow(), word.getColumn()) && fitsOnGrid(word)) {
            int index = 0;
            while (index < word.getText().length()) {
                int currentRow = word.isVertical() ? word.getRow() + index : word.getRow();
                int currentColumn = !word.isVertical() ? word.getColumn() + index : word.getColumn();

                if ((word.getText().charAt(index) == grid[currentRow][currentColumn] ||
                    emptyCell == grid[currentRow][currentColumn]) &&
                    placementLegal(word, currentRow, currentColumn)) {
                    // We can place a word!
                } else {
                    canBePlaced = false;
                }
                index++;
            }
        } else {
            canBePlaced = false;
        }

        return canBePlaced;
    }

    private void addWord(Word word) {
        for (int letterIndex = 0; letterIndex < word.getText().length(); ++letterIndex) {
            int row = word.getRow();
            int column = word.getColumn();
            if (word.isVertical()) {
                row += letterIndex;
            } else {
                column += letterIndex;
            }

            grid[row][column] = word.getText().charAt(letterIndex);
        }
    }

    private boolean fitsOnGrid(Word word) {
        if (word.isVertical()) {
            return word.getRow() + word.getText().length() <= gridSize;
        } else {
            return word.getColumn() + word.getText().length() <= gridSize;
        }
    }

    private boolean isValidPosition(int row, int column) {
        return row >= 0 && row < gridSize && column >= 0 && column < gridSize;
    }

    private boolean placementLegal(Word word, int row, int column) {
        boolean illegal = false;
        if (word.isVertical()) {
            illegal = isInterference(row, column + 1, row + 1, column) ||
                      isInterference(row, column - 1, row + 1, column) ||
                      overwritingVerticalWord(row, column) ||
                      invadingTerritory(word, row, column);

        } else {
            illegal = isInterference(row + 1, column, row, column + 1) ||
                      isInterference(row - 1, column, row, column + 1) ||
                      overwritingHorizontalWord(row, column) ||
                      invadingTerritory(word, row, column);

        }
        return !illegal;
    }

    private boolean isInterference(int row, int column, int nextRow, int nextColumn) {
        return isValidPosition(row, column) &&
               isValidPosition(nextRow, nextColumn) &&
               isLetter(row, column) &&
               isLetter(nextRow, nextColumn);    
    }

    boolean isLetter(int row, int column) {
        return grid[row][column] != emptyCell;
    }

    private boolean overwritingHorizontalWord(int row, int column) {
        int leftColumn = column - 1;
        return isValidPosition(row, leftColumn) && 
               isLetter(row, column) && 
               isLetter(row, leftColumn);
    }

    private boolean overwritingVerticalWord(int row, int column) {
        int rowAbove = row - 1;
        return isValidPosition(rowAbove, column) && 
               isLetter(row, column) && 
               isLetter(rowAbove, column);
    }

    private boolean invadingTerritory(Word word, int row, int column) {
        boolean invading = false;
        boolean empty = !isLetter(row, column);
        if (word.isVertical()) {
            boolean weHaveNeighbors = (doesCharacterExist(row, column - 1) ||
                                       doesCharacterExist(row, column + 1)) ||
                                      (endOfWord(word, row, column) && 
                                       doesCharacterExist(row + 1, column));

            invading = empty && weHaveNeighbors;                
        } else {
            boolean weHaveNeighbors = (doesCharacterExist(row - 1, column) ||
                                       doesCharacterExist(row + 1, column)) ||
                                      (endOfWord(word, row, column) && 
                                       doesCharacterExist(row, column + 1));

            invading = empty && weHaveNeighbors;
        }
        return invading;
    }

    private boolean endOfWord(Word word, int row, int column) {
        if (word.isVertical()) {
            return word.getRow() + word.getText().length() - 1 == row;
        } else {
            return word.getColumn() + word.getText().length() - 1 == column;
        }
    }

    private boolean doesCharacterExist(int row, int column) {
        return isValidPosition(row, column) && isLetter(row, column);
    }

    public int getIntersections() {
        int intersections = 0;
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                if (isLetter(row, column)) {
                    if (isValidPosition(row - 1, column) &&
                        isValidPosition(row + 1, column) &&
                        isValidPosition(row, column - 1) &&
                        isValidPosition(row, column + 1) &&
                        isLetter(row - 1, column) &&
                        isLetter(row + 1, column) &&
                        isLetter(row, column - 1) &&
                        isLetter(row, column + 1)) {
                        intersections++;
                    }
                }
            }
        }
        return intersections;
    }

    public char[][] getGrid() {
        return grid;
    }
}
