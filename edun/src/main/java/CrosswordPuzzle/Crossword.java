/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrosswordPuzzle;

/**
 *
 * @author rayas
 */
// Path: com/mycompany/edun/crossword/CrosswordPuzzle.java

public class Crossword {
    private int id;
    private String question;
    private String answer;

    public Crossword(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
