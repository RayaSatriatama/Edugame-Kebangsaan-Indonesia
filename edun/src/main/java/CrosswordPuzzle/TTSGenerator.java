/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrosswordPuzzle;

/**
 *
 * @author rayas
 */

import java.util.ArrayList;
import java.util.List;

public class TTSGenerator {
    private char[][] grid;
    private List<Crossword> crosswords;
    private int size;

    public TTSGenerator(List<Crossword> crosswords, int size) {
        this.crosswords = crosswords;
        this.size = size;
        this.grid = new char[size][size];
        initializeGrid();
        generatePuzzle();
    }

    private void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    private void generatePuzzle() {
        for (Crossword crossword : crosswords) {
            String answer = crossword.getAnswer().toUpperCase();
            if (!placeWordInGrid(answer)) {
                System.out.println("Failed to place word: " + answer);
            }
        }
    }

    private boolean placeWordInGrid(String word) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == ' ' || grid[i][j] == word.charAt(0)) {
                    if (canPlaceWord(word, i, j, true) || canPlaceWord(word, i, j, false)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean canPlaceWord(String word, int row, int col, boolean horizontal) {
        if (horizontal) {
            if (col + word.length() > size) return false;
            for (int i = 0; i < word.length(); i++) {
                if (grid[row][col + i] != ' ' && grid[row][col + i] != word.charAt(i)) return false;
            }
            for (int i = 0; i < word.length(); i++) {
                grid[row][col + i] = word.charAt(i);
            }
        } else {
            if (row + word.length() > size) return false;
            for (int i = 0; i < word.length(); i++) {
                if (grid[row + i][col] != ' ' && grid[row + i][col] != word.charAt(i)) return false;
            }
            for (int i = 0; i < word.length(); i++) {
                grid[row + i][col] = word.charAt(i);
            }
        }
        return true;
    }

    public char[][] getGrid() {
        return grid;
    }
}