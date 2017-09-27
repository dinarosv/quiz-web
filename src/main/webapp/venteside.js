/**
 * Created by dina on 27/09/2017.
 */
var quizname;
$(document).ready(function() {
    var href = window.document.URL;
    var del = href.split('?')[1];
    var navn = del.split('=')[1];
    quizname = navn.split('&')[0];
    var brukerlinje = del.split('&')[1];
    var bruker = brukerlinje.split('=')[1];
    $.get("rest/quizzes/time/"+quizname, function(data){
        window.setInterval(function(){
            var quizTime = new Date(data);
            var thisTime = new Date();
            var milli =  quizTime.getTime() - thisTime.getTime();
            var timeformat = "--";
            if(milli < 0){
                timeformat = "Quizen er over";
            }else if(milli > 2629746000){
                timeformat = "Over en måned igjen";
            }else if(milli > 86400000){
                timeformat = "Over en dag igjen ";
            }else if(milli > 3600000){
                var sek = (milli / 1000) % 60 ;
                var min = ((milli / (1000*60)) % 60);
                var timer = ((milli / (1000*60*60)) % 24);
                timeformat = timer.toFixed(0) + " timer, " + min.toFixed(0) + " minutter og " + sek.toFixed(0) + " sekunder"
            }else{
                var sek = (milli / 1000) % 60 ;
                var min = ((milli / (1000*60)) % 60);
                if(sek.toFixed(0)==60){
                    sek=0;
                }
                timeformat = min.toFixed(0) + " minutter og "+ sek.toFixed(0) + " sekunder";
            }
            if(milli == 0 || milli < 999){
                kjorQuiz();
            }
            $("#h5").text("Tid til start: " + timeformat);
        }, 1000);
    });
    function kjorQuiz() {
        window.location = "Questions.html?qn=" + quizname + "&br=" + bruker + "&numb=0";
    }
    $.get("rest/quizzes/", function(data) {
        for(var i=0; i<data.length; i++){
            if(data[i].quizName == quizname){
                quiz = data[i];
            }
        }
        var sb = quiz.scoreBoard;
        for(var p in sb){
            if(sb.hasOwnProperty(p)){
                var obj = sb[p];
                if(obj.nick == bruker){
                    $('#myTable').append('<tr><th>'+obj.nick+'</th></tr>');
                }else{
                    $('#myTable').append('<tr><td>'+obj.nick+'</td></tr>');
                }
            }
        }
    });
    $("#goquiz").click(function() {
        kjorQuiz();
    });
});