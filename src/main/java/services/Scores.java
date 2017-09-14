package services;

/**
 * Created by dina on 14/09/2017.
 */
class Scores {
    private String brukernavn;
    private double score;
    private Quiz quiz;

    public Scores(String brukernavn, double score, Quiz quiz) {
        this.brukernavn = brukernavn;
        this.score = score;
        this.quiz = quiz;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public double getScore() {
        return score;
    }

    public Quiz getQuiz() {
        return quiz;
    }
}
