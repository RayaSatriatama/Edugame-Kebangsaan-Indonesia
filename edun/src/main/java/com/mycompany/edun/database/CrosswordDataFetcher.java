/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edun.database;

/**
 *
 * @author rayas
 */

import com.mycompany.edun.database.koneksi_db;
import com.mycompany.crosswordpuzzlegenerator.CrosswordPuzzle;
import com.mycompany.crosswordpuzzlegenerator.Word;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrosswordDataFetcher {

    private static List<Word> words = new ArrayList<>();

    static {
        try {
            fetchCrosswordData();
        } catch (SQLException ex) {
            Logger.getLogger(CrosswordDataFetcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void fetchCrosswordData() throws SQLException {
        String query = "SELECT question, answer FROM crossword_puzzle";

        Connection connection = koneksi_db.konfigurasi_koneksiDB();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        try {
            while (resultSet.next()) {
                String question = resultSet.getString("question");
                String answer = resultSet.getString("answer");
                // Placeholder values for row, column
                int row = 0;
                int column = 0;
                boolean vertical = determineOrientation(answer);

                words.add(new Word(answer, row, column, vertical, question));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean determineOrientation(String answer) {
        CrosswordPuzzle tempGrid = new CrosswordPuzzle();
        Word verticalWord = new Word(answer, 0, 0, true, "");
        Word horizontalWord = new Word(answer, 0, 0, false, "");

        boolean canPlaceVertically = tempGrid.update(verticalWord);
        if (canPlaceVertically) {
            return true;
        } else {
            tempGrid.update(horizontalWord); // Assuming false if above fails
            return false;
        }
    }

    public static List<Word> getWords() {
        return words;
    }
}
