package services;

/**
 * Created by dina on 14/09/2017.
 */
public class Answer {
    public String answer;
    //public boolean correct;

    public Answer(String answer) {
        this.answer = answer;
        //this.correct = correct;
    }
    public Answer(){}

    public String getAnswer() {
        return answer;
    }

    /*public boolean isCorrect() {
        return correct;
    }*/
}
