package services;

/**
 * Created by dina on 14/09/2017.
 */
class Scores {
    private String brukernavn;
    private double score;

    public Scores(String brukernavn, double score) {
        this.brukernavn = brukernavn;
        this.score = score;
    }
    public Scores(){}
    public String getBrukernavn() {
        return brukernavn;
    }

    public double getScore() {
        return score;
    }

}
