package services;

import java.util.ArrayList;
import java.util.HashMap;

public class Quiz {
    private String quizName;
    private String time;
    private String tpq; //Time per question
    private Question[] questions = new Question[0];
    private HashMap<String, Scores> scoreBoard = new HashMap<String, Scores>();

    public Quiz(String quizName, String time, String tpq){
        this.quizName = quizName;
        this.time = time;
        this.tpq = tpq;
    }
    public Quiz(){
    }

    public String getQuizName() {
        return quizName;
    }
    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getTime(){
        return time.split("T")[0] + " " + time.split("T")[1];
    }
    public void setTime(String time){
        this.time = time;
    }

    public Question[] getQuestions() {
        return questions;
    }
    public void setQuestions(Question[] questions){
        this.questions = questions;
    }

    public void setTpq(String tpq){
        this.tpq = tpq;
    }
    public String getTpq(){
        return tpq;
    }

    public void setScoreBoard(HashMap<String, Scores> scoreBoard){ this.scoreBoard = scoreBoard; }
    public HashMap<String, Scores> getScoreBoard(){return scoreBoard;}

    public void addScore(Scores scores){
        scoreBoard.put(scores.getNick(), scores);
    }
    public void updateScore(Scores score){
        int last = scoreBoard.get(score.getNick()).getScore();
        scoreBoard.get(score.getNick()).setScore(score.getScore()+last);
    }

}
