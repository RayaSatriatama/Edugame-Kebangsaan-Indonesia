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
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CrosswordPuzzleGenerator {

    private static final int attemptsToFitWords = 5000;
    private static final int gridsToMake = 12;
    private List<String> usedWords = new ArrayList<>();
    private List<CrosswordPuzzle> generatedGrids = new ArrayList<>();
    private Set<Character> goodStartingLetters = new HashSet<>();
    private static final int gridSize = 12;

    public CrosswordPuzzle createCrossWordPuzzle() {
        generateGrids();
        return getBestGrid(generatedGrids);
    }

    //check
    private boolean attemptToPlaceWordOnGrid(CrosswordPuzzle grid, List<String> usedWordsInThisGrid) {
        String text = getAWordToTry();
        for (int row = 0; row < gridSize; ++row) {
            for (int column = 0; column < gridSize; ++column) {
                Word word = new Word(text, row, column, new Random().nextBoolean(), "");
                if (grid.isLetter(row, column) && grid.update(word)) {
                    pushUsedWords(word.getText(), word.isVertical());
                    usedWordsInThisGrid.add(text);
                    return true;
                }
            }
        }
        return false;
    }

    private void pushUsedWords(String text, boolean isVertical) {
        usedWords.add(text);
        for (char c : text.toCharArray()) {
            goodStartingLetters.add(c);
        }
    }

    private String getAWordToTry() {
        Word word = getRandomWord(Words.getWords());
        boolean goodWord = isGoodWord(word.getText());

        while (usedWords.contains(word.getText()) || !goodWord) {
            word = getRandomWord(Words.getWords());
            goodWord = isGoodWord(word.getText());
        }
        return word.getText();
    }

    // check
    private CrosswordPuzzle getBestGrid(List<CrosswordPuzzle> grids) {
        System.out.println("Checking for best grid out of " + grids.size() + " grids");
        CrosswordPuzzle bestGrid = grids.get(0);
        for (CrosswordPuzzle grid : grids) {
            System.out.println("Grid intersections: " + grid.getIntersections());
            if (grid.getIntersections() >= bestGrid.getIntersections()) {
                bestGrid = grid;
            }
        }
        System.out.println("Best grid intersections: " + bestGrid.getIntersections());
        return bestGrid;
    }

    private boolean isGoodWord(String word) {
        for (char letter : goodStartingLetters) {
            if (letter == word.charAt(0)) {
                return true;
            }
        }
        return false;
    }

    // check
    private void generateGrids() {
        generatedGrids = new ArrayList<>();
        System.out.println("Generating grids...");

        for (int gridsMade = 0; gridsMade < gridsToMake; gridsMade++) {
            System.out.println("Creating grid #" + (gridsMade + 1));
            CrosswordPuzzle grid = new CrosswordPuzzle();
            List<String> usedWordsInThisGrid = new ArrayList<>();

            Word word = new Word(getRandomWordOfSize(getUnusedWords(), 9).getText(), 0, 0, false, "");
            if (!usedWordsInThisGrid.contains(word.getText())) {
                if (grid.update(word)) {
                    pushUsedWords(word.getText(), word.isVertical());
                    usedWordsInThisGrid.add(word.getText());
                    System.out.println("Placed initial word: " + word.getText());
                }
            }

            int continuousFails = 0;
            for (int attempts = 0; attempts < attemptsToFitWords; ++attempts) {
                boolean placed = attemptToPlaceWordOnGrid(grid, usedWordsInThisGrid);
                if (placed) {
                    continuousFails = 0;
                    System.out.println("Placed word at attempt " + attempts);
                } else {
                    continuousFails++;
                }
                if (continuousFails > 470) {
                    System.out.println("Too many continuous failures, breaking out at attempt " + attempts);
                    break;
                }
            }

            generatedGrids.add(grid);
            System.out.println("Grid created with " + grid.getIntersections() + " intersections");

            if (grid.getIntersections() >= 4) {
                System.out.println("Sufficient intersections, stopping grid generation.");
                break;
            }
            usedWords.clear();
        }
        System.out.println("Finished generating grids. Total grids: " + generatedGrids.size());
    }

    private List<Word> getUnusedWords() {
        List<Word> unusedWords = new ArrayList<>();
        for (Word word : Words.getWords()) {
            if (!usedWords.contains(word.getText())) {
                unusedWords.add(word);
            }
        }
        return unusedWords;
    }

    private Word getRandomWordOfSize(List<Word> wordList, int wordSize) {
        List<Word> properLengthWords = new ArrayList<>();
        for (Word word : wordList) {
            if (word.getText().length() >= wordSize) {
                properLengthWords.add(word);
            }
        }
        return properLengthWords.get(new Random().nextInt(properLengthWords.size()));
    }

    private Word getRandomWord(List<Word> wordList) {
        List<Word> words = getUnusedWords();
        return words.get(new Random().nextInt(words.size()));
    }
}
