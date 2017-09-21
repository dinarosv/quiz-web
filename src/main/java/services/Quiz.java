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

    public Quiz(String quizName, String tid){
        this.quizName = quizName;
        Date d = new Date();
        int timer = Integer.parseInt(tid.substring(0,tid.indexOf(':')));
        int min = Integer.parseInt(tid.substring(tid.indexOf(':')+1, tid.length()));
        this.starttidspunkt = new Date(d.getYear(), d.getMonth(), d.getDate(), timer,min, 0);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public Date getStarttidspunkt() {
        return starttidspunkt;
    }

    public void setStarttidspunkt(Date starttidspunkt) {
        this.starttidspunkt = starttidspunkt;
    }

    public ArrayList<String> getBrukere() {
        return brukere;
    }

    public void setBrukere(ArrayList<String> brukere) {
        this.brukere = brukere;
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
