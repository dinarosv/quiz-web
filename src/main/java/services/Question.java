package services;


public class Question {
    private String question;
    private int correctanswer;
    private String[] answers;
    private String url;

    public Question(String question, int correctanswer, String[] answers) {
        this.question = question;
        this.correctanswer = correctanswer;
        this.answers = answers;
    }
    public Question(){}
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }
    public void setAnswers(String[] answers){
        this.answers = answers;
    }

    public void setCorrectanswer(int correctanswer){
        this.correctanswer = correctanswer;
    }
    public int getCorrectanswer(){
        return correctanswer;
    }

    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return url;
    }
}
