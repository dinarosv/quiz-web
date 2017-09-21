package services;

import java.util.ArrayList;
import java.util.Date;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dina on 14/09/2017.
 */
@Path("/quizzes/")
public class Quizzes {
    private static HashMap<String, Quiz> quizzes = new HashMap<String, Quiz>();
    private static HashMap<String, ScoreBoard> s = new HashMap<String, ScoreBoard>();

    public Quizzes(){}
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addQuiz(Quiz q){
        quizzes.put(q.getQuizName(), q);
    }
    @POST
    @Path("/{quizname}/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addQuestion(@PathParam("quizname") String quizname, Question q){
        quizzes.get(quizname).addQuestion(q);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<String, Quiz> getQuizzes(){
        return quizzes;
    }
}
