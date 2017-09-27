/**
 * Created by dina on 27/09/2017.
 */
var quizName;
var bruker;
$(document).ready(function(){
    window.setInterval(function(){
        oppdater();
    }, 500);
    var href = window.document.URL;
    var del = href.split('?')[1];
    var varTab = del.split('&');
    quizName = varTab[0].split('=')[1];
    $("h3").append(quizName + "\"");
    if(varTab[1] != null) bruker = varTab[1].split('=')[1];
});
function SortByPoints(a, b){
    var aName = a.score;
    var bName = b.score;
    return ((aName < bName) ? -1 : ((aName > bName) ? 1 : 0));
}
function oppdater(){
    $.get("rest/quizzes/", function(data) {
        for(var i=0; i<data.length; i++){
            if(data[i].quizName == quizName){
                quiz = data[i];
            }
        }
        $("#myTable tbody tr").remove();
        var sb = quiz.scoreBoard;
        var tab = [];


        for(var p in sb){
            if(sb.hasOwnProperty(p)){
                var scores = sb[p];
                var nick = scores.nick;
                var score = scores.score;
                tab.push({nick: nick, score: score});
            }
        }
        tab.sort(SortByPoints);
        var ant = tab.length;
        for(var i=0; i<ant; i++){
            var scores = tab.pop();
            var nick = scores.nick;
            var score = scores.score;
            var plass = i+1;
            if(nick == bruker) {
                $("#myTable").append('<tr class="table-success"><th>'+plass+'</th><th>'+nick+'</th><th>'+score+'</th></tr>');
            }else{
                $("#myTable").append('<tr><td>'+plass+'</td><td>'+nick+'</td><td>'+score+'</td></tr>');
            }

        }
    });

}