package services;

import java.util.ArrayList;
import java.util.HashMap;

public class Quiz {
    private String quizName;
    private static HashMap<String, String> nicks = new HashMap<String, String>();
    private String time;

    private HashMap<String, Scores> scoreBoard = new HashMap<String, Scores>();
    private HashMap<String, Question> questions;

    public Quiz(String quizName, String time){
        this.quizName = quizName;
        this.time = time;
    }
    public Quiz(){
    }
    public void setTime(String time){
        this.time = time;

    }
    public String getTime(){
        return time.split("T")[0] + " " + time.split("T")[1];
    }
    public String getQuizName() {
        return quizName;
    }
    public Question getQuestion(String name){
        return questions.get(name);
    }
    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }


    public HashMap<String, Question> getQuestions() {
        return questions;
    }
    public void addQuestion(Question q){
        if(q.validQuestion()){
            questions.put(q.getQuestion(), q);
        }
    }

    public String getNick(String nick){
        return nicks.get(nick);
    }
    public HashMap<String, String> getNicks() {
        return nicks;
    }
    public void addNick(String nick){
        nicks.put(nick, nick);
    }
    /*
    Date d = new Date();
        int timer = Integer.parseInt(time.substring(0,time.indexOf(':')));
        int min = Integer.parseInt(time.substring(time.indexOf(':')+1, time.length()));
        this.starttidspunkt = new Date(d.getYear(), d.getMonth(), d.getDate(), timer,min, 0);
     */
}
