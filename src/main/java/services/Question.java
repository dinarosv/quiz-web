package services;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dina on 14/09/2017.
 */
public class Question {
    private String question;
    private ArrayList<Answer> answers = new ArrayList<Answer>();
    private double tidsangivelse;

    BufferedImage img;

    public Question(String question, double tidsangivelse) {
        this.question = question;
        this.tidsangivelse = tidsangivelse;
    }
    public String getQuestion() {
        return question;
    }
    public void addAnswer(String answer, boolean correct){
        answers.add(new Answer(answer, correct));
    }
    public boolean validQuestion(){
        if (answers.size() >=2){
            return true;
        }
        return false;
    }
    public boolean addImage(String link){
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
}
