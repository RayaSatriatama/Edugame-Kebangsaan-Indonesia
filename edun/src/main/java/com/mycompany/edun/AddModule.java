/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edun;

/**
 *
 * @author rayas
 */
// AddModule.java
import javax.swing.*;

public class AddModule extends JFrame {

    public AddModule() {
        // Inisialisasi jendela AddModule
        setTitle("Add Module");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Buat instance dari AddModule untuk pengujian mandiri
        AddModule addModule = new AddModule();
        addModule.setVisible(true);
        addModule.setAlwaysOnTop(true);
    }
}
