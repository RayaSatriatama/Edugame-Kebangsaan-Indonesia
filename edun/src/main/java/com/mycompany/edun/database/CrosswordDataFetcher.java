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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrosswordDataFetcher {

    private static List<String> words = new ArrayList<>();

    static {
        try {
            fetchCrosswordData();
        } catch (SQLException ex) {
            Logger.getLogger(CrosswordDataFetcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void fetchCrosswordData() throws SQLException {
        String query = "SELECT answer FROM crossword_puzzle";

        Connection connection = (Connection) koneksi_db.konfigurasi_koneksiDB();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        try {
            while (resultSet.next()) {
                String word = resultSet.getString("answer");
                words.add(word);
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

    public static List<String> getWords() {
        return words;
    }
}
