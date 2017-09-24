package services;

/**
 * Created by dina on 22/09/2017.
 */
public class Nick {
    private String nick;

    public Nick(){}

    public Nick(String nick){
        this.nick = nick;
    }

    public void setNick(String nick){
        this.nick = nick;
    }
    public String getNick(){
        return nick;
    }
}
