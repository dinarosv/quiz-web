package services;

/**
 * Created by dina on 14/09/2017.
 */
class Scores {
    private String nick;
    private int score;

    public Scores(String nick, int score) {
        this.nick = nick;
        this.score = score;
    }
    public Scores(){}

    public void setNick(String nick){
        this.nick = nick;
    }
    public String getNick() {
        return nick;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score){
        this.score = score;
    }

}
