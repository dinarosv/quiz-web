/**
 * Created by dina on 27/09/2017.
 */
var quiz;
var number;
var nick;
var quizName;
$(document).ready(function() {
    var href = window.document.URL;
    var del = href.split('?')[1];
    var varTab = del.split('&');
    quizName = varTab[0].split('=')[1];
    nick = varTab[1].split('=')[1];
    number = varTab[2].split('=')[1];
    $("#h5").append(quizName + "\"");

    $.get("rest/quizzes/tid/"+quizName, function(data){
        window.setInterval(function(){
            if(data>=10){
                $("#tid").text("Tid igjen: 00:" + data);
            }else if(data>=0){
                $("#tid").text("Tid igjen: 00:0" + data);
            }else{
                next();
            }
            data--;
        }, 1000);
    });
    function next(){
        var nyNumb = Number(number)+1;
        var antall = quiz.questions.length-1;
        if(number == antall){
            window.location = "Scoreboard.html?qn=" + quizName + "&br=" + nick;
        }else{
            window.location = "Questions.html?qn=" + quizName + "&br=" + nick + "&numb=" + nyNumb;
        }

    }

    $.get("rest/quizzes/", function(data){
        for(var i=0; i<data.length; i++){
            if(data[i].quizName == quizName){
                quiz = data[i];
            }
        }
        var question = quiz.questions[number].question;
        var urlen = quiz.questions[number].url;
        $("#bilde").append('<img src="'+urlen+'" class="img-fluid">');

        $("#quest").append(question);
        var antSpors = quiz.questions[number].answers.length;
        for(var i=0; i<antSpors; i++){
            var answer = quiz.questions[number].answers[i];
            $('#myTable tbody').append('<tr><td><button class="btn btn-secondary btn-lg btn-block" onclick="clicked(this)" id="'+i+'">'+answer+'</button></td></tr>');
        }
    });
});

function clicked(el){
    var clickedid = Number(el.id)+1;
    var riktigid = Number(quiz.questions[number].correctanswer);
    var antSvar = quiz.questions[number].answers.length;
    if(clickedid == riktigid){
        givePoint();
        el.classList.remove('btn-secondary');
        el.classList.add('btn-success');

        for(var i=0; i<antSvar;i++){
            document.getElementById(i).disabled = true;
        }
    }else{
        el.classList.remove('btn-secondary');
        el.classList.add('btn-danger');
        document.getElementById(riktigid-1).classList.remove('btn-secondary');
        document.getElementById(riktigid-1).classList.add('btn-outline-success');
        for(var i=0; i<antSvar;i++){
            document.getElementById(i).disabled = true;
        }
    }
}
function givePoint(){
    $.ajax({
        url: 'rest/quizzes/update/'+quizName,
        type: 'PUT',
        data: JSON.stringify({
            nick: nick,
            score: 1
        }),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json'
    });
}