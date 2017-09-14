package services;

import java.util.ArrayList;

/**
 * Created by dina on 14/09/2017.
 */
class ScoreBoard {
    private ArrayList<Scores> scores = new ArrayList<Scores>();

    public ScoreBoard(){
        new ScoreBoard();
    }
    public ArrayList<Scores> getScores(){
        return scores;
    }
    public ArrayList<Scores> getScoresForQuiz(Quiz q){
        ArrayList<Scores> quizscores = new ArrayList<Scores>();
        for(int i=0; i<scores.size(); i++){
            if(scores.get(i).getQuiz().equals(q)){
                quizscores.add(scores.get(i));
            }
        }
        return quizscores;
    }
}
