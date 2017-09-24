package services;

import java.util.ArrayList;
import java.util.HashMap;

public class Quiz {
    private String quizName;
    private String time;
    private String tpq; //Time per question
    private HashMap<String, Nick> nicks = new HashMap<String, Nick>();
    private HashMap<String, Question> questions = new HashMap<String, Question>();
    private HashMap<String, Scores> scoreBoard = new HashMap<String, Scores>();

    public Quiz(String quizName, String time, String tpq){
        this.quizName = quizName;
        this.time = time;
        this.tpq = tpq;
    }
    public Quiz(){
    }

    public String getTime(){
        return time.split("T")[0] + " " + time.split("T")[1];
    }
    public void setTime(String time){
        this.time = time;
    }

    public String getQuizName() {
        return quizName;
    }
    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public Question getQuestion(String name){
        return questions.get(name);
    }
    public void addQuestion(Question q){
        questions.put(q.getQuestion(), q);
    }

    public HashMap<String, Question> getQuestions() {
        return questions;
    }
    public void setQuestions(HashMap<String, Question> questions){
        this.questions = questions;
    }

    public String getNick(String nick){
        return nicks.get(nick).getNick();
    }
    public void addNick(Nick nick){
        nicks.put(nick.getNick(), nick);
    }

    public HashMap<String, Nick> getNicks() {
        return nicks;
    }
    public void setNicks(HashMap<String, Nick> nicks){ this.nicks = nicks;}

    public void setTpq(String tpq){
        this.tpq = tpq;
    }
    public String getTpq(){
        return tpq;
    }

    public void setScoreBoard(HashMap<String, Scores> scoreBoard){ this.scoreBoard = scoreBoard; }
    public HashMap<String, Scores> getScoreBoard(){return scoreBoard;}

}
