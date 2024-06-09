/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edun;

/**
 *
 * @author rayas
 */
// MainApp.java
import java.awt.event.*;

public class MainApp {

    public static void main(String[] args) {
        // Buat instance dari AddModule
        AddModule addModule = new AddModule();
        addModule.setVisible(true);
        addModule.setAlwaysOnTop(true);

        // Tambahkan WindowListener
        addModule.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("AddModule window closed.");
                // Tambahkan logika yang ingin dijalankan saat jendela ditutup
                performCleanup();
            }
        });
    }

    private static void performCleanup() {
        // Logika yang ingin dijalankan saat AddModule ditutup
        System.out.println("Performing cleanup tasks...");
        // Contoh logika cleanup: membersihkan resource, memperbarui UI, dll.
    }
}
