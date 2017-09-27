package services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashMap;

@Path("/quizzes/")
public class Quizzes {
    private static HashMap<String, Quiz> quizzes = new HashMap<String, Quiz>();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addQuiz(Quiz quiz){
        quizzes.put(quiz.getQuizName(), quiz);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Quiz> getQuizzes(){
        return quizzes.values();
    }

    @POST
    @Path("{quizName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addQuestions(@PathParam("quizName") String quizName, Question[] questions){
        quizzes.get(quizName).setQuestions(questions);
    }

    @GET
    @Path("{quizName}")
    @Produces(MediaType.APPLICATION_JSON) public Question[] getQuestions(@PathParam("quizName") String quizName){
        return quizzes.get(quizName).getQuestions();
    }

    @POST
    @Path("bruker/{quizName}")
    @Produces(MediaType.APPLICATION_JSON) public void addScore(@PathParam("quizName") String quizName, Scores scores){
        quizzes.get(quizName).addScore(scores);
    }
    @PUT
    @Path("update/{quizName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateScore(@PathParam("quizName") String quizName, Scores score){
        quizzes.get(quizName).updateScore(score);
    }
    @GET
    @Path("time/{quizName}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTime(@PathParam("quizName") String quizName){
        return quizzes.get(quizName).getTime();
    }

    @GET
    @Path("tid/{quizName}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTpq(@PathParam("quizName") String quizName){
        return quizzes.get(quizName).getTpq();
    }


}
