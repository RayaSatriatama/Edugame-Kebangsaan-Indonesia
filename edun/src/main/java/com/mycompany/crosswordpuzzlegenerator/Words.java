/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crosswordpuzzlegenerator;

/**
 *
 * @author rayas
 */

import com.mycompany.edun.database.CrosswordDataFetcher;
import java.util.List;

public class Words {
    private static List<Word> words;

    static {
        words = CrosswordDataFetcher.getWords();
    }

    public static List<Word> getWords() {
        return words;
    }
}
