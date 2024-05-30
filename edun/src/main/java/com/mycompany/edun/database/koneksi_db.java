/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edun.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ivanbesti
 */

/**
 * Kelas db_koneksi untuk menghandle koneksi ke database MySQL
 */
public class koneksi_db {
    public static Connection koneksi;

    /**
     * Mengkonfigurasi koneksi ke database
     * @return Connection
     * @throws SQLException
     */
    public static Connection konfigurasi_koneksiDB() throws SQLException {
        try {
            String url_host = "jdbc:mysql://localhost/eduN";
            String nama_user = "root";
            String password_db = "";

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksi = DriverManager.getConnection(url_host, nama_user, password_db);
            System.out.println("Database berhasil terhubung");
//            JOptionPane.showMessageDialog(null, "Selamat, Koneksi berhasil terhubung");
            return koneksi;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal, Koneksi gagal terhubung");
            System.out.println("Database gagal terhubung");
            return null;
        }
    }

    /**
     * Main method untuk menjalankan koneksi
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        System.out.println("Mencoba Database");
        konfigurasi_koneksiDB();
    }
}
