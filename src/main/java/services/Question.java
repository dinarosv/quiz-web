package services;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Question {
    private String question;
    private HashMap<String, Answer> answers = new HashMap<String, Answer>();
    //private BufferedImage img = null;

    public Question(String question) {
        this.question = question;
    }
    public Question(){}
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public HashMap<String, Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(HashMap<String, Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer a){
        answers.put(a.getAnswer(), a);
    }
    public Answer getAnswer(String answer){
        return answers.get(answer);
    }
    public boolean validQuestion(){
        if (answers.size() >=2){
            return true;
        }
        return false;
    }
    /*public boolean addImage(String link){
        try{
            img = ImageIO.read(new URL(link));
            return true;
        }catch(java.net.MalformedURLException e ){
            System.out.println("Not okay Malformed");
            return false;
        }catch (java.io.IOException e ){
            System.out.println("Not okay IO");
            return false;
        }
    }
    public BufferedImage getImg(){
        return img;
    }*/
}
