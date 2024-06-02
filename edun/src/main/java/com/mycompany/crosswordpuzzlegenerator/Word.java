/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crosswordpuzzlegenerator;

/**
 *
 * @author rayas
 */

public class Word {
    private String text;
    private int row;
    private int column;
    private boolean vertical;

    public Word(String text, int row, int column, boolean vertical) {
        this.text = text;
        this.row = row;
        this.column = column;
        this.vertical = vertical;
    }

    // Getters
    public String getText() {
        return text;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isVertical() {
        return vertical;
    }

    // Setters
    public void setText(String text) {
        this.text = text;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }
}

