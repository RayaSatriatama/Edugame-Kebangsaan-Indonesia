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
import java.util.HashMap;
import java.util.Map;

public class CrosswordPuzzle {

    private static final int gridSize = 12;
    private char[][] grid;
    private static final char emptyCell = '_';
    private List<Word> words = new ArrayList<>();
    private int[][] numberGrid;
    private List<String> acrossQuestions = new ArrayList<>();
    private List<String> downQuestions = new ArrayList<>();
    private int currentNumber = 1;
    private Map<String, Integer> positionToNumberMap = new HashMap<>();

    public CrosswordPuzzle() {
        grid = new char[gridSize][gridSize];
        numberGrid = new int[gridSize][gridSize];
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                grid[row][column] = emptyCell;
                numberGrid[row][column] = 0;
            }
        }
    }

    private List<String> sortQuestions(List<String> questions) {
        questions.sort((q1, q2) -> {
            int num1 = Integer.parseInt(q1.split("\\.")[0]);
            int num2 = Integer.parseInt(q2.split("\\.")[0]);
            return Integer.compare(num1, num2);
        });
        return questions;
    }

    public List<String> getAcrossQuestions() {
        return sortQuestions(acrossQuestions);
    }

    public List<String> getDownQuestions() {
        return sortQuestions(downQuestions);
    }

    public int[][] getNumberGrid() {
        return numberGrid;
    }

    public boolean update(Word word) {
        if (canBePlaced(word)) {
            addWord(word);
            words.add(word);
            return true;
        }
        return false;
    }

    //check
    public List<Word> getPlacedWords() {
        return words;
    }

    private boolean canBePlaced(Word word) {
        boolean canBePlaced = true;
        if (isValidPosition(word.getRow(), word.getColumn()) && fitsOnGrid(word)) {
            int index = 0;
            while (index < word.getText().length()) {
                int currentRow = word.isVertical() ? word.getRow() + index : word.getRow();
                int currentColumn = !word.isVertical() ? word.getColumn() + index : word.getColumn();

                if ((word.getText().charAt(index) == grid[currentRow][currentColumn]
                        || emptyCell == grid[currentRow][currentColumn])
                        && placementLegal(word, currentRow, currentColumn)) {
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
        int row = word.getRow();
        int column = word.getColumn();
        String positionKey = row + "," + column;

        boolean isNewNumber = false;
        if (!positionToNumberMap.containsKey(positionKey)) {
            positionToNumberMap.put(positionKey, currentNumber);
            numberGrid[row][column] = currentNumber++;
            isNewNumber = true;
        } else {
            numberGrid[row][column] = positionToNumberMap.get(positionKey);
        }

        for (int letterIndex = 0; letterIndex < word.getText().length(); ++letterIndex) {
            int currentRow = word.isVertical() ? row + letterIndex : row;
            int currentColumn = word.isVertical() ? column : column + letterIndex;
            grid[currentRow][currentColumn] = word.getText().charAt(letterIndex);
        }

        String question = word.getQuestion();
        int questionNumber = numberGrid[row][column];

        // Ensure that both across and down questions are added if they share the same start position
        if (word.isVertical()) {
            if (!downQuestions.contains(questionNumber + ". " + question)) {
                downQuestions.add(questionNumber + ". " + question);
            }
        } else {
            if (!acrossQuestions.contains(questionNumber + ". " + question)) {
                acrossQuestions.add(questionNumber + ". " + question);
            }
        }
    }

    public void printGrid() {
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                System.out.print(grid[row][column] + " ");
            }
            System.out.println();
        }
    }

    public void printPlacedWords() {
        System.out.println("Placed Words:");
        for (Word word : words) {
            System.out.println(word.getText() + " at (" + word.getRow() + ", " + word.getColumn() + ") " + (word.isVertical() ? "Vertical" : "Horizontal"));
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
            illegal = isInterference(row, column + 1, row + 1, column)
                    || isInterference(row, column - 1, row + 1, column)
                    || overwritingVerticalWord(row, column)
                    || invadingTerritory(word, row, column);

        } else {
            illegal = isInterference(row + 1, column, row, column + 1)
                    || isInterference(row - 1, column, row, column + 1)
                    || overwritingHorizontalWord(row, column)
                    || invadingTerritory(word, row, column);

        }
        return !illegal;
    }

    private boolean isInterference(int row, int column, int nextRow, int nextColumn) {
        return isValidPosition(row, column)
                && isValidPosition(nextRow, nextColumn)
                && isLetter(row, column)
                && isLetter(nextRow, nextColumn);
    }

    boolean isLetter(int row, int column) {
        return grid[row][column] != emptyCell;
    }

    private boolean overwritingHorizontalWord(int row, int column) {
        int leftColumn = column - 1;
        return isValidPosition(row, leftColumn)
                && isLetter(row, column)
                && isLetter(row, leftColumn);
    }

    private boolean overwritingVerticalWord(int row, int column) {
        int rowAbove = row - 1;
        return isValidPosition(rowAbove, column)
                && isLetter(row, column)
                && isLetter(rowAbove, column);
    }

    private boolean invadingTerritory(Word word, int row, int column) {
        boolean invading = false;
        boolean empty = !isLetter(row, column);
        if (word.isVertical()) {
            boolean weHaveNeighbors = (doesCharacterExist(row, column - 1)
                    || doesCharacterExist(row, column + 1))
                    || (endOfWord(word, row, column)
                    && doesCharacterExist(row + 1, column));

            invading = empty && weHaveNeighbors;
        } else {
            boolean weHaveNeighbors = (doesCharacterExist(row - 1, column)
                    || doesCharacterExist(row + 1, column))
                    || (endOfWord(word, row, column)
                    && doesCharacterExist(row, column + 1));

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

    //check
    public int getIntersections() {
        int intersections = 0;
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                if (isLetter(row, column)) {
                    if (isValidPosition(row - 1, column) && isLetter(row - 1, column)
                            && isValidPosition(row + 1, column) && isLetter(row + 1, column)) {
                        intersections++;
                    }
                    if (isValidPosition(row, column - 1) && isLetter(row, column - 1)
                            && isValidPosition(row, column + 1) && isLetter(row, column + 1)) {
                        intersections++;
                    }
                }
            }
        }
        return intersections;
    }

    public List<Word> getWords() {
        return words;
    }

    public char[][] getGrid() {
        return grid;
    }
}
