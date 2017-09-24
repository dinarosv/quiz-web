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
    public void addQuestion(@PathParam("quizName") String quizName, Question question){
        quizzes.get(quizName).addQuestion(question);
    }

    @GET
    @Path("{quizName}")
    @Produces(MediaType.APPLICATION_JSON) public Collection<Question> getQuestions(@PathParam("quizName") String quizName){
        return quizzes.get(quizName).getQuestions().values();
    }

    @POST
    @Path("{quizName}/{question}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAnswer(@PathParam("quizName") String quizName, @PathParam("question") String question, Answer answer){
        quizzes.get(quizName).getQuestion(question).addAnswer(answer);
    }

    @POST
    @Path("bruker/{quizName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addNick(@PathParam("quizName") String quizName, Nick nick){
        quizzes.get(quizName).addNick(nick);
    }

    @GET
    @Path("bruker/{quizName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Nick> getNicks(@PathParam("quizName") String quizName){
        return quizzes.get(quizName).getNicks().values();
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
