/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrosswordPuzzle;

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

public class CrosswordDAO {
    public List<Crossword> getCrosswords() {
        List<Crossword> crosswords = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = koneksi_db.konfigurasi_koneksiDB();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM crossword_puzzle");

            while (rs.next()) {
                int id = rs.getInt("id");
                String question = rs.getString("question");
                String answer = rs.getString("answer");
                crosswords.add(new Crossword(id, question, answer));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return crosswords;
    }
}
