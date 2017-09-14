package services;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dina on 14/09/2017.
 */
class Quizzes {
    private static ArrayList<Quiz> quizzes = new ArrayList<>();
    private static ScoreBoard s = new ScoreBoard();

    public void addQuiz(String quizname, ArrayList<Question> questions){
        Quiz q = new Quiz(quizname);
        for(int i=0; i<questions.size(); i++){
            q.addQuestion(questions.get(i));
        }
        quizzes.add(q);
    }
    public void joinQuiz(String brukernavn, Quiz q){
        q.addBruker(brukernavn);
    }
    public ArrayList<Scores> getScores(Quiz q){
        return s.getScoresForQuiz(q);
    }
}
