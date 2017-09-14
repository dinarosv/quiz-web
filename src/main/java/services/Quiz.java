package services;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dina on 14/09/2017.
 */
public class Quiz {
    private ArrayList<Question> questions;
    private String quizName;
    private Date starttidspunkt;
    private ArrayList<String> brukere = new ArrayList();

    public Quiz(String quizName){
        this.quizName = quizName;
    }

    public void addQuestion(Question q){
        if(q.validQuestion()){
            questions.add(q);
        }
    }
    public void addBruker(String nick){
        brukere.add(nick);
    }

}
