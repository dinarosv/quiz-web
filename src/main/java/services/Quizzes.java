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
    public void addQuiz(Quiz q){
        quizzes.put(q.getQuizName(), q);
    }

    @POST
    @Path("{quizName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addQuestion(@PathParam("quizName") String quizname, Question q){
        quizzes.get(quizname).addQuestion(q);
    }

    @POST
    @Path("{quizName}/{question}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAnswer(@PathParam("quizName") String quizName, @PathParam("question") String question, String answer){
        quizzes.get(quizName).getQuestion(question).addAnswer(answer);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON) public Collection<Quiz> getQuizzes(){
        return quizzes.values();
    }

    @GET
    @Path("{quizName}")
    @Produces(MediaType.TEXT_PLAIN) public String getTime(@PathParam("quizName") String quizName){
        return quizzes.get(quizName).getTime();
    }
    @GET
    @Path("bruker/{quizName}")
    @Produces(MediaType.APPLICATION_JSON) public Collection<Nick> getNicks(@PathParam("quizName") String quizName){
        return quizzes.get(quizName).getNicks().values();
    }
    @POST
    @Path("bruker/{quizName}")
    @Consumes(MediaType.APPLICATION_JSON) public void addNick(@PathParam("quizName") String quizName, String nick){
        quizzes.get(quizName).addNick(nick);
    }
}
