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
    private static final int gridsToMake = 20;
    private List<String> usedWords = new ArrayList<>();
    private List<CrosswordPuzzle> generatedGrids = new ArrayList<>();
    private Set<Character> goodStartingLetters = new HashSet<>();
    private static final int gridSize = 20;

    public CrosswordPuzzle createCrossWordPuzzle() {
        generateGrids();
        return getBestGrid(generatedGrids);
    }

    private boolean attemptToPlaceWordOnGrid(CrosswordPuzzle grid, Word word) {
        String text = getAWordToTry();
        for (int row = 0; row < gridSize; ++row) {
            for (int column = 0; column < gridSize; ++column) {
                word.setText(text);
                word.setRow(row);
                word.setColumn(column);
                word.setVertical(new Random().nextBoolean());

                if (grid.isLetter(row, column)) {
                    if (grid.update(word)) {
                        pushUsedWords(word.getText());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private String getAWordToTry() {
        String word = getRandomWord(Words.words);
        boolean goodWord = isGoodWord(word);

        while (usedWords.contains(word) || !goodWord) {
            word = getRandomWord(Words.words);
            goodWord = isGoodWord(word);
        }
        return word;
    }

    private CrosswordPuzzle getBestGrid(List<CrosswordPuzzle> grids) {
        CrosswordPuzzle bestGrid = grids.get(0);
        for (CrosswordPuzzle grid : grids) {
            if (grid.getIntersections() >= bestGrid.getIntersections()) {
                bestGrid = grid;
            }
        }
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

    private void generateGrids() {
        generatedGrids = new ArrayList<>();

        for (int gridsMade = 0; gridsMade < gridsToMake; gridsMade++) {
            CrosswordPuzzle grid = new CrosswordPuzzle();
            Word word = new Word(getRandomWordOfSize(getUnusedWords(), 9), 0, 0, false);
            grid.update(word);
            pushUsedWords(word.getText());

            int continuousFails = 0;
            for (int attempts = 0; attempts < attemptsToFitWords; ++attempts) {
                boolean placed = attemptToPlaceWordOnGrid(grid, word);
                if (placed) {
                    continuousFails = 0;
                } else {
                    continuousFails++;
                }
                if (continuousFails > 470) {
                    break;
                }
            }

            generatedGrids.add(grid);
            if (grid.getIntersections() >= 4) {
                break;
            }
            usedWords.clear();
        }
    }

    private void pushUsedWords(String text) {
        usedWords.add(text);
        for (char c : text.toCharArray()) {
            goodStartingLetters.add(c);
        }
    }

    private List<String> getUnusedWords() {
        List<String> unusedWords = new ArrayList<>();
        for (String word : Words.words) {
            if (!usedWords.contains(word)) {
                unusedWords.add(word);
            }
        }
        return unusedWords;
    }

    private String getRandomWordOfSize(List<String> wordList, int wordSize) {
        List<String> properLengthWords = new ArrayList<>();
        for (String word : wordList) {
            if (word.length() >= wordSize) {
                properLengthWords.add(word);
            }
        }
        return properLengthWords.get(new Random().nextInt(properLengthWords.size()));
    }

    private String getRandomWord(List<String> wordList) {
        List<String> words = getUnusedWords();
        return words.get(new Random().nextInt(words.size()));
    }
}
